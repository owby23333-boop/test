package com.bytedance.sdk.openadsdk.core.video.dl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.android.metrics.LiveMetricsBuilder;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.dl;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.ti;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.gz.g;
import com.bytedance.sdk.openadsdk.hh.e;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static String dl(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    public static void z(final String str, final na naVar, final long j) {
        e.g(new fo("csj_live_log_event") { // from class: com.bytedance.sdk.openadsdk.core.video.dl.z.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ti tiVarIa = naVar.ia();
                    String strNz = naVar.nz();
                    if (TextUtils.isEmpty(strNz) && tiVarIa != null) {
                        strNz = tiVarIa.g();
                    }
                    if (TextUtils.isEmpty(strNz)) {
                        return;
                    }
                    String strM = tiVarIa != null ? tiVarIa.m() : null;
                    if (TextUtils.isEmpty(strM)) {
                        strM = naVar.aq();
                    }
                    JSONObject jSONObjectFilterParam = LiveMetrics.filterParam(new LiveMetricsBuilder().roomId(Long.parseLong(strNz)).anchorId(tiVarIa != null ? tiVarIa.z() : "").requestId(strM).enterFromMerge(z.g(eo.gz(naVar))).enterMethod(z.z(eo.gz(naVar))).actionType(ActionType.CLICK).duration(j).build(), z.z(zw.getContext()));
                    jSONObjectFilterParam.put("tob_extra", naVar.vk());
                    m.g(str, jSONObjectFilterParam);
                } catch (Throwable th) {
                    wp.dl("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static Map<String, String> z(Context context) {
        HashMap map = new HashMap();
        map.put("device_id", tb.dl());
        map.put("sdk_version", gk.f1105a);
        map.put(an.x, "Android");
        map.put(an.y, Build.VERSION.RELEASE);
        map.put("device_model", uy.g());
        map.put(an.z, oq.gc(context) + "x" + oq.a(context));
        map.put("language", Locale.getDefault().getLanguage());
        map.put(an.M, String.valueOf(g()));
        map.put(an.Q, v.e(context));
        map.put("openudid", uy.z());
        map.put("aid", "1371");
        map.put(an.s, com.bytedance.sdk.openadsdk.core.gz.z.gc());
        map.put("app_version", com.bytedance.sdk.openadsdk.core.gz.z.a());
        map.put("package", eo.fo());
        map.put(TtmlNode.TAG_REGION, Locale.getDefault().getCountry());
        map.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        map.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        map.put("rom", z());
        map.put(an.H, Build.MANUFACTURER);
        ArrayList<String> arrayListZ = dl.z(context, "MD5");
        if (arrayListZ != null && !arrayListZ.isEmpty()) {
            map.put("sig_hash", Build.MANUFACTURER);
        }
        map.put("display_density", dl(oq.gz(context)));
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        map.put("density_dpi", String.valueOf(oq.gz(context)));
        map.put(an.F, Build.BRAND);
        map.put("build_serial", uy.kb());
        map.put("version_code", eo.uy());
        map.put("udid", uy.gz());
        map.put("cpu_abi", Build.CPU_ABI);
        map.put("oaid", uy.dl(false));
        return map;
    }

    public static EnterMethod z(int i) {
        if (i == 5) {
            return EnterMethod.LIVE_CARD;
        }
        if (i == 7 || i == 8 || i == 9) {
            return EnterMethod.LIVE_CELL;
        }
        return EnterMethod.NO_VALUE;
    }

    public static EnterFromMerge g(int i) {
        if (i == 7) {
            return EnterFromMerge.AD_UNION_EXCITATION;
        }
        if (i == 8) {
            return EnterFromMerge.AD_UNION_INSERT;
        }
        if (i == 5) {
            return EnterFromMerge.AD_UNION_FEED;
        }
        if (i == 9) {
            return EnterFromMerge.AD_UNION_DRAW;
        }
        return EnterFromMerge.NO_VALUE;
    }

    public static boolean z(na naVar) {
        return gk.a() && com.bytedance.sdk.openadsdk.core.iq.eo.z(naVar);
    }

    public static void g(na naVar) {
        if (naVar != null && z(naVar)) {
            String strGz = com.bytedance.sdk.openadsdk.core.iq.eo.gz(naVar);
            String strFo = com.bytedance.sdk.openadsdk.core.iq.eo.fo(naVar);
            if (!TextUtils.isEmpty(strGz)) {
                g.z(strGz).to(new io() { // from class: com.bytedance.sdk.openadsdk.core.video.dl.z.2
                    @Override // com.bytedance.sdk.component.m.io
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.m.io
                    public void onSuccess(ls lsVar) {
                    }
                });
            }
            if (TextUtils.isEmpty(strFo)) {
                return;
            }
            g.z(strFo).to(new io() { // from class: com.bytedance.sdk.openadsdk.core.video.dl.z.3
                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls lsVar) {
                }
            });
        }
    }

    private static String z() {
        StringBuilder sb = new StringBuilder();
        try {
            if (sy.ls()) {
                sb.append("MIUI-");
            } else if (sy.tb()) {
                sb.append("FLYME-");
            } else {
                String strQ = sy.q();
                if (sy.z(strQ)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strQ)) {
                    sb.append(strQ).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static int g() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }
}
