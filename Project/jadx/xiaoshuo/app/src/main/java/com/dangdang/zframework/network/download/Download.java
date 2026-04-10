package com.dangdang.zframework.network.download;

import com.dangdang.zframework.network.download.DownloadManagerFactory;
import com.dangdang.zframework.network.download.IDownload;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class Download extends IDownload.GetDownload implements Serializable {
    private static final long serialVersionUID = 1;

    @Override // com.dangdang.zframework.network.download.IDownload
    public DownloadManagerFactory.DownloadModule getDownloadModule() {
        return null;
    }

    @Override // com.dangdang.zframework.network.download.IDownload
    public File getLoaclFile() {
        return null;
    }

    @Override // com.dangdang.zframework.network.download.IDownload
    public long getStartPosition() {
        return 0L;
    }

    @Override // com.dangdang.zframework.network.download.IDownload
    public long getTotalSize() {
        return 0L;
    }

    @Override // com.dangdang.zframework.network.IRequest
    public String getUrl() {
        return null;
    }
}
