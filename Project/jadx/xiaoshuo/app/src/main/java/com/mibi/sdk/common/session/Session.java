package com.mibi.sdk.common.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import com.mibi.sdk.common.account.loader.AccountLoader;
import com.mibi.sdk.common.account.loader.FakeAccountLoader;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.storage.StorageDir;
import com.mibi.sdk.common.storage.UserStorage;
import com.mibi.sdk.common.utils.MibiLog;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes13.dex */
public class Session {
    public static final String KEY_GROUP_GLOBAL_SETTINGS = "groupGlobalSettings";
    private static final String TAG = "Session";
    private final AccountLoader mAccountLoader;
    private final ConcurrentHashMap<String, Object> mLockMap;
    private final MemoryStorage mMemoryStorage;
    private volatile Boolean mSessionClosed;
    private volatile int mSessionClosedCode;
    private volatile String mSessionClosedMessage;
    private volatile long mTimeStamp;
    private final UserStorage mUserStorage;
    private final String mUuid;
    private final Context sApplicationContext;

    public static final class SessionSaveData implements Parcelable {
        public static final Parcelable.Creator<SessionSaveData> CREATOR = new Parcelable.Creator<SessionSaveData>() { // from class: com.mibi.sdk.common.session.Session.SessionSaveData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionSaveData createFromParcel(Parcel parcel) {
                SessionSaveData sessionSaveData = new SessionSaveData();
                sessionSaveData.mAccountLoader = (AccountLoader) parcel.readParcelable(AccountLoader.class.getClassLoader());
                sessionSaveData.mUuid = parcel.readString();
                sessionSaveData.mSessionClosed = parcel.readByte() != 0;
                sessionSaveData.mSessionClosedCode = parcel.readInt();
                sessionSaveData.mSessionClosedMessage = parcel.readString();
                sessionSaveData.mTimeStamp = parcel.readLong();
                MemoryStorage memoryStorageNewMemoryStorage = MemoryStorage.newMemoryStorage();
                sessionSaveData.mMemoryStorage = memoryStorageNewMemoryStorage;
                memoryStorageNewMemoryStorage.readFromParcel(parcel);
                return sessionSaveData;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionSaveData[] newArray(int i) {
                return new SessionSaveData[i];
            }
        };
        AccountLoader mAccountLoader;
        MemoryStorage mMemoryStorage;
        boolean mSessionClosed;
        int mSessionClosedCode;
        String mSessionClosedMessage;
        long mTimeStamp;
        String mUuid;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mAccountLoader, i);
            parcel.writeString(this.mUuid);
            parcel.writeByte(this.mSessionClosed ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.mSessionClosedCode);
            parcel.writeString(this.mSessionClosedMessage);
            parcel.writeLong(this.mTimeStamp);
            this.mMemoryStorage.writeToParcel(parcel);
        }
    }

    public Session(Context context, AccountLoader accountLoader) {
        this.mSessionClosed = Boolean.FALSE;
        this.mLockMap = new ConcurrentHashMap<>();
        Context applicationContext = context.getApplicationContext();
        this.sApplicationContext = applicationContext;
        this.mAccountLoader = accountLoader;
        this.mUuid = UUID.randomUUID().toString();
        this.mTimeStamp = System.currentTimeMillis();
        this.mUserStorage = UserStorage.newUserStorage(applicationContext, accountLoader.getUserId());
        this.mMemoryStorage = MemoryStorage.newMemoryStorage();
    }

    public static SessionSaveData saveSession(Session session) {
        SessionSaveData sessionSaveData;
        if (session == null) {
            throw new IllegalArgumentException("session to save is null");
        }
        synchronized (session) {
            session.mTimeStamp = System.currentTimeMillis();
            sessionSaveData = new SessionSaveData();
            sessionSaveData.mAccountLoader = session.mAccountLoader;
            sessionSaveData.mUuid = session.mUuid;
            sessionSaveData.mSessionClosed = session.mSessionClosed.booleanValue();
            sessionSaveData.mSessionClosedCode = session.mSessionClosedCode;
            sessionSaveData.mSessionClosedMessage = session.mSessionClosedMessage;
            sessionSaveData.mTimeStamp = session.mTimeStamp;
            sessionSaveData.mMemoryStorage = session.mMemoryStorage;
            MibiLog.v(TAG, "session " + session.mUuid + " saved at " + session.mTimeStamp);
        }
        return sessionSaveData;
    }

    public synchronized void closeSession(int i, String str) {
        this.mSessionClosed = Boolean.TRUE;
        this.mSessionClosedCode = i;
        this.mSessionClosedMessage = str;
    }

    public AccountLoader getAccountLoader() {
        return this.mAccountLoader;
    }

    public Context getAppContext() {
        return this.sApplicationContext;
    }

    public Object getLock(String str) {
        Object obj = this.mLockMap.get(str);
        if (obj != null) {
            return obj;
        }
        Object obj2 = new Object();
        Object objPutIfAbsent = this.mLockMap.putIfAbsent(str, obj2);
        return objPutIfAbsent == null ? obj2 : objPutIfAbsent;
    }

    public MemoryStorage getMemoryStorage() {
        return this.mMemoryStorage;
    }

    public int getSessionClosedCode() {
        return this.mSessionClosedCode;
    }

    public String getSessionClosedMessage() {
        return this.mSessionClosedMessage;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public String getUserId() {
        return getAccountLoader().getUserId();
    }

    public SharedPreferences getUserPreferences() {
        return this.mUserStorage.getPreference();
    }

    public StorageDir getUserStorage() {
        return this.mUserStorage.getStorageDir();
    }

    public String getUuid() {
        return this.mUuid;
    }

    public boolean isAccountChanged() {
        return this.mAccountLoader.isAccountChanged(this.sApplicationContext);
    }

    public boolean isFakeAccountLoader() {
        return this.mAccountLoader instanceof FakeAccountLoader;
    }

    public boolean isSessionClosed() {
        return this.mSessionClosed.booleanValue();
    }

    public void load(Context context) throws PaymentException {
        this.mAccountLoader.load(context);
    }

    public void reload(Context context) throws PaymentException {
        this.mAccountLoader.reload(context);
    }

    public void update(SessionSaveData sessionSaveData) {
        getMemoryStorage().update(sessionSaveData.mMemoryStorage);
        this.mSessionClosed = Boolean.valueOf(sessionSaveData.mSessionClosed);
        this.mSessionClosedCode = sessionSaveData.mSessionClosedCode;
        this.mSessionClosedMessage = sessionSaveData.mSessionClosedMessage;
        this.mTimeStamp = sessionSaveData.mTimeStamp;
    }

    public SharedPreferences getUserPreferences(String str) {
        return this.mUserStorage.getPreference(str);
    }

    public StorageDir getUserStorage(String str) {
        return this.mUserStorage.getStorageDir(str);
    }

    public Session(Context context, SessionSaveData sessionSaveData) {
        this.mSessionClosed = Boolean.FALSE;
        this.mLockMap = new ConcurrentHashMap<>();
        Context applicationContext = context.getApplicationContext();
        this.sApplicationContext = applicationContext;
        AccountLoader accountLoader = sessionSaveData.mAccountLoader;
        this.mAccountLoader = accountLoader;
        this.mUuid = sessionSaveData.mUuid;
        this.mSessionClosed = Boolean.valueOf(sessionSaveData.mSessionClosed);
        this.mSessionClosedCode = sessionSaveData.mSessionClosedCode;
        this.mSessionClosedMessage = sessionSaveData.mSessionClosedMessage;
        this.mTimeStamp = sessionSaveData.mTimeStamp;
        this.mUserStorage = UserStorage.newUserStorage(applicationContext, accountLoader.getUserId());
        this.mMemoryStorage = sessionSaveData.mMemoryStorage;
    }
}
