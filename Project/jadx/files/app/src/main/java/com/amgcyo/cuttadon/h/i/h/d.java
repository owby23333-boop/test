package com.amgcyo.cuttadon.h.i.h;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SplashZoomOutLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f3998s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f3999t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f4000u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4001v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f4002w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f4003x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f4004y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int f4005z;

    /* JADX INFO: compiled from: SplashZoomOutLayout.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View view = (View) d.this.getParent();
            if (view == null) {
                return;
            }
            int width = view.getWidth();
            int height = view.getHeight();
            d dVar = d.this;
            dVar.f4002w = (height - dVar.getHeight()) - d.this.f4000u;
            d dVar2 = d.this;
            dVar2.f4001v = (width - dVar2.getWidth()) - d.this.f4000u;
        }
    }

    public d(Context context, int i2) {
        super(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(10.0f);
        setBackgroundDrawable(gradientDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(true);
        }
        this.f4000u = i2;
        this.f4005z = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[PHI: r4
  0x0043: PHI (r4v15 int) = (r4v9 int), (r4v10 int) binds: [B:10:0x0041, B:13:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054 A[PHI: r4
  0x0054: PHI (r4v14 int) = (r4v11 int), (r4v12 int) binds: [B:16:0x0052, B:19:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.h.i.h.d.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }
}
