package com.xuexiang.xupdate.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateEntity implements Parcelable {
    public static final Parcelable.Creator<UpdateEntity> CREATOR = new Parcelable.Creator<UpdateEntity>() { // from class: com.xuexiang.xupdate.entity.UpdateEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateEntity createFromParcel(Parcel parcel) {
            return new UpdateEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UpdateEntity[] newArray(int i) {
            return new UpdateEntity[i];
        }
    };
    private DownloadEntity mDownloadEntity;
    private boolean mHasUpdate;
    private IUpdateHttpService mIUpdateHttpService;
    private boolean mIsAutoInstall;
    private boolean mIsForce;
    private boolean mIsIgnorable;
    private boolean mIsSilent;
    private String mUpdateContent;
    private int mVersionCode;
    private String mVersionName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UpdateEntity() {
        this.mVersionName = "unknown_version";
        this.mDownloadEntity = new DownloadEntity();
        this.mIsAutoInstall = true;
    }

    protected UpdateEntity(Parcel parcel) {
        this.mHasUpdate = parcel.readByte() != 0;
        this.mIsForce = parcel.readByte() != 0;
        this.mIsIgnorable = parcel.readByte() != 0;
        this.mVersionCode = parcel.readInt();
        this.mVersionName = parcel.readString();
        this.mUpdateContent = parcel.readString();
        this.mDownloadEntity = (DownloadEntity) parcel.readParcelable(DownloadEntity.class.getClassLoader());
        this.mIsSilent = parcel.readByte() != 0;
        this.mIsAutoInstall = parcel.readByte() != 0;
    }

    public boolean isHasUpdate() {
        return this.mHasUpdate;
    }

    public UpdateEntity setHasUpdate(boolean z) {
        this.mHasUpdate = z;
        return this;
    }

    public boolean isForce() {
        return this.mIsForce;
    }

    public UpdateEntity setForce(boolean z) {
        if (z) {
            this.mIsIgnorable = false;
        }
        this.mIsForce = z;
        return this;
    }

    public boolean isIgnorable() {
        return this.mIsIgnorable;
    }

    public UpdateEntity setIsIgnorable(boolean z) {
        if (z) {
            this.mIsForce = false;
        }
        this.mIsIgnorable = z;
        return this;
    }

    public boolean isSilent() {
        return this.mIsSilent;
    }

    public UpdateEntity setIsSilent(boolean z) {
        this.mIsSilent = z;
        return this;
    }

    public boolean isAutoInstall() {
        return this.mIsAutoInstall;
    }

    public UpdateEntity setIsAutoInstall(boolean z) {
        this.mIsAutoInstall = z;
        return this;
    }

    public UpdateEntity setApkCacheDir(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(this.mDownloadEntity.getCacheDir())) {
            this.mDownloadEntity.setCacheDir(str);
        }
        return this;
    }

    public UpdateEntity setIsAutoMode(boolean z) {
        if (z) {
            this.mIsSilent = true;
            this.mIsAutoInstall = true;
            this.mDownloadEntity.setShowNotification(true);
        }
        return this;
    }

    public UpdateEntity setShowNotification(boolean z) {
        this.mDownloadEntity.setShowNotification(z);
        return this;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public UpdateEntity setVersionCode(int i) {
        this.mVersionCode = i;
        return this;
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public UpdateEntity setVersionName(String str) {
        this.mVersionName = str;
        return this;
    }

    public String getUpdateContent() {
        return this.mUpdateContent;
    }

    public UpdateEntity setUpdateContent(String str) {
        this.mUpdateContent = str;
        return this;
    }

    public String getDownloadUrl() {
        return this.mDownloadEntity.getDownloadUrl();
    }

    public UpdateEntity setDownloadUrl(String str) {
        this.mDownloadEntity.setDownloadUrl(str);
        return this;
    }

    public String getMd5() {
        return this.mDownloadEntity.getMd5();
    }

    public UpdateEntity setMd5(String str) {
        this.mDownloadEntity.setMd5(str);
        return this;
    }

    public long getSize() {
        return this.mDownloadEntity.getSize();
    }

    public UpdateEntity setSize(long j) {
        this.mDownloadEntity.setSize(j);
        return this;
    }

    public String getApkCacheDir() {
        return this.mDownloadEntity.getCacheDir();
    }

    public UpdateEntity setDownLoadEntity(DownloadEntity downloadEntity) {
        this.mDownloadEntity = downloadEntity;
        return this;
    }

    public DownloadEntity getDownLoadEntity() {
        return this.mDownloadEntity;
    }

    public UpdateEntity setIUpdateHttpService(IUpdateHttpService iUpdateHttpService) {
        this.mIUpdateHttpService = iUpdateHttpService;
        return this;
    }

    public IUpdateHttpService getIUpdateHttpService() {
        return this.mIUpdateHttpService;
    }

    public String toString() {
        return "UpdateEntity{mHasUpdate=" + this.mHasUpdate + ", mIsForce=" + this.mIsForce + ", mIsIgnorable=" + this.mIsIgnorable + ", mVersionCode=" + this.mVersionCode + ", mVersionName='" + this.mVersionName + "', mUpdateContent='" + this.mUpdateContent + "', mDownloadEntity=" + this.mDownloadEntity + ", mIsSilent=" + this.mIsSilent + ", mIsAutoInstall=" + this.mIsAutoInstall + ", mIUpdateHttpService=" + this.mIUpdateHttpService + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mHasUpdate ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsForce ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsIgnorable ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mVersionCode);
        parcel.writeString(this.mVersionName);
        parcel.writeString(this.mUpdateContent);
        parcel.writeParcelable(this.mDownloadEntity, i);
        parcel.writeByte(this.mIsSilent ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsAutoInstall ? (byte) 1 : (byte) 0);
    }
}
