package com.bytedance.sdk.component.gz.g.z.g;

import com.bytedance.sdk.component.gz.z.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z<T extends com.bytedance.sdk.component.gz.z.g> extends com.bytedance.sdk.component.gz.g.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Queue<T> f748a = new ConcurrentLinkedQueue();
    public com.bytedance.sdk.component.gz.z.gc dl;
    public String g;
    private Queue<String> gc;
    public com.bytedance.sdk.component.gz.g.a.g.z z;

    public z(com.bytedance.sdk.component.gz.g.a.g.z zVar, Queue<String> queue, String str, com.bytedance.sdk.component.gz.z.gc gcVar) {
        this.z = zVar;
        this.gc = queue;
        this.dl = gcVar;
        this.g = str;
    }

    public void g(T t) {
        if (this.f748a == null || t == null || !z(t)) {
            return;
        }
        this.f748a.offer(t);
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z
    public List<com.bytedance.sdk.component.gz.z.g> g(int i, com.bytedance.sdk.component.gz.z.g gVar, boolean z, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.f748a.size();
        do {
            T tPoll = this.f748a.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.z.g());
        return arrayList;
    }

    private void g(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.gz.z.g gVar;
        int size = this.f748a.size();
        if ((i == -1 || i == 200 || i == 509 || i == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap map = new HashMap();
            for (T t : this.f748a) {
                if (t != null) {
                    map.put(t.dl(), t);
                }
            }
            for (T t2 : list) {
                if (t2 != null && (gVar = (com.bytedance.sdk.component.gz.z.g) map.get(t2.dl())) != null) {
                    this.f748a.remove(gVar);
                }
            }
        }
        this.f748a.size();
    }

    public com.bytedance.sdk.component.gz.g.z.g z(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.gz.g.z.g gVar = new com.bytedance.sdk.component.gz.g.z.g();
        if (list != null && list.size() != 0 && list.get(0) != null && z(list.get(0))) {
            g(i, list, i2);
            gVar.z(true);
            return gVar;
        }
        gVar.z(false);
        return gVar;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z
    public boolean g(int i, String str, com.bytedance.sdk.component.gz.z.g gVar) {
        int size = this.f748a.size();
        int iZ = this.z.z();
        com.bytedance.sdk.component.gz.g.dl.z.g(i);
        return size >= iZ;
    }

    @Override // com.bytedance.sdk.component.gz.g.z.z
    public boolean z(String str) {
        return this.f748a.size() > 0;
    }
}
