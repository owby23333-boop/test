package com.anythink.core.b;

import android.text.TextUtils;
import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.p;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static f f6556h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ConcurrentHashMap<String, List<ai>> f6558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ConcurrentHashMap<String, Integer> f6559e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MediationBidManager f6562i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f6561g = f.class.getSimpleName();
    ConcurrentHashMap<String, m> a = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, j> b = new ConcurrentHashMap<>(5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ConcurrentHashMap<String, ai> f6557c = new ConcurrentHashMap<>(5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    List<Integer> f6560f = new CopyOnWriteArrayList();

    private f() {
    }

    public static f a() {
        if (f6556h == null) {
            f6556h = new f();
        }
        return f6556h;
    }

    public static void b(String str) {
        p.a(n.a().g(), com.anythink.core.common.b.g.f6805u, str);
    }

    private j c(ai aiVar) {
        if (aiVar != null) {
            return b(aiVar.N().f7342g, aiVar.N().f7346k);
        }
        return null;
    }

    private void d(ai aiVar) {
        m mVarN;
        if (aiVar == null || (mVarN = aiVar.N()) == null) {
            return;
        }
        c(mVarN.f7342g, mVarN.f7346k);
    }

    private boolean e(String str) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.f6559e;
        if (concurrentHashMap == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_c2sfirstStatus");
        return concurrentHashMap.get(sb.toString()) == null;
    }

    public final MediationBidManager b() {
        return this.f6562i;
    }

    public final void c(String str, String str2) {
        this.b.remove(str + "_" + str2);
    }

    private void d(String str) {
        if (this.f6559e == null) {
            this.f6559e = new ConcurrentHashMap<>();
        }
        this.f6559e.put(str + "_c2sfirstStatus", 1);
    }

    public final double b(ai aiVar) {
        m mVarN;
        return (aiVar == null || (mVarN = aiVar.N()) == null) ? PangleAdapterUtils.CPM_DEFLAUT_VALUE : a(mVarN.f7342g, aiVar.t());
    }

    public final ai c(String str) {
        return this.f6557c.get(str);
    }

    private void a(ai aiVar, m mVar) {
        this.a.put(aiVar.t(), mVar);
        if (aiVar.l() == 3 || aiVar.l() == 7) {
            a(aiVar.t(), mVar);
        }
    }

    public final j b(String str, String str2) {
        return this.b.get(str + "_" + str2);
    }

    public final boolean b(int i2) {
        boolean z2;
        synchronized (this.f6560f) {
            z2 = !this.f6560f.contains(Integer.valueOf(i2));
        }
        return z2;
    }

    public final void a(String str) {
        this.a.remove(str);
    }

    public static void a(String str, m mVar) {
        p.a(n.a().g(), com.anythink.core.common.b.g.f6805u, str, mVar.c());
    }

    public final m a(ai aiVar) {
        m mVarA = this.a.get(aiVar.t());
        if (mVarA == null && (aiVar.l() == 3 || aiVar.l() == 7)) {
            String strB = p.b(n.a().g(), com.anythink.core.common.b.g.f6805u, aiVar.t(), "");
            if (!TextUtils.isEmpty(strB)) {
                mVarA = m.a(strB);
            }
            if (mVarA != null) {
                this.a.put(aiVar.t(), mVarA);
            }
        }
        return mVarA;
    }

    public final void a(MediationBidManager mediationBidManager) {
        this.f6562i = mediationBidManager;
    }

    public final double a(String str, String str2) {
        j jVar = this.b.get(str + "_" + str2);
        return jVar != null ? jVar.f6568c : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    public final void a(String str, String str2, j jVar) {
        this.b.put(str + "_" + str2, jVar);
    }

    public final void a(String str, ai aiVar) {
        this.f6557c.put(str, aiVar);
    }

    public final void a(int i2) {
        synchronized (this.f6560f) {
            if (!this.f6560f.contains(Integer.valueOf(i2))) {
                this.f6560f.add(Integer.valueOf(i2));
            }
        }
    }
}
