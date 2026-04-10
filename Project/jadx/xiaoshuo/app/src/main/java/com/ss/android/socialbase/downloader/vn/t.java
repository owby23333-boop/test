package com.ss.android.socialbase.downloader.vn;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import com.yuewen.nm0;
import com.yuewen.w51;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class t {
    private int bf;
    private final JSONObject e;

    private t(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    private int w() {
        return this.e.optInt("url_balance", 2);
    }

    public boolean bf() {
        return w() > 0;
    }

    public float bh() {
        return (float) this.e.optDouble("main_ratio", w51.l);
    }

    public boolean d() {
        return w() == 1;
    }

    public void e(int i) {
        this.bf = bf(i);
    }

    public int ga() {
        return this.e.optInt("buffer_size", 8192);
    }

    public long m() {
        long jOptInt = this.e.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public long p() {
        long jOptInt = ((long) this.e.optInt("segment_min_kb", 512)) * 1024;
        return jOptInt < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH ? PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : jOptInt;
    }

    public float s() {
        return Math.min(Math.max(0.0f, (float) this.e.optDouble("poor_speed_ratio", w51.l)), 1.0f);
    }

    public int t() {
        return this.e.optInt("ratio_segment", 0);
    }

    public int tg() {
        return this.e.optInt("buffer_count", 512);
    }

    public long v() {
        long jOptInt = ((long) this.e.optInt("segment_min_init_mb", 10)) * 1048576;
        if (jOptInt < 5242880) {
            return 5242880L;
        }
        return jOptInt;
    }

    public boolean vn() {
        return this.e.optInt("segment_mode", 1) == 0;
    }

    public long wu() {
        long jOptInt = this.e.optInt("read_timeout", -1);
        if (jOptInt >= nm0.f14891a) {
            return jOptInt;
        }
        return -1L;
    }

    public int xu() {
        return this.e.optInt("ip_strategy", 0);
    }

    public long zk() {
        long jOptInt = ((long) this.e.optInt("segment_max_kb", 0)) * 1048576;
        if (jOptInt < p()) {
            return -1L;
        }
        return jOptInt;
    }

    private int bf(int i) {
        int iOptInt = this.e.optInt("thread_count", 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return w() == 1 ? Math.min(iOptInt, i) : iOptInt;
        }
        if (w() > 0) {
            return i;
        }
        return 1;
    }

    public int e() {
        return this.bf;
    }

    @NonNull
    public static t e(@NonNull JSONObject jSONObject) {
        return new t(jSONObject);
    }
}
