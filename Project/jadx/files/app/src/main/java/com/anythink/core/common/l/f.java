package com.anythink.core.common.l;

import android.content.Context;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.al;
import com.anythink.core.common.e.m;
import com.anythink.core.common.e.r;
import com.anythink.core.common.x;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final String a = com.anythink.core.common.h.class.getSimpleName();
    final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f7801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f7802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f7803e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    al f7811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    List<ai> f7812n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<ai> f7813o;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    volatile int f7807i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    volatile int f7808j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile int f7809k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    volatile int f7810l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    List<ai> f7804f = Collections.synchronizedList(new ArrayList(5));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    List<ai> f7805g = Collections.synchronizedList(new ArrayList(5));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    List<ai> f7806h = Collections.synchronizedList(new ArrayList(2));

    public f(g gVar) {
        this.f7801c = 1;
        this.f7804f.addAll(gVar.f7815d);
        if (this.f7812n == null) {
            this.f7812n = Collections.synchronizedList(new ArrayList());
        }
        this.f7812n.clear();
        this.f7812n.addAll(gVar.f7815d);
        this.b = gVar.f7814c.am();
        this.f7801c = gVar.f7814c.k();
        this.f7802d = gVar.f7814c.aa();
        this.f7803e = gVar.f7814c.m();
        List<ai> listB = b(gVar.f7815d);
        if (listB != null) {
            this.f7804f.removeAll(listB);
            this.f7806h.addAll(listB);
        }
        this.f7813o = Collections.synchronizedList(new ArrayList(3));
        this.f7811m = gVar.f7818g;
    }

    private double i() {
        return a(false);
    }

    private double j() {
        return a(true);
    }

    public final List<ai> a() {
        return this.f7804f;
    }

    public final List<ai> b() {
        return this.f7805g;
    }

    public final List<ai> c() {
        return this.f7806h;
    }

    public final int d() {
        return this.f7807i;
    }

    public final int e() {
        return this.f7808j;
    }

    public final int f() {
        return this.f7809k;
    }

    public final al g() {
        return this.f7811m;
    }

    public final List<ai> h() {
        List<ai> listB;
        int i2 = this.f7801c;
        if (i2 == 1) {
            listB = new ArrayList<>();
            int iMin = Math.min(this.f7802d, this.f7804f.size());
            for (int i3 = 0; i3 < iMin; i3++) {
                listB.add(this.f7804f.get(i3));
            }
        } else {
            listB = i2 == 2 ? b(1) : null;
        }
        StringBuilder sb = new StringBuilder("startToRequestMediationAd: mRequestNumType: ");
        sb.append(this.f7801c);
        sb.append(", needRequestNum: ");
        sb.append(listB != null ? listB.size() : 0);
        sb.append(", validCacheNum: ");
        sb.append(this.b);
        sb.append(", mWaitingFillTime: ");
        sb.append(this.f7803e);
        if (listB.size() > 0) {
            this.f7804f.removeAll(listB);
        }
        return listB;
    }

    public static String a(List<ai> list) {
        String str = "";
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 > 0) {
                str = str + ",";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(i2).c());
            str = str + sb.toString();
        }
        return str;
    }

    public final List<ai> b(int i2) {
        List<ai> list = i2 != 2 ? this.f7804f : this.f7806h;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            ai aiVar = list.get(0);
            if (i2 == 2) {
                arrayList.add(aiVar);
            } else {
                boolean z2 = com.anythink.core.common.k.g.a(aiVar) > a(true);
                int i3 = this.f7801c;
                if (i3 == 1) {
                    boolean z3 = this.f7808j < this.f7802d;
                    if (z3 && z2) {
                        arrayList.add(aiVar);
                    } else {
                        StringBuilder sb = new StringBuilder("getNextRequestList, isLessThenMaxRequestNum: ");
                        sb.append(z3);
                        sb.append(", isExceedCachePrice");
                        sb.append(z2);
                    }
                } else if (i3 == 2) {
                    if (this.f7810l == 0 && z2) {
                        double dA = com.anythink.core.common.k.g.a(aiVar);
                        int size = list.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            ai aiVar2 = list.get(i4);
                            if (com.anythink.core.common.k.g.a(aiVar2) == dA) {
                                arrayList.add(aiVar2);
                            }
                        }
                        this.f7810l = arrayList.size();
                        new StringBuilder("getNextRequestList: same price, need request num: ").append(this.f7810l);
                    } else {
                        new StringBuilder("getNextRequestList: The number of ad sources with the same price that did not return results: ").append(this.f7810l);
                    }
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
        }
        return arrayList;
    }

    public final boolean c(ai aiVar) {
        double dA;
        double dA2 = com.anythink.core.common.k.g.a(aiVar);
        double dA3 = a(true);
        synchronized (this.f7805g) {
            Iterator<ai> it = this.f7805g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    dA = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                    break;
                }
                ai next = it.next();
                dA = com.anythink.core.common.k.g.a(next);
                if (next.j() && dA > com.anythink.core.common.k.g.a(aiVar)) {
                    break;
                }
            }
        }
        return dA2 > Math.max(dA3, dA);
    }

    public final void a(int i2, int i3) {
        this.f7807i += i2;
        if (i3 != 2) {
            this.f7808j += i2;
        } else {
            this.f7809k += i2;
        }
    }

    public final void a(int i2) {
        if (this.f7801c == 2 && i2 == 1) {
            this.f7810l--;
        }
    }

    public final void a(ai aiVar) {
        synchronized (this.f7812n) {
            if (this.f7812n != null) {
                if (this.f7812n.size() == 0) {
                    this.f7812n.add(aiVar);
                    a(aiVar, 0, null);
                    return;
                }
                for (int i2 = 0; i2 < this.f7812n.size(); i2++) {
                    ai aiVar2 = this.f7812n.get(i2);
                    if (com.anythink.core.common.k.g.a(aiVar) > com.anythink.core.common.k.g.a(aiVar2)) {
                        this.f7812n.add(i2, aiVar);
                        a(aiVar, i2, aiVar2);
                        return;
                    }
                }
                this.f7812n.add(aiVar);
                a(aiVar, this.f7812n.size() - 1, null);
            }
        }
    }

    private static List<ai> b(List<ai> list) {
        ArrayList arrayList = null;
        for (ai aiVar : list) {
            if (aiVar.l() == 8) {
                if (arrayList == null) {
                    arrayList = new ArrayList(4);
                }
                arrayList.add(aiVar);
            }
        }
        return arrayList;
    }

    private void a(ai aiVar, int i2, ai aiVar2) {
        m mVarN;
        m mVarN2;
        if (aiVar.j() && (mVarN2 = aiVar.N()) != null) {
            if (aiVar2 != null) {
                mVarN2.f7352q = com.anythink.core.common.k.g.a(aiVar2);
            } else {
                mVarN2.f7352q = com.anythink.core.common.k.g.a(aiVar);
            }
        }
        if (i2 > 0) {
            ai aiVar3 = this.f7812n.get(i2 - 1);
            if (!aiVar3.j() || (mVarN = aiVar3.N()) == null) {
                return;
            }
            mVarN.f7352q = com.anythink.core.common.k.g.a(aiVar);
        }
    }

    public final void b(ai aiVar) {
        synchronized (this.f7813o) {
            if (this.f7813o.size() == 0) {
                this.f7813o.add(aiVar);
            } else {
                double dA = com.anythink.core.common.k.g.a(aiVar);
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f7813o.size()) {
                        break;
                    }
                    if (dA > com.anythink.core.common.k.g.a(this.f7813o.get(i2))) {
                        this.f7813o.add(i2, aiVar);
                        break;
                    } else {
                        if (i2 == this.f7813o.size() - 1) {
                            this.f7813o.add(aiVar);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
    }

    public final double a(boolean z2) {
        synchronized (this.f7813o) {
            int size = this.f7813o.size();
            if (size == 0) {
                return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            }
            int i2 = this.b - 1;
            int i3 = size - 1;
            if (z2 && i3 < i2) {
                return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            }
            return com.anythink.core.common.k.g.a(this.f7813o.get(Math.min(i2, i3)));
        }
    }

    public final void a(com.anythink.core.common.e.e eVar, ai aiVar) {
        ArrayList arrayList = new ArrayList(5);
        synchronized (this.f7813o) {
            a(arrayList, this.f7813o);
        }
        synchronized (this.f7805g) {
            a(arrayList, this.f7805g);
        }
        Iterator<ai> it = arrayList.iterator();
        while (it.hasNext()) {
            a(it.next(), eVar, aiVar, false);
        }
    }

    public static void a(ai aiVar, com.anythink.core.common.e.e eVar, ai aiVar2, boolean z2) {
        m mVarN;
        if (aiVar2 == null || (mVarN = aiVar.N()) == null) {
            return;
        }
        double dA = com.anythink.core.common.k.g.a(aiVar2);
        r rVar = new r();
        rVar.a = 2;
        rVar.b = dA;
        rVar.f7378e = eVar;
        rVar.f7376c = aiVar2;
        rVar.f7377d = aiVar;
        mVarN.a(rVar, z2);
    }

    private void a(List<ai> list, List<ai> list2) {
        int iAf;
        int size = list2.size();
        int size2 = this.f7813o.size();
        for (int i2 = 0; i2 < size; i2++) {
            ai aiVar = list2.get(i2);
            if (aiVar.j() && (iAf = aiVar.af()) > 0 && iAf <= size2 && com.anythink.core.common.k.g.a(aiVar) < com.anythink.core.common.k.g.a(this.f7813o.get(iAf - 1))) {
                list.add(aiVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.anythink.core.common.e.ai r4, com.anythink.core.common.l.h r5) {
        /*
            int r0 = r4.Z()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            if (r0 == 0) goto L2c
            int r4 = r4.l()
            if (r4 == r2) goto L25
            r3 = 3
            if (r4 == r3) goto L25
            r3 = 6
            if (r4 == r3) goto L1d
            r3 = 7
            if (r4 == r3) goto L25
            goto L2c
        L1d:
            boolean r4 = r5.f7823g
            if (r4 == 0) goto L22
            goto L2d
        L22:
            r5.f7823g = r2
            goto L2c
        L25:
            boolean r4 = r5.f7822f
            if (r4 == 0) goto L2a
            goto L2d
        L2a:
            r5.f7822f = r2
        L2c:
            r1 = r0
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.l.f.a(com.anythink.core.common.e.ai, com.anythink.core.common.l.h):boolean");
    }

    public static void a(Context context, String str, String str2, ai aiVar, ai aiVar2) {
        al.a aVar;
        al.a aVar2 = null;
        if (aiVar != null) {
            al.a aVar3 = new al.a(aiVar);
            aVar = null;
            aVar2 = aVar3;
        } else {
            aVar = aiVar2 != null ? new al.a(aiVar2) : null;
        }
        x.a(context).a(str, str2, aVar2, aVar);
    }

    public static void a(Context context, String str) {
        x.a(context).a(str);
    }
}
