package com.amgcyo.cuttadon.h.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.SdkErrorBean;
import com.amgcyo.cuttadon.app.MkApplication;
import com.amgcyo.cuttadon.f.n;
import com.amgcyo.cuttadon.h.a.f;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: CsjNewBaseAdUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends f {

    /* JADX INFO: compiled from: CsjNewBaseAdUtil.java */
    class a implements TTNativeExpressAd.ExpressAdInteractionListener {
        final /* synthetic */ FrameLayout a;
        final /* synthetic */ TTNativeExpressAd b;

        a(b bVar, FrameLayout frameLayout, TTNativeExpressAd tTNativeExpressAd) {
            this.a = frameLayout;
            this.b = tTNativeExpressAd;
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdClicked(View view, int i2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onAdShow(View view, int i2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderFail(View view, String str, int i2) {
            g.a(new Throwable("CsjExpressFlowAdTools onRenderFail," + str + " code: " + i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public void onRenderSuccess(View view, float f2, float f3) {
            if (this.a != null) {
                this.a.removeAllViews();
                this.a.setTag(this.b);
                this.a.addView(view);
            }
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CsjNewBaseAdUtil.java */
    class C0091b implements TTAppDownloadListener {
        C0091b(b bVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadActive(long j2, long j3, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFailed(long j2, long j3, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadFinished(long j2, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onDownloadPaused(long j2, long j3, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public void onInstalled(String str, String str2) {
        }
    }

    /* JADX INFO: compiled from: CsjNewBaseAdUtil.java */
    class c implements TTAdDislike.DislikeInteractionCallback {
        final /* synthetic */ FrameLayout a;
        final /* synthetic */ String b;

        c(FrameLayout frameLayout, String str) {
            this.a = frameLayout;
            this.b = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onCancel() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onSelected(int i2, String str, boolean z2) {
            b.this.b("点击 " + str);
            Object tag = this.a.getTag();
            String str2 = "tag:" + tag;
            if ("chapterContentAdView".equals(tag) || "ad_end".equals(tag)) {
                me.jessyan.art.d.f.a().a(str, "tag_refresh_page");
            }
            com.amgcyo.cuttadon.h.a.c.a(this.b, 0L);
            this.a.removeAllViews();
            if (z2) {
                b.this.b("模版Banner 穿山甲sdk强制将view关闭了");
            }
            com.amgcyo.cuttadon.h.h.c.a("ad_dislike_reason", b.this.a(), z2 + " · " + str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public void onShow() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
    }

    @Override // com.amgcyo.cuttadon.h.a.f
    public String a() {
        return "csj_new";
    }

    @Nullable
    protected TTAdNative c(Context context) {
        TTAdManager tTAdManager = MkApplication.getTTAdManager();
        if (tTAdManager != null) {
            return tTAdManager.createAdNative(context);
        }
        return null;
    }

    AdSlot a(String str, int i2, int i3) {
        return new AdSlot.Builder().setCodeId(str).setSupportDeepLink(true).setExpressViewAcceptedSize(i2, i3).setImageAcceptedSize(640, TbsListener.ErrorCode.ERROR_SDKENGINE_INIT_THROWABLE).setAdLoadType(TTAdLoadType.LOAD).build();
    }

    void a(String str, FrameLayout frameLayout, Context context, TTNativeExpressAd tTNativeExpressAd) {
        tTNativeExpressAd.setExpressInteractionListener(new a(this, frameLayout, tTNativeExpressAd));
        a(str, frameLayout, tTNativeExpressAd, context);
        if (tTNativeExpressAd.getInteractionType() != 4) {
            return;
        }
        tTNativeExpressAd.setDownloadListener(new C0091b(this));
    }

    private void a(String str, FrameLayout frameLayout, TTNativeExpressAd tTNativeExpressAd, Context context) {
        tTNativeExpressAd.setDislikeCallback((Activity) context, new c(frameLayout, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, SdkErrorBean sdkErrorBean) {
        a(context, sdkErrorBean, n.f3689c);
    }
}
