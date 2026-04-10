package com.liulishuo.filedownloader.e0;

import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.List;

/* JADX INFO: compiled from: FileDownloadDatabase.java */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.liulishuo.filedownloader.e0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileDownloadDatabase.java */
    public interface InterfaceC0484a extends Iterable<FileDownloadModel> {
        void a(int i2, FileDownloadModel fileDownloadModel);

        void a(FileDownloadModel fileDownloadModel);

        void b(FileDownloadModel fileDownloadModel);

        void f();
    }

    InterfaceC0484a a();

    void a(int i2);

    void a(int i2, int i3);

    void a(int i2, int i3, long j2);

    void a(int i2, long j2);

    void a(int i2, long j2, String str, String str2);

    void a(int i2, String str, long j2, long j3, int i3);

    void a(int i2, Throwable th);

    void a(int i2, Throwable th, long j2);

    void a(com.liulishuo.filedownloader.model.a aVar);

    void b(int i2);

    void b(int i2, long j2);

    List<com.liulishuo.filedownloader.model.a> c(int i2);

    void c(int i2, long j2);

    void clear();

    FileDownloadModel d(int i2);

    void e(int i2);

    void insert(FileDownloadModel fileDownloadModel);

    boolean remove(int i2);

    void update(FileDownloadModel fileDownloadModel);
}
