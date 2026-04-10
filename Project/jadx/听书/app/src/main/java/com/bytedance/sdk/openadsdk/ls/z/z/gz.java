package com.bytedance.sdk.openadsdk.ls.z.z;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class gz implements TTDrawFeedAd {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public gz(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getVideoCoverImage() {
        return new kb(pf.z(this.g.objectValue(140001, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Bitmap getAdLogo() {
        return (Bitmap) this.g.objectValue(140002, Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getTitle() {
        return this.g.stringValue(140003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getDescription() {
        return this.g.stringValue(140004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getButtonText() {
        return this.g.stringValue(140018);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.g.intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.g.intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.g.intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public String getSource() {
        return this.g.stringValue(140008);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTImage getIcon() {
        return new kb(pf.z(this.g.objectValue(140009, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public List<TTImage> getImageList() {
        List arrayList = (List) this.g.objectValue(140010, List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new kb(pf.z(it.next())));
        }
        return arrayList2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.g.intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.g.intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DislikeInfo getDislikeInfo() {
        return new a(pf.z(this.g.objectValue(140013, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public ComplianceInfo getComplianceInfo() {
        return new dl(pf.z(this.g.objectValue(140014, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public DownloadStatusController getDownloadStatusController() {
        return new gc(pf.z(this.g.objectValue(140015, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        return (View) this.g.objectValue(140016, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.g.objectValue(140017, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140101);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(0, activity);
        return new e(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 140102);
        sparseArray.put(-99999985, Function.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, pf.z(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        return new e(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(-99999987, 140103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, view);
        sparseArray.put(2, new com.bytedance.sdk.openadsdk.io.z.z.z.z(adInteractionListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(-99999987, 140104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, new com.bytedance.sdk.openadsdk.io.z.z.z.z(adInteractionListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(7);
        sparseArray.put(-99999987, 140105);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, view);
        sparseArray.put(4, new com.bytedance.sdk.openadsdk.io.z.z.z.z(adInteractionListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(8);
        sparseArray.put(-99999987, 140106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, list3);
        sparseArray.put(4, view);
        sparseArray.put(5, new com.bytedance.sdk.openadsdk.io.z.z.z.z(adInteractionListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(9);
        sparseArray.put(-99999987, 140107);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, viewGroup);
        sparseArray.put(1, list);
        sparseArray.put(2, list2);
        sparseArray.put(3, list3);
        sparseArray.put(4, list4);
        sparseArray.put(5, view);
        sparseArray.put(6, new com.bytedance.sdk.openadsdk.io.z.z.z.z(adInteractionListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, TTNativeAd.AdInteractionListener adInteractionListener, IMediationViewBinder iMediationViewBinder) {
        SparseArray<Object> sparseArray = new SparseArray<>(9);
        sparseArray.put(-99999987, 140117);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, viewGroup);
        sparseArray.put(2, list);
        sparseArray.put(3, list2);
        sparseArray.put(4, list3);
        sparseArray.put(5, new com.bytedance.sdk.openadsdk.io.z.z.z.z(adInteractionListener));
        sparseArray.put(6, new com.bytedance.sdk.openadsdk.mediation.ad.z.z.g.gc(iMediationViewBinder));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140108);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.ls.z.g.dl(tTAppDownloadListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 140110);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140111);
        sparseArray.put(-99999985, Void.class);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.ad.z.z.g.m((MediationExpressRenderListener) expressRenderListener));
            sparseArray.put(1, 1);
        } else {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.io.z.z.z.dl(expressRenderListener));
            sparseArray.put(1, 0);
        }
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 140112);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.js.z.z.z.z(dislikeInteractionCallback));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(-99999987, 140113);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, tTDislikeDialogAbstract);
        sparseArray.put(1, pf.z(tTDislikeDialogAbstract.getTTDislikeListViewIds()));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void uploadDislikeEvent(String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140118);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(Activity activity) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140115);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, activity);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setEasyPlayWidgetListener(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140119);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.io.z.z.z.g(easyPlayWidgetListener));
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 140114);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public MediationNativeManager getMediationManager() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 140116);
        sparseArray.put(-99999985, Void.class);
        return new com.bytedance.sdk.openadsdk.mediation.manager.z.z.z.a(pf.z(this.z.apply(sparseArray)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 160101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.iq.z.z.g.z(videoAdListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoRewardListener(TTFeedAd.VideoRewardListener videoRewardListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 160102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.iq.z.z.g.g(videoRewardListener));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        return this.g.doubleValue(160001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public TTFeedAd.CustomizeVideo getCustomVideo() {
        return new com.bytedance.sdk.openadsdk.iq.z.z.z.z(pf.z(this.g.objectValue(160002, Object.class)));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        return this.g.intValue(160003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        return this.g.intValue(160004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 170101);
        sparseArray.put(0, Boolean.valueOf(z));
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 170102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, bitmap);
        sparseArray.put(0, Integer.valueOf(i));
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 170103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.q.z.z.z.z(drawVideoListener));
        this.z.apply(sparseArray);
    }
}
