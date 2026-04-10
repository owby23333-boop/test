package com.yuewen;

import android.text.TextUtils;
import com.xiaomi.ad.mediation.feedad.MMFeedAd;

/* JADX INFO: loaded from: classes11.dex */
public class my1 {
    public static boolean a(MMFeedAd mMFeedAd) {
        if (mMFeedAd == null) {
            return false;
        }
        if (mMFeedAd.getInteractionType() == 1) {
            return !b(mMFeedAd.getPermissionUrl(), mMFeedAd.getDeveloperName(), mMFeedAd.getAppName(), mMFeedAd.getAppVersion(), mMFeedAd.getPrivacyUrl(), mMFeedAd.getFunctionDescUrl());
        }
        return true;
    }

    public static boolean b(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }
}
