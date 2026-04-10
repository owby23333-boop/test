package com.bytedance.msdk.dl.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.msdk.core.views.RefreshableBannerView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f430a;
    private com.bytedance.msdk.api.z.g dl;
    private final Handler e;
    private com.bytedance.msdk.api.a.z.z.z fo;
    private final SoftReference<Context> g;
    private m gc;
    private final Handler gz;
    private final Runnable ls;
    private RefreshableBannerView m;
    private final com.bytedance.msdk.api.a.z.z.z pf;
    private com.bytedance.msdk.api.a.z.z.a uy;
    private final View.OnAttachStateChangeListener v;
    private int z = 0;
    private SoftReference<Activity> kb = new SoftReference<>(null);
    private SoftReference<com.bytedance.sdk.openadsdk.js.z.g.z.z> wp = new SoftReference<>(null);
    private SoftReference<Map<String, Object>> i = new SoftReference<>(null);

    /* JADX INFO: renamed from: com.bytedance.msdk.dl.a.kb$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            kb.this.gz.post(new Runnable() { // from class: com.bytedance.msdk.dl.a.kb.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (kb.this.z == 0 || kb.this.gc == null) {
                        return;
                    }
                    View viewZ = kb.this.gc.z((Context) kb.this.g.get());
                    if (viewZ != null) {
                        kb.this.z(kb.this.gc);
                        if (kb.this.m != null) {
                            kb.this.m.z(viewZ);
                        }
                        kb.this.gz.postDelayed(new Runnable() { // from class: com.bytedance.msdk.dl.a.kb.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (kb.this.f430a != null) {
                                    kb.this.f430a.z();
                                }
                                kb.this.f430a = kb.this.gc;
                                kb.this.p();
                            }
                        }, 250L);
                    } else {
                        if (kb.this.gc != null) {
                            kb.this.gc.z();
                        }
                        kb.this.p();
                    }
                    kb.this.pf();
                }
            });
        }
    }

    public kb(Context context) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.bytedance.msdk.dl.a.kb.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (kb.this.z == 0) {
                    return;
                }
                kb.this.p();
                kb.this.pf();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                kb.this.ls();
            }
        };
        this.v = onAttachStateChangeListener;
        this.pf = new com.bytedance.msdk.api.a.z.z.z() { // from class: com.bytedance.msdk.dl.a.kb.2
            @Override // com.bytedance.msdk.api.a.z.z.z
            public void f_() {
                kb.this.ls();
                if (kb.this.fo != null) {
                    kb.this.fo.f_();
                }
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void z(View view) {
                if (kb.this.fo != null) {
                    kb.this.fo.z(view);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void g(View view) {
                if (kb.this.fo != null) {
                    kb.this.fo.g(view);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.z.z
            public void z(com.bytedance.msdk.api.z zVar) {
                if (kb.this.fo != null) {
                    kb.this.fo.z(zVar);
                }
            }
        };
        this.ls = new AnonymousClass3();
        this.g = new SoftReference<>(context);
        this.f430a = new m(context);
        if (context != null) {
            RefreshableBannerView refreshableBannerView = new RefreshableBannerView(context);
            this.m = refreshableBannerView;
            refreshableBannerView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.m.setVisibilityChangeListener(new RefreshableBannerView.z() { // from class: com.bytedance.msdk.dl.a.kb.4
                @Override // com.bytedance.msdk.core.views.RefreshableBannerView.z
                public void z(boolean z) {
                    if (z) {
                        if (kb.this.z == 0) {
                            return;
                        }
                        kb.this.pf();
                        return;
                    }
                    kb.this.ls();
                }
            });
        }
        this.e = new Handler(com.bytedance.msdk.z.gc.m.g());
        this.gz = new Handler(Looper.getMainLooper());
    }

    private void z(com.bytedance.msdk.api.z.g gVar) {
        com.bytedance.msdk.core.uy.g gVarZ;
        if (gVar == null || (gVarZ = com.bytedance.msdk.core.g.g().z(gVar.zw(), 1, 100)) == null) {
            return;
        }
        int iUy = gVarZ.uy(1);
        if (iUy >= 10000 && iUy <= 180000) {
            this.z = iUy;
            com.bytedance.msdk.z.gc.dl.z("TMe", "---==-----banner轮播时间：" + this.z);
        } else {
            com.bytedance.msdk.z.gc.dl.z("TMe", "---==-----banner轮播时间下发不在10*1000～180*1000范围内：" + iUy + "，禁止banner轮播");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf() {
        this.e.removeCallbacksAndMessages(null);
        this.e.postDelayed(this.ls, this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        this.e.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Context context;
        SoftReference<Context> softReference = this.g;
        if (softReference == null || (context = softReference.get()) == null) {
            return;
        }
        m mVar = new m(context);
        this.gc = mVar;
        mVar.z(this.pf);
        this.gc.z(this.uy);
        z(this.dl);
        this.gc.z(this.dl, (com.bytedance.msdk.api.a.z.z.g) null);
    }

    public void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.a.z.z.g gVar2) {
        SoftReference<Context> softReference;
        if (this.f430a == null || (softReference = this.g) == null || softReference.get() == null) {
            return;
        }
        this.dl = gVar;
        z(gVar);
        if (!com.bytedance.msdk.core.g.g().z(gVar.zw(), 1) && gVar2 != null) {
            gVar2.z(new com.bytedance.msdk.api.z(840031, com.bytedance.msdk.api.z.z(840031)));
        } else if (com.bytedance.msdk.core.g.g().pf()) {
            this.f430a.z(this.dl, gVar2);
        } else if (gVar2 != null) {
            gVar2.z(new com.bytedance.msdk.api.z(840032, com.bytedance.msdk.api.z.z(840032)));
        }
    }

    public void z(com.bytedance.msdk.api.a.z.z.z zVar) {
        this.fo = zVar;
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.z(this.pf);
        }
    }

    public void z(com.bytedance.msdk.api.a.z.z.a aVar) {
        this.uy = aVar;
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.z(aVar);
        }
    }

    public void z() {
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.gc();
        }
    }

    public void g() {
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.m();
        }
    }

    public void dl() {
        this.gz.removeCallbacksAndMessages(null);
        ls();
        RefreshableBannerView refreshableBannerView = this.m;
        if (refreshableBannerView != null) {
            refreshableBannerView.removeOnAttachStateChangeListener(this.v);
        }
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.z();
        }
        m mVar2 = this.gc;
        if (mVar2 != null) {
            mVar2.z();
        }
    }

    public boolean a() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.dl();
        }
        return false;
    }

    public View gc() {
        m mVar = this.f430a;
        if (mVar == null) {
            return null;
        }
        View viewZ = mVar.z(this.g.get());
        m mVar2 = this.f430a;
        mVar2.z(mVar2.f428a);
        if (viewZ == null || this.m == null) {
            return null;
        }
        viewZ.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.msdk.dl.a.kb.5
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (view.getVisibility() == 0) {
                    kb kbVar = kb.this;
                    kbVar.z(kbVar.f430a);
                    view.removeOnLayoutChangeListener(this);
                }
            }
        });
        this.m.removeAllViews();
        ViewParent parent = viewZ.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(viewZ);
        }
        this.m.addView(viewZ);
        return this.m;
    }

    public int m() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.a();
        }
        return 0;
    }

    public Map<String, Object> e() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.fv();
        }
        return new HashMap();
    }

    public List<com.bytedance.msdk.api.g> gz() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.uy();
        }
        return new ArrayList();
    }

    public List<com.bytedance.msdk.api.dl> fo() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.kb();
        }
        return null;
    }

    public com.bytedance.msdk.api.dl uy() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.ls();
        }
        return null;
    }

    public List<com.bytedance.msdk.api.dl> kb() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.wp();
        }
        return null;
    }

    public com.bytedance.msdk.api.dl wp() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.pf();
        }
        return null;
    }

    public int i() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.p();
        }
        return -1;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.z(dlVar);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.g(gVar);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.z(dlVar);
        }
    }

    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        this.kb = new SoftReference<>(activity);
        this.wp = new SoftReference<>(zVar);
    }

    public void z(Dialog dialog, Integer[] numArr) {
        HashMap map = new HashMap();
        map.put("dislike_dialog", dialog);
        map.put("dislike_ids", numArr);
        this.i = new SoftReference<>(map);
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.z(activity);
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.a v() {
        m mVar = this.f430a;
        if (mVar != null) {
            return mVar.q();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(m mVar) {
        Map<String, Object> map = this.i.get();
        if (map != null) {
            Dialog dialog = (Dialog) map.get("dislike_dialog");
            Integer[] numArr = (Integer[]) map.get("dislike_ids");
            if (dialog != null && numArr != null) {
                mVar.z(dialog, numArr);
            }
        }
        Activity activity = this.kb.get();
        com.bytedance.sdk.openadsdk.js.z.g.z.z zVar = this.wp.get();
        if (activity == null || zVar == null) {
            return;
        }
        mVar.z(activity, zVar);
    }

    public void z(String str) {
        m mVar = this.f430a;
        if (mVar != null) {
            mVar.a(str);
        }
    }
}
