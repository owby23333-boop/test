package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.ksad.download.c;
import com.ksad.download.d;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static void aT(final Context context) {
        g.schedule(new av() { // from class: com.kwad.sdk.core.diskcache.a.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                d dVarO;
                synchronized (a.class) {
                    try {
                        File fileCR = au.cR(context);
                        if (!fileCR.exists()) {
                            return;
                        }
                        for (File file : a.i(fileCR)) {
                            if (file.getName().endsWith(com.anythink.china.common.a.a.f6395g) && com.kwad.sdk.core.a.ud().bf(file.getAbsolutePath()) != null && a.b(context, file) != null && (dVarO = c.M().O()) != null) {
                                dVarO.b(file);
                            }
                        }
                    } catch (Throwable th) {
                        b.printStackTrace(th);
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PackageInfo b(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 65);
                    if (packageManager.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e2) {
                b.printStackTrace(e2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<File> i(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(fileArrListFiles));
        o(arrayList);
        return arrayList;
    }

    private static void o(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
            private static int a(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return a(file, file2);
            }
        });
    }
}
