package com.bumptech.glide.load.data.o;

import java.io.File;

/* JADX INFO: compiled from: FileService.java */
/* JADX INFO: loaded from: classes2.dex */
class a {
    a() {
    }

    public boolean a(File file) {
        return file.exists();
    }

    public long b(File file) {
        return file.length();
    }

    public File a(String str) {
        return new File(str);
    }
}
