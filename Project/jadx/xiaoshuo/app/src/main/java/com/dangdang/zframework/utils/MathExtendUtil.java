package com.dangdang.zframework.utils;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes10.dex */
public class MathExtendUtil {
    private static final int DEFAULT_DIV_SCALE = 1;

    public static double add(double d, double d2) {
        return new BigDecimal(Double.toString(d)).add(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static double divide(double d, double d2) {
        return divide(d, d2, 1);
    }

    public static double multiply(double d, double d2) {
        return new BigDecimal(Double.toString(d)).multiply(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static double round(double d, int i) {
        return round(d, i, 6);
    }

    public static double subtract(double d, double d2) {
        return new BigDecimal(Double.toString(d)).subtract(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static double divide(double d, double d2, int i) {
        return divide(d, d2, i, 6);
    }

    public static double round(double d, int i, int i2) {
        if (i >= 0) {
            return new BigDecimal(Double.toString(d)).setScale(i, i2).doubleValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static double divide(double d, double d2, int i, int i2) {
        if (i >= 0) {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, i2).doubleValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static String add(String str, String str2) {
        return new BigDecimal(str).add(new BigDecimal(str2)).toString();
    }

    public static String multiply(String str, String str2) {
        return new BigDecimal(str).multiply(new BigDecimal(str2)).toString();
    }

    public static String subtract(String str, String str2) {
        return new BigDecimal(str).subtract(new BigDecimal(str2)).toString();
    }

    public static String round(String str, int i) {
        return round(str, i, 6);
    }

    public static String round(String str, int i, int i2) {
        if (i >= 0) {
            return new BigDecimal(str).setScale(i, i2).toString();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static String divide(String str, String str2) {
        return divide(str, str2, 1);
    }

    public static String divide(String str, String str2, int i) {
        return divide(str, str2, 1, 6);
    }

    public static String divide(String str, String str2, int i, int i2) {
        if (i >= 0) {
            return new BigDecimal(str).divide(new BigDecimal(str2), i, i2).toString();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
