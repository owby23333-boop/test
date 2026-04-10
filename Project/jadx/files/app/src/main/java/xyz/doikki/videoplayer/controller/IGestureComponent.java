package xyz.doikki.videoplayer.controller;

/* JADX INFO: loaded from: classes4.dex */
public interface IGestureComponent extends IControlComponent {
    void onBrightnessChange(int i2);

    void onPositionChange(int i2, int i3, int i4);

    void onStartSlide();

    void onStopSlide();

    void onVolumeChange(int i2);
}
