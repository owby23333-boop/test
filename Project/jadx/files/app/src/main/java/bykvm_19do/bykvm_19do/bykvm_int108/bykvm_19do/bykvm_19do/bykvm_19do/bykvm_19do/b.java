package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<String> f1817c = new ConcurrentLinkedQueue();
    private final d a = new f(this.f1817c);
    private final c b = new c();

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> a(int i2, int i3) {
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listA;
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> listB;
        boolean z2;
        synchronized (this) {
            listA = this.a.a(i2, i3);
            if (listA == null || listA.size() == 0) {
                listA = this.b.a(i2, i3);
                if (listA != null && listA.size() != 0) {
                    HashMap map = new HashMap();
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : listA) {
                        map.put(aVar.i(), aVar);
                    }
                    ArrayList<String> arrayList = new ArrayList(this.f1817c);
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("allSendingQueue:" + arrayList.size());
                    if (arrayList.size() != 0) {
                        for (String str : arrayList) {
                            if (map.get(str) != null) {
                                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("db duplicate delete");
                                map.remove(str);
                            }
                        }
                    }
                    listA.clear();
                    Iterator it = map.keySet().iterator();
                    while (it.hasNext()) {
                        listA.add(map.get((String) it.next()));
                    }
                }
            } else {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("memory get " + listA.size());
                if ((i2 == 1 || i2 == 2) && (listB = this.b.b((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a) listA.get(0), listA.size())) != null && listB.size() != 0) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("db get " + listB.size());
                    HashMap map2 = new HashMap();
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar2 : listB) {
                        map2.put(aVar2.i(), aVar2);
                    }
                    ArrayList arrayList2 = new ArrayList(this.f1817c);
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar3 : listB) {
                        Iterator it2 = arrayList2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z2 = false;
                                break;
                            }
                            if (TextUtils.equals(aVar3.i(), (String) it2.next())) {
                                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(" duplicate delete ");
                                z2 = true;
                                break;
                            }
                        }
                        if (z2) {
                            map2.remove(aVar3.i());
                        }
                    }
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar4 : listA) {
                        map2.put(aVar4.i(), aVar4);
                    }
                    listA.clear();
                    Iterator it3 = map2.keySet().iterator();
                    while (it3.hasNext()) {
                        listA.add(map2.get((String) it3.next()));
                    }
                }
            }
            if (listA == null || listA.isEmpty()) {
                listA = new ArrayList();
            } else {
                Iterator it4 = listA.iterator();
                while (it4.hasNext()) {
                    this.f1817c.offer(((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a) it4.next()).i());
                }
            }
        }
        return listA;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        synchronized (this) {
            ArrayList<String> arrayList = new ArrayList(this.f1817c.size());
            arrayList.addAll(this.f1817c);
            for (String str : arrayList) {
                Iterator<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> it = list.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(str, it.next().i())) {
                        this.f1817c.remove(str);
                    }
                }
            }
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(i2, list);
            }
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i2, list);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        d dVar;
        c cVar;
        synchronized (this) {
            if (i2 != 5) {
                if (j.l().b().a(j.l().d()) && (dVar = this.a) != null && aVar != null) {
                    dVar.a(aVar, i2);
                }
                cVar = this.b;
                if (cVar != null && aVar != null) {
                    cVar.a(aVar, i2);
                }
            } else {
                cVar = this.b;
                if (cVar != null) {
                    cVar.a(aVar, i2);
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public boolean a(int i2, boolean z2) {
        boolean z3;
        AtomicLong atomicLongS;
        synchronized (this) {
            z3 = true;
            if (this.a.a(i2, z2)) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("memory meet");
                atomicLongS = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.E();
            } else if ((i2 == 1 || i2 == 2) && this.b.a(i2, z2)) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("db meet");
                atomicLongS = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1895h.s();
            } else {
                z3 = false;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(atomicLongS, 1);
        }
        return z3;
    }
}
