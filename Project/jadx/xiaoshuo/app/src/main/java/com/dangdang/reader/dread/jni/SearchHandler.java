package com.dangdang.reader.dread.jni;

import com.dangdang.reader.dread.data.OneSearch;
import com.dangdang.reader.dread.jni.BaseJniWarp;
import com.dangdang.zframework.log.LogM;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class SearchHandler {
    private List<OneSearch> mSearchs = new ArrayList();
    private int mWordLen;

    public SearchHandler(String str) {
        this.mWordLen = str.length();
    }

    public void callBackSeachByEpub(String str, String str2, int i, int i2, int i3) {
        OneSearch oneSearch = new OneSearch();
        oneSearch.setContent(str2);
        oneSearch.setKeywordStartIndex(new BaseJniWarp.ElementIndex(i3));
        oneSearch.setKeywordEndIndex(new BaseJniWarp.ElementIndex((this.mWordLen + i3) - 1));
        oneSearch.setKeywordIndexInContent(i3 - i);
        this.mSearchs.add(oneSearch);
    }

    public void callBackSeachByPdf(int i, String str, int i2, int i3, int i4) {
    }

    public void callBackSeachByTxt(String str, int i, int i2, String str2, int i3, int i4, int i5) {
    }

    public List<OneSearch> getSearchs() {
        return this.mSearchs;
    }

    public void printLog(String str) {
        LogM.i(getClass().getSimpleName(), str);
    }
}
