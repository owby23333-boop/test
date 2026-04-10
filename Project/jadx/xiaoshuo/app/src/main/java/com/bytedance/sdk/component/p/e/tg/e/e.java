package com.bytedance.sdk.component.p.e.tg.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.sdk.component.p.e.tg.e {
    private bf bf;
    private byte d;
    protected JSONObject e;
    private long ga;
    private byte m;
    private long p;
    private byte tg;
    private String v;
    private long vn;
    private String wu;
    private String zk;

    public e(String str, JSONObject jSONObject) {
        this.zk = str;
        this.e = jSONObject;
    }

    public static com.bytedance.sdk.component.p.e.tg.e tg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt("priority");
            e eVar = new e();
            eVar.e((byte) iOptInt);
            eVar.bf((byte) iOptInt2);
            eVar.e(jSONObject.optJSONObject("event"));
            eVar.e(jSONObject.optString("localId"));
            eVar.bf(jSONObject.optString("genTime"));
            return eVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public byte bf() {
        return this.m;
    }

    public void d(String str) {
        this.wu = str;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public bf e() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public byte ga() {
        return this.tg;
    }

    public String m() {
        return this.wu;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public synchronized JSONObject p() {
        bf bfVar;
        if (this.e == null && (bfVar = this.bf) != null) {
            this.e = bfVar.e(m());
        }
        return this.e;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public long v() {
        return this.ga;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public String vn() {
        if (TextUtils.isEmpty(this.zk)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.zk);
            jSONObject.put("event", p());
            jSONObject.put("genTime", wu());
            jSONObject.put("priority", (int) this.tg);
            jSONObject.put("type", (int) this.d);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String wu() {
        return this.v;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public long zk() {
        return this.vn;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public void bf(String str) {
        this.v = str;
    }

    public void d(byte b2) {
        this.m = b2;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public void e(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public void bf(long j) {
        this.vn = j;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public String d() {
        return this.zk;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public void e(byte b2) {
        this.d = b2;
    }

    public e(String str, bf bfVar) {
        this.zk = str;
        this.bf = bfVar;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public void bf(byte b2) {
        this.tg = b2;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public void d(long j) {
        this.p = j;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public void e(String str) {
        this.zk = str;
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public void e(long j) {
        this.ga = j;
    }

    private e() {
    }

    @Override // com.bytedance.sdk.component.p.e.tg.e
    public byte tg() {
        return this.d;
    }
}
