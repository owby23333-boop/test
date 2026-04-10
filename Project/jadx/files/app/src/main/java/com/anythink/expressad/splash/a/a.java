package com.anythink.expressad.splash.a;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ak;
import com.anythink.core.common.k.c;
import com.anythink.core.common.k.d;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f11221e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f11226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f11227k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f11228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f11229m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f11230n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f11231o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f11232p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11219c = DispatchConstants.ANDROID;
    public String a = k.b();
    public String b = k.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11222f = d.f();

    public a(Context context) {
        String strFillCDataParam;
        this.f11221e = d.d(context);
        int iA = k.a();
        this.f11224h = String.valueOf(iA);
        this.f11225i = k.a(context, iA);
        this.f11226j = d.i();
        this.f11227k = com.anythink.expressad.foundation.b.a.b().f();
        this.f11228l = com.anythink.expressad.foundation.b.a.b().e();
        this.f11229m = String.valueOf(t.f(context));
        this.f11230n = String.valueOf(t.e(context));
        this.f11232p = String.valueOf(t.c(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f11231o = "landscape";
        } else {
            this.f11231o = "portrait";
        }
        IExHandler iExHandlerB = n.a().b();
        if (iExHandlerB != null) {
            strFillCDataParam = iExHandlerB.fillCDataParam("at_device1|||at_device2|||at_device3");
            strFillCDataParam.replace("at_device1", "").replace("at_device2", "").replace("at_device3", "");
        } else {
            strFillCDataParam = "";
        }
        if (TextUtils.isEmpty(strFillCDataParam)) {
            this.f11220d = "";
            this.f11223g = "";
        } else {
            String[] strArrSplit = strFillCDataParam.split("\\|\\|\\|");
            try {
                this.f11220d = strArrSplit[0];
            } catch (Throwable unused) {
            }
            try {
                this.f11223g = strArrSplit[2];
            } catch (Throwable unused2) {
            }
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", this.a);
            jSONObject.put("system_version", this.b);
            jSONObject.put("network_type", this.f11224h);
            jSONObject.put("network_type_str", this.f11225i);
            jSONObject.put("device_ua", this.f11226j);
            ak akVarL = n.a().L();
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
            jSONObject.put("plantform", this.f11219c);
            jSONObject.put(c.b("ZGV2aWNlX2ltZWk="), this.f11220d);
            jSONObject.put("android_id", this.f11221e);
            jSONObject.put("google_ad_id", this.f11222f);
            jSONObject.put("oaid", this.f11223g);
            jSONObject.put("appkey", this.f11227k);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.f12231u, this.f11228l);
            jSONObject.put("screen_width", this.f11229m);
            jSONObject.put("screen_height", this.f11230n);
            jSONObject.put("orientation", this.f11231o);
            jSONObject.put("scale", this.f11232p);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
