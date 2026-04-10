package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.j.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.kwad.components.core.m.a {
    public IAdLiveOfflineView dD;
    public boolean iH;
    private Handler iK;
    public boolean jk;
    public AdResultData mAdResultData;
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    public long mPageEnterTime;
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bv mTimerHelper;
    public KsVideoPlayConfig mVideoPlayConfig;
    public boolean mw;
    public boolean rC;
    public com.kwad.components.ad.reward.e.b rD;
    public com.kwad.components.ad.reward.m.e rE;
    public com.kwad.components.core.playable.a rF;
    public RewardActionBarControl rG;
    public j rH;
    public com.kwad.components.ad.l.a rI;
    public d rJ;
    private final PriorityQueue<com.kwad.components.ad.reward.e.g> rK;
    public final List<com.kwad.components.ad.reward.k.a> rL;
    private final List<s> rM;
    private final List<com.kwad.components.ad.reward.m.c> rN;
    public Set<com.kwad.components.ad.reward.e.e> rO;
    private com.kwad.components.core.webview.tachikoma.f.a rP;
    private boolean rQ;
    private boolean rR;
    public boolean rS;
    public boolean rT;
    public boolean rU;
    public boolean rV;
    private boolean rW;
    public boolean rX;
    public boolean rY;
    public List<Integer> rZ;
    private List<b> sA;
    private List<a.InterfaceC0338a> sB;
    public int sa;
    public int sb;
    public int sc;
    public boolean sd;
    public com.kwad.components.ad.reward.n.p se;
    public boolean sf;
    private PlayableSource sg;
    private boolean sh;
    public long si;
    private List<DialogInterface.OnDismissListener> sj;
    public com.kwad.components.ad.reward.e.o sk;
    public boolean sl;
    public com.kwad.components.ad.reward.l.b.a sm;
    public com.kwad.components.ad.reward.l.a.a sn;
    public int so;
    private int sp;
    public long sq;
    public long sr;
    public boolean ss;
    private boolean st;
    private boolean su;
    public boolean sv;
    public boolean sw;
    public LoadStrategy sx;
    private RewardRenderResult sy;
    private List<a> sz;

    public interface a {
        void hd();

        void he();

        void hf();

        void hg();
    }

    public interface b {
        boolean interceptPlayCardResume();
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
    }

    public g(com.kwad.components.core.m.b<?> bVar) {
        super(bVar);
        this.rC = false;
        this.rK = new PriorityQueue<>();
        this.rL = new CopyOnWriteArrayList();
        this.rM = new CopyOnWriteArrayList();
        this.rN = new CopyOnWriteArrayList();
        this.rO = new HashSet();
        this.rQ = false;
        this.rR = false;
        this.rT = false;
        this.rU = false;
        this.rV = false;
        this.rW = false;
        this.rX = false;
        this.mRewardVerifyCalled = false;
        this.rY = false;
        this.rZ = new ArrayList();
        this.mCheckExposureResult = true;
        this.sa = 1;
        this.sb = 1;
        this.sc = 0;
        this.sd = false;
        this.sf = false;
        this.sg = null;
        this.sh = false;
        this.jk = false;
        this.sj = new CopyOnWriteArrayList();
        this.iK = new Handler(Looper.getMainLooper());
        this.sl = false;
        this.sp = 2;
        this.st = false;
        this.su = false;
        this.sv = false;
        this.sw = false;
        this.sx = LoadStrategy.FULL_TK;
        this.sz = new CopyOnWriteArrayList();
        this.sA = new CopyOnWriteArrayList();
        this.sB = new CopyOnWriteArrayList();
        this.Rt.add(new com.kwad.components.core.m.a.a() { // from class: com.kwad.components.ad.reward.g.1
            @Override // com.kwad.components.core.m.a.a
            public final void gY() {
                g.this.gC();
            }

            @Override // com.kwad.components.core.m.a.a
            public final void c(com.kwad.components.core.proxy.f fVar) {
                g.this.gD();
            }

            @Override // com.kwad.components.core.m.a.a
            public final void d(com.kwad.components.core.proxy.f fVar) {
                g.this.gE();
            }

            @Override // com.kwad.components.core.m.a.a
            public final void gZ() {
                g.this.gF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC() {
        Iterator<a> it = this.sz.iterator();
        while (it.hasNext()) {
            it.next().hd();
        }
    }

    public final void gD() {
        if (this.rR || this.rQ || this.st) {
            return;
        }
        Iterator<b> it = this.sA.iterator();
        boolean zInterceptPlayCardResume = false;
        while (it.hasNext()) {
            zInterceptPlayCardResume |= it.next().interceptPlayCardResume();
        }
        if (zInterceptPlayCardResume) {
            return;
        }
        Iterator<a> it2 = this.sz.iterator();
        while (it2.hasNext()) {
            it2.next().he();
        }
    }

    public final void gE() {
        Iterator<a> it = this.sz.iterator();
        while (it.hasNext()) {
            it.next().hf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF() {
        Iterator<a> it = this.sz.iterator();
        while (it.hasNext()) {
            it.next().hg();
        }
    }

    public final void A(boolean z) {
        this.rR = z;
        if (z) {
            gE();
        } else {
            gD();
        }
    }

    public final boolean gG() {
        return this.rR;
    }

    public final void a(a aVar) {
        this.sz.add(aVar);
    }

    public final void b(a aVar) {
        this.sz.remove(aVar);
    }

    public final void a(b bVar) {
        this.sA.add(bVar);
    }

    public final void b(b bVar) {
        this.sA.remove(bVar);
    }

    public final void a(com.kwad.components.ad.reward.k.a aVar) {
        this.rL.add(aVar);
    }

    public final void b(com.kwad.components.ad.reward.k.a aVar) {
        this.rL.remove(aVar);
    }

    public final void a(s sVar) {
        this.rM.add(sVar);
    }

    public final void b(s sVar) {
        this.rM.remove(sVar);
    }

    public final void a(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.rN.add(cVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.rN.remove(cVar);
        }
    }

    public final void gH() {
        a(this.rN, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.m.c>() { // from class: com.kwad.components.ad.reward.g.5
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
                c(cVar);
            }

            private static void c(com.kwad.components.ad.reward.m.c cVar) {
                cVar.jB();
            }
        });
    }

    public static <T> void a(List<T> list, com.kwad.sdk.g.a<T> aVar) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    public final String gI() {
        if (this.mAdTemplate.tkLiveShopItemInfo == null) {
            return null;
        }
        return this.mAdTemplate.tkLiveShopItemInfo.itemId;
    }

    @Override // com.kwad.components.core.m.a, com.kwad.sdk.mvp.a
    public final void release() {
        gJ();
        com.kwad.components.ad.reward.m.e eVar = this.rE;
        if (eVar != null) {
            eVar.release();
        }
    }

    private void gJ() {
        this.rK.clear();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        j jVar = this.rH;
        if (jVar != null) {
            jVar.release();
        }
        d dVar = this.rJ;
        if (dVar != null) {
            dVar.release();
        }
        Set<com.kwad.components.ad.reward.e.e> set = this.rO;
        if (set != null) {
            set.clear();
        }
    }

    public static boolean g(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.g(adInfo) && !com.kwad.components.ad.reward.a.b.k(adInfo);
    }

    public final void b(com.kwad.components.ad.reward.e.g gVar) {
        this.rK.offer(gVar);
    }

    public final void c(com.kwad.components.ad.reward.e.g gVar) {
        this.rK.remove(gVar);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void gK() {
        if (isMainThread()) {
            gL();
        } else {
            this.iK.post(new bg() { // from class: com.kwad.components.ad.reward.g.6
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    g.this.gL();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gL() {
        try {
            int size = this.rK.size();
            for (int i = 0; i < size; i++) {
                com.kwad.components.ad.reward.e.g gVarPoll = this.rK.poll();
                if (gVarPoll != null) {
                    gVarPoll.cX();
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void a(long j, long j2, int i) {
        Iterator<com.kwad.components.ad.reward.e.e> it = this.rO.iterator();
        while (it.hasNext()) {
            it.next().dq();
        }
    }

    public final void a(int i, Context context, int i2, int i3) {
        b(i, context, i2, i3);
    }

    public final void b(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, 0L, false, null);
    }

    public final void a(int i, Context context, int i2, int i3, long j) {
        a(1, context, 40, 1, j, false, null);
    }

    public final void a(int i, Context context, final int i2, int i3, long j, boolean z, final com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.e.d.a.a(new a.C0333a(context).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aq(false).aB(i3).A(j).aA(i2).az(i).al(gI()).a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: hb, reason: merged with bridge method [inline-methods] */
            public String call() {
                if (g.this.rE != null) {
                    return g.this.rE.kX().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).a(new a.b() { // from class: com.kwad.components.ad.reward.g.7
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    g.this.a(i2, bVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dd(i);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, (String) null, (String) null, bVar, this.mReportExtData);
        com.kwad.components.ad.reward.c.a.hV().c(this.mAdTemplate, com.kwad.components.ad.reward.c.b.STATUS_NONE);
        this.rD.cW();
    }

    public final void Z(int i) {
        this.sp = i;
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.sj.add(onDismissListener);
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.sj.remove(onDismissListener);
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.sj.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.o oVar) {
        this.sk = oVar;
    }

    public final boolean gM() {
        return this.su;
    }

    public final void B(boolean z) {
        this.su = z;
    }

    public final void gN() {
        com.kwad.components.core.webview.tachikoma.f.a aVar = this.rP;
        if (aVar == null) {
            return;
        }
        aVar.kk();
    }

    public final void a(com.kwad.components.core.webview.tachikoma.f.a aVar) {
        this.rP = aVar;
    }

    public final boolean gO() {
        return this.rW;
    }

    public final PlayableSource gP() {
        return this.sg;
    }

    public final void d(PlayableSource playableSource) {
        this.sg = playableSource;
    }

    public final boolean gQ() {
        return this.sh;
    }

    public final void C(boolean z) {
        this.sh = true;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.hV().a(this.mAdTemplate, bVar);
    }

    public final void a(final com.kwad.components.core.j.c cVar) {
        final com.kwad.components.core.j.d dVarP = com.kwad.components.ad.reward.e.f.P(this.mAdTemplate.getUniqueId());
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.9
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.j.d dVar = dVarP;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void b(final com.kwad.components.core.j.c cVar) {
        final com.kwad.components.core.j.d dVarP = com.kwad.components.ad.reward.e.f.P(this.mAdTemplate.getUniqueId());
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.g.10
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.components.core.j.d dVar = dVarP;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final List<a.InterfaceC0338a> gR() {
        return this.sB;
    }

    public final void a(a.InterfaceC0338a interfaceC0338a) {
        List<a.InterfaceC0338a> list = this.sB;
        if (list != null) {
            list.add(interfaceC0338a);
        }
    }

    public final void b(a.InterfaceC0338a interfaceC0338a) {
        List<a.InterfaceC0338a> list = this.sB;
        if (list != null) {
            list.remove(interfaceC0338a);
        }
    }

    public static com.kwad.components.core.j.c a(List<com.kwad.components.core.j.c> list, long j) {
        if (j >= 0 && list != null) {
            for (com.kwad.components.core.j.c cVar : list) {
                if (com.kwad.sdk.core.response.b.e.ev(cVar.getAdTemplate()) == j) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.sy = rewardRenderResult;
    }

    public final RewardRenderResult gS() {
        return this.sy;
    }

    public final boolean gT() {
        return RewardRenderResult.NEO_TK.equals(this.sy);
    }

    public final boolean gU() {
        return this.st;
    }

    public final void D(boolean z) {
        this.st = true;
    }

    public final boolean gV() {
        return this.rQ;
    }

    public final void E(boolean z) {
        this.rQ = z;
    }

    public final boolean gW() {
        return this.mRewardVerifyCalled;
    }

    public final void F(final boolean z) {
        if (z != this.mRewardVerifyCalled) {
            a(this.rM, new com.kwad.sdk.g.a<s>() { // from class: com.kwad.components.ad.reward.g.11
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void accept(s sVar) {
                    sVar.ab(z);
                }
            });
        }
        this.mRewardVerifyCalled = z;
    }

    public static void a(Context context, g gVar, ViewGroup viewGroup) {
        IAdLiveOfflineView iAdLiveOfflineViewA;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate);
        com.kwad.components.core.o.a.b.a aVar = (com.kwad.components.core.o.a.b.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.b.a.class);
        if (aVar != null && aVar.qu() && com.kwad.sdk.core.response.b.a.cR(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate))) {
            try {
                iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(aVar, context, com.kwad.sdk.core.response.b.a.bf(adInfoEl) == 8 ? 1 : 0);
            } catch (Throwable unused) {
                iAdLiveOfflineViewA = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = iAdLiveOfflineViewA;
            if (iAdLiveOfflineView != null) {
                View view = iAdLiveOfflineView.getView();
                gVar.dD = iAdLiveOfflineView;
                viewGroup.addView(view);
                gVar.rE.a(2, new com.kwad.components.ad.reward.f.a(gVar.mAdTemplate, aVar.getAdLivePlayModule(iAdLiveOfflineView, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cp(adInfoEl)), com.kwad.sdk.core.response.b.a.cq(adInfoEl), com.kwad.sdk.core.response.b.a.cr(adInfoEl))));
            }
        }
    }

    public static boolean N(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.el(adTemplate)));
    }

    public static boolean O(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.O(adTemplate);
    }

    public static boolean P(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.a.cX(com.kwad.sdk.core.response.b.e.el(adTemplate))) {
            return false;
        }
        return N(adTemplate) || O(adTemplate);
    }

    public static long a(long j, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.b.a.ag(adInfo), j);
    }

    public static boolean b(g gVar) {
        return gVar.rQ;
    }

    public static void a(g gVar, final h.c cVar, final h.a aVar) {
        if (!gVar.rE.kW()) {
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate);
            bVarC = com.kwad.components.ad.reward.a.b.j(adInfoEl) || com.kwad.sdk.core.response.b.a.cj(adInfoEl) == 2 ? c(gVar) : null;
            if (bVarC == null) {
                bVarC = d(gVar);
            }
        }
        com.kwad.components.ad.reward.k.a.b bVar = bVarC;
        if (bVar != null) {
            com.kwad.components.ad.reward.k.a.b.a(bVar, gVar.getActivity(), gVar.rE.getPlayDuration(), aVar, new e.a() { // from class: com.kwad.components.ad.reward.g.12
                @Override // com.kwad.components.core.webview.tachikoma.d.e.a
                public final boolean hc() {
                    g.b(g.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(gVar, cVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(g gVar, h.c cVar, h.a aVar) {
        boolean zB = b(gVar);
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + zB);
        if (zB) {
            return;
        }
        h.a(gVar.getActivity(), gVar.mAdTemplate, cVar, aVar);
    }

    public final void d(final boolean z, final boolean z2) {
        if (this.rE.kW()) {
            bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.components.ad.reward.g.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    com.kwad.components.ad.reward.f.a aVarKX = g.this.rE.kX();
                    if (aVarKX != null) {
                        aVarKX.setAudioEnabled(z, z2);
                    }
                }
            }, 500L);
        }
    }

    public final void D(String str) {
        int iA = -1;
        try {
            if (com.kwad.sdk.core.config.e.BP()) {
                iA = com.kwad.components.ad.reward.j.a.a(getActivity());
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        com.kwad.components.ad.reward.j.b.a(this.mContext, this.mAdTemplate, str, iA, this.mReportExtData);
    }

    public final void gX() {
        long j = this.sr;
        com.kwad.sdk.core.adlog.c.i(this.mAdTemplate, com.kwad.sdk.core.response.b.a.ae(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate)), j != 0 ? (int) (j / 1000) : 0);
    }

    private static com.kwad.components.ad.reward.k.a.b c(g gVar) {
        e.b bVar = new e.b();
        bVar.a(gVar.mAdResultData);
        bVar.bg(com.kwad.sdk.core.response.b.b.dO(gVar.mAdTemplate));
        bVar.aZ(false);
        bVar.ba(true);
        return com.kwad.components.ad.reward.k.a.b.a(gVar, bVar);
    }

    private static com.kwad.components.ad.reward.k.a.b d(g gVar) {
        if (com.kwad.sdk.core.response.b.a.cj(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate)) == 4 || com.kwad.sdk.core.response.b.a.cj(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate)) == 3) {
            return c(gVar);
        }
        return null;
    }

    public static void a(Activity activity, g gVar) {
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showExtraDialog");
        com.kwad.components.ad.reward.k.a.b.a(gVar, activity, gVar.rE.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.Ho();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(g.this.getActivity())) {
                    return;
                }
                g.this.rE.resume();
            }
        }, new h.b() { // from class: com.kwad.components.ad.reward.g.4
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void ha() {
                g.this.rE.pause();
            }
        });
    }
}
