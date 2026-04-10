package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class j implements h {
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> b = new HashMap();
    private e0 a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.T();

    j() {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.h
    public void a(Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> map) {
        String strB;
        JSONArray jSONArray = new JSONArray();
        this.b.clear();
        Iterator<Map.Entry<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c value = it.next().getValue();
            if (value != null && value.s() == 3 && value.r() != null) {
                this.b.put(value.q(), value);
                jSONArray.put(value.r());
            }
        }
        if (jSONArray.length() <= 0 || (strB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(jSONArray.toString(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) == null || TextUtils.isEmpty(strB)) {
            return;
        }
        this.a.b("splash_config", strB);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.h
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c(String str) {
        String strA;
        if (!TextUtils.isEmpty(str)) {
            Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> map = this.b;
            if (map != null && map.get(str) != null) {
                return this.b.get(str);
            }
            e0 e0Var = this.a;
            if (e0Var != null && (strA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(e0Var.d("splash_config"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) != null && !TextUtils.isEmpty(strA)) {
                this.b.clear();
                try {
                    JSONArray jSONArray = new JSONArray(strA);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarB = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c.b(jSONArray.getJSONObject(i2));
                        if (cVarB != null) {
                            this.b.put(cVarB.q(), cVarB);
                        }
                    }
                    return this.b.get(str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }
}
