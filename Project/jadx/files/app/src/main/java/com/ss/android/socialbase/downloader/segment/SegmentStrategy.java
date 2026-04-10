package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SegmentStrategy {
    private static final int MAX_THREAD_COUNT = 16;
    private static final long MIN_CONNECT_TIMEOUT = 2000;
    private static final long MIN_READ_TIMEOUT = 4000;
    private static final long SEGMENT_MIN_INIT_SIZE = 5242880;
    private static final long SEGMENT_MIN_SIZE = 65536;
    public static final String TAG = "SegmentStrategy";
    private final JSONObject config;
    private int threadCount;

    private SegmentStrategy(JSONObject jSONObject) {
        this.config = jSONObject;
    }

    private int calculateThreadCount(int i2) {
        int iOptInt = this.config.optInt(DownloadSettingKeys.SegmentConfig.THREAD_COUNT, 4);
        if (iOptInt > 16) {
            iOptInt = 16;
        }
        if (iOptInt > 0) {
            return getUrlBalance() == 1 ? Math.min(iOptInt, i2) : iOptInt;
        }
        if (getUrlBalance() > 0) {
            return i2;
        }
        return 1;
    }

    @NonNull
    public static SegmentStrategy from(@NonNull JSONObject jSONObject) {
        return new SegmentStrategy(jSONObject);
    }

    private int getUrlBalance() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.URL_BALANCE, 2);
    }

    public int getBufferCount() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.BUFFER_COUNT, 512);
    }

    public int getBufferSize() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.BUFFER_SIZE, 8192);
    }

    public long getConnectTimeout() {
        long jOptInt = this.config.optInt("connect_timeout", -1);
        if (jOptInt >= 2000) {
            return jOptInt;
        }
        return -1L;
    }

    public int getIpStrategy() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.IP_STRATEGY, 0);
    }

    public float getMainRatio() {
        return (float) this.config.optDouble(DownloadSettingKeys.SegmentConfig.MAIN_RATIO, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
    }

    public float getPoorSpeedRatio() {
        return Math.min(Math.max(0.0f, (float) this.config.optDouble(DownloadSettingKeys.SegmentConfig.POOR_SPEED_RATIO, PangleAdapterUtils.CPM_DEFLAUT_VALUE)), 1.0f);
    }

    public int getRatioSegmentStrategy() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.RATIO_SEGMENT, 0);
    }

    public long getReadTimeout() {
        long jOptInt = this.config.optInt(DownloadSettingKeys.SegmentConfig.READ_TIMEOUT, -1);
        if (jOptInt >= MIN_READ_TIMEOUT) {
            return jOptInt;
        }
        return -1L;
    }

    public long getSegmentMaxSize() {
        long jOptInt = ((long) this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MAX_KB, 0)) * 1048576;
        if (jOptInt < getSegmentMinSize()) {
            return -1L;
        }
        return jOptInt;
    }

    public long getSegmentMinInitSize() {
        long jOptInt = ((long) this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MIN_INIT_MB, 10)) * 1048576;
        return jOptInt < SEGMENT_MIN_INIT_SIZE ? SEGMENT_MIN_INIT_SIZE : jOptInt;
    }

    public long getSegmentMinSize() {
        long jOptInt = ((long) this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MIN_KB, 512)) * 1024;
        if (jOptInt < 65536) {
            return 65536L;
        }
        return jOptInt;
    }

    public int getThreadCount() {
        return this.threadCount;
    }

    public boolean segmentOneByOne() {
        return this.config.optInt(DownloadSettingKeys.SegmentConfig.SEGMENT_MODE, 1) == 0;
    }

    public void updateUrlCount(int i2) {
        this.threadCount = calculateThreadCount(i2);
    }

    public boolean urlBalance() {
        return getUrlBalance() > 0;
    }

    public boolean urlBalanceStrictly() {
        return getUrlBalance() == 1;
    }
}
