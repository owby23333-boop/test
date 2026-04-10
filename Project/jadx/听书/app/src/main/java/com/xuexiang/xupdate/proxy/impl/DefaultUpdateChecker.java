package com.xuexiang.xupdate.proxy.impl;

import android.text.TextUtils;
import com.xuexiang.xupdate._XUpdate;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.listener.IUpdateParseCallback;
import com.xuexiang.xupdate.proxy.IUpdateChecker;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;
import com.xuexiang.xupdate.proxy.IUpdateProxy;
import com.xuexiang.xupdate.utils.UpdateUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultUpdateChecker implements IUpdateChecker {
    @Override // com.xuexiang.xupdate.proxy.IUpdateChecker
    public void onAfterCheck() {
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateChecker
    public void onBeforeCheck() {
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateChecker
    public void checkVersion(boolean z, final String str, Map<String, Object> map, final IUpdateProxy iUpdateProxy) {
        if (_XUpdate.isAppUpdating(str)) {
            iUpdateProxy.onAfterCheck();
            _XUpdate.onUpdateError(2003);
            return;
        }
        _XUpdate.setCheckUrlStatus(str, true);
        if (z) {
            iUpdateProxy.getIUpdateHttpService().asyncGet(str, map, new IUpdateHttpService.Callback() { // from class: com.xuexiang.xupdate.proxy.impl.DefaultUpdateChecker.1
                @Override // com.xuexiang.xupdate.proxy.IUpdateHttpService.Callback
                public void onSuccess(String str2) {
                    DefaultUpdateChecker.this.onCheckSuccess(str, str2, iUpdateProxy);
                }

                @Override // com.xuexiang.xupdate.proxy.IUpdateHttpService.Callback
                public void onError(Throwable th) {
                    DefaultUpdateChecker.this.onCheckError(str, iUpdateProxy, th);
                }
            });
        } else {
            iUpdateProxy.getIUpdateHttpService().asyncPost(str, map, new IUpdateHttpService.Callback() { // from class: com.xuexiang.xupdate.proxy.impl.DefaultUpdateChecker.2
                @Override // com.xuexiang.xupdate.proxy.IUpdateHttpService.Callback
                public void onSuccess(String str2) {
                    DefaultUpdateChecker.this.onCheckSuccess(str, str2, iUpdateProxy);
                }

                @Override // com.xuexiang.xupdate.proxy.IUpdateHttpService.Callback
                public void onError(Throwable th) {
                    DefaultUpdateChecker.this.onCheckError(str, iUpdateProxy, th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCheckSuccess(String str, String str2, IUpdateProxy iUpdateProxy) {
        _XUpdate.setCheckUrlStatus(str, false);
        iUpdateProxy.onAfterCheck();
        if (!TextUtils.isEmpty(str2)) {
            processCheckResult(str2, iUpdateProxy);
        } else {
            _XUpdate.onUpdateError(2005);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCheckError(String str, IUpdateProxy iUpdateProxy, Throwable th) {
        _XUpdate.setCheckUrlStatus(str, false);
        iUpdateProxy.onAfterCheck();
        _XUpdate.onUpdateError(2000, th.getMessage());
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateChecker
    public void processCheckResult(final String str, final IUpdateProxy iUpdateProxy) {
        try {
            if (iUpdateProxy.isAsyncParser()) {
                iUpdateProxy.parseJson(str, new IUpdateParseCallback() { // from class: com.xuexiang.xupdate.proxy.impl.DefaultUpdateChecker.3
                    @Override // com.xuexiang.xupdate.listener.IUpdateParseCallback
                    public void onParseResult(UpdateEntity updateEntity) {
                        try {
                            UpdateUtils.processUpdateEntity(updateEntity, str, iUpdateProxy);
                        } catch (Exception e) {
                            e.printStackTrace();
                            _XUpdate.onUpdateError(2006, e.getMessage());
                        }
                    }
                });
            } else {
                UpdateUtils.processUpdateEntity(iUpdateProxy.parseJson(str), str, iUpdateProxy);
            }
        } catch (Exception e) {
            e.printStackTrace();
            _XUpdate.onUpdateError(2006, e.getMessage());
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateChecker
    public void noNewVersion(Throwable th) {
        _XUpdate.onUpdateError(2004, th != null ? th.getMessage() : null);
    }
}
