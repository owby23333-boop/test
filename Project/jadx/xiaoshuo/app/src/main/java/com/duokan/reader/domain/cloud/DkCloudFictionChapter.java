package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.store.DkStoreFictionChapterInfo;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudFictionChapter extends DkCloudJsonItem {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DkStoreFictionChapterInfo mChapterInfo;
    private ChapterState mChapterState;
    private final boolean mIsFree;

    public enum ChapterState {
        NORMAL,
        FREE,
        ORDER
    }

    public DkCloudFictionChapter(DkStoreFictionChapterInfo dkStoreFictionChapterInfo, boolean z) {
        super(0L);
        this.mChapterState = ChapterState.NORMAL;
        this.mChapterInfo = dkStoreFictionChapterInfo;
        boolean z2 = z || dkStoreFictionChapterInfo.mPrice == 0;
        this.mIsFree = z2;
        if (z2) {
            this.mChapterState = ChapterState.FREE;
        }
    }

    public int getBasePrice() {
        return this.mChapterInfo.mBasePrice;
    }

    public long getChapterDuration() {
        return this.mChapterInfo.mDuration;
    }

    public long getChapterSize() {
        return this.mChapterInfo.mSize;
    }

    public ChapterState getChapterState() {
        return this.mChapterState;
    }

    public long getChapterUpdateTime() {
        return this.mChapterInfo.mChapterUpdateTime;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return this.mChapterInfo.mChapterId;
    }

    public String getOuterId() {
        return this.mChapterInfo.mOuterId;
    }

    public int getPrice() {
        if (this.mIsFree) {
            return 0;
        }
        return this.mChapterInfo.mPrice;
    }

    public String getSha1() {
        return this.mChapterInfo.mSha1;
    }

    public String getTitle() {
        return this.mChapterInfo.mTitle;
    }

    public Date getUpdateDate() {
        return this.mChapterInfo.mUpdatedDate;
    }

    public String getUrl() {
        return this.mChapterInfo.mUrl;
    }

    public boolean getVisible() {
        return this.mChapterInfo.mVisible;
    }

    public long getWordCount() {
        return this.mChapterInfo.mWordCount;
    }

    public boolean isFree() {
        return this.mIsFree;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }

    public void setChapterState(ChapterState chapterState) {
        this.mChapterState = chapterState;
    }

    public void setTitle(String str) {
        this.mChapterInfo.mTitle = str;
    }
}
