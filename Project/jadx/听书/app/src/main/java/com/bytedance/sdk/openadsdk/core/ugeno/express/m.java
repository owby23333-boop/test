package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.tb;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.adsdk.ugeno.gc.g.z;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.component.adexpress.g.e;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.nh;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.nativeexpress.uy;
import com.bytedance.sdk.openadsdk.core.un.mc;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m extends a implements z {
    private uy js;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.z.g tb;

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.a, com.bytedance.sdk.component.adexpress.dynamic.a
    public void z(CharSequence charSequence, int i, int i2, boolean z) {
    }

    public m(Context context, na naVar, g gVar, ViewGroup viewGroup) {
        super(context, naVar, gVar, viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.a
    protected JSONObject z() {
        return this.e.gc().optJSONObject("xTemplate");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.a
    protected void g(e eVar) {
        v();
        this.z.z((fv) this);
        this.z.z((tb) this);
        nh nhVarE = vm.e(this.m);
        try {
            if (nhVarE != null) {
                this.dl = this.z.z(this.f1350a, this.gc, nhVarE.gc());
            } else {
                this.dl = this.z.z(this.f1350a, this.gc, (JSONObject) null);
            }
            if (this.z.z()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_not_exist", new JSONArray((Collection) this.z.g()));
                this.e.mc().z(jSONObject);
                eVar.z(138, "ugen unknown component");
                return;
            }
            if (this.dl != null) {
                if (this.fv == null) {
                    this.fv = new com.bytedance.sdk.openadsdk.core.ugeno.uy.z(this.e.gc());
                }
                this.fv.z(this.z, this.dl);
            }
            this.e.mc().g();
            this.e.mc().dl();
        } catch (NoClassDefFoundError unused) {
            if (eVar != null) {
                eVar.z(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, "ugen no class def found error");
            }
        } catch (UnsatisfiedLinkError unused2) {
            if (eVar != null) {
                eVar.z(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, "ugen yoga so load fail");
            }
        } catch (Throwable unused3) {
            if (eVar != null) {
                eVar.z(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, "ugen other fail");
            }
        }
    }

    private void v() {
        v vVar = new v();
        HashMap map = new HashMap();
        map.put("shake_value", Integer.valueOf(this.e.fv()));
        map.put("calculation_method", Integer.valueOf(this.e.io()));
        map.put("rotation_angle", Integer.valueOf(this.e.tb()));
        map.put("calculation_method_twist", Integer.valueOf(this.e.uf()));
        map.put("twist_config", this.e.q());
        map.put("image_info", this.e.v());
        map.put("cache_dir", this.e.p());
        map.put("shake_interact_conf", this.e.iq());
        map.put("twist_interact_conf", this.e.zw());
        vVar.z(map);
        vVar.z(this.g);
        vVar.z(this.f1350a);
        vVar.g(this.gc);
        this.z.z(an.aw, vVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.a
    protected com.bytedance.adsdk.ugeno.g.dl gc() {
        if (this.dl == null) {
            return null;
        }
        return this.dl.gc("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.a
    protected JSONObject uy() {
        return this.e.gc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.a, com.bytedance.adsdk.ugeno.dl.fv
    public void z(final com.bytedance.adsdk.ugeno.g.dl dlVar, final String str, final m.z zVar) {
        if (zVar == null) {
            return;
        }
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            if (this.i == null || this.i.get() == null) {
                return;
            }
            mc.z(this.i, new com.bytedance.sdk.openadsdk.core.g.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.m.1
                @Override // com.bytedance.sdk.openadsdk.core.g.dl
                public void z() {
                    if (m.this.i == null || m.this.i.get() == null || !mc.z(m.this.i.get())) {
                        return;
                    }
                    m.this.g(dlVar, str, zVar);
                }
            });
            return;
        }
        g(dlVar, str, zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
        int i;
        CharSequence text;
        String strG = zVar.g();
        if (com.bytedance.sdk.openadsdk.core.ugeno.express.z.z.z.contains(strG)) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.z.z.z(this.js, this.tb, this.m, strG, zVar);
            return;
        }
        strG.hashCode();
        i = 5;
        switch (strG) {
            case "openAppPermission":
                i = 10;
                break;
            case "openCommonUrl":
                i = 13;
                break;
            case "openPrivacy":
                i = 7;
                break;
            case "resumeVideo":
                uy uyVar = this.js;
                if (uyVar != null) {
                    uyVar.z(3);
                    return;
                }
                return;
            case "pauseVideo":
                uy uyVar2 = this.js;
                if (uyVar2 != null) {
                    uyVar2.z(2);
                    return;
                }
                return;
            case "skip":
                i = 6;
                break;
            case "close":
                i = 8;
                break;
            case "openAppFunction":
                i = 12;
                break;
            case "videoControl":
                i = 4;
                break;
            case "convert":
                i = 2;
                break;
            case "muteVideo":
                break;
            case "openAppPolicy":
                i = 9;
                break;
            case "dislike":
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        zw.z zVarZ = new zw.z().a(this.wp.v()).dl(this.wp.pf()).g(this.wp.ls()).z(this.wp.p()).z(dlVar.x()).g(this.wp.wp()).z(this.wp.i());
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.equals(str, "shake") || TextUtils.equals(str, "twist")) {
            try {
                jSONObject.put("convertActionType", 1);
            } catch (Throwable unused) {
            }
        }
        try {
            String strZ = com.bytedance.adsdk.ugeno.a.g.z(zVar.dl().getOrDefault("webUrl", ""), uy());
            String strZ2 = com.bytedance.adsdk.ugeno.a.g.z(zVar.dl().getOrDefault("webTitle", ""), uy());
            jSONObject.put("openCommonWebUrl", strZ);
            jSONObject.put("openCommonWebTitle", strZ2);
        } catch (JSONException unused2) {
        }
        View viewFo = dlVar.fo();
        try {
            if ((viewFo instanceof TextView) && (text = ((TextView) viewFo).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused3) {
        }
        zVarZ.z(jSONObject);
        zw zwVarZ = zVarZ.z();
        if (this.fo != null) {
            this.fo.z(viewFo, i, zwVarZ);
        }
    }

    public void z(String str, Map<String, String> map) {
        if (this.dl == null) {
            return;
        }
        m.z zVar = new m.z();
        zVar.z(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
        zVar.g("emit");
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put("name", str);
        zVar.z(map2);
        z.C0046z.z(this.dl, "jsb", zVar).z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.z
    public void z(uy uyVar) {
        this.js = uyVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.express.z.g gVar) {
        this.tb = gVar;
    }
}
