package xyz.doikki.videoplayer.player;

import android.content.res.AssetFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractPlayer {
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    protected PlayerEventListener mPlayerEventListener;

    public interface PlayerEventListener {
        void onCompletion();

        void onError();

        void onInfo(int i2, int i3);

        void onPrepared();

        void onVideoSizeChanged(int i2, int i3);
    }

    public abstract int getBufferedPercentage();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract float getSpeed();

    public abstract long getTcpSpeed();

    public abstract void initPlayer();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void prepareAsync();

    public abstract void release();

    public abstract void reset();

    public abstract void seekTo(long j2);

    public abstract void setDataSource(AssetFileDescriptor assetFileDescriptor);

    public abstract void setDataSource(String str, Map<String, String> map);

    public abstract void setDisplay(SurfaceHolder surfaceHolder);

    public abstract void setLooping(boolean z2);

    public abstract void setOptions();

    public void setPlayerEventListener(PlayerEventListener playerEventListener) {
        this.mPlayerEventListener = playerEventListener;
    }

    public abstract void setSpeed(float f2);

    public abstract void setSurface(Surface surface);

    public abstract void setVolume(float f2, float f3);

    public abstract void start();

    public abstract void stop();
}
