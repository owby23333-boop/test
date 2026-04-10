package com.baidu.mobads.sdk.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes2.dex */
public class bw {
    public static final String a = "ApkLoader";
    protected static Thread.UncaughtExceptionHandler b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12969c = "__badApkVersion__9.26";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12970d = "previousProxyVersion";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final String f12971e = "__xadsdk__remote__final__";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final String f12972f = "bdxadsdk.jar";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final String f12973g = "__xadsdk__remote__final__builtin__.jar";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final String f12974h = "__xadsdk__remote__final__builtinversion__.jar";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected static final String f12975i = "__xadsdk__remote__final__downloaded__.jar";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected static final String f12976j = "__xadsdk__remote__final__running__.jar";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12977k = "OK";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12978l = "ERROR";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12979m = "APK_INFO";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12980n = "CODE";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f12981o = "success";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected static volatile bl f12982p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected static volatile bl f12983q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected static volatile Class f12984r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected static String f12985s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected static final Handler f12986t = new bx(Looper.getMainLooper());

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f12987x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected Handler f12988u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    protected final Handler f12989v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private bu f12990w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Context f12991y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private bq f12992z;

    public static final class a extends Exception {
        private static final long a = 2978543166232984104L;

        public a(String str) {
            bq.a().c(str);
        }
    }

    protected static final class b extends Exception {
        private static final long a = -7838296421993681751L;

        public b(String str) {
            bq.a().c(str);
        }
    }

    public interface c {
        void a(boolean z2);
    }

    public bw(Activity activity) {
        this(activity.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] fileArrListFiles = this.f12991y.getFilesDir().listFiles();
            int i2 = 0;
            while (fileArrListFiles != null) {
                if (i2 >= fileArrListFiles.length) {
                    return;
                }
                if (fileArrListFiles[i2].getAbsolutePath().contains(f12971e) && fileArrListFiles[i2].getAbsolutePath().endsWith("dex")) {
                    fileArrListFiles[i2].delete();
                }
                i2++;
            }
        } catch (Exception e2) {
            bq.a().c(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.f12991y.getSharedPreferences(w.az, 0);
    }

    private boolean n() {
        String string = m().getString(f12970d, null);
        return string == null || !string.equals(a());
    }

    private boolean o() {
        try {
            if (!bo.a(c())) {
                if (!bo.a(f())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            this.f12992z.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        bp bpVar = new bp(f(), this.f12991y);
        if (!bo.a(bpVar)) {
            return false;
        }
        try {
            if (n()) {
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            }
            synchronized (this) {
                this.f12992z.a(a, "loadDownloadedOrBuiltInApk len=" + bpVar.length() + ", path=" + bpVar.getAbsolutePath());
                b(bpVar);
                double d2 = (double) m().getFloat(f12969c, -1.0f);
                this.f12992z.a(a, "downloadedApkFile.getApkVersion(): " + bpVar.c() + ", badApkVersion: " + d2);
                if (bpVar.c() == d2) {
                    throw new a("downloaded file marked bad, drop it and use built-in");
                }
                this.f12992z.a(a, "loaded: " + bpVar.getPath());
            }
            return true;
        } catch (a e2) {
            this.f12992z.a(a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
            if (bpVar.exists()) {
                bpVar.delete();
            }
            k();
            return false;
        }
    }

    public final String a() {
        return "9.26";
    }

    public int h() {
        return this.f12991y.getApplicationContext().getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    public IXAdContainerFactory i() {
        return a(f12982p);
    }

    public IXAdContainerFactory j() {
        return a(f12983q);
    }

    protected void k() {
        if (f12982p != null) {
            f12982p.b();
            f12982p = null;
        }
    }

    public bw(Context context) {
        this.f12992z = bq.a();
        this.A = false;
        this.f12988u = f12986t;
        this.B = new CopyOnWriteArrayList<>();
        this.f12989v = new by(this, Looper.getMainLooper());
        this.f12991y = context;
        c(context);
        if (b == null) {
            b = ck.a(context);
            ck.a(context).a(new bz(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof ck) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(b);
    }

    protected static String f() {
        if (TextUtils.isEmpty(f12985s)) {
            return "";
        }
        return f12985s + f12975i;
    }

    protected void e() throws b {
        this.f12992z.a(a, "start load assets file");
        d(this.f12991y);
        String strC = c();
        bp bpVar = new bp(strC, this.f12991y);
        if (!bo.a(bpVar)) {
            throw new b("loadBuiltInApk failed: " + strC);
        }
        this.f12992z.a(a, "assets file can read ,will use it ");
        if (c(bpVar)) {
            b(true);
        }
    }

    protected void g() throws a {
        if (h() != 2 ? p() : false) {
            this.f12992z.a(a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.f12992z.a(a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            this.f12992z.a(a, "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(f12985s)) {
            f12985s = context.getDir(f12987x, 0).getAbsolutePath() + "/";
        }
    }

    protected static String d() {
        if (TextUtils.isEmpty(f12985s)) {
            return "";
        }
        return f12985s + f12974h;
    }

    protected void b() {
        new File(f()).delete();
    }

    private static synchronized void d(Context context) {
        try {
            String strC = c();
            double dB = b(strC);
            bq.a().a(a, "copy assets,compare version=" + Double.valueOf("9.26") + "remote=" + dB);
            if (Double.valueOf("9.26").doubleValue() != dB) {
                bp bpVar = new bp(strC, context);
                if (bpVar.exists()) {
                    bpVar.delete();
                }
                bo.a(context, f12972f, strC);
            }
        } catch (Exception e2) {
            throw new b("loadBuiltInApk failed: " + e2.toString());
        }
    }

    private void b(bp bpVar) throws Throwable {
        this.f12992z.a(a, "len=" + bpVar.length() + ", path=" + bpVar.getAbsolutePath());
        if (f12982p == null) {
            String strA = a(this.f12991y);
            bp bpVar2 = new bp(strA, this.f12991y);
            if (bpVar2.exists()) {
                bpVar2.delete();
            }
            try {
                bo.a(new FileInputStream(bpVar), strA);
            } catch (Exception e2) {
                this.f12992z.c(e2);
            }
            f12982p = new bl(bpVar2.b(), this.f12991y);
            try {
                IXAdContainerFactory iXAdContainerFactoryA = f12982p.a();
                this.f12992z.a(a, "preloaded apk.version=" + iXAdContainerFactoryA.getRemoteVersion());
                return;
            } catch (a e3) {
                this.f12992z.a(a, "preload local apk " + bpVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + f12982p.b);
                a(e3.getMessage());
                throw e3;
            }
        }
        this.f12992z.a(a, "mApkBuilder already initialized, version: " + f12982p.b);
    }

    protected static String c() {
        if (TextUtils.isEmpty(f12985s)) {
            return "";
        }
        return f12985s + f12973g;
    }

    @TargetApi(9)
    protected void a(String str) {
        if (f12982p != null) {
            SharedPreferences.Editor editorEdit = m().edit();
            editorEdit.putFloat(f12969c, (float) f12982p.b);
            editorEdit.apply();
        }
    }

    private boolean c(bp bpVar) {
        synchronized (this) {
            b(bpVar);
            this.f12992z.a(a, "loaded: " + bpVar.getPath());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        Message messageObtainMessage = this.f12988u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z2);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.what = 0;
        this.f12988u.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z2) {
        double d2;
        if (z2) {
            try {
                d2 = f12982p.b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        an.a(d2, new cc(this, d2), new cd(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bp bpVar) {
        Class<?> clsB = bpVar.b();
        synchronized (this) {
            f12983q = new bl(clsB, this.f12991y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z2, String str) {
        try {
            ck.a(this.f12991y).c();
            if (this.B != null && this.B.size() > 0) {
                for (int i2 = 0; i2 < this.B.size(); i2++) {
                    c cVar = this.B.get(i2);
                    if (cVar != null) {
                        cVar.a(z2);
                    }
                }
            }
            if (this.B != null) {
                this.B.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        if (!z2 && !o()) {
            this.A = true;
        } else {
            a(z2, z2 ? "apk Successfully Loaded" : "apk Load Failed");
        }
        if (this.A) {
            ba.a().a((h) new ca(this, z2));
        } else {
            ba.a().a(new cb(this, z2), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) throws a {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.f12988u = handler;
        if (f12982p == null) {
            g();
        } else {
            b(true);
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f12985s)) {
            f12985s = context.getDir(f12987x, 0).getAbsolutePath() + "/";
        }
        if (TextUtils.isEmpty(f12985s)) {
            return "";
        }
        return f12985s + f12976j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bu buVar) {
        if (buVar.a().booleanValue()) {
            bs bsVarA = bs.a(this.f12991y, buVar, f12985s, this.f12989v);
            if (!bsVarA.isAlive()) {
                this.f12992z.a(a, "XApkDownloadThread starting ...");
                bsVarA.start();
            } else {
                this.f12992z.a(a, "XApkDownloadThread already started");
                bsVarA.a(buVar.c());
            }
        }
    }

    public static double b(Context context) throws Throwable {
        try {
            c(context);
            double dB = b(f());
            String strD = d();
            if (Double.valueOf("9.26").doubleValue() > b(strD)) {
                bp bpVar = new bp(strD, context);
                if (bpVar.exists()) {
                    bpVar.delete();
                }
                bo.a(context, f12972f, strD);
            }
            return Math.max(dB, b(d()));
        } catch (Exception unused) {
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
    }

    @TargetApi(9)
    public void a(c cVar, Handler handler) {
        ba.a().a((h) new ce(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, f12986t);
    }

    private IXAdContainerFactory a(bl blVar) {
        if (blVar == null) {
            return null;
        }
        try {
            return blVar.a();
        } catch (Exception unused) {
            return null;
        }
    }

    public static double b(String str) throws Throwable {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cj.f13019d.booleanValue()) {
            File file = new File(str);
            if (bo.a(file)) {
                jarFile = new JarFile(file);
                try {
                    double d2 = Double.parseDouble(jarFile.getManifest().getMainAttributes().getValue("Implementation-Version"));
                    if (d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                        try {
                            jarFile.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return d2;
                    }
                } catch (Exception unused2) {
                    jarFile2 = jarFile;
                    if (jarFile2 != null) {
                        jarFile2.close();
                    }
                    return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                } catch (Throwable th2) {
                    th = th2;
                    jarFile2 = jarFile;
                    if (jarFile2 != null) {
                        try {
                            jarFile2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                jarFile = null;
            }
            if (jarFile != null) {
                jarFile.close();
            }
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
        return Double.valueOf("9.26").doubleValue();
    }
}
