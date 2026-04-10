package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.message.MessageSnapshot;

/* JADX INFO: compiled from: ITaskHunter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface x extends r {

    /* JADX INFO: compiled from: ITaskHunter.java */
    public interface a {
        MessageSnapshot a(Throwable th);

        boolean a(MessageSnapshot messageSnapshot);

        boolean b(MessageSnapshot messageSnapshot);

        boolean c(MessageSnapshot messageSnapshot);

        boolean d(MessageSnapshot messageSnapshot);

        t g();
    }

    /* JADX INFO: compiled from: ITaskHunter.java */
    public interface b {
        void start();
    }

    int a();

    Throwable b();

    byte c();

    long d();

    void e();

    void free();

    long getTotalBytes();
}
