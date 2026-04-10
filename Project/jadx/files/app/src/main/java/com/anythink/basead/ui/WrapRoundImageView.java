package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.anythink.core.common.k.u;
import com.anythink.core.common.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes2.dex */
public class WrapRoundImageView extends RoundImageView {
    public WrapRoundImageView(Context context) {
        super(context);
    }

    public int[] setBitmapAndResize(Bitmap bitmap, int i2, int i3) {
        setImageBitmap(bitmap);
        if (i2 > 0 && i3 > 0) {
            try {
                int[] iArrA = u.a(i2, i3, bitmap.getWidth() / bitmap.getHeight());
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iArrA[0];
                    layoutParams.height = iArrA[1];
                    setLayoutParams(layoutParams);
                    return iArrA;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public WrapRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
