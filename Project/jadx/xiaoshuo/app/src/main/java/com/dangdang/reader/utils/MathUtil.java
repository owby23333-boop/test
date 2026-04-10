package com.dangdang.reader.utils;

import android.graphics.Point;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes10.dex */
public class MathUtil {
    public static double add(Double d, Double d2) {
        return new BigDecimal(String.valueOf(d)).add(new BigDecimal(String.valueOf(d2))).doubleValue();
    }

    public static int getDistance(Point point, Point point2) {
        int iAbs = Math.abs(point.x - point2.x);
        int iAbs2 = Math.abs(point.y - point2.y);
        return (int) Math.sqrt((iAbs * iAbs) + (iAbs2 * iAbs2));
    }

    public static double minus(Double d, Double d2) {
        return new BigDecimal(String.valueOf(d)).subtract(new BigDecimal(String.valueOf(d2))).doubleValue();
    }

    public static float multiply(float f, float f2) {
        return new BigDecimal(String.valueOf(f)).multiply(new BigDecimal(String.valueOf(f2))).floatValue();
    }
}
