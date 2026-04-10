package com.bytedance.sdk.openadsdk.mediation.manager.z.z.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements MediationFullScreenManager {
    private final Function<SparseArray<Object>, Object> z;

    public dl(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.dl.dl : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270001);
        sparseArray.put(-99999985, Boolean.class);
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

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager
    public void destroy() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270007);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
