package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;

/* JADX INFO: loaded from: classes2.dex */
public class BaseThemeActivity extends Activity {
    protected na gc;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        na naVarZ = eo.z(getIntent());
        this.gc = naVarZ;
        if (naVarZ == null) {
            wp.g("BaseLandingPageActivity", "物料为空,退出落地页!");
        } else {
            if (!naVarZ.a() || (window = getWindow()) == null) {
                return;
            }
            window.addFlags(512);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }
}
