package com.yuewen;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public abstract class vb2 implements View.OnClickListener {
    public static final int LAZY_CLICK_INTERVAL = 500;
    private static long lastClickTime;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = lastClickTime;
        if (jCurrentTimeMillis < j || jCurrentTimeMillis - j > 500) {
            lastClickTime = jCurrentTimeMillis;
            onLazyClick(view);
        }
    }

    public abstract void onLazyClick(View view);
}
