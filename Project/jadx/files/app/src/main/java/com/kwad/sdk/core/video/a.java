package com.kwad.sdk.core.video;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends TextureView {
    private int videoHeight;
    private int videoWidth;

    public a(Context context) {
        super(context);
    }

    public final void adaptVideoSize(int i2, int i3) {
        if (this.videoWidth == i2 || this.videoHeight == i3) {
            return;
        }
        this.videoWidth = i2;
        this.videoHeight = i3;
        requestLayout();
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i3) {
        int size;
        int i4;
        float rotation = getRotation();
        if (rotation == 90.0f || rotation == 270.0f) {
            i3 = i2;
            i2 = i3;
        }
        int defaultSize = TextureView.getDefaultSize(this.videoWidth, i2);
        int defaultSize2 = TextureView.getDefaultSize(this.videoHeight, i3);
        if (this.videoWidth <= 0 || this.videoHeight <= 0) {
            size = defaultSize;
        } else {
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.videoWidth;
                int i6 = i5 * size2;
                int i7 = this.videoHeight;
                if (i6 < size * i7) {
                    defaultSize = (i5 * size2) / i7;
                    defaultSize2 = size2;
                } else {
                    defaultSize2 = i5 * size2 > size * i7 ? (i7 * size) / i5 : size2;
                }
            } else if (mode == 1073741824) {
                int i8 = this.videoHeight;
                int i9 = this.videoWidth;
                int i10 = (size * i8) / i9;
                if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                    defaultSize2 = i10;
                } else {
                    defaultSize = (i9 * size2) / i8;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                int i11 = this.videoWidth;
                int i12 = this.videoHeight;
                i4 = (size2 * i11) / i12;
                if (mode != Integer.MIN_VALUE || i4 <= size) {
                    defaultSize2 = size2;
                    size = i4;
                } else {
                    defaultSize2 = (i12 * size) / i11;
                }
            } else {
                i4 = this.videoWidth;
                int i13 = this.videoHeight;
                if (mode2 != Integer.MIN_VALUE || i13 <= size2) {
                    defaultSize2 = i13;
                } else {
                    i4 = (i4 * size2) / i13;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i4 <= size) {
                    size = i4;
                } else {
                    defaultSize2 = (this.videoHeight * size) / this.videoWidth;
                }
            }
            size = defaultSize;
        }
        setMeasuredDimension(size, defaultSize2);
    }

    @Override // android.view.View
    public final void setRotation(float f2) {
        if (f2 != getRotation()) {
            super.setRotation(f2);
            requestLayout();
        }
    }
}
