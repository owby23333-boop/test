package com.ss.android.socialbase.downloader.fo.z;

import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.e.gc;
import com.ss.android.socialbase.downloader.pf.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    private final Map<String, a> dl;
    private final Map<String, dl> g;
    protected int z;

    void z(String str, dl dlVar) {
        synchronized (this.g) {
            this.g.put(str, dlVar);
        }
    }

    void z(int i) {
        this.z = i;
    }

    public dl z(String str, List<gc> list) {
        dl dlVarRemove;
        synchronized (this.g) {
            dlVarRemove = this.g.remove(str);
        }
        if (dlVarRemove == null) {
            return null;
        }
        if (m.z(dlVarRemove.gz(), list)) {
            try {
                dlVarRemove.a();
            } catch (InterruptedException e) {
                wp.z(e);
            }
            if (dlVarRemove.m() && dlVarRemove.gc()) {
                return dlVarRemove;
            }
        }
        try {
            dlVarRemove.dl();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean z(String str) {
        dl dlVar = this.g.get(str);
        if (dlVar != null) {
            if (dlVar.e()) {
                return true;
            }
            if (dlVar.m() && dlVar.gc()) {
                return true;
            }
        }
        return false;
    }

    public a g(String str, List<gc> list) {
        a aVarRemove;
        synchronized (this.dl) {
            aVarRemove = this.dl.remove(str);
        }
        if (aVarRemove == null) {
            return null;
        }
        if (m.z(aVarRemove.m(), list)) {
            try {
                aVarRemove.gc();
            } catch (InterruptedException e) {
                wp.z(e);
            }
            if (aVarRemove.gz() && aVarRemove.e()) {
                return aVarRemove;
            }
        }
        try {
            aVarRemove.a();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.fo.z.z$z, reason: collision with other inner class name */
    private static final class C0478z {
        private static final z z = new z();
    }

    public static z z() {
        return C0478z.z;
    }

    private z() {
        this.g = new HashMap();
        this.dl = new LinkedHashMap(3);
        this.z = 3;
    }
}
