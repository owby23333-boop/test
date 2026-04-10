package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dd extends bf {
    private e.a A;
    private BaiduNativeManager.ExpressAdListener B;
    private BaiduNativeManager.EntryAdListener C;
    private e.b D;
    private int E;
    private List<NativeResponse> a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private List<ExpressResponse> f13086q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<EntryResponse> f13087r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f13088s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f13089t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f13090u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f13091v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f13092w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f13093x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private RequestParameters f13094y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f13095z;

    public dd(Context context, String str, String str2, boolean z2, int i2) {
        super(context);
        this.f13088s = 8000;
        this.f13095z = false;
        this.E = 0;
        this.f13091v = str;
        this.f13090u = str2;
        this.f13089t = z2;
        this.f13088s = i2;
        this.f13092w = 600;
        this.f13093x = 500;
    }

    public void a(e.a aVar) {
        this.A = aVar;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            map.put("activity", activity);
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, map);
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b_() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z2) {
        this.f13095z = z2;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c_() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d() {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i2 = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.a != null) {
            while (i2 < this.a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.a(xAdNativeResponse);
                }
                i2++;
            }
            return;
        }
        if (this.B != null && !TextUtils.isEmpty(message) && this.f13086q != null) {
            while (i2 < this.f13086q.size()) {
                bn bnVar = (bn) this.f13086q.get(i2);
                if (TextUtils.equals(message, bnVar.a())) {
                    bnVar.c();
                }
                i2++;
            }
            return;
        }
        if (this.C == null || TextUtils.isEmpty(message) || this.f13087r == null) {
            return;
        }
        while (i2 < this.f13087r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f13087r.get(i2);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onADExposed();
            }
            i2++;
        }
    }

    public String f() {
        return this.f13090u;
    }

    public RequestParameters g() {
        return this.f13094y;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i2 = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.a != null) {
            while (i2 < this.a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.b(xAdNativeResponse);
                }
                i2++;
            }
            return;
        }
        if (this.B != null && !TextUtils.isEmpty(message) && this.f13086q != null) {
            while (i2 < this.f13086q.size()) {
                bn bnVar = (bn) this.f13086q.get(i2);
                if (TextUtils.equals(message, bnVar.a())) {
                    bnVar.b();
                }
                i2++;
            }
            return;
        }
        if (this.C == null || TextUtils.isEmpty(message) || this.f13087r == null) {
            return;
        }
        while (i2 < this.f13087r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f13087r.get(i2);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdClick();
            }
            i2++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f13086q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int iIntValue = ((Integer) data.get("viewWidth")).intValue();
        int iIntValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i2 = 0; i2 < this.f13086q.size(); i2++) {
            bn bnVar = (bn) this.f13086q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                bnVar.a(view, iIntValue, iIntValue2);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f13086q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int iIntValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i2 = 0; i2 < this.f13086q.size(); i2++) {
            bn bnVar = (bn) this.f13086q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                bnVar.a(view, str2, iIntValue);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str) && TextUtils.equals("dismiss", str2)) {
                xAdNativeResponse.onShakeViewDismiss();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.f13088s);
            jSONObject.put("isCacheVideo", this.f13089t);
            jSONObject.put("cacheVideoOnlyWifi", this.f13095z);
            jSONObject.put("appConfirmPolicy", this.f13094y == null ? 1 : this.f13094y.getAPPConfirmPolicy());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void q() {
        int iOptInt;
        boolean zB;
        if (this.A == null && this.B == null && this.C == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVarA = b.a(this.f12901n);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (i3 < bVarA.a().size()) {
            a aVar = bVarA.a().get(i3);
            String strM = aVar.m();
            int i4 = 3;
            if (aVar.p() == 1) {
                i4 = 1;
            } else if (aVar.p() != 2) {
                if (aVar.p() == 512) {
                    try {
                        JSONObject jSONObject = new JSONObject(aVar.q());
                        iOptInt = jSONObject.optInt("fb_act", i2);
                        try {
                            zB = br.b(this.f12895h, jSONObject.optString("page", ""));
                        } catch (Throwable unused) {
                            zB = false;
                        }
                    } catch (Throwable unused2) {
                        iOptInt = 0;
                    }
                    if (!zB) {
                        if (iOptInt != 1 && iOptInt == 2) {
                            if (TextUtils.isEmpty(strM) || !br.a(this.f12895h, strM)) {
                                i2 = 0;
                                i4 = 2;
                            }
                        }
                    }
                    i2 = 0;
                }
                i2 = 0;
                i4 = 1;
            } else if (strM == null || strM.equals("") || strM.equals("null") || hashSet.contains(strM)) {
                i2 = 1;
                i4 = 1;
            } else {
                hashSet.add(strM);
                if (!br.a(this.f12895h, strM)) {
                    i4 = 2;
                }
            }
            if (i2 == 0) {
                if (this.A != null) {
                    XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.f12895h, this, aVar);
                    xAdNativeResponse.setIsDownloadApp(i4 == 2);
                    xAdNativeResponse.setAdActionType(i4);
                    arrayList.add(xAdNativeResponse);
                } else if (this.B != null) {
                    bn bnVar = new bn(this.f12895h, this, aVar);
                    bnVar.a(i4);
                    arrayList2.add(bnVar);
                } else if (this.C != null) {
                    arrayList3.add(new XAdEntryResponse(this.f12895h, this, aVar));
                }
            }
            i3++;
            i2 = 0;
        }
        e.a aVar2 = this.A;
        if (aVar2 != null) {
            this.a = arrayList;
            aVar2.a(arrayList);
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            this.f13086q = arrayList2;
            expressAdListener.onNativeLoad(arrayList2);
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            this.f13087r = arrayList3;
            entryAdListener.onNativeLoad(arrayList3);
        }
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.B = expressAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f13086q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i2 = 0; i2 < this.f13086q.size(); i2++) {
            bn bnVar = (bn) this.f13086q.get(i2);
            if (TextUtils.equals(bnVar.a(), str)) {
                if (TextUtils.equals(TTLogUtil.TAG_EVENT_SHOW, str2)) {
                    bnVar.d();
                } else if (TextUtils.equals("click", str2)) {
                    Object obj = data.get("reason");
                    bnVar.a(obj instanceof String ? (String) obj : "");
                } else if (TextUtils.equals(com.anythink.expressad.foundation.d.c.cf, str2)) {
                    bnVar.e();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i2 = 0;
        if (this.A != null && data != null && this.a != null) {
            String str = (String) data.get("instanceInfo");
            while (i2 < this.a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.A.a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
                i2++;
            }
            return;
        }
        if (this.C == null || data == null || this.f13087r == null) {
            return;
        }
        String str2 = (String) data.get("instanceInfo");
        while (i2 < this.f13087r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f13087r.get(i2);
            if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
            }
            i2++;
        }
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.C = entryAdListener;
    }

    public void a(e.b bVar) {
        this.D = bVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        IAdInterListener iAdInterListener = this.f12898k;
        if (iAdInterListener == null) {
            this.f12899l = false;
        } else {
            this.f12899l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(IOAdEvent iOAdEvent) {
        if (this.D == null || iOAdEvent == null || this.a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.D.a(xAdNativeResponse);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void d(String str) {
        if (!TextUtils.isEmpty(str) && this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.f13086q != null) {
            for (int i3 = 0; i3 < this.f13086q.size(); i3++) {
                bn bnVar = (bn) this.f13086q.get(i3);
                if (TextUtils.equals(str, bnVar.a())) {
                    bnVar.f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f13087r == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f13087r.size(); i4++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f13087r.get(i4);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f13092w = width;
            this.f13093x = height;
        }
        this.f13094y = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f13090u);
            this.f12898k.createProdHandler(jSONObject2);
            this.f12898k.setAdContainer(this.f12894g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f13090u);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f13091v);
            if (cn.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f12902o)) {
                jSONObject.put("appid", this.f12902o);
            }
            if ("video".equals(this.f13090u)) {
                jSONObject.put("at", AgooConstants.ACK_REMOVE_PACKAGE);
                jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f13092w);
            jSONObject.put("h", "" + this.f13093x);
            jSONObject.put("msa", 143);
            jSONObject = j.a(jSONObject, b(this.f12900m));
            jSONObject.put("opt", this.E);
            if (this.E == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, int i2) {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.b(i2, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNativeFail(i2, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i2, str);
        }
    }

    public void a(int i2) {
        this.E = i2;
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.G());
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, map);
        Object obj = map.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void e(String str) {
        if (!TextUtils.isEmpty(str) && this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f13086q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f13086q.size(); i3++) {
            bn bnVar = (bn) this.f13086q.get(i3);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.g();
            }
        }
    }

    public String h() {
        return this.f13091v;
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> mapA = j.a(map);
            if (this.f12900m == null) {
                this.f12900m = new HashMap<>();
            }
            if (mapA.isEmpty()) {
                return;
            }
            for (String str : mapA.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = mapA.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.f12900m.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void b(String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z2);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f13086q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f13086q.size(); i3++) {
            bn bnVar = (bn) this.f13086q.get(i3);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.b(z2);
            }
        }
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.G());
            map.put("container", viewGroup);
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, map);
    }

    public boolean a(View view, a aVar, int i2) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            map.put(com.anythink.expressad.a.B, view);
            map.put("code", Integer.valueOf(i2));
        } catch (JSONException e2) {
            bq.a().a(e2);
        }
        a(jSONObject, map);
        Object obj = map.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(int i2, String str) {
        e.a aVar = this.A;
        if (aVar != null) {
            aVar.a(i2, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNoAd(i2, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i2, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    protected void a(String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z2);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f13086q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f13086q.size(); i3++) {
            bn bnVar = (bn) this.f13086q.get(i3);
            if (TextUtils.equals(str, bnVar.a())) {
                bnVar.a(z2);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(Map<String, String> map) {
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap map2 = new HashMap(map);
        HashMap<String, String> map3 = new HashMap<>();
        int i2 = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (map2.containsKey(str)) {
                String str2 = (String) map2.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i2) < 150) {
                    map3.put(str, str2);
                    i2 = length;
                }
            }
        }
        if (!map2.isEmpty()) {
            for (String str3 : map2.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) map2.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i2 + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        map3.put("c_" + str3, str4);
                        i2 = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.f12900m = map3;
    }
}
