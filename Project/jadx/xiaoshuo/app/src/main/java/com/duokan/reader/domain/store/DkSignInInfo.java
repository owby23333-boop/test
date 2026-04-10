package com.duokan.reader.domain.store;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DkSignInInfo implements Serializable {
    public boolean[] mSignStatus = {false, false, false, false, false, false, false};
    public int mToday = 1;
    public List<DkSignInReward> mReward = new ArrayList();
    public boolean mHasPhysical = false;
    public boolean mLottery = false;
}
