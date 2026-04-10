package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* JADX INFO: loaded from: classes8.dex */
public class ej implements LoggerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoggerInterface f7917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoggerInterface f7918b;

    public ej(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f7917a = loggerInterface;
        this.f7918b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.f7917a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f7918b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f7917a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f7918b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }
}
