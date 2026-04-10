package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: compiled from: RequestOptions.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends a<h> {

    @Nullable
    private static h centerCropOptions;

    @Nullable
    private static h centerInsideOptions;

    @Nullable
    private static h circleCropOptions;

    @Nullable
    private static h fitCenterOptions;

    @Nullable
    private static h noAnimationOptions;

    @Nullable
    private static h noTransformOptions;

    @Nullable
    private static h skipMemoryCacheFalseOptions;

    @Nullable
    private static h skipMemoryCacheTrueOptions;

    @NonNull
    @CheckResult
    public static h bitmapTransform(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return new h().transform(iVar);
    }

    @NonNull
    @CheckResult
    public static h centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new h().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    @NonNull
    @CheckResult
    public static h centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new h().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    @NonNull
    @CheckResult
    public static h circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new h().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    @NonNull
    @CheckResult
    public static h decodeTypeOf(@NonNull Class<?> cls) {
        return new h().decode(cls);
    }

    @NonNull
    @CheckResult
    public static h diskCacheStrategyOf(@NonNull com.bumptech.glide.load.engine.h hVar) {
        return new h().diskCacheStrategy(hVar);
    }

    @NonNull
    @CheckResult
    public static h downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return new h().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static h encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return new h().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static h encodeQualityOf(@IntRange(from = 0, to = 100) int i2) {
        return new h().encodeQuality(i2);
    }

    @NonNull
    @CheckResult
    public static h errorOf(@Nullable Drawable drawable) {
        return new h().error(drawable);
    }

    @NonNull
    @CheckResult
    public static h fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new h().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    @NonNull
    @CheckResult
    public static h formatOf(@NonNull DecodeFormat decodeFormat) {
        return new h().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static h frameOf(@IntRange(from = 0) long j2) {
        return new h().frame(j2);
    }

    @NonNull
    @CheckResult
    public static h noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new h().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }

    @NonNull
    @CheckResult
    public static h noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new h().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    @NonNull
    @CheckResult
    public static <T> h option(@NonNull com.bumptech.glide.load.e<T> eVar, @NonNull T t2) {
        return new h().set(eVar, t2);
    }

    @NonNull
    @CheckResult
    public static h overrideOf(int i2, int i3) {
        return new h().override(i2, i3);
    }

    @NonNull
    @CheckResult
    public static h placeholderOf(@Nullable Drawable drawable) {
        return new h().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static h priorityOf(@NonNull Priority priority) {
        return new h().priority(priority);
    }

    @NonNull
    @CheckResult
    public static h signatureOf(@NonNull com.bumptech.glide.load.c cVar) {
        return new h().signature(cVar);
    }

    @NonNull
    @CheckResult
    public static h sizeMultiplierOf(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        return new h().sizeMultiplier(f2);
    }

    @NonNull
    @CheckResult
    public static h skipMemoryCacheOf(boolean z2) {
        if (z2) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new h().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new h().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    @NonNull
    @CheckResult
    public static h timeoutOf(@IntRange(from = 0) int i2) {
        return new h().timeout(i2);
    }

    @NonNull
    @CheckResult
    public static h errorOf(@DrawableRes int i2) {
        return new h().error(i2);
    }

    @NonNull
    @CheckResult
    public static h overrideOf(int i2) {
        return overrideOf(i2, i2);
    }

    @NonNull
    @CheckResult
    public static h placeholderOf(@DrawableRes int i2) {
        return new h().placeholder(i2);
    }
}
