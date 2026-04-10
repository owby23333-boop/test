package xyz.doikki.videoplayer.render;

import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import xyz.doikki.videoplayer.player.AbstractPlayer;

/* JADX INFO: loaded from: classes4.dex */
public interface IRenderView {
    void attachToPlayer(@NonNull AbstractPlayer abstractPlayer);

    Bitmap doScreenShot();

    View getView();

    void release();

    void setScaleType(int i2);

    void setVideoRotation(int i2);

    void setVideoSize(int i2, int i3);
}
