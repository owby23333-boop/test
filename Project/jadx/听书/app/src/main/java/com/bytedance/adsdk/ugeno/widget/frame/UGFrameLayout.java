package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.dl;
import com.bytedance.adsdk.ugeno.dl.ls;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UGFrameLayout extends FrameLayout {
    private Map<Integer, ls> g;
    private dl z;

    public UGFrameLayout(Context context) {
        super(context);
    }

    public void setEventMap(Map<Integer, ls> map) {
        this.g = map;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        dl dlVar = this.z;
        if (dlVar != null) {
            int[] iArrZ = dlVar.z(i, i2);
            super.onMeasure(iArrZ[0], iArrZ[1]);
        } else {
            super.onMeasure(i, i2);
        }
        dl dlVar2 = this.z;
        if (dlVar2 != null) {
            dlVar2.dl();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.a();
        }
        super.onLayout(z, i, i2, i3, i4);
        dl dlVar2 = this.z;
        if (dlVar2 != null) {
            dlVar2.z(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, ls> map = this.g;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void z(dl dlVar) {
        this.z = dlVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.gc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.m();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.z(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        dl dlVar = this.z;
        if (dlVar != null) {
            dlVar.g(i, i2, i3, i4);
        }
    }
}
