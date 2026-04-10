package com.bykv.vk.component.ttvideo.playerwrapper;

import android.content.Context;
import android.media.AudioManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerSetting {
    private final Context mContext;
    private float mCurrentPlayerVolume = 1.0f;
    private float mLastVolume;
    private MediaPlayer mPlayer;

    public PlayerSetting(Context context, MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
        this.mContext = context;
    }

    public float getMaxVolume() {
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return (audioManager != null ? audioManager.getStreamMaxVolume(3) : 0) >= 0 ? r0 : 0;
    }

    public float getPlayerVolume() {
        return this.mCurrentPlayerVolume;
    }

    public float getVolume() {
        Context context = this.mContext;
        if (context == null) {
            return 0.0f;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        return (audioManager != null ? audioManager.getStreamVolume(3) : 0) >= 0 ? r0 : 0;
    }

    public boolean isMute() {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isOSPlayer() ? getVolume() < 0.001f : this.mPlayer.isMute();
    }

    public void setMute(boolean z) {
        MediaPlayer mediaPlayer = this.mPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (!mediaPlayer.isOSPlayer()) {
            this.mPlayer.setIsMute(z);
            return;
        }
        float maxVolume = getMaxVolume();
        if (maxVolume > 0.0f) {
            this.mLastVolume = getVolume() / maxVolume;
        }
        if (z) {
            this.mPlayer.setVolume(0.0f, 0.0f);
            return;
        }
        MediaPlayer mediaPlayer2 = this.mPlayer;
        float f = this.mLastVolume;
        mediaPlayer2.setVolume(f, f);
    }

    public void setPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000a A[PHI: r1
  0x000a: PHI (r1v2 float) = (r1v0 float), (r1v1 float) binds: [B:6:0x0008, B:9:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPlayerVolume(float r4) {
        /*
            r3 = this;
            com.bykv.vk.component.ttvideo.player.MediaPlayer r0 = r3.mPlayer
            if (r0 != 0) goto L5
            return
        L5:
            r1 = 0
            int r2 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r2 >= 0) goto Lc
        La:
            r4 = r1
            goto L13
        Lc:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r2 <= 0) goto L13
            goto La
        L13:
            r3.mCurrentPlayerVolume = r4
            r0.setVolume(r4, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.playerwrapper.PlayerSetting.setPlayerVolume(float):void");
    }

    public void setVolume(float f) {
        AudioManager audioManager;
        if (this.mPlayer == null || (audioManager = (AudioManager) this.mContext.getSystemService("audio")) == null) {
            return;
        }
        audioManager.setStreamVolume(3, (int) f, 0);
    }
}
