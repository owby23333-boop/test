package com.duokan.reader.domain.cloud.push;

import android.text.TextUtils;
import com.xiaomi.ad.mediation.InterstitialTypeChecker;

/* JADX INFO: loaded from: classes3.dex */
public interface MessageWakeupListener {

    public enum MessageSubType {
        MESSAGE_LOOPER,
        BBS_FEEDBACK,
        USER_TASK,
        FICTION_UPDATE,
        RESIGN_SUCCEED,
        RECHARGE_SUCCEED,
        COUPONS_UPDATE;

        public static MessageSubType value(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.equals(str, "20")) {
                return MESSAGE_LOOPER;
            }
            if (TextUtils.equals(str, InterstitialTypeChecker.INTERSTITIAL_IMAGE_HOR)) {
                return BBS_FEEDBACK;
            }
            if (TextUtils.equals(str, InterstitialTypeChecker.INTERSTITIAL_FULL_VIDEO)) {
                return USER_TASK;
            }
            if (TextUtils.equals(str, "23")) {
                return RESIGN_SUCCEED;
            }
            if (TextUtils.equals(str, InterstitialTypeChecker.INTERSTITIAL_HALF_VIDEO)) {
                return RECHARGE_SUCCEED;
            }
            if (TextUtils.equals(str, InterstitialTypeChecker.INTERSTITIAL_HALF_VIDEO_IMG_HOR)) {
                return COUPONS_UPDATE;
            }
            return null;
        }
    }

    void a(MessageSubType messageSubType, Object obj, boolean z);
}
