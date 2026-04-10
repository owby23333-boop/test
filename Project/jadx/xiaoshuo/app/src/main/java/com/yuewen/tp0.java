package com.yuewen;

import android.text.TextUtils;
import com.duokan.reader.domain.store.DkStoreBookPrice;
import com.duokan.reader.domain.store.DkStoreOrderInfo;
import com.duokan.reader.domain.store.DkStoreOrderStatus;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class tp0 extends ng2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DkStoreOrderInfo f18041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DkStoreBookPrice[] f18042b;
    public LinkedList<yp0> c;

    public tp0(String str) {
        DkStoreOrderInfo dkStoreOrderInfo = new DkStoreOrderInfo();
        this.f18041a = dkStoreOrderInfo;
        dkStoreOrderInfo.mPaymentMothodName = "dummy";
        dkStoreOrderInfo.mOrderUuid = "";
        dkStoreOrderInfo.mBookUuid = str;
        dkStoreOrderInfo.mOrderStatus = DkStoreOrderStatus.PAID;
        dkStoreOrderInfo.mPrice = 0;
        dkStoreOrderInfo.mPaymentEnvelop = "";
        dkStoreOrderInfo.mPaymentId = "";
        dkStoreOrderInfo.mPaymentSenderSign = "";
        DkStoreBookPrice dkStoreBookPrice = new DkStoreBookPrice();
        dkStoreBookPrice.mNewPrice = 0;
        dkStoreBookPrice.mPrice = 0;
        this.f18042b = new DkStoreBookPrice[]{dkStoreBookPrice};
    }

    @Override // com.yuewen.ng2
    public String a() {
        return this.f18041a.mPaymentEnvelop;
    }

    @Override // com.yuewen.ng2
    public String b() {
        return this.f18041a.mPaymentId;
    }

    @Override // com.yuewen.ng2
    public String c() {
        return this.f18041a.mPaymentMothodName;
    }

    @Override // com.yuewen.ng2
    public String d() {
        return this.f18041a.mPaymentSenderSign;
    }

    public DkStoreBookPrice[] e() {
        return this.f18042b;
    }

    public String f(int i) {
        return this.f18041a.mDiscountName[i];
    }

    public int g() {
        return this.f18041a.mDiscountName.length;
    }

    public float h(int i) {
        return this.f18041a.mDiscountValue[i];
    }

    public String[] i() {
        return this.f18041a.mFreeBookUuids;
    }

    public String[] j() {
        return this.f18041a.mIllegalBookUuids;
    }

    public DkStoreOrderStatus k() {
        return this.f18041a.mOrderStatus;
    }

    public String l() {
        return this.f18041a.mOrderUuid;
    }

    public String[] m() {
        return this.f18041a.mPaidBookUuids;
    }

    public int n() {
        return this.f18041a.mPrice;
    }

    public DkStoreBookPrice[] o() {
        return this.f18041a.mTransBooks;
    }

    public LinkedList<yp0> p() {
        return this.c;
    }

    public DkStoreOrderInfo q() {
        return this.f18041a;
    }

    public int r() {
        int i = 0;
        for (DkStoreBookPrice dkStoreBookPrice : this.f18042b) {
            i += dkStoreBookPrice.mNewPrice;
        }
        return i;
    }

    public boolean s(tp0 tp0Var) {
        if (tp0Var == null) {
            return false;
        }
        DkStoreBookPrice[] dkStoreBookPriceArrO = o();
        DkStoreBookPrice[] dkStoreBookPriceArrO2 = tp0Var.o();
        for (DkStoreBookPrice dkStoreBookPrice : dkStoreBookPriceArrO) {
            for (DkStoreBookPrice dkStoreBookPrice2 : dkStoreBookPriceArrO2) {
                if (dkStoreBookPrice.equals(dkStoreBookPrice2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean t() {
        return TextUtils.isEmpty(this.f18041a.mBookUuid);
    }

    public void u(LinkedList<yp0> linkedList) {
        this.c = linkedList;
    }

    public tp0(DkStoreOrderInfo dkStoreOrderInfo, DkStoreBookPrice... dkStoreBookPriceArr) {
        this.f18041a = dkStoreOrderInfo;
        this.f18042b = dkStoreBookPriceArr;
    }
}
