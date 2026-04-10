package com.amgcyo.cuttadon.view.comic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;

/* JADX INFO: loaded from: classes.dex */
public class GestureDetectorFrameLayout extends FrameLayout implements GestureDetector.OnDoubleTapListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private GestureDetectorCompat f4462s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.github.chrisbanes.photoview.i f4463t;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (GestureDetectorFrameLayout.this.f4463t != null) {
                GestureDetectorFrameLayout.this.f4463t.onLongPress(motionEvent.getRawX(), motionEvent.getRawY());
            }
        }
    }

    public GestureDetectorFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        com.github.chrisbanes.photoview.i iVar = this.f4463t;
        if (iVar == null) {
            return false;
        }
        iVar.onSingleTap(motionEvent.getRawX(), motionEvent.getRawY());
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f4462s.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setTapListenerListener(com.github.chrisbanes.photoview.i iVar) {
        this.f4463t = iVar;
    }

    public GestureDetectorFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureDetectorFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setClickable(true);
        this.f4462s = new GestureDetectorCompat(getContext(), new a());
        this.f4462s.setOnDoubleTapListener(this);
    }
}
