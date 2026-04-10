package com.bytedance.adsdk.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, fo> f155a;
    private Map<String, List<com.bytedance.adsdk.lottie.model.layer.gz>> dl;
    private SparseArray<com.bytedance.adsdk.lottie.model.a> e;
    private List<com.bytedance.adsdk.lottie.model.layer.gz> fo;
    private g fv;
    private Map<String, com.bytedance.adsdk.lottie.model.dl> gc;
    private LongSparseArray<com.bytedance.adsdk.lottie.model.layer.gz> gz;
    private float i;
    private dl js;
    private float kb;
    private a ls;
    private List<com.bytedance.adsdk.lottie.model.m> m;
    private z tb;
    private Rect uy;
    private boolean v;
    private float wp;
    private final fv z = new fv();
    private final HashSet<String> g = new HashSet<>();
    private int pf = 0;
    private String p = "";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f156a;
        public String dl;
        public JSONArray e;
        public int fo;
        public String g;
        public int[] gc;
        public int gz;
        public String m;
        public String[] uy;
        public int z;
    }

    public static class dl {
        public JSONArray dl;
        public int[][] g;
        public String z;
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f157a;
        public Map<String, Object> dl;
        public JSONArray e;
        public Map<String, Object> g;
        public int gc;
        public String m;
        public int z;
    }

    public void z(Rect rect, float f, float f2, float f3, List<com.bytedance.adsdk.lottie.model.layer.gz> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.gz> longSparseArray, Map<String, List<com.bytedance.adsdk.lottie.model.layer.gz>> map, Map<String, fo> map2, SparseArray<com.bytedance.adsdk.lottie.model.a> sparseArray, Map<String, com.bytedance.adsdk.lottie.model.dl> map3, List<com.bytedance.adsdk.lottie.model.m> list2, a aVar, String str, g gVar, dl dlVar, z zVar) {
        this.uy = rect;
        this.kb = f;
        this.wp = f2;
        this.i = f3;
        this.fo = list;
        this.gz = longSparseArray;
        this.dl = map;
        this.f155a = map2;
        this.e = sparseArray;
        this.gc = map3;
        this.m = list2;
        this.ls = aVar;
        this.p = str;
        this.fv = gVar;
        this.js = dlVar;
        this.tb = zVar;
    }

    public void z(String str) {
        com.bytedance.adsdk.lottie.gc.gc.g(str);
        this.g.add(str);
    }

    public void z(boolean z2) {
        this.v = z2;
    }

    public void z(int i) {
        this.pf += i;
    }

    public boolean z() {
        return this.v;
    }

    public int g() {
        return this.pf;
    }

    public void g(boolean z2) {
        this.z.z(z2);
    }

    public fv dl() {
        return this.z;
    }

    public com.bytedance.adsdk.lottie.model.layer.gz z(long j) {
        return this.gz.get(j);
    }

    public Rect a() {
        return this.uy;
    }

    public float gc() {
        return (long) ((fv() / this.i) * 1000.0f);
    }

    public float m() {
        return this.kb;
    }

    public float e() {
        return this.wp;
    }

    public float z(float f) {
        return com.bytedance.adsdk.lottie.gc.gz.z(this.kb, this.wp, f);
    }

    public a gz() {
        return this.ls;
    }

    public String fo() {
        return this.p;
    }

    public z uy() {
        return this.tb;
    }

    public dl kb() {
        return this.js;
    }

    public g wp() {
        return this.fv;
    }

    public float i() {
        return this.i;
    }

    public List<com.bytedance.adsdk.lottie.model.layer.gz> v() {
        return this.fo;
    }

    public List<com.bytedance.adsdk.lottie.model.layer.gz> g(String str) {
        return this.dl.get(str);
    }

    public SparseArray<com.bytedance.adsdk.lottie.model.a> pf() {
        return this.e;
    }

    public Map<String, com.bytedance.adsdk.lottie.model.dl> ls() {
        return this.gc;
    }

    public com.bytedance.adsdk.lottie.model.m dl(String str) {
        int size = this.m.size();
        for (int i = 0; i < size; i++) {
            com.bytedance.adsdk.lottie.model.m mVar = this.m.get(i);
            if (mVar.z(str)) {
                return mVar;
            }
        }
        return null;
    }

    public Map<String, fo> p() {
        return this.f155a;
    }

    public float fv() {
        return this.wp - this.kb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.lottie.model.layer.gz> it = this.fo.iterator();
        while (it.hasNext()) {
            sb.append(it.next().z("\t"));
        }
        return sb.toString();
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f158a;
        public String dl;
        public String g;
        public String z;
        public float gc = -1.0f;
        public float m = -1.0f;
        public float e = -1.0f;
        public float gz = -1.0f;

        public String toString() {
            return "area[" + this.z + "," + this.g + "," + this.dl + "," + this.f158a + "]->[" + this.gc + "," + this.m + "," + this.e + "," + this.gz + "]";
        }
    }
}
