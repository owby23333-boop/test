package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.x;

/* JADX INFO: compiled from: BaseDownloadTask.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.liulishuo.filedownloader.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseDownloadTask.java */
    public interface InterfaceC0481a {
        void a(a aVar);
    }

    /* JADX INFO: compiled from: BaseDownloadTask.java */
    public interface b {
        boolean a(int i2);

        int d();

        void free();

        x.a getMessageHandler();

        a getOrigin();

        boolean isOver();

        Object k();

        void n();

        void o();

        void s();

        boolean t();

        boolean v();
    }

    /* JADX INFO: compiled from: BaseDownloadTask.java */
    public interface c {
        int a();
    }

    /* JADX INFO: compiled from: BaseDownloadTask.java */
    public interface d {
        void f();

        void h();

        void onBegin();
    }

    int a();

    a a(i iVar);

    a a(boolean z2);

    a b(String str);

    Throwable b();

    byte c();

    c e();

    boolean f();

    int g();

    String getFilename();

    int getId();

    i getListener();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean h();

    int j();

    int l();

    boolean m();

    long p();

    long r();

    int start();

    boolean u();

    boolean w();
}
