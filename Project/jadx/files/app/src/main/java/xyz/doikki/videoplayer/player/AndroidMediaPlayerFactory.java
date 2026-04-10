package xyz.doikki.videoplayer.player;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class AndroidMediaPlayerFactory extends PlayerFactory<AndroidMediaPlayer> {
    public static AndroidMediaPlayerFactory create() {
        return new AndroidMediaPlayerFactory();
    }

    @Override // xyz.doikki.videoplayer.player.PlayerFactory
    public AndroidMediaPlayer createPlayer(Context context) {
        return new AndroidMediaPlayer(context);
    }
}
