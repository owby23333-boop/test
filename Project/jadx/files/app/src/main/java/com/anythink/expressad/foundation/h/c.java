package com.anythink.expressad.foundation.h;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.e.ak;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f10621y = "portrait";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f10622z = "landscape";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10625e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f10631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f10633m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f10634n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f10635o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f10636p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10637q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f10638r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f10639s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f10640t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f10641u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10642v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f10643w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public JSONObject f10644x;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10623c = DispatchConstants.ANDROID;
    public String a = k.b();
    public String b = k.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10626f = com.anythink.core.common.k.d.f();

    public c(Context context) {
        this.f10624d = com.anythink.core.common.k.d.d(context);
        int iA = k.a();
        this.f10627g = String.valueOf(iA);
        this.f10628h = k.a(context, iA);
        this.f10629i = com.anythink.core.common.k.d.i();
        this.f10630j = com.anythink.expressad.foundation.b.a.b().f();
        this.f10631k = com.anythink.expressad.foundation.b.a.b().e();
        this.f10632l = String.valueOf(t.f(context));
        this.f10633m = String.valueOf(t.e(context));
        this.f10638r = String.valueOf(t.c(context));
        this.f10639s = com.anythink.expressad.foundation.b.a.b().i().toString();
        this.f10641u = com.anythink.core.common.k.d.b();
        this.f10642v = com.anythink.core.common.p.a().c();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f10634n = f10622z;
        } else {
            this.f10634n = f10621y;
        }
        IExHandler iExHandlerB = com.anythink.core.common.b.n.a().b();
        String[] strArrSplit = (iExHandlerB != null ? iExHandlerB.fillCDataParam("at_device1|||at_device12|||at_device3") : "|||").split("\\|\\|\\|");
        if (strArrSplit != null) {
            this.f10625e = strArrSplit.length > 0 ? strArrSplit[0] : "";
            this.f10643w = strArrSplit.length > 1 ? strArrSplit[1] : "";
            this.f10637q = strArrSplit.length > 2 ? strArrSplit[2] : "";
        }
        this.f10635o = com.anythink.expressad.foundation.g.a.co;
        this.f10636p = com.anythink.expressad.foundation.g.a.cp;
        this.f10640t = k.e();
        this.f10644x = b();
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(k.i());
            jSONObject.put("cid", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(k.f());
            jSONObject.put("dmt", sb2.toString());
            jSONObject.put("dmf", k.g());
            jSONObject.put(com.anythink.expressad.d.a.b.dx, k.h());
            jSONObject.put(com.anythink.core.common.k.c.b("aW1laQ=="), this.f10625e);
            jSONObject.put(com.anythink.core.common.k.c.b("bWFj"), this.f10643w);
            jSONObject.put("oaid", this.f10637q);
            jSONObject.put("android_id", this.f10624d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", this.a);
            jSONObject.put("system_version", this.b);
            jSONObject.put("network_type", this.f10627g);
            jSONObject.put("network_type_str", this.f10628h);
            jSONObject.put("device_ua", this.f10629i);
            ak akVarL = com.anythink.core.common.b.n.a().L();
            if (akVarL != null) {
                jSONObject.put("has_wx", akVarL.a());
                jSONObject.put("integrated_wx", akVarL.b());
                StringBuilder sb = new StringBuilder();
                sb.append(akVarL.c());
                jSONObject.put("opensdk_ver", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(akVarL.d());
                jSONObject.put("wx_api_ver", sb2.toString());
            }
            jSONObject.put("brand", this.f10641u);
            jSONObject.put("plantform", this.f10623c);
            jSONObject.put(com.anythink.core.common.k.c.b("ZGV2aWNlX2ltZWk="), this.f10625e);
            jSONObject.put("android_id", this.f10624d);
            jSONObject.put("google_ad_id", this.f10626f);
            jSONObject.put("oaid", this.f10637q);
            jSONObject.put("appkey", this.f10630j);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.f12231u, this.f10631k);
            jSONObject.put("screen_width", this.f10632l);
            jSONObject.put("screen_height", this.f10633m);
            jSONObject.put("orientation", this.f10634n);
            jSONObject.put("scale", this.f10638r);
            jSONObject.put("b", this.f10635o);
            jSONObject.put("c", this.f10636p);
            jSONObject.put("web_env", this.f10639s);
            jSONObject.put("f", this.f10640t);
            jSONObject.put("misk_spt", this.f10642v);
            jSONObject.put("dvi", j.a(this.f10644x.toString()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
