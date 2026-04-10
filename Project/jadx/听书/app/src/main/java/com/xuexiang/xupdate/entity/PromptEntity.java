package com.xuexiang.xupdate.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public class PromptEntity implements Parcelable {
    public static final Parcelable.Creator<PromptEntity> CREATOR = new Parcelable.Creator<PromptEntity>() { // from class: com.xuexiang.xupdate.entity.PromptEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PromptEntity createFromParcel(Parcel parcel) {
            return new PromptEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PromptEntity[] newArray(int i) {
            return new PromptEntity[i];
        }
    };
    private int mButtonTextColor;
    private float mHeightRatio;
    private boolean mIgnoreDownloadError;
    private boolean mSupportBackgroundUpdate;
    private int mThemeColor;
    private String mTopDrawableTag;
    private int mTopResId;
    private float mWidthRatio;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PromptEntity() {
        this.mThemeColor = -1;
        this.mTopResId = -1;
        this.mTopDrawableTag = "";
        this.mButtonTextColor = 0;
        this.mSupportBackgroundUpdate = false;
        this.mWidthRatio = -1.0f;
        this.mHeightRatio = -1.0f;
        this.mIgnoreDownloadError = false;
    }

    protected PromptEntity(Parcel parcel) {
        this.mThemeColor = parcel.readInt();
        this.mTopResId = parcel.readInt();
        this.mTopDrawableTag = parcel.readString();
        this.mButtonTextColor = parcel.readInt();
        this.mSupportBackgroundUpdate = parcel.readByte() != 0;
        this.mWidthRatio = parcel.readFloat();
        this.mHeightRatio = parcel.readFloat();
        this.mIgnoreDownloadError = parcel.readByte() != 0;
    }

    public int getThemeColor() {
        return this.mThemeColor;
    }

    public PromptEntity setThemeColor(int i) {
        this.mThemeColor = i;
        return this;
    }

    public int getTopResId() {
        return this.mTopResId;
    }

    public PromptEntity setTopResId(int i) {
        this.mTopResId = i;
        return this;
    }

    public String getTopDrawableTag() {
        return this.mTopDrawableTag;
    }

    public PromptEntity setTopDrawableTag(String str) {
        this.mTopDrawableTag = str;
        return this;
    }

    public int getButtonTextColor() {
        return this.mButtonTextColor;
    }

    public PromptEntity setButtonTextColor(int i) {
        this.mButtonTextColor = i;
        return this;
    }

    public boolean isSupportBackgroundUpdate() {
        return this.mSupportBackgroundUpdate;
    }

    public PromptEntity setSupportBackgroundUpdate(boolean z) {
        this.mSupportBackgroundUpdate = z;
        return this;
    }

    public PromptEntity setWidthRatio(float f) {
        this.mWidthRatio = f;
        return this;
    }

    public float getWidthRatio() {
        return this.mWidthRatio;
    }

    public PromptEntity setHeightRatio(float f) {
        this.mHeightRatio = f;
        return this;
    }

    public float getHeightRatio() {
        return this.mHeightRatio;
    }

    public PromptEntity setIgnoreDownloadError(boolean z) {
        this.mIgnoreDownloadError = z;
        return this;
    }

    public boolean isIgnoreDownloadError() {
        return this.mIgnoreDownloadError;
    }

    public String toString() {
        return "PromptEntity{mThemeColor=" + this.mThemeColor + ", mTopResId=" + this.mTopResId + ", mTopDrawableTag=" + this.mTopDrawableTag + ", mButtonTextColor=" + this.mButtonTextColor + ", mSupportBackgroundUpdate=" + this.mSupportBackgroundUpdate + ", mWidthRatio=" + this.mWidthRatio + ", mHeightRatio=" + this.mHeightRatio + ", mIgnoreDownloadError=" + this.mIgnoreDownloadError + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mThemeColor);
        parcel.writeInt(this.mTopResId);
        parcel.writeString(this.mTopDrawableTag);
        parcel.writeInt(this.mButtonTextColor);
        parcel.writeByte(this.mSupportBackgroundUpdate ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.mWidthRatio);
        parcel.writeFloat(this.mHeightRatio);
        parcel.writeByte(this.mIgnoreDownloadError ? (byte) 1 : (byte) 0);
    }
}
