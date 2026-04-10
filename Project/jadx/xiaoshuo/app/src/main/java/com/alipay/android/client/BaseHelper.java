package com.alipay.android.client;

import com.iflytek.aikit.media.param.MscKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BaseHelper {
    public static JSONObject string2JSON(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String[] strArrSplit = str.split(str2);
            for (int i = 0; i < strArrSplit.length; i++) {
                String str3 = strArrSplit[i].split(MscKeys.KEY_VAL_SEP)[0];
                jSONObject.put(str3, strArrSplit[i].substring(str3.length() + 1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
