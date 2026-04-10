package com.kwad.components.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX INFO: loaded from: classes3.dex */
public class TextProgressBar extends ProgressBar {
    private Matrix NB;
    private boolean NC;
    private boolean ND;
    private boolean NE;
    private int NF;
    private int NG;
    private Drawable NH;
    private int NI;
    private Rect NJ;
    private int[] NK;
    private int NL;
    private int NM;
    private boolean NN;

    @Nullable
    private String Ny;
    private LinearGradient Nz;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(Wrapper.wrapContextIfNeed(context), attributeSet);
        this.ND = false;
        this.NE = true;
        this.NJ = new Rect();
        pm();
    }

    private void pm() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.b.kwai.a.a(getContext(), 12.0f));
        this.NI = com.kwad.sdk.b.kwai.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.NL = -1;
        this.NM = -117146;
    }

    private void setProgressText(int i2) {
        this.Ny = String.valueOf((int) (((i2 * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void f(String str, int i2) {
        this.Ny = str;
        this.NC = true;
        setProgress(i2);
        invalidate();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.ND) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.Ny)) {
            this.mPaint.getTextBounds(this.Ny, 0, this.Ny.length(), this.NJ);
        }
        int height = (getHeight() / 2) - this.NJ.centerY();
        if (this.NH != null) {
            int intrinsicWidth = this.NH.getIntrinsicWidth();
            int intrinsicHeight = this.NH.getIntrinsicHeight();
            int width2 = (((getWidth() - this.NJ.width()) - intrinsicWidth) - this.NI) / 2;
            int i2 = intrinsicWidth + width2;
            this.NH.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i2, (getHeight() + intrinsicHeight) / 2);
            this.NH.draw(canvas);
            width = i2 + this.NI;
        } else {
            width = (getWidth() / 2) - this.NJ.centerX();
        }
        if (this.NK != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f2 = width;
            if (progress >= f2) {
                if (this.Nz == null) {
                    this.Nz = new LinearGradient(f2, 0.0f, width + this.NJ.width(), 0.0f, this.NK, (float[]) null, Shader.TileMode.CLAMP);
                    this.NB = new Matrix();
                    this.Nz.setLocalMatrix(this.NB);
                }
                this.mPaint.setShader(this.Nz);
                this.NB.setScale(((progress - f2) * 1.0f) / this.NJ.width(), 1.0f, f2, 0.0f);
                this.Nz.setLocalMatrix(this.NB);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.Ny, f2, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.NN) {
            this.mPaint.setColor(this.NL);
            if (this.Ny != null) {
                canvas.drawText(this.Ny, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int iSave = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.NM);
        if (this.Ny != null) {
            canvas.drawText(this.Ny, width, height, this.mPaint);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.NL);
        if (this.Ny != null) {
            canvas.drawText(this.Ny, width, height, this.mPaint);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.Ny)) {
            Rect rect = new Rect();
            this.mPaint.getTextBounds(this.Ny, 0, this.Ny.length(), rect);
            if (layoutParams.width == -2) {
                layoutParams.width = rect.width() + this.NF + this.NG;
                i2 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            }
            if (layoutParams.height == -2) {
                layoutParams.height = rect.height();
                i3 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
        }
        if (!this.ND) {
            super.onMeasure(i2, i3);
        } else {
            super.onMeasure(i3, i2);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.ND) {
            super.onSizeChanged(i3, i2, i4, i5);
        } else {
            super.onSizeChanged(i2, i3, i4, i5);
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        this.NH = drawable;
    }

    public void setDrawablePadding(int i2) {
        this.NI = i2;
    }

    public void setHasProgress(boolean z2) {
        this.NE = z2;
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        this.NF = i2;
        this.NG = i4;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i2) {
        if (this.NE) {
            super.setProgress(i2);
        } else {
            super.setProgress(0);
        }
    }

    public void setTextColor(int i2) {
        this.NN = false;
        this.NL = i2;
        postInvalidate();
    }

    public final void setTextColor(@ColorInt int i2, @ColorInt int i3) {
        this.NN = true;
        this.NL = i2;
        this.NM = i3;
        postInvalidate();
    }

    public void setTextDimen(float f2) {
        this.mPaint.setTextSize(f2);
    }

    public void setTextDimenSp(int i2) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i2, getResources().getDisplayMetrics()));
    }

    public void setVertical(boolean z2) {
        this.ND = z2;
    }
}
