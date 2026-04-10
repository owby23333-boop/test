package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class cu implements t {
    final /* synthetic */ int a;
    final /* synthetic */ int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f13052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ cq f13053d;

    cu(cq cqVar, int i2, int i3, String str) {
        this.f13053d = cqVar;
        this.a = i2;
        this.b = i3;
        this.f13052c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f13053d.f());
        map.put("interstitial_container", viewGroup);
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        map.put("novel_id", this.f13052c);
        this.f13053d.a(cv.f13055r, map);
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
        map.put("novel_activity", this.f13053d.f());
        map.put("banner_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f13053d.g()));
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        map.put("novel_id", this.f13052c);
        map.put("novel_info", jSONObject);
        this.f13053d.a(cv.f13057t, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f13053d.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f13053d.g()));
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        map.put("novel_id", this.f13052c);
        map.put("novel_info", jSONObject);
        this.f13053d.a(cv.f13056s, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", viewGroup.getContext());
        map.put("banner_container", viewGroup);
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        map.put("novel_id", this.f13052c);
        this.f13053d.a(cv.f13059v, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f13053d.f());
        map.put("banner_container", viewGroup2);
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f13053d.g()));
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        map.put("novel_id", this.f13052c);
        map.put("backgroundColor", Integer.valueOf(i2));
        this.f13053d.a(cv.f13060w, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String strH = this.f13053d.h("get_cuid");
        String strH2 = this.f13053d.h("get_imei");
        String strH3 = this.f13053d.h("get_oaid");
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
        this.f13053d.f12896i.a("单次阅读器打开时长 = " + j2);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.f13053d.f());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.f13053d.g()));
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.b));
        map.put("novel_id", this.f13052c);
        map.put("count_down", Integer.valueOf(i2));
        this.f13053d.a(cv.f13061x, map);
    }
}
