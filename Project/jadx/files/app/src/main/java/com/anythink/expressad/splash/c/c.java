package com.anythink.expressad.splash.c;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.a.b;
import com.anythink.expressad.splash.c.a;
import com.anythink.expressad.splash.c.e;
import com.anythink.expressad.splash.view.ATSplashView;
import com.anythink.expressad.videocommon.b.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f11259c = "SplashLoadManager";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f11260l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f11261m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f11262n = 3;
    private int B;
    com.anythink.expressad.foundation.d.c b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f11265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f11266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.anythink.expressad.splash.b.c f11267h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ATSplashView f11269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.anythink.expressad.d.c f11270k;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f11271o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f11272p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f11273q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f11274r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f11275s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f11276t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f11277u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile boolean f11278v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.anythink.expressad.videocommon.d.b f11279w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private i.d f11280x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f11281y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f11282z;
    private String A = "";
    private Handler C = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.splash.c.c.1
        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                Object obj = message.obj;
                int i3 = message.arg1;
                if (obj instanceof com.anythink.expressad.foundation.d.c) {
                    com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) obj;
                    c.a(c.this, i.a().c(cVar.c()), cVar, i3);
                    return;
                }
                return;
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof com.anythink.expressad.foundation.d.c) {
                    c cVar2 = c.this;
                    cVar2.b((com.anythink.expressad.foundation.d.c) obj2, cVar2.f11276t);
                    return;
                }
                return;
            }
            Object obj3 = message.obj;
            if (obj3 instanceof String) {
                c cVar3 = c.this;
                String string = obj3.toString();
                String unused = c.this.f11275s;
                int unused2 = c.this.f11276t;
                cVar3.a(string);
            }
        }
    };
    private Runnable D = new Runnable() { // from class: com.anythink.expressad.splash.c.c.2
        @Override // java.lang.Runnable
        public final void run() {
            c cVar = c.this;
            String unused = cVar.f11275s;
            int unused2 = c.this.f11276t;
            cVar.a("load timeout");
        }
    };
    boolean a = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Context f11268i = n.a().g();

    /* JADX INFO: renamed from: com.anythink.expressad.splash.c.c$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        AnonymousClass4(com.anythink.expressad.foundation.d.c cVar, int i2) {
            this.a = cVar;
            this.b = i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x008b A[Catch: Exception -> 0x00de, PHI: r0 r4
  0x008b: PHI (r0v4 java.io.FileOutputStream) = (r0v11 java.io.FileOutputStream), (r0v12 java.io.FileOutputStream) binds: [B:32:0x00a0, B:22:0x0089] A[DONT_GENERATE, DONT_INLINE]
  0x008b: PHI (r4v1 java.io.File) = (r4v3 java.io.File), (r4v6 java.io.File) binds: [B:32:0x00a0, B:22:0x0089] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x00de, blocks: (B:45:0x00da, B:46:0x00dd, B:34:0x00a3, B:36:0x00a9, B:38:0x00af, B:40:0x00b5, B:42:0x00cb, B:23:0x008b), top: B:52:0x0001 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 238
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.c.c.AnonymousClass4.run():void");
        }
    }

    public c(String str, String str2, long j2) {
        this.f11264e = str;
        this.f11263d = str2;
        this.f11266g = j2;
    }

    private boolean e() {
        return this.f11271o;
    }

    private int f() {
        return this.f11272p;
    }

    private void g() {
        try {
            this.f11282z++;
            if (this.f11270k == null || this.f11282z > this.f11270k.t()) {
                o.b(f11259c, "onload 重置offset为0");
                this.f11282z = 0;
            }
            o.b(f11259c, "onload 算出 下次的offset是:" + this.f11282z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void h() {
    }

    private void h(com.anythink.expressad.foundation.d.c cVar, int i2) {
        if (this.f11269j.isH5Ready()) {
            return;
        }
        this.f11269j.setH5Ready(true);
        b(cVar, i2);
    }

    private static void i() {
    }

    private void i(com.anythink.expressad.foundation.d.c cVar, int i2) {
        this.f11279w = new AnonymousClass8(cVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        com.anythink.expressad.videocommon.b.e.a().a(this.f11263d, arrayList, com.anythink.expressad.foundation.g.a.aV, this.f11279w);
        if (!com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.f11263d, cVar.A())) {
            com.anythink.expressad.videocommon.b.e.a().d(this.f11263d);
        } else {
            this.f11269j.setVideoReady(true);
            b(cVar, i2);
        }
    }

    private void j() {
        this.f11282z = 0;
    }

    private static void k() {
    }

    private void l() {
        this.C.removeCallbacks(this.D);
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.c.c$7, reason: invalid class name */
    final class AnonymousClass7 implements e.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        AnonymousClass7(com.anythink.expressad.foundation.d.c cVar, int i2) {
            this.a = cVar;
            this.b = i2;
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a() {
            if (this.a.s()) {
                return;
            }
            c.c(c.this, this.a, this.b);
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a(String str) {
            c.this.a(str);
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a(int i2) {
            if (i2 == 1) {
                c.c(c.this, this.a, this.b);
            } else {
                c.this.a("readyState 2");
            }
        }
    }

    private void e(com.anythink.expressad.foundation.d.c cVar, int i2) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass4(cVar, i2));
    }

    private void f(com.anythink.expressad.foundation.d.c cVar, int i2) {
        if (cVar.j()) {
            return;
        }
        this.f11280x = new AnonymousClass5(cVar, i2);
        i.a().b(cVar.c(), (i.a) this.f11280x);
    }

    public final void b(boolean z2) {
        this.f11271o = z2;
    }

    public final com.anythink.expressad.foundation.d.c c() {
        return this.b;
    }

    private void c(com.anythink.expressad.foundation.d.c cVar, int i2) {
        this.f11269j.clearResState();
        if (!TextUtils.isEmpty(cVar.c()) && !cVar.j()) {
            this.f11280x = new AnonymousClass5(cVar, i2);
            i.a().b(cVar.c(), (i.a) this.f11280x);
        }
        if (cVar.j()) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass4(cVar, i2));
        }
        if (!TextUtils.isEmpty(cVar.S())) {
            this.f11279w = new AnonymousClass8(cVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            com.anythink.expressad.videocommon.b.e.a().a(this.f11263d, arrayList, com.anythink.expressad.foundation.g.a.aV, this.f11279w);
            if (!com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.f11263d, cVar.A())) {
                com.anythink.expressad.videocommon.b.e.a().d(this.f11263d);
            } else {
                this.f11269j.setVideoReady(true);
                b(cVar, i2);
            }
        }
        if (TextUtils.isEmpty(cVar.be())) {
            return;
        }
        d(cVar, i2);
    }

    private void d(final com.anythink.expressad.foundation.d.c cVar, final int i2) {
        b.a(this.f11269j, cVar, new com.anythink.expressad.splash.view.a() { // from class: com.anythink.expressad.splash.c.c.3
            @Override // com.anythink.expressad.splash.view.a
            public final void a() {
                if (cVar.j() && c.this.f11269j != null) {
                    c.this.f11269j.setImageReady(true);
                    c.b(c.this, cVar, i2);
                }
                c.this.b(cVar, i2);
            }

            @Override // com.anythink.expressad.splash.view.a
            public final void b() {
                if (!cVar.j() || c.this.f11269j == null) {
                    return;
                }
                c.this.f11269j.setImageReady(false);
                c cVar2 = c.this;
                String unused = cVar2.f11275s;
                cVar2.a("Image resource load faile");
            }
        });
    }

    public final void b(int i2) {
        this.f11272p = i2;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.c.c$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.expressad.splash.b.a {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        AnonymousClass6(com.anythink.expressad.foundation.d.c cVar, int i2) {
            this.a = cVar;
            this.b = i2;
        }

        @Override // com.anythink.expressad.splash.b.a
        public final void a(View view) {
            if (c.this.f11269j != null) {
                c.this.f11269j.setDynamicView(true);
                c.this.f11269j.setSplashNativeView(view);
                c.this.b(this.a, this.b);
            }
        }

        @Override // com.anythink.expressad.splash.b.a
        public final void a(String str) {
            c cVar = c.this;
            String unused = cVar.f11275s;
            cVar.a(str);
        }
    }

    public final void a(int i2) {
        this.B = i2;
    }

    public final void b() {
        if (this.f11267h != null) {
            this.f11267h = null;
        }
        if (this.f11279w != null) {
            this.f11279w = null;
        }
        if (this.f11280x != null) {
            this.f11280x = null;
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.c.c$5, reason: invalid class name */
    final class AnonymousClass5 implements i.d {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;

        AnonymousClass5(com.anythink.expressad.foundation.d.c cVar, int i2) {
            this.a = cVar;
            this.b = i2;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = this.a;
            messageObtain.arg1 = this.b;
            c.this.C.sendMessage(messageObtain);
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            c cVar = c.this;
            String unused = cVar.f11275s;
            cVar.a(str);
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.obj = str;
            c.this.C.sendMessage(messageObtain);
        }
    }

    public final void a(boolean z2) {
        this.a = z2;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.splash.c.c$8, reason: invalid class name */
    final class AnonymousClass8 implements com.anythink.expressad.videocommon.d.b {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;

        AnonymousClass8(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str) {
            c.this.f11269j.setVideoReady(true);
            o.a(c.f11259c, "========VIDEO SUC");
            Message messageObtain = Message.obtain();
            messageObtain.obj = this.a;
            messageObtain.what = 3;
            c.this.C.sendMessage(messageObtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str, String str2) {
            c.this.f11269j.setVideoReady(false);
            o.a(c.f11259c, "========VIDEO FAI");
            Message messageObtain = Message.obtain();
            messageObtain.obj = str;
            messageObtain.what = 2;
            c.this.C.sendMessage(messageObtain);
        }
    }

    public final void a(com.anythink.expressad.d.c cVar) {
        this.f11270k = cVar;
    }

    private void g(com.anythink.expressad.foundation.d.c cVar, int i2) {
        if (cVar.j()) {
            b.a aVar = new b.a();
            aVar.b(this.f11263d).a(this.f11264e).a(this.f11271o).a(cVar).a(this.f11272p).h(this.B);
            try {
                if (!TextUtils.isEmpty(cVar.c())) {
                    Uri uri = Uri.parse(cVar.c());
                    String queryParameter = uri.getQueryParameter("hdbtn");
                    String queryParameter2 = uri.getQueryParameter(com.anythink.expressad.video.dynview.a.a.Q);
                    String queryParameter3 = uri.getQueryParameter("hdinfo");
                    String queryParameter4 = uri.getQueryParameter("shake_show");
                    String queryParameter5 = uri.getQueryParameter("shake_strength");
                    String queryParameter6 = uri.getQueryParameter("shake_time");
                    String queryParameter7 = uri.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th) {
                o.d(f11259c, th.getMessage());
            }
            a unused = a.C0218a.a;
            a.a(this.f11269j, new com.anythink.expressad.splash.a.b(aVar), new AnonymousClass6(cVar, i2));
        }
    }

    public final void a(ATSplashView aTSplashView) {
        this.f11269j = aTSplashView;
    }

    public final void a(int i2, int i3) {
        this.f11274r = i2;
        this.f11273q = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.expressad.foundation.d.c cVar, int i2) {
        if (!b.a(this.f11269j, cVar) || this.f11278v) {
            return;
        }
        l();
        this.b = cVar;
        this.f11278v = true;
        com.anythink.expressad.splash.b.c cVar2 = this.f11267h;
        if (cVar2 != null) {
            cVar2.a(cVar, i2);
        }
    }

    public final String a() {
        return this.A;
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        ArrayList arrayList;
        this.f11278v = false;
        this.f11275s = "";
        this.f11276t = 2;
        if (dVar == null || dVar.J == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
            cVar.l(this.f11263d);
            this.f11281y = dVar.c();
            if (cVar.O() != 99 && (!TextUtils.isEmpty(cVar.c()) || !TextUtils.isEmpty(cVar.d()))) {
                if (t.a(cVar)) {
                    cVar.i(t.a(this.f11268i, cVar.ba()) ? 1 : 2);
                }
                if (cVar.ae() == 1 || !t.a(this.f11268i, cVar.ba()) || t.a(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            g();
            o.b(f11259c, "onload load成功 size:" + arrayList.size());
            com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) arrayList.get(0);
            if (TextUtils.isEmpty(cVar2.c()) && (TextUtils.isEmpty(cVar2.d()) || !cVar2.d().contains("<MBTPLMARK>"))) {
                cVar2.a(false);
                cVar2.b(true);
            } else {
                cVar2.a(true);
                cVar2.b(false);
            }
            ATSplashView aTSplashView = this.f11269j;
            if (aTSplashView != null) {
                aTSplashView.setDynamicView(false);
            }
            if (cVar2.j()) {
                d(cVar2, 2);
            }
            if (b.a(this.f11269j, cVar2)) {
                b(cVar2, 2);
                return;
            }
            this.f11269j.clearResState();
            if (!TextUtils.isEmpty(cVar2.c()) && !cVar2.j()) {
                this.f11280x = new AnonymousClass5(cVar2, 2);
                i.a().b(cVar2.c(), (i.a) this.f11280x);
            }
            if (cVar2.j()) {
                return;
            }
            if (!TextUtils.isEmpty(cVar2.d())) {
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass4(cVar2, 2));
            }
            if (!TextUtils.isEmpty(cVar2.S())) {
                this.f11279w = new AnonymousClass8(cVar2);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(cVar2);
                com.anythink.expressad.videocommon.b.e.a().a(this.f11263d, arrayList2, com.anythink.expressad.foundation.g.a.aV, this.f11279w);
                if (!com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.f11263d, cVar2.A())) {
                    com.anythink.expressad.videocommon.b.e.a().d(this.f11263d);
                } else {
                    this.f11269j.setVideoReady(true);
                    b(cVar2, 2);
                }
            }
            if (TextUtils.isEmpty(cVar2.be())) {
                return;
            }
            d(cVar2, 2);
            return;
        }
        o.b(f11259c, "onload load失败 返回的compaign没有可以用的");
        a("invalid  campaign");
    }

    private void b(String str) {
        if (this.f11278v) {
            return;
        }
        l();
        o.d(f11259c, "real failed ");
        this.f11278v = true;
        com.anythink.expressad.splash.b.c cVar = this.f11267h;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    private List<com.anythink.expressad.foundation.d.c> b(com.anythink.expressad.foundation.d.d dVar) {
        if (dVar == null || dVar.J == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
        cVar.l(this.f11263d);
        this.f11281y = dVar.c();
        if (cVar.O() == 99) {
            return arrayList;
        }
        if (TextUtils.isEmpty(cVar.c()) && TextUtils.isEmpty(cVar.d())) {
            return arrayList;
        }
        if (t.a(cVar)) {
            cVar.i(t.a(this.f11268i, cVar.ba()) ? 1 : 2);
        }
        if (cVar.ae() != 1 && t.a(this.f11268i, cVar.ba())) {
            if (!t.a(cVar)) {
                return arrayList;
            }
            arrayList.add(cVar);
            return arrayList;
        }
        arrayList.add(cVar);
        return arrayList;
    }

    private void c(String str) {
        a(str);
    }

    static /* synthetic */ void c(c cVar, com.anythink.expressad.foundation.d.c cVar2, int i2) {
        if (cVar.f11269j.isH5Ready()) {
            return;
        }
        cVar.f11269j.setH5Ready(true);
        cVar.b(cVar2, i2);
    }

    static /* synthetic */ void b(c cVar, com.anythink.expressad.foundation.d.c cVar2, int i2) {
        if (cVar2.j()) {
            b.a aVar = new b.a();
            aVar.b(cVar.f11263d).a(cVar.f11264e).a(cVar.f11271o).a(cVar2).a(cVar.f11272p).h(cVar.B);
            try {
                if (!TextUtils.isEmpty(cVar2.c())) {
                    Uri uri = Uri.parse(cVar2.c());
                    String queryParameter = uri.getQueryParameter("hdbtn");
                    String queryParameter2 = uri.getQueryParameter(com.anythink.expressad.video.dynview.a.a.Q);
                    String queryParameter3 = uri.getQueryParameter("hdinfo");
                    String queryParameter4 = uri.getQueryParameter("shake_show");
                    String queryParameter5 = uri.getQueryParameter("shake_strength");
                    String queryParameter6 = uri.getQueryParameter("shake_time");
                    String queryParameter7 = uri.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th) {
                o.d(f11259c, th.getMessage());
            }
            a unused = a.C0218a.a;
            a.a(cVar.f11269j, new com.anythink.expressad.splash.a.b(aVar), cVar.new AnonymousClass6(cVar2, i2));
        }
    }

    private void a(long j2) {
        this.C.postDelayed(this.D, j2);
    }

    public final void a(com.anythink.expressad.splash.b.c cVar) {
        this.f11267h = cVar;
    }

    private void a(com.anythink.expressad.foundation.d.c cVar, int i2) {
        ATSplashView aTSplashView = this.f11269j;
        if (aTSplashView != null) {
            aTSplashView.setDynamicView(false);
        }
        if (cVar.j()) {
            d(cVar, i2);
        }
        if (b.a(this.f11269j, cVar)) {
            b(cVar, i2);
            return;
        }
        this.f11269j.clearResState();
        if (!TextUtils.isEmpty(cVar.c()) && !cVar.j()) {
            this.f11280x = new AnonymousClass5(cVar, i2);
            i.a().b(cVar.c(), (i.a) this.f11280x);
        }
        if (cVar.j()) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass4(cVar, i2));
        }
        if (!TextUtils.isEmpty(cVar.S())) {
            this.f11279w = new AnonymousClass8(cVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            com.anythink.expressad.videocommon.b.e.a().a(this.f11263d, arrayList, com.anythink.expressad.foundation.g.a.aV, this.f11279w);
            if (!com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.f11263d, cVar.A())) {
                com.anythink.expressad.videocommon.b.e.a().d(this.f11263d);
            } else {
                this.f11269j.setVideoReady(true);
                b(cVar, i2);
            }
        }
        if (TextUtils.isEmpty(cVar.be())) {
            return;
        }
        d(cVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f11277u) {
            this.f11277u = false;
        } else {
            b(str);
        }
    }

    private void a(String str, com.anythink.expressad.foundation.d.c cVar, int i2) {
        e.c cVar2 = new e.c();
        cVar2.c(this.f11263d);
        cVar2.b(this.f11264e);
        cVar2.a(cVar);
        cVar2.a(str);
        cVar2.b(this.f11271o);
        cVar2.a(this.f11272p);
        cVar2.a(this.a);
        e.a.a.a(this.f11269j, cVar2, new AnonymousClass7(cVar, i2));
    }

    private void a(com.anythink.expressad.foundation.d.d dVar, int i2) {
        ArrayList arrayList;
        if (dVar == null || dVar.J == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            com.anythink.expressad.foundation.d.c cVar = dVar.J.get(0);
            cVar.l(this.f11263d);
            this.f11281y = dVar.c();
            if (cVar.O() != 99 && (!TextUtils.isEmpty(cVar.c()) || !TextUtils.isEmpty(cVar.d()))) {
                if (t.a(cVar)) {
                    cVar.i(t.a(this.f11268i, cVar.ba()) ? 1 : 2);
                }
                if (cVar.ae() == 1 || !t.a(this.f11268i, cVar.ba()) || t.a(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            g();
            o.b(f11259c, "onload load成功 size:" + arrayList.size());
            com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) arrayList.get(0);
            if (TextUtils.isEmpty(cVar2.c()) && (TextUtils.isEmpty(cVar2.d()) || !cVar2.d().contains("<MBTPLMARK>"))) {
                cVar2.a(false);
                cVar2.b(true);
            } else {
                cVar2.a(true);
                cVar2.b(false);
            }
            ATSplashView aTSplashView = this.f11269j;
            if (aTSplashView != null) {
                aTSplashView.setDynamicView(false);
            }
            if (cVar2.j()) {
                d(cVar2, i2);
            }
            if (b.a(this.f11269j, cVar2)) {
                b(cVar2, i2);
                return;
            }
            this.f11269j.clearResState();
            if (!TextUtils.isEmpty(cVar2.c()) && !cVar2.j()) {
                this.f11280x = new AnonymousClass5(cVar2, i2);
                i.a().b(cVar2.c(), (i.a) this.f11280x);
            }
            if (cVar2.j()) {
                return;
            }
            if (!TextUtils.isEmpty(cVar2.d())) {
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass4(cVar2, i2));
            }
            if (!TextUtils.isEmpty(cVar2.S())) {
                this.f11279w = new AnonymousClass8(cVar2);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(cVar2);
                com.anythink.expressad.videocommon.b.e.a().a(this.f11263d, arrayList2, com.anythink.expressad.foundation.g.a.aV, this.f11279w);
                if (!com.anythink.expressad.videocommon.b.e.a().a(com.anythink.expressad.foundation.g.a.aV, this.f11263d, cVar2.A())) {
                    com.anythink.expressad.videocommon.b.e.a().d(this.f11263d);
                } else {
                    this.f11269j.setVideoReady(true);
                    b(cVar2, i2);
                }
            }
            if (TextUtils.isEmpty(cVar2.be())) {
                return;
            }
            d(cVar2, i2);
            return;
        }
        o.b(f11259c, "onload load失败 返回的compaign没有可以用的");
        a("invalid  campaign");
    }

    static /* synthetic */ void a(c cVar, String str, com.anythink.expressad.foundation.d.c cVar2, int i2) {
        e.c cVar3 = new e.c();
        cVar3.c(cVar.f11263d);
        cVar3.b(cVar.f11264e);
        cVar3.a(cVar2);
        cVar3.a(str);
        cVar3.b(cVar.f11271o);
        cVar3.a(cVar.f11272p);
        cVar3.a(cVar.a);
        e.a.a.a(cVar.f11269j, cVar3, cVar.new AnonymousClass7(cVar2, i2));
    }
}
