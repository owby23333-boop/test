package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.arialyy.aria.core.command.NormalCmdFactory;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static long sv;

    public interface a {
        boolean gK();
    }

    public interface b extends a {
        void gJ();
    }

    private static boolean V(String str) {
        if (!com.kwad.components.ad.reward.kwai.b.ha()) {
            com.kwad.sdk.core.d.b.e(str, "isEnable false");
            return true;
        }
        int iGZ = com.kwad.components.ad.reward.kwai.b.gZ();
        com.kwad.sdk.core.d.b.d(str, "JumpDirectMaxCount " + iGZ);
        return iGZ <= 0 || com.kwad.components.ad.reward.e.a.cO() >= iGZ;
    }

    private static void a(final com.kwad.components.ad.reward.j jVar, @NonNull final k.b bVar) {
        String str;
        final AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        final JSONObject jSONObject = jVar.mReportExtData;
        long jV = com.kwad.sdk.core.response.a.a.V(adInfoCb);
        if (jV <= 0 || com.kwad.sdk.core.response.a.a.F(adInfoCb) <= jV) {
            str = "观看完整视频即可获取奖励";
        } else {
            str = "观看视频" + jV + "s即可获取奖励";
        }
        final k.c cVarA = com.kwad.components.ad.reward.k.a(jVar, str);
        com.kwad.components.ad.reward.j.a(jVar, cVarA, new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.4
            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void J(boolean z2) {
                jVar.I(false);
                if (!z2) {
                    com.kwad.sdk.core.report.a.p(adTemplate, TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING);
                }
                k.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.J(z2);
                }
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.ad.reward.k.a
            public final void g(int i2, int i3) {
                super.g(i2, i3);
                com.kwad.components.ad.reward.j jVar2 = jVar;
                jVar2.a(1, jVar2.mContext, i2, i3);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gs() {
                jVar.pw.pause();
                jVar.I(true);
                if (cVarA.getStyle() == 0) {
                    com.kwad.sdk.core.report.a.k(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.report.a.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.ad.reward.k.a
            public final void gx() {
                super.gx();
                com.kwad.sdk.core.report.a.p(adTemplate, TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO);
                com.kwad.components.ad.reward.j jVar2 = jVar;
                jVar2.a(1, jVar2.mContext, 156, 1);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gy() {
                super.gy();
                jVar.I(false);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gz() {
                jVar.I(false);
                jVar.pw.resume();
                if (cVarA.getStyle() == 1 || cVarA.getStyle() == 2 || cVarA.getStyle() == 5 || cVarA.getStyle() == 8) {
                    com.kwad.sdk.core.report.a.p(adTemplate, TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO);
                } else {
                    com.kwad.sdk.core.report.a.l(adTemplate, jSONObject);
                }
            }
        });
    }

    public static void a(com.kwad.components.ad.reward.j jVar, b bVar) {
        boolean zT = com.kwad.components.ad.reward.n.t(jVar.mAdTemplate);
        s(jVar);
        if (zT && bVar != null && bVar.gK()) {
            return;
        }
        jVar.hH();
    }

    public static void a(com.kwad.components.ad.reward.j jVar, b bVar, boolean z2) {
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        boolean z3 = !z2 && com.kwad.components.ad.reward.n.t(adTemplate);
        if (jVar.pN) {
            int iGc = jVar.gc();
            if (!p(adTemplate) && !q(adTemplate)) {
                if (com.kwad.sdk.core.response.a.b.bG(jVar.mAdTemplate) && jVar.mAdTemplate.mPlayAgain != null && !jVar.gm() && !jVar.gn() && !jVar.gf() && jVar.mRewardVerifyCalled && iGc == 2) {
                    if (bVar != null) {
                        bVar.gJ();
                        return;
                    }
                    return;
                } else {
                    if (jVar.qi || jVar.qh >= com.kwad.sdk.core.response.a.a.Y(adInfoCb)) {
                        t(jVar);
                    }
                    if (z3 && bVar != null && bVar.gK()) {
                        return;
                    }
                    s(jVar);
                    jVar.hH();
                    return;
                }
            }
            n(jVar);
            if ((jVar.mRewardVerifyCalled || !y(jVar.mAdTemplate) || jVar.pS) ? false : true) {
                r(jVar);
                return;
            }
        }
        s(jVar);
        jVar.hH();
    }

    public static void a(final com.kwad.components.ad.reward.j jVar, boolean z2) {
        AdTemplate adTemplate = jVar.mAdTemplate;
        final AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (!jVar.pN) {
            jVar.mAdOpenInteractionListener.onSkippedVideo();
            if (com.kwad.sdk.core.response.a.a.bD(adInfoCb)) {
                jVar.release();
                jVar.hH();
                return;
            } else {
                if (jVar.pP) {
                    o(jVar);
                    return;
                }
                com.kwad.sdk.core.report.a.j(adTemplate, jVar.mReportExtData);
                jVar.pw.release();
                jVar.ga();
                q(jVar);
                return;
            }
        }
        n(jVar);
        boolean z3 = !jVar.mRewardVerifyCalled && y(jVar.mAdTemplate);
        if (p(adTemplate) || q(adTemplate) || jVar.qh < com.kwad.sdk.core.response.a.a.Y(adInfoCb)) {
            if (z3) {
                a(jVar, new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.1
                    @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
                    public final void J(boolean z4) {
                        super.J(z4);
                        if (com.kwad.components.ad.reward.kwai.b.l(adInfoCb)) {
                            jVar.hH();
                        } else if (com.kwad.sdk.core.response.a.a.bE(adInfoCb)) {
                            jVar.release();
                            jVar.hH();
                        } else {
                            e.o(jVar);
                            com.kwad.components.ad.reward.m.m(jVar);
                        }
                    }
                });
                return;
            } else if (com.kwad.sdk.core.response.a.a.bE(adInfoCb)) {
                jVar.release();
                jVar.hH();
                return;
            } else {
                o(jVar);
                com.kwad.components.ad.reward.m.m(jVar);
                return;
            }
        }
        if (jVar.qb) {
            jVar.hH();
            return;
        }
        if (!jVar.qi && jVar.qh < com.kwad.sdk.core.response.a.a.Y(adInfoCb)) {
            if (z2) {
                jVar.hH();
                return;
            }
            return;
        }
        if (jVar.qi) {
            jVar.O(2);
        } else {
            jVar.O(1);
        }
        t(jVar);
        if (com.kwad.sdk.core.response.a.a.bE(adInfoCb)) {
            jVar.release();
            jVar.hH();
        } else {
            o(jVar);
            com.kwad.components.ad.reward.m.m(jVar);
        }
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        String str2;
        if (com.kwad.sdk.core.response.a.a.bu(adInfo)) {
            str2 = "is playable return";
        } else if (!com.kwad.sdk.core.response.a.a.ay(adInfo)) {
            str2 = "is not Download type";
        } else if (adTemplate.mPlayAgain != null) {
            str2 = "is playAgain return";
        } else if (com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(adInfo))) {
            str2 = "isRewardLaunchAppTask";
        } else {
            if (!com.kwad.components.ad.reward.j.h(adInfo)) {
                return false;
            }
            str2 = "is Aggregation return";
        }
        com.kwad.sdk.core.d.b.i(str, str2);
        return true;
    }

    private static void n(com.kwad.components.ad.reward.j jVar) {
        long j2 = jVar.qg;
        int i2 = j2 != 0 ? (int) (j2 / 1000) : 0;
        long j3 = jVar.qh;
        int i3 = j3 != 0 ? (int) (j3 / 1000) : 0;
        y.b bVar = new y.b();
        bVar.ajK = 69;
        bVar.aka = i2;
        bVar.akb = i3;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 141, bVar, jVar.mReportExtData);
    }

    public static void o(final com.kwad.components.ad.reward.j jVar) {
        long j2 = jVar.qh;
        int i2 = j2 != 0 ? (int) (j2 / 1000) : 0;
        jVar.pS = true;
        AdTemplate adTemplate = jVar.mAdTemplate;
        com.kwad.sdk.core.report.a.d(adTemplate, com.kwad.sdk.core.response.a.a.W(com.kwad.sdk.core.response.a.d.cb(adTemplate)), i2);
        if (h.u(jVar)) {
            bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.p(jVar);
                }
            }, 200L);
        } else {
            p(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(com.kwad.components.ad.reward.j jVar) {
        jVar.pw.skipToEnd();
    }

    private static boolean p(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
    }

    public static void q(com.kwad.components.ad.reward.j jVar) {
        com.kwad.sdk.core.d.b.d("openAppMarket", "tryOpenAppMarket");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - sv < 300) {
            com.kwad.sdk.core.d.b.d("openAppMarket", "连续点击");
            return;
        }
        sv = jElapsedRealtime;
        if (V("openAppMarket")) {
            return;
        }
        AdTemplate adTemplate = jVar.mAdTemplate;
        Context context = jVar.mContext;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (a("openAppMarket", adTemplate, adInfoCb)) {
            return;
        }
        String strCs = com.kwad.sdk.core.response.a.a.cs(adInfoCb);
        com.kwad.sdk.core.d.b.i("openAppMarket", "tryOpenMiAppStore url：" + strCs);
        com.kwad.sdk.core.report.i iVarBp = new com.kwad.sdk.core.report.i().bf(NormalCmdFactory.TASK_HIGHEST_PRIORITY).bp(8);
        if (com.kwad.sdk.utils.d.a(context, strCs, adTemplate)) {
            com.kwad.sdk.core.report.a.a(adTemplate, iVarBp, (JSONObject) null);
            com.kwad.sdk.core.report.a.c(adTemplate, 1, 8);
            com.kwad.components.ad.reward.e.a.J(context);
        } else {
            if (!com.kwad.sdk.utils.d.g(context, strCs, com.kwad.sdk.core.response.a.a.ar(adInfoCb))) {
                com.kwad.sdk.core.d.b.i("openAppMarket", "tryOpenMiAppStore failed");
                return;
            }
            com.kwad.sdk.core.report.a.a(adTemplate, iVarBp, (JSONObject) null);
            com.kwad.sdk.core.report.a.c(adTemplate, 0, 8);
            com.kwad.components.ad.reward.e.a.J(context);
        }
    }

    private static boolean q(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.q(adTemplate);
    }

    private static void r(final com.kwad.components.ad.reward.j jVar) {
        final AdTemplate adTemplate = jVar.mAdTemplate;
        com.kwad.components.ad.reward.j.a(jVar, com.kwad.components.ad.reward.k.a(jVar, (String) null), new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.3
            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void J(boolean z2) {
                jVar.I(false);
                if (!z2) {
                    com.kwad.sdk.core.report.a.p(adTemplate, TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING);
                }
                e.s(jVar);
                jVar.hH();
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gs() {
                jVar.I(true);
                com.kwad.sdk.core.report.a.b(adTemplate, 149, jVar.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gz() {
                jVar.I(false);
                com.kwad.sdk.core.report.a.p(adTemplate, TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(com.kwad.components.ad.reward.j jVar) {
        jVar.mAdOpenInteractionListener.h(false);
    }

    private static void t(com.kwad.components.ad.reward.j jVar) {
        jVar.mAdOpenInteractionListener.onRewardVerify();
    }

    private static boolean y(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.ac(com.kwad.sdk.core.response.a.d.cb(adTemplate));
    }
}
