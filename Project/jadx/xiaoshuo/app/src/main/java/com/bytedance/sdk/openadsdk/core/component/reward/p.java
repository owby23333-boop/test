package com.bytedance.sdk.openadsdk.core.component.reward;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public class p {
    private int bf;
    private String e;

    public int bf() {
        return this.bf;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.e);
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(int i) {
        this.bf = i;
    }
}
