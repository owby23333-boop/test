package com.amgcyo.cuttadon.h.d.d;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.f.o;
import com.bytedance.msdk.api.v2.GMAdConfig;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment;
import com.bytedance.msdk.api.v2.GMGdtOption;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.GMPangleOption;
import com.bytedance.msdk.api.v2.GMPrivacyConfig;
import com.fatcatfat.io.R;
import java.util.HashMap;

/* JADX INFO: compiled from: GMAdManagerHolder.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static boolean a;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.d.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GMAdManagerHolder.java */
    class C0097a extends GMPrivacyConfig {
        C0097a() {
        }

        @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
        public GMAdConstant.ADULT_STATE getAgeGroup() {
            return GMAdConstant.ADULT_STATE.AGE_ADULT;
        }

        @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
        public String getMacAddress() {
            return "";
        }

        @Override // com.bytedance.msdk.api.v2.GMPrivacyConfig
        public boolean isCanUsePhoneState() {
            return true;
        }
    }

    private static GMAdConfig a(Context context, String str) {
        GMConfigUserInfoForSegment gMConfigUserInfoForSegment = new GMConfigUserInfoForSegment();
        gMConfigUserInfoForSegment.setUserId("msdk-demo");
        gMConfigUserInfoForSegment.setGender("male");
        gMConfigUserInfoForSegment.setChannel("msdk-channel");
        gMConfigUserInfoForSegment.setSubChannel("msdk-sub-channel");
        gMConfigUserInfoForSegment.setAge(999);
        gMConfigUserInfoForSegment.setUserValueGroup("msdk-demo-user-value-group");
        HashMap map = new HashMap();
        map.put("aaaa", "test111");
        map.put("bbbb", "test222");
        gMConfigUserInfoForSegment.setCustomInfos(map);
        HashMap map2 = new HashMap();
        map2.put("1111", "22222");
        map2.put("22222", "33333");
        map2.put("44444", "5555");
        return new GMAdConfig.Builder().setAppId(str).setAppName(o.d(R.string.app_name)).setDebug(false).setPublisherDid(a(context)).setOpenAdnTest(false).setConfigUserInfoForSegment(gMConfigUserInfoForSegment).setPangleOption(new GMPangleOption.Builder().setIsPaid(false).setTitleBarTheme(1).setAllowShowNotify(true).setAllowShowPageWhenScreenLock(true).setDirectDownloadNetworkType(4, 3).setIsUseTextureView(true).setNeedClearTaskReset(new String[0]).setKeywords("").build()).setGdtOption(new GMGdtOption.Builder().setWxInstalled(false).setOpensdkVer(null).setSupportH265(false).setSupportSplashZoomout(false).build()).setPrivacyConfig(new C0097a()).setLocalExtra(map2).build();
    }

    private static void b(@NonNull Context context, String str) {
        if (a) {
            return;
        }
        GMMediationAdSdk.initialize(context, a(context, str));
        a = true;
    }

    public static void c(Context context, String str) {
        b(context, str);
    }

    private static String a(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
