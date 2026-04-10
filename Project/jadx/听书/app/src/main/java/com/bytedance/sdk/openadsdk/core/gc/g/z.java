package com.bytedance.sdk.openadsdk.core.gc.g;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private String e;
    private gc gz;
    private final int wp;
    private final AtomicBoolean gc = new AtomicBoolean(false);
    private final AtomicBoolean m = new AtomicBoolean(false);
    List<na> z = new ArrayList();
    List<na> g = new ArrayList();
    List<na> dl = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<String> f1089a = new ArrayList();
    private long fo = -1;
    private long uy = -1;
    private long kb = -1;
    private final Runnable i = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gc.g.z.1
        @Override // java.lang.Runnable
        public void run() {
            if (z.this.m.get()) {
                return;
            }
            z.this.gc.set(true);
            Iterator<na> it = z.this.dl.iterator();
            while (it.hasNext()) {
                it.next().fo(100003L);
            }
            z zVar = z.this;
            zVar.g(zVar.z);
        }
    };

    public z(int i) {
        this.wp = i;
    }

    public void z() {
        this.gz = null;
        gz.dl().removeCallbacks(this.i);
    }

    public void z(long j) {
        this.fo = j;
    }

    public void g(long j) {
        this.uy = j;
    }

    private void dl(long j) {
        this.kb = j;
    }

    public void z(List<na> list, gc gcVar) {
        this.gz = gcVar;
        z(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(java.util.List<com.bytedance.sdk.openadsdk.core.iq.na> r20) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.gc.g.z.z(java.util.List):void");
    }

    private void z(final int i, final List<na> list) {
        Iterator<na> it = list.iterator();
        long jMin = 2147483647L;
        while (it.hasNext()) {
            JSONObject jSONObjectGl = it.next().gl();
            long jOptLong = jSONObjectGl == null ? 0L : jSONObjectGl.optLong("correct_interface_timeout", 0L);
            if (jOptLong > 0) {
                jMin = Math.min(jMin, jOptLong);
            }
        }
        if (jMin == 2147483647L) {
            jMin = 0;
        }
        if (jMin > 0) {
            gz.dl().postDelayed(this.i, jMin);
        }
        zw.z().z(g(i, list), new g<a>() { // from class: com.bytedance.sdk.openadsdk.core.gc.g.z.2
            @Override // com.bytedance.sdk.openadsdk.core.gc.g.g
            public void z(a aVar, long j, long j2) {
                try {
                    z.this.z(i, list, aVar, j);
                } catch (Exception e) {
                    wp.z(e);
                    e.getMessage();
                }
            }
        });
    }

    private JSONObject g(int i, List<na> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<na> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(z(it.next()));
            }
            jSONObject.put("ads", jSONArray);
            jSONObject.put("check_type", i);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, List<na> list, a aVar, long j) throws JSONException {
        if (this.gc.get()) {
            return;
        }
        this.m.set(true);
        if (aVar == null || aVar.z()) {
            a(Collections.emptyList());
            return;
        }
        if (j != 20000) {
            Iterator<na> it = list.iterator();
            while (it.hasNext()) {
                it.next().fo(100001L);
            }
            g(this.z);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, JSONObject> map = aVar.g;
        for (na naVar : list) {
            String strZ = a.z(naVar.mj(), naVar.aq());
            JSONObject jSONObject = TextUtils.isEmpty(strZ) ? null : map.get(strZ);
            if (jSONObject == null) {
                naVar.fo(100004L);
                arrayList.add(naVar);
            } else {
                if (jSONObject.has("is_valid")) {
                    if (jSONObject.optBoolean("is_valid")) {
                        if (i == 2 || i == 3) {
                            String strOptString = jSONObject.optString("ext");
                            String strOptString2 = jSONObject.optString("media_ext");
                            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                                naVar.fo(100006L);
                                arrayList.add(naVar);
                            } else {
                                naVar.iq(strOptString);
                                naVar.z(z(new JSONObject(strOptString2), naVar.fq()));
                            }
                        }
                        naVar.fo(100000L);
                        arrayList.add(naVar);
                    } else {
                        arrayList2.add(naVar);
                        this.e = jSONObject.optString(MediationConstant.KEY_REASON);
                        naVar.fo(100007L);
                    }
                } else {
                    naVar.fo(100005L);
                    arrayList.add(naVar);
                }
                arrayList.addAll(this.g);
                g(arrayList);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    g((na) it2.next());
                }
                gc gcVar = this.gz;
                if (gcVar != null) {
                    gcVar.dl(arrayList2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<na> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f1089a) {
            for (na naVar : list) {
                if (str.equals(naVar.jt())) {
                    arrayList.add(naVar);
                }
            }
        }
        a(arrayList);
    }

    public static Map<String, Object> z(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null) {
            return map;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private JSONObject z(na naVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strMj = naVar.mj();
            String strVk = naVar.vk();
            Map<String, Object> mapFq = naVar.fq();
            String string = "";
            if (mapFq != null) {
                JSONObject jSONObject2 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = mapFq.entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject2.length() > 0) {
                    string = jSONObject2.toString();
                }
            }
            z(strMj, strVk, string, naVar.aq(), jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void z(String str, String str2, String str3, String str4, JSONObject jSONObject) throws JSONException {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        StringBuilder sb = new StringBuilder("id=");
        sb.append(str).append("&timestamp=").append(iCurrentTimeMillis).append("&ext=").append(str2).append("&media_ext=").append(str3).append("&req_id=").append(str4);
        String upperCase = com.bytedance.sdk.component.utils.gc.g(sb.toString()).toUpperCase();
        jSONObject.put("id", str);
        jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, iCurrentTimeMillis);
        jSONObject.put("ext", str2);
        jSONObject.put("media_ext", str3);
        jSONObject.put("req_id", str4);
        jSONObject.put("sign", upperCase);
    }

    private void dl(List<na> list) {
        list.size();
        Iterator<na> it = list.iterator();
        while (it.hasNext()) {
            g(it.next());
        }
        gc gcVar = this.gz;
        if (gcVar != null) {
            gcVar.z(list);
        }
        z();
    }

    private void a(List<na> list) {
        list.size();
        Iterator<na> it = list.iterator();
        while (it.hasNext()) {
            g(it.next());
        }
        gc gcVar = this.gz;
        if (gcVar != null) {
            gcVar.g(list);
        }
        z();
    }

    private void g(na naVar) {
        dl(System.currentTimeMillis());
        if (naVar.to() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String strG = eo.g(this.wp);
            long j = this.uy;
            long j2 = this.fo;
            jSONObject.put("cache_get_duration", j - j2 < 0 ? -1L : j - j2);
            long j3 = this.kb;
            long j4 = this.uy;
            jSONObject.put("network_check_duration", j3 - j4 < 0 ? -1L : j3 - j4);
            long j5 = this.kb;
            long j6 = this.fo;
            jSONObject.put("cache_total_duration", j5 - j6 < 0 ? -1L : j5 - j6);
            jSONObject.put("cache_loss_reason", this.e);
            if (naVar != null) {
                jSONObject.put("correct_action_code", naVar.to());
                jSONObject.put("correct_result_code", naVar.lz());
                jSONObject.put("creative_check_duration", naVar.gl() != null ? naVar.gl().optLong("creative_check_duration", 0L) : -1L);
            }
            com.bytedance.sdk.openadsdk.core.i.a.g(naVar, strG, jSONObject);
        } catch (Exception unused) {
        }
    }
}
