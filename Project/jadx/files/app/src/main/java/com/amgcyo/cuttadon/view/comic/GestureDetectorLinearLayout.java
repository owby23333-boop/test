package com.amgcyo.cuttadon.view.comic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;

/* JADX INFO: loaded from: classes.dex */
public class GestureDetectorLinearLayout extends LinearLayout implements GestureDetector.OnDoubleTapListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private GestureDetectorCompat f4465s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.github.chrisbanes.photoview.i f4466t;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (GestureDetectorLinearLayout.this.f4466t != null) {
                GestureDetectorLinearLayout.this.f4466t.onLongPress(motionEvent.getRawX(), motionEvent.getRawY());
            }
        }
    }

    public GestureDetectorLinearLayout(Context context) {
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
        com.github.chrisbanes.photoview.i iVar = this.f4466t;
        if (iVar == null) {
            return false;
        }
        iVar.onSingleTap(motionEvent.getRawX(), motionEvent.getRawY());
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f4465s.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setTapListenerListener(com.github.chrisbanes.photoview.i iVar) {
        this.f4466t = iVar;
    }

    public GestureDetectorLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureDetectorLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setClickable(true);
        this.f4465s = new GestureDetectorCompat(getContext(), new a());
        this.f4465s.setOnDoubleTapListener(this);
    }
}
