package com.dangdang.reader.utils;

import android.text.TextUtils;
import com.dangdang.zframework.log.LogM;
import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public class InbuildBooks {
    public static final int BOOKS_LENGTH = 4;
    public static final String EPUB_BOOK_THIRD_ID_PRE = "epub_third_id_";
    public static final String HELP_ID = "help";
    public static final String PDF_BOOK_ID_PRE = "pdf_id_";
    public static final String[] PRE_IMPORT_BOOKS = {".txt", ".pdf", DangdangFileManager.BOOK_SUFFIX};
    public static final String PUBLIC_KEY_PREFIX = "has_key";
    public static final String TXT_BOOK_ID_PRE = "txt_id_";

    public static String getImportBooksPreIndex(String str) {
        String lowerCase = str.toLowerCase();
        String[] strArr = PRE_IMPORT_BOOKS;
        return lowerCase.endsWith(strArr[0]) ? TXT_BOOK_ID_PRE : lowerCase.endsWith(strArr[1]) ? PDF_BOOK_ID_PRE : EPUB_BOOK_THIRD_ID_PRE;
    }

    public static boolean isDangdangInnerEpubBook(String str) {
        return !new ParserEpubN().readInnerZipFile(str, DangdangFileManager.OLD_ROOT_NAME).equals("");
    }

    public static boolean isImportBook(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(TXT_BOOK_ID_PRE) || str.startsWith(PDF_BOOK_ID_PRE) || str.startsWith(EPUB_BOOK_THIRD_ID_PRE);
    }

    public static boolean isImportBookEndsWith(File file) {
        String name = file.getName();
        String[] strArr = PRE_IMPORT_BOOKS;
        if (name.endsWith(strArr[0]) || name.endsWith(strArr[1])) {
            return true;
        }
        if (name.endsWith(strArr[2])) {
            return !isDangdangInnerEpubBook(file.getAbsolutePath());
        }
        return false;
    }

    public static boolean isInbuildBook(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(PUBLIC_KEY_PREFIX);
    }

    public void printLog(String str) {
        LogM.i(getClass().getSimpleName(), str);
    }
}
