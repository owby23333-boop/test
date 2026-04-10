package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class dq0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10316a;

    public static dq0 e(JSONObject jSONObject) throws JSONException {
        dq0 dq0Var = new dq0();
        dq0Var.f10316a = jSONObject.optString("url");
        return dq0Var;
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return 0L;
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return "";
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return new User();
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
    }
}
