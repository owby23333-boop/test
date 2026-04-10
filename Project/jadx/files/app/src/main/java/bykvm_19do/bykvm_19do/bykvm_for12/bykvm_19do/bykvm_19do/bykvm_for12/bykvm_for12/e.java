package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f828e = new Object();
    private Context a;
    private d b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f830d;

    public e(Context context, boolean z2, int i2) {
        this.f829c = true;
        this.a = context;
        this.f829c = z2;
        this.f830d = i2;
    }

    private d b(JSONObject jSONObject) {
        try {
            d dVar = new d();
            if (jSONObject.has("local_enable")) {
                dVar.a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                dVar.b = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                dVar.f817c = map;
            } else {
                dVar.f817c = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                dVar.f818d = map2;
            } else {
                dVar.f818d = null;
            }
            dVar.f819e = jSONObject.optInt("req_to_cnt", dVar.f819e);
            dVar.f820f = jSONObject.optInt("req_to_api_cnt", dVar.f820f);
            dVar.f821g = jSONObject.optInt("req_to_ip_cnt", dVar.f821g);
            dVar.f822h = jSONObject.optInt("req_err_cnt", dVar.f822h);
            dVar.f823i = jSONObject.optInt("req_err_api_cnt", dVar.f823i);
            dVar.f824j = jSONObject.optInt("req_err_ip_cnt", dVar.f824j);
            dVar.f825k = jSONObject.optInt("update_interval", dVar.f825k);
            dVar.f826l = jSONObject.optInt("update_random_range", dVar.f826l);
            dVar.f827m = jSONObject.optString("http_code_black", dVar.f827m);
            return dVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public d a() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        String str;
        if (!this.f829c) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", "handleConfigChanged: no mainProc");
            return;
        }
        h.a().a(this.f830d).h();
        try {
            boolean z2 = jSONObject.optInt("ttnet_url_dispatcher_enabled", 0) > 0;
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ttnet_dispatch_actions");
            JSONObject jSONObject2 = null;
            if (h.a().a(this.f830d).g() && z2 && jSONArrayOptJSONArray != null) {
                ArrayList<JSONObject> arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObject3 = ((JSONObject) jSONArrayOptJSONArray.get(i2)).getJSONObject("param");
                    if (jSONObject3.optString("service_name", "").equals("idc_selection")) {
                        arrayList.add(jSONObject3.getJSONObject("strategy_info"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    jSONObject2 = new JSONObject();
                    for (JSONObject jSONObject4 : arrayList) {
                        Iterator<String> itKeys = jSONObject4.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject2.put(next, jSONObject4.getString(next));
                        }
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tnc_config");
            if (jSONObjectOptJSONObject == null && jSONObject2 == null) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.b("TNCConfigHandler", " tnc host_replace_map config is null");
            } else {
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                } else {
                    str = jSONObject2 != null ? "host_replace_map" : "host_replace_map";
                }
                jSONObjectOptJSONObject.put(str, jSONObject2);
            }
            d dVarB = b(jSONObjectOptJSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("handleConfigChanged, newConfig: ");
            sb.append(dVarB == null ? "null" : dVarB.toString());
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", sb.toString());
            if (dVarB == null) {
                synchronized (f828e) {
                    this.a.getSharedPreferences(h.a().a(this.f830d).f(), 0).edit().putString("tnc_config_str", "").apply();
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.a, 1, "", this.f830d);
                }
            } else {
                this.b = dVarB;
                String string = jSONObjectOptJSONObject.toString();
                synchronized (f828e) {
                    this.a.getSharedPreferences(h.a().a(this.f830d).f(), 0).edit().putString("tnc_config_str", string).apply();
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.a, 1, string, this.f830d);
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.b = new d();
                synchronized (f828e) {
                    this.a.getSharedPreferences(h.a().a(this.f830d).f(), 0).edit().putString("tnc_config_str", "").apply();
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.a, 1, "", this.f830d);
                }
            } catch (Throwable th2) {
                synchronized (f828e) {
                    this.a.getSharedPreferences(h.a().a(this.f830d).f(), 0).edit().putString("tnc_config_str", "").apply();
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.a, 1, "", this.f830d);
                    throw th2;
                }
            }
        }
    }

    public void b() {
        String str;
        if (this.f829c) {
            String string = this.a.getSharedPreferences(h.a().a(this.f830d).f(), 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                str = "loadLocalConfig: no existed";
            } else {
                try {
                    d dVarB = b(new JSONObject(string));
                    if (dVarB != null) {
                        this.b = dVarB;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("loadLocalConfig: ");
                    sb.append(dVarB == null ? "null" : dVarB.toString());
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", sb.toString());
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    str = "loadLocalConfig: except: " + th.getMessage();
                }
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", str);
        }
    }

    public void c() {
        try {
            String strA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(this.a, 1, this.f830d);
            if (TextUtils.isEmpty(strA)) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            d dVarB = b(new JSONObject(strA));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            sb.append(dVarB == null ? "null" : dVarB.toString());
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", sb.toString());
            if (dVarB != null) {
                this.b = dVarB;
            }
        } catch (Throwable th) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }
}
