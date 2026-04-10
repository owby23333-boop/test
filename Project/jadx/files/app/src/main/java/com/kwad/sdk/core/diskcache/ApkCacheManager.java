package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.au;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class ApkCacheManager {
    private Future adO;
    private File adP;
    private final ExecutorService adQ;
    private final Callable<Void> adR;

    enum Holder {
        INSTANCE;

        private ApkCacheManager mInstance = new ApkCacheManager(0);

        Holder() {
        }

        final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    private ApkCacheManager() {
        this.adQ = b.yf();
        this.adR = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: vu, reason: merged with bridge method [inline-methods] */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.adP != null && ApkCacheManager.this.adP.exists() && !ApkCacheManager.this.vs()) {
                        for (File file : ApkCacheManager.this.i(ApkCacheManager.this.adP)) {
                            if (file.getName().endsWith(com.anythink.china.common.a.a.f6395g)) {
                                ApkCacheManager.this.c(file);
                                if (ApkCacheManager.this.vs()) {
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                }
            }
        };
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        try {
            this.adP = au.cR(((e) ServiceProvider.get(e.class)).getContext());
        } catch (Throwable unused) {
        }
    }

    /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (!file.isDirectory()) {
                if (file.exists()) {
                    file.delete();
                    return;
                }
                return;
            }
            for (File file2 : file.listFiles()) {
                c(file2);
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    private int g(File file) {
        return (int) ((h(file) / 1000.0f) / 1000.0f);
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private long h(File file) {
        File[] fileArrListFiles = file.listFiles();
        long jH = 0;
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            for (int i2 = 0; i2 < length; i2++) {
                jH += fileArrListFiles[i2].isDirectory() ? h(fileArrListFiles[i2]) : fileArrListFiles[i2].length();
            }
        }
        return jH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> i(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(fileArrListFiles));
        o(arrayList);
        return arrayList;
    }

    private void o(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vs() {
        File file = this.adP;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] fileArrListFiles = this.adP.listFiles();
        if (fileArrListFiles.length > 5) {
            return fileArrListFiles.length <= 10 && g(this.adP) <= 400;
        }
        return true;
    }

    public final void vt() {
        File file = this.adP;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.adO;
        if (future == null || future.isDone()) {
            this.adO = this.adQ.submit(this.adR);
        }
    }
}
