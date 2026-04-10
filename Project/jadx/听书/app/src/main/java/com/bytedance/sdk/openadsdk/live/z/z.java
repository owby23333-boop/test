package com.bytedance.sdk.openadsdk.live.z;

import android.util.SparseArray;
import com.bykv.z.z.z.z.dl;
import com.bytedance.android.live.base.api.IHostPermission;
import com.bytedance.android.live.base.api.LocationProvider;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements IHostPermission {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? dl.dl : function;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262101);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 262102);
        sparseArray.put(-99999985, com.bytedance.sdk.openadsdk.LocationProvider.class);
        Object objApply = this.z.apply(sparseArray);
        final com.bytedance.sdk.openadsdk.ls.z.dl.dl dlVar = objApply instanceof SparseArray ? new com.bytedance.sdk.openadsdk.ls.z.dl.dl(dl.z((SparseArray<Object>) objApply).g()) : null;
        if (dlVar == null) {
            return null;
        }
        return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.live.z.z.1
            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLatitude() {
                return dlVar.getLatitude();
            }

            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLongitude() {
                return dlVar.getLongitude();
            }
        };
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262103);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262104);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262105);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262107);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262108);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262109);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262112);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262110);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }
}
