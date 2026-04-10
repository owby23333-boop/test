package com.bytedance.adsdk.lottie.e;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.bytedance.adsdk.lottie.vn.p;

/* JADX INFO: loaded from: classes.dex */
public class e extends Paint {
    public e() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            super.setAlpha(p.e(i, 0, 255));
        } else {
            setColor((p.e(i, 0, 255) << 24) | (getColor() & 16777215));
        }
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public e(int i) {
        super(i);
    }

    public e(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public e(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
