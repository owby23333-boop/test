package com.sn.android;

/* JADX INFO: renamed from: com.sn.android.do, reason: invalid class name */
/* JADX INFO: compiled from: CrashHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cdo implements com.sntech.net.Cdo {
    public Cdo(Cif cif) {
    }

    @Override // com.sntech.net.Cdo
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public void mo74do(Exception exc) {
        String str = "Report Crash Error: " + exc;
        exc.printStackTrace();
    }

    @Override // com.sntech.net.Cdo
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public void mo75do(String str) {
    }
}
