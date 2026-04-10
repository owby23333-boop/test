package com.bumptech.glide.load.j;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.NonNull;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.bumptech.glide.load.j.n;
import java.io.InputStream;

/* JADX INFO: compiled from: AssetUriLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f13662c = 22;
    private final AssetManager a;
    private final InterfaceC0266a<Data> b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.j.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssetUriLoader.java */
    public interface InterfaceC0266a<Data> {
        com.bumptech.glide.load.data.d<Data> a(AssetManager assetManager, String str);
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class b implements o<Uri, AssetFileDescriptor>, InterfaceC0266a<AssetFileDescriptor> {
        private final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new a(this.a, this);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.a.InterfaceC0266a
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class c implements o<Uri, InputStream>, InterfaceC0266a<InputStream> {
        private final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.a, this);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.a.InterfaceC0266a
        public com.bumptech.glide.load.data.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }
    }

    public a(AssetManager assetManager, InterfaceC0266a<Data> interfaceC0266a) {
        this.a = assetManager;
        this.b = interfaceC0266a;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(uri), this.b.a(this.a, uri.toString().substring(f13662c)));
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Uri uri) {
        return BmobDbOpenHelper.FILE.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
