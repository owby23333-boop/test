package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class ai implements t {
    final /* synthetic */ ad a;

    ai(ad adVar) {
        this.a = adVar;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("interstitial_container", viewGroup);
        map.put(com.anythink.expressad.foundation.g.a.aj, 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.f12820t[0]));
        this.a.a(cv.f13055r, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z2) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("banner_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.h()));
        map.put(com.anythink.expressad.foundation.g.a.aj, 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.f12820t[0]));
        map.put("novel_info", jSONObject);
        this.a.a(cv.f13057t, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.h()));
        map.put(com.anythink.expressad.foundation.g.a.aj, 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.f12820t[0]));
        map.put("novel_info", jSONObject);
        this.a.a(cv.f13056s, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", viewGroup.getContext());
        map.put("banner_container", viewGroup);
        map.put(com.anythink.expressad.foundation.g.a.aj, 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.f12820t[0]));
        this.a.a(cv.f13059v, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("banner_container", viewGroup2);
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.h()));
        map.put(com.anythink.expressad.foundation.g.a.aj, 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.f12820t[0]));
        map.put("backgroundColor", Integer.valueOf(i2));
        this.a.a(cv.f13060w, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String strH = this.a.h("get_cuid");
        String strH2 = this.a.h("get_imei");
        String strH3 = this.a.h("get_oaid");
        try {
            jSONObject.put("cuid", strH);
            jSONObject.put("imei", strH2);
            jSONObject.put("oaid", strH3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(long j2) {
        this.a.f12896i.a("单次阅读器打开时长 = " + j2);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.h()));
        map.put(com.anythink.expressad.foundation.g.a.aj, 2);
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.f12820t[0]));
        map.put("count_down", Integer.valueOf(i2));
        this.a.a(cv.f13061x, map);
    }
}
