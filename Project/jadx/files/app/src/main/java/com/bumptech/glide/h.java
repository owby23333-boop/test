package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import com.bumptech.glide.util.k;
import com.bumptech.glide.util.l;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class h<TranscodeType> extends com.bumptech.glide.request.a<h<TranscodeType>> implements Cloneable, g<h<TranscodeType>> {
    protected static final com.bumptech.glide.request.h DOWNLOAD_ONLY_OPTIONS = new com.bumptech.glide.request.h().diskCacheStrategy(com.bumptech.glide.load.engine.h.f13534c).priority(Priority.LOW).skipMemoryCache(true);
    private final Context context;

    @Nullable
    private h<TranscodeType> errorBuilder;
    private final c glide;
    private final e glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;

    @Nullable
    private Object model;

    @Nullable
    private List<com.bumptech.glide.request.g<TranscodeType>> requestListeners;
    private final i requestManager;

    @Nullable
    private Float thumbSizeMultiplier;

    @Nullable
    private h<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;

    @NonNull
    private j<?, ? super TranscodeType> transitionOptions;

    /* JADX INFO: compiled from: RequestBuilder.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[Priority.values().length];

        static {
            try {
                b[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = new int[ImageView.ScaleType.values().length];
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    protected h(@NonNull c cVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = cVar;
        this.requestManager = iVar;
        this.transcodeClass = cls;
        this.context = context;
        this.transitionOptions = iVar.getDefaultTransitionOptions(cls);
        this.glideContext = cVar.f();
        initRequestListeners(iVar.getDefaultRequestListeners());
        apply((com.bumptech.glide.request.a<?>) iVar.getDefaultRequestOptions());
    }

    private com.bumptech.glide.request.e buildRequest(com.bumptech.glide.request.k.j<TranscodeType> jVar, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return buildRequestRecursive(new Object(), jVar, gVar, null, this.transitionOptions, aVar.getPriority(), aVar.getOverrideWidth(), aVar.getOverrideHeight(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.request.e buildRequestRecursive(Object obj, com.bumptech.glide.request.k.j<TranscodeType> jVar, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, @Nullable RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar2, Priority priority, int i2, int i3, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        RequestCoordinator requestCoordinator2;
        RequestCoordinator bVar;
        if (this.errorBuilder != null) {
            bVar = new com.bumptech.glide.request.b(obj, requestCoordinator);
            requestCoordinator2 = bVar;
        } else {
            requestCoordinator2 = null;
            bVar = requestCoordinator;
        }
        com.bumptech.glide.request.e eVarBuildThumbnailRequestRecursive = buildThumbnailRequestRecursive(obj, jVar, gVar, bVar, jVar2, priority, i2, i3, aVar, executor);
        if (requestCoordinator2 == null) {
            return eVarBuildThumbnailRequestRecursive;
        }
        int overrideWidth = this.errorBuilder.getOverrideWidth();
        int overrideHeight = this.errorBuilder.getOverrideHeight();
        if (l.b(i2, i3) && !this.errorBuilder.isValidOverride()) {
            overrideWidth = aVar.getOverrideWidth();
            overrideHeight = aVar.getOverrideHeight();
        }
        h<TranscodeType> hVar = this.errorBuilder;
        com.bumptech.glide.request.b bVar2 = requestCoordinator2;
        bVar2.a(eVarBuildThumbnailRequestRecursive, hVar.buildRequestRecursive(obj, jVar, gVar, bVar2, hVar.transitionOptions, hVar.getPriority(), overrideWidth, overrideHeight, this.errorBuilder, executor));
        return bVar2;
    }

    private com.bumptech.glide.request.e buildThumbnailRequestRecursive(Object obj, com.bumptech.glide.request.k.j<TranscodeType> jVar, com.bumptech.glide.request.g<TranscodeType> gVar, @Nullable RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar2, Priority priority, int i2, int i3, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        h<TranscodeType> hVar = this.thumbnailBuilder;
        if (hVar == null) {
            if (this.thumbSizeMultiplier == null) {
                return obtainRequest(obj, jVar, gVar, aVar, requestCoordinator, jVar2, priority, i2, i3, executor);
            }
            com.bumptech.glide.request.j jVar3 = new com.bumptech.glide.request.j(obj, requestCoordinator);
            jVar3.a(obtainRequest(obj, jVar, gVar, aVar, jVar3, jVar2, priority, i2, i3, executor), obtainRequest(obj, jVar, gVar, aVar.mo42clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), jVar3, jVar2, getThumbnailPriority(priority), i2, i3, executor));
            return jVar3;
        }
        if (this.isThumbnailBuilt) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        j<?, ? super TranscodeType> jVar4 = hVar.isDefaultTransitionOptionsSet ? jVar2 : hVar.transitionOptions;
        Priority priority2 = this.thumbnailBuilder.isPrioritySet() ? this.thumbnailBuilder.getPriority() : getThumbnailPriority(priority);
        int overrideWidth = this.thumbnailBuilder.getOverrideWidth();
        int overrideHeight = this.thumbnailBuilder.getOverrideHeight();
        if (l.b(i2, i3) && !this.thumbnailBuilder.isValidOverride()) {
            overrideWidth = aVar.getOverrideWidth();
            overrideHeight = aVar.getOverrideHeight();
        }
        com.bumptech.glide.request.j jVar5 = new com.bumptech.glide.request.j(obj, requestCoordinator);
        com.bumptech.glide.request.e eVarObtainRequest = obtainRequest(obj, jVar, gVar, aVar, jVar5, jVar2, priority, i2, i3, executor);
        this.isThumbnailBuilt = true;
        h<TranscodeType> hVar2 = this.thumbnailBuilder;
        com.bumptech.glide.request.e eVarBuildRequestRecursive = hVar2.buildRequestRecursive(obj, jVar, gVar, jVar5, jVar4, priority2, overrideWidth, overrideHeight, hVar2, executor);
        this.isThumbnailBuilt = false;
        jVar5.a(eVarObtainRequest, eVarBuildRequestRecursive);
        return jVar5;
    }

    private h<TranscodeType> cloneWithNullErrorAndThumbnail() {
        return mo42clone().error((h) null).thumbnail((h) null);
    }

    @NonNull
    private Priority getThumbnailPriority(@NonNull Priority priority) {
        int i2 = a.b[priority.ordinal()];
        if (i2 == 1) {
            return Priority.NORMAL;
        }
        if (i2 == 2) {
            return Priority.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + getPriority());
    }

    @SuppressLint({"CheckResult"})
    private void initRequestListeners(List<com.bumptech.glide.request.g<Object>> list) {
        Iterator<com.bumptech.glide.request.g<Object>> it = list.iterator();
        while (it.hasNext()) {
            addListener((com.bumptech.glide.request.g) it.next());
        }
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.e eVar) {
        return !aVar.isMemoryCacheable() && eVar.isComplete();
    }

    @NonNull
    private h<TranscodeType> loadGeneric(@Nullable Object obj) {
        if (isAutoCloneEnabled()) {
            return mo42clone().loadGeneric(obj);
        }
        this.model = obj;
        this.isModelSet = true;
        return selfOrThrowIfLocked();
    }

    private com.bumptech.glide.request.e obtainRequest(Object obj, com.bumptech.glide.request.k.j<TranscodeType> jVar, com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar2, Priority priority, int i2, int i3, Executor executor) {
        Context context = this.context;
        e eVar = this.glideContext;
        return SingleRequest.a(context, eVar, obj, this.model, this.transcodeClass, aVar, i2, i3, priority, jVar, gVar, this.requestListeners, requestCoordinator, eVar.d(), jVar2.a(), executor);
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> addListener(@Nullable com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (isAutoCloneEnabled()) {
            return mo42clone().addListener(gVar);
        }
        if (gVar != null) {
            if (this.requestListeners == null) {
                this.requestListeners = new ArrayList();
            }
            this.requestListeners.add(gVar);
        }
        return selfOrThrowIfLocked();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.a apply(@NonNull com.bumptech.glide.request.a aVar) {
        return apply((com.bumptech.glide.request.a<?>) aVar);
    }

    @CheckResult
    @Deprecated
    public <Y extends com.bumptech.glide.request.k.j<File>> Y downloadOnly(@NonNull Y y2) {
        return (Y) getDownloadOnlyRequest().into(y2);
    }

    @NonNull
    public h<TranscodeType> error(@Nullable h<TranscodeType> hVar) {
        if (isAutoCloneEnabled()) {
            return mo42clone().error((h) hVar);
        }
        this.errorBuilder = hVar;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    protected h<File> getDownloadOnlyRequest() {
        return new h(File.class, this).apply((com.bumptech.glide.request.a<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    @NonNull
    public <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y into(@NonNull Y y2) {
        return (Y) into(y2, null, com.bumptech.glide.util.e.b());
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> listener(@Nullable com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (isAutoCloneEnabled()) {
            return mo42clone().listener(gVar);
        }
        this.requestListeners = null;
        return addListener(gVar);
    }

    @NonNull
    public com.bumptech.glide.request.k.j<TranscodeType> preload(int i2, int i3) {
        return into(com.bumptech.glide.request.k.h.a(this.requestManager, i2, i3));
    }

    @NonNull
    public com.bumptech.glide.request.d<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> thumbnail(@Nullable h<TranscodeType> hVar) {
        if (isAutoCloneEnabled()) {
            return mo42clone().thumbnail(hVar);
        }
        this.thumbnailBuilder = hVar;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> transition(@NonNull j<?, ? super TranscodeType> jVar) {
        if (isAutoCloneEnabled()) {
            return mo42clone().transition(jVar);
        }
        k.a(jVar);
        this.transitionOptions = jVar;
        this.isDefaultTransitionOptionsSet = false;
        return selfOrThrowIfLocked();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    public h<TranscodeType> apply(@NonNull com.bumptech.glide.request.a<?> aVar) {
        k.a(aVar);
        return (h) super.apply(aVar);
    }

    @CheckResult
    @Deprecated
    public com.bumptech.glide.request.d<File> downloadOnly(int i2, int i3) {
        return getDownloadOnlyRequest().submit(i2, i3);
    }

    @NonNull
    <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y into(@NonNull Y y2, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, Executor executor) {
        return (Y) into(y2, gVar, this, executor);
    }

    @NonNull
    public com.bumptech.glide.request.d<TranscodeType> submit(int i2, int i3) {
        com.bumptech.glide.request.f fVar = new com.bumptech.glide.request.f(i2, i3);
        return (com.bumptech.glide.request.d) into(fVar, fVar, com.bumptech.glide.util.e.a());
    }

    private <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y into(@NonNull Y y2, @Nullable com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        k.a(y2);
        if (this.isModelSet) {
            com.bumptech.glide.request.e eVarBuildRequest = buildRequest(y2, gVar, aVar, executor);
            com.bumptech.glide.request.e eVarA = y2.a();
            if (eVarBuildRequest.a(eVarA) && !isSkipMemoryCacheWithCompletePreviousRequest(aVar, eVarA)) {
                k.a(eVarA);
                if (!eVarA.isRunning()) {
                    eVarA.c();
                }
                return y2;
            }
            this.requestManager.clear((com.bumptech.glide.request.k.j<?>) y2);
            y2.a(eVarBuildRequest);
            this.requestManager.track(y2, eVarBuildRequest);
            return y2;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @Override // com.bumptech.glide.request.a
    @CheckResult
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo42clone() {
        h<TranscodeType> hVar = (h) super.mo42clone();
        hVar.transitionOptions = hVar.transitionOptions.m61clone();
        List<com.bumptech.glide.request.g<TranscodeType>> list = hVar.requestListeners;
        if (list != null) {
            hVar.requestListeners = new ArrayList(list);
        }
        h<TranscodeType> hVar2 = hVar.thumbnailBuilder;
        if (hVar2 != null) {
            hVar.thumbnailBuilder = hVar2.mo42clone();
        }
        h<TranscodeType> hVar3 = hVar.errorBuilder;
        if (hVar3 != null) {
            hVar.errorBuilder = hVar3.mo42clone();
        }
        return hVar;
    }

    @NonNull
    public com.bumptech.glide.request.k.j<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> error(Object obj) {
        if (obj == null) {
            return error((h) null);
        }
        return error((h) cloneWithNullErrorAndThumbnail().mo48load(obj));
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> thumbnail(@Nullable h<TranscodeType>... hVarArr) {
        if (hVarArr != null && hVarArr.length != 0) {
            return thumbnail(Arrays.asList(hVarArr));
        }
        return thumbnail((h) null);
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> thumbnail(@Nullable List<h<TranscodeType>> list) {
        h<TranscodeType> hVarThumbnail = null;
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                h<TranscodeType> hVar = list.get(size);
                if (hVar != null) {
                    hVarThumbnail = hVarThumbnail == null ? hVar : hVar.thumbnail(hVarThumbnail);
                }
            }
            return thumbnail(hVarThumbnail);
        }
        return thumbnail((h) null);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo48load(@Nullable Object obj) {
        return loadGeneric(obj);
    }

    @SuppressLint({"CheckResult"})
    protected h(Class<TranscodeType> cls, h<?> hVar) {
        this(hVar.glide, hVar.requestManager, cls, hVar.context);
        this.model = hVar.model;
        this.isModelSet = hVar.isModelSet;
        apply((com.bumptech.glide.request.a<?>) hVar);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo43load(@Nullable Bitmap bitmap) {
        return loadGeneric(bitmap).apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.diskCacheStrategyOf(com.bumptech.glide.load.engine.h.b));
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo44load(@Nullable Drawable drawable) {
        return loadGeneric(drawable).apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.diskCacheStrategyOf(com.bumptech.glide.load.engine.h.b));
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo49load(@Nullable String str) {
        return loadGeneric(str);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo45load(@Nullable Uri uri) {
        return loadGeneric(uri);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public h<TranscodeType> thumbnail(float f2) {
        if (isAutoCloneEnabled()) {
            return mo42clone().thumbnail(f2);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.thumbSizeMultiplier = Float.valueOf(f2);
            return selfOrThrowIfLocked();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    public com.bumptech.glide.request.k.k<ImageView, TranscodeType> into(@NonNull ImageView imageView) {
        com.bumptech.glide.request.a aVarOptionalCenterCrop;
        l.b();
        k.a(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarOptionalCenterCrop = mo42clone().optionalCenterCrop();
                    break;
                case 2:
                    aVarOptionalCenterCrop = mo42clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarOptionalCenterCrop = mo42clone().optionalFitCenter();
                    break;
                case 6:
                    aVarOptionalCenterCrop = mo42clone().optionalCenterInside();
                    break;
                default:
                    aVarOptionalCenterCrop = this;
                    break;
            }
        } else {
            aVarOptionalCenterCrop = this;
        }
        return (com.bumptech.glide.request.k.k) into(this.glideContext.a(imageView, this.transcodeClass), null, aVarOptionalCenterCrop, com.bumptech.glide.util.e.b());
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo46load(@Nullable File file) {
        return loadGeneric(file);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo47load(@Nullable @DrawableRes @RawRes Integer num) {
        return loadGeneric(num).apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.signatureOf(com.bumptech.glide.o.a.a(this.context)));
    }

    @Override // 
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo50load(@Nullable URL url) {
        return loadGeneric(url);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> mo51load(@Nullable byte[] bArr) {
        h<TranscodeType> hVarLoadGeneric = loadGeneric(bArr);
        if (!hVarLoadGeneric.isDiskCacheStrategySet()) {
            hVarLoadGeneric = hVarLoadGeneric.apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.diskCacheStrategyOf(com.bumptech.glide.load.engine.h.b));
        }
        return !hVarLoadGeneric.isSkipMemoryCacheSet() ? hVarLoadGeneric.apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.skipMemoryCacheOf(true)) : hVarLoadGeneric;
    }

    @Deprecated
    public com.bumptech.glide.request.d<TranscodeType> into(int i2, int i3) {
        return submit(i2, i3);
    }
}
