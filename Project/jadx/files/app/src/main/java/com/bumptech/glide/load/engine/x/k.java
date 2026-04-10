package com.bumptech.glide.load.engine.x;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Bitmap.Config f13619j = Bitmap.Config.ARGB_8888;
    private final l a;
    private final Set<Bitmap.Config> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f13620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13626i;

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: LruBitmapPool.java */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.x.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.x.k.a
        public void b(Bitmap bitmap) {
        }
    }

    k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f13621d = j2;
        this.a = lVar;
        this.b = set;
        this.f13620c = new b();
    }

    @NonNull
    private static Bitmap c(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f13619j;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Nullable
    private synchronized Bitmap d(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap bitmapA;
        a(config);
        bitmapA = this.a.a(i2, i3, config != null ? config : f13619j);
        if (bitmapA == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                String str = "Missing bitmap=" + this.a.b(i2, i3, config);
            }
            this.f13624g++;
        } else {
            this.f13623f++;
            this.f13622e -= (long) this.a.c(bitmapA);
            this.f13620c.a(bitmapA);
            c(bitmapA);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            String str2 = "Get bitmap=" + this.a.b(i2, i3, config);
        }
        c();
        return bitmapA;
    }

    private void e() {
        a(this.f13621d);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> f() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l g() {
        return Build.VERSION.SDK_INT >= 19 ? new n() : new c();
    }

    @Override // com.bumptech.glide.load.engine.x.e
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.a.c(bitmap) <= this.f13621d && this.b.contains(bitmap.getConfig())) {
                int iC = this.a.c(bitmap);
                this.a.a(bitmap);
                this.f13620c.b(bitmap);
                this.f13625h++;
                this.f13622e += (long) iC;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    String str = "Put bitmap in pool=" + this.a.b(bitmap);
                }
                c();
                e();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                String str2 = "Reject bitmap from pool, bitmap: " + this.a.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    public long b() {
        return this.f13621d;
    }

    @Override // com.bumptech.glide.load.engine.x.e
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            String str = "trimMemory, level=" + i2;
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }

    private static void c(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        b(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.x.e
    @NonNull
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapD = d(i2, i3, config);
        return bitmapD == null ? c(i2, i3, config) : bitmapD;
    }

    @TargetApi(19)
    private static void b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private void c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            d();
        }
    }

    public k(long j2) {
        this(j2, g(), f());
    }

    private void d() {
        String str = "Hits=" + this.f13623f + ", misses=" + this.f13624g + ", puts=" + this.f13625h + ", evictions=" + this.f13626i + ", currentSize=" + this.f13622e + ", maxSize=" + this.f13621d + "\nStrategy=" + this.a;
    }

    @Override // com.bumptech.glide.load.engine.x.e
    @NonNull
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapD = d(i2, i3, config);
        if (bitmapD != null) {
            bitmapD.eraseColor(0);
            return bitmapD;
        }
        return c(i2, i3, config);
    }

    @TargetApi(26)
    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @Override // com.bumptech.glide.load.engine.x.e
    public void a() {
        Log.isLoggable("LruBitmapPool", 3);
        a(0L);
    }

    private synchronized void a(long j2) {
        while (this.f13622e > j2) {
            Bitmap bitmapRemoveLast = this.a.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    d();
                }
                this.f13622e = 0L;
                return;
            }
            this.f13620c.a(bitmapRemoveLast);
            this.f13622e -= (long) this.a.c(bitmapRemoveLast);
            this.f13626i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                String str = "Evicting bitmap=" + this.a.b(bitmapRemoveLast);
            }
            c();
            bitmapRemoveLast.recycle();
        }
    }
}
