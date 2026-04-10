package com.bytedance.sdk.component.ga.d.e.e;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class tg {
    static final Charset e = Charset.forName("US-ASCII");
    static final Charset bf = Charset.forName("UTF-8");

    public static void e(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                e(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
