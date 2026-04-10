package com.xuexiang.xupdate.proxy.impl;

import com.xuexiang.xupdate._XUpdate;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IPrompterProxy;
import com.xuexiang.xupdate.proxy.IUpdateProxy;
import com.xuexiang.xupdate.service.OnFileDownloadListener;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultPrompterProxyImpl implements IPrompterProxy {
    private IUpdateProxy mUpdateProxy;

    DefaultPrompterProxyImpl(IUpdateProxy iUpdateProxy) {
        this.mUpdateProxy = iUpdateProxy;
    }

    @Override // com.xuexiang.xupdate.proxy.IPrompterProxy
    public String getUrl() {
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        return iUpdateProxy != null ? iUpdateProxy.getUrl() : "";
    }

    @Override // com.xuexiang.xupdate.proxy.IPrompterProxy
    public void startDownload(UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener) {
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.startDownload(updateEntity, onFileDownloadListener);
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IPrompterProxy
    public void backgroundDownload() {
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.backgroundDownload();
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IPrompterProxy
    public void cancelDownload() {
        _XUpdate.setIsPrompterShow(getUrl(), false);
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.cancelDownload();
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IPrompterProxy
    public void recycle() {
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.recycle();
            this.mUpdateProxy = null;
        }
    }
}
