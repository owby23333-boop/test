package xyz.doikki.videoplayer.player;

import android.content.Context;
import xyz.doikki.videoplayer.player.AbstractPlayer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PlayerFactory<P extends AbstractPlayer> {
    public abstract P createPlayer(Context context);
}
