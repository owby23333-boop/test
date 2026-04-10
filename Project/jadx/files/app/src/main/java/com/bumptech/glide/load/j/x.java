package com.bumptech.glide.load.j;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.j.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: UrlUriLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class x<Data> implements n<Uri, Data> {
    private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final n<g, Data> a;

    /* JADX INFO: compiled from: UrlUriLoader.java */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, InputStream> a(r rVar) {
            return new x(rVar.a(g.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    public x(n<g, Data> nVar) {
        this.a = nVar;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Data> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return this.a.a(new g(uri.toString()), i2, i3, fVar);
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}
