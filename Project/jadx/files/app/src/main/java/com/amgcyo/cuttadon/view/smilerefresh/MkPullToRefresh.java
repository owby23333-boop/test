package com.amgcyo.cuttadon.view.smilerefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class MkPullToRefresh extends PullToRefreshView {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final int f5526k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private float f5527l0;

    public MkPullToRefresh(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5526k0 = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5527l0 = MotionEvent.obtain(motionEvent).getX();
        } else if (action == 2 && Math.abs(motionEvent.getX() - this.f5527l0) > this.f5526k0) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
