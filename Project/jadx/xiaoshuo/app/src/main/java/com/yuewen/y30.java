package com.yuewen;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class y30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f20203a;

    public interface a {
        String a(String str, String str2);

        void b(String str, String str2);
    }

    public y30(a aVar) {
        this.f20203a = aVar;
    }

    public String a(JSONObject jSONObject, String str, String str2) {
        String strA = this.f20203a.a(str, str2);
        String strOptString = jSONObject.optString(str, strA);
        if (TextUtils.isEmpty(strOptString)) {
            return strA;
        }
        if (!TextUtils.equals(strOptString, strA)) {
            this.f20203a.b(str, strOptString);
        }
        return strOptString;
    }
}
