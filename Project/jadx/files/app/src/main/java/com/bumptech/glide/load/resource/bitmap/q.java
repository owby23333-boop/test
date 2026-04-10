package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: HardwareConfigState.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f13785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f13786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final File f13787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile q f13788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile int f13789k;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private int f13791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f13792e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f13793f = new AtomicBoolean(false);
    private final boolean a = f();

    static {
        f13785g = Build.VERSION.SDK_INT < 29;
        f13786h = Build.VERSION.SDK_INT >= 26;
        f13787i = new File("/proc/self/fd");
        f13789k = -1;
    }

    @VisibleForTesting
    q() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = 20000;
            this.f13790c = 0;
        } else {
            this.b = 700;
            this.f13790c = 128;
        }
    }

    private boolean b() {
        return f13785g && !this.f13793f.get();
    }

    public static q c() {
        if (f13788j == null) {
            synchronized (q.class) {
                if (f13788j == null) {
                    f13788j = new q();
                }
            }
        }
        return f13788j;
    }

    private int d() {
        return f13789k != -1 ? f13789k : this.b;
    }

    private synchronized boolean e() {
        int i2 = this.f13791d + 1;
        this.f13791d = i2;
        if (i2 >= 50) {
            this.f13791d = 0;
            int length = f13787i.list().length;
            long jD = d();
            this.f13792e = ((long) length) < jD;
            if (!this.f13792e && Log.isLoggable("Downsampler", 5)) {
                String str = "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jD;
            }
        }
        return this.f13792e;
    }

    private static boolean f() {
        return (g() || h()) ? false : true;
    }

    private static boolean g() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean h() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }

    public void a() {
        com.bumptech.glide.util.l.b();
        this.f13793f.set(true);
    }

    public boolean a(int i2, int i3, boolean z2, boolean z3) {
        if (!z2) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (!this.a) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (!f13786h) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (b()) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (z3) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        int i4 = this.f13790c;
        if (i2 < i4) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (i3 < i4) {
            Log.isLoggable("HardwareConfig", 2);
            return false;
        }
        if (e()) {
            return true;
        }
        Log.isLoggable("HardwareConfig", 2);
        return false;
    }

    @TargetApi(26)
    boolean a(int i2, int i3, BitmapFactory.Options options, boolean z2, boolean z3) {
        boolean zA = a(i2, i3, z2, z3);
        if (zA) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zA;
    }
}
