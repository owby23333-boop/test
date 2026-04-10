package com.kwad.sdk.collector;

import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int aaP;
    private String aaO;
    private int state;

    public g(String str, int i2) {
        this.state = aaP;
        this.aaO = str;
        this.state = i2;
    }

    public static JSONArray m(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toJson());
        }
        return jSONArray;
    }

    private String tS() {
        int iLastIndexOf;
        String str = this.aaO;
        return ((str.startsWith("com.android.") || this.aaO.startsWith("android.permission")) && (iLastIndexOf = this.aaO.lastIndexOf(".")) < this.aaO.length() + (-1)) ? this.aaO.substring(iLastIndexOf + 1) : str;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", tS());
            jSONObject.put(CallMraidJS.b, this.state);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        return jSONObject;
    }
}
