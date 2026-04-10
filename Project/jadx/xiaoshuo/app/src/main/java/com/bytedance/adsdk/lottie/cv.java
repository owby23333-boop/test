package com.bytedance.adsdk.lottie;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.bytedance.component.sdk.annotation.ColorInt;

/* JADX INFO: loaded from: classes.dex */
public class cv extends PorterDuffColorFilter {
    public cv(@ColorInt int i) {
        super(i, PorterDuff.Mode.SRC_ATOP);
    }
}
