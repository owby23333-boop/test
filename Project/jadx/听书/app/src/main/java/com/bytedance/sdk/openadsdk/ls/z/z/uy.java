package com.bytedance.sdk.openadsdk.ls.z.z;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements TTFullScreenVideoAd {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public uy(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 210101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d, String str, String str2) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(-99999987, 210102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 210103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, d);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 210104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.ls.z.g.g(tTAdInteractionListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 130101);
        sparseArray.put(-99999985, Void.class);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.g.z.g.g((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 1);
        } else {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.zw.z.z.z.z(fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 0);
        }
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 130102);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.ls.z.g.dl(tTAppDownloadListener));
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.g.intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 130103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(-99999987, 130104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, ritScenes == null ? null : ritScenes.getScenesName());
        sparseArray.put(2, str);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.g.objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.g.intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.g.longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 130106);
        sparseArray.put(-99999985, Object.class);
        return new com.bytedance.sdk.openadsdk.mediation.manager.z.z.z.dl(pf.z(this.z.apply(sparseArray)));
    }
}
