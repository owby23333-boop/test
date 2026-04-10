package com.yuewen;

import java.net.URLDecoder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class jp0 extends ng2 {
    public static final String f = "23";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13038b;
    public final String c;
    public final String d;
    public final String e;

    public jp0(String str, String str2) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        this.f13037a = URLDecoder.decode(jSONObject.optString("payment_envelope"));
        this.f13038b = URLDecoder.decode(jSONObject.optString("payment_id"));
        this.c = URLDecoder.decode(jSONObject.optString("payment_sender_sign"));
        this.d = str2;
        this.e = jSONObject.optString("vip_id", "");
    }

    public static jp0 f(String str, String str2) {
        try {
            return new jp0(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.yuewen.ng2
    public String a() {
        return this.f13037a;
    }

    @Override // com.yuewen.ng2
    public String b() {
        return this.f13038b;
    }

    @Override // com.yuewen.ng2
    public String c() {
        return this.d;
    }

    @Override // com.yuewen.ng2
    public String d() {
        return this.c;
    }

    public boolean e() {
        return "23".equals(this.e);
    }
}
