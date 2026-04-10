package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class kb implements com.ss.android.socialbase.downloader.downloader.wp {
    private final SparseArray<com.ss.android.socialbase.downloader.e.dl> z = new SparseArray<>();
    private final SparseArray<List<com.ss.android.socialbase.downloader.e.g>> g = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.kb.fo>> dl = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean a() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(com.ss.android.socialbase.downloader.e.g gVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean gc() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, int i2, int i3, int i4) {
    }

    public SparseArray<com.ss.android.socialbase.downloader.e.dl> z() {
        return this.z;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.e.g>> m() {
        return this.g;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl e(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.a(2);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized com.ss.android.socialbase.downloader.e.dl g(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVar;
        try {
            dlVar = this.z.get(i);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            dlVar = null;
        }
        return dlVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.z.size();
            for (int i = 0; i < size; i++) {
                com.ss.android.socialbase.downloader.e.dl dlVarValueAt = this.z.valueAt(i);
                if (str != null && str.equals(dlVarValueAt.uy())) {
                    arrayList.add(dlVarValueAt);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.z.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.z.size(); i++) {
            com.ss.android.socialbase.downloader.e.dl dlVar = this.z.get(this.z.keyAt(i));
            if (dlVar != null && !TextUtils.isEmpty(dlVar.yt()) && dlVar.yt().equals(str) && com.ss.android.socialbase.downloader.g.m.e(dlVar.p())) {
                arrayList.add(dlVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized List<com.ss.android.socialbase.downloader.e.dl> dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.z.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.z.size(); i++) {
            com.ss.android.socialbase.downloader.e.dl dlVar = this.z.get(this.z.keyAt(i));
            if (dlVar != null && !TextUtils.isEmpty(dlVar.yt()) && dlVar.yt().equals(str) && dlVar.p() == -3) {
                arrayList.add(dlVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized List<com.ss.android.socialbase.downloader.e.dl> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.z.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.z.size(); i++) {
            com.ss.android.socialbase.downloader.e.dl dlVar = this.z.get(this.z.keyAt(i));
            if (dlVar != null && !TextUtils.isEmpty(dlVar.yt()) && dlVar.yt().equals(str) && com.ss.android.socialbase.downloader.g.m.m(dlVar.p())) {
                arrayList.add(dlVar);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized List<com.ss.android.socialbase.downloader.e.dl> g() {
        if (this.z.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.z.size());
        for (int i = 0; i < this.z.size(); i++) {
            com.ss.android.socialbase.downloader.e.dl dlVarValueAt = this.z.valueAt(i);
            if (dlVarValueAt != null) {
                arrayList.add(dlVarValueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized List<com.ss.android.socialbase.downloader.e.g> dl(int i) {
        return this.g.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized void a(int i) {
        this.g.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(com.ss.android.socialbase.downloader.e.g gVar) {
        int iKb = gVar.kb();
        List<com.ss.android.socialbase.downloader.e.g> arrayList = this.g.get(iKb);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.g.put(iKb, arrayList);
        }
        arrayList.add(gVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized void z(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.e.g> listDl = dl(i);
        if (listDl == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.e.g gVar : listDl) {
            if (gVar != null && gVar.js() == i2) {
                gVar.g(j);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r0.e() == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r3 = r0.e().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        if (r3.hasNext() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r5 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        if (r5.js() != r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        r5.g(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        return;
     */
    @Override // com.ss.android.socialbase.downloader.downloader.wp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void z(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.dl(r3)     // Catch: java.lang.Throwable -> L52
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L52
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L50
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L52
            com.ss.android.socialbase.downloader.e.g r0 = (com.ss.android.socialbase.downloader.e.g) r0     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto Ld
            int r1 = r0.js()     // Catch: java.lang.Throwable -> L52
            if (r1 != r5) goto Ld
            boolean r1 = r0.m()     // Catch: java.lang.Throwable -> L52
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.e()     // Catch: java.lang.Throwable -> L52
            if (r3 == 0) goto L50
            java.util.List r3 = r0.e()     // Catch: java.lang.Throwable -> L52
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L52
        L35:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L52
            if (r5 == 0) goto L4e
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L52
            com.ss.android.socialbase.downloader.e.g r5 = (com.ss.android.socialbase.downloader.e.g) r5     // Catch: java.lang.Throwable -> L52
            if (r5 == 0) goto L35
            int r0 = r5.js()     // Catch: java.lang.Throwable -> L52
            if (r0 != r4) goto L35
            r5.g(r6)     // Catch: java.lang.Throwable -> L52
            monitor-exit(r2)
            return
        L4e:
            monitor-exit(r2)
            return
        L50:
            monitor-exit(r2)
            return
        L52:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.kb.z(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized com.ss.android.socialbase.downloader.e.dl z(int i, int i2) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.gc(i2);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        boolean z = true;
        if (dlVar == null) {
            return true;
        }
        if (this.z.get(dlVar.e()) == null) {
            z = false;
        }
        this.z.put(dlVar.e(), dlVar);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized boolean gc(int i) {
        this.z.remove(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean m(int i) {
        gc(i);
        a(i);
        i(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized void dl() {
        this.z.clear();
        this.g.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl z(int i, long j, String str, String str2) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.e(j);
            dlVarG.gc(str);
            if (TextUtils.isEmpty(dlVarG.gz()) && !TextUtils.isEmpty(str2)) {
                dlVarG.m(str2);
            }
            dlVarG.a(3);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl z(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.z(j, false);
            if (dlVarG.p() != -3 && dlVarG.p() != -2 && !com.ss.android.socialbase.downloader.g.m.e(dlVarG.p()) && dlVarG.p() != -4) {
                dlVarG.a(4);
            }
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl g(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.z(j, false);
            dlVarG.a(-1);
            dlVarG.fo(false);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl gz(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.a(5);
            dlVarG.fo(false);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl dl(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.z(j, false);
            dlVarG.a(-3);
            dlVarG.fo(false);
            dlVarG.uy(false);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl a(int i, long j) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.z(j, false);
            dlVarG.a(-2);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl fo(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.a(1);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl uy(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarG = g(i);
        if (dlVarG != null) {
            dlVarG.a(-7);
        }
        return dlVarG;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        z(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        if (list == null) {
            return;
        }
        a(i);
        for (com.ss.android.socialbase.downloader.e.g gVar : list) {
            if (gVar != null) {
                z(gVar);
                if (gVar.m()) {
                    Iterator<com.ss.android.socialbase.downloader.e.g> it = gVar.e().iterator();
                    while (it.hasNext()) {
                        z(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized List<com.ss.android.socialbase.downloader.kb.fo> v(int i) {
        Map<Long, com.ss.android.socialbase.downloader.kb.fo> map = this.dl.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized Map<Long, com.ss.android.socialbase.downloader.kb.fo> wp(int i) {
        return this.dl.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized boolean z(int i, Map<Long, com.ss.android.socialbase.downloader.kb.fo> map) {
        this.dl.put(i, map);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public synchronized void i(int i) {
        this.dl.remove(i);
    }
}
