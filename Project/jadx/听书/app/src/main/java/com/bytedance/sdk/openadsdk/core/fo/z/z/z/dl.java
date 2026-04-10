package com.bytedance.sdk.openadsdk.core.fo.z.z.z;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.common.C;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.ec;
import com.bytedance.sdk.openadsdk.core.iq.iq;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.ti;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.core.un.wj;
import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.uy;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1055a;
    private String dl;
    private boolean fo;
    private na g;
    private ls gc;
    private com.bytedance.sdk.openadsdk.core.video.g.g i;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl kb;
    private boolean uy;
    private String wp;
    private com.bytedance.sdk.openadsdk.core.fo.z.z.z z;
    private boolean m = false;
    private boolean e = false;
    private Function<SparseArray<Object>, Object> gz = uy.ls().oq();

    public dl(com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar, na naVar, String str, ls lsVar, Context context) {
        this.z = zVar;
        this.g = naVar;
        this.dl = str;
        this.f1055a = context;
        this.gc = lsVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.video.g.g gVar) {
        this.i = gVar;
    }

    public void z(boolean z) {
        this.m = z;
    }

    public void g(boolean z) {
        this.e = z;
    }

    public void dl(boolean z) {
        this.fo = z;
    }

    public void z(com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar) {
        this.kb = dlVar;
    }

    public void z(String str) {
        this.wp = str;
    }

    private ls z() {
        ls lsVar = this.gc;
        return lsVar == null ? new ls() : lsVar;
    }

    public Boolean z(Map<String, Object> map, String str, JSONObject jSONObject) {
        String strDl = dl(str);
        if (TextUtils.isEmpty(strDl)) {
            return null;
        }
        ls.z((String) null);
        Uri uri = Uri.parse(strDl);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (this.m) {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.g, this.dl, "lp_open_dpl", g(strDl));
        }
        boolean zG = eo.g(this.f1055a);
        try {
            jSONObject.putOpt("is_lp", Boolean.valueOf(this.m));
            jSONObject.putOpt("can_qry_pkg", Boolean.valueOf(zG));
        } catch (Exception unused) {
        }
        if (zG) {
            boolean z = eo.z(this.f1055a, intent);
            try {
                jSONObject.putOpt("installed", Boolean.valueOf(z));
            } catch (Exception unused2) {
            }
            if (z) {
                return z(map, intent, true, jSONObject);
            }
            z(map, true, (Throwable) null);
            z(1);
            return null;
        }
        try {
            jSONObject.putOpt("installed_douyin", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.live.gc.z.z(strDl)));
            String strIo = eo.io(this.g);
            if (strIo != null && strIo.length() > 0) {
                jSONObject.putOpt("installed_other", Boolean.valueOf(eo.z(strIo)));
            }
            jSONObject.putOpt("pkg", strIo);
        } catch (Throwable unused3) {
        }
        return z(map, intent, false, jSONObject);
    }

    private Boolean z(JSONObject jSONObject) {
        Boolean boolValueOf;
        try {
            jSONObject.putOpt("tag", this.wp);
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(this.wp) || !iq.z(this.g, this.wp)) {
            return null;
        }
        int iG = iq.g(this.g, this.wp);
        if (iG == 1) {
            boolValueOf = Boolean.valueOf(g());
        } else {
            boolValueOf = z(new HashMap(), iq.dl(this.g, this.wp), jSONObject);
        }
        try {
            jSONObject.putOpt("convert_type", Integer.valueOf(iG));
            jSONObject.putOpt("dpl_result", boolValueOf);
        } catch (JSONException unused2) {
        }
        return boolValueOf;
    }

    private boolean g() {
        String strDl = iq.dl(this.g, this.wp);
        na naVar = this.g;
        Context context = this.f1055a;
        String str = this.dl;
        com.bytedance.sdk.openadsdk.core.fo.z.z.g.z zVar = new com.bytedance.sdk.openadsdk.core.fo.z.z.g.z(naVar, context, str, eo.g(str));
        zVar.dl(true);
        zVar.z(strDl);
        zVar.z(this.i);
        return zVar.z((Map<String, Object>) new HashMap());
    }

    private Boolean z(final Map<String, Object> map, Intent intent, final boolean z, JSONObject jSONObject) {
        eo.g(intent);
        z(intent);
        HashMap map2 = new HashMap();
        map2.put("source", "DeepLinkConverter");
        if (this.e) {
            boolean z2 = z(this.dl, "open_fallback_url", this.g, map);
            if (!z2) {
                com.bytedance.sdk.openadsdk.core.i.a.gz(this.g, this.dl, "open_url_app", map2);
            }
            try {
                jSONObject.putOpt("intercept", Boolean.valueOf(z2));
            } catch (JSONException unused) {
            }
        } else {
            com.bytedance.sdk.openadsdk.core.i.a.gz(this.g, this.dl, "open_url_app", map2);
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        com.bytedance.sdk.component.utils.g.z(this.f1055a, intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.dl.1
            @Override // com.bytedance.sdk.component.utils.g.z
            public void z() {
                atomicBoolean.set(true);
                if (dl.this.m) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(dl.this.g, dl.this.dl, "lp_openurl", (Throwable) null);
                    com.bytedance.sdk.openadsdk.core.i.a.z(dl.this.g, dl.this.dl, "lp_deeplink_success_realtime", (Throwable) null);
                } else {
                    com.bytedance.sdk.openadsdk.core.i.a.z(dl.this.g, dl.this.dl, "deeplink_success_realtime", (Throwable) null);
                }
                com.bytedance.sdk.openadsdk.core.i.e.z().z(dl.this.g, dl.this.dl, dl.this.m);
                dl.this.z(0);
            }

            @Override // com.bytedance.sdk.component.utils.g.z
            public void z(Throwable th) {
                atomicBoolean.set(false);
                dl.this.z((Map<String, Object>) map, z, th);
                dl.this.z(3);
            }
        }, TextUtils.equals("main", UMModuleRegister.INNER));
        return Boolean.valueOf(atomicBoolean.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i) {
        na naVar = this.g;
        if (naVar == null || naVar.hu() != 1) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(this.g, this.dl, 1, 1, i, gk.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Map<String, Object> map, boolean z, Throwable th) {
        if (this.e && !z) {
            com.bytedance.sdk.openadsdk.core.i.a.dl(this.g, this.dl, "open_fallback_download");
        }
        if (this.e) {
            com.bytedance.sdk.openadsdk.core.i.a.dl(this.g, this.dl, "lp_openurl_failed");
            if (!this.uy && !z(this.dl, "open_fallback_url", this.g, map)) {
                this.uy = true;
                com.bytedance.sdk.openadsdk.core.i.a.gz(this.g, this.dl, "open_fallback_url", null);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.i.a.gz(this.g, this.dl, "open_fallback_url", null);
        }
        if (this.fo) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(this.g, this.dl, (this.e && this.m) ? "lp_deeplink_fail_realtime" : "deeplink_fail_realtime", th);
    }

    private boolean z(String str, String str2, na naVar, Map<String, Object> map) {
        if (this.gz == null) {
            return false;
        }
        Object objApply = this.gz.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(2).z(Boolean.class).z(0, new lq().z("tagIntercept", str).z("label", str2).z("hashCode", Integer.valueOf(z.dl(map))).z("meta", naVar.kv().toString())).g());
        return objApply != null && ((Boolean) objApply).booleanValue();
    }

    protected String g(String str) {
        Uri uri;
        return (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || TextUtils.isEmpty(uri.getScheme())) ? "" : uri.getScheme().toLowerCase(Locale.US);
    }

    public void z(final Intent intent) {
        final com.bytedance.sdk.openadsdk.core.un.z zVarA;
        final long jCurrentTimeMillis = System.currentTimeMillis();
        na naVar = this.g;
        if (naVar == null || intent == null || this.f1055a == null) {
            return;
        }
        ls lsVarVy = naVar.vy();
        if (lsVarVy != null && lsVarVy.dl() == 2 && !lsVarVy.z() && com.bytedance.sdk.openadsdk.core.g.z().get("dpl_reject_by_dialog", false)) {
            com.bytedance.sdk.openadsdk.core.eo.z(this.g, this.dl);
        } else if (this.g.ib() && (zVarA = uy.ls().a()) != null) {
            zVarA.z(new z.InterfaceC0206z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.dl.2
                @Override // com.bytedance.sdk.openadsdk.core.un.z.InterfaceC0206z
                public void z() {
                    if (System.currentTimeMillis() - jCurrentTimeMillis <= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                        dl.this.g(intent);
                    }
                    com.bytedance.sdk.openadsdk.core.un.z zVar = zVarA;
                    if (zVar != null) {
                        zVar.dl();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final Intent intent) {
        na naVar = this.g;
        if (naVar == null || this.f1055a == null || intent == null) {
            return;
        }
        String strDl = naVar.c() != null ? this.g.c().dl() : "";
        com.bytedance.sdk.openadsdk.core.un.m.z(this.f1055a, this.g.mj(), strDl, TextUtils.isEmpty(strDl) ? "是否立即打开应用" : "是否立即打开".concat(String.valueOf(strDl)), "立即打开", "退出", new m.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.dl.3
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                HashMap map = new HashMap();
                map.put("source", "DeepLinkConverter");
                com.bytedance.sdk.openadsdk.core.i.a.gz(dl.this.g, dl.this.dl, "open_url_app", map);
                com.bytedance.sdk.component.utils.g.z(dl.this.f1055a, intent, new g.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.z.z.dl.3.1
                    @Override // com.bytedance.sdk.component.utils.g.z
                    public void z() {
                        com.bytedance.sdk.openadsdk.core.i.e.z().z(dl.this.g, dl.this.dl, false);
                        com.bytedance.sdk.openadsdk.core.i.a.z(dl.this.g, dl.this.dl, "deeplink_success_realtime", (Throwable) null);
                    }

                    @Override // com.bytedance.sdk.component.utils.g.z
                    public void z(Throwable th) {
                        com.bytedance.sdk.openadsdk.core.i.a.z(dl.this.g, dl.this.dl, "deeplink_fail_realtime", th);
                    }
                }, TextUtils.equals("main", UMModuleRegister.INNER));
            }
        });
    }

    private String dl(String str) {
        na naVar;
        ti tiVarIa;
        if (TextUtils.isEmpty(str) || (naVar = this.g) == null || !ec.z(naVar) || (tiVarIa = this.g.ia()) == null) {
            return str;
        }
        try {
            String strDl = tiVarIa.dl();
            String strA = tiVarIa.a();
            Map<String, String> mapZ = wj.z(str);
            mapZ.put("live_short_touch_params", strDl);
            mapZ.put("extra_pangle_scheme_params", strA);
            String strZ = wj.z(str, mapZ);
            com.bytedance.sdk.openadsdk.core.g.z().put("is_reward_deep_link_to_live", true);
            return strZ;
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(Map<String, Object> map) {
        Object objValueOf;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean boolZ = z(jSONObject);
            try {
                if (boolZ == null || !boolZ.booleanValue()) {
                    ls lsVarZ = z();
                    if (lsVarZ == null) {
                        lsVarZ = this.g.vy();
                    }
                    if (lsVarZ == null || TextUtils.isEmpty(lsVarZ.g())) {
                        try {
                            jSONObject.putOpt("dpl_null", Boolean.TRUE);
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar = this.z;
                        z = zVar != null && zVar.z(map);
                        jSONObject.putOpt("uchain", Boolean.TRUE);
                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.g.wm()));
                        jSONObject.putOpt("req_id", this.g.aq());
                        objValueOf = Boolean.valueOf(this.g.z());
                    } else {
                        String strG = lsVarZ.g();
                        Boolean boolZ2 = z(map, strG, jSONObject);
                        try {
                            jSONObject.putOpt("dpl_result", boolZ2);
                            jSONObject.putOpt("url", strG);
                        } catch (Exception unused2) {
                        }
                        if (lsVarZ.gc() != 2 || this.kb == null || this.e || (boolZ2 != null && boolZ2.booleanValue())) {
                            if (boolZ2 != null && !this.e) {
                                return boolZ2.booleanValue();
                            }
                            if (!this.e || (boolZ2 != null && boolZ2.booleanValue())) {
                                try {
                                    jSONObject.putOpt("uchain", Boolean.TRUE);
                                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.g.wm()));
                                    jSONObject.putOpt("req_id", this.g.aq());
                                    jSONObject.putOpt("web_meta", Boolean.valueOf(this.g.z()));
                                } catch (Exception unused3) {
                                }
                                v.z().z("open_detail_page", "native", 0, jSONObject);
                                return false;
                            }
                            try {
                                jSONObject.putOpt("uchain", Boolean.TRUE);
                                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.g.wm()));
                                jSONObject.putOpt("req_id", this.g.aq());
                                jSONObject.putOpt("web_meta", Boolean.valueOf(this.g.z()));
                            } catch (Exception unused4) {
                            }
                            v.z().z("open_detail_page", "native", 0, jSONObject);
                            com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar2 = this.z;
                            return zVar2 != null && zVar2.z(map);
                        }
                        this.kb.a(false);
                        this.kb.z(this.g, com.bytedance.sdk.openadsdk.core.fo.z.a.z.z(map));
                        jSONObject.putOpt("uchain", Boolean.TRUE);
                        jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.g.wm()));
                        jSONObject.putOpt("req_id", this.g.aq());
                        objValueOf = Boolean.valueOf(this.g.z());
                    }
                } else {
                    try {
                        jSONObject.putOpt("dpa_sub", Boolean.TRUE);
                    } catch (Exception unused5) {
                    }
                    jSONObject.putOpt("uchain", Boolean.TRUE);
                    jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.g.wm()));
                    jSONObject.putOpt("req_id", this.g.aq());
                    objValueOf = Boolean.valueOf(this.g.z());
                }
                jSONObject.putOpt("web_meta", objValueOf);
            } catch (Exception unused6) {
            }
            v.z().z("open_detail_page", "native", 0, jSONObject);
            return z;
        } finally {
            try {
                jSONObject.putOpt("uchain", Boolean.TRUE);
                jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.g.wm()));
                jSONObject.putOpt("req_id", this.g.aq());
                jSONObject.putOpt("web_meta", Boolean.valueOf(this.g.z()));
            } catch (Exception unused7) {
            }
            v.z().z("open_detail_page", "native", 0, jSONObject);
        }
    }
}
