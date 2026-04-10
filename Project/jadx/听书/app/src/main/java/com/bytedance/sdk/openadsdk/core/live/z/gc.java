package com.bytedance.sdk.openadsdk.core.live.z;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {
    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int g(Context context, na naVar, Map<String, Object> map) {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z
    protected boolean x_() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int z(com.bytedance.sdk.openadsdk.core.live.g.g gVar, boolean z) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(com.bytedance.sdk.openadsdk.pf.a aVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(String str, boolean z) {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int z(android.content.Context r10, com.bytedance.sdk.openadsdk.core.iq.na r11, java.util.Map<java.lang.String, java.lang.Object> r12) {
        /*
            r9 = this;
            r0 = -1
            if (r10 == 0) goto Laf
            if (r11 != 0) goto L7
            goto Laf
        L7:
            boolean r1 = r9.a_(r11)
            java.lang.String r2 = "TTLiveSDkBridge"
            if (r1 != 0) goto L15
            java.lang.String r10 = "mata has not le property"
            com.bytedance.sdk.component.utils.wp.z(r2, r10)
            return r0
        L15:
            if (r12 == 0) goto L20
            java.lang.String r0 = "event_tag"
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            goto L22
        L20:
            java.lang.String r0 = ""
        L22:
            r5 = r0
            int r7 = r11.wm()
            boolean r0 = r9.m()
            r1 = 1
            if (r0 != 0) goto L3e
            r10 = 1
            r12 = 7
            if (r7 != r12) goto L34
            r8 = r1
            goto L36
        L34:
            r12 = 2
            r8 = r12
        L36:
            r3 = r9
            r4 = r11
            r6 = r7
            r7 = r10
            r3.z(r4, r5, r6, r7, r8)
            return r1
        L3e:
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r0 = r9.z
            if (r0 == 0) goto La7
            java.util.function.Function<android.util.SparseArray<java.lang.Object>, java.lang.Object> r0 = r9.z
            com.bytedance.sdk.openadsdk.ls.a r1 = com.bytedance.sdk.openadsdk.ls.a.z()
            r3 = 0
            com.bytedance.sdk.openadsdk.ls.a r1 = r1.z(r3)
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            com.bytedance.sdk.openadsdk.ls.a r1 = r1.z(r4)
            java.lang.String r12 = r9.g(r11, r12)
            com.bytedance.sdk.openadsdk.ls.a r12 = r1.z(r3, r12)
            android.util.SparseArray r12 = r12.g()
            java.lang.Object r12 = r0.apply(r12)
            if (r12 == 0) goto L6d
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r1 = r12
            goto L6e
        L6d:
            r1 = r3
        L6e:
            if (r1 != 0) goto L8d
            boolean r12 = r9.z(r11, r3)
            if (r12 == 0) goto L8e
            int r3 = r9.dl(r11)
            if (r3 != 0) goto L8e
            com.bytedance.sdk.openadsdk.core.live.dl.z r12 = new com.bytedance.sdk.openadsdk.core.live.dl.z     // Catch: java.lang.Exception -> L89
            r12.<init>()     // Catch: java.lang.Exception -> L89
            com.bytedance.sdk.openadsdk.core.live.dl.z r12 = r12.z(r5)     // Catch: java.lang.Exception -> L89
            r12.z(r10, r11)     // Catch: java.lang.Exception -> L89
            goto L8e
        L89:
            r10 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r10)
        L8d:
            r3 = 3
        L8e:
            if (r1 != 0) goto L93
            java.lang.String r10 = "le openliv succ"
            goto La2
        L93:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "callR: "
            r10.<init>(r12)
            java.lang.StringBuilder r10 = r10.append(r1)
            java.lang.String r10 = r10.toString()
        La2:
            com.bytedance.sdk.component.utils.wp.z(r2, r10)
            r8 = r3
            goto La8
        La7:
            r8 = r1
        La8:
            r3 = r9
            r4 = r11
            r6 = r7
            r3.z(r4, r5, r6, r7, r8)
            return r1
        Laf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.live.z.gc.z(android.content.Context, com.bytedance.sdk.openadsdk.core.iq.na, java.util.Map):int");
    }

    private String g(na naVar, Map<String, Object> map) {
        if (naVar == null) {
            return "";
        }
        try {
            Uri uriZ = com.bytedance.sdk.openadsdk.core.live.dl.z(Uri.parse("sslocal://webcast_room"), z(naVar, map));
            wp.z("TTLiveSDkBridge", "link: " + uriZ.toString());
            return uriZ.toString();
        } catch (Throwable th) {
            wp.z(th);
            wp.a("TTLiveSDkBridge", "link: null");
            return "";
        }
    }

    public Map<String, String> z(na naVar, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (naVar == null) {
            return map2;
        }
        map2.put("room_id", naVar.nz());
        if (this.z != null) {
            int iGz = eo.gz(naVar);
            String str = (String) this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(1).z(String.class).z(0, Integer.valueOf(iGz)).g());
            String str2 = (String) this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(2).z(String.class).z(0, Integer.valueOf(iGz)).z(1, Boolean.valueOf(com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar))).g());
            map2.put("enter_from_merge", str);
            map2.put("enter_method", str2);
        }
        map2.put("host", "aweme");
        map2.put("is_other_channel", "union_ad");
        String strZ = z(naVar, naVar.qi(), map);
        if (!TextUtils.isEmpty(strZ)) {
            map2.put("ecom_live_params", strZ);
        }
        ls lsVarVy = naVar.vy();
        if (lsVarVy != null && !TextUtils.isEmpty(lsVarVy.g())) {
            try {
                Uri uri = Uri.parse(lsVarVy.g());
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                String strOptString = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    jSONObject3.put("ad_event_aid", jSONObject.optString("aid"));
                    jSONObject3.put("ad_event_source", com.bytedance.sdk.openadsdk.core.live.dl.z(uri, "source"));
                    jSONObject3.put("ad_event_gd_label", com.bytedance.sdk.openadsdk.core.live.dl.z(uri, "gd_label"));
                    jSONObject3.put("ad_event_union_user_id", com.bytedance.sdk.openadsdk.core.live.dl.z(uri, "union_user_id"));
                    jSONObject3.put("ad_event_app_siteid", uy.ls().q());
                    jSONObject3.put("ad_event_live_type", "1");
                    map2.put(MediationConstant.EXTRA_LOG_EXTRA, jSONObject3.toString());
                    jSONObject2.put(MediationConstant.EXTRA_LOG_EXTRA, jSONObject3.toString());
                }
                String strOptString2 = jSONObject.optString(CmcdConfiguration.KEY_CONTENT_ID);
                jSONObject2.put("creativeID", strOptString2);
                map2.put("creative_id", strOptString2);
                map2.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                String strZ2 = com.bytedance.sdk.openadsdk.core.live.dl.z(uri, "owner_open_id");
                if (TextUtils.isEmpty(strZ2)) {
                    strZ2 = com.bytedance.sdk.openadsdk.core.live.dl.z(uri, "user_id");
                }
                map2.put("owner_open_id", strZ2);
                String strZ3 = com.bytedance.sdk.openadsdk.core.live.dl.z(uri, "pangle_live_room_data");
                if (!TextUtils.isEmpty(strZ3)) {
                    map2.put("pangle_live_room_data", strZ3);
                }
                map2.put("request_id", com.bytedance.sdk.openadsdk.core.live.dl.z(uri, "request_id"));
            } catch (Exception e) {
                wp.z(e);
            }
        }
        return map2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public boolean z(na naVar) {
        return a_(naVar) && this.z != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.z, com.bytedance.sdk.openadsdk.core.live.z.a
    public void z(final String str, final na naVar, final long j) {
        com.bytedance.sdk.openadsdk.hh.e.g(new fo("csj_live_log_event_v2") { // from class: com.bytedance.sdk.openadsdk.core.live.z.gc.1
            @Override // java.lang.Runnable
            public void run() {
                gc.this.g(str, naVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, na naVar, long j) {
        try {
            if (this.z == null) {
                return;
            }
            Map<String, String> mapZ = z(naVar, (Map<String, Object>) null);
            Map<String, String> mapZ2 = com.bytedance.sdk.openadsdk.core.video.dl.z.z(zw.getContext());
            mapZ2.put("room_id", mapZ.get("room_id"));
            mapZ2.put("anchor_id", mapZ.get("owner_open_id"));
            mapZ2.put("enter_from_merge", mapZ.get("enter_from_merge"));
            mapZ2.put("enter_method", mapZ.get("enter_method"));
            mapZ2.put("action_type", "click");
            mapZ2.put("request_id", mapZ.get("request_id"));
            mapZ2.put("duration", new StringBuilder().append(j).toString());
            mapZ2.put("is_other_channel", "union_ad");
            mapZ2.put("IESLiveEffectAdTrackExtraServiceKey", mapZ.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : mapZ2.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(4).z(Void.class).z(0, str).z(1, jSONObject).g());
        } catch (Throwable th) {
            if (wp.dl()) {
                wp.dl("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int g() {
        if (this.z != null) {
            try {
                Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(3).z(Object.class).z(0, 1).g());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable th) {
                wp.g("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int b_(na naVar) {
        if (this.z != null) {
            long jG = g(naVar);
            if (jG == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", jG);
                Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(3).z(Object.class).z(0, 2).z(1, bundle).g());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable th) {
                wp.g("TTLiveSDkBridge", th);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int gc() {
        boolean zBooleanValue = false;
        if (this.z != null) {
            try {
                Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(3).z(Object.class).z(0, 3).g());
                if (objApply instanceof Boolean) {
                    zBooleanValue = ((Boolean) objApply).booleanValue();
                }
            } catch (Throwable th) {
                wp.g("TTLiveSDkBridge", th);
            }
        }
        return zBooleanValue ? 2 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public boolean m() {
        return g() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public String e() {
        if (this.z == null) {
            return null;
        }
        try {
            Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(3).z(Object.class).z(0, 4).g());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        } catch (Throwable th) {
            wp.g("TTLiveSDkBridge", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int z(na naVar, dl dlVar, String str) {
        if (naVar == null || TextUtils.isEmpty(naVar.bv()) || this.z == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", naVar.bv());
            Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(3).z(Object.class).z(0, 5).z(1, bundle).g());
            if (objApply == null) {
                return 4;
            }
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public JSONObject gz() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.z.a
    public int z(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", str);
            Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(3).z(Object.class).z(0, 6).z(1, bundle).g());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
