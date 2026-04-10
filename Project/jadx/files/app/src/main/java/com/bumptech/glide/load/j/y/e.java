package com.bumptech.glide.load.j.y;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.g;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: UrlLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements n<URL, InputStream> {
    private final n<g, InputStream> a;

    /* JADX INFO: compiled from: UrlLoader.java */
    public static class a implements o<URL, InputStream> {
        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<URL, InputStream> a(r rVar) {
            return new e(rVar.a(g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    public e(n<g, InputStream> nVar) {
        this.a = nVar;
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull URL url) {
        return true;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<InputStream> a(@NonNull URL url, int i2, int i3, @NonNull f fVar) {
        return this.a.a(new g(url), i2, i3, fVar);
    }
}
