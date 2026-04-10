package com.anythink.expressad.exoplayer.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    c a;
    private final Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f8526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BroadcastReceiver f8527d;

    private final class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            c cVarA = c.a(intent);
            if (cVarA.equals(d.this.a)) {
                return;
            }
            d dVar = d.this;
            dVar.a = cVarA;
            b unused = dVar.f8526c;
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }
    }

    public interface b {
        void a();
    }

    private d(Context context, b bVar) {
        this.b = (Context) com.anythink.expressad.exoplayer.k.a.a(context);
        this.f8526c = (b) com.anythink.expressad.exoplayer.k.a.a(bVar);
        this.f8527d = af.a >= 21 ? new a(this, (byte) 0) : null;
    }

    private void b() {
        BroadcastReceiver broadcastReceiver = this.f8527d;
        if (broadcastReceiver != null) {
            this.b.unregisterReceiver(broadcastReceiver);
        }
    }

    private c a() {
        BroadcastReceiver broadcastReceiver = this.f8527d;
        this.a = c.a(broadcastReceiver == null ? null : this.b.registerReceiver(broadcastReceiver, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
        return this.a;
    }
}
