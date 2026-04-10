package com.yuewen;

import android.text.TextUtils;
import com.duokan.adbridge.bean.CommonAdInfo;

/* JADX INFO: loaded from: classes11.dex */
public class e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10504a = "AdDataHelper";

    public static boolean a(CommonAdInfo commonAdInfo) {
        if (commonAdInfo == null) {
            qt1.a(f10504a, "checkCompliance adInfo = null");
            return false;
        }
        if (TextUtils.equals(commonAdInfo.S, "videoAd")) {
            boolean z = !b(commonAdInfo.y, commonAdInfo.B, commonAdInfo.i);
            qt1.a(f10504a, "videoAd checkCompliance isCompliance = " + z);
            return z;
        }
        if (commonAdInfo.o != CommonAdInfo.n0) {
            qt1.a(f10504a, "checkCompliance return true");
            return true;
        }
        boolean z2 = !b(commonAdInfo.i(), commonAdInfo.e(), commonAdInfo.h(), commonAdInfo.k(), commonAdInfo.j(), commonAdInfo.g());
        qt1.a(f10504a, "checkCompliance isCompliance = " + z2);
        return z2;
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
