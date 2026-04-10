package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.kwad.framework.filedownloader.a$a, reason: collision with other inner class name */
    public interface InterfaceC0370a {
        boolean br(int i);

        void free();

        boolean isOver();

        a wR();

        x.a wS();

        int wT();

        void wU();

        boolean wV();

        void wW();

        void wX();

        boolean wY();
    }

    public interface b {
        int wZ();
    }

    public interface c {
        void onBegin();

        void xa();
    }

    a a(i iVar);

    a bd(boolean z);

    a be(boolean z);

    a bf(boolean z);

    a bk(String str);

    a bl(String str);

    a bq(int i);

    a c(String str, boolean z);

    boolean cancel();

    a f(Object obj);

    String getFilename();

    int getId();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSpeed();

    long getStatusUpdateTime();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean isRunning();

    boolean pause();

    int start();

    a u(String str, String str2);

    b wA();

    boolean wB();

    boolean wC();

    int wD();

    int wE();

    boolean wF();

    i wG();

    long wH();

    long wI();

    byte wJ();

    boolean wK();

    Throwable wL();

    int wM();

    int wN();

    boolean wO();

    boolean wP();

    boolean wQ();
}
