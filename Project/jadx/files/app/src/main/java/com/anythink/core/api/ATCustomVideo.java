package com.anythink.core.api;

/* JADX INFO: loaded from: classes2.dex */
public interface ATCustomVideo {
    String getVideoUrl();

    void reportVideoAutoStart();

    void reportVideoBreak(long j2);

    void reportVideoContinue(long j2);

    void reportVideoError(long j2, int i2, int i3);

    void reportVideoFinish();

    void reportVideoPause(long j2);

    void reportVideoStart();

    void reportVideoStartError(int i2, int i3);
}
