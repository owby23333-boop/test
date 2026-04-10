package com.qmuiteam.qmui.widget.tab;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.qmuiteam.qmui.util.QMUIColorHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITabIcon extends Drawable implements Drawable.Callback {
    public static final int TAB_ICON_INTRINSIC = -1;
    private float mCurrentSelectFraction;
    private boolean mDynamicChangeIconColor;
    private Drawable mNormalIconDrawable;
    private Drawable mSelectedIconDrawable;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public QMUITabIcon(Drawable drawable, Drawable drawable2) {
        this(drawable, drawable2, true);
    }

    public QMUITabIcon(Drawable drawable, Drawable drawable2, boolean z) {
        this.mCurrentSelectFraction = 0.0f;
        this.mDynamicChangeIconColor = true;
        Drawable drawableMutate = drawable.mutate();
        this.mNormalIconDrawable = drawableMutate;
        drawableMutate.setCallback(this);
        if (drawable2 != null) {
            Drawable drawableMutate2 = drawable2.mutate();
            this.mSelectedIconDrawable = drawableMutate2;
            drawableMutate2.setCallback(this);
        }
        this.mNormalIconDrawable.setAlpha(255);
        int intrinsicWidth = this.mNormalIconDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.mNormalIconDrawable.getIntrinsicHeight();
        this.mNormalIconDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        Drawable drawable3 = this.mSelectedIconDrawable;
        if (drawable3 != null) {
            drawable3.setAlpha(0);
            this.mSelectedIconDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        this.mDynamicChangeIconColor = z;
    }

    public boolean hasSelectedIcon() {
        return this.mSelectedIconDrawable != null;
    }

    public void tint(int i, int i2) {
        if (this.mSelectedIconDrawable == null) {
            DrawableCompat.setTint(this.mNormalIconDrawable, QMUIColorHelper.computeColor(i, i2, this.mCurrentSelectFraction));
        } else {
            DrawableCompat.setTint(this.mNormalIconDrawable, i);
            DrawableCompat.setTint(this.mSelectedIconDrawable, i2);
        }
        invalidateSelf();
    }

    public void tintNormal(int i) {
        DrawableCompat.setTint(this.mNormalIconDrawable, i);
        invalidateSelf();
    }

    public void tintSelected(int i) {
        Drawable drawable = this.mSelectedIconDrawable;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
            invalidateSelf();
        }
    }

    public void srcNormal(Drawable drawable) {
        int i = (int) ((1.0f - this.mCurrentSelectFraction) * 255.0f);
        this.mNormalIconDrawable.setCallback(null);
        Drawable drawableMutate = drawable.mutate();
        this.mNormalIconDrawable = drawableMutate;
        drawableMutate.setCallback(this);
        this.mNormalIconDrawable.setAlpha(i);
        invalidateSelf();
    }

    public void srcSelected(Drawable drawable) {
        int i = (int) (this.mCurrentSelectFraction * 255.0f);
        Drawable drawable2 = this.mSelectedIconDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Drawable drawableMutate = drawable.mutate();
        this.mSelectedIconDrawable = drawableMutate;
        drawableMutate.setCallback(this);
        this.mSelectedIconDrawable.setAlpha(i);
        invalidateSelf();
    }

    public void src(Drawable drawable, Drawable drawable2) {
        int i = (int) ((1.0f - this.mCurrentSelectFraction) * 255.0f);
        this.mNormalIconDrawable.setCallback(null);
        Drawable drawableMutate = drawable.mutate();
        this.mNormalIconDrawable = drawableMutate;
        drawableMutate.setCallback(this);
        this.mNormalIconDrawable.setAlpha(i);
        Drawable drawable3 = this.mSelectedIconDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        Drawable drawableMutate2 = drawable2.mutate();
        this.mSelectedIconDrawable = drawableMutate2;
        drawableMutate2.setCallback(this);
        this.mSelectedIconDrawable.setAlpha(255 - i);
        invalidateSelf();
    }

    public void src(Drawable drawable, int i, int i2) {
        this.mNormalIconDrawable.setCallback(this);
        Drawable drawableMutate = drawable.mutate();
        this.mNormalIconDrawable = drawableMutate;
        drawableMutate.setCallback(this);
        Drawable drawable2 = this.mSelectedIconDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            this.mSelectedIconDrawable = null;
        }
        if (this.mDynamicChangeIconColor) {
            DrawableCompat.setTint(this.mNormalIconDrawable, QMUIColorHelper.computeColor(i, i2, this.mCurrentSelectFraction));
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mNormalIconDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mNormalIconDrawable.getIntrinsicHeight();
    }

    public void setSelectFraction(float f, int i) {
        float fConstrain = QMUILangHelper.constrain(f, 0.0f, 1.0f);
        this.mCurrentSelectFraction = fConstrain;
        if (this.mSelectedIconDrawable == null) {
            if (this.mDynamicChangeIconColor) {
                DrawableCompat.setTint(this.mNormalIconDrawable, i);
            }
        } else {
            int i2 = (int) ((1.0f - fConstrain) * 255.0f);
            this.mNormalIconDrawable.setAlpha(i2);
            this.mSelectedIconDrawable.setAlpha(255 - i2);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mNormalIconDrawable.draw(canvas);
        Drawable drawable = this.mSelectedIconDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mNormalIconDrawable.setBounds(rect);
        Drawable drawable = this.mSelectedIconDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(drawable);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }
}
