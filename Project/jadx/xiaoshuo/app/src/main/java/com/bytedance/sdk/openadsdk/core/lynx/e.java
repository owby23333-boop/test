package com.bytedance.sdk.openadsdk.core.lynx;

import android.graphics.Bitmap;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.image.AbsUIImage;

/* JADX INFO: loaded from: classes10.dex */
public class e extends AbsUIImage {
    private static final Bitmap bf = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    private String e;

    @LynxProp(name = "key")
    public void setKey(String str) {
        this.e = str;
    }
}
