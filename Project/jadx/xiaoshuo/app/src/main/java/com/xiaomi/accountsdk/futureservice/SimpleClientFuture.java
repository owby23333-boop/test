package com.xiaomi.accountsdk.futureservice;

import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleClientFuture<DataType> extends ClientFuture<DataType, DataType> {
    public SimpleClientFuture() {
        super(null);
    }

    @Override // com.xiaomi.accountsdk.futureservice.ClientFuture
    public DataType convertServerDataToClientData(DataType datatype) throws Throwable {
        return datatype;
    }

    @Override // com.xiaomi.accountsdk.futureservice.ClientFuture
    public void interpretExecutionException(ExecutionException executionException) throws Exception {
        throw executionException;
    }
}
