package com.yuewen;

import android.text.TextUtils;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ks {
    public static final String c = "mix";
    public static final String d = "male";
    public static final String e = "female";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f13595b;

    public ks(String str, List<String> list) {
        this.f13594a = str;
        this.f13595b = list;
    }

    public static ks a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("title");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONObject("data").optJSONArray("data");
        String strC = c();
        List arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= jSONArrayOptJSONArray.length()) {
                break;
            }
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (TextUtils.equals(strC, jSONObjectOptJSONObject.optString("desc"))) {
                arrayList = e(jSONObjectOptJSONObject.optJSONObject("data").optJSONArray("data"));
                break;
            }
            i++;
        }
        return new ks(strOptString, arrayList);
    }

    public static List<ks> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(a(jSONArray.optJSONObject(i)));
        }
        return arrayList;
    }

    public static String c() {
        String strH = DkSharedStorageManager.f().h();
        return TextUtils.equals("4", strH) ? "female" : TextUtils.equals("3", strH) ? "male" : TextUtils.equals("2", strH) ? "mix" : "";
    }

    public static List<String> e(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optJSONObject(i).optString("cover"));
        }
        return arrayList;
    }

    public List<String> d() {
        return this.f13595b;
    }

    public String f() {
        return this.f13594a;
    }
}
