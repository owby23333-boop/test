package com.kwad.components.core.page;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.webview.tachikoma.d.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.bw;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
public class AdWebViewActivityProxy extends f {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    private static final String KEY_IS_AUTO_SHOW = "key_is_auto_show";
    private static final String KEY_LANDING_PAGE_TYPE = "key_landing_page_type";
    private static final String KEY_PAGE_TITLE = "key_page_title";
    private static final String KEY_PAGE_URL = "key_page_url";
    private static final String KEY_SHOW_PERMISSION = "key_show_permission";
    private static final String KEY_SHOW_TK_CONFIRM_DIALOG = "key_show_tk_confirm_dialog";
    public static final String KEY_TEMPLATE = "key_template_json";
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private boolean mAutoShow;
    private com.kwad.components.core.r.b mDialogFragment;
    private boolean mDisableShowConfirmDialog;
    private boolean mHasShowShowConfirmDialog;
    private Dialog mKsExitInterceptDialog;
    private Dialog mKsExitInterceptDialogV2;
    private int mLandingPageType;
    private c mLandingPageView;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private volatile boolean destroyed = false;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.1
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            AdWebViewActivityProxy.this.finish();
        }
    };
    private com.kwad.components.core.page.a.a mLandPageViewListener = new com.kwad.components.core.page.a.a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.2
        @Override // com.kwad.components.core.page.a.a
        public final void qO() {
            AdWebViewActivityProxy.this.onBackPressed();
        }

        @Override // com.kwad.components.core.page.a.a
        public final void qP() {
            if (AdWebViewActivityProxy.this.mLandingPageView == null || !AdWebViewActivityProxy.this.mLandingPageView.getCanInterceptBackClick()) {
                if (!AdWebViewActivityProxy.this.mDisableShowConfirmDialog) {
                    if (AdWebViewActivityProxy.this.handleMiddlePageDialog()) {
                        return;
                    }
                    if (!AdWebViewActivityProxy.this.mAdTemplate.mIsForceJumpLandingPage) {
                        if (!com.kwad.sdk.core.response.b.a.aO(e.el(AdWebViewActivityProxy.this.mAdTemplate)) || com.kwad.components.core.r.a.sF().sG() != 1 || !com.kwad.components.core.r.a.sF().sL() || com.kwad.components.core.r.a.sF().sI()) {
                            if (AdWebViewActivityProxy.this.isFormAdExitInterceptEnable()) {
                                AdWebViewActivityProxy.this.showDialog();
                                return;
                            } else {
                                AdWebViewActivityProxy.this.finish();
                                return;
                            }
                        }
                        if (com.kwad.components.core.r.a.sF().sH() || !com.kwad.sdk.core.config.e.Fq()) {
                            AdWebViewActivityProxy.this.finish();
                            return;
                        }
                        AdWebViewActivityProxy adWebViewActivityProxy = AdWebViewActivityProxy.this;
                        adWebViewActivityProxy.mDialogFragment = adWebViewActivityProxy.getTkDialogFragment();
                        com.kwad.components.core.r.b.a(AdWebViewActivityProxy.this.mDialogFragment, AdWebViewActivityProxy.this.getActivity(), AdWebViewActivityProxy.this.mBaseDialogListener);
                        return;
                    }
                    AdWebViewActivityProxy.this.finish();
                    return;
                }
                AdWebViewActivityProxy.this.finish();
                return;
            }
            AdWebViewActivityProxy.this.mLandingPageView.qY();
        }
    };
    private com.kwad.components.core.webview.tachikoma.f.c mBaseDialogListener = new com.kwad.components.core.webview.tachikoma.f.c() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.3
        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void G(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void hj() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void ha() {
            com.kwad.components.core.r.a.sF().aO(true);
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public final void hi() {
            com.kwad.components.core.r.a.sF().aO(false);
        }
    };

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "AdWebViewActivityProxy";
    }

    public static void register() {
        com.kwad.sdk.service.c.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
    }

    public static void launch(Context context, a aVar) {
        if (context == null || TextUtils.isEmpty(aVar.Tk)) {
            return;
        }
        try {
            com.kwad.sdk.commercial.g.a.j(aVar.getAdTemplate(), aVar.qS(), aVar.qR());
            com.kwad.sdk.service.c.a(AdWebViewActivity.class, AdWebViewActivityProxy.class);
            Intent intent = new Intent(context, (Class<?>) AdWebViewActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(KEY_PAGE_TITLE, aVar.Tj);
            intent.putExtra(KEY_LANDING_PAGE_TYPE, aVar.To);
            intent.putExtra(KEY_PAGE_URL, aVar.Tk);
            intent.putExtra(KEY_IS_AUTO_SHOW, aVar.Tn);
            intent.putExtra(KEY_SHOW_PERMISSION, aVar.Tm);
            intent.putExtra(KEY_SHOW_TK_CONFIRM_DIALOG, aVar.qU());
            AdResultData adResultDataDW = aVar.Tl;
            if (adResultDataDW == null) {
                adResultDataDW = com.kwad.sdk.core.response.b.c.dW(aVar.adTemplate);
            }
            intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.ol().l(adResultDataDW));
            context.startActivity(intent);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            com.kwad.sdk.commercial.g.a.a(aVar.getAdTemplate(), aVar.qS(), aVar.qR(), bw.s(th));
            if (l.Cf().Bk()) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
            throw th;
        }
    }

    public static void launch(Context context, AdTemplate adTemplate) {
        launch(context, new a.C0344a().aA(com.kwad.sdk.core.response.b.b.cN(adTemplate)).aD(adTemplate).qW());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.g.a.k(this.mAdTemplate, this.mLandingPageType, this.mPageUrl);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(Intent intent) {
        AdResultData adResultDataD = com.kwad.components.core.c.f.ol().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = adResultDataD;
        if (adResultDataD == null) {
            return false;
        }
        AdTemplate adTemplateR = com.kwad.sdk.core.response.b.c.r(adResultDataD);
        this.mAdTemplate = adTemplateR;
        return adTemplateR != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        setContentView(R.layout.ksad_activity_landpage);
        initContentView();
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.destroyed = false;
        this.mPageTitle = getIntent().getStringExtra(KEY_PAGE_TITLE);
        this.mLandingPageType = getIntent().getIntExtra(KEY_LANDING_PAGE_TYPE, 0);
        this.mPageUrl = getIntent().getStringExtra(KEY_PAGE_URL);
        this.mAutoShow = getIntent().getBooleanExtra(KEY_IS_AUTO_SHOW, false);
        this.mShowPermission = getIntent().getBooleanExtra(KEY_SHOW_PERMISSION, false);
        this.mDisableShowConfirmDialog = getIntent().getBooleanExtra(KEY_SHOW_TK_CONFIRM_DIALOG, false);
    }

    private void initContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_land_page_root);
        c cVarA = c.a(this.mContext, new a.C0344a().az(this.mPageTitle).aA(this.mPageUrl).aD(this.mAdTemplate).aF(this.mShowPermission).aG(this.mAutoShow).aO(this.mLandingPageType).aH(this.mDisableShowConfirmDialog).qW());
        this.mLandingPageView = cVarA;
        cVarA.setLandPageViewListener(this.mLandPageViewListener);
        this.mLandingPageView.setWebCardCloseListener(this.mWebCardCloseListener);
        viewGroup.addView(this.mLandingPageView);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            this.destroyed = true;
            com.kwad.components.core.r.b bVar = this.mDialogFragment;
            if (bVar != null) {
                bVar.dismiss();
                this.mDialogFragment = null;
            }
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
                this.mAdTemplate.mIsForceJumpLandingPage = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        c cVar = this.mLandingPageView;
        if (cVar != null && cVar.getCanInterceptBackClick()) {
            this.mLandingPageView.qY();
            return;
        }
        if (this.mDisableShowConfirmDialog) {
            finish();
            return;
        }
        if (handleMiddlePageDialog()) {
            return;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null || adTemplate.mIsForceJumpLandingPage) {
            super.onBackPressed();
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aO(e.el(this.mAdTemplate)) && com.kwad.components.core.r.a.sF().sG() == 1 && com.kwad.components.core.r.a.sF().sL() && !com.kwad.components.core.r.a.sF().sI()) {
            if (com.kwad.components.core.r.a.sF().sH() || !com.kwad.sdk.core.config.e.Fq()) {
                super.onBackPressed();
                return;
            }
            com.kwad.components.core.r.b tkDialogFragment = getTkDialogFragment();
            this.mDialogFragment = tkDialogFragment;
            com.kwad.components.core.r.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
            return;
        }
        if (isFormAdExitInterceptEnable()) {
            try {
                if (this.mKsExitInterceptDialogV2 == null) {
                    this.mKsExitInterceptDialogV2 = new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0348a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.4
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
                        public final void a(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                            dialogInterface.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
                        public final void b(DialogInterface dialogInterface) {
                            if (!AdWebViewActivityProxy.this.destroyed) {
                                try {
                                    AdWebViewActivityProxy.super.onBackPressed();
                                } catch (Throwable th) {
                                    com.kwad.sdk.core.d.c.printStackTrace(th);
                                }
                            }
                            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
                        public final void c(DialogInterface dialogInterface) {
                            com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                            dialogInterface.dismiss();
                        }
                    });
                }
                com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
                this.mKsExitInterceptDialogV2.show();
                return;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleMiddlePageDialog() {
        boolean z = false;
        if (this.mAdTemplate == null || !com.kwad.sdk.core.config.e.Fq()) {
            return false;
        }
        if (!bp.isNullString(com.kwad.sdk.core.response.b.a.cn(this.mAdTemplate)) && com.kwad.sdk.core.response.b.a.cm(this.mAdTemplate)) {
            z = true;
            if (this.mHasShowShowConfirmDialog) {
                try {
                    super.onBackPressed();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            } else {
                com.kwad.components.core.r.b tkDialogFragment = getTkDialogFragment();
                this.mDialogFragment = tkDialogFragment;
                com.kwad.components.core.r.b.a(tkDialogFragment, getActivity(), this.mBaseDialogListener);
                this.mHasShowShowConfirmDialog = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFormAdExitInterceptEnable() {
        AdTemplate adTemplate;
        if (this.mShowPermission || (adTemplate = this.mAdTemplate) == null || e.O(adTemplate)) {
            return false;
        }
        if (com.kwad.sdk.core.config.e.Fy() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.e.Fz() && !this.mAdTemplate.mIsFromContent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.r.b getTkDialogFragment() {
        e.b bVar = new e.b();
        bVar.a(this.mAdResultData);
        bVar.bg(com.kwad.sdk.core.response.b.b.dQ(this.mAdTemplate));
        bVar.aZ(false);
        bVar.ba(true);
        return com.kwad.components.core.r.b.a(bVar);
    }

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0348a() { // from class: com.kwad.components.core.page.AdWebViewActivityProxy.5
            @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
            public final void b(DialogInterface dialogInterface) {
                try {
                    AdWebViewActivityProxy.super.onBackPressed();
                } catch (Throwable unused) {
                }
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.adlog.c.p(AdWebViewActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    public static class a {
        private String Tj;
        private String Tk;
        private AdResultData Tl;
        private boolean Tm;
        private boolean Tn;
        private int To;
        private boolean Tp;
        private AdTemplate adTemplate;

        /* synthetic */ a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adResultData, z, z2, z3, i);
        }

        /* synthetic */ a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i, byte b) {
            this(str, str2, adTemplate, z, z2, z3, i);
        }

        private a(String str, String str2, AdTemplate adTemplate, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.adTemplate = adTemplate;
        }

        private a(String str, String str2, AdResultData adResultData, boolean z, boolean z2, boolean z3, int i) {
            this(str, str2, z, z2, z3, i);
            this.Tl = adResultData;
            this.adTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
        }

        private a(String str, String str2, boolean z, boolean z2, boolean z3, int i) {
            this.Tj = str;
            this.Tk = str2;
            this.Tm = z;
            this.Tn = z2;
            this.Tp = z3;
            this.To = i;
        }

        public final String qQ() {
            return this.Tj;
        }

        public final String qR() {
            return this.Tk;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final int qS() {
            return this.To;
        }

        public final boolean qT() {
            return this.Tm;
        }

        public final boolean qU() {
            return this.Tp;
        }

        public final boolean qV() {
            return this.Tn;
        }

        /* JADX INFO: renamed from: com.kwad.components.core.page.AdWebViewActivityProxy$a$a, reason: collision with other inner class name */
        public static class C0344a {
            private String Tj;
            private String Tk;
            private AdResultData Tl;
            private boolean Tn;
            private int To = 0;
            private boolean Tp;
            private boolean Tq;
            private AdTemplate adTemplate;

            public final C0344a aF(boolean z) {
                this.Tq = z;
                return this;
            }

            public final C0344a aO(int i) {
                this.To = i;
                return this;
            }

            public final C0344a az(String str) {
                this.Tj = str;
                return this;
            }

            public final C0344a aA(String str) {
                this.Tk = str;
                return this;
            }

            public final C0344a q(AdResultData adResultData) {
                this.Tl = adResultData;
                return this;
            }

            public final C0344a aD(AdTemplate adTemplate) {
                this.adTemplate = adTemplate;
                return this;
            }

            public final C0344a aG(boolean z) {
                this.Tn = z;
                return this;
            }

            public final C0344a aH(boolean z) {
                this.Tp = z;
                return this;
            }

            public final a qW() {
                if (this.Tl != null) {
                    return new a(this.Tj, this.Tk, this.Tl, this.Tq, this.Tn, this.Tp, this.To, (byte) 0);
                }
                return new a(this.Tj, this.Tk, this.adTemplate, this.Tq, this.Tn, this.Tp, this.To, (byte) 0);
            }
        }
    }
}
