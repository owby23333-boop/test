package com.bytedance.sdk.openadsdk.core.component.reward.business.g;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private int g;
    private String z;

    public String z() {
        return this.z;
    }

    public void z(String str) {
        this.z = str;
    }

    public void z(int i) {
        this.g = i;
    }

    public int g() {
        return this.g;
    }

    public boolean dl() {
        return !TextUtils.isEmpty(this.z);
    }
}
