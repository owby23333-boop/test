package com.bytedance.msdk.dl.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.api.activity.TTTransparentActivity;
import com.bytedance.msdk.core.g;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends uy {
    private volatile boolean g;
    private final Application.ActivityLifecycleCallbacks gk;
    private String h;
    private com.bytedance.msdk.g.dl hh;
    private int io;
    private Handler iq;
    private Object l;
    protected boolean ls;
    private SoftReference<Activity> q;
    private int sy;
    private SoftReference<Activity> tb;
    private int uf;
    private boolean z;
    private int zw;

    protected void z(Activity activity, Object obj, String str) {
    }

    public a(Context context) {
        super(context);
        this.z = false;
        this.ls = true;
        this.g = false;
        this.tb = new SoftReference<>(null);
        this.q = new SoftReference<>(null);
        this.zw = 0;
        this.io = 2;
        this.uf = 0;
        this.sy = 15000;
        this.gk = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.msdk.dl.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- onActivityCreated: activity: ".concat(String.valueOf(activity)));
                Activity activity2 = (Activity) a.this.q.get();
                if (activity2 == null) {
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- onActivityCreated: start transparent activity");
                    if (activity instanceof TTTransparentActivity) {
                        a.this.q = new SoftReference(activity);
                        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- onActivityCreated: start transparent activity, callSuperShowAd");
                        a aVar = a.this;
                        aVar.g(aVar.hh, activity, a.this.l, a.this.h);
                        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- onActivityCreated: end");
                        return;
                    }
                    return;
                }
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- onActivityCreated again, showingActivity: ".concat(String.valueOf(activity2)));
                String name = activity.getClass().getName();
                if ((activity2 instanceof TTTransparentActivity) && com.bytedance.msdk.core.admanager.z.g(name)) {
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- onActivityCreated again, is adn ad activity: ".concat(String.valueOf(activity)));
                    activity2.finish();
                    a.this.q = new SoftReference(activity);
                } else {
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- onActivityCreated again, is not adn ad activity");
                }
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- onActivityCreated: end 2");
            }
        };
    }

    public void g(com.bytedance.msdk.api.z.g gVar) {
        z(gVar);
        if (this.e != null) {
            this.uf = this.e.v();
            if (dl()) {
                this.io = this.e.pf();
                int iUy = this.e.uy(this.e.ti());
                this.sy = iUy;
                if (iUy <= 0) {
                    this.sy = 15000;
                }
                this.iq = new Handler(Looper.getMainLooper());
                return;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- inter full refresh is not enabled");
        }
    }

    private boolean dl() {
        return this.uf != 0;
    }

    private void a() {
        if (this.g) {
            return;
        }
        Application applicationZ = g.z.z();
        if (applicationZ == null) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- app is null, 插全屏轮播直接return");
            return;
        }
        applicationZ.unregisterActivityLifecycleCallbacks(this.gk);
        applicationZ.registerActivityLifecycleCallbacks(this.gk);
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.msdk.g.dl dlVar, Activity activity, Object obj, String str) {
        super.z(dlVar, activity, obj, str);
    }

    @Override // com.bytedance.msdk.dl.a.uy
    public void z(com.bytedance.msdk.g.dl dlVar, Activity activity, Object obj, String str) {
        if (dl()) {
            a();
            this.tb = new SoftReference<>(activity);
            this.hh = dlVar;
            this.f428a = dlVar;
            this.l = obj;
            this.h = str;
            Intent intent = new Intent(com.bytedance.msdk.core.g.getContext(), (Class<?>) TTTransparentActivity.class);
            intent.addFlags(268435456);
            com.bytedance.msdk.core.g.getContext().startActivity(intent);
            return;
        }
        super.z(dlVar, activity, obj, str);
    }

    @Override // com.bytedance.msdk.dl.a.uy
    protected boolean q() {
        return this.z;
    }

    private void z(final Handler handler, final Activity activity) {
        int i = this.sy + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth;
        if (i <= 0) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.bytedance.msdk.dl.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.z(activity)) {
                    a.this.gc();
                    return;
                }
                Toast toastMakeText = Toast.makeText(com.bytedance.msdk.core.g.getContext(), "2秒后播放下一个广告", 0);
                toastMakeText.show();
                handler.postDelayed(new z(toastMakeText, 1, handler), 1000L);
            }
        }, i);
    }

    private static class z implements Runnable {
        private final Handler dl;
        private final int g;
        private Toast z;

        private z(Toast toast, int i, Handler handler) {
            this.z = toast;
            this.g = i;
            this.dl = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.g > 0) {
                this.z.cancel();
                Toast toastMakeText = Toast.makeText(com.bytedance.msdk.core.g.getContext(), this.g + "秒后播放下一个广告", 0);
                this.z = toastMakeText;
                toastMakeText.show();
                Handler handler = this.dl;
                handler.postDelayed(new z(this.z, this.g - 1, handler), 1000L);
                return;
            }
            this.z.cancel();
        }
    }

    protected final void iq() {
        if (dl()) {
            this.ls = true;
            this.zw++;
            final Activity activity = this.tb.get();
            final Activity activity2 = this.q.get();
            final com.bytedance.msdk.g.dl dlVar = this.hh;
            if (!z(activity2, activity, dlVar)) {
                gc();
                return;
            }
            Handler handler = this.iq;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                z(this.iq, activity2);
                this.iq.postDelayed(new Runnable() { // from class: com.bytedance.msdk.dl.a.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.z(activity2)) {
                            a.this.gc();
                            return;
                        }
                        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播 开始，先showingActivity finish");
                        a.this.ls = false;
                        activity2.finish();
                        dlVar.fv();
                        a.this.q = new SoftReference(null);
                        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播开始 showingActivity finish end");
                        a.this.z = true;
                        a aVar = a.this;
                        aVar.z(activity, aVar.l, a.this.h);
                    }
                }, this.sy);
            }
        }
    }

    protected final void zw() {
        if (dl()) {
            if (this.ls) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 用户关闭了广告，停止轮播");
                Activity activity = this.q.get();
                if (activity instanceof TTTransparentActivity) {
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 用户关闭了广告，finish showingActivity");
                    activity.finish();
                    this.q = new SoftReference<>(null);
                }
                gc();
                return;
            }
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 调用finish触发了close回调");
        }
    }

    protected final void io() {
        if (dl()) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 用户点击了广告，停止轮播");
            gc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        Handler handler = this.iq;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Application applicationZ = g.z.z();
        if (applicationZ != null) {
            applicationZ.unregisterActivityLifecycleCallbacks(this.gk);
        }
    }

    private boolean z(com.bytedance.msdk.core.uy.uy uyVar) {
        return uyVar.oq() && uyVar.z() != 1;
    }

    private boolean a(com.bytedance.msdk.g.dl dlVar) {
        return dlVar.jc() && dlVar.io() != 1;
    }

    private boolean z(Activity activity, Activity activity2, com.bytedance.msdk.g.dl dlVar) {
        if (this.zw >= this.io) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，轮播次数已达上限: " + this.io);
            return false;
        }
        if (activity2 == null) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播 停止轮播 developerActivity为null");
            return false;
        }
        if (dlVar == null) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，ttBaseAd为null，不轮播");
            return false;
        }
        if (a(dlVar)) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，展示的是自定义adn，则不轮播");
            return false;
        }
        if (com.bytedance.msdk.core.admanager.z.z(dlVar.zx(), dlVar.hy(), dlVar.j())) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，当前展示的广告不支持轮播: " + dlVar.zx() + ", adtype: " + dlVar.hy() + ", subType: " + dlVar.j());
            com.bytedance.msdk.gc.m.z(this.m, 81011);
            return false;
        }
        if (activity != null) {
            return true;
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，showingActivity是null，停止轮播");
        com.bytedance.msdk.gc.m.z(this.m, 81010);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，showingActivity正在finish或已经destroy，停止轮播");
            return false;
        }
        int iM = m();
        if (iM == 2) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，无任何广告可用，停止轮播");
            com.bytedance.msdk.gc.m.z(this.m, 81008);
            return false;
        }
        if (iM == 1) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，仅有自定义adn广告可用，停止轮播");
            com.bytedance.msdk.gc.m.z(this.m, 81009);
            return false;
        }
        int iG = g(this.gc);
        if (iG == 0) {
            return true;
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==--- 插全屏轮播，命中了展示频控，停止轮播");
        com.bytedance.msdk.gc.m.z(this.m, iG);
        return false;
    }

    private int m() {
        CopyOnWriteArrayList<com.bytedance.msdk.g.dl> copyOnWriteArrayListE;
        CopyOnWriteArrayList<com.bytedance.msdk.g.dl> copyOnWriteArrayListUy;
        CopyOnWriteArrayList<com.bytedance.msdk.g.dl> copyOnWriteArrayListGz;
        boolean z2;
        List<com.bytedance.msdk.core.uy.uy> listG = null;
        if (this.dl != null) {
            copyOnWriteArrayListE = this.dl.e();
            copyOnWriteArrayListUy = this.dl.uy();
            copyOnWriteArrayListGz = this.dl.gz();
        } else {
            copyOnWriteArrayListE = null;
            copyOnWriteArrayListUy = null;
            copyOnWriteArrayListGz = null;
        }
        if (copyOnWriteArrayListE == null || copyOnWriteArrayListE.size() <= 0) {
            z2 = false;
        } else {
            z2 = false;
            for (com.bytedance.msdk.g.dl dlVar : copyOnWriteArrayListE) {
                if (dlVar != null && dlVar.un(this.gc) && !dlVar.jq()) {
                    if (!a(dlVar) && !com.bytedance.msdk.core.admanager.z.z(dlVar.zx(), dlVar.hy(), dlVar.j())) {
                        return 0;
                    }
                    z2 = true;
                }
            }
        }
        if (copyOnWriteArrayListGz != null && copyOnWriteArrayListGz.size() > 0) {
            for (com.bytedance.msdk.g.dl dlVar2 : copyOnWriteArrayListGz) {
                if (dlVar2 != null && dlVar2.un(this.gc) && !dlVar2.jq()) {
                    if (!a(dlVar2) && !com.bytedance.msdk.core.admanager.z.z(dlVar2.zx(), dlVar2.hy(), dlVar2.j())) {
                        return 0;
                    }
                    z2 = true;
                }
            }
        }
        if (copyOnWriteArrayListUy != null && copyOnWriteArrayListUy.size() > 0) {
            for (com.bytedance.msdk.g.dl dlVar3 : copyOnWriteArrayListUy) {
                if (dlVar3 != null && dlVar3.un(this.gc) && !dlVar3.jq()) {
                    if (!a(dlVar3) && !com.bytedance.msdk.core.admanager.z.z(dlVar3.zx(), dlVar3.hy(), dlVar3.j())) {
                        return 0;
                    }
                    z2 = true;
                }
            }
        }
        try {
            listG = g();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        if (listG != null && listG.size() > 0) {
            for (com.bytedance.msdk.core.uy.uy uyVar : listG) {
                String strFv = uyVar.fv();
                if (uyVar.tb() && com.bytedance.msdk.core.gc.z.z.z().a(this.gc, strFv, js()) && com.bytedance.msdk.core.gc.z.z.z().z(strFv, this.m, false) == 3) {
                    if (!z(uyVar) && !com.bytedance.msdk.core.admanager.z.z(uyVar.pf(), uyVar.i(), uyVar.m())) {
                        return 0;
                    }
                    z2 = true;
                }
            }
        }
        return z2 ? 1 : 2;
    }
}
