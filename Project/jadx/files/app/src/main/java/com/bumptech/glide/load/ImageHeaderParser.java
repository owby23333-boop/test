package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        UNKNOWN(false);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final boolean f13430s;

        ImageType(boolean z2) {
            this.f13430s = z2;
        }

        public boolean hasAlpha() {
            return this.f13430s;
        }

        public boolean isWebp() {
            int i2 = a.a[ordinal()];
            return i2 == 1 || i2 == 2 || i2 == 3;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[ImageType.values().length];

        static {
            try {
                a[ImageType.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageType.WEBP_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    int a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException;

    int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException;

    @NonNull
    ImageType getType(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException;
}
