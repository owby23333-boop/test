package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class MultiTouchImageView extends StretchedImageView {
    private float doubleTapScale;
    private float[] initialStateValues;
    private PointF lastPosition;
    private float lastScale;
    private float[] matrixValues;
    private float maxScale;
    private float minScale;
    private Matrix scaleMatrix;
    private float[] scaleMatrixValues;

    public enum Axis {
        X,
        Y
    }

    public MultiTouchImageView(Context context) {
        this(context, null, 0);
    }

    public float getCurrentScale() {
        return this.matrixValues[0];
    }

    public float getDoubleTapScale() {
        return this.doubleTapScale;
    }

    public PointF getLastPosition() {
        return this.lastPosition;
    }

    public float getLastScale() {
        return this.lastScale;
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public float getMinScale() {
        return this.minScale;
    }

    public float getOffset(Axis axis, int i, int i2, float f) {
        if (axis == Axis.X) {
            return (i - (i2 * f)) / 2.0f;
        }
        float f2 = i2 * f;
        float f3 = i;
        if (f2 < f3) {
            return (f3 - f2) / 2.0f;
        }
        return 0.0f;
    }

    public float getTranslation(Axis axis, int i, float f, int i2, float f2, float f3) {
        float f4 = i * f;
        float f5 = i2;
        return f4 <= f5 ? getOffset(axis, i2, i, f) : f3 > 0.0f ? Math.min(0.0f, f2 + f3) : Math.max((f4 - f5) * (-1.0f), f2 + f3);
    }

    public boolean istranslate(MotionEvent motionEvent) {
        return (getDrawable() == null || this.matrixValues[2] == getTranslation(Axis.X, getDrawable().getIntrinsicWidth(), getCurrentScale(), getMeasuredWidth(), this.matrixValues[2], motionEvent.getX() - this.lastPosition.x)) ? false : true;
    }

    @Override // com.dangdang.zframework.view.StretchedImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        getImageMatrix().getValues(this.matrixValues);
        if (Arrays.equals(this.matrixValues, this.initialStateValues) || getDrawable() == null) {
            return;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        translate(0.0f, 0.0f);
        getImageMatrix().getValues(this.initialStateValues);
    }

    public boolean reset() {
        getImageMatrix().getValues(this.matrixValues);
        if (this.matrixValues[0] == this.initialStateValues[0] || getImageMatrix().isIdentity()) {
            return false;
        }
        getImageMatrix().setValues(this.initialStateValues);
        invalidate();
        return true;
    }

    public void scale(float f, float f2, float f3) {
        if (f > 1.0f) {
            f = Math.min(f, this.maxScale / getCurrentScale());
        } else if (f < 1.0f) {
            f = Math.max(f, this.initialStateValues[0] / getCurrentScale());
        }
        this.scaleMatrix.set(getImageMatrix());
        this.scaleMatrix.postScale(f, f, f2, f3);
        this.scaleMatrix.getValues(this.scaleMatrixValues);
        setLastScale(f);
        float[] fArr = this.matrixValues;
        float[] fArr2 = this.scaleMatrixValues;
        fArr[0] = fArr2[0];
        fArr[4] = fArr2[4];
        translate(fArr2[2] - fArr[2], fArr2[5] - fArr[5]);
    }

    public void setDoubleTap(MotionEvent motionEvent) {
        float currentScale = getCurrentScale();
        float f = this.initialStateValues[0];
        if (currentScale > f) {
            scale(f / getCurrentScale(), motionEvent.getX(), motionEvent.getY());
        } else {
            scale(this.doubleTapScale / getCurrentScale(), motionEvent.getX(), motionEvent.getY());
        }
        invalidate();
    }

    public void setDoubleTapScale(float f) {
        this.doubleTapScale = f;
    }

    public void setLastPosition(float f, float f2) {
        PointF pointF = this.lastPosition;
        pointF.x = f;
        pointF.y = f2;
    }

    public void setLastScale(float f) {
        this.lastScale = f;
    }

    public void setMaxScale(float f) {
        this.maxScale = f;
    }

    public void setMinScale(float f) {
        this.minScale = f;
    }

    public void setScale(ScaleGestureDetector scaleGestureDetector) {
        scale(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        invalidate();
    }

    public void setTranslate(MotionEvent motionEvent) {
        translate(motionEvent.getX() - this.lastPosition.x, motionEvent.getY() - this.lastPosition.y);
        invalidate();
    }

    public void translate(float f, float f2) {
        if (getDrawable() == null) {
            return;
        }
        this.matrixValues[2] = getTranslation(Axis.X, getDrawable().getIntrinsicWidth(), getCurrentScale(), getMeasuredWidth(), this.matrixValues[2], f);
        this.matrixValues[5] = getTranslation(Axis.Y, getDrawable().getIntrinsicHeight(), getCurrentScale(), getMeasuredHeight(), this.matrixValues[5], f2);
        setLastPosition(getLastPosition().x + f, getLastPosition().y + f2);
        getImageMatrix().setValues(this.matrixValues);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxScale = 3.5f;
        this.minScale = 1.0f;
        this.doubleTapScale = 2.0f;
        this.initialStateValues = new float[9];
        this.matrixValues = new float[9];
        this.scaleMatrix = new Matrix();
        this.scaleMatrixValues = new float[9];
        this.lastPosition = new PointF(0.0f, 0.0f);
        this.lastScale = 1.0f;
    }

    public void setLastPosition(MotionEvent motionEvent) {
        setLastPosition(motionEvent.getX(), motionEvent.getY());
    }
}
