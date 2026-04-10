package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f1426a;
    private int e;
    private float gc;
    private boolean kb;
    private int m;
    private final z z;
    private boolean g = false;
    private boolean dl = false;
    private boolean gz = true;
    private boolean fo = false;
    private final View.OnTouchListener uy = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.v.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (v.this.z.pf()) {
                return v.this.g || !v.this.dl;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                v vVar = v.this;
                vVar.kb = vVar.z(motionEvent);
                v.this.f1426a = x;
                v.this.gc = y;
                v.this.m = (int) x;
                v.this.e = (int) y;
                v.this.gz = true;
                if (v.this.z != null && v.this.dl && !v.this.g) {
                    v.this.z.z(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - v.this.m) > 20.0f || Math.abs(y - v.this.e) > 20.0f) {
                    v.this.gz = false;
                }
                if (!v.this.g) {
                    v.this.gz = true;
                }
                v.this.fo = false;
                v.this.f1426a = 0.0f;
                v.this.gc = 0.0f;
                v.this.m = 0;
                if (v.this.z != null) {
                    v.this.z.z(view, v.this.gz);
                }
                v.this.kb = false;
            } else if (action != 2) {
                if (action == 3) {
                    v.this.kb = false;
                }
            } else if (v.this.g && !v.this.kb) {
                float f = x - v.this.f1426a;
                float f2 = y - v.this.gc;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (!v.this.fo) {
                    if (fAbs <= 20.0f && fAbs2 <= 20.0f) {
                        return true;
                    }
                    v.this.fo = true;
                }
                if (v.this.z != null) {
                    v.this.z.v();
                }
                v.this.f1426a = x;
                v.this.gc = y;
            }
            return v.this.g || !v.this.dl;
        }
    };

    public interface z {
        boolean pf();

        void v();

        void z(View view, boolean z);
    }

    public v(z zVar) {
        this.z = zVar;
    }

    public void z(View view) {
        if (view != null) {
            view.setOnTouchListener(this.uy);
        }
    }

    public void z(boolean z2) {
        this.dl = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iA = oq.a(zw.getContext().getApplicationContext());
        int iGc = oq.gc(zw.getContext().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = iA;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = iGc;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}
