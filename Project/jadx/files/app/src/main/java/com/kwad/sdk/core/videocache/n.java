package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.au;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    static File bk(Context context) {
        return new File(au.cQ(context), "video-cache");
    }
}
