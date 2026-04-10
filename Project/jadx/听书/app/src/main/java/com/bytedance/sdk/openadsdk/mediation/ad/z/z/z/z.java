package com.bytedance.sdk.openadsdk.mediation.ad.z.z.z;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ls.z.z.a;
import com.bytedance.sdk.openadsdk.ls.z.z.e;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.z.z.g.gc;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements IMediationNativeAdInfo {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getTitle() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268001);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getDescription() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268002);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getIconUrl() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268003);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getImageUrl() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268004);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getActionText() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268005);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public double getStarRating() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268006);
        sparseArray.put(-99999985, String.class);
        return ((Double) this.z.apply(sparseArray)).doubleValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public List<String> getImageList() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268007);
        sparseArray.put(-99999985, List.class);
        return (List) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getSource() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268008);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getAdImageMode() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268009);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getInteractionType() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268010);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder) {
        SparseArray<Object> sparseArray = new SparseArray<>(8);
        sparseArray.put(-99999987, 268011);
        sparseArray.put(0, activity);
        sparseArray.put(1, viewGroup);
        sparseArray.put(2, list);
        sparseArray.put(3, list2);
        sparseArray.put(4, list3);
        sparseArray.put(5, new gc(iMediationViewBinder));
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationNativeAdAppInfo getNativeAdAppInfo() {
        return new dl(pf.z(this.g.objectValue(268101, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public boolean hasDislike() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268012);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 268102);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, activity);
        return new g(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 268103);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, map);
        return new g(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 268016);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.js.z.z.z.z(dislikeInteractionCallback));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 268017);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, pf.z(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public TTAdDislike getDislikeDialog2(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 268018);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, activity);
        return new e(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 268019);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, pf.z(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        return new e(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public DislikeInfo getDislikeInfo() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 268020);
        sparseArray.put(-99999985, Object.class);
        return new a(pf.z(this.z.apply(sparseArray)));
    }
}
