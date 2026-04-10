package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.lxj.xpopup.c.b;

/* JADX INFO: loaded from: classes3.dex */
public class PartShadowContainer extends FrameLayout {
    public boolean isDismissOnTouchOutside;
    private b listener;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f17595x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f17596y;

    public PartShadowContainer(@NonNull Context context) {
        super(context);
        this.isDismissOnTouchOutside = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        View childAt = getChildAt(0);
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (!com.lxj.xpopup.util.b.a(motionEvent.getRawX(), motionEvent.getRawY(), new Rect(iArr[0], iArr[1], iArr[0] + childAt.getMeasuredWidth(), iArr[1] + childAt.getMeasuredHeight()))) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f17595x = motionEvent.getX();
                this.f17596y = motionEvent.getY();
            } else if (action == 1 || action == 2 || action == 3) {
                if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.f17595x, 2.0d) + Math.pow(motionEvent.getY() - this.f17596y, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.isDismissOnTouchOutside && (bVar = this.listener) != null) {
                    bVar.a();
                }
                this.f17595x = 0.0f;
                this.f17596y = 0.0f;
            }
        }
        return true;
    }

    public void setOnClickOutsideListener(b bVar) {
        this.listener = bVar;
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.isDismissOnTouchOutside = true;
    }
}
