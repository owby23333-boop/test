package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.ss.android.z.z.g.fv;
import com.ss.android.z.z.g.io;
import com.ss.android.z.z.g.iq;
import com.ss.android.z.z.g.js;
import com.ss.android.z.z.g.ls;
import com.ss.android.z.z.g.tb;
import com.ss.android.z.z.gc.z;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.z.z.g.dl f1996a;
    private static com.ss.android.z.z.g.e dl;
    private static com.ss.android.z.z.g.uy e;
    private static com.ss.android.z.z.gc.z fo;
    private static com.ss.android.z.z.g.pf fv;
    private static Context g;
    private static com.ss.android.z.z.g.v gc;
    private static com.ss.android.z.z.g.wp gz;
    private static com.ss.android.z.z.g.gc i;
    private static iq iq;
    private static js js;
    private static com.ss.android.socialbase.appdownloader.dl.fo kb;
    private static io ls;
    private static com.ss.android.z.z.g.fo m;
    private static ls p;
    private static com.ss.android.z.z.g.i pf;
    private static tb q;
    private static com.ss.android.z.z.a.z tb;
    private static com.ss.android.z.z.g.g uy;
    private static fv v;
    private static com.ss.android.z.z.g.a wp;
    public static final JSONObject z = new JSONObject();
    private static com.ss.android.z.z.g.kb zw;

    public static String v() {
        return "1.7.0";
    }

    public static void z(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        g = context.getApplicationContext();
    }

    public static void g(Context context) {
        if (g != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        g = context.getApplicationContext();
    }

    public static Context getContext() {
        Context context = g;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void z(com.ss.android.z.z.g.e eVar) {
        dl = eVar;
    }

    public static void z(com.ss.android.z.z.g.v vVar) {
        gc = vVar;
    }

    public static void z(com.ss.android.z.z.g.fo foVar) {
        m = foVar;
    }

    public static void z(com.ss.android.z.z.g.uy uyVar) {
        e = uyVar;
    }

    public static void z(com.ss.android.z.z.g.wp wpVar) {
        gz = wpVar;
    }

    public static void z(com.ss.android.z.z.gc.z zVar) {
        fo = zVar;
    }

    public static void z(com.ss.android.z.z.g.g gVar) {
        uy = gVar;
    }

    public static com.ss.android.z.z.g.e z() {
        return dl;
    }

    public static com.ss.android.z.z.g.dl g() {
        if (f1996a == null) {
            f1996a = new com.ss.android.z.z.g.dl() { // from class: com.ss.android.downloadlib.addownload.wp.1
            };
        }
        return f1996a;
    }

    public static com.ss.android.z.z.g.v dl() {
        if (gc == null) {
            gc = new com.ss.android.z.z.z.z();
        }
        return gc;
    }

    public static com.ss.android.z.z.g.fo a() {
        return m;
    }

    public static com.ss.android.z.z.g.uy gc() {
        if (e == null) {
            e = new com.ss.android.z.z.z.g();
        }
        return e;
    }

    public static com.ss.android.socialbase.appdownloader.dl.fo m() {
        if (kb == null) {
            kb = new com.ss.android.socialbase.appdownloader.dl.fo() { // from class: com.ss.android.downloadlib.addownload.wp.2
                @Override // com.ss.android.socialbase.appdownloader.dl.fo
                public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i2) {
                }
            };
        }
        return kb;
    }

    public static fv e() {
        return v;
    }

    public static js gz() {
        if (js == null) {
            js = new js() { // from class: com.ss.android.downloadlib.addownload.wp.3
            };
        }
        return js;
    }

    public static JSONObject fo() {
        com.ss.android.z.z.g.wp wpVar = gz;
        if (wpVar == null || wpVar.z() == null) {
            return z;
        }
        return gz.z();
    }

    public static com.ss.android.z.z.gc.z uy() {
        if (fo == null) {
            fo = new z.C0485z().z();
        }
        return fo;
    }

    public static com.ss.android.z.z.g.pf kb() {
        return fv;
    }

    public static com.ss.android.z.z.g.g wp() {
        return uy;
    }

    public static ls i() {
        return p;
    }

    public static void z(String str) {
        com.ss.android.socialbase.appdownloader.a.kb().z(str);
    }

    public static void z(com.ss.android.socialbase.appdownloader.dl.dl dlVar) {
        com.ss.android.socialbase.appdownloader.a.kb().z(dlVar);
    }

    public static com.ss.android.z.z.g.a pf() {
        return wp;
    }

    public static com.ss.android.z.z.g.gc ls() {
        return i;
    }

    public static com.ss.android.z.z.g.i p() {
        return pf;
    }

    public static void z(tb tbVar) {
        q = tbVar;
    }

    public static tb fv() {
        return q;
    }

    public static io js() {
        return ls;
    }

    public static void z(com.ss.android.z.z.a.z zVar) {
        tb = zVar;
    }

    public static com.ss.android.z.z.a.z tb() {
        if (tb == null) {
            tb = new com.ss.android.z.z.a.z() { // from class: com.ss.android.downloadlib.addownload.wp.4
                @Override // com.ss.android.z.z.a.z
                public void z(Throwable th, String str) {
                }
            };
        }
        return tb;
    }

    public static iq q() {
        if (iq == null) {
            iq = new iq() { // from class: com.ss.android.downloadlib.addownload.wp.5
            };
        }
        return iq;
    }

    public static void z(com.ss.android.z.z.g.kb kbVar) {
        zw = kbVar;
    }

    public static com.ss.android.z.z.g.kb iq() {
        return zw;
    }

    public static String zw() {
        try {
            int i2 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + fo().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean io() {
        return (dl == null || m == null || gz == null || uy == null || q == null) ? false : true;
    }
}
