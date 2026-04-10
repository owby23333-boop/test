package com.baidu.tts.auth;

import com.baidu.tts.auth.OfflineAuth;
import com.baidu.tts.auth.OnlineAuth;
import com.baidu.tts.bridge.engine.synthesizer.OfflineSynthesizer;
import com.baidu.tts.bridge.engine.synthesizer.OnlineSynthesizer;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.enumtype.TtsEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.flyweight.persistent.AppPersistentValueFlyweight;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.memorizer.Memorizer;
import com.baidu.tts.param.AllSynthesizerParams;
import com.baidu.tts.param.TtsParams;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class AuthClient {
    private static final String TAG = "AuthClient";
    private static volatile AuthClient mInstance;
    private Memorizer<OnlineAuth, OnlineAuth.OnlineResult> mOnlineMemorizer = new Memorizer<>();
    private Memorizer<OfflineAuth, OfflineAuth.OfflineResult> mOfflineMemorizer = new Memorizer<>();

    /* JADX INFO: renamed from: com.baidu.tts.auth.AuthClient$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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

    private class OfflineWork implements Callable<OfflineAuth.OfflineResult> {
        private OfflineSynthesizer.OfflineSynthesizerParams mParams;

        public OfflineWork(OfflineSynthesizer.OfflineSynthesizerParams offlineSynthesizerParams) {
            this.mParams = offlineSynthesizerParams;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public OfflineAuth.OfflineResult call() throws Exception {
            OfflineAuth.OfflineResult offlineResult = new OfflineAuth.OfflineResult();
            AppPersistentValueFlyweight appPersistentValueFlyweight = PersistentPool.getInstance().getAppPersistentValueFlyweight();
            if (appPersistentValueFlyweight == null) {
                offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.APP_RESOURCE_IS_NULL));
                return offlineResult;
            }
            String appCode = this.mParams.getAppCode();
            String authSN = this.mParams.getAuthSN();
            String ttsLicenseFilePath = this.mParams.getTtsLicenseFilePath();
            if (StringTool.isEmpty(ttsLicenseFilePath) || !new File(ttsLicenseFilePath).exists()) {
                ttsLicenseFilePath = appPersistentValueFlyweight.getDefaultLicenseFilePath();
            }
            LoggerProxy.d(AuthClient.TAG, "appCode=" + appCode + " SN=" + authSN);
            StringBuilder sb = new StringBuilder();
            sb.append("licenseFilePath=");
            sb.append(ttsLicenseFilePath);
            LoggerProxy.d(AuthClient.TAG, sb.toString());
            OfflineAuth offlineAuth = new OfflineAuth();
            offlineAuth.setAuthSN(authSN);
            offlineAuth.setAppCode(appCode);
            offlineAuth.setLicenseFilePath(ttsLicenseFilePath);
            return (OfflineAuth.OfflineResult) AuthClient.this.mOfflineMemorizer.memory(offlineAuth);
        }
    }

    private class OnlineWork implements Callable<OnlineAuth.OnlineResult> {
        private OnlineSynthesizer.OnlineSynthesizerParams mParams;

        public OnlineWork(OnlineSynthesizer.OnlineSynthesizerParams onlineSynthesizerParams) {
            this.mParams = onlineSynthesizerParams;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public OnlineAuth.OnlineResult call() throws Exception {
            String productId = this.mParams.getProductId();
            String apiKey = this.mParams.getApiKey();
            String secretKey = this.mParams.getSecretKey();
            String key = this.mParams.getKey();
            String requestProtocol = this.mParams.getRequestProtocol();
            LoggerProxy.d(AuthClient.TAG, "pid=" + productId);
            LoggerProxy.d(AuthClient.TAG, "key=" + key);
            LoggerProxy.d(AuthClient.TAG, "ak=" + apiKey);
            LoggerProxy.d(AuthClient.TAG, "sk=" + secretKey);
            OnlineAuth onlineAuth = new OnlineAuth();
            onlineAuth.setProductId(productId);
            onlineAuth.setApiKey(apiKey);
            onlineAuth.setSecretKey(secretKey);
            onlineAuth.setRequestProtocol(requestProtocol);
            return (OnlineAuth.OnlineResult) AuthClient.this.mOnlineMemorizer.memory(onlineAuth);
        }
    }

    private AuthClient() {
    }

    private <T> FutureTask<T> executeTask(Callable<T> callable) {
        FutureTask<T> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.setName("bdtts-AuthClient");
        thread.start();
        return futureTask;
    }

    private <T> T executeTaskAndGet(Callable<T> callable, long j2) throws ExecutionException, InterruptedException, TimeoutException {
        return executeTask(callable).get(j2, TimeUnit.MILLISECONDS);
    }

    public static AuthClient getInstance() {
        if (mInstance == null) {
            synchronized (AuthClient.class) {
                if (mInstance == null) {
                    mInstance = new AuthClient();
                }
            }
        }
        return mInstance;
    }

    public AuthInfo auth(TtsEnum ttsEnum, TtsParams ttsParams) {
        AllSynthesizerParams engineParams = ttsParams.getEngineParams();
        AuthInfo authInfo = new AuthInfo();
        authInfo.setTtsEnum(ttsEnum);
        int i2 = AnonymousClass3.$SwitchMap$com$baidu$tts$enumtype$TtsEnum[ttsEnum.ordinal()];
        if (i2 == 1) {
            authInfo.setOnlineResult(authOnline(engineParams.getOnlineSynthesizerParams()));
            return authInfo;
        }
        if (i2 != 2) {
            return i2 != 3 ? authInfo : authMix(engineParams);
        }
        authInfo.setOfflineResult(authOffline(engineParams.getOfflineSynthesizerParams()));
        return authInfo;
    }

    public AuthInfo authMix(final AllSynthesizerParams allSynthesizerParams) {
        LoggerProxy.d(TAG, "enter authMix");
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        FutureTask futureTask = new FutureTask(new Callable<OnlineAuth.OnlineResult>() { // from class: com.baidu.tts.auth.AuthClient.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public OnlineAuth.OnlineResult call() throws Exception {
                try {
                    return AuthClient.this.authOnline(allSynthesizerParams.getOnlineSynthesizerParams());
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        FutureTask futureTask2 = new FutureTask(new Callable<OfflineAuth.OfflineResult>() { // from class: com.baidu.tts.auth.AuthClient.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public OfflineAuth.OfflineResult call() throws Exception {
                try {
                    return AuthClient.this.authOffline(allSynthesizerParams.getOfflineSynthesizerParams());
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        Thread thread = new Thread(futureTask);
        thread.setName("bdtts-onlineThread");
        thread.start();
        Thread thread2 = new Thread(futureTask2);
        thread2.setName("bdtts-offlineThread");
        thread2.start();
        try {
            LoggerProxy.d(TAG, "+ await");
            countDownLatch.await();
            LoggerProxy.d(TAG, "- await");
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            futureTask2.cancel(true);
        }
        OnlineAuth.OnlineResult onlineResult = new OnlineAuth.OnlineResult();
        LoggerProxy.d(TAG, "+ mix online get onlineResult=" + onlineResult);
        try {
            onlineResult = (OnlineAuth.OnlineResult) futureTask.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_AUTH_INTERRUPTED_EXCEPTION, e2));
        } catch (CancellationException e3) {
            onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_AUTH_CANCELLATION_EXCEPTION, e3));
        } catch (ExecutionException e4) {
            onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_AUTH_EXECUTION_EXCEPTION, e4.getCause()));
        }
        LoggerProxy.d(TAG, "- online get");
        OfflineAuth.OfflineResult offlineResult = new OfflineAuth.OfflineResult();
        LoggerProxy.d(TAG, "+ mix offline get offlineResult=" + offlineResult);
        try {
            offlineResult = (OfflineAuth.OfflineResult) futureTask2.get();
        } catch (InterruptedException e5) {
            Thread.currentThread().interrupt();
            futureTask2.cancel(true);
            offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_AUTH_INTERRUPTED_EXCEPTION, e5));
        } catch (CancellationException e6) {
            offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_AUTH_CANCELLATION_EXCEPTION, e6));
        } catch (ExecutionException e7) {
            offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_AUTH_EXECUTION_EXCEPTION, e7.getCause()));
        }
        LoggerProxy.d(TAG, "- offline get");
        AuthInfo authInfo = new AuthInfo();
        authInfo.setTtsEnum(TtsEnum.MIX);
        authInfo.setOnlineResult(onlineResult);
        authInfo.setOfflineResult(offlineResult);
        LoggerProxy.d(TAG, "end authMix");
        return authInfo;
    }

    public OfflineAuth.OfflineResult authOffline(OfflineSynthesizer.OfflineSynthesizerParams offlineSynthesizerParams) {
        OfflineAuth.OfflineResult offlineResult = new OfflineAuth.OfflineResult();
        try {
            return (OfflineAuth.OfflineResult) executeTaskAndGet(new OfflineWork(offlineSynthesizerParams), TimeOutEnum.DEFAULT.getMillSeconds());
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_AUTH_INTERRUPTED_EXCEPTION, e2));
            return offlineResult;
        } catch (CancellationException e3) {
            offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_AUTH_CANCELLATION_EXCEPTION, e3));
            return offlineResult;
        } catch (ExecutionException e4) {
            offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_AUTH_EXECUTION_EXCEPTION, e4.getCause()));
            return offlineResult;
        } catch (TimeoutException e5) {
            offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_AUTH_TIMEOUT_EXCEPTION, e5));
            return offlineResult;
        }
    }

    public OnlineAuth.OnlineResult authOnline(OnlineSynthesizer.OnlineSynthesizerParams onlineSynthesizerParams) {
        OnlineAuth.OnlineResult onlineResult = new OnlineAuth.OnlineResult();
        try {
            return (OnlineAuth.OnlineResult) executeTaskAndGet(new OnlineWork(onlineSynthesizerParams), TimeOutEnum.DEFAULT.getMillSeconds());
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_AUTH_INTERRUPTED_EXCEPTION, e2));
            return onlineResult;
        } catch (CancellationException e3) {
            onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_AUTH_CANCELLATION_EXCEPTION, e3));
            return onlineResult;
        } catch (ExecutionException e4) {
            onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_AUTH_EXECUTION_EXCEPTION, e4.getCause()));
            return onlineResult;
        } catch (TimeoutException e5) {
            onlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_AUTH_TIMEOUT_EXCEPTION, e5));
            return onlineResult;
        }
    }

    public void clear() {
        Memorizer<OnlineAuth, OnlineAuth.OnlineResult> memorizer = this.mOnlineMemorizer;
        if (memorizer != null) {
            memorizer.clear();
        }
        Memorizer<OfflineAuth, OfflineAuth.OfflineResult> memorizer2 = this.mOfflineMemorizer;
        if (memorizer2 != null) {
            memorizer2.clear();
        }
    }
}
