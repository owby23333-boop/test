package com.bytedance.sdk.openadsdk.mediation.manager.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import com.bytedance.sdk.openadsdk.mediation.ad.z.z.g.e;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a implements MediationNativeManager {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public a(Function<SparseArray<Object>, Object> function) {
        this.g = com.bykv.z.z.z.z.dl.z;
        function = function == null ? com.bykv.z.z.z.z.dl.dl : function;
        this.z = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.g = com.bykv.z.z.z.z.dl.z((SparseArray<Object>) objApply).g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270001);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270002);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.z.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new g(pf.z(it.next())));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270003);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.z.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new z(pf.z(it.next())));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270004);
        sparseArray.put(-99999985, Object.class);
        return new z(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270005);
        sparseArray.put(-99999985, List.class);
        List arrayList = (List) this.z.apply(sparseArray);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new z(pf.z(it.next())));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270006);
        sparseArray.put(-99999985, Object.class);
        return new z(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean hasDislike() {
        return this.g.booleanValue(270008);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setUseCustomVideo(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270009);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Boolean.valueOf(z));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setShakeViewListener(MediationShakeViewListener mediationShakeViewListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270010);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new e(mediationShakeViewListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean isExpress() {
        return this.g.booleanValue(270011);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void onResume() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271048);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void onPause() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271049);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
