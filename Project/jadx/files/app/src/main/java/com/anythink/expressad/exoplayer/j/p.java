package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.expressad.exoplayer.j.s;
import com.anythink.expressad.exoplayer.k.af;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements s {
    public static final int a = 8000;
    public static final int b = 8000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9712d = "DefaultHttpDataSource";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9713e = 20;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f9714f = 2048;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f9715g = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicReference<byte[]> f9716h = new AtomicReference<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f9717i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f9718j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f9719k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f9720l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.u<String> f9721m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final s.f f9722n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final s.f f9723o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final aa<? super p> f9724p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private k f9725q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private HttpURLConnection f9726r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private InputStream f9727s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f9728t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f9729u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f9730v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f9731w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f9732x;

    private p(String str, com.anythink.expressad.exoplayer.k.u<String> uVar) {
        this(str, uVar, null);
    }

    private HttpURLConnection e() {
        return this.f9726r;
    }

    private long f() {
        return this.f9731w;
    }

    private long g() {
        return this.f9732x;
    }

    private long h() {
        long j2 = this.f9730v;
        return j2 == -1 ? j2 : j2 - this.f9732x;
    }

    private void i() throws IOException {
        if (this.f9731w == this.f9729u) {
            return;
        }
        byte[] andSet = f9716h.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j2 = this.f9731w;
            long j3 = this.f9729u;
            if (j2 == j3) {
                f9716h.set(andSet);
                return;
            }
            int i2 = this.f9727s.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (i2 == -1) {
                throw new EOFException();
            }
            this.f9731w += (long) i2;
            aa<? super p> aaVar = this.f9724p;
            if (aaVar != null) {
                aaVar.a(i2);
            }
        }
    }

    private void j() {
        HttpURLConnection httpURLConnection = this.f9726r;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
            this.f9726r = null;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        HttpURLConnection httpURLConnection = this.f9726r;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a A[Catch: Exception -> 0x006b, all -> 0x008e, TryCatch #0 {Exception -> 0x006b, blocks: (B:14:0x0024, B:16:0x002c, B:21:0x003a, B:23:0x004a, B:25:0x0052), top: B:45:0x0024 }] */
    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.f9727s     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L7b
            java.net.HttpURLConnection r2 = r9.f9726r     // Catch: java.lang.Throwable -> L8e
            long r3 = r9.f9730v     // Catch: java.lang.Throwable -> L8e
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L13
            long r3 = r9.f9730v     // Catch: java.lang.Throwable -> L8e
            goto L18
        L13:
            long r3 = r9.f9730v     // Catch: java.lang.Throwable -> L8e
            long r7 = r9.f9732x     // Catch: java.lang.Throwable -> L8e
            long r3 = r3 - r7
        L18:
            int r7 = com.anythink.expressad.exoplayer.k.af.a     // Catch: java.lang.Throwable -> L8e
            r8 = 19
            if (r7 == r8) goto L24
            int r7 = com.anythink.expressad.exoplayer.k.af.a     // Catch: java.lang.Throwable -> L8e
            r8 = 20
            if (r7 != r8) goto L6b
        L24:
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L34
            int r3 = r2.read()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            r4 = -1
            if (r3 != r4) goto L3a
            goto L6b
        L34:
            r5 = 2048(0x800, double:1.012E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L6b
        L3a:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            if (r4 != 0) goto L52
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            if (r3 == 0) goto L6b
        L52:
            java.lang.Class r3 = r2.getClass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
            r3.invoke(r2, r4)     // Catch: java.lang.Exception -> L6b java.lang.Throwable -> L8e
        L6b:
            java.io.InputStream r2 = r9.f9727s     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8e
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L8e
            goto L7b
        L71:
            r2 = move-exception
            com.anythink.expressad.exoplayer.j.s$c r3 = new com.anythink.expressad.exoplayer.j.s$c     // Catch: java.lang.Throwable -> L8e
            com.anythink.expressad.exoplayer.j.k r4 = r9.f9725q     // Catch: java.lang.Throwable -> L8e
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L8e
            throw r3     // Catch: java.lang.Throwable -> L8e
        L7b:
            r9.f9727s = r0
            r9.j()
            boolean r0 = r9.f9728t
            if (r0 == 0) goto L8d
            r9.f9728t = r1
            com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> r0 = r9.f9724p
            if (r0 == 0) goto L8d
            r0.c()
        L8d:
            return
        L8e:
            r2 = move-exception
            r9.f9727s = r0
            r9.j()
            boolean r0 = r9.f9728t
            if (r0 == 0) goto La1
            r9.f9728t = r1
            com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> r0 = r9.f9724p
            if (r0 == 0) goto La1
            r0.c()
        La1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.p.b():void");
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final Map<String, List<String>> c() {
        HttpURLConnection httpURLConnection = this.f9726r;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void d() {
        this.f9723o.a();
    }

    private p(String str, com.anythink.expressad.exoplayer.k.u<String> uVar, aa<? super p> aaVar) {
        this(str, uVar, aaVar, (byte) 0);
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void a(String str, String str2) {
        com.anythink.expressad.exoplayer.k.a.a(str);
        com.anythink.expressad.exoplayer.k.a.a(str2);
        this.f9723o.a(str, str2);
    }

    private p(String str, com.anythink.expressad.exoplayer.k.u<String> uVar, aa<? super p> aaVar, byte b2) {
        this(str, uVar, aaVar, 8000, 8000, false, null);
    }

    public p(String str, com.anythink.expressad.exoplayer.k.u<String> uVar, aa<? super p> aaVar, int i2, int i3, boolean z2, s.f fVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f9720l = str;
            this.f9721m = uVar;
            this.f9724p = aaVar;
            this.f9723o = new s.f();
            this.f9718j = i2;
            this.f9719k = i3;
            this.f9717i = z2;
            this.f9722n = fVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void a(String str) {
        com.anythink.expressad.exoplayer.k.a.a(str);
        this.f9723o.a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a9  */
    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(com.anythink.expressad.exoplayer.j.k r25) throws com.anythink.expressad.exoplayer.j.s.c {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.p.a(com.anythink.expressad.exoplayer.j.k):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.HttpURLConnection b(com.anythink.expressad.exoplayer.j.k r19) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r19
            java.net.URL r1 = new java.net.URL
            android.net.Uri r2 = r0.f9667c
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            byte[] r2 = r0.f9668d
            long r12 = r0.f9670f
            long r14 = r0.f9671g
            r3 = 1
            boolean r16 = r0.a(r3)
            r11 = r18
            boolean r0 = r11.f9717i
            if (r0 != 0) goto L2a
            r8 = 1
            r0 = r18
            r3 = r12
            r5 = r14
            r7 = r16
            java.net.HttpURLConnection r0 = r0.a(r1, r2, r3, r5, r7, r8)
            return r0
        L2a:
            r0 = 0
        L2b:
            int r17 = r0 + 1
            r3 = 20
            if (r0 > r3) goto La3
            r0 = 0
            r3 = r18
            r4 = r1
            r5 = r2
            r6 = r12
            r8 = r14
            r10 = r16
            r11 = r0
            java.net.HttpURLConnection r0 = r3.a(r4, r5, r6, r8, r10, r11)
            int r3 = r0.getResponseCode()
            r4 = 300(0x12c, float:4.2E-43)
            if (r3 == r4) goto L5f
            r4 = 301(0x12d, float:4.22E-43)
            if (r3 == r4) goto L5f
            r4 = 302(0x12e, float:4.23E-43)
            if (r3 == r4) goto L5f
            r4 = 303(0x12f, float:4.25E-43)
            if (r3 == r4) goto L5f
            if (r2 != 0) goto L5e
            r2 = 307(0x133, float:4.3E-43)
            if (r3 == r2) goto L5f
            r2 = 308(0x134, float:4.32E-43)
            if (r3 != r2) goto L5e
            goto L5f
        L5e:
            return r0
        L5f:
            r2 = 0
            java.lang.String r3 = "Location"
            java.lang.String r3 = r0.getHeaderField(r3)
            r0.disconnect()
            if (r3 == 0) goto L9b
            java.net.URL r0 = new java.net.URL
            r0.<init>(r1, r3)
            java.lang.String r1 = r0.getProtocol()
            java.lang.String r3 = "https"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L95
            java.lang.String r3 = "http"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L85
            goto L95
        L85:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Unsupported protocol redirect: "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L95:
            r11 = r18
            r1 = r0
            r0 = r17
            goto L2b
        L9b:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Null location redirect"
            r0.<init>(r1)
            throw r0
        La3:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException
            java.lang.String r1 = java.lang.String.valueOf(r17)
            java.lang.String r2 = "Too many redirects: "
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            goto Lb4
        Lb3:
            throw r0
        Lb4:
            goto Lb3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.p.b(com.anythink.expressad.exoplayer.j.k):java.net.HttpURLConnection");
    }

    private int b(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f9730v;
        if (j2 != -1) {
            long j3 = j2 - this.f9732x;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min(i3, j3);
        }
        int i4 = this.f9727s.read(bArr, i2, i3);
        if (i4 == -1) {
            if (this.f9730v == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.f9732x += (long) i4;
        aa<? super p> aaVar = this.f9724p;
        if (aaVar != null) {
            aaVar.a(i4);
        }
        return i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.net.HttpURLConnection a(java.net.URL r6, byte[] r7, long r8, long r10, boolean r12, boolean r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.p.a(java.net.URL, byte[], long, long, boolean, boolean):java.net.HttpURLConnection");
    }

    private static URL a(URL url, String str) throws ProtocolException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if ("https".equals(protocol) || "http".equals(protocol)) {
                return url2;
            }
            throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
        }
        throw new ProtocolException("Null location redirect");
    }

    private static long a(HttpURLConnection httpURLConnection) {
        long j2;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField)) {
            j2 = -1;
        } else {
            try {
                j2 = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                String str = "Unexpected Content-Length [" + headerField + "]";
                j2 = -1;
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j2;
        }
        Matcher matcher = f9715g.matcher(headerField2);
        if (!matcher.find()) {
            return j2;
        }
        try {
            long j3 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j2 < 0) {
                return j3;
            }
            if (j2 == j3) {
                return j2;
            }
            String str2 = "Inconsistent headers [" + headerField + "] [" + headerField2 + "]";
            return Math.max(j2, j3);
        } catch (NumberFormatException unused2) {
            String str3 = "Unexpected Content-Range [" + headerField2 + "]";
            return j2;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, long j2) {
        int i2 = af.a;
        if (i2 == 19 || i2 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) throws s.c {
        try {
            if (this.f9731w != this.f9729u) {
                byte[] andSet = f9716h.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.f9731w != this.f9729u) {
                    int i4 = this.f9727s.read(andSet, 0, (int) Math.min(this.f9729u - this.f9731w, andSet.length));
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i4 != -1) {
                        this.f9731w += (long) i4;
                        if (this.f9724p != null) {
                            this.f9724p.a(i4);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                f9716h.set(andSet);
            }
            if (i3 == 0) {
                return 0;
            }
            if (this.f9730v != -1) {
                long j2 = this.f9730v - this.f9732x;
                if (j2 == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i3, j2);
            }
            int i5 = this.f9727s.read(bArr, i2, i3);
            if (i5 == -1) {
                if (this.f9730v == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.f9732x += (long) i5;
            if (this.f9724p != null) {
                this.f9724p.a(i5);
            }
            return i5;
        } catch (IOException e2) {
            throw new s.c(e2, this.f9725q, 2);
        }
    }
}
