package com.bumptech.glide.load.k.e;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: AnimatedWebpDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
public final class a {
    private final List<ImageHeaderParser> a;
    private final com.bumptech.glide.load.engine.x.b b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.k.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatedWebpDecoder.java */
    private static final class C0274a implements s<Drawable> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final AnimatedImageDrawable f13712s;

        C0274a(AnimatedImageDrawable animatedImageDrawable) {
            this.f13712s = animatedImageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.s
        @NonNull
        public Class<Drawable> a() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.s
        public int getSize() {
            return this.f13712s.getIntrinsicWidth() * this.f13712s.getIntrinsicHeight() * l.a(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // com.bumptech.glide.load.engine.s
        public void recycle() {
            this.f13712s.stop();
            this.f13712s.clearAnimationCallbacks();
        }

        @Override // com.bumptech.glide.load.engine.s
        @NonNull
        public Drawable get() {
            return this.f13712s;
        }
    }

    private a(List<ImageHeaderParser> list, com.bumptech.glide.load.engine.x.b bVar) {
        this.a = list;
        this.b = bVar;
    }

    public static com.bumptech.glide.load.g<ByteBuffer, Drawable> a(List<ImageHeaderParser> list, com.bumptech.glide.load.engine.x.b bVar) {
        return new b(new a(list, bVar));
    }

    public static com.bumptech.glide.load.g<InputStream, Drawable> b(List<ImageHeaderParser> list, com.bumptech.glide.load.engine.x.b bVar) {
        return new c(new a(list, bVar));
    }

    /* JADX INFO: compiled from: AnimatedWebpDecoder.java */
    private static final class b implements com.bumptech.glide.load.g<ByteBuffer, Drawable> {
        private final a a;

        b(a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.g
        public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
            return this.a.a(byteBuffer);
        }

        @Override // com.bumptech.glide.load.g
        public s<Drawable> a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
            return this.a.a(ImageDecoder.createSource(byteBuffer), i2, i3, fVar);
        }
    }

    /* JADX INFO: compiled from: AnimatedWebpDecoder.java */
    private static final class c implements com.bumptech.glide.load.g<InputStream, Drawable> {
        private final a a;

        c(a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.g
        public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
            return this.a.a(inputStream);
        }

        @Override // com.bumptech.glide.load.g
        public s<Drawable> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
            return this.a.a(ImageDecoder.createSource(com.bumptech.glide.util.a.a(inputStream)), i2, i3, fVar);
        }
    }

    boolean a(ByteBuffer byteBuffer) throws IOException {
        return a(com.bumptech.glide.load.b.getType(this.a, byteBuffer));
    }

    boolean a(InputStream inputStream) throws IOException {
        return a(com.bumptech.glide.load.b.getType(this.a, inputStream, this.b));
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP;
    }

    s<Drawable> a(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new com.bumptech.glide.load.k.a(i2, i3, fVar));
        if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
            return new C0274a((AnimatedImageDrawable) drawableDecodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + drawableDecodeDrawable);
    }
}
