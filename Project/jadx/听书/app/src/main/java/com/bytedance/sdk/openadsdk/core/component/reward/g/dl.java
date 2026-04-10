package com.bytedance.sdk.openadsdk.core.component.reward.g;

import android.os.Bundle;
import android.view.View;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.iq.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f955a = false;
    private String dl;
    private na g;
    private View gc;
    private final TTBaseVideoActivity z;

    public dl(TTBaseVideoActivity tTBaseVideoActivity) {
        this.z = tTBaseVideoActivity;
    }

    public void z(na naVar, String str, View view) {
        if (this.f955a) {
            return;
        }
        this.f955a = true;
        this.g = naVar;
        this.dl = str;
        this.gc = view;
    }

    public JSONObject z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.z.gb() != null) {
                jSONObject.put("reward_full_scene_type", this.z.gb().h());
                this.z.gb().z(jSONObject);
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return jSONObject;
    }

    public void z(Map<String, Object> map) {
        if (map == null || this.z.gb() == null) {
            return;
        }
        map.put("reward_full_scene_type", Integer.valueOf(this.z.gb().h()));
        this.z.gb().z(map);
    }

    public void z() {
        final JSONObject jSONObjectZ = z(new JSONObject());
        com.bytedance.sdk.openadsdk.core.i.a.z(this.g, this.dl, "skip", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.dl.1
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObjectZ, dl.this.g);
                jSONObject.put("ad_extra_data", jSONObjectZ);
            }
        });
    }

    public void g() {
        final JSONObject jSONObjectZ = z(new JSONObject());
        com.bytedance.sdk.openadsdk.core.i.a.z(this.g, this.dl, "skip_endcard", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.dl.2
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObjectZ, dl.this.g);
                jSONObject.put("ad_extra_data", jSONObjectZ);
            }
        });
    }

    public void dl() {
        final JSONObject jSONObjectZ = z(new JSONObject());
        com.bytedance.sdk.openadsdk.core.i.a.z(this.g, this.dl, "reward_arrived_begin", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.dl.3
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObjectZ, dl.this.g);
                jSONObject.put("ad_extra_data", jSONObjectZ);
            }
        });
    }

    public void z(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        boolean z2 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string = bundle.getString("callback_extra_key_error_msg");
        boolean z3 = bundle.getBoolean("callback_extra_key_is_server_verify");
        String str = z2 ? "reward_arrived_success" : "reward_arrived_failed";
        final JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isRewardVerify", z2);
            jSONObject2.put("isServerCallback", z3);
            jSONObject2.put(MediationConstant.KEY_REWARD_TYPE, i);
            jSONObject2.put(MediationConstant.KEY_ERROR_CODE, i2);
            jSONObject2.put(MediationConstant.KEY_ERROR_MSG, string);
            jSONObject.put("reward_data_bundle", jSONObject2);
        } catch (Exception e) {
            wp.a("RewardFullEventManager", e.getMessage());
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(this.g, this.dl, str, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.dl.4
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject3) throws JSONException {
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, dl.this.g);
                jSONObject3.put("ad_extra_data", dl.this.z(jSONObject));
            }
        });
    }

    public void z(String str, int i, String str2) {
        final JSONObject jSONObjectZ = z(new JSONObject());
        try {
            jSONObjectZ.put("dialog_type", i);
            jSONObjectZ.put("template_url", str2);
        } catch (JSONException e) {
            wp.z(e);
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(this.g, this.dl, str, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.g.dl.5
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObjectZ, dl.this.g);
                jSONObject.put("ad_extra_data", dl.this.z(jSONObjectZ));
            }
        });
    }

    public void z(boolean z2, int i, long j) {
        new z.C0178z().gc(this.g.mj()).z(this.dl).g(z2 ? "scroll_up" : "scroll_down").a(this.g.vk()).z(new z(i, j, z(new JSONObject())));
    }

    private static class z implements com.bytedance.sdk.openadsdk.m.z.z {
        private final JSONObject dl;
        private final long g;
        private final int z;

        z(int i, long j, JSONObject jSONObject) {
            this.z = i;
            this.g = j;
            this.dl = jSONObject;
        }

        @Override // com.bytedance.sdk.openadsdk.m.z.z
        public void z(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = this.dl;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.z);
            jSONObject2.put("duration", this.g);
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        }
    }

    public void z(View view, uy uyVar) {
        try {
            g(view, uyVar);
        } catch (Exception e) {
            wp.a("RewardFullEventManager", "onClickReport error :" + e.getMessage());
        }
    }

    @DungeonFlag
    private void g(View view, uy uyVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387609) {
            z("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387630) {
            z("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387875) {
            z("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387793) {
            z("click_play_logo", (JSONObject) null);
        } else if (view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964) {
            z("click_start_play_bar", a());
        } else if (view.getId() == 2114387642) {
            z("click_video", a());
        } else if (view.getId() == 2114387864) {
            z("fallback_endcard_click", a());
        }
        dl(view, uyVar);
    }

    @DungeonFlag
    private void dl(View view, uy uyVar) {
        if (gc() || this.g == null || view == null) {
            return;
        }
        if (view.getId() == 2114387609 || view.getId() == 2114387630 || view.getId() == 2114387875 || view.getId() == 2114387793 || view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964 || view.getId() == 2114387830 || view.getId() == 2114387642 || view.getId() == 2114387864) {
            int iGz = oq.gz(zw.getContext());
            com.bytedance.sdk.openadsdk.core.i.a.z("click_other", this.g, new fo.z().m(uyVar.v()).gc(uyVar.pf()).a(uyVar.ls()).dl(uyVar.p()).g(System.currentTimeMillis()).z(0L).g(oq.z(this.gc)).z(oq.z((View) null)).dl(oq.dl(this.gc)).a(oq.dl((View) null)).dl(uyVar.g()).a(uyVar.dl()).gc(uyVar.a()).z(uyVar.uy()).g(com.bytedance.sdk.openadsdk.core.uy.ls().dl() ? 1 : 2).z(iGz).z(oq.m(zw.getContext())).g(oq.e(zw.getContext())).z(), this.dl, true, this.z.j(), -1, false);
        }
    }

    @DungeonFlag
    protected JSONObject a() {
        try {
            long jV = this.z.ec().v();
            int iPf = this.z.ec().pf();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jV);
                jSONObject.put("percent", iPf);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void z(String str, JSONObject jSONObject) {
        na naVar = this.g;
        String str2 = this.dl;
        if (!this.z.sy()) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar, str2, str, jSONObject);
    }

    private boolean gc() {
        na naVar = this.g;
        return naVar == null || tb.kb(naVar) != 1;
    }
}
