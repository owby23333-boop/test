package com.anythink.network.ks;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.china.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.a;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KSATNativeAd extends CustomNativeAd {
    Context a;
    KsNativeAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f12508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f12509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    FrameLayout f12510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f12512g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f12513h = 0;

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATNativeAd$1, reason: invalid class name */
    final class AnonymousClass1 implements KsNativeAd.AdInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final void onAdClicked(View view, KsNativeAd ksNativeAd) {
            KSATNativeAd.this.notifyAdClicked();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final void onAdShow(KsNativeAd ksNativeAd) {
            KSATInitManager.getInstance().a(KSATNativeAd.this.getShowId(), new WeakReference(ksNativeAd));
            KSATNativeAd.this.notifyAdImpression();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public final void onDownloadTipsDialogShow() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATNativeAd$2, reason: invalid class name */
    final class AnonymousClass2 implements KsAppDownloadListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            if (((a) KSATNativeAd.this).mDownloadListener == null || !(((a) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            CustomAdapterDownloadListener customAdapterDownloadListener = (CustomAdapterDownloadListener) ((a) KSATNativeAd.this).mDownloadListener;
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            customAdapterDownloadListener.onDownloadFail(kSATNativeAd.f12509d, kSATNativeAd.f12513h, "", kSATNativeAd.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            if (((a) KSATNativeAd.this).mDownloadListener == null || !(((a) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            CustomAdapterDownloadListener customAdapterDownloadListener = (CustomAdapterDownloadListener) ((a) KSATNativeAd.this).mDownloadListener;
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            customAdapterDownloadListener.onDownloadFinish(kSATNativeAd.f12509d, "", kSATNativeAd.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadStarted() {
            if (((a) KSATNativeAd.this).mDownloadListener == null || !(((a) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            CustomAdapterDownloadListener customAdapterDownloadListener = (CustomAdapterDownloadListener) ((a) KSATNativeAd.this).mDownloadListener;
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            customAdapterDownloadListener.onDownloadStart(kSATNativeAd.f12509d, 0L, "", kSATNativeAd.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            if (((a) KSATNativeAd.this).mDownloadListener == null || !(((a) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            ((CustomAdapterDownloadListener) ((a) KSATNativeAd.this).mDownloadListener).onInstalled("", KSATNativeAd.this.getTitle());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            if (((a) KSATNativeAd.this).mDownloadListener == null || !(((a) KSATNativeAd.this).mDownloadListener instanceof CustomAdapterDownloadListener)) {
                return;
            }
            KSATNativeAd kSATNativeAd = KSATNativeAd.this;
            kSATNativeAd.f12513h = (kSATNativeAd.f12509d * ((long) i2)) / 100;
            CustomAdapterDownloadListener customAdapterDownloadListener = (CustomAdapterDownloadListener) ((a) kSATNativeAd).mDownloadListener;
            KSATNativeAd kSATNativeAd2 = KSATNativeAd.this;
            customAdapterDownloadListener.onDownloadUpdate(kSATNativeAd2.f12509d, kSATNativeAd2.f12513h, "", kSATNativeAd2.getTitle());
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATNativeAd$3, reason: invalid class name */
    final class AnonymousClass3 implements KsNativeAd.VideoPlayListener {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            KSATNativeAd.this.notifyAdVideoEnd();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i2, int i3) {
            String str = "KuaiShou Video play error:" + i2 + " " + i3;
            KSATNativeAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i2), String.valueOf(i3));
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            KSATNativeAd.this.notifyAdVideoStart();
        }
    }

    public KSATNativeAd(Context context, KsNativeAd ksNativeAd, boolean z2) {
        this.f12509d = 0L;
        this.a = context.getApplicationContext();
        this.b = ksNativeAd;
        this.f12511f = z2;
        setTitle(this.b.getAppName());
        setIconImageUrl(this.b.getAppIconUrl());
        setAdFrom(this.b.getAdSource());
        setStarRating(Double.valueOf(this.b.getAppScore()));
        setDescriptionText(this.b.getAdDescription());
        setAdChoiceIconUrl(this.b.getAdSourceLogoUrl(0));
        setNativeInteractionType(this.b.getInteractionType() == 2 ? 3 : this.b.getInteractionType() == 1 ? 1 : 0);
        ArrayList arrayList = new ArrayList();
        List<KsImage> imageList = this.b.getImageList();
        if (imageList != null && imageList.size() > 0) {
            for (int i2 = 0; i2 < imageList.size(); i2++) {
                KsImage ksImage = imageList.get(i2);
                if (ksImage != null) {
                    arrayList.add(ksImage.getImageUrl());
                    if (i2 == 0) {
                        setMainImageUrl(ksImage.getImageUrl());
                        setMainImageWidth(ksImage.getWidth());
                        setMainImageHeight(ksImage.getHeight());
                    }
                }
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.b.getActionDescription());
        setVideoDuration(this.b.getVideoDuration());
        setVideoUrl(this.b.getVideoUrl());
        setVideoWidth(this.b.getVideoWidth());
        setVideoHeight(this.b.getVideoHeight());
        this.f12509d = this.b.getAppPackageSize();
        if (this.b.getInteractionType() == 1) {
            setAdAppInfo(new KSATDownloadAppInfo(this.b));
        }
        if (this.b.getMaterialType() == 1) {
            this.mAdSourceType = "1";
        } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
            this.mAdSourceType = "2";
        }
        this.f12510e = new FrameLayout(context.getApplicationContext());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
        a(view);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        KsNativeAd ksNativeAd = this.b;
        if (ksNativeAd != null) {
            ksNativeAd.setDownloadListener(null);
            try {
                this.b.registerViewForInteraction(null, null, null);
            } catch (Exception unused) {
            }
        }
        this.a = null;
        this.f12510e = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.b.getMaterialType() == 1) {
            return this.f12510e;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() <= 0) {
            clickViewList = new ArrayList<>();
            a(clickViewList, view);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        this.b.registerViewForInteraction(viewGroup, clickViewList, new AnonymousClass1());
        this.b.setDownloadListener(new AnonymousClass2());
        this.b.setVideoPlayListener(new AnonymousClass3());
        if (this.b.getMaterialType() == 1) {
            KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
            builder.videoSoundEnable(this.f12511f);
            int i2 = this.f12512g;
            if (i2 > 0) {
                builder.videoSoundEnable(i2 != 1);
            }
            this.f12508c = this.b.getVideoView(viewGroup.getContext(), builder.build());
            View view2 = this.f12508c;
            if (view2 == null || this.f12510e == null || view2.getParent() != null) {
                return;
            }
            this.f12510e.addView(this.f12508c);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z2) {
        super.setVideoMute(z2);
        this.f12512g = z2 ? 1 : 2;
    }

    private void a() {
        setTitle(this.b.getAppName());
        setIconImageUrl(this.b.getAppIconUrl());
        setAdFrom(this.b.getAdSource());
        setStarRating(Double.valueOf(this.b.getAppScore()));
        setDescriptionText(this.b.getAdDescription());
        setAdChoiceIconUrl(this.b.getAdSourceLogoUrl(0));
        int i2 = this.b.getInteractionType() == 1 ? 1 : 0;
        if (this.b.getInteractionType() == 2) {
            i2 = 3;
        }
        setNativeInteractionType(i2);
        ArrayList arrayList = new ArrayList();
        List<KsImage> imageList = this.b.getImageList();
        if (imageList != null && imageList.size() > 0) {
            for (int i3 = 0; i3 < imageList.size(); i3++) {
                KsImage ksImage = imageList.get(i3);
                if (ksImage != null) {
                    arrayList.add(ksImage.getImageUrl());
                    if (i3 == 0) {
                        setMainImageUrl(ksImage.getImageUrl());
                        setMainImageWidth(ksImage.getWidth());
                        setMainImageHeight(ksImage.getHeight());
                    }
                }
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.b.getActionDescription());
        setVideoDuration(this.b.getVideoDuration());
        setVideoUrl(this.b.getVideoUrl());
        setVideoWidth(this.b.getVideoWidth());
        setVideoHeight(this.b.getVideoHeight());
        this.f12509d = this.b.getAppPackageSize();
        if (this.b.getInteractionType() == 1) {
            setAdAppInfo(new KSATDownloadAppInfo(this.b));
        }
        if (this.b.getMaterialType() == 1) {
            this.mAdSourceType = "1";
        } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
            this.mAdSourceType = "2";
        }
    }

    private void a(List<View> list, View view) {
        if ((view instanceof ViewGroup) && view != this.f12508c) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(list, viewGroup.getChildAt(i2));
            }
            return;
        }
        if (view != this.f12508c) {
            list.add(view);
        }
    }

    private void a(ViewGroup viewGroup, List<View> list) {
        this.b.registerViewForInteraction(viewGroup, list, new AnonymousClass1());
        this.b.setDownloadListener(new AnonymousClass2());
        this.b.setVideoPlayListener(new AnonymousClass3());
        if (this.b.getMaterialType() == 1) {
            KsAdVideoPlayConfig.Builder builder = new KsAdVideoPlayConfig.Builder();
            builder.videoSoundEnable(this.f12511f);
            int i2 = this.f12512g;
            if (i2 > 0) {
                builder.videoSoundEnable(i2 != 1);
            }
            this.f12508c = this.b.getVideoView(viewGroup.getContext(), builder.build());
            View view = this.f12508c;
            if (view == null || this.f12510e == null || view.getParent() != null) {
                return;
            }
            this.f12510e.addView(this.f12508c);
        }
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if ((view instanceof ViewGroup) && view != this.f12508c) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2));
            }
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }
}
