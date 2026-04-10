package com.dangdang.zframework.network.download;

import com.dangdang.zframework.network.IRequest;
import com.dangdang.zframework.network.RequestConstant;
import com.dangdang.zframework.network.download.DownloadConstant;
import com.dangdang.zframework.network.download.DownloadManagerFactory;
import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public interface IDownload extends IRequest {

    public static abstract class BaseDownload implements IDownload {
        @Override // com.dangdang.zframework.network.download.IDownload
        public boolean addPublicParams() {
            return true;
        }

        @Override // com.dangdang.zframework.network.IRequest
        public RequestConstant.DataType getDataType() {
            return RequestConstant.DataType.BYTE;
        }

        @Override // com.dangdang.zframework.network.download.IDownload
        public String getDownloadUrl() {
            String url = getUrl();
            if (getHttpMode() != RequestConstant.HttpMode.POST) {
                return url;
            }
            return url + getPost();
        }

        @Override // com.dangdang.zframework.network.IRequest
        public RequestConstant.HttpType getHttpType() {
            return RequestConstant.HttpType.HTTP;
        }

        @Override // com.dangdang.zframework.network.IRequest
        public RequestConstant.Priority getPriority() {
            return RequestConstant.Priority.NORMAL;
        }

        @Override // com.dangdang.zframework.network.download.IDownload
        public Object getTag() {
            return null;
        }

        @Override // com.dangdang.zframework.network.download.IDownload
        public DownloadConstant.DownloadType getType() {
            return DownloadConstant.DownloadType.FILE;
        }

        @Override // com.dangdang.zframework.network.IRequest
        public boolean isTrustAllHost() {
            return true;
        }
    }

    public static abstract class GetDownload extends BaseDownload {
        @Override // com.dangdang.zframework.network.IRequest
        public RequestConstant.HttpMode getHttpMode() {
            return RequestConstant.HttpMode.GET;
        }

        @Override // com.dangdang.zframework.network.IRequest
        public String getPost() {
            return "";
        }
    }

    public static abstract class PostDownload extends BaseDownload {
        @Override // com.dangdang.zframework.network.IRequest
        public RequestConstant.HttpMode getHttpMode() {
            return RequestConstant.HttpMode.POST;
        }
    }

    boolean addPublicParams();

    DownloadManagerFactory.DownloadModule getDownloadModule();

    String getDownloadUrl();

    File getLoaclFile();

    long getStartPosition();

    Object getTag();

    long getTotalSize();

    DownloadConstant.DownloadType getType();
}
