package com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsBannerLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationAdSlotValueSet f2422a;
    private Function<SparseArray<Object>, Object> b;
    private final KsBannerLoader c;
    private boolean d;
    private WeakReference<Context> e;

    class a extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        KsFeedAd f2426a;
        View b;

        public a(KsFeedAd ksFeedAd, MediationAdSlotValueSet mediationAdSlotValueSet, Function function) {
            super(mediationAdSlotValueSet, function);
            this.f2426a = ksFeedAd;
            if (f.this.c.isClientBidding()) {
                int ecpm = ksFeedAd.getECPM();
                setCpm(ecpm > 0 ? ecpm : 0.0d);
            }
            this.f2426a.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.a.1
                @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                public void onAdClicked() {
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1009);
                        sparseArray.put(-99999985, Void.class);
                        a.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                public void onAdShow() {
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1008);
                        sparseArray.put(-99999985, Void.class);
                        a.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                public void onDislikeClicked() {
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1014);
                        sparseArray.put(-99999985, Void.class);
                        a.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }
            });
            if (f.this.f2422a != null) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
                kSAdVideoPlayConfigImpl.setVideoSoundEnable(!f.this.f2422a.isMuted());
                ksFeedAd.setVideoPlayConfig(kSAdVideoPlayConfigImpl);
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8140);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8033, true);
            sparseArray.put(8059, Integer.valueOf(o.a(this.f2426a.getInteractionType())));
            this.mGMAd.apply(sparseArray);
        }

        private void c() {
            n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.d();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            try {
                KsFeedAd ksFeedAd = this.f2426a;
                if (ksFeedAd != null) {
                    ksFeedAd.render(new KsFeedAd.AdRenderListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.a.3
                        @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
                        public void onAdRenderFailed(int i, String str) {
                            f.this.c.notifyAdFailed(i, str);
                        }

                        @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
                        public void onAdRenderSuccess(View view) {
                            Context context = (Context) f.this.e.get();
                            if (context == null && view != null) {
                                context = view.getContext();
                            }
                            if (a.this.f2426a != null && context != null) {
                                a aVar = a.this;
                                aVar.b = aVar.f2426a.getFeedView(context);
                            }
                            KsBannerLoader ksBannerLoader = f.this.c;
                            a aVar2 = a.this;
                            ksBannerLoader.notifyAdSuccess(aVar2, aVar2.mGMAd);
                        }
                    });
                } else {
                    f.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "render fail, ksFeedAd is null");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.f2426a == null) {
                    f.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "render fail, ksFeedAd is null");
                    return;
                }
                Context context = (Context) f.this.e.get();
                View feedView = context != null ? this.f2426a.getFeedView(context) : null;
                if (feedView == null) {
                    f.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "render fail, expressView is null");
                } else {
                    this.b = feedView;
                    f.this.c.notifyAdSuccess(this, this.mGMAd);
                }
            }
        }

        private String e() {
            return f.this.d ? f() : g();
        }

        private String f() {
            try {
                return (String) n.a(new Callable<String>() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.a.4
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String call() {
                        return a.this.g();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String g() {
            Object obj;
            try {
                KsFeedAd ksFeedAd = this.f2426a;
                if (ksFeedAd == null || (obj = ksFeedAd.getMediaExtraInfo().get("llsid")) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a() {
            if (f.this.d) {
                c();
            } else {
                d();
            }
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 6081) {
                return (T) b();
            }
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8147) {
                    return (T) e();
                }
                if (i == 8142) {
                    if (o.a(this.f2426a)) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long jA = o.a((Map<String, Object>) map);
                            long jB = o.b((Map<String, Object>) map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                            KsFeedAd ksFeedAd = this.f2426a;
                            if (ksFeedAd != null) {
                                ksFeedAd.setBidEcpm(jA, jB);
                            }
                        }
                    }
                } else if (i == 8144 && o.b(this.f2426a)) {
                    Map map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int iC = o.c(map2);
                        int iD = o.d(map2);
                        int iE = o.e(map2);
                        String strF = o.f(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + iD + " failureCode = " + iC);
                        if (this.f2426a != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(iD);
                            adExposureFailedReason.setAdnType(iE);
                            adExposureFailedReason.setAdnName(strF);
                            this.f2426a.reportAdExposureFailed(iC, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @JProtect
        public View b() {
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return false;
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public void onDestroy() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    class b extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        KsNativeAd f2431a;
        KsNativeAd.AdInteractionListener b;
        KsNativeAd.VideoPlayListener c;

        public b(KsNativeAd ksNativeAd, MediationAdSlotValueSet mediationAdSlotValueSet, Function function) {
            KsImage videoCoverImage;
            super(mediationAdSlotValueSet, function);
            this.b = new KsNativeAd.AdInteractionListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.b.2
                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return false;
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                @JProtect
                public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                    if (b.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1009);
                        sparseArray.put(-99999985, Void.class);
                        b.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                @JProtect
                public void onAdShow(KsNativeAd ksNativeAd2) {
                    if (b.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1008);
                        sparseArray.put(-99999985, Void.class);
                        b.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                public void onDownloadTipsDialogShow() {
                }
            };
            this.c = new KsNativeAd.VideoPlayListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.b.3
                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                @JProtect
                public void onVideoPlayComplete() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                @JProtect
                public void onVideoPlayError(int i, int i2) {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayPause() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayReady() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                public void onVideoPlayResume() {
                }

                @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                @JProtect
                public void onVideoPlayStart() {
                }
            };
            this.f2431a = ksNativeAd;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(8033, false);
            sparseArray.put(8061, this.f2431a.getActionDescription());
            sparseArray.put(8046, this.f2431a.getAdDescription());
            sparseArray.put(8048, this.f2431a.getAppIconUrl());
            String appName = !TextUtils.isEmpty(this.f2431a.getAppName()) ? this.f2431a.getAppName() : !TextUtils.isEmpty(this.f2431a.getProductName()) ? this.f2431a.getProductName() : "";
            sparseArray.put(8049, appName);
            sparseArray.put(8045, this.f2431a.getAdSource());
            sparseArray.put(8055, Boolean.valueOf(this.f2431a.getInteractionType() == 1));
            sparseArray.put(8082, Double.valueOf(this.f2431a.getAppScore()));
            sparseArray.put(8056, appName);
            sparseArray.put(8057, this.f2431a.getCorporationName());
            sparseArray.put(8047, Integer.valueOf((int) this.f2431a.getAppPackageSize()));
            sparseArray.put(8078, Long.valueOf(this.f2431a.getAppPackageSize()));
            sparseArray.put(8081, this.f2431a.getAppVersion());
            sparseArray.put(8079, this.f2431a.getPermissionInfoUrl());
            sparseArray.put(8080, this.f2431a.getAppPrivacyUrl());
            try {
                sparseArray.put(8551, this.f2431a.getIntroductionInfoUrl());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            sparseArray.put(8059, Integer.valueOf(o.a(this.f2431a.getInteractionType())));
            if (f.this.c.isClientBidding()) {
                sparseArray.put(8016, Double.valueOf(Math.max(this.f2431a.getECPM(), 0.0d)));
            }
            if (this.f2431a.getMaterialType() == 2) {
                if (this.f2431a.getImageList() != null && !this.f2431a.getImageList().isEmpty() && this.f2431a.getImageList().get(0) != null) {
                    sparseArray.put(8060, 3);
                    videoCoverImage = this.f2431a.getImageList().get(0);
                    sparseArray.put(8050, videoCoverImage.getImageUrl());
                    sparseArray.put(8051, Integer.valueOf(videoCoverImage.getHeight()));
                    sparseArray.put(8052, Integer.valueOf(videoCoverImage.getWidth()));
                }
            } else if (this.f2431a.getMaterialType() == 3) {
                if (this.f2431a.getImageList() != null && this.f2431a.getImageList().size() > 0) {
                    sparseArray.put(8060, 4);
                    ArrayList arrayList = new ArrayList();
                    Iterator<KsImage> it = this.f2431a.getImageList().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getImageUrl());
                    }
                    sparseArray.put(8053, arrayList);
                }
            } else if (this.f2431a.getMaterialType() == 1) {
                sparseArray.put(8060, 5);
                videoCoverImage = this.f2431a.getVideoCoverImage();
                if (videoCoverImage == null && this.f2431a.getImageList() != null && !this.f2431a.getImageList().isEmpty() && this.f2431a.getImageList().get(0) != null) {
                    videoCoverImage = this.f2431a.getImageList().get(0);
                }
                if (videoCoverImage != null) {
                    sparseArray.put(8050, videoCoverImage.getImageUrl());
                    sparseArray.put(8051, Integer.valueOf(videoCoverImage.getHeight()));
                    sparseArray.put(8052, Integer.valueOf(videoCoverImage.getWidth()));
                }
            } else {
                sparseArray.put(8060, -1);
            }
            sparseArray.put(-99999987, 8140);
            sparseArray.put(-99999985, Void.class);
            function.apply(sparseArray);
            this.f2431a.setVideoPlayListener(this.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            KsNativeAd ksNativeAd = this.f2431a;
            if (ksNativeAd != null) {
                ksNativeAd.setVideoPlayListener(null);
                this.f2431a = null;
            }
        }

        private void b() {
            n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a();
                }
            });
        }

        private String c() {
            return f.this.d ? d() : e();
        }

        private String d() {
            try {
                return (String) n.a(new Callable<String>() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.b.4
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String call() {
                        return b.this.e();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String e() {
            Object obj;
            try {
                KsNativeAd ksNativeAd = this.f2431a;
                if (ksNativeAd == null || (obj = ksNativeAd.getMediaExtraInfo().get("llsid")) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        @JProtect
        public void a(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, MediationViewBinder mediationViewBinder) {
            View viewFindViewById;
            if (list != null && list2 != null) {
                list.addAll(list2);
            }
            KsNativeAd ksNativeAd = this.f2431a;
            if (ksNativeAd != null) {
                ksNativeAd.registerViewForInteraction(viewGroup, list, this.b);
            }
            KsNativeAd ksNativeAd2 = this.f2431a;
            boolean z = false;
            if (ksNativeAd2 != null && ksNativeAd2.getAdSourceLogoUrl(1) != null && (viewFindViewById = viewGroup.findViewById(mediationViewBinder.logoLayoutId)) != null) {
                viewFindViewById.setVisibility(0);
                if (viewFindViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(context);
                    new com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.a(imageView).execute(this.f2431a.getAdSourceLogoUrl(1));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (viewFindViewById instanceof ImageView) {
                    ImageView imageView2 = (ImageView) viewFindViewById;
                    new com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.a(imageView2).execute(this.f2431a.getAdSourceLogoUrl(1));
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                }
            }
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.mediaViewId);
            if (this.f2431a == null || viewGroup3 == null) {
                return;
            }
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            if (f.this.f2422a != null && !f.this.f2422a.isMuted()) {
                z = true;
            }
            kSAdVideoPlayConfigImpl.setVideoSoundEnable(z);
            View videoView = this.f2431a.getVideoView(context, kSAdVideoPlayConfigImpl);
            if (videoView == null) {
                return;
            }
            f.this.c.removeSelfFromParent(videoView);
            viewGroup3.removeAllViews();
            viewGroup3.addView(videoView, -1, -1);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8159) {
                final Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                final ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(8067), ViewGroup.class, null);
                final List<View> list = (List) MediationValueUtil.objectValue(sparseArray.get(8068), List.class, null);
                final List<View> list2 = (List) MediationValueUtil.objectValue(sparseArray.get(8069), List.class, null);
                final Object objObjectValue = MediationValueUtil.objectValue(sparseArray.get(8071), Object.class, null);
                if (f.this.d) {
                    n.b(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.b.5
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.a(activity, viewGroup, list, list2, o.a(AdnAdapterBridgeWrapper.covertToFunction(objObjectValue)));
                        }
                    });
                } else {
                    a(activity, viewGroup, list, list2, o.a(AdnAdapterBridgeWrapper.covertToFunction(objObjectValue)));
                }
            } else if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8147) {
                    return (T) c();
                }
                if (i == 8142) {
                    if (o.a(this.f2431a)) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long jA = o.a((Map<String, Object>) map);
                            long jB = o.b((Map<String, Object>) map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                            KsNativeAd ksNativeAd = this.f2431a;
                            if (ksNativeAd != null) {
                                ksNativeAd.setBidEcpm(jA, jB);
                            }
                        }
                    }
                } else if (i == 8144 && o.b(this.f2431a)) {
                    Map map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int iC = o.c(map2);
                        int iD = o.d(map2);
                        int iE = o.e(map2);
                        String strF = o.f(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + iD + " failureCode = " + iC);
                        if (this.f2431a != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(iD);
                            adExposureFailedReason.setAdnType(iE);
                            adExposureFailedReason.setAdnName(strF);
                            this.f2431a.reportAdExposureFailed(iC, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f2431a == null;
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            if (f.this.d) {
                b();
            } else {
                a();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    public f(KsBannerLoader ksBannerLoader) {
        this.c = ksBannerLoader;
    }

    @JProtect
    private void a(KsScene ksScene) {
        KsAdSDK.getLoadManager().loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.2
            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onError(int i, String str) {
                f.this.c.notifyAdFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
            public void onFeedAdLoad(List<KsFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    f.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功，list为空");
                    return;
                }
                for (KsFeedAd ksFeedAd : list) {
                    if (ksFeedAd != null) {
                        f fVar = f.this;
                        fVar.new a(ksFeedAd, fVar.f2422a, f.this.b).a();
                        return;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        KsBannerLoader ksBannerLoader;
        String str;
        if (context == null || mediationAdSlotValueSet == null) {
            ksBannerLoader = this.c;
            str = "context is null or adSlotValueSet is null";
        } else {
            this.f2422a = mediationAdSlotValueSet;
            this.b = this.c.getGMBridge();
            try {
                KsScene ksSceneBuild = new KsScene.Builder(Long.valueOf(this.c.getAdnId()).longValue()).adNum(1).build();
                if (mediationAdSlotValueSet.getAdSubType() == 4) {
                    int originType = mediationAdSlotValueSet.getOriginType();
                    if (originType == 1) {
                        float expressWidth = mediationAdSlotValueSet.getExpressWidth();
                        if (context != null && expressWidth > 0.0f) {
                            ksSceneBuild.setWidth((int) o.a(context, expressWidth));
                        }
                        a(ksSceneBuild);
                        return;
                    }
                    if (originType == 2) {
                        b(ksSceneBuild);
                        return;
                    } else {
                        ksBannerLoader = this.c;
                        str = "广告类型错误";
                    }
                } else {
                    ksBannerLoader = this.c;
                    str = "ks不支持banner";
                }
            } catch (Exception unused) {
                this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "广告位id错误");
                return;
            }
        }
        ksBannerLoader.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, str);
    }

    @JProtect
    private void b(KsScene ksScene) {
        KsAdSDK.getLoadManager().loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.3
            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onError(int i, String str) {
                f.this.c.notifyAdFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
            public void onNativeAdLoad(List<KsNativeAd> list) {
                if (list == null || list.isEmpty()) {
                    f.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功，list为空");
                    return;
                }
                for (KsNativeAd ksNativeAd : list) {
                    if (ksNativeAd != null) {
                        KsBannerLoader ksBannerLoader = f.this.c;
                        f fVar = f.this;
                        ksBannerLoader.notifyAdSuccess(fVar.new b(ksNativeAd, fVar.f2422a, f.this.b), f.this.b);
                        return;
                    }
                }
            }
        });
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.e = new WeakReference<>(context);
        boolean zA = o.a(this.c, mediationAdSlotValueSet);
        this.d = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.b(context.getApplicationContext(), mediationAdSlotValueSet);
                    n.a(getClass().getName(), context.getApplicationContext());
                }
            });
        } else {
            b(context.getApplicationContext(), mediationAdSlotValueSet);
        }
    }
}
