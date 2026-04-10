package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.List;
import net.lucode.hackware.magicindicator.FragmentContainerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

/* JADX INFO: loaded from: classes9.dex */
public class TestPagerIndicator extends View implements IPagerIndicator {
    private RectF mInnerRect;
    private int mInnerRectColor;
    private RectF mOutRect;
    private int mOutRectColor;
    private Paint mPaint;
    private List<PositionData> mPositionDataList;

    public TestPagerIndicator(Context context) {
        super(context);
        this.mOutRect = new RectF();
        this.mInnerRect = new RectF();
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mOutRectColor = -65536;
        this.mInnerRectColor = -16711936;
    }

    public int getInnerRectColor() {
        return this.mInnerRectColor;
    }

    public int getOutRectColor() {
        return this.mOutRectColor;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mOutRectColor);
        canvas.drawRect(this.mOutRect, this.mPaint);
        this.mPaint.setColor(this.mInnerRectColor);
        canvas.drawRect(this.mInnerRect, this.mPaint);
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
        PositionData imitativePositionData = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i);
        PositionData imitativePositionData2 = FragmentContainerHelper.getImitativePositionData(this.mPositionDataList, i + 1);
        RectF rectF = this.mOutRect;
        rectF.left = imitativePositionData.mLeft + ((imitativePositionData2.mLeft - r1) * f);
        rectF.top = imitativePositionData.mTop + ((imitativePositionData2.mTop - r1) * f);
        rectF.right = imitativePositionData.mRight + ((imitativePositionData2.mRight - r1) * f);
        rectF.bottom = imitativePositionData.mBottom + ((imitativePositionData2.mBottom - r1) * f);
        RectF rectF2 = this.mInnerRect;
        rectF2.left = imitativePositionData.mContentLeft + ((imitativePositionData2.mContentLeft - r1) * f);
        rectF2.top = imitativePositionData.mContentTop + ((imitativePositionData2.mContentTop - r1) * f);
        rectF2.right = imitativePositionData.mContentRight + ((imitativePositionData2.mContentRight - r1) * f);
        rectF2.bottom = imitativePositionData.mContentBottom + ((imitativePositionData2.mContentBottom - r7) * f);
        invalidate();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPageSelected(int i) {
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
    public void onPositionDataProvide(List<PositionData> list) {
        this.mPositionDataList = list;
    }

    public void setInnerRectColor(int i) {
        this.mInnerRectColor = i;
    }

    public void setOutRectColor(int i) {
        this.mOutRectColor = i;
    }
}
