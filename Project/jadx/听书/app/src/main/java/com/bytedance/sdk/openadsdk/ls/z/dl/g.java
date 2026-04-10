package com.bytedance.sdk.openadsdk.ls.z.dl;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static final SparseArray<Object> z(final AdSlot adSlot) {
        if (adSlot == null) {
            return new SparseArray<>();
        }
        com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z();
        dlVarZ.z(260001, adSlot.getAdId());
        dlVarZ.z(260002, adSlot.getCreativeId());
        dlVarZ.z(260003, adSlot.getExt());
        dlVarZ.z(260004, adSlot.getCodeId());
        dlVarZ.z(260005, adSlot.isAutoPlay());
        dlVarZ.z(260006, adSlot.getImgAcceptedWidth());
        dlVarZ.z(260007, adSlot.getImgAcceptedHeight());
        dlVarZ.z(260008, adSlot.getExpressViewAcceptedWidth());
        dlVarZ.z(260009, adSlot.getExpressViewAcceptedHeight());
        dlVarZ.z(260010, adSlot.isSupportDeepLink());
        dlVarZ.z(260011, adSlot.isSupportRenderConrol());
        dlVarZ.z(2600012, adSlot.getAdCount());
        dlVarZ.z(260013, adSlot.getMediaExtra());
        dlVarZ.z(260014, adSlot.getUserID());
        dlVarZ.z(260015, adSlot.getOrientation());
        dlVarZ.z(260016, adSlot.getNativeAdType());
        dlVarZ.z(260017, adSlot.getExternalABVid());
        dlVarZ.z(260018, adSlot.getAdloadSeq());
        dlVarZ.z(260019, adSlot.getPrimeRit());
        dlVarZ.z(260020, adSlot.getAdType());
        dlVarZ.z(260021, adSlot.getBidAdm());
        dlVarZ.z(260022, adSlot.getUserData());
        dlVarZ.z(260023, z(adSlot.getAdLoadType()));
        dlVarZ.z(260024, new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.g.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return adSlot.getRewardName();
            }
        });
        dlVarZ.z(260025, new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.g.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adSlot.getRewardAmount());
            }
        });
        dlVarZ.z(260026, new Supplier<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ls.z.dl.g.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(adSlot.isSupportIconStyle());
            }
        });
        if (adSlot.getMediationAdSlot() != null) {
            dlVarZ.z(8260028, new com.bytedance.sdk.openadsdk.mediation.ad.z.z.g.z(adSlot.getMediationAdSlot()));
        }
        return dlVarZ.g().sparseArray();
    }

    public static AdSlot z(SparseArray<Object> sparseArray) {
        AdSlot.Builder builder = new AdSlot.Builder();
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        if (valueSetG != null) {
            builder.setAdId(valueSetG.stringValue(260001)).setCodeId(valueSetG.stringValue(260002)).setExt(valueSetG.stringValue(260003)).setCodeId(valueSetG.stringValue(260004)).setIsAutoPlay(valueSetG.booleanValue(260005)).setImageAcceptedSize(valueSetG.intValue(260006), valueSetG.intValue(260007)).setExpressViewAcceptedSize(valueSetG.floatValue(260008), valueSetG.floatValue(260009)).setSupportDeepLink(valueSetG.booleanValue(260010)).setAdCount(valueSetG.intValue(2600012)).setMediaExtra(valueSetG.stringValue(260013)).setUserID(valueSetG.stringValue(260014)).setExternalABVid((int[]) valueSetG.objectValue(260017, int[].class)).setAdloadSeq(valueSetG.intValue(260018)).setPrimeRit(valueSetG.stringValue(260019)).setAdType(valueSetG.intValue(260020)).withBid(valueSetG.stringValue(260021)).setUserData(valueSetG.stringValue(260022)).setAdLoadType(z(valueSetG.intValue(260023))).setMediationAdSlot(new z(pf.z(valueSetG.objectValue(8260028, Object.class))).z()).setOrientation(valueSetG.intValue(260015)).setRewardName((String) valueSetG.objectValue(260024, String.class)).setRewardAmount(valueSetG.intValue(260025));
            if (valueSetG.booleanValue(260011)) {
                builder.supportRenderControl();
            }
        }
        return builder.build();
    }

    private static Integer z(TTAdLoadType tTAdLoadType) {
        if (tTAdLoadType == null) {
            return null;
        }
        if (tTAdLoadType == TTAdLoadType.UNKNOWN) {
            return -1;
        }
        if (tTAdLoadType == TTAdLoadType.LOAD) {
            return 3;
        }
        return tTAdLoadType == TTAdLoadType.PRELOAD ? 1 : null;
    }

    private static TTAdLoadType z(int i) {
        if (i == 3) {
            return TTAdLoadType.LOAD;
        }
        if (i == 1) {
            return TTAdLoadType.PRELOAD;
        }
        return TTAdLoadType.UNKNOWN;
    }

    public static class z {
        private Function<SparseArray<Object>, Object> z;

        public z(Function<SparseArray<Object>, Object> function) {
            this.z = function;
        }

        public IMediationAdSlot z() {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8260031);
            Object objApply = this.z.apply(sparseArray);
            if (objApply instanceof IMediationAdSlot) {
                return (IMediationAdSlot) objApply;
            }
            return null;
        }
    }
}
