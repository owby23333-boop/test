package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.r;
import com.umeng.message.proguard.ad;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: Downsampler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<DecodeFormat> f13773f = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f13424u);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<PreferredColorSpace> f13774g = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Boolean> f13775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Boolean> f13776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Set<String> f13777j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final b f13778k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f13779l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f13780m;
    private final com.bumptech.glide.load.engine.x.e a;
    private final DisplayMetrics b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.x.b f13781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f13782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f13783e = q.c();

    /* JADX INFO: compiled from: Downsampler.java */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l.b
        public void a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l.b
        public void a(com.bumptech.glide.load.engine.x.e eVar, Bitmap bitmap) {
        }
    }

    /* JADX INFO: compiled from: Downsampler.java */
    public interface b {
        void a();

        void a(com.bumptech.glide.load.engine.x.e eVar, Bitmap bitmap) throws IOException;
    }

    static {
        com.bumptech.glide.load.e<DownsampleStrategy> eVar = DownsampleStrategy.f13754f;
        f13775h = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
        f13776i = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
        f13777j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f13778k = new a();
        f13779l = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f13780m = com.bumptech.glide.util.l.a(0);
    }

    public l(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.x.e eVar, com.bumptech.glide.load.engine.x.b bVar) {
        this.f13782d = list;
        com.bumptech.glide.util.k.a(displayMetrics);
        this.b = displayMetrics;
        com.bumptech.glide.util.k.a(eVar);
        this.a = eVar;
        com.bumptech.glide.util.k.a(bVar);
        this.f13781c = bVar;
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (f13780m) {
            f13780m.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    private static int[] b(r rVar, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.x.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        a(rVar, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public com.bumptech.glide.load.engine.s<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, com.bumptech.glide.load.f fVar) throws IOException {
        return a(new r.a(byteBuffer, this.f13782d, this.f13781c), i2, i3, fVar, f13778k);
    }

    public com.bumptech.glide.load.engine.s<Bitmap> a(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.f fVar, b bVar) throws IOException {
        return a(new r.b(inputStream, this.f13782d, this.f13781c), i2, i3, fVar, bVar);
    }

    @RequiresApi(21)
    public com.bumptech.glide.load.engine.s<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, com.bumptech.glide.load.f fVar) throws IOException {
        return a(new r.c(parcelFileDescriptor, this.f13782d, this.f13781c), i2, i3, fVar, f13778k);
    }

    private com.bumptech.glide.load.engine.s<Bitmap> a(r rVar, int i2, int i3, com.bumptech.glide.load.f fVar, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.f13781c.a(65536, byte[].class);
        BitmapFactory.Options optionsA = a();
        optionsA.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) fVar.a(f13773f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) fVar.a(f13774g);
        try {
            return e.a(a(rVar, optionsA, (DownsampleStrategy) fVar.a(DownsampleStrategy.f13754f), decodeFormat, preferredColorSpace, fVar.a(f13776i) != null && ((Boolean) fVar.a(f13776i)).booleanValue(), i2, i3, ((Boolean) fVar.a(f13775h)).booleanValue(), bVar), this.a);
        } finally {
            c(optionsA);
            this.f13781c.put(bArr);
        }
    }

    private static boolean b(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap a(com.bumptech.glide.load.resource.bitmap.r r28, android.graphics.BitmapFactory.Options r29, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r30, com.bumptech.glide.load.DecodeFormat r31, com.bumptech.glide.load.PreferredColorSpace r32, boolean r33, int r34, int r35, boolean r36, com.bumptech.glide.load.resource.bitmap.l.b r37) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.l.a(com.bumptech.glide.load.resource.bitmap.r, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.DecodeFormat, com.bumptech.glide.load.PreferredColorSpace, boolean, int, int, boolean, com.bumptech.glide.load.resource.bitmap.l$b):android.graphics.Bitmap");
    }

    private static void a(ImageHeaderParser.ImageType imageType, r rVar, b bVar, com.bumptech.glide.load.engine.x.e eVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        int i7;
        int i8;
        int iMin;
        int iMax;
        int iFloor;
        double dFloor;
        int iRound;
        if (i3 > 0 && i4 > 0) {
            if (a(i2)) {
                i8 = i3;
                i7 = i4;
            } else {
                i7 = i3;
                i8 = i4;
            }
            float fB = downsampleStrategy.b(i7, i8, i5, i6);
            if (fB > 0.0f) {
                DownsampleStrategy.SampleSizeRounding sampleSizeRoundingA = downsampleStrategy.a(i7, i8, i5, i6);
                if (sampleSizeRoundingA != null) {
                    float f2 = i7;
                    float f3 = i8;
                    int iC = i7 / c(fB * f2);
                    int iC2 = i8 / c(fB * f3);
                    if (sampleSizeRoundingA == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                        iMin = Math.max(iC, iC2);
                    } else {
                        iMin = Math.min(iC, iC2);
                    }
                    if (Build.VERSION.SDK_INT > 23 || !f13777j.contains(options.outMimeType)) {
                        iMax = Math.max(1, Integer.highestOneBit(iMin));
                        if (sampleSizeRoundingA == DownsampleStrategy.SampleSizeRounding.MEMORY && iMax < 1.0f / fB) {
                            iMax <<= 1;
                        }
                    } else {
                        iMax = 1;
                    }
                    options.inSampleSize = iMax;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float fMin = Math.min(iMax, 8);
                        iFloor = (int) Math.ceil(f2 / fMin);
                        iRound = (int) Math.ceil(f3 / fMin);
                        int i9 = iMax / 8;
                        if (i9 > 0) {
                            iFloor /= i9;
                            iRound /= i9;
                        }
                    } else {
                        if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                            if (imageType.isWebp()) {
                                if (Build.VERSION.SDK_INT >= 24) {
                                    float f4 = iMax;
                                    iFloor = Math.round(f2 / f4);
                                    iRound = Math.round(f3 / f4);
                                } else {
                                    float f5 = iMax;
                                    iFloor = (int) Math.floor(f2 / f5);
                                    dFloor = Math.floor(f3 / f5);
                                }
                            } else if (i7 % iMax == 0 && i8 % iMax == 0) {
                                iFloor = i7 / iMax;
                                iRound = i8 / iMax;
                            } else {
                                int[] iArrB = b(rVar, options, bVar, eVar);
                                iFloor = iArrB[0];
                                iRound = iArrB[1];
                            }
                        } else {
                            float f6 = iMax;
                            iFloor = (int) Math.floor(f2 / f6);
                            dFloor = Math.floor(f3 / f6);
                        }
                        iRound = (int) dFloor;
                    }
                    double dB = downsampleStrategy.b(iFloor, iRound, i5, i6);
                    if (Build.VERSION.SDK_INT >= 19) {
                        options.inTargetDensity = a(dB);
                        options.inDensity = b(dB);
                    }
                    if (b(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        String str = "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + downsampleStrategy + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        if (Log.isLoggable("Downsampler", 3)) {
            String str2 = "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]";
        }
    }

    private static int a(double d2) {
        int iB = b(d2);
        double d3 = iB;
        Double.isNaN(d3);
        int iC = c(d3 * d2);
        double d4 = iC / iB;
        Double.isNaN(d4);
        double d5 = iC;
        Double.isNaN(d5);
        return c((d2 / d4) * d5);
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f13779l.contains(imageType);
    }

    private void a(r rVar, DecodeFormat decodeFormat, boolean z2, boolean z3, BitmapFactory.Options options, int i2, int i3) {
        if (this.f13783e.a(i2, i3, options, z2, z3)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888 && Build.VERSION.SDK_INT != 16) {
            boolean zHasAlpha = false;
            try {
                zHasAlpha = rVar.c().hasAlpha();
            } catch (IOException unused) {
                if (Log.isLoggable("Downsampler", 3)) {
                    String str = "Cannot determine whether the image has alpha or not from header, format " + decodeFormat;
                }
            }
            options.inPreferredConfig = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(com.bumptech.glide.load.resource.bitmap.r r4, android.graphics.BitmapFactory.Options r5, com.bumptech.glide.load.resource.bitmap.l.b r6, com.bumptech.glide.load.engine.x.e r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto La
            r6.a()
            r4.a()
        La:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.y.a()
            r3.lock()
            android.graphics.Bitmap r4 = r4.a(r5)     // Catch: java.lang.Throwable -> L23 java.lang.IllegalArgumentException -> L25
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.y.a()
            r5.unlock()
            return r4
        L23:
            r4 = move-exception
            goto L4b
        L25:
            r3 = move-exception
            java.io.IOException r0 = a(r3, r0, r1, r2, r5)     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L23
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L4a
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            r7.a(r1)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            r1 = 0
            r5.inBitmap = r1     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            android.graphics.Bitmap r4 = a(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L49
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.y.a()
            r5.unlock()
            return r4
        L49:
            throw r0     // Catch: java.lang.Throwable -> L23
        L4a:
            throw r0     // Catch: java.lang.Throwable -> L23
        L4b:
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.y.a()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.l.a(com.bumptech.glide.load.resource.bitmap.r, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.l$b, com.bumptech.glide.load.engine.x.e):android.graphics.Bitmap");
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        String str2 = "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + a(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.util.g.a(j2);
    }

    private static String a(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    @Nullable
    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ad.f20406s;
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + a(options), illegalArgumentException);
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, com.bumptech.glide.load.engine.x.e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i2, i3, config);
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options optionsPoll;
        synchronized (f13780m) {
            optionsPoll = f13780m.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            d(optionsPoll);
        }
        return optionsPoll;
    }
}
