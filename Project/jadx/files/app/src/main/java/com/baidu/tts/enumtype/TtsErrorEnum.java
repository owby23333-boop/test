package com.baidu.tts.enumtype;

import anet.channel.util.ErrorConstant;
import com.anythink.core.common.g.g;

/* JADX INFO: loaded from: classes2.dex */
public enum TtsErrorEnum {
    ONLINE_ENGINE_AUTH_FAILURE(ErrorType.ONLINE_ENGINE_ERROR, -1, "online engine auth failure"),
    ONLINE_ENGINE_HTTP_REQUEST_FAILURE(ErrorType.ONLINE_ENGINE_ERROR, -2, "request failure"),
    ONLINE_ENGINE_CANCEL_FAILURE(ErrorType.ONLINE_ENGINE_ERROR, -3, "cancel failure"),
    ONLINE_AUTH_INTERRUPTED_EXCEPTION(ErrorType.ONLINE_ENGINE_ERROR, -4, "InterruptedException"),
    ONLINE_AUTH_EXECUTION_EXCEPTION(ErrorType.ONLINE_ENGINE_ERROR, -5, "ExecutionException"),
    ONLINE_AUTH_TIMEOUT_EXCEPTION(ErrorType.ONLINE_ENGINE_ERROR, -6, "TimeoutException"),
    ONLINE_ENGINE_REQUEST_RESULT_ERROR(ErrorType.ONLINE_ENGINE_ERROR, -7, "request result contains error message"),
    ONLINE_TOKEN_IS_NULL(ErrorType.ONLINE_ENGINE_ERROR, -8, "access token is null, please check your apikey and secretkey or product id"),
    ONLINE_ENGINE_UNINITIALIZED(ErrorType.ONLINE_ENGINE_ERROR, -9, "online engine is not initial"),
    ONLINE_ENGINE_CALL_EXCEPTION(ErrorType.ONLINE_ENGINE_ERROR, -10, "online engine call synthesize exception"),
    ONLINE_UNSUPPORTED_OPERATION(ErrorType.ONLINE_ENGINE_ERROR, -11, "this method is not supported by online mode(please use other mode)"),
    ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR(ErrorType.ONLINE_ENGINE_ERROR, -12, "request result parse error may responsebag is null"),
    ONLINE_ENGINE_GET_INTERRUPTED(ErrorType.ONLINE_ENGINE_ERROR, -13, "online synthesize get was interrupted"),
    ONLINE_ENGINE_GET_EXECUTION_EXCEPTION(ErrorType.ONLINE_ENGINE_ERROR, -14, "online synthesize get exception"),
    ONLINE_ENGINE_GET_TIMEOUT(ErrorType.ONLINE_ENGINE_ERROR, -15, "online synthesize get was timeout"),
    ONLINE_AUTH_CANCELLATION_EXCEPTION(ErrorType.ONLINE_ENGINE_ERROR, -16, "CancellationException"),
    ONLINE_ENGINE_SERVER_IP_IS_NULL(ErrorType.ONLINE_ENGINE_ERROR, -17, "online engine server ip is null"),
    OFFLINE_ENGINE_AUTH_FAILURE(ErrorType.OFFLINE_ENGINE_ERROR, -100, "offline engine auth failure,please check you offline auth params"),
    OFFLINE_ENGINE_CANCEL_FAILURE(ErrorType.OFFLINE_ENGINE_ERROR, ErrorConstant.ERROR_EXCEPTION, "offline engine cancel failure"),
    OFFLINE_ENGINE_DOWNLOAD_LICENSE_FAILED(ErrorType.OFFLINE_ENGINE_ERROR, ErrorConstant.ERROR_PARAM_ILLEGAL, "offline engine download license failure"),
    OFFLINE_ENGINE_AUTH_NULL(ErrorType.OFFLINE_ENGINE_ERROR, ErrorConstant.ERROR_REMOTE_CALL_FAIL, "offline engine auth authinfo is null"),
    OFFLINE_AUTH_INTERRUPTED_EXCEPTION(ErrorType.OFFLINE_ENGINE_ERROR, ErrorConstant.ERROR_ACCS_CUSTOM_FRAME_CB_NULL, "InterruptedException"),
    OFFLINE_AUTH_EXECUTION_EXCEPTION(ErrorType.OFFLINE_ENGINE_ERROR, -106, "ExecutionException"),
    OFFLINE_AUTH_TIMEOUT_EXCEPTION(ErrorType.OFFLINE_ENGINE_ERROR, -107, "TimeoutException"),
    OFFLINE_ENGINE_INIT_FAILED(ErrorType.OFFLINE_ENGINE_ERROR, ErrorConstant.ERROR_GET_PROCESS_NULL, "bdTTSEngineInit failed,please check you offline params"),
    OFFLINE_ENGINE_UNINITIALIZED(ErrorType.OFFLINE_ENGINE_ERROR, -109, "offline engine is uninitialized,please invoke initTts() method"),
    OFFLINE_ENGINE_CALL_EXCEPTION(ErrorType.OFFLINE_ENGINE_ERROR, -110, "offline engine call synthesize exception"),
    OFFLINE_ENGINE_SYNTHESIZE_ERROR(ErrorType.OFFLINE_ENGINE_ERROR, -111, "offline engine synthesize result not 0"),
    OFFLINE_ENGINE_AUTH_EXPIRED(ErrorType.OFFLINE_ENGINE_ERROR, -112, "offline engine auth verify expired,formal expired or temp expired"),
    OFFLINE_ENGINE_AUTH_PACKAGE_UNMATCH(ErrorType.OFFLINE_ENGINE_ERROR, -113, "package name is unmatch"),
    OFFLINE_ENGINE_AUTH_SIGN_UNMATCH(ErrorType.OFFLINE_ENGINE_ERROR, -114, "app sign is unmatch"),
    OFFLINE_ENGINE_AUTH_CUID_UNMATCH(ErrorType.OFFLINE_ENGINE_ERROR, -115, "devices cuid is unmatch"),
    OFFLINE_ENGINE_AUTH_PLATFORM_ERROR(ErrorType.OFFLINE_ENGINE_ERROR, -116, "platform is unmatch"),
    OFFLINE_ENGINE_AUTH_LICENSE_FILE_INVALID(ErrorType.OFFLINE_ENGINE_ERROR, -117, "license file not exist or file length is 0 (download license fail)"),
    OFFLINE_AUTH_CANCELLATION_EXCEPTION(ErrorType.ONLINE_ENGINE_ERROR, -118, "CancellationException"),
    OFFLINE_DOWNLOAD_LICENSE_INVALID_SN(ErrorType.OFFLINE_ENGINE_ERROR, -119, "download license failure,invalid SN"),
    MIX_ENGINE_AUTH_FAILURE(ErrorType.MIX_ERROR, -200, "both online and offline engine auth failue"),
    MIX_AUTH_INTERRUPTED_EXCEPTION(ErrorType.MIX_ERROR, ErrorConstant.ERROR_REQUEST_FAIL, "InterruptedException"),
    MIX_AUTH_EXECUTION_EXCEPTION(ErrorType.MIX_ERROR, ErrorConstant.ERROR_REQUEST_TIME_OUT, "ExecutionException"),
    MIX_AUTH_TIMEOUT_EXCEPTION(ErrorType.MIX_ERROR, ErrorConstant.ERROR_NO_STRATEGY, "TimeoutException"),
    MIX_ENGINE_OFFLINE_INIT_FAILURE(ErrorType.MIX_ERROR, ErrorConstant.ERROR_REQUEST_CANCEL, "mix engine initTTS, the offline init failure"),
    MIX_AUTH_CANCELLATION_EXCEPTION(ErrorType.MIX_ERROR, ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, "CancellationException"),
    TEXT_IS_EMPTY(ErrorType.TEXT, ErrorConstant.ERROR_TNET_EXCEPTION, "text is null or empty double quotation marks"),
    TEXT_IS_TOO_LONG(ErrorType.TEXT, ErrorConstant.ERROR_SESSION_INVALID, "text length in gbk is more than 120 ,the text is too long cut it short than 120"),
    TEXT_ENCODE_IS_WRONG(ErrorType.TEXT, ErrorConstant.ERROR_AUTH_EXCEPTION, "text encode is not gbk, please use gbk text"),
    TTS_UNINITIAL(ErrorType.TTS, ErrorConstant.ERROR_CONN_TIME_OUT, "tts has not been initialized,invoke in a wrong state"),
    TTS_MODE_ILLEGAL(ErrorType.TTS, ErrorConstant.ERROR_SOCKET_TIME_OUT, "tts mode unset or not the spechified value"),
    TTS_QUEUE_IS_FULL(ErrorType.TTS, ErrorConstant.ERROR_SSL_ERROR, "队列长度小于MAX_QUEUE_SIZE时才能加入合成队列"),
    TTS_LIST_IS_TOO_LONG(ErrorType.TTS, ErrorConstant.ERROR_HOST_NOT_VERIFY_ERROR, "list的size小于MAX_LIST_SIZE时才有效"),
    TTS_ENGINE_STOP_FAILURE(ErrorType.TTS, ErrorConstant.ERROR_IO_EXCEPTION, "引擎停止失败"),
    TTS_APP_ID_IS_INVALID(ErrorType.TTS, ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION, "app id is invalid,must be less than int(11)"),
    TTS_PARAMETER_INVALID(ErrorType.TTS, ErrorConstant.ERROR_CONNECT_EXCEPTION, "arguments of the method is invalid"),
    APP_RESOURCE_IS_NULL(ErrorType.APP, -500, "context was released or persistent app value is null"),
    PLAYER_IS_NULL(ErrorType.PLAYER, -600, "player is null"),
    MODEL_PARAMS_ERROR(ErrorType.MODEL, -1000, "params is wrong"),
    MODEL_REQUEST_ERROR(ErrorType.MODEL, g.b, "request error"),
    MODEL_SERVER_ERROR(ErrorType.MODEL, g.f7498c, "server error"),
    MODEL_DB_MODEL_INVALID(ErrorType.MODEL, g.f7499d, "model item in db is invalid(fileids is empty)"),
    MODEL_DB_MODEL_FILE_PATHS_INVALID(ErrorType.MODEL, g.f7500e, "model file in db is invalid(abspath is empty)"),
    MODEL_EXISTS(ErrorType.MODEL, g.f7501f, "this model exists(have downloaded success ever)"),
    MODEL_BAGS_EMPTY(ErrorType.MODEL, -1006, "can't get server model info,maybe modelid invalid or request failure"),
    MODEL_FILE_BAG_EMPTY(ErrorType.MODEL, -1007, "can't get server file info,maybe fileid invalid or request failure"),
    MODEL_CHECK_EXCEPTION(ErrorType.MODEL, -1008, "CheckWork exception happened"),
    MODEL_FILE_DOWNLOAD_EXCEPTION(ErrorType.MODEL, -1009, "exception happens when file downloadwork execute"),
    TTS_ERROR_UNKNOW(ErrorType.UNKNOW, g.f7503h, "unknow");

    private final int mId;
    private final String mMessage;
    private final ErrorType mType;

    public enum ErrorType {
        MIX_ERROR,
        ONLINE_ENGINE_ERROR,
        OFFLINE_ENGINE_ERROR,
        TEXT,
        TTS,
        APP,
        PLAYER,
        MODEL,
        UNKNOW
    }

    TtsErrorEnum(ErrorType errorType, int i2, String str) {
        this.mType = errorType;
        this.mId = i2;
        this.mMessage = str;
    }

    public int getId() {
        return this.mId;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public ErrorType getType() {
        return this.mType;
    }
}
