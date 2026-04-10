package com.kwad.components.core.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.a.a;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.af;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
@Deprecated
public class AdLandPageActivityProxy extends com.kwad.components.core.l.d {
    private static final String KEY_DIALOG_URL = "key_dialog_url";
    public static final String KEY_TEMPLATE = "key_template_json";
    private static final String TAG = "AdWebViewActivityProxy";
    private static boolean mIsDownloadDialogShowing = false;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private String mDialogUrl;
    private com.kwad.sdk.core.webview.b mJsBridgeContext;
    private com.kwad.components.core.webview.a mJsInterface;
    private com.kwad.components.core.a.a mTitleBarHelper;
    private ViewGroup mWebContainer;
    private ImageView mWebTipBarCloseBtn;
    private LinearLayout mWebTipBarLayout;
    private TextView mWebTipBarTitle;
    private ae webCardRegisterLifecycleListenerHandler;

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    private y.b getClientParams() {
        y.b bVar = new y.b();
        bVar.ajX = 0;
        return bVar;
    }

    @NonNull
    private KsAdWebView.c getOnWebViewScrollChangeListener() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.5
            @Override // com.kwad.sdk.core.webview.KsAdWebView.c
            public final void op() {
                if (AdLandPageActivityProxy.this.mWebTipBarLayout.getVisibility() == 0) {
                    AdLandPageActivityProxy.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        };
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                    AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.rs();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                if (AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler != null) {
                    AdLandPageActivityProxy.this.webCardRegisterLifecycleListenerHandler.rr();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
            }
        };
    }

    private void inflateJsBridgeContext() {
        this.mJsBridgeContext = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar = this.mJsBridgeContext;
        bVar.mScreenOrientation = 0;
        bVar.Lk = this.mAdWebView;
        bVar.LI = this.mWebContainer;
    }

    private void initTipBarView() {
        this.mWebTipBarLayout = (LinearLayout) findViewById(R.id.ksad_web_tip_bar);
        this.mWebTipBarTitle = (TextView) findViewById(R.id.ksad_web_tip_bar_textview);
        this.mWebTipBarCloseBtn = (ImageView) findViewById(R.id.ksad_web_tip_close_btn);
        this.mWebTipBarCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdLandPageActivityProxy.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        boolean zBm = com.kwad.sdk.core.response.a.a.bm(adInfoCb);
        String strBi = com.kwad.sdk.core.response.a.a.bi(adInfoCb);
        if (!zBm) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        this.mWebTipBarTitle.setText(strBi);
        this.mWebTipBarTitle.setSelected(true);
    }

    public static boolean isDownloadDialogShowing() {
        return mIsDownloadDialogShowing;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void launch(Context context, AdTemplate adTemplate, String str) {
        if (context == 0 || adTemplate == null) {
            return;
        }
        com.kwad.sdk.service.a.a(AdWebViewActivity.class, AdLandPageActivityProxy.class);
        Intent intent = new Intent(context, (Class<?>) AdWebViewActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_DIALOG_URL, str);
        context.startActivity(intent);
        boolean z2 = context instanceof ResContext;
        Object delegatedContext = context;
        if (z2) {
            delegatedContext = ((ResContext) context).getDelegatedContext();
        }
        if (delegatedContext instanceof Activity) {
            ((Activity) delegatedContext).overridePendingTransition(0, 0);
        }
        mIsDownloadDialogShowing = true;
    }

    private void registerWebCardHandler(com.kwad.components.core.webview.a aVar, com.kwad.components.core.d.b.c cVar) {
        aVar.a(new j(this.mJsBridgeContext, cVar, null));
        aVar.a(new g(this.mJsBridgeContext, cVar, (com.kwad.sdk.core.webview.c.kwai.a) null));
        aVar.a(new m(this.mJsBridgeContext));
        aVar.a(new ah(this.mJsBridgeContext, cVar));
        aVar.a(new t(this.mJsBridgeContext));
        aVar.a(new z(new z.b() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.1
            @Override // com.kwad.components.core.webview.jshandler.z.b
            public final void a(z.a aVar2) {
            }
        }, this.mDialogUrl));
        this.webCardRegisterLifecycleListenerHandler = new ae();
        aVar.a(this.webCardRegisterLifecycleListenerHandler);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void setupJsBridge(KsAdWebView ksAdWebView, com.kwad.components.core.d.b.c cVar) {
        clearJsInterfaceRegister();
        this.mJsInterface = new com.kwad.components.core.webview.a(ksAdWebView);
        registerWebCardHandler(this.mJsInterface, cVar);
        ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
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

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_activity_ad_webview;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "AdLandPageActivityProxy";
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.mDialogUrl = getIntent().getStringExtra(KEY_DIALOG_URL);
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        KsAdWebView ksAdWebView;
        String strAL;
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().cr(this.mAdTemplate).b(getClientParams()).c(getOnWebViewScrollChangeListener()).b(getWebErrorListener()));
        this.mAdWebView.onActivityCreate();
        findViewById(R.id.ksad_kwad_titlebar_title);
        findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_kwad_web_navi_close);
        this.mWebContainer = (ViewGroup) findViewById(R.id.ksad_landing_page_root);
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        String strBJ = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdLandPageActivityProxy.this.finish();
            }
        });
        this.mTitleBarHelper = new com.kwad.components.core.a.a(this.mWebContainer);
        this.mTitleBarHelper.a(new a.InterfaceC0385a() { // from class: com.kwad.components.core.page.AdLandPageActivityProxy.3
            @Override // com.kwad.components.core.a.a.InterfaceC0385a
            public final void u(View view) {
                AdLandPageActivityProxy.this.onBackPressed();
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0385a
            public final void v(View view) {
                AdLandPageActivityProxy.this.finish();
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.a.b(strBJ));
        initTipBarView();
        if (this.mDialogUrl != null) {
            inflateJsBridgeContext();
            com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            setupJsBridge(this.mAdWebView, cVar);
            if (com.kwad.sdk.core.config.d.ux() && af.isWifiConnected(getActivity())) {
                cVar.m(new a.C0395a(getActivity()).al(false).am(false).J(this.mAdTemplate).ao(false));
            }
            ksAdWebView = this.mAdWebView;
            strAL = this.mDialogUrl;
        } else {
            ksAdWebView = this.mAdWebView;
            strAL = com.kwad.sdk.core.response.a.a.aL(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        }
        ksAdWebView.loadUrl(strAL);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView == null || !ksAdWebView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.mAdWebView.goBack();
            com.kwad.sdk.core.report.a.ay(this.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        ae aeVar = this.webCardRegisterLifecycleListenerHandler;
        if (aeVar != null) {
            aeVar.onDestroy();
        }
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        super.onDestroy();
        mIsDownloadDialogShowing = false;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onStop() {
        super.onStop();
    }
}
