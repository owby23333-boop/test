package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.k.h;

/* JADX INFO: loaded from: classes2.dex */
public class RoundCornerRelativeLayout extends RelativeLayout {
    private Path a;
    private Paint b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RectF f6296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f6297d;

    public RoundCornerRelativeLayout(Context context) {
        super(context);
        this.f6297d = 0.0f;
        a();
    }

    private void a() {
        this.f6297d = h.a(getContext(), 12.0f);
        this.a = new Path();
        this.b = new Paint(1);
        this.f6296c = new RectF();
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    private Path b() {
        this.a.reset();
        Path path = this.a;
        RectF rectF = this.f6296c;
        float f2 = this.f6297d;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        this.a.reset();
        Path path = this.a;
        RectF rectF = this.f6296c;
        float f2 = this.f6297d;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        canvas.clipPath(this.a);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f6296c.set(0.0f, 0.0f, i2, i3);
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6297d = 0.0f;
        a();
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6297d = 0.0f;
        a();
    }

    @RequiresApi(api = 21)
    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f6297d = 0.0f;
        a();
    }
}
