package com.bumptech.glide.load.j;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.bumptech.glide.load.j.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: UriLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class w<Data> implements n<Uri, Data> {
    private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList(BmobDbOpenHelper.FILE, "android.resource", "content")));
    private final c<Data> a;

    /* JADX INFO: compiled from: UriLoader.java */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {
        private final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.j.o
        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.w.c
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.a, uri);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {
        private final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.j.w.c
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.i(this.a, uri);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri uri);
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class d implements o<Uri, InputStream>, c<InputStream> {
        private final ContentResolver a;

        public d(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.j.w.c
        public com.bumptech.glide.load.data.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.data.n(this.a, uri);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.a = cVar;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(uri), this.a.a(uri));
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}
