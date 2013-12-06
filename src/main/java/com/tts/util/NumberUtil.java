package com.tts.util;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.math.NumberUtils;

public class NumberUtil extends NumberUtils
{
  protected static char[] randomSymbol = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
  protected static char[] randomNumbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
  private static SecureRandom srandom = new SecureRandom();
  private static AtomicInteger counter = new AtomicInteger(0);
  protected static Random random = new Random();

  public static boolean isNumeric(String val)
  {
    return isNumber(val);
  }

  public static boolean isNotEmpty(Integer val) {
    if ((val != null) && (val.intValue() != 0))
      return true;
    return false;
  }

  public static int ceil(double val)
  {
    return (int)Math.ceil(val);
  }

  public static String randomString(int length)
  {
    StringBuffer tmpString = new StringBuffer();
    for (int i = 0; i < length; i++)
      tmpString.append(randomSymbol[random.nextInt(randomSymbol.length)]);
    return tmpString.toString();
  }

  public static String randomNumbers(int length)
  {
    return Math.abs(srandom.nextLong()) + "";
  }

  public static String randomNums(int length) {
    if (counter.get() > 999999) counter.set(1);
    long time = System.currentTimeMillis();
    String returnValue = time * length + counter.incrementAndGet() + "";
    return returnValue;
  }
}
