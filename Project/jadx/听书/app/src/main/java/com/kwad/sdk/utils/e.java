package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static final Map<String, List<String>> aYp;

    static {
        HashMap map = new HashMap();
        aYp = map;
        map.put("huawei", Arrays.asList("com.huawei.appmarket"));
        map.put("oppo", Arrays.asList("com.oppo.market", "com.heytap.market"));
        map.put("vivo", Arrays.asList("com.bbk.appstore"));
        map.put(MediationConstant.ADN_XIAOMI, Arrays.asList("com.xiaomi.market"));
        map.put("oneplus", Arrays.asList("com.oppo.market"));
        map.put("meizu", Arrays.asList("com.meizu.mstore"));
        map.put("samsung", Arrays.asList("com.sec.android.app.samsungapps"));
        map.put("smartisan", Arrays.asList("com.smartisanos.appstore"));
        map.put("realme", Arrays.asList("com.oppo.market"));
        map.put("honor", Arrays.asList("com.hihonor.appmarket", "com.huawei.appmarket"));
    }

    public static boolean a(Context context, final String str, final AdTemplate adTemplate) {
        if (bb.Rl() && adTemplate.mAdScene != null && adTemplate.mAdScene.adStyle != 4) {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.commercial.b.a.a(adTemplate, "com.xiaomi.market", 0, 1);
                return false;
            }
            if (com.kwad.sdk.core.download.a.b.a(context, str, new b.C0399b() { // from class: com.kwad.sdk.utils.e.1
                @Override // com.kwad.sdk.core.download.a.b.C0399b, com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    super.onStart();
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str, "com.xiaomi.market", 0, 1);
                }

                @Override // com.kwad.sdk.core.download.a.b.C0399b, com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    super.onSuccess();
                    adTemplate.mXiaomiAppStoreDetailViewOpen = true;
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate, str, "com.xiaomi.market", 0, 1);
                }

                @Override // com.kwad.sdk.core.download.a.b.C0399b, com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                    super.onError(th);
                    com.kwad.sdk.commercial.b.a.a(adTemplate, str, "com.xiaomi.market", 0, 1, bw.s(th));
                }
            }) == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(Context context, AdTemplate adTemplate) {
        String str;
        int i;
        String str2;
        Intent intent;
        String str3;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        String strCW = com.kwad.sdk.core.response.b.a.cW(adInfoEl);
        String strAy = com.kwad.sdk.core.response.b.a.ay(adInfoEl);
        List<String> arrayList = aYp.get(Build.BRAND.toLowerCase());
        if (arrayList == null || arrayList.isEmpty()) {
            arrayList = new ArrayList<>();
            str = "";
        } else {
            str = arrayList.get(0);
        }
        String str4 = str;
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(strCW)) {
            com.kwad.sdk.commercial.b.a.a(adTemplate, str4, 1, 0);
            return false;
        }
        try {
            if ("samsung".equals(Build.BRAND)) {
                strCW = "http://apps.samsung.com/appquery/appDetail.as?appId=" + strAy;
            }
            com.kwad.sdk.commercial.b.a.a(adTemplate, strCW, str4, 1, 0);
            intent = new Intent("android.intent.action.VIEW", Uri.parse(strCW));
            intent.addFlags(268435456);
        } catch (Throwable th) {
            th = th;
            i = 1;
            str2 = strCW;
        }
        for (String str5 : arrayList) {
            PackageInfo packageInfo = y.getPackageInfo(context, str5, 1);
            if (packageInfo != null && (str3 = packageInfo.packageName) != null && str3.equals(str5)) {
                intent.setPackage(str3);
                intent.setFlags(268435456);
                context.startActivity(intent);
                adTemplate.mClickOpenAppStore = true;
                com.kwad.sdk.commercial.b.a.b(adTemplate, strCW, str5, 1, 0);
                return true;
            }
            com.kwad.sdk.commercial.b.a.a(adTemplate, str2, str4, i, 0, bw.s(th));
            return false;
        }
        try {
            context.startActivity(intent);
            adTemplate.mClickOpenAppStore = true;
            com.kwad.sdk.commercial.b.a.b(adTemplate, strCW, str4, 0, 0);
            return true;
        } catch (Throwable th2) {
            th = th2;
            str2 = strCW;
            i = 0;
        }
    }
}
