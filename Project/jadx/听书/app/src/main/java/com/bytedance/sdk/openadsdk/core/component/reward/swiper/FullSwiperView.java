package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.x;
import com.bytedance.sdk.openadsdk.core.pf.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class FullSwiperView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f966a;
    private TTBaseVideoActivity dl;
    private boolean e;
    private List<Integer> fo;
    private List<z> g;
    private float gc;
    private List<Integer> gz;
    private boolean i;
    private List<FullSwiperItemView> kb;
    private String m;
    private AtomicBoolean pf;
    private List<Long> uy;
    private boolean v;
    private int wp;
    private BaseSwiper<ViewGroup> z;

    public FullSwiperView(TTBaseVideoActivity tTBaseVideoActivity) {
        super(tTBaseVideoActivity);
        this.e = false;
        this.i = true;
        this.v = true;
        this.pf = new AtomicBoolean(false);
        this.dl = tTBaseVideoActivity;
        this.gz = new ArrayList();
        this.fo = new ArrayList();
        this.uy = new ArrayList();
        this.z = new SwiperView(tTBaseVideoActivity);
        this.kb = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.z, layoutParams);
    }

    public FullSwiperView z(List<z> list) {
        this.g = list;
        return this;
    }

    public FullSwiperView z(float f) {
        this.f966a = f;
        return this;
    }

    public FullSwiperView g(float f) {
        this.gc = f;
        return this;
    }

    public FullSwiperView z(String str) {
        this.m = str;
        return this;
    }

    public void z() {
        hh hhVarDp;
        List<z> list = this.g;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.z.z(false).z(TtmlNode.TEXT_EMPHASIS_MARK_DOT).a(false).dl(false).g(false);
        this.z.setOnPageChangeListener(new com.bytedance.adsdk.ugeno.swiper.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.1
            @Override // com.bytedance.adsdk.ugeno.swiper.z
            public void z(boolean z, int i, int i2, boolean z2, boolean z3) {
                if (FullSwiperView.this.v && i == 1) {
                    return;
                }
                FullSwiperView.this.v = false;
                FullSwiperView.this.wp = i;
                FullSwiperItemView fullSwiperItemViewDl = FullSwiperView.this.dl(i);
                if (fullSwiperItemViewDl != null && FullSwiperView.this.wp != 0) {
                    fullSwiperItemViewDl.g(false);
                }
                FullSwiperItemView fullSwiperItemViewDl2 = FullSwiperView.this.dl(i - 1);
                if (fullSwiperItemViewDl2 != null) {
                    fullSwiperItemViewDl2.ls();
                    fullSwiperItemViewDl2.fv();
                }
                FullSwiperView.this.g(i + 1);
                if (!FullSwiperView.this.e && i > 0) {
                    FullSwiperView.this.e = true;
                    a.g(FullSwiperView.this.m);
                }
                int iIntValue = ((Integer) FullSwiperView.this.gz.get(i)).intValue();
                if (iIntValue > 0 && i != FullSwiperView.this.kb.size() - 1) {
                    FullSwiperView.this.uy.add(i, Long.valueOf(System.currentTimeMillis()));
                    int i3 = iIntValue / 1000;
                    int iMin = Math.min(x.g(false), i3);
                    int iMax = Math.max(i3 - x.g(false), 0);
                    if (iMin > 0) {
                        FullSwiperView.this.pf.set(false);
                        FullSwiperView.this.dl.z(-1, iMin, iMax);
                    } else {
                        if (x.v() != 1) {
                            if (FullSwiperView.this.pf.get()) {
                                return;
                            }
                            FullSwiperView.this.z(iIntValue);
                            return;
                        }
                        FullSwiperView.this.z(iIntValue);
                    }
                }
            }
        });
        for (z zVar : this.g) {
            na naVarZ = zVar.z();
            if (naVarZ != null && (hhVarDp = naVarZ.dp()) != null) {
                this.gz.add(Integer.valueOf((int) hhVarDp.g()));
                this.fo.add(0);
                this.uy.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.dl, zVar, this.f966a, this.gc);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.2
                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.z
                    public void z() {
                        if (x.v() == 0) {
                            FullSwiperView.this.m();
                            FullSwiperView.this.dl.b();
                        }
                        FullSwiperView.this.pf.set(true);
                    }
                });
                this.z.z(fullSwiperItemView);
                this.kb.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.kb.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.g
            public void z(View view, float f, float f2) {
                int iIntValue = ((Integer) FullSwiperView.this.gz.get(0)).intValue();
                if (iIntValue <= 0) {
                    FullSwiperView.this.z.gc();
                } else {
                    FullSwiperView.this.uy.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.z.gc();
                    if (FullSwiperView.this.kb.size() > 1) {
                        int i = iIntValue / 1000;
                        int iMin = Math.min(x.g(false), i);
                        int iMax = Math.max(i - x.g(false), 0);
                        if (iMin > 0) {
                            FullSwiperView.this.dl.z(-1, iMin, iMax);
                        } else {
                            FullSwiperView.this.z(iIntValue);
                        }
                    }
                }
                fullSwiperItemView2.g(true);
                FullSwiperView.this.g(1);
            }
        });
        fullSwiperItemView2.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        FullSwiperItemView fullSwiperItemViewDl = dl(i);
        if (fullSwiperItemViewDl != null) {
            fullSwiperItemViewDl.v();
        }
    }

    public void g() {
        FullSwiperItemView fullSwiperItemViewDl = dl(this.wp);
        if (fullSwiperItemViewDl != null) {
            fullSwiperItemViewDl.ls();
        }
        List<Long> list = this.uy;
        if (list != null && this.wp < list.size()) {
            this.fo.add(this.wp, Integer.valueOf(this.gz.get(this.wp).intValue() - ((int) (System.currentTimeMillis() - this.uy.get(this.wp).longValue()))));
        }
        m();
    }

    public void dl() {
        FullSwiperItemView fullSwiperItemViewDl = dl(this.wp);
        if (fullSwiperItemViewDl != null) {
            fullSwiperItemViewDl.p();
        }
        if (this.wp == this.kb.size() - 1) {
            return;
        }
        this.z.uy(this.wp);
        List<Integer> list = this.fo;
        if (list == null || this.wp >= list.size()) {
            return;
        }
        if (!this.i && !this.pf.get()) {
            z(this.fo.get(this.wp).intValue());
        }
        this.i = false;
    }

    public void a() {
        m();
    }

    public void gc() {
        for (FullSwiperItemView fullSwiperItemView : this.kb) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.js();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView dl(int i) {
        List<FullSwiperItemView> list = this.kb;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.kb.get(i);
    }

    public int getCurrentPosition() {
        return this.wp;
    }

    public void z(int i) {
        BaseSwiper<ViewGroup> baseSwiper;
        if (Math.min(x.g(false), i / 1000) <= 0 && (baseSwiper = this.z) != null) {
            baseSwiper.kb(i);
        }
    }

    public void m() {
        BaseSwiper<ViewGroup> baseSwiper = this.z;
        if (baseSwiper != null) {
            baseSwiper.m();
        }
    }

    public void e() {
        BaseSwiper<ViewGroup> baseSwiper = this.z;
        if (baseSwiper != null) {
            baseSwiper.uy(this.wp + 1);
        }
    }
}
