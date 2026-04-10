package com.funny.audio.user;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/funny/audio/user/UserSettingKey;", "", "()V", "AUDIO_TOP", "", "getAUDIO_TOP", "()Ljava/lang/String;", "setAUDIO_TOP", "(Ljava/lang/String;)V", "READED_ALERT_NOTICE_ID", "getREADED_ALERT_NOTICE_ID", "setREADED_ALERT_NOTICE_ID", "USERID", "getUSERID", "setUSERID", "USERINFO", "getUSERINFO", "setUSERINFO", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserSettingKey {
    public static final UserSettingKey INSTANCE = new UserSettingKey();
    private static String USERID = "KEY_USER_SETTING_USERID";
    private static String USERINFO = "KEY_USER_SETTING_USERINFO";
    private static String READED_ALERT_NOTICE_ID = "KEY_USER_SETTING_READED_ALERT_NOTICE_ID";
    private static String AUDIO_TOP = "KEY_USER_SETTING_AUDIO_TOP";

    private UserSettingKey() {
    }

    public final String getUSERID() {
        return USERID;
    }

    public final void setUSERID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        USERID = str;
    }

    public final String getUSERINFO() {
        return USERINFO;
    }

    public final void setUSERINFO(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        USERINFO = str;
    }

    public final String getREADED_ALERT_NOTICE_ID() {
        return READED_ALERT_NOTICE_ID;
    }

    public final void setREADED_ALERT_NOTICE_ID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        READED_ALERT_NOTICE_ID = str;
    }

    public final String getAUDIO_TOP() {
        return AUDIO_TOP;
    }

    public final void setAUDIO_TOP(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        AUDIO_TOP = str;
    }
}
