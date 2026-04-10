package com.jeremyliao.liveeventbus.core;

/* JADX INFO: loaded from: classes7.dex */
public class ObservableConfig {
    Boolean lifecycleObserverAlwaysActive = null;
    Boolean autoClear = null;

    public ObservableConfig autoClear(boolean z) {
        this.autoClear = Boolean.valueOf(z);
        return this;
    }

    public ObservableConfig lifecycleObserverAlwaysActive(boolean z) {
        this.lifecycleObserverAlwaysActive = Boolean.valueOf(z);
        return this;
    }
}
