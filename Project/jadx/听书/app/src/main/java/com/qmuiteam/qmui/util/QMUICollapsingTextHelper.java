package com.qmuiteam.qmui.util;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.ts.TsExtractor;
import com.qmuiteam.qmui.R;

/* JADX INFO: loaded from: classes4.dex */
public final class QMUICollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private boolean mBoundsChanged;
    private final Rect mCollapsedBounds;
    private float mCollapsedDrawX;
    private float mCollapsedDrawY;
    private int mCollapsedShadowColor;
    private float mCollapsedShadowDx;
    private float mCollapsedShadowDy;
    private float mCollapsedShadowRadius;
    private ColorStateList mCollapsedTextColor;
    private int mCollapsedTextGravity;
    private float mCollapsedTextHeight;
    private float mCollapsedTextSize;
    private float mCollapsedTextWidth;
    private Typeface mCollapsedTypeface;
    private final RectF mCurrentBounds;
    private float mCurrentDrawX;
    private float mCurrentDrawY;
    private float mCurrentTextHeight;
    private float mCurrentTextSize;
    private float mCurrentTextWidth;
    private Typeface mCurrentTypeface;
    private boolean mDrawTitle;
    private final Rect mExpandedBounds;
    private float mExpandedDrawX;
    private float mExpandedDrawY;
    private float mExpandedFraction;
    private int mExpandedShadowColor;
    private float mExpandedShadowDx;
    private float mExpandedShadowDy;
    private float mExpandedShadowRadius;
    private ColorStateList mExpandedTextColor;
    private int mExpandedTextGravity;
    private float mExpandedTextHeight;
    private float mExpandedTextSize;
    private float mExpandedTextWidth;
    private Bitmap mExpandedTitleTexture;
    private Typeface mExpandedTypeface;
    private boolean mIsRtl;
    private Interpolator mPositionInterpolator;
    private float mScale;
    private int[] mState;
    private CharSequence mText;
    private final TextPaint mTextPaint;
    private Interpolator mTextSizeInterpolator;
    private CharSequence mTextToDraw;
    private float mTextureAscent;
    private float mTextureDescent;
    private Paint mTexturePaint;
    private float mTypefaceUpdateAreaPercent;
    private boolean mUseTexture;
    private final View mView;
    private static final boolean USE_SCALING_TEXTURE = false;
    private static final Paint DEBUG_DRAW_PAINT = null;

    public QMUICollapsingTextHelper(View view) {
        this(view, 0.0f);
    }

    public QMUICollapsingTextHelper(View view, float f) {
        this.mExpandedTextGravity = 16;
        this.mCollapsedTextGravity = 16;
        this.mExpandedTextSize = 15.0f;
        this.mCollapsedTextSize = 15.0f;
        this.mView = view;
        this.mTextPaint = new TextPaint(TsExtractor.TS_STREAM_TYPE_AC3);
        this.mExpandedFraction = f;
        this.mCollapsedBounds = new Rect();
        this.mExpandedBounds = new Rect();
        this.mCurrentBounds = new RectF();
    }

    public void setTextSizeInterpolator(Interpolator interpolator) {
        this.mTextSizeInterpolator = interpolator;
        recalculate();
    }

    public void setPositionInterpolator(Interpolator interpolator) {
        this.mPositionInterpolator = interpolator;
        recalculate();
    }

    public void setTextSize(float f, float f2, boolean z) {
        if (this.mExpandedTextSize == f2 && this.mCollapsedTextSize == f) {
            return;
        }
        this.mExpandedTextSize = f2;
        this.mCollapsedTextSize = f;
        if (z) {
            recalculate();
        }
    }

    public void setExpandedTextSize(float f) {
        if (this.mExpandedTextSize != f) {
            this.mExpandedTextSize = f;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f) {
        if (this.mCollapsedTextSize != f) {
            this.mCollapsedTextSize = f;
            recalculate();
        }
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.mCollapsedTextColor != colorStateList) {
            this.mCollapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.mExpandedTextColor != colorStateList) {
            this.mExpandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setTextColor(ColorStateList colorStateList, ColorStateList colorStateList2, boolean z) {
        if (this.mCollapsedTextColor == colorStateList && this.mExpandedTextColor == colorStateList2) {
            return;
        }
        this.mCollapsedTextColor = colorStateList;
        this.mExpandedTextColor = colorStateList2;
        if (z) {
            recalculate();
        }
    }

    public void setCollapsedTextAppearance(int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, R.styleable.QMUITextAppearance);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUITextAppearance_android_textColor)) {
            this.mCollapsedTextColor = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.QMUITextAppearance_android_textColor);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUITextAppearance_android_textSize)) {
            this.mCollapsedTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITextAppearance_android_textSize, (int) this.mCollapsedTextSize);
        }
        this.mCollapsedShadowColor = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUITextAppearance_android_shadowColor, 0);
        this.mCollapsedShadowDx = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUITextAppearance_android_shadowDx, 0.0f);
        this.mCollapsedShadowDy = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUITextAppearance_android_shadowDy, 0.0f);
        this.mCollapsedShadowRadius = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUITextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.mCollapsedTypeface = readFontFamilyTypeface(i);
        recalculate();
    }

    public void setExpandedTextAppearance(int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, R.styleable.QMUITextAppearance);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUITextAppearance_android_textColor)) {
            this.mExpandedTextColor = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.QMUITextAppearance_android_textColor);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.QMUITextAppearance_android_textSize)) {
            this.mExpandedTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUITextAppearance_android_textSize, (int) this.mExpandedTextSize);
        }
        this.mExpandedShadowColor = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUITextAppearance_android_shadowColor, 0);
        this.mExpandedShadowDx = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUITextAppearance_android_shadowDx, 0.0f);
        this.mExpandedShadowDy = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUITextAppearance_android_shadowDy, 0.0f);
        this.mExpandedShadowRadius = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUITextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        this.mExpandedTypeface = readFontFamilyTypeface(i);
        recalculate();
    }

    public void setExpandedBounds(int i, int i2, int i3, int i4) {
        if (rectEquals(this.mExpandedBounds, i, i2, i3, i4)) {
            return;
        }
        this.mExpandedBounds.set(i, i2, i3, i4);
        this.mBoundsChanged = true;
        onBoundsChanged();
    }

    public void setCollapsedBounds(int i, int i2, int i3, int i4) {
        if (rectEquals(this.mCollapsedBounds, i, i2, i3, i4)) {
            return;
        }
        this.mCollapsedBounds.set(i, i2, i3, i4);
        this.mBoundsChanged = true;
        onBoundsChanged();
    }

    void onBoundsChanged() {
        this.mDrawTitle = this.mCollapsedBounds.width() > 0 && this.mCollapsedBounds.height() > 0 && this.mExpandedBounds.width() > 0 && this.mExpandedBounds.height() > 0;
    }

    public void setExpandedTextGravity(int i) {
        if (this.mExpandedTextGravity != i) {
            this.mExpandedTextGravity = i;
            recalculate();
        }
    }

    public int getExpandedTextGravity() {
        return this.mExpandedTextGravity;
    }

    public void setCollapsedTextGravity(int i) {
        if (this.mCollapsedTextGravity != i) {
            this.mCollapsedTextGravity = i;
            recalculate();
        }
    }

    public int getCollapsedTextGravity() {
        return this.mCollapsedTextGravity;
    }

    public void setGravity(int i, int i2, boolean z) {
        if (this.mCollapsedTextGravity == i && this.mExpandedTextGravity == i2) {
            return;
        }
        this.mCollapsedTextGravity = i;
        this.mExpandedTextGravity = i2;
        if (z) {
            recalculate();
        }
    }

    private Typeface readFontFamilyTypeface(int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{android.R.attr.fontFamily});
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
            return null;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setTypeface(Typeface typeface, Typeface typeface2, boolean z) {
        if (this.mCollapsedTypeface == typeface && this.mExpandedTypeface == typeface2) {
            return;
        }
        this.mCollapsedTypeface = typeface;
        this.mExpandedTypeface = typeface2;
        if (z) {
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (this.mCollapsedTypeface != typeface) {
            this.mCollapsedTypeface = typeface;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (this.mExpandedTypeface != typeface) {
            this.mExpandedTypeface = typeface;
            recalculate();
        }
    }

    public void setTypefaces(Typeface typeface) {
        this.mExpandedTypeface = typeface;
        this.mCollapsedTypeface = typeface;
        recalculate();
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.mCollapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.mExpandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void setExpansionFraction(float f) {
        float fConstrain = QMUILangHelper.constrain(f, 0.0f, 1.0f);
        if (fConstrain != this.mExpandedFraction) {
            this.mExpandedFraction = fConstrain;
            calculateCurrentOffsets();
        }
    }

    public final boolean setState(int[] iArr) {
        this.mState = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    public void setTypefaceUpdateAreaPercent(float f) {
        this.mTypefaceUpdateAreaPercent = f;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.mCollapsedTextColor;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.mExpandedTextColor) != null && colorStateList.isStateful());
    }

    public float getExpansionFraction() {
        return this.mExpandedFraction;
    }

    public float getCollapsedTextSize() {
        return this.mCollapsedTextSize;
    }

    public float getExpandedTextSize() {
        return this.mExpandedTextSize;
    }

    public void calculateCurrentOffsets() {
        calculateOffsets(this.mExpandedFraction);
    }

    private void calculateOffsets(float f) {
        interpolateBounds(f);
        this.mCurrentDrawX = lerp(this.mExpandedDrawX, this.mCollapsedDrawX, f, this.mPositionInterpolator);
        this.mCurrentDrawY = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f, this.mPositionInterpolator);
        this.mCurrentTextHeight = lerp(this.mExpandedTextHeight, this.mCollapsedTextHeight, f, this.mPositionInterpolator);
        this.mCurrentTextWidth = lerp(this.mExpandedTextWidth, this.mCollapsedTextWidth, f, this.mPositionInterpolator);
        setInterpolatedTextSize(lerp(this.mExpandedTextSize, this.mCollapsedTextSize, f, this.mTextSizeInterpolator));
        if (this.mCollapsedTextColor != this.mExpandedTextColor) {
            this.mTextPaint.setColor(QMUIColorHelper.computeColor(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f));
        } else {
            this.mTextPaint.setColor(getCurrentCollapsedTextColor());
        }
        this.mTextPaint.setShadowLayer(lerp(this.mExpandedShadowRadius, this.mCollapsedShadowRadius, f, null), lerp(this.mExpandedShadowDx, this.mCollapsedShadowDx, f, null), lerp(this.mExpandedShadowDy, this.mCollapsedShadowDy, f, null), QMUIColorHelper.computeColor(this.mExpandedShadowColor, this.mCollapsedShadowColor, f));
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private int getCurrentExpandedTextColor() {
        ColorStateList colorStateList = this.mExpandedTextColor;
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.mState;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private int getCurrentCollapsedTextColor() {
        ColorStateList colorStateList = this.mCollapsedTextColor;
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.mState;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    public void calculateBaseOffsets() {
        float f = this.mCurrentTextSize;
        calculateUsingTextSize(this.mCollapsedTextSize);
        CharSequence charSequence = this.mTextToDraw;
        this.mCollapsedTextWidth = charSequence != null ? this.mTextPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        this.mCollapsedTextHeight = this.mTextPaint.descent() - this.mTextPaint.ascent();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.mCollapsedTextGravity, this.mIsRtl ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.mCollapsedDrawY = this.mCollapsedBounds.top - this.mTextPaint.ascent();
        } else if (i == 80) {
            this.mCollapsedDrawY = this.mCollapsedBounds.bottom - this.mTextPaint.descent();
        } else {
            this.mCollapsedDrawY = this.mCollapsedBounds.centerY() + ((this.mCollapsedTextHeight / 2.0f) - this.mTextPaint.descent());
        }
        int i2 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i2 == 1) {
            this.mCollapsedDrawX = this.mCollapsedBounds.centerX() - (this.mCollapsedTextWidth / 2.0f);
        } else if (i2 == 5) {
            this.mCollapsedDrawX = this.mCollapsedBounds.right - this.mCollapsedTextWidth;
        } else {
            this.mCollapsedDrawX = this.mCollapsedBounds.left;
        }
        calculateUsingTextSize(this.mExpandedTextSize);
        CharSequence charSequence2 = this.mTextToDraw;
        this.mExpandedTextWidth = charSequence2 != null ? this.mTextPaint.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        this.mExpandedTextHeight = this.mTextPaint.descent() - this.mTextPaint.ascent();
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.mExpandedTextGravity, this.mIsRtl ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        if (i3 == 48) {
            this.mExpandedDrawY = this.mExpandedBounds.top - this.mTextPaint.ascent();
        } else if (i3 == 80) {
            this.mExpandedDrawY = this.mExpandedBounds.bottom - this.mTextPaint.descent();
        } else {
            this.mExpandedDrawY = this.mExpandedBounds.centerY() + ((this.mExpandedTextHeight / 2.0f) - this.mTextPaint.descent());
        }
        int i4 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i4 == 1) {
            this.mExpandedDrawX = this.mExpandedBounds.centerX() - (this.mExpandedTextWidth / 2.0f);
        } else if (i4 == 5) {
            this.mExpandedDrawX = this.mExpandedBounds.right - this.mExpandedTextWidth;
        } else {
            this.mExpandedDrawX = this.mExpandedBounds.left;
        }
        clearTexture();
        setInterpolatedTextSize(f);
    }

    private void interpolateBounds(float f) {
        this.mCurrentBounds.left = lerp(this.mExpandedBounds.left, this.mCollapsedBounds.left, f, this.mPositionInterpolator);
        this.mCurrentBounds.top = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f, this.mPositionInterpolator);
        this.mCurrentBounds.right = lerp(this.mExpandedBounds.right, this.mCollapsedBounds.right, f, this.mPositionInterpolator);
        this.mCurrentBounds.bottom = lerp(this.mExpandedBounds.bottom, this.mCollapsedBounds.bottom, f, this.mPositionInterpolator);
    }

    public void draw(Canvas canvas) {
        float fAscent;
        int iSave = canvas.save();
        if (this.mTextToDraw != null && this.mDrawTitle) {
            float f = this.mCurrentDrawX;
            float f2 = this.mCurrentDrawY;
            boolean z = this.mUseTexture && this.mExpandedTitleTexture != null;
            if (z) {
                fAscent = this.mTextureAscent * this.mScale;
            } else {
                fAscent = this.mTextPaint.ascent() * this.mScale;
                this.mTextPaint.descent();
            }
            if (z) {
                f2 += fAscent;
            }
            float f3 = f2;
            float f4 = this.mScale;
            if (f4 != 1.0f) {
                canvas.scale(f4, f4, f, f3);
            }
            if (z) {
                canvas.drawBitmap(this.mExpandedTitleTexture, f, f3, this.mTexturePaint);
            } else {
                CharSequence charSequence = this.mTextToDraw;
                canvas.drawText(charSequence, 0, charSequence.length(), f, f3, this.mTextPaint);
            }
        }
        canvas.restoreToCount(iSave);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (ViewCompat.getLayoutDirection(this.mView) == 1) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f);
        boolean z = USE_SCALING_TEXTURE && this.mScale != 1.0f;
        this.mUseTexture = z;
        if (z) {
            ensureExpandedTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private void calculateUsingTextSize(float f) {
        boolean z;
        float f2;
        if (this.mText == null) {
            return;
        }
        float fWidth = this.mCollapsedBounds.width();
        float fWidth2 = this.mExpandedBounds.width();
        float f3 = this.mExpandedFraction;
        float f4 = this.mTypefaceUpdateAreaPercent;
        if (f3 >= 1.0f - f4) {
            Typeface typeface = this.mCurrentTypeface;
            Typeface typeface2 = this.mCollapsedTypeface;
            if (typeface != typeface2) {
                this.mCurrentTypeface = typeface2;
                z = true;
            }
            z = false;
        } else {
            if (f3 <= f4) {
                Typeface typeface3 = this.mCurrentTypeface;
                Typeface typeface4 = this.mExpandedTypeface;
                if (typeface3 != typeface4) {
                    this.mCurrentTypeface = typeface4;
                    z = true;
                }
            }
            z = false;
        }
        if (isClose(f, this.mCollapsedTextSize)) {
            f2 = this.mCollapsedTextSize;
            this.mScale = 1.0f;
        } else {
            float f5 = this.mExpandedTextSize;
            if (isClose(f, f5)) {
                this.mScale = 1.0f;
            } else {
                this.mScale = f / this.mExpandedTextSize;
            }
            float f6 = this.mCollapsedTextSize / this.mExpandedTextSize;
            fWidth = fWidth2 * f6 > fWidth ? Math.min(fWidth / f6, fWidth2) : fWidth2;
            f2 = f5;
        }
        if (fWidth > 0.0f) {
            z = this.mCurrentTextSize != f2 || this.mBoundsChanged || z;
            this.mCurrentTextSize = f2;
            this.mBoundsChanged = false;
        }
        if (this.mTextToDraw == null || z) {
            this.mTextPaint.setTextSize(this.mCurrentTextSize);
            this.mTextPaint.setTypeface(this.mCurrentTypeface);
            this.mTextPaint.setLinearText(this.mScale != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.mText, this.mTextPaint, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.mTextToDraw)) {
                return;
            }
            this.mTextToDraw = charSequenceEllipsize;
            this.mIsRtl = calculateIsRtl(charSequenceEllipsize);
        }
    }

    private void ensureExpandedTexture() {
        if (this.mExpandedTitleTexture != null || this.mExpandedBounds.isEmpty() || TextUtils.isEmpty(this.mTextToDraw)) {
            return;
        }
        calculateOffsets(0.0f);
        this.mTextureAscent = this.mTextPaint.ascent();
        this.mTextureDescent = this.mTextPaint.descent();
        TextPaint textPaint = this.mTextPaint;
        CharSequence charSequence = this.mTextToDraw;
        int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int iRound2 = Math.round(this.mTextureDescent - this.mTextureAscent);
        if (iRound <= 0 || iRound2 <= 0) {
            return;
        }
        this.mExpandedTitleTexture = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.mExpandedTitleTexture);
        CharSequence charSequence2 = this.mTextToDraw;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.mTextPaint.descent(), this.mTextPaint);
        if (this.mTexturePaint == null) {
            this.mTexturePaint = new Paint(3);
        }
    }

    public void recalculate() {
        if (this.mView.getHeight() <= 0 || this.mView.getWidth() <= 0) {
            return;
        }
        calculateBaseOffsets();
        calculateCurrentOffsets();
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.mTextToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    public CharSequence getText() {
        return this.mText;
    }

    private void clearTexture() {
        Bitmap bitmap = this.mExpandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.mExpandedTitleTexture = null;
        }
    }

    public float getExpandedTextWidth() {
        return this.mExpandedTextWidth;
    }

    public float getCollapsedTextWidth() {
        return this.mCollapsedTextWidth;
    }

    public float getExpandedTextHeight() {
        return this.mExpandedTextHeight;
    }

    public float getCollapsedTextHeight() {
        return this.mCollapsedTextHeight;
    }

    public float getExpandedDrawX() {
        return this.mExpandedDrawX;
    }

    public float getCollapsedDrawX() {
        return this.mCollapsedDrawX;
    }

    private static boolean isClose(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    ColorStateList getExpandedTextColor() {
        return this.mExpandedTextColor;
    }

    ColorStateList getCollapsedTextColor() {
        return this.mCollapsedTextColor;
    }

    public static float lerp(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return f + Math.round(f3 * (f2 - f));
    }

    private static boolean rectEquals(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
