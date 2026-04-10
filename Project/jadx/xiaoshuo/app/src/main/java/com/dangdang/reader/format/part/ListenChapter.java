package com.dangdang.reader.format.part;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.dangdang.reader.format.Chapter;
import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public class ListenChapter extends Chapter {
    public static final int CHAPTER_FREE_NO = 0;
    public static final int CHAPTER_FREE_YES = 1;
    public static final Parcelable.Creator<ListenChapter> CREATOR = new Parcelable.Creator<ListenChapter>() { // from class: com.dangdang.reader.format.part.ListenChapter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ListenChapter createFromParcel(Parcel parcel) {
            return new ListenChapter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ListenChapter[] newArray(int i) {
            return new ListenChapter[i];
        }
    };
    private static final long serialVersionUID = 1;
    protected int code;
    protected int downloadState;
    protected long duration;
    protected long fileSize;
    public int id;
    protected int index;
    protected int isFree;
    public boolean mIsDownloaded;
    protected String mp3Url;
    protected int myDownloadState;
    protected int needBuy;
    protected int pageCount;
    protected PartBuyInfo partBuyInfo;
    protected double resourceSize;
    protected int showIndex;
    protected String title;
    protected int wordCnt;
    protected int wordCntTotal;

    public ListenChapter() {
        this.needBuy = 1;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ListenChapter) && getId() == ((ListenChapter) obj).getId();
    }

    public int getCode() {
        return this.code;
    }

    public int getDownloadState() {
        return this.downloadState;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getId() {
        return this.id;
    }

    public String getImagePath(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(new File(this.path).getParentFile().getPath());
        String str = File.separator;
        sb.append(str);
        sb.append(this.id);
        sb.append(str);
        String string = sb.toString();
        File file = new File(string);
        if (!file.exists()) {
            file.mkdirs();
        }
        return string + i;
    }

    public int getIndex() {
        return this.index;
    }

    public int getIsFree() {
        return this.isFree;
    }

    public String getMp3Url() {
        return this.mp3Url;
    }

    public int getMyDownloadState() {
        return this.myDownloadState;
    }

    public int getNeedBuy() {
        return this.needBuy;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public PartBuyInfo getPartBuyInfo() {
        return this.partBuyInfo;
    }

    public double getResourceSize() {
        return this.resourceSize;
    }

    public int getShowIndex() {
        return this.showIndex;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWordCnt() {
        return this.wordCnt;
    }

    public int getWordCntTotal() {
        return this.wordCntTotal;
    }

    public int hashCode() {
        return TextUtils.isEmpty(this.path) ? super.hashCode() : this.path.hashCode();
    }

    public boolean isChapterExist() {
        if (new File(getPath().split(":")[0]).exists()) {
            return true;
        }
        for (int i = 1; i <= getWordCnt(); i++) {
            if (!new File(getImagePath(i)).exists()) {
                return false;
            }
        }
        return true;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setDownloadState(int i) {
        this.downloadState = i;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setIsFree(int i) {
        this.isFree = i;
    }

    public void setMp3Url(String str) {
        this.mp3Url = str;
    }

    public void setMyDownloadState(int i) {
        this.myDownloadState = i;
    }

    public void setNeedBuy(int i) {
        this.needBuy = i;
    }

    public void setPageCount(int i) {
        this.pageCount = i;
    }

    public void setPartBuyInfo(PartBuyInfo partBuyInfo) {
        this.partBuyInfo = partBuyInfo;
    }

    public void setResourceSize(double d) {
        this.resourceSize = d;
    }

    public void setShowIndex(int i) {
        this.showIndex = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setWordCnt(int i) {
        this.wordCnt = i;
    }

    public void setWordCntTotal(int i) {
        this.wordCntTotal = i;
    }

    public String toString() {
        return "ListenChapter{id=" + this.id + ", title='" + this.title + "', wordCnt=" + this.wordCnt + ", index=" + this.index + ", isFree=" + this.isFree + ", pageCount=" + this.pageCount + ", partBuyInfo=" + this.partBuyInfo + ", code=" + this.code + '}';
    }

    @Override // com.dangdang.reader.format.Chapter, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.wordCnt);
        parcel.writeInt(this.index);
        parcel.writeInt(this.isFree);
        parcel.writeInt(this.pageCount);
        parcel.writeInt(this.code);
        parcel.writeInt(this.wordCntTotal);
        parcel.writeInt(this.needBuy);
        parcel.writeInt(this.showIndex);
        parcel.writeInt(this.downloadState);
        parcel.writeInt(this.myDownloadState);
        parcel.writeString(this.title);
        parcel.writeString(this.mp3Url);
        parcel.writeLong(this.fileSize);
        parcel.writeLong(this.duration);
        parcel.writeDouble(this.resourceSize);
    }

    public ListenChapter(String str) {
        super(str);
        this.needBuy = 1;
    }

    public ListenChapter(Parcel parcel) {
        this.needBuy = 1;
        this.id = parcel.readInt();
        this.wordCnt = parcel.readInt();
        this.index = parcel.readInt();
        this.isFree = parcel.readInt();
        this.pageCount = parcel.readInt();
        this.code = parcel.readInt();
        this.wordCntTotal = parcel.readInt();
        this.needBuy = parcel.readInt();
        this.showIndex = parcel.readInt();
        this.downloadState = parcel.readInt();
        this.myDownloadState = parcel.readInt();
        this.title = parcel.readString();
        this.mp3Url = parcel.readString();
        this.fileSize = parcel.readLong();
        this.duration = parcel.readLong();
        this.resourceSize = parcel.readDouble();
    }
}
