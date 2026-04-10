package com.dangdang.reader.format;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class Chapter implements Serializable, Parcelable {
    public static final Parcelable.Creator<Chapter> CREATOR = new Parcelable.Creator<Chapter>() { // from class: com.dangdang.reader.format.Chapter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Chapter createFromParcel(Parcel parcel) {
            return new Chapter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Chapter[] newArray(int i) {
            return new Chapter[i];
        }
    };
    private static final long serialVersionUID = 1;
    protected int endIndexInBook;
    protected int endPageNum;
    protected int indexInBook;
    protected String path;
    protected int startIndexInBook;
    protected int startPageNum;

    public Chapter() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEndIndexInBook() {
        return this.endIndexInBook;
    }

    public int getEndPageNum() {
        return this.endPageNum;
    }

    public int getIndexInBook() {
        return this.indexInBook;
    }

    public int getPageTotal() {
        return this.endPageNum;
    }

    public String getPath() {
        return this.path;
    }

    public int getStartIndexInBook() {
        return this.startIndexInBook;
    }

    public int getStartPageNum() {
        return this.startPageNum;
    }

    public String getTagPath() {
        return this.path;
    }

    public void reSet() {
        this.startPageNum = 0;
        this.endPageNum = 0;
    }

    public void setEndIndexInBook(int i) {
        this.endIndexInBook = i;
    }

    public void setEndPageNum(int i) {
        this.endPageNum = i;
    }

    public void setIndexInBook(int i) {
        this.indexInBook = i;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setStartIndexInBook(int i) {
        this.startIndexInBook = i;
    }

    public void setStartPageNum(int i) {
        this.startPageNum = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.startPageNum);
        parcel.writeInt(this.endPageNum);
        parcel.writeInt(this.startIndexInBook);
        parcel.writeInt(this.endIndexInBook);
        parcel.writeInt(this.indexInBook);
        parcel.writeString(this.path);
    }

    public Chapter(String str) {
        this.path = str;
    }

    public Chapter(Parcel parcel) {
        this.startPageNum = parcel.readInt();
        this.endPageNum = parcel.readInt();
        this.startIndexInBook = parcel.readInt();
        this.endIndexInBook = parcel.readInt();
        this.indexInBook = parcel.readInt();
        this.path = parcel.readString();
    }
}
