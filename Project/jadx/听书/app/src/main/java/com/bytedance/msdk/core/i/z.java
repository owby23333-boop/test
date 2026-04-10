package com.bytedance.msdk.core.i;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.msdk.api.z.g;
import com.bytedance.msdk.core.uy.e;
import com.bytedance.msdk.core.uy.gz;
import com.bytedance.msdk.core.uy.m;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gz.i;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.gz.mc;
import com.bytedance.msdk.gz.zw;
import com.bytedance.msdk.z.gc.dl;
import com.bytedance.sdk.component.fo.g.a;
import com.bytedance.sdk.component.fo.g.gc;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.pi.ACTD;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;

    /* JADX INFO: renamed from: com.bytedance.msdk.core.i.z$z, reason: collision with other inner class name */
    public interface InterfaceC0074z {
        void z(com.bytedance.msdk.api.z zVar);

        void z(e eVar);
    }

    public static int z(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    private String z(Map<String, com.bytedance.msdk.dl.z.z> map, Context context, g gVar, uy uyVar, Map<String, Object> map2) {
        if (gVar == null || uyVar == null) {
            dl.g("serverBiddingRequest", "adSlot is null or waterFallConfig is null can not get server bidding token");
            return "";
        }
        if (TextUtils.equals("baidu", uyVar.pf())) {
            com.bytedance.msdk.dl.m.g.g gVarZ = com.bytedance.msdk.dl.m.g.g.z(uyVar, (com.bytedance.msdk.dl.g.g.z) null);
            com.bytedance.msdk.dl.z.z zVarZ = com.bytedance.msdk.dl.gz.dl.z(gVarZ, gVar, (com.bytedance.msdk.dl.z.g) null);
            if (zVarZ == null) {
                return "";
            }
            try {
                map.put(String.format("%1$s_%2$s_%3$s", gVar.z(), gVar.zw(), uyVar.fv()), zVarZ);
                return zVarZ.z(context, gVarZ, gVar);
            } catch (Throwable unused) {
                return "";
            }
        }
        return com.bytedance.msdk.m.g.z.z(map2, uyVar.pf());
    }

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public void z(Map<String, com.bytedance.msdk.dl.z.z> map, Context context, g gVar, List<uy> list, List<com.bytedance.msdk.g.dl> list2, com.bytedance.msdk.core.uy.g gVar2, int i, boolean z2, final InterfaceC0074z interfaceC0074z) {
        final JSONObject jSONObject = new JSONObject();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        gc gcVarG = com.bytedance.msdk.a.g.z().g().g();
        gcVarG.z(com.bytedance.msdk.core.dl.dl());
        String strGz = com.bytedance.msdk.core.z.kb().gz();
        if (!TextUtils.isEmpty(strGz)) {
            gcVarG.g("X-Tt-Env", strGz);
            gcVarG.g("x-use-ppe", "1");
        }
        gcVarG.g("User-Agent", com.bytedance.msdk.g.g.z);
        final boolean z3 = !com.bytedance.msdk.core.g.g().gc();
        if (z3) {
            gcVarG.g("x-pglcypher", "4");
            gcVarG.z("application/octet-stream", mc.g(z(map, context, gVar, list, list2, gVar2, i, z2, jSONObject, true)));
        } else {
            gcVarG.dl(z(map, context, gVar, list, list2, gVar2, i, z2, jSONObject, false));
        }
        gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.msdk.core.i.z.1
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, com.bytedance.sdk.component.fo.g gVar3) {
                JSONObject jSONObject2;
                JSONObject jSONObject3;
                if (gVar3 != null) {
                    int iZ = gVar3.z();
                    if (mc.z(gVar3)) {
                        String strZ = mc.z(gVar3.uy());
                        if (!TextUtils.isEmpty(strZ)) {
                            try {
                                z.this.z(new JSONObject(strZ), jSONObject, interfaceC0074z, z3, jCurrentTimeMillis);
                                return;
                            } catch (Throwable th) {
                                z.this.z(81014, th.getMessage(), interfaceC0074z, z3);
                                return;
                            }
                        }
                        dl.a("ServerBiddingHelper", "Server Bidding Request onResponse...response v4 is empty");
                        z.this.z(iZ, "response is empty", interfaceC0074z, z3);
                        return;
                    }
                    if (!TextUtils.isEmpty(gVar3.a())) {
                        try {
                            JSONObject jSONObject4 = new JSONObject(gVar3.a());
                            int iOptInt = jSONObject4.optInt("cypher", -1);
                            String strOptString = jSONObject4.optString("message");
                            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                                if (iOptInt == 2) {
                                    String strZ2 = mc.z(strOptString);
                                    if (TextUtils.isEmpty(strZ2)) {
                                        jSONObject3 = null;
                                        jSONObject2 = jSONObject3;
                                    } else {
                                        try {
                                            jSONObject3 = new JSONObject(strZ2);
                                        } catch (Throwable th2) {
                                            dl.z("ServerBiddingHelper", ">>>>> server bidding data error: " + th2.toString());
                                            jSONObject3 = null;
                                        }
                                        jSONObject2 = jSONObject3;
                                    }
                                } else {
                                    if (iOptInt == 1) {
                                        String strG = com.bytedance.msdk.gz.z.g(strOptString, com.bytedance.msdk.gz.g.z());
                                        if (!TextUtils.isEmpty(strG)) {
                                            try {
                                                jSONObject3 = new JSONObject(strG);
                                            } catch (Throwable th3) {
                                                dl.z("ServerBiddingHelper", "server bidding data error: ", th3);
                                                jSONObject3 = null;
                                            }
                                            jSONObject2 = jSONObject3;
                                        }
                                    } else if (iOptInt == 0) {
                                        jSONObject2 = new JSONObject(strOptString);
                                    }
                                    jSONObject3 = null;
                                    jSONObject2 = jSONObject3;
                                }
                                z.this.z(jSONObject2, jSONObject, interfaceC0074z, z3, jCurrentTimeMillis);
                                return;
                            }
                            int iOptInt2 = jSONObject4.optInt("status_code", -2);
                            int iOptInt3 = jSONObject4.optInt(MediationConstant.KEY_REASON, -2);
                            String strOptString2 = jSONObject4.optString("desc");
                            dl.a("ServerBiddingHelper", "Server Bidding onResponse error ");
                            z.this.z(iOptInt2, "reason is " + iOptInt3 + "，desc is " + strOptString2, interfaceC0074z, z3);
                            return;
                        } catch (Throwable th4) {
                            z.this.z(81006, th4.getMessage(), interfaceC0074z, z3);
                            return;
                        }
                    }
                    dl.a("ServerBiddingHelper", "Server Bidding Request onResponse...response is empty");
                    z.this.z(iZ, "response is empty", interfaceC0074z, z3);
                    return;
                }
                dl.a("ServerBiddingHelper", "Server Bidding Request onResponse...response is null");
                z.this.z(-1, "response is null", interfaceC0074z, z3);
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, IOException iOException) {
                int i2 = iOException instanceof SocketTimeoutException ? 44405 : 44404;
                dl.a("ServerBiddingHelper", "Server Bidding Request onError...errorCode=".concat(String.valueOf(i2)));
                z.this.z(i2, "request fail " + iOException.getMessage(), interfaceC0074z, z3);
            }
        });
    }

    private void z(boolean z2, long j) {
        l.z(z2 ? "v4Enc_exchange" : "v2Enc_exchange", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str, InterfaceC0074z interfaceC0074z, boolean z2) {
        l.z(z2 ? "v4Enc_exchange" : "v2Enc_exchange", false, 0L, "code = " + i + "，msg = " + str);
        z(interfaceC0074z, new com.bytedance.msdk.api.z(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(JSONObject jSONObject, JSONObject jSONObject2, InterfaceC0074z interfaceC0074z, boolean z2, long j) {
        String str;
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        gz gzVar;
        JSONObject jSONObjectOptJSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jSONObject != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                e eVar = new e();
                eVar.z(jSONObject2);
                eVar.dl(jSONObject.optString("request_id"));
                eVar.gc(jSONObject.optString("server_bidding_extra"));
                eVar.a(jSONObject.optString("server_request_id"));
                gz gzVar2 = new gz();
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("winner");
                String str5 = "price";
                if (jSONObjectOptJSONObject2 != null) {
                    gzVar2.g(jSONObjectOptJSONObject2.optInt("req_bidding_type"));
                    gzVar2.dl(jSONObjectOptJSONObject2.optString("price"));
                    gzVar2.a(jSONObjectOptJSONObject2.optString("load_price"));
                    gzVar2.uy(jSONObjectOptJSONObject2.optString("adm"));
                    gzVar2.gc(jSONObjectOptJSONObject2.optString("name"));
                    gzVar2.e(jSONObjectOptJSONObject2.optString(PluginConstants.KEY_APP_ID));
                    gzVar2.m(jSONObjectOptJSONObject2.optString("slot_id"));
                    str = "ServerBiddingHelper";
                    gzVar2.gz(jSONObjectOptJSONObject2.optString("win_callback", null));
                    gzVar2.fo(jSONObjectOptJSONObject2.optString("fail_callback", null));
                    gzVar2.z(jSONObjectOptJSONObject2.optInt("pricing_type", 1));
                    eVar.z(gzVar2);
                } else {
                    str = "ServerBiddingHelper";
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("winners");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    str2 = str;
                } else {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < jSONArrayOptJSONArray.length()) {
                        try {
                            gzVar = new gz();
                            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                            jSONArray = jSONArrayOptJSONArray;
                        } catch (Throwable th) {
                            th = th;
                            jSONArray = jSONArrayOptJSONArray;
                        }
                        try {
                            gzVar.g(jSONObjectOptJSONObject.optInt("req_bidding_type"));
                            gzVar.dl(jSONObjectOptJSONObject.optString(str5));
                            gzVar.a(jSONObjectOptJSONObject.optString("load_price"));
                            gzVar.uy(jSONObjectOptJSONObject.optString("adm"));
                            gzVar.gc(jSONObjectOptJSONObject.optString("name"));
                            gzVar.e(jSONObjectOptJSONObject.optString(PluginConstants.KEY_APP_ID));
                            gzVar.m(jSONObjectOptJSONObject.optString("slot_id"));
                            str3 = str5;
                            try {
                                gzVar.gz(jSONObjectOptJSONObject.optString("win_callback", null));
                                gzVar.fo(jSONObjectOptJSONObject.optString("fail_callback", null));
                                gzVar.z(jSONObjectOptJSONObject.optString("m_aid", null));
                                gzVar.g(jSONObjectOptJSONObject.optString("ad_extra", null));
                            } catch (Throwable th2) {
                                th = th2;
                                str4 = str;
                                dl.z(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                                i++;
                                str = str4;
                                str5 = str3;
                                jSONArrayOptJSONArray = jSONArray;
                            }
                            try {
                                gzVar.z(jSONObjectOptJSONObject.optInt("pricing_type", 1));
                                arrayList.add(gzVar);
                                str4 = str;
                            } catch (Throwable th3) {
                                th = th3;
                                str4 = str;
                                dl.z(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            str3 = str5;
                            str4 = str;
                            dl.z(str4, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                            i++;
                            str = str4;
                            str5 = str3;
                            jSONArrayOptJSONArray = jSONArray;
                        }
                        i++;
                        str = str4;
                        str5 = str3;
                        jSONArrayOptJSONArray = jSONArray;
                    }
                    str2 = str;
                    eVar.z(arrayList);
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("auto_detail");
                if (jSONObjectOptJSONObject3 != null) {
                    eVar.z(jSONObjectOptJSONObject3.optString("est_price"));
                    eVar.z(jSONObjectOptJSONObject3.optInt("est_price_source"));
                    eVar.g(jSONObjectOptJSONObject3.optString("bidding_ecpm"));
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("waterfall");
                if (jSONObjectOptJSONObject4 != null) {
                    e.z zVar = new e.z();
                    zVar.z(jSONObjectOptJSONObject4.optString("version"));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("adn_rit_conf");
                    ArrayList arrayList2 = new ArrayList();
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            try {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                uy uyVar = new uy();
                                uyVar.dl(jSONObjectOptJSONObject5.optString(MediationConstant.EXTRA_ADN_NAME));
                                uyVar.gc(jSONObjectOptJSONObject5.optString("adn_slot_id"));
                                arrayList2.add(uyVar);
                            } catch (Throwable th5) {
                                dl.z(str2, "new waterfallListJson parse error: " + th5.toString());
                            }
                        }
                    }
                    zVar.z(arrayList2);
                    eVar.z(zVar);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("invalid_non_server_bidding_results");
                ArrayList arrayList3 = new ArrayList();
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        try {
                            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
                            m mVar = new m();
                            mVar.z(jSONObjectOptJSONObject6.optString("name"));
                            mVar.g(jSONObjectOptJSONObject6.optString("slot_id"));
                            mVar.z(jSONObjectOptJSONObject6.optInt("req_bidding_type"));
                            mVar.g(jSONObjectOptJSONObject6.optInt("error_code"));
                            mVar.dl(jSONObjectOptJSONObject6.optString("error_msg"));
                            mVar.a(jSONObjectOptJSONObject6.optString("level_tag"));
                            arrayList3.add(mVar);
                        } catch (Throwable th6) {
                            dl.z(str2, "new invalid_non_server_bidding_results parse error: " + th6.toString());
                        }
                    }
                    eVar.g(arrayList3);
                }
                z(interfaceC0074z, eVar);
                z(z2, jCurrentTimeMillis);
                return;
            }
            dl.a("ServerBiddingHelper", "Server Bidding Request onResponse..data.string is null ");
            z(-1, "data.string is null", interfaceC0074z, z2);
            return;
        }
        dl.a("ServerBiddingHelper", "Server Bidding Request onResponse...data is null");
        z(-1, "data is null", interfaceC0074z, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(com.bytedance.msdk.core.uy.e r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "ServerBiddingHelper"
            if (r4 != 0) goto L5
            return
        L5:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto Lc
            return
        Lc:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lb3
            r1.<init>(r5)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = "cypher"
            r2 = -1
            int r5 = r1.optInt(r5, r2)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = "message"
            java.lang.String r1 = r1.optString(r2)     // Catch: java.lang.Throwable -> Lb3
            if (r5 < 0) goto Lad
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lb3
            if (r2 != 0) goto Lad
            r2 = 2
            if (r5 != r2) goto L51
            java.lang.String r5 = com.bytedance.msdk.gz.mc.z(r1)     // Catch: java.lang.Throwable -> Lb3
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lb3
            if (r1 != 0) goto L78
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L39
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L39
            goto L79
        L39:
            r5 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = ">>>>> m_meta data error: "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb3
            java.lang.StringBuilder r5 = r1.append(r5)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb3
            com.bytedance.msdk.z.gc.dl.z(r0, r5)     // Catch: java.lang.Throwable -> Lb3
            goto L78
        L51:
            r2 = 1
            if (r5 != r2) goto L6f
            java.lang.String r5 = com.bytedance.msdk.gz.g.z()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = com.bytedance.msdk.gz.z.g(r1, r5)     // Catch: java.lang.Throwable -> Lb3
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lb3
            if (r1 != 0) goto L78
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L68
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L68
            goto L79
        L68:
            r5 = move-exception
            java.lang.String r1 = "m_meta data error: "
            com.bytedance.msdk.z.gc.dl.z(r0, r1, r5)     // Catch: java.lang.Throwable -> Lb3
            goto L78
        L6f:
            if (r5 != 0) goto L78
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lb3
            r5.<init>(r1)     // Catch: java.lang.Throwable -> Lb3
            r1 = r5
            goto L79
        L78:
            r1 = 0
        L79:
            if (r1 == 0) goto La7
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> Lb3
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lb3
            if (r5 != 0) goto La1
            java.lang.String r5 = "request_id"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> Lb3
            r4.dl(r5)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = "server_bidding_extra"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> Lb3
            r4.gc(r5)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = "server_request_id"
            java.lang.String r5 = r1.optString(r5)     // Catch: java.lang.Throwable -> Lb3
            r4.a(r5)     // Catch: java.lang.Throwable -> Lb3
            return
        La1:
            java.lang.String r4 = "m_meta..data.string is null "
            com.bytedance.msdk.z.gc.dl.a(r0, r4)     // Catch: java.lang.Throwable -> Lb3
            return
        La7:
            java.lang.String r4 = "m_meta...data is null"
            com.bytedance.msdk.z.gc.dl.a(r0, r4)     // Catch: java.lang.Throwable -> Lb3
            return
        Lad:
            java.lang.String r4 = "m_meta onResponse error "
            com.bytedance.msdk.z.gc.dl.a(r0, r4)     // Catch: java.lang.Throwable -> Lb3
            return
        Lb3:
            r4 = move-exception
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "m_meta onResponse throwable ："
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r5.concat(r4)
            com.bytedance.msdk.z.gc.dl.a(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.i.z.z(com.bytedance.msdk.core.uy.e, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.bytedance.msdk.core.uy.gz z(org.json.JSONObject r7) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.i.z.z(org.json.JSONObject):com.bytedance.msdk.core.uy.gz");
    }

    public void z(String str, InterfaceC0074z interfaceC0074z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                e eVar = new e();
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
                String strOptString = jSONObject.optString("m_meta");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            gz gzVarZ = z(jSONArrayOptJSONArray.optJSONObject(i));
                            if (gzVarZ != null) {
                                arrayList.add(gzVarZ);
                            }
                        } catch (Throwable th) {
                            dl.z("ServerBiddingHelper", "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        }
                    }
                    eVar.z(arrayList);
                }
                z(eVar, strOptString);
                z(interfaceC0074z, eVar);
                return;
            } catch (Throwable th2) {
                String string = th2.toString();
                dl.a("ServerBiddingHelper", "Server Bidding onResponse throwable ：".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    string = com.bytedance.msdk.api.z.z(-1);
                }
                z(interfaceC0074z, new com.bytedance.msdk.api.z(-1, string));
                return;
            }
        }
        dl.a("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
        z(interfaceC0074z, new com.bytedance.msdk.api.z(-1, "response is invalid"));
    }

    private void z(final InterfaceC0074z interfaceC0074z, final com.bytedance.msdk.api.z zVar) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.i.z.2
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0074z interfaceC0074z2 = interfaceC0074z;
                if (interfaceC0074z2 != null) {
                    interfaceC0074z2.z(zVar);
                }
            }
        });
    }

    private void z(final InterfaceC0074z interfaceC0074z, final e eVar) {
        com.bytedance.msdk.z.gc.m.z(new Runnable() { // from class: com.bytedance.msdk.core.i.z.3
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0074z interfaceC0074z2 = interfaceC0074z;
                if (interfaceC0074z2 != null) {
                    interfaceC0074z2.z(eVar);
                }
            }
        });
    }

    private JSONObject g() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.g.g().i())) {
            return null;
        }
        try {
            return new JSONObject(com.bytedance.msdk.core.g.g().i());
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }

    private JSONObject z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            wp.z(e);
            return null;
        }
    }

    public String z(Map<String, com.bytedance.msdk.dl.z.z> map, Context context, g gVar, List<uy> list, com.bytedance.msdk.core.uy.g gVar2, int i, boolean z2, JSONObject jSONObject) {
        return context == null ? "" : z(map, context, gVar, list, null, gVar2, i, z2, jSONObject, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0561 A[Catch: Exception -> 0x0623, TryCatch #16 {Exception -> 0x0623, blocks: (B:135:0x04b1, B:137:0x04bd, B:141:0x04f8, B:143:0x04fe, B:145:0x0519, B:164:0x0561, B:166:0x0564, B:168:0x056e, B:169:0x0573, B:171:0x0583, B:172:0x0587, B:174:0x058d, B:176:0x0595, B:178:0x05a7, B:181:0x05ba, B:182:0x05c1, B:184:0x05f9, B:185:0x0602, B:179:0x05b0, B:188:0x0619, B:161:0x055a), top: B:235:0x04b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x056e A[Catch: Exception -> 0x0623, TryCatch #16 {Exception -> 0x0623, blocks: (B:135:0x04b1, B:137:0x04bd, B:141:0x04f8, B:143:0x04fe, B:145:0x0519, B:164:0x0561, B:166:0x0564, B:168:0x056e, B:169:0x0573, B:171:0x0583, B:172:0x0587, B:174:0x058d, B:176:0x0595, B:178:0x05a7, B:181:0x05ba, B:182:0x05c1, B:184:0x05f9, B:185:0x0602, B:179:0x05b0, B:188:0x0619, B:161:0x055a), top: B:235:0x04b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0583 A[Catch: Exception -> 0x0623, TryCatch #16 {Exception -> 0x0623, blocks: (B:135:0x04b1, B:137:0x04bd, B:141:0x04f8, B:143:0x04fe, B:145:0x0519, B:164:0x0561, B:166:0x0564, B:168:0x056e, B:169:0x0573, B:171:0x0583, B:172:0x0587, B:174:0x058d, B:176:0x0595, B:178:0x05a7, B:181:0x05ba, B:182:0x05c1, B:184:0x05f9, B:185:0x0602, B:179:0x05b0, B:188:0x0619, B:161:0x055a), top: B:235:0x04b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x047e A[SYNTHETIC] */
    /* JADX WARN: Type update failed for variable: r36v0 'this'  ??, new type: com.bytedance.msdk.core.i.z
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16251. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:37)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:224)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:480)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:197)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:473)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:241)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:225)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:202)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:119)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:86)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:72)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String z(java.util.Map<java.lang.String, com.bytedance.msdk.dl.z.z> r37, android.content.Context r38, com.bytedance.msdk.api.z.g r39, java.util.List<com.bytedance.msdk.core.uy.uy> r40, java.util.List<com.bytedance.msdk.g.dl> r41, com.bytedance.msdk.core.uy.g r42, int r43, boolean r44, org.json.JSONObject r45, boolean r46) {
        /*
            Method dump skipped, instruction units count: 1625
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.i.z.z(java.util.Map, android.content.Context, com.bytedance.msdk.api.z.g, java.util.List, java.util.List, com.bytedance.msdk.core.uy.g, int, boolean, org.json.JSONObject, boolean):java.lang.String");
    }

    private String z(g gVar, uy uyVar) {
        String strZ = gVar != null ? gVar.z() : null;
        if (uyVar != null) {
            return (strZ + "_") + uyVar.fv();
        }
        return strZ;
    }

    private String z(JSONObject jSONObject, boolean z2, boolean z3) {
        if (z3) {
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.putOpt("token_type", Integer.valueOf(z2 ? 1 : 0));
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        JSONObject jSONObjectZ = mc.z(jSONObject);
        if (jSONObjectZ == null) {
            return null;
        }
        try {
            jSONObjectZ.putOpt("token_type", Integer.valueOf(z2 ? 1 : 0));
        } catch (Exception unused2) {
        }
        return jSONObjectZ.toString();
    }

    private JSONObject z(g gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", gVar.z());
            jSONObject.put("ad_sdk_version", com.bytedance.msdk.g.g.g());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.g.g.a());
            jSONObject.put("source_type", "app");
            jSONObject.put("app", dl());
            JSONObject jSONObjectZ = zw.z(com.bytedance.msdk.core.g.getContext());
            if (jSONObjectZ != null && gVar.mc() > 0) {
                jSONObjectZ.put("orientation", gVar.mc());
            }
            jSONObject.put("device", jSONObjectZ);
            jSONObject.put(com.umeng.analytics.pro.z.d, com.bytedance.msdk.g.g.z);
            jSONObject.put("ip", io.iq());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(g(gVar));
            jSONObject.put("adslots", jSONArray);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (gVar.zw() != null && gVar.z() != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(gVar.zw()).concat(gVar.z());
            }
            jSONObject.put("req_sign", i.z(strConcat));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject g(g gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int iIq = gVar.iq();
            jSONObject.put("id", gVar.zw());
            jSONObject.put("adtype", iIq);
            jSONObject.put("pos", z(iIq));
            z(jSONObject, "accepted_size", gVar.uf(), gVar.sy());
            jSONObject.put("is_support_dpl", gVar.l());
            int iHh = gVar.hh();
            int i = 1;
            if (iHh <= 0) {
                iHh = 1;
            }
            if (iHh > 3) {
                iHh = 3;
            }
            if (iIq != 7 && iIq != 8) {
                i = iHh;
            }
            jSONObject.put("ad_count", i);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void z(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put(MediaFormat.KEY_WIDTH, i);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        try {
            jSONObject.put(an.o, mc.z());
            jSONObject.put("version_code", mc.g());
            jSONObject.put("version", mc.dl());
        } catch (Exception unused) {
        }
    }

    private void dl(JSONObject jSONObject) {
        if (com.bytedance.msdk.gz.m.z(com.bytedance.msdk.core.g.getContext()) != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", r0.z);
                jSONObject2.put("longitude", r0.g);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.bytedance.msdk.api.a.z.g.m.z zVarZ = com.bytedance.msdk.m.g.z.z(str);
            if (zVarZ != null) {
                return zVarZ.dl();
            }
            com.bytedance.msdk.z.z.a aVarZ = com.bytedance.msdk.m.g.g.z().z(str);
            if (aVarZ == null) {
                return null;
            }
            return aVarZ.g();
        } catch (Throwable th) {
            wp.z(th);
            dl.a("TTMediationSDK_SDK_Init", "GDT SDK 初始化失败。。 e=" + th.toString());
            return null;
        }
    }

    private JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ACTD.APPID_KEY, com.bytedance.msdk.core.z.kb().wp());
            jSONObject.put("name", com.bytedance.msdk.core.z.kb().fv());
            g(jSONObject);
            dl(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
