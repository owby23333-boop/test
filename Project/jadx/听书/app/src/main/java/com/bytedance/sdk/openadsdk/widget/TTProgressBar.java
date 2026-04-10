package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.bytedance.sdk.component.utils.wp;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class TTProgressBar extends ProgressBar {
    public TTProgressBar(Context context) {
        super(context);
    }

    public TTProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            try {
                super.onRestoreInstanceState(parcelable);
            } catch (Exception unused) {
                Field field = getClass().getField("mPrivateFlags");
                field.setAccessible(true);
                field.set(this, Integer.valueOf(((Integer) field.get(this)).intValue() | 131072));
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }
}
