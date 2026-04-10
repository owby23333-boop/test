package com.iflytek.aikit.media.param;

import android.os.Environment;
import com.iflytek.aikit.media.speech.SpeechConstant;

/* JADX INFO: loaded from: classes7.dex */
public class MscKeys {
    public static final String ACTIVITY_NAME = "act_name";
    public static final String AIMIC_ALSA_CARD = "alsa_card";
    public static final String AIMIC_ALSA_SAMPLE_RATE = "alsa_rate";
    public static final String AIMIC_CHANNEL = "aimic_on_channel";
    public static final String AIMIC_INIT_PARAM = "aimic_init_param";
    public static final String AIMIC_ON_PARAM_PREFIX = "aimic_on_";
    public static final String AIMIC_SSB_PARAM_PREFIX = "aimic_ssb_";
    public static final String AIMIC_VERSION = "aimic_on_version";
    public static final String AUDIO_AUE = "aue";
    public static final String AUDIO_AUF = "auf=audio/L16;rate";
    public static final String BOS_DISPOSE = "bos_dispose";
    public static final String DVC = "dvc";
    public static final String END_WITH_NULL = "end_with_null";
    public static final String GRAMMAR_CONTENT = "grammar_content";
    public static String IST_RESULT_TIME_LEFT = "wtime";
    public static final int IVW_CHANNEL_SINGLE = 0;
    public static final String IVW_CONFIG_PATH = "ivw_config_path";
    public static final String IVW_CONFIG_THRESHOLD = "cfg_threshold";
    public static final String IVW_CONFIG_THRESTMEP = "cfg_threstemp";
    public static final int IVW_DEF_QUERY_PERIOD = 86400000;
    public static final String IVW_ENROLL = "enroll";
    public static final int IVW_MODE_CLOSE = 0;
    public static final String IVW_NETVAL = "ivw_netval";
    public static final int IVW_NORMAL_QUERY = 2;
    public static final int IVW_NORMAL_UPDATA = 1;
    public static final String IVW_ONESHOT = "oneshot";
    public static final String IVW_WAKE = "wakeup";
    public static final int IVW_WIFI_QUERY = 4;
    public static final int IVW_WIFI_UPDATA = 3;
    public static final String JSON_KEY_AUDIOLEN = "audio_len";
    public static final String JSON_KEY_SPELLINFO = "spell_info";
    public static final String KEY_AUDIO_INFO = "audio_info";
    public static final String KEY_CALLER_APPID = "caller.appid";
    public static final String KEY_ISE_CATEGORY = "category";
    public static final String KEY_ISE_SST = "sst";
    public static final String KEY_IVW_QUERY_LASTTIME = "ivw_query_last_time";
    public static final String KEY_IVW_QUERY_PERIOD = "ivw_query_period";
    public static final String KEY_LOG_LEVEL = "lvl";
    public static final String KEY_LOG_OUTPUT = "output";
    public static final String KEY_LOG_PATH = "log";
    public static final String KEY_LXY_DATA_COLLECT_ENABLE = "lxy_tp_dc";
    public static final String KEY_PTE = "pte";
    public static final String KEY_RECORD_READ_RATE = "record_read_rate";
    public static final String KEY_RSE = "rse";
    public static final String KEY_SEP = ",";
    public static final String KEY_SPEED_INCREASE = "speed_increase";
    public static final String KEY_TEXT_BOM = "text_bom";
    public static final String KEY_TTS_BUFFERING_FADING = "tts_buf_fading";
    public static final String KEY_TTS_MIN_AUDIO_LEN = "tts_min_audio_len";
    public static final String KEY_TTS_NEXT_AUDIO_PATH = "tts_next_audio_path";
    public static final String KEY_TTS_PROC_SCALE = "tts_proc_scale";
    public static final String KEY_VAL_SEP = "=";
    public static final String LEXICON_CONTENT = "lexicon_content";
    public static final String LEXICON_NAME = "lexicon_name";
    public static final String MAC_ADDR = "mac";
    public static final String MD5 = "appid_key";
    public static final String MESSAGE_MAIN_THREAD = "message_main_thread";
    public static final String MMLC = "mmlc";
    public static final String MSC_SKIN = "msc.skin";
    public static final String MSC_VER = "msc.ver";
    public static final String MSP_AUTH = "auth";
    public static final String MSP_SSM = "ssm";
    public static final String NET_SUBTYPE = "net_subtype";
    public static final String PWD = "pwd";
    public static final String RECORD_FORCE_STOP = "record_force_stop";
    public static final String REQUEST_AUDIO_URL = "request_audio_url";
    public static final String SAMPLE_BIT = "sample_bit";
    public static final String SAMPLE_CHANNEL = "sample_channel";
    public static final String SUB_ASR = "asr";
    public static final String SUB_AUTH = "auth";
    public static final String SUB_HCR = "hcr";
    public static final String SUB_IAT = "iat";
    public static final String SUB_IATSCH = "iat_sch";
    public static final String SUB_IFR = "ifr";
    public static final String SUB_IST = "ist";
    public static final String SUB_IVP = "ivp";
    public static final String SUB_IVW = "ivw";
    public static final String SUB_MFV = "mfv";
    public static final String SUB_SEE = "ise";
    public static final String SUB_TTS = "tts";
    public static final String SUB_UUP = "uup";
    public static final String TEXT = "text";
    public static final String TTS_AUDIO_URI = "tts_audio_uri";
    public static final String UNIQUE_ID = "unique_id";
    public static final String USR = "usr";
    public static final int VALUE_AUDIO_AIMIC = -3;
    public static final int VALUE_AUDIO_EXTERNAL = -1;
    public static final int VALUE_AUDIO_EXTERNALFILE = -2;
    public static final int VALUE_IST_SESSION_TRY_DEFAULT = 1;
    public static final int VALUE_IST_SESSION_TRY_INFINITY = -1;
    public static final String VAL_FALSE = "false";
    public static final String VAL_SEP = ";";
    public static final String VER_ASR = "ver_asr";
    public static final String VER_IVW = "ver_ivw";
    public static final String VER_MSC = "ver_msc";
    public static final String VER_TTS = "ver_tts";
    public static final String VIEW_TIPS_PLAIN = "view_tips_plain";
    public static final String VALUE_IST_AUDIO_PATH = Environment.getExternalStorageDirectory().getPath() + "/msc/ist/audio/";
    public static final String SERVER_URL = "server_url";
    public static final String SUB_SCH = "sch";
    public static final String[][] MSC_MAP_KEYS = {new String[]{"surl", SERVER_URL}, new String[]{"besturl_search", "search_best_url"}, new String[]{"bsts", "search_best_url"}, new String[]{SpeechConstant.ASR_SCH, SUB_SCH}, new String[]{SpeechConstant.ASR_NOMATCH_ERROR, "asr_nme"}, new String[]{SpeechConstant.ASR_PTT, "ptt"}, new String[]{SpeechConstant.RESULT_TYPE, "rst"}, new String[]{SpeechConstant.RESULT_LEVEL, "rst_level"}, new String[]{SpeechConstant.VAD_BOS, "vad_timeout"}, new String[]{"bos", "vad_timeout"}, new String[]{SpeechConstant.VAD_EOS, "vad_speech_tail", "eos"}, new String[]{"eos", "vad_speech_tail", "eos"}, new String[]{SpeechConstant.ASR_AUDIO_PATH, "aap"}, new String[]{SpeechConstant.TTS_BUFFER_TIME, "tbt"}, new String[]{SpeechConstant.TTS_AUDIO_PATH, "tap"}, new String[]{"subject", "sub"}, new String[]{SpeechConstant.DATA_TYPE, "dtt"}, new String[]{SpeechConstant.ASR_NBEST, "nbest"}, new String[]{SpeechConstant.ASR_WBEST, "wbest"}, new String[]{SpeechConstant.ASR_DWA, "dwa"}, new String[]{SpeechConstant.VOICE_NAME, "vcn"}, new String[]{SpeechConstant.BACKGROUND_SOUND, "bgs"}, new String[]{SpeechConstant.TEXT_ENCODING, "tte"}, new String[]{SpeechConstant.IVW_NET_MODE, "ivwnet_mode"}};

    public enum VadStatus {
        VAD_LOOKING,
        VAD_INSPEECH,
        undefined_2,
        VAD_EOS,
        VAD_TIMEOUT,
        VAD_ERROR
    }
}
