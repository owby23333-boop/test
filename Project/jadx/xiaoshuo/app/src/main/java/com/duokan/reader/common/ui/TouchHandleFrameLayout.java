package com.duokan.reader.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class TouchHandleFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f4061a;

    public interface a {
        boolean a(MotionEvent motionEvent);

        boolean onTouchEvent(MotionEvent motionEvent);
    }

    public TouchHandleFrameLayout(@NonNull Context context) {
        super(context);
    }

    public a getTouchHandle() {
        return this.f4061a;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f4061a;
        return aVar != null ? aVar.a(motionEvent) : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f4061a;
        return aVar != null ? aVar.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void setTouchHandle(a aVar) {
        this.f4061a = aVar;
    }

    public TouchHandleFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchHandleFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
