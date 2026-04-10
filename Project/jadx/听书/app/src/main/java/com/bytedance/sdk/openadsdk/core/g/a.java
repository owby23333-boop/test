package com.bytedance.sdk.openadsdk.core.g;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.gk.fo;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.un.io;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f1067a = 0.0f;
    private static float dl = 0.0f;
    protected static int fo = 8;
    private static float g;
    private static long gc;
    private static float z;
    protected uy e = new uy();
    protected final com.bytedance.sdk.openadsdk.core.g.z.a gz = new com.bytedance.sdk.openadsdk.core.g.z.a();
    protected final Context m;

    public void a() {
    }

    public void dl() {
    }

    public void gc(int i) {
    }

    protected abstract void z(View view, uy uyVar);

    public void z(zw zwVar) {
    }

    static {
        try {
            if (ViewConfiguration.get(com.bytedance.sdk.openadsdk.core.zw.getContext()) != null) {
                fo = ViewConfiguration.get(com.bytedance.sdk.openadsdk.core.zw.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public a(Context context) {
        if (context == null) {
            this.m = com.bytedance.sdk.openadsdk.core.zw.getContext();
        } else {
            this.m = context;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (fo.z()) {
            z(view, this.e);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        int i;
        this.e.dl(motionEvent.getDeviceId());
        this.e.g(motionEvent.getToolType(0));
        this.e.a(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 1;
        if (actionMasked == 0) {
            this.e.gc((int) motionEvent.getRawX());
            this.e.m((int) motionEvent.getRawY());
            this.e.z(motionEvent.getRawX());
            this.e.g(motionEvent.getRawY());
            this.e.z(System.currentTimeMillis());
            this.e.g(motionEvent.getToolType(0));
            this.e.dl(motionEvent.getDeviceId());
            this.e.a(motionEvent.getSource());
            gc = System.currentTimeMillis();
            this.e.z(true);
            io.z(motionEvent);
            i = 0;
        } else if (actionMasked != 1) {
            i = 2;
            if (actionMasked == 2) {
                dl += Math.abs(motionEvent.getX() - z);
                f1067a += Math.abs(motionEvent.getY() - g);
                z = motionEvent.getX();
                g = motionEvent.getY();
                long jCurrentTimeMillis = System.currentTimeMillis() - gc;
                this.e.dl(motionEvent.getRawX());
                this.e.a(motionEvent.getRawY());
                if (Math.abs(this.e.ls() - this.e.gz()) >= fo || Math.abs(this.e.p() - this.e.fo()) >= fo) {
                    this.e.z(false);
                }
                if (jCurrentTimeMillis > 200) {
                    float f = dl;
                    int i3 = fo;
                    if (f > i3 || g > i3) {
                    }
                }
            } else if (actionMasked != 3) {
                i2 = -1;
            } else {
                if (com.bytedance.sdk.component.adexpress.dynamic.g.z.z(view) && com.bytedance.sdk.component.adexpress.dynamic.g.z.g(view)) {
                    view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (view.isShown()) {
                                a aVar = a.this;
                                aVar.z(view, aVar.e);
                            }
                        }
                    });
                    return true;
                }
                i2 = 4;
            }
            i = i2;
        } else {
            this.e.dl(motionEvent.getRawX());
            this.e.a(motionEvent.getRawY());
            if (Math.abs(this.e.ls() - this.e.gz()) >= fo || Math.abs(this.e.p() - this.e.fo()) >= fo) {
                this.e.z(false);
            }
            this.e.g(System.currentTimeMillis());
            Context context = this.m;
            if (context == null) {
                context = com.bytedance.sdk.openadsdk.core.zw.getContext();
            }
            com.bytedance.sdk.openadsdk.core.g.z.g gVar = (com.bytedance.sdk.openadsdk.core.g.z.g) z(com.bytedance.sdk.openadsdk.core.g.z.g.class);
            if (gVar != null) {
                gVar.z(this.e);
            }
            if (com.bytedance.sdk.component.adexpress.dynamic.g.z.z(view)) {
                if (com.bytedance.sdk.component.adexpress.dynamic.g.z.z(view, this.e.ls(), this.e.p(), this.e.gz(), this.e.fo())) {
                    return false;
                }
                if (com.bytedance.sdk.component.adexpress.dynamic.g.z.g(view)) {
                    z(view, this.e);
                }
                return true;
            }
            if (gVar != null) {
                Point point = new Point((int) this.e.ls(), (int) this.e.p());
                if (view != null && !gVar.z(view, context) && gVar.z((View) view.getParent(), point)) {
                    return true;
                }
            }
            i = 3;
        }
        this.e.uy().put(motionEvent.getActionMasked(), new z(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public <T extends com.bytedance.sdk.openadsdk.core.g.z.z> T z(Class<T> cls) {
        return (T) this.gz.z(cls);
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f1068a;
        public double dl;
        public double g;
        public int z;

        public z(int i, double d, double d2, long j) {
            this.z = i;
            this.g = d;
            this.dl = d2;
            this.f1068a = j;
        }
    }
}
