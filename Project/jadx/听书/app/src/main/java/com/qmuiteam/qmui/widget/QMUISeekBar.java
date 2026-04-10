package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.collection.SimpleArrayMap;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISeekBar extends QMUISlider {
    private static SimpleArrayMap<String, Integer> sDefaultSkinAttrs;
    private int mTickHeight;
    private int mTickWidth;

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(2);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(QMUISkinValueBuilder.BACKGROUND, Integer.valueOf(R.attr.qmui_skin_support_seek_bar_color));
        sDefaultSkinAttrs.put(QMUISkinValueBuilder.PROGRESS_COLOR, Integer.valueOf(R.attr.qmui_skin_support_seek_bar_color));
    }

    public QMUISeekBar(Context context) {
        this(context, null);
    }

    public QMUISeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUISeekBarStyle);
    }

    public QMUISeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUISeekBar, i, 0);
        this.mTickWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUISeekBar_qmui_seek_bar_tick_width, QMUIDisplayHelper.dp2px(context, 1));
        this.mTickHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUISeekBar_qmui_seek_bar_tick_height, QMUIDisplayHelper.dp2px(context, 4));
        typedArrayObtainStyledAttributes.recycle();
        setClickToChangeProgress(true);
    }

    public void setTickHeight(int i) {
        this.mTickHeight = i;
        invalidate();
    }

    public void setTickWidth(int i) {
        this.mTickWidth = i;
        invalidate();
    }

    public int getTickHeight() {
        return this.mTickHeight;
    }

    @Override // com.qmuiteam.qmui.widget.QMUISlider
    protected void drawRect(Canvas canvas, RectF rectF, int i, Paint paint, boolean z) {
        canvas.drawRect(rectF, paint);
    }

    @Override // com.qmuiteam.qmui.widget.QMUISlider
    protected void drawTick(Canvas canvas, int i, int i2, int i3, int i4, float f, Paint paint, int i5, int i6) {
        int i7;
        int i8 = this.mTickHeight;
        if (i8 <= 0 || (i7 = this.mTickWidth) <= 0 || i2 < 1) {
            return;
        }
        float f2 = ((i4 - i3) - i7) / i2;
        float f3 = f - (i8 / 2.0f);
        float f4 = f + (i8 / 2.0f);
        float f5 = i3 + (i7 / 2.0f);
        int i9 = 0;
        while (i9 <= i2) {
            int i10 = this.mTickWidth;
            float f6 = f5 - (i10 / 2.0f);
            float f7 = f5 + (i10 / 2.0f);
            paint.setColor(i9 <= i ? i6 : i5);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f6, f3, f7, f4, paint);
            f5 += f2;
            i9++;
        }
    }

    @Override // com.qmuiteam.qmui.widget.QMUISlider, com.qmuiteam.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }
}
