package xyz.doikki.videoplayer.controller;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes4.dex */
public interface MediaPlayerControl {
    Bitmap doScreenShot();

    int getBufferedPercentage();

    long getCurrentPosition();

    long getDuration();

    float getSpeed();

    long getTcpSpeed();

    int[] getVideoSize();

    boolean isFullScreen();

    boolean isMute();

    boolean isPlaying();

    boolean isTinyScreen();

    void pause();

    void replay(boolean z2);

    void seekTo(long j2);

    void setMirrorRotation(boolean z2);

    void setMute(boolean z2);

    void setRotation(float f2);

    void setScreenScaleType(int i2);

    void setSpeed(float f2);

    void start();

    void startFullScreen();

    void startTinyScreen();

    void stopFullScreen();

    void stopTinyScreen();
}
