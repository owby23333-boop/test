package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkImageView extends ImageView {
    private static final String a = "MBridgeImageView";
    private Xfermode b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f11738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f11739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float[] f11740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float[] f11741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RectF f11742n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RectF f11743o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f11744p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f11745q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Path f11746r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Paint f11747s;

    public AnyThinkImageView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        a(canvas, this.f11738j, this.f11739k, this.f11743o, this.f11740l);
    }

    private void b() {
        int i2;
        int i3;
        int i4;
        try {
            if (this.f11740l == null || this.f11741m == null) {
                return;
            }
            int i5 = 0;
            while (true) {
                i2 = 2;
                if (i5 >= 2) {
                    break;
                }
                this.f11740l[i5] = this.f11734f;
                this.f11741m[i5] = this.f11734f - (this.f11738j / 2.0f);
                i5++;
            }
            while (true) {
                i3 = 4;
                if (i2 >= 4) {
                    break;
                }
                this.f11740l[i2] = this.f11735g;
                this.f11741m[i2] = this.f11735g - (this.f11738j / 2.0f);
                i2++;
            }
            while (true) {
                if (i3 >= 6) {
                    break;
                }
                this.f11740l[i3] = this.f11736h;
                this.f11741m[i3] = this.f11736h - (this.f11738j / 2.0f);
                i3++;
            }
            for (i4 = 6; i4 < 8; i4++) {
                this.f11740l[i4] = this.f11737i;
                this.f11741m[i4] = this.f11737i - (this.f11738j / 2.0f);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        RectF rectF = this.f11743o;
        if (rectF != null) {
            int i2 = this.f11738j;
            rectF.set(i2 / 2.0f, i2 / 2.0f, this.f11731c - (i2 / 2.0f), this.f11732d - (i2 / 2.0f));
        }
    }

    private void d() {
        RectF rectF = this.f11742n;
        if (rectF != null) {
            rectF.set(0.0f, 0.0f, this.f11731c, this.f11732d);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            canvas.saveLayer(this.f11742n, null, 31);
            canvas.scale(((this.f11731c - (this.f11738j * 2)) * 1.0f) / this.f11731c, ((this.f11732d - (this.f11738j * 2)) * 1.0f) / this.f11732d, this.f11731c / 2.0f, this.f11732d / 2.0f);
            super.onDraw(canvas);
            if (this.f11747s != null) {
                this.f11747s.reset();
                this.f11747s.setAntiAlias(true);
                this.f11747s.setStyle(Paint.Style.FILL);
                this.f11747s.setXfermode(this.b);
            }
            if (this.f11746r != null) {
                this.f11746r.reset();
                this.f11746r.addRoundRect(this.f11742n, this.f11741m, Path.Direction.CCW);
            }
            canvas.drawPath(this.f11746r, this.f11747s);
            if (this.f11747s != null) {
                this.f11747s.setXfermode(null);
            }
            canvas.restore();
            if (this.f11744p) {
                a(canvas, this.f11738j, this.f11739k, this.f11743o, this.f11740l);
            }
        } catch (Exception e2) {
            o.a(a, e2.getMessage());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        super.onSizeChanged(i2, i3, i4, i5);
        this.f11731c = i2;
        this.f11732d = i3;
        int i9 = 0;
        if (this.f11745q) {
            try {
                if (this.f11740l != null && this.f11741m != null) {
                    while (true) {
                        i6 = 2;
                        if (i9 >= 2) {
                            break;
                        }
                        this.f11740l[i9] = this.f11734f;
                        this.f11741m[i9] = this.f11734f - (this.f11738j / 2.0f);
                        i9++;
                    }
                    while (true) {
                        i7 = 4;
                        if (i6 >= 4) {
                            break;
                        }
                        this.f11740l[i6] = this.f11735g;
                        this.f11741m[i6] = this.f11735g - (this.f11738j / 2.0f);
                        i6++;
                    }
                    while (true) {
                        if (i7 >= 6) {
                            break;
                        }
                        this.f11740l[i7] = this.f11736h;
                        this.f11741m[i7] = this.f11736h - (this.f11738j / 2.0f);
                        i7++;
                    }
                    for (i8 = 6; i8 < 8; i8++) {
                        this.f11740l[i8] = this.f11737i;
                        this.f11741m[i8] = this.f11737i - (this.f11738j / 2.0f);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (this.f11740l != null && this.f11741m != null) {
            while (i9 < this.f11740l.length) {
                try {
                    this.f11740l[i9] = this.f11733e;
                    this.f11741m[i9] = this.f11733e - (this.f11738j / 2.0f);
                    i9++;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        RectF rectF = this.f11743o;
        if (rectF != null) {
            int i10 = this.f11738j;
            rectF.set(i10 / 2.0f, i10 / 2.0f, this.f11731c - (i10 / 2.0f), this.f11732d - (i10 / 2.0f));
        }
        RectF rectF2 = this.f11742n;
        if (rectF2 != null) {
            rectF2.set(0.0f, 0.0f, this.f11731c, this.f11732d);
        }
    }

    public void setBorder(int i2, int i3, int i4) {
        this.f11744p = true;
        this.f11738j = i3;
        this.f11739k = i4;
        this.f11733e = i2;
    }

    public void setCornerRadius(int i2) {
        this.f11733e = i2;
    }

    public void setCustomBorder(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f11744p = true;
        this.f11745q = true;
        this.f11738j = i6;
        this.f11739k = i7;
        this.f11734f = i2;
        this.f11736h = i4;
        this.f11735g = i3;
        this.f11737i = i5;
    }

    public AnyThinkImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas, int i2, int i3, RectF rectF, float[] fArr) {
        try {
            a(i2, i3);
            if (this.f11746r != null) {
                this.f11746r.addRoundRect(rectF, fArr, Path.Direction.CCW);
            }
            if (canvas != null) {
                canvas.drawPath(this.f11746r, this.f11747s);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public AnyThinkImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11746r = new Path();
        this.f11747s = new Paint();
        this.f11740l = new float[8];
        this.f11741m = new float[8];
        this.f11743o = new RectF();
        this.f11742n = new RectF();
        this.b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    private void a(int i2, int i3) {
        Path path = this.f11746r;
        if (path != null) {
            path.reset();
        }
        Paint paint = this.f11747s;
        if (paint != null) {
            paint.setStrokeWidth(i2);
            this.f11747s.setColor(i3);
            this.f11747s.setStyle(Paint.Style.STROKE);
        }
    }

    private void a() {
        if (this.f11740l == null || this.f11741m == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f11740l.length; i2++) {
            try {
                this.f11740l[i2] = this.f11733e;
                this.f11741m[i2] = this.f11733e - (this.f11738j / 2.0f);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }
}
