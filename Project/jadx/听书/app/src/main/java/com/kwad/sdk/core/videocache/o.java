package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.be;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class o {
    static File bQ(Context context) {
        return new File(be.dE(context), "video-cache");
    }
}
