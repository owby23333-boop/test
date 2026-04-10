package com.anythink.expressad.mbbanner.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import anet.channel.entity.ConnType;
import com.anythink.core.common.a.i;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends CommonBannerJSBridgeImp {
    private static final String b = "BannerJSBridgeImpl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f10777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<com.anythink.expressad.foundation.d.c> f10778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.anythink.expressad.mbbanner.a.c.a f10782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f10783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f10784j = false;

    public c(Context context, String str, String str2) {
        this.f10779e = str;
        this.f10780f = str2;
        this.f10777c = new WeakReference<>(context);
    }

    public final void a(com.anythink.expressad.mbbanner.a.c.a aVar) {
        if (aVar != null) {
            this.f10782h = aVar;
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void click(Object obj, String str) {
        com.anythink.expressad.foundation.d.c cVarB;
        o.d(b, "click");
        try {
            if (this.f10778d == null) {
                return;
            }
            com.anythink.expressad.foundation.d.c cVar = null;
            if (this.f10778d != null && this.f10778d.size() > 0) {
                cVar = this.f10778d.get(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectA = com.anythink.expressad.foundation.d.c.a(cVar);
                JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectA.put(next, jSONObject.getString(next));
                }
                cVarB = com.anythink.expressad.foundation.d.c.b(jSONObjectA);
                String strOptString = jSONObjectA.optString("unitId");
                if (!TextUtils.isEmpty(strOptString)) {
                    cVarB.l(strOptString);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                cVarB = cVar;
            }
            if (this.f10782h != null) {
                this.f10782h.a(cVarB);
            }
        } catch (Throwable th) {
            o.b(b, "click", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void close() {
        o.d(b, com.anythink.expressad.foundation.d.c.cf);
        try {
            if (this.f10782h != null) {
                this.f10782h.b();
            }
        } catch (Throwable th) {
            o.b(b, com.anythink.expressad.foundation.d.c.cf, th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void expand(String str, boolean z2) {
        Context context;
        try {
            String strP = "";
            if (getMraidCampaign() != null) {
                if (TextUtils.isEmpty(getMraidCampaign().q())) {
                    strP = getMraidCampaign().p();
                } else {
                    strP = "file:////" + getMraidCampaign().q();
                }
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(str)) {
                str = strP;
            }
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z2);
            if (this.f10777c != null && (context = this.f10777c.get()) != null) {
                if (this.f10783i != null && this.f10783i.isShowing()) {
                    return;
                }
                this.f10783i = new b(context, bundle, this.f10782h);
                this.f10783i.a(this.f10780f, this.f10778d);
                this.f10783i.show();
            }
            if (this.f10782h != null) {
                this.f10782h.a(true);
            }
        } catch (Throwable th) {
            o.b(b, "expand", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void getFileInfo(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            CommonJSBridgeImpUtils.callbackExcep(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th) {
            o.a(b, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final com.anythink.expressad.foundation.d.c getMraidCampaign() {
        List<com.anythink.expressad.foundation.d.c> list = this.f10778d;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f10778d.get(0);
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void init(Object obj, String str) {
        o.d(b, "BANNER INIT INVOKE");
        try {
            JSONObject jSONObject = new JSONObject();
            com.anythink.expressad.foundation.h.c cVar = new com.anythink.expressad.foundation.h.c(n.a().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f10781g);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", cVar.a());
            jSONObject.put("campaignList", com.anythink.expressad.foundation.d.c.b(this.f10778d));
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.c cVarC = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.f10780f);
            if (cVarC == null) {
                cVarC = com.anythink.expressad.d.c.c(this.f10780f);
            }
            if (!TextUtils.isEmpty(this.f10779e)) {
                cVarC.e(this.f10779e);
            }
            jSONObject.put("unitSetting", cVarC.s());
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e());
            jSONObject.put("appSetting", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            o.b(b, "init", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void open(String str) {
        o.d(b, ConnType.PK_OPEN);
        try {
            o.d(b, str);
            if (this.f10778d.size() > 1) {
                n.a().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            if (this.f10782h != null) {
                this.f10782h.a(true, str);
            }
        } catch (Throwable th) {
            o.b(b, ConnType.PK_OPEN, th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void readyStatus(Object obj, String str) {
        if (obj != null) {
            try {
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(0));
                if (this.f10782h != null) {
                    this.f10782h.b(iOptInt);
                }
            } catch (Throwable th) {
                o.b(b, "readyStatus", th);
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void sendImpressions(Object obj, String str) {
        o.a(b, "sendImpressions:".concat(String.valueOf(str)));
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                for (com.anythink.expressad.foundation.d.c cVar : this.f10778d) {
                    if (cVar.aZ().equals(string)) {
                        f.a(this.f10780f, cVar, "banner");
                        arrayList.add(string);
                    }
                }
            }
        } catch (Throwable th) {
            o.b(b, "sendImpressions", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void toggleCloseBtn(Object obj, String str) {
        o.d(b, "toggleCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt(CallMraidJS.b);
            if (this.f10782h != null) {
                this.f10782h.a(iOptInt);
            }
        } catch (Throwable th) {
            o.b(b, "toggleCloseBtn", th);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.bridge.CommonBannerJSBridgeImp, com.anythink.expressad.atsignalcommon.bridge.IBannerJSBridge
    public final void triggerCloseBtn(Object obj, String str) {
        o.d(b, "triggerCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new JSONObject(str).optString(CallMraidJS.b);
            if (this.f10782h != null) {
                this.f10782h.a();
            }
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(0));
        } catch (Throwable th) {
            o.b(b, "triggerCloseBtn", th);
            j.a().a(obj, CommonJSBridgeImpUtils.codeToJsonString(-1));
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public final void useCustomClose(boolean z2) {
        int i2 = z2 ? 2 : 1;
        try {
            if (this.f10782h != null) {
                this.f10782h.a(i2);
            }
        } catch (Throwable th) {
            o.b(b, "useCustomClose", th);
        }
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        this.f10778d = list;
    }

    public final void a(int i2) {
        this.f10781g = i2;
    }

    public final void a() {
        if (this.f10782h != null) {
            this.f10782h = null;
        }
        if (this.f10783i != null) {
            this.f10783i = null;
        }
    }

    private static void a(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String strConcat;
        File file;
        String str4 = "message";
        String str5 = "code";
        JSONObject jSONObject2 = new JSONObject();
        int i2 = 1;
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    String strOptString = jSONObject3.optString("ref", "");
                    int i4 = jSONObject3.getInt("type");
                    JSONObject jSONObject4 = new JSONObject();
                    JSONArray jSONArray3 = jSONArray;
                    if (i4 == i2 && !TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject5 = new JSONObject();
                        com.anythink.expressad.videocommon.b.a.a();
                        i iVarB = com.anythink.expressad.videocommon.b.a.b(strOptString);
                        if (iVarB != null) {
                            o.a(b, "VideoBean not null");
                            jSONObject5.put("type", 1);
                            str2 = str4;
                            str3 = str5;
                            try {
                                jSONObject5.put("videoDataLength", iVarB.d());
                                String strB = iVarB.b();
                                if (TextUtils.isEmpty(strB)) {
                                    o.a(b, "VideoPath null");
                                    jSONObject5.put("path", "");
                                    jSONObject5.put("path4Web", "");
                                } else {
                                    o.a(b, "VideoPath not null");
                                    jSONObject5.put("path", strB);
                                    jSONObject5.put("path4Web", strB);
                                }
                                if (iVarB.c() == 100) {
                                    jSONObject5.put("downloaded", 1);
                                } else {
                                    jSONObject5.put("downloaded", 0);
                                }
                                jSONObject4.put(strOptString, jSONObject5);
                                jSONArray2.put(jSONObject4);
                            } catch (Throwable th) {
                                th = th;
                                str4 = str2;
                                str = str3;
                            }
                        } else {
                            str2 = str4;
                            str3 = str5;
                            o.a(b, "VideoBean null");
                        }
                    } else {
                        str2 = str4;
                        str3 = str5;
                        if (i4 == 2 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("type", 2);
                            jSONObject6.put("path", com.anythink.expressad.videocommon.b.i.a().a(strOptString) == null ? "" : com.anythink.expressad.videocommon.b.i.a().c(strOptString));
                            jSONObject4.put(strOptString, jSONObject6);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 3 && !TextUtils.isEmpty(strOptString)) {
                            try {
                                file = new File(strOptString);
                            } catch (Throwable th2) {
                                if (com.anythink.expressad.a.a) {
                                    th2.printStackTrace();
                                }
                            }
                            if (file.exists() && file.isFile() && file.canRead()) {
                                o.a(b, "getFileInfo Mraid file ".concat(String.valueOf(strOptString)));
                                strConcat = "file:////".concat(String.valueOf(strOptString));
                            } else {
                                strConcat = "";
                            }
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("type", 3);
                            jSONObject7.put("path", strConcat);
                            jSONObject4.put(strOptString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 4 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject8 = new JSONObject();
                            jSONObject8.put("type", 4);
                            jSONObject8.put("path", s.a(strOptString) == null ? "" : s.a(strOptString));
                            jSONObject4.put(strOptString, jSONObject8);
                            jSONArray2.put(jSONObject4);
                        }
                    }
                    i3++;
                    jSONArray = jSONArray3;
                    str4 = str2;
                    str5 = str3;
                    i2 = 1;
                }
                str2 = str4;
                str3 = str5;
                jSONObject2.put("resource", jSONArray2);
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            str = "code";
            try {
                jSONObject2.put(str, 1);
                str4 = "message";
            } catch (JSONException e2) {
                e = e2;
                str4 = "message";
            } catch (Throwable th3) {
                th = th3;
                str4 = "message";
            }
            try {
                try {
                    jSONObject2.put(str4, "resource is null");
                    j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (JSONException e3) {
                e = e3;
                o.a(b, e.getMessage());
                return;
            }
        } catch (Throwable th5) {
            th = th5;
            str = str5;
        }
        try {
            jSONObject2.put(str, 1);
            jSONObject2.put(str4, th.getLocalizedMessage());
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (JSONException e4) {
            o.a(b, e4.getMessage());
        }
    }
}
