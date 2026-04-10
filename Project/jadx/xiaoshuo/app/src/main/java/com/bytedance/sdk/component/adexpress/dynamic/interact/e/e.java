package com.bytedance.sdk.component.adexpress.dynamic.interact.e;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.wu;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
public class e implements View.OnTouchListener {
    private static int d = 10;
    private float bf;
    private float e;
    private int ga;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.p tg;
    private RectF vn = new RectF();
    private long p = 0;
    private final int v = 200;
    private final int zk = 3;
    private SoftReference<ViewGroup> m = new SoftReference<>(null);

    public e(com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar, int i, final ViewGroup viewGroup) {
        this.ga = d;
        this.tg = pVar;
        if (i > 0) {
            this.ga = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.e.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.m = new SoftReference(viewGroup);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar;
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
            int i = this.ga;
            if (fAbs < i || fAbs2 < i) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.p;
                wu.bf("limittouch", "d:" + jCurrentTimeMillis + " a:" + fAbs + " b:" + fAbs2);
                if ((jCurrentTimeMillis < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (pVar = this.tg) != null) {
                    pVar.e();
                }
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.interact.p pVar2 = this.tg;
                if (pVar2 != null) {
                    pVar2.e();
                }
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
