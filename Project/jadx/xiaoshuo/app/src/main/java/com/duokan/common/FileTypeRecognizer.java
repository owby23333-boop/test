package com.duokan.common;

import com.yuewen.q41;

/* JADX INFO: loaded from: classes12.dex */
public class FileTypeRecognizer {

    public enum FileType {
        UNSUPPORTED,
        TXT,
        EPUB,
        PDF
    }

    public static FileType a(String str) {
        String strR = q41.r(str);
        return strR == null ? FileType.UNSUPPORTED : strR.equalsIgnoreCase("epub") ? FileType.EPUB : strR.equalsIgnoreCase("txt") ? FileType.TXT : (b() && strR.equalsIgnoreCase("pdf")) ? FileType.PDF : FileType.UNSUPPORTED;
    }

    public static boolean b() {
        return true;
    }
}
