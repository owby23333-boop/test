package com.amgcyo.cuttadon.sdk.self.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;

/* JADX INFO: loaded from: classes.dex */
public class PreviewVideoView extends VideoView {
    public PreviewVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, (int) (size / 0.56f));
    }

    public PreviewVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
