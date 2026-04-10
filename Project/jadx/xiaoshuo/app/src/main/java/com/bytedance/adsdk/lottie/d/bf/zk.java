package com.bytedance.adsdk.lottie.d.bf;

/* JADX INFO: loaded from: classes.dex */
public class zk implements d {
    private final e bf;
    private final boolean d;
    private final String e;

    public enum e {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static e e(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public zk(String str, e eVar, boolean z) {
        this.e = str;
        this.bf = eVar;
        this.d = z;
    }

    public e bf() {
        return this.bf;
    }

    public boolean d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "MergePaths{mode=" + this.bf + '}';
    }

    @Override // com.bytedance.adsdk.lottie.d.bf.d
    public com.bytedance.adsdk.lottie.e.e.d e(com.bytedance.adsdk.lottie.v vVar, com.bytedance.adsdk.lottie.vn vnVar, com.bytedance.adsdk.lottie.d.d.e eVar) {
        if (vVar.e()) {
            return new com.bytedance.adsdk.lottie.e.e.xu(this);
        }
        com.bytedance.adsdk.lottie.vn.tg.bf("Animation contains merge paths but they are disabled.");
        return null;
    }
}
