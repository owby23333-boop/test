package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
class g {
    static int a = 0;
    static boolean b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static g f19025e = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f19026h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f19027j = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f19028l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u f19029c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private u f19030d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19031f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f19032g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f19033i = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f19034k = null;

    private g() {
    }

    public static g a(boolean z2) {
        if (f19025e == null && z2) {
            synchronized (g.class) {
                if (f19025e == null) {
                    f19025e = new g();
                }
            }
        }
        return f19025e;
    }

    static void a(int i2) {
        f19026h = i2;
    }

    private void b(int i2) {
        FileOutputStream fileOutputStream;
        String strValueOf = String.valueOf(i2);
        Properties properties = new Properties();
        properties.setProperty(f19028l, strValueOf);
        try {
            fileOutputStream = new FileOutputStream(new File(this.f19034k, "count.prop"));
            try {
                properties.store(fileOutputStream, (String) null);
            } catch (FileNotFoundException e2) {
                e = e2;
                e.printStackTrace();
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            fileOutputStream = null;
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int d() {
        return f19026h;
    }

    private int j() throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                File file = new File(this.f19034k, "count.prop");
                if (!file.exists()) {
                    return 0;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    int iIntValue = Integer.valueOf(properties.getProperty(f19028l, "1")).intValue();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return iIntValue;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
        }
        throw th;
    }

    public u a() {
        if (this.f19031f) {
            return this.f19029c;
        }
        return null;
    }

    public synchronized void a(Context context, boolean z2, boolean z3) {
        TbsLog.initIfNeed(context);
        a++;
        TbsLog.i("SDKEngine", "init", "#1# context: " + context + ", mInitCount: " + a);
        o.a().b(context, a == 1);
        o.a().j(context);
        boolean zA = QbSdk.a(context, z2, z3);
        TbsLog.i("SDKEngine", "init", "#2# canLoadX5 is " + zA);
        if (zA) {
            if (this.f19031f) {
                return;
            }
            TbsLog.i("SDKEngine", "init", "#3# start to load tbs");
            try {
                File fileP = o.a().p(context);
                Context applicationContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
                if (fileP == null) {
                    this.f19031f = false;
                    this.f19033i = "false03";
                    TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_TBSCORE_SHARE_DIR, new Throwable());
                    QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                    return;
                }
                String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, applicationContext, fileP.getAbsolutePath());
                for (int i2 = 0; i2 < dexLoaderFileList.length; i2++) {
                    TbsLog.i("SDKEngine", "dexLoaderFileList[" + i2 + "]: " + dexLoaderFileList[i2]);
                }
                String absolutePath = fileP.getAbsolutePath();
                TbsLog.i("SDKEngine", "init", "#4# optDir is " + absolutePath);
                if (this.f19030d != null) {
                    this.f19029c = this.f19030d;
                    this.f19029c.a(context, applicationContext, fileP.getAbsolutePath(), absolutePath, dexLoaderFileList, QbSdk.f18839d);
                } else {
                    this.f19029c = new u(context, applicationContext, fileP.getAbsolutePath(), absolutePath, dexLoaderFileList, QbSdk.f18839d);
                }
                this.f19031f = true;
                this.f19033i = "true01";
            } catch (Throwable th) {
                TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th);
                TbsCoreLoadStat.getInstance().a(context, TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE, th);
                this.f19031f = false;
                this.f19033i = "false04";
                QbSdk.a(context, "SDKEngine::useSystemWebView by exception: " + th);
            }
        } else if (!QbSdk.a || !this.f19031f) {
            this.f19031f = false;
            this.f19033i = "false05";
            TbsLog.e("SDKEngine", "init", "[LoadError] check log upon for details");
        }
        d.a().a(context);
        this.f19034k = o.r(context);
        this.f19032g = true;
    }

    void a(String str) {
        f19028l = str;
    }

    public boolean b() {
        return this.f19031f;
    }

    boolean b(boolean z2) {
        b = z2;
        return z2;
    }

    u c() {
        return this.f19029c;
    }

    public String e() {
        u uVar = this.f19029c;
        return (uVar == null || QbSdk.a) ? "system webview get nothing..." : uVar.a();
    }

    public String f() {
        u uVar = this.f19029c;
        return (uVar == null || QbSdk.a) ? "system webview get nothing..." : uVar.b();
    }

    boolean g() throws Throwable {
        if (b) {
            if (f19028l == null) {
                return false;
            }
            int iJ = j();
            if (iJ == 0) {
                b(1);
            } else {
                int i2 = iJ + 1;
                if (i2 > f19027j) {
                    return false;
                }
                b(i2);
            }
        }
        return b;
    }

    boolean h() {
        return this.f19032g;
    }

    public boolean i() {
        return QbSdk.useSoftWare();
    }
}
