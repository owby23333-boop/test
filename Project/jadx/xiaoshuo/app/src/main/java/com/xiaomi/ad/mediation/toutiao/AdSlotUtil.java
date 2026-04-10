package com.xiaomi.ad.mediation.toutiao;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.xiaomi.ad.mediation.MMAdConfig;
import com.xiaomi.ad.mediation.MMAdSdk;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;

/* JADX INFO: loaded from: classes5.dex */
public class AdSlotUtil {
    public static AdSlot getAdSlot(Context context, AdInternalConfig adInternalConfig, String str) {
        AdSlot.Builder builder = new AdSlot.Builder();
        builder.setCodeId(adInternalConfig.adPositionId).setSupportDeepLink(adInternalConfig.supportDeeplink).setImageAcceptedSize(adInternalConfig.imageWidth, adInternalConfig.imageHeight).setAdCount(adInternalConfig.adCount);
        if (adInternalConfig.isExpress) {
            int iPx2dip = adInternalConfig.viewWidth;
            if (iPx2dip <= 0) {
                iPx2dip = px2dip(context, adInternalConfig.imageWidth);
            }
            int iPx2dip2 = adInternalConfig.viewHeight;
            if (iPx2dip2 <= 0) {
                iPx2dip2 = px2dip(context, adInternalConfig.imageHeight);
            }
            builder.setExpressViewAcceptedSize(iPx2dip, iPx2dip2);
        }
        int i = adInternalConfig.videoOrientation == MMAdConfig.Orientation.ORIENTATION_HORIZONTAL ? 2 : 1;
        str.hashCode();
        if (str.equals(MMAdSdk.AD_TYPE_REWARD_VIDEO)) {
            builder.setUserID(adInternalConfig.userId).setOrientation(i);
        } else if (str.equals(MMAdSdk.AD_TYPE_FULLSCREEN_INTERSTITIAL)) {
            builder.setOrientation(i);
        }
        return builder.build();
    }

    public static int px2dip(Context context, int i) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = i;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }
}
