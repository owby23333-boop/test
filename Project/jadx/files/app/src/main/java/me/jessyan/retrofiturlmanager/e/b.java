package me.jessyan.retrofiturlmanager.e;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DefaultUrlParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements e {
    private e a;
    private volatile e b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile e f21263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private me.jessyan.retrofiturlmanager.a f21264d;

    @Override // me.jessyan.retrofiturlmanager.e.e
    public void a(me.jessyan.retrofiturlmanager.a aVar) {
        this.f21264d = aVar;
        this.a = new c();
        this.a.a(aVar);
    }

    @Override // me.jessyan.retrofiturlmanager.e.e
    public HttpUrl a(HttpUrl httpUrl, HttpUrl httpUrl2) {
        if (httpUrl == null) {
            return httpUrl2;
        }
        if (httpUrl2.getUrl().contains("#baseurl_path_size=")) {
            if (this.f21263c == null) {
                synchronized (this) {
                    if (this.f21263c == null) {
                        this.f21263c = new d();
                        this.f21263c.a(this.f21264d);
                    }
                }
            }
            return this.f21263c.a(httpUrl, httpUrl2);
        }
        if (this.f21264d.d()) {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = new a();
                        this.b.a(this.f21264d);
                    }
                }
            }
            return this.b.a(httpUrl, httpUrl2);
        }
        return this.a.a(httpUrl, httpUrl2);
    }
}
