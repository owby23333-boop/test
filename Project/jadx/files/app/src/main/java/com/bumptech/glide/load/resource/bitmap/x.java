package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.l;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class x implements com.bumptech.glide.load.g<InputStream, Bitmap> {
    private final l a;
    private final com.bumptech.glide.load.engine.x.b b;

    /* JADX INFO: compiled from: StreamBitmapDecoder.java */
    static class a implements l.b {
        private final RecyclableBufferedInputStream a;
        private final com.bumptech.glide.util.d b;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, com.bumptech.glide.util.d dVar) {
            this.a = recyclableBufferedInputStream;
            this.b = dVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l.b
        public void a() {
            this.a.i();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l.b
        public void a(com.bumptech.glide.load.engine.x.e eVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionI = this.b.i();
            if (iOExceptionI != null) {
                if (bitmap == null) {
                    throw iOExceptionI;
                }
                eVar.a(bitmap);
                throw iOExceptionI;
            }
        }
    }

    public x(l lVar, com.bumptech.glide.load.engine.x.b bVar) {
        this.a = lVar;
        this.b = bVar;
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) {
        return this.a.a(inputStream);
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.s<Bitmap> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z2;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z2 = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.b);
            z2 = true;
        }
        com.bumptech.glide.util.d dVarB = com.bumptech.glide.util.d.b(recyclableBufferedInputStream);
        try {
            return this.a.a(new com.bumptech.glide.util.i(dVarB), i2, i3, fVar, new a(recyclableBufferedInputStream, dVarB));
        } finally {
            dVarB.j();
            if (z2) {
                recyclableBufferedInputStream.j();
            }
        }
    }
}
