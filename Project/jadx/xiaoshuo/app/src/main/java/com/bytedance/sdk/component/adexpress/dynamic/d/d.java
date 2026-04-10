package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private JSONObject bf;
    private HashMap<String, Object> e = new HashMap<>();

    public d(JSONObject jSONObject) {
        this.bf = jSONObject;
    }

    public boolean bf(String str) {
        return this.e.containsKey(str);
    }

    public Object e(String str) {
        if (this.e.containsKey(str)) {
            return this.e.get(str);
        }
        return null;
    }

    public void e() {
        Iterator<String> itKeys = this.bf.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.bf.opt(next);
            int i = 0;
            if (TextUtils.equals("image", next)) {
                if (objOpt instanceof JSONArray) {
                    while (true) {
                        JSONArray jSONArray = (JSONArray) objOpt;
                        if (i < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    Object objOpt2 = jSONObjectOptJSONObject.opt(next2);
                                    this.e.put(next + Consts.DOT + i + Consts.DOT + next2, objOpt2);
                                }
                            }
                            i++;
                        }
                    }
                }
            } else if (TextUtils.equals("dynamic_creative", next)) {
                if (objOpt instanceof String) {
                    try {
                        JSONObject jSONObject = new JSONObject((String) objOpt);
                        Iterator<String> itKeys3 = jSONObject.keys();
                        while (itKeys3.hasNext()) {
                            String next3 = itKeys3.next();
                            Object objOpt3 = jSONObject.opt(next3);
                            if ((objOpt3 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i2 = 0; i2 < ((JSONArray) objOpt3).length(); i2++) {
                                    this.e.put(next + Consts.DOT + next3 + Consts.DOT + i2, ((JSONArray) objOpt3).opt(i2));
                                }
                            } else {
                                this.e.put(next + Consts.DOT + next3, objOpt3);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (!(objOpt instanceof JSONObject)) {
                this.e.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.e.put(next, objOpt);
                }
            } else if (objOpt != null) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                Iterator<String> itKeys4 = jSONObject2.keys();
                while (itKeys4.hasNext()) {
                    String next4 = itKeys4.next();
                    Object objOpt4 = jSONObject2.opt(next4);
                    this.e.put(next + Consts.DOT + next4, objOpt4);
                }
            }
        }
    }
}
