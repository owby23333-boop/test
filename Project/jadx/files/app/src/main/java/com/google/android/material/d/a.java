package com.google.android.material.d;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: InsetDialogOnTouchListener.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final Dialog f15225s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f15226t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f15227u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f15228v;

    public a(@NonNull Dialog dialog, @NonNull Rect rect) {
        this.f15225s = dialog;
        this.f15226t = rect.left;
        this.f15227u = rect.top;
        this.f15228v = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f15226t + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, this.f15227u + viewFindViewById.getTop(), width, viewFindViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i2 = this.f15228v;
            motionEventObtain.setLocation((-i2) - 1, (-i2) - 1);
        }
        view.performClick();
        return this.f15225s.onTouchEvent(motionEventObtain);
    }
}
