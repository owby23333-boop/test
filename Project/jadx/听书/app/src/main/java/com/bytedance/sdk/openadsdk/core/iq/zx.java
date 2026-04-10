package com.bytedance.sdk.openadsdk.core.iq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class zx {
    private int dl;
    private int g;
    private int z;

    public int z() {
        return this.z;
    }

    public void z(int i) {
        if (i != 1 && i != 2) {
            i = 0;
        }
        this.z = i;
    }

    public int g() {
        return this.g;
    }

    public void g(int i) {
        if (i <= 0 || i >= a()) {
            int i2 = this.z;
            if (i2 == 1) {
                this.g = 90;
                return;
            } else {
                if (i2 == 2) {
                    this.g = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
                    return;
                }
                return;
            }
        }
        this.g = i;
    }

    public int dl() {
        return this.dl;
    }

    public void dl(int i) {
        if (i <= 0 || i >= a()) {
            int i2 = this.z;
            if (i2 == 1) {
                this.dl = 90;
                return;
            } else {
                if (i2 == 2) {
                    this.dl = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
                    return;
                }
                return;
            }
        }
        this.dl = i;
    }

    private int a() {
        return com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), com.bytedance.sdk.openadsdk.core.un.oq.gc(com.bytedance.sdk.openadsdk.core.zw.getContext()));
    }
}
