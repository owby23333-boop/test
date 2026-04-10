package com.sntech.okhttpconnection.log;

import android.content.Context;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.new, reason: invalid class name */
/* JADX INFO: compiled from: DigManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cnew {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static Map<String, List> f122do = new HashMap();

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m138do(Context context, JSONArray jSONArray) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(BaseMonitor.COUNT_POINT_DNS, jSONArray);
            m139do(jSONObject);
            context.getSharedPreferences("sn_prefs_logs", 0).edit().putString("dig_domains", jSONObject.toString()).apply();
        } catch (JSONException e2) {
            if (Cdo.m119do()) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m139do(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(BaseMonitor.COUNT_POINT_DNS);
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getJSONObject(i2).getString(Constants.KEY_HOST);
                JSONArray jSONArray2 = jSONArray.getJSONObject(i2).getJSONArray("ips");
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList.add(jSONArray2.getString(i3));
                }
                ((HashMap) f122do).put(string, arrayList);
            }
        }
    }
}
