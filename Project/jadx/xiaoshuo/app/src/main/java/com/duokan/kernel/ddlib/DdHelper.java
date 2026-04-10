package com.duokan.kernel.ddlib;

import com.dangdang.reader.dread.jni.BaseJniWarp;
import com.dangdang.reader.format.Chapter;

/* JADX INFO: loaded from: classes11.dex */
public abstract class DdHelper {
    public static BaseJniWarp.EPageIndex newPageIndex(Chapter chapter, long j) {
        BaseJniWarp.EPageIndex ePageIndex = new BaseJniWarp.EPageIndex();
        ePageIndex.filePath = chapter.getPath();
        ePageIndex.pageIndexInChapter = (int) j;
        return ePageIndex;
    }
}
