package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IOfferClickHandler implements Serializable {
    public abstract boolean startDownloadApp(Context context, i iVar, j jVar, String str);
}
