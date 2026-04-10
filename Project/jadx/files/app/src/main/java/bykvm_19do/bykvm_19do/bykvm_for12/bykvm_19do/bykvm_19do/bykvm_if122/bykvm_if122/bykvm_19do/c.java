package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

import android.support.v4.media.session.PlaybackStateCompat;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.u;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.umeng.message.proguard.k;
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
public final class c {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f1143c = b0.a(null, a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f f1144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f1145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f f1146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final f f1147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final f f1148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Charset f1149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Charset f1150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Charset f1151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Charset f1152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Charset f1153m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final TimeZone f1154n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Comparator<String> f1155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Pattern f1156p;

    static final class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    static final class b implements ThreadFactory {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        b(String str, boolean z2) {
            this.a = str;
            this.b = z2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, ThreadHelper.THREDA_NAME_PREFIX + this.a);
            thread.setDaemon(this.b);
            thread.setPriority(10);
            return thread;
        }
    }

    static {
        z.a((u) null, a);
        f1144d = f.a("efbbbf");
        f1145e = f.a("feff");
        f1146f = f.a("fffe");
        f1147g = f.a("0000ffff");
        f1148h = f.a("ffff0000");
        f1149i = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        f1150j = Charset.forName(k.f20481d);
        f1151k = Charset.forName(k.f20482e);
        f1152l = Charset.forName("UTF-32BE");
        f1153m = Charset.forName("UTF-32LE");
        f1154n = TimeZone.getTimeZone("GMT");
        f1155o = new a();
        f1156p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j2);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j2 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static AssertionError a(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    public static String a(s sVar, boolean z2) {
        String strG;
        if (sVar.g().contains(":")) {
            strG = "[" + sVar.g() + "]";
        } else {
            strG = sVar.g();
        }
        if (!z2 && sVar.j() == s.c(sVar.m())) {
            return strG;
        }
        return strG + ":" + sVar.j();
    }

    public static String a(String str) {
        if (str.contains(":")) {
            InetAddress inetAddressA = (str.startsWith("[") && str.endsWith("]")) ? a(str, 1, str.length() - 1) : a(str, 0, str.length());
            if (inetAddressA != null) {
                byte[] address = inetAddressA.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + "'");
            }
        } else {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (!lowerCase.isEmpty()) {
                    if (!b(lowerCase)) {
                        return lowerCase;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private static String a(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (i3 < bArr.length) {
            int i6 = i3;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i3;
            if (i7 > i4 && i7 >= 4) {
                i5 = i3;
                i4 = i7;
            }
            i3 = i6 + 2;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        while (i2 < bArr.length) {
            if (i2 == i5) {
                cVar.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    cVar.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    cVar.writeByte(58);
                }
                cVar.e(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return cVar.n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
    
        if (r3 == r0.length) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
    
        if (r4 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0083, code lost:
    
        r12 = r3 - r4;
        java.lang.System.arraycopy(r0, r4, r0, r0.length - r12, r12);
        java.util.Arrays.fill(r0, r4, (r0.length - r3) + r4, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        return java.net.InetAddress.getByAddress(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009b, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress a(java.lang.String r11, int r12, int r13) {
        /*
            r0 = 16
            byte[] r0 = new byte[r0]
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = -1
            r5 = -1
        L9:
            r6 = 0
            if (r12 >= r13) goto L7d
            int r7 = r0.length
            if (r3 != r7) goto L11
            goto L94
        L11:
            int r7 = r12 + 2
            r8 = 1
            if (r7 > r13) goto L2b
            r9 = 2
            java.lang.String r10 = "::"
            boolean r9 = r11.regionMatches(r12, r10, r2, r9)
            if (r9 == 0) goto L2b
            if (r4 == r1) goto L23
            goto L94
        L23:
            int r3 = r3 + 2
            r4 = r3
            if (r7 != r13) goto L29
            goto L7d
        L29:
            r5 = r7
            goto L4d
        L2b:
            if (r3 == 0) goto L4c
            java.lang.String r7 = ":"
            boolean r7 = r11.regionMatches(r12, r7, r2, r8)
            if (r7 == 0) goto L38
            int r12 = r12 + 1
            goto L4c
        L38:
            java.lang.String r7 = "."
            boolean r12 = r11.regionMatches(r12, r7, r2, r8)
            if (r12 == 0) goto L94
            int r12 = r3 + (-2)
            boolean r11 = a(r11, r5, r13, r0, r12)
            if (r11 != 0) goto L49
            goto L94
        L49:
            int r3 = r3 + 2
            goto L7d
        L4c:
            r5 = r12
        L4d:
            r12 = r5
            r7 = 0
        L4f:
            if (r12 >= r13) goto L62
            char r9 = r11.charAt(r12)
            int r9 = a(r9)
            if (r9 != r1) goto L5c
            goto L62
        L5c:
            int r7 = r7 << 4
            int r7 = r7 + r9
            int r12 = r12 + 1
            goto L4f
        L62:
            int r9 = r12 - r5
            if (r9 == 0) goto L94
            r10 = 4
            if (r9 <= r10) goto L6a
            goto L94
        L6a:
            int r6 = r3 + 1
            int r9 = r7 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            byte r9 = (byte) r9
            r0[r3] = r9
            r3 = r7 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            byte r3 = (byte) r3
            r0[r6] = r3
            int r3 = r6 + 1
            goto L9
        L7d:
            int r11 = r0.length
            if (r3 == r11) goto L90
            if (r4 != r1) goto L83
            goto L94
        L83:
            int r11 = r0.length
            int r12 = r3 - r4
            int r11 = r11 - r12
            java.lang.System.arraycopy(r0, r4, r0, r11, r12)
            int r11 = r0.length
            int r11 = r11 - r3
            int r11 = r11 + r4
            java.util.Arrays.fill(r0, r4, r11, r2)
        L90:
            java.net.InetAddress r6 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L95
        L94:
            return r6
        L95:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            goto L9c
        L9b:
            throw r11
        L9c:
            goto L9b
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(java.lang.String, int, int):java.net.InetAddress");
    }

    public static Charset a(e eVar, Charset charset) throws IOException {
        if (eVar.a(0L, f1144d)) {
            eVar.skip(f1144d.e());
            return f1149i;
        }
        if (eVar.a(0L, f1145e)) {
            eVar.skip(f1145e.e());
            return f1150j;
        }
        if (eVar.a(0L, f1146f)) {
            eVar.skip(f1146f.e());
            return f1151k;
        }
        if (eVar.a(0L, f1147g)) {
            eVar.skip(f1147g.e());
            return f1152l;
        }
        if (!eVar.a(0L, f1148h)) {
            return charset;
        }
        eVar.skip(f1148h.e());
        return f1153m;
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(String str, boolean z2) {
        return new b(str, z2);
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException | Exception unused) {
            }
        }
    }

    public static boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s sVar, int i2, TimeUnit timeUnit) {
        try {
            return b(sVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
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

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
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

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int b(String str, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static boolean b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s sVar, int i2, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jC = sVar.b().d() ? sVar.b().c() - jNanoTime : Long.MAX_VALUE;
        sVar.b().a(Math.min(jC, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
            while (sVar.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.j();
            }
            t tVarB = sVar.b();
            if (jC == Long.MAX_VALUE) {
                tVarB.a();
            } else {
                tVarB.a(jC + jNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            t tVarB2 = sVar.b();
            if (jC == Long.MAX_VALUE) {
                tVarB2.a();
            } else {
                tVarB2.a(jC + jNanoTime);
            }
            return false;
        } catch (Throwable th) {
            t tVarB3 = sVar.b();
            if (jC == Long.MAX_VALUE) {
                tVarB3.a();
            } else {
                tVarB3.a(jC + jNanoTime);
            }
            throw th;
        }
    }

    private static boolean b(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int c(String str, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 < i2) {
                return i2;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
    }

    public static String d(String str, int i2, int i3) {
        int iB = b(str, i2, i3);
        return str.substring(iB, c(str, iB, i3));
    }

    public static boolean d(String str) {
        return f1156p.matcher(str).matches();
    }
}
