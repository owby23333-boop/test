package com.dangdang.reader.dread.jni;

import com.dangdang.reader.dread.format.Book;
import com.dangdang.reader.dread.format.epub.EpubBook;
import com.dangdang.reader.dread.format.epub.EpubChapter;
import com.dangdang.reader.format.Chapter;
import com.dangdang.reader.utils.DReaderConstants;
import com.dangdang.zframework.log.LogM;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BookStructHandler {
    private String mVersion;
    private EpubBook.EpubNavPoint oneLevelNPoint;
    private List<Chapter> mChapterList = new ArrayList();
    private List<Book.BaseNavPoint> mNavPointList = new ArrayList();
    private String mModVersion = DReaderConstants.BOOK_MODIFY_VERSION;
    private boolean mIsLandScape = false;

    public List<Chapter> getChapterList() {
        return this.mChapterList;
    }

    public String getModVersion() {
        return this.mModVersion;
    }

    public List<Book.BaseNavPoint> getNavPointList() {
        return this.mNavPointList;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public boolean isLandScape() {
        return this.mIsLandScape;
    }

    public void printLog(String str) {
        LogM.i(getClass().getSimpleName(), str);
    }

    public void setEpubChapter(String str, boolean z) {
        EpubChapter epubChapter = new EpubChapter(str);
        if (this.mChapterList.contains(epubChapter)) {
            return;
        }
        epubChapter.setIndexInBook(this.mChapterList.size());
        this.mChapterList.add(epubChapter);
    }

    public void setEpubModVersion(String str) {
        if (str.isEmpty()) {
            return;
        }
        this.mModVersion = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
    
        r0.chapterIndex = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setEpubNavPoint(java.lang.String r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r1 = this;
            com.dangdang.reader.dread.format.epub.EpubBook$EpubNavPoint r0 = new com.dangdang.reader.dread.format.epub.EpubBook$EpubNavPoint
            r0.<init>()
            r0.setFullSrc(r2)
            r0.setLableText(r4)
            r0.setAnchor(r3)
            r0.setLevel(r5)
            java.lang.String r3 = "/"
            int r3 = r2.lastIndexOf(r3)     // Catch: java.lang.Exception -> L43
            int r3 = r3 + 1
            java.lang.String r2 = r2.substring(r3)     // Catch: java.lang.Exception -> L43
            r0.setShortSrc(r2)     // Catch: java.lang.Exception -> L43
            r2 = 0
        L21:
            java.util.List<com.dangdang.reader.format.Chapter> r3 = r1.mChapterList     // Catch: java.lang.Exception -> L43
            int r3 = r3.size()     // Catch: java.lang.Exception -> L43
            if (r2 >= r3) goto L47
            java.util.List<com.dangdang.reader.format.Chapter> r3 = r1.mChapterList     // Catch: java.lang.Exception -> L43
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Exception -> L43
            com.dangdang.reader.format.Chapter r3 = (com.dangdang.reader.format.Chapter) r3     // Catch: java.lang.Exception -> L43
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Exception -> L43
            java.lang.String r4 = r0.fullSrc     // Catch: java.lang.Exception -> L43
            boolean r3 = android.text.TextUtils.equals(r3, r4)     // Catch: java.lang.Exception -> L43
            if (r3 == 0) goto L40
            r0.chapterIndex = r2     // Catch: java.lang.Exception -> L43
            goto L47
        L40:
            int r2 = r2 + 1
            goto L21
        L43:
            r2 = move-exception
            r2.printStackTrace()
        L47:
            if (r5 != 0) goto L51
            java.util.List<com.dangdang.reader.dread.format.Book$BaseNavPoint> r2 = r1.mNavPointList
            r2.add(r0)
            r1.oneLevelNPoint = r0
            goto L56
        L51:
            com.dangdang.reader.dread.format.epub.EpubBook$EpubNavPoint r2 = r1.oneLevelNPoint
            r2.addSubNavPoint(r0)
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dangdang.reader.dread.jni.BookStructHandler.setEpubNavPoint(java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    public void setEpubVersion(String str) {
        this.mVersion = str;
    }

    public void setLandScape(boolean z) {
        this.mIsLandScape = z;
    }
}
