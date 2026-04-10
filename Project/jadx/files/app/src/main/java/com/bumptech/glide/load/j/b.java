package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.j.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteArrayLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class b<Data> implements n<byte[], Data> {
    private final InterfaceC0268b<Data> a;

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class a implements o<byte[], ByteBuffer> {

        /* JADX INFO: renamed from: com.bumptech.glide.load.j.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ByteArrayLoader.java */
        class C0267a implements InterfaceC0268b<ByteBuffer> {
            C0267a(a aVar) {
            }

            @Override // com.bumptech.glide.load.j.b.InterfaceC0268b
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // com.bumptech.glide.load.j.b.InterfaceC0268b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<byte[], ByteBuffer> a(@NonNull r rVar) {
            return new b(new C0267a(this));
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.j.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public interface InterfaceC0268b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class d implements o<byte[], InputStream> {

        /* JADX INFO: compiled from: ByteArrayLoader.java */
        class a implements InterfaceC0268b<InputStream> {
            a(d dVar) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.j.b.InterfaceC0268b
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // com.bumptech.glide.load.j.b.InterfaceC0268b
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<byte[], InputStream> a(@NonNull r rVar) {
            return new b(new a(this));
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    public b(InterfaceC0268b<Data> interfaceC0268b) {
        this.a = interfaceC0268b;
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    private static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final byte[] f13663s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final InterfaceC0268b<Data> f13664t;

        c(byte[] bArr, InterfaceC0268b<Data> interfaceC0268b) {
            this.f13663s = bArr;
            this.f13664t = interfaceC0268b;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.a(this.f13664t.a(this.f13663s));
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
        public Class<Data> a() {
            return this.f13664t.a();
        }
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Data> a(@NonNull byte[] bArr, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(bArr), new c(bArr, this.a));
    }
}
