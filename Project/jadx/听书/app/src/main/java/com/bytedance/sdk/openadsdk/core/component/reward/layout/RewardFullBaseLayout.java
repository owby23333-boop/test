package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class RewardFullBaseLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f961a;
    float dl;
    private FrameLayout e;
    private FrameLayout fo;
    protected TTProgressBar g;
    z gc;
    private FrameLayout gz;
    private FrameLayout i;
    private FrameLayout kb;
    private int ls;
    private FrameLayout m;
    private int p;
    private int pf;
    private FrameLayout uy;
    private int v;
    private FrameLayout wp;
    protected TTProgressBar z;

    public interface z {
        void z();
    }

    public RewardFullBaseLayout(Context context) {
        super(context);
    }

    public void z(com.bytedance.sdk.openadsdk.core.component.reward.a.z zVar) {
        FrameLayout frameLayoutGc = gc();
        this.m = frameLayoutGc;
        frameLayoutGc.setPadding(this.v, this.pf, this.ls, this.p);
        this.m.setClipChildren(false);
        this.m.addView(g());
        this.m.addView(dl());
        this.m.addView(a());
        addView(this.m);
        this.e.addView(zVar.fo());
        this.fo.addView(zVar.uy());
        this.uy.addView(zVar.kb());
    }

    private FrameLayout g() {
        this.i = gc();
        FrameLayout frameLayoutGc = gc();
        this.wp = frameLayoutGc;
        this.i.addView(frameLayoutGc);
        FrameLayout frameLayoutGc2 = gc();
        this.e = frameLayoutGc2;
        frameLayoutGc2.setVisibility(8);
        this.wp.addView(this.e);
        FrameLayout frameLayoutGc3 = gc();
        this.gz = frameLayoutGc3;
        frameLayoutGc3.setVisibility(8);
        this.wp.addView(this.gz);
        this.kb = gc();
        return this.i;
    }

    private FrameLayout dl() {
        FrameLayout frameLayoutGc = gc();
        this.fo = frameLayoutGc;
        return frameLayoutGc;
    }

    private FrameLayout a() {
        FrameLayout frameLayoutGc = gc();
        this.uy = frameLayoutGc;
        return frameLayoutGc;
    }

    private FrameLayout gc() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public FrameLayout getExpressFrameContainer() {
        return this.gz;
    }

    public FrameLayout getEndCardFrameContainer() {
        return this.fo;
    }

    public FrameLayout getWidgetFrameContainer() {
        return this.e;
    }

    public FrameLayout getTopFrameContainer() {
        return this.uy;
    }

    public FrameLayout getSceneFrame() {
        return this.wp;
    }

    public FrameLayout getSceneFrameContainer() {
        return this.i;
    }

    public FrameLayout getEasyPlayableContainer() {
        return this.kb;
    }

    public void z(int i) {
        if (this.z == null) {
            this.z = new TTProgressBar(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.z.setLayoutParams(layoutParams);
            try {
                this.z.setIndeterminateDrawable(tb.dl(getContext(), "tt_video_loading_progress_bar"));
            } catch (Throwable unused) {
            }
            addView(this.z);
        }
        this.z.setVisibility(i);
    }

    public void z(int i, TTProgressBar tTProgressBar) {
        TTProgressBar tTProgressBar2 = this.g;
        if (tTProgressBar2 != null) {
            tTProgressBar2.setVisibility(8);
            removeView(this.g);
        }
        if (tTProgressBar == null) {
            return;
        }
        this.g = tTProgressBar;
        addView(tTProgressBar);
        this.g.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gc == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.dl = motionEvent.getY();
            this.f961a = System.currentTimeMillis();
        } else if (action == 1) {
            float y = motionEvent.getY();
            float f = this.dl;
            if (y < f && Math.abs(y - f) > oq.dl(getContext(), 30.0f)) {
                this.gc.z();
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void z(z zVar) {
        this.gc = zVar;
    }

    public void z() {
        this.gc = null;
    }

    public void z(int i, int i2, int i3, int i4) {
        this.v = i;
        this.pf = i2;
        this.ls = i3;
        this.p = i4;
    }
}
