package com.kwad.sdk.core.imageloader.utils;

import android.opengl.GLES10;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    /* JADX INFO: renamed from: com.kwad.sdk.core.imageloader.utils.ImageSizeUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType = new int[ViewScaleType.values().length];

        static {
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[ViewScaleType.CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int iMax = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(iMax, iMax);
    }

    private ImageSizeUtils() {
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z2) {
        int iMax;
        int i2;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i3 = AnonymousClass1.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$ViewScaleType[viewScaleType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                iMax = 1;
            } else if (z2) {
                int i4 = width / 2;
                int i5 = height / 2;
                i2 = 1;
                while (i4 / i2 > width2 && i5 / i2 > height2) {
                    i2 *= 2;
                }
                iMax = i2;
            } else {
                iMax = Math.min(width / width2, height / height2);
            }
        } else if (z2) {
            int i6 = width / 2;
            int i7 = height / 2;
            i2 = 1;
            while (true) {
                if (i6 / i2 <= width2 && i7 / i2 <= height2) {
                    break;
                }
                i2 *= 2;
            }
            iMax = i2;
        } else {
            iMax = Math.max(width / width2, height / height2);
        }
        if (iMax <= 0) {
            iMax = 1;
        }
        return considerMaxTextureSize(width, height, iMax, z2);
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z2) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f2 = width;
        float f3 = f2 / width2;
        float f4 = height;
        float f5 = f4 / height2;
        if ((viewScaleType != ViewScaleType.FIT_INSIDE || f3 < f5) && (viewScaleType != ViewScaleType.CROP || f3 >= f5)) {
            width2 = (int) (f2 / f5);
        } else {
            height2 = (int) (f4 / f3);
        }
        if ((z2 || width2 >= width || height2 >= height) && (!z2 || width2 == width || height2 == height)) {
            return 1.0f;
        }
        return width2 / f2;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    private static int considerMaxTextureSize(int i2, int i3, int i4, boolean z2) {
        int width = maxBitmapSize.getWidth();
        int height = maxBitmapSize.getHeight();
        while (true) {
            if (i2 / i4 <= width && i3 / i4 <= height) {
                return i4;
            }
            i4 = z2 ? i4 * 2 : i4 + 1;
        }
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = imageSize.getHeight();
        }
        return new ImageSize(width, height);
    }
}
