package com.kwad.components.ad.splashscreen.b.kwai;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.r.h;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ba;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.splashscreen.b.e implements View.OnClickListener {
    private TextView DQ;
    private TextView DR;
    private TextView DS;
    private TextView DT;
    private AdInfo.DownloadSafeInfo DU;

    private void initView() {
        this.DQ = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.DR = (TextView) findViewById(R.id.ksad_ad_permission_text);
        this.DS = (TextView) findViewById(R.id.ksad_ad_privacy_text);
        this.DT = (TextView) findViewById(R.id.ksad_ad_developer_text);
    }

    private void lG() {
        if (com.kwad.sdk.core.response.a.a.aI(com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate))) {
            StringBuilder sb = new StringBuilder();
            String str = this.DU.appVersion;
            if (ba.ex(str)) {
                sb.append("版本号：");
                sb.append(str);
                sb.append("  |  ");
            }
            long j2 = this.DU.packageSize;
            if (j2 > 0) {
                sb.append("应用大小：");
                sb.append(h.a(j2, true));
            }
            if (ba.ex(sb.toString())) {
                this.DQ.setText(sb);
            }
            AdInfo.DownloadSafeInfo downloadSafeInfo = this.DU;
            String str2 = downloadSafeInfo.appPermissionInfoUrl;
            String str3 = downloadSafeInfo.appPrivacyUrl;
            if (ba.ex(str2)) {
                this.DR.setText("权限信息");
                this.DR.setOnClickListener(this);
            }
            StringBuilder sb2 = new StringBuilder();
            if (ba.ex(str2)) {
                sb2.append(" | ");
            }
            if (ba.ex(str3)) {
                sb2.append("隐私政策");
                this.DS.setText(sb2);
                this.DS.setOnClickListener(this);
            }
            StringBuilder sb3 = new StringBuilder();
            String str4 = this.DU.appName;
            if (ba.ex(str4)) {
                sb3.append("应用名：");
                sb3.append(str4);
                sb3.append("；");
            }
            String str5 = this.DU.corporationName;
            if (ba.ex(str5)) {
                sb3.append("开发者：");
                sb3.append(str5);
            }
            if (ba.ex(sb3.toString())) {
                this.DT.setText(sb3);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.DU = com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate).downloadSafeInfo;
        lG();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.DS) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0405a().ar("隐私政策").as(this.DU.appPrivacyUrl).ax(true).M(this.Cx.mAdTemplate).ow());
        } else if (view == this.DR) {
            AdWebViewActivityProxy.launch(getContext(), new AdWebViewActivityProxy.a.C0405a().ar("权限信息").ax(true).as(this.DU.appPermissionInfoUrl).M(this.Cx.mAdTemplate).ow());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
