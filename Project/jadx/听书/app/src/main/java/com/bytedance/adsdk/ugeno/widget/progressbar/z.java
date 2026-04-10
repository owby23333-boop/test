package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.m.gz;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<UGProgressBar> {
    private float cb;
    private String k;
    private float o;
    private int wo;
    private int wx;
    private int z;

    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public UGProgressBar z() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.g);
        uGProgressBar.z(this);
        return uGProgressBar;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        ((UGProgressBar) this.gc).setBackgroundColor(this.wo);
        ((UGProgressBar) this.gc).setText(this.k);
        ((UGProgressBar) this.gc).setProgressBgColor(this.wo);
        ((UGProgressBar) this.gc).setProgressColor(this.z);
        ((UGProgressBar) this.gc).setTextColor(this.wx);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "progressBgColor":
                this.wo = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case "textColor":
                this.wx = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case "textSize":
                this.cb = gz.z(this.g, str2);
                break;
            case "progress":
                this.o = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case "text":
                this.k = str2;
                break;
            case "progressColor":
                this.z = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
        }
    }
}
