package com.mibi.sdk.component;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes13.dex */
public class PartnerInfo implements Parcelable {
    public static final Parcelable.Creator<PartnerInfo> CREATOR = new Parcelable.Creator<PartnerInfo>() { // from class: com.mibi.sdk.component.PartnerInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PartnerInfo createFromParcel(Parcel parcel) {
            return new PartnerInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PartnerInfo[] newArray(int i) {
            return new PartnerInfo[i];
        }
    };
    private String accountType;
    private long marketType;
    private long rechargePrice;
    private String token;
    private String userId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public long getMarketType() {
        return this.marketType;
    }

    public long getRechargePrice() {
        return this.rechargePrice;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setMarketType(long j) {
        this.marketType = j;
    }

    public void setRechargePrice(long j) {
        this.rechargePrice = j;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeString(this.accountType);
        parcel.writeLong(this.marketType);
        parcel.writeLong(this.rechargePrice);
        parcel.writeString(this.token);
    }

    public PartnerInfo() {
    }

    public PartnerInfo(String str) {
        this.userId = str;
    }

    public PartnerInfo(String str, String str2) {
        this.userId = str;
        this.accountType = str2;
    }

    public PartnerInfo(String str, String str2, long j) {
        this.userId = str;
        this.accountType = str2;
        this.marketType = j;
    }

    private PartnerInfo(Parcel parcel) {
        this.userId = parcel.readString();
        this.accountType = parcel.readString();
        this.marketType = parcel.readLong();
        this.rechargePrice = parcel.readLong();
        this.token = parcel.readString();
    }
}
