package com.bytedance.android.live.base.api;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;

/* JADX INFO: loaded from: classes2.dex */
public interface IFeedProvider extends IService {
    IBaseHorizontalLiveListView getFollowListView(Context context, Bundle bundle, ILiveBorderAnimController iLiveBorderAnimController);
}
