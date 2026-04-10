package com.xm.logsdk.log.logger.collator;

/* JADX INFO: loaded from: classes8.dex */
public class MaxLimitCollator implements ILogCollator {
    @Override // com.xm.logsdk.log.logger.collator.ILogCollator
    public void collatingLog(String str, long j) throws Throwable {
        ClearLogUtils.deleteFilesByLimitSize(str, j);
    }
}
