package me.jessyan.art.http.imageloader.glide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.h;
import com.bumptech.glide.j;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.g;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.io.File;
import java.net.URL;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GlideRequest<TranscodeType> extends h<TranscodeType> implements Cloneable {
    GlideRequest(@NonNull Class<TranscodeType> cls, @NonNull h<?> hVar) {
        super(cls, hVar);
    }

    @Override // com.bumptech.glide.h, com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ h apply(@NonNull com.bumptech.glide.request.a aVar) {
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
    @CheckResult
    @Deprecated
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transforms(@NonNull i[] iVarArr) {
        return transforms((i<Bitmap>[]) iVarArr);
    }

    GlideRequest(@NonNull com.bumptech.glide.c cVar, @NonNull com.bumptech.glide.i iVar, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(cVar, iVar, cls, context);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> addListener(@Nullable g<TranscodeType> gVar) {
        return (GlideRequest) super.addListener((g) gVar);
    }

    @Override // com.bumptech.glide.h, com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a apply(@NonNull com.bumptech.glide.request.a aVar) {
        return apply((com.bumptech.glide.request.a<?>) aVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    public GlideRequest<TranscodeType> autoClone() {
        return (GlideRequest) super.autoClone();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> centerCrop() {
        return (GlideRequest) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> centerInside() {
        return (GlideRequest) super.centerInside();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> circleCrop() {
        return (GlideRequest) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> decode(@NonNull Class<?> cls) {
        return (GlideRequest) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        return (GlideRequest) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> diskCacheStrategy(@NonNull com.bumptech.glide.load.engine.h hVar) {
        return (GlideRequest) super.diskCacheStrategy(hVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> dontAnimate() {
        return (GlideRequest) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> dontTransform() {
        return (GlideRequest) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (GlideRequest) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (GlideRequest) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> encodeQuality(@IntRange(from = 0, to = 100) int i2) {
        return (GlideRequest) super.encodeQuality(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> fitCenter() {
        return (GlideRequest) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> format(@NonNull DecodeFormat decodeFormat) {
        return (GlideRequest) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> frame(@IntRange(from = 0) long j2) {
        return (GlideRequest) super.frame(j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    public GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).apply((com.bumptech.glide.request.a<?>) h.DOWNLOAD_ONLY_OPTIONS);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> listener(@Nullable g<TranscodeType> gVar) {
        return (GlideRequest) super.listener((g) gVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    public GlideRequest<TranscodeType> lock() {
        return (GlideRequest) super.lock();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean z2) {
        return (GlideRequest) super.onlyRetrieveFromCache(z2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalCenterCrop() {
        return (GlideRequest) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalCenterInside() {
        return (GlideRequest) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalCircleCrop() {
        return (GlideRequest) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalFitCenter() {
        return (GlideRequest) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> priority(@NonNull Priority priority) {
        return (GlideRequest) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public <Y> GlideRequest<TranscodeType> set(@NonNull e<Y> eVar, @NonNull Y y2) {
        return (GlideRequest) super.set((e) eVar, (Object) y2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> signature(@NonNull com.bumptech.glide.load.c cVar) {
        return (GlideRequest) super.signature(cVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> sizeMultiplier(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        return (GlideRequest) super.sizeMultiplier(f2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> skipMemoryCache(boolean z2) {
        return (GlideRequest) super.skipMemoryCache(z2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> theme(@Nullable Resources.Theme theme) {
        return (GlideRequest) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> timeout(@IntRange(from = 0) int i2) {
        return (GlideRequest) super.timeout(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    @Deprecated
    public GlideRequest<TranscodeType> transforms(@NonNull i<Bitmap>... iVarArr) {
        return (GlideRequest) super.transforms(iVarArr);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> transition(@NonNull j<?, ? super TranscodeType> jVar) {
        return (GlideRequest) super.transition((j) jVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> useAnimationPool(boolean z2) {
        return (GlideRequest) super.useAnimationPool(z2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z2) {
        return (GlideRequest) super.useUnlimitedSourceGeneratorsPool(z2);
    }

    @Override // com.bumptech.glide.h, com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> apply(@NonNull com.bumptech.glide.request.a<?> aVar) {
        return (GlideRequest) super.apply(aVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> fallback(@Nullable Drawable drawable) {
        return (GlideRequest) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> optionalTransform(@NonNull i<Bitmap> iVar) {
        return (GlideRequest) super.optionalTransform(iVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> override(int i2, int i3) {
        return (GlideRequest) super.override(i2, i3);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> placeholder(@Nullable Drawable drawable) {
        return (GlideRequest) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a transform(@NonNull i[] iVarArr) {
        return transform((i<Bitmap>[]) iVarArr);
    }

    @Override // com.bumptech.glide.h, com.bumptech.glide.request.a
    @CheckResult
    /* JADX INFO: renamed from: clone */
    public GlideRequest<TranscodeType> mo42clone() {
        return (GlideRequest) super.mo42clone();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> fallback(@DrawableRes int i2) {
        return (GlideRequest) super.fallback(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public <Y> GlideRequest<TranscodeType> optionalTransform(@NonNull Class<Y> cls, @NonNull i<Y> iVar) {
        return (GlideRequest) super.optionalTransform((Class) cls, (i) iVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> override(int i2) {
        return (GlideRequest) super.override(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> placeholder(@DrawableRes int i2) {
        return (GlideRequest) super.placeholder(i2);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> transform(@NonNull i<Bitmap> iVar) {
        return (GlideRequest) super.transform(iVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> error(@Nullable Drawable drawable) {
        return (GlideRequest) super.error(drawable);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> thumbnail(@Nullable h<TranscodeType> hVar) {
        return (GlideRequest) super.thumbnail((h) hVar);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> transform(@NonNull i<Bitmap>... iVarArr) {
        return (GlideRequest) super.transform(iVarArr);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> error(@DrawableRes int i2) {
        return (GlideRequest) super.error(i2);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @SafeVarargs
    @CheckResult
    public final GlideRequest<TranscodeType> thumbnail(@Nullable h<TranscodeType>... hVarArr) {
        return (GlideRequest) super.thumbnail((h[]) hVarArr);
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public <Y> GlideRequest<TranscodeType> transform(@NonNull Class<Y> cls, @NonNull i<Y> iVar) {
        return (GlideRequest) super.transform((Class) cls, (i) iVar);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    public GlideRequest<TranscodeType> error(@Nullable h<TranscodeType> hVar) {
        return (GlideRequest) super.error((h) hVar);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> thumbnail(@Nullable List<h<TranscodeType>> list) {
        return (GlideRequest) super.thumbnail((List) list);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    public GlideRequest<TranscodeType> error(Object obj) {
        return (GlideRequest) super.error(obj);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    @Deprecated
    public GlideRequest<TranscodeType> thumbnail(float f2) {
        return (GlideRequest) super.thumbnail(f2);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo48load(@Nullable Object obj) {
        return (GlideRequest) super.mo48load(obj);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo43load(@Nullable Bitmap bitmap) {
        return (GlideRequest) super.mo43load(bitmap);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo44load(@Nullable Drawable drawable) {
        return (GlideRequest) super.mo44load(drawable);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo49load(@Nullable String str) {
        return (GlideRequest) super.mo49load(str);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo45load(@Nullable Uri uri) {
        return (GlideRequest) super.mo45load(uri);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo46load(@Nullable File file) {
        return (GlideRequest) super.mo46load(file);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo47load(@Nullable @DrawableRes @RawRes Integer num) {
        return (GlideRequest) super.mo47load(num);
    }

    @Override // com.bumptech.glide.h
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo50load(@Nullable URL url) {
        return (GlideRequest) super.mo50load(url);
    }

    @Override // com.bumptech.glide.h
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<TranscodeType> mo51load(@Nullable byte[] bArr) {
        return (GlideRequest) super.mo51load(bArr);
    }
}
