package com.kwai.filedownloader.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwai.filedownloader.exception.PathConflictException;
import com.kwai.filedownloader.y;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @SuppressLint({"StaticFieldLeak"})
    private static Context aHS;

    public interface a {
        int ak(long j2);
    }

    public interface b {
        com.kwai.filedownloader.kwai.b q(String str);
    }

    /* JADX INFO: renamed from: com.kwai.filedownloader.e.c$c, reason: collision with other inner class name */
    public interface InterfaceC0467c {
        com.kwai.filedownloader.a.a IO();
    }

    public interface d {
        int j(String str, String str2, boolean z2);

        int k(String str, String str2, boolean z2);
    }

    public interface e {
        com.kwai.filedownloader.d.a ac(File file);
    }

    public static Context IN() {
        return aHS;
    }

    public static boolean a(int i2, long j2, String str, String str2, y yVar) {
        int iQ;
        if (str2 == null || str == null || (iQ = yVar.q(str, i2)) == 0) {
            return false;
        }
        com.kwai.filedownloader.message.e.Ij().s(com.kwai.filedownloader.message.f.a(i2, j2, new PathConflictException(iQ, str, str2)));
        return true;
    }

    public static boolean a(int i2, com.kwai.filedownloader.c.c cVar, y yVar, boolean z2) {
        if (!yVar.a(cVar)) {
            return false;
        }
        com.kwai.filedownloader.message.e.Ij().s(com.kwai.filedownloader.message.f.a(i2, cVar.Ip(), cVar.getTotal(), z2));
        return true;
    }

    public static boolean a(int i2, String str, boolean z2, boolean z3) {
        if (!z2 && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.kwai.filedownloader.message.e.Ij().s(com.kwai.filedownloader.message.f.a(i2, file, z3));
                return true;
            }
        }
        return false;
    }

    public static void dy(Context context) {
        aHS = context;
    }
}
