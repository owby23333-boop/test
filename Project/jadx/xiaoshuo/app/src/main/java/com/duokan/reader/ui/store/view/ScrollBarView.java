package com.duokan.reader.ui.store.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.yuewen.yt2;

/* JADX INFO: loaded from: classes5.dex */
public class ScrollBarView extends FrameLayout implements GestureDetector.OnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureDetector f6539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f6540b;
    public a c;
    public int d;
    public Runnable e;
    public boolean f;

    public interface a {
        void a(float f);
    }

    public ScrollBarView(Context context) {
        super(context);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f6540b.startAnimation(AnimationUtils.loadAnimation(getContext(), yt2.a.d1));
        this.f6540b.setVisibility(8);
    }

    public final void b() {
        this.f6539a = new GestureDetector(getContext(), this);
    }

    public void d() {
        removeCallbacks(this.e);
    }

    public void e() {
        removeCallbacks(this.e);
        postDelayed(this.e, 1000L);
    }

    public void f(float f) {
        if (this.f) {
            return;
        }
        this.f6540b.setY(f * (this.d - r0.getMeasuredHeight()));
    }

    public View getScrollBar() {
        return this.f6540b;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f6540b = findViewById(yt2.k.Z4);
        this.e = new Runnable() { // from class: com.yuewen.jc3
            @Override // java.lang.Runnable
            public final void run() {
                this.f12887a.c();
            }
        };
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        d();
        this.f6540b.setVisibility(0);
        float y = this.f6540b.getY();
        float f3 = -f2;
        if (y == 0.0f && f3 < 0.0f) {
            return true;
        }
        float f4 = y + f3;
        float measuredHeight = f4 > 0.0f ? f4 : 0.0f;
        if (measuredHeight >= this.d - this.f6540b.getMeasuredHeight()) {
            measuredHeight = this.d - this.f6540b.getMeasuredHeight();
        }
        this.f = true;
        this.f6540b.setY(measuredHeight);
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(measuredHeight / (this.d - this.f6540b.getMeasuredHeight()));
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.f6540b.getVisibility() != 0) {
            return false;
        }
        d();
        this.f6540b.setY((int) motionEvent.getY());
        this.f = true;
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(motionEvent.getY() / (this.d - this.f6540b.getMeasuredHeight()));
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f6539a.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            e();
            this.f = false;
        }
        return true;
    }

    public void setOnScrollListener(a aVar) {
        this.c = aVar;
    }

    public void setScrollHeight(int i) {
        this.d = i - 20;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.d;
            setLayoutParams(layoutParams);
        }
    }

    public ScrollBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ScrollBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
