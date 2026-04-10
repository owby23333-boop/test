package com.ss.android.g.z.g;

import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.g.z.z.dl;
import com.ss.android.g.z.z.g;
import com.ss.android.g.z.z.z;
import com.ss.android.z.z.dl.dl;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2024a;
    private long b;
    private String bm;
    private boolean bv;
    public final AtomicBoolean dl;
    private long e;
    private long ec;
    private boolean eo;
    private String f;
    private int fo;
    private String fv;
    protected boolean g;
    private boolean gb;
    public final AtomicBoolean gc;
    private long gk;
    private boolean gp;
    private String gz;
    private long h;
    private int hh;
    private String i;
    private int io;
    private long iq;
    private boolean j;
    private long jq;
    private String js;
    private String kb;
    private long l;
    private int lq;
    private int ls;
    private transient boolean lw;
    private long m;
    private String mc;
    private boolean me;
    private String na;
    private boolean nh;
    private boolean oq;
    private int p;
    private int pf;
    private boolean q;
    private boolean qd;
    private boolean r;
    private boolean rv;
    private long sd;
    private long sv;
    private int sy;
    private int t;
    private String tb;
    private boolean tc;
    private String ti;
    private boolean uf;
    private boolean un;
    private String uy;
    private int v;
    private int vm;
    private boolean wj;
    private String wp;
    private int x;
    private String xl;
    private long y;
    private boolean yx;
    private boolean yz;
    protected boolean z;
    private JSONObject zw;
    private boolean zx;

    @Override // com.ss.android.g.z.g.z
    public JSONObject fv() {
        return null;
    }

    @Override // com.ss.android.g.z.g.z
    public JSONObject kb() {
        return null;
    }

    @Override // com.ss.android.g.z.g.z
    public JSONObject ls() {
        return null;
    }

    @Override // com.ss.android.g.z.g.z
    public Object pf() {
        return null;
    }

    @Override // com.ss.android.g.z.g.z
    public int tb() {
        return -1;
    }

    @Override // com.ss.android.g.z.g.z
    public List<String> v() {
        return null;
    }

    private g() {
        this.fo = 1;
        this.q = true;
        this.uf = false;
        this.sy = 0;
        this.hh = 0;
        this.un = false;
        this.eo = false;
        this.oq = true;
        this.wj = true;
        this.z = true;
        this.g = true;
        this.dl = new AtomicBoolean(false);
        this.f2024a = new AtomicBoolean(false);
        this.gc = new AtomicBoolean(false);
        this.vm = 1;
        this.bv = true;
        this.b = -1L;
    }

    public g(dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar) {
        this(dlVar, gVar, zVar, 0);
    }

    public g(dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, int i) {
        this.fo = 1;
        this.q = true;
        this.uf = false;
        this.sy = 0;
        this.hh = 0;
        this.un = false;
        this.eo = false;
        this.oq = true;
        this.wj = true;
        this.z = true;
        this.g = true;
        this.dl = new AtomicBoolean(false);
        this.f2024a = new AtomicBoolean(false);
        this.gc = new AtomicBoolean(false);
        this.vm = 1;
        this.bv = true;
        this.b = -1L;
        this.m = dlVar.a();
        this.e = dlVar.e();
        this.gz = dlVar.uf();
        this.uy = dlVar.sy();
        this.zw = dlVar.gk();
        this.q = dlVar.io();
        this.p = dlVar.iq();
        this.fv = dlVar.zw();
        this.kb = dlVar.z();
        if (dlVar.l() != null) {
            this.wp = dlVar.l().g();
            this.i = dlVar.l().z();
        }
        this.v = dlVar.x();
        this.js = dlVar.gz();
        this.tb = dlVar.hh();
        this.ti = dlVar.fo();
        this.na = gVar.g();
        this.xl = gVar.z();
        this.j = gVar.i();
        this.uf = zVar.dl();
        this.pf = zVar.z();
        this.ls = zVar.g();
        this.bv = zVar.wp();
        this.gb = zVar.i();
        this.oq = zVar.v();
        this.z = zVar.pf();
        this.g = zVar.ls();
        this.io = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.iq = jCurrentTimeMillis;
        this.l = jCurrentTimeMillis;
        this.eo = dlVar.ti();
        if (dlVar instanceof com.ss.android.g.z.z.dl) {
            this.bm = ((com.ss.android.g.z.z.dl) dlVar).t();
        }
    }

    public int io() {
        return this.sy;
    }

    public void z(int i) {
        this.sy = i;
    }

    public synchronized void uf() {
        this.sy++;
    }

    public int sy() {
        return this.hh;
    }

    public void g(int i) {
        this.hh = i;
    }

    public synchronized void hh() {
        this.hh++;
    }

    public long l() {
        long j = this.l;
        return j == 0 ? this.iq : j;
    }

    public void z(long j) {
        this.l = j;
    }

    public long h() {
        return this.h;
    }

    public void g(long j) {
        this.h = j;
    }

    public void dl(long j) {
        this.gk = j;
    }

    public int gk() {
        return this.x;
    }

    public void dl(int i) {
        this.x = i;
    }

    public int x() {
        return this.lq;
    }

    public void a(int i) {
        this.lq = i;
    }

    public String lq() {
        return this.mc;
    }

    public void z(String str) {
        this.mc = str;
    }

    @Override // com.ss.android.g.z.g.z
    public long g() {
        return this.m;
    }

    public void a(long j) {
        this.m = j;
    }

    @Override // com.ss.android.g.z.g.z
    public long wp() {
        return this.e;
    }

    public void gc(long j) {
        this.e = j;
    }

    public int mc() {
        return this.fo;
    }

    public void gc(int i) {
        this.fo = i;
    }

    @Override // com.ss.android.g.z.g.z
    public String gc() {
        return this.uy;
    }

    public void g(String str) {
        this.uy = str;
    }

    public long un() {
        return this.iq;
    }

    public void m(long j) {
        if (j > 0) {
            this.iq = j;
        }
    }

    @Override // com.ss.android.g.z.g.z
    public String a() {
        return this.gz;
    }

    public void dl(String str) {
        this.gz = str;
    }

    @Override // com.ss.android.g.z.g.z
    public boolean dl() {
        return this.q;
    }

    public void z(boolean z) {
        this.q = z;
    }

    @Override // com.ss.android.g.z.g.z
    public JSONObject e() {
        return this.zw;
    }

    public void z(JSONObject jSONObject) {
        this.zw = jSONObject;
    }

    public void m(int i) {
        this.p = i;
    }

    public void a(String str) {
        this.fv = str;
    }

    public int ti() {
        return this.p;
    }

    public String eo() {
        return this.fv;
    }

    public void e(int i) {
        this.io = i;
    }

    @Override // com.ss.android.g.z.g.z
    public int js() {
        return this.io;
    }

    public void g(boolean z) {
        this.j = z;
    }

    @Override // com.ss.android.g.z.g.z
    public boolean i() {
        return this.j;
    }

    public void gz(int i) {
        this.t = i;
    }

    public int oq() {
        return this.t;
    }

    public void fo(int i) {
        this.vm = i;
    }

    public void gc(String str) {
        this.i = str;
    }

    @Override // com.ss.android.g.z.g.z
    public int gz() {
        return this.vm;
    }

    public void dl(boolean z) {
        this.uf = z;
    }

    public boolean wj() {
        return this.uf;
    }

    public void m(String str) {
        this.na = str;
    }

    @Override // com.ss.android.g.z.g.z
    public String uy() {
        return this.na;
    }

    public void e(String str) {
        this.xl = str;
    }

    @Override // com.ss.android.g.z.g.z
    public String fo() {
        return this.xl;
    }

    public void gz(String str) {
        this.kb = str;
    }

    @Override // com.ss.android.g.z.g.z
    public String z() {
        return this.kb;
    }

    public void fo(String str) {
        this.wp = str;
    }

    @Override // com.ss.android.g.z.g.z
    public String m() {
        return this.wp;
    }

    public void e(long j) {
        this.b = j;
    }

    public long na() {
        return this.b;
    }

    public void uy(String str) {
        this.js = str;
    }

    public String xl() {
        return this.js;
    }

    public void kb(String str) {
        this.tb = str;
    }

    public void uy(int i) {
        this.pf = i;
    }

    public int j() {
        return this.pf;
    }

    public void kb(int i) {
        this.ls = i;
    }

    public void wp(int i) {
        this.v = i;
    }

    public void a(boolean z) {
        this.yx = z;
    }

    public String gp() {
        return this.f;
    }

    public void wp(String str) {
        this.f = str;
    }

    public boolean t() {
        return this.qd;
    }

    public void gc(boolean z) {
        this.qd = z;
    }

    public boolean vm() {
        return this.gp;
    }

    public void m(boolean z) {
        this.gp = z;
    }

    public boolean y() {
        return this.zx;
    }

    public void e(boolean z) {
        this.zx = z;
    }

    public long ec() {
        return this.y;
    }

    public void gz(long j) {
        this.y = j;
    }

    public long bv() {
        return this.ec;
    }

    public void fo(long j) {
        this.ec = j;
    }

    public boolean gb() {
        return this.un;
    }

    public void gz(boolean z) {
        this.un = z;
    }

    public String jq() {
        return this.ti;
    }

    public void i(String str) {
        this.ti = str;
    }

    public boolean sv() {
        return this.eo;
    }

    public void fo(boolean z) {
        this.eo = z;
    }

    public boolean f() {
        return this.lw;
    }

    public void uy(boolean z) {
        this.lw = z;
    }

    public boolean yx() {
        return this.rv;
    }

    public void kb(boolean z) {
        this.rv = z;
    }

    public boolean qd() {
        return this.me;
    }

    public void wp(boolean z) {
        this.me = z;
    }

    public boolean zx() {
        return this.tc;
    }

    public void i(boolean z) {
        this.tc = z;
    }

    public boolean b() {
        return this.nh;
    }

    public void v(boolean z) {
        this.nh = z;
    }

    public boolean lw() {
        return this.r;
    }

    public void pf(boolean z) {
        this.r = z;
    }

    public void ls(boolean z) {
        this.bv = z;
    }

    public void p(boolean z) {
        this.gb = z;
    }

    @Override // com.ss.android.g.z.g.z
    public boolean p() {
        return this.oq;
    }

    public void fv(boolean z) {
        this.oq = z;
    }

    public void js(boolean z) {
        this.wj = z;
    }

    public void tb(boolean z) {
        this.z = z;
    }

    public void q(boolean z) {
        this.g = z;
    }

    public boolean rv() {
        return this.yz;
    }

    public void iq(boolean z) {
        this.yz = z;
    }

    public String tc() {
        return this.bm;
    }

    public void v(String str) {
        this.bm = str;
    }

    public long me() {
        return this.sd;
    }

    public void uy(long j) {
        this.sd = j;
    }

    public void kb(long j) {
        this.jq = j;
    }

    public void wp(long j) {
        this.sv = j;
    }

    public JSONObject nh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.m);
            jSONObject.put("mExtValue", this.e);
            jSONObject.put("mLogExtra", this.gz);
            jSONObject.put("mDownloadStatus", this.fo);
            jSONObject.put("mPackageName", this.uy);
            jSONObject.put("mIsAd", this.q);
            jSONObject.put("mTimeStamp", this.iq);
            jSONObject.put("mExtras", this.zw);
            jSONObject.put("mVersionCode", this.p);
            jSONObject.put("mVersionName", this.fv);
            jSONObject.put("mDownloadId", this.io);
            jSONObject.put("mIsV3Event", this.j);
            jSONObject.put("mScene", this.t);
            jSONObject.put("mEventTag", this.na);
            jSONObject.put("mEventRefer", this.xl);
            jSONObject.put("mDownloadUrl", this.kb);
            jSONObject.put("mEnableBackDialog", this.uf);
            jSONObject.put("hasSendInstallFinish", this.dl.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.f2024a.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.gc.get());
            jSONObject.put("mLastFailedErrCode", this.lq);
            jSONObject.put("mLastFailedErrMsg", this.mc);
            jSONObject.put("mOpenUrl", this.wp);
            jSONObject.put("mLinkMode", this.pf);
            jSONObject.put("mDownloadMode", this.ls);
            jSONObject.put("mModelType", this.v);
            jSONObject.put("mAppName", this.js);
            jSONObject.put("mAppIcon", this.tb);
            jSONObject.put("mDownloadFailedTimes", this.sy);
            long j = this.l;
            if (j == 0) {
                j = this.iq;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.hh);
            jSONObject.put("mJumpInstallTime", this.h);
            jSONObject.put("mCancelInstallTime", this.gk);
            jSONObject.put("mLastFailedResumeCount", this.x);
            jSONObject.put("mIsUpdateDownload", this.un);
            jSONObject.put("mOriginMimeType", this.ti);
            jSONObject.put("mIsPatchApplyHandled", this.eo);
            jSONObject.put("downloadFinishReason", this.f);
            jSONObject.put("clickDownloadTime", this.y);
            jSONObject.put("clickDownloadSize", this.ec);
            jSONObject.put("installAfterCleanSpace", this.gp);
            jSONObject.put("funnelType", this.vm);
            jSONObject.put("webUrl", this.i);
            jSONObject.put("enableShowComplianceDialog", this.bv);
            jSONObject.put("isAutoDownloadOnCardShow", this.gb);
            int i = 1;
            jSONObject.put("enable_new_activity", this.oq ? 1 : 0);
            jSONObject.put("enable_pause", this.wj ? 1 : 0);
            jSONObject.put("enable_ah", this.z ? 1 : 0);
            if (!this.g) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.yz));
            jSONObject.put("task_key", this.bm);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.sd));
            jSONObject.putOpt("download_pause_timestamp", Long.valueOf(this.jq));
            jSONObject.putOpt("download_finish_timestamp", Long.valueOf(this.sv));
        } catch (Exception e) {
            wp.tb().z(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public static g g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        try {
            gVar.a(com.ss.android.z.z.m.g.z(jSONObject, "mId"));
            gVar.gc(com.ss.android.z.z.m.g.z(jSONObject, "mExtValue"));
            gVar.dl(jSONObject.optString("mLogExtra"));
            gVar.gc(jSONObject.optInt("mDownloadStatus"));
            gVar.g(jSONObject.optString("mPackageName"));
            boolean z = true;
            gVar.z(jSONObject.optBoolean("mIsAd", true));
            gVar.m(com.ss.android.z.z.m.g.z(jSONObject, "mTimeStamp"));
            gVar.m(jSONObject.optInt("mVersionCode"));
            gVar.a(jSONObject.optString("mVersionName"));
            gVar.e(jSONObject.optInt("mDownloadId"));
            gVar.g(jSONObject.optBoolean("mIsV3Event"));
            gVar.gz(jSONObject.optInt("mScene"));
            gVar.m(jSONObject.optString("mEventTag"));
            gVar.e(jSONObject.optString("mEventRefer"));
            gVar.gz(jSONObject.optString("mDownloadUrl"));
            gVar.dl(jSONObject.optBoolean("mEnableBackDialog"));
            gVar.dl.set(jSONObject.optBoolean("hasSendInstallFinish"));
            gVar.f2024a.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            gVar.gc.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            gVar.a(jSONObject.optInt("mLastFailedErrCode"));
            gVar.z(jSONObject.optString("mLastFailedErrMsg"));
            gVar.fo(jSONObject.optString("mOpenUrl"));
            gVar.uy(jSONObject.optInt("mLinkMode"));
            gVar.kb(jSONObject.optInt("mDownloadMode"));
            gVar.wp(jSONObject.optInt("mModelType"));
            gVar.uy(jSONObject.optString("mAppName"));
            gVar.kb(jSONObject.optString("mAppIcon"));
            gVar.z(jSONObject.optInt("mDownloadFailedTimes", 0));
            gVar.z(com.ss.android.z.z.m.g.z(jSONObject, "mRecentDownloadResumeTime"));
            gVar.g(jSONObject.optInt("mClickPauseTimes"));
            gVar.g(com.ss.android.z.z.m.g.z(jSONObject, "mJumpInstallTime"));
            gVar.dl(com.ss.android.z.z.m.g.z(jSONObject, "mCancelInstallTime"));
            gVar.dl(jSONObject.optInt("mLastFailedResumeCount"));
            gVar.wp(jSONObject.optString("downloadFinishReason"));
            gVar.fo(jSONObject.optLong("clickDownloadSize"));
            gVar.gz(jSONObject.optLong("clickDownloadTime"));
            gVar.gz(jSONObject.optBoolean("mIsUpdateDownload"));
            gVar.i(jSONObject.optString("mOriginMimeType"));
            gVar.fo(jSONObject.optBoolean("mIsPatchApplyHandled"));
            gVar.m(jSONObject.optBoolean("installAfterCleanSpace"));
            gVar.fo(jSONObject.optInt("funnelType", 1));
            gVar.gc(jSONObject.optString("webUrl"));
            gVar.ls(jSONObject.optBoolean("enableShowComplianceDialog", true));
            gVar.p(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            gVar.fv(jSONObject.optInt("enable_new_activity", 1) == 1);
            gVar.js(jSONObject.optInt("enable_pause", 1) == 1);
            gVar.tb(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            gVar.q(z);
            gVar.z(jSONObject.optJSONObject("mExtras"));
            gVar.iq(jSONObject.optBoolean("intent_jump_browser_success"));
            gVar.v(jSONObject.optString("task_key"));
            gVar.uy(jSONObject.optLong("market_install_finish_check_start_timestamp"));
            gVar.kb(jSONObject.optLong("download_pause_timestamp", 0L));
            gVar.wp(jSONObject.optLong("download_finish_timestamp", 0L));
        } catch (Exception e) {
            wp.tb().z(e, "NativeDownloadModel fromJson");
        }
        return gVar;
    }

    @Override // com.ss.android.g.z.g.z
    public dl q() {
        return r();
    }

    @Override // com.ss.android.g.z.g.z
    public com.ss.android.z.z.dl.g iq() {
        return yz();
    }

    @Override // com.ss.android.g.z.g.z
    public com.ss.android.z.z.dl.z zw() {
        return bm();
    }

    public com.ss.android.g.z.z.dl r() {
        return new dl.z().g(this.m).a(this.e).g(this.gz).dl(this.uy).z(this.zw).z(this.q).g(this.p).kb(this.fv).gc(this.kb).z(this.v).gz(this.ti).e(this.js).a(this.tb).v(this.bm).z(new com.ss.android.z.z.gc.g(this.wp, this.i, null)).z();
    }

    public com.ss.android.g.z.z.g yz() {
        return new g.z().z(this.na).uy(this.xl).dl(this.j).z();
    }

    public com.ss.android.g.z.z.z bm() {
        return new z.C0450z().z(this.uf).z(this.pf).g(this.ls).gc(this.bv).gz(this.z).fo(this.g).z();
    }
}
