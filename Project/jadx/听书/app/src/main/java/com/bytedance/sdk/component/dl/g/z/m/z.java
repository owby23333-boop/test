package com.bytedance.sdk.component.dl.g.z.m;

import com.bytedance.sdk.component.dl.z.fv;
import com.bytedance.sdk.component.dl.z.js;
import com.bytedance.sdk.component.dl.z.wp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface z {
    public static final z z = new z() { // from class: com.bytedance.sdk.component.dl.g.z.m.z.1
        @Override // com.bytedance.sdk.component.dl.g.z.m.z
        public js z(File file) throws FileNotFoundException {
            return wp.z(file);
        }

        @Override // com.bytedance.sdk.component.dl.g.z.m.z
        public fv g(File file) throws FileNotFoundException {
            try {
                return wp.g(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return wp.g(file);
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.m.z
        public fv dl(File file) throws FileNotFoundException {
            try {
                return wp.dl(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return wp.dl(file);
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.m.z
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.m.z
        public boolean a(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.component.dl.g.z.m.z
        public long gc(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.component.dl.g.z.m.z
        public void z(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // com.bytedance.sdk.component.dl.g.z.m.z
        public void m(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    m(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }
    };

    boolean a(File file);

    void delete(File file) throws IOException;

    fv dl(File file) throws FileNotFoundException;

    fv g(File file) throws FileNotFoundException;

    long gc(File file);

    void m(File file) throws IOException;

    js z(File file) throws FileNotFoundException;

    void z(File file, File file2) throws IOException;
}
