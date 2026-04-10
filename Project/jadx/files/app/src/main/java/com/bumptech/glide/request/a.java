package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.request.a;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.Map;

/* JADX INFO: compiled from: BaseRequestOptions.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private int errorId;

    @Nullable
    private Drawable errorPlaceholder;

    @Nullable
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;

    @Nullable
    private Drawable placeholderDrawable;
    private int placeholderId;

    @Nullable
    private Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;

    @NonNull
    private com.bumptech.glide.load.engine.h diskCacheStrategy = com.bumptech.glide.load.engine.h.f13536e;

    @NonNull
    private Priority priority = Priority.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;

    @NonNull
    private com.bumptech.glide.load.c signature = com.bumptech.glide.o.c.a();
    private boolean isTransformationAllowed = true;

    @NonNull
    private com.bumptech.glide.load.f options = new com.bumptech.glide.load.f();

    @NonNull
    private Map<Class<?>, com.bumptech.glide.load.i<?>> transformations = new com.bumptech.glide.util.b();

    @NonNull
    private Class<?> resourceClass = Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    private boolean isSet(int i2) {
        return isSet(this.fields, i2);
    }

    private static boolean isSet(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    @NonNull
    private T optionalScaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return (T) scaleOnlyTransform(downsampleStrategy, iVar, false);
    }

    @NonNull
    private T scaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return (T) scaleOnlyTransform(downsampleStrategy, iVar, true);
    }

    private T self() {
        return this;
    }

    @NonNull
    @CheckResult
    public T apply(@NonNull a<?> aVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().apply(aVar);
        }
        if (isSet(aVar.fields, 2)) {
            this.sizeMultiplier = aVar.sizeMultiplier;
        }
        if (isSet(aVar.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = aVar.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(aVar.fields, 1048576)) {
            this.useAnimationPool = aVar.useAnimationPool;
        }
        if (isSet(aVar.fields, 4)) {
            this.diskCacheStrategy = aVar.diskCacheStrategy;
        }
        if (isSet(aVar.fields, 8)) {
            this.priority = aVar.priority;
        }
        if (isSet(aVar.fields, 16)) {
            this.errorPlaceholder = aVar.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(aVar.fields, 32)) {
            this.errorId = aVar.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(aVar.fields, 64)) {
            this.placeholderDrawable = aVar.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(aVar.fields, 128)) {
            this.placeholderId = aVar.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(aVar.fields, 256)) {
            this.isCacheable = aVar.isCacheable;
        }
        if (isSet(aVar.fields, 512)) {
            this.overrideWidth = aVar.overrideWidth;
            this.overrideHeight = aVar.overrideHeight;
        }
        if (isSet(aVar.fields, 1024)) {
            this.signature = aVar.signature;
        }
        if (isSet(aVar.fields, 4096)) {
            this.resourceClass = aVar.resourceClass;
        }
        if (isSet(aVar.fields, 8192)) {
            this.fallbackDrawable = aVar.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(aVar.fields, 16384)) {
            this.fallbackId = aVar.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(aVar.fields, 32768)) {
            this.theme = aVar.theme;
        }
        if (isSet(aVar.fields, 65536)) {
            this.isTransformationAllowed = aVar.isTransformationAllowed;
        }
        if (isSet(aVar.fields, 131072)) {
            this.isTransformationRequired = aVar.isTransformationRequired;
        }
        if (isSet(aVar.fields, 2048)) {
            this.transformations.putAll(aVar.transformations);
            this.isScaleOnlyOrNoTransform = aVar.isScaleOnlyOrNoTransform;
        }
        if (isSet(aVar.fields, 524288)) {
            this.onlyRetrieveFromCache = aVar.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            this.fields &= -2049;
            this.isTransformationRequired = false;
            this.fields &= -131073;
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= aVar.fields;
        this.options.a(aVar.options);
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    public T autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return (T) lock();
    }

    @NonNull
    @CheckResult
    public T centerCrop() {
        return (T) transform(DownsampleStrategy.f13751c, new com.bumptech.glide.load.resource.bitmap.i());
    }

    @NonNull
    @CheckResult
    public T centerInside() {
        return (T) scaleOnlyTransform(DownsampleStrategy.b, new com.bumptech.glide.load.resource.bitmap.j());
    }

    @NonNull
    @CheckResult
    public T circleCrop() {
        return (T) transform(DownsampleStrategy.b, new k());
    }

    @NonNull
    @CheckResult
    public T decode(@NonNull Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().decode(cls);
        }
        com.bumptech.glide.util.k.a(cls);
        this.resourceClass = cls;
        this.fields |= 4096;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T disallowHardwareConfig() {
        return (T) set(l.f13776i, false);
    }

    @NonNull
    @CheckResult
    public T diskCacheStrategy(@NonNull com.bumptech.glide.load.engine.h hVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().diskCacheStrategy(hVar);
        }
        com.bumptech.glide.util.k.a(hVar);
        this.diskCacheStrategy = hVar;
        this.fields |= 4;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T dontAnimate() {
        return (T) set(com.bumptech.glide.load.k.g.i.b, true);
    }

    @NonNull
    @CheckResult
    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().dontTransform();
        }
        this.transformations.clear();
        this.fields &= -2049;
        this.isTransformationRequired = false;
        this.fields &= -131073;
        this.isTransformationAllowed = false;
        this.fields |= 65536;
        this.isScaleOnlyOrNoTransform = true;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        com.bumptech.glide.load.e eVar = DownsampleStrategy.f13754f;
        com.bumptech.glide.util.k.a(downsampleStrategy);
        return (T) set(eVar, downsampleStrategy);
    }

    @NonNull
    @CheckResult
    public T encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        com.bumptech.glide.load.e eVar = com.bumptech.glide.load.resource.bitmap.c.f13770c;
        com.bumptech.glide.util.k.a(compressFormat);
        return (T) set(eVar, compressFormat);
    }

    @NonNull
    @CheckResult
    public T encodeQuality(@IntRange(from = 0, to = 100) int i2) {
        return (T) set(com.bumptech.glide.load.resource.bitmap.c.b, Integer.valueOf(i2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == aVar.errorId && com.bumptech.glide.util.l.b(this.errorPlaceholder, aVar.errorPlaceholder) && this.placeholderId == aVar.placeholderId && com.bumptech.glide.util.l.b(this.placeholderDrawable, aVar.placeholderDrawable) && this.fallbackId == aVar.fallbackId && com.bumptech.glide.util.l.b(this.fallbackDrawable, aVar.fallbackDrawable) && this.isCacheable == aVar.isCacheable && this.overrideHeight == aVar.overrideHeight && this.overrideWidth == aVar.overrideWidth && this.isTransformationRequired == aVar.isTransformationRequired && this.isTransformationAllowed == aVar.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == aVar.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == aVar.onlyRetrieveFromCache && this.diskCacheStrategy.equals(aVar.diskCacheStrategy) && this.priority == aVar.priority && this.options.equals(aVar.options) && this.transformations.equals(aVar.transformations) && this.resourceClass.equals(aVar.resourceClass) && com.bumptech.glide.util.l.b(this.signature, aVar.signature) && com.bumptech.glide.util.l.b(this.theme, aVar.theme);
    }

    @NonNull
    @CheckResult
    public T error(@Nullable Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        this.fields |= 16;
        this.errorId = 0;
        this.fields &= -33;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T fallback(@Nullable Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        this.fields |= 8192;
        this.fallbackId = 0;
        this.fields &= -16385;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T fitCenter() {
        return (T) scaleOnlyTransform(DownsampleStrategy.a, new p());
    }

    @NonNull
    @CheckResult
    public T format(@NonNull DecodeFormat decodeFormat) {
        com.bumptech.glide.util.k.a(decodeFormat);
        return (T) set(l.f13773f, decodeFormat).set(com.bumptech.glide.load.k.g.i.a, decodeFormat);
    }

    @NonNull
    @CheckResult
    public T frame(@IntRange(from = 0) long j2) {
        return (T) set(VideoDecoder.f13765d, Long.valueOf(j2));
    }

    @NonNull
    public final com.bumptech.glide.load.engine.h getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    @NonNull
    public final com.bumptech.glide.load.f getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    @NonNull
    public final Priority getPriority() {
        return this.priority;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    @NonNull
    public final com.bumptech.glide.load.c getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.theme;
    }

    @NonNull
    public final Map<Class<?>, com.bumptech.glide.load.i<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return com.bumptech.glide.util.l.a(this.theme, com.bumptech.glide.util.l.a(this.signature, com.bumptech.glide.util.l.a(this.resourceClass, com.bumptech.glide.util.l.a(this.transformations, com.bumptech.glide.util.l.a(this.options, com.bumptech.glide.util.l.a(this.priority, com.bumptech.glide.util.l.a(this.diskCacheStrategy, com.bumptech.glide.util.l.a(this.onlyRetrieveFromCache, com.bumptech.glide.util.l.a(this.useUnlimitedSourceGeneratorsPool, com.bumptech.glide.util.l.a(this.isTransformationAllowed, com.bumptech.glide.util.l.a(this.isTransformationRequired, com.bumptech.glide.util.l.a(this.overrideWidth, com.bumptech.glide.util.l.a(this.overrideHeight, com.bumptech.glide.util.l.a(this.isCacheable, com.bumptech.glide.util.l.a(this.fallbackDrawable, com.bumptech.glide.util.l.a(this.fallbackId, com.bumptech.glide.util.l.a(this.placeholderDrawable, com.bumptech.glide.util.l.a(this.placeholderId, com.bumptech.glide.util.l.a(this.errorPlaceholder, com.bumptech.glide.util.l.a(this.errorId, com.bumptech.glide.util.l.a(this.sizeMultiplier)))))))))))))))))))));
    }

    protected final boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return com.bumptech.glide.util.l.b(this.overrideWidth, this.overrideHeight);
    }

    @NonNull
    public T lock() {
        this.isLocked = true;
        return (T) self();
    }

    @NonNull
    @CheckResult
    public T onlyRetrieveFromCache(boolean z2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().onlyRetrieveFromCache(z2);
        }
        this.onlyRetrieveFromCache = z2;
        this.fields |= 524288;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T optionalCenterCrop() {
        return (T) optionalTransform(DownsampleStrategy.f13751c, new com.bumptech.glide.load.resource.bitmap.i());
    }

    @NonNull
    @CheckResult
    public T optionalCenterInside() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.b, new com.bumptech.glide.load.resource.bitmap.j());
    }

    @NonNull
    @CheckResult
    public T optionalCircleCrop() {
        return (T) optionalTransform(DownsampleStrategy.f13751c, new k());
    }

    @NonNull
    @CheckResult
    public T optionalFitCenter() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.a, new p());
    }

    @NonNull
    final T optionalTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().optionalTransform(downsampleStrategy, iVar);
        }
        downsample(downsampleStrategy);
        return (T) transform(iVar, false);
    }

    @NonNull
    @CheckResult
    public T override(int i2, int i3) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().override(i2, i3);
        }
        this.overrideWidth = i2;
        this.overrideHeight = i3;
        this.fields |= 512;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T placeholder(@Nullable Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        this.fields |= 64;
        this.placeholderId = 0;
        this.fields &= -129;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T priority(@NonNull Priority priority) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().priority(priority);
        }
        com.bumptech.glide.util.k.a(priority);
        this.priority = priority;
        this.fields |= 8;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    protected final T selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) self();
    }

    @NonNull
    @CheckResult
    public <Y> T set(@NonNull com.bumptech.glide.load.e<Y> eVar, @NonNull Y y2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().set(eVar, y2);
        }
        com.bumptech.glide.util.k.a(eVar);
        com.bumptech.glide.util.k.a(y2);
        this.options.a(eVar, y2);
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T signature(@NonNull com.bumptech.glide.load.c cVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().signature(cVar);
        }
        com.bumptech.glide.util.k.a(cVar);
        this.signature = cVar;
        this.fields |= 1024;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T sizeMultiplier(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().sizeMultiplier(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = f2;
        this.fields |= 2;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T skipMemoryCache(boolean z2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().skipMemoryCache(true);
        }
        this.isCacheable = !z2;
        this.fields |= 256;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T theme(@Nullable Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= 32768;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T timeout(@IntRange(from = 0) int i2) {
        return (T) set(com.bumptech.glide.load.j.y.a.b, Integer.valueOf(i2));
    }

    @NonNull
    @CheckResult
    final T transform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().transform(downsampleStrategy, iVar);
        }
        downsample(downsampleStrategy);
        return (T) transform(iVar);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public T transforms(@NonNull com.bumptech.glide.load.i<Bitmap>... iVarArr) {
        return (T) transform((com.bumptech.glide.load.i<Bitmap>) new com.bumptech.glide.load.d(iVarArr), true);
    }

    @NonNull
    @CheckResult
    public T useAnimationPool(boolean z2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().useAnimationPool(z2);
        }
        this.useAnimationPool = z2;
        this.fields |= 1048576;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T useUnlimitedSourceGeneratorsPool(boolean z2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().useUnlimitedSourceGeneratorsPool(z2);
        }
        this.useUnlimitedSourceGeneratorsPool = z2;
        this.fields |= 262144;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    private T scaleOnlyTransform(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.bumptech.glide.load.i<Bitmap> iVar, boolean z2) {
        T t2 = z2 ? (T) transform(downsampleStrategy, iVar) : (T) optionalTransform(downsampleStrategy, iVar);
        t2.isScaleOnlyOrNoTransform = true;
        return t2;
    }

    @Override // 
    @CheckResult
    /* JADX INFO: renamed from: clone */
    public T mo42clone() {
        try {
            T t2 = (T) super.clone();
            t2.options = new com.bumptech.glide.load.f();
            t2.options.a(this.options);
            t2.transformations = new com.bumptech.glide.util.b();
            t2.transformations.putAll(this.transformations);
            t2.isLocked = false;
            t2.isAutoCloneEnabled = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    public T optionalTransform(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return (T) transform(iVar, false);
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull com.bumptech.glide.load.i<Bitmap> iVar) {
        return (T) transform(iVar, true);
    }

    @NonNull
    @CheckResult
    public <Y> T optionalTransform(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar) {
        return (T) transform(cls, iVar, false);
    }

    @NonNull
    @CheckResult
    public T transform(@NonNull com.bumptech.glide.load.i<Bitmap>... iVarArr) {
        if (iVarArr.length > 1) {
            return (T) transform((com.bumptech.glide.load.i<Bitmap>) new com.bumptech.glide.load.d(iVarArr), true);
        }
        if (iVarArr.length == 1) {
            return (T) transform(iVarArr[0]);
        }
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T override(int i2) {
        return (T) override(i2, i2);
    }

    @NonNull
    @CheckResult
    public T error(@DrawableRes int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().error(i2);
        }
        this.errorId = i2;
        this.fields |= 32;
        this.errorPlaceholder = null;
        this.fields &= -17;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T fallback(@DrawableRes int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().fallback(i2);
        }
        this.fallbackId = i2;
        this.fields |= 16384;
        this.fallbackDrawable = null;
        this.fields &= -8193;
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public T placeholder(@DrawableRes int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().placeholder(i2);
        }
        this.placeholderId = i2;
        this.fields |= 128;
        this.placeholderDrawable = null;
        this.fields &= -65;
        return (T) selfOrThrowIfLocked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T transform(@NonNull com.bumptech.glide.load.i<Bitmap> iVar, boolean z2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().transform(iVar, z2);
        }
        n nVar = new n(iVar, z2);
        transform(Bitmap.class, iVar, z2);
        transform(Drawable.class, nVar, z2);
        nVar.a();
        transform(BitmapDrawable.class, nVar, z2);
        transform(com.bumptech.glide.load.k.g.c.class, new com.bumptech.glide.load.k.g.f(iVar), z2);
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    <Y> T transform(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar, boolean z2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo42clone().transform(cls, iVar, z2);
        }
        com.bumptech.glide.util.k.a(cls);
        com.bumptech.glide.util.k.a(iVar);
        this.transformations.put(cls, iVar);
        this.fields |= 2048;
        this.isTransformationAllowed = true;
        this.fields |= 65536;
        this.isScaleOnlyOrNoTransform = false;
        if (z2) {
            this.fields |= 131072;
            this.isTransformationRequired = true;
        }
        return (T) selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public <Y> T transform(@NonNull Class<Y> cls, @NonNull com.bumptech.glide.load.i<Y> iVar) {
        return (T) transform(cls, iVar, true);
    }
}
