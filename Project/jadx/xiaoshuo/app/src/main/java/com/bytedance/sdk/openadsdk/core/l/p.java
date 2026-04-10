package com.bytedance.sdk.openadsdk.core.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.bytedance.sdk.component.utils.wu;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes10.dex */
public class p {
    private vn bf;
    private e d;
    private final AudioManager ga;
    private final Context tg;
    private int e = -1;
    private boolean vn = false;
    private int p = -1;

    public static class e extends BroadcastReceiver {
        private WeakReference<p> e;

        public e(p pVar) {
            this.e = new WeakReference<>(pVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            vn vnVarD;
            int iBf;
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    wu.bf("VolumeChangeObserver", "媒体音量改变通.......");
                    p pVar = this.e.get();
                    if (pVar == null || (vnVarD = pVar.d()) == null || (iBf = pVar.bf()) == pVar.e()) {
                        return;
                    }
                    pVar.e(iBf);
                    if (iBf >= 0) {
                        vnVarD.e(iBf);
                    }
                }
            } catch (Throwable th) {
                wu.e("VolumeChangeObserver", "onVolumeChangedError: ", th);
            }
        }
    }

    public p(Context context) {
        this.tg = context;
        this.ga = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int bf() {
        try {
            AudioManager audioManager = this.ga;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            wu.e("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public vn d() {
        return this.bf;
    }

    public int e() {
        return this.p;
    }

    public void registerReceiver() {
        if (this.vn) {
            return;
        }
        try {
            this.d = new e(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.tg.registerReceiver(this.d, intentFilter);
            this.vn = true;
        } catch (Throwable th) {
            wu.e("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public void unregisterReceiver() {
        if (this.vn) {
            try {
                this.tg.unregisterReceiver(this.d);
                this.bf = null;
                this.vn = false;
            } catch (Throwable th) {
                wu.e("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public void e(int i) {
        this.p = i;
    }

    public void e(vn vnVar) {
        this.bf = vnVar;
    }
}
