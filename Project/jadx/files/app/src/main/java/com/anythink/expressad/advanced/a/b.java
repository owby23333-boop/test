package com.anythink.expressad.advanced.a;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ak;
import com.anythink.core.common.k.d;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8130e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f8132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f8133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f8134i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f8135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f8136k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f8137l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f8138m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f8139n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f8140o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f8141p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8128c = DispatchConstants.ANDROID;
    public String a = k.b();
    public String b = k.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8131f = d.f();

    public b(Context context) {
        String strFillCDataParam;
        this.f8130e = d.d(context);
        int iA = k.a();
        this.f8133h = String.valueOf(iA);
        this.f8134i = k.a(context, iA);
        this.f8135j = d.i();
        this.f8136k = com.anythink.expressad.foundation.b.a.b().f();
        this.f8137l = com.anythink.expressad.foundation.b.a.b().e();
        this.f8138m = String.valueOf(t.f(context));
        this.f8139n = String.valueOf(t.e(context));
        this.f8141p = String.valueOf(t.c(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f8140o = "landscape";
        } else {
            this.f8140o = "portrait";
        }
        IExHandler iExHandlerB = n.a().b();
        if (iExHandlerB != null) {
            strFillCDataParam = iExHandlerB.fillCDataParam("at_device1|||at_device2|||at_device3");
            strFillCDataParam.replace("at_device1", "").replace("at_device2", "").replace("at_device3", "");
        } else {
            strFillCDataParam = "";
        }
        if (TextUtils.isEmpty(strFillCDataParam)) {
            this.f8129d = "";
            this.f8132g = "";
        } else {
            String[] strArrSplit = strFillCDataParam.split("\\|\\|\\|");
            try {
                this.f8129d = strArrSplit[0];
            } catch (Throwable unused) {
            }
            try {
                this.f8132g = strArrSplit[2];
            } catch (Throwable unused2) {
            }
        }
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", this.a);
            jSONObject.put("system_version", this.b);
            jSONObject.put("network_type", this.f8133h);
            jSONObject.put("network_type_str", this.f8134i);
            jSONObject.put("device_ua", this.f8135j);
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
            jSONObject.put("plantform", this.f8128c);
            jSONObject.put(com.anythink.core.common.k.c.b("ZGV2aWNlX2ltZWk="), this.f8129d);
            jSONObject.put("android_id", this.f8130e);
            jSONObject.put("google_ad_id", this.f8131f);
            jSONObject.put("oaid", this.f8132g);
            jSONObject.put("appkey", this.f8136k);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.f12231u, this.f8137l);
            jSONObject.put("screen_width", this.f8138m);
            jSONObject.put("screen_height", this.f8139n);
            jSONObject.put("orientation", this.f8140o);
            jSONObject.put("scale", this.f8141p);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
