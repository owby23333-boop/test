package com.bytedance.adsdk.ugeno.widget.g;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.widget.image.g;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends g {
    private int cb;

    @Override // com.bytedance.adsdk.ugeno.widget.image.g
    protected String e() {
        return "drawable";
    }

    public abstract String kb(String str);

    public z(Context context) {
        super(context);
        this.cb = -16777216;
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.g, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        this.z = i(this.z);
        super.g();
        ((RoundImageView) this.gc).setColorFilter(this.cb);
        ((RoundImageView) this.gc).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String i(String str) {
        String strKb = kb(str);
        return TextUtils.isEmpty(strKb) ? "" : "local://".concat(String.valueOf(strKb));
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.g, com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        if (str.equals(QMUISkinValueBuilder.TEXT_COLOR)) {
            this.cb = com.bytedance.adsdk.ugeno.m.z.z(str2);
        }
    }
}
