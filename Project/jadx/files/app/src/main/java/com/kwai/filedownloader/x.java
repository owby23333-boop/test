package com.kwai.filedownloader;

import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.s;

/* JADX INFO: loaded from: classes3.dex */
public interface x extends s.a {

    public interface a {
        t GC();

        boolean a(MessageSnapshot messageSnapshot);

        boolean b(MessageSnapshot messageSnapshot);

        boolean c(MessageSnapshot messageSnapshot);

        boolean d(MessageSnapshot messageSnapshot);

        MessageSnapshot l(Throwable th);
    }

    public interface b {
        void start();
    }

    void GD();

    long GE();

    byte Ge();

    Throwable Gg();

    int Gi();

    boolean Gk();

    void free();

    long getStatusUpdateTime();

    long getTotalBytes();

    boolean pause();

    void reset();
}
