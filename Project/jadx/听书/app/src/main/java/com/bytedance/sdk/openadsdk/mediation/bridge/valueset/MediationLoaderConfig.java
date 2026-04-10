package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.mediation.z.g;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MediationLoaderConfig {
    private ValueSet z;

    private MediationLoaderConfig(ValueSet valueSet) {
        if (valueSet != null) {
            SparseArray sparseArray = (SparseArray) valueSet.objectValue(8424, SparseArray.class);
            ValueSet valueSetG = (sparseArray == null || sparseArray.size() <= 0) ? null : dl.z((SparseArray<Object>) sparseArray).g();
            if (valueSetG != null) {
                this.z = valueSetG;
            } else {
                this.z = valueSet;
            }
        }
    }

    public static MediationLoaderConfig create(ValueSet valueSet) {
        return new MediationLoaderConfig(valueSet);
    }

    private boolean z() {
        ValueSet valueSet = this.z;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public int getAdType() {
        if (z()) {
            return this.z.intValue(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes);
        }
        return 0;
    }

    public String getADNName() {
        return z() ? this.z.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec) : "";
    }

    public String getClassName() {
        return z() ? this.z.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public ValueSet getAdSlotValueSet() {
        if (z()) {
            return dl.z((SparseArray<Object>) this.z.objectValue(8548, SparseArray.class)).g();
        }
        return null;
    }

    public Context getContext() {
        if (z()) {
            return (Context) this.z.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class);
        }
        return null;
    }

    public ValueSet getMediationCustomServiceConfigValue() {
        if (z()) {
            return dl.z((SparseArray<Object>) this.z.objectValue(8546, SparseArray.class)).g();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> getGMCustomAdLoader() {
        if (z()) {
            return g.z(this.z.objectValue(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, Object.class));
        }
        return null;
    }

    public int getManagerLoaderType() {
        if (z()) {
            return this.z.intValue(8561);
        }
        return 0;
    }
}
