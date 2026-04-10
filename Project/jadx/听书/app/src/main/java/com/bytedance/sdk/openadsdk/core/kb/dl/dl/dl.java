package com.bytedance.sdk.openadsdk.core.kb.dl.dl;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.kb.dl.uy;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.core.zw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private z dl;
    private Context g;
    private com.bytedance.sdk.openadsdk.core.kb.dl.z.z gc;
    private na z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1217a = true;
    private boolean m = false;
    private int e = 0;
    private boolean gz = false;

    public dl(Context context, na naVar) {
        this.g = context;
        this.z = naVar;
    }

    public void z(z zVar) {
        z(zVar, this.z);
    }

    public void z(z zVar, na naVar) {
        this.dl = zVar;
        if (zVar == null) {
            return;
        }
        zVar.z(this.g);
        zVar.z(naVar);
        zVar.z(this.f1217a);
    }

    public void z(boolean z) {
        this.f1217a = z;
    }

    public void z(com.bytedance.sdk.openadsdk.core.kb.dl.z.z zVar) {
        this.gc = zVar;
    }

    public void g(boolean z) {
        this.m = z;
    }

    public void z(int i) {
        this.e = i;
    }

    public void dl(boolean z) {
        this.gz = z;
    }

    public boolean a(boolean z) {
        z zVar = this.dl;
        boolean z2 = true;
        if (zVar == null) {
            return true;
        }
        if (zVar instanceof g) {
            g gVar = (g) zVar;
            if (!z && !this.gz) {
                z2 = false;
            }
            gVar.dl(z2);
            gVar.g(this.m);
            gVar.z(this.e);
        }
        return this.dl.z();
    }

    public void z(String str, com.bytedance.sdk.openadsdk.core.kb.dl.z.g gVar) {
        if (this.z == null) {
            return;
        }
        z((com.bytedance.sdk.openadsdk.core.iq.a) null, str, gVar);
    }

    public void z(com.bytedance.sdk.openadsdk.core.iq.a aVar, final String str, final String str2, final com.bytedance.sdk.openadsdk.core.kb.dl.z.g gVar) {
        na naVar = this.z;
        if (naVar == null) {
            return;
        }
        if (aVar != null || naVar.dh() != 2 || (this.dl instanceof gc)) {
            z(aVar, str, gVar);
        } else {
            e.g(new fo("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl.1
                @Override // java.lang.Runnable
                public void run() {
                    dl.this.z(zw.z().z(dl.this.z, str2), str, gVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.iq.a aVar, String str, com.bytedance.sdk.openadsdk.core.kb.dl.z.g gVar) {
        String strGy;
        String strG;
        String strZ;
        m.z zVarG = g(str, gVar);
        try {
            if (aVar != null) {
                com.bytedance.sdk.openadsdk.core.iq.m mVarBw = this.z.bw();
                if (mVarBw != null) {
                    aVar.z(mVarBw.a());
                    aVar.z(mVarBw.dl());
                }
                strGy = aVar.m();
                strG = aVar.z();
                strZ = aVar.dl();
            } else {
                strGy = this.z.gy();
                strG = uy.g(this.z);
                gk gkVarKp = this.z.kp();
                strZ = gkVarKp != null ? gkVarKp.z() : "";
            }
            if (com.bytedance.sdk.openadsdk.core.ugeno.uy.fo(this.z)) {
                if (!com.bytedance.sdk.openadsdk.core.ugeno.uy.z(this.g, this.z, strG)) {
                    na naVar = this.z;
                    z(naVar, str, com.bytedance.sdk.openadsdk.core.ugeno.uy.g(this.g, naVar, strG), 0, "");
                }
            } else {
                com.bytedance.sdk.openadsdk.core.i.a.g(this.z, str, "pop_up", z());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", strG);
            jSONObject.put("dialog_icon_url", strZ);
            jSONObject.put("dialog_app_description", this.z.he());
            String strZ2 = z(strGy);
            g(str);
            if (com.bytedance.sdk.openadsdk.core.ugeno.uy.z(this.g, this.z, strG)) {
                z(str, zVarG, strZ2, strZ, jSONObject);
            } else {
                com.bytedance.sdk.openadsdk.core.un.m.z(this.g, this.z.mj(), strZ2, jSONObject.toString(), zVarG, this.z);
            }
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    private String z(String str) {
        int iFv = tb.fv(this.z);
        try {
            if (iFv != 4) {
                if (iFv != 3) {
                    return str;
                }
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("ugen_url", tb.tb(this.z));
            jSONObject2.put("ugen_md5", tb.q(this.z));
            jSONObject2.put("download_num", g(this.z.jc()));
            if (this.z.c() == null) {
                return jSONObject2.toString();
            }
            jSONObject2.put("app_size", dl(r1.e()));
            jSONObject2.put("comment_num", z(r1.m()));
            return jSONObject2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    private void g(final String str) {
        if (tb.fv(this.z) != 4) {
            return;
        }
        TTDelegateActivity.z(new com.bytedance.sdk.openadsdk.core.ugeno.e.e() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(int i, String str2) {
                dl.this.z(str, 1, str2);
                TTDelegateActivity.z((com.bytedance.sdk.openadsdk.core.ugeno.e.e) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                dl.this.z(str, 0, "");
                TTDelegateActivity.z((com.bytedance.sdk.openadsdk.core.ugeno.e.e) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, int i, String str2) {
        JSONObject jSONObjectZ = z();
        try {
            jSONObjectZ.put("ugen_dl_render_fail_msg", str2);
            jSONObjectZ.put("ugen_dl_render_fail", i);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.i.a.g(this.z, str, "pop_up", jSONObjectZ);
    }

    public String z(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(j / 100000000));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(j / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
        }
        return j > 0 ? String.valueOf(j) : "-";
    }

    public String g(long j) {
        if (j >= 100000000) {
            return String.format("%d亿+", Long.valueOf(Math.round(j / 1.0E8d)));
        }
        if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return String.format("%d万+", Long.valueOf(Math.round(j / 10000.0d)));
        }
        return j > 0 ? String.valueOf(j) : "-";
    }

    public String dl(long j) {
        return j <= 0 ? "-" : String.format("%.1fMB", Double.valueOf((j / 1024.0d) / 1024.0d));
    }

    private void z(String str, m.z zVar, String str2, String str3, JSONObject jSONObject) throws JSONException {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.bytedance.sdk.openadsdk.core.un.m.z(this.g, this.z.mj(), com.bytedance.sdk.openadsdk.core.ugeno.uy.z(this.g, str2, this.z, str3), jSONObject.toString(), zVar, dl(str), this.z);
    }

    private com.bytedance.sdk.openadsdk.core.ugeno.e.e dl(final String str) {
        return new com.bytedance.sdk.openadsdk.core.ugeno.e.e() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(int i, String str2) {
                dl dlVar = dl.this;
                dlVar.z(dlVar.z, str, 6, i, str2);
                TTDelegateActivity.z((com.bytedance.sdk.openadsdk.core.ugeno.e.e) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                dl dlVar2 = dl.this;
                dlVar2.z(dlVar2.z, str, 5, 0, "");
                TTDelegateActivity.z((com.bytedance.sdk.openadsdk.core.ugeno.e.e) null);
            }
        };
    }

    private m.z g(final String str, final com.bytedance.sdk.openadsdk.core.kb.dl.z.g gVar) {
        return new m.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl.4
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                com.bytedance.sdk.openadsdk.core.kb.dl.z.g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.z();
                }
                if (dl.this.gc != null) {
                    dl.this.gc.z();
                }
                m.g = true;
                com.bytedance.sdk.openadsdk.core.i.a.g(dl.this.z, str, "pop_up_download", dl.this.z());
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                com.bytedance.sdk.openadsdk.core.i.a.g(dl.this.z, str, "pop_up_cancel", dl.this.z());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(na naVar, String str, int i, int i2, String str2) {
        JSONObject jSONObjectZ = z();
        if (6 == i) {
            try {
                jSONObjectZ.put("easy_dl_render_fail_code", i2);
                if (naVar != null) {
                    String strDl = naVar.vx().dl();
                    jSONObjectZ.put("easy_dl_render_fail_msg", str2);
                    jSONObjectZ.put("easy_dl_render_fail_dsl", a(strDl));
                }
            } catch (Exception unused) {
            }
        }
        jSONObjectZ.put("show_easy_dl_dialog_code", i);
        com.bytedance.sdk.openadsdk.core.i.a.g(this.z, str, "pop_up", jSONObjectZ);
    }

    private String a(String str) {
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        if (dlVarZ == null) {
            return null;
        }
        return dlVarZ.get(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            z zVar = this.dl;
            jSONObject.put("download_type", zVar != null ? zVar.g() : 0);
        } catch (Exception e) {
            wp.z(e);
        }
        return jSONObject;
    }
}
