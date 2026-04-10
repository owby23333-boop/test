package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.ls.dl.g.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.m;
import com.kwad.sdk.api.model.AdnName;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class z extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.ui.g f1028a;
    private dl dl;
    private boolean e;
    private g fo;
    private com.bytedance.sdk.openadsdk.core.dislike.dl.g g;
    private TTDislikeToast gc;
    private SoftReference<View> gz;
    private final List<com.bytedance.sdk.openadsdk.core.dislike.g.z> kb;
    private AtomicBoolean m;
    private InterfaceC0168z uy;
    private final Context z;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.dislike.ui.z$z, reason: collision with other inner class name */
    public interface InterfaceC0168z {
        void g();

        void z();

        void z(int i, String str, boolean z);
    }

    public z(Context context, com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, String str, boolean z) {
        this.m = new AtomicBoolean(false);
        this.kb = new ArrayList();
        gVar.g(str);
        gVar.z(AdnName.OTHER);
        this.z = context;
        if (context == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            wp.dl("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.g = gVar;
        this.e = z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a();
        } else {
            gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.a();
                }
            });
        }
    }

    public z(Context context, com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, boolean z) {
        this(context, gVar, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ViewGroup viewGroup;
        dl dlVar = new dl(this.z, this.g);
        this.dl = dlVar;
        dlVar.z(new com.bytedance.sdk.openadsdk.core.dislike.g.dl() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.z.2
            @Override // com.bytedance.sdk.openadsdk.core.dislike.g.dl
            public void z() {
                z.this.gc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.g.dl
            public void z(int i, m mVar) {
                try {
                    if (!z.this.kb.isEmpty()) {
                        String strA = z.this.f1028a != null ? z.this.f1028a.a() : "";
                        Iterator it = z.this.kb.iterator();
                        while (it.hasNext()) {
                            ((com.bytedance.sdk.openadsdk.core.dislike.g.z) it.next()).z(mVar, strA, z.this.f1028a);
                        }
                    }
                    if (!mVar.m()) {
                        if (z.this.uy != null) {
                            z.this.uy.z(i, mVar.g(), z.this.g != null ? z.this.g.gz() : false);
                        }
                        z.this.m.set(true);
                        if (z.this.gc != null) {
                            z.this.gc.z();
                        }
                        z.this.m();
                    }
                    wp.a("TTAdDislikeImpl", "onDislikeSelected: " + i + ", " + mVar.g());
                } catch (Throwable th) {
                    wp.dl("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.g.dl
            public void g() {
                if (z.this.uy != null) {
                    z.this.uy.z();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.g.dl
            public void dl() {
                wp.a("TTAdDislikeImpl", "onDislikeHide: ");
                try {
                    if (z.this.uy == null || z.this.dl()) {
                        return;
                    }
                    z.this.uy.g();
                } catch (Throwable th) {
                    wp.dl("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.ui.g gVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.g(this.z, this.g);
        this.f1028a = gVar;
        gVar.z(new com.bytedance.sdk.openadsdk.core.dislike.g.g() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.z.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.g.g
            public void z() {
                try {
                    if (z.this.m.get()) {
                        return;
                    }
                    z.this.dl.show();
                    if (z.this.f1028a != null) {
                        String strA = z.this.f1028a.a();
                        if (TextUtils.isEmpty(strA)) {
                            return;
                        }
                        z.this.dl.z(strA);
                    }
                } catch (Throwable th) {
                    wp.dl("TTAdDislikeImpl", "dislike callback selected error: ", th);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.g.g
            public void z(int i, m mVar) {
                try {
                    if (mVar.m()) {
                        return;
                    }
                    if (z.this.uy != null) {
                        z.this.uy.z(i, mVar.g(), z.this.g != null ? z.this.g.gz() : false);
                    }
                    z.this.m.set(true);
                    if (z.this.gc != null) {
                        z.this.gc.z();
                    }
                    z.this.m();
                } catch (Throwable th) {
                    wp.dl("TTAdDislikeImpl", "comment callback selected error: ", th);
                }
            }
        });
        if ((this.z instanceof Activity) && this.e) {
            this.gc = new TTDislikeToast(this.z);
            Window window = ((Activity) this.z).getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView()) == null) {
                return;
            }
            viewGroup.addView(this.gc);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
    public void z() {
        TTDislikeToast tTDislikeToast;
        Context context = this.z;
        boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
        if (this.m.get() && this.e && (tTDislikeToast = this.gc) != null) {
            tTDislikeToast.g();
        } else {
            if (!z || dl()) {
                return;
            }
            this.dl.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        if ((this.z instanceof Activity) && (!((Activity) r0).isFinishing()) && !this.f1028a.isShowing()) {
            this.f1028a.show();
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        if ((this.z instanceof Activity) && gVar != null) {
            this.dl.z(gVar);
            this.f1028a.z(gVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
    public void z(final com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        this.uy = new InterfaceC0168z() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.z.4
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void z() {
                com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void z(int i, String str, boolean z) {
                com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z(i, str, z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.z.InterfaceC0168z
            public void g() {
                com.bytedance.sdk.openadsdk.js.z.g.z.z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.g();
                }
            }
        };
    }

    public void z(InterfaceC0168z interfaceC0168z) {
        this.uy = interfaceC0168z;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
    public void z(String str) {
        com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar = this.g;
        if (gVar != null) {
            gVar.z(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
    public void g() {
        if (this.z instanceof Activity) {
            dl dlVar = this.dl;
            if (dlVar != null) {
                dlVar.hide();
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.g gVar = this.f1028a;
            if (gVar != null) {
                gVar.z();
            }
            TTDislikeToast tTDislikeToast = this.gc;
            if (tTDislikeToast != null) {
                tTDislikeToast.dl();
            }
            this.m.set(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.e
    public boolean dl() {
        if (!(this.z instanceof Activity)) {
            return false;
        }
        dl dlVar = this.dl;
        boolean zIsShowing = dlVar != null ? dlVar.isShowing() : false;
        com.bytedance.sdk.openadsdk.core.dislike.ui.g gVar = this.f1028a;
        return gVar != null ? zIsShowing | gVar.isShowing() : zIsShowing;
    }

    public void z(View view) {
        this.gz = new SoftReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar = this.g;
        if (gVar == null) {
            return;
        }
        final String strE = gVar.e();
        if ("slide_banner_ad".equals(strE) || "banner_ad".equals(strE) || "embeded_ad".equals(strE)) {
            if (this.gz.get() != null && this.g.gz()) {
                this.gz.get().setVisibility(8);
            }
            if (this.fo == null) {
                this.fo = new g(this.z);
            }
            this.fo.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.z.5
                @Override // java.lang.Runnable
                public void run() {
                    z.this.g.g("dislike");
                    if (z.this.gz == null || z.this.gz.get() == null || !((View) z.this.gz.get()).isShown()) {
                        com.bytedance.sdk.openadsdk.core.dislike.z.z.z().z(z.this.z, z.this.g, "close_success");
                    } else {
                        com.bytedance.sdk.openadsdk.core.dislike.z.z.z().z(z.this.z, z.this.g, "close_fail");
                    }
                    z.this.g.g(strE);
                }
            }, 500L);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.dislike.g.z zVar) {
        this.kb.add(zVar);
        com.bytedance.sdk.openadsdk.core.dislike.ui.g gVar = this.f1028a;
        if (gVar != null) {
            gVar.z(zVar);
        }
    }

    public static class g extends Handler {
        public WeakReference<Context> z;

        public g(Context context) {
            this.z = new WeakReference<>(context);
        }
    }
}
