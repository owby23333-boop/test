package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ExecutorGroup;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    private long a;
    private int al;
    private String b;
    private long cd;
    private boolean df;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18071e;
    private boolean fb;
    private String fu;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AbsNotificationItem f18072g;
    private IRetryDelayTimeCalculator gm;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18073h;
    private int[] he;
    private List<String> hj;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IDownloadFileUriProvider f18074i;
    private String jq;
    private String km;
    private String ko;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private IChunkAdjustCalculator f18076l;
    private String lc;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private IChunkCntCalculator f18077m;
    private Activity mb;
    private boolean nf;
    private boolean ng;
    private IDownloadListener nk;
    private boolean nq;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private IDownloadListener f18079o;
    private String on;
    private IDownloadDiskSpaceHandler ot;
    private Context ox;
    private IDownloadMonitorDepend pa;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f18080q;
    private JSONObject qa;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f18081r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f18082s;
    private INotificationClickCallback sa;
    private boolean sr;
    private boolean sw;
    private String tl;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f18083u;
    private int up;
    private boolean wn;
    private List<HttpHeader> ww;
    private int xa;
    private IDownloadDepend yr;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.ss.android.socialbase.appdownloader.b.h f18086z;
    private boolean lz = true;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f18085x = false;
    private boolean jb = true;
    private boolean je = false;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private String f18075io = AdBaseConstants.MIME_APK;
    private int ge = 5;
    private boolean ep = true;
    private EnqueueType bv = EnqueueType.ENQUEUE_NONE;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f18084w = TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO;
    private boolean vy = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List<IDownloadCompleteHandler> f18078n = new ArrayList();
    private boolean kk = true;
    private boolean kg = true;

    public u(@NonNull Context context, @NonNull String str) {
        this.ox = context.getApplicationContext();
        this.b = str;
    }

    public String a() {
        return this.fu;
    }

    public String al() {
        return this.f18083u;
    }

    public String b() {
        return this.ko;
    }

    public EnqueueType bv() {
        return this.bv;
    }

    public boolean cd() {
        return this.kk;
    }

    public long df() {
        return this.a;
    }

    public boolean e() {
        return this.df;
    }

    public boolean ep() {
        return this.wn;
    }

    public boolean fb() {
        return this.sr;
    }

    public int fu() {
        return this.al;
    }

    public String g() {
        return this.jq;
    }

    public boolean ge() {
        return this.sw;
    }

    public Activity getActivity() {
        return this.mb;
    }

    public Context getContext() {
        return this.ox;
    }

    public String gm() {
        return this.on;
    }

    public boolean h() {
        return this.lz;
    }

    public List<HttpHeader> hj() {
        return this.ww;
    }

    public INotificationClickCallback i() {
        return this.sa;
    }

    public IChunkAdjustCalculator io() {
        return this.f18076l;
    }

    public String jb() {
        return this.lc;
    }

    public String je() {
        return this.f18075io;
    }

    public boolean jq() {
        return this.nf;
    }

    public JSONObject kg() {
        return this.qa;
    }

    public IDownloadDiskSpaceHandler kk() {
        return this.ot;
    }

    public boolean ko() {
        return this.jb;
    }

    public boolean l() {
        return this.f18081r;
    }

    public IChunkCntCalculator lc() {
        return this.f18077m;
    }

    public IDownloadListener lz() {
        return this.nk;
    }

    public int m() {
        return this.up;
    }

    public String mb() {
        return this.b;
    }

    public int[] n() {
        return this.he;
    }

    public int nf() {
        return this.f18084w;
    }

    public boolean ng() {
        return this.ep;
    }

    public boolean nk() {
        return this.f18071e;
    }

    public List<String> nq() {
        return this.hj;
    }

    public AbsNotificationItem o() {
        return this.f18072g;
    }

    public int on() {
        return this.xa;
    }

    public List<IDownloadCompleteHandler> ot() {
        return this.f18078n;
    }

    public String ox() {
        return this.f18073h;
    }

    public IDownloadDepend pa() {
        return this.yr;
    }

    public boolean q() {
        return this.fb;
    }

    public boolean qa() {
        return this.kg;
    }

    public int r() {
        return this.ge;
    }

    public boolean s() {
        return this.nq;
    }

    public int sa() {
        return this.f18082s;
    }

    public long sr() {
        return this.cd;
    }

    public boolean sw() {
        return this.f18080q;
    }

    public String tl() {
        return this.km;
    }

    public boolean u() {
        return this.f18085x;
    }

    public String up() {
        return this.tl;
    }

    public IDownloadMonitorDepend vy() {
        return this.pa;
    }

    public boolean w() {
        return this.ng;
    }

    public boolean wn() {
        return this.vy;
    }

    public boolean ww() {
        return this.je;
    }

    public IDownloadListener x() {
        return this.f18079o;
    }

    public IRetryDelayTimeCalculator xa() {
        return this.gm;
    }

    public com.ss.android.socialbase.appdownloader.b.h yr() {
        return this.f18086z;
    }

    public IDownloadFileUriProvider z() {
        return this.f18074i;
    }

    public u b(@NonNull String str) {
        this.ko = str;
        return this;
    }

    public u h(String str) {
        this.f18075io = str;
        return this;
    }

    public u hj(String str) {
        this.lc = str;
        return this;
    }

    public u io(boolean z2) {
        this.kk = z2;
        return this;
    }

    public u jb(boolean z2) {
        this.wn = z2;
        return this;
    }

    public u je(boolean z2) {
        this.f18080q = z2;
        return this;
    }

    public u ko(String str) {
        this.jq = str;
        return this;
    }

    public u lc(boolean z2) {
        this.nq = z2;
        return this;
    }

    public u lz(boolean z2) {
        this.ep = z2;
        return this;
    }

    public void mb(int i2) {
        this.up = i2;
    }

    public u nk(boolean z2) {
        this.vy = z2;
        return this;
    }

    public u o(boolean z2) {
        this.ng = z2;
        return this;
    }

    public u ox(String str) {
        this.f18083u = str;
        return this;
    }

    public u u(boolean z2) {
        this.f18081r = z2;
        return this;
    }

    public u ww(String str) {
        this.fu = str;
        return this;
    }

    public u x(boolean z2) {
        this.sw = z2;
        return this;
    }

    public u b(boolean z2) {
        this.je = z2;
        return this;
    }

    public u h(boolean z2) {
        this.df = z2;
        return this;
    }

    public u hj(boolean z2) {
        this.f18071e = z2;
        return this;
    }

    public u ko(boolean z2) {
        this.nf = z2;
        return this;
    }

    public u lz(String str) {
        this.km = str;
        return this;
    }

    public u mb(String str) {
        this.f18073h = str;
        return this;
    }

    public u ox(boolean z2) {
        this.f18085x = z2;
        return this;
    }

    public u u(String str) {
        this.on = str;
        return this;
    }

    public u ww(boolean z2) {
        this.fb = z2;
        return this;
    }

    public u x(String str) {
        this.tl = str;
        return this;
    }

    public u b(int i2) {
        this.xa = i2;
        return this;
    }

    public u h(int i2) {
        this.al = i2;
        return this;
    }

    public u hj(int i2) {
        this.f18084w = i2;
        return this;
    }

    public u mb(List<HttpHeader> list) {
        this.ww = list;
        return this;
    }

    public u ox(int i2) {
        this.ge = i2;
        return this;
    }

    public u u(@ExecutorGroup int i2) {
        this.f18082s = i2;
        return this;
    }

    public u mb(boolean z2) {
        this.lz = z2;
        return this;
    }

    public u ox(List<String> list) {
        this.hj = list;
        return this;
    }

    public u mb(IDownloadListener iDownloadListener) {
        this.nk = iDownloadListener;
        return this;
    }

    public u mb(long j2) {
        this.a = j2;
        return this;
    }

    public u mb(EnqueueType enqueueType) {
        this.bv = enqueueType;
        return this;
    }

    public u mb(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.f18074i = iDownloadFileUriProvider;
        return this;
    }

    public u mb(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.ot = iDownloadDiskSpaceHandler;
        return this;
    }

    public u mb(JSONObject jSONObject) {
        this.qa = jSONObject;
        return this;
    }

    public u mb(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.f18078n) {
            if (iDownloadCompleteHandler != null) {
                if (!this.f18078n.contains(iDownloadCompleteHandler)) {
                    this.f18078n.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }
}
