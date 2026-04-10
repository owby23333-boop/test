package com.bytedance.sdk.component.adexpress.dynamic.interact.e;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.dt;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
public class p implements View.OnTouchListener {
    private static int d = 10;
    private float bf;
    private float e;
    private int ga;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.p tg;
    private RectF vn = new RectF();
    private long p = 0;
    private final int v = 200;
    private final int zk = 3;
    private SoftReference<View> m = new SoftReference<>(null);

    public p(com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar, int i, final ViewGroup viewGroup) {
        this.ga = d;
        this.tg = pVar;
        if (i > 0) {
            this.ga = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.e.p.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup2 = viewGroup;
                    View viewFindViewById = viewGroup2.findViewById(dt.ga(viewGroup2.getContext(), "tt_splash_unlock_btn"));
                    p.this.m = new SoftReference(viewFindViewById);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.vn = e(this.m.get());
            this.e = motionEvent.getRawX();
            this.bf = motionEvent.getRawY();
            this.p = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.vn;
            if (rectF != null && !rectF.contains(this.e, this.bf)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.e);
            float fAbs2 = Math.abs(rawY - this.bf);
            int iBf = com.bytedance.sdk.component.adexpress.d.bf.bf(com.bytedance.sdk.component.adexpress.tg.getContext(), Math.abs(rawX - this.e));
            int i = d;
            if (fAbs < i || fAbs2 < i) {
                if ((System.currentTimeMillis() - this.p < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (pVar = this.tg) != null) {
                    pVar.e();
                }
            } else if (rawX > this.e && iBf > this.ga && (pVar2 = this.tg) != null) {
                pVar2.e();
            }
        }
        return true;
    }

    private RectF e(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }
}
