package com.mibi.sdk.component.recharge;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class RechargeType implements Serializable {
    public String mType = null;
    public String mTitle = null;
    public String mTitleHint = null;
    public String mIcon = "";
    public int mLocalIconRes = -1;
    public boolean mFavorite = false;
    public String mCurrencyUnit = null;
    public ArrayList<RechargeMethod> mRechargeMethods = new ArrayList<>();
}
