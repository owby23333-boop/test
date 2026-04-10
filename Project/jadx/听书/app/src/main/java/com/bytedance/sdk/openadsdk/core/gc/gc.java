package com.bytedance.sdk.openadsdk.core.gc;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.gz;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static final Map<String, z> z = new ConcurrentHashMap();

    public static z z(String str, gz.dl dlVar) {
        if (TextUtils.isEmpty(str)) {
            return new z(dlVar);
        }
        Map<String, z> map = z;
        z zVar = map.get(str);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(dlVar);
        map.put(str, zVar2);
        return zVar2;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1090a;
        private long z = 0;
        private int g = 0;
        private int dl = 0;

        public z(gz.dl dlVar) {
            this.f1090a = dlVar.kb();
        }

        public void z(gz.dl dlVar) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (dlVar.m() > 0) {
                if (jCurrentTimeMillis - this.z < dlVar.m()) {
                    this.g++;
                    this.f1090a += dlVar.e();
                }
                this.z = jCurrentTimeMillis;
            }
            if (dlVar.gz() > 0) {
                int i = this.dl + 1;
                this.dl = i;
                if (i > dlVar.gz()) {
                    this.f1090a += dlVar.fo();
                }
            }
        }

        public void g(gz.dl dlVar) {
            this.dl = 0;
            this.g = 0;
            this.f1090a += dlVar.uy();
            this.f1090a = Math.min(dlVar.kb(), this.f1090a);
        }

        public int z(int i, gz.dl dlVar) {
            int i2 = this.f1090a - i;
            if (i2 < 0) {
                return 0;
            }
            LinkedHashMap<Integer, Integer> linkedHashMapWp = dlVar.wp();
            int i3 = -1;
            if (linkedHashMapWp == null) {
                return -1;
            }
            for (Map.Entry<Integer, Integer> entry : linkedHashMapWp.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().intValue() + i2 <= 0 && iIntValue > i3) {
                    i3 = iIntValue;
                }
            }
            return i3;
        }

        public void z(final int i, final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final gz.dl dlVar, final String str, final String str2) {
            v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.gc.gc.z.1
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("slot_type", Integer.valueOf(i));
                    jSONObject.putOpt("rit", gVar.a());
                    jSONObject.putOpt(MediationConstant.KEY_REASON, str);
                    jSONObject.putOpt("reason_value", str2);
                    jSONObject.putOpt("freq_count", Integer.valueOf(z.this.g));
                    jSONObject.putOpt("continuous_count", Integer.valueOf(z.this.dl));
                    jSONObject.putOpt("score", Integer.valueOf(z.this.f1090a));
                    jSONObject.putOpt("score_threshold", Integer.valueOf(dlVar.a()));
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("load_score_cache").g(jSONObject.toString());
                }
            }, "load_score_cache");
        }
    }
}
