package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamRewinder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements e<InputStream> {
    private final RecyclableBufferedInputStream a;

    /* JADX INFO: compiled from: InputStreamRewinder.java */
    public static final class a implements e.a<InputStream> {
        private final com.bumptech.glide.load.engine.x.b a;

        public a(com.bumptech.glide.load.engine.x.b bVar) {
            this.a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.a);
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, com.bumptech.glide.load.engine.x.b bVar) {
        this.a = new RecyclableBufferedInputStream(inputStream, bVar);
        this.a.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.a.j();
    }

    public void c() {
        this.a.i();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.e
    @NonNull
    public InputStream a() throws IOException {
        this.a.reset();
        return this.a;
    }
}
