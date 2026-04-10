package com.kwad.sdk.core.i;

import android.app.ActivityManager;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Debug;
import android.os.LocaleList;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements c {
    private static Locale aKg;
    private String aFk;
    private boolean aKe = true;
    private Map<String, String> aKf = new LinkedHashMap();

    private static long aH(long j) {
        if (j > 524288000) {
            return 524288000L;
        }
        return j;
    }

    @Override // com.kwad.sdk.core.i.c
    public final void bt(boolean z) {
        this.aKe = z;
    }

    @Override // com.kwad.sdk.core.i.c
    public final String JS() {
        return this.aKe ? "kwai-android aegon/4.6.3.1" : "kwai-android aegon/4.6.3";
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bI(Context context) {
        return bL(context);
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bJ(Context context) {
        try {
            if (this.aKf.isEmpty()) {
                bK(context);
            }
            StringBuilder sbJT = JT();
            if (this.aKe) {
                sbJT.insert(0, " KRN/3.6.6");
            }
            return sbJT.toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.w("KwaiUAGetter", "getWebViewUASuffix: " + th.getMessage());
            return "";
        }
    }

    private void bK(Context context) {
        this.aKf.put("Yoda", "3.2.11-rc1");
        this.aKf.put("Kwai", "11.8.10");
        this.aKf.put("OS_PRO_BIT", String.valueOf(AbiUtil.isArm64(context) ? 1 : 0));
        this.aKf.put("MAX_PHY_MEM", String.valueOf(br.dS(context) >> 20));
        this.aKf.put("KDT", "PHONE");
        this.aKf.put("AZPREFIX", "az4");
        this.aKf.put("ICFO", "0");
        this.aKf.put("StatusHT", String.valueOf(com.kwad.sdk.c.a.a.bh(context)));
        this.aKf.put("TitleHT", "44");
        this.aKf.put("NetType", bM(context));
        this.aKf.put("ISLP", String.valueOf(bN(context)));
        this.aKf.put("ISDM", String.valueOf(bO(context)));
        int iDR = br.dR(context);
        this.aKf.put("ISLB", String.valueOf((iDR <= 0 || iDR >= 15) ? 0 : 1));
        this.aKf.put("locale", JU());
        this.aKf.put("SHP", String.valueOf(m.getScreenHeight(context)));
        this.aKf.put("SWP", String.valueOf(m.getScreenWidth(context)));
        this.aKf.put("SD", String.valueOf(m.cK(context)));
        this.aKf.put("CD", "0");
        this.aKf.put("ISLM", String.valueOf(bP(context)));
    }

    private StringBuilder JT() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.aKf.entrySet()) {
            sb.append(" ").append(entry.getKey()).append("/").append(entry.getValue());
        }
        return sb;
    }

    private String bL(Context context) {
        if (!TextUtils.isEmpty(this.aFk)) {
            return this.aFk;
        }
        if (context == null) {
            return "";
        }
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(this.aFk)) {
            return this.aFk;
        }
        this.aFk = WebSettings.getDefaultUserAgent(context);
        return this.aFk;
    }

    private static String bM(Context context) {
        NetworkInfo networkInfoDe;
        if (context == null || (networkInfoDe = ao.de(context)) == null) {
            return "DISABLE";
        }
        int type = networkInfoDe.getType();
        if (type != 0) {
            return type != 1 ? "unknown" : "WIFI";
        }
        String subtypeName = networkInfoDe.getSubtypeName();
        return TextUtils.isEmpty(subtypeName) ? networkInfoDe.getTypeName() : subtypeName;
    }

    private static int bN(Context context) {
        return !AbiUtil.isArm64(context) || ((br.dS(context) >> 20) > 4096L ? 1 : ((br.dS(context) >> 20) == 4096L ? 0 : -1)) <= 0 ? 1 : 0;
    }

    private static int bO(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return 0;
        }
    }

    private static int bP(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return !memoryInfo.lowMemory && (memoryInfo.availMem > (aH(memoryInfo.threshold) + aI(Debug.getPss())) ? 1 : (memoryInfo.availMem == (aH(memoryInfo.threshold) + aI(Debug.getPss())) ? 0 : -1)) > 0 ? 0 : 1;
    }

    private static String JU() {
        Locale locale = LocaleList.getDefault().get(0);
        aKg = locale;
        if (locale == null) {
            aKg = Locale.CHINESE;
        }
        return aKg.getLanguage();
    }

    private static long aI(long j) {
        long j2;
        long j3 = j / 512000;
        if (j3 == 0) {
            return 524288000L;
        }
        if (j3 == 1) {
            j2 = j / 2;
        } else {
            j2 = j / 3;
        }
        return j2 * 1024;
    }
}
