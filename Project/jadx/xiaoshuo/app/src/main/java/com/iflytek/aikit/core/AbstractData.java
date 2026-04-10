package com.iflytek.aikit.core;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractData implements AiData {
    protected AiDataHolder<?, ?> holder;

    public void ref(AiDataHolder<?, ?> aiDataHolder) {
        this.holder = aiDataHolder;
    }

    @Override // com.iflytek.aikit.core.AiData
    public void syncCtrl(int i) {
        this.holder.syncCtrl(i);
    }

    @Override // com.iflytek.aikit.core.AiData
    public void syncDesc(int i) {
        this.holder.syncDesc(i);
    }
}
