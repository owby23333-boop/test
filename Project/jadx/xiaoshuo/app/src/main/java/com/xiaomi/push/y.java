package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes8.dex */
class y implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.isDirectory();
    }
}
