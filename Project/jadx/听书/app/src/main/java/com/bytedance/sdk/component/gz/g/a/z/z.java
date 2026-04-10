package com.bytedance.sdk.component.gz.g.a.z;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.gz.z.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f729a;
    private byte dl;
    private long e;
    private String fo;
    private g g;
    private long gc;
    private String gz;
    private String kb;
    private long m;
    private byte uy;
    private int wp;
    protected JSONObject z;

    public z(String str, JSONObject jSONObject) {
        this.fo = str;
        this.z = jSONObject;
    }

    public z(String str, g gVar) {
        this.fo = str;
        this.g = gVar;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public g z() {
        return this.g;
    }

    private z() {
    }

    public void dl(String str) {
        this.kb = str;
    }

    public String uy() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public synchronized JSONObject e() {
        g gVar;
        if (this.z == null && (gVar = this.g) != null) {
            this.z = gVar.z(uy());
        }
        return this.z;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void z(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public static com.bytedance.sdk.component.gz.z.g a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt("priority");
            z zVar = new z();
            zVar.z((byte) iOptInt);
            zVar.g((byte) iOptInt2);
            zVar.z(jSONObject.optJSONObject(NotificationCompat.CATEGORY_EVENT));
            zVar.z(jSONObject.optString("localId"));
            zVar.g(jSONObject.optString("genTime"));
            zVar.z(jSONObject.optInt("channel"));
            return zVar;
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public void dl(byte b) {
        this.uy = b;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public byte g() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public String dl() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public byte a() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void z(byte b) {
        this.dl = b;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void z(String str) {
        this.fo = str;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void g(String str) {
        this.gz = str;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void z(long j) {
        this.gc = j;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public long gz() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void g(long j) {
        this.m = j;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public long fo() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void dl(long j) {
        this.e = j;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void z(int i) {
        this.wp = i;
    }

    public String kb() {
        return this.gz;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public void g(byte b) {
        this.f729a = b;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public byte gc() {
        return this.f729a;
    }

    @Override // com.bytedance.sdk.component.gz.z.g
    public String m() {
        if (TextUtils.isEmpty(this.fo)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.fo);
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, e());
            jSONObject.put("genTime", kb());
            jSONObject.put("priority", (int) this.f729a);
            jSONObject.put("type", (int) this.dl);
            jSONObject.put("channel", this.wp);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
