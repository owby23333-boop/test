package com.baidu.tts.adapter.audiotransition;

import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.tts.tools.CommonUtility;

/* JADX INFO: loaded from: classes2.dex */
public class AudioDecoderAdapter implements IAudioTransitionAdapter<byte[], byte[]> {
    private static final String TAG = "AudioDecoderAdapter";

    @Override // com.baidu.tts.adapter.audiotransition.IAudioTransitionAdapter
    public void initial() {
    }

    @Override // com.baidu.tts.adapter.audiotransition.IAudioTransitionAdapter
    public void release() {
    }

    @Override // com.baidu.tts.adapter.audiotransition.IAudioTransitionAdapter
    public void start() {
    }

    @Override // com.baidu.tts.adapter.audiotransition.IAudioTransitionAdapter
    public void stop() {
    }

    @Override // com.baidu.tts.adapter.audiotransition.IAudioTransitionAdapter
    public byte[] getAdaptedData(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[0];
        int i2 = length * 50;
        short[] sArr = new short[i2 / 2];
        int[] iArr = new int[1];
        try {
            if (new SpeechDecoder().decode(bArr, length, sArr, iArr, i2, 0) != 0) {
                return bArr2;
            }
            int i3 = iArr[0] / 2;
            short[] sArr2 = new short[i3];
            System.arraycopy(sArr, 0, sArr2, 0, i3);
            return CommonUtility.shortArrayToByteArray(sArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr2;
        }
    }
}
