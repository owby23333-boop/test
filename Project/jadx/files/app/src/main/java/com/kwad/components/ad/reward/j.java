package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.g.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends com.kwad.components.core.j.a {
    public boolean fN;

    @NonNull
    public com.kwad.components.ad.reward.d.b mAdOpenInteractionListener;

    @NonNull
    public com.kwad.components.ad.reward.d.d mAdRewardStepListener;

    @Nullable
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    private Handler mHandler;
    public long mPageEnterTime;

    @Nullable
    public JSONObject mReportExtData;
    public boolean mRewardVerifyCalled;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bg mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;

    @Nullable
    public l pA;

    @Nullable
    public com.kwad.components.ad.i.b pB;

    @Nullable
    public com.kwad.components.ad.i.a pC;

    @Nullable
    public g pD;
    private final PriorityQueue<com.kwad.components.ad.reward.d.f> pE;
    public Set<com.kwad.components.ad.reward.d.e> pF;

    @Nullable
    private com.kwad.components.ad.reward.g.c pG;

    @Nullable
    private com.kwad.components.core.webview.a.d.a pH;

    @Nullable
    private e.a pI;

    @Nullable
    private e.b pJ;
    private boolean pK;
    private boolean pL;
    private boolean pM;
    public boolean pN;
    public boolean pO;
    public boolean pP;
    public boolean pQ;
    private boolean pR;
    public boolean pS;
    public boolean pT;
    public List<Integer> pU;

    @Nullable
    public com.kwad.components.ad.reward.k.o pV;
    public boolean pW;

    @Nullable
    private PlayableSource pX;
    private boolean pY;
    private List<DialogInterface.OnDismissListener> pZ;
    public DetailVideoView pv;

    @NonNull
    public com.kwad.components.ad.reward.j.b pw;

    @Nullable
    public IAdLiveOfflineView px;

    @Nullable
    public com.kwad.components.core.playable.a py;

    @NonNull
    public RewardActionBarControl pz;

    @Nullable
    public com.kwad.components.ad.reward.d.m qa;
    public boolean qb;

    @Nullable
    public com.kwad.components.ad.reward.i.a.a qc;

    @Nullable
    public com.kwad.components.ad.reward.i.kwai.a qd;
    public int qe;
    private int qf;
    public long qg;
    public long qh;
    public boolean qi;
    private boolean qj;
    private boolean qk;
    public boolean ql;
    public boolean qm;
    public boolean qn;

    @NonNull
    public LoadStrategy qo;
    private RewardRenderResult qp;
    private List<a> qq;
    private List<b> qr;
    private List<a.InterfaceC0399a> qs;

    public interface a {
        void gt();

        void gu();

        void gv();

        void gw();
    }

    public interface b {
        boolean interceptPlayCardResume();
    }

    public j(com.kwad.components.core.j.b<?> bVar) {
        super(bVar);
        this.pE = new PriorityQueue<>();
        this.pF = new HashSet();
        this.pK = false;
        this.pL = false;
        this.pM = false;
        this.pO = false;
        this.pP = false;
        this.pQ = false;
        this.pR = false;
        this.pS = false;
        this.mRewardVerifyCalled = false;
        this.pT = false;
        this.pU = new ArrayList();
        this.pW = false;
        this.pX = null;
        this.pY = false;
        this.pZ = new CopyOnWriteArrayList();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.qb = false;
        this.qf = 2;
        this.qj = false;
        this.qk = false;
        this.ql = false;
        this.qm = false;
        this.qn = false;
        this.qo = LoadStrategy.FULL_TK;
        this.qq = new CopyOnWriteArrayList();
        this.qr = new CopyOnWriteArrayList();
        this.qs = new CopyOnWriteArrayList();
        this.Kg.add(new com.kwad.components.core.j.kwai.a() { // from class: com.kwad.components.ad.reward.j.1
            @Override // com.kwad.components.core.j.kwai.a
            public final void a(com.kwad.components.core.l.d dVar) {
                j.this.fU();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void b(com.kwad.components.core.l.d dVar) {
                j.this.fV();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void c(com.kwad.components.core.l.d dVar) {
                j.this.fW();
            }

            @Override // com.kwad.components.core.j.kwai.a
            public final void gq() {
                j.this.fT();
            }
        });
    }

    public static long a(long j2, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.a.a.Y(adInfo), j2);
    }

    @Nullable
    public static com.kwad.components.core.g.c a(List<com.kwad.components.core.g.c> list, long j2) {
        if (j2 >= 0 && list != null) {
            for (com.kwad.components.core.g.c cVar : list) {
                if (com.kwad.sdk.core.response.a.d.ck(cVar.getAdTemplate()) == j2) {
                    return cVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, com.kwad.sdk.core.report.i iVar) {
        if (iVar == null) {
            iVar = new com.kwad.sdk.core.report.i();
        }
        iVar.bf(i2);
        iVar.c(this.mRootContainer.getTouchCoords());
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, iVar.xk(), this.mReportExtData);
        com.kwad.components.ad.reward.b.a.hi().c(this.mAdTemplate, com.kwad.components.ad.reward.b.b.STATUS_NONE);
        this.mAdOpenInteractionListener.bN();
    }

    public static void a(Activity activity, j jVar) {
        com.kwad.components.ad.reward.h.kwai.b.a(jVar, activity, jVar.pw.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.j.8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                j.this.d(dialogInterface);
                com.kwad.sdk.core.b.b.we();
                Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(j.this.getActivity())) {
                    return;
                }
                j.this.pw.resume();
            }
        }, new k.b() { // from class: com.kwad.components.ad.reward.j.9
            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gs() {
                j.this.pw.pause();
            }
        });
    }

    public static void a(Context context, j jVar, ViewGroup viewGroup) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        if (aVar != null && aVar.hasLiveCompoReady() && com.kwad.sdk.core.response.a.a.co(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) {
            IAdLiveOfflineView view = aVar.getView(context, com.kwad.sdk.core.response.a.a.aY(adInfoCb) == 8 ? 1 : 0);
            View view2 = view.getView();
            jVar.px = view;
            viewGroup.addView(view2);
            jVar.pw.a(aVar.getAdLivePlayModule(view, KsAdSDKImpl.get().getAppId(), String.valueOf(com.kwad.sdk.core.response.a.a.bM(adInfoCb))));
        }
    }

    public static void a(j jVar, final k.c cVar, final k.a aVar) {
        if (!jVar.pw.jY()) {
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
            bVarF = com.kwad.components.ad.reward.kwai.b.k(adInfoCb) || com.kwad.sdk.core.response.a.a.cg(adInfoCb) ? f(jVar) : null;
            if (bVarF == null) {
                bVarF = g(jVar);
            }
        }
        com.kwad.components.ad.reward.h.kwai.b bVar = bVarF;
        if (bVar != null) {
            com.kwad.components.ad.reward.h.kwai.b.a(bVar, jVar.getActivity(), jVar.pw.getPlayDuration(), aVar, new d.a() { // from class: com.kwad.components.ad.reward.j.6
                @Override // com.kwad.components.core.webview.a.b.d.a
                public final boolean gr() {
                    j.b(j.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(jVar, cVar, aVar);
        }
    }

    public static boolean a(j jVar) {
        AdMatrixInfo.FullScreenInfo fullScreenInfoBK;
        return (!com.kwad.sdk.core.config.d.isCanUseTk() || (fullScreenInfoBK = com.kwad.sdk.core.response.a.b.bK(jVar.mAdTemplate)) == null || fullScreenInfoBK.renderType != 1 || com.kwad.sdk.core.response.a.a.ci(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) || com.kwad.sdk.core.response.a.a.co(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) || com.kwad.sdk.core.response.a.a.aJ(jVar.mAdTemplate) || com.kwad.sdk.core.response.a.a.cg(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(j jVar, k.c cVar, k.a aVar) {
        boolean zE = e(jVar);
        new StringBuilder("showNativeCloseDialog isCloseDialogShowing: ").append(zE);
        if (zE) {
            return;
        }
        k.a(jVar.getActivity(), jVar.mAdTemplate, cVar, aVar);
    }

    public static boolean b(j jVar) {
        boolean z2 = false;
        if (jVar.pw.jY() || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null || a(jVar)) {
            return false;
        }
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        boolean z3 = (com.kwad.sdk.core.response.a.a.ci(adInfoCb) || (com.kwad.sdk.core.response.a.a.bu(adInfoCb) && com.kwad.components.ad.reward.kwai.b.gV()) || com.kwad.sdk.core.response.a.d.cm(jVar.mAdTemplate)) ? false : true;
        jVar.pP = z3 && !jVar.qm;
        if (z3 && !jVar.qm) {
            z2 = true;
        }
        jVar.F(z2);
        return z3;
    }

    public static boolean c(j jVar) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        boolean z2 = false;
        if (jVar.pw.jY() || com.kwad.sdk.core.response.a.a.co(adInfoCb) || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null || a(jVar)) {
            return false;
        }
        boolean z3 = com.kwad.components.ad.reward.kwai.b.k(adInfoCb) || !(com.kwad.components.ad.reward.kwai.b.j(adInfoCb) || com.kwad.sdk.core.response.a.d.cn(jVar.mAdTemplate) || com.kwad.sdk.core.response.a.a.ci(adInfoCb));
        if (z3 && !jVar.qm) {
            z2 = true;
        }
        jVar.pP = z2;
        return z3;
    }

    public static boolean d(j jVar) {
        if (jVar.pw.jY() || !com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.a.c.class) == null || a(jVar) || jVar.ql) {
            return false;
        }
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.cu(adInfoCb)) {
            return true;
        }
        return (p(jVar.mAdTemplate) || q(jVar.mAdTemplate) || !(com.kwad.components.ad.reward.kwai.b.k(adInfoCb) || (!com.kwad.components.ad.reward.kwai.b.j(adInfoCb) && !com.kwad.sdk.core.response.a.a.ci(adInfoCb) && !(com.kwad.sdk.core.response.a.a.bu(adInfoCb) && com.kwad.components.ad.reward.kwai.b.gV()) && !com.kwad.sdk.core.response.a.d.cn(jVar.mAdTemplate) && !com.kwad.sdk.core.response.a.a.aJ(jVar.mAdTemplate)))) ? false : true;
    }

    public static boolean e(j jVar) {
        return jVar.pK;
    }

    private static com.kwad.components.ad.reward.h.kwai.b f(j jVar) {
        d.b bVar = new d.b();
        bVar.setAdTemplate(jVar.mAdTemplate);
        bVar.aH("ksad-video-confirm-card");
        bVar.aN(false);
        bVar.aO(true);
        return com.kwad.components.ad.reward.h.kwai.b.a(jVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fT() {
        Iterator<a> it = this.qq.iterator();
        while (it.hasNext()) {
            it.next().gt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fU() {
        if (this.pL || this.pK || this.qj) {
            return;
        }
        boolean zInterceptPlayCardResume = false;
        Iterator<b> it = this.qr.iterator();
        while (it.hasNext()) {
            zInterceptPlayCardResume |= it.next().interceptPlayCardResume();
        }
        if (zInterceptPlayCardResume) {
            return;
        }
        Iterator<a> it2 = this.qq.iterator();
        while (it2.hasNext()) {
            it2.next().gu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV() {
        Iterator<a> it = this.qq.iterator();
        while (it.hasNext()) {
            it.next().gv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW() {
        Iterator<a> it = this.qq.iterator();
        while (it.hasNext()) {
            it.next().gw();
        }
    }

    private void fZ() {
        this.Kg.clear();
        this.pE.clear();
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        l lVar = this.pA;
        if (lVar != null) {
            lVar.release();
        }
        g gVar = this.pD;
        if (gVar != null) {
            gVar.release();
        }
        Set<com.kwad.components.ad.reward.d.e> set = this.pF;
        if (set != null) {
            set.clear();
        }
    }

    private static com.kwad.components.ad.reward.h.kwai.b g(j jVar) {
        if (!com.kwad.sdk.core.response.a.a.cn(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) && !com.kwad.sdk.core.response.a.a.cp(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) {
            return null;
        }
        d.b bVar = new d.b();
        bVar.setAdTemplate(jVar.mAdTemplate);
        bVar.aH("ksad-video-confirm-card");
        bVar.aN(false);
        bVar.aO(true);
        return com.kwad.components.ad.reward.h.kwai.b.a(jVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb() {
        int size = this.pE.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.kwad.components.ad.reward.d.f fVarPoll = this.pE.poll();
            if (fVarPoll != null) {
                fVarPoll.bM();
            }
        }
    }

    public static boolean h(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.b.h(adInfo) && !com.kwad.components.ad.reward.kwai.b.l(adInfo);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean p(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
    }

    public static boolean q(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.q(adTemplate);
    }

    public static boolean r(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.a.cu(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            return false;
        }
        return p(adTemplate) || q(adTemplate);
    }

    public final void B(boolean z2) {
        this.pL = z2;
        if (z2) {
            fV();
        } else {
            fU();
        }
    }

    public final void C(boolean z2) {
        com.kwad.components.ad.reward.g.c cVar = this.pG;
        if (cVar == null) {
            return;
        }
        cVar.onPlayAgainClick(z2);
    }

    public final void D(boolean z2) {
        this.qk = z2;
    }

    public final void E(boolean z2) {
        this.pM = true;
    }

    public final void F(boolean z2) {
        this.pR = z2;
    }

    public final void G(boolean z2) {
        this.pY = true;
    }

    public final void H(boolean z2) {
        this.qj = true;
    }

    public final void I(boolean z2) {
        this.pK = z2;
    }

    public final void O(int i2) {
        this.qf = i2;
    }

    public final void a(int i2, Context context, int i3, int i4) {
        b(i2, context, i3, i4);
    }

    public final void a(int i2, Context context, int i3, int i4, long j2) {
        a(1, context, 40, 1, j2, false, null);
    }

    public final void a(int i2, Context context, final int i3, int i4, long j2, boolean z2, final com.kwad.sdk.core.report.i iVar) {
        com.kwad.components.core.d.b.a.a(new a.C0395a(context).J(this.mAdTemplate).b(this.mApkDownloadHelper).al(false).ap(i4).q(j2).ao(i3).an(i2).am(fY()).b(this.pw.jZ()).a(new a.b() { // from class: com.kwad.components.ad.reward.j.3
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                j.this.a(i3, iVar);
            }
        }));
    }

    public final void a(long j2, long j3, int i2) {
        Iterator<com.kwad.components.ad.reward.d.e> it = this.pF.iterator();
        while (it.hasNext()) {
            it.next().cg();
        }
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.pZ.add(onDismissListener);
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.qp = rewardRenderResult;
    }

    public final void a(@Nullable com.kwad.components.ad.reward.d.m mVar) {
        this.qa = mVar;
    }

    public final void a(com.kwad.components.ad.reward.g.c cVar) {
        this.pG = cVar;
    }

    public final void a(a aVar) {
        this.qq.add(aVar);
    }

    public final void a(b bVar) {
        this.qr.add(bVar);
    }

    public final void a(@Nullable e.a aVar) {
        this.pI = aVar;
    }

    public final void a(@Nullable e.b bVar) {
        this.pJ = bVar;
    }

    public final void a(a.InterfaceC0399a interfaceC0399a) {
        List<a.InterfaceC0399a> list = this.qs;
        if (list != null) {
            list.add(interfaceC0399a);
        }
    }

    public final void a(com.kwad.components.core.webview.a.d.a aVar) {
        this.pH = aVar;
    }

    public final void b(int i2, Context context, int i3, int i4) {
        a(i2, context, i3, i4, 0L, false, null);
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.pZ.remove(onDismissListener);
    }

    public final void b(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.b.a.hi().a(this.mAdTemplate, bVar);
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.d.f fVar) {
        this.pE.offer(fVar);
    }

    public final void b(a aVar) {
        this.qq.remove(aVar);
    }

    public final void b(b bVar) {
        this.qr.remove(bVar);
    }

    public final void b(a.InterfaceC0399a interfaceC0399a) {
        List<a.InterfaceC0399a> list = this.qs;
        if (list != null) {
            list.remove(interfaceC0399a);
        }
    }

    public final void b(final com.kwad.components.core.g.c cVar) {
        final com.kwad.components.core.g.d dVarH = KSRewardVideoActivityProxy.a.H(this.mAdTemplate.getUniqueId());
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.j.4
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.g.d dVar = dVarH;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    @MainThread
    public final void c(com.kwad.components.ad.reward.d.f fVar) {
        this.pE.remove(fVar);
    }

    public final void c(final com.kwad.components.core.g.c cVar) {
        final com.kwad.components.core.g.d dVarH = KSRewardVideoActivityProxy.a.H(this.mAdTemplate.getUniqueId());
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.j.5
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.g.d dVar = dVarH;
                if (dVar != null) {
                    dVar.e(cVar);
                }
            }
        });
    }

    public final void c(final boolean z2, final boolean z3) {
        if (this.pw.jY()) {
            bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.j.7
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.pw.jZ().setAudioEnabled(z2, z3);
                }
            }, 500L);
        }
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.pZ.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.pX = playableSource;
    }

    public final boolean fX() {
        return this.pL;
    }

    @Nullable
    public final String fY() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    public final void ga() {
        if (isMainThread()) {
            gb();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.reward.j.2
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.gb();
                }
            });
        }
    }

    public final int gc() {
        return this.qf;
    }

    public final boolean gd() {
        return this.qk;
    }

    public final void ge() {
        com.kwad.components.core.webview.a.d.a aVar = this.pH;
        if (aVar == null) {
            return;
        }
        aVar.cr();
    }

    public final boolean gf() {
        return this.pM;
    }

    public final boolean gg() {
        return this.pR;
    }

    @Nullable
    public final PlayableSource gh() {
        return this.pX;
    }

    public final boolean gi() {
        return this.pY;
    }

    public final List<a.InterfaceC0399a> gj() {
        return this.qs;
    }

    @Nullable
    public final e.b gk() {
        return this.pJ;
    }

    public final RewardRenderResult gl() {
        return this.qp;
    }

    public final boolean gm() {
        return RewardRenderResult.NEO_TK.equals(this.qp);
    }

    public final boolean gn() {
        return RewardRenderResult.LIVE_TK.equals(this.qp);
    }

    public final boolean go() {
        return this.qj;
    }

    public final boolean gp() {
        return this.pK;
    }

    @Override // com.kwad.components.core.j.a, com.kwad.sdk.mvp.a
    public final void release() {
        fZ();
        this.pw.release();
    }

    public final void releaseSync() {
        fZ();
        this.pw.releaseSync();
    }
}
