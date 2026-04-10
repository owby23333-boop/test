package com.tencent.smtt.sdk.a;

import cn.bmob.v3.datatype.up.Params;
import com.baidu.tts.emstatistics.SynthesizeResultDb;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f18989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f18990d;

    private b() {
    }

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = jSONObject.optInt("id", -1);
        bVar.b = jSONObject.optInt(SynthesizeResultDb.KEY_CMD_ID, -1);
        bVar.f18989c = jSONObject.optString("ext_params", "");
        bVar.f18990d = jSONObject.optLong(Params.EXPIRATION, 0L) * 1000;
        return bVar;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public String c() {
        return this.f18989c;
    }

    public long d() {
        return this.f18990d;
    }

    public boolean e() {
        return System.currentTimeMillis() > this.f18990d;
    }

    public String toString() {
        return "[id=" + this.a + ", cmd=" + this.b + ", extra='" + this.f18989c + "', expiration=" + a.a(this.f18990d) + ']';
    }
}
