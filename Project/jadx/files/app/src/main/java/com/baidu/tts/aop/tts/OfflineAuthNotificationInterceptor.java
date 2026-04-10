package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.auth.AuthClient;
import com.baidu.tts.auth.OfflineAuth;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TtsEnum;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.param.TtsParams;
import com.baidu.tts.state.tts.Tts;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class OfflineAuthNotificationInterceptor extends AInterceptor {
    private static final String EXPIRED_NOTICE_TEXT_PREFIX = "百度语音试用服务已经到期，请及时更新授权，";
    private static final int NOTIFICATION_FREQUENCY = 20;
    private static final String PRE_NOTICE_TEXT_PREFIX = "百度语音试用服务%d天后到期，";
    private static final String TAG = "OfflineAuthNotificationInterceptor";
    private AtomicInteger mCount = new AtomicInteger(-1);

    /* JADX INFO: renamed from: com.baidu.tts.aop.tts.OfflineAuthNotificationInterceptor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$tts$enumtype$TtsEnum = new int[TtsEnum.values().length];

        static {
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsEnum[TtsEnum.MIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsEnum[TtsEnum.OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void addPrefixText(OfflineAuth.OfflineResult offlineResult, TextParams textParams) {
        if (offlineResult.isValidTemp()) {
            textParams.setTextPrefix(String.format(Locale.US, PRE_NOTICE_TEXT_PREFIX, Integer.valueOf(offlineResult.getLeftValidDays())));
        }
        if (offlineResult.isOfficialExpired()) {
            textParams.setTextPrefix(EXPIRED_NOTICE_TEXT_PREFIX);
        }
        textParams.buildSynthesizeText();
    }

    private Object handleOffline(Tts tts, TtsParams ttsParams, TextParams textParams) {
        addPrefixText(AuthClient.getInstance().authOffline(ttsParams.getOfflineSynthesizerParams()), textParams);
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.AInterceptor
    protected Object handleBefore(Object obj, Method method, Object[] objArr) {
        Tts tts = (Tts) obj;
        if (!tts.isInitialized()) {
            tts.errorUninitial();
            return AInterceptorHandler.END;
        }
        TtsEnum mode = tts.getMode();
        if (mode == null) {
            tts.errorUninitial();
            return AInterceptorHandler.END;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$tts$enumtype$TtsEnum[mode.ordinal()];
        if (i2 == 1 || i2 == 2) {
            int iIncrementAndGet = this.mCount.incrementAndGet();
            LoggerProxy.d(TAG, "currentCount=" + iIncrementAndGet);
            if (iIncrementAndGet % 20 == 0) {
                TextParams textParams = (TextParams) objArr[0];
                TtsParams ttsParams = tts.getTtsParams();
                if (ttsParams != null) {
                    return handleOffline(tts, ttsParams, textParams);
                }
                tts.errorUninitial();
                return AInterceptorHandler.END;
            }
        }
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.AInterceptor
    protected void registerInterceptMethods() {
        this.mInterceptMethods.add("speak");
    }
}
