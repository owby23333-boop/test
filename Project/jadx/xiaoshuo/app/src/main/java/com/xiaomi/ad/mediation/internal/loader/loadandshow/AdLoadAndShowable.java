package com.xiaomi.ad.mediation.internal.loader.loadandshow;

import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;

/* JADX INFO: loaded from: classes5.dex */
public interface AdLoadAndShowable {
    <T extends AdLoadAndShowInteractionListener> void loadAndShow(AdInternalConfig adInternalConfig, AdLoadAndShowListener adLoadAndShowListener, T t);
}
