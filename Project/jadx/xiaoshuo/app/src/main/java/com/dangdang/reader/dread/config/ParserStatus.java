package com.dangdang.reader.dread.config;

/* JADX INFO: loaded from: classes10.dex */
public class ParserStatus {
    public static final int C_DECTYPT_ERROR = -3;
    public static final int C_FILENOEXIST_ERROR = -4;
    public static final int C_HTML_ERROR = -2;
    public static final int C_INIT_FAILED = -6;
    public static final int C_INVALID_FILE = -5;
    public static final int C_SUCCESS = -1;
    public static final int DECRYPT_ERROR = -114;
    public static final int EPUB_ERROR = -112;
    public static final int FILE_DOWNLOAD_ERROR = -116;
    public static final int FILE_ERROR = -111;
    public static final int MISS_CHAPTER_TEXT_COUNT = -115;
    public static final int SUCCESS = 100;
    public static final int TRAINING_OVER = -113;
    public static final int UNZIP_ERROR = -101;

    public static boolean isComposingSuccess(int i) {
        return i == -1 || i == -5;
    }

    public static boolean isSuccess(int i) {
        return i == -1;
    }
}
