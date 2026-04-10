package com.bytedance.adsdk.lottie;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class fv {
    private boolean z = false;
    private final Set<Object> g = new z();
    private final Map<String, com.bytedance.adsdk.lottie.gc.e> dl = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f145a = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.lottie.fv.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    void z(boolean z) {
        this.z = z;
    }

    public void z(String str, float f) {
        if (this.z) {
            com.bytedance.adsdk.lottie.gc.e eVar = this.dl.get(str);
            if (eVar == null) {
                eVar = new com.bytedance.adsdk.lottie.gc.e();
                this.dl.put(str, eVar);
            }
            eVar.z(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.g.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
