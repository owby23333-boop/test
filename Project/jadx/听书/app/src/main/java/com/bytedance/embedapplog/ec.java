package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class ec extends gp {
    private final Context gc;
    private final bv m;

    ec(Context context, bv bvVar) {
        super(false, false);
        this.gc = context;
        this.m = bvVar;
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME);
        jSONObject.put("sdk_version_name", "3.9.1.baseChina-alpha.97");
        jSONObject.put("channel", this.m.kb());
        gb.z(jSONObject, "aid", this.m.uy());
        gb.z(jSONObject, "release_build", this.m.hh());
        gb.z(jSONObject, "app_region", this.m.v());
        gb.z(jSONObject, "app_language", this.m.i());
        gb.z(jSONObject, "user_agent", this.m.l());
        gb.z(jSONObject, "ab_sdk_version", this.m.ls());
        gb.z(jSONObject, "ab_version", this.m.tb());
        gb.z(jSONObject, "aliyun_uuid", this.m.g());
        String strWp = this.m.wp();
        if (TextUtils.isEmpty(strWp)) {
            strWp = n.z(this.gc, this.m);
        }
        if (!TextUtils.isEmpty(strWp)) {
            gb.z(jSONObject, "google_aid", strWp);
        }
        String strSy = this.m.sy();
        if (!TextUtils.isEmpty(strSy)) {
            try {
                jSONObject.put("app_track", new JSONObject(strSy));
            } catch (Throwable th) {
                cb.g(th);
            }
        }
        String strPf = this.m.pf();
        if (strPf != null && strPf.length() > 0) {
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, new JSONObject(strPf));
        }
        gb.z(jSONObject, "user_unique_id", this.m.p());
        return true;
    }
}
