package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;

/* JADX INFO: loaded from: classes3.dex */
public class z extends com.bytedance.adsdk.ugeno.widget.text.g {
    private String cb;
    protected String k;
    private String wx;

    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.g, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        if (TextUtils.isEmpty(this.cb) || TextUtils.equals(this.cb, "null")) {
            this.cb = "";
        }
        if (TextUtils.isEmpty(this.wx) || TextUtils.equals(this.wx, "null")) {
            this.wx = "";
        }
        this.z = this.wx + this.cb;
        wp(this.z);
        ((UGTextView) this.gc).setGravity(17);
    }

    public void z(int i, int i2, int i3) {
        if (i <= 0 && !TextUtils.isEmpty(this.k)) {
            this.z = this.k;
            wp(this.z);
            return;
        }
        if (TextUtils.isEmpty(this.cb) || TextUtils.equals(this.cb, "null")) {
            this.cb = "";
        }
        if (TextUtils.isEmpty(this.wx) || TextUtils.equals(this.wx, "null")) {
            this.wx = "";
        }
        this.z = this.wx + i + this.cb;
        wp(this.z);
    }

    protected void wp(String str) {
        ((UGTextView) this.gc).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.gc).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                a((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.g, com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "before":
                this.wx = str2;
                break;
            case "finish":
                this.k = str2;
                break;
            case "after":
                this.cb = str2;
                break;
        }
    }
}
