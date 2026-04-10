package com.xuexiang.xupdate.proxy.impl;

import android.text.TextUtils;
import com.xuexiang.xupdate.logs.UpdateLog;
import com.xuexiang.xupdate.proxy.IFileEncryptor;
import com.xuexiang.xupdate.utils.Md5Utils;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultFileEncryptor implements IFileEncryptor {
    @Override // com.xuexiang.xupdate.proxy.IFileEncryptor
    public String encryptFile(File file) {
        return Md5Utils.getFileMD5(file);
    }

    @Override // com.xuexiang.xupdate.proxy.IFileEncryptor
    public boolean isFileValid(String str, File file) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String strEncryptFile = encryptFile(file);
        boolean zEqualsIgnoreCase = str.equalsIgnoreCase(strEncryptFile);
        if (!zEqualsIgnoreCase) {
            UpdateLog.d("File verification failed! Target encrypt value is: " + str + ", but file encrypt value is: " + strEncryptFile);
        }
        return zEqualsIgnoreCase;
    }
}
