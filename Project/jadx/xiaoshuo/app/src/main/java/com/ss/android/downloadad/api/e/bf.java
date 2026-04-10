package com.ss.android.downloadad.api.e;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.wu;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class bf implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7221b;
    protected boolean bf;
    private int bh;
    private String bm;
    private boolean bx;
    private int cv;
    public final AtomicBoolean d;
    private boolean dt;
    protected boolean e;
    private boolean em;
    private boolean ev;
    private String f;
    private String fl;
    private long ft;
    private long fy;
    private boolean g;
    private long ga;
    private int h;
    private String hb;
    private boolean i;
    private boolean j;
    private String k;
    private String l;
    private int lc;
    private String m;
    private long n;
    private boolean nt;
    private long ot;
    private transient boolean ov;
    private String p;
    private long pe;
    private String q;
    private boolean r;

    @AdBaseConstants.FunnelType
    private int rb;
    private boolean rm;
    private String rt;
    private int s;
    private int t;
    public final AtomicBoolean tg;
    private String tx;
    private boolean ue;
    private long uk;
    private boolean uq;
    private int v;
    private long vn;
    private boolean vs;
    private boolean vu;
    private int w;
    private boolean wl;
    private String wu;
    private int x;
    private String xu;
    private JSONObject y;
    private boolean ya;
    private boolean yf;
    private int yl;
    private boolean z;
    private int za;
    private String zk;

    private bf() {
        this.v = 1;
        this.dt = true;
        this.wl = false;
        this.za = 0;
        this.lc = 0;
        this.bx = false;
        this.f7221b = false;
        this.r = true;
        this.rm = true;
        this.e = true;
        this.bf = true;
        this.d = new AtomicBoolean(false);
        this.tg = new AtomicBoolean(false);
        this.rb = 1;
        this.nt = true;
        this.ft = -1L;
    }

    public synchronized void a() {
        this.lc++;
    }

    public int b() {
        return this.w;
    }

    public void bf(int i) {
        this.lc = i;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public boolean bh() {
        return this.j;
    }

    public long bm() {
        return this.pe;
    }

    public int bx() {
        return this.v;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public DownloadController cv() {
        return zb();
    }

    public void d(long j) {
        this.fy = j;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public int dt() {
        return -1;
    }

    public void e(int i) {
        this.za = i;
    }

    public String em() {
        return this.tx;
    }

    public boolean ev() {
        return this.em;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public JSONObject f() {
        return null;
    }

    public boolean fl() {
        return this.bx;
    }

    public boolean ft() {
        return this.vu;
    }

    public long fy() {
        return this.uk;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.ga);
            jSONObject.put("mExtValue", this.vn);
            jSONObject.put("mLogExtra", this.p);
            jSONObject.put("mDownloadStatus", this.v);
            jSONObject.put("mPackageName", this.zk);
            jSONObject.put("mIsAd", this.dt);
            jSONObject.put("mTimeStamp", this.pe);
            jSONObject.put("mExtras", this.y);
            jSONObject.put("mVersionCode", this.w);
            jSONObject.put("mVersionName", this.l);
            jSONObject.put("mDownloadId", this.cv);
            jSONObject.put("mIsV3Event", this.j);
            jSONObject.put("mScene", this.yl);
            jSONObject.put("mEventTag", this.q);
            jSONObject.put("mEventRefer", this.rt);
            jSONObject.put("mDownloadUrl", this.m);
            jSONObject.put("mEnableBackDialog", this.wl);
            jSONObject.put("hasSendInstallFinish", this.d.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.tg.get());
            jSONObject.put("mLastFailedErrCode", this.x);
            jSONObject.put("mLastFailedErrMsg", this.hb);
            jSONObject.put("mOpenUrl", this.wu);
            jSONObject.put("mLinkMode", this.t);
            jSONObject.put("mDownloadMode", this.s);
            jSONObject.put("mModelType", this.bh);
            jSONObject.put("mAppName", this.f);
            jSONObject.put("mAppIcon", this.k);
            jSONObject.put("mDownloadFailedTimes", this.za);
            long j = this.f7220a;
            if (j == 0) {
                j = this.pe;
            }
            jSONObject.put("mRecentDownloadResumeTime", j);
            jSONObject.put("mClickPauseTimes", this.lc);
            jSONObject.put("mJumpInstallTime", this.uk);
            jSONObject.put("mCancelInstallTime", this.fy);
            jSONObject.put("mLastFailedResumeCount", this.h);
            jSONObject.put("mIsUpdateDownload", this.bx);
            jSONObject.put("mOriginMimeType", this.bm);
            jSONObject.put("mIsPatchApplyHandled", this.f7221b);
            jSONObject.put("downloadFinishReason", this.fl);
            jSONObject.put("clickDownloadTime", this.ot);
            jSONObject.put("clickDownloadSize", this.n);
            jSONObject.put("installAfterCleanSpace", this.i);
            jSONObject.put("funnelType", this.rb);
            jSONObject.put("webUrl", this.xu);
            jSONObject.put("enableShowComplianceDialog", this.nt);
            jSONObject.put("isAutoDownloadOnCardShow", this.ya);
            int i = 1;
            jSONObject.put("enable_new_activity", this.r ? 1 : 0);
            jSONObject.put("enable_pause", this.rm ? 1 : 0);
            jSONObject.put("enable_ah", this.e ? 1 : 0);
            if (!this.bf) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.g));
            jSONObject.put("task_key", this.tx);
        } catch (Exception e) {
            wu.dt().e(e, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public void ga(long j) {
        this.vn = j;
    }

    public int h() {
        return this.h;
    }

    public String hb() {
        return this.hb;
    }

    public int i() {
        return this.t;
    }

    public String j() {
        return this.f;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public int k() {
        return this.cv;
    }

    public void l(boolean z) {
        this.ya = z;
    }

    public int lc() {
        return this.lc;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public String m() {
        return this.q;
    }

    public boolean n() {
        return this.ue;
    }

    public long nt() {
        return this.ot;
    }

    public boolean ot() {
        return this.i;
    }

    public boolean ov() {
        return this.ev;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public JSONObject p() {
        return this.y;
    }

    public void pe(boolean z) {
        this.bf = z;
    }

    public AdDownloadEventConfig pl() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.q).setRefer(this.rt).setIsEnableV3Event(this.j).build();
    }

    public boolean q() {
        return this.wl;
    }

    public String r() {
        return this.l;
    }

    public boolean rb() {
        return this.yf;
    }

    public int rm() {
        return this.yl;
    }

    public long rt() {
        return this.ft;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public Object s() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public List<String> t() {
        return null;
    }

    public void tg(int i) {
        this.x = i;
    }

    public AdDownloadModel tx() {
        return new AdDownloadModel.Builder().setAdId(this.ga).setExtraValue(this.vn).setLogExtra(this.p).setPackageName(this.zk).setExtra(this.y).setIsAd(this.dt).setVersionCode(this.w).setVersionName(this.l).setDownloadUrl(this.m).setModelType(this.bh).setMimeType(this.bm).setAppName(this.f).setAppIcon(this.k).setTaskKey(this.tx).setDeepLink(new DeepLink(this.wu, this.xu, null)).build();
    }

    public boolean ue() {
        return this.ov;
    }

    public long uk() {
        long j = this.f7220a;
        return j == 0 ? this.pe : j;
    }

    public String uq() {
        return this.bm;
    }

    public void v(int i) {
        this.yl = i;
    }

    public void vn(long j) {
        if (j > 0) {
            this.pe = j;
        }
    }

    public boolean vs() {
        return this.g;
    }

    public boolean vu() {
        return this.z;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public JSONObject w() {
        return null;
    }

    public int wl() {
        return this.za;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public JSONObject wu() {
        return null;
    }

    public int x() {
        return this.x;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public long xu() {
        return this.vn;
    }

    public void y(boolean z) {
        this.g = z;
    }

    public long ya() {
        return this.n;
    }

    public boolean yf() {
        return this.f7221b;
    }

    public String yl() {
        return this.fl;
    }

    public boolean z() {
        return this.vs;
    }

    public synchronized void za() {
        this.za++;
    }

    public AdDownloadController zb() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.wl).setLinkMode(this.t).setDownloadMode(this.s).setEnableShowComplianceDialog(this.nt).setEnableAH(this.e).setEnableAM(this.bf).build();
    }

    public void zk(int i) {
        this.rb = i;
    }

    public void bf(long j) {
        this.uk = j;
    }

    public void bh(String str) {
        this.bm = str;
    }

    public void d(int i) {
        this.h = i;
    }

    public void dt(boolean z) {
        this.e = z;
    }

    public void e(long j) {
        this.f7220a = j;
    }

    public void f(boolean z) {
        this.r = z;
    }

    public void ga(int i) {
        this.v = i;
    }

    public void k(boolean z) {
        this.rm = z;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public boolean l() {
        return this.r;
    }

    public void m(String str) {
        this.f = str;
    }

    public void p(int i) {
        this.cv = i;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public DownloadModel pe() {
        return tx();
    }

    public void s(boolean z) {
        this.em = z;
    }

    public void t(boolean z) {
        this.vs = z;
    }

    public void tg(long j) {
        this.ga = j;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public int v() {
        return this.rb;
    }

    public void vn(int i) {
        this.w = i;
    }

    public void w(boolean z) {
        this.nt = z;
    }

    public void wu(String str) {
        this.k = str;
    }

    public void xu(int i) {
        this.bh = i;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public DownloadEventConfig y() {
        return pl();
    }

    @Override // com.ss.android.downloadad.api.e.e
    public String zk() {
        return this.rt;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public long bf() {
        return this.ga;
    }

    public void bh(boolean z) {
        this.z = z;
    }

    public void d(String str) {
        this.p = str;
    }

    public void e(String str) {
        this.hb = str;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public String ga() {
        return this.zk;
    }

    public void m(int i) {
        this.t = i;
    }

    public void p(String str) {
        this.rt = str;
    }

    public void t(String str) {
        this.tx = str;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public String tg() {
        return this.p;
    }

    public void v(String str) {
        this.m = str;
    }

    public void vn(String str) {
        this.q = str;
    }

    public void wu(int i) {
        this.s = i;
    }

    public void xu(String str) {
        this.fl = str;
    }

    public void zk(String str) {
        this.wu = str;
    }

    public void bf(String str) {
        this.zk = str;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public boolean d() {
        return this.dt;
    }

    public void e(boolean z) {
        this.dt = z;
    }

    public void ga(String str) {
        this.xu = str;
    }

    public void m(boolean z) {
        this.ov = z;
    }

    public void p(long j) {
        this.ft = j;
    }

    public void tg(String str) {
        this.l = str;
    }

    public void v(long j) {
        this.ot = j;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public String vn() {
        return this.wu;
    }

    public void wu(boolean z) {
        this.vu = z;
    }

    public void xu(boolean z) {
        this.ev = z;
    }

    public void zk(long j) {
        this.n = j;
    }

    public void bf(boolean z) {
        this.j = z;
    }

    public void d(boolean z) {
        this.wl = z;
    }

    public void e(JSONObject jSONObject) {
        this.y = jSONObject;
    }

    public void ga(boolean z) {
        this.yf = z;
    }

    public void p(boolean z) {
        this.ue = z;
    }

    public void tg(boolean z) {
        this.uq = z;
    }

    public void v(boolean z) {
        this.bx = z;
    }

    public void vn(boolean z) {
        this.i = z;
    }

    public void zk(boolean z) {
        this.f7221b = z;
    }

    public static bf bf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bf bfVar = new bf();
        try {
            bfVar.tg(com.ss.android.download.api.d.bf.e(jSONObject, "mId"));
            bfVar.ga(com.ss.android.download.api.d.bf.e(jSONObject, "mExtValue"));
            bfVar.d(jSONObject.optString("mLogExtra"));
            bfVar.ga(jSONObject.optInt("mDownloadStatus"));
            bfVar.bf(jSONObject.optString("mPackageName"));
            boolean z = true;
            bfVar.e(jSONObject.optBoolean("mIsAd", true));
            bfVar.vn(com.ss.android.download.api.d.bf.e(jSONObject, "mTimeStamp"));
            bfVar.vn(jSONObject.optInt("mVersionCode"));
            bfVar.tg(jSONObject.optString("mVersionName"));
            bfVar.p(jSONObject.optInt("mDownloadId"));
            bfVar.bf(jSONObject.optBoolean("mIsV3Event"));
            bfVar.v(jSONObject.optInt("mScene"));
            bfVar.vn(jSONObject.optString("mEventTag"));
            bfVar.p(jSONObject.optString("mEventRefer"));
            bfVar.v(jSONObject.optString("mDownloadUrl"));
            bfVar.d(jSONObject.optBoolean("mEnableBackDialog"));
            bfVar.d.set(jSONObject.optBoolean("hasSendInstallFinish"));
            bfVar.tg.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            bfVar.tg(jSONObject.optInt("mLastFailedErrCode"));
            bfVar.e(jSONObject.optString("mLastFailedErrMsg"));
            bfVar.zk(jSONObject.optString("mOpenUrl"));
            bfVar.m(jSONObject.optInt("mLinkMode"));
            bfVar.wu(jSONObject.optInt("mDownloadMode"));
            bfVar.xu(jSONObject.optInt("mModelType"));
            bfVar.m(jSONObject.optString("mAppName"));
            bfVar.wu(jSONObject.optString("mAppIcon"));
            bfVar.e(jSONObject.optInt("mDownloadFailedTimes", 0));
            bfVar.e(com.ss.android.download.api.d.bf.e(jSONObject, "mRecentDownloadResumeTime"));
            bfVar.bf(jSONObject.optInt("mClickPauseTimes"));
            bfVar.bf(com.ss.android.download.api.d.bf.e(jSONObject, "mJumpInstallTime"));
            bfVar.d(com.ss.android.download.api.d.bf.e(jSONObject, "mCancelInstallTime"));
            bfVar.d(jSONObject.optInt("mLastFailedResumeCount"));
            bfVar.xu(jSONObject.optString("downloadFinishReason"));
            bfVar.zk(jSONObject.optLong("clickDownloadSize"));
            bfVar.v(jSONObject.optLong("clickDownloadTime"));
            bfVar.v(jSONObject.optBoolean("mIsUpdateDownload"));
            bfVar.bh(jSONObject.optString("mOriginMimeType"));
            bfVar.zk(jSONObject.optBoolean("mIsPatchApplyHandled"));
            bfVar.vn(jSONObject.optBoolean("installAfterCleanSpace"));
            bfVar.zk(jSONObject.optInt("funnelType", 1));
            bfVar.ga(jSONObject.optString("webUrl"));
            bfVar.w(jSONObject.optBoolean("enableShowComplianceDialog", true));
            bfVar.l(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            bfVar.f(jSONObject.optInt("enable_new_activity", 1) == 1);
            bfVar.k(jSONObject.optInt("enable_pause", 1) == 1);
            bfVar.dt(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            bfVar.pe(z);
            bfVar.e(jSONObject.optJSONObject("mExtras"));
            bfVar.y(jSONObject.optBoolean("intent_jump_browser_success"));
            bfVar.t(jSONObject.optString("task_key"));
        } catch (Exception e) {
            wu.dt().e(e, "NativeDownloadModel fromJson");
        }
        return bfVar;
    }

    @Override // com.ss.android.downloadad.api.e.e
    public String e() {
        return this.m;
    }

    public bf(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public bf(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.v = 1;
        this.dt = true;
        this.wl = false;
        this.za = 0;
        this.lc = 0;
        this.bx = false;
        this.f7221b = false;
        this.r = true;
        this.rm = true;
        this.e = true;
        this.bf = true;
        this.d = new AtomicBoolean(false);
        this.tg = new AtomicBoolean(false);
        this.rb = 1;
        this.nt = true;
        this.ft = -1L;
        this.ga = downloadModel.getId();
        this.vn = downloadModel.getExtraValue();
        this.p = downloadModel.getLogExtra();
        this.zk = downloadModel.getPackageName();
        this.y = downloadModel.getExtra();
        this.dt = downloadModel.isAd();
        this.w = downloadModel.getVersionCode();
        this.l = downloadModel.getVersionName();
        this.m = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.wu = downloadModel.getDeepLink().getOpenUrl();
            this.xu = downloadModel.getDeepLink().getWebUrl();
        }
        this.bh = downloadModel.getModelType();
        this.f = downloadModel.getName();
        this.k = downloadModel.getAppIcon();
        this.bm = downloadModel.getMimeType();
        this.q = downloadEventConfig.getClickButtonTag();
        this.rt = downloadEventConfig.getRefer();
        this.j = downloadEventConfig.isEnableV3Event();
        this.wl = downloadController.isEnableBackDialog();
        this.t = downloadController.getLinkMode();
        this.s = downloadController.getDownloadMode();
        this.nt = downloadController.enableShowComplianceDialog();
        this.ya = downloadController.isAutoDownloadOnCardShow();
        this.r = downloadController.enableNewActivity();
        this.e = downloadController.enableAH();
        this.bf = downloadController.enableAM();
        this.cv = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.pe = jCurrentTimeMillis;
        this.f7220a = jCurrentTimeMillis;
        this.f7221b = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.tx = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
