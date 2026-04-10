package me.jessyan.art.http.imageloader.glide;

import android.content.res.Resources;
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
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.h;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class GlideOptions extends h implements Cloneable {
    private static GlideOptions centerCropTransform2;
    private static GlideOptions centerInsideTransform1;
    private static GlideOptions circleCropTransform3;
    private static GlideOptions fitCenterTransform0;
    private static GlideOptions noAnimation5;
    private static GlideOptions noTransformation4;

    @NonNull
    @CheckResult
    public static GlideOptions bitmapTransform(@NonNull i<Bitmap> iVar) {
        return new GlideOptions().transform(iVar);
    }

    @NonNull
    @CheckResult
    public static GlideOptions centerCropTransform() {
        if (centerCropTransform2 == null) {
            centerCropTransform2 = new GlideOptions().centerCrop().autoClone();
        }
        return centerCropTransform2;
    }

    @NonNull
    @CheckResult
    public static GlideOptions centerInsideTransform() {
        if (centerInsideTransform1 == null) {
            centerInsideTransform1 = new GlideOptions().centerInside().autoClone();
        }
        return centerInsideTransform1;
    }

    @NonNull
    @CheckResult
    public static GlideOptions circleCropTransform() {
        if (circleCropTransform3 == null) {
            circleCropTransform3 = new GlideOptions().circleCrop().autoClone();
        }
        return circleCropTransform3;
    }

    @NonNull
    @CheckResult
    public static GlideOptions decodeTypeOf(@NonNull Class<?> cls) {
        return new GlideOptions().decode(cls);
    }

    @NonNull
    @CheckResult
    public static GlideOptions diskCacheStrategyOf(@NonNull com.bumptech.glide.load.engine.h hVar) {
        return new GlideOptions().diskCacheStrategy(hVar);
    }

    @NonNull
    @CheckResult
    public static GlideOptions downsampleOf(@NonNull DownsampleStrategy downsampleStrategy) {
        return new GlideOptions().downsample(downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public static GlideOptions encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return new GlideOptions().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static GlideOptions encodeQualityOf(@IntRange(from = 0, to = 100) int i2) {
        return new GlideOptions().encodeQuality(i2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions errorOf(@Nullable Drawable drawable) {
        return new GlideOptions().error(drawable);
    }

    @NonNull
    @CheckResult
    public static GlideOptions fitCenterTransform() {
        if (fitCenterTransform0 == null) {
            fitCenterTransform0 = new GlideOptions().fitCenter().autoClone();
        }
        return fitCenterTransform0;
    }

    @NonNull
    @CheckResult
    public static GlideOptions formatOf(@NonNull DecodeFormat decodeFormat) {
        return new GlideOptions().format(decodeFormat);
    }

    @NonNull
    @CheckResult
    public static GlideOptions frameOf(@IntRange(from = 0) long j2) {
        return new GlideOptions().frame(j2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions noAnimation() {
        if (noAnimation5 == null) {
            noAnimation5 = new GlideOptions().dontAnimate().autoClone();
        }
        return noAnimation5;
    }

    @NonNull
    @CheckResult
    public static GlideOptions noTransformation() {
        if (noTransformation4 == null) {
            noTransformation4 = new GlideOptions().dontTransform().autoClone();
        }
        return noTransformation4;
    }

    @NonNull
    @CheckResult
    public static <T> GlideOptions option(@NonNull e<T> eVar, @NonNull T t2) {
        return new GlideOptions().set(eVar, t2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions overrideOf(int i2, int i3) {
        return new GlideOptions().override(i2, i3);
    }

    @NonNull
    @CheckResult
    public static GlideOptions placeholderOf(@Nullable Drawable drawable) {
        return new GlideOptions().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static GlideOptions priorityOf(@NonNull Priority priority) {
        return new GlideOptions().priority(priority);
    }

    @NonNull
    @CheckResult
    public static GlideOptions signatureOf(@NonNull com.bumptech.glide.load.c cVar) {
        return new GlideOptions().signature(cVar);
    }

    @NonNull
    @CheckResult
    public static GlideOptions sizeMultiplierOf(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        return new GlideOptions().sizeMultiplier(f2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions skipMemoryCacheOf(boolean z2) {
        return new GlideOptions().skipMemoryCache(z2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions timeoutOf(@IntRange(from = 0) int i2) {
        return new GlideOptions().timeout(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a apply(@NonNull com.bumptech.glide.request.a aVar) {
        return apply((com.bumptech.glide.request.a<?>) aVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a decode(@NonNull Class cls) {
        return decode((Class<?>) cls);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a optionalTransform(@NonNull i iVar) {
        return optionalTransform((i<Bitmap>) iVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a set(@NonNull e eVar, @NonNull Object obj) {
        return set((e<Object>) eVar, obj);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transform(@NonNull i iVar) {
        return transform((i<Bitmap>) iVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @Deprecated
    @SafeVarargs
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transforms(@NonNull i[] iVarArr) {
        return transforms((i<Bitmap>[]) iVarArr);
    }

    @NonNull
    @CheckResult
    public static GlideOptions errorOf(@DrawableRes int i2) {
        return new GlideOptions().error(i2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions overrideOf(int i2) {
        return new GlideOptions().override(i2);
    }

    @NonNull
    @CheckResult
    public static GlideOptions placeholderOf(@DrawableRes int i2) {
        return new GlideOptions().placeholder(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions apply(@NonNull com.bumptech.glide.request.a<?> aVar) {
        return (GlideOptions) super.apply(aVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    public GlideOptions autoClone() {
        return (GlideOptions) super.autoClone();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions centerCrop() {
        return (GlideOptions) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions centerInside() {
        return (GlideOptions) super.centerInside();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions circleCrop() {
        return (GlideOptions) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions decode(@NonNull Class<?> cls) {
        return (GlideOptions) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions disallowHardwareConfig() {
        return (GlideOptions) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions diskCacheStrategy(@NonNull com.bumptech.glide.load.engine.h hVar) {
        return (GlideOptions) super.diskCacheStrategy(hVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions dontAnimate() {
        return (GlideOptions) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions dontTransform() {
        return (GlideOptions) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (GlideOptions) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions encodeQuality(@IntRange(from = 0, to = 100) int i2) {
        return (GlideOptions) super.encodeQuality(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions fitCenter() {
        return (GlideOptions) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions format(@NonNull DecodeFormat decodeFormat) {
        return (GlideOptions) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions frame(@IntRange(from = 0) long j2) {
        return (GlideOptions) super.frame(j2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    public GlideOptions lock() {
        return (GlideOptions) super.lock();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions onlyRetrieveFromCache(boolean z2) {
        return (GlideOptions) super.onlyRetrieveFromCache(z2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions optionalCenterCrop() {
        return (GlideOptions) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions optionalCenterInside() {
        return (GlideOptions) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions optionalCircleCrop() {
        return (GlideOptions) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions optionalFitCenter() {
        return (GlideOptions) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions priority(@NonNull Priority priority) {
        return (GlideOptions) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public <Y> GlideOptions set(@NonNull e<Y> eVar, @NonNull Y y2) {
        return (GlideOptions) super.set((e) eVar, (Object) y2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions signature(@NonNull com.bumptech.glide.load.c cVar) {
        return (GlideOptions) super.signature(cVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions sizeMultiplier(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        return (GlideOptions) super.sizeMultiplier(f2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions skipMemoryCache(boolean z2) {
        return (GlideOptions) super.skipMemoryCache(z2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions theme(@Nullable Resources.Theme theme) {
        return (GlideOptions) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions timeout(@IntRange(from = 0) int i2) {
        return (GlideOptions) super.timeout(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @Deprecated
    @SafeVarargs
    @CheckResult
    public final GlideOptions transforms(@NonNull i<Bitmap>... iVarArr) {
        return (GlideOptions) super.transforms(iVarArr);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions useAnimationPool(boolean z2) {
        return (GlideOptions) super.useAnimationPool(z2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions useUnlimitedSourceGeneratorsPool(boolean z2) {
        return (GlideOptions) super.useUnlimitedSourceGeneratorsPool(z2);
    }

    @Override // com.bumptech.glide.request.a
    @CheckResult
    /* JADX INFO: renamed from: clone */
    public GlideOptions mo42clone() {
        return (GlideOptions) super.mo42clone();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions error(@Nullable Drawable drawable) {
        return (GlideOptions) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions fallback(@Nullable Drawable drawable) {
        return (GlideOptions) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions optionalTransform(@NonNull i<Bitmap> iVar) {
        return (GlideOptions) super.optionalTransform(iVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions override(int i2, int i3) {
        return (GlideOptions) super.override(i2, i3);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions placeholder(@Nullable Drawable drawable) {
        return (GlideOptions) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @SafeVarargs
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transform(@NonNull i[] iVarArr) {
        return transform((i<Bitmap>[]) iVarArr);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions error(@DrawableRes int i2) {
        return (GlideOptions) super.error(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions fallback(@DrawableRes int i2) {
        return (GlideOptions) super.fallback(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public <Y> GlideOptions optionalTransform(@NonNull Class<Y> cls, @NonNull i<Y> iVar) {
        return (GlideOptions) super.optionalTransform((Class) cls, (i) iVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions override(int i2) {
        return (GlideOptions) super.override(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions placeholder(@DrawableRes int i2) {
        return (GlideOptions) super.placeholder(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideOptions transform(@NonNull i<Bitmap> iVar) {
        return (GlideOptions) super.transform(iVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @SafeVarargs
    @CheckResult
    public final GlideOptions transform(@NonNull i<Bitmap>... iVarArr) {
        return (GlideOptions) super.transform(iVarArr);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public <Y> GlideOptions transform(@NonNull Class<Y> cls, @NonNull i<Y> iVar) {
        return (GlideOptions) super.transform((Class) cls, (i) iVar);
    }
}
