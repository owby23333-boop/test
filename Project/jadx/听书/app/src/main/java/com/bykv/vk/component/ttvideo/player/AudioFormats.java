package com.bykv.vk.component.ttvideo.player;

import android.media.audiofx.AudioEffect;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.OpusUtil;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: loaded from: classes2.dex */
public class AudioFormats {
    private static final int[] validSampleRates = {4000, 8000, 11025, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 22050, LogType.UNEXP_KNOWN_REASON, 37800, 44056, 44100, 47250, OpusUtil.SAMPLE_RATE, 50000, 50400, 88200, 96000, 176400, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 352800, 2822400, 5644800};
    private static boolean sDetectDlbDevices = false;
    private static boolean sDlbDevice = false;

    public static int getDefaultSampleRatesNB() {
        return validSampleRates.length;
    }

    public static int getMaxSupportedSampleRates(int[] iArr) {
        int length = validSampleRates.length - 3;
        for (int i = 0; i < length; i++) {
            iArr[i] = validSampleRates[i];
        }
        return length;
    }

    public static boolean isLicencedDolbyDevice() {
        if (sDetectDlbDevices) {
            return sDlbDevice;
        }
        AudioEffect.Descriptor[] descriptorArrQueryEffects = AudioEffect.queryEffects();
        int length = descriptorArrQueryEffects.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (descriptorArrQueryEffects[i].implementor.contains("Dolby Laboratories")) {
                sDlbDevice = true;
                break;
            }
            i++;
        }
        sDetectDlbDevices = true;
        return sDlbDevice;
    }
}
