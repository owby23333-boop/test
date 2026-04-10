package com.bytedance.adsdk.ugeno.component.frame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.bf;
import com.bytedance.adsdk.ugeno.bf.wu;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UGFrameLayout extends FrameLayout {
    private Map<Integer, wu> bf;
    private bf e;

    public UGFrameLayout(Context context) {
        super(context);
    }

    public void e(bf bfVar) {
        this.e = bfVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.tg();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.ga();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.e(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, wu> map = this.bf;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        bf bfVar = this.e;
        if (bfVar != null) {
            bfVar.e(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        bf bfVar = this.e;
        if (bfVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] iArrE = bfVar.e(i, i2);
            super.onMeasure(iArrE[0], iArrE[1]);
        }
    }

    public void setEventMap(Map<Integer, wu> map) {
        this.bf = map;
    }
}
