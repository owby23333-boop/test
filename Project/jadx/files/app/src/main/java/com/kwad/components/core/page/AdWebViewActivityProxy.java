package com.kwad.components.core.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.webview.a.b.d;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
public class AdWebViewActivityProxy extends com.kwad.components.core.l.d {
    private static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    private static final String KEY_PAGE_TITLE = "key_page_title";
    private static final String KEY_PAGE_URL = "key_page_url";
    private static final String KEY_SHOW_PERMISSION = "key_show_permission";
    public static final String KEY_TEMPLATE = "key_template_json";
    private AdTemplate mAdTemplate;
    private boolean mAutoShow;
    private com.kwad.components.core.p.b mDialogFragment;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private c mLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private com.kwad.sdk.core.webview.c.kwai.b mWebCardCloseListener = new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        @Override // com.kwad.sdk.core.webview.c.kwai.b
        public final void a(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.page.kwai.a mLandPageViewListener = new com.kwad.components.core.page.kwai.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        @Override // com.kwad.components.core.page.kwai.a
        public final void dK() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.kwai.a
        public final void dL() {
            if (AdWebViewActivityProxy.this.mLandingPageView != null && AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                AdWebViewActivityProxy.this.mLandingPageView.oy();
                return;
            }
            if (AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                AdWebViewActivityProxy.this.finish();
                return;
            }
            if (com.kwad.sdk.core.response.a.a.aH(com.kwad.sdk.core.response.a.d.cb(AdWebViewActivityProxy.this.mAdTemplate)) && com.kwad.components.core.p.a.pJ().pK() == 1 && com.kwad.components.core.p.a.pJ().pP() && !com.kwad.components.core.p.a.pJ().pM()) {
                if (!com.kwad.components.core.p.a.pJ().pL()) {
                    AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                    adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
                    com.kwad.components.core.p.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
                    return;
                }
            } else if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                AdWebViewActivityProxy.this.showDialog();
                return;
            }
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.webview.a.d.c mBaseDialogListener = new com.kwad.components.core.webview.a.d.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        @Override // com.kwad.components.core.webview.a.d.c
        public final void J(boolean z2) {
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public final void gs() {
            com.kwad.components.core.p.a.pJ().aG(true);
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public final void gy() {
            com.kwad.components.core.p.a.pJ().aG(false);
        }

        @Override // com.kwad.components.core.webview.a.d.c
        public final void gz() {
        }
    };

    public static class a {
        private String Lq;
        private String Lr;
        private boolean Ls;
        private boolean Lt;
        private AdTemplate adTemplate;

        /* JADX INFO: renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a, reason: collision with other inner class name */
        public static class C0405a {
            private String Lq;
            private String Lr;
            private boolean Lt;
            private boolean Lu;
            private AdTemplate adTemplate;

            public final C0405a M(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }

            public final C0405a ar(String str) {
                this.Lq = str;
                return this;
            }

            public final C0405a as(String str) {
                this.Lr = str;
                return this;
            }

            public final C0405a ax(boolean z2) {
                this.Lu = z2;
                return this;
            }

            public final C0405a ay(boolean z2) {
                this.Lt = z2;
                return this;
            }

            public final a ow() {
                return new a(this.Lq, this.Lr, this.adTemplate, this.Lu, this.Lt, (byte) 0);
            }
        }

        private a(String str, String str2, AdTemplate adTemplate, boolean z2, boolean z3) {
            this.Lq = str;
            this.Lr = str2;
            this.adTemplate = adTemplate;
            this.Ls = z2;
            this.Lt = z3;
        }

        /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z2, boolean z3, byte b) {
            this(str, str2, adTemplate, z2, z3);
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final String os() {
            return this.Lq;
        }

        public final String ot() {
            return this.Lr;
        }

        public final boolean ou() {
            return this.Ls;
        }

        public final boolean ov() {
            return this.Lt;
        }
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0408a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                com.kwad.sdk.core.report.a.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.p.b getTkDialogFragment() {
        d.b bVar = new d.b();
        bVar.setAdTemplate(this.mAdTemplate);
        bVar.aH("ksad-video-web-close-card");
        bVar.aN(false);
        bVar.aO(true);
        return com.kwad.components.core.p.b.a(bVar);
    }

    private void initContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_land_page_root);
        this.mLandingPageView = c.b(this.mContext, new a.C0405a().ar(this.mPageTitle).as(this.mPageUrl).M(this.mAdTemplate).ax(this.mShowPermission).ay(this.mAutoShow).ow());
        this.mLandingPageView.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        viewGroup.addView(this.mLandingPageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || com.kwad.sdk.core.response.a.d.q(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.d.uH() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.d.uI() && !this.mAdTemplate.mIsFromContent;
    }

    public static void launch(Context context, a aVar) {
        if (context == null || TextUtils.isEmpty(aVar.Lr)) {
            return;
        }
        com.kwad.sdk.f.a.e("all", "convert", "launch_landing_page");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(aVar.adTemplate.mAdScene != null ? KSLoggerReporter.bs(aVar.adTemplate.mAdScene.getAdStyle()) : null, "startH5Page").report();
        com.kwad.sdk.service.a.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
        Intent intent = new Intent(context, (Class<?>) AdWebViewActivity.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra(KEY_PAGE_TITLE, aVar.Lq);
        intent.putExtra(KEY_PAGE_URL, aVar.Lr);
        intent.putExtra(KEY_IS_AUTO_SHOW, aVar.Lt);
        intent.putExtra("key_template_json", aVar.adTemplate.toJson().toString());
        intent.putExtra(KEY_SHOW_PERMISSION, aVar.Ls);
        context.startActivity(intent);
        com.kwad.sdk.f.a.f("all", "convert", "launch_landing_page");
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C0405a().as(com.kwad.sdk.core.response.a.b.bh(adTemplate)).M(adTemplate).ow());
    }

    public static void register() {
        com.kwad.sdk.service.a.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
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
        return 0;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.destroyed = false;
        String stringExtra = getIntent().getStringExtra("key_template_json");
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        try {
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        setContentView(R.layout.ksad_activity_landpage);
        initContentView();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mLandingPageView;
        if (cVar != null && cVar.getCanInterceptBackClick()) {
            this.mLandingPageView.oy();
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null || adTemplate.mIsForceJumpLandingPage) {
            super.onBackPressed();
            return;
        }
        if (com.kwad.sdk.core.response.a.a.aH(com.kwad.sdk.core.response.a.d.cb(adTemplate)) && com.kwad.components.core.p.a.pJ().pK() == 1 && com.kwad.components.core.p.a.pJ().pP() && !com.kwad.components.core.p.a.pJ().pM()) {
            if (com.kwad.components.core.p.a.pJ().pL()) {
                super.onBackPressed();
                return;
            } else {
                this.mDialogFragment = getTkDialogFragment();
                com.kwad.components.core.p.b.a(this.mDialogFragment, getActivity(), this.mBaseDialogListener);
                return;
            }
        }
        if (isFormAdExitInterceptEnable()) {
            try {
                if (this.mKsExitInterceptDialogV2 == null) {
                    this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0408a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
                        public final void a(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.report.a.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                            dialogInterface.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
                        public final void b(DialogInterface dialogInterface) {
                            if (!AdWebViewActivityProxy.this.destroyed) {
                                try {
                                    AdWebViewActivityProxy.super.onBackPressed();
                                } catch (Throwable th) {
                                    com.kwad.sdk.core.d.b.printStackTrace(th);
                                }
                            }
                            com.kwad.sdk.core.report.a.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
                        public final void c(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.report.a.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                            dialogInterface.dismiss();
                        }
                    });
                }
                com.kwad.sdk.core.report.a.b(this.mAdTemplate, 103, (JSONObject) null);
                this.mKsExitInterceptDialogV2.show();
                return;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
        super.onBackPressed();
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        SceneImpl sceneImpl;
        super.onCreate(bundle);
        AdTemplate adTemplate = this.mAdTemplate;
        KSLoggerReporter.ReportClient.CONVERT_H5WEB.buildMethodCheck((adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) ? null : KSLoggerReporter.bs(sceneImpl.getAdStyle()), "h5PageCreate").report();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        this.destroyed = true;
        Dialog dialog = this.mKsExitInterceptDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mKsExitInterceptDialog.dismiss();
        }
        Dialog dialog2 = this.mKsExitInterceptDialogV2;
        if (dialog2 != null && dialog2.isShowing()) {
            this.mKsExitInterceptDialogV2.dismiss();
        }
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.interactLandingPageShowing = false;
            adTemplate.mIsForceJumpLandingPage = false;
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}
