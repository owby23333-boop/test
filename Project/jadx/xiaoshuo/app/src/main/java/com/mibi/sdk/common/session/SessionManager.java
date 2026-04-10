package com.mibi.sdk.common.session;

import android.content.Context;
import android.text.TextUtils;
import com.mibi.sdk.common.account.loader.AccountLoader;
import com.mibi.sdk.common.session.Session;
import com.mibi.sdk.common.utils.MibiLog;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes13.dex */
public class SessionManager {
    private static final String TAG = "SessionManager";
    private static SessionCache sSessionCache = new SessionCache();

    public static class SessionCache {
        private static Map<String, SoftReference<Session>> sSessionCache = new ConcurrentHashMap();

        private SessionCache() {
        }

        public Session get(String str) {
            SoftReference<Session> softReference;
            if (TextUtils.isEmpty(str) || (softReference = sSessionCache.get(str)) == null) {
                return null;
            }
            return softReference.get();
        }

        public void put(Session session) {
            if (session == null) {
                return;
            }
            sSessionCache.put(session.getUuid(), new SoftReference<>(session));
        }
    }

    private SessionManager() {
    }

    public static Session get(String str) {
        return sSessionCache.get(str);
    }

    public static Session newSession(Context context, AccountLoader accountLoader) {
        Session session = new Session(context, accountLoader);
        MibiLog.v(TAG, "new session " + session.getUuid() + " created");
        sSessionCache.put(session);
        return session;
    }

    public static Session restoreOrUpdateSession(Context context, Session.SessionSaveData sessionSaveData, Session.SessionSaveData sessionSaveData2) {
        if (sessionSaveData2 == null && sessionSaveData == null) {
            MibiLog.d(TAG, "intent session and saved session all null");
            return null;
        }
        String str = sessionSaveData2 != null ? sessionSaveData2.mUuid : sessionSaveData.mUuid;
        StringBuilder sb = new StringBuilder();
        sb.append("session ");
        sb.append(str);
        sb.append(" restore from ");
        sb.append(sessionSaveData2 != null ? "intent data" : "saved data");
        MibiLog.v(TAG, sb.toString());
        if (sessionSaveData == null || sessionSaveData2 == null ? sessionSaveData != null : sessionSaveData2.mTimeStamp <= sessionSaveData.mTimeStamp) {
            sessionSaveData2 = sessionSaveData;
        }
        Session session = get(str);
        if (session == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("session ");
            sb2.append(str);
            sb2.append(" is not in cache, restore from ");
            sb2.append(sessionSaveData2 == sessionSaveData ? "saved data" : "intent data");
            MibiLog.v(TAG, sb2.toString());
            Session session2 = new Session(context, sessionSaveData2);
            sSessionCache.put(session2);
            return session2;
        }
        synchronized (session) {
            if (sessionSaveData2.mTimeStamp > session.getTimeStamp()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("session ");
                sb3.append(str);
                sb3.append(" in cache is out of date, try to update from ");
                sb3.append(sessionSaveData2 == sessionSaveData ? "saved data" : "intent data");
                MibiLog.v(TAG, sb3.toString());
                session.update(sessionSaveData2);
            } else {
                MibiLog.v(TAG, "session " + str + " found in cache");
            }
        }
        return session;
    }

    public static Session.SessionSaveData saveSession(Session session) {
        return Session.saveSession(session);
    }
}
