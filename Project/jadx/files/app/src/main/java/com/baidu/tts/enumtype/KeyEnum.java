package com.baidu.tts.enumtype;

import com.anythink.core.api.ATCustomRuleKeys;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;
import com.anythink.expressad.d.a.b;
import com.anythink.expressad.foundation.d.l;
import com.anythink.expressad.foundation.h.i;
import com.taobao.accs.utl.BaseMonitor;

/* JADX INFO: loaded from: classes2.dex */
public enum KeyEnum {
    STATE(null, CallMraidJS.b, null),
    CODE(null, "code", null),
    DATA(null, "data", null),
    IVERSION(null, "iversion", null),
    URL("url", "url", null),
    MD5(null, "md5", null),
    LENGTH(null, "length", null),
    ABS_PATH(null, "absPath", null),
    ID("id", "id", null),
    GENDER(null, ATCustomRuleKeys.GENDER, null),
    DOMAIN(null, "domain", null),
    QUALITY(null, "quality", null),
    DATA_COUNT(null, "data_count", null),
    DATA_LIST(null, "data_list", null),
    NAME(null, "name", null),
    VERSION_MIN(null, "version_min", null),
    VERSION_MAX(null, "version_max", null),
    TEXT_DATA_ID(null, "text_data_id", null),
    SPEECH_DATA_ID(null, "speech_data_id", null),
    FUNCTION("func", "function", ""),
    MODELSINFO("modelsinfo", "modelsinfo", ""),
    ERROR_NUMBER("err_no", "errorNumber", ""),
    ERROR_MESSAGE("err_msg", "errorMessage", ""),
    MIX_MODE(null, "mixMode", null),
    NOTIFICATION_COUNT_PER_SECOND("ncps", "notificationCountPerSecond", ""),
    PERCENT("pct", "percent", ""),
    APP_CODE(b.da, "appCode", ""),
    AUTH_SERIAL_NUMBER("authSN", "authSerialNumber", ""),
    PACKAGE_NAME("pn", "packageName", "app_name"),
    PLATFORM("", "platform", ""),
    SPEED("spd", "speed", ""),
    VOLUME("vol", "volume", ""),
    PITCH("pit", "pitch", ""),
    LANGUAGE("lan", "language", ""),
    TEXT_ENCODE("cod", "textEncode", ""),
    STREAM_TYPE("st", "streamType", ""),
    AUDIO_ENCODE("aue", "audioEncode", ""),
    BITRATE("rate", "audioRate", ""),
    SPEAKER("per", "speaker", ""),
    STYLE("sty", i.f10647e, ""),
    BACKGROUND("bcg", "background", ""),
    PRODUCT_ID("pdt", "productId", ""),
    TEXT_DAT_PATH("tdp", "textDatPath", ""),
    SPEECH_DAT_PATH("sdp", "speechDatPath", ""),
    TTS_LICENSE_FILE_PATH("tlfp", "ttsLicenseFilePath", ""),
    CUSTOM_SYNTH("cs", "custom_synth", ""),
    OPEN_XML("xml", "open_xml", ""),
    TTS_VOCODER_OPTIMIZATION("tvo", "ttsVocoderOptimzation", ""),
    SAMPLE_RATE("sr", "sampleRate", ""),
    SERIAL_NUMBER("sn", "serialNumber", ""),
    INDEX("idx", "index", ""),
    TEXT("tex", "text", ""),
    CTP("ctp", "clientPath", ""),
    CUID("cuid", "deviceId", "wise_cuid"),
    VERSION("ver", "version", "sdkversion"),
    NUMBER(l.f10300d, "number", ""),
    ENGINE("en", "engine", ""),
    TERRITORY("ter", "territory", ""),
    PUNCTUATION("puc", "punctuation", ""),
    CONTEXT("ctx", "context", ""),
    API_KEY("", "apiKey", ""),
    SECRET_KEY("", "secretKey", ""),
    TOKEN("tok", "token", ""),
    SPEC("spec", "spec", ""),
    KEY("key", "key", ""),
    PROXY_HOST("ph", "proxyHost", ""),
    PROXY_PORT("pp", "proxyPort", ""),
    REQUEST_PROTOCOL("rp", "requestProtocol", ""),
    REQUEST_ENABLE_DNS(BaseMonitor.COUNT_POINT_DNS, BaseMonitor.COUNT_POINT_DNS, ""),
    SIGN("sign", "", "appidmd5"),
    APPNAME("app", "", "app_package_name"),
    SELFDEF("selfDef", "", ""),
    STA("sta", "", ""),
    GETLICENSE_ERRNO("errno", "", ""),
    BILINGUAL_MODE("bmode", "bilingualmode", ""),
    MIX_ONLINE_REQUEST_TIMEOUT(null, "mix_online_request_timeout", null),
    RESPONSE_CHANNEL("channel", "channel", ""),
    RESPONSE_SAMPLE_RATE("samplerate", "samplerate", ""),
    AUDIO_CTRL("audio_ctrl", "audio_ctrl", ""),
    TEXT_CTRL("text_ctrl", "text_ctrl", ""),
    CUID_NUM("cuid_num", "cuid_num", "");

    private final String mAlias;
    private final String mFullName;
    private final String mShortName;

    KeyEnum(String str, String str2, String str3) {
        this.mShortName = str;
        this.mFullName = str2;
        this.mAlias = str3;
    }

    public static String getUniqueName(KeyEnum keyEnum) {
        if (keyEnum == null) {
            return null;
        }
        return keyEnum.name();
    }

    public String getAlias() {
        return this.mAlias;
    }

    public String getFullName() {
        return this.mFullName;
    }

    public String getShortName() {
        return this.mShortName;
    }
}
