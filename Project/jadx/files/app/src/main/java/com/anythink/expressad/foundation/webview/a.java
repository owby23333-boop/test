package com.anythink.expressad.foundation.webview;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    public static final int a = 4;
    public static final int b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10754c = 6;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10755d = 7;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10756e = 8;

    /* JADX INFO: renamed from: com.anythink.expressad.foundation.webview.a$a, reason: collision with other inner class name */
    public interface InterfaceC0211a {
        void a();

        void b();
    }

    Drawable getBackground();

    ViewGroup.LayoutParams getLayoutParams();

    float getProgress();

    int getVisibility();

    void initResource(boolean z2);

    void onThemeChange();

    void setBackgroundColor(int i2);

    void setBackgroundDrawable(Drawable drawable);

    void setLayoutParams(ViewGroup.LayoutParams layoutParams);

    void setPaused(boolean z2);

    void setProgress(float f2, boolean z2);

    void setProgressBarListener(InterfaceC0211a interfaceC0211a);

    void setProgressState(int i2);

    void setVisibility(int i2);

    void setVisible(boolean z2);

    void startEndAnimation();
}
