package com.tts.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil
{
  private static final String EMAIL_REGEX = "^([a-z0-9]+[-|\\.]?)+[a-z0-9]@([a-z0-9]+(-[a-z0-9]+)?\\.)+[a-z]{2,}$";
  public static final String MOBILE_REGEX = "^1(3|5|8){1}[0-9]{1}[0-9]{8}$";

  public static boolean validate(String valContent, String regex)
  {
    Pattern pattern = Pattern.compile(regex, 2);
    Matcher matcher = pattern.matcher(valContent);
    return matcher.matches();
  }

  public static boolean validateType(String content, String regex) {
    Pattern pattern = Pattern.compile(regex, 42);
    Matcher matcher = pattern.matcher(content);
    return matcher.find();
  }

  public static String match(String content, String regex, int groupId) {
    Pattern pattern = Pattern.compile(regex, 42);

    if (groupId == 0) return "";

    Matcher matcher = pattern.matcher(content);
    StringBuffer buffer = new StringBuffer();
    while (matcher.find())
      buffer.append(matcher.group(groupId));
    return buffer.toString();
  }

  public static Map<String, String> matchError(String content, String regex, int code, int msg) {
    Pattern pattern = Pattern.compile(regex, 42);

    if ((code == 0) || (msg == 0)) return null;

    Matcher matcher = pattern.matcher(content);
    if (matcher.find()) {
      Map<String,String> errors = new HashMap<String,String>();
      errors.put("code", matcher.group(code));
      errors.put("msg", matcher.group(msg));
      return errors;
    }
    return null;
  }

  public static String matchToken(String content, String regex, int groupId) {
    Pattern pattern = Pattern.compile(regex, 42);

    if (groupId == 0) return "";

    Matcher matcher = pattern.matcher(content);
    if (matcher.find()) {
      return matcher.group(groupId);
    }
    return "";
  }

  public static String matchUrls(String content, String regex, int groupId) {
    Pattern pattern = Pattern.compile(regex, 34);

    Matcher matcher = pattern.matcher(content);
    StringBuffer buffer = new StringBuffer();
    while (matcher.find())
      buffer.append(matcher.group(groupId)).append("$");
    return buffer.toString();
  }

  public static List<String> matchList(String content, String regex, int groupId) {
    Pattern pattern = Pattern.compile(regex, 2);

      List<String> list = new ArrayList<String>();
    Matcher matcher = pattern.matcher(content);
    while (matcher.find()) {
      list.add(matcher.group(groupId));
    }
    return list;
  }

  public static boolean valEmail(String email)
  {
    return validate(email, "^([a-z0-9]+[-|\\.]?)+[a-z0-9]@([a-z0-9]+(-[a-z0-9]+)?\\.)+[a-z]{2,}$");
  }

  public static boolean valPhone(String phone)
  {
    return validate(phone, "^1(3|5|8){1}[0-9]{1}[0-9]{8}$");
  }

  public static String clearHtml(String html) {
    String regEx = "<.+?>";

    Pattern p = Pattern.compile(regEx);
    Matcher m = p.matcher(html);
    String s = m.replaceAll("");

    return s;
  }
}
