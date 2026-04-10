package com.bumptech.glide.l;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.l.c;

/* JADX INFO: compiled from: DefaultConnectivityMonitorFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements d {
    @Override // com.bumptech.glide.l.d
    @NonNull
    public c a(@NonNull Context context, @NonNull c.a aVar) {
        boolean z2 = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        return z2 ? new e(context, aVar) : new n();
    }
}
