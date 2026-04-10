package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1530a;
    public boolean b;
    public com.efs.sdk.base.core.b.b c;
    public C0233a d;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        this.f1530a = false;
        this.b = true;
        this.c = new com.efs.sdk.base.core.b.b();
        this.d = new C0233a();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1531a = new a(0);
    }

    public final void a() {
        String[] list;
        File fileD = com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!fileD.exists() || !fileD.isDirectory() || (list = fileD.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                File file = new File(fileD, str);
                List<File> listD = com.efs.sdk.base.core.util.b.d(file);
                if (!listD.isEmpty()) {
                    for (File file2 : listD) {
                        if (a(file2.getName())) {
                            c(file2);
                        } else {
                            com.efs.sdk.base.core.d.b bVarB = com.efs.sdk.base.core.util.b.b(file2.getName());
                            if (bVarB == null) {
                                b(file2);
                            } else {
                                e eVarA = this.c.a(bVarB.f1559a.b);
                                if (eVarA == null) {
                                    b(file2);
                                } else {
                                    eVarA.a(file2);
                                }
                            }
                        }
                    }
                }
                com.efs.sdk.base.core.util.b.b(file);
            }
        }
    }

    static boolean a(String str) {
        try {
            long j = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            com.efs.sdk.base.core.a.a.a();
            return Math.abs(com.efs.sdk.base.core.a.a.b() - j) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    public final com.efs.sdk.base.core.d.b a(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            if (a(file.getName())) {
                c(file);
                return null;
            }
            com.efs.sdk.base.core.d.b bVarB = com.efs.sdk.base.core.util.b.b(file.getName());
            if (bVarB == null) {
                b(file);
                return null;
            }
            e eVarA = this.c.a(bVarB.f1559a.b);
            if (eVarA == null) {
                b(file);
                return null;
            }
            if (eVarA.a(file, bVarB)) {
                return bVarB;
            }
            b(file);
            return null;
        } catch (Throwable th) {
            Log.w("efs.cache", th);
            b(file);
            return null;
        }
    }

    static void b(File file) {
        if (!file.getName().startsWith("wa_")) {
            f.a.f1570a.c.e();
        }
        com.efs.sdk.base.core.util.b.b(file);
    }

    static void c(File file) {
        StringBuilder sbAppend = new StringBuilder("file is expire: ").append(file.getName()).append(", now is ");
        com.efs.sdk.base.core.a.a.a();
        Log.i("efs.cache", sbAppend.append(com.efs.sdk.base.core.a.a.b()).toString());
        if (!file.getName().startsWith("wa_")) {
            f.a.f1570a.c.d();
        }
        com.efs.sdk.base.core.util.b.b(file);
    }

    /* JADX INFO: renamed from: com.efs.sdk.base.core.b.a$a, reason: collision with other inner class name */
    public static class C0233a implements Comparator<File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            long jLastModified = file.lastModified() - file2.lastModified();
            if (jLastModified > 0) {
                return 1;
            }
            return jLastModified == 0 ? 0 : -1;
        }
    }
}
