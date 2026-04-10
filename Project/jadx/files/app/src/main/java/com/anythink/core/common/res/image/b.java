package com.anythink.core.common.res.image;

import android.os.SystemClock;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    private final String a = getClass().getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f7928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f7929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f7930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected long f7931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected long f7932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected long f7933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected long f7934i;

    /* JADX INFO: renamed from: com.anythink.core.common.res.image.b$1, reason: invalid class name */
    final class AnonymousClass1 extends com.anythink.core.common.k.b.b {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v31 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v44 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r1v46 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v9, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v17, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.net.HttpURLConnection] */
        private void b(String str) throws Throwable {
            ?? r2;
            b.this.f7930e = System.currentTimeMillis();
            b.this.f7931f = SystemClock.elapsedRealtime();
            ?? r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            try {
                try {
                    String unused = b.this.a;
                    r2 = (HttpURLConnection) new URL(str).openConnection();
                } catch (OutOfMemoryError e2) {
                    e = e2;
                } catch (StackOverflowError e3) {
                    e = e3;
                } catch (Error e4) {
                    e = e4;
                } catch (SocketTimeoutException e5) {
                    e = e5;
                } catch (ConnectTimeoutException e6) {
                    e = e6;
                } catch (Exception e7) {
                    e = e7;
                }
                try {
                    r2.setInstanceFollowRedirects(false);
                    Map<String, String> mapA = b.this.a();
                    if (mapA != null && mapA.size() > 0) {
                        for (String str2 : mapA.keySet()) {
                            r2.addRequestProperty(str2, mapA.get(str2));
                            String unused2 = b.this.a;
                            StringBuilder sb = new StringBuilder("REQUEST ADDED HEADER: \n");
                            sb.append(str2);
                            sb.append("  :  ");
                            sb.append(mapA.get(str2));
                        }
                    }
                } catch (OutOfMemoryError e8) {
                    e = e8;
                    r1 = r2;
                    System.gc();
                    String unused3 = b.this.a;
                    e.getMessage();
                    b.this.a(c.a, e.getMessage());
                    if (r1 != 0) {
                        r1.disconnect();
                        return;
                    }
                } catch (StackOverflowError e9) {
                    e = e9;
                    r1 = r2;
                    System.gc();
                    String unused4 = b.this.a;
                    e.getMessage();
                    b.this.a(c.a, e.getMessage());
                    if (r1 != 0) {
                        r1.disconnect();
                        return;
                    }
                } catch (Error e10) {
                    e = e10;
                    r1 = r2;
                    System.gc();
                    String unused5 = b.this.a;
                    e.getMessage();
                    b.this.a(c.a, e.getMessage());
                    if (r1 != 0) {
                        r1.disconnect();
                        return;
                    }
                } catch (SocketTimeoutException e11) {
                    e = e11;
                    r1 = r2;
                    b.this.a(c.a, e.getMessage());
                    String unused6 = b.this.a;
                    if (r1 != 0) {
                        r1.disconnect();
                    }
                } catch (ConnectTimeoutException e12) {
                    e = e12;
                    r1 = r2;
                    b.this.a(c.a, e.getMessage());
                    if (r1 != 0) {
                        r1.disconnect();
                        return;
                    }
                } catch (Exception e13) {
                    e = e13;
                    r1 = r2;
                    String unused7 = b.this.a;
                    e.getMessage();
                    b.this.a(c.a, e.getMessage());
                    if (r1 != 0) {
                        r1.disconnect();
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
                if (b.this.f7929d) {
                    b.this.a(c.b, "Task had been canceled.");
                    if (r2 != 0) {
                        r2.disconnect();
                        return;
                    }
                    return;
                }
                r2.setConnectTimeout(BaseConstants.Time.MINUTE);
                r2.connect();
                int responseCode = r2.getResponseCode();
                if (responseCode != 200) {
                    String unused8 = b.this.a;
                    StringBuilder sb2 = new StringBuilder("http respond status code is ");
                    sb2.append(responseCode);
                    sb2.append(" ! url=");
                    sb2.append(str);
                    if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                        b.this.a(c.a, r2.getResponseMessage());
                        if (r2 != 0) {
                            r2.disconnect();
                            return;
                        }
                        return;
                    }
                    if (b.this.f7929d) {
                        b.this.a(c.b, "Task had been canceled.");
                    } else {
                        String headerField = r2.getHeaderField("Location");
                        if (headerField != null) {
                            if (!headerField.toLowerCase().startsWith("http")) {
                                b.this.a(c.a, "Final url is wrong:".concat(String.valueOf(headerField)));
                                if (r2 != 0) {
                                    r2.disconnect();
                                    return;
                                }
                                return;
                            }
                            b(headerField);
                        }
                    }
                    if (r2 != 0) {
                        r2.disconnect();
                        return;
                    }
                    return;
                }
                if (b.this.f7929d) {
                    b.this.a(c.b, "Task had been canceled.");
                    if (r2 != 0) {
                        r2.disconnect();
                        return;
                    }
                    return;
                }
                b.this.f7934i = r2.getContentLength();
                InputStream inputStream = r2.getInputStream();
                boolean zA = b.this.a(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                b.this.f7932g = System.currentTimeMillis();
                b.this.f7933h = SystemClock.elapsedRealtime();
                if (zA) {
                    String unused9 = b.this.a;
                    StringBuilder sb3 = new StringBuilder("download success --> ");
                    String str3 = b.this.f7928c;
                    sb3.append(str3);
                    b.this.c();
                    r1 = str3;
                } else {
                    String unused10 = b.this.a;
                    new StringBuilder("download fail --> ").append(b.this.f7928c);
                    b.this.a(c.a, "Save fail!");
                    r1 = "Save fail!";
                }
                if (r2 != 0) {
                    r2.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                r2 = r1;
            }
        }

        @Override // com.anythink.core.common.k.b.b
        public final void a() throws Throwable {
            try {
                b(b.this.f7928c);
            } catch (Exception e2) {
                String unused = b.this.a;
                e2.getMessage();
                b.this.a(c.a, e2.getMessage());
            } catch (OutOfMemoryError e3) {
                e = e3;
                System.gc();
                b.this.a(c.a, e.getMessage());
            } catch (StackOverflowError e4) {
                e = e4;
                System.gc();
                b.this.a(c.a, e.getMessage());
            }
        }
    }

    public b(String str) {
        this.f7928c = str;
    }

    private void e() {
        this.f7929d = true;
    }

    private void f() {
        a(new AnonymousClass1());
    }

    private static int g() {
        return BaseConstants.Time.MINUTE;
    }

    private static int h() {
        return 20000;
    }

    protected abstract Map<String, String> a();

    protected abstract void a(com.anythink.core.common.k.b.b bVar);

    protected abstract void a(String str, String str2);

    protected abstract boolean a(InputStream inputStream);

    protected abstract void b();

    protected abstract void c();

    public final void d() {
        this.f7929d = false;
        a(new AnonymousClass1());
    }
}
