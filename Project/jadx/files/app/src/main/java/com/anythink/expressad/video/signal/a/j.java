package com.anythink.expressad.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.api.ATAdConst;
import com.anythink.expressad.foundation.d.r;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.v;
import com.anythink.expressad.video.signal.a.c;
import com.anythink.expressad.video.signal.c;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j extends c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f11943t = "j";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f11944u = "正在下载中,请稍后...";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f11945z = "camp_position";
    private com.anythink.expressad.foundation.d.c A;
    private List<com.anythink.expressad.foundation.d.c> B;
    private int C;
    private String D = "";
    private String E = "";
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Activity f11946v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f11947w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f11948x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Context f11949y;

    public j(Activity activity, com.anythink.expressad.foundation.d.c cVar) {
        this.f11946v = activity;
        this.A = cVar;
    }

    private static JSONObject A() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.n.a().g()).a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject B() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f11929s);
            jSONObject2.put("instanceId", this.D);
            jSONObject.put("sdkSetting", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject C() {
        JSONObject jSONObject = new JSONObject();
        com.anythink.expressad.videocommon.e.d dVar = this.f11925o;
        return dVar != null ? dVar.R() : jSONObject;
    }

    private static JSONObject D() {
        JSONObject jSONObject = new JSONObject();
        com.anythink.expressad.videocommon.e.a aVarB = com.anythink.expressad.videocommon.e.c.a().b();
        return aVarB != null ? aVarB.k() : jSONObject;
    }

    private static boolean E() {
        return false;
    }

    private void c(boolean z2) {
        this.H = z2;
    }

    private void e(String str) {
        List<com.anythink.expressad.foundation.d.c> list;
        if (this.A == null || (list = this.B) == null || list.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(f11945z)) {
                this.A = this.B.get(jSONObject.getInt(f11945z));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private boolean s() {
        return this.H;
    }

    private String t() {
        JSONObject jSONObject = new JSONObject();
        com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.n.a().g());
        try {
            jSONObject.put("unit_id", this.f11924n);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("instanceId", this.D);
            jSONObject2.put("rootViewInstanceId", this.E);
            jSONObject2.put("isRootTemplateWebView", this.F);
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.anythink.expressad.out.b.a + ",3.0.1");
            jSONObject2.put("playVideoMute", this.f11929s);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", cVar.a());
            JSONArray jSONArray = new JSONArray();
            if (this.B == null || this.B.size() <= 0) {
                jSONArray.put(com.anythink.expressad.foundation.d.c.a(this.A));
            } else {
                for (com.anythink.expressad.foundation.d.c cVar2 : this.B) {
                    jSONArray.put(com.anythink.expressad.foundation.d.c.a(cVar2, cVar2.at(), c(cVar2)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", C());
            String strE = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            String strA = com.anythink.expressad.d.b.a(strE);
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject3 = new JSONObject(strA);
                a(jSONObject3);
                com.anythink.expressad.d.b.a();
                String strB = com.anythink.expressad.d.b.b(this.f11924n);
                if (!TextUtils.isEmpty(strB)) {
                    jSONObject3.put("ivreward", new JSONObject(strB));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", D());
            if (!TextUtils.isEmpty(this.f11924n)) {
                jSONObject.put("unit_id", this.f11924n);
            }
            jSONObject.put("rw_plus", this.G ? "1" : "0");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private com.anythink.expressad.a.a u() {
        if (this.f11927q == null) {
            this.f11927q = new com.anythink.expressad.a.a(com.anythink.core.common.b.n.a().g(), this.f11924n);
        }
        return this.f11927q;
    }

    private JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(com.anythink.core.common.b.n.a().g());
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.f11929s);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", cVar.a());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(com.anythink.expressad.foundation.d.c.a(this.A));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", C());
            String strE = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            String strA = com.anythink.expressad.d.b.a(strE);
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject3 = new JSONObject(strA);
                a(jSONObject3);
                com.anythink.expressad.d.b.a();
                String strB = com.anythink.expressad.d.b.b(this.f11924n);
                if (!TextUtils.isEmpty(strB)) {
                    jSONObject3.put("ivreward", strB);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", D());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.anythink.expressad.out.b.a + ",3.0.1");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f11924n)) {
                jSONObject.put("unit_id", this.f11924n);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject y() {
        JSONObject jSONObject = new JSONObject();
        try {
            String strE = com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            String strA = com.anythink.expressad.d.b.a(strE);
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("appSetting", new JSONObject(strA));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f11925o != null) {
                jSONObject.put("unitSetting", this.f11925o.R());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.A = cVar;
    }

    public final void b(boolean z2) {
        this.G = z2;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.d
    public void click(int i2, String str) {
        String queryParameter;
        List<com.anythink.expressad.foundation.d.c> list;
        super.click(i2, str);
        com.anythink.expressad.foundation.d.c cVar = this.A;
        if (cVar != null && cVar.k() == 5 && this.A != null && (list = this.B) != null && list.size() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(f11945z)) {
                    this.A = this.B.get(jSONObject.getInt(f11945z));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        boolean z2 = true;
        try {
            if (i2 != 1) {
                if (i2 != 3) {
                    return;
                }
                if (((this.A == null || this.A.g() <= -2) ? this.f11925o != null ? this.f11925o.p() : 1 : this.A.g()) == -1) {
                    a(new c.b(this, this.f11928r));
                }
                click(1, str);
                return;
            }
            if (this.A == null && this.B != null && this.B.size() > 0) {
                this.A = this.B.get(0);
            }
            if (this.A == null) {
                return;
            }
            com.anythink.expressad.foundation.d.c cVarA = a(str, this.A);
            try {
                queryParameter = Uri.parse(cVarA.ah()).getQueryParameter(com.anythink.expressad.foundation.g.a.cf);
            } catch (Throwable th) {
                com.anythink.expressad.foundation.h.o.b(f11943t, "INSTALL", th);
            }
            int i3 = !TextUtils.isEmpty(queryParameter) ? Integer.parseInt(queryParameter) : 0;
            c.a aVar = this.f11928r;
            if (i3 != 2) {
                z2 = false;
            }
            aVar.a(cVarA, z2);
            u().a(this.f11928r);
            u();
        } catch (Throwable th2) {
            com.anythink.expressad.foundation.h.o.b(f11943t, th2.getMessage(), th2);
        }
    }

    public final void d(String str) {
        this.E = str;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final String h(int i2) {
        switch (i2) {
            case 1:
                return w().toString();
            case 2:
                return x().toString();
            case 3:
                return y().toString();
            case 4:
                return z().toString();
            case 5:
                return A().toString();
            case 6:
                return B().toString();
            default:
                return v().toString();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i2, String str) {
        super.handlerH5Exception(i2, str);
        try {
            this.f11928r.a(i2, str);
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f11943t, th.getMessage(), th);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final String i() {
        this.f11928r.b();
        this.f11915e = true;
        if (TextUtils.isEmpty(this.f11947w)) {
            this.f11947w = t();
        }
        return this.f11947w;
    }

    public final void j(int i2) {
        this.C = i2;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void l() {
        super.l();
        c.a aVar = this.f11928r;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final String o() {
        com.anythink.expressad.foundation.h.o.a(f11943t, "getNotchArea");
        return this.f11948x;
    }

    public final void p() {
        this.F = true;
    }

    public final void q() {
        this.f11947w = "";
    }

    public final int r() {
        return this.C;
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        String queryParameter;
        try {
            queryParameter = Uri.parse(cVar.ah()).getQueryParameter(com.anythink.expressad.foundation.g.a.cf);
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f11943t, "INSTALL", th);
        }
        int i2 = !TextUtils.isEmpty(queryParameter) ? Integer.parseInt(queryParameter) : 0;
        this.f11928r.a(cVar, i2 == 2);
        u().a(this.f11928r);
        u();
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        this.B = list;
    }

    public final void c(String str) {
        this.D = str;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void j() {
        super.j();
        try {
            if (this.f11946v != null) {
                this.f11946v.finish();
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f11943t, th.getMessage(), th);
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            Context contextD = com.anythink.expressad.foundation.b.a.b().d();
            String string = v.b(contextD, "Anythink_ConfirmTitle" + this.f11924n, "").toString();
            String string2 = v.b(contextD, "Anythink_ConfirmContent" + this.f11924n, "").toString();
            String string3 = v.b(contextD, "Anythink_CancelText" + this.f11924n, "").toString();
            String string4 = v.b(contextD, "Anythink_ConfirmText" + this.f11924n, "").toString();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put(com.anythink.expressad.d.a.b.ct, string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cu, string2);
            }
            if (!TextUtils.isEmpty(string3)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cv, string3);
            }
            if (!TextUtils.isEmpty(string4)) {
                jSONObject.put(com.anythink.expressad.d.a.b.cx, string4);
            }
            if (TextUtils.isEmpty(string4)) {
                return;
            }
            jSONObject.put(com.anythink.expressad.d.a.b.cw, string4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(com.anythink.expressad.foundation.d.c r7) {
        /*
            com.anythink.expressad.foundation.b.a r0 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Exception -> L38
            java.lang.String r0 = r0.e()     // Catch: java.lang.Exception -> L38
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L38
            r1 = 0
            if (r0 != 0) goto L22
            com.anythink.expressad.d.b.a()     // Catch: java.lang.Exception -> L38
            com.anythink.expressad.d.a r0 = com.anythink.expressad.d.b.b()     // Catch: java.lang.Exception -> L38
            if (r0 == 0) goto L22
            long r3 = r0.l()     // Catch: java.lang.Exception -> L38
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            goto L23
        L22:
            r3 = r1
        L23:
            com.anythink.expressad.videocommon.e.c r0 = com.anythink.expressad.videocommon.e.c.a()     // Catch: java.lang.Exception -> L38
            com.anythink.expressad.videocommon.e.a r0 = r0.b()     // Catch: java.lang.Exception -> L38
            if (r0 == 0) goto L31
            long r1 = r0.c()     // Catch: java.lang.Exception -> L38
        L31:
            if (r7 == 0) goto L38
            boolean r7 = r7.a(r1, r3)     // Catch: java.lang.Exception -> L38
            return r7
        L38:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.a.j.c(com.anythink.expressad.foundation.d.c):boolean");
    }

    public j(Activity activity, com.anythink.expressad.foundation.d.c cVar, List<com.anythink.expressad.foundation.d.c> list) {
        this.f11946v = activity;
        this.A = cVar;
        this.B = list;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11948x = str;
    }

    private com.anythink.expressad.foundation.d.c a(String str, com.anythink.expressad.foundation.d.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        if (TextUtils.isEmpty(str) && cVar == null) {
            return null;
        }
        if (!str.contains("notice")) {
            try {
                JSONObject jSONObjectA = com.anythink.expressad.foundation.d.c.a(cVar);
                com.anythink.expressad.foundation.d.c cVarB = com.anythink.expressad.foundation.d.c.b(jSONObjectA);
                if (cVarB == null) {
                    cVarB = cVar;
                }
                if (!TextUtils.isEmpty(str)) {
                    a(jSONObjectA, cVarB);
                    JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject(com.anythink.expressad.foundation.g.a.ce);
                    if (jSONObjectOptJSONObject != null) {
                        String.valueOf(t.b(this.f11946v, Integer.valueOf(jSONObjectOptJSONObject.getString(com.anythink.expressad.foundation.g.a.cc)).intValue()));
                        String.valueOf(t.b(this.f11946v, Integer.valueOf(jSONObjectOptJSONObject.getString(com.anythink.expressad.foundation.g.a.cd)).intValue()));
                    }
                    cVarB.p(cVarB.ad());
                    String strAh = cVarB.ah();
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        StringBuilder sb = new StringBuilder();
                        while (itKeys.hasNext()) {
                            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                            String next = itKeys.next();
                            String strOptString = jSONObjectOptJSONObject.optString(next);
                            if (com.anythink.expressad.foundation.g.a.cc.equals(next) || com.anythink.expressad.foundation.g.a.cd.equals(next)) {
                                strOptString = String.valueOf(t.b(this.f11946v, Integer.valueOf(strOptString).intValue()));
                            }
                            sb.append(next);
                            sb.append("=");
                            sb.append(strOptString);
                        }
                        cVarB.q(strAh + ((Object) sb));
                    }
                }
                return cVarB;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return cVar;
            } catch (Throwable th) {
                th.printStackTrace();
                return cVar;
            }
        }
        try {
            JSONObject jSONObjectA2 = com.anythink.expressad.foundation.d.c.a(cVar);
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.opt(com.anythink.expressad.foundation.d.h.cv) == null) {
                jSONObject.put(com.anythink.expressad.foundation.d.h.cv, "");
            }
            try {
                if (!jSONObject.has(com.anythink.expressad.foundation.d.c.O)) {
                    jSONObjectA2.put(com.anythink.expressad.foundation.d.c.O, "");
                }
            } catch (Exception unused) {
            }
            Iterator<String> itKeys2 = jSONObject.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                jSONObjectA2.put(next2, jSONObject.getString(next2));
            }
            com.anythink.expressad.foundation.d.c cVarB2 = com.anythink.expressad.foundation.d.c.b(jSONObjectA2);
            a(jSONObjectA2, cVarB2);
            return cVarB2;
        } catch (JSONException e3) {
            e3.printStackTrace();
            return cVar;
        }
    }

    private static void a(JSONObject jSONObject, com.anythink.expressad.foundation.d.c cVar) {
        try {
            String strOptString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            cVar.l(strOptString);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(int i2, String str) {
        super.a(i2, str);
        if (i2 != 2) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("event", "event");
            String strOptString2 = jSONObject.optString("template", GMNetworkPlatformConst.AD_NETWORK_NO_PRICE);
            String strOptString3 = jSONObject.optString("layout", GMNetworkPlatformConst.AD_NETWORK_NO_PRICE);
            String strOptString4 = jSONObject.optString("unit_id", this.f11924n);
            this.f11946v.getApplication();
            int iA = com.anythink.expressad.foundation.h.k.a();
            new r(r.f10363j, strOptString, strOptString2, strOptString3, strOptString4, this.A.aZ(), iA, com.anythink.expressad.foundation.h.k.a(this.f11946v.getApplication(), iA));
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f11943t, th.getMessage(), th);
        }
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(Activity activity) {
        this.f11946v = activity;
    }

    @Override // com.anythink.expressad.video.signal.a.c, com.anythink.expressad.video.signal.c
    public final void a(Context context) {
        this.f11949y = context;
    }
}
