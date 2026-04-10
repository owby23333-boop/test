package com.ss.android.downloadad.api.mb;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.x;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements mb {
    private int a;
    private String al;
    public final AtomicBoolean b;
    private boolean bv;
    private long cd;
    private JSONObject df;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17963e;
    private String ep;
    private long fb;
    private int fu;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f17964g;
    private long ge;
    private boolean gm;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f17965h;
    private boolean he;
    public final AtomicBoolean hj;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @AdBaseConstants.FunnelType
    private int f17966i;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private int f17967io;
    private String jb;
    private String je;
    private int jq;
    private boolean kg;
    private boolean kk;
    private boolean km;
    private String ko;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f17968l;
    private int lc;
    private String lz;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f17969m;
    protected boolean mb;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17970n;
    private int nf;
    private long ng;
    private int nk;
    private boolean nq;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f17971o;
    private boolean on;
    private long ot;
    protected boolean ox;
    private boolean pa;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f17972q;
    private String qa;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f17973r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f17974s;
    private boolean sa;
    private boolean sr;
    private boolean sw;
    private boolean tl;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f17975u;
    private transient boolean up;
    private String vy;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f17976w;
    private String wn;
    private int ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private String f17977x;
    private long xa;
    private boolean yr;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f17978z;

    private ox() {
        this.ww = 1;
        this.gm = true;
        this.on = false;
        this.jq = 0;
        this.a = 0;
        this.sw = false;
        this.f17972q = false;
        this.bv = true;
        this.f17976w = true;
        this.mb = true;
        this.ox = true;
        this.b = new AtomicBoolean(false);
        this.hj = new AtomicBoolean(false);
        this.f17966i = 1;
        this.sa = true;
        this.cd = -1L;
    }

    public int a() {
        return this.a;
    }

    public boolean al() {
        return this.on;
    }

    public void b(long j2) {
        this.xa = j2;
    }

    public String bv() {
        return this.f17963e;
    }

    public boolean cd() {
        return this.nq;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadEventConfig df() {
        return y();
    }

    public void e(boolean z2) {
        this.sr = z2;
    }

    public String ep() {
        return this.ep;
    }

    public boolean fb() {
        return this.f17974s;
    }

    public int fu() {
        return this.fu;
    }

    public void g(boolean z2) {
        this.ox = z2;
    }

    public long ge() {
        long j2 = this.ng;
        return j2 == 0 ? this.f17964g : j2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int gm() {
        return -1;
    }

    public void gm(boolean z2) {
        this.mb = z2;
    }

    public void h(long j2) {
        this.f17975u = j2;
    }

    public AdDownloadModel he() {
        return new AdDownloadModel.Builder().setAdId(this.f17965h).setExtraValue(this.f17975u).setLogExtra(this.ko).setPackageName(this.lz).setExtra(this.df).setIsAd(this.gm).setVersionCode(this.f17967io).setVersionName(this.f17963e).setDownloadUrl(this.f17977x).setModelType(this.nk).setMimeType(this.wn).setAppName(this.f17968l).setAppIcon(this.f17969m).setDeepLink(new DeepLink(this.jb, this.je, null)).build();
    }

    public void hj(int i2) {
        this.fu = i2;
    }

    public boolean i() {
        return this.f17970n;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject io() {
        return null;
    }

    public void io(boolean z2) {
        this.sa = z2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject jb() {
        return null;
    }

    public void jb(String str) {
        this.f17969m = str;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public long je() {
        return this.f17975u;
    }

    public AdDownloadController jm() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.on).setLinkMode(this.f17971o).setDownloadMode(this.lc).setEnableShowComplianceDialog(this.sa).setEnableAH(this.mb).setEnableAM(this.ox).build();
    }

    public synchronized void jq() {
        this.jq++;
    }

    public boolean kg() {
        return this.he;
    }

    public boolean kk() {
        return this.km;
    }

    public JSONObject km() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f17965h);
            jSONObject.put("mExtValue", this.f17975u);
            jSONObject.put("mLogExtra", this.ko);
            jSONObject.put("mDownloadStatus", this.ww);
            jSONObject.put("mPackageName", this.lz);
            jSONObject.put("mIsAd", this.gm);
            jSONObject.put("mTimeStamp", this.f17964g);
            jSONObject.put("mExtras", this.df);
            jSONObject.put("mVersionCode", this.f17967io);
            jSONObject.put("mVersionName", this.f17963e);
            jSONObject.put("mDownloadId", this.f17973r);
            jSONObject.put("mIsV3Event", this.pa);
            jSONObject.put("mScene", this.f17978z);
            jSONObject.put("mEventTag", this.al);
            jSONObject.put("mEventRefer", this.vy);
            jSONObject.put("mDownloadUrl", this.f17977x);
            jSONObject.put("mEnableBackDialog", this.on);
            jSONObject.put("hasSendInstallFinish", this.b.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.hj.get());
            jSONObject.put("mLastFailedErrCode", this.fu);
            jSONObject.put("mLastFailedErrMsg", this.ep);
            jSONObject.put("mOpenUrl", this.jb);
            jSONObject.put("mLinkMode", this.f17971o);
            jSONObject.put("mDownloadMode", this.lc);
            jSONObject.put("mModelType", this.nk);
            jSONObject.put("mAppName", this.f17968l);
            jSONObject.put("mAppIcon", this.f17969m);
            jSONObject.put("mDownloadFailedTimes", this.jq);
            jSONObject.put("mRecentDownloadResumeTime", this.ng == 0 ? this.f17964g : this.ng);
            jSONObject.put("mClickPauseTimes", this.a);
            jSONObject.put("mJumpInstallTime", this.ge);
            jSONObject.put("mCancelInstallTime", this.xa);
            jSONObject.put("mLastFailedResumeCount", this.nf);
            jSONObject.put("mIsUpdateDownload", this.sw);
            jSONObject.put("mOriginMimeType", this.wn);
            jSONObject.put("mIsPatchApplyHandled", this.f17972q);
            jSONObject.put("downloadFinishReason", this.qa);
            jSONObject.put("clickDownloadTime", this.ot);
            jSONObject.put("clickDownloadSize", this.fb);
            jSONObject.put("installAfterCleanSpace", this.yr);
            jSONObject.put("funnelType", this.f17966i);
            jSONObject.put("webUrl", this.je);
            jSONObject.put("enableShowComplianceDialog", this.sa);
            jSONObject.put("isAutoDownloadOnCardShow", this.sr);
            int i2 = 1;
            jSONObject.put("enable_new_activity", this.bv ? 1 : 0);
            jSONObject.put("enable_pause", this.f17976w ? 1 : 0);
            jSONObject.put("enable_ah", this.mb ? 1 : 0);
            if (!this.ox) {
                i2 = 0;
            }
            jSONObject.put("enable_am", i2);
        } catch (Exception e2) {
            x.m().mb(e2, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject ko() {
        return this.df;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject l() {
        return null;
    }

    public void l(boolean z2) {
        this.bv = z2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public Object lc() {
        return null;
    }

    public void lc(boolean z2) {
        this.he = z2;
    }

    public void lz(int i2) {
        this.f17966i = i2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int m() {
        return this.f17973r;
    }

    public void mb(int i2) {
        this.jq = i2;
    }

    public boolean n() {
        return this.f17972q;
    }

    public int nf() {
        return this.nf;
    }

    public synchronized void ng() {
        this.a++;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean nk() {
        return this.pa;
    }

    public boolean nq() {
        return this.kk;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public List<String> o() {
        return null;
    }

    public void o(boolean z2) {
        this.km = z2;
    }

    public int on() {
        return this.jq;
    }

    public boolean ot() {
        return this.yr;
    }

    public void ox(int i2) {
        this.a = i2;
    }

    public String pa() {
        return this.f17968l;
    }

    public int q() {
        return this.f17967io;
    }

    public boolean qa() {
        return this.sw;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadController r() {
        return jm();
    }

    public boolean s() {
        return this.up;
    }

    public long sa() {
        return this.ot;
    }

    public long sr() {
        return this.fb;
    }

    public int sw() {
        return this.ww;
    }

    public String tl() {
        return this.wn;
    }

    public void u(long j2) {
        if (j2 > 0) {
            this.f17964g = j2;
        }
    }

    public boolean up() {
        return this.kg;
    }

    public long vy() {
        return this.cd;
    }

    public int w() {
        return this.f17978z;
    }

    public long wn() {
        return this.f17964g;
    }

    public void ww(int i2) {
        this.f17978z = i2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String x() {
        return this.al;
    }

    public long xa() {
        return this.ge;
    }

    public AdDownloadEventConfig y() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.al).setRefer(this.vy).setIsEnableV3Event(this.pa).build();
    }

    public int yr() {
        return this.f17971o;
    }

    public String z() {
        return this.qa;
    }

    public void b(int i2) {
        this.nf = i2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean e() {
        return this.bv;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadModel g() {
        return he();
    }

    public void h(int i2) {
        this.ww = i2;
    }

    public void hj(long j2) {
        this.f17965h = j2;
    }

    public void jb(int i2) {
        this.lc = i2;
    }

    public void je(int i2) {
        this.nk = i2;
    }

    public void ko(int i2) {
        this.f17973r = i2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String lz() {
        return this.vy;
    }

    public void m(boolean z2) {
        this.f17976w = z2;
    }

    public void mb(long j2) {
        this.ng = j2;
    }

    public void nk(String str) {
        this.wn = str;
    }

    public void ox(long j2) {
        this.ge = j2;
    }

    public void u(int i2) {
        this.f17967io = i2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int ww() {
        return this.f17966i;
    }

    public void x(String str) {
        this.f17968l = str;
    }

    public void b(String str) {
        this.ko = str;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String h() {
        return this.lz;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String hj() {
        return this.ko;
    }

    public void jb(boolean z2) {
        this.nq = z2;
    }

    public void je(String str) {
        this.qa = str;
    }

    public void ko(String str) {
        this.vy = str;
    }

    public void lz(String str) {
        this.jb = str;
    }

    public void mb(String str) {
        this.ep = str;
    }

    public void nk(boolean z2) {
        this.kk = z2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public long ox() {
        return this.f17965h;
    }

    public void u(String str) {
        this.al = str;
    }

    public void ww(String str) {
        this.f17977x = str;
    }

    public void x(int i2) {
        this.f17971o = i2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean b() {
        return this.gm;
    }

    public void h(String str) {
        this.je = str;
    }

    public void hj(String str) {
        this.f17963e = str;
    }

    public void je(boolean z2) {
        this.kg = z2;
    }

    public void ko(long j2) {
        this.cd = j2;
    }

    public void lz(long j2) {
        this.fb = j2;
    }

    public void mb(boolean z2) {
        this.gm = z2;
    }

    public void ox(String str) {
        this.lz = str;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String u() {
        return this.jb;
    }

    public void ww(long j2) {
        this.ot = j2;
    }

    public void x(boolean z2) {
        this.up = z2;
    }

    public void b(boolean z2) {
        this.on = z2;
    }

    public void h(boolean z2) {
        this.f17970n = z2;
    }

    public void hj(boolean z2) {
        this.tl = z2;
    }

    public void ko(boolean z2) {
        this.f17974s = z2;
    }

    public void lz(boolean z2) {
        this.f17972q = z2;
    }

    public void mb(JSONObject jSONObject) {
        this.df = jSONObject;
    }

    public void ox(boolean z2) {
        this.pa = z2;
    }

    public void u(boolean z2) {
        this.yr = z2;
    }

    public void ww(boolean z2) {
        this.sw = z2;
    }

    public static ox ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ox oxVar = new ox();
        try {
            oxVar.hj(com.ss.android.download.api.b.ox.mb(jSONObject, "mId"));
            oxVar.h(com.ss.android.download.api.b.ox.mb(jSONObject, "mExtValue"));
            oxVar.b(jSONObject.optString("mLogExtra"));
            oxVar.h(jSONObject.optInt("mDownloadStatus"));
            oxVar.ox(jSONObject.optString("mPackageName"));
            boolean z2 = true;
            oxVar.mb(jSONObject.optBoolean("mIsAd", true));
            oxVar.u(com.ss.android.download.api.b.ox.mb(jSONObject, "mTimeStamp"));
            oxVar.u(jSONObject.optInt("mVersionCode"));
            oxVar.hj(jSONObject.optString("mVersionName"));
            oxVar.ko(jSONObject.optInt("mDownloadId"));
            oxVar.ox(jSONObject.optBoolean("mIsV3Event"));
            oxVar.ww(jSONObject.optInt("mScene"));
            oxVar.u(jSONObject.optString("mEventTag"));
            oxVar.ko(jSONObject.optString("mEventRefer"));
            oxVar.ww(jSONObject.optString("mDownloadUrl"));
            oxVar.b(jSONObject.optBoolean("mEnableBackDialog"));
            oxVar.b.set(jSONObject.optBoolean("hasSendInstallFinish"));
            oxVar.hj.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            oxVar.hj(jSONObject.optInt("mLastFailedErrCode"));
            oxVar.mb(jSONObject.optString("mLastFailedErrMsg"));
            oxVar.lz(jSONObject.optString("mOpenUrl"));
            oxVar.x(jSONObject.optInt("mLinkMode"));
            oxVar.jb(jSONObject.optInt("mDownloadMode"));
            oxVar.je(jSONObject.optInt("mModelType"));
            oxVar.x(jSONObject.optString("mAppName"));
            oxVar.jb(jSONObject.optString("mAppIcon"));
            oxVar.mb(jSONObject.optInt("mDownloadFailedTimes", 0));
            oxVar.mb(com.ss.android.download.api.b.ox.mb(jSONObject, "mRecentDownloadResumeTime"));
            oxVar.ox(jSONObject.optInt("mClickPauseTimes"));
            oxVar.ox(com.ss.android.download.api.b.ox.mb(jSONObject, "mJumpInstallTime"));
            oxVar.b(com.ss.android.download.api.b.ox.mb(jSONObject, "mCancelInstallTime"));
            oxVar.b(jSONObject.optInt("mLastFailedResumeCount"));
            oxVar.je(jSONObject.optString("downloadFinishReason"));
            oxVar.lz(jSONObject.optLong("clickDownloadSize"));
            oxVar.ww(jSONObject.optLong("clickDownloadTime"));
            oxVar.ww(jSONObject.optBoolean("mIsUpdateDownload"));
            oxVar.nk(jSONObject.optString("mOriginMimeType"));
            oxVar.lz(jSONObject.optBoolean("mIsPatchApplyHandled"));
            oxVar.u(jSONObject.optBoolean("installAfterCleanSpace"));
            oxVar.lz(jSONObject.optInt("funnelType", 1));
            oxVar.h(jSONObject.optString("webUrl"));
            oxVar.io(jSONObject.optBoolean("enableShowComplianceDialog", true));
            oxVar.e(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            oxVar.l(jSONObject.optInt("enable_new_activity", 1) == 1);
            oxVar.m(jSONObject.optInt("enable_pause", 1) == 1);
            oxVar.gm(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z2 = false;
            }
            oxVar.g(z2);
            oxVar.mb(jSONObject.optJSONObject("mExtras"));
        } catch (Exception e2) {
            x.m().mb(e2, "NativeDownloadModel fromJson");
        }
        return oxVar;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String mb() {
        return this.f17977x;
    }

    public ox(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public ox(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i2) {
        this.ww = 1;
        this.gm = true;
        this.on = false;
        this.jq = 0;
        this.a = 0;
        this.sw = false;
        this.f17972q = false;
        this.bv = true;
        this.f17976w = true;
        this.mb = true;
        this.ox = true;
        this.b = new AtomicBoolean(false);
        this.hj = new AtomicBoolean(false);
        this.f17966i = 1;
        this.sa = true;
        this.cd = -1L;
        this.f17965h = downloadModel.getId();
        this.f17975u = downloadModel.getExtraValue();
        this.ko = downloadModel.getLogExtra();
        this.lz = downloadModel.getPackageName();
        this.df = downloadModel.getExtra();
        this.gm = downloadModel.isAd();
        this.f17967io = downloadModel.getVersionCode();
        this.f17963e = downloadModel.getVersionName();
        this.f17977x = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.jb = downloadModel.getDeepLink().getOpenUrl();
            this.je = downloadModel.getDeepLink().getWebUrl();
        }
        this.nk = downloadModel.getModelType();
        this.f17968l = downloadModel.getName();
        this.f17969m = downloadModel.getAppIcon();
        this.wn = downloadModel.getMimeType();
        this.al = downloadEventConfig.getClickButtonTag();
        this.vy = downloadEventConfig.getRefer();
        this.pa = downloadEventConfig.isEnableV3Event();
        this.on = downloadController.isEnableBackDialog();
        this.f17971o = downloadController.getLinkMode();
        this.lc = downloadController.getDownloadMode();
        this.sa = downloadController.enableShowComplianceDialog();
        this.sr = downloadController.isAutoDownloadOnCardShow();
        this.bv = downloadController.enableNewActivity();
        this.mb = downloadController.enableAH();
        this.ox = downloadController.enableAM();
        this.f17973r = i2;
        this.f17964g = System.currentTimeMillis();
        this.ng = this.f17964g;
        this.f17972q = downloadModel.shouldDownloadWithPatchApply();
    }
}
