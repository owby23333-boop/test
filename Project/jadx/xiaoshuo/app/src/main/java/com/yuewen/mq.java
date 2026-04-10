package com.yuewen;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class mq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14422a = "25000000";

    public static List<String> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("categories");
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            while (true) {
                if (i >= jSONArrayOptJSONArray.length()) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(TTDownloadField.TT_LABEL);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                        break;
                    }
                }
                i++;
            }
        }
        return arrayList;
    }

    public static List<String> b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("categories");
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            while (true) {
                if (i >= jSONArrayOptJSONArray.length()) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && !f14422a.equals(jSONObjectOptJSONObject.optString("category_id"))) {
                    String strOptString = jSONObjectOptJSONObject.optString(TTDownloadField.TT_LABEL);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                        break;
                    }
                }
                i++;
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("dkfree_new_tags");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                if (!TextUtils.isEmpty(strOptString2)) {
                    arrayList.add(strOptString2);
                }
            }
        }
        return arrayList;
    }

    public static List<String> c(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("categories");
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            while (true) {
                if (i >= jSONArrayOptJSONArray.length()) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(TTDownloadField.TT_LABEL);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                        break;
                    }
                }
                i++;
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("new_tags");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                if (!TextUtils.isEmpty(strOptString2)) {
                    arrayList.add(strOptString2);
                }
            }
        }
        return arrayList;
    }

    public static List<String> d(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("categories");
        if (jSONArrayOptJSONArray != null) {
            int i = 0;
            while (true) {
                if (i >= jSONArrayOptJSONArray.length()) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(TTDownloadField.TT_LABEL);
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList.add(strOptString);
                        break;
                    }
                }
                i++;
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("tags");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                if (!TextUtils.isEmpty(strOptString2)) {
                    arrayList.add(strOptString2);
                }
            }
        }
        return arrayList;
    }

    public static List<String> e(@we2 String str, String str2) {
        try {
            return f(str, new JSONObject(str2));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> f(@we2 String str, JSONObject jSONObject) {
        str.hashCode();
        switch (str) {
            case "分类付费小说":
                return c(jSONObject);
            case "分类听书":
                return a(jSONObject);
            case "分类图书":
            case "分类杂志":
                return d(jSONObject);
            case "分类女生":
            case "分类男生":
                return b(jSONObject);
            default:
                return null;
        }
    }
}
