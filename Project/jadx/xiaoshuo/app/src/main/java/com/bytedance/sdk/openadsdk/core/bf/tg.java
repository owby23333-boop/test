package com.bytedance.sdk.openadsdk.core.bf;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.a.l;
import com.bytedance.sdk.openadsdk.core.dt.zk;
import com.bytedance.sdk.openadsdk.core.lc;

/* JADX INFO: loaded from: classes10.dex */
public abstract class tg implements View.OnClickListener, View.OnTouchListener {
    private static float bf = 0.0f;
    private static float d = 0.0f;
    private static float e = 0.0f;
    private static long ga = 0;
    private static float tg = 0.0f;
    protected static int zk = 8;
    protected zk p = new zk();
    protected final com.bytedance.sdk.openadsdk.core.bf.e.tg v = new com.bytedance.sdk.openadsdk.core.bf.e.tg();
    protected final Context vn;

    public static class e {
        public double bf;
        public double d;
        public int e;
        public long tg;

        public e(int i, double d, double d2, long j) {
            this.e = i;
            this.bf = d;
            this.d = d2;
            this.tg = j;
        }
    }

    static {
        try {
            if (ViewConfiguration.get(lc.getContext()) != null) {
                zk = ViewConfiguration.get(lc.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public tg(Context context) {
        if (context == null) {
            this.vn = lc.getContext();
        } else {
            this.vn = context;
        }
    }

    public <T extends com.bytedance.sdk.openadsdk.core.bf.e.e> T e(Class<T> cls) {
        return (T) this.v.e(cls);
    }

    public abstract void e(View view, zk zkVar);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.bytedance.sdk.openadsdk.core.lc.ga.e()) {
            e(view, this.p);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        this.p.bf(motionEvent.getDeviceId());
        this.p.e(motionEvent.getToolType(0));
        this.p.d(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 1;
        if (actionMasked != 0) {
            i = 3;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    i2 = actionMasked != 3 ? -1 : 4;
                } else {
                    d += Math.abs(motionEvent.getX() - e);
                    tg += Math.abs(motionEvent.getY() - bf);
                    e = motionEvent.getX();
                    bf = motionEvent.getY();
                    long jCurrentTimeMillis = System.currentTimeMillis() - ga;
                    this.p.d(motionEvent.getRawX());
                    this.p.tg(motionEvent.getRawY());
                    if (Math.abs(this.p.s() - this.p.p()) >= zk || Math.abs(this.p.w() - this.p.v()) >= zk) {
                        this.p.e(false);
                    }
                    if (jCurrentTimeMillis > 200) {
                        float f = d;
                        int i3 = zk;
                        if (f > i3 || bf > i3) {
                        }
                    }
                    i = 2;
                }
                i = i2;
            } else {
                this.p.d(motionEvent.getRawX());
                this.p.tg(motionEvent.getRawY());
                if (Math.abs(this.p.s() - this.p.p()) >= zk || Math.abs(this.p.w() - this.p.v()) >= zk) {
                    this.p.e(false);
                }
                this.p.bf(System.currentTimeMillis());
                Point point = new Point((int) this.p.s(), (int) this.p.w());
                Context context = this.vn;
                if (context == null) {
                    context = lc.getContext();
                }
                com.bytedance.sdk.openadsdk.core.bf.e.bf bfVar = (com.bytedance.sdk.openadsdk.core.bf.e.bf) e(com.bytedance.sdk.openadsdk.core.bf.e.bf.class);
                if (bfVar != null) {
                    bfVar.e(this.p);
                    if (view != null && !bfVar.e(view, context) && bfVar.e((View) view.getParent(), point)) {
                        return true;
                    }
                }
            }
        } else {
            this.p.tg((int) motionEvent.getRawX());
            this.p.ga((int) motionEvent.getRawY());
            this.p.e(motionEvent.getRawX());
            this.p.bf(motionEvent.getRawY());
            this.p.e(System.currentTimeMillis());
            this.p.e(motionEvent.getToolType(0));
            this.p.bf(motionEvent.getDeviceId());
            this.p.d(motionEvent.getSource());
            ga = System.currentTimeMillis();
            this.p.e(true);
            l.e(motionEvent, this.vn);
            i = 0;
        }
        this.p.zk().put(motionEvent.getActionMasked(), new e(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }
}
