package com.bytedance.msdk.dl.m.z;

import android.text.TextUtils;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.dl.gz.e;
import com.bytedance.msdk.gz.h;
import com.bytedance.msdk.z.gc.dl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private List<Integer> kb;
    private AtomicInteger dl = new AtomicInteger(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f454a = new AtomicBoolean();
    public final Map<Integer, Boolean> z = new HashMap();
    public final Map<Integer, Boolean> g = new HashMap();
    private final Map<Integer, AtomicInteger> gc = new HashMap();
    private final AtomicInteger m = new AtomicInteger();
    private final AtomicInteger e = new AtomicInteger();
    private final AtomicInteger gz = new AtomicInteger();
    private final List<String> fo = new CopyOnWriteArrayList();
    private final AtomicInteger uy = new AtomicInteger(-1000);

    public List<Integer> z() {
        return this.kb;
    }

    public void z(List<Integer> list) {
        this.kb = list;
    }

    public synchronized void z(int i) {
        this.dl.set(i);
    }

    public synchronized int g() {
        return this.dl.get();
    }

    public synchronized boolean dl() {
        return g() > 0;
    }

    public synchronized void g(int i) {
        if (this.uy.get() < i) {
            this.uy.set(i);
        }
        this.z.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean dl(int i) {
        Boolean bool = this.z.get(Integer.valueOf(i));
        if (bool != null) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void a(int i) {
        this.g.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean gc(int i) {
        Boolean bool = this.g.get(Integer.valueOf(i));
        if (bool != null) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void a() {
        this.f454a.set(true);
    }

    public synchronized boolean gc() {
        return this.f454a.get();
    }

    public synchronized boolean m() {
        AtomicInteger atomicInteger = this.gc.get(-100);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized boolean e() {
        AtomicInteger atomicInteger = this.gc.get(0);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized void z(int i, int i2) {
        this.gc.put(Integer.valueOf(i), new AtomicInteger(i2));
    }

    public synchronized int m(int i) {
        AtomicInteger atomicInteger = this.gc.get(Integer.valueOf(i));
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public synchronized void e(int i) {
        this.m.set(i);
    }

    public synchronized boolean gz() {
        return this.m.get() == 0;
    }

    public synchronized void gz(int i) {
        this.e.set(i);
    }

    public synchronized boolean fo() {
        return this.e.get() == 0;
    }

    public synchronized void fo(int i) {
        this.gz.set(i);
    }

    public synchronized boolean uy() {
        return this.gz.get() == 0;
    }

    public synchronized void z(int i, String str) {
        AtomicInteger atomicInteger = this.gc.get(Integer.valueOf(i));
        if (atomicInteger != null && atomicInteger.get() != 0) {
            atomicInteger.decrementAndGet();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fo.add(str);
        if (i < -100 && this.e.get() != 0) {
            this.e.decrementAndGet();
        }
        if (i > 0 && this.gz.get() != 0) {
            this.gz.decrementAndGet();
        }
        if (this.m.get() != 0) {
            this.m.decrementAndGet();
        } else {
            dl.a("TTMediationSDK", "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
        }
    }

    public synchronized void z(List<uy> list, List<uy> list2, List<uy> list3) {
        int size;
        if (list != null) {
            if (list.size() != 0) {
                List<uy> listG = e.g(list);
                int i = 0;
                if (h.z(listG)) {
                    size = 0;
                } else {
                    size = listG.size();
                    for (uy uyVar : listG) {
                        Iterator<String> it = this.fo.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                String next = it.next();
                                if (!TextUtils.isEmpty(next) && uyVar != null && next.equals(uyVar.fv())) {
                                    size--;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (size < 0) {
                    size = 0;
                }
                this.gz.set(size);
                int size2 = list.size();
                if (list2 != null) {
                    size2 += list2.size();
                }
                if (list3 != null) {
                    size2 += list3.size();
                }
                for (uy uyVar2 : list) {
                    Iterator<String> it2 = this.fo.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!TextUtils.isEmpty(next2) && uyVar2 != null && next2.equals(uyVar2.fv())) {
                                size2--;
                                break;
                            }
                        }
                    }
                }
                if (!h.z(list2)) {
                    for (uy uyVar3 : list2) {
                        Iterator<String> it3 = this.fo.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                String next3 = it3.next();
                                if (!TextUtils.isEmpty(next3) && uyVar3 != null && next3.equals(uyVar3.fv())) {
                                    size2--;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (!h.z(list3)) {
                    for (uy uyVar4 : list3) {
                        Iterator<String> it4 = this.fo.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                String next4 = it4.next();
                                if (!TextUtils.isEmpty(next4) && uyVar4 != null && next4.equals(uyVar4.fv())) {
                                    size2--;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (size2 >= 0) {
                    i = size2;
                }
                this.m.set(i);
            }
        }
    }

    public synchronized int kb() {
        return this.uy.get();
    }

    public synchronized void wp() {
        this.dl.set(-1);
        this.f454a.set(false);
        this.z.clear();
        this.g.clear();
        this.gc.clear();
        this.m.set(0);
        this.fo.clear();
        this.uy.set(-1000);
    }
}
