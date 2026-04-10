package com.xiaomi.push;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes8.dex */
class cb implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return (TextUtils.isEmpty(str) || str.toLowerCase().endsWith(".lock")) ? false : true;
    }
}
