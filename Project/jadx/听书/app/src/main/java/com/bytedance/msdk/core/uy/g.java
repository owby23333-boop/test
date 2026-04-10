package com.bytedance.msdk.core.uy;

import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.msdk.gz.kb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f408a;
    private int dl;
    private long e;
    private int ec;
    private int eo;
    private int fv;
    private int g;
    private long gc;
    private double gk;
    private String gz;
    private int h;
    private boolean hh;
    private String io;
    private int iq;
    private int j;
    private String js;
    private boolean l;
    private int lq;
    private int ls;
    private long m;
    private int mc;
    private int na;
    private com.bytedance.msdk.core.gz.fo oq;
    private long p;
    private int pf;
    private int q;
    private long sy;
    private double t;
    private String tb;
    private int ti;
    private int uf;
    private int un;
    private double vm;
    private com.bytedance.msdk.core.gz.e wj;
    private int x;
    private JSONObject xl;
    private long y;
    private String z;
    private int zw;
    private List<uy> fo = new CopyOnWriteArrayList();
    private Map<Integer, List<uy>> uy = new HashMap();
    private Map<Integer, List<uy>> kb = new HashMap();
    private List<Integer> wp = new ArrayList();
    private double i = -1.0d;
    private double v = -1.0d;
    private int gp = 1000;
    private int bv = 0;
    private int gb = 2;
    private int jq = 0;
    private int sv = 0;
    private Map<String, Object> f = new HashMap();

    public void z(int i) {
        this.sv = i;
    }

    public int z() {
        return this.sv;
    }

    public int g() {
        return this.ec;
    }

    public void g(int i) {
        this.ec = i;
    }

    public void z(double d) {
        if (d < 0.1d || d > 1.0d) {
            d = 0.1d;
        }
        this.vm = d;
    }

    public double dl() {
        return this.vm;
    }

    public void g(double d) {
        if (d < 0.01d || d > 1.0d) {
            d = 0.01d;
        }
        this.t = d;
    }

    public double a() {
        return this.t;
    }

    public void z(long j) {
        if (j < 1000) {
            j = 1000;
        }
        this.y = j;
    }

    public long gc() {
        return this.y;
    }

    public Map<String, Object> m() {
        return this.f;
    }

    public int e() {
        return this.j;
    }

    public void dl(int i) {
        this.j = i;
    }

    public int gz() {
        int iMin = Math.min(this.gp, 1000);
        if (iMin <= 0) {
            return 1000;
        }
        return iMin;
    }

    public void a(int i) {
        this.gp = i;
    }

    public void gc(int i) {
        this.na = i;
    }

    public com.bytedance.msdk.core.gz.e fo() {
        return this.wj;
    }

    public void z(com.bytedance.msdk.core.gz.e eVar) {
        this.wj = eVar;
    }

    public com.bytedance.msdk.core.gz.fo uy() {
        return this.oq;
    }

    public void z(com.bytedance.msdk.core.gz.fo foVar) {
        this.oq = foVar;
    }

    public void m(int i) {
        this.eo = i;
    }

    public boolean kb() {
        return this.eo == 1;
    }

    public boolean wp() {
        return this.mc == 3;
    }

    public boolean i() {
        return this.na == 1;
    }

    public void e(int i) {
        this.bv = i;
    }

    public int v() {
        return this.bv;
    }

    public void gz(int i) {
        this.gb = i;
    }

    public int pf() {
        int i = this.gb;
        if (i < 2) {
            return 2;
        }
        return i;
    }

    public g ls() {
        List<String> listZ = kb.z();
        g gVar = new g();
        gVar.z = this.z;
        kb.z(listZ, "mRitId");
        gVar.g = this.g;
        kb.z(listZ, "mRitType");
        gVar.dl = this.dl;
        kb.z(listZ, "mLookType");
        gVar.f408a = this.f408a;
        kb.z(listZ, "mMinWaitTime");
        gVar.gc = this.gc;
        kb.z(listZ, "mLayerTimeOut");
        gVar.m = this.m;
        kb.z(listZ, "mTotalTimeOut");
        gVar.e = this.e;
        kb.z(listZ, "mCacheTimeOut");
        gVar.gz = this.gz;
        kb.z(listZ, "mVersion");
        gVar.p = this.p;
        kb.z(listZ, "mWaterFallId");
        gVar.zw = this.zw;
        kb.z(listZ, "reqType");
        gVar.tb = this.tb;
        kb.z(listZ, "mWaterfallAbTestParam");
        gVar.fv = this.fv;
        kb.z(listZ, "segmentId");
        gVar.js = this.js;
        kb.z(listZ, "segmentVersion");
        gVar.q = this.q;
        kb.z(listZ, "preLoadSortControl");
        gVar.iq = this.iq;
        kb.z(listZ, "preShowSortControl");
        gVar.io = this.io;
        kb.z(listZ, "waterfallExtra");
        gVar.uf = this.uf;
        kb.z(listZ, "mMultilevelAfterP");
        gVar.sy = this.sy;
        kb.z(listZ, "mMultilevelTimeOut");
        gVar.h = this.h;
        kb.z(listZ, "mRefreshTime");
        gVar.gk = this.gk;
        kb.z(listZ, "mBidFloor");
        gVar.mc = this.mc;
        kb.z(listZ, "mParallelType");
        gVar.un = this.un;
        kb.z(listZ, "mReqParallelNum");
        gVar.ti = this.ti;
        kb.z(listZ, "mAdCount");
        gVar.x = this.x;
        kb.z(listZ, "serverSideVerifyPreRequestTime");
        gVar.lq = this.lq;
        kb.z(listZ, "serverSideRewardType");
        gVar.na = this.na;
        kb.z(listZ, "mAdPrime");
        gVar.gb = this.gb;
        kb.z(listZ, "mRefreshNum");
        gVar.bv = this.bv;
        kb.z(listZ, "mIsRefresh");
        gVar.wj = this.wj;
        kb.z(listZ, "mIntervalFreqctlBean");
        gVar.oq = this.oq;
        kb.z(listZ, "mIntervalPacingBean");
        gVar.eo = this.eo;
        kb.z(listZ, "mWaterFallTimingMode");
        gVar.y = this.y;
        kb.z(listZ, "mReqInterval");
        gVar.t = this.t;
        kb.z(listZ, "mTotalTimeoutRate");
        gVar.vm = this.vm;
        kb.z(listZ, "mLayerTimeoutRate");
        gVar.f = new HashMap(this.f);
        gVar.j = this.j;
        gVar.gp = this.gp;
        gVar.v = this.v;
        gVar.kb = new HashMap(this.kb);
        kb.g(listZ, "AdsenseRitConfig");
        gVar.jq = this.jq;
        kb.z(listZ, "mBehaviorTTL");
        gVar.sv = this.sv;
        kb.z(listZ, "mIsSamste");
        return gVar;
    }

    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public g clone() {
        g gVar = new g();
        gVar.z = this.z;
        gVar.g = this.g;
        gVar.dl = this.dl;
        gVar.f408a = this.f408a;
        gVar.gc = this.gc;
        gVar.m = this.m;
        gVar.e = this.e;
        gVar.gz = this.gz;
        gVar.p = this.p;
        gVar.zw = this.zw;
        gVar.tb = this.tb;
        gVar.fv = this.fv;
        gVar.js = this.js;
        gVar.q = this.q;
        gVar.iq = this.iq;
        gVar.io = this.io;
        gVar.uf = this.uf;
        gVar.sy = this.sy;
        gVar.h = this.h;
        gVar.gk = this.gk;
        gVar.mc = this.mc;
        gVar.un = this.un;
        gVar.ti = this.ti;
        gVar.x = this.x;
        gVar.lq = this.lq;
        gVar.na = this.na;
        gVar.wj = this.wj;
        gVar.oq = this.oq;
        gVar.eo = this.eo;
        gVar.hh = this.hh;
        gVar.l = this.l;
        gVar.xl = this.xl;
        gVar.i = this.i;
        gVar.ls = this.ls;
        gVar.fo = new CopyOnWriteArrayList(this.fo);
        gVar.uy = new HashMap(this.uy);
        gVar.pf = this.pf;
        gVar.wp = new ArrayList(this.wp);
        gVar.f = new HashMap(this.f);
        gVar.kb = new HashMap(this.kb);
        gVar.j = this.j;
        gVar.gp = this.gp;
        gVar.v = this.v;
        gVar.y = this.y;
        gVar.t = this.t;
        gVar.vm = this.vm;
        gVar.bv = this.bv;
        gVar.gb = this.gb;
        gVar.jq = this.jq;
        gVar.sv = this.sv;
        return gVar;
    }

    public int fv() {
        return this.ti;
    }

    public void fo(int i) {
        this.ti = i;
    }

    public double js() {
        return this.gk;
    }

    public void dl(double d) {
        this.gk = d;
    }

    public int uy(int i) {
        if (e() == 2) {
            int iZ = com.bytedance.msdk.core.fo.a.z(this.z, i, m());
            if (this.h != 0 && iZ != 0) {
                return iZ;
            }
        }
        return this.h;
    }

    public void kb(int i) {
        this.h = i;
    }

    public String tb() {
        return this.io;
    }

    public void z(String str) {
        this.io = str;
    }

    public void wp(int i) {
        this.uf = i;
    }

    public long q() {
        return this.sy;
    }

    public void g(long j) {
        this.sy = j;
    }

    public int iq() {
        return this.zw;
    }

    public void i(int i) {
        this.zw = i;
    }

    public int zw() {
        return this.ls;
    }

    public double io() {
        return this.i;
    }

    public void a(double d) {
        this.i = d;
    }

    public double uf() {
        return this.v;
    }

    public void gc(double d) {
        this.v = d;
    }

    public Map<Integer, List<uy>> sy() {
        HashMap map = new HashMap();
        Map<Integer, List<uy>> map2 = this.uy;
        if (map2 != null) {
            for (Map.Entry<Integer, List<uy>> entry : map2.entrySet()) {
                map.put(Integer.valueOf(entry.getKey().intValue()), new ArrayList(entry.getValue()));
            }
        }
        return map;
    }

    public long hh() {
        return this.p;
    }

    public void dl(long j) {
        this.p = j;
    }

    public void v(int i) {
        this.fv = i;
    }

    public int l() {
        return this.fv;
    }

    public void g(String str) {
        this.js = str;
    }

    public String h() {
        return this.js;
    }

    public boolean gk() {
        return this.hh;
    }

    public void z(boolean z) {
        this.hh = z;
    }

    public boolean x() {
        return this.l;
    }

    public void g(boolean z) {
        this.l = z;
    }

    public String lq() {
        return this.gz;
    }

    public void dl(String str) {
        this.gz = str;
    }

    public List<Integer> mc() {
        return this.wp;
    }

    public String un() {
        return this.z;
    }

    public void a(String str) {
        this.z = str;
    }

    public int ti() {
        return this.g;
    }

    public void pf(int i) {
        this.g = i;
    }

    public void ls(int i) {
        this.dl = i;
    }

    public long eo() {
        return this.f408a;
    }

    public void a(long j) {
        this.f408a = j;
    }

    public long oq() {
        return this.gc;
    }

    public void gc(long j) {
        this.gc = j;
    }

    public long wj() {
        return this.m;
    }

    public void m(long j) {
        this.m = j;
    }

    public long na() {
        return this.e;
    }

    public void e(long j) {
        this.e = j;
    }

    public void p(int i) {
        this.x = i;
    }

    public int xl() {
        return this.x;
    }

    public void fv(int i) {
        this.lq = i;
    }

    public int j() {
        return this.lq;
    }

    public Map<Integer, List<uy>> gp() {
        return this.kb;
    }

    public List<uy> t() {
        return this.fo;
    }

    private void dl(List<uy> list) {
        int iIo;
        List<uy> arrayList;
        if (list == null) {
            return;
        }
        this.kb.clear();
        int i = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            uy uyVar = list.get(i2);
            if (uyVar != null) {
                if (uyVar.js() == 0) {
                    arrayList = new ArrayList<>();
                    iIo = uyVar.uf();
                } else if (uyVar.io() != i) {
                    arrayList = new ArrayList<>();
                    iIo = uyVar.io();
                } else {
                    iIo = i;
                    arrayList = this.kb.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(uyVar);
                    this.kb.put(Integer.valueOf(iIo), arrayList);
                }
                i = iIo;
            }
        }
    }

    private void a(List<uy> list) {
        int iIo;
        List<uy> arrayList;
        if (list == null) {
            return;
        }
        this.kb.clear();
        int i = -1000;
        for (int i2 = 0; i2 < list.size(); i2++) {
            uy uyVar = list.get(i2);
            if (uyVar != null) {
                if (uyVar.io() != i) {
                    arrayList = new ArrayList<>();
                    iIo = uyVar.io();
                } else {
                    iIo = i;
                    arrayList = this.kb.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(uyVar);
                    this.kb.put(Integer.valueOf(iIo), arrayList);
                }
                i = iIo;
            }
        }
    }

    public void z(List<uy> list) {
        int iIo;
        List<uy> arrayList;
        a(list);
        this.fo = list;
        if (list == null) {
            return;
        }
        this.pf = 0;
        this.uy.clear();
        this.wp.clear();
        this.ls = this.fo.size();
        int i = -1000;
        for (int i2 = 0; i2 < this.fo.size(); i2++) {
            uy uyVar = list.get(i2);
            if (uyVar != null) {
                if (uyVar.io() != i) {
                    this.pf++;
                    arrayList = new ArrayList<>();
                    iIo = uyVar.io();
                } else {
                    iIo = i;
                    arrayList = this.uy.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(uyVar);
                    this.uy.put(Integer.valueOf(iIo), arrayList);
                }
                i = iIo;
            }
        }
        this.wp.addAll(this.uy.keySet());
    }

    public void g(List<uy> list) {
        int iIo;
        List<uy> arrayList;
        dl(list);
        this.fo = list;
        if (list == null) {
            return;
        }
        this.pf = 0;
        this.uy.clear();
        this.wp.clear();
        this.ls = this.fo.size();
        int i = -1000;
        for (int i2 = 0; i2 < this.fo.size(); i2++) {
            uy uyVar = list.get(i2);
            if (uyVar != null) {
                if (uyVar.js() == 0) {
                    this.pf++;
                    arrayList = new ArrayList<>();
                    iIo = uyVar.uf();
                } else if (uyVar.io() != i) {
                    this.pf++;
                    arrayList = new ArrayList<>();
                    iIo = uyVar.io();
                } else {
                    iIo = i;
                    arrayList = this.uy.get(Integer.valueOf(i));
                }
                if (arrayList != null) {
                    arrayList.add(uyVar);
                    this.uy.put(Integer.valueOf(iIo), arrayList);
                }
                i = iIo;
            }
        }
        this.wp.addAll(this.uy.keySet());
    }

    public String vm() {
        return this.tb;
    }

    public void gc(String str) {
        this.tb = str;
    }

    public uy m(String str) {
        List<uy> list;
        if (!TextUtils.isEmpty(str) && (list = this.fo) != null && list.size() != 0) {
            for (uy uyVar : this.fo) {
                if (str.equals(uyVar.fv())) {
                    return uyVar;
                }
            }
        }
        return null;
    }

    public int y() {
        return this.mc;
    }

    public void js(int i) {
        this.mc = i;
    }

    public int ec() {
        return this.un;
    }

    public void tb(int i) {
        this.un = i;
    }

    public void z(JSONObject jSONObject) {
        this.xl = jSONObject;
    }

    public static g e(String str) {
        if (TextUtils.isEmpty(str)) {
            com.bytedance.msdk.z.gc.dl.z("AdsenseRitConfig", "TMe jsonStr is null or empty");
            return null;
        }
        try {
            return z(new JSONObject(str), true);
        } catch (JSONException e) {
            wp.z(e);
            return null;
        }
    }

    public static g z(JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2;
        uy uyVar;
        String str;
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        gVar.z(jSONObject);
        gVar.dl(jSONObject.optDouble("bid_floor", 0.0d));
        gVar.a(jSONObject.optString("rit_id"));
        gVar.dl(jSONObject.optString("version"));
        gVar.dl(jSONObject.optLong("waterfall_id", -1L));
        gVar.pf(jSONObject.optInt("rit_type"));
        gVar.ls(jSONObject.optInt("look_type", 1));
        gVar.a(jSONObject.optLong("time_min", iq(gVar.ti()).longValue()));
        gVar.gc(jSONObject.optLong("layer_time_out", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        gVar.m(jSONObject.optLong("total_time_out", zw(gVar.ti()).longValue()));
        gVar.g(jSONObject.optLong("multilevel_time_out", ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        gVar.e(jSONObject.optLong("cache_time_out", C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS));
        gVar.i(jSONObject.optInt("req_type", 0));
        com.bytedance.msdk.core.gc.g.a.z().z(gVar.un(), gVar.iq());
        gVar.v(jSONObject.optInt("segment_id"));
        gVar.g(jSONObject.optString("segment_version"));
        gVar.z(jSONObject.optString("waterfall_extra"));
        gVar.wp(jSONObject.optInt("multilevel_after_p", 1));
        gVar.kb(jSONObject.optInt("refresh_time", 0));
        gVar.e(jSONObject.optInt("is_refresh", 0));
        gVar.gz(jSONObject.optInt("refresh_num", 2));
        gVar.js(jSONObject.optInt("parallel_type", 1));
        gVar.gc(jSONObject.optInt("is_adprime", 0));
        gVar.tb(jSONObject.optInt("req_parallel_num", 2));
        gVar.p(jSONObject.optInt("reward_start_time", 15000));
        gVar.fv(jSONObject.optInt("reward_callback_type"));
        gVar.z(jSONObject.optLong("req_interval", 1000L));
        gVar.g(jSONObject.optDouble("total_time_rate", 0.01d));
        gVar.z(jSONObject.optDouble("layer_time_rate", 0.1d));
        gVar.g(jSONObject.optInt("support_render_control", 0));
        gVar.q(jSONObject.optInt("behavior_ttl"));
        int iOptInt = jSONObject.optInt("ad_count", 0);
        if (iOptInt < 0) {
            iOptInt = 0;
        } else if (iOptInt > 3) {
            iOptInt = 3;
        }
        gVar.fo(iOptInt);
        gVar.dl(jSONObject.optInt("group_type"));
        gVar.a(jSONObject.optInt("bidding_time_out", 1000));
        String strOptString = jSONObject.optString("waterfall_abtest");
        if (strOptString != null) {
            gVar.gc(strOptString);
        }
        int iOptInt2 = jSONObject.optInt("waterfall_timing_mode");
        gVar.m(iOptInt2);
        if (gVar.kb()) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("waterfall_show_pacing_rule");
            if (jSONObjectOptJSONObject != null) {
                str = "waterfall_show_rules_version";
                gVar.z(new com.bytedance.msdk.core.gz.fo(gVar.un(), "", jSONObject.optString("waterfall_show_rules_version"), "", iOptInt2, jSONObjectOptJSONObject.optString("waterfall_show_pacing"), jSONObjectOptJSONObject.optString("waterfall_show_pacing_rule_id")));
            } else {
                str = "waterfall_show_rules_version";
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("waterfall_show_freqctl_rules");
            gVar.z(new com.bytedance.msdk.core.gz.e(gVar.un(), "", jSONObject.optString(str), "", iOptInt2, jSONArrayOptJSONArray == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : jSONArrayOptJSONArray.toString()));
        }
        if (jSONObject.optInt("is_ra") == 1) {
            com.bytedance.msdk.core.admanager.reward.rewardagain.z zVar = new com.bytedance.msdk.core.admanager.reward.rewardagain.z();
            zVar.z(jSONObject.optString("ra_id"));
            zVar.g(jSONObject.optInt("ra_max", 0));
            zVar.g(jSONObject.optDouble("ra_ecpm"));
            zVar.z(jSONObject.optLong("ra_in", 0L));
            zVar.z(jSONObject.optInt("ra_h_max", 0));
            zVar.z(jSONObject.optDouble("ra_ra"));
            com.bytedance.msdk.core.admanager.reward.rewardagain.dl.z(gVar.un(), zVar);
        } else {
            com.bytedance.msdk.core.admanager.reward.rewardagain.dl.uy(gVar.un());
        }
        gVar.z(jSONObject.optInt("is_smaste", 0));
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("adn_rit_conf");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                try {
                    jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i);
                    uyVar = new uy();
                    uyVar.dl(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME));
                    if (com.bytedance.msdk.core.g.g().dl(jSONObject2.optString(MediationConstant.EXTRA_ADN_NAME))) {
                        uyVar.a(jSONObject2.optString("custom_adn_name"));
                    } else {
                        uyVar.a((String) null);
                    }
                    uyVar.e(gVar.vm());
                    String strOptString2 = jSONObject2.optString("adn_slot_id");
                    uyVar.gc(strOptString2);
                    if (!z && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(gVar.un())) {
                        com.bytedance.msdk.dl.gz.a.g.put(strOptString2, gVar.un());
                    }
                    uyVar.z(jSONObject2.optInt("is_refresh", 0));
                    int iOptInt3 = jSONObject2.optInt("freqctl_timing_mode");
                    uyVar.g(iOptInt3);
                    if (uyVar.a()) {
                        JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("show_pacing_rule");
                        if (jSONObjectOptJSONObject2 != null) {
                            uyVar.z(new com.bytedance.msdk.core.gz.fo(gVar.un(), strOptString2, "", "", iOptInt3, jSONObjectOptJSONObject2.optString("pacing"), jSONObjectOptJSONObject2.optString("rule_id")));
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("show_freqctl_rules");
                        uyVar.z(new com.bytedance.msdk.core.gz.e(gVar.un(), strOptString2, "", jSONObject2.optString("show_freqctl_rules_version"), iOptInt3, jSONArrayOptJSONArray3 == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : jSONArrayOptJSONArray3.toString()));
                    }
                    uyVar.uy(jSONObject2.optInt("req_bidding_type"));
                    uyVar.m(jSONObject2.optString("slot_cpm", "0"));
                    uyVar.g(jSONObject2.optString("exchange_rate"));
                    uyVar.kb(jSONObject2.optInt("load_sort"));
                    uyVar.wp(jSONObject2.optInt("show_sort"));
                    uyVar.a(jSONObject2.optInt("ad_expired_time", 1800000));
                    com.bytedance.msdk.core.gc.g.a.z().z(gVar.un(), uyVar.fv(), uyVar.gz());
                    com.bytedance.msdk.core.gc.z.z.z().z(gVar.un(), uyVar.fv(), uyVar.gz());
                    uyVar.gz(jSONObject2.optInt("if_is_ready", 1));
                    com.bytedance.msdk.core.gc.g.a.z().g(gVar.un(), uyVar.fv(), uyVar.wp());
                    com.bytedance.msdk.core.gc.z.z.z().g(gVar.un(), uyVar.fv(), uyVar.wp());
                    uyVar.gc(jSONObject2.optInt("if_reuse_ads", 0));
                    com.bytedance.msdk.core.gc.z.z.z().dl(gVar.un(), uyVar.fv(), uyVar.fo());
                    uyVar.e(jSONObject2.optInt("if_pre_request", 0));
                    com.bytedance.msdk.core.gc.z.z.z().m(gVar.un(), uyVar.fv(), uyVar.kb());
                    uyVar.fo(gVar.ti());
                    uyVar.z("%1$s%2$sAdapter");
                    uyVar.m(jSONObject2.optInt("origin_type"));
                    uyVar.dl(jSONObject2.optInt("sub_adtype"));
                    uyVar.z(g(jSONObject2.optJSONObject("multilevel_slot_cpm")));
                } catch (JSONException e) {
                    e = e;
                }
                if (uyVar.js() == 1) {
                    gVar.g(true);
                } else if (uyVar.js() == 2) {
                    try {
                        gVar.z(true);
                    } catch (JSONException e2) {
                        e = e2;
                        wp.z(e);
                    }
                } else {
                    if (uyVar.js() == 3) {
                        try {
                            gVar.g(true);
                        } catch (JSONException e3) {
                            e = e3;
                            wp.z(e);
                        }
                    } else if (uyVar.js() != 100) {
                        if (gVar.io() == -1.0d || gVar.io() < uyVar.zw()) {
                            gVar.a(uyVar.zw());
                        }
                        if (gVar.uf() == -1.0d || gVar.uf() > uyVar.zw()) {
                            gVar.gc(uyVar.zw());
                        }
                    }
                    uyVar.fo(jSONObject2.optString("customer_adapter_json"));
                    arrayList.add(uyVar);
                }
                uyVar.fo(jSONObject2.optString("customer_adapter_json"));
                arrayList.add(uyVar);
            }
        }
        Collections.sort(arrayList);
        if (gVar.wp()) {
            gVar.g(arrayList);
        } else {
            gVar.z(arrayList);
        }
        return gVar;
    }

    private static Long iq(int i) {
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 5) {
                    if (i != 7 && i != 8) {
                        return 0L;
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    private static Long zw(int i) {
        if (i != 1 && i != 2) {
            if (i == 3) {
                return 5000L;
            }
            if (i != 5) {
                if (i == 7 || i == 8) {
                    return Long.valueOf(TTAdConstant.AD_MAX_EVENT_TIME);
                }
                return Long.valueOf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            }
        }
        return Long.valueOf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    private static Map<String, String> g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys == null) {
                return null;
            }
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                    map.put(next, strOptString);
                }
            }
            if (map.size() == 0) {
                return null;
            }
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public int bv() {
        return this.jq;
    }

    public void q(int i) {
        this.jq = i;
    }

    public String toString() {
        return "AdsenseRitConfig{mRitId='" + this.z + "', mIsSpeed=" + wp() + ", mHasServerbidding=" + this.hh + ", mHasClientOrMultiLevel=" + this.l + ", mRitType=" + this.g + ", mLookType=" + this.dl + ", mMinWaitTime=" + this.f408a + ", mLayerTimeOut=" + this.gc + ", mTotalTimeOut=" + this.m + ", mWaterFallConfigList=" + this.fo + ", mWaterFallConfMap=" + this.uy + ", mLoadSortLevelList=" + this.wp + ", mCurrentCommonAdMaxCpm=" + this.i + ", mTotalLoadLevelCount=" + this.pf + ", mTotalWaterFallCount=" + this.ls + ", mWaterfallAbTestParam=" + this.tb + ", mServerSideVerifyPreRequestTime=" + this.x + ", mServerSideVerifyRewardType=" + this.lq + '}';
    }
}
