package com.getkeepsafe.relinker;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: ReLinker.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: compiled from: ReLinker.java */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, com.getkeepsafe.relinker.c cVar);
    }

    /* JADX INFO: renamed from: com.getkeepsafe.relinker.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReLinker.java */
    public interface InterfaceC0314b {
        String a(String str);

        String[] a();

        String b(String str);

        void c(String str);

        void loadLibrary(String str);
    }

    /* JADX INFO: compiled from: ReLinker.java */
    public interface c {
        void a(Throwable th);

        void success();
    }

    /* JADX INFO: compiled from: ReLinker.java */
    public interface d {
        void log(String str);
    }

    public static com.getkeepsafe.relinker.c a(d dVar) {
        com.getkeepsafe.relinker.c cVar = new com.getkeepsafe.relinker.c();
        cVar.a(dVar);
        return cVar;
    }
}
