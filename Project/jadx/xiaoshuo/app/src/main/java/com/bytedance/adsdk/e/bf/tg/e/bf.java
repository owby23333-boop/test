package com.bytedance.adsdk.e.bf.tg.e;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static boolean e(int i, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return i == number.intValue();
        }
        if (number instanceof Long) {
            return ((long) i) == number.longValue();
        }
        if (number instanceof Float) {
            return ((float) i) == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) i) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    private static boolean e(long j, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return j == ((long) number.intValue());
        }
        if (number instanceof Long) {
            return j == number.longValue();
        }
        if (number instanceof Float) {
            return ((float) j) == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) j) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    private static boolean e(float f, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return f == ((float) number.intValue());
        }
        if (number instanceof Long) {
            return f == ((float) number.longValue());
        }
        if (number instanceof Float) {
            return f == number.floatValue();
        }
        if (number instanceof Double) {
            return ((double) f) == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    private static boolean e(double d, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return d == ((double) number.intValue());
        }
        if (number instanceof Long) {
            return d == ((double) number.longValue());
        }
        if (number instanceof Float) {
            return d == ((double) number.floatValue());
        }
        if (number instanceof Double) {
            return d == number.doubleValue();
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    public static boolean e(Number number, Number number2) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return e(number.longValue(), number2);
            }
            if (number instanceof Float) {
                return e(number.floatValue(), number2);
            }
            if (number instanceof Double) {
                return e(number.doubleValue(), number2);
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
        }
        return e(number.intValue(), number2);
    }
}
