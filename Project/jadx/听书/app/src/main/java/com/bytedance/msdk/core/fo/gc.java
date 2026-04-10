package com.bytedance.msdk.core.fo;

import android.text.TextUtils;
import com.bytedance.msdk.core.gc.g.e;
import com.bytedance.msdk.gz.x;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.umcrash.UMCrash;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {
    private static volatile gc gc;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, double[]> f386a;
    protected final Map<String, String> dl;

    private gc() {
        super("label_v_v_s");
        this.dl = new ConcurrentHashMap();
        this.f386a = new ConcurrentHashMap();
        g();
    }

    public static gc a() {
        if (gc == null) {
            synchronized (gc.class) {
                if (gc == null) {
                    gc = new gc();
                }
            }
        }
        return gc;
    }

    protected void z(int i, double d) {
        if (com.bytedance.msdk.core.g.g().y()) {
            z(2, String.valueOf(i), 1, d);
        }
    }

    private void a(int i) {
        if (i == 2) {
            this.f386a.clear();
            return;
        }
        this.dl.clear();
        if (this.g != null) {
            this.g.dl();
        }
    }

    public Map<String, JSONObject> g(int i) {
        if (!com.bytedance.msdk.core.g.g().y()) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        for (Map.Entry<String, double[]> entry : (i == 2 ? this.f386a : g(this.dl)).entrySet()) {
            String key = entry.getKey();
            double[] value = entry.getValue();
            try {
                if (!TextUtils.isEmpty(key)) {
                    Map<String, JSONObject> mapZ = z(key, value);
                    JSONObject jSONObject3 = mapZ.get("config_req_label_value");
                    JSONObject jSONObject4 = mapZ.get("event_label_value");
                    if (jSONObject4 != null) {
                        jSONObject.putOpt(key, jSONObject4);
                    }
                    if (jSONObject3 != null) {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONObject2.putOpt(key, jSONObject3);
                    }
                }
            } catch (Exception e) {
                wp.z(e);
            }
        }
        map.put("event_label_value_root", jSONObject);
        if (jSONObject2 != null) {
            map.put("config_req_label_value_root", jSONObject2);
        }
        a(i);
        return map;
    }

    private Map<String, double[]> g(Map<String, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && map.size() != 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    String value = it.next().getValue();
                    if (!TextUtils.isEmpty(value)) {
                        String[] strArrSplit = value.split("_");
                        String str = strArrSplit[0];
                        String str2 = strArrSplit[1];
                        String str3 = strArrSplit[2];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            if (com.bytedance.msdk.core.g.g().z(System.currentTimeMillis() - Long.parseLong(strArrSplit[2]))) {
                                double[] dArr = (double[]) concurrentHashMap.get(str);
                                if (dArr == null) {
                                    dArr = new double[2];
                                }
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = dArr[1] + Double.parseDouble(str2);
                                concurrentHashMap.put(str, dArr);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    private Map<String, JSONObject> z(String str, double[] dArr) {
        JSONObject jSONObject;
        JSONException e;
        HashMap map = new HashMap();
        String strZ = z(dArr);
        JSONObject jSONObject2 = null;
        try {
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        if (!strZ.equals("-1")) {
            jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("input", g(strZ));
                jSONObject.putOpt(UMCrash.SP_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            } catch (JSONException e3) {
                e = e3;
                wp.z(e);
            }
            jSONObject2 = jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.putOpt(MediationConstant.KEY_ECPM, strZ);
            jSONObject4.putOpt(UMCrash.SP_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
            jSONObject3.putOpt("ecpm_info", jSONObject4);
        } catch (JSONException e4) {
            wp.z(e4);
        }
        map.put("config_req_label_value", jSONObject2);
        map.put("event_label_value", jSONObject3);
        return map;
    }

    public void z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (com.bytedance.msdk.core.g.g().y() && jSONObject2 != null) {
            try {
                jSONObject.putOpt("label_inputs", jSONObject2);
            } catch (JSONException e) {
                wp.z(e);
            }
        }
    }

    public void z(JSONObject jSONObject) {
        if (com.bytedance.msdk.core.g.g().y()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, com.bytedance.msdk.core.uy.dl> entry : com.bytedance.msdk.core.g.g().gp().entrySet()) {
                String key = entry.getKey();
                com.bytedance.msdk.core.uy.dl value = entry.getValue();
                if (value != null) {
                    try {
                        jSONObject2.putOpt(key, z(value));
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject2.length();
            }
            try {
                jSONObject.putOpt("last_label_outputs", jSONObject2);
            } catch (JSONException e2) {
                wp.z(e2);
            }
        }
    }

    private void g(JSONObject jSONObject) {
        Map<String, com.bytedance.msdk.core.uy.dl> mapGp = com.bytedance.msdk.core.g.g().gp();
        if (mapGp.size() > 0 && jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Map.Entry<String, com.bytedance.msdk.core.uy.dl> entry : mapGp.entrySet()) {
            String key = entry.getKey();
            com.bytedance.msdk.core.uy.dl value = entry.getValue();
            if (value != null) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(String.valueOf(key));
                    if (jSONObjectOptJSONObject == null) {
                        jSONObjectOptJSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(key), jSONObjectOptJSONObject);
                        jSONObjectOptJSONObject.put("ecpm_info", new JSONObject());
                    }
                    jSONObjectOptJSONObject.putOpt("label_info", z(value));
                    jSONObjectOptJSONObject.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.g.g().ec()));
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
        }
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected boolean g(String str, JSONObject jSONObject, Map<String, Object> map) {
        com.bytedance.msdk.core.uy.dl dlVar = com.bytedance.msdk.core.g.g().gp().get(str);
        if (dlVar == null) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", z(dlVar));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.g.g().ec()));
            return true;
        } catch (JSONException e) {
            wp.z(e);
            return false;
        }
    }

    protected void z(boolean z, com.bytedance.msdk.gc.a aVar, JSONObject jSONObject, Map<String, Object> map) {
        aVar.z(MediationConstant.KEY_REASON, Integer.valueOf(!z ? 1 : 0));
        if (map != null) {
            g(jSONObject);
            if (jSONObject != null) {
                map.put("label", jSONObject);
            }
        }
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected JSONObject z(com.bytedance.msdk.core.uy.dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", dlVar.z());
            jSONObject.putOpt("label_id", Integer.valueOf(dlVar.dl()));
            jSONObject.putOpt("label_version", dlVar.a());
            jSONObject.putOpt("upper_bound", Double.valueOf(dlVar.gc()));
            jSONObject.putOpt("lower_bound", Double.valueOf(dlVar.m()));
            jSONObject.putOpt(UMCrash.SP_KEY_TIMESTAMP, dlVar.g());
            return jSONObject;
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public static String gc() {
        if (!com.bytedance.msdk.core.g.g().y()) {
            return null;
        }
        Set<Map.Entry<String, com.bytedance.msdk.core.uy.dl>> setEntrySet = com.bytedance.msdk.core.g.g().gp().entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.core.uy.dl> entry : setEntrySet) {
            String key = entry.getKey();
            com.bytedance.msdk.core.uy.dl value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("label_name", value.z());
                jSONObject2.putOpt(UMCrash.SP_KEY_TIMESTAMP, value.g());
                jSONObject2.putOpt("lower_bound", Double.valueOf(value.m()));
                jSONObject2.putOpt("upper_bound", Double.valueOf(value.gc()));
                jSONObject.putOpt(z(Integer.parseInt(key)), jSONObject2);
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return jSONObject.toString();
    }

    public static String dl(int i) {
        com.bytedance.msdk.core.uy.dl dlVar;
        if (com.bytedance.msdk.core.g.g().y() && (dlVar = com.bytedance.msdk.core.g.g().gp().get(String.valueOf(i))) != null) {
            return dlVar.z();
        }
        return null;
    }

    public void z(Map<String, ConcurrentHashMap<String, List<e>>> map) {
        int iHy;
        ConcurrentHashMap<String, List<e>> value;
        if (!com.bytedance.msdk.core.g.g().y() || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ConcurrentHashMap<String, List<e>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ConcurrentHashMap<String, List<e>> value2 = entry.getValue();
            if (value2 != null) {
                Iterator<Map.Entry<String, List<e>>> it = value2.entrySet().iterator();
                while (it.hasNext()) {
                    List<e> value3 = it.next().getValue();
                    if (value3 != null && !value3.isEmpty() && value3.get(0) != null && value3.get(0).z != null) {
                        iHy = value3.get(0).z.hy();
                        break;
                    }
                }
                iHy = 0;
            } else {
                iHy = 0;
            }
            com.bytedance.msdk.core.uy.g gVarZ = com.bytedance.msdk.e.z.dl.z().z(key, iHy, 101);
            if (gVarZ != null && gVarZ.e() == 1 && (value = entry.getValue()) != null) {
                Iterator<Map.Entry<String, List<e>>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    List<e> value4 = it2.next().getValue();
                    if (value4 != null && !value4.isEmpty() && value4.get(0) != null && value4.get(0).z != null) {
                        x.z(value4);
                        e eVar = value4.get(0);
                        g(eVar.z.hy(), eVar.z.u());
                    }
                }
            }
        }
        com.bytedance.msdk.core.v.g.z(com.bytedance.msdk.core.g.g()).z(2);
    }

    public void g(int i, double d) {
        if (com.bytedance.msdk.core.g.g().y()) {
            String strValueOf = String.valueOf(i);
            double[] dArr = this.f386a.get(strValueOf);
            if (dArr == null) {
                dArr = new double[2];
            }
            dArr[0] = dArr[0] + 1.0d;
            dArr[1] = dArr[1] + d;
            this.f386a.put(strValueOf, dArr);
        }
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected void z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("cpm_key_")) {
            return;
        }
        this.dl.put(str, str2);
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected Map<String, String> z() {
        return this.dl;
    }

    @Override // com.bytedance.msdk.core.fo.z
    protected void z(String str, int i, String str2) {
        if (i == 2) {
            this.dl.put(str, str2);
        }
    }
}
