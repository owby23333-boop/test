package com.bumptech.glide.l;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: FirstFrameAndAfterTrimMemoryWaiter.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
final class i implements k, ComponentCallbacks2 {
    i() {
    }

    @Override // com.bumptech.glide.l.k
    public void a(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(20);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
    }
}
