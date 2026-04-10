package xyz.doikki.videoplayer.controller;

import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface IControlComponent {
    void attach(@NonNull ControlWrapper controlWrapper);

    @Nullable
    View getView();

    void onLockStateChanged(boolean z2);

    void onPlayStateChanged(int i2);

    void onPlayerStateChanged(int i2);

    void onVisibilityChanged(boolean z2, Animation animation);

    void setProgress(int i2, int i3);
}
