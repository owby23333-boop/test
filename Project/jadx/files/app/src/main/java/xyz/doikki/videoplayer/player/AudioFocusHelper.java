package xyz.doikki.videoplayer.player;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.anythink.expressad.exoplayer.k.o;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
final class AudioFocusHelper implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager mAudioManager;
    private final WeakReference<BaseVideoView> mWeakVideoView;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mStartRequested = false;
    private boolean mPausedForLoss = false;
    private int mCurrentFocus = 0;

    AudioFocusHelper(@NonNull BaseVideoView baseVideoView) {
        this.mWeakVideoView = new WeakReference<>(baseVideoView);
        this.mAudioManager = (AudioManager) baseVideoView.getContext().getApplicationContext().getSystemService(o.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAudioFocusChange(int i2) {
        BaseVideoView baseVideoView = this.mWeakVideoView.get();
        if (baseVideoView == null) {
            return;
        }
        if (i2 == -3) {
            if (!baseVideoView.isPlaying() || baseVideoView.isMute()) {
                return;
            }
            baseVideoView.setVolume(0.1f, 0.1f);
            return;
        }
        if (i2 == -2 || i2 == -1) {
            if (baseVideoView.isPlaying()) {
                this.mPausedForLoss = true;
                baseVideoView.pause();
                return;
            }
            return;
        }
        if (i2 == 1 || i2 == 2) {
            if (this.mStartRequested || this.mPausedForLoss) {
                baseVideoView.start();
                this.mStartRequested = false;
                this.mPausedForLoss = false;
            }
            if (baseVideoView.isMute()) {
                return;
            }
            baseVideoView.setVolume(1.0f, 1.0f);
        }
    }

    void abandonFocus() {
        AudioManager audioManager = this.mAudioManager;
        if (audioManager == null) {
            return;
        }
        this.mStartRequested = false;
        audioManager.abandonAudioFocus(this);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(final int i2) {
        if (this.mCurrentFocus == i2) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: xyz.doikki.videoplayer.player.AudioFocusHelper.1
            @Override // java.lang.Runnable
            public void run() {
                AudioFocusHelper.this.handleAudioFocusChange(i2);
            }
        });
        this.mCurrentFocus = i2;
    }

    void requestFocus() {
        AudioManager audioManager;
        if (this.mCurrentFocus == 1 || (audioManager = this.mAudioManager) == null) {
            return;
        }
        if (1 == audioManager.requestAudioFocus(this, 3, 1)) {
            this.mCurrentFocus = 1;
        } else {
            this.mStartRequested = true;
        }
    }
}
