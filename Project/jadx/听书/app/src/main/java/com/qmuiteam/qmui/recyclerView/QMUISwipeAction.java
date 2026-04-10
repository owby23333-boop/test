package com.qmuiteam.qmui.recyclerView;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISwipeAction {
    float contentHeight;
    float contentWidth;
    int mBackgroundColor;
    int mBackgroundColorAttr;
    Drawable mIcon;
    int mIconAttr;
    int mIconTextGap;
    int mOrientation;
    int mPaddingStartEnd;
    boolean mReverseDrawOrder;
    int mSwipeDirectionMiniSize;
    TimeInterpolator mSwipeMoveInterpolator;
    int mSwipePxPerMS;
    final String mText;
    int mTextColor;
    int mTextColorAttr;
    int mTextSize;
    Typeface mTypeface;
    boolean mUseIconTint;
    Paint paint;

    private QMUISwipeAction(ActionBuilder actionBuilder) {
        String str = (actionBuilder.mText == null || actionBuilder.mText.length() <= 0) ? null : actionBuilder.mText;
        this.mText = str;
        this.mTextColor = actionBuilder.mTextColor;
        this.mTextSize = actionBuilder.mTextSize;
        this.mTypeface = actionBuilder.mTypeface;
        this.mTextColorAttr = actionBuilder.mTextColorAttr;
        this.mIcon = actionBuilder.mIcon;
        this.mIconAttr = actionBuilder.mIconAttr;
        this.mUseIconTint = actionBuilder.mUseIconTint;
        this.mIconTextGap = actionBuilder.mIconTextGap;
        this.mBackgroundColor = actionBuilder.mBackgroundColor;
        this.mBackgroundColorAttr = actionBuilder.mBackgroundColorAttr;
        this.mPaddingStartEnd = actionBuilder.mPaddingStartEnd;
        this.mSwipeDirectionMiniSize = actionBuilder.mSwipeDirectionMiniSize;
        this.mOrientation = actionBuilder.mOrientation;
        this.mReverseDrawOrder = actionBuilder.mReverseDrawOrder;
        this.mSwipeMoveInterpolator = actionBuilder.mSwipeMoveInterpolator;
        this.mSwipePxPerMS = actionBuilder.mSwipePxPerMS;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setTypeface(this.mTypeface);
        this.paint.setTextSize(this.mTextSize);
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        Drawable drawable = this.mIcon;
        if (drawable != null && str != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mIcon.getIntrinsicHeight());
            if (this.mOrientation == 2) {
                this.contentWidth = this.mIcon.getIntrinsicWidth() + this.mIconTextGap + this.paint.measureText(str);
                this.contentHeight = Math.max(fontMetrics.descent - fontMetrics.ascent, this.mIcon.getIntrinsicHeight());
                return;
            } else {
                this.contentWidth = Math.max(this.mIcon.getIntrinsicWidth(), this.paint.measureText(str));
                this.contentHeight = (fontMetrics.descent - fontMetrics.ascent) + this.mIconTextGap + this.mIcon.getIntrinsicHeight();
                return;
            }
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mIcon.getIntrinsicHeight());
            this.contentWidth = this.mIcon.getIntrinsicWidth();
            this.contentHeight = this.mIcon.getIntrinsicHeight();
        } else if (str != null) {
            this.contentWidth = this.paint.measureText(str);
            this.contentHeight = fontMetrics.descent - fontMetrics.ascent;
        }
    }

    public String getText() {
        return this.mText;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    public int getTextColorAttr() {
        return this.mTextColorAttr;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public int getIconAttr() {
        return this.mIconAttr;
    }

    public boolean isUseIconTint() {
        return this.mUseIconTint;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBackgroundColorAttr() {
        return this.mBackgroundColorAttr;
    }

    public int getPaddingStartEnd() {
        return this.mPaddingStartEnd;
    }

    public int getIconTextGap() {
        return this.mIconTextGap;
    }

    public int getSwipeDirectionMiniSize() {
        return this.mSwipeDirectionMiniSize;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    protected void draw(Canvas canvas) {
        String str = this.mText;
        if (str != null && this.mIcon != null) {
            if (this.mOrientation == 2) {
                if (this.mReverseDrawOrder) {
                    canvas.drawText(str, 0.0f, (((this.contentHeight - this.paint.descent()) + this.paint.ascent()) / 2.0f) - this.paint.ascent(), this.paint);
                    canvas.save();
                    canvas.translate(this.contentWidth - this.mIcon.getIntrinsicWidth(), (this.contentHeight - this.mIcon.getIntrinsicHeight()) / 2.0f);
                    this.mIcon.draw(canvas);
                    canvas.restore();
                    return;
                }
                canvas.save();
                canvas.translate(0.0f, (this.contentHeight - this.mIcon.getIntrinsicHeight()) / 2.0f);
                this.mIcon.draw(canvas);
                canvas.restore();
                canvas.drawText(this.mText, this.mIcon.getIntrinsicWidth() + this.mIconTextGap, (((this.contentHeight - this.paint.descent()) + this.paint.ascent()) / 2.0f) - this.paint.ascent(), this.paint);
                return;
            }
            float fMeasureText = this.paint.measureText(str);
            if (this.mReverseDrawOrder) {
                canvas.drawText(this.mText, (this.contentWidth - fMeasureText) / 2.0f, -this.paint.ascent(), this.paint);
                canvas.save();
                canvas.translate((this.contentWidth - this.mIcon.getIntrinsicWidth()) / 2.0f, this.contentHeight - this.mIcon.getIntrinsicHeight());
                this.mIcon.draw(canvas);
                canvas.restore();
                return;
            }
            canvas.save();
            canvas.translate((this.contentWidth - this.mIcon.getIntrinsicWidth()) / 2.0f, 0.0f);
            this.mIcon.draw(canvas);
            canvas.restore();
            canvas.drawText(this.mText, (this.contentWidth - fMeasureText) / 2.0f, this.contentHeight - this.paint.descent(), this.paint);
            return;
        }
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            drawable.draw(canvas);
        } else if (str != null) {
            canvas.drawText(str, 0.0f, -this.paint.ascent(), this.paint);
        }
    }

    public static class ActionBuilder {
        public static final int HORIZONTAL = 2;
        public static final int VERTICAL = 1;
        int mBackgroundColor;
        Drawable mIcon;
        int mIconTextGap;
        int mSwipeDirectionMiniSize;
        String mText;
        int mTextColor;
        int mTextSize;
        Typeface mTypeface;
        int mTextColorAttr = 0;
        int mBackgroundColorAttr = 0;
        int mIconAttr = 0;
        boolean mUseIconTint = false;
        int mPaddingStartEnd = 0;
        int mOrientation = 1;
        boolean mReverseDrawOrder = false;
        TimeInterpolator mSwipeMoveInterpolator = QMUIInterpolatorStaticHolder.ACCELERATE_INTERPOLATOR;
        int mSwipePxPerMS = 2;

        public ActionBuilder text(String str) {
            this.mText = str;
            return this;
        }

        public ActionBuilder textSize(int i) {
            this.mTextSize = i;
            return this;
        }

        public ActionBuilder textColor(int i) {
            this.mTextColor = i;
            return this;
        }

        public ActionBuilder typeface(Typeface typeface) {
            this.mTypeface = typeface;
            return this;
        }

        public ActionBuilder textColorAttr(int i) {
            this.mTextColorAttr = i;
            return this;
        }

        public ActionBuilder icon(Drawable drawable) {
            this.mIcon = drawable == null ? null : drawable.mutate();
            return this;
        }

        public ActionBuilder iconAttr(int i) {
            this.mIconAttr = i;
            return this;
        }

        public ActionBuilder useIconTint(boolean z) {
            this.mUseIconTint = z;
            return this;
        }

        public ActionBuilder backgroundColor(int i) {
            this.mBackgroundColor = i;
            return this;
        }

        public ActionBuilder backgroundColorAttr(int i) {
            this.mBackgroundColorAttr = i;
            return this;
        }

        public ActionBuilder paddingStartEnd(int i) {
            this.mPaddingStartEnd = i;
            return this;
        }

        public ActionBuilder iconTextGap(int i) {
            this.mIconTextGap = i;
            return this;
        }

        public ActionBuilder swipeDirectionMinSize(int i) {
            this.mSwipeDirectionMiniSize = i;
            return this;
        }

        public ActionBuilder orientation(int i) {
            this.mOrientation = i;
            return this;
        }

        public ActionBuilder reverseDrawOrder(boolean z) {
            this.mReverseDrawOrder = z;
            return this;
        }

        public ActionBuilder swipeMoveInterpolator(TimeInterpolator timeInterpolator) {
            this.mSwipeMoveInterpolator = timeInterpolator;
            return this;
        }

        public ActionBuilder swipePxPerMS(int i) {
            this.mSwipePxPerMS = i;
            return this;
        }

        public QMUISwipeAction build() {
            return new QMUISwipeAction(this);
        }
    }
}
