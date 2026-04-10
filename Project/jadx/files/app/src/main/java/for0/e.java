package for0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import b1.a;
import com.google.gson.Gson;
import com.sntech.x2.Cif;
import com.sntech.x2.basics.installer.beans.InstallStrategy;
import com.sntech.x2.basics.installer.beans.TaskData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Installer.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static e f20798e;
    public final Context a;
    public final Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f20799c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f20800d;

    /* JADX INFO: compiled from: Installer.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = e.this.f20800d;
            if (fVar != null) {
                fVar.mo177do();
            }
            e.this.b.postDelayed(this, 10000L);
        }
    }

    public e() {
        new AtomicInteger(0);
        this.a = Cif.m154do();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        new Thread(new Runnable() { // from class: for0.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f20796s.d();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        TaskData taskData;
        List<String> downloadPaths;
        InstallStrategy installStrategy = null;
        try {
            String strA = f.a.a(z.a.f21747e, null);
            if (strA != null) {
                installStrategy = (InstallStrategy) new Gson().fromJson(strA, InstallStrategy.class);
            }
        } catch (Exception unused) {
        }
        if (installStrategy != null) {
            if (!"INSTALL_AGAIN".equals(installStrategy.getTaskType())) {
                if ("STOP_POLL".equals(installStrategy.getTaskType())) {
                    this.b.removeCallbacks(this.f20799c);
                }
            } else {
                if (installStrategy.getTaskData() == null || (downloadPaths = (taskData = installStrategy.getTaskData()).getDownloadPaths()) == null || downloadPaths.isEmpty()) {
                    return;
                }
                Iterator<String> it = downloadPaths.iterator();
                while (it.hasNext()) {
                    File fileA = a(it.next(), taskData.getPackageName(), installStrategy.getTaskUUID());
                    if (fileA != null) {
                        r.b.a(this.a, fileA);
                        return;
                    }
                }
            }
        }
    }

    public final void a() {
        if (b1.a.f610e == null) {
            synchronized (b1.a.class) {
                if (b1.a.f610e == null) {
                    b1.a.f610e = new b1.a();
                }
            }
        }
        b1.a.f610e.f611c = new a.b() { // from class: for0.b
            @Override // b1.a.b
            public final void a(boolean z2) {
                this.a.a(z2);
            }
        };
    }

    public final void b() {
        this.f20800d = new f() { // from class: for0.a
            @Override // for0.f
            /* JADX INFO: renamed from: do, reason: not valid java name */
            public final void mo177do() {
                this.a.c();
            }
        };
        this.b.post(this.f20799c);
    }

    public final File a(String str, String str2, String str3) {
        PackageInfo packageArchiveInfo;
        if (str != null && !str.isEmpty()) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : fileArrListFiles) {
                        if (file2.exists() && a(file2)) {
                            if (file2.isDirectory()) {
                                File[] fileArrListFiles2 = file2.listFiles();
                                if (fileArrListFiles2 != null && fileArrListFiles2.length > 0) {
                                    for (File file3 : fileArrListFiles2) {
                                        if (file3.exists() && a(file3) && !file3.isDirectory()) {
                                            arrayList.add(file3);
                                        }
                                    }
                                }
                            } else {
                                arrayList.add(file2);
                            }
                        }
                    }
                    Collections.sort(arrayList, new Comparator() { // from class: for0.d
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return e.a((File) obj, (File) obj2);
                        }
                    });
                    if (arrayList.size() == 0) {
                        d0.c.a().a(null, Cfor.NOT_FOUND_APK, str3, null);
                        return null;
                    }
                    File file4 = (File) arrayList.get(0);
                    try {
                        String str4 = (file4.isFile() && (packageArchiveInfo = this.a.getPackageManager().getPackageArchiveInfo(file4.getPath(), 1)) != null) ? packageArchiveInfo.packageName : null;
                        if (str4 != null && str4.equals(str2)) {
                            d0.c.a().a(null, Cfor.SUCCESS, str3, null);
                            return file4;
                        }
                        d0.c.a().a(null, Cfor.NOT_FOUND_APK, str3, null);
                        return null;
                    } catch (Exception unused) {
                        d0.c.a().a(null, Cfor.UNKNOWN, str3, null);
                        return null;
                    }
                }
                d0.c.a().a(null, Cfor.NOT_FOUND_APK, str3, null);
                return null;
            }
            d0.c.a().a(null, Cfor.NOT_FOUND_DIR, str3, null);
            return null;
        }
        d0.c.a().a(null, Cfor.NOT_FOUND_DIR, str3, null);
        return null;
    }

    public static /* synthetic */ int a(File file, File file2) {
        long jLastModified = file.lastModified() - file2.lastModified();
        if (jLastModified < 0) {
            return 1;
        }
        return jLastModified > 0 ? -1 : 0;
    }

    public final boolean a(File file) {
        String name = file.getName();
        try {
            String strSubstring = name.substring(name.lastIndexOf(".") + 1);
            if (strSubstring.isEmpty()) {
                return false;
            }
            return strSubstring.equalsIgnoreCase("apk");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            b();
        } else {
            this.b.removeCallbacks(this.f20799c);
        }
    }
}
