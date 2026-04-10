package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class GameBean implements Serializable {
    private int game_interval_seconds;
    private int game_switch;

    public int getGame_interval_seconds() {
        return this.game_interval_seconds;
    }

    public int getGame_switch() {
        return this.game_switch;
    }

    public void setGame_interval_seconds(int i2) {
        this.game_interval_seconds = i2;
    }

    public void setGame_switch(int i2) {
        this.game_switch = i2;
    }
}
