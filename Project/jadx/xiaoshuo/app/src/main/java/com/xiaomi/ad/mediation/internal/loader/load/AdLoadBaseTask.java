package com.xiaomi.ad.mediation.internal.loader.load;

import com.xiaomi.ad.mediation.internal.loader.AdBaseTask;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AdLoadBaseTask extends AdBaseTask {
    public AdLoadBaseTask(int i) {
        super(i);
    }

    public abstract void execute(AdBaseTask.AdTaskListener adTaskListener);
}
