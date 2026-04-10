package com.duokan.reader.domain.store;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreOrderInfo implements Serializable {
    public String mOrderUuid = null;
    public DkStoreOrderStatus mOrderStatus = DkStoreOrderStatus.UNKOWN;
    public int mPrice = 0;
    public DkStoreBookPrice[] mTransBooks = new DkStoreBookPrice[0];
    public String mPaymentId = "";
    public String mPaymentEnvelop = "";
    public String mPaymentSenderSign = "";
    public String mPaymentMothodName = "";
    public String mBookUuid = null;
    public String[] mDiscountName = new String[0];
    public float[] mDiscountValue = new float[0];
    public String[] mPaidBookUuids = new String[0];
    public String[] mIllegalBookUuids = new String[0];
    public String[] mFreeBookUuids = new String[0];
    public OrderType mOrderType = OrderType.NORMAL;

    public enum OrderType implements Serializable {
        GIFT,
        REDEEM,
        NORMAL
    }
}
