package com.umeng.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import com.umeng.message.proguard.ab;
import com.umeng.message.proguard.ad;
import com.umeng.message.proguard.ae;
import com.umeng.message.proguard.af;
import com.umeng.message.proguard.d;
import com.umeng.message.proguard.l;
import com.umeng.message.proguard.r;
import java.util.ArrayList;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class MessageSharedPrefs {
    private static final String a = "MessageSharedPrefs";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile MessageSharedPrefs f20251c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20252d = "k";
    private final Context b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final af f20253e = new af("push");

    private MessageSharedPrefs(Context context) {
        this.b = context.getApplicationContext();
    }

    private void a(String str, String str2) {
        try {
            this.b.getContentResolver().delete(ab.f20367e, "type=? and message=? ", new String[]{str, str2});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static MessageSharedPrefs getInstance(Context context) {
        if (f20251c == null) {
            synchronized (MessageSharedPrefs.class) {
                if (f20251c == null) {
                    f20251c = new MessageSharedPrefs(context);
                }
            }
        }
        return f20251c;
    }

    public void addAlias(String str, String str2, int i2, int i3, String str3) {
        Cursor cursorQuery = null;
        try {
            Context contextB = r.b();
            String strA = d.a(str);
            a(str2, str3);
            String[] strArr = {strA, str2, i2 + ""};
            cursorQuery = contextB.getContentResolver().query(ab.f20367e, new String[]{"error"}, "alias=? and type=? and exclusive=?", strArr, "time desc");
            if (cursorQuery == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("type", str2);
                contentValues.put("alias", strA);
                contentValues.put(ad.f20413z, Integer.valueOf(i2));
                contentValues.put("error", Integer.valueOf(i3));
                contentValues.put("message", str3);
                this.b.getContentResolver().insert(ab.f20367e, contentValues);
            } else if (cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues2.put("type", str2);
                contentValues2.put("alias", strA);
                contentValues2.put(ad.f20413z, Integer.valueOf(i2));
                contentValues2.put("error", Integer.valueOf(i3));
                contentValues2.put("message", str3);
                this.b.getContentResolver().update(ab.f20367e, contentValues2, "alias=? and type=? and exclusive=?", strArr);
            } else {
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues3.put("type", str2);
                contentValues3.put("alias", strA);
                contentValues3.put(ad.f20413z, Integer.valueOf(i2));
                contentValues3.put("error", Integer.valueOf(i3));
                contentValues3.put("message", str3);
                this.b.getContentResolver().insert(ab.f20367e, contentValues3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
    }

    public void addDeleteAliasInterval(String str) {
        if (str != null) {
            this.f20253e.a(MsgConstant.KEY_DELETEALIAS, str);
        }
    }

    public void addTags(String... strArr) {
        for (String str : strArr) {
            if (!isTagSet(str)) {
                this.f20253e.a(String.format("UMENG_TAG_%s", str), true);
                this.f20253e.a("UMENG_TAG_COUNT", getTagCount() + 1);
            }
        }
    }

    public String getAddAliasInterval() {
        return this.f20253e.b(MsgConstant.KEY_ADDALIAS, (String) null);
    }

    public String getAddTagsInterval() {
        return this.f20253e.b(MsgConstant.KEY_ADDTAGS, (String) null);
    }

    public String getAddWeightedTagsInterval() {
        return this.f20253e.b(MsgConstant.KEY_ADD_WEIGHTED_TAGS, (String) null);
    }

    public int getAppLaunchLogSendPolicy() {
        return this.f20253e.b(MsgConstant.KEY_APP_LAUNCH_LOG_SEND_POLICY, -1);
    }

    public String getDeleteAliasInterval() {
        return this.f20253e.b(MsgConstant.KEY_DELETEALIAS, (String) null);
    }

    public String getDeleteTagsInterval() {
        return this.f20253e.b(MsgConstant.KEY_DELETETAGS, (String) null);
    }

    public String getDeleteWeightedTagsInterval() {
        return this.f20253e.b(MsgConstant.KEY_DELETE_WEIGHTED_TAGS, (String) null);
    }

    public String getDeviceToken() {
        return this.f20253e.b(MsgConstant.KEY_DEVICE_TOKEN, "");
    }

    public int getDisplayNotificationNumber() {
        return this.f20253e.b(MsgConstant.KEY_NOTIFICATION_NUMBER, 1);
    }

    public String getGetTagsInterval() {
        return this.f20253e.b(MsgConstant.KEY_GETTAGS, (String) null);
    }

    public String getLastAdMessageMsgID() {
        return this.f20253e.b(MsgConstant.KEY_LAST_AD_MSG_ID, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054 A[EXC_TOP_SPLITTER, PHI: r1 r2
  0x0054: PHI (r1v2 java.lang.String) = (r1v0 java.lang.String), (r1v4 java.lang.String) binds: [B:15:0x005e, B:8:0x0052] A[DONT_GENERATE, DONT_INLINE]
  0x0054: PHI (r2v3 android.database.Cursor) = (r2v2 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:15:0x005e, B:8:0x0052] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getLastAlias(int r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "alias"
            java.lang.String r1 = ""
            r2 = 0
            java.lang.String r6 = "type=? and exclusive=? and (error=? or error = ?)"
            r3 = 4
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r3 = 0
            r7[r3] = r11     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r11 = 1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r3.<init>()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r3.append(r10)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r3.append(r1)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r10 = r3.toString()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r7[r11] = r10     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r10 = 2
            java.lang.String r11 = "0"
            r7[r10] = r11     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r10 = 3
            java.lang.String r11 = "2"
            r7[r10] = r11     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r8 = "time desc"
            android.content.Context r10 = r9.b     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            android.net.Uri r4 = com.umeng.message.proguard.ab.f20367e     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r2 == 0) goto L52
            int r10 = r2.getCount()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r10 <= 0) goto L52
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            int r10 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r1 = r2.getString(r10)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            java.lang.String r1 = com.umeng.message.proguard.d.b(r1)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
        L52:
            if (r2 == 0) goto L61
        L54:
            r2.close()     // Catch: java.lang.Throwable -> L61
            goto L61
        L58:
            r10 = move-exception
            goto L62
        L5a:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r2 == 0) goto L61
            goto L54
        L61:
            return r1
        L62:
            if (r2 == 0) goto L67
            r2.close()     // Catch: java.lang.Throwable -> L67
        L67:
            goto L69
        L68:
            throw r10
        L69:
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.getLastAlias(int, java.lang.String):java.lang.String");
    }

    public String getLastMessageMsgID() {
        return this.f20253e.b(MsgConstant.KEY_LAST_MSG_ID, "");
    }

    public String getListWeightedTagsInterval() {
        return this.f20253e.b(MsgConstant.KEY_LIST_WEIGHTED_TAGS, (String) null);
    }

    public String getMessageAppKey() {
        return this.f20253e.b("appkey", "");
    }

    public String getMessageAppSecret() {
        return this.f20253e.b(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET, "");
    }

    public String getMessageChannel() {
        return this.f20253e.b("channel", "");
    }

    public int getMuteDuration() {
        return this.f20253e.b(MsgConstant.KEY_MUTE_DURATION, 60);
    }

    public int getNoDisturbEndHour() {
        return this.f20253e.b(MsgConstant.KEY_NO_DISTURB_END_HOUR, 7);
    }

    public int getNoDisturbEndMinute() {
        return this.f20253e.b(MsgConstant.KEY_NO_DISTURB_END_MINUTE, 0);
    }

    public int getNoDisturbStartHour() {
        return this.f20253e.b(MsgConstant.KEY_NO_DISTURB_START_HOUR, 23);
    }

    public int getNoDisturbStartMinute() {
        return this.f20253e.b(MsgConstant.KEY_NO_DISTURB_START_MINUTE, 0);
    }

    public String getNotificationChannelName() {
        return this.f20253e.b(MsgConstant.KEY_NOTIFICATION_CHANNEL, "");
    }

    public boolean getNotificationOnForeground() {
        return this.f20253e.b(MsgConstant.KEY_SET_NOTIFICATION_ON_FOREGROUND, true);
    }

    public int getNotificationPlayLights() {
        return this.f20253e.b(MsgConstant.KEY_SET_NOTIFICATION_PLAY_LIGHTS, 0);
    }

    public int getNotificationPlaySound() {
        return this.f20253e.b(MsgConstant.KEY_SET_NOTIFICATION_PLAY_SOUND, 0);
    }

    public int getNotificationPlayVibrate() {
        return this.f20253e.b(MsgConstant.KEY_SET_NOTIFICATION_PLAY_VIBRATE, 0);
    }

    public String getNotificationSilenceChannelName() {
        return this.f20253e.b(MsgConstant.KEY_NOTIFICATION_SILENCE_CHANNEL, "");
    }

    public String getPushIntentServiceClass() {
        String strB = this.f20253e.b(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME, "");
        if (!TextUtils.isEmpty(strB)) {
            try {
                Class.forName(strB);
                return strB;
            } catch (Throwable unused) {
                UPLog.e(a, "custom service not exist:", strB, " if has removed. pls invoke PushAgent.setPushIntentServiceClass(null)");
            }
        }
        return "";
    }

    public int getRegisterTimes() {
        return this.f20253e.b(MsgConstant.KEY_REGISTER_TIMES, 0);
    }

    public String getResourcePackageName() {
        return this.f20253e.b(MsgConstant.KEY_SET_RESOURCE_PACKAGE_NAME, "");
    }

    public String getSetAliasInterval() {
        return this.f20253e.b("setAlias", (String) null);
    }

    public int getTagCount() {
        return this.f20253e.b("UMENG_TAG_COUNT", 0);
    }

    public int getTagRemain() {
        return this.f20253e.b(MsgConstant.KET_UMENG_TAG_REMAIN, 64);
    }

    public int getTagSendPolicy() {
        return this.f20253e.b(MsgConstant.KEY_TAG_SEND_POLICY, -1);
    }

    public boolean hasAppLaunchLogSentToday() {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(ae.a(this.b).c());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    public boolean hasResourceDownloaded(String str) {
        return this.f20253e.b(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX + str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e4 A[EXC_TOP_SPLITTER, PHI: r7 r8
  0x00e4: PHI (r7v1 boolean) = (r7v0 boolean), (r7v3 boolean) binds: [B:19:0x00ee, B:12:0x00e2] A[DONT_GENERATE, DONT_INLINE]
  0x00e4: PHI (r8v3 android.database.Cursor) = (r8v2 android.database.Cursor), (r8v4 android.database.Cursor) binds: [B:19:0x00ee, B:12:0x00e2] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isAliasSet(int r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.isAliasSet(int, java.lang.String, java.lang.String):boolean");
    }

    public boolean isBannerEnable() {
        return this.f20253e.b(MsgConstant.KEY_BANNER_ENABLE, true);
    }

    public boolean isRegistered() {
        return this.f20253e.b(MsgConstant.KEY_HAS_REGISTER, false);
    }

    public boolean isTagSet(String str) {
        return this.f20253e.b(String.format("UMENG_TAG_%s", str), false);
    }

    public void removeAlias(int i2, String str, String str2) {
        try {
            this.b.getContentResolver().delete(ab.f20367e, "type=? and alias=? and exclusive=? ", new String[]{str2, d.a(str), i2 + ""});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void removeMessageResourceRecord(String str) {
        this.f20253e.a(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX + str);
    }

    public void removeTags(String... strArr) {
        for (String str : strArr) {
            if (isTagSet(str)) {
                this.f20253e.a(String.format("UMENG_TAG_%s", str));
                this.f20253e.a("UMENG_TAG_COUNT", getTagCount() - 1);
            }
        }
    }

    public void resetTags() {
        Cursor cursorQuery = null;
        try {
            Context contextB = r.b();
            ArrayList arrayList = new ArrayList();
            cursorQuery = contextB.getContentResolver().query(ab.f20365c, null, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                cursorQuery.moveToFirst();
                while (!cursorQuery.isAfterLast()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("k"));
                    if (string.contains("UMENG_TAG")) {
                        arrayList.add(string);
                    }
                    cursorQuery.moveToNext();
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                contextB.getContentResolver().delete(ab.f20365c, "k=?", new String[]{(String) arrayList.get(i2)});
            }
            if (cursorQuery == null) {
                return;
            }
        } catch (Exception unused) {
            if (cursorQuery == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
        try {
            cursorQuery.close();
        } catch (Throwable unused3) {
        }
    }

    public void setAddAliasInterval(String str) {
        if (str != null) {
            this.f20253e.a(MsgConstant.KEY_ADDALIAS, str);
        }
    }

    public void setAddTagsInterval(String str) {
        if (str != null) {
            this.f20253e.a(MsgConstant.KEY_ADDTAGS, str);
        }
    }

    public void setAddWeightedTagsInterval(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f20253e.a(MsgConstant.KEY_ADD_WEIGHTED_TAGS, str);
    }

    public void setAppLaunchLogSendPolicy(int i2) {
        this.f20253e.a(MsgConstant.KEY_APP_LAUNCH_LOG_SEND_POLICY, i2);
    }

    public void setBannerEnableSync(boolean z2) {
        this.f20253e.a(MsgConstant.KEY_BANNER_ENABLE, z2);
    }

    public void setDeleteTagsInterval(String str) {
        if (str != null) {
            this.f20253e.a(MsgConstant.KEY_DELETETAGS, str);
        }
    }

    public void setDeleteWeightedTagsInterval(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f20253e.a(MsgConstant.KEY_DELETE_WEIGHTED_TAGS, str);
    }

    public void setDeviceToken(String str) {
        if (str == null) {
            this.f20253e.a(MsgConstant.KEY_DEVICE_TOKEN);
        } else {
            this.f20253e.a(MsgConstant.KEY_DEVICE_TOKEN, str);
        }
    }

    public void setDisplayNotificationNumber(int i2) {
        this.f20253e.a(MsgConstant.KEY_NOTIFICATION_NUMBER, i2);
    }

    public void setGetTagsInterval(String str) {
        if (str != null) {
            this.f20253e.a(MsgConstant.KEY_GETTAGS, str);
        }
    }

    public void setLastAdMessageMsgID(String str) {
        this.f20253e.a(MsgConstant.KEY_LAST_AD_MSG_ID, str);
    }

    public void setLastMessageMsgID(String str) {
        this.f20253e.a(MsgConstant.KEY_LAST_MSG_ID, str);
    }

    public void setListWeightedTagsInterval(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f20253e.a(MsgConstant.KEY_LIST_WEIGHTED_TAGS, str);
    }

    public void setMessageAppKey(String str) {
        if (l.c(this.b)) {
            if (str == null || str.equals("")) {
                UPLog.e(a, "appkey is empty!");
            } else {
                this.f20253e.a("appkey", str);
            }
        }
    }

    public void setMessageAppSecret(String str) {
        if (l.c(this.b)) {
            if (str == null || str.equals("")) {
                UPLog.e(a, "message secret is empty!");
            } else {
                this.f20253e.a(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET, str);
            }
        }
    }

    public void setMessageChannel(String str) {
        if (l.c(this.b)) {
            this.f20253e.a("channel", str);
        }
    }

    public void setMuteDuration(int i2) {
        this.f20253e.a(MsgConstant.KEY_MUTE_DURATION, i2);
    }

    public void setNoDisturbMode(int i2, int i3, int i4, int i5) {
        this.f20253e.a(MsgConstant.KEY_NO_DISTURB_START_HOUR, i2);
        this.f20253e.a(MsgConstant.KEY_NO_DISTURB_START_MINUTE, i3);
        this.f20253e.a(MsgConstant.KEY_NO_DISTURB_END_HOUR, i4);
        this.f20253e.a(MsgConstant.KEY_NO_DISTURB_END_MINUTE, i5);
    }

    public void setNotificationChannelName(String str) {
        this.f20253e.a(MsgConstant.KEY_NOTIFICATION_CHANNEL, str);
    }

    public void setNotificationOnForeground(boolean z2) {
        this.f20253e.a(MsgConstant.KEY_SET_NOTIFICATION_ON_FOREGROUND, z2);
    }

    public void setNotificationPlayLights(int i2) {
        this.f20253e.a(MsgConstant.KEY_SET_NOTIFICATION_PLAY_LIGHTS, i2);
    }

    public void setNotificationPlaySound(int i2) {
        this.f20253e.a(MsgConstant.KEY_SET_NOTIFICATION_PLAY_SOUND, i2);
    }

    public void setNotificationPlayVibrate(int i2) {
        this.f20253e.a(MsgConstant.KEY_SET_NOTIFICATION_PLAY_VIBRATE, i2);
    }

    public void setNotificationSilenceChannelName(String str) {
        this.f20253e.a(MsgConstant.KEY_NOTIFICATION_SILENCE_CHANNEL, str);
    }

    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        if (cls == null) {
            this.f20253e.a(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME);
        } else {
            this.f20253e.a(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME, cls.getName());
        }
    }

    public void setRegisterTimes(int i2) {
        this.f20253e.a(MsgConstant.KEY_REGISTER_TIMES, i2);
    }

    public void setRegistered(boolean z2) {
        this.f20253e.a(MsgConstant.KEY_HAS_REGISTER, z2);
    }

    public void setResourceDownloaded(String str) {
        this.f20253e.a(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX + str, true);
    }

    public void setResourcePackageName(String str) {
        this.f20253e.a(MsgConstant.KEY_SET_RESOURCE_PACKAGE_NAME, str);
    }

    public void setSetAliasInterval(String str) {
        if (str != null) {
            this.f20253e.a("setAlias", str);
        }
    }

    public void setTagRemain(int i2) {
        this.f20253e.a(MsgConstant.KET_UMENG_TAG_REMAIN, i2);
    }

    public void setTagSendPolicy(int i2) {
        this.f20253e.a(MsgConstant.KEY_TAG_SEND_POLICY, i2);
    }
}
