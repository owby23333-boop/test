package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public final Map<Integer, Boolean> a = new HashMap();
    private final Map<Integer, AtomicInteger> b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f1658c = new AtomicInteger();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f1659d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f1660e = new AtomicInteger();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<Integer> f1661f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f1662g = new AtomicInteger();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<String> f1663h = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f1664i = new AtomicBoolean(false);

    void a() {
        synchronized (this) {
            if (this.f1662g.get() != 0) {
                this.f1662g.decrementAndGet();
            }
        }
    }

    public void a(int i2) {
        AtomicInteger atomicInteger = this.b.get(Integer.valueOf(i2));
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return;
        }
        atomicInteger.decrementAndGet();
    }

    public void a(int i2, int i3) {
        this.b.put(Integer.valueOf(i2), new AtomicInteger(i3));
    }

    public void a(int i2, boolean z2) {
        synchronized (this) {
            Boolean bool = this.a.get(Integer.valueOf(i2));
            if (bool != null && !bool.booleanValue()) {
                this.a.put(Integer.valueOf(i2), Boolean.valueOf(z2));
                this.f1658c.decrementAndGet();
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                this.f1663h.add(str);
            }
            if (this.f1660e.get() != 0) {
                this.f1660e.decrementAndGet();
            } else {
                Logger.e("TTMediationSDK", "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
            }
        }
    }

    public void a(List<Integer> list) {
        if (list != null) {
            this.f1658c.set(list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                this.a.put(it.next(), false);
            }
        }
    }

    void a(List<j> list, List<j> list2, List<j> list3) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            int size = list.size();
            if (list2 != null) {
                size += list2.size();
            }
            if (list3 != null) {
                size += list3.size();
            }
            for (j jVar : list) {
                Iterator<String> it = this.f1663h.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && jVar != null && next.equals(jVar.d())) {
                            size--;
                            break;
                        }
                    }
                }
            }
            if (!h0.a(list2)) {
                for (j jVar2 : list2) {
                    Iterator<String> it2 = this.f1663h.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!TextUtils.isEmpty(next2) && jVar2 != null && next2.equals(jVar2.d())) {
                                size--;
                                break;
                            }
                        }
                    }
                }
            }
            if (!h0.a(list3)) {
                for (j jVar3 : list3) {
                    Iterator<String> it3 = this.f1663h.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            String next3 = it3.next();
                            if (!TextUtils.isEmpty(next3) && jVar3 != null && next3.equals(jVar3.d())) {
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
            this.f1660e.set(size);
        }
    }

    public void a(boolean z2) {
        this.f1659d.set(z2);
    }

    int b() {
        return this.f1662g.get();
    }

    public int b(int i2) {
        AtomicInteger atomicInteger = this.b.get(Integer.valueOf(i2));
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return -1;
    }

    void b(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            AtomicInteger atomicInteger = new AtomicInteger();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                Boolean bool = this.a.get(it.next());
                if (bool == null || !bool.booleanValue()) {
                    atomicInteger.incrementAndGet();
                }
            }
            this.f1658c.set(atomicInteger.get());
        }
    }

    public void b(boolean z2) {
        this.f1664i.set(z2);
    }

    int c() {
        int i2;
        synchronized (this) {
            i2 = this.f1658c.get();
        }
        return i2;
    }

    public boolean c(int i2) {
        Map<Integer, Boolean> map = this.a;
        return (map == null || map.get(Integer.valueOf(i2)) == null || !this.a.get(Integer.valueOf(i2)).booleanValue()) ? false : true;
    }

    int d() {
        int i2;
        synchronized (this) {
            i2 = this.f1660e.get();
        }
        return i2;
    }

    public void d(int i2) {
        this.f1661f.add(Integer.valueOf(i2));
    }

    public void e(int i2) {
        this.f1660e.set(i2);
    }

    public boolean e() {
        return this.f1664i.get();
    }

    void f(int i2) {
        this.f1662g.set(i2);
    }

    public boolean f() {
        return c() == 0 && d() == 0;
    }

    public boolean g() {
        return this.f1659d.get();
    }

    void h() {
        this.f1660e.set(0);
        this.f1658c.set(0);
        this.a.clear();
        this.b.clear();
        this.f1659d.set(false);
        this.f1663h.clear();
        this.f1661f.clear();
        this.f1664i.set(false);
    }
}
