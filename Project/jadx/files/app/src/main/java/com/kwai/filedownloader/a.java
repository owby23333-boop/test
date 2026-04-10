package com.kwai.filedownloader;

import com.kwai.filedownloader.x;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.kwai.filedownloader.a$a, reason: collision with other inner class name */
    public interface InterfaceC0461a {
        a Gm();

        x.a Gn();

        int Go();

        void Gp();

        boolean Gq();

        void Gr();

        void Gs();

        boolean Gt();

        boolean cr(int i2);

        void free();

        boolean isOver();
    }

    public interface b {
        int Gu();
    }

    public interface c {
        void Gv();

        void onBegin();
    }

    b FV();

    boolean FW();

    boolean FX();

    int FY();

    int FZ();

    boolean Ga();

    i Gb();

    long Gc();

    long Gd();

    byte Ge();

    boolean Gf();

    Throwable Gg();

    int Gh();

    int Gi();

    boolean Gj();

    boolean Gk();

    boolean Gl();

    a a(i iVar);

    a ah(String str, String str2);

    a bJ(boolean z2);

    a bK(boolean z2);

    a bL(boolean z2);

    boolean cancel();

    a cq(int i2);

    a eS(String str);

    a eT(String str);

    a f(String str, boolean z2);

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

    a j(Object obj);

    boolean pause();

    int start();
}
