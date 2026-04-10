package com.baidu.tts.enumtype;

/* JADX INFO: loaded from: classes2.dex */
public enum AudioEncoderFormat {
    BV("0") { // from class: com.baidu.tts.enumtype.AudioEncoderFormat.1
        @Override // com.baidu.tts.enumtype.AudioEncoderFormat
        public Bitrate[] getSupportBitrates() {
            return Bitrate.getBvBitrates();
        }
    },
    AMR("1") { // from class: com.baidu.tts.enumtype.AudioEncoderFormat.2
        @Override // com.baidu.tts.enumtype.AudioEncoderFormat
        public Bitrate[] getSupportBitrates() {
            return Bitrate.getAmrBitrates();
        }
    },
    OPUS("2") { // from class: com.baidu.tts.enumtype.AudioEncoderFormat.3
        @Override // com.baidu.tts.enumtype.AudioEncoderFormat
        public Bitrate[] getSupportBitrates() {
            return Bitrate.getOpusBitrates();
        }
    },
    MP3("3") { // from class: com.baidu.tts.enumtype.AudioEncoderFormat.4
        @Override // com.baidu.tts.enumtype.AudioEncoderFormat
        public Bitrate[] getSupportBitrates() {
            return Bitrate.getMp3Bitrates();
        }
    },
    PCM("4") { // from class: com.baidu.tts.enumtype.AudioEncoderFormat.5
        @Override // com.baidu.tts.enumtype.AudioEncoderFormat
        public Bitrate[] getSupportBitrates() {
            return Bitrate.getPcmBitrates();
        }
    };

    private final String mTag;

    public static AudioEncoderFormat getAudioEncoderFormat(String str) {
        for (AudioEncoderFormat audioEncoderFormat : values()) {
            if (audioEncoderFormat.getTag().equals(str)) {
                return audioEncoderFormat;
            }
        }
        return null;
    }

    public static boolean isMatched(AudioEncoderFormat audioEncoderFormat, Bitrate bitrate) {
        for (Bitrate bitrate2 : audioEncoderFormat.getSupportBitrates()) {
            if (bitrate2.equals(bitrate)) {
                return true;
            }
        }
        return false;
    }

    public abstract Bitrate[] getSupportBitrates();

    public String getTag() {
        return this.mTag;
    }

    AudioEncoderFormat(String str) {
        this.mTag = str;
    }

    public static boolean isMatched(AudioEncoderFormat audioEncoderFormat, String str) {
        for (Bitrate bitrate : audioEncoderFormat.getSupportBitrates()) {
            if (bitrate.getTag().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
