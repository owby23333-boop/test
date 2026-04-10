package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractAD<T> {
    protected T a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f17693e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f17691c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f17692d = false;
    private final Handler b = new Handler(Looper.getMainLooper());

    private void b(final Context context, final String str, final String str2) {
        this.f17693e = true;
        if (!b.b().d()) {
            a(2003);
            return;
        }
        final String strA = b.b().a();
        if (a.a(context)) {
            this.f17692d = true;
            b.f17802g.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final POFactory pOFactory = b.b().c().getPOFactory();
                        AbstractAD.this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (pOFactory != null) {
                                        AbstractAD.this.a = (T) AbstractAD.this.a(context, pOFactory, strA, str, str2);
                                        AbstractAD.this.f17691c = true;
                                        if (AbstractAD.this.a == null) {
                                            AbstractAD.this.a(ErrorCode.POFACTORY_GET_INTERFACE_ERROR);
                                        } else {
                                            AbstractAD.this.a(AbstractAD.this.a);
                                        }
                                    } else {
                                        AbstractAD.this.f17691c = true;
                                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                                    }
                                } catch (Throwable th) {
                                    GDTLogger.e("初始化错误：初始化广告实例时发生异常", th);
                                    AbstractAD.this.f17691c = true;
                                    AbstractAD.this.a(2001);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        GDTLogger.e("初始化错误：初始化插件时发生异常", th);
                        AbstractAD.this.f17691c = true;
                        AbstractAD.this.a(ErrorCode.PLUGIN_INIT_ERROR);
                    }
                }
            });
        } else {
            GDTLogger.e("Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
            a(4002);
        }
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2, String str3);

    protected final void a(final int i2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(i2);
        } else {
            this.b.post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD.this.b(i2);
                }
            });
        }
    }

    protected final void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            b(context, str, "");
        } else {
            GDTLogger.e("初始化错误：参数错误context或posId为空");
            a(2001);
        }
    }

    protected final void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str, str2);
        } else {
            GDTLogger.e("初始化错误：参数错误，context、posId、token 不可为空");
            a(2001);
        }
    }

    protected abstract void a(T t2);

    protected final void a(String str) {
        GDTLogger.e(getClass().getSimpleName() + ":调用方法 " + str + "异常，广告实例还未初始化");
    }

    protected final boolean a() {
        return this.f17693e && this.f17692d;
    }

    protected abstract void b(int i2);

    protected final boolean b() {
        return this.f17691c;
    }
}
