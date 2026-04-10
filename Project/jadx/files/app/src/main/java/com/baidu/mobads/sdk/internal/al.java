package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.u;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class al extends Observable implements u, Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected static final int f12834i = 10240;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected static final int f12835j = 10240;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12836k = ".tmp";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f12837m = "FileDownloader";
    protected Context a;
    protected URL b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f12838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f12839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f12840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected u.a f12841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f12842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f12843h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected byte[] f12844l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f12845n;

    public al(Context context, URL url, String str, String str2, boolean z2) {
        this.f12845n = false;
        this.a = context;
        this.b = url;
        this.f12838c = str;
        this.f12845n = z2;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.f12839d = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.f12839d = str2;
        }
        this.f12840e = -1;
        this.f12841f = u.a.DOWNLOADING;
        this.f12842g = 0;
        this.f12843h = 0;
    }

    private void s() {
        a(u.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a() {
        a(u.a.DOWNLOADING);
        p();
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z2) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public String e() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public String g() {
        return this.f12838c + this.f12839d;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public int j() {
        return this.f12840e;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public float k() {
        return Math.abs((this.f12842g / this.f12840e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public u.a l() {
        return this.f12841f;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.f12844l;
    }

    protected void p() {
        ba.a().a(this);
    }

    protected void q() {
        setChanged();
        notifyObservers();
    }

    protected void r() {
        bo.a(this.f12838c + this.f12839d + ".tmp", this.f12838c + this.f12839d);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.al.run():void");
    }

    protected void a(u.a aVar) {
        this.f12841f = aVar;
        q();
    }

    protected void a(int i2, float f2) {
        this.f12842g += i2;
        q();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                this.b = new URL(httpURLConnection.getHeaderField("Location"));
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.b.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }
}
