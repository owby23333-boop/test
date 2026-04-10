package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.logger.model.BusinessType;
import com.kwai.adclient.logger.model.SubBusinessType;
import com.kwai.adclient.logger.model.c;
import com.taobao.accs.common.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class KSLoggerReporter {
    private static float ahW = -1.0f;
    private static double ahX = -1.0d;
    private static boolean ahY;
    private static volatile boolean ahZ;
    private static List<com.kwai.adclient.logger.model.c> aia;
    private static a aib;
    private static final AtomicBoolean sHasInit = new AtomicBoolean();

    public enum ReportClient {
        CORE_CONVERT(ILoggerReporter.Category.APM_LOG, "ad_convert_method_call"),
        CONVERT_H5WEB(ILoggerReporter.Category.APM_LOG, "ad_h5convert_method"),
        CONVERT_DPLINK(ILoggerReporter.Category.APM_LOG, "ad_dplink_convert_method");

        private String mCategory;
        private String mEventId;

        ReportClient(String str, String str2) {
            this.mCategory = str;
            this.mEventId = str2;
        }

        public final b buildMethodCheck(@Nullable BusinessType businessType, String str) {
            return new b(this.mCategory, this.mEventId, businessType, str);
        }
    }

    public interface a {
        @WorkerThread
        void f(String str, String str2, boolean z2);

        @WorkerThread
        boolean sD();

        @WorkerThread
        JSONObject sE();
    }

    public static class b {
        private JSONObject aid = new JSONObject();
        private BusinessType aie;
        private String mCategory;
        private String mEventId;

        b(String str, String str2, @Nullable BusinessType businessType, String str3) {
            this.aie = businessType;
            this.mCategory = str;
            this.mEventId = str2;
            com.kwad.sdk.utils.s.putValue(this.aid, "method_name", str3);
        }

        public final b b(String str, Object obj) {
            com.kwad.sdk.utils.t.a(this.aid, str, obj);
            return this;
        }

        public final void report() {
            KSLoggerReporter.a(new o.a().cl(this.mCategory).a(this.aie).a(SubBusinessType.OTHER).a(com.kwai.adclient.logger.model.a.aCJ).cm(this.mEventId).z(this.aid).xm());
        }
    }

    @NonNull
    private static e a(String str, String str2, JSONObject jSONObject, String str3) {
        e eVar = new e();
        try {
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        if (jSONObject.has("ratio")) {
            eVar.ahM = jSONObject.getDouble("ratio");
            return eVar;
        }
        if (jSONObject.has("ratio_count") && jSONObject.getDouble("ratio_count") > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            eVar.ahM = 1.0d / jSONObject.getDouble("ratio_count");
            return eVar;
        }
        JSONObject jSONObjectSE = aib.sE();
        if (jSONObjectSE == null) {
            if (!com.kwad.b.kwai.a.bI.booleanValue()) {
                return eVar;
            }
            throw new Exception("reportConf未初始化 eventId:" + str2);
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectSE.optJSONObject(ck(str2));
        if (jSONObjectOptJSONObject != null) {
            eVar.a(str, jSONObjectOptJSONObject, str3);
            return eVar;
        }
        if (!com.kwad.b.kwai.a.bI.booleanValue()) {
            return eVar;
        }
        throw new Exception("EventSamplingKey未包含 eventId " + str2);
    }

    private static String a(String str, e eVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || ahX >= eVar.ahN) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    private static JSONObject a(@NonNull JSONObject jSONObject, e eVar) {
        try {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ratio", eVar.ahM);
            if (eVar.ahM > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                com.kwad.sdk.utils.s.putValue(jSONObject, "ratio_count", 1.0d / eVar.ahM);
            }
            com.kwad.sdk.utils.s.putValue(jSONObject, Constants.SP_KEY_DEBUG_MODE, com.kwad.b.kwai.a.bI.booleanValue() ? 1 : 0);
            com.kwad.sdk.utils.s.putValue(jSONObject, "convert_ratio", eVar.ahN);
            if (eVar.ahN > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                com.kwad.sdk.utils.s.putValue(jSONObject, "convert_ratio_count", 1.0d / eVar.ahN);
            }
            return jSONObject;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return jSONObject;
        }
    }

    public static synchronized void a(final a aVar) {
        if (ahY) {
            return;
        }
        ahY = true;
        aib = aVar;
        com.kwad.sdk.utils.g.execute(new av() { // from class: com.kwad.sdk.core.report.KSLoggerReporter.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                KSLoggerReporter.b(aVar);
                KSLoggerReporter.sHasInit.set(true);
                KSLoggerReporter.mO();
            }
        });
    }

    public static void a(@NonNull l lVar, String str) {
        a(new o.a().cl(ILoggerReporter.Category.ERROR_LOG).cm("ad_union_error_log").cn(str).z(lVar.toJson()).xm());
    }

    public static synchronized void a(@NonNull o oVar) {
        if (TextUtils.isEmpty(oVar.tag)) {
            oVar.tag = oVar.eventId;
        }
        a(oVar.category, oVar.biz, oVar.aif, oVar.aig, oVar.eventId, oVar.tag, oVar.suffixRatio, oVar.msg);
    }

    private static synchronized void a(com.kwai.adclient.logger.model.c cVar) {
        if (aia == null) {
            aia = new CopyOnWriteArrayList();
        }
        aia.add(cVar);
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        a(str, BusinessType.WEB_CACHE, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "union_web_cache_download_event", hybridLoadMsg.toJson());
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        double d2 = webViewCommercialMsg.rate;
        if (d2 >= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            com.kwad.sdk.utils.s.putValue(webViewCommercialMsg.msg, "ratio", d2);
        }
        a(str, webViewCommercialMsg.biz, webViewCommercialMsg.subBiz, webViewCommercialMsg.type, webViewCommercialMsg.eventId, webViewCommercialMsg.suffixRatio, webViewCommercialMsg.msg);
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        a(str, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "union_webview_load_event", webViewLoadMsg.toJson());
    }

    @Deprecated
    private static synchronized void a(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.logger.model.d dVar, String str2, String str3, String str4, JSONObject jSONObject) {
        com.kwai.adclient.logger.model.c cVarFS;
        e eVarA = a(str, str2, jSONObject, str4);
        if (ahW == -1.0f) {
            ahW = new Random().nextFloat();
        }
        if (ahX == -1.0d) {
            ahX = new Random().nextFloat();
        }
        if (ahW > eVarA.ahM) {
            return;
        }
        if (bi.ag("3.3.38", eVarA.ahO)) {
            try {
                cVarFS = (ILoggerReporter.Category.ERROR_LOG.equals(a(str, eVarA)) ? c.a.FQ() : c.a.FR()).b(businessType).b(subBusinessType).eO(str3).b(dVar).eP(str2).O(a(jSONObject, eVarA)).FS();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
                com.kwad.sdk.service.kwai.d dVar2 = (com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class);
                if (dVar2 != null) {
                    dVar2.gatherException(th);
                }
            }
            if (sHasInit.get()) {
                b(cVarFS);
            } else {
                a(cVarFS);
            }
        }
    }

    @Deprecated
    private static synchronized void a(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.logger.model.d dVar, String str2, String str3, JSONObject jSONObject) {
        a(str, businessType, subBusinessType, dVar, str2, str2, str3, jSONObject);
    }

    @Deprecated
    public static synchronized void a(String str, BusinessType businessType, SubBusinessType subBusinessType, com.kwai.adclient.logger.model.d dVar, String str2, JSONObject jSONObject) {
        a(str, businessType, subBusinessType, dVar, str2, "", jSONObject);
    }

    public static void a(String str, com.kwai.adclient.logger.model.d dVar, JSONObject jSONObject) {
        a(str, BusinessType.AD_SDK_INIT, SubBusinessType.OTHER, dVar, ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", jSONObject);
    }

    public static void a(boolean z2, JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, z2 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.logger.model.b.aCW, z2 ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", jSONObject);
    }

    public static void a(boolean z2, JSONObject jSONObject, com.kwai.adclient.logger.model.d dVar) {
        a(ILoggerReporter.Category.APM_LOG, z2 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, dVar, z2 ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar) {
        boolean zSD = aVar.sD();
        ahZ = zSD;
        if (zSD) {
            com.kwai.adclient.logger.a.FG().a(new com.kwai.adclient.logger.kwai.a() { // from class: com.kwad.sdk.core.report.KSLoggerReporter.2
                @Override // com.kwai.adclient.logger.kwai.a
                public final void F(String str, String str2) {
                    com.kwad.sdk.core.d.b.w(str, str2);
                }

                @Override // com.kwai.adclient.logger.kwai.a
                public final void G(String str, String str2) {
                    com.kwad.sdk.core.d.b.e(str, str2);
                }
            }, new com.kwai.adclient.logger.kwai.b() { // from class: com.kwad.sdk.core.report.KSLoggerReporter.3
                private void I(String str, String str2) {
                    aVar.f(str, str2, false);
                }

                @Override // com.kwai.adclient.logger.kwai.b
                public final void H(@NonNull String str, @NonNull String str2) {
                    I(str, str2);
                }
            }, null, com.kwad.b.kwai.a.bI.booleanValue(), com.kwad.b.kwai.a.bI.booleanValue());
        }
    }

    public static void b(@NonNull com.kwad.sdk.utils.a.a aVar) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "ad_union_kv_fail_rate", aVar.toJson());
    }

    private static void b(com.kwai.adclient.logger.model.c cVar) {
        if (ahZ) {
            com.kwai.adclient.logger.a.FG().c(cVar);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        a(str, BusinessType.WEB_CACHE, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "union_web_cache_load_event", hybridLoadMsg.toJson());
    }

    public static void b(boolean z2, JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, z2 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.logger.model.a.aCz, z2 ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", jSONObject);
    }

    public static BusinessType bs(int i2) {
        if (i2 == 1) {
            return BusinessType.AD_FEED;
        }
        if (i2 == 2) {
            return BusinessType.AD_REWARD;
        }
        if (i2 == 3) {
            return BusinessType.AD_FULLSCREEN;
        }
        if (i2 == 4) {
            return BusinessType.AD_SPLASH;
        }
        if (i2 != 13) {
            return null;
        }
        return BusinessType.AD_INTERSTITIAL;
    }

    public static void c(com.kwad.sdk.core.network.j jVar) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "ad_perf_monitor_net_error", jVar.toJson());
    }

    public static void c(com.kwad.sdk.core.network.k kVar) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "ad_perf_monitor_net_success", kVar.toJson());
    }

    public static void c(boolean z2, JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, z2 ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN, SubBusinessType.OTHER, com.kwai.adclient.logger.model.b.aDc, z2 ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", jSONObject);
    }

    private static String ck(String str) {
        String str2;
        try {
            String[] strArrSplit = str.split("_");
            StringBuilder sb = new StringBuilder();
            boolean z2 = false;
            for (String str3 : strArrSplit) {
                if (z2) {
                    str2 = Character.toUpperCase(str3.charAt(0)) + str3.substring(1);
                } else {
                    str2 = Character.toLowerCase(str3.charAt(0)) + str3.substring(1);
                    z2 = true;
                }
                sb.append(str2);
            }
            sb.append("ReportRate");
            return new String(sb);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void h(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_WEBVIEW, SubBusinessType.OTHER, com.kwai.adclient.logger.model.a.aCJ, "ad_sdk_webview_track", jSONObject);
    }

    public static void i(JSONObject jSONObject) {
        a(ILoggerReporter.Category.ERROR_LOG, BusinessType.AD_REWARD, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "ad_sdk_reward_performance", jSONObject);
    }

    public static void j(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.logger.model.a.aCJ, "ad_sdk_splash_load", jSONObject);
    }

    public static void k(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.logger.model.a.aCJ, "ad_sdk_splash_preload", jSONObject);
    }

    public static void l(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.logger.model.a.aCI, "ad_sdk_splash_single_cache", jSONObject);
    }

    public static void m(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.logger.model.a.aCI, "ad_sdk_splash_cache", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void mO() {
        if (aia == null) {
            return;
        }
        Iterator<com.kwai.adclient.logger.model.c> it = aia.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        aia.clear();
        aia = null;
    }

    public static void n(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_SPLASH, SubBusinessType.OTHER, com.kwai.adclient.logger.model.a.aCJ, "ad_sdk_splash_show", jSONObject);
    }

    public static void o(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("load_status");
        a(new o.a().cl((iOptInt == 3 || iOptInt == 4 || iOptInt == 7) ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).a(BusinessType.OTHER).a(SubBusinessType.OTHER).a(com.kwai.adclient.logger.model.a.aCJ).cm("ad_sdk_dynamic_update").z(jSONObject).xm());
    }

    public static void p(JSONObject jSONObject) {
        a(new o.a().cl(ILoggerReporter.Category.ERROR_LOG).a(BusinessType.OTHER).a(SubBusinessType.OTHER).a(com.kwai.adclient.logger.model.a.aCJ).cm("ad_sdk_dynamic_run").z(jSONObject).xm());
    }

    public static void q(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.logger.model.a.aCJ, "ad_sdk_interstitial_load", jSONObject);
    }

    public static void r(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.logger.model.b.aCW, "ad_sdk_interstitial_download_error", "1", jSONObject);
    }

    public static void s(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.logger.model.b.aCW, "ad_sdk_interstitial_download_error", jSONObject);
    }

    public static void t(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.logger.model.b.aDc, "ad_sdk_interstitial_play_error", "1", jSONObject);
    }

    public static void u(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.AD_INTERSTITIAL, SubBusinessType.OTHER, com.kwai.adclient.logger.model.b.aDc, "ad_sdk_interstitial_play_error", jSONObject);
    }

    public static void v(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "ad_sdk_block_info", jSONObject);
    }

    public static void w(JSONObject jSONObject) {
        a(ILoggerReporter.Category.APM_LOG, BusinessType.OTHER, SubBusinessType.OTHER, com.kwai.adclient.logger.model.d.aDj, "ad_image_load_perf", jSONObject);
    }

    public static void x(JSONObject jSONObject) {
        a(new o.a().cl(ILoggerReporter.Category.APM_LOG).a(BusinessType.OTHER).a(SubBusinessType.OTHER).a(com.kwai.adclient.logger.model.d.aDj).cm("ad_sdk_ranger_info").z(jSONObject).xm());
    }

    public static void y(JSONObject jSONObject) {
        a(new o.a().cl(ILoggerReporter.Category.APM_LOG).a(BusinessType.OTHER).cn("ad_thread_monitor").a(com.kwai.adclient.logger.model.d.aDj).cm("ad_thread_monitor").z(jSONObject).xm());
    }
}
