package com.bytedance.sdk.openadsdk.core.un;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static boolean z(int i) {
        return i == 3 || i == 7 || i == 8;
    }

    public static void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, int i, int i2) {
        if (zVar == null || zVar.g() == null || i2 <= 0) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.iq.na> listG = zVar.g();
        int size = listG.size();
        try {
            com.bytedance.sdk.component.a.g.dl dlVarZ = x.z(i + "_prefetch");
            delete(i, i2, dlVarZ, size);
            for (com.bytedance.sdk.openadsdk.core.iq.na naVar : listG) {
                String strLq = naVar.lq();
                String strG = com.bytedance.sdk.component.utils.z.g(naVar.kv().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put("message", strG);
                dlVarZ.put(strLq, jSONObject.toString());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    private static void delete(int i, int i2, com.bytedance.sdk.component.a.g.dl dlVar, int i3) {
        JSONObject jSONObject;
        if (dlVar == null) {
            return;
        }
        try {
            Map all = dlVar.getAll();
            if (all != null && all.size() != 0) {
                int size = all.size();
                if (z(i)) {
                    if (size > 1) {
                        dlVar.clear();
                        return;
                    }
                    return;
                }
                if (i3 >= i2) {
                    dlVar.clear();
                    return;
                }
                int i4 = size + i3;
                if (i4 > i2) {
                    PriorityQueue priorityQueue = new PriorityQueue();
                    for (Map.Entry entry : all.entrySet()) {
                        String str = (String) entry.getValue();
                        if (str != null && str.contains("pre_fetch_time")) {
                            jSONObject = new JSONObject(str);
                        } else {
                            jSONObject = str != null ? new JSONObject(com.bytedance.sdk.component.utils.z.dl(str)) : null;
                        }
                        if (jSONObject != null) {
                            priorityQueue.add(new z((String) entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                        }
                    }
                    int size2 = priorityQueue.size();
                    int i5 = i4 - i2;
                    if (size2 == 0 || size2 < i5) {
                        dlVar.clear();
                        return;
                    }
                    for (int i6 = 0; i6 < i5; i6++) {
                        z zVar = (z) priorityQueue.poll();
                        if (zVar != null) {
                            dlVar.remove(zVar.g);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.openadsdk.core.iq.na z(String str, int i) {
        if (com.bytedance.sdk.openadsdk.core.zw.g().gk() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.a.g.dl dlVarZ = x.z(i + "_prefetch");
        String strOptString = dlVarZ.get(str, (String) null);
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                if (strOptString.contains("pre_fetch_time")) {
                    strOptString = new JSONObject(strOptString).optString("message");
                }
                com.bytedance.sdk.openadsdk.core.iq.na naVarZ = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(com.bytedance.sdk.component.utils.z.dl(strOptString)));
                dlVarZ.remove(str);
                return naVarZ;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    static class z implements Comparable<z> {
        private String g;
        private long z;

        public z(String str, long j) {
            this.g = str;
            this.z = j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compareTo(z zVar) {
            if (zVar == null) {
                return 1;
            }
            long j = this.z;
            long j2 = zVar.z;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }
    }
}
