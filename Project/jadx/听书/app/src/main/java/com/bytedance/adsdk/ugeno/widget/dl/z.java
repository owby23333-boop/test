package com.bytedance.adsdk.ugeno.widget.dl;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends com.bytedance.adsdk.ugeno.g.z<UGFrameLayout> {
    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.z, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                g(str, str2);
                break;
        }
    }
}
