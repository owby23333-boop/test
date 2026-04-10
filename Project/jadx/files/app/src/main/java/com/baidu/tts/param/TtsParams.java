package com.baidu.tts.param;

import com.baidu.tts.bridge.engine.synthesizer.OfflineSynthesizer;
import com.baidu.tts.bridge.engine.synthesizer.OnlineSynthesizer;
import com.baidu.tts.bridge.play.player.AudioTrackPlayer;
import com.baidu.tts.enumtype.AudioEncoderFormat;
import com.baidu.tts.enumtype.Bitrate;
import com.baidu.tts.enumtype.CharSetEnum;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.MixMode;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.prototype.APrototype;

/* JADX INFO: loaded from: classes2.dex */
public class TtsParams extends APrototype<TtsParams> {
    private static final long serialVersionUID = 5006248468916728332L;
    private AllSynthesizerParams mEngineParams = new AllSynthesizerParams();
    private AllPlayerParams mPlayerParams = new AllPlayerParams();

    /* JADX INFO: renamed from: com.baidu.tts.param.TtsParams$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$tts$enumtype$KeyEnum = new int[KeyEnum.values().length];

        static {
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.SPEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.VOLUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.PITCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.TEXT_DAT_PATH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.SPEECH_DAT_PATH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.TTS_LICENSE_FILE_PATH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.APP_CODE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.TEXT_ENCODE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.NOTIFICATION_COUNT_PER_SECOND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.PRODUCT_ID.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.KEY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.AUDIO_ENCODE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.BITRATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.BACKGROUND.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.CUSTOM_SYNTH.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.LANGUAGE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.OPEN_XML.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.PUNCTUATION.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.SPEAKER.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.STYLE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.TERRITORY.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.TTS_VOCODER_OPTIMIZATION.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.API_KEY.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.SECRET_KEY.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.STREAM_TYPE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.MIX_MODE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.SAMPLE_RATE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.SPEC.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.PROXY_HOST.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.PROXY_PORT.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.REQUEST_PROTOCOL.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.REQUEST_ENABLE_DNS.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.URL.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.MIX_ONLINE_REQUEST_TIMEOUT.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.BILINGUAL_MODE.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.AUDIO_CTRL.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.TEXT_CTRL.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$KeyEnum[KeyEnum.AUTH_SERIAL_NUMBER.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
        }
    }

    private int dispatcher(KeyEnum keyEnum, String str) {
        TimeOutEnum timeOutEnumValueOf;
        MixMode mixModeValueOf;
        OfflineSynthesizer.OfflineSynthesizerParams offlineSynthesizerParams = this.mEngineParams.getOfflineSynthesizerParams();
        OnlineSynthesizer.OnlineSynthesizerParams onlineSynthesizerParams = this.mEngineParams.getOnlineSynthesizerParams();
        AudioTrackPlayer.AudioTrackPlayerParams audioTrackPlayerParams = this.mPlayerParams.getAudioTrackPlayerParams();
        switch (AnonymousClass1.$SwitchMap$com$baidu$tts$enumtype$KeyEnum[keyEnum.ordinal()]) {
            case 1:
                this.mEngineParams.setSpeed(str);
                return 0;
            case 2:
                this.mEngineParams.setVolume(str);
                return 0;
            case 3:
                this.mEngineParams.setPitch(str);
                return 0;
            case 4:
                offlineSynthesizerParams.setTextDatPath(str);
                return 0;
            case 5:
                offlineSynthesizerParams.setSpeechDatPath(str);
                return 0;
            case 6:
                offlineSynthesizerParams.setTtsLicenseFilePath(str);
                return 0;
            case 7:
                offlineSynthesizerParams.setAppCode(str);
                return 0;
            case 8:
                onlineSynthesizerParams.setTextEncode(CharSetEnum.getCharSetEnum(str));
                return 0;
            case 9:
                audioTrackPlayerParams.setNotificationCountPerSecond(str);
                return 0;
            case 10:
                onlineSynthesizerParams.setProductId(str);
                return 0;
            case 11:
                onlineSynthesizerParams.setKey(str);
                return 0;
            case 12:
                return onlineSynthesizerParams.setAudioEncode(AudioEncoderFormat.getAudioEncoderFormat(str));
            case 13:
                onlineSynthesizerParams.setAudioRate(Bitrate.getFirstEqualBitrate(str));
                return 0;
            case 14:
                onlineSynthesizerParams.setBackground(str);
                return 0;
            case 15:
                return offlineSynthesizerParams.setDomainSynth(str);
            case 16:
                onlineSynthesizerParams.setLanguage(str);
                offlineSynthesizerParams.setLanguage(str);
                return 0;
            case 17:
                return this.mEngineParams.setOpenXml(str);
            case 18:
                onlineSynthesizerParams.setPunc(str);
                return 0;
            case 19:
                onlineSynthesizerParams.setSpeaker(str);
                return 0;
            case 20:
                onlineSynthesizerParams.setStyle(str);
                return 0;
            case 21:
                onlineSynthesizerParams.setTerritory(str);
                return 0;
            case 22:
                return offlineSynthesizerParams.setVocoderOptimLevel(str);
            case 23:
                onlineSynthesizerParams.setApiKey(str);
                return 0;
            case 24:
                onlineSynthesizerParams.setSecretKey(str);
                return 0;
            case 25:
                this.mPlayerParams.setStreamType(Integer.parseInt(str));
                return 0;
            case 26:
                try {
                    mixModeValueOf = MixMode.valueOf(str);
                    break;
                } catch (Exception unused) {
                    mixModeValueOf = MixMode.DEFAULT;
                }
                this.mEngineParams.setMixMode(mixModeValueOf);
                return 0;
            case 27:
                offlineSynthesizerParams.setSampleRate(str);
                return 0;
            case 28:
                offlineSynthesizerParams.setSpec(str);
                return 0;
            case 29:
                onlineSynthesizerParams.setProxyHost(str);
                return 0;
            case 30:
                onlineSynthesizerParams.setProxyPort(Integer.parseInt(str));
                return 0;
            case 31:
                onlineSynthesizerParams.setRequestProtocol(str);
                return 0;
            case 32:
                onlineSynthesizerParams.setRequestMode(str);
                return 0;
            case 33:
                onlineSynthesizerParams.setUrl(str);
                return 0;
            case 34:
                try {
                    timeOutEnumValueOf = TimeOutEnum.valueOf(str);
                    break;
                } catch (Exception unused2) {
                    timeOutEnumValueOf = TimeOutEnum.FOUR_SECOND;
                }
                this.mEngineParams.setMixOnlineRequestTimeout(timeOutEnumValueOf);
                return 0;
            case 35:
                offlineSynthesizerParams.setBiligualMode(str);
                return 0;
            case 36:
                onlineSynthesizerParams.setAudioCtrl(str);
                return 0;
            case 37:
                onlineSynthesizerParams.setTextCtrl(str);
                return 0;
            case 38:
                offlineSynthesizerParams.setAuthSN(str);
                return 0;
            default:
                return 0;
        }
    }

    public AudioTrackPlayer.AudioTrackPlayerParams getAudioTrackPlayerParams() {
        return this.mPlayerParams.getAudioTrackPlayerParams();
    }

    public AllSynthesizerParams getEngineParams() {
        return this.mEngineParams;
    }

    public OfflineSynthesizer.OfflineSynthesizerParams getOfflineSynthesizerParams() {
        return this.mEngineParams.getOfflineSynthesizerParams();
    }

    public OnlineSynthesizer.OnlineSynthesizerParams getOnlineSynthesizerParams() {
        return this.mEngineParams.getOnlineSynthesizerParams();
    }

    public AllPlayerParams getPlayerParams() {
        return this.mPlayerParams;
    }

    public void setEngineParams(AllSynthesizerParams allSynthesizerParams) {
        this.mEngineParams = allSynthesizerParams;
    }

    public int setParam(KeyEnum keyEnum, String str) {
        return dispatcher(keyEnum, str);
    }

    public void setPlayerParams(AllPlayerParams allPlayerParams) {
        this.mPlayerParams = allPlayerParams;
    }
}
