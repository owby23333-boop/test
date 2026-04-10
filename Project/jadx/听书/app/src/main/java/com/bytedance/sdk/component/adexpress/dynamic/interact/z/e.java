package com.bytedance.sdk.component.adexpress.dynamic.interact.z;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class e implements View.OnTouchListener {
    private static int dl = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.gz f569a;
    private float g;
    private int gc;
    private float z;
    private RectF m = new RectF();
    private long e = 0;
    private final int gz = 200;
    private final int fo = 3;
    private SoftReference<View> uy = new SoftReference<>(null);

    public e(com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar, int i, final ViewGroup viewGroup) {
        this.gc = dl;
        this.f569a = gzVar;
        if (i > 0) {
            this.gc = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.z.e.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    e.this.uy = new SoftReference(viewFindViewById);
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
        com.bytedance.sdk.component.adexpress.dynamic.interact.gz gzVar2;
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
            int iG = com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), Math.abs(rawX - this.z));
            int i = dl;
            if (fAbs < i || fAbs2 < i) {
                if ((System.currentTimeMillis() - this.e < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (gzVar = this.f569a) != null) {
                    gzVar.z();
                }
            } else if (rawX > this.z && iG > this.gc && (gzVar2 = this.f569a) != null) {
                gzVar2.z();
            }
        }
        return true;
    }
}
