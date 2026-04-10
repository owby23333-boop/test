package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes3.dex */
public class RatioFrameLayout extends FrameLayout {
    private double ahM;

    public RatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.ahM = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    public double getRatio() {
        return this.ahM;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.ahM != PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            int size = View.MeasureSpec.getSize(i2);
            String str = "widthSize:" + size;
            double d2 = size;
            double d3 = this.ahM;
            Double.isNaN(d2);
            i3 = View.MeasureSpec.makeMeasureSpec((int) (d2 * d3), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setRatio(double d2) {
        this.ahM = d2;
    }
}
