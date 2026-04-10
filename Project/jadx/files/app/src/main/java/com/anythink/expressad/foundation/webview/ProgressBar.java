package com.anythink.expressad.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.webview.a;

/* JADX INFO: loaded from: classes2.dex */
public class ProgressBar extends View implements a {
    private static final float C = 1200.0f;
    private static final long L = 25;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f10733g = "ProgressBar";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f10734h = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final float f10735t = 0.05f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final float f10736u = 0.2f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final float f10737v = 0.4f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final float f10738w = 1.0f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final long f10739x = 2000;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final float f10740y = 0.2f;
    private int A;
    private int B;
    private long D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private Drawable H;
    private boolean I;
    private a.InterfaceC0211a J;
    private Handler K;
    private boolean M;
    private boolean N;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Runnable f10741f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Rect f10742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f10743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f10744k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f10745l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f10746m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f10747n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f10748o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f10749p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f10750q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f10751r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f10752s;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f10753z;

    public ProgressBar(Context context) {
        super(context);
        this.f10742i = new Rect();
        this.f10744k = 0.95f;
        this.D = L;
        this.I = false;
        this.K = new Handler(Looper.getMainLooper());
        this.f10741f = new Runnable() { // from class: com.anythink.expressad.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.N = false;
        setWillNotDraw(false);
    }

    private void a() {
        setWillNotDraw(false);
    }

    private float b() {
        if (this.f10747n) {
            if (this.M) {
                return 1.0f;
            }
            return f10737v;
        }
        if (this.f10751r < 2000) {
            if (this.A == 1) {
                if (this.M) {
                    return 1.0f;
                }
                return f10737v;
            }
            if (this.f10753z == 1) {
                if (this.M) {
                    return f10737v;
                }
                return 0.2f;
            }
            if (this.M) {
                return 0.2f;
            }
        }
        return f10735t;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.webview.ProgressBar.draw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean z2) {
        return null;
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public float getProgress() {
        return this.f10749p;
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void initResource(boolean z2) {
        if (z2 || (this.H == null && this.E == null && this.F == null && this.G == null)) {
            this.H = getResources().getDrawable(getResources().getIdentifier("anythink_cm_highlight", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
            Drawable drawable = this.H;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.H.getIntrinsicHeight());
            }
            this.E = getResources().getDrawable(getResources().getIdentifier("anythink_cm_head", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.E.getIntrinsicHeight());
            }
            this.F = getResources().getDrawable(getResources().getIdentifier("anythink_cm_tail", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
            this.G = getResources().getDrawable(getResources().getIdentifier("anythink_cm_end_animation", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f10743j = getMeasuredWidth();
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void onThemeChange() {
        if (this.I) {
            initResource(true);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        Drawable drawable = this.H;
        if (drawable != null) {
            double intrinsicWidth = drawable.getIntrinsicWidth();
            Double.isNaN(intrinsicWidth);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * 1.5d), getHeight());
        }
        Drawable drawable2 = this.E;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setPaused(boolean z2) {
        this.N = z2;
        if (z2) {
            return;
        }
        this.f10745l = System.currentTimeMillis();
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setProgress(float f2, boolean z2) {
        if (!z2 || f2 < 1.0f) {
            return;
        }
        startEndAnimation();
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setProgressBarListener(a.InterfaceC0211a interfaceC0211a) {
        this.J = interfaceC0211a;
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setProgressState(int i2) {
        if (i2 == 5) {
            this.f10753z = 1;
            this.A = 0;
            this.B = 0;
            this.f10751r = 0L;
            return;
        }
        if (i2 == 6) {
            this.A = 1;
            if (this.B == 1) {
                startEndAnimation();
            }
            this.f10751r = 0L;
            return;
        }
        if (i2 == 7) {
            startEndAnimation();
        } else {
            if (i2 != 8) {
                return;
            }
            this.B = 1;
            if (this.A == 1) {
                startEndAnimation();
            }
        }
    }

    @Override // android.view.View, com.anythink.expressad.foundation.webview.a
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void setVisible(boolean z2) {
        if (!z2) {
            setVisibility(4);
            return;
        }
        this.M = true;
        this.f10745l = System.currentTimeMillis();
        this.f10746m = 0.0f;
        this.f10751r = 0L;
        this.f10747n = false;
        this.f10748o = 0.0f;
        this.f10749p = 0.0f;
        this.f10743j = getMeasuredWidth();
        this.N = false;
        this.f10753z = 0;
        this.A = 0;
        this.B = 0;
        Drawable drawable = this.H;
        if (drawable != null) {
            this.f10752s = -drawable.getIntrinsicWidth();
        } else {
            this.f10752s = 0;
        }
        Drawable drawable2 = this.F;
        if (drawable2 != null) {
            drawable2.setAlpha(255);
        }
        Drawable drawable3 = this.G;
        if (drawable3 != null) {
            drawable3.setAlpha(255);
        }
        Drawable drawable4 = this.E;
        if (drawable4 != null) {
            drawable4.setAlpha(255);
        }
        setVisibility(0);
        invalidate();
    }

    @Override // com.anythink.expressad.foundation.webview.a
    public void startEndAnimation() {
        if (this.f10747n) {
            return;
        }
        this.f10747n = true;
        this.f10748o = 0.0f;
    }

    private void a(Canvas canvas, float f2) {
        Drawable drawable;
        Drawable drawable2;
        if (this.f10747n) {
            int i2 = (int) ((1.0f - (this.f10748o / (this.f10743j * 0.5f))) * 255.0f);
            if (i2 < 0) {
                i2 = 0;
            }
            if (this.f10748o > this.f10743j * 0.5f) {
                setVisible(false);
            }
            Drawable drawable3 = this.F;
            if (drawable3 != null) {
                drawable3.setAlpha(i2);
            }
            Drawable drawable4 = this.G;
            if (drawable4 != null) {
                drawable4.setAlpha(i2);
            }
            Drawable drawable5 = this.E;
            if (drawable5 != null) {
                drawable5.setAlpha(i2);
            }
            canvas.save();
            canvas.translate(this.f10748o, 0.0f);
        }
        if (this.F != null && this.E != null) {
            int iWidth = (int) (this.f10742i.width() - (this.E.getIntrinsicWidth() * f10735t));
            Drawable drawable6 = this.F;
            drawable6.setBounds(0, 0, iWidth, drawable6.getIntrinsicHeight());
            this.F.draw(canvas);
        }
        if (this.f10747n && (drawable2 = this.G) != null && this.E != null) {
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            Drawable drawable7 = this.G;
            drawable7.setBounds(0, 0, intrinsicWidth, drawable7.getIntrinsicHeight());
            canvas.save();
            canvas.translate(-intrinsicWidth, 0.0f);
            this.G.draw(canvas);
            canvas.restore();
        }
        if (this.E != null) {
            canvas.save();
            canvas.translate(this.f10742i.width() - getWidth(), 0.0f);
            this.E.draw(canvas);
            canvas.restore();
        }
        if (!this.f10747n && Math.abs(this.f10749p - this.f10744k) < 1.0E-5f && (drawable = this.H) != null) {
            this.f10752s = (int) (this.f10752s + (f2 * 0.2f * this.f10743j));
            if (this.f10752s + drawable.getIntrinsicWidth() >= this.f10742i.width()) {
                this.f10752s = -this.H.getIntrinsicWidth();
            }
            canvas.save();
            canvas.translate(this.f10752s, 0.0f);
            this.H.draw(canvas);
            canvas.restore();
        }
        if (this.f10747n) {
            canvas.restore();
        }
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10742i = new Rect();
        this.f10744k = 0.95f;
        this.D = L;
        this.I = false;
        this.K = new Handler(Looper.getMainLooper());
        this.f10741f = new Runnable() { // from class: com.anythink.expressad.foundation.webview.ProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                ProgressBar.this.invalidate();
            }
        };
        this.N = false;
        setWillNotDraw(false);
    }
}
