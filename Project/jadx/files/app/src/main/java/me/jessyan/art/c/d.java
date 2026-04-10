package me.jessyan.art.c;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.g;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.InputStream;
import okhttp3.Call;

/* JADX INFO: compiled from: OkHttpUrlLoader.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements n<g, InputStream> {
    private final Call.Factory a;

    /* JADX INFO: compiled from: OkHttpUrlLoader.java */
    public static class a implements o<g, InputStream> {
        private final Call.Factory a;

        public a(@NonNull Call.Factory factory) {
            this.a = factory;
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<g, InputStream> a(@NonNull r rVar) {
            return new d(this.a);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    public d(@NonNull Call.Factory factory) {
        this.a = factory;
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull g gVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<InputStream> a(@NonNull g gVar, int i2, int i3, @NonNull f fVar) {
        return new n.a<>(gVar, new c(this.a, gVar));
    }
}
