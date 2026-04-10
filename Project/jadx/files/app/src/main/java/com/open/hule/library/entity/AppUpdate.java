package com.open.hule.library.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.open.hule.library.R$color;
import com.open.hule.library.R$drawable;
import com.open.hule.library.R$layout;
import com.open.hule.library.R$mipmap;
import com.open.hule.library.R$string;

/* JADX INFO: loaded from: classes3.dex */
public class AppUpdate implements Parcelable {
    public static final Parcelable.Creator<AppUpdate> CREATOR = new Parcelable.Creator<AppUpdate>() { // from class: com.open.hule.library.entity.AppUpdate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppUpdate createFromParcel(Parcel parcel) {
            return new AppUpdate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppUpdate[] newArray(int i2) {
            return new AppUpdate[i2];
        }
    };
    private int btnBgResourceId;
    private String downBrowserUrl;
    private int downloadScheme;
    private String fileSize;
    private int forceUpdate;
    private String newVersionCode;
    private String newVersionUrl;
    private String savePath;
    private TipsBean tipsBean;
    private int top_imgResourceId;
    private int updateCancelColor;
    private int updateCancelText;
    private int updateColor;
    private int updateContentTitle;
    private int updateProgressColor;
    private int updateResourceId;
    private int updateText;
    private int updateTitle;

    public static class Builder {
        private int btnBgResourceId;
        private String fileSize;
        private String newVersionCode;
        private String newVersionUrl;
        private TipsBean tipsBean;
        private int top_imgResourceId;
        private int updateCancelColor;
        private int updateColor;
        private int updateProgressColor;
        private int updateResourceId;
        private int forceUpdate = 0;
        private int downloadScheme = 0;
        private String savePath = "/download/";
        private String downBrowserUrl = "";
        private int updateTitle = R$string.update_title;
        private int updateContentTitle = R$string.update_content_lb;
        private int updateText = R$string.update_text;
        private int updateCancelText = R$string.update_later;

        public Builder() {
            int i2 = R$color.color_blue;
            this.updateColor = i2;
            this.updateCancelColor = i2;
            this.updateProgressColor = i2;
            this.updateResourceId = R$layout.lib_update_dialog_update;
            this.top_imgResourceId = R$mipmap.top_3;
            this.btnBgResourceId = R$drawable.update_round_bg;
        }

        public AppUpdate build() {
            return new AppUpdate(this);
        }

        public Builder downBrowserUrl(String str) {
            this.downBrowserUrl = str;
            return this;
        }

        public Builder downloadScheme(int i2) {
            this.downloadScheme = i2;
            return this;
        }

        public Builder fileSize(String str) {
            this.fileSize = str;
            return this;
        }

        public Builder forceUpdate(int i2) {
            this.forceUpdate = i2;
            return this;
        }

        public Builder newVersionCode(String str) {
            this.newVersionCode = str;
            return this;
        }

        public Builder newVersionUrl(String str) {
            this.newVersionUrl = str;
            return this;
        }

        public Builder savePath(String str) {
            this.savePath = str;
            return this;
        }

        public Builder tipsBean(TipsBean tipsBean) {
            this.tipsBean = tipsBean;
            return this;
        }

        public Builder updateBtnBgResourceId(int i2) {
            this.btnBgResourceId = i2;
            return this;
        }

        public Builder updateCancelColor(int i2) {
            this.updateCancelColor = i2;
            return this;
        }

        public Builder updateColor(int i2) {
            this.updateColor = i2;
            return this;
        }

        public Builder updateContentTitle(int i2) {
            this.updateContentTitle = i2;
            return this;
        }

        public Builder updateLayoutResourceId(int i2) {
            this.updateResourceId = i2;
            return this;
        }

        public Builder updateProgressColor(int i2) {
            this.updateProgressColor = i2;
            return this;
        }

        public Builder updateText(int i2) {
            this.updateText = i2;
            return this;
        }

        public Builder updateTextCancel(int i2) {
            this.updateCancelText = i2;
            return this;
        }

        public Builder updateTitle(int i2) {
            this.updateTitle = i2;
            return this;
        }

        public Builder updateTopImgResourceId(int i2) {
            this.top_imgResourceId = i2;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBtnBgResourceId() {
        return this.btnBgResourceId;
    }

    public String getDownBrowserUrl() {
        return this.downBrowserUrl;
    }

    public int getDownloadScheme() {
        return this.downloadScheme;
    }

    public String getFileSize() {
        return this.fileSize;
    }

    public int getForceUpdate() {
        return this.forceUpdate;
    }

    public String getNewVersionCode() {
        return this.newVersionCode;
    }

    public String getNewVersionUrl() {
        return this.newVersionUrl;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public TipsBean getTipsBean() {
        return this.tipsBean;
    }

    public int getTop_imgResourceId() {
        return this.top_imgResourceId;
    }

    public int getUpdateCancelColor() {
        return this.updateCancelColor;
    }

    public int getUpdateCancelText() {
        return this.updateCancelText;
    }

    public int getUpdateColor() {
        return this.updateColor;
    }

    public int getUpdateContentTitle() {
        return this.updateContentTitle;
    }

    public int getUpdateProgressColor() {
        return this.updateProgressColor;
    }

    public int getUpdateResourceId() {
        return this.updateResourceId;
    }

    public int getUpdateText() {
        return this.updateText;
    }

    public int getUpdateTitle() {
        return this.updateTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.newVersionUrl);
        parcel.writeString(this.newVersionCode);
        parcel.writeInt(this.forceUpdate);
        parcel.writeInt(this.downloadScheme);
        parcel.writeString(this.fileSize);
        parcel.writeString(this.savePath);
        parcel.writeSerializable(this.tipsBean);
        parcel.writeString(this.downBrowserUrl);
        parcel.writeInt(this.updateTitle);
        parcel.writeInt(this.updateContentTitle);
        parcel.writeInt(this.updateText);
        parcel.writeInt(this.updateCancelText);
        parcel.writeInt(this.updateColor);
        parcel.writeInt(this.updateCancelColor);
        parcel.writeInt(this.updateProgressColor);
        parcel.writeInt(this.updateResourceId);
        parcel.writeInt(this.btnBgResourceId);
        parcel.writeInt(this.top_imgResourceId);
    }

    private AppUpdate(Builder builder) {
        this.newVersionUrl = builder.newVersionUrl;
        this.newVersionCode = builder.newVersionCode;
        this.forceUpdate = builder.forceUpdate;
        this.downloadScheme = builder.downloadScheme;
        this.fileSize = builder.fileSize;
        this.savePath = builder.savePath;
        this.tipsBean = builder.tipsBean;
        this.downBrowserUrl = builder.downBrowserUrl;
        this.updateTitle = builder.updateTitle;
        this.updateContentTitle = builder.updateContentTitle;
        this.updateText = builder.updateText;
        this.updateCancelText = builder.updateCancelText;
        this.updateColor = builder.updateColor;
        this.updateCancelColor = builder.updateCancelColor;
        this.updateProgressColor = builder.updateProgressColor;
        this.updateResourceId = builder.updateResourceId;
        this.top_imgResourceId = builder.top_imgResourceId;
        this.btnBgResourceId = builder.btnBgResourceId;
    }

    protected AppUpdate(Parcel parcel) {
        this.newVersionUrl = parcel.readString();
        this.newVersionCode = parcel.readString();
        this.forceUpdate = parcel.readInt();
        this.downloadScheme = parcel.readInt();
        this.fileSize = parcel.readString();
        this.savePath = parcel.readString();
        this.tipsBean = (TipsBean) parcel.readSerializable();
        this.downBrowserUrl = parcel.readString();
        this.updateTitle = parcel.readInt();
        this.updateContentTitle = parcel.readInt();
        this.updateText = parcel.readInt();
        this.updateCancelText = parcel.readInt();
        this.updateColor = parcel.readInt();
        this.updateCancelColor = parcel.readInt();
        this.updateProgressColor = parcel.readInt();
        this.updateResourceId = parcel.readInt();
        this.top_imgResourceId = parcel.readInt();
        this.btnBgResourceId = parcel.readInt();
    }
}
