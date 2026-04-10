package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class cy implements t {
    final /* synthetic */ cv a;

    cy(cv cvVar) {
        this.a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("interstitial_container", viewGroup);
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a.D));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.E));
        map.put("novel_id", this.a.F);
        this.a.a(cv.f13055r, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("banner_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.h()));
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a.D));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.E));
        map.put("novel_id", this.a.F);
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
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a.D));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.E));
        map.put("novel_id", this.a.F);
        map.put("novel_info", jSONObject);
        this.a.a(cv.f13056s, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", viewGroup.getContext());
        map.put("banner_container", viewGroup);
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a.D));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.E));
        map.put("novel_id", this.a.F);
        map.put("isnight", Boolean.valueOf(this.a.w()));
        this.a.a(cv.f13059v, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("banner_container", viewGroup2);
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.h()));
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a.D));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.E));
        map.put("novel_id", this.a.F);
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
        if (this.a.H != null) {
            this.a.H.onReadTime(j2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i2) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", this.a.g());
        map.put("interstitial_container", viewGroup);
        map.put("isnight", Boolean.valueOf(this.a.h()));
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a.D));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.E));
        map.put("novel_id", this.a.F);
        map.put("count_down", Integer.valueOf(i2));
        this.a.a(cv.f13061x, map);
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z2) {
        RelativeLayout relativeLayout;
        if (this.a.I == null || (relativeLayout = (RelativeLayout) this.a.I.get()) == null) {
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("novel_activity", (Activity) this.a.f12895h);
        map.put("interstitial_container", null);
        map.put("banner_container", relativeLayout);
        map.put(com.anythink.expressad.foundation.g.a.aj, Integer.valueOf(this.a.D));
        map.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.a.E));
        map.put("novel_id", this.a.F);
        map.put("isnight", Boolean.valueOf(this.a.w()));
        this.a.a(cv.f13060w, map);
    }
}
