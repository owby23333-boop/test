package com.taobao.accs.net;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.taobao.accs.internal.AccsJobService;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    protected static volatile f b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f18217c = {SubsamplingScaleImageView.ORIENTATION_270, 360, 480};
    protected Context a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f18219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f18220f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int[] f18221g = {0, 0, 0};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18222h;

    protected f(Context context) {
        this.f18222h = true;
        try {
            this.a = context;
            this.f18218d = 0;
            this.f18219e = System.currentTimeMillis();
            this.f18222h = com.taobao.accs.utl.u.b();
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "HeartbeatManager", th, new Object[0]);
        }
    }

    public static f a(Context context) {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    if (Build.VERSION.SDK_INT < 21 || !b(context)) {
                        ALog.i("HeartbeatManager", "hb use alarm", new Object[0]);
                        b = new a(context);
                    } else {
                        ALog.i("HeartbeatManager", "hb use job", new Object[0]);
                        b = new u(context);
                    }
                }
            }
        }
        return b;
    }

    private static boolean b(Context context) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), AccsJobService.class.getName()), 0).isEnabled();
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "isJobServiceExist", th, new Object[0]);
            return false;
        }
    }

    protected abstract void a(int i2);

    public void c() {
        this.f18219e = -1L;
        if (this.f18220f) {
            int[] iArr = this.f18221g;
            int i2 = this.f18218d;
            iArr[i2] = iArr[i2] + 1;
        }
        int i3 = this.f18218d;
        this.f18218d = i3 > 0 ? i3 - 1 : 0;
        ALog.d("HeartbeatManager", "onNetworkTimeout", new Object[0]);
    }

    public void d() {
        this.f18219e = -1L;
        ALog.d("HeartbeatManager", "onNetworkFail", new Object[0]);
    }

    public void e() {
        ALog.d("HeartbeatManager", "onHeartbeatSucc", new Object[0]);
        if (System.currentTimeMillis() - this.f18219e <= 7199000) {
            this.f18220f = false;
            this.f18221g[this.f18218d] = 0;
            return;
        }
        int i2 = this.f18218d;
        if (i2 >= f18217c.length - 1 || this.f18221g[i2] > 2) {
            return;
        }
        ALog.d("HeartbeatManager", "upgrade", new Object[0]);
        this.f18218d++;
        this.f18220f = true;
        this.f18219e = System.currentTimeMillis();
    }

    public void f() {
        this.f18218d = 0;
        this.f18219e = System.currentTimeMillis();
        ALog.d("HeartbeatManager", "resetLevel", new Object[0]);
    }

    public int b() {
        int i2 = this.f18222h ? f18217c[this.f18218d] : SubsamplingScaleImageView.ORIENTATION_270;
        this.f18222h = com.taobao.accs.utl.u.b();
        return i2;
    }

    public synchronized void a() {
        try {
            if (this.f18219e < 0) {
                this.f18219e = System.currentTimeMillis();
            }
            int iB = b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("HeartbeatManager", "set " + iB, new Object[0]);
            }
            a(iB);
        } catch (Throwable th) {
            ALog.e("HeartbeatManager", "set", th, new Object[0]);
        }
    }
}
