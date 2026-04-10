package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import me.jessyan.art.http.imageloader.glide.GlideConfiguration;

/* JADX INFO: loaded from: classes2.dex */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final GlideConfiguration a = new GlideConfiguration();

    public GeneratedAppGlideModuleImpl(Context context) {
        Log.isLoggable("Glide", 3);
    }

    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public Set<Class<?>> a() {
        return Collections.emptySet();
    }

    @Override // com.bumptech.glide.m.a
    public void applyOptions(@NonNull Context context, @NonNull d dVar) {
        this.a.applyOptions(context, dVar);
    }

    @Override // com.bumptech.glide.m.a
    public boolean isManifestParsingEnabled() {
        return this.a.isManifestParsingEnabled();
    }

    @Override // com.bumptech.glide.m.d
    public void registerComponents(@NonNull Context context, @NonNull c cVar, @NonNull Registry registry) {
        this.a.registerComponents(context, cVar, registry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.GeneratedAppGlideModule
    @NonNull
    public a b() {
        return new a();
    }
}
