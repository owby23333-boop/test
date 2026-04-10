package com.dangdang.zframework.network.report;

/* JADX INFO: loaded from: classes10.dex */
public class WrapDDEventBus<T> implements IDDEventBus<T> {
    private static WrapDDEventBus instance = new WrapDDEventBus();
    private IDDEventBus adapter;

    public static WrapDDEventBus getInstance() {
        return instance;
    }

    @Override // com.dangdang.zframework.network.report.IDDEventBus
    public void sendEventBus(T t) {
        this.adapter.sendEventBus(t);
    }

    public void setAdapter(IDDEventBus iDDEventBus) {
        this.adapter = iDDEventBus;
    }
}
