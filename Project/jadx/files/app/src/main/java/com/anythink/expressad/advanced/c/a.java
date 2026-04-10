package com.anythink.expressad.advanced.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.advanced.view.ATNativeAdvancedView;
import com.anythink.expressad.advanced.view.ATNativeAdvancedWebview;
import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.videocommon.b.i;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static String a = "NativeAdvancedLoadManager";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f8143j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f8144k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f8145l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f8146m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f8147n = 5;
    private int A;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.anythink.expressad.advanced.b.a f8150e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ATNativeAdvancedView f8152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.anythink.expressad.d.c f8153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f8154i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f8155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8157q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f8158r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f8159s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8160t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile boolean f8162v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.anythink.expressad.videocommon.d.b f8163w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private i.d f8164x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private i.d f8165y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f8166z;
    private String B = "";
    private Handler C = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.advanced.c.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                Object obj2 = message.obj;
                int i3 = message.arg1;
                if (obj2 == null || !(obj2 instanceof com.anythink.expressad.foundation.d.c)) {
                    return;
                }
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) obj2;
                a.a(a.this, i.a().c(cVar.c()), cVar, i3);
                return;
            }
            if (i2 == 2) {
                Object obj3 = message.obj;
                if (obj3 == null || !(obj3 instanceof String)) {
                    return;
                }
                a aVar = a.this;
                String string = obj3.toString();
                String unused = a.this.f8159s;
                aVar.b(string, a.this.f8160t);
                return;
            }
            if (i2 == 3) {
                Object obj4 = message.obj;
                if (obj4 == null || !(obj4 instanceof com.anythink.expressad.foundation.d.c)) {
                    return;
                }
                a aVar2 = a.this;
                aVar2.a((com.anythink.expressad.foundation.d.c) obj4, aVar2.f8160t);
                return;
            }
            if (i2 != 4) {
                if (i2 == 5 && (obj = message.obj) != null && (obj instanceof com.anythink.expressad.foundation.d.c)) {
                    if (a.this.f8152g != null) {
                        a.this.f8152g.setVideoReady(true);
                    }
                    a aVar3 = a.this;
                    aVar3.a((com.anythink.expressad.foundation.d.c) obj, aVar3.f8160t);
                    return;
                }
                return;
            }
            Object obj5 = message.obj;
            if (obj5 == null || !(obj5 instanceof com.anythink.expressad.foundation.d.c)) {
                return;
            }
            if (a.this.f8152g != null) {
                a.this.f8152g.setEndCardReady(true);
            }
            a aVar4 = a.this;
            aVar4.a((com.anythink.expressad.foundation.d.c) obj5, aVar4.f8160t);
        }
    };
    private Runnable D = new Runnable() { // from class: com.anythink.expressad.advanced.c.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            String unused = aVar.f8159s;
            aVar.b("load timeout", a.this.f8160t);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f8151f = n.a().g();

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.c.a$10, reason: invalid class name */
    final class AnonymousClass10 implements Runnable {
        final /* synthetic */ ATNativeAdvancedWebview a;
        final /* synthetic */ String b;

        AnonymousClass10(ATNativeAdvancedWebview aTNativeAdvancedWebview, String str) {
            this.a = aTNativeAdvancedWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.loadUrl(x.c(this.b));
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.c.a$7, reason: invalid class name */
    final class AnonymousClass7 implements Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        AnonymousClass7(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x008c A[Catch: Exception -> 0x00f3, PHI: r0 r4
  0x008c: PHI (r0v4 java.io.FileOutputStream) = (r0v13 java.io.FileOutputStream), (r0v14 java.io.FileOutputStream) binds: [B:32:0x00a1, B:22:0x008a] A[DONT_GENERATE, DONT_INLINE]
  0x008c: PHI (r4v1 java.io.File) = (r4v3 java.io.File), (r4v6 java.io.File) binds: [B:32:0x00a1, B:22:0x008a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x00f3, blocks: (B:45:0x00ef, B:46:0x00f2, B:34:0x00a4, B:36:0x00aa, B:38:0x00b0, B:40:0x00b6, B:42:0x00d5, B:23:0x008c), top: B:56:0x0001 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.advanced.c.a.AnonymousClass7.run():void");
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.c.a$9, reason: invalid class name */
    final class AnonymousClass9 extends com.anythink.expressad.atsignalcommon.a.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        AnonymousClass9(com.anythink.expressad.foundation.d.c cVar, int i2) {
            this.a = cVar;
            this.b = i2;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            o.d("NativeAdvancedLoadManager", "onPageFinished");
            if (!this.a.s()) {
                a.this.f8152g.setH5Ready(true);
                o.d("NativeAdvancedLoadManager", "=======onPageFinished OK");
                com.anythink.expressad.advanced.a.a.a(this.a.Z());
                a.b(a.this, this.a, this.b);
            }
            NativeAdvancedJsUtils.fireOnJSBridgeConnected(webView);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            o.d("NativeAdvancedLoadManager", "onReceivedError： " + i2 + "  " + str + "  " + str2);
            a.this.b(str, this.b);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            o.d("NativeAdvancedLoadManager", "onReceivedSslError: " + sslError.getPrimaryError());
            a.this.b("onReceivedSslError:" + sslError.getUrl(), this.b);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i2) {
            super.readyState(webView, i2);
            o.d("NativeAdvancedLoadManager", "=========readyState: ".concat(String.valueOf(i2)));
            if (i2 != 1) {
                a.this.b("readyState 2", this.b);
                return;
            }
            a.this.f8152g.setH5Ready(true);
            com.anythink.expressad.advanced.a.a.a(this.a.Z());
            a.b(a.this, this.a, this.b);
        }
    }

    public a(String str, String str2) {
        this.f8148c = str;
        this.b = str2;
    }

    private int e() {
        return this.f8156p;
    }

    private void f() {
        try {
            this.A++;
            if (this.f8153h == null || this.A > this.f8153h.t()) {
                o.b(a, "onload 重置offset为0");
                this.A = 0;
            }
            o.b(a, "onload 算出 下次的offset是:" + this.A);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void g() {
    }

    private void g(com.anythink.expressad.foundation.d.c cVar) {
        this.f8164x = new AnonymousClass8(cVar);
        i.a().b(cVar.c(), (i.a) this.f8164x);
    }

    private void h() {
        this.A = 0;
    }

    private void i() {
        this.C.removeCallbacks(this.D);
    }

    private static void j() {
    }

    private void b(int i2) {
        this.f8156p = i2;
    }

    private void e(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new AnonymousClass6(cVar));
    }

    private void h(com.anythink.expressad.foundation.d.c cVar) {
        this.f8163w = new AnonymousClass2(cVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        e.a().a(this.b, arrayList, com.anythink.expressad.foundation.g.a.aX, this.f8163w);
        if (!e.a().a(com.anythink.expressad.foundation.g.a.aX, this.b, cVar.A())) {
            o.a(a, " load Video");
            e.a().d(this.b);
        } else {
            o.a(a, " load Video isReady true");
            this.f8152g.setVideoReady(true);
            a(cVar, 2);
        }
    }

    public final com.anythink.expressad.foundation.d.c c() {
        return this.f8154i;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.c.a$4, reason: invalid class name */
    final class AnonymousClass4 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        AnonymousClass4(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            o.a(a.a, "giturl 下载成功： ".concat(String.valueOf(str)));
            if (a.this.C != null) {
                a.this.C.post(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        a.this.a(anonymousClass4.a, anonymousClass4.b);
                    }
                });
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            o.a(a.a, "gifurl 下载失败： ".concat(String.valueOf(str2)));
            if (a.this.C != null) {
                a.this.C.post(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.4.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        a.this.a(anonymousClass4.a, anonymousClass4.b);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.c.a$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        AnonymousClass6(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            o.a(a.a, "image 下载成功： ".concat(String.valueOf(str)));
            if (a.this.C != null) {
                a.this.C.post(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.6.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        a.this.a(anonymousClass6.a, anonymousClass6.b);
                    }
                });
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            o.a(a.a, "image 下载失败： ".concat(String.valueOf(str2)));
            if (a.this.C != null) {
                a.this.C.post(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.6.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        a.this.a(anonymousClass6.a, anonymousClass6.b);
                    }
                });
            }
        }
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.y(), new AnonymousClass4(cVar));
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        this.f8165y = new AnonymousClass5(cVar);
        i.a().b(cVar.I(), (i.a) this.f8165y);
    }

    public final void a(com.anythink.expressad.d.c cVar) {
        this.f8153h = cVar;
    }

    public final void b() {
        if (this.f8150e != null) {
            this.f8150e = null;
        }
        b("LoadManager release", this.f8160t);
        if (this.f8163w != null) {
            this.f8163w = null;
        }
        if (this.f8164x != null) {
            this.f8164x = null;
        }
    }

    private void c(String str, int i2) {
        b(str, i2);
    }

    public final void a(ATNativeAdvancedView aTNativeAdvancedView) {
        this.f8152g = aTNativeAdvancedView;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.c.a$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.expressad.videocommon.d.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;

        AnonymousClass2(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str) {
            o.a(a.a, "Video 下载成功： ".concat(String.valueOf(str)));
            Message messageObtain = Message.obtain();
            messageObtain.obj = this.a;
            messageObtain.what = 5;
            a.this.C.sendMessage(messageObtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str, String str2) {
            o.a(a.a, "Video 下载失败： ".concat(String.valueOf(str)));
            Message messageObtain = Message.obtain();
            messageObtain.obj = str;
            messageObtain.what = 2;
            a.this.C.sendMessage(messageObtain);
        }
    }

    public final void a(int i2) {
        this.f8155o = i2;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.c.a$8, reason: invalid class name */
    final class AnonymousClass8 implements i.d {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        AnonymousClass8(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            o.a(a.a, "zip 下载成功： ".concat(String.valueOf(str)));
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = this.a;
            messageObtain.arg1 = this.b;
            a.this.C.sendMessage(messageObtain);
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            o.a(a.a, "zip 下载失败： " + str2 + " " + str);
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.obj = str;
            a.this.C.sendMessage(messageObtain);
        }
    }

    public final void a(int i2, int i3) {
        this.f8158r = i2;
        this.f8157q = i3;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.advanced.c.a$5, reason: invalid class name */
    final class AnonymousClass5 implements i.d {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b = 2;

        AnonymousClass5(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            o.a(a.a, "endcard 下载成功： ".concat(String.valueOf(str)));
            if (a.this.C != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 4;
                messageObtain.obj = this.a;
                messageObtain.arg1 = this.b;
                a.this.C.sendMessage(messageObtain);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            o.a(a.a, "endcard 下载失败： ".concat(String.valueOf(str2)));
            if (a.this.f8152g != null) {
                a.this.f8152g.setEndCardReady(false);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.obj = str;
            a.this.C.sendMessage(messageObtain);
        }
    }

    private void f(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass7(cVar));
    }

    private void a(long j2) {
        this.C.postDelayed(this.D, j2);
    }

    public final String a() {
        return this.B;
    }

    public final void a(com.anythink.expressad.advanced.b.a aVar) {
        this.f8150e = aVar;
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        this.f8154i = cVar;
        if (c.a(this.f8152g, cVar)) {
            a(cVar, 2);
            return;
        }
        ATNativeAdvancedView aTNativeAdvancedView = this.f8152g;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(cVar.c())) {
            o.a(a, "开始下载zip： " + cVar.c());
            this.f8164x = new AnonymousClass8(cVar);
            i.a().b(cVar.c(), (i.a) this.f8164x);
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            o.a(a, "开始下载HTML： " + cVar.d());
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass7(cVar));
        }
        if (!TextUtils.isEmpty(cVar.S())) {
            o.a(a, "开始下载Video： " + cVar.S());
            this.f8163w = new AnonymousClass2(cVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            e.a().a(this.b, arrayList, com.anythink.expressad.foundation.g.a.aX, this.f8163w);
            if (!e.a().a(com.anythink.expressad.foundation.g.a.aX, this.b, cVar.A())) {
                o.a(a, " load Video");
                e.a().d(this.b);
            } else {
                o.a(a, " load Video isReady true");
                this.f8152g.setVideoReady(true);
                a(cVar, 2);
            }
        }
        if (!TextUtils.isEmpty(cVar.be())) {
            o.a(a, "开始下载image： " + cVar.be());
            com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new AnonymousClass6(cVar));
        }
        if (!TextUtils.isEmpty(cVar.I())) {
            o.a(a, "开始下载EndCard： " + cVar.I());
            this.f8165y = new AnonymousClass5(cVar);
            i.a().b(cVar.I(), (i.a) this.f8165y);
        }
        if (TextUtils.isEmpty(cVar.y())) {
            return;
        }
        o.a(a, "开始下载gitUrl： " + cVar.y());
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.y(), new AnonymousClass4(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i2) {
        if (this.f8162v) {
            return;
        }
        i();
        o.d(a, "real failed: ".concat(String.valueOf(str)));
        this.f8162v = true;
        com.anythink.expressad.advanced.b.a aVar = this.f8150e;
        if (aVar != null) {
            aVar.a(str, i2);
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        ATNativeAdvancedView aTNativeAdvancedView = this.f8152g;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(cVar.c())) {
            o.a(a, "开始下载zip： " + cVar.c());
            this.f8164x = new AnonymousClass8(cVar);
            i.a().b(cVar.c(), (i.a) this.f8164x);
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            o.a(a, "开始下载HTML： " + cVar.d());
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass7(cVar));
        }
        if (!TextUtils.isEmpty(cVar.S())) {
            o.a(a, "开始下载Video： " + cVar.S());
            this.f8163w = new AnonymousClass2(cVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            e.a().a(this.b, arrayList, com.anythink.expressad.foundation.g.a.aX, this.f8163w);
            if (!e.a().a(com.anythink.expressad.foundation.g.a.aX, this.b, cVar.A())) {
                o.a(a, " load Video");
                e.a().d(this.b);
            } else {
                o.a(a, " load Video isReady true");
                this.f8152g.setVideoReady(true);
                a(cVar, 2);
            }
        }
        if (!TextUtils.isEmpty(cVar.be())) {
            o.a(a, "开始下载image： " + cVar.be());
            com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new AnonymousClass6(cVar));
        }
        if (!TextUtils.isEmpty(cVar.I())) {
            o.a(a, "开始下载EndCard： " + cVar.I());
            this.f8165y = new AnonymousClass5(cVar);
            i.a().b(cVar.I(), (i.a) this.f8165y);
        }
        if (TextUtils.isEmpty(cVar.y())) {
            return;
        }
        o.a(a, "开始下载gitUrl： " + cVar.y());
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.y(), new AnonymousClass4(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.expressad.foundation.d.c cVar, int i2) {
        if (!c.a(this.f8152g, cVar) || this.f8162v) {
            return;
        }
        i();
        this.f8162v = true;
        com.anythink.expressad.advanced.b.a aVar = this.f8150e;
        if (aVar != null) {
            aVar.a(cVar, i2);
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, int i2) {
        if (this.f8152g.isH5Ready()) {
            a(cVar, i2);
        }
    }

    private void a(String str, int i2) {
        b(str, i2);
    }

    private List<com.anythink.expressad.foundation.d.c> b(d dVar) {
        if (dVar == null || dVar.J == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
        cVar.l(this.b);
        this.f8166z = dVar.c();
        if (cVar.O() == 99) {
            return arrayList;
        }
        if (TextUtils.isEmpty(cVar.c()) && TextUtils.isEmpty(cVar.d())) {
            return arrayList;
        }
        if (t.a(cVar)) {
            cVar.i(t.a(this.f8151f, cVar.ba()) ? 1 : 2);
        }
        if (cVar.ae() != 1 && t.a(this.f8151f, cVar.ba())) {
            o.d(a, "onload： " + cVar.bb() + " has been installed.");
            if (!t.a(cVar)) {
                return arrayList;
            }
            arrayList.add(cVar);
            return arrayList;
        }
        arrayList.add(cVar);
        return arrayList;
    }

    private void a(String str, com.anythink.expressad.foundation.d.c cVar, int i2) {
        ATNativeAdvancedView aTNativeAdvancedView = this.f8152g;
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new NativeAdvancedJSBridgeImpl(this.f8152g.getContext(), this.f8148c, this.b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(this.f8155o);
        nativeAdvancedJSBridgeImpl.setCountdownS(this.f8156p);
        this.f8152g.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        System.currentTimeMillis();
        ATNativeAdvancedWebview advancedNativeWebview = this.f8152g.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            b("webview is null", i2);
            return;
        }
        if (advancedNativeWebview != null && advancedNativeWebview.isDestroyed()) {
            b("webview is destroyed", i2);
            return;
        }
        advancedNativeWebview.setWebViewListener(new AnonymousClass9(cVar, i2));
        if (!advancedNativeWebview.isDestroyed()) {
            o.d(a, "=======开始渲染: ".concat(String.valueOf(str)));
            Handler handler = this.C;
            if (handler != null) {
                handler.post(new AnonymousClass10(advancedNativeWebview, str));
                return;
            }
            return;
        }
        b("webview has destory", i2);
    }

    static /* synthetic */ void b(a aVar, com.anythink.expressad.foundation.d.c cVar, int i2) {
        if (aVar.f8152g.isH5Ready()) {
            aVar.a(cVar, i2);
        }
    }

    public final String a(String str) {
        int iK;
        if (this.f8154i == null) {
            return "";
        }
        try {
            com.anythink.expressad.videocommon.b.c cVarA = e.a().a(this.b, this.f8154i.aZ() + this.f8154i.S() + this.f8154i.B());
            if (cVarA == null || (iK = cVarA.k()) != 5) {
                return str;
            }
            String strE = cVarA.e();
            if (!new File(strE).exists()) {
                return str;
            }
            o.d(a, "本地已下载完 拿本地播放地址：" + strE + " state：" + iK);
            return strE;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final void a(d dVar) {
        ArrayList arrayList;
        if (dVar == null || dVar.J == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
            cVar.l(this.b);
            this.f8166z = dVar.c();
            if (cVar.O() != 99 && (!TextUtils.isEmpty(cVar.c()) || !TextUtils.isEmpty(cVar.d()))) {
                if (t.a(cVar)) {
                    cVar.i(t.a(this.f8151f, cVar.ba()) ? 1 : 2);
                }
                if (cVar.ae() != 1 && t.a(this.f8151f, cVar.ba())) {
                    o.d(a, "onload： " + cVar.bb() + " has been installed.");
                    if (t.a(cVar)) {
                        arrayList.add(cVar);
                    }
                } else {
                    arrayList.add(cVar);
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            try {
                this.A++;
                if (this.f8153h == null || this.A > this.f8153h.t()) {
                    o.b(a, "onload 重置offset为0");
                    this.A = 0;
                }
                o.b(a, "onload 算出 下次的offset是:" + this.A);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            o.b(a, "onload load成功 size:" + arrayList.size());
            com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) arrayList.get(0);
            if (TextUtils.isEmpty(cVar2.c()) && (TextUtils.isEmpty(cVar2.d()) || !cVar2.d().contains("<MBTPLMARK>"))) {
                cVar2.a(false);
                cVar2.b(true);
            } else {
                cVar2.a(true);
                cVar2.b(false);
            }
            this.f8154i = cVar2;
            if (c.a(this.f8152g, cVar2)) {
                a(cVar2, 2);
                return;
            }
            ATNativeAdvancedView aTNativeAdvancedView = this.f8152g;
            if (aTNativeAdvancedView != null) {
                aTNativeAdvancedView.clearResState();
            }
            if (!TextUtils.isEmpty(cVar2.c())) {
                o.a(a, "开始下载zip： " + cVar2.c());
                this.f8164x = new AnonymousClass8(cVar2);
                i.a().b(cVar2.c(), (i.a) this.f8164x);
            }
            if (!TextUtils.isEmpty(cVar2.d())) {
                o.a(a, "开始下载HTML： " + cVar2.d());
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass7(cVar2));
            }
            if (!TextUtils.isEmpty(cVar2.S())) {
                o.a(a, "开始下载Video： " + cVar2.S());
                this.f8163w = new AnonymousClass2(cVar2);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(cVar2);
                e.a().a(this.b, arrayList2, com.anythink.expressad.foundation.g.a.aX, this.f8163w);
                if (!e.a().a(com.anythink.expressad.foundation.g.a.aX, this.b, cVar2.A())) {
                    o.a(a, " load Video");
                    e.a().d(this.b);
                } else {
                    o.a(a, " load Video isReady true");
                    this.f8152g.setVideoReady(true);
                    a(cVar2, 2);
                }
            }
            if (!TextUtils.isEmpty(cVar2.be())) {
                o.a(a, "开始下载image： " + cVar2.be());
                com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar2.be(), new AnonymousClass6(cVar2));
            }
            if (!TextUtils.isEmpty(cVar2.I())) {
                o.a(a, "开始下载EndCard： " + cVar2.I());
                this.f8165y = new AnonymousClass5(cVar2);
                i.a().b(cVar2.I(), (i.a) this.f8165y);
            }
            if (TextUtils.isEmpty(cVar2.y())) {
                return;
            }
            o.a(a, "开始下载gitUrl： " + cVar2.y());
            com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar2.y(), new AnonymousClass4(cVar2));
            return;
        }
        o.b(a, "onload load失败 返回的compaign没有可以用的");
        b("invalid  campaign", 2);
    }

    static /* synthetic */ void a(a aVar, String str, com.anythink.expressad.foundation.d.c cVar, int i2) {
        ATNativeAdvancedView aTNativeAdvancedView = aVar.f8152g;
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new NativeAdvancedJSBridgeImpl(aVar.f8152g.getContext(), aVar.f8148c, aVar.b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(aVar.f8155o);
        nativeAdvancedJSBridgeImpl.setCountdownS(aVar.f8156p);
        aVar.f8152g.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        System.currentTimeMillis();
        ATNativeAdvancedWebview advancedNativeWebview = aVar.f8152g.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            aVar.b("webview is null", i2);
            return;
        }
        if (advancedNativeWebview != null && advancedNativeWebview.isDestroyed()) {
            aVar.b("webview is destroyed", i2);
            return;
        }
        advancedNativeWebview.setWebViewListener(aVar.new AnonymousClass9(cVar, i2));
        if (!advancedNativeWebview.isDestroyed()) {
            o.d(a, "=======开始渲染: ".concat(String.valueOf(str)));
            Handler handler = aVar.C;
            if (handler != null) {
                handler.post(aVar.new AnonymousClass10(advancedNativeWebview, str));
                return;
            }
            return;
        }
        aVar.b("webview has destory", i2);
    }
}
