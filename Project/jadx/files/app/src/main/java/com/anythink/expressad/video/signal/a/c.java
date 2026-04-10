package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import android.content.Context;
import com.anythink.expressad.out.p;
import com.anythink.expressad.video.signal.c;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.anythink.expressad.video.signal.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final String f11914d = "DefaultJSCommon";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected String f11924n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected com.anythink.expressad.videocommon.e.d f11925o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected com.anythink.expressad.videocommon.c.c f11926p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected com.anythink.expressad.a.a f11927q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f11915e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f11916f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f11917g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f11918h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f11919i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f11920j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f11921k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f11922l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected int f11923m = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c.a f11928r = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f11929s = 2;

    public static class a implements c.a {
        @Override // com.anythink.expressad.out.p.c
        public final boolean a() {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onInterceptDefaultLoadingDialog");
            return false;
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onDismissLoading,campaign:".concat(String.valueOf(jVar)));
        }

        @Override // com.anythink.expressad.out.p.c
        public final void c(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onDownloadStart,campaign:".concat(String.valueOf(jVar)));
        }

        @Override // com.anythink.expressad.out.p.c
        public final void d(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onDownloadFinish,campaign:".concat(String.valueOf(jVar)));
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onShowLoading,campaign:".concat(String.valueOf(jVar)));
        }

        @Override // com.anythink.expressad.out.p.c
        public void b(com.anythink.expressad.out.j jVar, String str) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onFinishRedirection,campaign:" + jVar + ",url:" + str);
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void c() {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "videoLocationReady");
        }

        @Override // com.anythink.expressad.out.p.c
        public void a(com.anythink.expressad.foundation.d.c cVar, String str) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onStartRedirection,campaign:" + cVar + ",url:" + str);
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void b() {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onInitSuccess");
        }

        @Override // com.anythink.expressad.out.p.c
        public void a(com.anythink.expressad.out.j jVar, String str) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onFinishRedirection,campaign:" + jVar + ",url:" + str);
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(int i2) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onDownloadProgress,progress:".concat(String.valueOf(i2)));
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void a(com.anythink.expressad.foundation.d.c cVar, boolean z2) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onStartInstall");
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public void a(int i2, String str) {
            com.anythink.expressad.foundation.h.o.a(c.f11914d, "onH5Error,code:" + i2 + "，msg:" + str);
        }
    }

    public static class b implements c.a {
        private com.anythink.expressad.video.signal.c a;
        private c.a b;

        public b(com.anythink.expressad.video.signal.c cVar, c.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // com.anythink.expressad.out.p.c
        public final boolean a() {
            c.a aVar = this.b;
            return aVar != null && aVar.a();
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.b(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void c(com.anythink.expressad.out.j jVar) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.c(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void d(com.anythink.expressad.out.j jVar) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.d(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(jVar);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.b(jVar, str);
            }
            com.anythink.expressad.video.signal.c cVar = this.a;
            if (cVar != null) {
                cVar.j();
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void c() {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.c();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(cVar, str);
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(jVar, str);
            }
            com.anythink.expressad.video.signal.c cVar = this.a;
            if (cVar != null) {
                cVar.j();
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void b() {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(int i2) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(i2);
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z2) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(cVar, z2);
            }
        }

        @Override // com.anythink.expressad.video.signal.c.a
        public final void a(int i2, String str) {
            c.a aVar = this.b;
            if (aVar != null) {
                aVar.a(i2, str);
            }
        }
    }

    private void a(com.anythink.expressad.videocommon.c.c cVar) {
        this.f11926p = cVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void b(int i2) {
        this.f11918h = i2;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void c(int i2) {
        this.f11917g = i2;
    }

    @Override // com.anythink.expressad.video.signal.d
    public void click(int i2, String str) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "click:type" + i2 + ",pt:" + str);
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void d(int i2) {
        this.f11919i = i2;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void e(int i2) {
        this.f11920j = i2;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void f(int i2) {
        this.f11921k = i2;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final boolean g() {
        return this.f11915e;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void h() {
        this.f11915e = true;
    }

    @Override // com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i2, String str) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "handlerH5Exception,code=" + i2 + ",msg:" + str);
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void i(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "setAlertDialogRole ".concat(String.valueOf(i2)));
        this.f11922l = i2;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void j() {
        com.anythink.expressad.foundation.h.o.a(f11914d, "finish");
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void k() {
        com.anythink.expressad.foundation.h.o.a(f11914d, "release");
        com.anythink.expressad.a.a aVar = this.f11927q;
        if (aVar != null) {
            aVar.a();
            this.f11927q.a((p.c) null);
            this.f11927q.b();
        }
    }

    @Override // com.anythink.expressad.video.signal.c
    public void l() {
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int m() {
        return this.f11923m;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int n() {
        com.anythink.expressad.foundation.h.o.a(f11914d, "getAlertDialogRole " + this.f11922l);
        return this.f11922l;
    }

    @Override // com.anythink.expressad.video.signal.c
    public String o() {
        com.anythink.expressad.foundation.h.o.a(f11914d, "getNotchArea");
        return null;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(int i2) {
        this.f11929s = i2;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int b() {
        if (this.f11918h == 0 && this.f11916f) {
            this.f11918h = 1;
        }
        return this.f11918h;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int c() {
        if (this.f11917g == 0 && this.f11916f) {
            this.f11917g = 1;
        }
        return this.f11917g;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int d() {
        if (this.f11919i == 0 && this.f11916f) {
            this.f11919i = 1;
        }
        return this.f11919i;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int e() {
        return this.f11920j;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final int f() {
        return this.f11921k;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void g(int i2) {
        this.f11923m = i2;
    }

    @Override // com.anythink.expressad.video.signal.c
    public String h(int i2) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "getSDKInfo");
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.c
    public final boolean a() {
        return this.f11916f;
    }

    @Override // com.anythink.expressad.video.signal.c
    public String i() {
        com.anythink.expressad.foundation.h.o.a(f11914d, "init");
        return "{}";
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(boolean z2) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "setIsShowingTransparent:".concat(String.valueOf(z2)));
        this.f11916f = z2;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(String str) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "setUnitId:".concat(String.valueOf(str)));
        this.f11924n = str;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void b(String str) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "setNotchArea");
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(c.a aVar) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "setTrackingListener:".concat(String.valueOf(aVar)));
        this.f11928r = aVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public final void a(com.anythink.expressad.videocommon.e.d dVar) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "setSetting:".concat(String.valueOf(dVar)));
        this.f11925o = dVar;
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(int i2, String str) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "statistics,type:" + i2 + ",json:" + str);
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(Activity activity) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "setActivity ");
    }

    @Override // com.anythink.expressad.video.signal.c
    public void a(Context context) {
        com.anythink.expressad.foundation.h.o.a(f11914d, "setViewContext ");
    }
}
