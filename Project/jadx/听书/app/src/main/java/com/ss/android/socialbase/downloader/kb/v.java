package com.ss.android.socialbase.downloader.kb;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.datasource.cache.CacheDataSink;
import androidx.media3.exoplayer.ExoPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class v {
    private int g;
    private final JSONObject z;

    private v(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public void z(int i) {
        this.g = g(i);
    }

    public int z() {
        return this.g;
    }

    private int ls() {
        return this.z.optInt("url_balance", 2);
    }

    public boolean g() {
        return ls() > 0;
    }

    public boolean dl() {
        return ls() == 1;
    }

    public int a() {
        return this.z.optInt("buffer_count", 512);
    }

    public int gc() {
        return this.z.optInt("buffer_size", 8192);
    }

    public boolean m() {
        return this.z.optInt("segment_mode", 1) == 0;
    }

    public long e() {
        long jOptInt = ((long) this.z.optInt("segment_min_kb", 512)) * 1024;
        return jOptInt < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : jOptInt;
    }

    public long gz() {
        long jOptInt = ((long) this.z.optInt("segment_min_init_mb", 10)) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        return jOptInt < CacheDataSink.DEFAULT_FRAGMENT_SIZE ? CacheDataSink.DEFAULT_FRAGMENT_SIZE : jOptInt;
    }

    public long fo() {
        long jOptInt = ((long) this.z.optInt("segment_max_kb", 0)) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (jOptInt < e()) {
            return -1L;
        }
        return jOptInt;
    }

    public long uy() {
        long jOptInt = this.z.optInt("connect_timeout", -1);
        if (jOptInt >= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return jOptInt;
        }
        return -1L;
    }

    public long kb() {
        long jOptInt = this.z.optInt("read_timeout", -1);
        if (jOptInt >= 4000) {
            return jOptInt;
        }
        return -1L;
    }

    public int wp() {
        return this.z.optInt("ip_strategy", 0);
    }

    private int g(int i) {
        int iOptInt = this.z.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return ls() == 1 ? Math.min(iOptInt, i) : iOptInt;
        }
        if (ls() > 0) {
            return i;
        }
        return 1;
    }

    public float i() {
        return (float) this.z.optDouble("main_ratio", 0.0d);
    }

    public int v() {
        return this.z.optInt("ratio_segment", 0);
    }

    public float pf() {
        return Math.min(Math.max(0.0f, (float) this.z.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    public static v z(JSONObject jSONObject) {
        return new v(jSONObject);
    }
}
