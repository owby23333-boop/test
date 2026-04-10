package com.iflytek.aikit.core.media.record;

import com.iflytek.aikit.core.media.speech.SpeechError;
import com.iflytek.aikit.media.record.PcmRecorder;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class PcmRecorder extends com.iflytek.aikit.media.record.PcmRecorder {

    public interface PcmRecordListener {
        void onDecibel(int i);

        void onError(SpeechError speechError);

        void onRecordBuffer(byte[] bArr, int i, int i2);

        void onRecordReleased();

        void onRecordStarted(boolean z);
    }

    public PcmRecorder(PcmRecorder.Builder builder, PcmRecordListener pcmRecordListener) {
        super(builder, pcmRecordListener);
    }
}
