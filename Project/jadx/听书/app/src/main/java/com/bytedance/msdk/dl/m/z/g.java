package com.bytedance.msdk.dl.m.z;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.a.kb;
import com.bytedance.msdk.core.gc.g.a;
import com.bytedance.msdk.core.uy.fo;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.g.dl;
import com.bytedance.msdk.gz.h;
import com.bytedance.msdk.gz.v;
import com.bytedance.msdk.z.gc.gc;
import com.bytedance.msdk.z.gc.m;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private long h;
    private a.dl hh;
    private com.bytedance.msdk.core.uy.g i;
    private com.bytedance.msdk.api.z.g kb;
    private com.bytedance.msdk.dl.g.z.z ls;
    protected dl m;
    private String pf;
    private Handler q;
    private z v;
    private kb wp;
    protected SoftReference<Context> z;
    protected CopyOnWriteArrayList<dl> g = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<dl> dl = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected CopyOnWriteArrayList<dl> f453a = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<dl> gc = new CopyOnWriteArrayList<>();
    private final AtomicBoolean p = new AtomicBoolean(false);
    private final AtomicBoolean fv = new AtomicBoolean(false);
    private final AtomicBoolean js = new AtomicBoolean(false);
    private volatile boolean tb = false;
    protected Map<String, com.bytedance.msdk.dl.z.z> e = new ConcurrentHashMap();
    protected long gz = 0;
    private long iq = 0;
    private AtomicBoolean zw = new AtomicBoolean(false);
    private boolean io = false;
    private boolean uf = false;
    private boolean sy = false;
    private final AtomicInteger l = new AtomicInteger(0);
    protected Map<String, Object> fo = new ConcurrentHashMap();
    protected fo uy = new fo();
    private int gk = 0;
    private ConcurrentHashMap<String, com.bytedance.msdk.api.g> x = new ConcurrentHashMap<>();

    private g() {
    }

    public static g z(SoftReference<Context> softReference, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.dl.g.z.z zVar) {
        g gVar2 = new g();
        com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.core.g.g().z(gVar.zw(), gVar.iq(), 100);
        gVar.z(gVarZ);
        gVar2.kb = gVar;
        gVar2.i = gVarZ;
        if (gVarZ != null) {
            gVar2.fo.put("render_control", Integer.valueOf(gVarZ.g()));
        }
        gVar2.kb.a(com.bytedance.msdk.core.g.g().j());
        gVar2.kb.g(com.bytedance.msdk.core.g.g().fo());
        gVar2.kb.z(com.bytedance.msdk.core.e.dl.a());
        gVar2.kb.z(com.bytedance.msdk.core.e.dl.dl());
        gVar2.kb.dl(a.z().g(gVar2.kb.zw(), com.bytedance.msdk.core.g.g().j()));
        gVar2.uy.dl = com.bytedance.msdk.core.g.g().fo();
        gVar2.z = softReference;
        gVar2.ls = zVar;
        gVar2.v = new z();
        return gVar2;
    }

    public void z(int i) {
        this.gk = i;
    }

    public boolean z() {
        return this.p.get();
    }

    public boolean g() {
        return this.fv.get();
    }

    public boolean dl() {
        return this.js.get();
    }

    public void z(final String str) {
        m.a(new Runnable() { // from class: com.bytedance.msdk.dl.m.z.g.1
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.ls != null) {
                    g.this.ls.z(str);
                }
            }
        });
    }

    public void a() {
        ArrayList arrayList;
        ArrayList arrayList2;
        Map<String, Object> map;
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", gc.z(this.i) + " v2 load done..........s:" + z() + "  f:" + g() + "     p.size" + e().size() + "   bidding.size:" + uy().size() + "   normal.size:" + gz().size() + "   underNormal.size:" + fo().size());
        if (z() || g()) {
            return;
        }
        this.p.set(true);
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        List<dl> listTb = tb();
        if ((zw() || (!zw() && !this.uf)) && this.i != null && !this.kb.f() && (this.i.gk() || this.i.x())) {
            dl dlVar = listTb.size() > 0 ? listTb.get(0) : null;
            int iHh = this.kb.hh();
            if (iHh > 1) {
                arrayList = new ArrayList();
                for (int i = 1; i < iHh; i++) {
                    if (i < listTb.size()) {
                        arrayList.add(listTb.get(i));
                    }
                }
                if (listTb.size() > iHh) {
                    arrayList2 = new ArrayList();
                    while (iHh < listTb.size()) {
                        dl dlVar2 = listTb.get(iHh);
                        if (dlVar2 != null && dlVar2.hn()) {
                            arrayList2.add(dlVar2);
                        }
                        iHh++;
                    }
                } else {
                    arrayList2 = null;
                }
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            com.bytedance.msdk.gc.m.z(dlVar, this.kb, arrayList, arrayList2);
        }
        if (!this.kb.f() && !this.uf) {
            com.bytedance.msdk.core.fo.a.z(this.i, !h.g(listTb) ? listTb.get(0).u() : 0.0d, this.kb.zw(), this.kb.iq());
        }
        if (zw()) {
            gc(true);
            return;
        }
        int iHh2 = listTb.size() > this.kb.hh() ? this.kb.hh() : listTb.size();
        com.bytedance.msdk.core.uy.g gVar = this.i;
        if (gVar != null) {
            Map<String, Object> mapM = gVar.m();
            mapM.put("has_serverBidding", Boolean.valueOf(this.i.gk()));
            map = mapM;
        } else {
            map = null;
        }
        if (!iq()) {
            com.bytedance.msdk.api.z.g gVar2 = this.kb;
            dl dlVar3 = this.m;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.gz;
            int iWj = wj();
            int iG = g(this.v.kb());
            com.bytedance.msdk.core.uy.g gVar3 = this.i;
            com.bytedance.msdk.gc.m.z(map, gVar2, dlVar3, jElapsedRealtime, iWj, iG, 0, gVar3 != null ? gVar3.vm() : null, iHh2, this.gk, this.i);
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", gc.z(this.i) + "广告加载成功！给外部回调：invokeAdLoadSuccessOnMainUI........P.size:" + e().size() + "   bidding.size:" + uy().size() + "   normal.size:" + gz().size());
        m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.m.z.g.2
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.ls != null) {
                    g.this.ls.e();
                }
            }
        });
        na();
    }

    public void z(com.bytedance.msdk.api.z zVar) {
        Handler handler;
        if (zVar == null) {
            zVar = new com.bytedance.msdk.api.z(20005, com.bytedance.msdk.api.z.z(20005));
        }
        if ((!com.bytedance.msdk.gz.g.z.z(this.i) || zVar.z != 10003) && (handler = this.q) != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (z() || g()) {
            return;
        }
        this.fv.set(true);
        un().gc = true;
        if (!iq()) {
            com.bytedance.msdk.gc.m.z(this.kb, zVar, this.uy.z);
        }
        if (zw()) {
            gc(false);
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", gc.z(this.i) + "广告加载失败！给外部回调：invokeAdLoadFailCallbackOnMainUI...... error Code = " + zVar.z + " error Message = " + zVar.g);
        final com.bytedance.msdk.api.z zVarZ = v.z(this.kb, zVar, uf());
        m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.m.z.g.3
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.ls != null) {
                    g.this.ls.g(zVarZ);
                }
            }
        });
    }

    public void gc() {
        if (zw() || g() || dl() || !z()) {
            return;
        }
        com.bytedance.msdk.api.z.g gVar = this.kb;
        if (gVar != null && (gVar.iq() == 7 || this.kb.iq() == 8 || this.kb.iq() == 10)) {
            com.bytedance.msdk.z.gc.dl.dl("TTMediationSDK", gc.z(this.i) + "广告缓存成功！给外部回调：invokeAdVideoCacheOnMainUI........");
            com.bytedance.msdk.gc.m.z(this.kb, kb(), SystemClock.elapsedRealtime() - lq());
        }
        this.js.set(true);
        m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.m.z.g.4
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.ls != null) {
                    g.this.ls.gz();
                }
            }
        });
    }

    public void z(final List<dl> list, final com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.core.uy.g gVar = this.i;
        if (gVar == null || !gVar.i()) {
            return;
        }
        if (m()) {
            zVar = new com.bytedance.msdk.api.z(41044, com.bytedance.msdk.api.z.z(41044));
            list = null;
        }
        if (zw()) {
            return;
        }
        if (!h.z(list)) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", gc.z(this.i) + "单个广告加载完成！给外部回调：invokeSingleAdLoadCallbackUI......");
            for (dl dlVar : list) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", gc.z(this.kb.zw(), "fill") + "AdNetWorkName[" + dlVar.zx() + "] AdUnitId[" + dlVar.yz() + "]  请求成功 (loadSort=" + dlVar.xo() + ",showSort=" + dlVar.dt() + ")");
            }
        }
        if (zVar != null) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", gc.z(this.i) + "单个广告加载失败！给外部回调：invokeSingleAdLoadCallbackUI...... errorCode:" + zVar.z + "  errorMsg:" + zVar.g);
        }
        m.dl(new Runnable() { // from class: com.bytedance.msdk.dl.m.z.g.5
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.ls != null) {
                    g.this.ls.z(list, zVar);
                }
            }
        });
    }

    public boolean m() {
        return this.tb;
    }

    public CopyOnWriteArrayList<dl> e() {
        return this.gc;
    }

    public CopyOnWriteArrayList<dl> gz() {
        return this.g;
    }

    public CopyOnWriteArrayList<dl> fo() {
        return this.dl;
    }

    public CopyOnWriteArrayList<dl> uy() {
        return this.f453a;
    }

    public dl kb() {
        return this.m;
    }

    public void z(dl dlVar) {
        this.m = dlVar;
    }

    public com.bytedance.msdk.core.uy.g wp() {
        return this.i;
    }

    public void z(com.bytedance.msdk.core.uy.g gVar) {
        this.i = gVar;
    }

    public z i() {
        return this.v;
    }

    public void z(List<dl> list) {
        dl dlVar;
        if (h.z(list) || (dlVar = list.get(0)) == null) {
            return;
        }
        if (dlVar.o()) {
            this.gc.addAll(list);
            return;
        }
        if (dlVar.cb()) {
            this.g.addAll(list);
        } else if (dlVar.hn() || dlVar.k() || dlVar.wx()) {
            this.f453a.addAll(list);
        }
    }

    public boolean v() {
        int size = this.gc.size();
        com.bytedance.msdk.api.z.g gVar = this.kb;
        return size >= (gVar != null ? gVar.hh() : 1);
    }

    public boolean pf() {
        int size = this.gc.size() + this.g.size();
        com.bytedance.msdk.api.z.g gVar = this.kb;
        return size >= (gVar != null ? gVar.hh() : 1);
    }

    public boolean ls() {
        int size = this.gc.size() + this.g.size() + this.f453a.size();
        com.bytedance.msdk.api.z.g gVar = this.kb;
        return size >= (gVar != null ? gVar.hh() : 1);
    }

    public boolean p() {
        return !this.i.x() || this.v.gc(-100) || this.v.m();
    }

    private boolean oq() {
        return !this.i.gk() || this.v.gc(0) || this.v.e();
    }

    public boolean fv() {
        return p() && oq();
    }

    public com.bytedance.msdk.api.z.g js() {
        return this.kb;
    }

    public Context getContext() {
        return this.z.get();
    }

    public List<dl> tb() {
        ArrayList arrayList = new ArrayList();
        if (!h.z(this.g)) {
            arrayList.addAll(this.g);
        }
        if (!h.z(this.f453a)) {
            arrayList.addAll(this.f453a);
        }
        com.bytedance.msdk.core.e.dl.z(arrayList, com.bytedance.msdk.core.e.dl.z());
        if (!h.z(this.gc)) {
            com.bytedance.msdk.core.e.dl.z(this.gc, (Comparator<dl>) null);
            arrayList.addAll(0, this.gc);
        }
        return arrayList;
    }

    public Map<String, com.bytedance.msdk.dl.z.z> q() {
        return this.e;
    }

    public boolean iq() {
        return this.sy;
    }

    public void z(boolean z) {
        this.sy = z;
    }

    public boolean zw() {
        return this.io;
    }

    public void g(boolean z) {
        this.io = z;
    }

    public void dl(boolean z) {
        this.uf = z;
    }

    public ConcurrentHashMap<String, com.bytedance.msdk.api.g> io() {
        return this.x;
    }

    public void z(ConcurrentHashMap<String, com.bytedance.msdk.api.g> concurrentHashMap) {
        this.x = concurrentHashMap;
    }

    public List<com.bytedance.msdk.api.g> uf() {
        com.bytedance.msdk.api.g value;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, com.bytedance.msdk.api.g> entry : io().entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !TextUtils.equals("广告加载成功", value.m()) && !TextUtils.equals("广告请求中", value.m())) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public void z(a.dl dlVar) {
        this.hh = dlVar;
    }

    public int sy() {
        return this.l.get();
    }

    public void hh() {
        this.l.incrementAndGet();
    }

    public void z(long j) {
        this.h = j;
    }

    public long l() {
        return this.h;
    }

    public Map<String, Object> h() {
        return this.fo;
    }

    public kb gk() {
        return this.wp;
    }

    public void z(kb kbVar) {
        this.wp = kbVar;
    }

    public void z(Handler handler) {
        this.q = handler;
    }

    public long x() {
        return this.gz;
    }

    public void g(long j) {
        this.gz = j;
    }

    public long lq() {
        return this.iq;
    }

    public void dl(long j) {
        this.iq = j;
    }

    public boolean mc() {
        return this.zw.get();
    }

    public void a(boolean z) {
        this.zw.set(z);
    }

    public fo un() {
        return this.uy;
    }

    public void z(fo foVar) {
        this.uy = foVar;
    }

    public String ti() {
        return this.pf;
    }

    public void g(String str) {
        this.pf = str;
    }

    public void eo() {
        m.z(new Runnable() { // from class: com.bytedance.msdk.dl.m.z.g.6
            @Override // java.lang.Runnable
            public void run() {
                g.this.tb = true;
                if (g.this.g != null) {
                    g.this.g.clear();
                }
                if (g.this.dl != null) {
                    g.this.dl.clear();
                }
                if (g.this.f453a != null) {
                    g.this.f453a.clear();
                }
                if (g.this.gc != null) {
                    g.this.gc.clear();
                }
                if (g.this.q != null) {
                    g.this.q.removeCallbacksAndMessages(null);
                }
                g.this.v.wp();
                g.this.wp = null;
                if (g.this.fv.get() || g.this.p.get()) {
                    return;
                }
                g.this.z(new com.bytedance.msdk.api.g.z(41044, com.bytedance.msdk.api.z.z(41044)));
            }
        });
    }

    private int wj() {
        List<uy> list;
        com.bytedance.msdk.core.uy.g gVar = this.i;
        int size = 0;
        if (gVar == null) {
            return 0;
        }
        Map<Integer, List<uy>> mapSy = gVar.sy();
        if (mapSy != null && mapSy.size() != 0) {
            ArrayList<Integer> arrayList = new ArrayList();
            arrayList.addAll(mapSy.keySet());
            for (Integer num : arrayList) {
                if (this.v.dl(num.intValue()) && (list = mapSy.get(num)) != null) {
                    size += list.size();
                }
            }
        }
        return size;
    }

    protected int g(int i) {
        if (this.v.z() == null) {
            return -1;
        }
        return this.v.z().indexOf(Integer.valueOf(i)) + 1;
    }

    private void na() {
        if (zw() || g() || dl() || !z()) {
            return;
        }
        if (xl()) {
            gc();
        } else {
            final long jZ = com.bytedance.msdk.core.g.g().z(this.kb.iq(), this.kb.zw());
            m.z(new Runnable() { // from class: com.bytedance.msdk.dl.m.z.g.7
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.msdk.z.gc.dl.dl("TTMediationSDK", gc.z(g.this.i) + "m-sdk----设置 cacheTimeout 已到时间【" + jZ + "】，给外部invokeAdVideoCache ...");
                    g.this.gc();
                }
            }, jZ);
        }
    }

    private boolean xl() {
        if (e() != null) {
            Iterator<dl> it = e().iterator();
            while (it.hasNext()) {
                if (it.next().by()) {
                    return true;
                }
            }
        }
        if (uy() != null) {
            Iterator<dl> it2 = uy().iterator();
            while (it2.hasNext()) {
                if (it2.next().by()) {
                    return true;
                }
            }
        }
        if (gz() == null) {
            return false;
        }
        Iterator<dl> it3 = gz().iterator();
        while (it3.hasNext()) {
            if (it3.next().by()) {
                return true;
            }
        }
        return false;
    }

    private void gc(final boolean z) {
        m.z(new Runnable() { // from class: com.bytedance.msdk.dl.m.z.g.8
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.hh != null) {
                    g.this.hh.z(g.this.kb.zw(), z, 0, null);
                }
            }
        });
    }
}
