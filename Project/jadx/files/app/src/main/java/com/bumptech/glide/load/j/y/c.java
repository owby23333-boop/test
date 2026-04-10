package com.bumptech.glide.load.j.y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import java.io.InputStream;

/* JADX INFO: compiled from: MediaStoreVideoThumbLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements n<Uri, InputStream> {
    private final Context a;

    /* JADX INFO: compiled from: MediaStoreVideoThumbLoader.java */
    public static class a implements o<Uri, InputStream> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new c(this.a);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    public c(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.j.n
    @Nullable
    public n.a<InputStream> a(@NonNull Uri uri, int i2, int i3, @NonNull f fVar) {
        if (com.bumptech.glide.load.data.o.b.a(i2, i3) && a(fVar)) {
            return new n.a<>(new com.bumptech.glide.o.d(uri), com.bumptech.glide.load.data.o.c.b(this.a, uri));
        }
        return null;
    }

    private boolean a(f fVar) {
        Long l2 = (Long) fVar.a(VideoDecoder.f13765d);
        return l2 != null && l2.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Uri uri) {
        return com.bumptech.glide.load.data.o.b.c(uri);
    }
}
