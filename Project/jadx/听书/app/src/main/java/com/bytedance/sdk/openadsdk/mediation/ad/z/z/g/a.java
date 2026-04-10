package com.bytedance.sdk.openadsdk.mediation.ad.z.z.g;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Function<SparseArray<Object>, Object> {
    private final IMediationSplashRequestInfo z;

    public a(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.z = iMediationSplashRequestInfo;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String adnName = "";
        switch (com.bykv.z.z.z.z.dl.z(sparseArray).g().intValue(-99999987)) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.z;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    adnName = this.z.getAdnName();
                }
                return String.valueOf(adnName);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.z;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    adnName = this.z.getAdnSlotId();
                }
                return String.valueOf(adnName);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.z;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    adnName = this.z.getAppId();
                }
                return String.valueOf(adnName);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.z;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    adnName = this.z.getAppkey();
                }
                return String.valueOf(adnName);
            default:
                return null;
        }
    }
}
