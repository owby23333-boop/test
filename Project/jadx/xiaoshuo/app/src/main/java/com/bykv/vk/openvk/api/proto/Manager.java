package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i);

    ValueSet values();
}
