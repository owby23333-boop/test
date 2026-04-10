package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.account.privacy_data.master.PrivacyDataMaster;
import com.xiaomi.account.privacy_data.master.PrivacyDataType;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.hasheddeviceidlib.PlainDeviceIdUtil;
import com.xiaomi.accountsdk.utils.AccountLogger;
import com.xiaomi.passport.accountmanager.XiaomiAccountManager;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes5.dex */
public class HashedDeviceIdUtil {
    private static final String ANDROID_ID_PREFIX = "an_";
    private static final String OAID_PREFIX = "oa_";
    private static final String PSEUDO_DEVICE_ID_PREFIX = "android_";
    private static final String SP_KEY_HASHED_DEVICE_ID = "hashedDeviceId";
    private static final String SP_NAME_DEVICE_ID = "deviceId";
    private static final String TAG = "HashedDeviceIdUtil";
    private static final ExecutorService sExecutorService = Executors.newCachedThreadPool();
    private final Context context;
    private final PlainDeviceIdUtil.IPlainDeviceIdFetcher plainDeviceIdFetcher;

    public enum DeviceIdPolicy {
        RUNTIME_DEVICE_ID_ONLY,
        CACHED_THEN_RUNTIME_THEN_PSEUDO
    }

    public static class GlobalConfig {
        public static DeviceIdPolicy DEFAULT_DEVICE_ID_POLICY = DeviceIdPolicy.RUNTIME_DEVICE_ID_ONLY;
        private static final GlobalConfig sInstance = new GlobalConfig();
        private DeviceIdPolicy policy = DEFAULT_DEVICE_ID_POLICY;
        private IUnifiedDeviceIdFetcher unifiedDeviceIdFetcher;

        private GlobalConfig() {
        }

        public static GlobalConfig getInstance() {
            return sInstance;
        }

        public IUnifiedDeviceIdFetcher getUnifiedDeviceIdFetcher() {
            return this.unifiedDeviceIdFetcher;
        }

        public void setUnifiedDeviceIdFetcher(IUnifiedDeviceIdFetcher iUnifiedDeviceIdFetcher) {
            this.unifiedDeviceIdFetcher = iUnifiedDeviceIdFetcher;
        }

        public void setupPolicy(Context context) {
            this.policy = XiaomiAccountManager.isSystemXiaomiAccountApp(context) ? DeviceIdPolicy.RUNTIME_DEVICE_ID_ONLY : DeviceIdPolicy.CACHED_THEN_RUNTIME_THEN_PSEUDO;
        }
    }

    public HashedDeviceIdUtil(Context context) {
        this(context, PlainDeviceIdUtil.getFetcherInstance());
    }

    public static void clearLocalDeviceId(Context context) {
        AccountLogger.log(TAG, "clearLocalDeviceId>>>");
        context.getSharedPreferences("deviceId", 0).edit().clear().apply();
    }

    private static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private String truncateAndSaveHistoricalId(String str) {
        String strTruncateIfNecessary = truncateIfNecessary(str);
        saveHistoricalHashedDeviceId(strTruncateIfNecessary);
        return strTruncateIfNecessary;
    }

    private String truncateIfNecessary(String str) {
        return (str == null || str.length() <= 128) ? str : str.substring(0, 128);
    }

    public String createPseudoDeviceId() {
        return String.format("%s%s", PSEUDO_DEVICE_ID_PREFIX, UUID.randomUUID().toString());
    }

    public synchronized String getHashedDeviceId(boolean z) {
        DeviceIdPolicy deviceIdPolicyPolicy = policy();
        if (deviceIdPolicyPolicy == DeviceIdPolicy.RUNTIME_DEVICE_ID_ONLY) {
            return truncateIfNecessary(getRuntimeDeviceIdHashed());
        }
        if (deviceIdPolicyPolicy != DeviceIdPolicy.CACHED_THEN_RUNTIME_THEN_PSEUDO) {
            AccountLogger.log(TAG, "getHashedDeviceId>>>bad policy");
            throw new IllegalStateException("unknown policy " + deviceIdPolicyPolicy);
        }
        String strLoadHistoricalHashedDeviceId = loadHistoricalHashedDeviceId();
        if (!TextUtils.isEmpty(strLoadHistoricalHashedDeviceId)) {
            return truncateIfNecessary(strLoadHistoricalHashedDeviceId);
        }
        String runtimeDeviceIdHashed = getRuntimeDeviceIdHashed();
        if (runtimeDeviceIdHashed != null) {
            AccountLogger.log(TAG, "getHashedDeviceId>>>get runtime device id");
            return truncateAndSaveHistoricalId(runtimeDeviceIdHashed);
        }
        boolean zIsMainThread = isMainThread();
        if (z && !zIsMainThread) {
            IUnifiedDeviceIdFetcher unifiedDeviceIdFetcher = GlobalConfig.getInstance().getUnifiedDeviceIdFetcher();
            boolean z2 = unifiedDeviceIdFetcher != null;
            AccountLogger.log(TAG, "getHashedDeviceId>>>hasFetcher=" + z2);
            if (z2) {
                String hashedDeviceId = unifiedDeviceIdFetcher.getHashedDeviceId(this.context);
                if (!TextUtils.isEmpty(hashedDeviceId)) {
                    AccountLogger.log(TAG, "getHashedDeviceId>>>use inheritedDeviceId");
                    return truncateAndSaveHistoricalId(hashedDeviceId);
                }
            }
        } else if (zIsMainThread) {
            AccountLogger.log(TAG, "in main thread get deviceId", new Exception());
        }
        String str = PrivacyDataMaster.get(this.context, PrivacyDataType.OAID, new String[0]);
        if (!TextUtils.isEmpty(str)) {
            AccountLogger.log(TAG, "getHashedDeviceId>>>use oaid");
            return truncateAndSaveHistoricalId(OAID_PREFIX + DeviceIDCloudCoder.getDataMd5Digest(str.getBytes()));
        }
        String str2 = PrivacyDataMaster.get(this.context, PrivacyDataType.ANDROID_ID, new String[0]);
        if (TextUtils.isEmpty(str2)) {
            String strCreatePseudoDeviceId = createPseudoDeviceId();
            AccountLogger.log(TAG, "getHashedDeviceId>>>use newone");
            return truncateAndSaveHistoricalId(strCreatePseudoDeviceId);
        }
        AccountLogger.log(TAG, "getHashedDeviceId>>>use androidID");
        return truncateAndSaveHistoricalId(ANDROID_ID_PREFIX + DeviceIDCloudCoder.getDataMd5Digest(str2.getBytes()));
    }

    @Deprecated
    public synchronized String getHashedDeviceIdNoThrow() {
        return getHashedDeviceId(true);
    }

    public FutureTask<String> getHashedDeviceIdNoThrowAsync() {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() { // from class: com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil.1
            @Override // java.util.concurrent.Callable
            public String call() throws Exception {
                return HashedDeviceIdUtil.this.getHashedDeviceIdNoThrow();
            }
        });
        if (isMainThread()) {
            sExecutorService.submit(futureTask);
        } else {
            futureTask.run();
        }
        return futureTask;
    }

    public String getHashedDeviceIdThrow() throws IllegalDeviceException {
        String hashedDeviceIdNoThrow = getHashedDeviceIdNoThrow();
        if (hashedDeviceIdNoThrow != null) {
            return hashedDeviceIdNoThrow;
        }
        throw new IllegalDeviceException("null device id");
    }

    public String getRuntimeDeviceIdHashed() {
        try {
            String userEnvironmentPlainDeviceId = getUserEnvironmentPlainDeviceId();
            if (legal(userEnvironmentPlainDeviceId)) {
                return XMPassportSettings.getDeviceType() == XMPassportSettings.DeviceType.WEAR ? userEnvironmentPlainDeviceId : DeviceIdHasher.hashDeviceInfo(userEnvironmentPlainDeviceId);
            }
            return null;
        } catch (SecurityException e) {
            AccountLogger.log(TAG, "can't get deviceid.", e);
            return null;
        }
    }

    public SharedPreferences getSP() {
        Context context = this.context;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("deviceId", 0);
    }

    public String getUserEnvironmentPlainDeviceId() {
        return this.plainDeviceIdFetcher.getPlainDeviceId(this.context);
    }

    public boolean hasHistoricalHashedDeviceId() {
        return legal(loadHistoricalHashedDeviceId());
    }

    public boolean legal(String str) {
        return !TextUtils.isEmpty(str);
    }

    public String loadHistoricalHashedDeviceId() {
        SharedPreferences sp = getSP();
        if (sp == null) {
            return null;
        }
        return sp.getString(SP_KEY_HASHED_DEVICE_ID, null);
    }

    public DeviceIdPolicy policy() {
        return GlobalConfig.getInstance().policy;
    }

    public void saveHistoricalHashedDeviceId(String str) {
        SharedPreferences sp = getSP();
        if (sp != null) {
            sp.edit().putString(SP_KEY_HASHED_DEVICE_ID, str).commit();
        }
    }

    public HashedDeviceIdUtil(Context context, PlainDeviceIdUtil.IPlainDeviceIdFetcher iPlainDeviceIdFetcher) {
        if (iPlainDeviceIdFetcher == null) {
            throw new IllegalArgumentException("plainDeviceIdFetcher == null");
        }
        this.context = context == null ? null : context.getApplicationContext();
        this.plainDeviceIdFetcher = iPlainDeviceIdFetcher;
    }
}
