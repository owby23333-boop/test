package com.bytedance.sdk.openadsdk.core.iq;

import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hh {
    private int dl;
    private long g;
    private int z;

    public static hh z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        hh hhVar = new hh();
        hhVar.z = jSONObject.optInt("refresh_control", 0);
        hhVar.g = jSONObject.optLong("refresh_imp_max_time", 0L);
        hhVar.dl = jSONObject.optInt("refresh_num", 0);
        return hhVar;
    }

    public void g(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.z);
            jSONObject.put("refresh_imp_max_time", this.g);
            jSONObject.put("refresh_num", this.dl);
        } catch (JSONException unused) {
        }
    }

    public static boolean z(na naVar) {
        hh hhVarDp;
        return (naVar == null || (hhVarDp = naVar.dp()) == null || hhVarDp.z() != 1) ? false : true;
    }

    public int z() {
        return this.z;
    }

    public long g() {
        return this.g;
    }

    public int dl() {
        return this.dl;
    }

    public static int g(na naVar) {
        hh hhVarDp;
        if (naVar == null || (hhVarDp = naVar.dp()) == null) {
            return 0;
        }
        return hhVarDp.dl();
    }

    public static boolean z(List<na> list) {
        Iterator<na> it = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().tk() == 100.0f) {
                z = true;
            } else {
                z2 = true;
            }
        }
        return (z && z2) ? false : true;
    }

    public static boolean dl(na naVar) {
        return com.bytedance.sdk.openadsdk.core.zw.g().ls(String.valueOf(com.bytedance.sdk.openadsdk.core.un.eo.fo(naVar))) && z(naVar) && !com.bytedance.sdk.openadsdk.core.pf.a.z(String.valueOf(com.bytedance.sdk.openadsdk.core.un.eo.fo(naVar)));
    }
}
