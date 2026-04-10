package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes7.dex */
final class f extends com.google.android.play.core.listener.a<SplitInstallSessionState> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f6967b;
    private final c c;

    public f(Context context) {
        this(context, a.a());
    }

    private f(Context context, c cVar) {
        super(new com.google.android.play.core.splitcompat.b.b("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f6967b = new Handler(Looper.getMainLooper());
        this.c = cVar;
    }

    @Override // com.google.android.play.core.listener.a
    public final void a(Intent intent) {
        c cVar;
        SplitInstallSessionState splitInstallSessionStateA = SplitInstallSessionState.a(intent.getBundleExtra("session_state"));
        this.f6923a.b("ListenerRegistryBroadcastReceiver.onReceive: %s", splitInstallSessionStateA);
        if (splitInstallSessionStateA.status() != 3 || (cVar = this.c) == null) {
            a(splitInstallSessionStateA);
        } else {
            cVar.a(splitInstallSessionStateA.f6961a, new b(this, splitInstallSessionStateA));
        }
    }
}
