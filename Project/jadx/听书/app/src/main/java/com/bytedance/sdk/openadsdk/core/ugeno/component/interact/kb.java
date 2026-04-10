package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class kb extends com.bytedance.adsdk.ugeno.widget.frame.z {
    private final float[] k;
    private String wo;

    public kb(Context context) {
        super(context);
        this.k = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        if (TextUtils.equals(str, "clickableInteract")) {
            this.wo = str2;
        } else {
            super.z(str, str2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.frame.z, com.bytedance.adsdk.ugeno.g.z, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        kb(this.wo);
        super.g();
    }

    private void kb(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.length() <= 2 || (strArrSplit = strTrim.substring(1, strTrim.length() - 1).split(",")) == null || strArrSplit.length != 4) {
            return;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.k[i] = Float.parseFloat(com.bytedance.sdk.openadsdk.upie.z.z.z(str2.trim(), this.f239a));
                } catch (NumberFormatException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        }
    }

    public float[] sv() {
        return this.k;
    }
}
