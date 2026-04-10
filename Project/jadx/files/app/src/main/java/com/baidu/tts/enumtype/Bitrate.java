package com.baidu.tts.enumtype;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
public enum Bitrate {
    BV_16K("BV_16K", "0", 16000.0d),
    AMR_6K6("AMR_6K6", "0", 6600.0d),
    AMR_8K85("AMR_8K85", "1", 8850.0d),
    AMR_12K65("AMR_12K65", "2", 12650.0d),
    AMR_14K25("AMR_14K25", "3", 14250.0d),
    AMR_15K85("AMR_15K85", "4", 15850.0d),
    AMR_18K25("AMR_18K25", "5", 18250.0d),
    AMR_19K85("AMR_19K85", "6", 19850.0d),
    AMR_23K05("AMR_23K05", "7", 23050.0d),
    AMR_23K85("AMR_23K85", "8", 23850.0d),
    OPUS_8K("OPUS_8K", "0", 8000.0d),
    OPUS_16K("OPUS_16K", "1", 16000.0d),
    OPUS_18K("OPUS_18K", "2", 18000.0d),
    OPUS_20K("OPUS_20K", "3", 20000.0d),
    OPUS_24K("OPUS_24K", "4", 24000.0d),
    OPUS_32K("OPUS_32K", "5", 32000.0d),
    MP3_8K("MP3_8K", "0", 8000.0d),
    MP3_11K("MP3_11K", "1", 11000.0d),
    MP3_16K("MP3_16K", "2", 16000.0d),
    MP3_24K("MP3_24K", "3", 24000.0d),
    MP3_32K("MP3_32K", "4", 32000.0d),
    PCM("PCM", "0", PangleAdapterUtils.CPM_DEFLAUT_VALUE);

    private final double mBitrate;
    private final String mExpression;
    private final String mTag;

    Bitrate(String str, String str2, double d2) {
        this.mExpression = str;
        this.mTag = str2;
        this.mBitrate = d2;
    }

    public static Bitrate[] getAmrBitrates() {
        return new Bitrate[]{AMR_6K6, AMR_8K85, AMR_12K65, AMR_14K25, AMR_15K85, AMR_18K25, AMR_19K85, AMR_23K05, AMR_23K85};
    }

    public static Bitrate[] getBvBitrates() {
        return new Bitrate[]{BV_16K};
    }

    public static Bitrate getFirstEqualBitrate(String str) {
        for (Bitrate bitrate : values()) {
            if (bitrate.getTag().equals(str)) {
                return bitrate;
            }
        }
        return null;
    }

    public static Bitrate[] getMp3Bitrates() {
        return new Bitrate[]{MP3_8K, MP3_11K, MP3_16K, MP3_24K, MP3_32K};
    }

    public static Bitrate[] getOpusBitrates() {
        return new Bitrate[]{OPUS_8K, OPUS_16K, OPUS_18K, OPUS_20K, OPUS_24K, OPUS_32K};
    }

    public static Bitrate[] getPcmBitrates() {
        return new Bitrate[]{PCM};
    }

    public double getBitrate() {
        return this.mBitrate;
    }

    public String getExpression() {
        return this.mExpression;
    }

    public String getTag() {
        return this.mTag;
    }
}
