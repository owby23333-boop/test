package com.dangdang.zframework.network.command;

import com.dangdang.zframework.network.IRequest;
import com.dangdang.zframework.network.RequestConstant;

/* JADX INFO: loaded from: classes10.dex */
public interface IRequestCommand extends IRequest {
    public static final String ENCODING = "UTF-8";

    RequestConstant.CacheStatus getCacheStatus();

    Object parse(byte[] bArr);
}
