package com.anythink.expressad.atsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.anythink.expressad.exoplayer.k.o;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class MraidVolumeChangeReceiver {
    public static double a = -1.0d;
    private static final String b = "android.media.VOLUME_CHANGED_ACTION";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8289c = "android.media.EXTRA_VOLUME_STREAM_TYPE";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f8290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AudioManager f8291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8292f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private VolumeChangeListener f8293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private VolumeChangeBroadcastReceiver f8294h;

    private static class VolumeChangeBroadcastReceiver extends BroadcastReceiver {
        private WeakReference<MraidVolumeChangeReceiver> a;

        public VolumeChangeBroadcastReceiver(MraidVolumeChangeReceiver mraidVolumeChangeReceiver) {
            this.a = new WeakReference<>(mraidVolumeChangeReceiver);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MraidVolumeChangeReceiver mraidVolumeChangeReceiver;
            VolumeChangeListener volumeChangeListener;
            if (!MraidVolumeChangeReceiver.b.equals(intent.getAction()) || intent.getIntExtra(MraidVolumeChangeReceiver.f8289c, -1) != 3 || (mraidVolumeChangeReceiver = this.a.get()) == null || (volumeChangeListener = mraidVolumeChangeReceiver.getVolumeChangeListener()) == null) {
                return;
            }
            double currentVolume = mraidVolumeChangeReceiver.getCurrentVolume();
            if (currentVolume >= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                volumeChangeListener.onVolumeChanged(currentVolume);
            }
        }
    }

    public interface VolumeChangeListener {
        void onVolumeChanged(double d2);
    }

    public MraidVolumeChangeReceiver(Context context) {
        this.f8290d = context;
        this.f8291e = (AudioManager) context.getApplicationContext().getSystemService(o.b);
    }

    public double getCurrentVolume() {
        AudioManager audioManager = this.f8291e;
        int streamMaxVolume = audioManager != null ? audioManager.getStreamMaxVolume(3) : -1;
        AudioManager audioManager2 = this.f8291e;
        double streamVolume = audioManager2 != null ? audioManager2.getStreamVolume(3) : -1;
        Double.isNaN(streamVolume);
        double d2 = streamMaxVolume;
        Double.isNaN(d2);
        double d3 = (streamVolume * 100.0d) / d2;
        a = d3;
        return d3;
    }

    public VolumeChangeListener getVolumeChangeListener() {
        return this.f8293g;
    }

    public void registerReceiver() {
        if (this.f8290d != null) {
            this.f8294h = new VolumeChangeBroadcastReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b);
            this.f8290d.registerReceiver(this.f8294h, intentFilter);
            this.f8292f = true;
        }
    }

    public void setVolumeChangeListener(VolumeChangeListener volumeChangeListener) {
        this.f8293g = volumeChangeListener;
    }

    public void unregisterReceiver() {
        Context context;
        if (!this.f8292f || (context = this.f8290d) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.f8294h);
            this.f8293g = null;
            this.f8292f = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
