package com.xuexiang.xupdate.listener.impl;

import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;
import com.xuexiang.xupdate.logs.UpdateLog;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultUpdateFailureListener implements OnUpdateFailureListener {
    @Override // com.xuexiang.xupdate.listener.OnUpdateFailureListener
    public void onFailure(UpdateError updateError) {
        UpdateLog.e(updateError);
    }
}
