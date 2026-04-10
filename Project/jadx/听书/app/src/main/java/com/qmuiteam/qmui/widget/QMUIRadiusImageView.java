package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qmuiteam.qmui.R;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIRadiusImageView extends AppCompatImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLOR_DRAWABLE_DIMEN = 2;
    private static final int DEFAULT_BORDER_COLOR = -7829368;
    private Bitmap mBitmap;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private ColorFilter mColorFilter;
    private int mCornerRadius;
    private RectF mDrawRectF;
    private int mHeight;
    private boolean mIsCircle;
    private boolean mIsOval;
    private boolean mIsSelected;
    private boolean mIsTouchSelectModeEnabled;
    private ImageView.ScaleType mLastCalculateScaleType;
    private Matrix mMatrix;
    private boolean mNeedResetShader;
    private RectF mRectF;
    private int mSelectedBorderColor;
    private int mSelectedBorderWidth;
    private ColorFilter mSelectedColorFilter;
    private int mSelectedMaskColor;
    private int mWidth;

    public QMUIRadiusImageView(Context context) {
        this(context, null, R.attr.QMUIRadiusImageViewStyle);
    }

    public QMUIRadiusImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIRadiusImageViewStyle);
    }

    public QMUIRadiusImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsSelected = false;
        this.mIsOval = false;
        this.mIsCircle = false;
        this.mIsTouchSelectModeEnabled = true;
        this.mNeedResetShader = false;
        this.mRectF = new RectF();
        this.mDrawRectF = new RectF();
        Paint paint = new Paint();
        this.mBorderPaint = paint;
        paint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mMatrix = new Matrix();
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIRadiusImageView, i, 0);
        this.mBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_border_width, 0);
        this.mBorderColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView_qmui_border_color, -7829368);
        this.mSelectedBorderWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_selected_border_width, this.mBorderWidth);
        this.mSelectedBorderColor = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView_qmui_selected_border_color, this.mBorderColor);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView_qmui_selected_mask_color, 0);
        this.mSelectedMaskColor = color;
        if (color != 0) {
            this.mSelectedColorFilter = new PorterDuffColorFilter(this.mSelectedMaskColor, PorterDuff.Mode.DARKEN);
        }
        this.mIsTouchSelectModeEnabled = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_touch_select_mode_enabled, true);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_circle, false);
        this.mIsCircle = z;
        if (!z) {
            this.mIsOval = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_oval, false);
        }
        if (!this.mIsOval) {
            this.mCornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_corner_radius, 0);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("不支持adjustViewBounds");
        }
    }

    public void setBorderWidth(int i) {
        if (this.mBorderWidth != i) {
            this.mBorderWidth = i;
            invalidate();
        }
    }

    public void setBorderColor(int i) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidate();
        }
    }

    public void setCornerRadius(int i) {
        if (this.mCornerRadius != i) {
            this.mCornerRadius = i;
            if (this.mIsCircle || this.mIsOval) {
                return;
            }
            invalidate();
        }
    }

    public void setSelectedBorderColor(int i) {
        if (this.mSelectedBorderColor != i) {
            this.mSelectedBorderColor = i;
            if (this.mIsSelected) {
                invalidate();
            }
        }
    }

    public void setSelectedBorderWidth(int i) {
        if (this.mSelectedBorderWidth != i) {
            this.mSelectedBorderWidth = i;
            if (this.mIsSelected) {
                invalidate();
            }
        }
    }

    public void setSelectedMaskColor(int i) {
        if (this.mSelectedMaskColor != i) {
            this.mSelectedMaskColor = i;
            if (i != 0) {
                this.mSelectedColorFilter = new PorterDuffColorFilter(this.mSelectedMaskColor, PorterDuff.Mode.DARKEN);
            } else {
                this.mSelectedColorFilter = null;
            }
            if (this.mIsSelected) {
                invalidate();
            }
        }
        this.mSelectedMaskColor = i;
    }

    public void setCircle(boolean z) {
        if (this.mIsCircle != z) {
            this.mIsCircle = z;
            requestLayout();
            invalidate();
        }
    }

    public void setOval(boolean z) {
        boolean z2 = false;
        if (z && this.mIsCircle) {
            this.mIsCircle = false;
            z2 = true;
        }
        if (this.mIsOval != z || z2) {
            this.mIsOval = z;
            requestLayout();
            invalidate();
        }
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getSelectedBorderColor() {
        return this.mSelectedBorderColor;
    }

    public int getSelectedBorderWidth() {
        return this.mSelectedBorderWidth;
    }

    public int getSelectedMaskColor() {
        return this.mSelectedMaskColor;
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public boolean isOval() {
        return !this.mIsCircle && this.mIsOval;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.mIsSelected;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        if (this.mIsSelected != z) {
            this.mIsSelected = z;
            invalidate();
        }
    }

    public void setTouchSelectModeEnabled(boolean z) {
        this.mIsTouchSelectModeEnabled = z;
    }

    public boolean isTouchSelectModeEnabled() {
        return this.mIsTouchSelectModeEnabled;
    }

    public void setSelectedColorFilter(ColorFilter colorFilter) {
        if (this.mSelectedColorFilter == colorFilter) {
            return;
        }
        this.mSelectedColorFilter = colorFilter;
        if (this.mIsSelected) {
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mColorFilter == colorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        if (this.mIsSelected) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (!this.mIsCircle) {
            super.onMeasure(i, i2);
            return;
        }
        if (mode == 1073741824) {
            setMeasuredDimension(size, size);
            return;
        }
        if (mode2 == 1073741824) {
            setMeasuredDimension(size2, size2);
            return;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            setMeasuredDimension(0, 0);
        } else {
            int iMin = Math.min(Math.min(bitmap.getWidth(), size), Math.min(this.mBitmap.getHeight(), size2));
            setMeasuredDimension(iMin, iMin);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        setupBitmap();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setupBitmap();
    }

    private Bitmap getBitmap() {
        Bitmap bitmapCreateBitmap;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap == null) {
                return null;
            }
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (width == 0.0f || height == 0.0f) {
                return null;
            }
            float minimumWidth = getMinimumWidth() / width;
            float minimumHeight = getMinimumHeight() / height;
            if (minimumWidth <= 1.0f && minimumHeight <= 1.0f) {
                return bitmap;
            }
            float fMax = Math.max(minimumWidth, minimumHeight);
            Matrix matrix = new Matrix();
            matrix.postScale(fMax, fMax);
            return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, false);
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmapCreateBitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setupBitmap() {
        Bitmap bitmap = getBitmap();
        if (bitmap == this.mBitmap) {
            return;
        }
        this.mBitmap = bitmap;
        if (bitmap == null) {
            this.mBitmapShader = null;
            invalidate();
            return;
        }
        this.mNeedResetShader = true;
        this.mBitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        if (this.mBitmapPaint == null) {
            Paint paint = new Paint();
            this.mBitmapPaint = paint;
            paint.setAntiAlias(true);
        }
        this.mBitmapPaint.setShader(this.mBitmapShader);
        requestLayout();
        invalidate();
    }

    private void updateBitmapShader() {
        Bitmap bitmap;
        this.mMatrix.reset();
        this.mNeedResetShader = false;
        if (this.mBitmapShader == null || (bitmap = this.mBitmap) == null) {
            return;
        }
        updateMatrix(this.mMatrix, bitmap, this.mRectF);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mBitmapPaint.setShader(this.mBitmapShader);
    }

    private void updateMatrix(Matrix matrix, Bitmap bitmap, RectF rectF) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        if (scaleType == ImageView.ScaleType.MATRIX) {
            updateScaleTypeMatrix(matrix, bitmap, rectF);
            return;
        }
        if (scaleType == ImageView.ScaleType.CENTER) {
            float f = (this.mWidth - width) / 2.0f;
            float f2 = (this.mHeight - height) / 2.0f;
            matrix.postTranslate(f, f2);
            rectF.set(Math.max(0.0f, f), Math.max(0.0f, f2), Math.min(f + width, this.mWidth), Math.min(f2 + height, this.mHeight));
            return;
        }
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(this.mWidth / width, this.mHeight / height);
            matrix.setScale(fMax, fMax);
            matrix.postTranslate((-((width * fMax) - this.mWidth)) / 2.0f, (-((fMax * height) - this.mHeight)) / 2.0f);
            rectF.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            return;
        }
        if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            int i = this.mWidth;
            float f3 = i / width;
            int i2 = this.mHeight;
            float f4 = i2 / height;
            if (f3 >= 1.0f && f4 >= 1.0f) {
                float f5 = (i - width) / 2.0f;
                float f6 = (i2 - height) / 2.0f;
                matrix.postTranslate(f5, f6);
                rectF.set(f5, f6, width + f5, height + f6);
                return;
            }
            float fMin = Math.min(f3, f4);
            matrix.setScale(fMin, fMin);
            float f7 = width * fMin;
            float f8 = height * fMin;
            float f9 = (this.mWidth - f7) / 2.0f;
            float f10 = (this.mHeight - f8) / 2.0f;
            matrix.postTranslate(f9, f10);
            rectF.set(f9, f10, f7 + f9, f8 + f10);
            return;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            matrix.setScale(this.mWidth / width, this.mHeight / height);
            rectF.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            return;
        }
        float fMin2 = Math.min(this.mWidth / width, this.mHeight / height);
        matrix.setScale(fMin2, fMin2);
        float f11 = width * fMin2;
        float f12 = height * fMin2;
        if (scaleType == ImageView.ScaleType.FIT_START) {
            rectF.set(0.0f, 0.0f, f11, f12);
            return;
        }
        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            float f13 = (this.mWidth - f11) / 2.0f;
            float f14 = (this.mHeight - f12) / 2.0f;
            matrix.postTranslate(f13, f14);
            rectF.set(f13, f14, f11 + f13, f12 + f14);
            return;
        }
        matrix.postTranslate(this.mWidth - f11, this.mHeight - f12);
        int i3 = this.mWidth;
        float f15 = i3 - f11;
        int i4 = this.mHeight;
        rectF.set(f15, i4 - f12, i3, i4);
    }

    protected void updateScaleTypeMatrix(Matrix matrix, Bitmap bitmap, RectF rectF) {
        matrix.set(getImageMatrix());
        rectF.set(0.0f, 0.0f, this.mWidth, this.mHeight);
    }

    private void drawBitmap(Canvas canvas, int i) {
        float f = (i * 1.0f) / 2.0f;
        this.mBitmapPaint.setColorFilter(this.mIsSelected ? this.mSelectedColorFilter : this.mColorFilter);
        if (this.mIsCircle) {
            canvas.drawCircle(this.mRectF.centerX(), this.mRectF.centerY(), Math.min(this.mRectF.width() / 2.0f, this.mRectF.height() / 2.0f) - f, this.mBitmapPaint);
            return;
        }
        this.mDrawRectF.left = this.mRectF.left + f;
        this.mDrawRectF.top = this.mRectF.top + f;
        this.mDrawRectF.right = this.mRectF.right - f;
        this.mDrawRectF.bottom = this.mRectF.bottom - f;
        if (this.mIsOval) {
            canvas.drawOval(this.mDrawRectF, this.mBitmapPaint);
            return;
        }
        RectF rectF = this.mDrawRectF;
        int i2 = this.mCornerRadius;
        canvas.drawRoundRect(rectF, i2, i2, this.mBitmapPaint);
    }

    private void drawBorder(Canvas canvas, int i) {
        if (i <= 0) {
            return;
        }
        float f = i;
        float f2 = (1.0f * f) / 2.0f;
        this.mBorderPaint.setColor(this.mIsSelected ? this.mSelectedBorderColor : this.mBorderColor);
        this.mBorderPaint.setStrokeWidth(f);
        if (this.mIsCircle) {
            canvas.drawCircle(this.mRectF.centerX(), this.mRectF.centerY(), (Math.min(this.mRectF.width(), this.mRectF.height()) / 2.0f) - f2, this.mBorderPaint);
            return;
        }
        this.mDrawRectF.left = this.mRectF.left + f2;
        this.mDrawRectF.top = this.mRectF.top + f2;
        this.mDrawRectF.right = this.mRectF.right - f2;
        this.mDrawRectF.bottom = this.mRectF.bottom - f2;
        if (this.mIsOval) {
            canvas.drawOval(this.mDrawRectF, this.mBorderPaint);
            return;
        }
        RectF rectF = this.mDrawRectF;
        int i2 = this.mCornerRadius;
        canvas.drawRoundRect(rectF, i2, i2, this.mBorderPaint);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        int i = this.mIsSelected ? this.mSelectedBorderWidth : this.mBorderWidth;
        if (this.mBitmap == null || this.mBitmapShader == null) {
            drawBorder(canvas, i);
            return;
        }
        if (this.mWidth != width || this.mHeight != height || this.mLastCalculateScaleType != getScaleType() || this.mNeedResetShader) {
            this.mWidth = width;
            this.mHeight = height;
            this.mLastCalculateScaleType = getScaleType();
            updateBitmapShader();
        }
        drawBitmap(canvas, i);
        drawBorder(canvas, i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isClickable()) {
            setSelected(false);
            return super.onTouchEvent(motionEvent);
        }
        if (!this.mIsTouchSelectModeEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setSelected(true);
        } else if (action == 1 || action == 3 || action == 4 || action == 8) {
            setSelected(false);
        }
        return super.onTouchEvent(motionEvent);
    }
}
