package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.g.g;
import com.bytedance.sdk.openadsdk.core.iq.gc;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.ugeno.m.z;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.v.gz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class BaseLandingPageActivity extends BaseThemeActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f913a;
    protected String dl;
    private boolean e;
    protected String g;
    private UgenBanner m;
    protected String z;

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.dl = intent.getStringExtra("event_tag");
        this.z = intent.getStringExtra(MediationConstant.EXTRA_ADID);
        this.g = intent.getStringExtra(MediationConstant.EXTRA_LOG_EXTRA);
        this.f913a = intent.getIntExtra("source", -1);
    }

    @Override // android.app.Activity
    protected void onResume() {
        String strHy;
        super.onResume();
        Window window = getWindow();
        if (window != null) {
            gz.z(window.getDecorView());
        }
        if (this.gc == null || !g()) {
            return;
        }
        if (this.m == null) {
            this.m = new UgenBanner(this);
        }
        addContentView(this.m, new ViewGroup.LayoutParams(-1, -2));
        this.e = true;
        gc gcVarC = this.gc.c();
        if (gcVarC != null) {
            strHy = gcVarC.dl();
        } else {
            strHy = this.gc.hy();
        }
        this.m.setTopMargin(oq.dl(this, 50.0f));
        this.m.z(z(), this.gc, new g(this, this.gc, this.dl, this.f913a), strHy, this.gc.li(), "立即打开", true);
    }

    private z z() {
        ls lsVarVy = this.gc.vy();
        if (lsVarVy == null) {
            return null;
        }
        String strM = lsVarVy.m();
        if (TextUtils.isEmpty(strM)) {
            return null;
        }
        z zVar = new z();
        zVar.dl(strM);
        zVar.g(lsVarVy.e());
        zVar.z(strM);
        return zVar;
    }

    private boolean g() {
        ls lsVarVy = this.gc.vy();
        if (lsVarVy == null) {
            return false;
        }
        lsVarVy.z(true);
        int iDl = lsVarVy.dl();
        return (iDl == 1 || iDl == 2) && !this.e;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ls lsVarVy;
        super.onDestroy();
        UgenBanner ugenBanner = this.m;
        if (ugenBanner != null) {
            ugenBanner.z();
        }
        if (this.gc == null || (lsVarVy = this.gc.vy()) == null) {
            return;
        }
        lsVarVy.z(false);
    }
}
