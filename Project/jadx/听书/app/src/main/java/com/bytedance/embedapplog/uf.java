package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uf extends sy {
    private final Map<String, h> gc;
    private final List<String> m;

    public uf(Context context, q qVar, hh hhVar) {
        super(context, qVar, hhVar);
        this.gc = new HashMap();
        this.m = new ArrayList();
    }

    @Override // com.bytedance.embedapplog.sy
    protected List<String> z() {
        this.m.add("d_i0");
        this.m.add("d_a0");
        return this.m;
    }

    public void z(final JSONObject jSONObject, final String str) {
        js.z("__kite", "doReport");
        x.z().postDelayed(new Runnable() { // from class: com.bytedance.embedapplog.uf.1
            @Override // java.lang.Runnable
            public void run() {
                js.z("__kite", "run()");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObjectZ = o.z(jSONObject, str);
                    String strZ = uf.this.dl.z("d_data");
                    if (!TextUtils.isEmpty(strZ)) {
                        jSONObject2.putOpt("message", "ok");
                        jSONObject2.putOpt("data", strZ);
                        js.z("__kite", "config from cache");
                    } else {
                        JSONObject jSONObject3 = new JSONObject();
                        String strG = o.g(jSONObjectZ);
                        jSONObject3.putOpt("header", strG);
                        if (js.g()) {
                            js.z("__kite", "config 请求header进行sword加密：加密内容：".concat(String.valueOf(jSONObjectZ)));
                            js.z("__kite", "config 请求header进行sword加密：加密结果：".concat(String.valueOf(strG)));
                        }
                        jSONObject3.putOpt("fetch_config", Boolean.TRUE);
                        jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        jSONObject2 = gk.z(uf.this.g, jSONObject3, uf.this.z(jSONObjectZ));
                        js.z("__kite", "config from server.");
                    }
                    if (js.g()) {
                        js.z("__kite", "config: ".concat(String.valueOf(jSONObject2)));
                    }
                    uf.this.f300a.z(jSONObject2);
                    uf.this.z(5L);
                    uf.this.g();
                    uf.this.dl();
                    uf.this.g(jSONObjectZ);
                } catch (Exception e) {
                    js.a("__kite", "error " + e.getMessage());
                }
            }
        }, this.f300a.dl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        for (Map.Entry<String, h> entry : this.gc.entrySet()) {
            if (TextUtils.equals(entry.getKey(), "d_i0")) {
                JSONObject jSONObjectG = entry.getValue().g();
                e eVarE = o.e();
                if (eVarE != null && jSONObjectG != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObjectG.optJSONObject("data");
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        arrayList.add(itKeys.next());
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    int[] iArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        iArr[i] = jSONObjectOptJSONObject.optInt(strArr[i]);
                    }
                    eVarE.z(strArr, iArr, false);
                    return;
                }
            }
        }
    }

    public void z(long j) {
        Map<String, JSONObject> mapZ = this.f300a.z();
        if (mapZ.isEmpty()) {
            js.z("__kite", "map is empty");
        } else {
            z(mapZ, j);
        }
    }

    public void g() {
        if (this.z.size() <= 0) {
            js.z("__kite", "return");
            return;
        }
        for (int i = 0; i < this.z.size(); i++) {
            try {
                h hVar = this.z.get(i).get();
                this.gc.put(hVar.z(), hVar);
                if (js.g()) {
                    js.z("__kite", "result: ".concat(String.valueOf(hVar)));
                }
            } catch (Exception e) {
                js.a("__kite", "error " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final JSONObject jSONObject) {
        if (this.gc.size() <= 0) {
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, h> entry : this.gc.entrySet()) {
            try {
                JSONObject jSONObjectG = entry.getValue().g();
                jSONObject2.putOpt(entry.getKey(), o.g(jSONObjectG));
                if (js.g()) {
                    js.z("__kite", "report 请求data中的字段进行sword加密：加密内容：".concat(String.valueOf(jSONObjectG)));
                }
            } catch (JSONException e) {
                js.a("__kite", "error " + e.getMessage());
            }
        }
        x.z(new Runnable() { // from class: com.bytedance.embedapplog.uf.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject.putOpt(an.ai, Build.MODEL);
                    jSONObject.putOpt("device_platform", "android");
                    jSONObject3.putOpt("header", o.g(jSONObject));
                    if (js.g()) {
                        js.z("__kite", "report 请求header进行sword加密：加密内容：" + jSONObject);
                    }
                    jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject3.putOpt("data", jSONObject2);
                    jSONObject3.putOpt("version", Integer.valueOf(uf.this.f300a.g()));
                } catch (Exception e2) {
                    js.z("__kite", "error: " + e2.getMessage());
                }
                JSONObject jSONObjectZ = gk.z(uf.this.g, jSONObject3, uf.this.z(jSONObject));
                if (js.g()) {
                    js.dl("__kite", "response:".concat(String.valueOf(jSONObjectZ)));
                }
                uf.this.f300a.g(jSONObjectZ);
            }
        });
    }
}
