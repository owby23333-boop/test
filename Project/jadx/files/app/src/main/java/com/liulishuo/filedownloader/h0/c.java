package com.liulishuo.filedownloader.h0;

import android.annotation.SuppressLint;
import android.content.Context;
import com.liulishuo.filedownloader.exception.PathConflictException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.y;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: FileDownloadHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context a;

    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface a {
        int a(int i2, String str, String str2, long j2);
    }

    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface b {
        com.liulishuo.filedownloader.d0.b a(String str) throws IOException;
    }

    /* JADX INFO: renamed from: com.liulishuo.filedownloader.h0.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface InterfaceC0490c {
        com.liulishuo.filedownloader.e0.a a();
    }

    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface d {
        int a(int i2, String str, String str2, boolean z2);

        int a(String str, String str2, boolean z2);
    }

    /* JADX INFO: compiled from: FileDownloadHelper.java */
    public interface e {
        com.liulishuo.filedownloader.g0.a a(File file) throws IOException;

        boolean a();
    }

    public static void a(Context context) {
        a = context;
    }

    public static Context a() {
        return a;
    }

    public static boolean a(int i2, String str, boolean z2, boolean z3) {
        if (!z2 && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.liulishuo.filedownloader.message.c.a().a(com.liulishuo.filedownloader.message.d.a(i2, file, z3));
                return true;
            }
        }
        return false;
    }

    public static boolean a(int i2, FileDownloadModel fileDownloadModel, y yVar, boolean z2) {
        if (!yVar.a(fileDownloadModel)) {
            return false;
        }
        com.liulishuo.filedownloader.message.c.a().a(com.liulishuo.filedownloader.message.d.a(i2, fileDownloadModel.g(), fileDownloadModel.o(), z2));
        return true;
    }

    public static boolean a(int i2, long j2, String str, String str2, y yVar) {
        int iA;
        if (str2 == null || str == null || (iA = yVar.a(str, i2)) == 0) {
            return false;
        }
        com.liulishuo.filedownloader.message.c.a().a(com.liulishuo.filedownloader.message.d.a(i2, j2, new PathConflictException(iA, str, str2)));
        return true;
    }
}
