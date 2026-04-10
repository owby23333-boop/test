package com.bumptech.glide.load.k;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.q;

/* JADX INFO: compiled from: DefaultOnHeaderDecodedListener.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 28)
public final class a implements ImageDecoder.OnHeaderDecodedListener {
    private final q a = q.c();
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DecodeFormat f13706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DownsampleStrategy f13707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f13708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PreferredColorSpace f13709g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultOnHeaderDecodedListener.java */
    class C0272a implements ImageDecoder.OnPartialImageListener {
        C0272a(a aVar) {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public a(int i2, int i3, @NonNull f fVar) {
        this.b = i2;
        this.f13705c = i3;
        this.f13706d = (DecodeFormat) fVar.a(l.f13773f);
        this.f13707e = (DownsampleStrategy) fVar.a(DownsampleStrategy.f13754f);
        this.f13708f = fVar.a(l.f13776i) != null && ((Boolean) fVar.a(l.f13776i)).booleanValue();
        this.f13709g = (PreferredColorSpace) fVar.a(l.f13774g);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(@NonNull ImageDecoder imageDecoder, @NonNull ImageDecoder.ImageInfo imageInfo, @NonNull ImageDecoder.Source source) {
        if (this.a.a(this.b, this.f13705c, this.f13708f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f13706d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C0272a(this));
        Size size = imageInfo.getSize();
        int width = this.b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f13705c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f13707e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            String str = "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB;
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        PreferredColorSpace preferredColorSpace = this.f13709g;
        if (preferredColorSpace != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut() ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i2 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
