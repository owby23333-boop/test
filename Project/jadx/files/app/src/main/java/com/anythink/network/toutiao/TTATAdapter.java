package com.anythink.network.toutiao;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.anythink.network.toutiao.TTATNativeExpressHandler;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTATAdapter extends CustomNativeAdapter {
    String a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12604c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f12608g = TTATAdapter.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12605d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f12606e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f12607f = false;

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f12611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f12612d;

        AnonymousClass2(Context context, Map map, Map map2, int i2) {
            this.a = context;
            this.b = map;
            this.f12611c = map2;
            this.f12612d = i2;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // java.lang.Runnable
        public final void run() {
            final boolean z2;
            final int i2;
            final Bitmap bitmap;
            TTAdManager adManager = TTAdSdk.getAdManager();
            int i3 = this.a.getResources().getDisplayMetrics().widthPixels;
            int i4 = this.a.getResources().getDisplayMetrics().heightPixels;
            Map map = this.b;
            if (map != null) {
                Object obj = map.containsKey(ATAdConst.KEY.AD_WIDTH) ? this.b.get(ATAdConst.KEY.AD_WIDTH) : null;
                Object obj2 = this.b.containsKey(TTATConst.NATIVE_AD_IMAGE_HEIGHT) ? this.b.get(TTATConst.NATIVE_AD_IMAGE_HEIGHT) : this.b.containsKey(ATAdConst.KEY.AD_HEIGHT) ? this.b.get(ATAdConst.KEY.AD_HEIGHT) : null;
                Object obj3 = this.b.get(TTATConst.NATIVE_AD_INTERRUPT_VIDEOPLAY);
                Object obj4 = this.b.get(TTATConst.NATIVE_AD_VIDEOPLAY_BTN_BITMAP);
                Object obj5 = this.b.get(TTATConst.NATIVE_AD_VIDEOPLAY_BTN_SIZE);
                if (obj == null || obj2 == null) {
                    int i5 = TTATAdapter.this.f12605d;
                    if (i5 == 1) {
                        i3 = 690;
                        i4 = 388;
                    } else if (i5 == 2) {
                        i3 = TbsListener.ErrorCode.INCR_ERROR_DETAIL;
                        i4 = TbsListener.ErrorCode.STARTDOWNLOAD_API_LEVEL_BELOW_FROYO;
                    } else if (i5 == 3) {
                        i3 = 1280;
                        i4 = 720;
                    } else if (i5 == 4) {
                        i3 = 1200;
                        i4 = 628;
                    } else if (i5 == 5) {
                        i3 = 640;
                        i4 = 640;
                    }
                } else {
                    try {
                        i3 = (int) Double.parseDouble(obj.toString());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        i4 = (int) Double.parseDouble(obj2.toString());
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                z2 = obj3 instanceof Boolean ? Boolean.parseBoolean(obj3.toString()) : true;
                bitmap = obj4 instanceof Bitmap ? (Bitmap) obj4 : null;
                i2 = obj5 instanceof Integer ? Integer.parseInt(obj5.toString()) : 0;
            } else {
                z2 = true;
                i2 = 0;
                bitmap = null;
            }
            TTAdNative tTAdNativeCreateAdNative = adManager.createAdNative(this.a);
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATAdapter.this.a, this.f12611c, this.b);
            tTATCustomAdSlotBuilder.setAdCount(Math.min(this.f12612d, 3));
            tTATCustomAdSlotBuilder.setSupportDeepLink(true);
            if (TextUtils.equals("0", TTATAdapter.this.f12604c) && TextUtils.equals("0", TTATAdapter.this.b)) {
                String unused = TTATAdapter.this.f12608g;
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(TTATAdapter.a(this.a, i3), TTATAdapter.a(this.a, i4));
                tTAdNativeCreateAdNative.loadNativeExpressAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i6, String str) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                    public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        TTATAdapter.a(TTATAdapter.this, anonymousClass2.a, (List) list, z2, false);
                    }
                });
                return;
            }
            if (TextUtils.equals("1", TTATAdapter.this.f12604c) && TextUtils.equals("0", TTATAdapter.this.b)) {
                String unused2 = TTATAdapter.this.f12608g;
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(TTATAdapter.a(this.a, i3), TTATAdapter.a(this.a, i4));
                tTAdNativeCreateAdNative.loadExpressDrawFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i6, String str) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                    public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        TTATAdapter.a(TTATAdapter.this, anonymousClass2.a, (List) list, z2, true);
                    }
                });
                return;
            }
            if (i3 <= 0 || i4 <= 0) {
                tTATCustomAdSlotBuilder.setImageAcceptedSize(640, TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE);
            } else {
                tTATCustomAdSlotBuilder.setImageAcceptedSize(i3, i4);
            }
            String str = TTATAdapter.this.f12604c;
            byte b = -1;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        b = 0;
                    }
                    break;
                case 49:
                    if (str.equals("1")) {
                        b = 1;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        b = 2;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        b = 3;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        b = 4;
                    }
                    break;
            }
            if (b == 0) {
                tTAdNativeCreateAdNative.loadFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.FeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.3
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i6, String str2) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                    public final void onFeedAdLoad(List<TTFeedAd> list) {
                        ArrayList arrayList = new ArrayList();
                        for (TTFeedAd tTFeedAd : list) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            arrayList.add(new TTATNativeAd(anonymousClass2.a, TTATAdapter.this.a, tTFeedAd, z2, bitmap, i2));
                        }
                        TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                    }
                });
                return;
            }
            if (b == 1) {
                tTAdNativeCreateAdNative.loadDrawFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.DrawFeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.4
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
                    public final void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                        ArrayList arrayList = new ArrayList();
                        for (TTDrawFeedAd tTDrawFeedAd : list) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            arrayList.add(new TTATNativeAd(anonymousClass2.a, TTATAdapter.this.a, tTDrawFeedAd, z2, bitmap, i2));
                        }
                        TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i6, String str2) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                    }
                });
                return;
            }
            if (b == 2) {
                tTATCustomAdSlotBuilder.setNativeAdType(1);
                tTAdNativeCreateAdNative.loadNativeAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.5
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i6, String str2) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
                    public final void onNativeAdLoad(List<TTNativeAd> list) {
                        ArrayList arrayList = new ArrayList();
                        for (TTNativeAd tTNativeAd : list) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            arrayList.add(new TTATNativeAd(anonymousClass2.a, TTATAdapter.this.a, tTNativeAd, z2, bitmap, i2));
                        }
                        TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                    }
                });
            } else if (b == 3) {
                tTATCustomAdSlotBuilder.setNativeAdType(2);
                tTAdNativeCreateAdNative.loadNativeAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.6
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i6, String str2) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
                    public final void onNativeAdLoad(List<TTNativeAd> list) {
                        ArrayList arrayList = new ArrayList();
                        for (TTNativeAd tTNativeAd : list) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            arrayList.add(new TTATNativeAd(anonymousClass2.a, TTATAdapter.this.a, tTNativeAd, z2, bitmap, i2));
                        }
                        TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                    }
                });
            } else if (b != 4) {
                TTATAdapter.this.notifyATLoadFail("", "The Native type is not exit.");
            } else {
                tTAdNativeCreateAdNative.loadStream(tTATCustomAdSlotBuilder.build(), new TTAdNative.FeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.7
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i6, String str2) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                    public final void onFeedAdLoad(List<TTFeedAd> list) {
                        if (list == null || list.isEmpty()) {
                            TTATAdapter.this.notifyATLoadFail("", "Ad list is empty.");
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (TTFeedAd tTFeedAd : list) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            arrayList.add(new TTATNativePatchAd(anonymousClass2.a, TTATAdapter.this.a, tTFeedAd, z2, bitmap, i2));
                        }
                        TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements TTATNativeExpressHandler.RenderCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f12624c;

        AnonymousClass3(Context context, boolean z2, boolean z3) {
            this.a = context;
            this.b = z2;
            this.f12624c = z3;
        }

        @Override // com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback
        public final void onRenderFail(String str, int i2) {
            TTATAdapter.this.notifyATLoadFail(String.valueOf(i2), str);
        }

        @Override // com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback
        public final void onRenderSuccess(List<TTNativeExpressAd> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<TTNativeExpressAd> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new TTATNativeExpressAd(this.a, TTATAdapter.this.a, it.next(), this.b, this.f12624c));
            }
            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        if (a(map)) {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TTATAdapter.this.notifyATLoadFail("", str);
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    TTATAdapter tTATAdapter = TTATAdapter.this;
                    TTATAdapter.a(tTATAdapter, context, map, map2, tTATAdapter.f12607f ? 1 : ((CustomNativeAdapter) tTATAdapter).mRequestNum);
                }
            });
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f12607f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2, int i2) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(this.f12604c)) {
            notifyATLoadFail("", "nativeType is empty");
        } else {
            runOnNetworkRequestThread(new AnonymousClass2(applicationContext, map2, map, i2));
        }
    }

    private static int b(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    private void a(Context context, List<TTNativeExpressAd> list, boolean z2, boolean z3) {
        new TTATNativeExpressHandler(list).startRender(new AnonymousClass3(context, z2, z3));
    }

    private void a(List<? extends TTClientBidding> list, CustomNativeAd... customNativeAdArr) {
        if (list.size() != 0 && customNativeAdArr.length != 0) {
            TTClientBidding tTClientBidding = list.get(0);
            HashMap map = new HashMap(3);
            if (tTClientBidding instanceof TTNativeAd) {
                try {
                    Map<String, Object> mediaExtraInfo = ((TTNativeAd) tTClientBidding).getMediaExtraInfo();
                    if (mediaExtraInfo != null) {
                        map.putAll(mediaExtraInfo);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (tTClientBidding instanceof TTNativeExpressAd) {
                try {
                    Map<String, Object> mediaExtraInfo2 = ((TTNativeExpressAd) tTClientBidding).getMediaExtraInfo();
                    if (mediaExtraInfo2 != null) {
                        map.putAll(mediaExtraInfo2);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (this.f12607f) {
                if (this.mBiddingListener != null) {
                    TTATInitManager.getInstance().a(map, customNativeAdArr[0], list.get(0), this.mBiddingListener);
                    this.mBiddingListener = null;
                    return;
                }
                return;
            }
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(customNativeAdArr);
                return;
            }
            return;
        }
        notifyATLoadFail("", "Ad list is empty.");
    }

    private boolean a(Map<String, Object> map) {
        String str = (String) map.get("app_id");
        this.a = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.a)) {
            return false;
        }
        this.b = "1";
        if (map.containsKey("layout_type")) {
            this.b = (String) map.get("layout_type");
        } else {
            this.b = "0";
        }
        if (map.containsKey("is_video")) {
            this.f12604c = map.get("is_video").toString();
        }
        try {
            if (map.containsKey("media_size")) {
                this.f12605d = Integer.parseInt(map.get("media_size").toString());
            }
        } catch (Exception unused) {
        }
        if (!map.containsKey("payload")) {
            return true;
        }
        this.f12606e = map.get("payload").toString();
        return true;
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, Context context, Map map, Map map2, int i2) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(tTATAdapter.f12604c)) {
            tTATAdapter.notifyATLoadFail("", "nativeType is empty");
        } else {
            tTATAdapter.runOnNetworkRequestThread(tTATAdapter.new AnonymousClass2(applicationContext, map2, map, i2));
        }
    }

    static /* synthetic */ int a(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, Context context, List list, boolean z2, boolean z3) {
        new TTATNativeExpressHandler(list).startRender(tTATAdapter.new AnonymousClass3(context, z2, z3));
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, List list, CustomNativeAd[] customNativeAdArr) {
        if (list.size() != 0 && customNativeAdArr.length != 0) {
            Object obj = list.get(0);
            HashMap map = new HashMap(3);
            if (obj instanceof TTNativeAd) {
                try {
                    Map<String, Object> mediaExtraInfo = ((TTNativeAd) obj).getMediaExtraInfo();
                    if (mediaExtraInfo != null) {
                        map.putAll(mediaExtraInfo);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (obj instanceof TTNativeExpressAd) {
                try {
                    Map<String, Object> mediaExtraInfo2 = ((TTNativeExpressAd) obj).getMediaExtraInfo();
                    if (mediaExtraInfo2 != null) {
                        map.putAll(mediaExtraInfo2);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (tTATAdapter.f12607f) {
                if (tTATAdapter.mBiddingListener != null) {
                    TTATInitManager.getInstance().a(map, customNativeAdArr[0], (TTClientBidding) list.get(0), tTATAdapter.mBiddingListener);
                    tTATAdapter.mBiddingListener = null;
                    return;
                }
                return;
            }
            ATCustomLoadListener aTCustomLoadListener = tTATAdapter.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(customNativeAdArr);
                return;
            }
            return;
        }
        tTATAdapter.notifyATLoadFail("", "Ad list is empty.");
    }
}
