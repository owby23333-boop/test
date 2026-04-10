package com.dangdang.zframework.network.command;

import com.dangdang.zframework.network.RequestConstant;

/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseRequestCommand implements IRequestCommand {
    @Override // com.dangdang.zframework.network.command.IRequestCommand
    public RequestConstant.CacheStatus getCacheStatus() {
        return RequestConstant.CacheStatus.NO;
    }

    @Override // com.dangdang.zframework.network.IRequest
    public RequestConstant.HttpMode getHttpMode() {
        return RequestConstant.HttpMode.POST;
    }

    @Override // com.dangdang.zframework.network.IRequest
    public RequestConstant.HttpType getHttpType() {
        return RequestConstant.HttpType.HTTP;
    }

    @Override // com.dangdang.zframework.network.IRequest
    public RequestConstant.Priority getPriority() {
        return RequestConstant.Priority.NORMAL;
    }
}
