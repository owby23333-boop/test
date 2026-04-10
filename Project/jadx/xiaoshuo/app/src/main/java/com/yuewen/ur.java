package com.yuewen;

import android.text.TextUtils;
import com.duokan.core.diagnostic.LogLevel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ur {
    public static final String e = "BookshelfEventData";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18564b;
    public final String c;
    public final String d;

    public ur(String str, String str2, String str3, String str4) {
        this.f18563a = str;
        this.f18564b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static ur a(JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("title_text"))) {
            return null;
        }
        return new ur(jSONObject.optString("title_text"), jSONObject.optString("action_text"), "", jSONObject.optString("action_url"));
    }

    public static List<ur> d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("extend");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("shelf_title");
                    String strOptString2 = jSONObjectOptJSONObject.optString("shelf_button");
                    String strOptString3 = jSONObjectOptJSONObject.optString("img/shelf");
                    String strOptString4 = "";
                    if (!TextUtils.isEmpty(strOptString3)) {
                        try {
                            JSONArray jSONArray2 = new JSONArray(strOptString3);
                            if (jSONArray2.length() > 0) {
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    strOptString4 = jSONArray2.getJSONObject(i2).optString("url");
                                    if (!TextUtils.isEmpty(strOptString4)) {
                                        break;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            ia0.w().j(LogLevel.ERROR, e, "parse event list error inner", th);
                        }
                    }
                    ur urVar = new ur(strOptString, strOptString2, strOptString4, jSONObject2.optString("id"));
                    if (urVar.c()) {
                        arrayList.add(urVar);
                    }
                }
            }
        } catch (Throwable th2) {
            ia0.w().j(LogLevel.ERROR, e, "parse event list error", th2);
        }
        return arrayList;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.c);
    }

    public boolean c() {
        return (TextUtils.isEmpty(this.f18563a) || TextUtils.isEmpty(this.d) || (TextUtils.isEmpty(this.f18564b) && TextUtils.isEmpty(this.c))) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ur)) {
            return false;
        }
        ur urVar = (ur) obj;
        return TextUtils.equals(this.f18563a, urVar.f18563a) && TextUtils.equals(this.f18564b, urVar.f18564b) && TextUtils.equals(this.d, urVar.d);
    }
}
