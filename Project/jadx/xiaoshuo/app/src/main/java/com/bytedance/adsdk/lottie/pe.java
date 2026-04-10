package com.bytedance.adsdk.lottie;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class pe {
    private boolean e = false;
    private final Set<e> bf = new com.bytedance.adsdk.lottie.e();
    private final Map<String, com.bytedance.adsdk.lottie.vn.vn> d = new HashMap();
    private final Comparator<Pair<String, Float>> tg = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.lottie.pe.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    public interface e {
        void e(float f);
    }

    public void e(boolean z) {
        this.e = z;
    }

    public void e(String str, float f) {
        if (this.e) {
            com.bytedance.adsdk.lottie.vn.vn vnVar = this.d.get(str);
            if (vnVar == null) {
                vnVar = new com.bytedance.adsdk.lottie.vn.vn();
                this.d.put(str, vnVar);
            }
            vnVar.e(f);
            if (str.equals("__container")) {
                Iterator<e> it = this.bf.iterator();
                while (it.hasNext()) {
                    it.next().e(f);
                }
            }
        }
    }
}
