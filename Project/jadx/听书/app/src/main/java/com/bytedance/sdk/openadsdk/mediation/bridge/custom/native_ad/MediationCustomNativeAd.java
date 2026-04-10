package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import com.bytedance.sdk.openadsdk.mediation.z.g;
import com.bytedance.sdk.openadsdk.mediation.z.z;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MediationCustomNativeAd extends z implements IMediationCustomNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1462a;
    private String dl;
    private int e;
    private String fo;
    private int fv;
    private Map<String, Object> g;
    private String gc;
    private int gz;
    private double i;
    private MediationNativeAdAppInfo js;
    private int kb;
    private boolean ls;
    private String m;
    private int p;
    private String pf;
    private MediationCustomNativeDislikeDialog q;
    private Function tb;
    private String uy;
    private List<String> v;
    private int wp;
    private double z;

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return null;
    }

    public View getVideoView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d) {
        this.z = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.g = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.dl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.f1462a = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.gc = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.m = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i) {
        this.e = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i) {
        this.gz = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.fo = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.uy = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i) {
        this.kb = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i) {
        this.wp = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d) {
        this.i = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.v = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.pf = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z) {
        this.ls = z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i) {
        this.p = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i) {
        this.fv = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.js = mediationNativeAdAppInfo;
    }

    public SparseArray<Object> getValues() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8016, Double.valueOf(this.z));
        sparseArray.put(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, this.g);
        sparseArray.put(8045, this.dl);
        sparseArray.put(8046, this.f1462a);
        sparseArray.put(8048, this.gc);
        sparseArray.put(8050, this.m);
        sparseArray.put(8051, Integer.valueOf(this.gz));
        sparseArray.put(8052, Integer.valueOf(this.e));
        sparseArray.put(8061, this.fo);
        sparseArray.put(8054, this.uy);
        sparseArray.put(8420, Integer.valueOf(this.kb));
        sparseArray.put(8421, Integer.valueOf(this.wp));
        sparseArray.put(8082, Double.valueOf(this.i));
        sparseArray.put(8053, this.v);
        sparseArray.put(8049, this.pf);
        sparseArray.put(8033, Boolean.valueOf(this.ls));
        sparseArray.put(8060, Integer.valueOf(this.p));
        sparseArray.put(8059, Integer.valueOf(this.fv));
        if (this.js != null) {
            sparseArray.put(8315, new MediationNativeAppInfoImpl(this.js));
        }
        return sparseArray;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8226);
            sparseArray.put(-99999985, Integer.class);
            Integer num = (Integer) this.tb.apply(sparseArray);
            if (num != null) {
                return num.intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8160);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.tb.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdClick() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8130);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8113);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f, float f2) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8133);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8040, Float.valueOf(f));
            sparseArray.put(8041, Float.valueOf(f2));
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i, String str) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8134);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8042, view);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8145);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8146);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8150);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8118);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i, String str) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8117);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j, long j2) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8154);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8072, Long.valueOf(j));
            sparseArray.put(8073, Long.valueOf(j2));
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8152);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j, long j2) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8187);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j, long j2, String str, String str2) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8158);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8157);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j, String str, String str2) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8155);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8156);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8185);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8184);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i, String str) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8132);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8038, Integer.valueOf(i));
            sparseArray.put(8039, str);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 6085);
            sparseArray.put(-99999985, Void.class);
            this.tb.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8110);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.tb.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isServerBidding() {
        if (this.tb != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-99999987, 8136);
            sparseArray.put(-99999985, Boolean.class);
            Boolean bool = (Boolean) this.tb.apply(sparseArray);
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i == 8127) {
            this.tb = g.z(valueSet.objectValue(8034, Object.class));
        } else if (i == 6083) {
            render();
        } else {
            if (i == 6081) {
                return (T) getExpressView();
            }
            if (i == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder(g.z(valueSet.objectValue(8071, Object.class))));
            } else {
                if (i == 8135) {
                    return (T) Boolean.valueOf(hasDislike());
                }
                if (i == 8149) {
                    onPause();
                } else if (i == 8148) {
                    onResume();
                } else if (i == 8109) {
                    onDestroy();
                } else {
                    if (i == 8121) {
                        return (T) z();
                    }
                    if (i == 8194) {
                        String strStringValue = valueSet.stringValue(8036, null);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.q;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(strStringValue, map);
                        }
                    } else if (i == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.q;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new com.bytedance.sdk.openadsdk.mediation.g.z.g(dislikeDialog);
                        }
                    } else {
                        if (i == 8320) {
                            return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                        }
                        if (i == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i == 8225) {
                            m.dl("TTMediationSDK", "MediationCustomNativeAd receiveBidResult");
                            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
                        } else if (i == 6164) {
                            return (T) getVideoView();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public SparseArray<Object> get() {
        return getValues();
    }

    private Integer z() {
        MediationConstant.AdIsReadyStatus adIsReadyStatusIsReadyCondition = isReadyCondition();
        if (adIsReadyStatusIsReadyCondition == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return 1;
        }
        if (adIsReadyStatusIsReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
            return 2;
        }
        if (adIsReadyStatusIsReadyCondition == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
            return 3;
        }
        if (adIsReadyStatusIsReadyCondition != MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
            return 1;
        }
        return 4;
    }
}
