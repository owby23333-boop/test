package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: LocalUriFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l<T> implements d<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Uri f13453s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ContentResolver f13454t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private T f13455u;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f13454t = contentResolver;
        this.f13453s = uri;
    }

    protected abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.d
    public final void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            this.f13455u = a(this.f13453s, this.f13454t);
            aVar.a(this.f13455u);
        } catch (FileNotFoundException e2) {
            Log.isLoggable("LocalUriFetcher", 3);
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t2) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t2 = this.f13455u;
        if (t2 != null) {
            try {
                a(t2);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
