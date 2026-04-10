package com.bytedance.adsdk.lottie.z;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.bytedance.adsdk.lottie.gc.gz;

/* JADX INFO: loaded from: classes2.dex */
public class z extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public z() {
    }

    public z(int i) {
        super(i);
    }

    public z(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public z(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            setColor((gz.z(i, 0, 255) << 24) | (getColor() & 16777215));
        } else {
            super.setAlpha(gz.z(i, 0, 255));
        }
    }
}
