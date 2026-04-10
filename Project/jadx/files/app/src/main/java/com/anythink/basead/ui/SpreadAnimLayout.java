package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class SpreadAnimLayout extends FrameLayout {
    private Paint a;
    private ValueAnimator b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f6310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RectF f6311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RectF f6312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f6314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Paint f6316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f6317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f6318k;

    static class a {
        RectF a;
        int b;

        a() {
        }
    }

    public SpreadAnimLayout(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.f6317j || !this.f6318k) {
            super.draw(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        this.a.setAlpha(this.f6310c.b);
        RectF rectF = this.f6310c.a;
        int i2 = this.f6313f;
        canvas.drawRoundRect(rectF, i2, i2, this.a);
        RectF rectF2 = this.f6311d;
        int i3 = this.f6313f;
        canvas.drawRoundRect(rectF2, i3, i3, this.f6316i);
        canvas.restoreToCount(iSaveLayer);
        super.draw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = this.f6314g;
        setPadding(i4, i4, i4, i4);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.f6317j) {
            if (i2 == 0) {
                post(new Runnable() { // from class: com.anythink.basead.ui.SpreadAnimLayout.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpreadAnimLayout.this.startSpreadAnimation();
                    }
                });
                return;
            }
            ValueAnimator valueAnimator = this.b;
            if (valueAnimator != null) {
                valueAnimator.end();
            }
        }
    }

    public void setMaxSpreadDistance(int i2) {
        this.f6314g = i2;
    }

    public void startSpreadAnimation() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.f6317j = true;
        if (!this.f6318k) {
            this.f6311d = new RectF(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            this.f6312e = new RectF(this.f6311d);
            this.f6310c = new a();
            a aVar = this.f6310c;
            aVar.b = 255;
            aVar.a = this.f6312e;
            this.f6314g = Math.min(this.f6314g, Math.min((getWidth() - childAt.getWidth()) / 2, (getHeight() - childAt.getHeight()) / 2));
            this.b = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.b.setDuration(this.f6315h);
            this.b.setRepeatMode(1);
            this.b.setRepeatCount(-1);
            this.b.setInterpolator(new AccelerateDecelerateInterpolator());
            this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.SpreadAnimLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SpreadAnimLayout.this.f6310c.b = (int) ((1.0f - fFloatValue) * 255.0f);
                    SpreadAnimLayout.this.f6310c.a.set(SpreadAnimLayout.this.f6311d);
                    float f2 = -((int) (SpreadAnimLayout.this.f6314g * fFloatValue));
                    SpreadAnimLayout.this.f6310c.a.inset(f2, f2);
                    SpreadAnimLayout.this.invalidate();
                }
            });
            this.f6318k = true;
        }
        this.b.start();
    }

    public SpreadAnimLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpreadAnimLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6317j = true;
        setWillNotDraw(false);
        int color = getResources().getColor(h.a(context, "color_spread", i.f10646d));
        this.f6314g = getResources().getDimensionPixelSize(h.a(getContext(), "myoffer_spread_max_distance_normal", "dimen"));
        this.f6313f = h.a(context, 4.0f);
        this.f6315h = 1000;
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setAlpha(255);
        this.a.setColor(color);
        this.f6316i = new Paint(1);
        this.f6316i.setColor(-1);
        this.f6316i.setStyle(Paint.Style.FILL);
        this.f6316i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
