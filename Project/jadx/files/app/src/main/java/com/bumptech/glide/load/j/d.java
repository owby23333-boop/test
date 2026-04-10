package com.bumptech.glide.load.j;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferFileLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements n<File, ByteBuffer> {

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    public static class b implements o<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<File, ByteBuffer> a(@NonNull r rVar) {
            return new d();
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<ByteBuffer> a(@NonNull File file, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(file), new a(file));
    }

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    private static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final File f13665s;

        a(File file) {
            this.f13665s = file;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(com.bumptech.glide.util.a.a(this.f13665s));
            } catch (IOException e2) {
                Log.isLoggable("ByteBufferFileLoader", 3);
                aVar.a((Exception) e2);
            }
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
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}
