package com.xuexiang.xupdate.proxy;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public interface IFileEncryptor {
    String encryptFile(File file);

    boolean isFileValid(String str, File file);
}
