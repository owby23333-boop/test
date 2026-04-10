package com.bytedance.sdk.component.m.dl.z.z;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
final class a {
    static final Charset z = Charset.forName("US-ASCII");
    static final Charset g = Charset.forName("UTF-8");

    static void z(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                z(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }
}
