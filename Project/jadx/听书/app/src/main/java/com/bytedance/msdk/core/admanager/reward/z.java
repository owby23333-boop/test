package com.bytedance.msdk.core.admanager.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.msdk.g.dl;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.l;
import com.bytedance.msdk.gz.mc;
import com.bytedance.msdk.gz.v;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.fo.g.a;
import com.bytedance.sdk.component.fo.g.gc;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private int dl;
    private com.bytedance.msdk.api.dl.z e;
    private int g;
    private com.bytedance.msdk.api.z.g i;
    private String ls;
    private g p;
    private long pf;
    private dl v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f379a = false;
    private boolean gc = false;
    private long m = -1;
    private boolean gz = false;
    private boolean fo = false;
    private boolean uy = true;
    private int kb = -1;
    private String wp = "";
    AtomicInteger z = new AtomicInteger(1);

    public interface g {
        void z(com.bytedance.msdk.api.dl.z zVar);
    }

    public z(String str) {
        com.bytedance.msdk.core.uy.g gVarZ;
        com.bytedance.msdk.core.v.dl dlVarG = com.bytedance.msdk.core.g.g();
        if (dlVarG != null && (gVarZ = dlVarG.z(str, 7, 101)) != null) {
            this.g = gVarZ.xl();
            this.dl = gVarZ.j();
        }
        if (this.g < 0) {
            this.g = 15000;
        }
    }

    public boolean z() {
        boolean z = this.dl == 1;
        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- 判断是否开启了M服务端激励验证： ".concat(String.valueOf(z)));
        return z;
    }

    public void g() {
        m.z(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.z.1
            @Override // java.lang.Runnable
            public void run() {
                z.this.gc = true;
            }
        });
    }

    public void dl() {
        m.z(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.z.2
            @Override // java.lang.Runnable
            public void run() {
                z.this.f379a = true;
            }
        });
    }

    public void z(com.bytedance.msdk.api.z.g gVar, dl dlVar) {
        this.pf = System.currentTimeMillis();
        this.i = gVar;
        this.v = dlVar;
        m();
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.admanager.reward.z$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!z.this.f379a) {
                z.this.gz = true;
                if (z.this.e != null) {
                    if (z.this.p == null || z.this.fo) {
                        return;
                    }
                    com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经有结果，直接给开发者回调");
                    z.this.fo = true;
                    z.this.p.z(z.this.e);
                    return;
                }
                if (z.this.m == -1) {
                    com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，先进来发起请求");
                    z.this.m = SystemClock.elapsedRealtime();
                    if (z.this.uy) {
                        z.this.e();
                    } else {
                        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                    }
                } else if (SystemClock.elapsedRealtime() - z.this.m > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                    com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，后进来但大于2s，发起请求");
                    if (z.this.uy) {
                        z.this.e();
                    } else {
                        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来准备请求，但是不能重试");
                    }
                }
                m.z(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.z.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!z.this.f379a) {
                            if (z.this.p == null || z.this.fo) {
                                return;
                            }
                            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，给开发者verify回调");
                            z.this.fo = true;
                            com.bytedance.msdk.api.dl.z zVar = new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.core.admanager.reward.z.3.1.1
                                @Override // com.bytedance.msdk.api.dl.z
                                public boolean z() {
                                    return false;
                                }

                                @Override // com.bytedance.msdk.api.dl.z
                                public float g() {
                                    if (z.this.i != null) {
                                        return z.this.i.gk();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.dl.z
                                public String dl() {
                                    return z.this.i != null ? z.this.i.h() : "";
                                }

                                @Override // com.bytedance.msdk.api.dl.z
                                @DungeonFlag
                                public Map<String, Object> a() {
                                    HashMap map = new HashMap();
                                    map.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                                    map.put("transId", z.this.ls);
                                    map.put(MediationConstant.KEY_REASON, 0);
                                    map.put("gromoreExtra", (z.this.i == null || z.this.i.oq() == null) ? "" : z.this.i.oq().get("gromoreExtra"));
                                    map.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(z.this.kb));
                                    map.put(MediationConstant.KEY_ERROR_MSG, z.this.wp);
                                    com.bytedance.msdk.api.dl dlVarZ = v.z(z.this.i, z.this.v, true);
                                    map.put(MediationConstant.KEY_ADN_NAME, dlVarZ != null ? dlVarZ.wp() : "");
                                    map.put(MediationConstant.KEY_ECPM, dlVarZ != null ? dlVarZ.i() : "");
                                    return map;
                                }
                            };
                            g gVar = z.this.p;
                            if (z.this.e != null) {
                                zVar = z.this.e;
                            }
                            gVar.z(zVar);
                            return;
                        }
                        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，已经destroy了, 直接return");
                    }
                }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                return;
            }
            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调进来，已经destroy, 直接return");
        }
    }

    public void a() {
        m.z(new AnonymousClass3());
    }

    public void gc() {
        m.z(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.z.4
            @Override // java.lang.Runnable
            public void run() {
                if (!z.this.f379a) {
                    if (z.this.e != null || z.this.fo) {
                        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经有响应(" + (z.this.e != null) + ")或已经给出开发者回调(" + z.this.fo + "), 直接return");
                        return;
                    }
                    if (z.this.m == -1) {
                        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，先进来发起请求");
                        z.this.m = SystemClock.elapsedRealtime();
                        if (z.this.uy) {
                            z.this.e();
                            return;
                        } else {
                            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                            return;
                        }
                    }
                    if (SystemClock.elapsedRealtime() - z.this.m > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，后进来但大于2s，发起请求");
                        if (z.this.uy) {
                            z.this.e();
                            return;
                        } else {
                            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来准备请求，但是不能重试");
                            return;
                        }
                    }
                    return;
                }
                com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- complete回调进来，已经destroy, 直接return");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void z(com.bytedance.sdk.component.fo.g gVar, boolean z, long j) {
        JSONObject jSONObject;
        if (this.f379a) {
            return;
        }
        if (gVar == null) {
            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify netResponse is null");
            z(-1, "response is null", z);
            return;
        }
        int iZ = gVar.z();
        if (mc.z(gVar)) {
            String strZ = mc.z(gVar.uy());
            if (!TextUtils.isEmpty(strZ)) {
                try {
                    this.kb = 20000;
                    z(new JSONObject(strZ), z, j);
                    return;
                } catch (Throwable th) {
                    wp.z(th);
                    this.kb = 1;
                    z(-1, th.getMessage(), z);
                    return;
                }
            }
            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data v4 is null");
            z(iZ, "data is empty", z);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(gVar.a());
            int iOptInt = jSONObject2.optInt("cypher", -1);
            String strOptString = jSONObject2.optString("message");
            this.kb = jSONObject2.optInt("code");
            this.wp = jSONObject2.optString("desc");
            int i = this.kb;
            if (i == 50001) {
                this.uy = true;
                com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: 50001，请求媒体服务端失败，需要重试");
                z(this.kb, this.wp, z);
                return;
            }
            if (i != 0 && i != 20000) {
                this.uy = false;
                com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify code: " + this.kb + ", msg: " + this.wp + "，不能再重试");
                z(this.kb, this.wp, z);
                return;
            }
            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject3 = null;
                if (iOptInt == 2) {
                    String strZ2 = mc.z(strOptString);
                    if (!TextUtils.isEmpty(strZ2)) {
                        jSONObject = new JSONObject(strZ2);
                        jSONObject3 = jSONObject;
                    }
                } else if (iOptInt == 1) {
                    String strG = com.bytedance.msdk.gz.z.g(strOptString, com.bytedance.msdk.gz.g.z());
                    if (!TextUtils.isEmpty(strG)) {
                        jSONObject = new JSONObject(strG);
                        jSONObject3 = jSONObject;
                    }
                } else if (iOptInt == 0) {
                    jSONObject3 = new JSONObject(strOptString);
                }
                z(jSONObject3, z, j);
                return;
            }
            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify cypher error or message is null");
            z(iZ, "message is null", z);
        } catch (Throwable th2) {
            z(-1, th2.getMessage(), z);
        }
    }

    @DungeonFlag
    private void z(JSONObject jSONObject, boolean z, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jSONObject != null) {
            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- data: " + jSONObject.toString());
            final boolean zOptBoolean = jSONObject.optBoolean("is_verify");
            final int iOptInt = jSONObject.optInt(MediationConstant.KEY_REASON);
            final String strOptString = jSONObject.optString(MediationConstant.REWARD_NAME);
            final int iOptInt2 = jSONObject.optInt(MediationConstant.REWARD_AMOUNT);
            this.e = new com.bytedance.msdk.api.dl.z() { // from class: com.bytedance.msdk.core.admanager.reward.z.5
                @Override // com.bytedance.msdk.api.dl.z
                public boolean z() {
                    return zOptBoolean;
                }

                @Override // com.bytedance.msdk.api.dl.z
                public float g() {
                    return iOptInt2;
                }

                @Override // com.bytedance.msdk.api.dl.z
                public String dl() {
                    return strOptString;
                }

                @Override // com.bytedance.msdk.api.dl.z
                @DungeonFlag
                public Map<String, Object> a() {
                    HashMap map = new HashMap();
                    map.put(MediationConstant.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, Boolean.TRUE);
                    map.put("transId", z.this.ls);
                    map.put(MediationConstant.KEY_REASON, Integer.valueOf(iOptInt));
                    map.put("gromoreExtra", (z.this.i == null || z.this.i.oq() == null) ? "" : z.this.i.oq().get("gromoreExtra"));
                    map.put(MediationConstant.KEY_ERROR_CODE, Integer.valueOf(z.this.kb));
                    map.put(MediationConstant.KEY_ERROR_MSG, z.this.wp);
                    com.bytedance.msdk.api.dl dlVarZ = v.z(z.this.i, z.this.v, true);
                    map.put(MediationConstant.KEY_ADN_NAME, dlVarZ != null ? dlVarZ.wp() : "");
                    map.put(MediationConstant.KEY_ECPM, dlVarZ != null ? dlVarZ.i() : "");
                    return map;
                }
            };
            if (this.gz && this.p != null && !this.fo) {
                com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- verify接口请求回来，给开发者verify回调");
                this.fo = true;
                this.p.z(this.e);
            }
            z(z, jCurrentTimeMillis);
            return;
        }
        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify data is null");
        z(-1, "data is null", z);
    }

    private void z(boolean z, long j) {
        l.z(z ? "v4Enc_reward" : "v2Enc_reward", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str, boolean z) {
        l.z(z ? "v4Enc_reward" : "v2Enc_reward", false, 0L, "code = " + i + "，msg = " + str);
    }

    private void m() {
        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- showListen回调进来，开始计时");
        m.z(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.z.6
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.m != -1 || z.this.f379a || z.this.gc) {
                    com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，已经destroy，或者skip，或者比complete/verify回调还晚，直接return");
                    return;
                }
                com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，发起请求");
                z.this.e();
                m.z(z.this.new RunnableC0071z(1), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                m.z(z.this.new RunnableC0071z(2), 6000L);
                m.z(z.this.new RunnableC0071z(3), 9000L);
            }
        }, this.g);
    }

    /* JADX INFO: renamed from: com.bytedance.msdk.core.admanager.reward.z$z, reason: collision with other inner class name */
    private class RunnableC0071z implements Runnable {
        private final int g;

        RunnableC0071z(int i) {
            this.g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (z.this.e != null || z.this.fo || !z.this.uy || z.this.f379a || z.this.gc) {
                return;
            }
            com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify 进行第" + this.g + "次重试请求");
            z.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public void e() {
        gc gcVarG = com.bytedance.msdk.a.g.z().g().g();
        gcVarG.z(com.bytedance.msdk.core.dl.a());
        final long jCurrentTimeMillis = System.currentTimeMillis();
        String strGz = com.bytedance.msdk.core.z.kb().gz();
        if (!TextUtils.isEmpty(strGz)) {
            gcVarG.g("X-Tt-Env", strGz);
            gcVarG.g("x-use-ppe", "1");
        }
        gcVarG.g("User-Agent", com.bytedance.msdk.g.g.z);
        final boolean z = !com.bytedance.msdk.core.g.g().dl();
        if (z) {
            gcVarG.g("x-pglcypher", "4");
            gcVarG.z("application/octet-stream", mc.g(z(true)));
        } else {
            gcVarG.dl(z(false));
        }
        gcVarG.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.msdk.core.admanager.reward.z.7
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, final com.bytedance.sdk.component.fo.g gVar) {
                m.z(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.z.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.z(gVar, z, jCurrentTimeMillis);
                    }
                });
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, final IOException iOException) {
                m.z(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.z.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.z.gc.dl.z("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + iOException.toString());
                        z.this.z(-2, "request error" + iOException.getMessage(), z);
                    }
                });
            }
        });
    }

    @DungeonFlag
    private String z(boolean z) {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", com.bytedance.msdk.g.g.g());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.g.g.a());
            jSONObject.put("user_agent", com.bytedance.msdk.g.g.z);
            jSONObject.put("try_value", this.z.getAndIncrement());
            jSONObject.put("network", io.gc());
            jSONObject.put("play_start_ts", this.pf);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            com.bytedance.msdk.api.z.g gVar = this.i;
            jSONObject.put("user_id", gVar != null ? gVar.lq() : "");
            if (TextUtils.isEmpty(this.ls)) {
                string = UUID.randomUUID().toString();
                this.ls = string;
            } else {
                string = this.ls;
            }
            jSONObject.put("trans_id", string);
            com.bytedance.msdk.api.z.g gVar2 = this.i;
            jSONObject.put("link_id", gVar2 != null ? gVar2.z() : "");
            com.bytedance.msdk.api.z.g gVar3 = this.i;
            jSONObject.put(MediationConstant.KEY_GM_PRIME_RIT, gVar3 != null ? gVar3.zw() : "");
            dl dlVar = this.v;
            jSONObject.put("adn_rit", dlVar != null ? dlVar.yz() : "");
            com.bytedance.msdk.api.z.g gVar4 = this.i;
            jSONObject.put(MediationConstant.REWARD_NAME, gVar4 != null ? gVar4.h() : "");
            com.bytedance.msdk.api.z.g gVar5 = this.i;
            jSONObject.put(MediationConstant.REWARD_AMOUNT, gVar5 != null ? gVar5.gk() : 0);
            com.bytedance.msdk.api.z.g gVar6 = this.i;
            jSONObject.put("media_extra", (gVar6 == null || gVar6.oq() == null) ? "" : this.i.oq().get("gromoreExtra"));
            com.bytedance.msdk.api.z.g gVar7 = this.i;
            if (gVar7 != null && gVar7.io() != null) {
                jSONObject.put("scenario_id", this.i.io());
            }
            com.bytedance.msdk.api.dl dlVarZ = v.z(this.i, this.v, true);
            jSONObject.put(MediationConstant.EXTRA_ADN_NAME, dlVarZ != null ? dlVarZ.wp() : "");
            jSONObject.put(MediationConstant.KEY_ECPM, dlVarZ != null ? dlVarZ.i() : "");
        } catch (JSONException e) {
            wp.z(e);
        }
        if (z) {
            return jSONObject.toString();
        }
        return mc.z(jSONObject).toString();
    }

    public void z(g gVar) {
        this.p = gVar;
    }
}
