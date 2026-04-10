package com.anythink.expressad.video.signal;

/* JADX INFO: loaded from: classes2.dex */
public interface j {
    public static final int m_ = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f12117n = 2;
    public static final int n_ = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f12118o = 1;
    public static final int o_ = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f12119p = 2;
    public static final int p_ = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f12120q = 0;
    public static final int q_ = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f12121r = 1;
    public static final int r_ = 0;
    public static final int s_ = 1;
    public static final int t_ = 1;
    public static final int u_ = 2;
    public static final int v_ = 1;
    public static final int w_ = 2;
    public static final int x_ = -1;
    public static final int y_ = 1;

    void alertWebViewShowed();

    void closeVideoOperate(int i2, int i3);

    void dismissAllAlert();

    int getBorderViewHeight();

    int getBorderViewLeft();

    int getBorderViewRadius();

    int getBorderViewTop();

    int getBorderViewWidth();

    String getCurrentProgress();

    void hideAlertView(int i2);

    boolean isH5Canvas();

    void notifyCloseBtn(int i2);

    void progressBarOperate(int i2);

    void progressOperate(int i2, int i3);

    void setCover(boolean z2);

    void setInstallDialogState(boolean z2);

    void setMiniEndCardState(boolean z2);

    void setScaleFitXY(int i2);

    void setVisible(int i2);

    void showAlertView();

    void showIVRewardAlertView(String str);

    void showVideoLocation(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    void soundOperate(int i2, int i3);

    void soundOperate(int i2, int i3, String str);

    void videoOperate(int i2);
}
