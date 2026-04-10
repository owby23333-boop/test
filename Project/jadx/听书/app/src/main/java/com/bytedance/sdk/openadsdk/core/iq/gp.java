package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1165a;
    private String dl;
    private String g;
    private String gc;
    private ArrayList<bm> m;
    private int z;

    public gp(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.z = 0;
        this.dl = "再看一个获取";
        this.f1165a = "更多奖励";
        this.m = new ArrayList<>();
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("play_again")) == null) {
            return;
        }
        this.z = jSONObjectOptJSONObject.optInt("again_type", 0);
        this.dl = jSONObjectOptJSONObject.optString("entrance_prefix", "再看一个获取");
        this.f1165a = jSONObjectOptJSONObject.optString("entrance_suffix", "更多奖励");
        this.g = jSONObjectOptJSONObject.optString("pre_sessions");
        this.gc = jSONObjectOptJSONObject.optString("play_again_rit");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("again_dialog_config");
        if (jSONArrayOptJSONArray != null) {
            this.m = new ArrayList<>();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject2 != null) {
                    this.m.add(new bm(jSONObjectOptJSONObject2));
                }
            }
        }
    }

    public void z(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.z);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        try {
            jSONObject2.put("entrance_prefix", this.dl);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        try {
            jSONObject2.put("entrance_suffix", this.f1165a);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.wp.z(e3);
        }
        try {
            jSONObject2.put("pre_sessions", this.g);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.wp.z(e4);
        }
        try {
            jSONObject2.put("play_again_rit", this.gc);
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.wp.z(e5);
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<bm> arrayList = this.m;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<bm> it = this.m.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().z());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.wp.z(e6);
            }
        } catch (JSONException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static boolean z(na naVar) {
        gp gpVarM = m(naVar);
        if (gpVarM == null || y.z(naVar)) {
            return false;
        }
        int i = gpVarM.z;
        return (i == 1 || i == 2 || i == 3) && !TextUtils.isEmpty(gpVarM.g);
    }

    public static boolean g(na naVar) {
        gp gpVarM = m(naVar);
        if (gpVarM == null) {
            return false;
        }
        int i = gpVarM.z;
        return (i == 1 || i == 3) && z(naVar);
    }

    public static String dl(na naVar) {
        gp gpVarM = m(naVar);
        if (gpVarM == null) {
            return null;
        }
        return gpVarM.g;
    }

    public static String a(na naVar) {
        gp gpVarM = m(naVar);
        if (gpVarM == null) {
            return null;
        }
        return gpVarM.gc;
    }

    public static String z(String str) {
        return str + "again";
    }

    public static String g(String str) {
        return str + "custom_again";
    }

    public static String z(na naVar, String str, String str2) {
        gp gpVarM = m(naVar);
        if (gpVarM == null) {
            return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) ? "再看一个获取更多奖励" : "再看一个获取" + str2 + str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(gpVarM.dl) ? "再看一个获取" : gpVarM.dl);
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            sb.append(str2);
            sb.append(str);
        } else {
            sb.append(TextUtils.isEmpty(gpVarM.f1165a) ? "更多奖励" : gpVarM.f1165a);
        }
        return sb.toString();
    }

    public static ArrayList<bm> gc(na naVar) {
        gp gpVarM = m(naVar);
        if (gpVarM != null) {
            return gpVarM.m;
        }
        return new ArrayList<>();
    }

    private static gp m(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.w();
    }
}
