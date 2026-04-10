package com.bumptech.glide.load.j;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: MediaStoreFileLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements n<Uri, File> {
    private final Context a;

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    public static final class a implements o<Uri, File> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, File> a(r rVar) {
            return new k(this.a);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    public k(Context context) {
        this.a = context;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<File> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(uri), new b(this.a, uri));
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Uri uri) {
        return com.bumptech.glide.load.data.o.b.b(uri);
    }

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    private static class b implements com.bumptech.glide.load.data.d<File> {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final String[] f13676u = {"_data"};

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Context f13677s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final Uri f13678t;

        b(Context context, Uri uri) {
            this.f13677s = context;
            this.f13678t = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super File> aVar) {
            Cursor cursorQuery = this.f13677s.getContentResolver().query(this.f13678t, f13676u, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.a(new File(string));
                return;
            }
            aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f13678t));
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }
    }
}
