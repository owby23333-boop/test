package t0;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MsaManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {
    public String a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f21710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21712f;

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorCode", this.f21711e);
        jSONObject.put("isSupported", this.f21712f);
        jSONObject.put("oaid", this.a);
        jSONObject.put("vaid", this.b);
        jSONObject.put("aaid", this.f21709c);
        jSONObject.put("takeMs", this.f21710d);
        return jSONObject;
    }
}
