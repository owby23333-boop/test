package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class e extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f790a;
    private Rect dl;
    private Rect g;
    private int gc;
    private View z;

    public e(Rect rect, View view) {
        super(rect, view);
        this.g = rect;
        this.gc = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.dl = rect2;
        int i = this.gc;
        rect2.inset(-i, -i);
        this.z = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zContains;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z = this.f790a;
                zContains = z ? this.dl.contains(x, y) : true;
                z = z;
            } else if (action != 3) {
                zContains = true;
                z = false;
            } else {
                boolean z2 = this.f790a;
                this.f790a = false;
                z = z2;
                zContains = true;
            }
        } else if (this.g.contains(x, y)) {
            this.f790a = true;
            zContains = true;
        } else {
            this.f790a = false;
            zContains = true;
            z = false;
        }
        if (!z) {
            return false;
        }
        View view = this.z;
        if (zContains) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.gc * 2);
            motionEvent.setLocation(f, f);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
