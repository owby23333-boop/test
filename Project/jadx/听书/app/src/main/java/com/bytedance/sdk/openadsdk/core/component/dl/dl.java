package com.bytedance.sdk.openadsdk.core.component.dl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class dl extends com.bytedance.sdk.openadsdk.ls.dl.z implements LazeLayout.z<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.z<NativeVideoTsView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.q.z.g.z.z f928a;
    private int dl;
    private final na e;
    private LazeLayout fo;
    private Bitmap g;
    private a gc;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g gz;
    private com.bytedance.sdk.openadsdk.io.z.g.z.z kb;
    private final Context m;
    private volatile WeakReference<NativeVideoTsView> uy;
    private boolean z;

    public dl(Context context, na naVar, int i, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        super(new a(context, naVar, i, gVar));
        this.fo = null;
        this.uy = null;
        this.kb = new com.bytedance.sdk.openadsdk.io.z.g.z.z(null) { // from class: com.bytedance.sdk.openadsdk.core.component.dl.dl.3
            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(View view, i iVar) {
                NativeVideoTsView nativeVideoTsViewSy = dl.this.gc.sy();
                if (nativeVideoTsViewSy != null) {
                    nativeVideoTsViewSy.uy();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void g(View view, i iVar) {
                NativeVideoTsView nativeVideoTsViewSy = dl.this.gc.sy();
                if (nativeVideoTsViewSy != null) {
                    nativeVideoTsViewSy.uy();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(i iVar) {
                NativeVideoTsView nativeVideoTsViewSy = dl.this.gc.sy();
                if (nativeVideoTsViewSy != null) {
                    nativeVideoTsViewSy.js();
                }
            }
        };
        this.gz = gVar;
        a aVar = (a) sy();
        this.gc = aVar;
        this.e = naVar;
        this.m = context;
        ((com.bytedance.sdk.openadsdk.core.zw.a) aVar.lq()).z(this.kb);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.z, com.bytedance.sdk.openadsdk.ls.dl.g.i
    public View q() {
        NativeVideoTsView nativeVideoTsViewG = null;
        if (this.e == null || this.m == null) {
            return null;
        }
        if (this.gc.gk()) {
            if (e.z()) {
                this.fo = new LazeLayout(this.m, this, this);
            } else {
                try {
                    nativeVideoTsViewG = g(this.m);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewG != null) {
                    z(nativeVideoTsViewG);
                }
                return nativeVideoTsViewG;
            }
        } else if (com.bytedance.sdk.openadsdk.gc.z.gz(this.e)) {
            return new UpieImageView(this.m, com.bytedance.sdk.openadsdk.gc.z.fo(this.e), null);
        }
        com.bytedance.sdk.openadsdk.core.e.a.z().z(this.e).z(this.gc.hh()).g(this.gc.l());
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.z
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView g(Context context) {
        NativeVideoTsView nativeVideoTsViewZ = this.gc.z(true);
        nativeVideoTsViewZ.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.component.dl.dl.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
            public void z(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                dl.this.gc.z.z = z;
                dl.this.gc.z.gc = j;
                dl.this.gc.z.m = j2;
                dl.this.gc.z.e = j3;
                dl.this.gc.z.f1272a = z2;
                dl.this.gc.z.gz = z3;
            }
        });
        nativeVideoTsViewZ.setAdCreativeClickListener(new NativeVideoTsView.z() { // from class: com.bytedance.sdk.openadsdk.core.component.dl.dl.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.z
            public void z(View view, int i) {
                iq iqVarA = ((com.bytedance.sdk.openadsdk.core.zw.a) dl.this.gc.lq()).a();
                if (iqVarA != null) {
                    iqVarA.z(view, i);
                }
            }
        });
        nativeVideoTsViewZ.setVideoAdLoadListener(this.gc);
        nativeVideoTsViewZ.setVideoAdInteractionListener(this.gc);
        int iFo = eo.fo(this.e);
        nativeVideoTsViewZ.setIsAutoPlay(z(iFo));
        nativeVideoTsViewZ.setIsQuiet(zw.g().a(iFo));
        NativeDrawVideoTsView nativeDrawVideoTsView = (NativeDrawVideoTsView) nativeVideoTsViewZ;
        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.z);
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            nativeDrawVideoTsView.z(bitmap, this.dl);
        }
        nativeVideoTsViewZ.setDrawVideoListener(this.f928a);
        this.uy = new WeakReference<>(nativeVideoTsViewZ);
        return nativeVideoTsViewZ;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.z
    public void z(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.z(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar, com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar) {
        View viewQ;
        try {
            z(viewGroup, (List<View>) null, list, list2, list3, (View) null, zVar);
            if (aVar != null) {
                View viewFindViewById = viewGroup.findViewById(aVar.wp());
                if (viewFindViewById != null && m() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(m());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = oq.dl(viewGroup.getContext(), 38.0f);
                        layoutParams.height = oq.dl(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(m());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(aVar.e());
                if (frameLayout == null || (viewQ = q()) == null) {
                    return;
                }
                oq.gz(viewQ);
                frameLayout.removeAllViews();
                frameLayout.addView(viewQ, -1, -1);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar) {
        a aVar = this.gc;
        if (aVar != null) {
            aVar.z(gVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public gc uf() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.fo
    public void z(boolean z) {
        this.z = z;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.fo
    public void z(Bitmap bitmap, int i) {
        this.g = bitmap;
        this.dl = i;
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.z, com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void io() {
        NativeVideoTsView nativeVideoTsView;
        super.io();
        if (this.uy != null && (nativeVideoTsView = this.uy.get()) != null) {
            nativeVideoTsView.js();
        }
        LazeLayout lazeLayout = this.fo;
        if (lazeLayout != null) {
            lazeLayout.z();
        }
    }

    private boolean z(int i) {
        int iE = zw.g().e(i);
        if (3 == iE) {
            return false;
        }
        if (1 != iE || !v.a(this.m)) {
            if (2 == iE) {
                if (!v.gc(this.m) && !v.a(this.m)) {
                    v.m(this.m);
                }
            } else if (5 == iE && !v.a(this.m)) {
                v.m(this.m);
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.fo
    public void z(com.bytedance.sdk.openadsdk.q.z.g.z.z zVar) {
        this.f928a = zVar;
    }

    private void l() {
        int i = this.dl;
        if (i >= 200) {
            this.dl = 200;
        } else if (i <= 20) {
            this.dl = 20;
        }
    }
}
