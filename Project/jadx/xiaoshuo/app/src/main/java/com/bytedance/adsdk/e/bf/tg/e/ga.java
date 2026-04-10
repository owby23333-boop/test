package com.bytedance.adsdk.e.bf.tg.e;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    private static Object e(int i, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Integer.valueOf(i - number.intValue());
        }
        if (number instanceof Long) {
            return Long.valueOf(((long) i) - number.longValue());
        }
        if (number instanceof Float) {
            return Float.valueOf(i - number.floatValue());
        }
        if (number instanceof Double) {
            return Double.valueOf(((double) i) - number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    private static Object e(long j, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Long.valueOf(j - number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(j - number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(j - number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
        }
        return Long.valueOf(j - ((long) number.intValue()));
    }

    private static Object e(float f, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Float.valueOf(f - number.longValue());
            }
            if (number instanceof Float) {
                return Float.valueOf(f - number.floatValue());
            }
            if (number instanceof Double) {
                return Double.valueOf(((double) f) - number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
        }
        return Float.valueOf(f - number.intValue());
    }

    private static Object e(double d, Number number) {
        if (!(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            if (number instanceof Long) {
                return Double.valueOf(d - number.longValue());
            }
            if (number instanceof Float) {
                return Double.valueOf(d - ((double) number.floatValue()));
            }
            if (number instanceof Double) {
                return Double.valueOf(d - number.doubleValue());
            }
            throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
        }
        return Double.valueOf(d - ((double) number.intValue()));
    }

    public static Object e(Number number, Number number2) {
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
