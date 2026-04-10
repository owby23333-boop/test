package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static ExecutorService axm = GlobalThreadPools.Js();
    public static JSONObject axn;
    public static boolean axo;

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.cj(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, aj.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.mI = i;
        if (adTemplate.swipeAngle != 0) {
            aVar2.ayv = adTemplate.swipeAngle;
        }
        if (aVar != null) {
            aVar2.mK = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.EM() : null, jSONObject);
    }

    public static boolean b(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo adInfoEl = e.el(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.dr(Ey());
        com.kwad.sdk.core.adlog.c.a aVarEM = bVar.EM();
        if (adTemplate.fromCache) {
            aVarEM.a(h.cj(adTemplate));
        }
        aVarEM.aym = G(adInfoEl) ? 1 : 0;
        return a(adTemplate, 1, aVarEM, jSONObject);
    }

    private static int Ey() {
        return aq.isOrientationPortrait() ? 2 : 1;
    }

    private static boolean G(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String strAy = com.kwad.sdk.core.response.b.a.ay(adInfo);
        if (TextUtils.isEmpty(strAy)) {
            return false;
        }
        return as.ap(fVar.getContext(), strAy);
    }

    public static void a(AdTemplate adTemplate, long j, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0392a c0392a = new a.C0392a();
        if (j != -1) {
            c0392a.duration = j;
            aVar.Pk = c0392a;
        }
        a(adTemplate, 934, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, long j, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axL = i;
        a.C0392a c0392a = new a.C0392a();
        c0392a.duration = j;
        aVar.Pk = c0392a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.EM() : null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, long j2, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.yU = j;
        aVar.ayo = i2;
        aVar.axL = i;
        a.C0392a c0392a = new a.C0392a();
        c0392a.duration = j2;
        aVar.Pk = c0392a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void bR(AdTemplate adTemplate) {
        q(adTemplate, 4);
    }

    public static void bS(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        adTemplate.downLoadType = 3;
        aVar.a(new a.C0392a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0392a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 33, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0392a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 34, aVar, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo adInfoEl = e.el(adTemplate);
        String str = adInfoEl.downloadFilePath;
        if (str == null) {
            return;
        }
        String strAy = com.kwad.sdk.core.response.b.a.ay(adInfoEl);
        String strHf = as.hf(str);
        if (strHf == null || TextUtils.isEmpty(strHf) || strHf.equals(strAy)) {
            return;
        }
        bVar.du(strHf);
        bVar.dt(strAy);
        adInfoEl.adBaseInfo.appPackageName = strHf;
    }

    public static void c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        axm.submit(new bg() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.C0392a c0392a = new a.C0392a();
                c0392a.awZ = adTemplate.downLoadType;
                com.kwad.sdk.core.adlog.c.b bVarDg = new com.kwad.sdk.core.adlog.c.b().b(c0392a).dg(adTemplate.downloadSource);
                c.a(adTemplate, bVarDg);
                c.a(adTemplate, 31, bVarDg.EM(), jSONObject);
                AdInfo adInfoEl = e.el(adTemplate);
                as.av(adInfoEl.downloadFilePath, adInfoEl.downloadId);
            }
        });
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new a.C0392a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        axm.submit(new bg() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo adInfoEl = e.el(adTemplate);
                int iAw = as.aw(adInfoEl.downloadId, com.kwad.sdk.core.response.b.a.ay(adInfoEl));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                aVar.downloadSource = adTemplate.downloadSource;
                aVar.aya = iAw;
                aVar.ayb = adTemplate.installFrom;
                aVar.a(new a.C0392a());
                aVar.Pk.awZ = adTemplate.downLoadType;
                c.a(adTemplate, 32, aVar, jSONObject);
            }
        });
    }

    public static void bT(AdTemplate adTemplate) {
        q(adTemplate, 36);
    }

    public static void bU(AdTemplate adTemplate) {
        q(adTemplate, 38);
    }

    public static void bV(AdTemplate adTemplate) {
        q(adTemplate, 41);
    }

    public static void bW(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayf = com.kwad.sdk.core.response.b.a.ay(e.el(adTemplate));
        a(adTemplate, 768, aVar, new JSONObject());
    }

    public static void h(AdTemplate adTemplate, int i) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayr = i;
        aVar.a(new a.C0392a());
        aVar.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.Pl = i;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, aVar, (JSONObject) null);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.ayc = aVar.toJson().toString();
        aVar2.a(new a.C0392a());
        aVar2.Pk.awZ = adTemplate.downLoadType;
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void bX(AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void bY(AdTemplate adTemplate) {
        g(adTemplate, (JSONObject) null);
    }

    public static void g(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL, jSONObject);
    }

    public static void h(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axL = 1;
        aVar.Pk = new a.C0392a();
        aVar.Pk.templateId = "101";
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.axX = i;
        if (!str.equals("")) {
            aVar.axY = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.axX = i;
        if (!str.equals("")) {
            aVar.axY = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, String str, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axX = i;
        if (!str.equals("")) {
            aVar.axY = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axZ = i;
        b(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void k(AdTemplate adTemplate, int i) {
        h(adTemplate, i, 0);
    }

    public static void h(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayl = i;
        aVar.Pm = i2;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void g(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0392a c0392a = new a.C0392a();
        if (z) {
            c0392a.axd = 1;
        } else {
            c0392a.axd = 2;
        }
        aVar.a(c0392a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void h(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        a.C0392a c0392a = new a.C0392a();
        if (z) {
            c0392a.axd = 1;
        } else {
            c0392a.axd = 2;
        }
        aVar.a(c0392a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, aVar, (JSONObject) null);
    }

    public static void bZ(AdTemplate adTemplate) {
        q(adTemplate, 58);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j) {
        aVar.ayj = j;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void l(AdTemplate adTemplate, long j) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.EK().av(j), (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void i(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axM = 69;
        aVar.ayh = i;
        aVar.ayi = i2;
        a(adTemplate, 501, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, jSONObject);
    }

    public static void k(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, jSONObject);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, bVar != null ? bVar.EM() : null, (JSONObject) null);
    }

    public static void l(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axK = i;
        a(adTemplate, 759, aVar, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axJ = i;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axJ = i;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void ca(AdTemplate adTemplate) {
        q(adTemplate, 914);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().df(i));
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a aVarEM = bVar.EM();
        aVarEM.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, aVarEM, jSONObject);
    }

    public static void n(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayf = com.kwad.sdk.core.response.b.a.ay(e.el(adTemplate));
        a(adTemplate, i, aVar, new JSONObject());
    }

    public static void c(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayf = com.kwad.sdk.core.response.b.a.ay(e.el(adTemplate));
        aVar.axM = 93;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, aVar, (JSONObject) null);
    }

    public static void o(AdTemplate adTemplate, int i) {
        a(adTemplate, i, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void p(AdTemplate adTemplate, int i) {
        e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(i));
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a aVarEM = bVar.EM();
        aVarEM.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, aVarEM, jSONObject);
    }

    public static void m(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.axO = j;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == -9999 || i == 6) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.axP = i;
            if (adExposureFailedReason != null) {
                aVar.axQ = adExposureFailedReason.winEcpm;
                try {
                    aVar.adnType = adExposureFailedReason.adnType;
                    if (adExposureFailedReason.adnType == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adUserName)) {
                        aVar.axR = adExposureFailedReason.adUserName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adTitle)) {
                        aVar.axS = adExposureFailedReason.adTitle;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adRequestId)) {
                        aVar.axT = adExposureFailedReason.adRequestId;
                    }
                    aVar.axU = adExposureFailedReason.isShow;
                    aVar.axV = adExposureFailedReason.isClick;
                    aVar.adnMaterialType = adExposureFailedReason.adnMaterialType;
                    aVar.adnMaterialUrl = adExposureFailedReason.adnMaterialUrl;
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, aVar, (JSONObject) null);
        }
    }

    public static void cb(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.b.a.bA(e.el(adTemplate));
        com.kwad.sdk.core.d.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.downloadStatus);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.Pj = str;
        a(adTemplate, i, aVar, jSONObject);
    }

    public static void cc(AdTemplate adTemplate) {
        q(adTemplate, 722);
    }

    public static void cd(AdTemplate adTemplate) {
        q(adTemplate, 721);
    }

    public static void n(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.ayk = j;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0392a c0392a = new a.C0392a();
        c0392a.axa = 1;
        bVar.b(c0392a);
        if (z) {
            bVar.dm(33);
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, bVar.EM(), (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0392a c0392a = new a.C0392a();
        c0392a.axa = 2;
        bVar.b(c0392a);
        if (z) {
            bVar.dm(33);
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL, bVar.EM(), (JSONObject) null);
    }

    private static void q(AdTemplate adTemplate, int i) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    private static void d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static boolean a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (adTemplate == null || !ce(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.ayn = com.kwad.sdk.core.response.b.a.aT(e.el(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i == 2 && axo) {
            if (aVar.Pk == null) {
                aVar.Pk = new a.C0392a();
            }
            aVar.Pk.axg = axn;
        }
        if (i == 1 && e.ef(adTemplate) == 4 && com.kwad.sdk.core.response.b.a.du(e.el(adTemplate))) {
            if (aVar.Pk == null) {
                aVar.Pk = new a.C0392a();
            }
            aVar.Pk.axf = com.kwad.sdk.core.response.b.a.dv(e.el(adTemplate));
        }
        aVar.adTemplate = adTemplate;
        aVar.awx = i;
        aVar.axI = jSONObject;
        com.kwad.sdk.core.d.c.d("AdReportManager", new StringBuilder().append(i).toString());
        b.a(aVar);
        return true;
    }

    private static boolean ce(AdTemplate adTemplate) {
        if (e.ed(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        return fVar != null && fVar.aR(adTemplate);
    }
}
