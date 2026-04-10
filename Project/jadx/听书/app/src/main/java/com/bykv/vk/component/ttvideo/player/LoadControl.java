package com.bykv.vk.component.ttvideo.player;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LoadControl extends NativeObject {
    protected abstract int onCodecStackSelected(int i);

    protected abstract int onFilterStackSelected(int i);

    protected abstract int onTrackSelected(int i);

    protected abstract boolean shouldStartPlayback(long j, float f, boolean z);
}
