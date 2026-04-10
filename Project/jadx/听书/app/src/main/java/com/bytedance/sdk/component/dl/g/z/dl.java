package com.bytedance.sdk.component.dl.g.z;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.dl.g.gk;
import com.bytedance.sdk.component.dl.g.hh;
import com.bytedance.sdk.component.dl.g.q;
import com.bytedance.sdk.component.dl.z.gc;
import com.bytedance.sdk.component.dl.z.js;
import com.bytedance.sdk.component.dl.z.m;
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

/* JADX INFO: loaded from: classes2.dex */
public final class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hh f653a;
    public static final gk dl;
    public static final byte[] z;
    public static final String[] g = new String[0];
    private static final m fo = m.g("efbbbf");
    private static final m uy = m.g("feff");
    private static final m kb = m.g("fffe");
    private static final m wp = m.g("0000ffff");
    private static final m i = m.g("ffff0000");
    public static final Charset gc = Charset.forName("UTF-8");
    public static final Charset m = Charset.forName("ISO-8859-1");
    private static final Charset v = Charset.forName("UTF-16BE");
    private static final Charset pf = Charset.forName("UTF-16LE");
    private static final Charset ls = Charset.forName("UTF-32BE");
    private static final Charset p = Charset.forName("UTF-32LE");
    public static final TimeZone e = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> gz = new Comparator<String>() { // from class: com.bytedance.sdk.component.dl.g.z.dl.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final Pattern fv = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static int z(char c) {
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

    static {
        byte[] bArr = new byte[0];
        z = bArr;
        dl = gk.z(null, bArr);
        f653a = hh.z((q) null, bArr);
    }

    public static void z(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean z(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void z(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!z(e2)) {
                    throw e2;
                }
            } catch (RuntimeException unused) {
            } catch (Exception unused2) {
            }
        }
    }

    public static boolean z(js jsVar, int i2, TimeUnit timeUnit) {
        try {
            return g(jsVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean g(js jsVar, int i2, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jO_ = jsVar.z().dl() ? jsVar.z().o_() - jNanoTime : Long.MAX_VALUE;
        jsVar.z().z(Math.min(jO_, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            com.bytedance.sdk.component.dl.z.dl dlVar = new com.bytedance.sdk.component.dl.z.dl();
            while (jsVar.z(dlVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                dlVar.fv();
            }
            if (jO_ == Long.MAX_VALUE) {
                jsVar.z().m();
                return true;
            }
            jsVar.z().z(jNanoTime + jO_);
            return true;
        } catch (InterruptedIOException unused) {
            if (jO_ == Long.MAX_VALUE) {
                jsVar.z().m();
                return false;
            }
            jsVar.z().z(jNanoTime + jO_);
            return false;
        } catch (Throwable th) {
            if (jO_ == Long.MAX_VALUE) {
                jsVar.z().m();
            } else {
                jsVar.z().z(jNanoTime + jO_);
            }
            throw th;
        }
    }

    public static <T> List<T> z(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> z(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory z(final String str, final boolean z2) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.component.dl.g.z.dl.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(runnable, "csj_" + str);
                dlVar.setDaemon(z2);
                dlVar.setPriority(10);
                return dlVar;
            }
        };
    }

    public static String[] z(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean g(Comparator<String> comparator, String[] strArr, String[] strArr2) {
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

    public static String z(com.bytedance.sdk.component.dl.g.js jsVar, boolean z2) {
        String strE;
        if (jsVar.e().contains(":")) {
            strE = "[" + jsVar.e() + "]";
        } else {
            strE = jsVar.e();
        }
        return (z2 || jsVar.gz() != com.bytedance.sdk.component.dl.g.js.z(jsVar.dl())) ? strE + ":" + jsVar.gz() : strE;
    }

    public static boolean z(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int z(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String[] z(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int z(String str, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int g(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static String dl(String str, int i2, int i3) {
        int iZ = z(str, i2, i3);
        return str.substring(iZ, g(str, iZ, i3));
    }

    public static int z(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int z(String str, int i2, int i3, char c) {
        while (i2 < i3) {
            if (str.charAt(i2) == c) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String z(String str) {
        InetAddress inetAddressA;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressA = a(str, 1, str.length() - 1);
            } else {
                inetAddressA = a(str, 0, str.length());
            }
            if (inetAddressA == null) {
                return null;
            }
            byte[] address = inetAddressA.getAddress();
            if (address.length == 16) {
                return z(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (a(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean a(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int g(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean dl(String str) {
        return fv.matcher(str).matches();
    }

    public static String z(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset z(gc gcVar, Charset charset) throws IOException {
        if (gcVar.z(0L, fo)) {
            gcVar.gz(r0.e());
            return gc;
        }
        if (gcVar.z(0L, uy)) {
            gcVar.gz(r0.e());
            return v;
        }
        if (gcVar.z(0L, kb)) {
            gcVar.gz(r0.e());
            return pf;
        }
        if (gcVar.z(0L, wp)) {
            gcVar.gz(r0.e());
            return ls;
        }
        if (!gcVar.z(0L, i)) {
            return charset;
        }
        gcVar.gz(r0.e());
        return p;
    }

    public static AssertionError z(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        if (r4 == 16) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
    
        if (r5 != (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007e, code lost:
    
        r11 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r11, r11);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008e, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress a(java.lang.String r11, int r12, int r13) {
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
            if (r12 >= r13) goto L79
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
            goto L79
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
            boolean r11 = z(r11, r6, r13, r1, r12)
            if (r11 != 0) goto L46
            return r7
        L46:
            int r4 = r4 + 2
            goto L79
        L49:
            return r7
        L4a:
            r6 = r12
        L4b:
            r8 = r2
            r12 = r6
        L4d:
            if (r12 >= r13) goto L5f
            char r9 = r11.charAt(r12)
            int r9 = z(r9)
            if (r9 == r3) goto L5f
            int r8 = r8 << 4
            int r8 = r8 + r9
            int r12 = r12 + 1
            goto L4d
        L5f:
            int r9 = r12 - r6
            if (r9 == 0) goto L78
            r10 = 4
            if (r9 <= r10) goto L67
            goto L78
        L67:
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
        L78:
            return r7
        L79:
            if (r4 == r0) goto L8a
            if (r5 != r3) goto L7e
            return r7
        L7e:
            int r11 = r4 - r5
            int r12 = 16 - r11
            java.lang.System.arraycopy(r1, r5, r1, r12, r11)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8a:
            java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
            return r11
        L8f:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.dl.g.z.dl.a(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean z(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char cCharAt = str.charAt(i6);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    private static String z(byte[] bArr) {
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        com.bytedance.sdk.component.dl.z.dl dlVar = new com.bytedance.sdk.component.dl.z.dl();
        while (i3 < bArr.length) {
            if (i3 == i2) {
                dlVar.fo(58);
                i3 += i5;
                if (i3 == 16) {
                    dlVar.fo(58);
                }
            } else {
                if (i3 > 0) {
                    dlVar.fo(58);
                }
                dlVar.kb(((bArr[i3] & 255) << 8) | (bArr[i3 + 1] & 255));
                i3 += 2;
            }
        }
        return dlVar.pf();
    }
}
