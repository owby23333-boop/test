package com.duokan.advertisement.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes12.dex */
public class PageAdRootView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2702b;
    public int c;
    public boolean d;

    public PageAdRootView(@NonNull Context context) {
        super(context);
        this.f2701a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f2702b = 0;
        this.c = 0;
        this.d = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f2702b = (int) motionEvent.getRawX();
            this.c = (int) motionEvent.getRawY();
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (Math.abs(rawX - this.f2702b) >= this.f2701a || Math.abs(rawY - this.c) >= this.f2701a) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r3) {
        /*
            r2 = this;
            boolean r0 = r2.d
            if (r0 == 0) goto L9
            boolean r3 = super.onTouchEvent(r3)
            return r3
        L9:
            int r3 = r3.getAction()
            r0 = 1
            if (r3 == r0) goto L1f
            r1 = 2
            if (r3 == r1) goto L17
            r1 = 3
            if (r3 == r1) goto L1f
            goto L27
        L17:
            android.view.ViewParent r3 = r2.getParent()
            r3.requestDisallowInterceptTouchEvent(r0)
            goto L27
        L1f:
            android.view.ViewParent r3 = r2.getParent()
            r1 = 0
            r3.requestDisallowInterceptTouchEvent(r1)
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.advertisement.ui.PageAdRootView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setEnable(boolean z) {
        this.d = z;
    }

    public PageAdRootView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2701a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f2702b = 0;
        this.c = 0;
        this.d = true;
    }
}
