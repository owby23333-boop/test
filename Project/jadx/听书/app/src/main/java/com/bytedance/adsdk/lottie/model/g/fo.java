package com.bytedance.adsdk.lottie.model.g;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements dl {
    private final boolean dl;
    private final z g;
    private final String z;

    public enum z {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static z z(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public fo(String str, z zVar, boolean z2) {
        this.z = str;
        this.g = zVar;
        this.dl = z2;
    }

    public String z() {
        return this.z;
    }

    public z g() {
        return this.g;
    }

    public boolean dl() {
        return this.dl;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new com.bytedance.adsdk.lottie.z.z.wp(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.g + '}';
    }
}
