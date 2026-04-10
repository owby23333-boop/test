package com.bumptech.glide.load.engine.y;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: compiled from: MemorySizeCalculator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private final int a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f13638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13639d;

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f13640i;
        final Context a;
        ActivityManager b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c f13641c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f13643e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f13642d = 2.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f13644f = 0.4f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f13645g = 0.33f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f13646h = 4194304;

        static {
            f13640i = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f13643e = f13640i;
            this.a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.f13641c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.b)) {
                return;
            }
            this.f13643e = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    private static final class b implements c {
        private final DisplayMetrics a;

        b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.y.i.c
        public int a() {
            return this.a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.y.i.c
        public int b() {
            return this.a.widthPixels;
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        this.f13638c = aVar.a;
        this.f13639d = a(aVar.b) ? aVar.f13646h / 2 : aVar.f13646h;
        int iA = a(aVar.b, aVar.f13644f, aVar.f13645g);
        float fB = aVar.f13641c.b() * aVar.f13641c.a() * 4;
        int iRound = Math.round(aVar.f13643e * fB);
        int iRound2 = Math.round(fB * aVar.f13642d);
        int i2 = iA - this.f13639d;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.b = iRound2;
            this.a = iRound;
        } else {
            float f2 = i2;
            float f3 = aVar.f13643e;
            float f4 = aVar.f13642d;
            float f5 = f2 / (f3 + f4);
            this.b = Math.round(f4 * f5);
            this.a = Math.round(f5 * aVar.f13643e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.b));
            sb.append(", pool size: ");
            sb.append(a(this.a));
            sb.append(", byte array size: ");
            sb.append(a(this.f13639d));
            sb.append(", memory class limited? ");
            sb.append(i3 > iA);
            sb.append(", max size: ");
            sb.append(a(iA));
            sb.append(", memoryClass: ");
            sb.append(aVar.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.b));
            sb.toString();
        }
    }

    public int a() {
        return this.f13639d;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i2) {
        return Formatter.formatFileSize(this.f13638c, i2);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
