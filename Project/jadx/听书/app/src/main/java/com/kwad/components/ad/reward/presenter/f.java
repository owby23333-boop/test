package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static long vC;

    private static void o(final com.kwad.components.ad.reward.g gVar) {
        if (com.kwad.sdk.core.response.b.a.bV(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate))) {
            p(gVar);
            return;
        }
        if (gVar.rU) {
            r(gVar);
            return;
        }
        gVar.rX = true;
        com.kwad.components.ad.reward.g.a(gVar.rL, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jV();
            }
        });
        gVar.rD.onVideoSkipToEnd(0L);
        com.kwad.sdk.core.adlog.c.i(gVar.mAdTemplate, gVar.mReportExtData);
        if (gVar.rE != null) {
            gVar.rE.release();
        }
        gVar.gK();
        u(gVar);
    }

    public static void a(final com.kwad.components.ad.reward.g gVar, boolean z) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        final AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (!gVar.rS) {
            o(gVar);
            return;
        }
        q(gVar);
        boolean z2 = !gVar.gW() && V(gVar.mAdTemplate);
        if (N(adTemplate) || O(adTemplate) || gVar.sr < com.kwad.sdk.core.response.b.a.ag(adInfoEl)) {
            if (z2) {
                a(gVar, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                    @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
                    public final void G(boolean z3) {
                        super.G(z3);
                        if (com.kwad.components.ad.reward.a.b.k(adInfoEl)) {
                            gVar.iz();
                        } else if (com.kwad.sdk.core.response.b.a.bW(adInfoEl)) {
                            f.p(gVar);
                        } else {
                            f.r(gVar);
                            com.kwad.components.ad.reward.l.j(gVar);
                        }
                    }
                });
                return;
            } else if (com.kwad.sdk.core.response.b.a.bW(adInfoEl)) {
                p(gVar);
                return;
            } else {
                r(gVar);
                com.kwad.components.ad.reward.l.j(gVar);
                return;
            }
        }
        if (gVar.sl) {
            gVar.iz();
            return;
        }
        if (!gVar.ss && gVar.sr < com.kwad.sdk.core.response.b.a.ag(adInfoEl)) {
            if (z) {
                gVar.iz();
                return;
            }
            return;
        }
        if (gVar.ss) {
            gVar.Z(2);
        } else {
            gVar.Z(1);
        }
        y(gVar);
        if (com.kwad.sdk.core.response.b.a.bW(adInfoEl)) {
            p(gVar);
        } else {
            r(gVar);
            com.kwad.components.ad.reward.l.j(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(final com.kwad.components.ad.reward.g gVar) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.presenter.f.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                gVar.gX();
                gVar.rD.onVideoSkipToEnd(gVar.sr);
                gVar.release();
                gVar.iz();
            }
        });
    }

    private static boolean V(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.ak(com.kwad.sdk.core.response.b.e.el(adTemplate));
    }

    private static void q(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.adlog.c.e(gVar.mAdTemplate, gVar.mReportExtData, new com.kwad.sdk.core.adlog.c.b().df(69).di(gVar.sq != 0 ? (int) (gVar.sq / 1000) : 0).dj(gVar.sr != 0 ? (int) (gVar.sr / 1000) : 0));
    }

    public static void r(final com.kwad.components.ad.reward.g gVar) {
        gVar.rX = true;
        gVar.gX();
        if (i.z(gVar)) {
            bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.s(gVar);
                }
            }, 200L);
        } else {
            s(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(final com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar.rL, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jV();
            }
        });
        if (gVar.rE != null) {
            gVar.rE.skipToEnd();
        }
    }

    public static void t(com.kwad.components.ad.reward.g gVar) {
        x(gVar);
        gVar.iz();
    }

    public static void u(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.d.c.d("openAppMarket", "tryOpenAppMarket");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - vC < 300) {
            com.kwad.sdk.core.d.c.d("openAppMarket", "连续点击");
            return;
        }
        vC = jElapsedRealtime;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (a(adInfoEl, "openAppMarket")) {
            return;
        }
        Context context = gVar.mContext;
        if (a("openAppMarket", adTemplate, adInfoEl)) {
            return;
        }
        com.kwad.sdk.core.adlog.c.b bVarDp = new com.kwad.sdk.core.adlog.c.b().dd(MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID).dp(8);
        boolean z = com.kwad.sdk.core.download.a.b.F(context, com.kwad.sdk.core.response.b.a.cT(adInfoEl)) == 1;
        com.kwad.sdk.core.d.c.i("openAppMarket", "handleDeepLink dpSuccess: " + z);
        if (z) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarDp, (JSONObject) null);
            com.kwad.components.ad.reward.h.a.J(context);
            return;
        }
        String strCW = com.kwad.sdk.core.response.b.a.cW(adInfoEl);
        com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore url：" + strCW);
        if (com.kwad.sdk.utils.e.a(context, strCW, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarDp, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.h(adTemplate, 1, 8);
            com.kwad.components.ad.reward.h.a.J(context);
        } else {
            if (com.kwad.sdk.utils.e.i(context, adTemplate)) {
                com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarDp, (JSONObject) null);
                com.kwad.sdk.core.adlog.c.h(adTemplate, 0, 8);
                com.kwad.components.ad.reward.h.a.J(context);
                return;
            }
            com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore failed");
        }
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bK(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is playable return");
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is not Download type");
            return true;
        }
        if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(adInfo))) {
            com.kwad.sdk.core.d.c.i(str, "isRewardLaunchAppTask");
            return true;
        }
        if (!com.kwad.components.ad.reward.g.g(adInfo)) {
            return false;
        }
        com.kwad.sdk.core.d.c.i(str, "is Aggregation return");
        return true;
    }

    private static boolean a(AdInfo adInfo, String str) {
        if (!com.kwad.components.ad.reward.a.b.hL()) {
            com.kwad.sdk.core.d.c.e(str, "isEnable false");
            return true;
        }
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cW(adInfo))) {
            return true;
        }
        int iHK = com.kwad.components.ad.reward.a.b.hK();
        com.kwad.sdk.core.d.c.d(str, "JumpDirectMaxCount " + iHK);
        return iHK <= 0 || com.kwad.components.ad.reward.h.a.dO() >= iHK;
    }

    public static void v(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (!gVar.rS) {
            x(gVar);
            gVar.iz();
            return;
        }
        if (N(adTemplate) || O(adTemplate)) {
            q(gVar);
            if ((gVar.gW() || !V(gVar.mAdTemplate) || gVar.rX) ? false : true) {
                w(gVar);
                return;
            } else {
                x(gVar);
                gVar.iz();
                return;
            }
        }
        long jAg = com.kwad.sdk.core.response.b.a.ag(adInfoEl);
        if (!gVar.ss && gVar.sr < jAg) {
            z = false;
        }
        if (z) {
            y(gVar);
        }
        x(gVar);
        gVar.iz();
    }

    private static boolean N(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.el(adTemplate)));
    }

    private static boolean O(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.O(adTemplate);
    }

    private static void w(final com.kwad.components.ad.reward.g gVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.reward.g.a(gVar, com.kwad.components.ad.reward.h.a(gVar, (String) null), new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void ha() {
                gVar.E(true);
                com.kwad.sdk.core.adlog.c.b(adTemplate, 149, gVar.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void G(boolean z) {
                gVar.E(false);
                if (!z) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS);
                }
                f.x(gVar);
                gVar.iz();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hj() {
                gVar.E(false);
                com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(com.kwad.components.ad.reward.g gVar) {
        gVar.rD.i(false);
    }

    private static void y(com.kwad.components.ad.reward.g gVar) {
        gVar.rD.onRewardVerify();
    }

    private static void a(final com.kwad.components.ad.reward.g gVar, final h.b bVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        final JSONObject jSONObject = gVar.mReportExtData;
        long jAd = com.kwad.sdk.core.response.b.a.ad(adInfoEl);
        final h.c cVarA = com.kwad.components.ad.reward.h.a(gVar, (jAd <= 0 || ((long) com.kwad.sdk.core.response.b.a.L(adInfoEl)) <= jAd) ? "观看完整视频即可获取奖励" : "观看视频" + jAd + "s即可获取奖励");
        com.kwad.components.ad.reward.g.a(gVar, cVarA, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void ha() {
                if (gVar.rE != null) {
                    gVar.rE.pause();
                }
                gVar.E(true);
                if (cVarA.getStyle() == 0) {
                    com.kwad.sdk.core.adlog.c.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.adlog.c.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hi() {
                super.hi();
                gVar.E(false);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void G(boolean z) {
                gVar.E(false);
                if (!z) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS);
                }
                h.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.G(z);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hj() {
                gVar.E(false);
                if (gVar.rE != null) {
                    gVar.rE.resume();
                }
                if (cVarA.getStyle() == 1 || cVarA.getStyle() == 2 || cVarA.getStyle() == 5 || cVarA.getStyle() == 8) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
                } else {
                    com.kwad.sdk.core.adlog.c.k(adTemplate, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void hh() {
                super.hh();
                com.kwad.sdk.core.adlog.c.p(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
                com.kwad.components.ad.reward.g gVar2 = gVar;
                gVar2.a(1, gVar2.mContext, 156, 1);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void h(int i, int i2) {
                super.h(i, i2);
                com.kwad.components.ad.reward.g gVar2 = gVar;
                gVar2.a(1, gVar2.mContext, i, i2);
            }
        });
    }
}
