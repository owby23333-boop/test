package com.iflytek.aikit.media.speech;

import com.alibaba.android.arouter.utils.Consts;
import com.iflytek.aikit.media.resource.Resource;
import com.iflytek.aikit.utils.constants.ErrorCode;

/* JADX INFO: loaded from: classes7.dex */
public class SpeechError extends Exception {
    protected static final int TIP_ENGINE_NOT_INSTALLED = 29;
    public static final int TIP_ERROR_ALREADY_EXIST = 66;
    protected static final int TIP_ERROR_AUDIO_RECORD = 9;
    public static final int TIP_ERROR_AUTHID_NOT_AVAILABLE = 71;
    protected static final int TIP_ERROR_BROWSER_NOT_INSTALLED = 26;
    protected static final int TIP_ERROR_CLIENT = 8;
    protected static final int TIP_ERROR_EMPTY_UTTERANCE = 13;
    protected static final int TIP_ERROR_ENGINE_INIT_FAIL = 28;
    protected static final int TIP_ERROR_EXIST_UNLISTED_WORD = 42;
    protected static final int TIP_ERROR_FACE_IMAGE_FULL_LEFT = 44;
    protected static final int TIP_ERROR_FACE_IMAGE_FULL_RIGHT = 45;
    protected static final int TIP_ERROR_FACE_INVALID_MODEL = 51;
    protected static final int TIP_ERROR_FACE_OCCULTATION = 50;
    protected static final int TIP_ERROR_FILE_ACCESS = 14;
    protected static final int TIP_ERROR_FUSION_ENOUGH_DATA = 54;
    protected static final int TIP_ERROR_FUSION_INVALID_INPUT_TYPE = 52;
    protected static final int TIP_ERROR_FUSION_NO_ENOUGH_DATA = 53;
    public static final int TIP_ERROR_GROUP_EMPTY = 68;
    protected static final int TIP_ERROR_ILLUMINATION = 49;
    protected static final int TIP_ERROR_IMAGE_CLOCKWISE_WHIRL = 46;
    protected static final int TIP_ERROR_IMAGE_COUNTET_CLOCKWISE_WHIRL = 47;
    protected static final int TIP_ERROR_INSUFFICIENT_PERMISSIONS = 4;
    protected static final int TIP_ERROR_INTERRUPT = 27;
    protected static final int TIP_ERROR_INVALID_DATA = 20;
    protected static final int TIP_ERROR_INVALID_ENCODING = 12;
    protected static final int TIP_ERROR_INVALID_GRAMMAR = 21;
    protected static final int TIP_ERROR_INVALID_LOCAL_RESOURCE = 22;
    protected static final int TIP_ERROR_INVALID_PARAM = 7;
    protected static final int TIP_ERROR_INVALID_RESULT = 5;
    protected static final int TIP_ERROR_IN_USE = 19;
    public static final int TIP_ERROR_IVP_EXTRA_RGN_SOPPORT = 56;
    public static final int TIP_ERROR_IVP_GENERAL = 55;
    public static final int TIP_ERROR_IVP_MUCH_NOISE = 58;
    public static final int TIP_ERROR_IVP_NO_ENOUGH_AUDIO = 63;
    public static final int TIP_ERROR_IVP_TEXT_NOT_MATCH = 62;
    public static final int TIP_ERROR_IVP_TOO_LOW = 59;
    public static final int TIP_ERROR_IVP_TRUNCATED = 57;
    public static final int TIP_ERROR_IVP_UTTER_TOO_SHORT = 61;
    public static final int TIP_ERROR_IVP_ZERO_AUDIO = 60;
    protected static final int TIP_ERROR_LOGIN = 18;
    protected static final int TIP_ERROR_LOGIN_INVALID_PWD = 24;
    protected static final int TIP_ERROR_LOGIN_INVALID_USER = 23;
    protected static final int TIP_ERROR_MEMORY_WRANING = 16;
    public static final int TIP_ERROR_MODEL_IS_CREATING = 65;
    public static final int TIP_ERROR_MODEL_NOT_FOUND = 64;
    protected static final int TIP_ERROR_NET_EXPECTION = 3;
    protected static final int TIP_ERROR_NOISY_OR_SHORT_AUDIO = 36;
    protected static final int TIP_ERROR_NOT_FACE_IMAGE = 43;
    protected static final int TIP_ERROR_NOT_PAPER_DATA = 37;
    protected static final int TIP_ERROR_NO_CONTENT = 34;
    public static final int TIP_ERROR_NO_GROUP = 67;
    protected static final int TIP_ERROR_NO_MATCH = 10;
    protected static final int TIP_ERROR_NO_PICTURE = 33;
    public static final int TIP_ERROR_NO_USER = 69;
    protected static final int TIP_ERROR_OTHER_DATA_EXCEPTION = 40;
    public static final int TIP_ERROR_OVERFLOW_IN_GROUP = 70;
    protected static final int TIP_ERROR_PERMISSION_DENIED = 25;
    protected static final int TIP_ERROR_PLAY_MEDIA = 15;
    protected static final int TIP_ERROR_SERVER_CONNECT = 6;
    protected static final int TIP_ERROR_SILENT_OR_LOW_VOLUME = 35;
    protected static final int TIP_ERROR_SPEECH_TIMEOUT = 11;
    protected static final int TIP_ERROR_TEXT_OVERFLOW = 17;
    protected static final int TIP_ERROR_VALID_IMAGE_SIZE = 48;
    protected static final int TIP_ERROR_WRONG_AUDIO_FORMAT = 39;
    protected static final int TIP_ERROR_WRONG_PAPER_CONTENT = 38;
    protected static final int TIP_ERROR_WRONG_PAPER_FORMAT = 41;
    protected static final int TIP_INVALID_AUTHORIZATION = 32;
    protected static final int TIP_LOCAL_ENGINE_ERROR = 30;
    protected static final int TIP_NO_NETWORK = 1;
    protected static final int TIP_RESULT_TIMEOUT = 2;
    protected static final int TIP_SCRIPT_ERROR = 31;
    private static final long serialVersionUID = 4434424251478985596L;
    private String mDescription;
    private int mErrorCode;

    public SpeechError(Exception exc) {
        this.mDescription = "";
        this.mErrorCode = ErrorCode.ERROR_UNKNOWN;
        this.mDescription = exc.toString();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDescription() {
        return this.mDescription;
    }

    public String getHtmlDescription(boolean z) {
        String str = this.mDescription + "...";
        if (!z) {
            return str;
        }
        return ((str + "<br>(") + Resource.getErrorTag(0) + ":") + this.mErrorCode + ")";
    }

    public String getPlainDescription(boolean z) {
        String str = this.mDescription;
        if (!z) {
            return str;
        }
        return ((str + Consts.DOT) + "(" + Resource.getErrorTag(0) + ":") + this.mErrorCode + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getPlainDescription(true);
    }

    public SpeechError(Throwable th, int i) {
        this(i);
        initCause(th);
    }

    public SpeechError(int i, String str) {
        this(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SpeechError(int r9) {
        /*
            Method dump skipped, instruction units count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.aikit.media.speech.SpeechError.<init>(int):void");
    }
}
