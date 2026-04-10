package com.bytedance.sdk.openadsdk.mediation.ad.z.z.g;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements Function<SparseArray<Object>, Object> {
    private final IMediationViewBinder z;

    public gc(IMediationViewBinder iMediationViewBinder) {
        this.z = iMediationViewBinder;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        switch (com.bykv.z.z.z.z.dl.z(sparseArray).g().intValue(-99999987)) {
            case 271021:
                return Integer.class.cast(Integer.valueOf(this.z.getLayoutId()));
            case 271022:
                return Integer.class.cast(Integer.valueOf(this.z.getTitleId()));
            case 271023:
                return Integer.class.cast(Integer.valueOf(this.z.getDecriptionTextId()));
            case 271024:
                return Integer.class.cast(Integer.valueOf(this.z.getCallToActionId()));
            case 271025:
                return Integer.class.cast(Integer.valueOf(this.z.getIconImageId()));
            case 271026:
                return Integer.class.cast(Integer.valueOf(this.z.getMainImageId()));
            case 271027:
                return Integer.class.cast(Integer.valueOf(this.z.getMediaViewId()));
            case 271028:
                return Integer.class.cast(Integer.valueOf(this.z.getSourceId()));
            case 271029:
                return Integer.class.cast(Integer.valueOf(this.z.getGroupImage1Id()));
            case 271030:
                return Integer.class.cast(Integer.valueOf(this.z.getGroupImage2Id()));
            case 271031:
                return Integer.class.cast(Integer.valueOf(this.z.getGroupImage3Id()));
            case 271032:
                return Integer.class.cast(Integer.valueOf(this.z.getLogoLayoutId()));
            case 271033:
                return Integer.class.cast(Integer.valueOf(this.z.getShakeViewContainerId()));
            case 271034:
                return this.z.getExtras();
            default:
                return com.bykv.z.z.z.z.dl.dl.apply(sparseArray);
        }
    }
}
