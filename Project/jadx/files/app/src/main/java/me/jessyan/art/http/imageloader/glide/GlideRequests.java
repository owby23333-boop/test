package me.jessyan.art.http.imageloader.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.i;
import com.bumptech.glide.l.l;
import com.bumptech.glide.l.q;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.h;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class GlideRequests extends i {
    public GlideRequests(@NonNull com.bumptech.glide.c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
        super(cVar, lVar, qVar, context);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    public /* bridge */ /* synthetic */ i addDefaultRequestListener(g gVar) {
        return addDefaultRequestListener((g<Object>) gVar);
    }

    @Override // com.bumptech.glide.i
    protected void setRequestOptions(@NonNull h hVar) {
        if (hVar instanceof GlideOptions) {
            super.setRequestOptions(hVar);
        } else {
            super.setRequestOptions(new GlideOptions().apply((com.bumptech.glide.request.a<?>) hVar));
        }
    }

    @Override // com.bumptech.glide.i
    @NonNull
    public GlideRequests addDefaultRequestListener(g<Object> gVar) {
        return (GlideRequests) super.addDefaultRequestListener(gVar);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    public synchronized GlideRequests applyDefaultRequestOptions(@NonNull h hVar) {
        return (GlideRequests) super.applyDefaultRequestOptions(hVar);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    public <ResourceType> GlideRequest<ResourceType> as(@NonNull Class<ResourceType> cls) {
        return new GlideRequest<>(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    public GlideRequest<Bitmap> asBitmap() {
        return (GlideRequest) super.asBitmap();
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    public GlideRequest<Drawable> asDrawable() {
        return (GlideRequest) super.asDrawable();
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    public GlideRequest<File> asFile() {
        return (GlideRequest) super.asFile();
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    public GlideRequest<com.bumptech.glide.load.k.g.c> asGif() {
        return (GlideRequest) super.asGif();
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    public GlideRequest<File> download(@Nullable Object obj) {
        return (GlideRequest) super.download(obj);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    public GlideRequest<File> downloadOnly() {
        return (GlideRequest) super.downloadOnly();
    }

    @Override // com.bumptech.glide.i
    @NonNull
    public synchronized GlideRequests setDefaultRequestOptions(@NonNull h hVar) {
        return (GlideRequests) super.setDefaultRequestOptions(hVar);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo52load(@Nullable Bitmap bitmap) {
        return (GlideRequest) super.mo52load(bitmap);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo53load(@Nullable Drawable drawable) {
        return (GlideRequest) super.mo53load(drawable);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo58load(@Nullable String str) {
        return (GlideRequest) super.mo58load(str);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo54load(@Nullable Uri uri) {
        return (GlideRequest) super.mo54load(uri);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo55load(@Nullable File file) {
        return (GlideRequest) super.mo55load(file);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo56load(@Nullable @DrawableRes @RawRes Integer num) {
        return (GlideRequest) super.mo56load(num);
    }

    @Override // com.bumptech.glide.i
    @CheckResult
    @Deprecated
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo59load(@Nullable URL url) {
        return (GlideRequest) super.mo59load(url);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo60load(@Nullable byte[] bArr) {
        return (GlideRequest) super.mo60load(bArr);
    }

    @Override // com.bumptech.glide.i
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: load */
    public GlideRequest<Drawable> mo57load(@Nullable Object obj) {
        return (GlideRequest) super.mo57load(obj);
    }
}
