package com.liulishuo.filedownloader;

import android.content.Context;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.e;

/* JADX INFO: compiled from: FileDownloadServiceProxy.java */
/* JADX INFO: loaded from: classes3.dex */
public class m implements u {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final u f17225s;

    /* JADX INFO: compiled from: FileDownloadServiceProxy.java */
    private static final class b {
        private static final m a = new m();
    }

    public static e.a b() {
        if (c().f17225s instanceof n) {
            return (e.a) c().f17225s;
        }
        return null;
    }

    public static m c() {
        return b.a;
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        return this.f17225s.a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
    }

    @Override // com.liulishuo.filedownloader.u
    public byte getStatus(int i2) {
        return this.f17225s.getStatus(i2);
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean isConnected() {
        return this.f17225s.isConnected();
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean pause(int i2) {
        return this.f17225s.pause(i2);
    }

    @Override // com.liulishuo.filedownloader.u
    public void stopForeground(boolean z2) {
        this.f17225s.stopForeground(z2);
    }

    private m() {
        this.f17225s = com.liulishuo.filedownloader.h0.e.a().f17208d ? new n() : new o();
    }

    @Override // com.liulishuo.filedownloader.u
    public void a(Context context) {
        this.f17225s.a(context);
    }

    @Override // com.liulishuo.filedownloader.u
    public void a(Context context, Runnable runnable) {
        this.f17225s.a(context, runnable);
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean a() {
        return this.f17225s.a();
    }
}
