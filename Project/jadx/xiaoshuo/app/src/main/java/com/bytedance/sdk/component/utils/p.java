package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class p extends TouchDelegate {
    private Rect bf;
    private Rect d;
    private View e;
    private int ga;
    private boolean tg;

    public p(Rect rect, View view) {
        super(rect, view);
        this.bf = rect;
        this.ga = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.d = rect2;
        int i = this.ga;
        rect2.inset(-i, -i);
        this.e = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zContains;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z = this.tg;
                zContains = z ? this.d.contains(x, y) : true;
                z = z;
            } else if (action != 3) {
                zContains = true;
                z = false;
            } else {
                boolean z2 = this.tg;
                this.tg = false;
                z = z2;
                zContains = true;
            }
        } else if (this.bf.contains(x, y)) {
            this.tg = true;
            zContains = true;
        } else {
            this.tg = false;
            zContains = true;
            z = false;
        }
        if (!z) {
            return false;
        }
        View view = this.e;
        if (zContains) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.ga * 2);
            motionEvent.setLocation(f, f);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
