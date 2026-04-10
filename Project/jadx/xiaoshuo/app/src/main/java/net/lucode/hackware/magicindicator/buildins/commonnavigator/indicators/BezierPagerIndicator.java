package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

/* JADX INFO: loaded from: classes9.dex */
public class BezierPagerIndicator extends View implements IPagerIndicator {
    private List<Integer> mColors;
    private Interpolator mEndInterpolator;
    private float mLeftCircleRadius;
    private float mLeftCircleX;
    private float mMaxCircleRadius;
    private float mMinCircleRadius;
    private Paint mPaint;
    private Path mPath;
    private List<PositionData> mPositionDataList;
    private float mRightCircleRadius;
    private float mRightCircleX;
    private Interpolator mStartInterpolator;
    private float mYOffset;

    public BezierPagerIndicator(Context context) {
        super(context);
        this.mPath = new Path();
        this.mStartInterpolator = new AccelerateInterpolator();
        this.mEndInterpolator = new DecelerateInterpolator();
        init(context);
    }

    private void drawBezierCurve(Canvas canvas) {
        this.mPath.reset();
        float height = (getHeight() - this.mYOffset) - this.mMaxCircleRadius;
        this.mPath.moveTo(this.mRightCircleX, height);
        this.mPath.lineTo(this.mRightCircleX, height - this.mRightCircleRadius);
        Path path = this.mPath;
        float f = this.mRightCircleX;
        float f2 = this.mLeftCircleX;
        path.quadTo(f + ((f2 - f) / 2.0f), height, f2, height - this.mLeftCircleRadius);
        this.mPath.lineTo(this.mLeftCircleX, this.mLeftCircleRadius + height);
        Path path2 = this.mPath;
        float f3 = this.mRightCircleX;
        path2.quadTo(((this.mLeftCircleX - f3) / 2.0f) + f3, height, f3, this.mRightCircleRadius + height);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mMaxCircleRadius = UIUtil.dip2px(context, 3.5d);
        this.mMinCircleRadius = UIUtil.dip2px(context, 2.0d);
        this.mYOffset = UIUtil.dip2px(context, 1.5d);
    }

    public float getMaxCircleRadius() {
        return this.mMaxCircleRadius;
    }

    public float getMinCircleRadius() {
        return this.mMinCircleRadius;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.mLeftCircleX, (getHeight() - this.mYOffset) - this.mMaxCircleRadius, this.mLeftCircleRadius, this.mPaint);
        canvas.drawCircle(this.mRightCircleX, (getHeight() - this.mYOffset) - this.mMaxCircleRadius, this.mRightCircleRadius, this.mPaint);
        drawBezierCurve(canvas);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrollStateChanged(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageScrolled(int i, float f, int i2) {
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
        int i3 = imitativePositionData.mLeft;
        float f2 = i3 + ((imitativePositionData.mRight - i3) / 2);
        int i4 = imitativePositionData2.mLeft;
        float f3 = (i4 + ((imitativePositionData2.mRight - i4) / 2)) - f2;
        this.mLeftCircleX = (this.mStartInterpolator.getInterpolation(f) * f3) + f2;
        this.mRightCircleX = f2 + (f3 * this.mEndInterpolator.getInterpolation(f));
        float f4 = this.mMaxCircleRadius;
        this.mLeftCircleRadius = f4 + ((this.mMinCircleRadius - f4) * this.mEndInterpolator.getInterpolation(f));
        float f5 = this.mMinCircleRadius;
        this.mRightCircleRadius = f5 + ((this.mMaxCircleRadius - f5) * this.mStartInterpolator.getInterpolation(f));
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
            this.mEndInterpolator = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f) {
        this.mMaxCircleRadius = f;
    }

    public void setMinCircleRadius(float f) {
        this.mMinCircleRadius = f;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f) {
        this.mYOffset = f;
    }
}
