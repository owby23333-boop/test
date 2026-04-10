package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final String a = "LoadRemoteDex";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static z f13258i;
    private IXAdContainerFactory b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private bl f13259c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f13262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f13263g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f13266k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13260d = 5000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f13261e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private bq f13264h = bq.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AtomicBoolean f13265j = new AtomicBoolean(false);

    public interface a {
        public static final int a = 1;
        public static final int b = 2;

        void onFailure();

        void onSuccess();
    }

    private z() {
    }

    private void f() {
        this.f13265j.set(true);
        if (an.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (z.class) {
            try {
                this.f13259c = new bl(Class.forName(w.aC, true, getClass().getClassLoader()), this.f13263g);
                this.b = this.f13259c.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f13262f = new aa(this);
        j();
        if (f.a == null) {
            synchronized (bw.class) {
                if (f.a == null) {
                    f.a = new bw(this.f13263g);
                }
            }
        }
        if (this.b != null) {
            k();
            return;
        }
        if (f.a == null) {
            this.f13264h.a(a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
            return;
        }
        this.f13264h.a(a, "start load apk");
        try {
            f.a.a(new ab(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void i() {
        Runnable runnable = this.f13262f;
        if (runnable != null) {
            this.f13261e.removeCallbacks(runnable);
        }
        this.f13262f = null;
    }

    private void j() {
        Runnable runnable = this.f13262f;
        if (runnable != null) {
            this.f13261e.postDelayed(runnable, this.f13260d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f13265j.set(false);
        bj.a(this.f13263g);
        i();
        p.a().a(1);
        ck.a(this.f13263g).b();
        ck.a(this.f13263g).a();
    }

    public IXAdContainerFactory c() {
        if (this.f13263g == null) {
            return null;
        }
        if (this.b == null && !this.f13265j.get()) {
            f();
        }
        return this.b;
    }

    public String d() {
        if (this.b == null) {
            return "";
        }
        return "_" + this.b.getRemoteVersion();
    }

    public boolean e() {
        return this.f13266k;
    }

    public Context b() {
        return this.f13263g;
    }

    public static z a() {
        if (f13258i == null) {
            synchronized (z.class) {
                if (f13258i == null) {
                    f13258i = new z();
                }
            }
        }
        return f13258i;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.f13264h.c(a, "init Context is null,error");
            return;
        }
        this.f13263g = context.getApplicationContext();
        p.a().a(aVar);
        if (this.b != null) {
            k();
        } else {
            if (this.f13265j.get()) {
                return;
            }
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f13264h.a(a, "加载dex失败原因=" + str);
        this.f13265j.set(false);
        i();
        p.a().a(2);
    }
}
