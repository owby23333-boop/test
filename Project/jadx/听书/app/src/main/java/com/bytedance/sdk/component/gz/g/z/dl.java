package com.bytedance.sdk.component.gz.g.z;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.gz.z.gc f747a;
    private final Queue<String> dl;
    private final a g;
    private com.bytedance.sdk.component.gz.g.g.dl.dl gc;
    private final gc z;

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public List<com.bytedance.sdk.component.gz.z.g> z(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, List<String> list) {
        return null;
    }

    public dl(com.bytedance.sdk.component.gz.z.gc gcVar, com.bytedance.sdk.component.gz.g.g.dl.dl dlVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.dl = concurrentLinkedQueue;
        this.f747a = gcVar;
        this.gc = dlVar;
        this.z = new m(concurrentLinkedQueue, this.f747a);
        this.g = new a(this.f747a);
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public synchronized void z(com.bytedance.sdk.component.gz.z.g gVar) {
        if (!com.bytedance.sdk.component.gz.g.dl.z.fo(gVar, this.f747a) || !this.gc.a()) {
            this.z.z(gVar);
        }
        if (gVar != null) {
            this.g.z(gVar);
        }
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public synchronized g z(int i, List<com.bytedance.sdk.component.gz.z.g> list, int i2) {
        g gVarZ;
        try {
            Iterator<com.bytedance.sdk.component.gz.z.g> it = list.iterator();
            while (it.hasNext()) {
                this.dl.remove(it.next().dl());
            }
        } catch (Throwable th) {
            g gVar = new g();
            gVar.z(false);
            gVar.z("sending exception:" + th.getMessage());
            com.bytedance.sdk.component.gz.g.dl.dl.dl(th.getMessage(), this.f747a);
        }
        try {
            this.z.z(i, list, i2);
        } catch (Throwable th2) {
            g gVar2 = new g();
            gVar2.z(false);
            gVar2.z("mem exception:" + th2.getMessage());
            com.bytedance.sdk.component.gz.g.dl.dl.dl(th2.getMessage(), this.f747a);
        }
        try {
            gVarZ = this.g.z(i, list, i2);
        } catch (Exception e) {
            g gVar3 = new g();
            gVar3.z(false);
            gVar3.z("db exception:" + e.getMessage());
            com.bytedance.sdk.component.gz.g.dl.dl.dl(e.getMessage(), this.f747a);
            gVarZ = gVar3;
        }
        return gVarZ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public synchronized List<com.bytedance.sdk.component.gz.z.g> z(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, String str) {
        List list;
        boolean z2;
        List<com.bytedance.sdk.component.gz.z.g> listZ = this.z.z(i, gVar, z, (List<String>) null);
        if (listZ != null && listZ.size() != 0) {
            int size = listZ.size();
            list = listZ;
            if (com.bytedance.sdk.component.gz.g.dl.z.z(i)) {
                List<com.bytedance.sdk.component.gz.z.g> listZ2 = this.g.z((com.bytedance.sdk.component.gz.z.g) listZ.get(0), size, i, z);
                list = listZ;
                if (listZ2 != null) {
                    list = listZ;
                    if (listZ2.size() != 0) {
                        listZ2.size();
                        HashMap map = new HashMap();
                        for (com.bytedance.sdk.component.gz.z.g gVar2 : listZ2) {
                            map.put(gVar2.dl(), gVar2);
                        }
                        ArrayList arrayList = new ArrayList(this.dl);
                        arrayList.size();
                        for (com.bytedance.sdk.component.gz.z.g gVar3 : listZ2) {
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (TextUtils.equals(gVar3.dl(), (String) it.next())) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (z2) {
                                map.remove(gVar3.dl());
                            }
                        }
                        for (com.bytedance.sdk.component.gz.z.g gVar4 : listZ) {
                            map.put(gVar4.dl(), gVar4);
                        }
                        listZ.clear();
                        Set setKeySet = map.keySet();
                        map.size();
                        Iterator it2 = setKeySet.iterator();
                        while (it2.hasNext()) {
                            listZ.add(map.get((String) it2.next()));
                        }
                        listZ2.clear();
                        list = listZ;
                    }
                }
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.dl);
            int size2 = arrayList2.size();
            List<com.bytedance.sdk.component.gz.z.g> listZ3 = this.g.z(i, gVar, z, arrayList2);
            if (listZ3 != null && listZ3.size() != 0) {
                listZ3.size();
                HashMap map2 = new HashMap();
                for (com.bytedance.sdk.component.gz.z.g gVar5 : listZ3) {
                    map2.put(gVar5.dl(), gVar5);
                }
                if (size2 != 0) {
                    for (String str2 : arrayList2) {
                        if (map2.get(str2) != null) {
                            map2.remove(str2);
                        }
                    }
                }
                listZ3.clear();
                Set setKeySet2 = map2.keySet();
                map2.size();
                Iterator it3 = setKeySet2.iterator();
                while (it3.hasNext()) {
                    listZ3.add(map2.get((String) it3.next()));
                }
            }
            list = listZ3;
        }
        if (list != null && !list.isEmpty()) {
            list.size();
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                this.dl.offer(((com.bytedance.sdk.component.gz.z.g) it4.next()).dl());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.bytedance.sdk.component.gz.g.z.gc
    public synchronized boolean z(int i, String str, com.bytedance.sdk.component.gz.z.g gVar) {
        if (this.z.z(i, str, gVar)) {
            com.bytedance.sdk.component.gz.g.dl.dl.g("_opt", "cacheManager check result : memory meet ".concat(String.valueOf(str)), this.f747a);
            return true;
        }
        if (!com.bytedance.sdk.component.gz.g.dl.z.z(i) || !this.g.z(i, str, gVar)) {
            return false;
        }
        com.bytedance.sdk.component.gz.g.dl.dl.g("_opt", "cacheManager check result : db meet ".concat(String.valueOf(str)), this.f747a);
        return true;
    }
}
