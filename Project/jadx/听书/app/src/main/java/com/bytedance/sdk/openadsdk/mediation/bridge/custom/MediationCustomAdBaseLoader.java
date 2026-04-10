package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.ls.z.dl.g;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.z.z;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediationCustomAdBaseLoader extends z {
    public Function<SparseArray<Object>, Object> mGmAdLoader;

    public abstract <T> T callMethod(int i, ValueSet valueSet, Class<T> cls);

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public SparseArray<Object> get() {
        return null;
    }

    public abstract void load(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig);

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    public final void loadInner(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig mediationCustomServiceConfig, Function<SparseArray<Object>, Object> function) {
        this.mGmAdLoader = function;
        z();
        if (adSlot == null) {
            try {
                adSlot = new AdSlot.Builder().build();
            } catch (Exception e) {
                m.z(e);
                return;
            }
        }
        load(context, adSlot, mediationCustomServiceConfig);
    }

    private void z() {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(8405, this);
            sparseArray.put(-99999987, 8221);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final void callLoadFail(int i, String str) {
        if (this.mGmAdLoader != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            sparseArray.put(-99999987, 8123);
            sparseArray.put(-99999985, String.class);
            this.mGmAdLoader.apply(sparseArray);
        }
    }

    public final String getAdm() {
        if (this.mGmAdLoader == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8137);
        sparseArray.put(-99999985, String.class);
        return (String) this.mGmAdLoader.apply(sparseArray);
    }

    public final Object getExtraDataNoParse() {
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8224);
        sparseArray.put(-99999985, Object.class);
        return this.mGmAdLoader.apply(sparseArray);
    }

    public final int getBiddingType() {
        if (this.mGmAdLoader == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8226);
        sparseArray.put(-99999985, Integer.class);
        Integer num = (Integer) this.mGmAdLoader.apply(sparseArray);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final void setMediaExtraInfo(Map<String, Object> map) {
        if (this.mGmAdLoader == null || map == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8075, map);
        sparseArray.put(-99999987, 8227);
        sparseArray.put(-99999985, Void.class);
        this.mGmAdLoader.apply(sparseArray);
    }

    public final Bridge getGMBridge() {
        if (this.mGmAdLoader == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8127);
        sparseArray.put(-99999985, Bridge.class);
        return (Bridge) this.mGmAdLoader.apply(sparseArray);
    }

    public final void load(Context context, ValueSet valueSet) {
        MediationLoaderConfig mediationLoaderConfigCreate = MediationLoaderConfig.create(valueSet);
        ValueSet adSlotValueSet = mediationLoaderConfigCreate.getAdSlotValueSet();
        loadInner(context, g.z(adSlotValueSet != null ? adSlotValueSet.sparseArray() : new SparseArray<>()), new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig(mediationLoaderConfigCreate.getMediationCustomServiceConfigValue()), mediationLoaderConfigCreate.getGMCustomAdLoader());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8241) {
            load((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), dl.z((SparseArray<Object>) valueSet.objectValue(8424, SparseArray.class)).g());
        } else if (i == 8225) {
            m.dl("TTMediationSDK", "MediationCustomBaseLoader receiveBidResult");
            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
        } else if (i == 8149) {
            m.dl("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onPause();
        } else if (i == 8148) {
            m.dl("TTMediationSDK", "MediationCustomBaseLoader onPause");
            onResume();
        } else if (i == 8109) {
            m.dl("TTMediationSDK", "MediationCustomBaseLoader onDestroy");
            onDestroy();
        }
        return (T) callMethod(i, valueSet, cls);
    }

    protected Integer z(MediationConstant.AdIsReadyStatus adIsReadyStatus) {
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return 1;
        }
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
            return 2;
        }
        if (adIsReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            return 3;
        }
        if (adIsReadyStatus != MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
            return 1;
        }
        return 4;
    }
}
