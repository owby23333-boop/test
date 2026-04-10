package com.yuewen;

import java.io.File;

/* JADX INFO: loaded from: classes12.dex */
public class rh extends qh {
    public File f;

    public rh(File file, String str, String str2) {
        super(str, str2);
        File file2 = new File(file, str2);
        this.f = file2;
        e(file2);
    }
}
