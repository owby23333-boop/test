package com.mibi.sdk.component;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes13.dex */
public class OrderBean implements Parcelable {
    public static final Parcelable.Creator<OrderBean> CREATOR = new Parcelable.Creator<OrderBean>() { // from class: com.mibi.sdk.component.OrderBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderBean createFromParcel(Parcel parcel) {
            OrderBean orderBean = new OrderBean();
            orderBean.mOrder = parcel.readString();
            orderBean.mOrderType = parcel.readInt();
            orderBean.mIsNoAccount = parcel.readByte() != 0;
            orderBean.mUseBalance = parcel.readByte() != 0;
            orderBean.mUseGiftcard = parcel.readByte() != 0;
            orderBean.mUseParterGiftcard = parcel.readByte() != 0;
            orderBean.mUseUi = parcel.readByte() != 0;
            orderBean.mUseMipayH5 = parcel.readByte() != 0;
            orderBean.mIsUmsPayDisabled = parcel.readByte() != 0;
            orderBean.mDiscountGiftCardId = parcel.readLong();
            orderBean.mRechargeFee = parcel.readLong();
            orderBean.mChannel = parcel.readString();
            orderBean.mQueryIntervalConfig = parcel.readString();
            orderBean.mPartnerUserId = parcel.readString();
            orderBean.mPartnerAccountType = parcel.readString();
            orderBean.mPartnerMarketType = parcel.readLong();
            return orderBean;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderBean[] newArray(int i) {
            return new OrderBean[i];
        }
    };
    public static final int ORDER_TYPE_DEDUCT = 2;
    public static final int ORDER_TYPE_PAY = 1;
    public static final int ORDER_TYPE_SIGN_DEDUCT = 3;
    public String mChannel;
    public long mDiscountGiftCardId;
    public boolean mIsNoAccount;
    public boolean mIsUmsPayDisabled;
    public String mOrder;
    public int mOrderType;
    public String mPartnerAccountType;
    public long mPartnerMarketType;
    public String mPartnerUserId;
    public String mQueryIntervalConfig;
    public long mRechargeFee;
    public boolean mUseBalance;
    public boolean mUseGiftcard;
    public boolean mUseMipayH5;
    public boolean mUseParterGiftcard;
    public boolean mUseUi;

    public static class OrderBeanBuilder {
        private OrderBean mOrderBean = new OrderBean();

        public OrderBean build() {
            return this.mOrderBean;
        }

        public OrderBeanBuilder disableUmsPay(boolean z) {
            this.mOrderBean.mIsUmsPayDisabled = z;
            return this;
        }

        public OrderBeanBuilder setChannel(String str) {
            this.mOrderBean.mChannel = str;
            return this;
        }

        public OrderBeanBuilder setDiscountGiftcardId(long j) {
            this.mOrderBean.mDiscountGiftCardId = j;
            return this;
        }

        public OrderBeanBuilder setNoAccount(boolean z) {
            this.mOrderBean.mIsNoAccount = z;
            return this;
        }

        public OrderBeanBuilder setOrder(String str) {
            this.mOrderBean.mOrder = str;
            return this;
        }

        public OrderBeanBuilder setPartnerAccountType(String str) {
            this.mOrderBean.mPartnerAccountType = str;
            return this;
        }

        public OrderBeanBuilder setPartnerMarketType(long j) {
            this.mOrderBean.mPartnerMarketType = j;
            return this;
        }

        public OrderBeanBuilder setPartnerUserId(String str) {
            this.mOrderBean.mPartnerUserId = str;
            return this;
        }

        public OrderBeanBuilder setQueryIntervalConfig(String str) {
            this.mOrderBean.mQueryIntervalConfig = str;
            return this;
        }

        public OrderBeanBuilder setRechargeFee(long j) {
            this.mOrderBean.mRechargeFee = j;
            return this;
        }

        public OrderBeanBuilder useBalance(boolean z) {
            this.mOrderBean.mUseBalance = z;
            return this;
        }

        public OrderBeanBuilder useGiftcard(boolean z) {
            this.mOrderBean.mUseGiftcard = z;
            return this;
        }

        public OrderBeanBuilder useMipayH5(boolean z) {
            this.mOrderBean.mUseMipayH5 = z;
            return this;
        }

        public OrderBeanBuilder usePartnerGiftcard(boolean z) {
            this.mOrderBean.mUseParterGiftcard = z;
            return this;
        }

        public OrderBeanBuilder useUi(boolean z) {
            this.mOrderBean.mUseUi = z;
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mOrder);
        parcel.writeInt(this.mOrderType);
        parcel.writeByte(this.mIsNoAccount ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mUseBalance ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mUseGiftcard ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mUseParterGiftcard ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mUseUi ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mUseMipayH5 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsUmsPayDisabled ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.mDiscountGiftCardId);
        parcel.writeLong(this.mRechargeFee);
        parcel.writeString(this.mChannel);
        parcel.writeString(this.mQueryIntervalConfig);
        parcel.writeString(this.mPartnerUserId);
        parcel.writeString(this.mPartnerAccountType);
        parcel.writeLong(this.mPartnerMarketType);
    }

    private OrderBean() {
    }
}
