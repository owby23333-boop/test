package com.baidu.tts.auth;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.OfflineAuth;
import com.baidu.tts.auth.OnlineAuth;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TtsEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;

/* JADX INFO: loaded from: classes2.dex */
public class AuthInfo {
    private static final String TAG = "AuthInfo";
    private OfflineAuth.OfflineResult mOfflineResult;
    private OnlineAuth.OnlineResult mOnlineResult;
    private TtsEnum mTtsEnum;
    private TtsError mTtsError;

    /* JADX INFO: renamed from: com.baidu.tts.auth.AuthInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$tts$enumtype$TtsEnum = new int[TtsEnum.values().length];

        static {
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsEnum[TtsEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsEnum[TtsEnum.OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsEnum[TtsEnum.MIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public int getLeftValidDays() {
        return this.mOfflineResult.getLeftValidDays();
    }

    public TtsError getMixTtsError() {
        TtsError onlineTtsError = getOnlineTtsError();
        TtsError offlineTtsError = getOfflineTtsError();
        TtsError ttsError = (onlineTtsError == null || offlineTtsError == null) ? (onlineTtsError != null || offlineTtsError == null) ? (onlineTtsError == null || offlineTtsError != null) ? null : TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_AUTH_FAILURE) : TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_ENGINE_AUTH_FAILURE) : TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MIX_ENGINE_AUTH_FAILURE);
        return ttsError != null ? ttsError : this.mTtsError;
    }

    public String getNotifyMessage() {
        return this.mOfflineResult.getNotifyMessage();
    }

    public OfflineAuth.OfflineResult getOfflineResult() {
        return this.mOfflineResult;
    }

    public TtsError getOfflineTtsError() {
        OfflineAuth.OfflineResult offlineResult = this.mOfflineResult;
        return offlineResult != null ? offlineResult.getError() : this.mTtsError;
    }

    public OnlineAuth.OnlineResult getOnlineResult() {
        return this.mOnlineResult;
    }

    public TtsError getOnlineTtsError() {
        OnlineAuth.OnlineResult onlineResult = this.mOnlineResult;
        return onlineResult != null ? onlineResult.getError() : this.mTtsError;
    }

    public TtsEnum getTtsEnum() {
        return this.mTtsEnum;
    }

    public TtsError getTtsError() {
        TtsError ttsError = this.mTtsError;
        if (ttsError != null) {
            return ttsError;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$tts$enumtype$TtsEnum[this.mTtsEnum.ordinal()];
        if (i2 == 1) {
            return this.mOnlineResult.getError();
        }
        if (i2 == 2) {
            return this.mOfflineResult.getError();
        }
        if (i2 != 3) {
            return null;
        }
        return getMixTtsError();
    }

    public boolean isMixSuccess() {
        return isOnlineSuccess() || isOfflineSuccess();
    }

    public boolean isOfflineSuccess() {
        OfflineAuth.OfflineResult offlineResult = this.mOfflineResult;
        if (offlineResult != null) {
            return offlineResult.isValid();
        }
        return false;
    }

    public boolean isOnlineSuccess() {
        OnlineAuth.OnlineResult onlineResult = this.mOnlineResult;
        if (onlineResult != null) {
            return onlineResult.isValid();
        }
        return false;
    }

    public boolean isSuccess() {
        if (this.mTtsError != null) {
            LoggerProxy.d(TAG, "cause=" + this.mTtsError.getThrowable().getMessage());
            return false;
        }
        TtsEnum ttsEnum = this.mTtsEnum;
        if (ttsEnum == null) {
            return false;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$tts$enumtype$TtsEnum[ttsEnum.ordinal()];
        if (i2 == 1) {
            return isOnlineSuccess();
        }
        if (i2 == 2) {
            return isOfflineSuccess();
        }
        if (i2 != 3) {
            return false;
        }
        return isMixSuccess();
    }

    public void setOfflineResult(OfflineAuth.OfflineResult offlineResult) {
        this.mOfflineResult = offlineResult;
    }

    public void setOnlineResult(OnlineAuth.OnlineResult onlineResult) {
        this.mOnlineResult = onlineResult;
    }

    public void setTtsEnum(TtsEnum ttsEnum) {
        this.mTtsEnum = ttsEnum;
    }

    public void setTtsError(TtsError ttsError) {
        this.mTtsError = ttsError;
    }
}
