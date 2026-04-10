package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class OwnNativeAdView extends FrameLayout {
    int a;
    int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f6236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f6238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f6239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f6240g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f6241h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f6242i;

    public interface a {
        void a();
    }

    public OwnNativeAdView(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = (int) motionEvent.getRawX();
            this.b = (int) motionEvent.getRawY();
            this.f6238e = (int) motionEvent.getX();
            this.f6239f = (int) motionEvent.getY();
        } else if (action == 1 || action == 3) {
            this.f6236c = (int) motionEvent.getRawX();
            this.f6237d = (int) motionEvent.getRawY();
            this.f6240g = (int) motionEvent.getX();
            this.f6241h = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.anythink.basead.c.a getAdClickRecord() {
        com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
        aVar.a = this.a;
        aVar.b = this.b;
        aVar.f5886c = this.f6236c;
        aVar.f5887d = this.f6237d;
        aVar.f5888e = this.f6238e;
        aVar.f5889f = this.f6239f;
        aVar.f5890g = this.f6240g;
        aVar.f5891h = this.f6241h;
        return aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setWindowEventListener(a aVar) {
        this.f6242i = aVar;
    }

    public OwnNativeAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OwnNativeAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
