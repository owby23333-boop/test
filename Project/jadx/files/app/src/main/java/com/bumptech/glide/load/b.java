package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class a implements h {
        final /* synthetic */ InputStream a;

        a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.b.h
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getType(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class C0257b implements h {
        final /* synthetic */ ByteBuffer a;

        C0257b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.b.h
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.getType(this.a);
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class c implements h {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ com.bumptech.glide.load.engine.x.b b;

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.x.b bVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = bVar;
        }

        @Override // com.bumptech.glide.load.b.h
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream);
                try {
                    recyclableBufferedInputStream.close();
                } catch (IOException unused) {
                }
                this.a.a();
                return type;
            } catch (Throwable th2) {
                th = th2;
                recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                if (recyclableBufferedInputStream2 != null) {
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.a();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class d implements g {
        final /* synthetic */ ByteBuffer a;
        final /* synthetic */ com.bumptech.glide.load.engine.x.b b;

        d(ByteBuffer byteBuffer, com.bumptech.glide.load.engine.x.b bVar) {
            this.a = byteBuffer;
            this.b = bVar;
        }

        @Override // com.bumptech.glide.load.b.g
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.a(this.a, this.b);
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class e implements g {
        final /* synthetic */ InputStream a;
        final /* synthetic */ com.bumptech.glide.load.engine.x.b b;

        e(InputStream inputStream, com.bumptech.glide.load.engine.x.b bVar) {
            this.a = inputStream;
            this.b = bVar;
        }

        @Override // com.bumptech.glide.load.b.g
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    class f implements g {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ com.bumptech.glide.load.engine.x.b b;

        f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.x.b bVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = bVar;
        }

        @Override // com.bumptech.glide.load.b.g
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int iA = imageHeaderParser.a(recyclableBufferedInputStream, this.b);
                try {
                    recyclableBufferedInputStream.close();
                } catch (IOException unused) {
                }
                this.a.a();
                return iA;
            } catch (Throwable th2) {
                th = th2;
                recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                if (recyclableBufferedInputStream2 != null) {
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.a();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    private interface g {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    private interface h {
        ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    @NonNull
    private static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, h hVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType type = hVar.getType(list.get(i2));
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new a(inputStream));
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return a(list, new d(byteBuffer, bVar));
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return a(list, new C0257b(byteBuffer));
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new e(inputStream, bVar));
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        return a(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    @RequiresApi(21)
    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        return a(list, new f(parcelFileDescriptorRewinder, bVar));
    }

    private static int a(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iA = gVar.a(list.get(i2));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }
}
