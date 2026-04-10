package com.xiaomi.phonenum.bean;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.xiaomi.phonenum.http.Response;

/* JADX INFO: loaded from: classes8.dex */
public enum HttpError {
    ENCRYPT(460),
    DECRYPT(MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES),
    DATA_NOT_ENABLED(462),
    NO_CHANGE_NETWORK_STATE_PERMISSION(463),
    CELLULAR_NETWORK_NOT_AVAILABLE(464),
    CELLULAR_NETWORK_IO_EXCEPTION(600);

    public final int code;

    HttpError(int i) {
        this.code = i;
    }

    public Response result() {
        return new Response.Builder().code(this.code).body(toString()).build();
    }
}
