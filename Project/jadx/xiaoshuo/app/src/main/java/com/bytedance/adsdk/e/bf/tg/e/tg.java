package com.bytedance.adsdk.e.bf.tg.e;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private static Object e(int i, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(i < number.intValue());
        }
        if (number instanceof Long) {
            return Boolean.valueOf(((long) i) < number.longValue());
        }
        if (number instanceof Float) {
            return Boolean.valueOf(((float) i) < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) i) < number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    private static Object e(long j, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(j < ((long) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(j < number.longValue());
        }
        if (number instanceof Float) {
            return Boolean.valueOf(((float) j) < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) j) < number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    private static Object e(float f, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(f < ((float) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(f < ((float) number.longValue()));
        }
        if (number instanceof Float) {
            return Boolean.valueOf(f < number.floatValue());
        }
        if (number instanceof Double) {
            return Boolean.valueOf(((double) f) < number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    private static Object e(double d, Number number) {
        if ((number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return Boolean.valueOf(d < ((double) number.intValue()));
        }
        if (number instanceof Long) {
            return Boolean.valueOf(d < ((double) number.longValue()));
        }
        if (number instanceof Float) {
            return Boolean.valueOf(d < ((double) number.floatValue()));
        }
        if (number instanceof Double) {
            return Boolean.valueOf(d < number.doubleValue());
        }
        throw new UnsupportedOperationException(number.getClass().getName() + "不支持该类型的加操作");
    }

    public static Object e(Object obj, Number number) {
        if (!(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
            if (obj instanceof Long) {
                return e(((Long) obj).longValue(), number);
            }
            if (obj instanceof Float) {
                return e(((Float) obj).floatValue(), number);
            }
            if (obj instanceof Double) {
                return e(((Double) obj).doubleValue(), number);
            }
            if (obj instanceof String) {
                try {
                    return e(Float.parseFloat((String) obj), number);
                } catch (NumberFormatException unused) {
                    throw new UnsupportedOperationException(obj.getClass().getName() + "不支持该类型的加操作");
                }
            }
            throw new UnsupportedOperationException(obj.getClass().getName() + "不支持该类型的加操作");
        }
        return e(((Number) obj).intValue(), number);
    }
}
