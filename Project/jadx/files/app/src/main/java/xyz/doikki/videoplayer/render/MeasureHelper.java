package xyz.doikki.videoplayer.render;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class MeasureHelper {
    private int mCurrentScreenScale;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoWidth;

    public int[] doMeasure(int i2, int i3) {
        int i4;
        int i5 = this.mVideoRotationDegree;
        if (i5 == 90 || i5 == 270) {
            int i6 = i2 + i3;
            i3 = i6 - i3;
            i2 = i6 - i3;
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i7 = this.mVideoHeight;
        if (i7 == 0 || (i4 = this.mVideoWidth) == 0) {
            return new int[]{size, size2};
        }
        int i8 = this.mCurrentScreenScale;
        if (i8 == 1) {
            i3 = (size / 16) * 9;
            if (size2 <= i3) {
                i2 = (size2 / 9) * 16;
                i3 = size2;
            }
            i2 = size;
        } else if (i8 == 2) {
            i3 = (size / 4) * 3;
            if (size2 <= i3) {
                i2 = (size2 / 3) * 4;
                i3 = size2;
            }
            i2 = size;
        } else if (i8 != 3) {
            if (i8 == 4) {
                i3 = i7;
                i2 = i4;
            } else if (i8 != 5) {
                if (i4 * size2 < size * i7) {
                    i2 = (i4 * size2) / i7;
                } else if (i4 * size2 > size * i7) {
                    i3 = (i7 * size) / i4;
                    i2 = size;
                } else {
                    i2 = size;
                }
                i3 = size2;
            } else if (i4 * size2 > size * i7) {
                i2 = (i4 * size2) / i7;
                i3 = size2;
            } else {
                i3 = (i7 * size) / i4;
                i2 = size;
            }
        }
        return new int[]{i2, i3};
    }

    public void setScreenScale(int i2) {
        this.mCurrentScreenScale = i2;
    }

    public void setVideoRotation(int i2) {
        this.mVideoRotationDegree = i2;
    }

    public void setVideoSize(int i2, int i3) {
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
    }
}
