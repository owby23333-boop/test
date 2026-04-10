package com.amgcyo.cuttadon.activity.setting;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity;

/* JADX INFO: loaded from: classes.dex */
public class MkBrowserActivity extends BaseWebViewAcitivity {
    @Override // com.amgcyo.cuttadon.activity.base.BaseWebViewAcitivity, me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        super.initData(bundle);
        String stringExtra = getIntent().getStringExtra("param_url");
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
        } else {
            this.webView.loadUrl(stringExtra);
        }
    }
}
