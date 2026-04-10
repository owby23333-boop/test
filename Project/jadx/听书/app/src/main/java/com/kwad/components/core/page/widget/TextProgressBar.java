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
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes4.dex */
public class TextProgressBar extends ProgressBar {
    private String VF;
    private LinearGradient VG;
    private Matrix VH;
    private boolean VI;
    private boolean VJ;
    private boolean VK;
    private int VL;
    private int VM;
    private Drawable VN;
    private int VO;
    private Rect VP;
    private int[] VQ;
    private int VR;
    private int VS;
    private boolean VT;
    private Paint mPaint;
    private RectF mRectF;

    public TextProgressBar(Context context) {
        this(context, null);
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(m.wrapContextIfNeed(context), attributeSet);
        this.VJ = false;
        this.VK = true;
        this.VP = new Rect();
        rP();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        if (this.VK) {
            super.setProgress(i);
        } else {
            super.setProgress(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        int width;
        if (this.VJ) {
            canvas.save();
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
        if (!TextUtils.isEmpty(this.VF)) {
            Paint paint = this.mPaint;
            String str = this.VF;
            paint.getTextBounds(str, 0, str.length(), this.VP);
        }
        int height = (getHeight() / 2) - this.VP.centerY();
        Drawable drawable = this.VN;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.VN.getIntrinsicHeight();
            int width2 = (((getWidth() - this.VP.width()) - intrinsicWidth) - this.VO) / 2;
            int i = intrinsicWidth + width2;
            this.VN.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i, (getHeight() + intrinsicHeight) / 2);
            this.VN.draw(canvas);
            width = i + this.VO;
        } else {
            width = (getWidth() / 2) - this.VP.centerX();
        }
        if (this.VQ != null) {
            float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
            float f = width;
            if (progress >= f) {
                if (this.VG == null) {
                    this.VG = new LinearGradient(f, 0.0f, width + this.VP.width(), 0.0f, this.VQ, (float[]) null, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.VH = matrix;
                    this.VG.setLocalMatrix(matrix);
                }
                this.mPaint.setShader(this.VG);
                this.VH.setScale(((progress - f) * 1.0f) / this.VP.width(), 1.0f, f, 0.0f);
                this.VG.setLocalMatrix(this.VH);
            } else {
                this.mPaint.setShader(null);
            }
            canvas.drawText(this.VF, f, height, this.mPaint);
            return;
        }
        if (!isIndeterminate() && !this.VT) {
            this.mPaint.setColor(this.VR);
            String str2 = this.VF;
            if (str2 != null) {
                canvas.drawText(str2, width, height, this.mPaint);
            }
            return;
        }
        float width3 = (getWidth() * getProgress()) / getMax();
        int iSave = canvas.save();
        this.mRectF.set(width3, 0.0f, getWidth(), getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.VS);
        String str3 = this.VF;
        if (str3 != null) {
            canvas.drawText(str3, width, height, this.mPaint);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        this.mRectF.set(0.0f, 0.0f, width3, getHeight());
        canvas.clipRect(this.mRectF);
        this.mPaint.setColor(this.VR);
        String str4 = this.VF;
        if (str4 != null) {
            canvas.drawText(str4, width, height, this.mPaint);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && !TextUtils.isEmpty(this.VF)) {
            Rect rect = new Rect();
            Paint paint = this.mPaint;
            String str = this.VF;
            paint.getTextBounds(str, 0, str.length(), rect);
            if (layoutParams.width == -2) {
                layoutParams.width = rect.width() + this.VL + this.VM;
                i = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            }
            if (layoutParams.height == -2) {
                layoutParams.height = rect.height();
                i2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
        }
        if (this.VJ) {
            super.onMeasure(i2, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.VJ) {
            super.onSizeChanged(i2, i, i3, i4);
        } else {
            super.onSizeChanged(i, i2, i3, i4);
        }
    }

    private void rP() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-1);
        this.mPaint.setTextSize(com.kwad.sdk.c.a.a.a(getContext(), 12.0f));
        this.VO = com.kwad.sdk.c.a.a.a(getContext(), 2.0f);
        this.mRectF = new RectF();
        this.VR = -1;
        this.VS = -117146;
    }

    private void setProgressText(int i) {
        this.VF = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
    }

    public final void e(String str, int i) {
        this.VF = str;
        this.VI = true;
        setProgress(i);
        invalidate();
    }

    public void setTextDimenSp(int i) {
        this.mPaint.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
    }

    public void setTextDimen(float f) {
        this.mPaint.setTextSize(f);
    }

    public void setTextColor(int i) {
        this.VT = false;
        this.VR = i;
        postInvalidate();
    }

    public final void setTextColor(int i, int i2) {
        this.VT = true;
        this.VR = i;
        this.VS = i2;
        postInvalidate();
    }

    public void setVertical(boolean z) {
        this.VJ = z;
    }

    public void setHasProgress(boolean z) {
        this.VK = z;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.VL = i;
        this.VM = i3;
    }

    public void setDrawableLeft(Drawable drawable) {
        this.VN = drawable;
    }

    public void setDrawablePadding(int i) {
        this.VO = i;
    }
}
