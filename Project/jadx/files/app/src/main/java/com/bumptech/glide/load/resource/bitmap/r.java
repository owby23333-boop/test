package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: ImageReader.java */
/* JADX INFO: loaded from: classes2.dex */
interface r {

    /* JADX INFO: compiled from: ImageReader.java */
    public static final class a implements r {
        private final ByteBuffer a;
        private final List<ImageHeaderParser> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.x.b f13794c;

        a(ByteBuffer byteBuffer, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.x.b bVar) {
            this.a = byteBuffer;
            this.b = list;
            this.f13794c = bVar;
        }

        private InputStream d() {
            return com.bumptech.glide.util.a.d(com.bumptech.glide.util.a.b(this.a));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        @Nullable
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(d(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public void a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public int b() throws IOException {
            return com.bumptech.glide.load.b.a(this.b, com.bumptech.glide.util.a.b(this.a), this.f13794c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.b.getType(this.b, com.bumptech.glide.util.a.b(this.a));
        }
    }

    /* JADX INFO: compiled from: ImageReader.java */
    public static final class b implements r {
        private final com.bumptech.glide.load.data.k a;
        private final com.bumptech.glide.load.engine.x.b b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f13795c;

        b(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.x.b bVar) {
            com.bumptech.glide.util.k.a(bVar);
            this.b = bVar;
            com.bumptech.glide.util.k.a(list);
            this.f13795c = list;
            this.a = new com.bumptech.glide.load.data.k(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public int b() throws IOException {
            return com.bumptech.glide.load.b.a(this.f13795c, this.a.a(), this.b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.b.getType(this.f13795c, this.a.a(), this.b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public void a() {
            this.a.c();
        }
    }

    /* JADX INFO: compiled from: ImageReader.java */
    @RequiresApi(21)
    public static final class c implements r {
        private final com.bumptech.glide.load.engine.x.b a;
        private final List<ImageHeaderParser> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f13796c;

        c(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.x.b bVar) {
            com.bumptech.glide.util.k.a(bVar);
            this.a = bVar;
            com.bumptech.glide.util.k.a(list);
            this.b = list;
            this.f13796c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f13796c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public void a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public int b() throws IOException {
            return com.bumptech.glide.load.b.a(this.b, this.f13796c, this.a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.r
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.bumptech.glide.load.b.getType(this.b, this.f13796c, this.a);
        }
    }

    @Nullable
    Bitmap a(BitmapFactory.Options options) throws IOException;

    void a();

    int b() throws IOException;

    ImageHeaderParser.ImageType c() throws IOException;
}
