package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.l.c;
import com.bumptech.glide.l.l;
import com.bumptech.glide.l.m;
import com.bumptech.glide.l.q;
import com.bumptech.glide.l.r;
import com.bumptech.glide.l.u;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class i implements ComponentCallbacks2, m, g<h<Drawable>> {
    private static final com.bumptech.glide.request.h DECODE_TYPE_BITMAP = com.bumptech.glide.request.h.decodeTypeOf(Bitmap.class).lock();
    private static final com.bumptech.glide.request.h DECODE_TYPE_GIF = com.bumptech.glide.request.h.decodeTypeOf(com.bumptech.glide.load.k.g.c.class).lock();
    private static final com.bumptech.glide.request.h DOWNLOAD_ONLY_OPTIONS = com.bumptech.glide.request.h.diskCacheStrategyOf(com.bumptech.glide.load.engine.h.f13534c).priority(Priority.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private final com.bumptech.glide.l.c connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<com.bumptech.glide.request.g<Object>> defaultRequestListeners;
    protected final com.bumptech.glide.c glide;
    final l lifecycle;
    private boolean pauseAllRequestsOnTrimMemoryModerate;

    @GuardedBy("this")
    private com.bumptech.glide.request.h requestOptions;

    @GuardedBy("this")
    private final r requestTracker;

    @GuardedBy("this")
    private final u targetTracker;

    @GuardedBy("this")
    private final q treeNode;

    /* JADX INFO: compiled from: RequestManager.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = i.this;
            iVar.lifecycle.b(iVar);
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    private static class b extends com.bumptech.glide.request.k.d<View, Object> {
        b(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.k.j
        public void a(@NonNull Object obj, @Nullable com.bumptech.glide.request.l.d<? super Object> dVar) {
        }

        @Override // com.bumptech.glide.request.k.j
        public void c(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.k.d
        protected void d(@Nullable Drawable drawable) {
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    private class c implements c.a {

        @GuardedBy("RequestManager.this")
        private final r a;

        c(@NonNull r rVar) {
            this.a = rVar;
        }

        @Override // com.bumptech.glide.l.c.a
        public void a(boolean z2) {
            if (z2) {
                synchronized (i.this) {
                    this.a.e();
                }
            }
        }
    }

    public i(@NonNull com.bumptech.glide.c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
        this(cVar, lVar, qVar, new r(), cVar.e(), context);
    }

    private void untrackOrDelegate(@NonNull com.bumptech.glide.request.k.j<?> jVar) {
        boolean zUntrack = untrack(jVar);
        com.bumptech.glide.request.e eVarA = jVar.a();
        if (zUntrack || this.glide.a(jVar) || eVarA == null) {
            return;
        }
        jVar.a((com.bumptech.glide.request.e) null);
        eVarA.clear();
    }

    private synchronized void updateRequestOptions(@NonNull com.bumptech.glide.request.h hVar) {
        this.requestOptions = this.requestOptions.apply(hVar);
    }

    public i addDefaultRequestListener(com.bumptech.glide.request.g<Object> gVar) {
        this.defaultRequestListeners.add(gVar);
        return this;
    }

    @NonNull
    public synchronized i applyDefaultRequestOptions(@NonNull com.bumptech.glide.request.h hVar) {
        updateRequestOptions(hVar);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> h<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new h<>(this.glide, this, cls, this.context);
    }

    @NonNull
    @CheckResult
    public h<Bitmap> asBitmap() {
        return as(Bitmap.class).apply((com.bumptech.glide.request.a<?>) DECODE_TYPE_BITMAP);
    }

    @NonNull
    @CheckResult
    public h<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public h<File> asFile() {
        return as(File.class).apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public h<com.bumptech.glide.load.k.g.c> asGif() {
        return as(com.bumptech.glide.load.k.g.c.class).apply((com.bumptech.glide.request.a<?>) DECODE_TYPE_GIF);
    }

    public void clear(@NonNull View view) {
        clear(new b(view));
    }

    @NonNull
    @CheckResult
    public h<File> download(@Nullable Object obj) {
        return downloadOnly().mo48load(obj);
    }

    @NonNull
    @CheckResult
    public h<File> downloadOnly() {
        return as(File.class).apply((com.bumptech.glide.request.a<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    List<com.bumptech.glide.request.g<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    synchronized com.bumptech.glide.request.h getDefaultRequestOptions() {
        return this.requestOptions;
    }

    @NonNull
    <T> j<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.f().a(cls);
    }

    public synchronized boolean isPaused() {
        return this.requestTracker.b();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.l.m
    public synchronized void onDestroy() {
        this.targetTracker.onDestroy();
        Iterator<com.bumptech.glide.request.k.j<?>> it = this.targetTracker.c().iterator();
        while (it.hasNext()) {
            clear(it.next());
        }
        this.targetTracker.b();
        this.requestTracker.a();
        this.lifecycle.a(this);
        this.lifecycle.a(this.connectivityMonitor);
        com.bumptech.glide.util.l.b(this.addSelfToLifecycle);
        this.glide.b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.l.m
    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    @Override // com.bumptech.glide.l.m
    public synchronized void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.requestTracker.c();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        Iterator<i> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.requestTracker.d();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        Iterator<i> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.requestTracker.f();
    }

    public synchronized void resumeRequestsRecursive() {
        com.bumptech.glide.util.l.b();
        resumeRequests();
        Iterator<i> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    @NonNull
    public synchronized i setDefaultRequestOptions(@NonNull com.bumptech.glide.request.h hVar) {
        setRequestOptions(hVar);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z2) {
        this.pauseAllRequestsOnTrimMemoryModerate = z2;
    }

    protected synchronized void setRequestOptions(@NonNull com.bumptech.glide.request.h hVar) {
        this.requestOptions = hVar.mo42clone().autoClone();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    synchronized void track(@NonNull com.bumptech.glide.request.k.j<?> jVar, @NonNull com.bumptech.glide.request.e eVar) {
        this.targetTracker.a(jVar);
        this.requestTracker.b(eVar);
    }

    synchronized boolean untrack(@NonNull com.bumptech.glide.request.k.j<?> jVar) {
        com.bumptech.glide.request.e eVarA = jVar.a();
        if (eVarA == null) {
            return true;
        }
        if (!this.requestTracker.a(eVarA)) {
            return false;
        }
        this.targetTracker.b(jVar);
        jVar.a((com.bumptech.glide.request.e) null);
        return true;
    }

    public void clear(@Nullable com.bumptech.glide.request.k.j<?> jVar) {
        if (jVar == null) {
            return;
        }
        untrackOrDelegate(jVar);
    }

    i(com.bumptech.glide.c cVar, l lVar, q qVar, r rVar, com.bumptech.glide.l.d dVar, Context context) {
        this.targetTracker = new u();
        this.addSelfToLifecycle = new a();
        this.glide = cVar;
        this.lifecycle = lVar;
        this.treeNode = qVar;
        this.requestTracker = rVar;
        this.context = context;
        this.connectivityMonitor = dVar.a(context.getApplicationContext(), new c(rVar));
        if (com.bumptech.glide.util.l.d()) {
            com.bumptech.glide.util.l.a(this.addSelfToLifecycle);
        } else {
            lVar.b(this);
        }
        lVar.b(this.connectivityMonitor);
        this.defaultRequestListeners = new CopyOnWriteArrayList<>(cVar.f().b());
        setRequestOptions(cVar.f().c());
        cVar.a(this);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo52load(@Nullable Bitmap bitmap) {
        return asDrawable().mo43load(bitmap);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo53load(@Nullable Drawable drawable) {
        return asDrawable().mo44load(drawable);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo58load(@Nullable String str) {
        return asDrawable().mo49load(str);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo54load(@Nullable Uri uri) {
        return asDrawable().mo45load(uri);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo55load(@Nullable File file) {
        return asDrawable().mo46load(file);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo56load(@Nullable @DrawableRes @RawRes Integer num) {
        return asDrawable().mo47load(num);
    }

    @Override // 
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo59load(@Nullable URL url) {
        return asDrawable().mo50load(url);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo60load(@Nullable byte[] bArr) {
        return asDrawable().mo51load(bArr);
    }

    @Override // 
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public h<Drawable> mo57load(@Nullable Object obj) {
        return asDrawable().mo48load(obj);
    }
}
