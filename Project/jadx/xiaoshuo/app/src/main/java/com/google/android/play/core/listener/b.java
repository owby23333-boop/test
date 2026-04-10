package com.google.android.play.core.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes7.dex */
final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ a f6925a;

    private b(a aVar) {
        this.f6925a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f6925a.a(intent);
    }

    public /* synthetic */ b(a aVar, byte b2) {
        this(aVar);
    }
}
