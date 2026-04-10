package com.kwad.components.ad.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
public class FeedDownloadActivityProxy extends com.kwad.components.core.l.d implements View.OnClickListener {
    private static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    private static final String TAG = "FeedDownloadActivity";
    private static b.InterfaceC0422b sInnerAdInteractionListener;
    private KsAdContainer mAdContainer;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private TailFrameBarAppPortraitVertical mAppTailFrameView;
    private TextProgressBar mProgressBarTv;

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.ax(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aI(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.ax(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.U(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.bv(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.bu(i2), i2);
            }
        });
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, b.InterfaceC0422b interfaceC0422b) {
        com.kwad.sdk.service.a.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, (Class<?>) FeedDownloadActivity.class);
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        sInnerAdInteractionListener = interfaceC0422b;
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new i().c(this.mAdContainer.getTouchCoords()), (JSONObject) null);
        b.InterfaceC0422b interfaceC0422b = sInnerAdInteractionListener;
        if (interfaceC0422b != null) {
            interfaceC0422b.onAdClicked();
        }
    }

    public static void register() {
        com.kwad.sdk.service.a.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
        return this.mAdTemplate != null;
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.kA();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_activity_feed_download;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "FeedDownloadActivityProxy";
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        this.mAdContainer = (KsAdContainer) findViewById(R.id.ksad_container);
        this.mAdContainer.setOnClickListener(this);
        this.mAppTailFrameView = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_download_container);
        this.mAppTailFrameView.bindView(this.mAdTemplate);
        this.mAppTailFrameView.x(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        this.mProgressBarTv = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv.setOnClickListener(this);
        bindDownloadListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.d.b.a.a(new a.C0395a(view.getContext()).J(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.mProgressBarTv ? 1 : 2).al(view == this.mProgressBarTv).a(new a.b() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.2
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                FeedDownloadActivityProxy.this.notifyAdClick();
            }
        }));
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }
}
