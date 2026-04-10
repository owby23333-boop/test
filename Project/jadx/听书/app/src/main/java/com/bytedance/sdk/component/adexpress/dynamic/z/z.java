package com.bytedance.sdk.component.adexpress.dynamic.z;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bytedance.sdk.component.adexpress.a.gc;
import com.bytedance.sdk.component.adexpress.dl;
import com.bytedance.sdk.component.adexpress.dynamic.a.gz;
import com.bytedance.sdk.component.adexpress.dynamic.dl.m;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.g.a;
import com.bytedance.sdk.component.adexpress.g.e;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.adexpress.g.kb;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.wp;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements a<DynamicRootView>, kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f576a;
    private Context dl;
    private ScheduledFuture<?> e;
    private gz g;
    private com.bytedance.sdk.component.adexpress.g.gz gc;
    private i m;
    private DynamicRootView z;
    private AtomicBoolean gz = new AtomicBoolean(false);
    private volatile boolean fo = false;

    public z(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, gz gzVar, i iVar, com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar) {
        this.dl = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, iVar, zVar);
        this.z = dynamicRootView;
        this.g = gzVar;
        this.m = iVar;
        dynamicRootView.setRenderListener(this);
        this.m = iVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    public void z(e eVar) {
        this.f576a = eVar;
        int iGz = this.m.gz();
        if (iGz < 0) {
            this.z.z(this.g instanceof com.bytedance.sdk.component.adexpress.dynamic.a.e ? 127 : 117, "time is " + iGz);
            return;
        }
        this.e = gc.z(new RunnableC0117z(2), iGz, TimeUnit.MILLISECONDS);
        if (this.fo) {
            com.bytedance.sdk.component.utils.gz.dl().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.z.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.gz();
                }
            }, this.m.wp());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.m.wp() <= 0) {
            gz();
        } else {
            com.bytedance.sdk.component.utils.gz.g().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.z.z.2
                @Override // java.lang.Runnable
                public void run() {
                    z.this.gz();
                }
            }, this.m.wp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz() {
        this.m.e().g(dl());
        JSONObject jSONObjectGc = this.m.gc();
        if (!com.bytedance.sdk.component.adexpress.z.g.g.z(jSONObjectGc)) {
            this.z.z(this.g instanceof com.bytedance.sdk.component.adexpress.dynamic.a.e ? 123 : 113, "data null is " + (jSONObjectGc == null));
        } else {
            this.g.z(new com.bytedance.sdk.component.adexpress.dynamic.gc.g() { // from class: com.bytedance.sdk.component.adexpress.dynamic.z.z.3
                @Override // com.bytedance.sdk.component.adexpress.dynamic.gc.g
                public void z(final com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
                    z.this.uy();
                    z.this.m.e().dl(z.this.dl());
                    z.this.z(gzVar);
                    z.this.g(gzVar);
                    if (z.this.fo) {
                        z.this.dl(gzVar);
                    } else {
                        com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.z.z.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                z.this.dl(gzVar);
                            }
                        });
                    }
                    if (z.this.z == null || gzVar == null) {
                        return;
                    }
                    z.this.z.setBgColor(gzVar.z());
                    z.this.z.setBgMaterialCenterCalcColor(gzVar.g());
                }
            });
            this.g.z(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> listKb;
        if (gzVar == null || (listKb = gzVar.kb()) == null || listKb.size() <= 0) {
            return;
        }
        Collections.sort(listKb, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.z.z.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar2, com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar3) {
                m mVarGc = gzVar2.uy().gc();
                m mVarGc2 = gzVar3.uy().gc();
                if (mVarGc == null || mVarGc2 == null) {
                    return 0;
                }
                return mVarGc.vo() >= mVarGc2.vo() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar2 : listKb) {
            if (gzVar2 != null) {
                z(gzVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        float fE;
        float fM;
        List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> listKb;
        if (gzVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> listKb2 = gzVar.kb();
        if (listKb2 == null || listKb2.size() <= 0) {
            fE = 0.0f;
        } else {
            fE = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar2 : listKb2) {
                if (gzVar2.e() > gzVar.e() - gzVar2.fo() || (listKb = gzVar2.kb()) == null || listKb.size() <= 0) {
                    fM = 0.0f;
                } else {
                    fM = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar3 : listKb) {
                        if (gzVar3.uy().getType().equals("logo-union")) {
                            fM = gzVar3.uy().m();
                            fE = (((-fM) + gzVar.e()) - gzVar2.e()) + gzVar2.uy().gc().o();
                        }
                    }
                }
                g(gzVar2);
                if (fM <= -15.0f) {
                    gzVar2.m(gzVar2.fo() - fM);
                    gzVar2.a(gzVar2.e() + fM);
                    for (com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar4 : gzVar2.kb()) {
                        gzVar4.a(gzVar4.e() - fM);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVarWp = gzVar.wp();
        if (gzVarWp == null) {
            return;
        }
        float fM2 = gzVar.m() - gzVarWp.m();
        float fE2 = gzVar.e() - gzVarWp.e();
        gzVar.dl(fM2);
        gzVar.a(fE2);
        if (fE > 0.0f) {
            gzVar.a(gzVar.e() - fE);
            gzVar.m(gzVar.fo() + fE);
            for (com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar5 : gzVar.kb()) {
                gzVar5.a(gzVar5.e() + fE);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public DynamicRootView e() {
        return m();
    }

    public void g() {
        z(e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                z(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gc) {
            ((com.bytedance.sdk.component.adexpress.dynamic.dynamicview.gc) view).g();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    public int dl() {
        return this.g instanceof com.bytedance.sdk.component.adexpress.dynamic.a.e ? 3 : 2;
    }

    public void a() {
        this.z.z();
    }

    public void gc() {
        this.z.g();
    }

    public void z(boolean z) {
        this.z.setSoundMute(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        if (gzVar == null) {
            this.z.z(this.g instanceof com.bytedance.sdk.component.adexpress.dynamic.a.e ? 123 : 113, "layoutUnit is null");
            return;
        }
        this.m.e().a(dl());
        try {
            this.z.z(gzVar, dl());
        } catch (Exception e) {
            this.z.z(this.g instanceof com.bytedance.sdk.component.adexpress.dynamic.a.e ? 128 : TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, "exception is " + e.getMessage());
        }
    }

    public DynamicRootView m() {
        return this.z;
    }

    public void z(com.bytedance.sdk.component.adexpress.g.gz gzVar) {
        this.gc = gzVar;
    }

    private boolean fo() {
        DynamicRootView dynamicRootView = this.z;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.kb
    public void z(v vVar) {
        if (this.gz.get()) {
            return;
        }
        this.gz.set(true);
        if (vVar.dl() && fo()) {
            this.z.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f576a.z(e(), vVar);
            return;
        }
        this.f576a.z(vVar.kb(), vVar.uy());
    }

    @Override // com.bytedance.sdk.component.adexpress.g.kb
    public void z(View view, int i, dl dlVar) {
        com.bytedance.sdk.component.adexpress.g.gz gzVar = this.gc;
        if (gzVar != null) {
            gzVar.z(view, i, dlVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.kb
    public void z(View view, int i, dl dlVar, int i2) {
        com.bytedance.sdk.component.adexpress.g.gz gzVar = this.gc;
        if (gzVar != null) {
            gzVar.z(view, i, dlVar, i2);
        }
    }

    public void g(boolean z) {
        this.fo = z;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.z.z$z, reason: collision with other inner class name */
    private class RunnableC0117z implements Runnable {
        private int g;

        public RunnableC0117z(int i) {
            this.g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.g == 2) {
                z.this.z.z(z.this.g instanceof com.bytedance.sdk.component.adexpress.dynamic.a.e ? 127 : 117, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uy() {
        try {
            ScheduledFuture<?> scheduledFuture = this.e;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.e.cancel(false);
            this.e = null;
        } catch (Throwable th) {
            wp.z(th);
        }
    }
}
