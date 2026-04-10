package com.baidu.tts.auth;

import android.content.Context;
import com.anythink.expressad.exoplayer.i.a;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.emstatistics.StatThread;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.memorizer.IMResult;
import com.baidu.tts.memorizer.IMemorizable;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class OfflineAuth implements IMemorizable<OfflineAuth, OfflineResult> {
    private static final String TAG = "OfflineAuth";
    private String mAppCode;
    private String mAuthSN;
    private String mLicenseFilePath;

    public static class OfflineResult implements IMResult {
        private static final int CODE_TEMP_LICENSE_MIN = 10000;
        private static final int CODE_VERIFY_OK_MIN = 0;
        private static final int CUID_UNMATCH = -4;
        private static final int INVALID_LICENSE = -8;
        private static final int OFFICIAL_LICENSE_EXPIRED = -5;
        private static final int PACKAGE_NAME_UNMATCH = -2;
        private static final int PLATFORM_UNMATCH = -7;
        private static final int SIGN_OR_CODE_UNMATCH = -3;
        private static final int TEMP_LICENSE_EXPIRED = -10;
        private static final int WILL_EXPIRED_AFTER_A_MONTH = -6;
        private String mAppId;
        private String mAuthSN;
        private int mDownloadLicenseResult = -1;
        private TtsError mError;
        private String mLicenseFilePath;
        private int mVerifyResult;

        public String getAppId() {
            return this.mAppId;
        }

        public String getAuthSN() {
            return this.mAuthSN;
        }

        public int getDownloadLicenseResult() {
            return this.mDownloadLicenseResult;
        }

        public TtsError getError() {
            return this.mError;
        }

        public int getLeftValidDays() {
            int i2 = this.mVerifyResult;
            if (i2 >= 10000) {
                return i2 - 10000;
            }
            return 0;
        }

        public String getLicenseFilePath() {
            return this.mLicenseFilePath;
        }

        public String getNotifyMessage() {
            if (isValidOfficial()) {
                return "valid official";
            }
            if (isValidTemp()) {
                return "valid temp";
            }
            switch (this.mVerifyResult) {
                case -10:
                    return "temp license expired";
                case -9:
                default:
                    return "not a valid result";
                case -8:
                    return "license not exist or invalid license";
                case -7:
                    return "platform unmatched";
                case -6:
                    return "will expire after a month";
                case -5:
                    return "official license expired";
                case -4:
                    return "cuid unmatched";
                case -3:
                    return "sign or appcode unmatched";
                case -2:
                    return "package name unmatched";
            }
        }

        public int getVerifyResult() {
            return this.mVerifyResult;
        }

        public boolean isOfficialExpired() {
            int i2 = this.mVerifyResult;
            return i2 == -5 || i2 == -6;
        }

        @Override // com.baidu.tts.memorizer.IMResult
        public boolean isValid() {
            if (StringTool.isEmpty(this.mLicenseFilePath) || !new File(this.mLicenseFilePath).exists()) {
                return false;
            }
            PersistentPool persistentPool = PersistentPool.getInstance();
            Context context = persistentPool.getContext();
            String deviceId = persistentPool.getDeviceId();
            byte[] bArr = new byte[128];
            LoggerProxy.d(OfflineAuth.TAG, "verify license before ");
            this.mVerifyResult = EmbeddedSynthesizerEngine.bdTTSVerifyLicense(context, this.mAppId, deviceId, this.mAuthSN, this.mLicenseFilePath, bArr);
            LoggerProxy.d(OfflineAuth.TAG, "verify result=" + this.mVerifyResult);
            LoggerProxy.d(OfflineAuth.TAG, "get appIdStr=" + new String(bArr));
            if (this.mVerifyResult < 0) {
                return false;
            }
            try {
                new StatThread(context, this.mAppId).start();
                return true;
            } catch (Exception e2) {
                LoggerProxy.d(OfflineAuth.TAG, "embedded statistics start exception=" + e2.toString());
                return true;
            }
        }

        public boolean isValidOfficial() {
            int i2 = this.mVerifyResult;
            return i2 >= 0 && i2 < 10000;
        }

        public boolean isValidTemp() {
            return this.mVerifyResult >= 10000;
        }

        public void setAppId(String str) {
            this.mAppId = str;
        }

        public void setAuthSN(String str) {
            this.mAuthSN = str;
        }

        public void setDownloadLicenseResult(int i2) {
            this.mDownloadLicenseResult = i2;
        }

        public void setError(TtsError ttsError) {
            if (ttsError != null) {
                LoggerProxy.d(OfflineAuth.TAG, "this=" + this + "--error=" + ttsError.getDetailMessage());
            }
            this.mError = ttsError;
        }

        public void setLicenseFilePath(String str) {
            this.mLicenseFilePath = str;
        }

        public void setVerifyResult(int i2) {
            this.mVerifyResult = i2;
        }
    }

    public String getAppCode() {
        return this.mAppCode;
    }

    public String getAuthSN() {
        return this.mAuthSN;
    }

    public String getLicenseFilePath() {
        return this.mLicenseFilePath;
    }

    public void setAppCode(String str) {
        this.mAppCode = str;
    }

    public void setAuthSN(String str) {
        this.mAuthSN = str;
    }

    public void setLicenseFilePath(String str) {
        this.mLicenseFilePath = str;
    }

    @Override // java.util.concurrent.Callable
    public OfflineResult call() throws Exception {
        OfflineResult offlineResult = new OfflineResult();
        offlineResult.setLicenseFilePath(this.mLicenseFilePath);
        offlineResult.setAppId(this.mAppCode);
        offlineResult.setAuthSN(this.mAuthSN);
        if (!offlineResult.isValid()) {
            Context context = PersistentPool.getInstance().getContext();
            LoggerProxy.d(TAG, "+ downloadLicense");
            long j2 = SharedPreferencesUtils.getLong(context, "getLicense_expires", 0L);
            long j3 = SharedPreferencesUtils.getLong(context, "getLicense_time", 0L);
            int iIntValue = -1;
            int i2 = SharedPreferencesUtils.getInt(context, "getLicense_err_no", -1);
            String string = SharedPreferencesUtils.getString(context, "SN", "");
            long jCurrentTimeMillis = System.currentTimeMillis() - j3;
            if (string.equals(this.mAuthSN) && ((i2 == -1006 || i2 == -1007 || i2 == -1008 || i2 == -1011) && jCurrentTimeMillis <= 86400000)) {
                offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_DOWNLOAD_LICENSE_INVALID_SN, -1, "appCode=" + this.mAppCode + "--licensePath=" + this.mLicenseFilePath + " SN=" + this.mAuthSN));
                return offlineResult;
            }
            if (jCurrentTimeMillis > j2) {
                try {
                    FutureTask futureTask = new FutureTask(new GetTtsLicenseWork(context, this.mAppCode, this.mLicenseFilePath, this.mAuthSN));
                    new Thread(futureTask).start();
                    iIntValue = ((Integer) futureTask.get(a.f9492f, TimeUnit.MILLISECONDS)).intValue();
                } catch (InterruptedException e2) {
                    LoggerProxy.d(TAG, e2.toString());
                } catch (ExecutionException e3) {
                    LoggerProxy.d(TAG, e3.getCause().toString());
                } catch (TimeoutException e4) {
                    LoggerProxy.d(TAG, e4.toString());
                }
            }
            LoggerProxy.d(TAG, "- downloadLicense ret = " + iIntValue);
            offlineResult.setDownloadLicenseResult(iIntValue);
            if (iIntValue < 0) {
                offlineResult.setError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_ENGINE_DOWNLOAD_LICENSE_FAILED, iIntValue, "appCode=" + this.mAppCode + "--licensePath=" + this.mLicenseFilePath));
            } else {
                offlineResult.isValid();
            }
        }
        return offlineResult;
    }

    @Override // java.lang.Comparable
    public int compareTo(OfflineAuth offlineAuth) {
        return (StringTool.isEqual(this.mAppCode, offlineAuth.getAppCode()) && StringTool.isEqual(this.mLicenseFilePath, offlineAuth.getLicenseFilePath())) ? 0 : 1;
    }
}
