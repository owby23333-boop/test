package com.anythink.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.network.baidu.impression.BDImpressionController;
import com.anythink.network.baidu.impression.BDImpressionTracker;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BaiduATNativeAd extends CustomNativeAd {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f12358e = "BaiduATNativeAd";
    protected NativeResponse a;
    protected Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    BDImpressionTracker f12359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f12360d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private XNativeView f12361f;

    protected BaiduATNativeAd() {
    }

    private void b(View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof ViewGroup) || view == this.f12361f) {
            view.setOnClickListener(null);
            view.setClickable(false);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                b(viewGroup.getChildAt(i2));
            }
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        b(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        this.a = null;
        XNativeView xNativeView = this.f12361f;
        if (xNativeView != null) {
            xNativeView.setNativeItem(null);
            this.f12361f.setNativeViewClickListener(null);
            this.f12361f = null;
        }
        this.b = null;
        BDImpressionTracker bDImpressionTracker = this.f12359c;
        if (bDImpressionTracker != null) {
            bDImpressionTracker.clear();
            this.f12359c = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null || nativeResponse.getMaterialType() != NativeResponse.MaterialType.VIDEO) {
            return null;
        }
        if (this.f12361f == null) {
            this.f12361f = new XNativeView(this.b);
            this.f12361f.setNativeItem(this.a);
            this.f12361f.setVideoMute(this.f12360d);
            this.f12361f.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.3
                @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
                public final void onNativeViewClick(XNativeView xNativeView) {
                    BaiduATNativeAd.this.notifyAdClicked();
                }
            });
        }
        return this.f12361f;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageHeight() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.getMainPicHeight();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getMainImageWidth() {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.getMainPicWidth();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getShakeView(int i2, int i3, final ATShakeViewListener aTShakeViewListener) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse != null) {
            return nativeResponse.renderShakeView(i2, i3, new NativeResponse.AdShakeViewListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.4
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                public final void onDismiss() {
                    ATShakeViewListener aTShakeViewListener2 = aTShakeViewListener;
                    if (aTShakeViewListener2 != null) {
                        aTShakeViewListener2.onDismiss();
                    }
                }
            });
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void impressionTrack(View view) {
        NativeResponse nativeResponse = this.a;
        if (nativeResponse == null || view == null) {
            return;
        }
        nativeResponse.recordImpression(view);
        notifyAdImpression();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> creativeClickViewList;
        if (this.a != null) {
            List<View> arrayList = new ArrayList<>();
            if ((aTNativePrepareInfo instanceof ATNativePrepareExInfo) && (creativeClickViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
                arrayList = creativeClickViewList;
            }
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() == 0) {
                clickViewList = a(view);
            }
            this.a.registerViewForInteraction(view, clickViewList, arrayList, new NativeResponse.AdInteractionListener() { // from class: com.anythink.network.baidu.BaiduATNativeAd.1
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onADExposed() {
                    BDImpressionTracker bDImpressionTracker = BaiduATNativeAd.this.f12359c;
                    if (bDImpressionTracker != null) {
                        bDImpressionTracker.clear();
                        BaiduATNativeAd.this.f12359c = null;
                    }
                    BaiduATNativeAd.this.notifyAdImpression();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onADExposureFailed(int i2) {
                    String unused = BaiduATNativeAd.f12358e;
                    "Baidu Native onADExposureFailed:".concat(String.valueOf(i2));
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onADStatusChanged() {
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onAdClick() {
                    BaiduATNativeAd.this.notifyAdClicked();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public final void onAdUnionClick() {
                }
            });
        }
        XNativeView xNativeView = this.f12361f;
        if (xNativeView != null) {
            xNativeView.render();
        }
        try {
            if (this.f12359c != null) {
                this.f12359c.addView(view, new BDImpressionController() { // from class: com.anythink.network.baidu.BaiduATNativeAd.2
                    @Override // com.anythink.network.baidu.impression.BDImpressionController, com.anythink.network.baidu.impression.BDImpressionInterface
                    public final void recordImpression(View view2) {
                        try {
                            if (BaiduATNativeAd.this.a == null || view2 == null) {
                                return;
                            }
                            BaiduATNativeAd.this.a.recordImpression(view2);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public void setData(NativeResponse nativeResponse) {
        setIconImageUrl(nativeResponse.getIconUrl());
        if (TextUtils.isEmpty(nativeResponse.getImageUrl())) {
            List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
            if (multiPicUrls != null && multiPicUrls.size() > 0) {
                setMainImageUrl(multiPicUrls.get(0));
                setMainImageWidth(nativeResponse.getMainPicWidth());
                setMainImageHeight(nativeResponse.getMainPicHeight());
            }
        } else {
            setMainImageUrl(nativeResponse.getImageUrl());
            setMainImageWidth(nativeResponse.getMainPicWidth());
            setMainImageHeight(nativeResponse.getMainPicHeight());
        }
        setMainImageWidth(nativeResponse.getMainPicWidth());
        setMainImageHeight(nativeResponse.getMainPicHeight());
        setImageUrlList(nativeResponse.getMultiPicUrls());
        setVideoUrl(nativeResponse.getVideoUrl());
        setVideoDuration(nativeResponse.getDuration());
        setAdChoiceIconUrl(nativeResponse.getBaiduLogoUrl());
        setTitle(nativeResponse.getTitle());
        setDescriptionText(nativeResponse.getDesc());
        setCallToActionText(nativeResponse.getActButtonString());
        setAdvertiserName(nativeResponse.getBrandName());
        int i2 = nativeResponse.getAdActionType() == 1 ? 2 : 0;
        if (nativeResponse.getAdActionType() == 2) {
            i2 = 1;
        }
        if (nativeResponse.getAdActionType() == 3) {
            i2 = 3;
        }
        setNativeInteractionType(i2);
        if (nativeResponse.getAdActionType() == 2) {
            setAdAppInfo(new BaiduATDownloadAppInfo(nativeResponse));
        }
        if (TextUtils.equals(nativeResponse.getAdMaterialType(), NativeResponse.MaterialType.VIDEO.getValue())) {
            this.mAdSourceType = "1";
        } else {
            this.mAdSourceType = "2";
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z2) {
        this.f12360d = z2;
        XNativeView xNativeView = this.f12361f;
        if (xNativeView != null) {
            xNativeView.setVideoMute(z2);
        }
    }

    protected final void a(Context context, NativeResponse nativeResponse) {
        this.b = context.getApplicationContext();
        this.f12359c = new BDImpressionTracker(this.b, 50);
        this.a = nativeResponse;
        setData(this.a);
    }

    public BaiduATNativeAd(Context context, NativeResponse nativeResponse) {
        a(context, nativeResponse);
    }

    private void a(View view, View.OnClickListener onClickListener) {
        if ((view instanceof ViewGroup) && view != this.f12361f) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), onClickListener);
            }
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    private List<View> a(View view) {
        ArrayList arrayList = new ArrayList();
        if ((view instanceof ViewGroup) && view != this.f12361f) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                arrayList.addAll(a(viewGroup.getChildAt(i2)));
            }
        } else {
            arrayList.add(view);
        }
        return arrayList;
    }
}
