package com.baidu.tts.network;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.CommonUtility;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FileAsyncHttpResponseHandler extends ResponseHandler {
    protected static final int BUFFER_SIZE = 4096;
    private static final String LOG_TAG = "FileAsyncHttpRH";
    protected final boolean append;
    protected final File file;
    protected File frontendFile;
    protected final boolean renameIfExists;

    public FileAsyncHttpResponseHandler(File file) {
        this(file, false);
    }

    public boolean deleteTargetFile() {
        return getTargetFile() != null && getTargetFile().delete();
    }

    protected File getOriginalFile() {
        CommonUtility.asserts(this.file != null, "Target file is null, fatal!");
        return this.file;
    }

    public File getTargetFile() {
        if (this.frontendFile == null) {
            this.frontendFile = getOriginalFile().isDirectory() ? getTargetFileByParsingURL() : getOriginalFile();
        }
        return this.frontendFile;
    }

    protected File getTargetFileByParsingURL() {
        String str;
        CommonUtility.asserts(getOriginalFile().isDirectory(), "Target file is not a directory, cannot proceed");
        CommonUtility.asserts(getRequestURI() != null, "RequestURI is null, cannot proceed");
        String string = getRequestURI().toString();
        String strSubstring = string.substring(string.lastIndexOf(47) + 1, string.length());
        File file = new File(getOriginalFile(), strSubstring);
        if (!file.exists() || !this.renameIfExists) {
            return file;
        }
        if (strSubstring.contains(".")) {
            str = strSubstring.substring(0, strSubstring.lastIndexOf(46)) + " (%d)" + strSubstring.substring(strSubstring.lastIndexOf(46), strSubstring.length());
        } else {
            str = strSubstring + " (%d)";
        }
        int i2 = 0;
        while (true) {
            File file2 = new File(getOriginalFile(), String.format(str, Integer.valueOf(i2)));
            if (!file2.exists()) {
                return file2;
            }
            i2++;
        }
    }

    protected File getTemporaryFile(Context context) {
        CommonUtility.asserts(context != null, "Tried creating temporary file without having Context");
        try {
            return File.createTempFile("temp_", "_handled", context.getCacheDir());
        } catch (IOException unused) {
            LoggerProxy.e(LOG_TAG, "Cannot create temporary file");
            return null;
        }
    }

    @Override // com.baidu.tts.network.ResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
        onFailure(i2, map, th, getTargetFile());
    }

    public abstract void onFailure(int i2, Map<String, List<String>> map, Throwable th, File file);

    public void onProgress(long j2, long j3) {
    }

    public abstract void onSuccess(int i2, Map<String, List<String>> map, File file);

    @Override // com.baidu.tts.network.ResponseHandler
    public void onSuccess(int i2, Map<String, List<String>> map, String str, byte[] bArr) {
        onSuccess(i2, map, getTargetFile());
    }

    public FileAsyncHttpResponseHandler(File file, boolean z2) {
        this(file, z2, false);
    }

    public FileAsyncHttpResponseHandler(File file, boolean z2, boolean z3) {
        CommonUtility.asserts(file != null, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        if (!file.isDirectory() && !file.getParentFile().isDirectory()) {
            CommonUtility.asserts(file.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
        }
        if (file.isDirectory() && !file.mkdirs()) {
            LoggerProxy.d(LOG_TAG, "Cannot create directories for requested Directory location, might not be a problem");
        }
        this.file = file;
        this.append = z2;
        this.renameIfExists = z3;
    }

    public FileAsyncHttpResponseHandler(Context context) {
        this.file = getTemporaryFile(context);
        this.append = false;
        this.renameIfExists = false;
    }
}
