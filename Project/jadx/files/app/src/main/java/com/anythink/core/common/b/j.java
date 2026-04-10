package com.anythink.core.common.b;

import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.c.d;
import com.anythink.core.common.b.g;
import com.anythink.core.common.c.k;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends ATAdInfo {
    private Map<String, Object> C;
    private ATBaseAdAdapter a;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Map<String, Object> f6957x;
    private int b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6936c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6937d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f6938e = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6939f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f6940g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Double f6941h = Double.valueOf(PangleAdapterUtils.CPM_DEFLAUT_VALUE);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6942i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f6943j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f6944k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f6945l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f6946m = "unknow";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f6947n = "Network";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f6948o = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6949p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f6950q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f6951r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f6952s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f6953t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f6954u = "";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f6955v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Map<String, Object> f6956w = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f6958y = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f6959z = 0;
    private String A = "";
    private int B = 0;

    public static j a(d dVar) {
        return dVar != null ? a(a(dVar.getTrackingInfo()), dVar) : new j();
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getABTestId() {
        return 0;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdNetworkType() {
        return this.f6947n;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getAdsourceId() {
        return this.f6936c;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getAdsourceIndex() {
        return this.f6937d;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getChannel() {
        return this.f6955v;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCountry() {
        return this.f6943j;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCurrency() {
        return this.f6942i;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getCustomRule() {
        Map<String, Object> map = this.f6956w;
        return map != null ? new JSONObject(map).toString() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getDismissType() {
        return this.f6959z;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final double getEcpm() {
        return this.f6938e;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getEcpmLevel() {
        return this.f6949p;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getEcpmPrecision() {
        return this.f6946m;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, Object> getExtInfoMap() {
        return this.f6957x;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Map<String, Object> getLocalExtra() {
        return this.C;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getNetworkFirmId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getNetworkPlacementId() {
        return this.f6948o;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final Double getPublisherRevenue() {
        return this.f6941h;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getRewardUserCustomData() {
        ATBaseAdAdapter aTBaseAdAdapter = this.a;
        return aTBaseAdAdapter != null ? aTBaseAdAdapter.getUserCustomData() : "";
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getScenarioId() {
        return this.f6951r;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getScenarioRewardName() {
        return this.f6952s;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getScenarioRewardNumber() {
        return this.f6953t;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int getSegmentId() {
        return this.f6950q;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getShowId() {
        return this.f6940g;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getSubChannel() {
        return this.f6954u;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTopOnAdFormat() {
        return this.f6945l;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTopOnPlacementId() {
        return this.f6944k;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final String getTpBidId() {
        return this.f6958y;
    }

    @Override // com.anythink.core.api.ATAdInfo
    public final int isHeaderBiddingAdsource() {
        return this.f6939f;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f6940g);
            jSONObject.put("publisher_revenue", this.f6941h);
            jSONObject.put("currency", this.f6942i);
            jSONObject.put("country", this.f6943j);
            jSONObject.put("adunit_id", this.f6944k);
            jSONObject.put("adunit_format", this.f6945l);
            jSONObject.put(com.anythink.core.common.l.P, this.f6946m);
            jSONObject.put("network_type", this.f6947n);
            jSONObject.put("network_placement_id", this.f6948o);
            jSONObject.put(com.anythink.core.common.l.O, this.f6949p);
            jSONObject.put(ATCustomRuleKeys.SEGMENT_ID, this.f6950q);
            if (!TextUtils.isEmpty(this.f6951r)) {
                jSONObject.put("scenario_id", this.f6951r);
            }
            if (!TextUtils.isEmpty(this.f6952s) && this.f6953t != 0) {
                jSONObject.put("scenario_reward_name", this.f6952s);
                jSONObject.put("scenario_reward_number", this.f6953t);
            }
            if (!TextUtils.isEmpty(this.f6955v)) {
                jSONObject.put("channel", this.f6955v);
            }
            if (!TextUtils.isEmpty(this.f6954u)) {
                jSONObject.put("sub_channel", this.f6954u);
            }
            if (this.f6956w != null && this.f6956w.size() > 0) {
                jSONObject.put("custom_rule", new JSONObject(this.f6956w));
            }
            jSONObject.put(k.a.f7051d, this.b);
            jSONObject.put("adsource_id", this.f6936c);
            jSONObject.put("adsource_index", this.f6937d);
            jSONObject.put("adsource_price", this.f6938e);
            jSONObject.put("adsource_isheaderbidding", this.f6939f);
            if (this.f6957x != null && this.f6957x.size() > 0) {
                jSONObject.put("ext_info", new JSONObject(this.f6957x));
            }
            if (this.a != null) {
                jSONObject.put("reward_custom_data", this.a.getUserCustomData());
            }
            if (!TextUtils.isEmpty(this.f6958y)) {
                jSONObject.put("tp_bid_id", this.f6958y);
            }
            if (this.f6959z != 0) {
                jSONObject.put("dismiss_type", this.f6959z);
            }
            if (!TextUtils.isEmpty(this.A)) {
                jSONObject.put(d.a.U, this.A);
            }
            jSONObject.put(com.anythink.core.common.g.c.I, this.B);
            if (this.C != null && this.C.size() > 0) {
                jSONObject.put("user_load_extra_data", new JSONObject(this.C));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static j a(BaseAd baseAd) {
        if (baseAd != null) {
            j jVarA = a(baseAd.getDetail());
            jVarA.f6957x = baseAd.getNetworkInfoMap();
            return jVarA;
        }
        return new j();
    }

    public static j a(com.anythink.core.common.e.e eVar, d dVar) {
        return a(a(eVar), dVar);
    }

    private static j a(com.anythink.core.common.e.e eVar) {
        j jVar = new j();
        return eVar != null ? a(jVar, eVar) : jVar;
    }

    private static j a(j jVar, d dVar) {
        if (dVar != null && (dVar instanceof ATBaseAdAdapter)) {
            jVar.a = (ATBaseAdAdapter) dVar;
            jVar.f6957x = jVar.a.getNetworkInfoMap();
        }
        return jVar;
    }

    private static j a(j jVar, com.anythink.core.common.e.e eVar) {
        ATRewardInfo aTRewardInfoR;
        ATRewardInfo aTRewardInfo;
        jVar.b = eVar.H();
        jVar.f6936c = eVar.x();
        jVar.f6937d = eVar.A();
        jVar.f6939f = eVar.v();
        jVar.f6938e = eVar.f();
        jVar.f6942i = eVar.h();
        jVar.f6940g = eVar.l();
        jVar.f6941h = Double.valueOf(jVar.f6938e / 1000.0d);
        jVar.f6943j = eVar.o();
        jVar.f6945l = com.anythink.core.common.k.g.d(eVar.Y());
        jVar.f6944k = eVar.W();
        jVar.f6946m = eVar.n();
        if (eVar.H() == 35) {
            jVar.f6947n = "Cross_Promotion";
        } else if (eVar.H() == 66) {
            jVar.f6947n = "Adx";
        } else {
            jVar.f6947n = "Network";
        }
        jVar.f6948o = eVar.k();
        jVar.f6949p = eVar.m();
        jVar.f6950q = eVar.I();
        jVar.f6951r = eVar.C;
        if (TextUtils.equals(g.C0162g.b, jVar.f6945l)) {
            Map<String, ATRewardInfo> mapQ = eVar.q();
            if (mapQ != null && mapQ.containsKey(jVar.f6951r) && (aTRewardInfo = mapQ.get(jVar.f6951r)) != null) {
                jVar.f6952s = aTRewardInfo.rewardName;
                jVar.f6953t = aTRewardInfo.rewardNumber;
            }
            if ((TextUtils.isEmpty(jVar.f6952s) || jVar.f6953t == 0) && (aTRewardInfoR = eVar.r()) != null) {
                jVar.f6952s = aTRewardInfoR.rewardName;
                jVar.f6953t = aTRewardInfoR.rewardNumber;
            }
        }
        jVar.f6955v = n.a().n();
        jVar.f6954u = n.a().o();
        jVar.f6956w = eVar.s();
        jVar.f6958y = eVar.e();
        jVar.f6959z = eVar.M();
        jVar.A = eVar.P();
        jVar.B = eVar.U();
        Map<String, Object> mapA = eVar.a();
        if (mapA != null) {
            jVar.C = new HashMap(mapA);
        }
        return jVar;
    }
}
