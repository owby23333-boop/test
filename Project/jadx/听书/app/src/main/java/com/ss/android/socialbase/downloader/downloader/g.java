package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.hh;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public class g {
    private String g;
    private String z;

    g() {
    }

    public static com.ss.android.socialbase.downloader.e.a z(Context context) {
        e.g(context);
        return new com.ss.android.socialbase.downloader.e.a();
    }

    public void z(int i) {
        a.z().a(i);
    }

    public int z(String str, String str2) {
        return a.z().z(str, str2);
    }

    public List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        return a.z().z(str);
    }

    public void g(int i) {
        z(i, true);
    }

    public void z(int i, boolean z) {
        a.z().dl(i, z);
    }

    public void dl(int i) {
        a.z().m(i);
    }

    public boolean a(int i) {
        return a.z().gc(i);
    }

    public void gc(int i) {
        a.z().e(i);
    }

    public void z() {
        a.z().dl();
    }

    public void z(List<String> list) {
        a.z().z(list);
    }

    public void g(List<String> list) {
        a.z().g(list);
    }

    public int m(int i) {
        return a.z().gz(i);
    }

    public boolean e(int i) {
        boolean zFo;
        if (com.ss.android.socialbase.downloader.pf.z.z(4194304)) {
            synchronized (this) {
                zFo = a.z().fo(i);
            }
            return zFo;
        }
        return a.z().fo(i);
    }

    public com.ss.android.socialbase.downloader.e.dl gz(int i) {
        return a.z().uy(i);
    }

    public com.ss.android.socialbase.downloader.e.dl g(String str, String str2) {
        return a.z().g(str, str2);
    }

    public gk fo(int i) {
        return a.z().kb(i);
    }

    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        return a.z().g(str);
    }

    public void uy(int i) {
        a.z().a(i, true);
    }

    @Deprecated
    public void kb(int i) {
        a.z().z(i, null, com.ss.android.socialbase.downloader.g.gz.MAIN, true);
    }

    @Deprecated
    public void z(int i, hh hhVar) {
        if (hhVar == null) {
            return;
        }
        a.z().g(i, hhVar, com.ss.android.socialbase.downloader.g.gz.MAIN, true);
    }

    @Deprecated
    public void z(int i, hh hhVar, boolean z) {
        if (hhVar == null) {
            return;
        }
        a.z().z(i, hhVar, com.ss.android.socialbase.downloader.g.gz.MAIN, true, z);
    }

    public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return a.z().z(dlVar);
    }

    public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) {
        return a.z().dl(str);
    }

    public List<com.ss.android.socialbase.downloader.e.dl> a(String str) {
        return a.z().a(str);
    }

    public void z(com.ss.android.socialbase.downloader.a.wp wpVar) {
        a.z().z(wpVar);
    }

    public com.ss.android.socialbase.downloader.a.q wp(int i) {
        return a.z().pf(i);
    }

    public boolean i(int i) {
        return a.z().dl(i).g();
    }

    public js g() {
        return dl.t();
    }

    public void z(js jsVar) {
        dl.z(jsVar);
    }

    public File dl() {
        return z(this.z, true);
    }

    public File a() {
        return z(this.g, false);
    }

    private File z(String str, boolean z) {
        File file;
        File file2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            file = new File(str);
        } catch (Throwable unused) {
        }
        try {
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                if (!z) {
                    return null;
                }
                file.delete();
                file.mkdirs();
            }
            return file;
        } catch (Throwable unused2) {
            file2 = file;
            return file2;
        }
    }

    public void gc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.z = str;
    }
}
