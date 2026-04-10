package com.anythink.core.api;

import com.anythink.core.common.e.a;
import com.anythink.core.common.e.ai;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediationBidManager {
    public static final String NO_BID_TOKEN_ERROR = "NO_BID_TOKEN";
    protected String mRequestUrl;

    public interface BidListener {
        void onBidFail(String str);

        void onBidStart(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter);

        void onBidSuccess(List<ai> list);
    }

    public abstract void notifyWinnerDisplay(String str, ai aiVar);

    public void setBidRequestUrl(String str) {
        this.mRequestUrl = str;
    }

    public abstract void startBid(a aVar, BidListener bidListener);
}
