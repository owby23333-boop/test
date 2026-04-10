package com.anythink.china.common.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.message.proguard.ad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6393e = ".temp";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f6394f = ".log";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6395g = ".apk";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6396h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6397i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6398j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6399k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6400l = 4;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f6401u = "a";
    protected String a;
    protected String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f6402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f6403d;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6404m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected long f6405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected long f6406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected long f6407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected long f6408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected long f6409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected long f6410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected long f6411t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private InterfaceC0150a f6412v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private e f6413w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f6414x;

    /* JADX INFO: renamed from: com.anythink.china.common.a.a$1, reason: invalid class name */
    final class AnonymousClass1 extends com.anythink.core.common.k.b.b {
        AnonymousClass1() {
        }

        private void b(String str) throws Throwable {
            HttpURLConnection httpURLConnection;
            a.this.f6406o = System.currentTimeMillis();
            a.this.f6407p = SystemClock.elapsedRealtime();
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    String unused = a.f6401u;
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (SocketTimeoutException e2) {
                    e = e2;
                } catch (Exception e3) {
                    e = e3;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                } catch (StackOverflowError e5) {
                    e = e5;
                } catch (Error e6) {
                    e = e6;
                } catch (ConnectTimeoutException e7) {
                    e = e7;
                }
                try {
                    httpURLConnection.setInstanceFollowRedirects(false);
                    if (a.this.f6413w.f6434o) {
                        String strI = com.anythink.core.common.k.d.i();
                        if (!TextUtils.isEmpty(strI)) {
                            httpURLConnection.addRequestProperty("User-Agent", strI);
                        }
                    }
                    if (a.this.f6405n > 0) {
                        String unused2 = a.f6401u;
                        StringBuilder sb = new StringBuilder("Range: startPos -> ");
                        sb.append(a.this.f6405n);
                        sb.append("  ,  endPos -> ");
                        sb.append(a.this.f6410s);
                        httpURLConnection.setRequestProperty("Range", "bytes=" + a.this.f6405n + "-");
                    } else {
                        a.this.f6410s = httpURLConnection.getContentLength();
                    }
                    if (a.this.f6410s <= 0) {
                        String unused3 = a.f6401u;
                        a.this.a(c.a("10000", "downloadSize <= 0"));
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    if (a.this.f6402c) {
                        if (a.this.f6413w != null) {
                            a.this.f6413w.j();
                        }
                        a.this.f6404m = 3;
                        a.this.d();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    httpURLConnection.setConnectTimeout(BaseConstants.Time.MINUTE);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200 && responseCode != 206) {
                        String unused4 = a.f6401u;
                        StringBuilder sb2 = new StringBuilder("http respond status code is ");
                        sb2.append(responseCode);
                        sb2.append(" ! url=");
                        sb2.append(str);
                        a.this.a(c.a("10001", httpURLConnection.getResponseMessage()));
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    if (a.this.f6402c) {
                        if (a.this.f6413w != null) {
                            a.this.f6413w.j();
                        }
                        a.this.f6404m = 3;
                        a.this.d();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (a.this.f6413w != null) {
                        a.this.f6413w.i();
                    }
                    a.this.f6413w.f6427h = a.this.f6410s;
                    if (a.this.f6412v != null) {
                        a.this.f6412v.a(a.this.f6413w, a.this.f6405n, a.this.f6410s);
                    }
                    int iA = a.this.a(a.this.b, inputStream);
                    a.this.f6404m = iA;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    a.this.f6408q = System.currentTimeMillis();
                    a.this.f6409r = SystemClock.elapsedRealtime();
                    a.this.f6413w.f6428i = a.this.f6409r - a.this.f6407p;
                    if (iA == 1) {
                        String unused5 = a.f6401u;
                        new StringBuilder("download success --> ").append(a.this.a);
                        a.this.e();
                    } else if (iA == 2 || iA == 3) {
                        a.this.d();
                    } else {
                        String unused6 = a.f6401u;
                        new StringBuilder("download fail --> ").append(a.this.a);
                        a.this.b(c.a("10000", "Save fail!(" + a.this.f6414x + ad.f20406s));
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Error e8) {
                    e = e8;
                    httpURLConnection2 = httpURLConnection;
                    System.gc();
                    String unused7 = a.f6401u;
                    e.getMessage();
                    a.this.a(c.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (SocketTimeoutException e9) {
                    e = e9;
                    httpURLConnection2 = httpURLConnection;
                    a.this.a(c.a("20001", e.getMessage()));
                    String unused8 = a.f6401u;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Exception e10) {
                    e = e10;
                    httpURLConnection2 = httpURLConnection;
                    String unused9 = a.f6401u;
                    e.getMessage();
                    a.this.a(c.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (OutOfMemoryError e11) {
                    e = e11;
                    httpURLConnection2 = httpURLConnection;
                    System.gc();
                    String unused10 = a.f6401u;
                    e.getMessage();
                    a.this.a(c.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (StackOverflowError e12) {
                    e = e12;
                    httpURLConnection2 = httpURLConnection;
                    System.gc();
                    String unused11 = a.f6401u;
                    e.getMessage();
                    a.this.a(c.a("10000", e.getMessage() != null ? e.getMessage() : "Http connect error!"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (ConnectTimeoutException e13) {
                    e = e13;
                    httpURLConnection2 = httpURLConnection;
                    a.this.a(e);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:145:0x0326  */
        @Override // com.anythink.core.common.k.b.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 820
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.common.a.a.AnonymousClass1.a():void");
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.common.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0150a {
        void a(e eVar, long j2);

        void a(e eVar, long j2, long j3);

        void a(e eVar, long j2, long j3, int i2);

        void a(e eVar, String str);

        void b(e eVar, long j2, long j3);
    }

    public a(e eVar) {
        this.f6413w = eVar;
        this.a = eVar.b;
        this.b = eVar.f6433n;
    }

    private void g() {
        com.anythink.china.common.a.a.a.a().a((com.anythink.core.common.k.b.b) new AnonymousClass1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.FileInputStream, java.io.InputStream] */
    private void h() throws Throwable {
        BufferedReader bufferedReader;
        ?? file = new File(com.anythink.china.common.c.b.a(this.b) + f6394f);
        StringBuilder sb = new StringBuilder();
        sb.append(com.anythink.china.common.c.b.a(this.b));
        ?? fileInputStream = f6393e;
        sb.append(f6393e);
        File file2 = new File(sb.toString());
        if (!file.exists() || !file2.exists()) {
            try {
                file.delete();
                file2.delete();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                fileInputStream = new FileInputStream((File) file);
                try {
                    file = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(file);
                        try {
                            String line = bufferedReader.readLine();
                            if (!TextUtils.isEmpty(line)) {
                                this.f6405n = Long.valueOf(line).longValue();
                                if (this.f6405n > file2.length()) {
                                    this.f6405n = 0L;
                                } else {
                                    this.f6410s = file2.length();
                                }
                                StringBuilder sb2 = new StringBuilder("readLogFile: startPost -> ");
                                sb2.append(this.f6405n);
                                sb2.append(", downloadSize -> ");
                                sb2.append(this.f6410s);
                            }
                            try {
                                bufferedReader.close();
                                file.close();
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader2 = bufferedReader;
                            e.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return;
                                }
                            }
                            if (file != 0) {
                                file.close();
                            }
                            if (fileInputStream != 0) {
                                fileInputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    throw th;
                                }
                            }
                            if (file != 0) {
                                file.close();
                            }
                            if (fileInputStream != 0) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    }
                } catch (Exception e7) {
                    e = e7;
                    file = 0;
                } catch (Throwable th2) {
                    th = th2;
                    file = 0;
                    bufferedReader = null;
                }
            } catch (Exception e8) {
                e = e8;
                file = 0;
                fileInputStream = 0;
            } catch (Throwable th3) {
                th = th3;
                file = 0;
                fileInputStream = 0;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = bufferedReader2;
        }
    }

    private static int i() {
        return BaseConstants.Time.MINUTE;
    }

    private static int j() {
        return 20000;
    }

    protected boolean c() {
        return true;
    }

    protected final void e() {
        new StringBuilder("url: ").append(this.a);
        InterfaceC0150a interfaceC0150a = this.f6412v;
        if (interfaceC0150a != null) {
            e eVar = this.f6413w;
            interfaceC0150a.a(eVar, eVar.f6428i);
        }
    }

    public final void a(InterfaceC0150a interfaceC0150a) {
        this.f6412v = interfaceC0150a;
        this.f6402c = false;
        com.anythink.china.common.a.a.a.a().a((com.anythink.core.common.k.b.b) new AnonymousClass1());
    }

    public final void b() {
        this.f6403d = true;
    }

    protected final void d() {
        new StringBuilder("url: ").append(this.a);
        InterfaceC0150a interfaceC0150a = this.f6412v;
        if (interfaceC0150a != null) {
            interfaceC0150a.a(this.f6413w, this.f6411t, this.f6410s, this.f6404m);
        }
    }

    protected final void b(b bVar) {
        StringBuilder sb = new StringBuilder("download failed --> ");
        sb.append(this.a);
        sb.append(ad.f20405r);
        sb.append(bVar.a());
        sb.append(ad.f20406s);
        this.f6413w.n();
        InterfaceC0150a interfaceC0150a = this.f6412v;
        if (interfaceC0150a != null) {
            interfaceC0150a.a(this.f6413w, bVar.b());
        }
    }

    public final void a() {
        this.f6402c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, InputStream inputStream) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        String strA = com.anythink.china.common.c.b.a(str);
        if (TextUtils.isEmpty(strA)) {
            return 4;
        }
        File file = new File(strA + f6393e);
        File file2 = new File(strA + f6394f);
        try {
            if (!file.exists()) {
                boolean zCreateNewFile = file.createNewFile();
                boolean zCreateNewFile2 = file2.createNewFile();
                if (!zCreateNewFile || !zCreateNewFile2) {
                    return 4;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rws");
            try {
                randomAccessFile2 = new RandomAccessFile(file2, "rws");
            } catch (Throwable th) {
                th = th;
                randomAccessFile2 = null;
            }
            try {
                long j2 = 0;
                if (this.f6405n > 0) {
                    String str2 = ad.f20405r + this.f6413w.f6422c + ")  seek to -> " + this.f6405n;
                    randomAccessFile.seek(this.f6405n);
                } else {
                    String str3 = ad.f20405r + this.f6413w.f6422c + ")  set temp file size -> " + this.f6410s;
                    randomAccessFile.setLength(this.f6410s);
                }
                byte[] bArr = new byte[1048576];
                this.f6411t = this.f6405n;
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (-1 != i2) {
                        if (this.f6403d) {
                            if (this.f6413w != null) {
                                this.f6413w.k();
                            }
                            try {
                                randomAccessFile.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            try {
                                randomAccessFile2.close();
                                return 2;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return 2;
                            }
                        }
                        if (this.f6402c) {
                            if (this.f6413w != null) {
                                this.f6413w.j();
                            }
                            try {
                                randomAccessFile.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            try {
                                randomAccessFile2.close();
                                return 3;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return 3;
                            }
                        }
                        randomAccessFile.write(bArr, 0, i2);
                        File file3 = file2;
                        this.f6411t += (long) i2;
                        if (this.f6413w != null) {
                            this.f6413w.f6426g = this.f6411t;
                        }
                        randomAccessFile2.setLength(j2);
                        randomAccessFile2.write(String.valueOf(this.f6411t).getBytes());
                        if (this.f6412v != null) {
                            this.f6412v.b(this.f6413w, this.f6411t, this.f6410s);
                            file2 = file3;
                            j2 = 0;
                        } else {
                            file2 = file3;
                        }
                    } else {
                        File file4 = file2;
                        file.renameTo(new File(strA + f6395g));
                        if (file4.exists()) {
                            file4.delete();
                        }
                        if (this.f6413w != null) {
                            this.f6413w.l();
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        try {
                            randomAccessFile2.close();
                            return 1;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            return 1;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    this.f6414x = th.getMessage();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (randomAccessFile2 == null) {
                        return 4;
                    }
                    try {
                        randomAccessFile2.close();
                        return 4;
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        return 4;
                    }
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            randomAccessFile2 = null;
        }
    }

    protected final void a(ConnectTimeoutException connectTimeoutException) {
        b(c.a("10000", connectTimeoutException.getMessage()));
    }

    protected final void a(b bVar) {
        new StringBuilder("url: ").append(this.a);
        b(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.FileInputStream, java.io.InputStream] */
    static /* synthetic */ void a(a aVar) throws Throwable {
        BufferedReader bufferedReader;
        ?? file = new File(com.anythink.china.common.c.b.a(aVar.b) + f6394f);
        StringBuilder sb = new StringBuilder();
        sb.append(com.anythink.china.common.c.b.a(aVar.b));
        ?? fileInputStream = f6393e;
        sb.append(f6393e);
        File file2 = new File(sb.toString());
        if (file.exists() && file2.exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream((File) file);
                    try {
                        file = new InputStreamReader(fileInputStream);
                        try {
                            bufferedReader = new BufferedReader(file);
                            try {
                                String line = bufferedReader.readLine();
                                if (!TextUtils.isEmpty(line)) {
                                    aVar.f6405n = Long.valueOf(line).longValue();
                                    if (aVar.f6405n > file2.length()) {
                                        aVar.f6405n = 0L;
                                    } else {
                                        aVar.f6410s = file2.length();
                                    }
                                    StringBuilder sb2 = new StringBuilder("readLogFile: startPost -> ");
                                    sb2.append(aVar.f6405n);
                                    sb2.append(", downloadSize -> ");
                                    sb2.append(aVar.f6410s);
                                }
                                try {
                                    bufferedReader.close();
                                    file.close();
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                bufferedReader2 = bufferedReader;
                                e.printStackTrace();
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        return;
                                    }
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                if (fileInputStream != 0) {
                                    fileInputStream.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (file != 0) {
                                    file.close();
                                }
                                if (fileInputStream != 0) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        file = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        file = 0;
                        bufferedReader = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    file = 0;
                    fileInputStream = 0;
                } catch (Throwable th3) {
                    th = th3;
                    file = 0;
                    fileInputStream = 0;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = bufferedReader2;
            }
        } else {
            try {
                file.delete();
                file2.delete();
            } catch (Throwable unused) {
            }
        }
    }
}
