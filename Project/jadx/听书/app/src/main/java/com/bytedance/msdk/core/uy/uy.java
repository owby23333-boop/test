package com.bytedance.msdk.core.uy;

import android.text.TextUtils;
import com.bytedance.msdk.gz.kb;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements Comparable<uy> {
    private String dl;
    private int e;
    private int fo;
    private gz fv;
    private String g;
    private int gz;
    private int i;
    private com.bytedance.msdk.core.gz.e io;
    private int iq;
    private Map<String, String> js;
    private String kb;
    private int ls;
    private int m;
    private int p;
    private int pf;
    private String q;
    private int tb;
    private int uf;
    private String uy;
    private int v;
    private String wp;
    private String z;
    private com.bytedance.msdk.core.gz.fo zw;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f412a = "1";
    private String gc = "0";

    public void z(int i) {
        this.uf = i;
    }

    public int z() {
        return this.uf;
    }

    public com.bytedance.msdk.core.gz.e g() {
        return this.io;
    }

    public void z(com.bytedance.msdk.core.gz.e eVar) {
        this.io = eVar;
    }

    public com.bytedance.msdk.core.gz.fo dl() {
        return this.zw;
    }

    public void z(com.bytedance.msdk.core.gz.fo foVar) {
        this.zw = foVar;
    }

    public void g(int i) {
        this.iq = i;
    }

    public boolean a() {
        return this.iq == 1;
    }

    public uy gc() {
        ConcurrentHashMap concurrentHashMap;
        List<String> listG = kb.g();
        uy uyVar = new uy();
        uyVar.z = this.z;
        kb.z(listG, "mAdnetworkName");
        uyVar.dl = this.dl;
        kb.z(listG, "mAdnetwokrSlotId");
        uyVar.f412a = this.f412a;
        kb.z(listG, "mExchangeRate");
        uyVar.gc = this.gc;
        kb.z(listG, "mEcpm");
        uyVar.m = this.m;
        kb.z(listG, "mAdnetworkSlotType");
        uyVar.e = this.e;
        kb.z(listG, "mLoadSort");
        uyVar.gz = this.gz;
        kb.z(listG, "mShowSort");
        uyVar.fo = this.fo;
        kb.z(listG, "mRitType");
        uyVar.pf = this.pf;
        kb.z(listG, "originType");
        uyVar.tb = this.tb;
        kb.z(listG, "mSubAdType");
        uyVar.uy = this.uy;
        kb.z(listG, "mLoaderAdapterName");
        uyVar.kb = this.kb;
        kb.z(listG, "mWaterfallAbTestParam");
        uyVar.wp = this.wp;
        kb.z(listG, "mServerBiddingExtra");
        uyVar.i = this.i;
        kb.z(listG, "adExpiredTime");
        uyVar.v = this.v;
        kb.z(listG, "ifReuseAds");
        uyVar.ls = this.ls;
        kb.z(listG, "ifPreRequest");
        uyVar.p = this.p;
        kb.z(listG, "ifIsReady");
        uyVar.uf = this.uf;
        kb.z(listG, "isRefresh");
        uyVar.g = this.g;
        kb.z(listG, "mCustomAdnetworkName");
        Map<String, String> map = this.js;
        if (map == null || map.size() <= 0) {
            concurrentHashMap = null;
        } else {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.js);
        }
        uyVar.js = concurrentHashMap;
        kb.z(listG, "mMultilevelSlotCpm");
        uyVar.q = this.q;
        kb.z(listG, "mCustomAdapterJson");
        uyVar.iq = this.iq;
        kb.z(listG, "mAdnRitTimingMode");
        uyVar.io = this.io;
        kb.z(listG, "mIntervalFreqctlBean");
        uyVar.zw = this.zw;
        kb.z(listG, "mIntervalPacingBean");
        kb.g(listG, "WaterFallConfig");
        return uyVar;
    }

    public int m() {
        return this.tb;
    }

    public void dl(int i) {
        this.tb = i;
    }

    public String e() {
        return this.uy;
    }

    public void z(String str) {
        this.uy = str;
    }

    public int gz() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public int fo() {
        return this.v;
    }

    public void gc(int i) {
        this.v = i;
    }

    public int uy() {
        return this.pf;
    }

    public void m(int i) {
        this.pf = i;
    }

    public int kb() {
        return this.ls;
    }

    public void e(int i) {
        this.ls = i;
    }

    public int wp() {
        return this.p;
    }

    public void gz(int i) {
        this.p = i;
    }

    public int i() {
        return this.fo;
    }

    public void fo(int i) {
        this.fo = i;
    }

    public String v() {
        return this.f412a;
    }

    public void g(String str) {
        this.f412a = str;
    }

    public String pf() {
        return this.z;
    }

    public void dl(String str) {
        this.z = str;
    }

    public String ls() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }

    public String p() {
        return TextUtils.isEmpty(this.z) ? this.g : this.z;
    }

    public String fv() {
        return this.dl;
    }

    public void gc(String str) {
        this.dl = str;
    }

    public int js() {
        return this.m;
    }

    public void uy(int i) {
        this.m = i;
    }

    public boolean tb() {
        int i = this.m;
        return i == 0 || i == 100;
    }

    public double q() {
        gz gzVar = this.fv;
        if (gzVar != null && !TextUtils.isEmpty(gzVar.gc())) {
            try {
                return Double.valueOf(this.fv.gc()).doubleValue();
            } catch (Exception e) {
                com.bytedance.msdk.z.gc.dl.a("WaterFallConfig", "getServerBiddingShowEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public double iq() {
        gz gzVar = this.fv;
        if (gzVar != null && !TextUtils.isEmpty(gzVar.m())) {
            try {
                return Double.valueOf(this.fv.m()).doubleValue();
            } catch (Exception e) {
                com.bytedance.msdk.z.gc.dl.a("WaterFallConfig", "getServerBiddingLoadEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public double zw() {
        try {
            return Double.valueOf(this.gc).doubleValue() * Double.valueOf(this.f412a).doubleValue();
        } catch (Exception e) {
            com.bytedance.msdk.z.gc.dl.a("WaterFallConfig", "getEcpm error " + e.toString());
            return 0.0d;
        }
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.gc = str;
    }

    public int io() {
        return this.e;
    }

    public void kb(int i) {
        this.e = i;
    }

    public int uf() {
        return this.gz;
    }

    public void wp(int i) {
        this.gz = i;
    }

    public String sy() {
        return this.kb;
    }

    public void e(String str) {
        this.kb = str;
    }

    public String hh() {
        return this.wp;
    }

    public void gz(String str) {
        this.wp = str;
    }

    public void z(gz gzVar) {
        this.fv = gzVar;
    }

    public gz l() {
        return this.fv;
    }

    public Map<String, String> h() {
        return this.js;
    }

    public void z(Map<String, String> map) {
        this.js = map;
    }

    public String toString() {
        return "WaterFallConfig{mAdnetworkName='" + this.z + "', mCustomAdnetworkName='" + this.g + "', mAdnetwokrSlotId='" + this.dl + "', mExchangeRate=" + this.f412a + ", mSlotEcpm=" + this.gc + ", mAdnetworkSlotType=" + this.m + ", mLoadSort=" + this.e + ", mShowSort=" + this.gz + '}';
    }

    public boolean gk() {
        return this.m == 2;
    }

    public boolean x() {
        return this.m == 1;
    }

    public boolean lq() {
        return this.m == 100;
    }

    public boolean mc() {
        return this.m == 3;
    }

    public boolean un() {
        return gk() || x() || mc();
    }

    public boolean ti() {
        return this.m == 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(uy uyVar) {
        if (uyVar == null || this.e > uyVar.io()) {
            return 1;
        }
        if (this.e < uyVar.io()) {
            return -1;
        }
        if (this.gz > uyVar.uf()) {
            return 1;
        }
        return this.gz < uyVar.uf() ? -1 : 0;
    }

    public void fo(String str) {
        this.q = str;
    }

    public String eo() {
        return this.q;
    }

    public boolean oq() {
        return com.bytedance.msdk.core.g.g().dl(this.z);
    }
}
