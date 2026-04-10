package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* JADX INFO: compiled from: AssetPathFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f13434s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AssetManager f13435t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private T f13436u;

    public b(AssetManager assetManager, String str) {
        this.f13435t = assetManager;
        this.f13434s = str;
    }

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            this.f13436u = a(this.f13435t, this.f13434s);
            aVar.a(this.f13436u);
        } catch (IOException e2) {
            Log.isLoggable("AssetPathFetcher", 3);
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t2) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t2 = this.f13436u;
        if (t2 == null) {
            return;
        }
        try {
            a(t2);
        } catch (IOException unused) {
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
