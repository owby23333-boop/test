package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Path f5054s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f5055t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f5056u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5057v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f5058w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f5059x;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.f5059x = 1;
        b();
    }

    private void a() {
        if (getWidth() == this.f5056u && getHeight() == this.f5057v && this.f5058w == this.f5055t) {
            return;
        }
        this.f5056u = getWidth();
        this.f5057v = getHeight();
        this.f5058w = this.f5055t;
        this.f5054s.reset();
        int i2 = this.f5059x;
        if (i2 == 1) {
            Path path = this.f5054s;
            RectF rectF = new RectF(0.0f, 0.0f, this.f5056u, this.f5057v);
            int i3 = this.f5055t;
            path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
            return;
        }
        if (i2 == 2) {
            Path path2 = this.f5054s;
            RectF rectF2 = new RectF(0.0f, 0.0f, this.f5056u, this.f5057v);
            int i4 = this.f5055t;
            path2.addRoundRect(rectF2, new float[]{i4, i4, 0.0f, 0.0f, 0.0f, 0.0f, i4, i4}, Path.Direction.CW);
            return;
        }
        if (i2 == 3) {
            Path path3 = this.f5054s;
            RectF rectF3 = new RectF(0.0f, 0.0f, this.f5056u, this.f5057v);
            int i5 = this.f5055t;
            path3.addRoundRect(rectF3, new float[]{i5, i5, i5, i5, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            return;
        }
        if (i2 == 4) {
            Path path4 = this.f5054s;
            RectF rectF4 = new RectF(0.0f, 0.0f, this.f5056u, this.f5057v);
            int i6 = this.f5055t;
            path4.addRoundRect(rectF4, new float[]{0.0f, 0.0f, i6, i6, i6, i6, 0.0f, 0.0f}, Path.Direction.CW);
            return;
        }
        if (i2 != 5) {
            return;
        }
        Path path5 = this.f5054s;
        RectF rectF5 = new RectF(0.0f, 0.0f, this.f5056u, this.f5057v);
        int i7 = this.f5055t;
        path5.addRoundRect(rectF5, new float[]{0.0f, 0.0f, 0.0f, 0.0f, i7, i7, i7, i7}, Path.Direction.CW);
    }

    private void b() {
        setBackground(new ColorDrawable(-1));
        this.f5054s = new Path();
        this.f5054s.setFillType(Path.FillType.EVEN_ODD);
        setCornerRadius(30);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f5059x == 0) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        a();
        canvas.clipPath(this.f5054s);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public void setCornerRadius(int i2) {
        this.f5055t = i2;
    }

    public void setRoundMode(int i2) {
        this.f5059x = i2;
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5059x = 1;
        b();
    }
}
