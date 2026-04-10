package com.amgcyo.cuttadon.view.read.page;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: PageViewUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    public static void a(View view) {
        if (view == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                return;
            }
            viewGroup.removeView(view);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
