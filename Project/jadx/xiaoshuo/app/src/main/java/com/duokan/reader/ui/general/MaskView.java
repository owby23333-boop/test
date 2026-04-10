package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.yuewen.az3;
import com.yuewen.e84;

/* JADX INFO: loaded from: classes5.dex */
public class MaskView extends FrameLayout {
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable f5488b;
    public Drawable c;
    public Bitmap d;
    public boolean e;

    public class a extends InsetDrawable {
        public a(Drawable drawable2, int i) {
            super(drawable2, i);
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if ((MaskView.this.f5487a & 1) == 1) {
                return;
            }
            super.draw(canvas);
        }
    }

    public class b extends InsetDrawable {
        public b(Drawable drawable2, int i) {
            super(drawable2, i);
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if ((MaskView.this.f5487a & 2) == 2) {
                return;
            }
            super.draw(canvas);
        }
    }

    public MaskView(Context context) {
        this(context, null);
    }

    public final void b(Canvas canvas) {
        this.f5487a |= 2;
        super.draw(canvas);
        this.f5487a &= -3;
    }

    public final void c(Canvas canvas) {
        this.f5487a |= 5;
        super.draw(canvas);
        this.f5487a &= -6;
    }

    public final void d() {
        Bitmap bitmap = this.d;
        if (bitmap == null) {
            return;
        }
        bitmap.recycle();
        this.d = null;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f5488b == null) {
            super.draw(canvas);
            return;
        }
        Bitmap bitmap = this.d;
        if (bitmap == null || bitmap.getWidth() != getWidth() || this.d.getHeight() != getHeight()) {
            d();
            this.d = com.duokan.core.utils.a.d(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.e = false;
        }
        if (!this.e) {
            Bitmap bitmapD = com.duokan.core.utils.a.d(this.d.getWidth(), this.d.getHeight(), Bitmap.Config.ARGB_8888);
            c(new Canvas(bitmapD));
            this.d.eraseColor(0);
            az3<Paint> az3Var = e84.h;
            Paint paintA = az3Var.a();
            Canvas canvas2 = new Canvas(this.d);
            b(canvas2);
            paintA.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas2.drawBitmap(bitmapD, 0.0f, 0.0f, paintA);
            if (!isInEditMode()) {
                bitmapD.recycle();
            }
            this.e = true;
            az3Var.d(paintA);
        }
        canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        if ((this.f5487a & 4) == 4) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.View
    public Drawable getBackground() {
        return this.c;
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.f5488b;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        this.e = false;
        invalidate(rect);
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable2) {
        if (this.c == drawable2) {
            return;
        }
        this.c = drawable2;
        super.setBackgroundDrawable(new a(this.c, 0));
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable2) {
        if (this.f5488b == drawable2) {
            return;
        }
        this.f5488b = drawable2;
        super.setForeground(new b(this.f5488b, 0));
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5487a = 0;
        this.d = null;
        this.e = false;
    }
}
