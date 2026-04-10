package com.anythink.network.ks;

import com.kwad.sdk.api.KsCustomController;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KSATCustomController {
    public boolean getCanReadICCID() {
        return true;
    }

    public boolean getCanReadMacAddress() {
        return true;
    }

    public boolean getCanReadNearbyWifiList() {
        return true;
    }

    public KsCustomController getKsCustomeController() {
        return null;
    }
}
