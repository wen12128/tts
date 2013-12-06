package com.tts.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Map;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.multipart.PartBase;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils
{
  private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
  private static final boolean DEBUG = logger.isDebugEnabled();
  private static final int OK = 200;
  private static final int NOT_MODIFIED = 304;
  private static final int BAD_REQUEST = 400;
  private static final int NOT_AUTHORIZED = 401;
  private static final int FORBIDDEN = 403;
  private static final int NOT_FOUND = 404;
  private static final int NOT_ACCEPTABLE = 406;
  private static final int INTERNAL_SERVER_ERROR = 500;
  private static final int BAD_GATEWAY = 502;
  private static final int SERVICE_UNAVAILABLE = 503;
  private HttpClient client = null;
  private String token;
  private MultiThreadedHttpConnectionManager connectionManager;
  private int maxSize;
  protected static Map<String, String> sessionMemory = new Hashtable<String, String>();

  public HttpUtils()
  {
    this(150, 30000, 30000, 1048576);
  }

  public HttpUtils(int maxConPerHost, int conTimeOutMs, int soTimeOutMs, int maxSize) {
    this.connectionManager = new MultiThreadedHttpConnectionManager();
    HttpConnectionManagerParams params = this.connectionManager.getParams();
    params.setDefaultMaxConnectionsPerHost(maxConPerHost);
    params.setConnectionTimeout(conTimeOutMs);
    params.setSoTimeout(soTimeOutMs);

    HttpClientParams clientParams = new HttpClientParams();

    clientParams.setCookiePolicy("ignoreCookies");
    this.client = new HttpClient(clientParams, this.connectionManager);
    Protocol myhttps = new Protocol("https", new SSLSocketFactory(), 443);
    Protocol.registerProtocol("https", myhttps);
    this.maxSize = maxSize;
  }

  private static void log(String message)
  {
    if (DEBUG)
      logger.debug(message);
  }

  private static String getCause(int statusCode)
  {
    String cause = null;
    switch (statusCode) {
    case 304:
      break;
    case 400:
      cause = "The request was invalid.  An accompanying error message will explain why. This is the status code will be returned during rate limiting.";
      break;
    case 401:
      cause = "Authentication credentials were missing or incorrect.";
      break;
    case 403:
      cause = "The request is understood, but it has been refused.  An accompanying error message will explain why.";
      break;
    case 404:
      cause = "The URI requested is invalid or the resource requested, such as a user, does not exists.";
      break;
    case 406:
      cause = "Returned by the Search API when an invalid format is specified in the request.";
      break;
    case 500:
      cause = "Something is broken.  Please post to the group so the Weibo team can investigate.";
      break;
    case 502:
      cause = "Weibo is down or being upgraded.";
      break;
    case 503:
      cause = "Service Unavailable: The Weibo servers are up, but overloaded with requests. Try again later. The search and trend methods use this to indicate when you are being rate limited.";
      break;
    default:
      cause = "";
    }
    return statusCode + ":" + cause;
  }

  public String getToken() {
    return this.token;
  }

  public static String httpSessionID(HttpURLConnection con)
  {
    return sessionMemory.get(con.getURL().getHost());
  }

  public static String httpGet(String url) {
    HttpClient httpclient = new HttpClient();
    GetMethod httpget = new GetMethod(url);
    try {
      httpclient.executeMethod(httpget);
      return httpget.getResponseBodyAsString();
    } catch (IOException io) {
      logger.error(io.getMessage());
    } finally {
      httpget.releaseConnection();
    }
    return "";
  }

  public static HttpURLConnection getPostHttpConnection(String url) {
    try {
      URL tmpUrl = new URL(url);
      HttpURLConnection connection = (HttpURLConnection)tmpUrl.openConnection();
      connection.setDoInput(true);
      connection.setDoOutput(true);
      connection.setRequestMethod("POST");
      HttpURLConnection.setFollowRedirects(true);
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.setUseCaches(false);

      connection.setConnectTimeout(15000);
      connection.setReadTimeout(12000);
      return connection; } catch (Exception e) {
    }
    return null;
  }

  public static String httpPost(String url, String parameter, boolean session, String streamCharsetName)
  {
    HttpURLConnection httpConnection = getPostHttpConnection(url);
    if (httpConnection == null)
      return null;
    return httpPost(httpConnection, parameter, session, streamCharsetName);
  }

  public static String httpPost(HttpURLConnection con, String parameter, boolean session, String streamCharsetName) {
    String tmpHost = con.getURL().getHost();
    if (session) {
      String sessionID = sessionMemory.get(tmpHost);
      if (sessionID != null)
        con.setRequestProperty("Cookie", sessionID);
    }
    StringBuffer tmpContent = new StringBuffer();
    try {
      if ((parameter != null) &&
        (parameter.length() > 0)) {
        con.setDoOutput(true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
        bw.write(parameter);
        bw.flush();
        bw.close();
      }
      if (con.getResponseCode() != 200) {
        logger.error("<http> http fail! responseCode = " + con.getResponseCode() + ", url=" + con.getURL());
        return null;
      }
      if (session) {
        String cookei = con.getHeaderField("Set-Cookie");
        if (cookei != null) {
          String cookeiLc = cookei.toLowerCase();
          if (cookeiLc.indexOf("sessionid") != -1) {
            int il1 = cookeiLc.indexOf("sessionid");
            int il2 = cookeiLc.lastIndexOf(";", il1);
            int il3 = cookeiLc.indexOf(";", il1);
            if (il3 == -1)
              il3 = cookeiLc.length();
            String sessionID = cookei.substring(il2 + 1, il3).trim();
            sessionMemory.put(tmpHost, sessionID);
          }
        }
      }
      BufferedReader br;
      if (streamCharsetName == null)
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      else
        br = new BufferedReader(new InputStreamReader(con.getInputStream(), streamCharsetName));
      String tmpText = br.readLine();
      while (tmpText != null) {
        tmpContent.append(tmpText);
        tmpContent.append("\n");
        tmpText = br.readLine();
      }
      br.close();
      con.disconnect();
    } catch (Exception e) {
      logger.error("<http>  ANTE ERROR:! url=" + con.getURL(), e);
      return null;
    }
    return tmpContent.toString();
  }

  public static String getLocalIp() {
    try {
      InetAddress i = InetAddress.getLocalHost();
      return i.getHostAddress(); } catch (UnknownHostException e) {
    }
    return null;
  }
}
