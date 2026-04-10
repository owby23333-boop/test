package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class VideoDecoder<T> implements com.bumptech.glide.load.g<T, Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Long> f13765d = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Integer> f13766e = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final e f13767f = new e();
    private final f<T> a;
    private final com.bumptech.glide.load.engine.x.e b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f13768c;

    private static final class VideoDecoderException extends RuntimeException {
        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    class a implements e.b<Long> {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Long l2, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l2.longValue()).array());
            }
        }
    }

    class b implements e.b<Integer> {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    private static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @RequiresApi(23)
    static final class d implements f<ByteBuffer> {

        class a extends MediaDataSource {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ ByteBuffer f13769s;

            a(d dVar, ByteBuffer byteBuffer) {
                this.f13769s = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f13769s.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j2, byte[] bArr, int i2, int i3) {
                if (j2 >= this.f13769s.limit()) {
                    return -1;
                }
                this.f13769s.position((int) j2);
                int iMin = Math.min(i3, this.f13769s.remaining());
                this.f13769s.get(bArr, i2, iMin);
                return iMin;
            }
        }

        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(this, byteBuffer));
        }
    }

    @VisibleForTesting
    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    @VisibleForTesting
    interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t2);
    }

    static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    VideoDecoder(com.bumptech.glide.load.engine.x.e eVar, f<T> fVar) {
        this(eVar, fVar, f13767f);
    }

    public static com.bumptech.glide.load.g<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.load.engine.x.e eVar) {
        return new VideoDecoder(eVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static com.bumptech.glide.load.g<ByteBuffer, Bitmap> b(com.bumptech.glide.load.engine.x.e eVar) {
        return new VideoDecoder(eVar, new d());
    }

    public static com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.x.e eVar) {
        return new VideoDecoder(eVar, new g());
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull T t2, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    @VisibleForTesting
    VideoDecoder(com.bumptech.glide.load.engine.x.e eVar, f<T> fVar, e eVar2) {
        this.b = eVar;
        this.a = fVar;
        this.f13768c = eVar2;
    }

    @Nullable
    @TargetApi(27)
    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        try {
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i7 == 90 || i7 == 270) {
                i6 = i5;
                i5 = i6;
            }
            float fB = downsampleStrategy.b(i5, i6, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i5 * fB), Math.round(fB * i6));
        } catch (Throwable unused) {
            Log.isLoggable("VideoDecoder", 3);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.s<Bitmap> a(@NonNull T t2, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        long jLongValue = ((Long) fVar.a(f13765d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) fVar.a(f13766e);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.a(DownsampleStrategy.f13754f);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f13753e;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f13768c.a();
        try {
            this.a.a(mediaMetadataRetrieverA, t2);
            return com.bumptech.glide.load.resource.bitmap.e.a(a(mediaMetadataRetrieverA, jLongValue, num.intValue(), i2, i3, downsampleStrategy2), this.b);
        } finally {
            if (Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetrieverA.close();
            } else {
                mediaMetadataRetrieverA.release();
            }
        }
    }

    @Nullable
    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmapB = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f13752d) ? null : b(mediaMetadataRetriever, j2, i2, i3, i4, downsampleStrategy);
        if (bitmapB == null) {
            bitmapB = a(mediaMetadataRetriever, j2, i2);
        }
        if (bitmapB != null) {
            return bitmapB;
        }
        throw new VideoDecoderException();
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }
}
