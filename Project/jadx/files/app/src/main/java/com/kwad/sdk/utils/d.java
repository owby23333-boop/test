package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final Map<String, String> axL;

    static {
        HashMap map = new HashMap();
        axL = map;
        map.put("HUAWEI", "com.huawei.appmarket");
        axL.put("OPPO", "com.oppo.market");
        axL.put(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO, "com.bbk.appstore");
        axL.put(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI, "com.xiaomi.market");
        axL.put("OnePlus", "com.oppo.market");
        axL.put("Meizu", "com.meizu.mstore");
        axL.put("samsung", "com.sec.android.app.samsungapps");
        axL.put("SMARTISAN", "com.smartisanos.appstore");
        axL.put("Realme", "com.oppo.market");
        axL.put("HONOR", "com.huawei.appmarket");
    }

    private static boolean A(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (!ar.DN() || (sceneImpl = adTemplate.mAdScene) == null || sceneImpl.adStyle == 4 || com.kwad.sdk.core.download.kwai.b.g(context, str) != 1) {
            return false;
        }
        adTemplate.mXiaomiAppStoreDetailViewOpen = true;
        return true;
    }

    private static boolean a(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        return resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || TextUtils.isEmpty(activityInfo.packageName);
    }

    private static boolean eb(String str) {
        return "OPPO".equals(Build.BRAND) && "com.heytap.market".equals(str);
    }

    public static boolean g(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("samsung".equals(Build.BRAND)) {
            str = "http://apps.samsung.com/appquery/appDetail.as?appId=" + str2;
        }
        try {
            String str3 = axL.get(Build.BRAND);
            Uri uri = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                if (!a(resolveInfo)) {
                    String str4 = resolveInfo.activityInfo.packageName;
                    if (str4.equals(str3) || eb(str4)) {
                        intent.setComponent(new ComponentName(str4, resolveInfo.activityInfo.name));
                        context.startActivity(intent);
                        return true;
                    }
                }
            }
            return A(context, str);
        } catch (Exception unused) {
            return A(context, str);
        }
    }
}
