package com.dangdang.reader.dread.data;

import com.dangdang.reader.dread.jni.BaseJniWarp;
import com.dangdang.reader.format.Chapter;

/* JADX INFO: loaded from: classes10.dex */
public class OneSearch {
    private Chapter chapter;
    private String content;
    private BaseJniWarp.ElementIndex keywordEndIndex;
    private int keywordIndexInContent;
    private BaseJniWarp.ElementIndex keywordStartIndex;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OneSearch)) {
            return false;
        }
        OneSearch oneSearch = (OneSearch) obj;
        return oneSearch.getChapter().equals(getChapter()) && oneSearch.getKeywordStartIndex().equals(getKeywordStartIndex()) && oneSearch.getKeywordEndIndex().equals(getKeywordEndIndex());
    }

    public Chapter getChapter() {
        return this.chapter;
    }

    public String getContent() {
        return this.content;
    }

    public BaseJniWarp.ElementIndex getKeywordEndIndex() {
        return this.keywordEndIndex;
    }

    public int getKeywordIndexInContent() {
        return this.keywordIndexInContent;
    }

    public BaseJniWarp.ElementIndex getKeywordStartIndex() {
        return this.keywordStartIndex;
    }

    public boolean isInClude(int i, int i2) {
        return this.keywordStartIndex.getIndex() >= i && this.keywordStartIndex.getIndex() <= i2;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setKeywordEndIndex(BaseJniWarp.ElementIndex elementIndex) {
        this.keywordEndIndex = elementIndex;
    }

    public void setKeywordIndexInContent(int i) {
        this.keywordIndexInContent = i;
    }

    public void setKeywordStartIndex(BaseJniWarp.ElementIndex elementIndex) {
        this.keywordStartIndex = elementIndex;
    }
}
