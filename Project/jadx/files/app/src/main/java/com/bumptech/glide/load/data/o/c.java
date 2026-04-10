package com.bumptech.glide.load.data.o;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ThumbFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Uri f13457s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final e f13458t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private InputStream f13459u;

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class a implements d {
        private static final String[] b = {"_data"};
        private final ContentResolver a;

        a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.o.d
        public Cursor query(Uri uri) {
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class b implements d {
        private static final String[] b = {"_data"};
        private final ContentResolver a;

        b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.o.d
        public Cursor query(Uri uri) {
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.f13457s = uri;
        this.f13458t = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream c() throws Throwable {
        InputStream inputStreamB = this.f13458t.b(this.f13457s);
        int iA = inputStreamB != null ? this.f13458t.a(this.f13457s) : -1;
        return iA != -1 ? new g(inputStreamB, iA) : inputStreamB;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.a(context).g().a(), dVar, com.bumptech.glide.c.a(context).c(), context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f13459u;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void a(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            this.f13459u = c();
            aVar.a(this.f13459u);
        } catch (FileNotFoundException e2) {
            Log.isLoggable("MediaStoreThumbFetcher", 3);
            aVar.a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
