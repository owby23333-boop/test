package com.funny.audio.ad.loader;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.funny.audio.ad.UIUtils;
import com.funny.audio.core.utils.DeviceUtils;
import com.funny.audio.database.entities.AdSettingEntity;
import com.funny.audio.user.UserManager;
import com.qq.e.ads.cfg.VideoOption;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FeedAdLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u00106\u001a\u0002072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u001a\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<J\"\u0010=\u001a\u0002072\u0006\u00109\u001a\u00020:2\u0006\u0010>\u001a\u00020?2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010@R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006A"}, d2 = {"Lcom/funny/audio/ad/loader/FeedAdLoader;", "", "()V", "adEntity", "Lcom/funny/audio/database/entities/AdSettingEntity;", "getAdEntity", "()Lcom/funny/audio/database/entities/AdSettingEntity;", "setAdEntity", "(Lcom/funny/audio/database/entities/AdSettingEntity;)V", d.R, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "feedAds", "", "Lcom/bytedance/sdk/openadsdk/TTFeedAd;", "getFeedAds", "()Ljava/util/List;", "setFeedAds", "(Ljava/util/List;)V", "isLoading", "", "()Z", "setLoading", "(Z)V", "lastLoadedTime", "", "getLastLoadedTime", "()J", "setLastLoadedTime", "(J)V", "loaded", "getLoaded", "setLoaded", "preloadSize", "", "getPreloadSize", "()I", "setPreloadSize", "(I)V", "screenWidthDp", "", "getScreenWidthDp", "()F", "setScreenWidthDp", "(F)V", "tagName", "", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "init", "", "load", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "listener", "Lcom/funny/audio/ad/loader/FlowAdLoadListener;", "show", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "Lcom/funny/audio/ad/loader/FlowAdListener;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FeedAdLoader {
    private AdSettingEntity adEntity;
    private Context context;
    private boolean isLoading;
    private long lastLoadedTime;
    private boolean loaded;
    private float screenWidthDp;
    private String tagName = "FeedAdLoader";
    private List<TTFeedAd> feedAds = new ArrayList();
    private int preloadSize = 1;

    public final String getTagName() {
        return this.tagName;
    }

    public final void setTagName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagName = str;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    /* JADX INFO: renamed from: isLoading, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    public final boolean getLoaded() {
        return this.loaded;
    }

    public final void setLoaded(boolean z) {
        this.loaded = z;
    }

    public final AdSettingEntity getAdEntity() {
        return this.adEntity;
    }

    public final void setAdEntity(AdSettingEntity adSettingEntity) {
        this.adEntity = adSettingEntity;
    }

    public final long getLastLoadedTime() {
        return this.lastLoadedTime;
    }

    public final void setLastLoadedTime(long j) {
        this.lastLoadedTime = j;
    }

    public final List<TTFeedAd> getFeedAds() {
        return this.feedAds;
    }

    public final void setFeedAds(List<TTFeedAd> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.feedAds = list;
    }

    public final float getScreenWidthDp() {
        return this.screenWidthDp;
    }

    public final void setScreenWidthDp(float f) {
        this.screenWidthDp = f;
    }

    public final int getPreloadSize() {
        return this.preloadSize;
    }

    public final void setPreloadSize(int i) {
        this.preloadSize = i;
    }

    public final void init(Context context, AdSettingEntity adEntity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adEntity, "adEntity");
        this.context = context;
        this.adEntity = adEntity;
        this.screenWidthDp = UIUtils.getScreenWidthDp(context);
    }

    public static /* synthetic */ void load$default(FeedAdLoader feedAdLoader, Activity activity, FlowAdLoadListener flowAdLoadListener, int i, Object obj) {
        if ((i & 2) != 0) {
            flowAdLoadListener = null;
        }
        feedAdLoader.load(activity, flowAdLoadListener);
    }

    public final void load(Activity activity, final FlowAdLoadListener listener) {
        String deviceUUID;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Log.i(this.tagName, "信息流广告已经在加载中...");
        if (this.isLoading) {
            Log.i(this.tagName, "信息流广告已经在加载了");
            return;
        }
        if (this.loaded) {
            Log.i(this.tagName, "信息流广告重复加载");
            return;
        }
        this.isLoading = true;
        this.loaded = false;
        if (UserManager.INSTANCE.isLogin()) {
            deviceUUID = UserManager.INSTANCE.getUserId();
        } else {
            deviceUUID = DeviceUtils.INSTANCE.getDeviceUUID(this.context);
        }
        AdSettingEntity adSettingEntity = this.adEntity;
        Intrinsics.checkNotNull(adSettingEntity);
        final String codeId = adSettingEntity.getCodeId();
        this.feedAds.clear();
        float f = this.screenWidthDp;
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(activity);
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(codeId).setExpressViewAcceptedSize(f, 0.0f).setAdCount(this.preloadSize).setUserID(deviceUUID).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(true).setExtraObject(MediationConstant.KEY_GDT_VIDEO_OPTION, new VideoOption.Builder().setAutoPlayMuted(true).setAutoPlayPolicy(1).build()).build()).build();
        Intrinsics.checkNotNullExpressionValue(adSlotBuild, "Builder()\n            .s…   )\n            .build()");
        if (tTAdNativeCreateAdNative != null) {
            tTAdNativeCreateAdNative.loadFeedAd(adSlotBuild, new TTAdNative.FeedAdListener() { // from class: com.funny.audio.ad.loader.FeedAdLoader.load.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                public void onError(int code, String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    FeedAdLoader.this.setLoading(false);
                    Log.i(FeedAdLoader.this.getTagName(), "信息流广告(" + codeId + ")加载失败:" + code + "," + msg);
                    switch (code) {
                        case 40043:
                        case 40044:
                            FeedAdLoader.this.setLastLoadedTime(System.currentTimeMillis());
                            break;
                    }
                    FlowAdLoadListener flowAdLoadListener = listener;
                    if (flowAdLoadListener != null) {
                        flowAdLoadListener.onLoadFail(code, msg);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                public void onFeedAdLoad(List<TTFeedAd> ads) {
                    FeedAdLoader.this.setLoading(false);
                    FeedAdLoader.this.setLastLoadedTime(System.currentTimeMillis());
                    if (ads != null) {
                        List<TTFeedAd> list = ads;
                        if (!list.isEmpty()) {
                            Log.i(FeedAdLoader.this.getTagName(), "信息流广告加载成功(" + ads.size() + ")");
                            FeedAdLoader.this.setLoaded(true);
                            FeedAdLoader.this.getFeedAds().addAll(list);
                            FlowAdLoadListener flowAdLoadListener = listener;
                            if (flowAdLoadListener != null) {
                                flowAdLoadListener.onAdLoad();
                            }
                        }
                    }
                }
            });
        }
    }

    public static /* synthetic */ void show$default(FeedAdLoader feedAdLoader, Activity activity, ViewGroup viewGroup, FlowAdListener flowAdListener, int i, Object obj) {
        if ((i & 4) != 0) {
            flowAdListener = null;
        }
        feedAdLoader.show(activity, viewGroup, flowAdListener);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    public final void show(Activity activity, final ViewGroup container, final FlowAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        if (this.loaded) {
            if (this.feedAds.isEmpty()) {
                this.loaded = false;
                return;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = this.feedAds.remove(0);
            if (this.feedAds.isEmpty()) {
                this.loaded = false;
            }
            ((TTFeedAd) objectRef.element).setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.funny.audio.ad.loader.FeedAdLoader.show.1
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onCancel() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onShow() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public void onSelected(int p0, String p1, boolean p2) {
                    container.removeAllViews();
                    FlowAdListener flowAdListener = listener;
                    if (flowAdListener != null) {
                        flowAdListener.onAdClose();
                    }
                }
            });
            if (((TTFeedAd) objectRef.element).getMediationManager().isExpress()) {
                ((TTFeedAd) objectRef.element).setExpressRenderListener(new MediationExpressRenderListener() { // from class: com.funny.audio.ad.loader.FeedAdLoader.show.2
                    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                    public void onAdClick() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                    public void onAdShow() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
                    public void onRenderSuccess(View view, float width, float height, boolean b) {
                        View adView = objectRef.element.getAdView();
                        UIUtils.removeFromParent(adView);
                        container.removeAllViews();
                        container.addView(adView);
                        FlowAdListener flowAdListener = listener;
                        if (flowAdListener != null) {
                            flowAdListener.onAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
                    public void onRenderFail(View view, String msg, int code) {
                        String tagName = this.getTagName();
                        AdSettingEntity adEntity = this.getAdEntity();
                        Intrinsics.checkNotNull(adEntity);
                        Log.i(tagName, "信息流广告渲染失败(" + adEntity.getCodeId() + ")：" + code + "," + msg);
                    }
                });
                ((TTFeedAd) objectRef.element).render();
            }
            if (this.feedAds.isEmpty()) {
                this.loaded = false;
            }
        }
    }
}
