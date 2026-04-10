package com.ss.android.socialbase.downloader.e;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.js;
import com.ss.android.socialbase.downloader.a.l;
import com.ss.android.socialbase.downloader.a.pf;
import com.ss.android.socialbase.downloader.a.q;
import com.ss.android.socialbase.downloader.a.sy;
import com.ss.android.socialbase.downloader.a.uf;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.a.v;
import com.ss.android.socialbase.downloader.downloader.fo;
import com.ss.android.socialbase.downloader.downloader.tb;
import com.ss.android.socialbase.downloader.downloader.uy;
import com.ss.android.socialbase.downloader.e.dl;
import com.ss.android.socialbase.downloader.g.gz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<gz, hh> f2064a;
    private uy dl;
    private final SparseArray<hh> e;
    private gk fo;
    private boolean fv;
    private fo g;
    private final SparseArray<gz> gc;
    private final SparseArray<hh> gz;
    private dl.z i;
    private boolean iq;
    private q js;
    private pf kb;
    private tb ls;
    private final SparseArray<hh> m;
    private un p;
    private js pf;
    private int q;
    private final List<v> tb;
    private sy uy;
    private uf v;
    private l wp;
    private dl z;

    public dl z() {
        return this.z;
    }

    public a() {
        this.f2064a = new ConcurrentHashMap();
        this.gc = new SparseArray<>();
        this.fv = false;
        this.tb = new ArrayList();
        this.iq = true;
        this.i = new dl.z();
        this.m = new SparseArray<>();
        this.e = new SparseArray<>();
        this.gz = new SparseArray<>();
    }

    public a(dl dlVar) {
        this();
        this.z = dlVar;
    }

    public boolean g() {
        return this.fv;
    }

    public void z(boolean z) {
        this.fv = z;
    }

    public sy dl() {
        return this.uy;
    }

    public pf a() {
        return this.kb;
    }

    public l gc() {
        return this.wp;
    }

    public uy m() {
        return this.dl;
    }

    public tb e() {
        return this.ls;
    }

    public uf gz() {
        return this.v;
    }

    public js fo() {
        return this.pf;
    }

    public gk uy() {
        return this.fo;
    }

    public un kb() {
        return this.p;
    }

    public int wp() {
        return this.q;
    }

    public boolean i() {
        return this.iq;
    }

    public q v() {
        return this.js;
    }

    public boolean pf() {
        dl dlVar = this.z;
        if (dlVar != null) {
            return dlVar.k();
        }
        return false;
    }

    public a z(uy uyVar) {
        this.dl = uyVar;
        return this;
    }

    public a z(fo foVar) {
        this.g = foVar;
        return this;
    }

    public a z(tb tbVar) {
        this.ls = tbVar;
        return this;
    }

    public a z(hh hhVar) {
        return hhVar == null ? this : z(hhVar.hashCode(), hhVar);
    }

    public a z(int i, hh hhVar) {
        if (hhVar != null) {
            synchronized (this.m) {
                this.m.put(i, hhVar);
            }
            this.f2064a.put(gz.MAIN, hhVar);
            synchronized (this.gc) {
                this.gc.put(i, gz.MAIN);
            }
        }
        return this;
    }

    public a g(int i, hh hhVar) {
        if (hhVar != null) {
            synchronized (this.e) {
                this.e.put(i, hhVar);
            }
            this.f2064a.put(gz.SUB, hhVar);
            synchronized (this.gc) {
                this.gc.put(i, gz.SUB);
            }
        }
        return this;
    }

    public a g(hh hhVar) {
        return hhVar == null ? this : dl(hhVar.hashCode(), hhVar);
    }

    public a dl(int i, hh hhVar) {
        if (hhVar != null) {
            synchronized (this.gz) {
                this.gz.put(i, hhVar);
            }
            this.f2064a.put(gz.NOTIFICATION, hhVar);
            synchronized (this.gc) {
                this.gc.put(i, gz.NOTIFICATION);
            }
        }
        return this;
    }

    public a z(gk gkVar) {
        this.fo = gkVar;
        return this;
    }

    public a z(sy syVar) {
        this.uy = syVar;
        return this;
    }

    public a z(pf pfVar) {
        this.kb = pfVar;
        return this;
    }

    public a z(l lVar) {
        this.wp = lVar;
        return this;
    }

    public a z(un unVar) {
        this.p = unVar;
        return this;
    }

    public a z(uf ufVar) {
        this.v = ufVar;
        return this;
    }

    public a z(js jsVar) {
        this.pf = jsVar;
        return this;
    }

    public a z(String str) {
        this.i.z(str);
        return this;
    }

    public a g(String str) {
        this.i.g(str);
        return this;
    }

    public a dl(String str) {
        this.i.dl(str);
        return this;
    }

    public a a(String str) {
        this.i.gc(str);
        return this;
    }

    public a gc(String str) {
        this.i.m(str);
        return this;
    }

    public a g(boolean z) {
        this.i.z(z);
        return this;
    }

    public a z(List<gc> list) {
        this.i.z(list);
        return this;
    }

    public a z(int i) {
        this.i.z(i);
        return this;
    }

    public a g(int i) {
        this.i.g(i);
        return this;
    }

    public a dl(boolean z) {
        this.i.g(z);
        return this;
    }

    public a dl(int i) {
        this.i.dl(i);
        return this;
    }

    public a a(int i) {
        this.i.a(i);
        return this;
    }

    public a g(List<String> list) {
        this.i.g(list);
        return this;
    }

    public a m(String str) {
        this.i.e(str);
        return this;
    }

    public a a(boolean z) {
        this.i.a(z);
        return this;
    }

    public a gc(boolean z) {
        this.i.dl(z);
        return this;
    }

    public a m(boolean z) {
        this.i.gc(z);
        return this;
    }

    public a e(boolean z) {
        this.i.m(z);
        return this;
    }

    public a e(String str) {
        this.i.gz(str);
        return this;
    }

    public a gz(String str) {
        this.i.fo(str);
        return this;
    }

    public a z(long j) {
        this.i.z(j);
        return this;
    }

    public a gz(boolean z) {
        this.i.fo(z);
        return this;
    }

    public a fo(String str) {
        this.i.uy(str);
        return this;
    }

    public a fo(boolean z) {
        this.i.e(z);
        return this;
    }

    public a uy(boolean z) {
        this.i.uy(z);
        return this;
    }

    public a kb(boolean z) {
        this.i.i(z);
        return this;
    }

    public a wp(boolean z) {
        this.i.gz(z);
        return this;
    }

    public a i(boolean z) {
        this.i.kb(z);
        return this;
    }

    public a z(com.ss.android.socialbase.downloader.g.e eVar) {
        this.i.z(eVar);
        return this;
    }

    public a v(boolean z) {
        this.i.wp(z);
        return this;
    }

    public a z(q qVar) {
        this.js = qVar;
        return this;
    }

    public a z(JSONObject jSONObject) {
        this.i.z(jSONObject);
        return this;
    }

    public a uy(String str) {
        this.i.wp(str);
        return this;
    }

    public a kb(String str) {
        this.i.a(str);
        return this;
    }

    public a gc(int i) {
        this.i.gc(i);
        return this;
    }

    public a g(long j) {
        this.i.g(j);
        return this;
    }

    public a pf(boolean z) {
        this.i.v(z);
        return this;
    }

    public a wp(String str) {
        this.i.kb(str);
        return this;
    }

    public a z(int[] iArr) {
        this.i.z(iArr);
        return this;
    }

    public a ls(boolean z) {
        this.i.pf(z);
        return this;
    }

    public a p(boolean z) {
        this.i.ls(z);
        return this;
    }

    public int ls() {
        this.z = this.i.z();
        dl dlVarG = com.ss.android.socialbase.downloader.downloader.dl.io().g(this.z.e());
        if (dlVarG == null) {
            this.z.hy();
            com.ss.android.socialbase.downloader.gz.z.z(this, (com.ss.android.socialbase.downloader.gc.z) null, 0);
        } else {
            this.z.z(dlVarG);
        }
        iq();
        com.ss.android.socialbase.downloader.downloader.a.z().z(this);
        dl dlVar = this.z;
        if (dlVar == null) {
            return 0;
        }
        return dlVar.e();
    }

    public int p() {
        dl dlVar = this.z;
        if (dlVar == null) {
            return 0;
        }
        return dlVar.e();
    }

    public void fv() {
        com.ss.android.socialbase.downloader.m.z.g("DownloadTask", "same task just tryDownloading, so add listener in last task instead of tryDownload");
        dl dlVar = this.z;
        if (dlVar != null && !dlVar.zz()) {
            this.z.z(true);
        }
        a(gz.MAIN);
        a(gz.SUB);
        com.ss.android.socialbase.downloader.gz.z.z(this.wp, this.z, new com.ss.android.socialbase.downloader.gc.z(1003, "has another same task, add Listener to old task"), 0);
    }

    private void a(gz gzVar) {
        SparseArray<hh> sparseArrayZ = z(gzVar);
        synchronized (sparseArrayZ) {
            for (int i = 0; i < sparseArrayZ.size(); i++) {
                hh hhVar = sparseArrayZ.get(sparseArrayZ.keyAt(i));
                if (hhVar != null) {
                    com.ss.android.socialbase.downloader.downloader.a.z().g(p(), hhVar, gzVar, false);
                }
            }
        }
    }

    public SparseArray<hh> z(gz gzVar) {
        if (gzVar == gz.MAIN) {
            return this.m;
        }
        if (gzVar == gz.SUB) {
            return this.e;
        }
        if (gzVar == gz.NOTIFICATION) {
            return this.gz;
        }
        return null;
    }

    public int g(gz gzVar) {
        int size;
        SparseArray<hh> sparseArrayZ = z(gzVar);
        if (sparseArrayZ == null) {
            return 0;
        }
        synchronized (sparseArrayZ) {
            size = sparseArrayZ.size();
        }
        return size;
    }

    public hh z(gz gzVar, int i) {
        SparseArray<hh> sparseArrayZ = z(gzVar);
        if (sparseArrayZ == null || i < 0) {
            return null;
        }
        synchronized (sparseArrayZ) {
            if (i >= sparseArrayZ.size()) {
                return null;
            }
            return sparseArrayZ.get(sparseArrayZ.keyAt(i));
        }
    }

    public synchronized int js() {
        hh hhVarDl = dl(gz.MAIN);
        if (hhVarDl == null) {
            hhVarDl = dl(gz.SUB);
        }
        if (hhVarDl != null) {
            this.q = hhVarDl.hashCode();
        }
        return this.q;
    }

    public hh dl(gz gzVar) {
        return this.f2064a.get(gzVar);
    }

    public void z(int i, hh hhVar, gz gzVar, boolean z) {
        int iIndexOfValue;
        SparseArray<hh> sparseArrayZ = z(gzVar);
        if (sparseArrayZ == null) {
            if (z && this.f2064a.containsKey(gzVar)) {
                this.f2064a.remove(gzVar);
                return;
            }
            return;
        }
        synchronized (sparseArrayZ) {
            if (z) {
                if (this.f2064a.containsKey(gzVar)) {
                    hhVar = this.f2064a.get(gzVar);
                    this.f2064a.remove(gzVar);
                }
                if (hhVar != null && (iIndexOfValue = sparseArrayZ.indexOfValue(hhVar)) >= 0 && iIndexOfValue < sparseArrayZ.size()) {
                    sparseArrayZ.removeAt(iIndexOfValue);
                }
            } else {
                sparseArrayZ.remove(i);
                synchronized (this.gc) {
                    gz gzVar2 = this.gc.get(i);
                    if (gzVar2 != null && this.f2064a.containsKey(gzVar2)) {
                        this.f2064a.remove(gzVar2);
                        this.gc.remove(i);
                    }
                }
            }
        }
    }

    public void g(int i, hh hhVar, gz gzVar, boolean z) {
        Map<gz, hh> map;
        if (hhVar == null) {
            return;
        }
        if (z && (map = this.f2064a) != null) {
            map.put(gzVar, hhVar);
            synchronized (this.gc) {
                this.gc.put(i, gzVar);
            }
        }
        SparseArray<hh> sparseArrayZ = z(gzVar);
        if (sparseArrayZ == null) {
            return;
        }
        synchronized (sparseArrayZ) {
            sparseArrayZ.put(i, hhVar);
        }
    }

    private void z(SparseArray<hh> sparseArray, SparseArray<hh> sparseArray2) {
        sparseArray.clear();
        for (int i = 0; i < sparseArray2.size(); i++) {
            int iKeyAt = sparseArray2.keyAt(i);
            hh hhVar = sparseArray2.get(iKeyAt);
            if (hhVar != null) {
                sparseArray.put(iKeyAt, hhVar);
            }
        }
    }

    public void z(SparseArray<hh> sparseArray, gz gzVar) {
        if (sparseArray == null) {
            return;
        }
        try {
            if (gzVar == gz.MAIN) {
                synchronized (this.m) {
                    z(this.m, sparseArray);
                }
                return;
            } else if (gzVar == gz.SUB) {
                synchronized (this.e) {
                    z(this.e, sparseArray);
                }
                return;
            } else {
                if (gzVar == gz.NOTIFICATION) {
                    synchronized (this.gz) {
                        z(this.gz, sparseArray);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        wp.z(th);
    }

    public void g(gk gkVar) {
        this.fo = gkVar;
    }

    public fo tb() {
        return this.g;
    }

    public void z(a aVar) {
        for (Map.Entry<gz, hh> entry : aVar.f2064a.entrySet()) {
            if (entry != null && !this.f2064a.containsKey(entry.getKey())) {
                this.f2064a.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (aVar.m.size() != 0) {
                synchronized (this.m) {
                    dl(this.m, aVar.m);
                    g(aVar.m, this.m);
                }
            }
            if (aVar.e.size() != 0) {
                synchronized (this.e) {
                    dl(this.e, aVar.e);
                    g(aVar.e, this.e);
                }
            }
            if (aVar.gz.size() != 0) {
                synchronized (this.gz) {
                    dl(this.gz, aVar.gz);
                    g(aVar.gz, this.gz);
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void g(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int iKeyAt = sparseArray.keyAt(i);
            sparseArray2.put(iKeyAt, sparseArray.get(iKeyAt));
        }
    }

    private void dl(SparseArray sparseArray, SparseArray sparseArray2) {
        if (sparseArray == null || sparseArray2 == null) {
            return;
        }
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.remove(sparseArray2.keyAt(i));
        }
    }

    public List<v> q() {
        return this.tb;
    }

    public v m(int i) {
        synchronized (this.tb) {
            if (i >= this.tb.size()) {
                return null;
            }
            return this.tb.get(i);
        }
    }

    public a z(v vVar) {
        synchronized (this.tb) {
            if (vVar != null) {
                if (!this.tb.contains(vVar)) {
                    this.tb.add(vVar);
                    return this;
                }
            }
            return this;
        }
    }

    public a dl(List<v> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<v> it = list.iterator();
            while (it.hasNext()) {
                z(it.next());
            }
        }
        return this;
    }

    private void iq() {
        if (this.z.ep() > 0) {
            z(new uy() { // from class: com.ss.android.socialbase.downloader.e.a.1
                @Override // com.ss.android.socialbase.downloader.downloader.uy
                public int z(long j) {
                    return 1;
                }
            });
        }
    }
}
