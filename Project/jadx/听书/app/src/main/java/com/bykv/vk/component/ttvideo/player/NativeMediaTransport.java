package com.bykv.vk.component.ttvideo.player;

import android.util.AndroidRuntimeException;
import com.bykv.vk.component.ttvideo.player.MediaTransport;

/* JADX INFO: loaded from: classes2.dex */
public class NativeMediaTransport extends MediaTransport {
    @Override // com.bykv.vk.component.ttvideo.player.MediaTransport
    protected void sendPacket(MediaTransport.MediaPacket mediaPacket) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeMediaTransport(MediaTransport mediaTransport) {
        return mediaTransport instanceof NativeMediaTransport;
    }
}
