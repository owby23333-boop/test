package com.bytedance.sdk.component.d.bf.e;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.d.bf.a;
import com.bytedance.sdk.component.d.bf.fy;
import com.bytedance.sdk.component.d.bf.pe;
import com.bytedance.sdk.component.d.e.ga;
import com.bytedance.sdk.component.d.e.k;
import com.bytedance.sdk.component.d.e.vn;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final fy d;
    public static final byte[] e;
    public static final a tg;
    public static final String[] bf = new String[0];
    private static final vn zk = vn.bf("efbbbf");
    private static final vn m = vn.bf("feff");
    private static final vn wu = vn.bf("fffe");
    private static final vn xu = vn.bf("0000ffff");
    private static final vn bh = vn.bf("ffff0000");
    public static final Charset ga = Charset.forName("UTF-8");
    public static final Charset vn = Charset.forName("ISO-8859-1");
    private static final Charset t = Charset.forName("UTF-16BE");
    private static final Charset s = Charset.forName("UTF-16LE");
    private static final Charset w = Charset.forName("UTF-32BE");
    private static final Charset l = Charset.forName("UTF-32LE");
    public static final TimeZone p = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> v = new Comparator<String>() { // from class: com.bytedance.sdk.component.d.bf.e.d.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final Pattern f = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = new byte[0];
        e = bArr;
        d = fy.e(null, bArr);
        tg = a.e((pe) null, bArr);
    }

    public static boolean bf(k kVar, int i, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jC_ = kVar.e().d() ? kVar.e().c_() - jNanoTime : Long.MAX_VALUE;
        kVar.e().e(Math.min(jC_, timeUnit.toNanos(i)) + jNanoTime);
        try {
            com.bytedance.sdk.component.d.e.d dVar = new com.bytedance.sdk.component.d.e.d();
            while (kVar.e(dVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                dVar.f();
            }
            if (jC_ == Long.MAX_VALUE) {
                kVar.e().vn();
                return true;
            }
            kVar.e().e(jNanoTime + jC_);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC_ == Long.MAX_VALUE) {
                kVar.e().vn();
                return false;
            }
            kVar.e().e(jNanoTime + jC_);
            return false;
        } catch (Throwable th) {
            if (jC_ == Long.MAX_VALUE) {
                kVar.e().vn();
            } else {
                kVar.e().e(jNanoTime + jC_);
            }
            throw th;
        }
    }

    public static String d(String str, int i, int i2) {
        int iE = e(str, i, i2);
        return str.substring(iE, bf(str, iE, i2));
    }

    public static int e(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    private static boolean tg(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static void e(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean e(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean d(String str) {
        return f.matcher(str).matches();
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x007a, code lost:
    
        if (r4 == 16) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007c, code lost:
    
        if (r5 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
    
        r11 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r11, r11);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008f, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress tg(java.lang.String r11, int r12, int r13) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        L9:
            r7 = 0
            if (r12 >= r13) goto L7a
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r12 + 2
            if (r8 > r13) goto L27
            java.lang.String r9 = "::"
            r10 = 2
            boolean r9 = r11.regionMatches(r12, r9, r2, r10)
            if (r9 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r13) goto L25
            goto L7a
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L4a
            java.lang.String r8 = ":"
            r9 = 1
            boolean r8 = r11.regionMatches(r12, r8, r2, r9)
            if (r8 == 0) goto L35
            int r12 = r12 + 1
            goto L4a
        L35:
            java.lang.String r8 = "."
            boolean r12 = r11.regionMatches(r12, r8, r2, r9)
            if (r12 == 0) goto L49
            int r12 = r4 + (-2)
            boolean r11 = e(r11, r6, r13, r1, r12)
            if (r11 != 0) goto L46
            return r7
        L46:
            int r4 = r4 + 2
            goto L7a
        L49:
            return r7
        L4a:
            r6 = r12
        L4b:
            r8 = r2
            r12 = r6
        L4d:
            if (r12 >= r13) goto L60
            char r9 = r11.charAt(r12)
            int r9 = e(r9)
            if (r9 != r3) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r9
            int r12 = r12 + 1
            goto L4d
        L60:
            int r9 = r12 - r6
            if (r9 == 0) goto L79
            r10 = 4
            if (r9 <= r10) goto L68
            goto L79
        L68:
            int r7 = r4 + 1
            int r9 = r8 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r7 + 1
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L79:
            return r7
        L7a:
            if (r4 == r0) goto L8b
            if (r5 != r3) goto L7f
            return r7
        L7f:
            int r11 = r4 - r5
            int r12 = 16 - r11
            java.lang.System.arraycopy(r1, r5, r1, r12, r11)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8b:
            java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
            return r11
        L90:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.bf.e.d.tg(java.lang.String, int, int):java.net.InetAddress");
    }

    public static void e(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!e(e2)) {
                    throw e2;
                }
            } catch (RuntimeException | Exception unused) {
            }
        }
    }

    public static boolean e(k kVar, int i, TimeUnit timeUnit) {
        try {
            return bf(kVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> e(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> e(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory e(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.component.d.bf.e.d.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "csj_" + str);
                thread.setDaemon(z);
                thread.setPriority(10);
                return thread;
            }
        };
    }

    public static String[] e(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean bf(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int bf(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String e(com.bytedance.sdk.component.d.bf.k kVar, boolean z) {
        String strP;
        if (kVar.p().contains(":")) {
            strP = "[" + kVar.p() + "]";
        } else {
            strP = kVar.p();
        }
        if (!z && kVar.v() == com.bytedance.sdk.component.d.bf.k.e(kVar.d())) {
            return strP;
        }
        return strP + ":" + kVar.v();
    }

    public static int bf(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static boolean e(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int e(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] e(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int e(String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int e(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int e(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String e(String str) {
        InetAddress inetAddressTg;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressTg = tg(str, 1, str.length() - 1);
            } else {
                inetAddressTg = tg(str, 0, str.length());
            }
            if (inetAddressTg == null) {
                return null;
            }
            byte[] address = inetAddressTg.getAddress();
            if (address.length == 16) {
                return e(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (tg(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String e(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset e(ga gaVar, Charset charset) throws IOException {
        if (gaVar.e(0L, zk)) {
            gaVar.v(r0.p());
            return ga;
        }
        if (gaVar.e(0L, m)) {
            gaVar.v(r0.p());
            return t;
        }
        if (gaVar.e(0L, wu)) {
            gaVar.v(r0.p());
            return s;
        }
        if (gaVar.e(0L, xu)) {
            gaVar.v(r0.p());
            return w;
        }
        if (!gaVar.e(0L, bh)) {
            return charset;
        }
        gaVar.v(r0.p());
        return l;
    }

    public static int e(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }
        throw new NullPointerException("unit == null");
    }

    public static AssertionError e(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    private static boolean e(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    private static String e(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        com.bytedance.sdk.component.d.e.d dVar = new com.bytedance.sdk.component.d.e.d();
        while (i2 < bArr.length) {
            if (i2 == i) {
                dVar.zk(58);
                i2 += i4;
                if (i2 == 16) {
                    dVar.zk(58);
                }
            } else {
                if (i2 > 0) {
                    dVar.zk(58);
                }
                dVar.wu(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return dVar.s();
    }
}
