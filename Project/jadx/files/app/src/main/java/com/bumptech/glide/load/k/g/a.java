package com.bumptech.glide.load.k.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.util.l;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: ByteBufferGifDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bumptech.glide.load.g<ByteBuffer, c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final C0275a f13714f = new C0275a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b f13715g = new b();
    private final Context a;
    private final List<ImageHeaderParser> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f13716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0275a f13717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.k.g.b f13718e;

    /* JADX INFO: renamed from: com.bumptech.glide.load.k.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    static class C0275a {
        C0275a() {
        }

        GifDecoder a(GifDecoder.a aVar, com.bumptech.glide.gifdecoder.b bVar, ByteBuffer byteBuffer, int i2) {
            return new com.bumptech.glide.gifdecoder.d(aVar, bVar, byteBuffer, i2);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.x.e eVar, com.bumptech.glide.load.engine.x.b bVar) {
        this(context, list, eVar, bVar, f13715g, f13714f);
    }

    @VisibleForTesting
    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.x.e eVar, com.bumptech.glide.load.engine.x.b bVar, b bVar2, C0275a c0275a) {
        this.a = context.getApplicationContext();
        this.b = list;
        this.f13717d = c0275a;
        this.f13718e = new com.bumptech.glide.load.k.g.b(eVar, bVar);
        this.f13716c = bVar2;
    }

    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    static class b {
        private final Queue<com.bumptech.glide.gifdecoder.c> a = l.a(0);

        b() {
        }

        synchronized com.bumptech.glide.gifdecoder.c a(ByteBuffer byteBuffer) {
            com.bumptech.glide.gifdecoder.c cVarPoll;
            cVarPoll = this.a.poll();
            if (cVarPoll == null) {
                cVarPoll = new com.bumptech.glide.gifdecoder.c();
            }
            cVarPoll.a(byteBuffer);
            return cVarPoll;
        }

        synchronized void a(com.bumptech.glide.gifdecoder.c cVar) {
            cVar.a();
            this.a.offer(cVar);
        }
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return !((Boolean) fVar.a(i.b)).booleanValue() && com.bumptech.glide.load.b.getType(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.g
    public e a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        com.bumptech.glide.gifdecoder.c cVarA = this.f13716c.a(byteBuffer);
        try {
            return a(byteBuffer, i2, i3, cVarA, fVar);
        } finally {
            this.f13716c.a(cVarA);
        }
    }

    @Nullable
    private e a(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.gifdecoder.c cVar, com.bumptech.glide.load.f fVar) {
        Bitmap.Config config;
        long jA = com.bumptech.glide.util.g.a();
        try {
            com.bumptech.glide.gifdecoder.b bVarB = cVar.b();
            if (bVarB.b() > 0 && bVarB.c() == 0) {
                if (fVar.a(i.a) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                GifDecoder gifDecoderA = this.f13717d.a(this.f13718e, bVarB, byteBuffer, a(bVarB, i2, i3));
                gifDecoderA.a(config);
                gifDecoderA.b();
                Bitmap bitmapA = gifDecoderA.a();
                if (bitmapA == null) {
                    return null;
                }
                e eVar = new e(new c(this.a, gifDecoderA, com.bumptech.glide.load.k.c.a(), i2, i3, bitmapA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    String str = "Decoded GIF from stream in " + com.bumptech.glide.util.g.a(jA);
                }
                return eVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                String str2 = "Decoded GIF from stream in " + com.bumptech.glide.util.g.a(jA);
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                String str3 = "Decoded GIF from stream in " + com.bumptech.glide.util.g.a(jA);
            }
        }
    }

    private static int a(com.bumptech.glide.gifdecoder.b bVar, int i2, int i3) {
        int iMin = Math.min(bVar.a() / i3, bVar.d() / i2);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            String str = "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + bVar.d() + "x" + bVar.a() + "]";
        }
        return iMax;
    }
}
