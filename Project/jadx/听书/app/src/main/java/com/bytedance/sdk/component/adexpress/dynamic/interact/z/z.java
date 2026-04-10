package com.bytedance.sdk.component.adexpress.dynamic.interact.z;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class z implements View.OnTouchListener {
    private static int dl = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gz f574a;
    private float g;
    private int gc;
    private float z;
    private RectF m = new RectF();
    private long e = 0;
    private final int gz = 200;
    private final int fo = 3;
    private SoftReference<ViewGroup> uy = new SoftReference<>(null);

    public z(com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar, int i, final ViewGroup viewGroup) {
        this.gc = dl;
        this.f574a = gzVar;
        if (i > 0) {
            this.gc = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.z.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.uy = new SoftReference(viewGroup);
                }
            });
        }
    }

    private RectF z(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.m = z(this.uy.get());
            this.z = motionEvent.getRawX();
            this.g = motionEvent.getRawY();
            this.e = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.m;
            if (rectF != null && !rectF.contains(this.z, this.g)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.z);
            float fAbs2 = Math.abs(rawY - this.g);
            int i = this.gc;
            if (fAbs >= i && fAbs2 >= i) {
                com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar2 = this.f574a;
                if (gzVar2 != null) {
                    gzVar2.z();
                }
            } else if ((System.currentTimeMillis() - this.e < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (gzVar = this.f574a) != null) {
                gzVar.z();
            }
        }
        return true;
    }
}
