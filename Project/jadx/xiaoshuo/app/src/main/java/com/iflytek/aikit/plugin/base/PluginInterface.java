package com.iflytek.aikit.plugin.base;

/* JADX INFO: loaded from: classes7.dex */
public interface PluginInterface {
    void bindHandleId(int i);

    void onError();

    int pause();

    int release();

    int resume();

    int start();

    int stop();

    void unBindHandleId();
}
