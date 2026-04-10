package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.h;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static List<c> avA = null;
    private static a avB = null;
    private static Map<String, com.kwad.sdk.commercial.c.c> avC = null;
    private static float avu = -1.0f;
    private static double avv = -1.0d;
    private static final AtomicBoolean avw = new AtomicBoolean();
    private static final AtomicBoolean avx = new AtomicBoolean();
    private static boolean avy;
    private static volatile boolean avz;

    public interface a {
        boolean CI();

        boolean CJ();

        JSONObject CK();

        String CL();

        void j(String str, String str2, boolean z);
    }

    public static synchronized void a(final a aVar, final boolean z) {
        if (avy) {
            return;
        }
        avy = true;
        avB = aVar;
        h.execute(new bg() { // from class: com.kwad.sdk.commercial.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    b.b(aVar, z);
                    b.DQ();
                    b.avw.set(true);
                    b.ow();
                } catch (Throwable th) {
                    b.avx.set(true);
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DQ() {
        try {
            avC = new HashMap();
            JSONObject jSONObjectCK = avB.CK();
            if (jSONObjectCK == null) {
                return;
            }
            Iterator<String> itKeys = jSONObjectCK.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectCK.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    a(next, jSONObjectOptJSONObject.optJSONArray("ratio"));
                    b(next, jSONObjectOptJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String strA = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = avC.get(strA);
                        if (cVar2 != null) {
                            cVar2.awb = true;
                            cVar2.avY = Double.parseDouble(str);
                        } else {
                            cVar.awb = true;
                            cVar.avY = Double.parseDouble(str);
                            avC.put(strA, cVar);
                        }
                    }
                }
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    private static void b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String strA = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = avC.get(strA);
                        if (cVar2 != null) {
                            cVar2.awc = true;
                            cVar2.avZ = Double.parseDouble(str);
                        } else {
                            cVar.awc = true;
                            cVar.avZ = Double.parseDouble(str);
                            avC.put(strA, cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    private static String a(com.kwad.sdk.commercial.c.b bVar, String str) {
        try {
            int iLastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && iLastIndexOf != -1) {
                bVar.awa = str.substring(iLastIndexOf + 1);
                return str.substring(0, iLastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    private static com.kwad.sdk.commercial.c.b a(c cVar) {
        double d;
        double d2;
        String str;
        com.kwad.sdk.commercial.c.c cVar2;
        com.kwad.sdk.commercial.c.c cVar3;
        com.kwad.sdk.commercial.c.b bVar = new com.kwad.sdk.commercial.c.b();
        try {
            if (com.kwad.framework.a.a.oz.booleanValue()) {
                bVar.avY = cVar.avI;
            } else {
                bVar.avY = cVar.avH;
            }
            bVar.avZ = cVar.avJ;
            if (!avC.containsKey(cVar.eventId) || (cVar3 = avC.get(cVar.eventId)) == null) {
                d = -1.0d;
                d2 = -1.0d;
            } else {
                d = cVar3.awb ? cVar3.avY : -1.0d;
                d2 = cVar3.awc ? cVar3.avZ : -1.0d;
                if (!TextUtils.isEmpty(cVar3.awa)) {
                    bVar.awa = cVar3.awa;
                }
            }
            if (TextUtils.isEmpty(cVar.primaryKey) && com.kwad.framework.a.a.oz.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str2 = cVar.eventId;
            if (!TextUtils.isEmpty(cVar.primaryKey)) {
                if (cVar.msg.has(cVar.primaryKey)) {
                    str = str2 + "_" + cVar.msg.opt(cVar.primaryKey);
                } else {
                    str = str2 + "_" + cVar.primaryKey;
                }
                if (avC.containsKey(str) && (cVar2 = avC.get(str)) != null) {
                    if (cVar2.awb) {
                        d = cVar2.avY;
                    }
                    if (cVar2.awc) {
                        d2 = cVar2.avZ;
                    }
                    if (!TextUtils.isEmpty(cVar2.awa)) {
                        bVar.awa = cVar2.awa;
                    }
                }
            }
            if (d != -1.0d) {
                bVar.avY = d;
            }
            if (d2 != -1.0d) {
                bVar.avZ = d2;
            } else {
                bVar.avZ = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BK();
            }
            cVar.avH = bVar.avY;
            cVar.avJ = bVar.avZ;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static void b(c cVar) {
        c.a aVarTo;
        if (avz) {
            com.kwad.sdk.commercial.c.b bVarA = a(cVar);
            if (avu == -1.0f) {
                avu = new Random().nextFloat();
            }
            if (avv == -1.0d) {
                avv = new Random().nextFloat();
            }
            if ((avB.CJ() || avu <= bVarA.avY) && bx.aA(BuildConfig.VERSION_NAME, bVarA.awa)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(a(cVar.category, cVar))) {
                        aVarTo = c.a.Tn();
                    } else {
                        aVarTo = c.a.To();
                    }
                    com.kwai.adclient.kscommerciallogger.a.Te().a(aVarTo.c(cVar.avK).b(cVar.avL).hN(TextUtils.isEmpty(cVar.tag) ? cVar.eventId : cVar.tag).b(cVar.avM).hO(cVar.eventId).A(a(cVar.msg, bVarA)).Tp());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    private static void c(c cVar) {
        if (avA == null) {
            avA = new CopyOnWriteArrayList();
        }
        avA.add(cVar);
    }

    public static synchronized void d(c cVar) {
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            if (cVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                com.kwad.sdk.core.d.c.e("KCLogReporter", "reportItem: " + cVar);
            } else {
                com.kwad.sdk.core.d.c.d("KCLogReporter", "reportItem: " + cVar);
            }
        }
        if (!avw.get()) {
            if (!avx.get()) {
                c(cVar);
            }
        } else {
            b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar, boolean z) {
        boolean zCI = aVar.CI();
        avz = zCI;
        if (zCI) {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "publish_type", 0);
            aa.putValue(jSONObject, "plug_sdk", z ? 1 : 0);
            com.kwai.adclient.kscommerciallogger.a.Te().a(new com.kwad.sdk.commercial.a(), new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.b.3
                @Override // com.kwai.adclient.kscommerciallogger.a.b
                public final void M(String str, String str2) {
                    N(str, str2);
                }

                private void N(String str, String str2) {
                    aVar.j(str, str2, false);
                }
            }, jSONObject, com.kwad.framework.a.a.oz.booleanValue(), com.kwad.framework.a.a.oz.booleanValue());
            com.kwad.sdk.commercial.h.a.Ea().cS(aVar.CL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void ow() {
        List<c> list = avA;
        if (list == null) {
            return;
        }
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        avA.clear();
        avA = null;
    }

    private static String a(String str, c cVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || avv >= cVar.avJ) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(str).i(0.001d).O(ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", "init_status").b(BusinessType.AD_SDK_INIT).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_reward_check_result", "check_type").b(BusinessType.AD_REWARD).z(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", "load_status").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(z ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", "download_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.beM));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", "page_status").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bep));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z ? "ad_sdk_reward_callback_interaction" : "ad_sdk_fullscreen_callback_interaction", "callback_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O(z ? "ad_sdk_reward_callback_load" : "ad_sdk_fullscreen_callback_load", "callback_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.5d).O("ad_sdk_webview_track", "scene_id").b(BusinessType.AD_WEBVIEW).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(z ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", "reward_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.beS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O(str, "reward_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.beS));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(0.01d).O("ad_sdk_reward_performance", "reward_type").b(BusinessType.AD_REWARD).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void i(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_reward_performance", "page_status").b(BusinessType.AD_REWARD).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.DS().cF(str).i(1.0E-4d).O("union_web_cache_download_event", "state").b(BusinessType.WEB_CACHE).z(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(c.DS().cF(str).i(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).O("union_web_cache_load_event", "state").b(BusinessType.WEB_CACHE).z(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            d(c.DS().cF(str).i(1.0d).O("union_webview_load_event", "state").z(webViewLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            if (webViewCommercialMsg.rate >= 0.0d) {
                aa.putValue(webViewCommercialMsg.msg, "ratio", webViewCommercialMsg.rate);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            d(c.DS().cF(str).i(webViewCommercialMsg.rate).O(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).b(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).h(webViewCommercialMsg.msg).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(j jVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0E-5d).O("ad_perf_monitor_net_success", "network_monitor").z(jVar).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(i iVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_perf_monitor_net_error", "network_monitor").z(iVar).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(com.kwad.sdk.utils.b.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_union_kv_fail_rate", "kv").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void j(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.4
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_load", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_load", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.5
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_preload", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.1d).O("ad_sdk_splash_preload", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(final boolean z, final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.6
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_splash_single_cache", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bey));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(z ? 1.0d : 0.01d).O("ad_sdk_splash_single_cache", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bey));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.7
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bey));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bey));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.8
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_show", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_splash_show", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void n(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.9
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_view_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_view_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.10
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_template_data_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_template_data_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void p(final com.kwad.sdk.commercial.c.a aVar) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BZ()) {
            h.schedule(new bg() { // from class: com.kwad.sdk.commercial.b.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_errorcode_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).O("ad_sdk_splash_monitor_errorcode_error", NotificationCompat.CATEGORY_STATUS).b(BusinessType.AD_SPLASH).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("load_status");
            d(c.DS().cF((iOptInt == 3 || iOptInt == 4 || iOptInt == 7) ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(1.0d).j(0.1d).k(0.001d).O("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.bez).h(jSONObject));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(str).i(0.001d).O("ad_sdk_resource_warmup", "warm_up").b(BusinessType.OTHER).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(str).i(0.001d).O("ad_sdk_local_warmup", "warm_up").b(BusinessType.OTHER).z(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void q(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_block_info", "block").a(com.kwai.adclient.kscommerciallogger.model.b.beS).z(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void r(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_image_load_perf", "image_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void s(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_thread_monitor", "thread_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void t(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.001d).O("ad_video_load_perf", "video_load_perf").cG("ad_video_load_perf").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void u(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.001d).O("ad_video_load_failed", "video_load_failed").cG("ad_video_load_failed").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void v(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_sdk_aggregation_monitor", "ranger").cG("ad_sdk_aggregation_monitor").z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void w(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_wayne_player_vse_monitor", NotificationCompat.CATEGORY_STATUS).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void x(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_installer_info", NotificationCompat.CATEGORY_STATUS).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bfb));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void y(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.01d).O("ad_sdk_uaid_data_performance", NotificationCompat.CATEGORY_STATUS).z(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.c.b bVar) {
        try {
            aa.putValue(jSONObject, "ratio", bVar.avY);
            if (bVar.avY > 0.0d) {
                aa.putValue(jSONObject, "ratio_count", a(1.0d, bVar.avY, 0));
            }
            aa.putValue(jSONObject, "debug_mode", com.kwad.framework.a.a.oz.booleanValue() ? 1 : 0);
            aa.putValue(jSONObject, "convert_ratio", bVar.avZ);
            if (bVar.avZ > 0.0d) {
                aa.putValue(jSONObject, "convert_ratio_count", a(1.0d, bVar.avZ, 0));
            }
            return jSONObject;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return jSONObject;
        }
    }

    private static double a(double d, double d2, int i) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d2)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
