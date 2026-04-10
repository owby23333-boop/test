package com.anythink.expressad.video.signal.communication;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.l;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.d.b;
import com.anythink.expressad.foundation.g.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.a.c;
import com.anythink.expressad.video.signal.factory.IJSFactory;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BaseVideoBridge extends AbsFeedBackForH5 implements IVideoBridge {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected static final String f11967h = "JS-Video-Brigde";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f11968j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f11969k = 2;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f11970l = "showTransparent";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f11971m = "mute";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f11972n = "closeType";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f11973o = "orientationType";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f11974p = "type";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f11975q = "h5cbp";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f11976r = "webfront";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f11977s = "showAlertRole";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected IJSFactory f11978i;

    private static String a(int i2) {
        switch (i2) {
            case 1:
                return ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO;
            case 2:
                return "unit_id";
            case 3:
                return "appSetting";
            case 4:
                return "unitSetting";
            case 5:
                return "device";
            case 6:
                return "sdkSetting";
            default:
                return "";
        }
    }

    private static void a(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 1);
                jSONObject.put("message", "params is null");
                j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Exception e2) {
            o.a(f11967h, e2.getMessage());
        }
    }

    private static String b(int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            o.d(f11967h, "code to string is error");
            return "";
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendSubView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().i(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "appendSubView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void appendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            c.a().j(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "appendViewTo error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void bringViewToFront(Object obj, String str) {
        a(obj, str);
        try {
            c.a().m(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "bringViewToFront error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void broadcast(Object obj, String str) {
        a(obj, str);
        try {
            c.a().M(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "broadcast error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void cai(Object obj, String str) {
        o.a(f11967h, "cai:".concat(String.valueOf(str)));
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
                    o.a(f11967h, e2.getMessage());
                }
            } catch (JSONException e3) {
                CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + e3.getLocalizedMessage());
                o.b(f11967h, "cai", e3);
            }
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "exception: " + th.getLocalizedMessage());
            o.b(f11967h, "cai", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void clearAllCache(Object obj, String str) {
        try {
            n.a().g().getSharedPreferences(a.f10419p, 0).edit().clear().apply();
            if (obj != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th) {
            o.d(f11967h, "getAllCache error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void click(Object obj, String str) {
        String strOptString;
        int iOptInt;
        com.anythink.expressad.video.signal.a.j jVar;
        o.b(f11967h, "click");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                iOptInt = jSONObject.optInt("type");
                strOptString = jSONObject.optString("pt");
            } catch (JSONException e2) {
                e2.printStackTrace();
                strOptString = "";
                iOptInt = 1;
            }
            if (this.f11978i != null) {
                this.f11978i.getJSCommon().click(iOptInt, strOptString);
                return;
            }
            if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (!(aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) || (jVar = (com.anythink.expressad.video.signal.a.j) aVar.a.getObject()) == null) {
                    return;
                }
                jVar.click(iOptInt, strOptString);
            }
        } catch (Throwable th) {
            o.b(f11967h, "click error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeAd(Object obj, String str) {
        a(obj, str);
        try {
            c.a().L(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "closeAd error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeVideoOperte(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(com.anythink.expressad.foundation.d.c.cf);
            int iOptInt2 = jSONObject.optInt("view_visible");
            o.b(f11967h, "closeVideoOperte,close:" + iOptInt + ",viewVisible:" + iOptInt2);
            this.f11978i.getJSVideoModule().closeVideoOperate(iOptInt, iOptInt2);
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(f11967h, "closeOperte error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void closeWeb(Object obj, String str) {
        o.d(f11967h, "type".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str) || this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("status");
            this.f11978i.getJSContainerModule().hideAlertWebview();
            this.f11978i.getJSVideoModule().hideAlertView(iOptInt);
        } catch (Throwable th) {
            o.b(f11967h, "closeWeb", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createNativeEC(Object obj, String str) {
        a(obj, str);
        try {
            c.a().Q(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "createNativeEC error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createPlayerView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().c(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "createPlayerView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().d(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "createSubPlayTemplateView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "createWebview error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void createWebview(Object obj, String str) {
        a(obj, str);
        try {
            c.a().b(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "createWebview error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void destroyComponent(Object obj, String str) {
        a(obj, str);
        try {
            c.a().e(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "destroyComponent error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getAllCache(Object obj, String str) {
        JSONObject jSONObject;
        Throwable th;
        String str2;
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = n.a().g().getSharedPreferences(a.f10419p, 0);
            jSONObject = new JSONObject();
        } catch (Throwable th2) {
            jSONObject = null;
            th = th2;
        }
        try {
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            str2 = "getAllCache Success";
        } catch (Throwable th3) {
            th = th3;
            o.d(f11967h, "getAllCache error ".concat(String.valueOf(th)));
            str2 = "getAllCache Error, reason is : " + th.getMessage();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", 0);
            jSONObject2.put("message", str2);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            } else {
                jSONObject2.put("data", "{}");
            }
            if (obj != null) {
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (Throwable th4) {
            o.d(f11967h, "getAllCache error ".concat(String.valueOf(th4)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getAppSetting(Object obj, String str) {
        JSONObject jSONObject;
        try {
            String strOptString = new JSONObject(str).optString("appid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get App Setting error, because must give a appId.");
            } else {
                b.a();
                String strA = b.a(strOptString);
                if (TextUtils.isEmpty(strA)) {
                    b.a();
                    jSONObject = new JSONObject(b.c().R());
                } else {
                    jSONObject = new JSONObject(strA);
                    jSONObject.put("isDefault", 0);
                }
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put("data", jSONObject);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get App Setting error, plz try again later.");
                }
            }
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(f11967h, "getAppSetting error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getComponentOptions(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.f(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "getComponentOptions error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCurrentProgress(Object obj, String str) {
        try {
            if (this.f11978i != null) {
                String currentProgress = this.f11978i.getJSVideoModule().getCurrentProgress();
                o.b(f11967h, "getCurrentProgress:".concat(String.valueOf(currentProgress)));
                if (!TextUtils.isEmpty(currentProgress)) {
                    currentProgress = Base64.encodeToString(currentProgress.getBytes(), 2);
                }
                j.a().a(obj, currentProgress);
            }
        } catch (Throwable th) {
            o.b(f11967h, "getCurrentProgress error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getCutout(Object obj, String str) {
        try {
            String strO = this.f11978i.getJSCommon().o();
            o.d(f11967h, strO);
            if (obj != null && !TextUtils.isEmpty(strO)) {
                j.a().a(obj, Base64.encodeToString(strO.getBytes(), 2));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "No notch data, plz try again later.");
            j.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(f11967h, "getCutout error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getEncryptPrice(Object obj, String str) {
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getFileInfo(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.P(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.b(f11967h, "getFileInfo error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardSetting(Object obj, String str) {
        try {
            JSONObject jSONObjectK = com.anythink.expressad.videocommon.e.c.a().b().k();
            JSONObject jSONObject = new JSONObject();
            if (obj != null) {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Success");
                jSONObject.put("data", jSONObjectK);
            } else {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Get Reward Setting error, plz try again later.");
            }
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(f11967h, "getRewardSetting error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getRewardUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("appid", "");
            String strOptString2 = jSONObject.optString("unitid", "");
            JSONObject jSONObject2 = new JSONObject();
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "Get reward unit Setting error, because must give appId and unitId.");
            } else {
                JSONObject jSONObjectR = com.anythink.expressad.videocommon.e.c.a().a(strOptString, strOptString2).R();
                if (obj != null) {
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "Success");
                    jSONObject2.put("data", jSONObjectR);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("message", "Get Reward Unit Setting error, plz try again later.");
                }
            }
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(f11967h, "getRewardUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getSDKInfo(Object obj, String str) {
        o.b(f11967h, "getSDKInfo");
        try {
            if (TextUtils.isEmpty(str)) {
                j.a().b(obj, "params is null");
                return;
            }
            JSONArray jSONArray = new JSONObject(str).getJSONArray("type");
            JSONObject jSONObject = new JSONObject();
            int i2 = 0;
            if (this.f11978i != null) {
                while (i2 < jSONArray.length()) {
                    int i3 = jSONArray.getInt(i2);
                    jSONObject.put(a(i3), this.f11978i.getJSCommon().h(i3));
                    i2++;
                }
            } else if (obj != null) {
                while (i2 < jSONArray.length()) {
                    int i4 = jSONArray.getInt(i2);
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    if (aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                        jSONObject.put(a(i4), ((com.anythink.expressad.video.signal.a.j) aVar.a.getObject()).h(i4));
                    }
                    i2++;
                }
            }
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.b(f11967h, "getSDKInfo error", th);
            j.a().b(obj, "exception");
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void getUnitSetting(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 1);
            jSONObject.put("message", "Get Unit Setting error, RV/IV can not support this method.");
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.d(f11967h, "getUnitSetting error : " + th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void gial(Object obj, String str) {
        o.a(f11967h, "gial:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("packageNameList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            CommonJSBridgeImpUtils.callbackExcep(obj, e2.getMessage());
            o.a(f11967h, e2.getMessage());
        } catch (Throwable th) {
            CommonJSBridgeImpUtils.callbackExcep(obj, th.getMessage());
            o.a(f11967h, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handleNativeObject(Object obj, String str) {
        a(obj, str);
        try {
            com.anythink.expressad.video.bt.a.b.a().a(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "handleNativeObject error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void handlerH5Exception(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            o.b(f11967h, "handlerH5Exception,params:".concat(String.valueOf(str)));
            this.f11978i.getJSCommon().handlerH5Exception(jSONObject.optInt("code", c.a), jSONObject.optString("message", "h5 error"));
        } catch (Throwable th) {
            o.b(f11967h, "handlerH5Exception", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void hideView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().n(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "hideView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void increaseOfferFrequence(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            new JSONObject(str);
            c.a(obj);
        } catch (Throwable th) {
            o.d(f11967h, "increaseOfferFrequence error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void init(Object obj, String str) {
        o.b(f11967h, "init");
        try {
            int i2 = 1;
            if (this.f11978i != null) {
                String strI = this.f11978i.getJSCommon().i();
                if (!TextUtils.isEmpty(strI)) {
                    strI = Base64.encodeToString(strI.getBytes(), 2);
                }
                j.a().a(obj, strI);
                this.f11978i.getJSCommon().h();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt(f11970l);
                int iOptInt2 = jSONObject.optInt("mute");
                int iOptInt3 = jSONObject.optInt(f11972n);
                int iOptInt4 = jSONObject.optInt(f11973o);
                int iOptInt5 = jSONObject.optInt(f11975q);
                int iOptInt6 = jSONObject.optInt(f11976r);
                int iOptInt7 = jSONObject.optInt(f11977s);
                this.f11978i.getJSCommon().a(iOptInt == 1);
                this.f11978i.getJSCommon().b(iOptInt2);
                this.f11978i.getJSCommon().c(iOptInt3);
                this.f11978i.getJSCommon().d(iOptInt4);
                this.f11978i.getJSCommon().e(iOptInt5);
                this.f11978i.getJSCommon().f(iOptInt6);
                com.anythink.expressad.video.signal.c jSCommon = this.f11978i.getJSCommon();
                if (iOptInt7 != 0) {
                    i2 = iOptInt7;
                }
                jSCommon.i(i2);
                return;
            }
            if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                    com.anythink.expressad.video.signal.a.j jVar = (com.anythink.expressad.video.signal.a.j) aVar.a.getObject();
                    String strI2 = jVar.i();
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        int iOptInt8 = jSONObject2.optInt(f11970l);
                        int iOptInt9 = jSONObject2.optInt("mute");
                        int iOptInt10 = jSONObject2.optInt(f11972n);
                        int iOptInt11 = jSONObject2.optInt(f11973o);
                        int iOptInt12 = jSONObject2.optInt(f11975q);
                        int iOptInt13 = jSONObject2.optInt(f11976r);
                        int iOptInt14 = jSONObject2.optInt(f11977s);
                        jVar.a(iOptInt8 == 1);
                        jVar.b(iOptInt9);
                        jVar.c(iOptInt10);
                        jVar.d(iOptInt11);
                        jVar.e(iOptInt12);
                        jVar.f(iOptInt13);
                        if (iOptInt14 != 0) {
                            i2 = iOptInt14;
                        }
                        jVar.i(i2);
                        o.b(f11967h, "init jsCommon.setIsShowingTransparent = ".concat(String.valueOf(iOptInt8)));
                    }
                    j.a().a(obj, Base64.encodeToString(strI2.getBytes(), 2));
                }
            }
        } catch (Throwable th) {
            o.b(f11967h, "init error", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.l
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        super.initialize(obj, windVaneWebView);
        if (obj instanceof IJSFactory) {
            this.f11978i = (IJSFactory) obj;
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            c.a().s(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "insertViewAbove error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void insertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            c.a().t(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "insertViewBelow error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void isSystemResume(Object obj, String str) {
        try {
            if (this.f11978i != null) {
                o.b(f11967h, "isSystemResume,params:".concat(String.valueOf(str)));
                j.a().a(obj, b(this.f11978i.getActivityProxy().h()));
            }
        } catch (Throwable th) {
            o.b(f11967h, "isSystemResume", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        o.d(f11967h, "ivRewardAdsWithoutVideo ： params".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str) || this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11978i.getJSContainerModule().ivRewardAdsWithoutVideo(str);
        } catch (Throwable th) {
            o.b(f11967h, "ivRewardAdsWithoutVideo", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadads(Object obj, String str) {
        String strOptString;
        int iOptInt;
        int iOptInt2;
        o.b(f11967h, "loadads");
        try {
            if (TextUtils.isEmpty(str)) {
                strOptString = "";
                iOptInt = 1;
                iOptInt2 = 1;
            } else {
                JSONObject jSONObject = new JSONObject(str);
                strOptString = jSONObject.optString("unitId");
                iOptInt2 = jSONObject.optInt("type", 1);
                if (iOptInt2 > 2) {
                    iOptInt2 = 1;
                }
                iOptInt = jSONObject.optInt("adtype", 1);
            }
            if (TextUtils.isEmpty(strOptString)) {
                j.a().a(obj, b(1));
                return;
            }
            if (obj != null) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.a instanceof WindVaneWebView) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        ((com.anythink.expressad.atsignalcommon.a.a) windVaneWebView.getWebViewListener()).a(strOptString, iOptInt2, iOptInt);
                    }
                }
            }
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(f11967h, "loadads error", th);
            j.a().a(obj, b(1));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void loadingResourceStatus(Object obj, String str) {
        a(obj, str);
        if (obj != null) {
            try {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().loadingResourceStatus(windVaneWebView, iOptInt);
                    }
                }
            } catch (Throwable th) {
                o.d(f11967h, "loadingResourceStatus error ".concat(String.valueOf(th)));
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(CallMraidJS.b);
            o.b(f11967h, "notifyCloseBtn,result:".concat(String.valueOf(iOptInt)));
            this.f11978i.getJSVideoModule().notifyCloseBtn(iOptInt);
        } catch (Throwable th) {
            o.b(f11967h, "notifyCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendSubView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().k(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "appendSubView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyAppendViewTo(Object obj, String str) {
        a(obj, str);
        try {
            c.a().l(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "appendViewTo error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewAbove(Object obj, String str) {
        a(obj, str);
        try {
            c.a().u(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "insertViewAbove error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void onlyInsertViewBelow(Object obj, String str) {
        a(obj, str);
        try {
            c.a().v(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "insertViewBelow error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void openURL(Object obj, String str) {
        o.d(f11967h, "openURL:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                l.a(this.f8328e, strOptString);
            } else if (iOptInt == 2) {
                l.b(this.f8328e, strOptString);
            }
        } catch (JSONException e2) {
            o.d(f11967h, e2.getMessage());
        } catch (Throwable th) {
            o.d(f11967h, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playVideoFinishOperate(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str) || this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("type");
            o.b(f11967h, "playVideoFinishOperate,type: ".concat(String.valueOf(iOptInt)));
            this.f11978i.getJSCommon().g(iOptInt);
        } catch (Throwable th) {
            o.b(f11967h, "playVideoFinishOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerGetMuteState(Object obj, String str) {
        a(obj, str);
        try {
            c.a().H(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerGetMuteState error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerMute(Object obj, String str) {
        a(obj, str);
        try {
            c.a().F(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerMute error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPause(Object obj, String str) {
        a(obj, str);
        try {
            c.a().B(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerPause error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerPlay(Object obj, String str) {
        a(obj, str);
        try {
            c.a().A(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerPlay error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerResume(Object obj, String str) {
        a(obj, str);
        try {
            c.a().C(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerResume error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetRenderType(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.J(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerSetRenderType error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerSetSource(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.I(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerSetSource error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerStop(Object obj, String str) {
        a(obj, str);
        try {
            c.a().D(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerStop error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUnmute(Object obj, String str) {
        a(obj, str);
        try {
            c.a().G(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerUnmute error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void playerUpdateFrame(Object obj, String str) {
        a(obj, str);
        try {
            c.a();
            c.E(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "playerUpdateFrame error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void preloadSubPlayTemplateView(Object obj, String str) {
        a(obj, str);
        try {
            if (this.f11978i != null) {
                c.a().K(obj, new JSONObject(str));
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            if (aVar.a instanceof WindVaneWebView) {
                WindVaneWebView windVaneWebView = aVar.a;
                if (windVaneWebView.getWebViewListener() == null) {
                    o.a(f11967h, "preloadSubPlayTemplateView: failed");
                } else {
                    ((com.anythink.expressad.atsignalcommon.a.a) windVaneWebView.getWebViewListener()).a(obj, str);
                    o.a(f11967h, "preloadSubPlayTemplateView: RVWebViewListener");
                }
            }
        } catch (Throwable th) {
            o.d(f11967h, "preloadSubPlayTemplateView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressBarOperate(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11978i.getJSVideoModule().progressBarOperate(new JSONObject(str).optInt("view_visible"));
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(f11967h, "progressOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void progressOperate(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
            int iOptInt2 = jSONObject.optInt("view_visible");
            o.b(f11967h, "progressOperate,progress:" + iOptInt + ",viewVisible:" + iOptInt2);
            this.f11978i.getJSVideoModule().progressOperate(iOptInt, iOptInt2);
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(f11967h, "progressOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reactDeveloper(Object obj, String str) {
        o.a(f11967h, "reactDeveloper");
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                j.a().b(obj, b(1));
            } else {
                this.f11978i.getJSBTModule().reactDeveloper(obj, str);
            }
        } catch (Throwable th) {
            o.d(f11967h, "reactDeveloper error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                if (aVar.a.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                    ((com.anythink.expressad.video.signal.a.j) aVar.a.getObject()).j(iOptInt);
                }
                if (aVar.a != null) {
                    WindVaneWebView windVaneWebView = aVar.a;
                    if (windVaneWebView.getWebViewListener() != null) {
                        windVaneWebView.getWebViewListener().readyState(windVaneWebView, iOptInt);
                    }
                }
            } catch (Throwable th) {
                o.b(f11967h, "readyStatus", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void removeCacheItem(java.lang.Object r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "removeCacheItem error "
            java.lang.String r1 = "JS-Video-Brigde"
            r2 = 1
            r3 = 0
            com.anythink.core.common.b.n r4 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L3f
            android.content.Context r4 = r4.g()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r5 = "anythink_h5_cachesp"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r5, r3)     // Catch: java.lang.Throwable -> L3f
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L3f
            if (r5 != 0) goto L3b
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3f
            r5.<init>(r9)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r9 = "key"
            java.lang.String r9 = r5.getString(r9)     // Catch: java.lang.Throwable -> L3f
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L3f
            if (r5 != 0) goto L36
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> L3f
            android.content.SharedPreferences$Editor r9 = r4.remove(r9)     // Catch: java.lang.Throwable -> L3f
            r9.apply()     // Catch: java.lang.Throwable -> L3f
        L36:
            java.lang.String r9 = "Delete Success"
            r4 = r9
            r9 = 1
            goto L5e
        L3b:
            java.lang.String r9 = ""
            r4 = r9
            goto L5d
        L3f:
            r9 = move-exception
            java.lang.String r4 = java.lang.String.valueOf(r9)
            java.lang.String r4 = r0.concat(r4)
            com.anythink.expressad.foundation.h.o.d(r1, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Delete Error, reason is : "
            r4.<init>(r5)
            java.lang.String r9 = r9.getMessage()
            r4.append(r9)
            java.lang.String r4 = r4.toString()
        L5d:
            r9 = 0
        L5e:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L9d
            r5.<init>()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r6 = "code"
            if (r9 == 0) goto L68
            r2 = 0
        L68:
            r5.put(r6, r2)     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = "message"
            r5.put(r2, r4)     // Catch: java.lang.Throwable -> L9d
            r2 = 2
            if (r8 == 0) goto L89
            if (r9 == 0) goto L89
            com.anythink.expressad.atsignalcommon.windvane.j r9 = com.anythink.expressad.atsignalcommon.windvane.j.a()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L9d
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r2)     // Catch: java.lang.Throwable -> L9d
            r9.a(r8, r2)     // Catch: java.lang.Throwable -> L9d
            return
        L89:
            com.anythink.expressad.atsignalcommon.windvane.j r9 = com.anythink.expressad.atsignalcommon.windvane.j.a()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L9d
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r2)     // Catch: java.lang.Throwable -> L9d
            r9.b(r8, r2)     // Catch: java.lang.Throwable -> L9d
            return
        L9d:
            com.anythink.expressad.foundation.h.o.d(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.communication.BaseVideoBridge.removeCacheItem(java.lang.Object, java.lang.String):void");
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void removeFromSuperView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().h(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "removeFromSuperView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void reportUrls(Object obj, String str) {
        o.a(f11967h, "reportUrls");
        try {
            if (TextUtils.isEmpty(str)) {
                j.a().b(obj, b(1));
            } else {
                c.a();
                c.b(obj, str);
            }
        } catch (Throwable th) {
            o.d(f11967h, "reportUrls error ".concat(String.valueOf(th)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCacheItem(java.lang.Object r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "setCacheItem error "
            java.lang.String r1 = "JS-Video-Brigde"
            r2 = 1
            r3 = 0
            com.anythink.core.common.b.n r4 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L4b
            android.content.Context r4 = r4.g()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = "anythink_h5_cachesp"
            android.content.SharedPreferences r4 = r4.getSharedPreferences(r5, r3)     // Catch: java.lang.Throwable -> L4b
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L4b
            if (r5 != 0) goto L47
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4b
            r5.<init>(r9)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r9 = "key"
            java.lang.String r9 = r5.getString(r9)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r6 = "value"
            java.lang.String r5 = r5.getString(r6)     // Catch: java.lang.Throwable -> L4b
            boolean r6 = android.text.TextUtils.isEmpty(r9)     // Catch: java.lang.Throwable -> L4b
            if (r6 != 0) goto L42
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L4b
            if (r6 != 0) goto L42
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> L4b
            android.content.SharedPreferences$Editor r9 = r4.putString(r9, r5)     // Catch: java.lang.Throwable -> L4b
            r9.apply()     // Catch: java.lang.Throwable -> L4b
        L42:
            java.lang.String r9 = "Save Success"
            r4 = r9
            r9 = 1
            goto L6a
        L47:
            java.lang.String r9 = ""
            r4 = r9
            goto L69
        L4b:
            r9 = move-exception
            java.lang.String r4 = java.lang.String.valueOf(r9)
            java.lang.String r4 = r0.concat(r4)
            com.anythink.expressad.foundation.h.o.d(r1, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Save Error, reason is : "
            r4.<init>(r5)
            java.lang.String r9 = r9.getMessage()
            r4.append(r9)
            java.lang.String r4 = r4.toString()
        L69:
            r9 = 0
        L6a:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> La9
            r5.<init>()     // Catch: java.lang.Throwable -> La9
            java.lang.String r6 = "code"
            if (r9 == 0) goto L74
            r2 = 0
        L74:
            r5.put(r6, r2)     // Catch: java.lang.Throwable -> La9
            java.lang.String r2 = "message"
            r5.put(r2, r4)     // Catch: java.lang.Throwable -> La9
            r2 = 2
            if (r8 == 0) goto L95
            if (r9 == 0) goto L95
            com.anythink.expressad.atsignalcommon.windvane.j r9 = com.anythink.expressad.atsignalcommon.windvane.j.a()     // Catch: java.lang.Throwable -> La9
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> La9
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> La9
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r2)     // Catch: java.lang.Throwable -> La9
            r9.a(r8, r2)     // Catch: java.lang.Throwable -> La9
            return
        L95:
            com.anythink.expressad.atsignalcommon.windvane.j r9 = com.anythink.expressad.atsignalcommon.windvane.j.a()     // Catch: java.lang.Throwable -> La9
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> La9
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> La9
            java.lang.String r2 = android.util.Base64.encodeToString(r3, r2)     // Catch: java.lang.Throwable -> La9
            r9.b(r8, r2)     // Catch: java.lang.Throwable -> La9
            return
        La9:
            com.anythink.expressad.foundation.h.o.d(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.signal.communication.BaseVideoBridge.setCacheItem(java.lang.Object, java.lang.String):void");
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setScaleFitXY(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("fitxy");
            o.b(f11967h, "setScaleFitXY,type:".concat(String.valueOf(iOptInt)));
            this.f11978i.getJSVideoModule().setScaleFitXY(iOptInt);
        } catch (Throwable th) {
            o.b(f11967h, "showVideoClickView error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setSubPlayTemplateInfo(Object obj, String str) {
        o.d(f11967h, "setSubPlayTemplateInfo : ".concat(String.valueOf(str)));
        a(obj, str);
        try {
            c.a().N(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "setSubPlayTemplateInfo error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewAlpha(Object obj, String str) {
        a(obj, str);
        try {
            c.a().q(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "setViewAlpha error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewBgColor(Object obj, String str) {
        a(obj, str);
        try {
            c.a().p(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "setViewBgColor error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewRect(Object obj, String str) {
        a(obj, str);
        try {
            c.a().g(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "setViewRect error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void setViewScale(Object obj, String str) {
        a(obj, str);
        try {
            c.a().r(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "setViewScale error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showAlertView(Object obj, String str) {
        o.b(f11967h, "showAlertView");
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.f11978i.getJSVideoModule().showIVRewardAlertView(str);
            j.a().a(obj, "showAlertView", "");
        } catch (Throwable th) {
            o.b(f11967h, "showAlertView", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoClickView(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("type");
            o.b(f11967h, "showVideoClickView,type:".concat(String.valueOf(iOptInt)));
            this.f11978i.getJSContainerModule().showVideoClickView(iOptInt);
        } catch (Throwable th) {
            o.b(f11967h, "showVideoClickView error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showVideoLocation(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("margin_top", 0);
            int iOptInt2 = jSONObject.optInt("margin_left", 0);
            int iOptInt3 = jSONObject.optInt("view_width", 0);
            int iOptInt4 = jSONObject.optInt("view_height", 0);
            int iOptInt5 = jSONObject.optInt("radius", 0);
            int iOptInt6 = jSONObject.optInt("border_top", 0);
            int iOptInt7 = jSONObject.optInt("border_left", 0);
            int iOptInt8 = jSONObject.optInt("border_width", 0);
            int iOptInt9 = jSONObject.optInt("border_height", 0);
            o.b(f11967h, "showVideoLocation,margin_top:" + iOptInt + ",marginLeft:" + iOptInt2 + ",viewWidth:" + iOptInt3 + ",viewHeight:" + iOptInt4 + ",radius:" + iOptInt5 + ",borderTop: " + iOptInt6 + ",borderLeft: " + iOptInt7 + ",borderWidth: " + iOptInt8 + ",borderHeight: " + iOptInt9);
            this.f11978i.getJSVideoModule().showVideoLocation(iOptInt, iOptInt2, iOptInt3, iOptInt4, iOptInt5, iOptInt6, iOptInt7, iOptInt8, iOptInt9);
            this.f11978i.getJSCommon().l();
        } catch (Throwable th) {
            o.b(f11967h, "showVideoLocation error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void showView(Object obj, String str) {
        a(obj, str);
        try {
            c.a().o(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "showView error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void soundOperate(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("mute");
            int iOptInt2 = jSONObject.optInt("view_visible");
            String strOptString = jSONObject.optString("pt", "");
            o.b(f11967h, "soundOperate,mute:" + iOptInt + ",viewVisible:" + iOptInt2 + ",pt:" + strOptString);
            if (TextUtils.isEmpty(strOptString)) {
                this.f11978i.getJSVideoModule().soundOperate(iOptInt, iOptInt2);
            } else {
                this.f11978i.getJSVideoModule().soundOperate(iOptInt, iOptInt2, strOptString);
            }
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(f11967h, "soundOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void statistics(Object obj, String str) {
        o.b(f11967h, "statistics,params:".concat(String.valueOf(str)));
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            this.f11978i.getJSCommon().a(jSONObject.optInt("type"), jSONObject.optString("data"));
        } catch (Throwable th) {
            o.b(f11967h, "statistics error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(CallMraidJS.b);
            o.b(f11967h, "toggleCloseBtn,result:".concat(String.valueOf(iOptInt)));
            int i2 = 2;
            if (iOptInt != 1) {
                i2 = iOptInt == 2 ? 1 : 0;
            }
            this.f11978i.getJSVideoModule().closeVideoOperate(0, i2);
        } catch (Throwable th) {
            o.b(f11967h, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void triggerCloseBtn(Object obj, String str) {
        o.b(f11967h, "triggerCloseBtn");
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str) || !new JSONObject(str).optString(CallMraidJS.b).equals("click")) {
                return;
            }
            this.f11978i.getJSVideoModule().closeVideoOperate(1, -1);
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(f11967h, "triggerCloseBtn error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void videoOperate(Object obj, String str) {
        try {
            if (this.f11978i == null || TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("pause_or_resume");
            o.b(f11967h, "videoOperate,pauseOrResume:".concat(String.valueOf(iOptInt)));
            this.f11978i.getJSVideoModule().videoOperate(iOptInt);
            j.a().a(obj, b(0));
        } catch (Throwable th) {
            o.b(f11967h, "videoOperate error", th);
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewFireEvent(Object obj, String str) {
        a(obj, str);
        try {
            c.a().O(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "setSubPlayTemplateInfo error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoBack(Object obj, String str) {
        a(obj, str);
        try {
            c.a().y(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "webviewGoBack error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewGoForward(Object obj, String str) {
        a(obj, str);
        try {
            c.a().z(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "webviewGoForward error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewLoad(Object obj, String str) {
        a(obj, str);
        try {
            c.a().w(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "webviewLoad error ".concat(String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.communication.IVideoBridge
    public void webviewReload(Object obj, String str) {
        a(obj, str);
        try {
            c.a().x(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.d(f11967h, "webviewReload error ".concat(String.valueOf(th)));
        }
    }
}
