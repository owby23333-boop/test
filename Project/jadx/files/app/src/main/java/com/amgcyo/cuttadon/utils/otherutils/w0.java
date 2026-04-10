package com.amgcyo.cuttadon.utils.otherutils;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: UtilitySecurityListener.java */
/* JADX INFO: loaded from: classes.dex */
public class w0 {
    public static void a(@Nullable View.OnClickListener onClickListener, View... viewArr) {
        if (viewArr == null || onClickListener == null) {
            return;
        }
        try {
            for (View view : viewArr) {
                view.setOnClickListener(onClickListener);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
