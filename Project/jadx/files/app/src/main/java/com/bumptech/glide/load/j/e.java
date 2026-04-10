package com.bumptech.glide.load.j;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.j.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DataUrlLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<Model, Data> implements n<Model, Data> {
    private final a<Data> a;

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public interface a<Data> {
        Class<Data> a();

        Data a(String str) throws IllegalArgumentException;

        void close(Data data) throws IOException;
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public static final class c<Model> implements o<Model, InputStream> {
        private final a<InputStream> a = new a(this);

        /* JADX INFO: compiled from: DataUrlLoader.java */
        class a implements a<InputStream> {
            a(c cVar) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.j.e.a
            public InputStream a(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }

            @Override // com.bumptech.glide.load.j.e.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.j.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Model, InputStream> a(@NonNull r rVar) {
            return new e(this.a);
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }
    }

    public e(a<Data> aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Data> a(@NonNull Model model, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(model), new b(model.toString(), this.a));
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    private static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final String f13666s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final a<Data> f13667t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private Data f13668u;

        b(String str, a<Data> aVar) {
            this.f13666s = str;
            this.f13667t = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                this.f13668u = this.f13667t.a(this.f13666s);
                aVar.a(this.f13668u);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f13667t.close(this.f13668u);
            } catch (IOException unused) {
            }
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
            return this.f13667t.a();
        }
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }
}
