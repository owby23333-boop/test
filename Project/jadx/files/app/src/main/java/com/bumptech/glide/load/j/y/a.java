package com.bumptech.glide.load.j.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.j;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.g;
import com.bumptech.glide.load.j.m;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.InputStream;

/* JADX INFO: compiled from: HttpGlideUrlLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements n<g, InputStream> {
    public static final com.bumptech.glide.load.e<Integer> b = com.bumptech.glide.load.e.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(com.anythink.expressad.exoplayer.d.f8753c));

    @Nullable
    private final m<g, g> a;

    /* JADX INFO: renamed from: com.bumptech.glide.load.j.y.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HttpGlideUrlLoader.java */
    public static class C0270a implements o<g, InputStream> {
        private final m<g, g> a = new m<>(500);

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<g, InputStream> a(r rVar) {
            return new a(this.a);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    public a(@Nullable m<g, g> mVar) {
        this.a = mVar;
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull g gVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<InputStream> a(@NonNull g gVar, int i2, int i3, @NonNull f fVar) {
        m<g, g> mVar = this.a;
        if (mVar != null) {
            g gVarA = mVar.a(gVar, 0, 0);
            if (gVarA == null) {
                this.a.a(gVar, 0, 0, gVar);
            } else {
                gVar = gVarA;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) fVar.a(b)).intValue()));
    }
}
