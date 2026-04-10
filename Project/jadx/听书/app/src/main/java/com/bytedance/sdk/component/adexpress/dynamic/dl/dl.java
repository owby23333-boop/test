package com.bytedance.sdk.component.adexpress.dynamic.dl;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.funny.audio.core.utils.FileUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private JSONObject g;
    private HashMap<String, Object> z = new HashMap<>();

    public dl(JSONObject jSONObject) {
        this.g = jSONObject;
    }

    public Object z(String str) {
        if (this.z.containsKey(str)) {
            return this.z.get(str);
        }
        return null;
    }

    public boolean g(String str) {
        return this.z.containsKey(str);
    }

    public void z() {
        Iterator<String> itKeys = this.g.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = this.g.opt(next);
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
                                    this.z.put(next + FileUtils.FILE_EXTENSION_SEPARATOR + i + FileUtils.FILE_EXTENSION_SEPARATOR + next2, jSONObjectOptJSONObject.opt(next2));
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
                            Object objOpt2 = jSONObject.opt(next3);
                            if ((objOpt2 instanceof JSONArray) && !TextUtils.equals(next3, "short_phrase") && !TextUtils.equals(next3, "long_phrase")) {
                                for (int i2 = 0; i2 < ((JSONArray) objOpt2).length(); i2++) {
                                    this.z.put(next + FileUtils.FILE_EXTENSION_SEPARATOR + next3 + FileUtils.FILE_EXTENSION_SEPARATOR + i2, ((JSONArray) objOpt2).opt(i2));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "coupon")) {
                                Iterator<String> itKeys4 = ((JSONObject) objOpt2).keys();
                                while (itKeys4.hasNext()) {
                                    String next4 = itKeys4.next();
                                    this.z.put(next + FileUtils.FILE_EXTENSION_SEPARATOR + next3 + FileUtils.FILE_EXTENSION_SEPARATOR + next4, ((JSONObject) objOpt2).opt(next4));
                                }
                            } else if ((objOpt2 instanceof JSONObject) && TextUtils.equals(next3, "live_room_data")) {
                                z(next, next3, objOpt2);
                            } else {
                                this.z.put(next + FileUtils.FILE_EXTENSION_SEPARATOR + next3, objOpt2);
                            }
                        }
                    } catch (JSONException e) {
                        wp.z(e);
                    }
                }
            } else if (!(objOpt instanceof JSONObject)) {
                this.z.put(next, objOpt);
                if (objOpt instanceof String) {
                    this.z.put(next, objOpt);
                }
            } else if (objOpt != null) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                Iterator<String> itKeys5 = jSONObject2.keys();
                while (itKeys5.hasNext()) {
                    String next5 = itKeys5.next();
                    this.z.put(next + FileUtils.FILE_EXTENSION_SEPARATOR + next5, jSONObject2.opt(next5));
                }
            }
        }
    }

    private void z(String str, String str2, Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if ((objOpt instanceof JSONArray) && TextUtils.equals(next, "product_infos")) {
                int i = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (i < jSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            this.z.put(str + FileUtils.FILE_EXTENSION_SEPARATOR + str2 + FileUtils.FILE_EXTENSION_SEPARATOR + next + FileUtils.FILE_EXTENSION_SEPARATOR + i + FileUtils.FILE_EXTENSION_SEPARATOR + next2, jSONObjectOptJSONObject.opt(next2));
                        }
                        i++;
                    }
                }
            } else {
                this.z.put(str + FileUtils.FILE_EXTENSION_SEPARATOR + str2 + FileUtils.FILE_EXTENSION_SEPARATOR + next, objOpt);
            }
        }
    }
}
