package com.anythink.expressad.splash.js;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.atsignalcommon.base.d;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.d.b;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.splash.d.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SplashJSBridgeImpl implements ISplashBridge {
    private WeakReference<Context> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<c> f11357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11361g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f11364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SplashExpandDialog f11365k;
    private String a = "SplashJSBridgeImpl";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f11362h = 5;

    public SplashJSBridgeImpl(Context context, String str, String str2) {
        this.f11359e = str;
        this.f11358d = str2;
        this.b = new WeakReference<>(context);
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void cai(Object obj, String str) {
        o.a(this.a, "cai:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String strOptString = new JSONObject(str).optString("packageName");
                if (TextUtils.isEmpty(strOptString)) {
                    CommonJSBridgeImpUtils.callbackExcep(obj, "packageName is empty");
                }
                int i2 = t.a(n.a().g(), strOptString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", CommonJSBridgeImpUtils.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i2);
                    jSONObject.put("data", jSONObject2);
                    j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e2) {
                    CommonJSBridgeImpUtils.callbackExcep(obj, e2.getMessage());
                    o.a(this.a, e2.getMessage());
                }
            } catch (Throwable th) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
                o.b(this.a, "cai", th);
            }
        } catch (JSONException e3) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e3.getLocalizedMessage());
            o.b(this.a, "cai", e3);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        o.d(this.a, c.cf);
        try {
            if (this.f11364j != null) {
                this.f11364j.c();
            }
        } catch (Throwable th) {
            o.b(this.a, c.cf, th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(String str, boolean z2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z2);
            if (this.b == null || this.b.get() == null) {
                return;
            }
            if (this.f11365k == null || !this.f11365k.isShowing()) {
                this.f11365k = new SplashExpandDialog(this.b.get(), bundle, this.f11364j);
                this.f11365k.setCampaignList(this.f11358d, this.f11357c);
                this.f11365k.show();
                if (this.f11364j != null) {
                    this.f11364j.a(true);
                }
            }
        } catch (Throwable th) {
            o.b(this.a, "expand", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public c getMraidCampaign() {
        List<c> list = this.f11357c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f11357c.get(0);
    }

    public a getSplashBridgeListener() {
        return this.f11364j;
    }

    public List<c> getmCampaignList() {
        return this.f11357c;
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void gial(Object obj, String str) {
        o.a(this.a, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packageNameList", new JSONArray());
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e2.getMessage());
            o.a(this.a, e2.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(this.a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void handlerH5Exception(Object obj, String str) {
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void init(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.anythink.expressad.splash.a.a aVar = new com.anythink.expressad.splash.a.a(n.a().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f11360f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", aVar.a());
            jSONObject.put("campaignList", c.b(this.f11357c));
            b.a();
            com.anythink.expressad.d.c cVarC = b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f11358d);
            if (cVarC == null) {
                cVarC = com.anythink.expressad.d.c.c(this.f11358d);
            }
            if (!TextUtils.isEmpty(this.f11359e)) {
                cVarC.e(this.f11359e);
            }
            cVarC.a(this.f11358d);
            cVarC.b(this.f11362h);
            cVarC.a(this.f11361g);
            jSONObject.put("unitSetting", cVarC.s());
            b.a();
            String strA = b.a(com.anythink.expressad.foundation.b.a.b().e());
            if (!TextUtils.isEmpty(strA)) {
                jSONObject.put("appSetting", new JSONObject(strA));
            }
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, d.a);
            o.d(this.a, "init" + jSONObject.toString());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.b(this.a, "init", th);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void install(Object obj, String str) {
        o.d(this.a, "install");
        try {
            if (this.f11357c == null) {
                return;
            }
            c cVar = null;
            if (this.f11357c != null && this.f11357c.size() > 0) {
                cVar = this.f11357c.get(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectA = c.a(cVar);
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectA.put(next, jSONObject.getString(next));
                }
                c cVarB = c.b(jSONObjectA);
                String strOptString = jSONObjectA.optString("unitId");
                if (!TextUtils.isEmpty(strOptString)) {
                    cVarB.l(strOptString);
                }
                cVar = cVarB;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (this.f11364j != null) {
                this.f11364j.a(cVar);
            }
        } catch (Throwable th) {
            o.b(this.a, "click", th);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void onJSBridgeConnect(Object obj, String str) {
        try {
            if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
                j.a();
                j.b(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a);
            }
        } catch (Throwable th) {
            o.b(this.a, "onJSBridgeConnect", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(String str) {
        a aVar = this.f11364j;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        o.d(this.a, "openURL:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        Context contextG = n.a().g();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextG == null) {
            try {
                if ((obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) && (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) != null) {
                    contextG = windVaneWebView.getContext();
                }
            } catch (Exception e2) {
                o.d(this.a, e2.getMessage());
            }
        }
        if (contextG == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                l.a(contextG, strOptString);
            } else if (iOptInt == 2) {
                l.b(contextG, strOptString);
            }
        } catch (JSONException e3) {
            o.d(this.a, e3.getMessage());
        } catch (Throwable th) {
            o.d(this.a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void pauseCountDown(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Call pause count down success.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.anythink.expressad.d.a.b.dk, this.f11363i);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.d(this.a, e2.getMessage());
        }
        a aVar = this.f11364j;
        if (aVar != null) {
            aVar.a(1, -1);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void readyStatus(Object obj, String str) {
    }

    public void release() {
        if (this.f11364j != null) {
            this.f11364j = null;
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void reportUrls(Object obj, String str) {
        o.a(this.a, "reportUrls:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                int iOptInt = jSONObject.optInt("type");
                String strOptString = jSONObject.optString("url");
                int iOptInt2 = jSONObject.optInt(AgooConstants.MESSAGE_REPORT);
                boolean z2 = true;
                if (iOptInt2 == 0) {
                    Context contextG = n.a().g();
                    if (iOptInt == 0) {
                        z2 = false;
                    }
                    com.anythink.expressad.a.a.a(contextG, (c) null, "", strOptString, z2);
                } else {
                    com.anythink.expressad.a.a.a(n.a().g(), null, "", strOptString, false, iOptInt != 0, iOptInt2);
                }
            }
            j.a().a(obj, SplashJsUtils.codeToJsonString(0));
        } catch (Throwable th) {
            o.b(this.a, "reportUrls", th);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void resetCountdown(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i2 = new JSONObject(str).getInt(com.anythink.expressad.d.a.b.dk);
            if (this.f11364j != null) {
                this.f11364j.b(i2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void resumeCountDown(Object obj, String str) {
        int iOptInt;
        int i2 = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                iOptInt = new JSONObject(str).optInt(com.anythink.expressad.d.a.b.dk);
            } catch (Exception e2) {
                e = e2;
            }
            try {
                j.a().a(obj, SplashJsUtils.codeToJsonString(0));
                i2 = iOptInt;
            } catch (Exception e3) {
                e = e3;
                i2 = iOptInt;
                o.d(this.a, e.getMessage());
            }
        }
        a aVar = this.f11364j;
        if (aVar != null) {
            aVar.a(2, i2);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void sendImpressions(Object obj, String str) {
        o.a(this.a, "sendImpressions:".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                for (c cVar : this.f11357c) {
                    if (cVar.aZ().equals(string)) {
                        f.a(this.f11358d, cVar, f.f10440f);
                        arrayList.add(string);
                    }
                }
            }
        } catch (Throwable th) {
            o.b(this.a, "sendImpressions", th);
        }
    }

    public void setAllowSkip(int i2) {
        this.f11361g = i2;
    }

    public void setCampaignList(List<c> list) {
        this.f11357c = list;
    }

    public void setCountdownS(int i2) {
        this.f11362h = i2;
    }

    public void setDevCloseBtnStatus(int i2) {
        this.f11360f = i2;
    }

    public void setSplashBridgeListener(a aVar) {
        if (aVar != null) {
            this.f11364j = aVar;
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(CallMraidJS.b);
            if (this.f11364j != null) {
                this.f11364j.a(iOptInt);
            }
        } catch (Throwable th) {
            o.b(this.a, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.splash.js.ISplashBridge
    public void triggerCloseBtn(Object obj, String str) {
        a aVar = this.f11364j;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    public void updateContext(Context context) {
        this.b = new WeakReference<>(context);
    }

    public void updateCountDown(int i2) {
        this.f11363i = i2;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z2) {
        int i2 = z2 ? 2 : 1;
        try {
            if (this.f11364j != null) {
                this.f11364j.a(i2);
            }
        } catch (Throwable th) {
            o.b(this.a, "useCustomClose", th);
        }
    }
}
