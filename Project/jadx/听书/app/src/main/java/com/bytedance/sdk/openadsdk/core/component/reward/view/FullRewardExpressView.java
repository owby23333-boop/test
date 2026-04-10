package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.g.a;
import com.bytedance.sdk.component.adexpress.g.dl;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.uy;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.z.z;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class FullRewardExpressView extends NativeExpressView implements uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f970a;
    com.bytedance.sdk.openadsdk.core.video.g.z dl;
    FullRewardExpressBackupView g;
    private v gc;
    private FullSwiperItemView.z hh;
    private z io;
    private ImageView iq;
    private com.bytedance.sdk.openadsdk.core.ugeno.uy.z l;
    private z.InterfaceC0212z sy;
    private View uf;
    uy z;
    private HashSet<String> zw;

    public interface z {
        void z(int i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void setPauseFromExpressView(boolean z2) {
    }

    public FullRewardExpressView(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, boolean z2, String str2) {
        super(context, naVar, gVar, str, z2, str2);
        this.zw = new HashSet<>();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void wp() {
        this.ls = true;
        this.v = new FrameLayout(this.m);
        super.wp();
        pf();
        if (getJsObject() != null) {
            getJsObject().wp(this.tb);
        }
    }

    public void setEasyPlayableContainer(View view) {
        this.uf = view;
    }

    public void setInteractListener(FullSwiperItemView.z zVar) {
        this.hh = zVar;
    }

    private void pf() {
        setBackupListener(new dl() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.component.adexpress.g.dl
            public boolean z(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).js();
                    FullRewardExpressView.this.g = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView.this.g.z(FullRewardExpressView.this.fo, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    public void setExpressVideoListenerProxy(uy uyVar) {
        this.z = uyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(com.bytedance.sdk.component.adexpress.g.a<? extends android.view.View> r4, com.bytedance.sdk.component.adexpress.g.v r5) {
        /*
            r3 = this;
            r3.f970a = r4
            boolean r0 = r4 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.v
            if (r0 == 0) goto L25
            r0 = r4
            com.bytedance.sdk.openadsdk.core.nativeexpress.v r0 = (com.bytedance.sdk.openadsdk.core.nativeexpress.v) r0
            com.bytedance.sdk.openadsdk.core.mc r1 = r0.D_()
            if (r1 == 0) goto L16
            com.bytedance.sdk.openadsdk.core.mc r1 = r0.D_()
            r1.z(r3)
        L16:
            com.bytedance.sdk.openadsdk.core.mc r1 = r0.D_()
            if (r1 == 0) goto L25
            com.bytedance.sdk.openadsdk.core.mc r0 = r0.D_()
            java.lang.String r1 = r3.uy
            r0.dl(r1)
        L25:
            boolean r0 = r4 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.z
            if (r0 == 0) goto L2f
            r0 = r4
            com.bytedance.sdk.openadsdk.core.ugeno.express.z r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.z) r0
            r0.z(r3)
        L2f:
            if (r5 == 0) goto L9a
            boolean r0 = r5.dl()
            if (r0 == 0) goto L9a
            r3.gc = r5
            int r0 = r5.g()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L54
            android.view.View r0 = r5.z()
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L54
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.ViewGroup r1 = r3.getVideoContainer()
            r0.addView(r1)
            r0 = r2
            goto L55
        L54:
            r0 = 0
        L55:
            if (r0 != 0) goto L5c
            android.widget.FrameLayout r0 = r3.v
            r3.z(r0, r2)
        L5c:
            int r0 = r5.g()
            r1 = 10
            if (r0 != r1) goto L71
            boolean r0 = r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.dl
            if (r0 == 0) goto L71
            r0 = r5
            com.bytedance.sdk.openadsdk.core.ugeno.express.dl r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.dl) r0
            com.bytedance.sdk.openadsdk.core.ugeno.uy.z r0 = r0.fv()
            r3.l = r0
        L71:
            int r0 = r5.g()
            if (r0 != r1) goto L9a
            boolean r0 = r5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.dl
            if (r0 == 0) goto L9a
            r0 = r5
            com.bytedance.sdk.openadsdk.core.ugeno.express.dl r0 = (com.bytedance.sdk.openadsdk.core.ugeno.express.dl) r0
            android.widget.FrameLayout r0 = r0.p()
            if (r0 == 0) goto L9a
            android.view.View r1 = r3.uf
            if (r1 == 0) goto L9a
            android.view.ViewParent r1 = r1.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            if (r1 == 0) goto L95
            android.view.View r2 = r3.uf
            r1.removeView(r2)
        L95:
            android.view.View r1 = r3.uf
            r0.addView(r1)
        L9a:
            super.g(r4, r5)
            int r4 = r3.getVisibility()
            r3.gc(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.g(com.bytedance.sdk.component.adexpress.g.a, com.bytedance.sdk.component.adexpress.g.v):void");
    }

    public void z(final ViewGroup viewGroup, final boolean z2) {
        if (this.gc == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g(viewGroup, z2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.g(viewGroup, z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(android.view.ViewGroup r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.g(android.view.ViewGroup, boolean):void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(boolean z2) {
        super.z(z2);
        this.tb = z2;
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.z(z2);
        }
        a aVar = this.f970a;
        if (aVar == null || !(aVar instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.z.z) aVar).z(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void e() {
        super.e();
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gz() {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.gz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(int i) {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.z(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long z() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.z();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int g() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.g();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int dl() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.dl();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long getActualPlayDuration() {
        uy uyVar = this.z;
        if (uyVar != null) {
            return uyVar.getActualPlayDuration();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void fo() {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.fo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void uy() {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.uy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void kb() {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.kb();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f, float f2, float f3, float f4, int i) {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.z(f, f2, f3, f4, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void g(int i) {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.g(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void a() {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gc() {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.gc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(final int i, final String str) {
        this.sy = new z.InterfaceC0212z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3
            @Override // com.bytedance.sdk.openadsdk.core.video.z.z.InterfaceC0212z
            public void z(long j, long j2) {
                int iAbs = (int) Math.abs(((long) i) - j);
                if (FullRewardExpressView.this.dl.mc() && FullRewardExpressView.this.z != null) {
                    iAbs = (int) Math.abs(((long) i) - FullRewardExpressView.this.z.getActualPlayDuration());
                }
                int i2 = FullRewardExpressView.this.dl instanceof com.bytedance.sdk.openadsdk.core.component.reward.draw.a ? 200 : 50;
                int i3 = i;
                if (i3 < 0 || iAbs > i2 || i3 > j2 || iAbs >= i2 || FullRewardExpressView.this.zw.contains(str)) {
                    return;
                }
                if (i > j) {
                    FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FullRewardExpressView.this.dl.m();
                            FullRewardExpressView.this.g(i, str);
                            if (gb.p(FullRewardExpressView.this.fo) || y.z(FullRewardExpressView.this.fo)) {
                                FullRewardExpressView.this.z.z(2);
                            }
                            if (FullRewardExpressView.this.z != null) {
                                FullRewardExpressView.this.z.setPauseFromExpressView(true);
                            }
                        }
                    }, iAbs);
                } else {
                    FullRewardExpressView.this.dl.m();
                    FullRewardExpressView.this.g(i, str);
                    if (gb.p(FullRewardExpressView.this.fo) || y.z(FullRewardExpressView.this.fo)) {
                        FullRewardExpressView.this.z.z(2);
                    }
                    if (FullRewardExpressView.this.z != null) {
                        FullRewardExpressView.this.z.setPauseFromExpressView(true);
                    }
                }
                FullRewardExpressView.this.zw.add(str);
            }
        };
        com.bytedance.sdk.openadsdk.core.video.g.z zVar = this.dl;
        if (zVar != null) {
            zVar.a(50);
            this.dl.z(this.sy);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f) {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.z(f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void m() {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.m();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void dl(int i) {
        uy uyVar = this.z;
        if (uyVar != null) {
            uyVar.dl(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.g.gz
    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
        FullSwiperItemView.z zVar = this.hh;
        if (zVar != null) {
            zVar.z();
        }
        if (i != -1 && dlVar != null && i == 3) {
            uy();
            return;
        }
        if (i == 5) {
            z(!this.tb);
        } else if (i == 4) {
            zw();
        } else {
            super.z(view, i, dlVar);
        }
    }

    private void zw() {
        com.bytedance.sdk.openadsdk.core.video.g.z zVar;
        if ((this.f970a instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z) && (zVar = this.dl) != null) {
            if (zVar.f()) {
                this.dl.m();
                g(true);
            } else {
                this.dl.gz();
                g(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        dl(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.g.gz
    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, int i2) {
        FullSwiperItemView.z zVar = this.hh;
        if (zVar != null) {
            zVar.z();
        }
        if (i != -1 && dlVar != null && i == 3) {
            uy();
        } else {
            super.z(view, i, dlVar, i2);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (q()) {
            return this.g.getVideoContainer();
        }
        return this.v;
    }

    public void setVideoController(com.bykv.vk.openvk.component.video.api.a.dl dlVar) {
        if (dlVar instanceof com.bytedance.sdk.openadsdk.core.video.g.z) {
            com.bytedance.sdk.openadsdk.core.video.g.z zVar = (com.bytedance.sdk.openadsdk.core.video.g.z) dlVar;
            this.dl = zVar;
            zVar.a(50);
            this.dl.z(this.sy);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.a.dl getVideoController() {
        return this.dl;
    }

    protected void g(boolean z2) {
        if (this.iq == null) {
            this.iq = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.uy.ls().xl() != null) {
                this.iq.setImageBitmap(com.bytedance.sdk.openadsdk.core.uy.ls().xl());
            } else {
                tb.z(zw.getContext(), "tt_new_play_video", this.iq);
            }
            this.iq.setScaleType(ImageView.ScaleType.FIT_XY);
            int iDl = oq.dl(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDl, iDl);
            layoutParams.gravity = 17;
            this.v.addView(this.iq, layoutParams);
        }
        if (z2) {
            this.iq.setVisibility(0);
        } else {
            this.iq.setVisibility(8);
        }
    }

    private void dl(boolean z2) {
        com.bytedance.sdk.openadsdk.core.video.g.z zVar;
        if ((this.f970a instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z) && z2) {
            ImageView imageView = this.iq;
            if (imageView != null && imageView.getVisibility() == 0 && (zVar = this.dl) != null) {
                zVar.m();
            } else {
                z(this.tb);
            }
        }
    }

    public void setOnVideoSizeChangeListener(z zVar) {
        this.io = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void i() {
        super.i();
        this.zw.clear();
    }

    public boolean v() {
        v vVar = this.gc;
        if (vVar == null) {
            return true;
        }
        return vVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.dl ? ((com.bytedance.sdk.openadsdk.core.ugeno.express.dl) vVar).ls() != null : (vVar.gz() == 0.0d || this.gc.fo() == 0.0d) ? false : true;
    }

    public v getRenderResult() {
        return this.gc;
    }

    public void z(int i, int i2, int i3, int i4) {
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar = this.l;
        if (zVar != null) {
            zVar.z(i, i2, i3, i4);
        }
    }
}
