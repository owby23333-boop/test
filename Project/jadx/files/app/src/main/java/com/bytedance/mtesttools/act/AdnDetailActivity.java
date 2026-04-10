package com.bytedance.mtesttools.act;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.c;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.d;
import bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1.g;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.ad.custom.init.GMCustomAdapterConfiguration;
import com.bytedance.mtesttools.base.BaseActivity;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;

/* JADX INFO: loaded from: classes2.dex */
public class AdnDetailActivity extends BaseActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f14474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TextView f14475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    TextView f14476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TextView f14477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    TextView f14478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    TextView f14479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    TextView f14480i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    TextView f14481j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    TextView f14482k;

    private void b() {
        this.f14475d.setText(GMMediationAdSdk.getSdkVersion());
        String strD = this.f14474c.d();
        if (TextUtils.isEmpty(strD)) {
            this.f14476e.setText("—");
        } else {
            this.f14476e.setText(strD);
        }
        String strE = this.f14474c.e();
        if (TextUtils.isEmpty(strE)) {
            this.f14477f.setText("—");
        } else {
            this.f14477f.setText(strE);
        }
        boolean zH = d.h(this.f14474c.c());
        GMCustomAdapterConfiguration gMCustomAdapterConfigurationA = d.a(this.f14474c.c());
        if (zH) {
            if (gMCustomAdapterConfigurationA == null) {
                this.f14478g.setText("未找到");
                this.f14478g.setEnabled(false);
            } else {
                this.f14478g.setEnabled(true);
                this.f14478g.setSelected(false);
                this.f14478g.setText(gMCustomAdapterConfigurationA.getNetworkSdkVersion());
            }
            this.f14481j.setVisibility(8);
        } else {
            String strE2 = d.e(this.f14474c.c());
            if (TextUtils.isEmpty(strE2)) {
                this.f14478g.setText("未找到");
                this.f14478g.setEnabled(false);
                this.f14481j.setVisibility(8);
            } else {
                this.f14478g.setText(strE2);
                if (GMMediationAdSdk.isAdnVersionFit(this.f14474c.c(), strE2)) {
                    this.f14478g.setEnabled(true);
                    this.f14478g.setSelected(false);
                    this.f14481j.setVisibility(8);
                } else {
                    this.f14478g.setEnabled(false);
                    this.f14481j.setVisibility(0);
                }
            }
        }
        if (zH) {
            if (gMCustomAdapterConfigurationA == null) {
                this.f14479h.setText("未找到");
                this.f14479h.setEnabled(false);
            } else {
                this.f14479h.setEnabled(true);
                this.f14479h.setSelected(false);
                this.f14479h.setText(gMCustomAdapterConfigurationA.getAdapterSdkVersion());
            }
            this.f14482k.setVisibility(8);
        } else {
            String strC = d.c(this.f14474c.c());
            if (TextUtils.isEmpty(strC)) {
                this.f14479h.setText("未找到");
                this.f14479h.setEnabled(false);
                this.f14482k.setVisibility(8);
            } else {
                this.f14479h.setText(strC);
                if (GMMediationAdSdk.isAdapterVersionFit(this.f14474c.c(), strC)) {
                    this.f14479h.setEnabled(true);
                    this.f14479h.setSelected(false);
                    this.f14482k.setVisibility(8);
                } else {
                    this.f14479h.setEnabled(false);
                    this.f14482k.setVisibility(0);
                }
            }
        }
        if (zH) {
            this.f14480i.setEnabled(true);
            this.f14480i.setSelected(true);
            this.f14480i.setText("不支持检测");
        } else if (!d.a(this, this.f14474c.c())) {
            this.f14480i.setText("未找到");
            this.f14480i.setEnabled(false);
        } else {
            this.f14480i.setText("已找到");
            this.f14480i.setEnabled(true);
            this.f14480i.setSelected(false);
        }
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity
    protected int a() {
        return R$layout.ttt_activity_adn_detail;
    }

    @Override // com.bytedance.mtesttools.base.BaseActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f14474c = (c) getIntent().getSerializableExtra("adn_config");
        if (this.f14474c == null) {
            g.a(this, "暂无数据，请稍后重试");
            finish();
            return;
        }
        a(this.f14474c.a() + "组件接入", true);
        this.f14475d = (TextView) findViewById(R$id.msdk_version);
        this.f14476e = (TextView) findViewById(R$id.app_id);
        this.f14477f = (TextView) findViewById(R$id.app_key);
        this.f14478g = (TextView) findViewById(R$id.adn_version);
        this.f14479h = (TextView) findViewById(R$id.adapter_version);
        this.f14480i = (TextView) findViewById(R$id.manifest_status);
        this.f14481j = (TextView) findViewById(R$id.adn_no_fit);
        this.f14482k = (TextView) findViewById(R$id.adapter_no_fit);
        b();
    }
}
