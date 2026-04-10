package com.tencent.smtt.sdk.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private int a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<b> f18997c;

    private d() {
    }

    public static d a(String str) {
        JSONException e2;
        d dVar;
        JSONObject jSONObject;
        if (str == null) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
            dVar = new d();
        } catch (JSONException e3) {
            e2 = e3;
            dVar = null;
        }
        try {
            dVar.a = jSONObject.optInt("ret_code", -1);
            dVar.b = jSONObject.optLong("next_req_interval", 1000L);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cmds");
            if (jSONArrayOptJSONArray == null) {
                return dVar;
            }
            dVar.f18997c = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                b bVarA = b.a(jSONArrayOptJSONArray.optJSONObject(i2));
                if (bVarA != null) {
                    dVar.f18997c.add(bVarA);
                }
            }
            return dVar;
        } catch (JSONException e4) {
            e2 = e4;
            e2.printStackTrace();
            return dVar;
        }
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public List<b> c() {
        return this.f18997c;
    }
}
