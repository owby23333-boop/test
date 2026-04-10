package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

/* JADX INFO: loaded from: classes9.dex */
public class LinePagerIndicator extends View implements IPagerIndicator {
    public static final int MODE_EXACTLY = 2;
    public static final int MODE_MATCH_EDGE = 0;
    public static final int MODE_WRAP_CONTENT = 1;
    private List<Integer> mColors;
    private Interpolator mEndInterpolator;
    private float mLineHeight;
    private RectF mLineRect;
    private float mLineWidth;
    private int mMode;
    private Paint mPaint;
    private List<PositionData> mPositionDataList;
    private float mRoundRadius;
    private Interpolator mStartInterpolator;
    private float mXOffset;
    private float mYOffset;

    public LinePagerIndicator(Context context) {
        super(context);
        this.mStartInterpolator = new LinearInterpolator();
        this.mEndInterpolator = new LinearInterpolator();
        this.mLineRect = new RectF();
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = UIUtil.dip2px(context, 3.0d);
        this.mLineWidth = UIUtil.dip2px(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.mColors;
    }

    public Interpolator getEndInterpolator() {
        return this.mEndInterpolator;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public int getMode() {
        return this.mMode;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public float getRoundRadius() {
        return this.mRoundRadius;
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public float getXOffset() {
        return this.mXOffset;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.mLineRect;
        float f = this.mRoundRadius;
        canvas.drawRoundRect(rectF, f, f, this.mPaint);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
        float fWidth;
        float fWidth2;
        float fWidth3;
        float f2;
        float f3;
        int i3;
        List<PositionData> list = this.mPositionDataList;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.mColors;
        if (list2 != null && list2.size() > 0) {
            this.mPaint.setColor(ArgbEvaluatorHolder.eval(f, this.mColors.get(Math.abs(i) % this.mColors.size()).intValue(), this.mColors.get(Math.abs(i + 1) % this.mColors.size()).intValue()));
        }
        PositionData imitativePositionData = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i);
        PositionData imitativePositionData2 = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i + 1);
        int i4 = this.mMode;
        if (i4 == 0) {
            float f4 = imitativePositionData.mLeft;
            f3 = this.mXOffset;
            fWidth = f4 + f3;
            f2 = imitativePositionData2.mLeft + f3;
            fWidth2 = imitativePositionData.mRight - f3;
            i3 = imitativePositionData2.mRight;
        } else {
            if (i4 != 1) {
                fWidth = imitativePositionData.mLeft + ((imitativePositionData.width() - this.mLineWidth) / 2.0f);
                float fWidth4 = imitativePositionData2.mLeft + ((imitativePositionData2.width() - this.mLineWidth) / 2.0f);
                fWidth2 = ((imitativePositionData.width() + this.mLineWidth) / 2.0f) + imitativePositionData.mLeft;
                fWidth3 = ((imitativePositionData2.width() + this.mLineWidth) / 2.0f) + imitativePositionData2.mLeft;
                f2 = fWidth4;
                this.mLineRect.left = fWidth + ((f2 - fWidth) * this.mStartInterpolator.getInterpolation(f));
                this.mLineRect.right = fWidth2 + ((fWidth3 - fWidth2) * this.mEndInterpolator.getInterpolation(f));
                this.mLineRect.top = (getHeight() - this.mLineHeight) - this.mYOffset;
                this.mLineRect.bottom = getHeight() - this.mYOffset;
                invalidate();
            }
            float f5 = imitativePositionData.mContentLeft;
            f3 = this.mXOffset;
            fWidth = f5 + f3;
            f2 = imitativePositionData2.mContentLeft + f3;
            fWidth2 = imitativePositionData.mContentRight - f3;
            i3 = imitativePositionData2.mContentRight;
        }
        fWidth3 = i3 - f3;
        this.mLineRect.left = fWidth + ((f2 - fWidth) * this.mStartInterpolator.getInterpolation(f));
        this.mLineRect.right = fWidth2 + ((fWidth3 - fWidth2) * this.mEndInterpolator.getInterpolation(f));
        this.mLineRect.top = (getHeight() - this.mLineHeight) - this.mYOffset;
        this.mLineRect.bottom = getHeight() - this.mYOffset;
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<PositionData> list) {
        this.mPositionDataList = list;
    }

    public void setColors(Integer... numArr) {
        this.mColors = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.mEndInterpolator = interpolator;
        if (interpolator == null) {
            this.mEndInterpolator = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
    }

    public void setLineWidth(float f) {
        this.mLineWidth = f;
    }

    public void setMode(int i) {
        if (i == 2 || i == 0 || i == 1) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("mode " + i + " not supported.");
    }

    public void setRoundRadius(float f) {
        this.mRoundRadius = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setXOffset(float f) {
        this.mXOffset = f;
    }

    public void setYOffset(float f) {
        this.mYOffset = f;
    }
}
