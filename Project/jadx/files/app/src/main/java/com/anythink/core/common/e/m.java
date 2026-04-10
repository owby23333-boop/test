package com.anythink.core.common.e;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.c.k;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends l implements Comparable<m> {
    private boolean A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    public int a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f7342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f7344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f7345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f7347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f7348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f7350o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f7351p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double f7352q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.anythink.core.b.c.a f7353r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7354s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f7355t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f7356u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f7357v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f7358w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f7359x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final String f7360y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final String f7361z;

    public m(boolean z2, double d2, String str, String str2, String str3, String str4, String str5) {
        super(z2, d2, str, str2, str3, str4, str5, ATAdConst.CURRENCY.USD);
        this.f7355t = m.class.getSimpleName() + ":";
        this.f7357v = "${AUCTION_PRICE}";
        this.f7358w = "${AUCTION_LOSS}";
        this.f7359x = "${AUCTION_SEAT_ID}";
        this.f7360y = "${AUCTION_BID_TO_WIN}";
        this.f7361z = "${AUCTION_CURRENCY}";
    }

    private static String a(int i2) {
        return i2 == 2 ? ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB : ErrorCode.networkError;
    }

    private static int d(ai aiVar) {
        if (aiVar == null) {
            return 0;
        }
        int iL = aiVar.l();
        if (iL != 2) {
            return (iL == 5 || iL == 6) ? 3 : 1;
        }
        return 2;
    }

    public final boolean a() {
        return this.f7341f < System.currentTimeMillis();
    }

    public final synchronized void b() {
        this.A = true;
    }

    public final String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(k.a.b, this.token);
            jSONObject.put("cur", this.b);
            jSONObject.put("origin_price", this.originPrice);
            jSONObject.put("price", this.price);
            jSONObject.put("nurl", this.winNoticeUrl);
            jSONObject.put("lurl", this.loseNoticeUrl);
            jSONObject.put("unit_id", this.f7338c);
            jSONObject.put("nw_firm_id", this.f7339d);
            jSONObject.put("is_success", this.isSuccess ? 1 : 0);
            jSONObject.put("err_code", this.a);
            jSONObject.put("err_msg", this.errorMsg);
            jSONObject.put("expire", this.f7340e);
            jSONObject.put("out_data_time", this.f7341f);
            jSONObject.put("is_send_winurl", this.f7356u);
            jSONObject.put(k.a.f7052e, this.f7344i);
            jSONObject.put("tp_bid_id", this.f7342g);
            jSONObject.put("burl", this.displayNoticeUrl);
            jSONObject.put("ad_source_id", this.f7346k);
            jSONObject.put("cur_rate", this.f7347l);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.anythink.core.common.l.ae, this.f7349n);
            jSONObject.put("ctrl", jSONObject2);
            if (!TextUtils.isEmpty(this.f7348m)) {
                jSONObject.put("bid_response", this.f7348m);
            }
            jSONObject.put("ecpm_api", this.f7350o);
            jSONObject.put(com.anythink.core.common.l.P, this.f7351p);
            jSONObject.put("second_price", this.f7352q);
            jSONObject.put("req_url", this.f7343h);
            jSONObject.put("bd_type", this.useType);
            jSONObject.put(com.anythink.core.common.l.am, this.sortPrice);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(m mVar) {
        m mVar2 = mVar;
        if (mVar2 == null) {
            return -1;
        }
        double dA = this.sortPrice;
        double dA2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        if (dA == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            dA = com.anythink.core.b.f.a().a(this.f7342g, this.f7346k);
        }
        if (mVar2 != null) {
            double d2 = mVar2.sortPrice;
            dA2 = d2 == PangleAdapterUtils.CPM_DEFLAUT_VALUE ? com.anythink.core.b.f.a().a(mVar2.f7342g, mVar2.f7346k) : d2;
        }
        return dA > dA2 ? -1 : 1;
    }

    public final synchronized void a(ai aiVar) {
        a(aiVar, this.f7352q);
    }

    public final boolean d() {
        return this.price == PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }

    private String b(boolean z2, int i2) {
        if (i2 == 3) {
            return GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
        }
        int i3 = this.f7339d;
        if (i3 == 8) {
            return i2 == 1 ? "5" : "1";
        }
        if (i3 == 29) {
            return i2 == 1 ? "2002" : "2";
        }
        if (i3 == 34) {
            return a(i2);
        }
        return (i3 == 59 || z2) ? ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB : ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL;
    }

    private synchronized void a(ai aiVar, double d2) {
        if (this.f7356u) {
            return;
        }
        this.f7356u = true;
        if (this.f7347l > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            d2 *= this.f7347l;
        }
        double sortPrice = this.f7347l > PangleAdapterUtils.CPM_DEFLAUT_VALUE ? getSortPrice() * this.f7347l : getSortPrice();
        if (!TextUtils.isEmpty(this.winNoticeUrl)) {
            String strReplace = this.winNoticeUrl.replace("${AUCTION_BID_TO_WIN}", a(d2));
            if (this.f7339d == 28) {
                strReplace = this.winNoticeUrl.replace("${AUCTION_PRICE}", a(sortPrice));
            }
            if (aiVar != null) {
                com.anythink.core.common.g.f fVarA = com.anythink.core.common.g.f.a(strReplace, aiVar.c(), aiVar.t());
                fVarA.a(c(aiVar));
                fVarA.a(0, (com.anythink.core.common.g.i) null);
            }
        }
        if (this.biddingNotice != null) {
            if (this.f7339d == 28) {
                this.biddingNotice.notifyBidWin(sortPrice);
            } else {
                this.biddingNotice.notifyBidWin(d2);
            }
            com.anythink.core.common.j.c.a(c(aiVar));
        }
        if ((aiVar.l() == 3 || aiVar.l() == 7) && !this.A) {
            com.anythink.core.b.f.a();
            com.anythink.core.b.f.a(this.f7346k, this);
        }
    }

    private void b(double d2) {
        this.f7352q = d2;
    }

    public final void b(String str) {
        this.B = str;
    }

    private void b(ai aiVar) {
        com.anythink.core.common.j.c.a(c(aiVar));
    }

    public final synchronized void a(boolean z2, double d2, boolean z3) {
        if (this.f7347l > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            d2 *= this.f7347l;
        }
        if (z2) {
            String str = this.f7345j;
            if (TextUtils.isEmpty(str)) {
                str = this.displayNoticeUrl;
            }
            if (!TextUtils.isEmpty(str)) {
                c(str.replace("${AUCTION_PRICE}", a(d2)));
            }
        } else {
            String str2 = this.displayNoticeUrl;
            if (!TextUtils.isEmpty(str2)) {
                c(str2.replace("${AUCTION_PRICE}", a(d2)).replace("${AUCTION_LOSS}", b(z3, 2)));
            }
        }
        if (this.biddingNotice != null) {
            this.biddingNotice.notifyBidDisplay(z2, d2);
            if (z2) {
                this.biddingNotice = null;
            }
        }
    }

    private static void c(String str) {
        com.anythink.core.common.g.f.b(str).a(0, (com.anythink.core.common.g.i) null);
    }

    private an c(ai aiVar) {
        if (aiVar == null) {
            return null;
        }
        an anVar = new an(aiVar.c(), aiVar.t());
        anVar.c(this.B);
        anVar.a(d(aiVar));
        anVar.f(this.f7342g);
        anVar.d(this.D);
        anVar.e(this.C);
        anVar.g(this.E);
        anVar.h(this.F);
        anVar.i(this.G);
        return anVar;
    }

    public final synchronized void a(r rVar, boolean z2) {
        String strReplace;
        int i2 = rVar.a;
        ai aiVar = rVar.f7377d;
        ai aiVar2 = rVar.f7376c;
        double sortPrice = rVar.b;
        e eVar = rVar.f7378e;
        if (aiVar2 != null && aiVar != null) {
            boolean zJ = aiVar2.j();
            int iC = aiVar2.c();
            m mVarA = com.anythink.core.b.f.a().a(aiVar);
            if (z2) {
                if (mVarA != null && TextUtils.equals(mVarA.token, this.token)) {
                    com.anythink.core.b.f.a().a(this.f7346k);
                    com.anythink.core.b.f.a();
                    com.anythink.core.b.f.b(this.f7346k);
                }
                if (aiVar.l() == 3 || aiVar.l() == 7) {
                    com.anythink.core.common.a.a.a().b(com.anythink.core.common.b.n.a().g(), this.token);
                }
            }
            if (this.f7356u) {
                return;
            }
            this.f7356u = true;
            if (sortPrice <= getSortPrice()) {
                sortPrice = getSortPrice() + 0.01d;
            }
            String str = this.loseNoticeUrl;
            String strB = b(zJ, i2);
            com.anythink.core.common.j.c.a(eVar, aiVar, sortPrice, strB);
            if (this.f7347l > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                sortPrice *= this.f7347l;
            }
            if (!strB.equals(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE)) {
                if (this.biddingNotice != null) {
                    HashMap map = new HashMap(3);
                    if (this.f7339d == 8) {
                        map.put(ATBiddingNotice.ADN_ID, Integer.valueOf(a(zJ, iC)));
                    }
                    this.biddingNotice.notifyBidLoss(strB, sortPrice, map);
                    this.biddingNotice = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    String strReplace2 = str.replace("${AUCTION_PRICE}", a(sortPrice)).replace("${AUCTION_LOSS}", strB);
                    if (this.f7339d == 8) {
                        strReplace = strReplace2.replace("${AUCTION_SEAT_ID}", String.valueOf(a(zJ, iC)));
                    } else if (this.f7339d == 29) {
                        strReplace = strReplace2.replace("${AUCTION_SEAT_ID}", this.f7339d == iC ? "1" : "10001");
                    } else {
                        strReplace = strReplace2.replace("${AUCTION_SEAT_ID}", "");
                    }
                    if (this.f7339d == 6) {
                        strReplace = strReplace.replace("${AUCTION_CURRENCY}", ATAdConst.CURRENCY.USD.toString());
                    }
                    c(strReplace);
                }
            }
        }
    }

    private int a(boolean z2, int i2) {
        int i3 = this.f7339d;
        return i2 == i3 ? !z2 ? 1 : 4 : (i2 == 67 || i3 == 35) ? 3 : 2;
    }

    private String a(double d2) {
        int i2 = this.f7339d;
        if (i2 != 8 && i2 != 28) {
            return String.valueOf(d2);
        }
        return String.valueOf((int) d2);
    }

    public static m a(String str) {
        double d2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            m mVar = new m(jSONObject.optInt("is_success") == 1, jSONObject.has("price") ? jSONObject.optDouble("price") : 0.0d, jSONObject.optString(k.a.b), jSONObject.optString("nurl"), jSONObject.optString("lurl"), jSONObject.optString("burl"), jSONObject.optString("err_msg"));
            mVar.b = jSONObject.optString("cur");
            mVar.f7338c = jSONObject.optString("unit_id");
            mVar.f7339d = jSONObject.optInt("nw_firm_id");
            mVar.a = jSONObject.optInt("err_code");
            mVar.f7340e = jSONObject.optLong("expire");
            mVar.f7341f = jSONObject.optLong("out_data_time");
            mVar.f7356u = jSONObject.optBoolean("is_send_winurl");
            mVar.f7344i = jSONObject.optString(k.a.f7052e);
            mVar.f7342g = jSONObject.optString("tp_bid_id");
            mVar.f7345j = jSONObject.optString("burl_win");
            mVar.f7346k = jSONObject.optString("ad_source_id");
            mVar.f7347l = jSONObject.optDouble("cur_rate");
            if (jSONObject.has("bid_response")) {
                mVar.f7348m = jSONObject.optString("bid_response");
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ctrl");
            if (jSONObjectOptJSONObject != null) {
                mVar.f7349n = jSONObjectOptJSONObject.optInt(com.anythink.core.common.l.ae);
            }
            if (jSONObject.has("ecpm_api")) {
                d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
                mVar.f7350o = jSONObject.optDouble("ecpm_api", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            } else {
                d2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            }
            mVar.f7351p = jSONObject.optString(com.anythink.core.common.l.P);
            if (jSONObject.has("second_price")) {
                mVar.f7352q = jSONObject.optDouble("second_price", d2);
            }
            mVar.f7343h = jSONObject.optString("req_url", "");
            mVar.useType = jSONObject.optInt("bd_type", 1);
            if (jSONObject.has(com.anythink.core.common.l.am)) {
                mVar.sortPrice = jSONObject.optDouble(com.anythink.core.common.l.am, d2);
            } else {
                mVar.sortPrice = mVar.price;
            }
            if (jSONObject.has("origin_price")) {
                mVar.originPrice = jSONObject.optDouble("origin_price");
            } else {
                mVar.originPrice = mVar.sortPrice;
            }
            return mVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private int a(m mVar) {
        if (mVar == null) {
            return -1;
        }
        double dA = this.sortPrice;
        double dA2 = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        if (dA == PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            dA = com.anythink.core.b.f.a().a(this.f7342g, this.f7346k);
        }
        if (mVar != null) {
            double d2 = mVar.sortPrice;
            dA2 = d2 == PangleAdapterUtils.CPM_DEFLAUT_VALUE ? com.anythink.core.b.f.a().a(mVar.f7342g, mVar.f7346k) : d2;
        }
        return dA > dA2 ? -1 : 1;
    }

    private static String a(int i2, String str) {
        return TextUtils.isEmpty(str) ? "" : i2 == 34 ? str.replace("${AUCTION_CURRENCY}", ATAdConst.CURRENCY.USD.toString()) : str;
    }

    private void a(String str, ai aiVar) {
        if (aiVar == null) {
            return;
        }
        com.anythink.core.common.g.f fVarA = com.anythink.core.common.g.f.a(str, aiVar.c(), aiVar.t());
        fVarA.a(c(aiVar));
        fVarA.a(0, (com.anythink.core.common.g.i) null);
    }

    public final void a(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.C = a(map, "offer_id");
        this.D = a(map, "dsp_id");
    }

    public final void a(e eVar) {
        if (eVar == null) {
            return;
        }
        this.F = String.valueOf(eVar.U());
        this.E = String.valueOf(eVar.I());
        this.G = eVar.W();
    }

    private static String a(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof String) {
            return obj.toString();
        }
        return obj != null ? obj.toString() : "";
    }
}
