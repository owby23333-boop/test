package com.bumptech.glide.load.j;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.j.n;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class f<Data> implements n<File, Data> {
    private final d<Data> a;

    /* JADX INFO: compiled from: FileLoader.java */
    public static class a<Data> implements o<File, Data> {
        private final d<Data> a;

        public a(d<Data> dVar) {
            this.a = dVar;
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public final n<File, Data> a(@NonNull r rVar) {
            return new f(this.a);
        }

        @Override // com.bumptech.glide.load.j.o
        public final void a() {
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class b extends a<ParcelFileDescriptor> {

        /* JADX INFO: compiled from: FileLoader.java */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.j.f.d
            public ParcelFileDescriptor a(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            }

            @Override // com.bumptech.glide.load.j.f.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.bumptech.glide.load.j.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }
        }

        public b() {
            super(new a());
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void close(Data data) throws IOException;
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class e extends a<InputStream> {

        /* JADX INFO: compiled from: FileLoader.java */
        class a implements d<InputStream> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.load.j.f.d
            public InputStream a(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            @Override // com.bumptech.glide.load.j.f.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.bumptech.glide.load.j.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.a = dVar;
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull File file) {
        return true;
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Data> a(@NonNull File file, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.d(file), new c(file, this.a));
    }

    /* JADX INFO: compiled from: FileLoader.java */
    private static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final File f13669s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final d<Data> f13670t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private Data f13671u;

        c(File file, d<Data> dVar) {
            this.f13669s = file;
            this.f13670t = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                this.f13671u = this.f13670t.a(this.f13669s);
                aVar.a(this.f13671u);
            } catch (FileNotFoundException e2) {
                Log.isLoggable("FileLoader", 3);
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Data data = this.f13671u;
            if (data != null) {
                try {
                    this.f13670t.close(data);
                } catch (IOException unused) {
                }
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
            return this.f13670t.a();
        }
    }
}
