package com.xuexiang.xupdate.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.xuexiang.xupdate._XUpdate;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadEntity implements Parcelable {
    public static final Parcelable.Creator<DownloadEntity> CREATOR = new Parcelable.Creator<DownloadEntity>() { // from class: com.xuexiang.xupdate.entity.DownloadEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadEntity createFromParcel(Parcel parcel) {
            return new DownloadEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadEntity[] newArray(int i) {
            return new DownloadEntity[i];
        }
    };
    private String mCacheDir;
    private String mDownloadUrl;
    private boolean mIsShowNotification;
    private String mMd5;
    private long mSize;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DownloadEntity() {
    }

    protected DownloadEntity(Parcel parcel) {
        this.mDownloadUrl = parcel.readString();
        this.mCacheDir = parcel.readString();
        this.mMd5 = parcel.readString();
        this.mSize = parcel.readLong();
        this.mIsShowNotification = parcel.readByte() != 0;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public DownloadEntity setDownloadUrl(String str) {
        this.mDownloadUrl = str;
        return this;
    }

    public String getCacheDir() {
        return this.mCacheDir;
    }

    public DownloadEntity setCacheDir(String str) {
        this.mCacheDir = str;
        return this;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public DownloadEntity setMd5(String str) {
        this.mMd5 = str;
        return this;
    }

    public long getSize() {
        return this.mSize;
    }

    public DownloadEntity setSize(long j) {
        this.mSize = j;
        return this;
    }

    public boolean isShowNotification() {
        return this.mIsShowNotification;
    }

    public DownloadEntity setShowNotification(boolean z) {
        this.mIsShowNotification = z;
        return this;
    }

    public boolean isApkFileValid(File file) {
        return _XUpdate.isFileValid(this.mMd5, file);
    }

    public String toString() {
        return "DownloadEntity{mDownloadUrl='" + this.mDownloadUrl + "', mCacheDir='" + this.mCacheDir + "', mMd5='" + this.mMd5 + "', mSize=" + this.mSize + ", mIsShowNotification=" + this.mIsShowNotification + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDownloadUrl);
        parcel.writeString(this.mCacheDir);
        parcel.writeString(this.mMd5);
        parcel.writeLong(this.mSize);
        parcel.writeByte(this.mIsShowNotification ? (byte) 1 : (byte) 0);
    }
}
