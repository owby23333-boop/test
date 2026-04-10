package com.xiaomi.ad.mediation.internal.loader.loadandshow;

import com.xiaomi.ad.mediation.internal.loader.AdBaseTask;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AdLoadAndShowBaseTask extends AdBaseTask {
    public AdLoadAndShowBaseTask(int i) {
        super(i);
    }

    public abstract <T extends AdLoadAndShowInteractionListener> void execute(AdBaseTask.AdTaskListener adTaskListener, T t);
}
