package com.anythink.expressad.advanced.js;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.a.b;
import com.anythink.expressad.advanced.d.a;
import com.anythink.expressad.atsignalcommon.base.d;
import com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdvancedJSBridgeImpl extends CommonBannerJSBridgeImp {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f8224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<c> f8225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f8226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8229h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f8231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private NativeAdvancedExpandDialog f8232k;
    private String b = "NativeAdvancedJSBridgeImpl";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8230i = 5;

    public NativeAdvancedJSBridgeImpl(Context context, String str, String str2) {
        this.f8227f = str;
        this.f8226e = str2;
        this.f8224c = new WeakReference<>(context);
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void click(Object obj, String str) {
        c cVar = null;
        try {
            if (this.f8225d != null && this.f8225d.size() > 0) {
                cVar = this.f8225d.get(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectA = c.a(cVar);
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
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
            if (this.f8231j != null) {
                this.f8231j.a(cVar);
            }
        } catch (Throwable th) {
            o.b(this.b, "click", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        o.d(this.b, c.cf);
        try {
            if (this.f8231j != null) {
                this.f8231j.d();
            }
        } catch (Throwable th) {
            o.b(this.b, c.cf, th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(String str, boolean z2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z2);
            if (this.f8224c == null || this.f8224c.get() == null) {
                return;
            }
            if (this.f8232k == null || !this.f8232k.isShowing()) {
                this.f8232k = new NativeAdvancedExpandDialog(this.f8224c.get(), bundle, this.f8231j);
                this.f8232k.setCampaignList(this.f8226e, this.f8225d);
                this.f8232k.show();
                if (this.f8231j != null) {
                    this.f8231j.a(true);
                }
            }
        } catch (Throwable th) {
            o.b(this.b, "expand", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void getFileInfo(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is empty");
            return;
        }
        try {
            NativeAdvancedJsUtils.getFileInfo(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.a(this.b, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public c getMraidCampaign() {
        List<c> list = this.f8225d;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f8225d.get(0);
    }

    public List<c> getmCampaignList() {
        return this.f8225d;
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void init(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            b bVar = new b(n.a().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f8228g);
            jSONObject2.put("customURLScheme", 1);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", bVar.a());
            jSONObject.put("campaignList", c.b(this.f8225d));
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.c cVarD = com.anythink.expressad.d.b.d(com.anythink.expressad.foundation.b.a.b().e(), this.f8226e);
            if (cVarD == null) {
                cVarD = com.anythink.expressad.d.c.y();
            }
            if (!TextUtils.isEmpty(this.f8227f)) {
                cVarD.e(this.f8227f);
            }
            cVarD.a(this.f8226e);
            cVarD.b(this.f8230i);
            cVarD.a(this.f8229h);
            jSONObject.put("unitSetting", cVarD.s());
            jSONObject.put("appSetting", new JSONObject());
            jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, d.a);
            o.d(this.b, "init" + jSONObject.toString());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.b(this.b, "init", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void install(Object obj, String str) {
        o.d(this.b, "install");
        c cVar = null;
        try {
            if (this.f8225d != null && this.f8225d.size() > 0) {
                cVar = this.f8225d.get(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectA = c.a(cVar);
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
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
            if (this.f8231j != null) {
                this.f8231j.a(cVar);
            }
        } catch (Throwable th) {
            o.b(this.b, "install", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void onJSBridgeConnect(Object obj, String str) {
        try {
            if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
                j.a();
                j.b(((com.anythink.expressad.atsignalcommon.windvane.a) obj).a);
            }
        } catch (Throwable th) {
            o.b(this.b, "onJSBridgeConnect", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(String str) {
        a aVar = this.f8231j;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void readyStatus(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            if (!(obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) || (windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a) == null) {
                return;
            }
            try {
                windVaneWebView.getWebViewListener().readyState(windVaneWebView, new JSONObject(str).getInt("isReady"));
            } catch (Exception unused) {
                windVaneWebView.getWebViewListener().readyState(windVaneWebView, 2);
            }
        } catch (Throwable th) {
            o.a(this.b, th.getMessage());
        }
    }

    public void release() {
        if (this.f8231j != null) {
            this.f8231j = null;
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void resetCountdown(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i2 = new JSONObject(str).getInt(com.anythink.expressad.d.a.b.dk);
            if (this.f8231j != null) {
                this.f8231j.b(i2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void sendImpressions(Object obj, String str) {
        o.a(this.b, "sendImpressions:".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                for (c cVar : this.f8225d) {
                    if (cVar.aZ().equals(string)) {
                        f.a(this.f8226e, cVar, f.f10441g);
                        arrayList.add(string);
                    }
                }
            }
        } catch (Throwable th) {
            o.b(this.b, "sendImpressions", th);
        }
    }

    public void setAllowSkip(int i2) {
        this.f8229h = i2;
    }

    public void setCampaignList(List<c> list) {
        this.f8225d = list;
    }

    public void setCountdownS(int i2) {
        this.f8230i = i2;
    }

    public void setDevCloseBtnStatus(int i2) {
        this.f8228g = i2;
    }

    public void setNativeAdvancedBridgeListener(a aVar) {
        if (aVar != null) {
            this.f8231j = aVar;
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(CallMraidJS.b);
            if (this.f8231j != null) {
                this.f8231j.a(iOptInt);
            }
        } catch (Throwable th) {
            o.b(this.b, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public void triggerCloseBtn(Object obj, String str) {
        if (this.f8231j != null) {
            NativeAdvancedJsUtils.callbackSuccess(obj);
            this.f8231j.a();
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    public void updateContext(Context context) {
        this.f8224c = new WeakReference<>(context);
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z2) {
        try {
            if (this.f8229h == -1) {
                int i2 = z2 ? 2 : 1;
                if (this.f8231j != null) {
                    this.f8231j.a(i2);
                }
            }
        } catch (Throwable th) {
            o.b(this.b, "useCustomClose", th);
        }
    }
}
