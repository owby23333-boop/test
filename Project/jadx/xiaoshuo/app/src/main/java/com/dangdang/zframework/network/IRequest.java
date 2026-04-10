package com.dangdang.zframework.network;

import com.dangdang.zframework.network.RequestConstant;

/* JADX INFO: loaded from: classes10.dex */
public interface IRequest {
    RequestConstant.DataType getDataType();

    RequestConstant.HttpMode getHttpMode();

    RequestConstant.HttpType getHttpType();

    String getPost();

    RequestConstant.Priority getPriority();

    String getUrl();

    boolean isTrustAllHost();
}
