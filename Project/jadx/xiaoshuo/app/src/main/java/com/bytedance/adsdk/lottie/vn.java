package com.bytedance.adsdk.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class vn {
    private float bh;
    private Map<String, List<com.bytedance.adsdk.lottie.d.d.tg>> d;
    private Map<String, com.bytedance.adsdk.lottie.d.d> ga;
    private Rect m;
    private SparseArray<com.bytedance.adsdk.lottie.d.tg> p;
    private boolean t;
    private Map<String, zk> tg;
    private LongSparseArray<com.bytedance.adsdk.lottie.d.d.tg> v;
    private List<com.bytedance.adsdk.lottie.d.v> vn;
    private float wu;
    private float xu;
    private List<com.bytedance.adsdk.lottie.d.d.tg> zk;
    private final pe e = new pe();
    private final HashSet<String> bf = new HashSet<>();
    private int s = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int bf() {
        return this.s;
    }

    public float bh() {
        return this.xu - this.wu;
    }

    public pe d() {
        return this.e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void e(Rect rect, float f, float f2, float f3, List<com.bytedance.adsdk.lottie.d.d.tg> list, LongSparseArray<com.bytedance.adsdk.lottie.d.d.tg> longSparseArray, Map<String, List<com.bytedance.adsdk.lottie.d.d.tg>> map, Map<String, zk> map2, SparseArray<com.bytedance.adsdk.lottie.d.tg> sparseArray, Map<String, com.bytedance.adsdk.lottie.d.d> map3, List<com.bytedance.adsdk.lottie.d.v> list2) {
        this.m = rect;
        this.wu = f;
        this.xu = f2;
        this.bh = f3;
        this.zk = list;
        this.v = longSparseArray;
        this.d = map;
        this.tg = map2;
        this.p = sparseArray;
        this.ga = map3;
        this.vn = list2;
    }

    public float ga() {
        return (long) ((bh() / this.bh) * 1000.0f);
    }

    public SparseArray<com.bytedance.adsdk.lottie.d.tg> m() {
        return this.p;
    }

    public float p() {
        return this.xu;
    }

    public Rect tg() {
        return this.m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.lottie.d.d.tg> it = this.zk.iterator();
        while (it.hasNext()) {
            sb.append(it.next().e("\t"));
        }
        return sb.toString();
    }

    public float v() {
        return this.bh;
    }

    public float vn() {
        return this.wu;
    }

    public Map<String, com.bytedance.adsdk.lottie.d.d> wu() {
        return this.ga;
    }

    public Map<String, zk> xu() {
        return this.tg;
    }

    public List<com.bytedance.adsdk.lottie.d.d.tg> zk() {
        return this.zk;
    }

    public void bf(boolean z) {
        this.e.e(z);
    }

    public com.bytedance.adsdk.lottie.d.v d(String str) {
        int size = this.vn.size();
        for (int i = 0; i < size; i++) {
            com.bytedance.adsdk.lottie.d.v vVar = this.vn.get(i);
            if (vVar.e(str)) {
                return vVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<com.bytedance.adsdk.lottie.d.d.tg> bf(String str) {
        return this.d.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void e(String str) {
        com.bytedance.adsdk.lottie.vn.tg.bf(str);
        this.bf.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void e(boolean z) {
        this.t = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void e(int i) {
        this.s += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean e() {
        return this.t;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.bytedance.adsdk.lottie.d.d.tg e(long j) {
        return this.v.get(j);
    }

    public float e(float f) {
        return com.bytedance.adsdk.lottie.vn.p.e(this.wu, this.xu, f);
    }
}
