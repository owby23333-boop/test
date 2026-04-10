package com.kwad.framework.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class r {
    private static final Object amu = new Object();
    private static final Object amw = new Object();
    private w amv;
    private volatile v amx;

    public static void aH(Context context) {
        com.kwad.framework.filedownloader.f.c.aI(context.getApplicationContext());
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwad.framework.filedownloader.f.c.aI(context.getApplicationContext());
        com.kwad.framework.filedownloader.download.b.yc().a(bVar);
    }

    static final class a {
        private static final r amy = new r();
    }

    public static r xI() {
        return a.amy;
    }

    public static com.kwad.framework.filedownloader.a bm(String str) {
        return new c(str);
    }

    private int bz(int i) {
        List<a.InterfaceC0370a> listBu = h.xp().bu(i);
        if (listBu.isEmpty()) {
            com.kwad.framework.filedownloader.f.d.d(this, "request pause but not exist %d", Integer.valueOf(i));
            return 0;
        }
        Iterator<a.InterfaceC0370a> it = listBu.iterator();
        while (it.hasNext()) {
            it.next().wR().pause();
        }
        return listBu.size();
    }

    public final boolean q(int i, String str) {
        bz(i);
        if (!n.xA().by(i)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(com.kwad.framework.filedownloader.f.f.bD(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        return true;
    }

    public final void xJ() {
        if (xK()) {
            return;
        }
        n.xA().aG(com.kwad.framework.filedownloader.f.c.zz());
    }

    public static boolean xK() {
        return n.xA().isConnected();
    }

    private static void a(e eVar) {
        f.xn().a("event.service.connect.changed", eVar);
    }

    final w xL() {
        if (this.amv == null) {
            synchronized (amu) {
                if (this.amv == null) {
                    this.amv = new ab();
                }
            }
        }
        return this.amv;
    }

    final v xM() {
        if (this.amx == null) {
            synchronized (amw) {
                if (this.amx == null) {
                    this.amx = new z();
                    a((e) this.amx);
                }
            }
        }
        return this.amx;
    }
}
