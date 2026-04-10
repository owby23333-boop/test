package com.iflytek.aikit.core.media.player;

import android.content.Context;
import com.iflytek.aikit.core.media.speech.SpeechError;
import com.iflytek.aikit.media.record.PcmBuffer;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class PcmPlayer extends com.iflytek.aikit.media.player.PcmPlayer {

    public interface PcmPlayerListener {
        void onError(SpeechError speechError);

        void onPaused();

        void onPercent(int i, int i2, int i3);

        void onResume();

        void onStoped();
    }

    public PcmPlayer(Context context, int i, boolean z, boolean z2, boolean z3) {
        super(context, i, z, z2, z3);
    }

    public boolean play(PcmBuffer pcmBuffer, PcmPlayerListener pcmPlayerListener) {
        setListener(pcmPlayerListener);
        return play(pcmBuffer);
    }

    public boolean rePlay(PcmBuffer pcmBuffer, PcmPlayerListener pcmPlayerListener) {
        super.setState(0);
        return play(pcmBuffer, pcmPlayerListener);
    }

    public PcmPlayer(Context context) {
        super(context);
    }
}
