package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class a extends z {
    private String cb;
    private int o;
    private String wx;

    public a(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.z
    public void z(int i, int i2, int i3) {
        if (i3 <= 0 && !TextUtils.isEmpty(this.k)) {
            this.z = this.k;
            wp(this.z);
            return;
        }
        int i4 = this.o;
        int i5 = i4 - i2;
        if (i4 > 0 && i5 > 0) {
            this.z = this.wx;
        } else {
            this.z = this.cb;
        }
        this.z = this.z.replace("${_countdownTime_}", String.valueOf(i5)).replace("${_remainTime_}", String.valueOf(i3));
        wp(this.z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.z, com.bytedance.adsdk.ugeno.widget.text.g, com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.wx = str2;
                break;
            case "text2":
                this.cb = str2;
                break;
            case "startCountDown":
                this.o = com.bytedance.adsdk.ugeno.m.dl.z(str2, -1);
                break;
        }
    }
}
