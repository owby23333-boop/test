package com.google.zxing.datamatrix.encoder;

import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.duokan.reader.ui.reading.menu.TtsPlayerController;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;

/* JADX INFO: loaded from: classes7.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 134, 240, 92, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE}, new int[]{28, 24, 185, 166, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 116, 255, 110, 61}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 138, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_ID, 12, 194, 168, 39, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, MediaPlayer.MEDIA_PLAYER_OPTION_IS_VPP_LEVEL, 97, 178, 100, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, 97, 192, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 95, 9, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME, 119, 138, 45, 18, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, MediaPlayer.MEDIA_PLAYER_OPTION_IS_VPP_LEVEL, 109, TsExtractor.TS_STREAM_TYPE_AC3, 94, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 225, 48, 90, 188}, new int[]{15, 195, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, 9, 233, 71, 168, 2, 188, 160, 153, 145, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 79, 108, 82, 27, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 172}, new int[]{52, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 88, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_ID, 109, 39, 176, 21, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME, 21, 5, 172, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 124, 12, 181, 184, 96, 50, 193}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_BEFORE_FIRST_FRAME, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 43, 97, 71, 96, 103, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 37, 151, TtsPlayerController.k1, 53, 75, 34, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 121, 17, 138, 110, MediaPlayer.MEDIA_PLAYER_OPTION_IS_VPP_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 136, 120, 151, 233, 168, 93, 255}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 127, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 218, 130, 250, 162, 181, 102, 120, 84, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 80, 182, 229, 18, 2, 4, 68, 33, 101, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 95, 119, 115, 44, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 31, 19, 38, 22, 153, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 105, 122, 2, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 57, 54, 101, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 172, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 96, 32, 117, 22, 238, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 238, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_ID, 188, 237, 87, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 106, 16, 147, 118, 23, 37, 90, TtsPlayerController.k1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_ID, 131, 88, 120, 100, 66, 138, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 240, 82, 44, 176, 87, 187, 147, 160, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 69, MediaPlayer.MEDIA_PLAYER_OPTION_IS_VPP_LEVEL, 92, MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT, 225, 19}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 9, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 238, 12, 17, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_DRM_DOWNGRADE, 100, 29, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, TtsPlayerController.k1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 192, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 235, 150, 159, 36, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 38, 200, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 54, 228, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK, 218, 234, 117, 203, 29, 232, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 238, 22, 150, 201, 117, 62, 207, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 13, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 127, 67, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 28, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME, 43, 203, 107, 233, 53, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 46}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 93, Opcodes.RET, 50, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, MediaPlayer.MEDIA_PLAYER_OPTION_REND_FIRST_FRAME_TIME, 39, 118, 202, 188, 201, 189, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 108, 196, 37, 185, 112, 134, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 63, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 250, 106, 185, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 64, 114, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, TtsPlayerController.k1, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 228, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 89, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, Opcodes.FCMPL, 159, 56, 89, 33, 147, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, 154, 36, 73, 127, MediaPlayer.MEDIA_PLAYER_OPTION_IS_VPP_LEVEL, 136, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, Opcodes.GETFIELD, 234, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 158, 177, 68, 122, 93, MediaPlayer.MEDIA_PLAYER_OPTION_IS_VPP_LEVEL, 15, 160, 227, 236, 66, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE, 153, 185, 202, 167, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 25, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 232, 96, MediaPlayer.MEDIA_PLAYER_OPTION_REND_FIRST_FRAME_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, 136, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 239, 181, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 59, 52, 172, 25, 49, 232, MediaPlayer.MEDIA_PLAYER_OPTION_BUFFERING_BEFORE_FIRST_FRAME, 189, 64, 54, 108, 153, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 63, 96, 103, 82, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i5, strCreateECCBlock.charAt(i6));
                    i5 += interleavedBlockCount;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i6 >= iArr.length) {
                i6 = -1;
                break;
            }
            if (iArr[i6] == i3) {
                break;
            }
            i6++;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
        }
        int[] iArr2 = FACTORS[i6];
        char[] cArr = new char[i3];
        for (int i7 = 0; i7 < i3; i7++) {
            cArr[i7] = 0;
        }
        for (int i8 = i; i8 < i + i2; i8++) {
            int i9 = i3 - 1;
            int iCharAt = cArr[i9] ^ charSequence.charAt(i8);
            while (i9 > 0) {
                if (iCharAt == 0 || (i5 = iArr2[i9]) == 0) {
                    cArr[i9] = cArr[i9 - 1];
                } else {
                    char c = cArr[i9 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i9] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i5]) % 255] ^ c);
                }
                i9--;
            }
            if (iCharAt == 0 || (i4 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i4]) % 255];
            }
        }
        char[] cArr2 = new char[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            cArr2[i10] = cArr[(i3 - i10) - 1];
        }
        return String.valueOf(cArr2);
    }
}
