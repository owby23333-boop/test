package com.bytedance.sdk.openadsdk.core.ugeno.component.z;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class z extends com.bytedance.adsdk.ugeno.widget.g.z {
    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.g.z
    public String kb(String str) {
        str.hashCode();
        switch (str) {
            case "unmuted":
                return "tt_ugen_unmuted";
            case "back":
                return "tt_ugen_back";
            case "logo":
                return "tt_ugen_logo";
            case "close":
                return "tt_ugen_close";
            case "muted":
                return "tt_ugen_muted";
            default:
                return "";
        }
    }
}
