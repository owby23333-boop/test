package com.kwai.filedownloader;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class r {
    private static final Object aEK = new Object();
    private static final Object aEM = new Object();
    private w aEL;
    private volatile v aEN;

    static final class a {
        private static final r aEO = new r();
    }

    public static r Hd() {
        return a.aEO;
    }

    public static boolean Hf() {
        return n.GV().isConnected();
    }

    public static void a(Context context, c.b bVar) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(r.class, "init Downloader with params: %s %s", context, bVar);
        }
        if (context == null) {
            throw new IllegalArgumentException("the provided context must not be null!");
        }
        com.kwai.filedownloader.e.c.dy(context.getApplicationContext());
        com.kwai.filedownloader.download.b.Ht().a(bVar);
    }

    private static void a(e eVar) {
        f.GI().a("event.service.connect.changed", eVar);
    }

    private int cz(int i2) {
        List<a.InterfaceC0461a> listCu = h.GK().cu(i2);
        if (listCu.isEmpty()) {
            com.kwai.filedownloader.e.d.h(this, "request pause but not exist %d", Integer.valueOf(i2));
            return 0;
        }
        Iterator<a.InterfaceC0461a> it = listCu.iterator();
        while (it.hasNext()) {
            it.next().Gm().pause();
        }
        return listCu.size();
    }

    public static void dx(Context context) {
        com.kwai.filedownloader.e.c.dy(context.getApplicationContext());
    }

    public static com.kwai.filedownloader.a eV(String str) {
        return new c(str);
    }

    public final void He() {
        if (Hf()) {
            return;
        }
        n.GV().dw(com.kwai.filedownloader.e.c.IN());
    }

    final w Hg() {
        if (this.aEL == null) {
            synchronized (aEK) {
                if (this.aEL == null) {
                    this.aEL = new ab();
                }
            }
        }
        return this.aEL;
    }

    final v Hh() {
        if (this.aEN == null) {
            synchronized (aEM) {
                if (this.aEN == null) {
                    this.aEN = new z();
                    a((e) this.aEN);
                }
            }
        }
        return this.aEN;
    }

    public final boolean m(int i2, String str) {
        cz(i2);
        if (!n.GV().cy(i2)) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        File file = new File(com.kwai.filedownloader.e.f.fk(str));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str);
        if (file2.exists()) {
            file2.delete();
        }
        return true;
    }
}
