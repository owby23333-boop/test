package com.anythink.core.api;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.e.l;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ATBiddingResult extends l {
    private ATBiddingResult(boolean z2, double d2, String str, ATBiddingNotice aTBiddingNotice, String str2, ATAdConst.CURRENCY currency) {
        super(z2, d2, str, aTBiddingNotice, str2, currency);
    }

    public static ATBiddingResult fail(String str) {
        return new ATBiddingResult(false, PangleAdapterUtils.CPM_DEFLAUT_VALUE, null, null, str, ATAdConst.CURRENCY.USD);
    }

    public static ATBiddingResult success(double d2, String str, ATBiddingNotice aTBiddingNotice) {
        return new ATBiddingResult(true, d2, str, aTBiddingNotice, null, ATAdConst.CURRENCY.USD);
    }

    public static ATBiddingResult success(double d2, String str, ATBiddingNotice aTBiddingNotice, ATAdConst.CURRENCY currency) {
        return new ATBiddingResult(true, d2, str, aTBiddingNotice, null, currency);
    }
}
