package com.duokan.reader.ui.store.data.cms;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Ti implements Serializable {
    public int month;
    public int top;
    public int year;

    public static Ti parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Ti ti = new Ti();
            JSONObject jSONObject = new JSONObject(str);
            ti.year = jSONObject.getInt("year");
            ti.month = jSONObject.getInt("month");
            ti.top = jSONObject.getInt("top");
            return ti;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
