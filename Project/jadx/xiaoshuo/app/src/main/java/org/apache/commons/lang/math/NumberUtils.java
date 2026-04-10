package org.apache.commons.lang.math;

import com.yuewen.w51;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = new Long(0);
    public static final Long LONG_ONE = new Long(1);
    public static final Long LONG_MINUS_ONE = new Long(-1);
    public static final Integer INTEGER_ZERO = new Integer(0);
    public static final Integer INTEGER_ONE = new Integer(1);
    public static final Integer INTEGER_MINUS_ONE = new Integer(-1);
    public static final Short SHORT_ZERO = new Short((short) 0);
    public static final Short SHORT_ONE = new Short((short) 1);
    public static final Short SHORT_MINUS_ONE = new Short((short) -1);
    public static final Byte BYTE_ZERO = new Byte((byte) 0);
    public static final Byte BYTE_ONE = new Byte((byte) 1);
    public static final Byte BYTE_MINUS_ONE = new Byte((byte) -1);
    public static final Double DOUBLE_ZERO = new Double(w51.l);
    public static final Double DOUBLE_ONE = new Double(1.0d);
    public static final Double DOUBLE_MINUS_ONE = new Double(-1.0d);
    public static final Float FLOAT_ZERO = new Float(0.0f);
    public static final Float FLOAT_ONE = new Float(1.0f);
    public static final Float FLOAT_MINUS_ONE = new Float(-1.0f);

    public static int compare(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        long jDoubleToLongBits2 = Double.doubleToLongBits(d2);
        if (jDoubleToLongBits == jDoubleToLongBits2) {
            return 0;
        }
        return jDoubleToLongBits < jDoubleToLongBits2 ? -1 : 1;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return new BigDecimal(str);
    }

    public static BigInteger createBigInteger(String str) {
        if (str == null) {
            return null;
        }
        return new BigInteger(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.valueOf(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ea, code lost:
    
        if (r1 == 'l') goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:138:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0131 A[Catch: NumberFormatException -> 0x013c, TRY_LEAVE, TryCatch #7 {NumberFormatException -> 0x013c, blocks: (B:73:0x0127, B:75:0x0131), top: B:147:0x0127 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0146 A[Catch: NumberFormatException -> 0x0152, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x0152, blocks: (B:80:0x013c, B:82:0x0146), top: B:138:0x013c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Number createNumber(java.lang.String r14) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.math.NumberUtils.createNumber(java.lang.String):java.lang.Number");
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return str.length() > 0;
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0067, code lost:
    
        if (r3 >= r0.length) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        r0 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006b, code lost:
    
        if (r0 < '0') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006d, code lost:
    
        if (r0 > '9') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006f, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0070, code lost:
    
        if (r0 == 'e') goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0072, code lost:
    
        if (r0 != 'E') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0075, code lost:
    
        if (r0 != '.') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0077, code lost:
    
        if (r13 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0079, code lost:
    
        if (r12 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x007c, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007d, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007e, code lost:
    
        if (r6 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0082, code lost:
    
        if (r0 == 'd') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0086, code lost:
    
        if (r0 == 'D') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0088, code lost:
    
        if (r0 == 'f') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x008c, code lost:
    
        if (r0 != 'F') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x008e, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0091, code lost:
    
        if (r0 == 'l') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0095, code lost:
    
        if (r0 != 'L') goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0098, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0099, code lost:
    
        if (r11 == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x009b, code lost:
    
        if (r12 != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x009e, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x009f, code lost:
    
        if (r6 != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00a1, code lost:
    
        if (r11 == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00a4, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00bb, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isNumber(java.lang.String r16) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.math.NumberUtils.isNumber(java.lang.String):boolean");
    }

    public static byte max(byte b2, byte b3, byte b4) {
        if (b3 > b2) {
            b2 = b3;
        }
        return b4 > b2 ? b4 : b2;
    }

    public static byte min(byte b2, byte b3, byte b4) {
        if (b3 < b2) {
            b2 = b3;
        }
        return b4 < b2 ? b4 : b2;
    }

    public static int stringToInt(String str) {
        return toInt(str);
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, w51.l);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static int stringToInt(String str, int i) {
        return toInt(str, i);
    }

    public static byte toByte(String str, byte b2) {
        if (str == null) {
            return b2;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b2;
        }
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static int compare(float f, float f2) {
        if (f < f2) {
            return -1;
        }
        if (f > f2) {
            return 1;
        }
        int iFloatToIntBits = Float.floatToIntBits(f);
        int iFloatToIntBits2 = Float.floatToIntBits(f2);
        if (iFloatToIntBits == iFloatToIntBits2) {
            return 0;
        }
        return iFloatToIntBits < iFloatToIntBits2 ? -1 : 1;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static long max(long[] jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                long j = jArr[0];
                for (int i = 1; i < jArr.length; i++) {
                    long j2 = jArr[i];
                    if (j2 > j) {
                        j = j2;
                    }
                }
                return j;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static long min(long[] jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                long j = jArr[0];
                for (int i = 1; i < jArr.length; i++) {
                    long j2 = jArr[i];
                    if (j2 < j) {
                        j = j2;
                    }
                }
                return j;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static int max(int[] iArr) {
        if (iArr != null) {
            if (iArr.length != 0) {
                int i = iArr[0];
                for (int i2 = 1; i2 < iArr.length; i2++) {
                    int i3 = iArr[i2];
                    if (i3 > i) {
                        i = i3;
                    }
                }
                return i;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static int min(int[] iArr) {
        if (iArr != null) {
            if (iArr.length != 0) {
                int i = iArr[0];
                for (int i2 = 1; i2 < iArr.length; i2++) {
                    int i3 = iArr[i2];
                    if (i3 < i) {
                        i = i3;
                    }
                }
                return i;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static short max(short[] sArr) {
        if (sArr != null) {
            if (sArr.length != 0) {
                short s = sArr[0];
                for (int i = 1; i < sArr.length; i++) {
                    short s2 = sArr[i];
                    if (s2 > s) {
                        s = s2;
                    }
                }
                return s;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static short min(short[] sArr) {
        if (sArr != null) {
            if (sArr.length != 0) {
                short s = sArr[0];
                for (int i = 1; i < sArr.length; i++) {
                    short s2 = sArr[i];
                    if (s2 < s) {
                        s = s2;
                    }
                }
                return s;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static byte max(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                byte b2 = bArr[0];
                for (int i = 1; i < bArr.length; i++) {
                    byte b3 = bArr[i];
                    if (b3 > b2) {
                        b2 = b3;
                    }
                }
                return b2;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static byte min(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                byte b2 = bArr[0];
                for (int i = 1; i < bArr.length; i++) {
                    byte b3 = bArr[i];
                    if (b3 < b2) {
                        b2 = b3;
                    }
                }
                return b2;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double max(double[] dArr) {
        if (dArr != null) {
            if (dArr.length != 0) {
                double d = dArr[0];
                for (int i = 1; i < dArr.length; i++) {
                    if (Double.isNaN(dArr[i])) {
                        return Double.NaN;
                    }
                    double d2 = dArr[i];
                    if (d2 > d) {
                        d = d2;
                    }
                }
                return d;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double min(double[] dArr) {
        if (dArr != null) {
            if (dArr.length != 0) {
                double d = dArr[0];
                for (int i = 1; i < dArr.length; i++) {
                    if (Double.isNaN(dArr[i])) {
                        return Double.NaN;
                    }
                    double d2 = dArr[i];
                    if (d2 < d) {
                        d = d2;
                    }
                }
                return d;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float max(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                float f = fArr[0];
                for (int i = 1; i < fArr.length; i++) {
                    if (Float.isNaN(fArr[i])) {
                        return Float.NaN;
                    }
                    float f2 = fArr[i];
                    if (f2 > f) {
                        f = f2;
                    }
                }
                return f;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float min(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                float f = fArr[0];
                for (int i = 1; i < fArr.length; i++) {
                    if (Float.isNaN(fArr[i])) {
                        return Float.NaN;
                    }
                    float f2 = fArr[i];
                    if (f2 < f) {
                        f = f2;
                    }
                }
                return f;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }
}
