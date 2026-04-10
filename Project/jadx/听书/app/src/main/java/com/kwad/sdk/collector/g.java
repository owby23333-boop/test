package com.kwad.sdk.collector;

import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int avh;
    private String avg;
    private int state;

    public static JSONArray w(List<g> list) {
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

    public g(String str, int i) {
        this.avg = str;
        this.state = i;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", DJ());
            jSONObject.put("state", this.state);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        return jSONObject;
    }

    private String DJ() {
        int iLastIndexOf;
        String str = this.avg;
        return !TextUtils.isEmpty(str) ? ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (iLastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) < str.length() + (-1)) ? str.substring(iLastIndexOf + 1) : str : str;
    }
}
