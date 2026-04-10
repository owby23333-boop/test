package com.amgcyo.cuttadon.widget.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class ObservableScrollView extends ScrollView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private a f5687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5688t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5689u;

    public interface a {
        void onScrollChanged(ObservableScrollView observableScrollView, int i2, int i3, int i4, int i5);
    }

    public ObservableScrollView(Context context) {
        super(context);
        this.f5687s = null;
        this.f5689u = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5688t = (int) motionEvent.getRawY();
        } else if (action == 2 && Math.abs(((int) motionEvent.getRawY()) - this.f5688t) > this.f5689u) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a aVar = this.f5687s;
        if (aVar != null) {
            aVar.onScrollChanged(this, i2, i3, i4, i5);
        }
    }

    public void setScrollViewListener(a aVar) {
        this.f5687s = aVar;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5687s = null;
        this.f5689u = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5687s = null;
        this.f5689u = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
