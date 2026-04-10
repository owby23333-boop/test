package com.mardous.discreteseekbar.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.mardous.discreteseekbar.a.d.b;

/* JADX INFO: compiled from: PopupIndicator.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private final WindowManager a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f17620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b.InterfaceC0500b f17621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int[] f17622e = new int[2];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Point f17623f = new Point();

    /* JADX INFO: compiled from: PopupIndicator.java */
    private class a extends FrameLayout implements b.InterfaceC0500b {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private com.mardous.discreteseekbar.a.a f17624s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f17625t;

        public a(Context context, AttributeSet attributeSet, int i2, String str, int i3, int i4) {
            super(context);
            this.f17624s = new com.mardous.discreteseekbar.a.a(context, attributeSet, i2, str, i3, i4);
            addView(this.f17624s, new FrameLayout.LayoutParams(-2, -2, 51));
        }

        @Override // com.mardous.discreteseekbar.a.d.b.InterfaceC0500b
        public void b() {
            if (b.this.f17621d != null) {
                b.this.f17621d.b();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            int measuredWidth = this.f17625t - (this.f17624s.getMeasuredWidth() / 2);
            com.mardous.discreteseekbar.a.a aVar = this.f17624s;
            aVar.layout(measuredWidth, 0, aVar.getMeasuredWidth() + measuredWidth, this.f17624s.getMeasuredHeight());
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            measureChildren(i2, i3);
            setMeasuredDimension(View.MeasureSpec.getSize(i2), this.f17624s.getMeasuredHeight());
        }

        public void a(int i2) {
            this.f17625t = i2;
            int measuredWidth = i2 - (this.f17624s.getMeasuredWidth() / 2);
            com.mardous.discreteseekbar.a.a aVar = this.f17624s;
            aVar.offsetLeftAndRight(measuredWidth - aVar.getLeft());
            if (isHardwareAccelerated()) {
                invalidate();
            }
        }

        @Override // com.mardous.discreteseekbar.a.d.b.InterfaceC0500b
        public void a() {
            if (b.this.f17621d != null) {
                b.this.f17621d.a();
            }
            b.this.b();
        }
    }

    public b(Context context, AttributeSet attributeSet, int i2, String str, int i3, int i4) {
        this.a = (WindowManager) context.getSystemService("window");
        this.f17620c = new a(context, attributeSet, i2, str, i3, i4);
    }

    private int b(int i2) {
        return (i2 & (-426521)) | 32768 | 8 | 16 | 512;
    }

    private void d() {
        this.f17620c.measure(View.MeasureSpec.makeMeasureSpec(this.f17623f.x, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f17623f.y, Integer.MIN_VALUE));
    }

    public void b() {
        if (c()) {
            this.b = false;
            this.a.removeViewImmediate(this.f17620c);
        }
    }

    public boolean c() {
        return this.b;
    }

    private void c(int i2) {
        this.f17620c.a(i2 + this.f17622e[0]);
    }

    public void a(String str) {
        b();
        a aVar = this.f17620c;
        if (aVar != null) {
            aVar.f17624s.a(str);
        }
    }

    public void a(b.InterfaceC0500b interfaceC0500b) {
        this.f17621d = interfaceC0500b;
    }

    public void a(CharSequence charSequence) {
        this.f17620c.f17624s.setValue(charSequence);
    }

    public void a(View view, Rect rect) {
        if (c()) {
            this.f17620c.f17624s.d();
            return;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken != null) {
            WindowManager.LayoutParams layoutParamsA = a(windowToken);
            layoutParamsA.gravity = 8388659;
            a(view, layoutParamsA, rect.bottom);
            this.b = true;
            c(rect.centerX());
            a(layoutParamsA);
        }
    }

    public void a(int i2) {
        if (c()) {
            c(i2);
        }
    }

    public void a() {
        this.f17620c.f17624s.c();
    }

    private void a(View view, WindowManager.LayoutParams layoutParams, int i2) {
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        this.f17623f.set(displayMetrics.widthPixels, displayMetrics.heightPixels);
        d();
        int measuredHeight = this.f17620c.getMeasuredHeight();
        int paddingBottom = this.f17620c.f17624s.getPaddingBottom();
        view.getLocationInWindow(this.f17622e);
        layoutParams.x = 0;
        layoutParams.y = (this.f17622e[1] - measuredHeight) + i2 + paddingBottom;
        layoutParams.width = this.f17623f.x;
        layoutParams.height = measuredHeight;
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        this.a.addView(this.f17620c, layoutParams);
        this.f17620c.f17624s.d();
    }

    private WindowManager.LayoutParams a(IBinder iBinder) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.flags = b(layoutParams.flags);
        layoutParams.type = 1000;
        layoutParams.token = iBinder;
        layoutParams.softInputMode = 3;
        layoutParams.setTitle("DiscreteSeekBar Indicator:" + Integer.toHexString(hashCode()));
        return layoutParams;
    }
}
