package com.kwad.components.core.page;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.components.core.a.a;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.widget.a;
import com.kwad.components.core.r.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentTransaction;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.widget.DownloadProgressBar;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
public class AdWebViewVideoActivityProxy extends com.kwad.components.core.l.a {
    public static final String KEY_REPORTED = "key_reported";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static boolean showingAdWebViewVideoActivity = false;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private b mFragment;
    private Dialog mKsExitInterceptDialog;
    private DownloadProgressBar mProgressbar;
    private com.kwad.components.core.page.splitLandingPage.a mSplitLandingPage;
    private com.kwad.components.core.a.a mTitleBarHelper;
    private ViewGroup mWebDownloadContainer;

    private com.kwad.components.core.page.widget.a buildDialog() {
        return new com.kwad.components.core.page.widget.a(getActivity(), new a.InterfaceC0408a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.4
            @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
            public final void a(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.p(AdWebViewVideoActivityProxy.this.mAdTemplate, 104);
                dialogInterface.dismiss();
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
            public final void b(DialogInterface dialogInterface) {
                AdWebViewVideoActivityProxy.super.onBackPressed();
                com.kwad.sdk.core.report.a.p(AdWebViewVideoActivityProxy.this.mAdTemplate, 105);
            }

            @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
            public final void c(DialogInterface dialogInterface) {
                com.kwad.sdk.core.report.a.p(AdWebViewVideoActivityProxy.this.mAdTemplate, 106);
                dialogInterface.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.C0395a getAdClickConfig(boolean z2) {
        return new a.C0395a(getActivity()).al(z2).aq(true).am(false).J(this.mAdTemplate).ao(false);
    }

    private void initView() {
        KsFragmentTransaction ksFragmentTransactionBeginTransaction;
        KsFragment ksFragment;
        this.mProgressbar = (DownloadProgressBar) findViewById(R.id.ksad_web_download_progress);
        this.mWebDownloadContainer = (ViewGroup) findViewById(R.id.ksad_web_download_container);
        final AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
            this.mWebDownloadContainer.setVisibility(0);
            this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.ax(adInfoCb));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.aI(AdWebViewVideoActivityProxy.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.ax(adInfoCb));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(100.0f);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.U(adInfoCb));
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i2) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.bv(i2));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i2) {
                    AdWebViewVideoActivityProxy.this.mProgressbar.setProgress(i2);
                    AdWebViewVideoActivityProxy.this.mProgressbar.setText(com.kwad.sdk.core.response.a.a.bu(i2));
                }
            });
            this.mProgressbar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.kwad.sdk.core.report.a.a(AdWebViewVideoActivityProxy.this.mAdTemplate, 50, (ab.a) null);
                    com.kwad.components.core.d.b.a.a(AdWebViewVideoActivityProxy.this.getAdClickConfig(true));
                }
            });
        } else {
            this.mWebDownloadContainer.setVisibility(8);
        }
        List<AdInfo> list = this.mAdTemplate.adInfoList;
        String strBJ = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bJ(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        this.mTitleBarHelper = new com.kwad.components.core.a.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper.a(new a.InterfaceC0385a() { // from class: com.kwad.components.core.page.AdWebViewVideoActivityProxy.3
            @Override // com.kwad.components.core.a.a.InterfaceC0385a
            public final void u(View view) {
                AdWebViewVideoActivityProxy.this.onBackPressed();
            }

            @Override // com.kwad.components.core.a.a.InterfaceC0385a
            public final void v(View view) {
                AdWebViewVideoActivityProxy.this.finish();
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.a.b(strBJ));
        ah.cr(getActivity());
        e.a(getActivity(), 0, true);
        int i2 = R.id.ksad_recycler_container;
        if (com.kwad.sdk.core.config.d.uh() != 0) {
            this.mSplitLandingPage = com.kwad.components.core.page.splitLandingPage.a.N(this.mAdTemplate);
            this.mSplitLandingPage.setApkDownloadHelper(this.mApkDownloadHelper);
            ksFragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            ksFragment = this.mSplitLandingPage;
        } else {
            this.mFragment = b.L(this.mAdTemplate);
            this.mFragment.setApkDownloadHelper(this.mApkDownloadHelper);
            ksFragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            ksFragment = this.mFragment;
        }
        ksFragmentTransactionBeginTransaction.replace(i2, ksFragment).commitAllowingStateLoss();
    }

    private boolean isFormAdExitInterceptEnable() {
        if (this.mAdTemplate == null) {
            return false;
        }
        if (com.kwad.sdk.core.config.d.uH() && this.mAdTemplate.mIsFromContent) {
            return true;
        }
        return com.kwad.sdk.core.config.d.uI() && !this.mAdTemplate.mIsFromContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void launch(Context context, AdTemplate adTemplate) {
        if (context == 0 || adTemplate == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.FragmentActivity3.class);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra(KEY_REPORTED, adTemplate.mPvReported);
        context.startActivity(intent);
        boolean z2 = context instanceof ResContext;
        Object delegatedContext = context;
        if (z2) {
            delegatedContext = ((ResContext) context).getDelegatedContext();
        }
        if (delegatedContext instanceof Activity) {
            ((Activity) delegatedContext).overridePendingTransition(0, 0);
        }
    }

    public static void register() {
        com.kwad.sdk.service.a.a(BaseFragmentActivity.FragmentActivity3.class, AdWebViewVideoActivityProxy.class);
    }

    private void showDialog() {
        if (this.mKsExitInterceptDialog == null) {
            this.mKsExitInterceptDialog = buildDialog();
        }
        com.kwad.sdk.core.report.a.b(this.mAdTemplate, 103, (JSONObject) null);
        this.mKsExitInterceptDialog.show();
    }

    private void showWaitDialog() {
        if (isFormAdExitInterceptEnable()) {
            showDialog();
        } else {
            finish();
        }
    }

    @Override // com.kwad.components.core.l.a
    public String getPageName() {
        return "AdWebViewVideoActivityProxy";
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.page.splitLandingPage.a aVar = this.mSplitLandingPage;
        if (aVar == null || !aVar.bX()) {
            com.kwad.components.core.page.splitLandingPage.a aVar2 = this.mSplitLandingPage;
            if (aVar2 != null) {
                aVar2.pg();
            }
            b bVar = this.mFragment;
            if (bVar == null || !bVar.bX()) {
                showWaitDialog();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ksad_activity_ad_video_webview);
        showingAdWebViewVideoActivity = true;
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
        AdTemplate adTemplate2 = this.mAdTemplate;
        if (adTemplate2 == null) {
            finish();
        } else {
            adTemplate2.mPvReported = getIntent().getBooleanExtra(KEY_REPORTED, false);
            initView();
        }
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        Dialog dialog = this.mKsExitInterceptDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mKsExitInterceptDialog.dismiss();
        }
        super.onDestroy();
        showingAdWebViewVideoActivity = false;
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        showingAdWebViewVideoActivity = false;
        overridePendingTransition(0, 0);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        showingAdWebViewVideoActivity = true;
    }
}
