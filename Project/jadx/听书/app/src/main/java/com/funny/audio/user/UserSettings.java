package com.funny.audio.user;

import android.content.Context;
import com.funny.audio.settings.AppSettingEntity;
import com.funny.audio.settings.AppSettings;
import com.umeng.analytics.pro.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR$\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000f¨\u0006&"}, d2 = {"Lcom/funny/audio/user/UserSettings;", "", "()V", "value", "", "audioTop", "getAudioTop", "()Z", "setAudioTop", "(Z)V", "audioTopSetting", "Lcom/funny/audio/settings/AppSettingEntity;", "getAudioTopSetting", "()Lcom/funny/audio/settings/AppSettingEntity;", "setAudioTopSetting", "(Lcom/funny/audio/settings/AppSettingEntity;)V", "", "readedAlertNoticeId", "getReadedAlertNoticeId", "()Ljava/lang/String;", "setReadedAlertNoticeId", "(Ljava/lang/String;)V", "readedAlertNoticeIdSetting", "getReadedAlertNoticeIdSetting", "setReadedAlertNoticeIdSetting", "userId", "getUserId", "setUserId", "userIdSetting", "getUserIdSetting", "setUserIdSetting", "userInfo", "getUserInfo", "setUserInfo", "userInfoSetting", "getUserInfoSetting", "setUserInfoSetting", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserSettings {
    private static UserSettings _current;
    private AppSettingEntity audioTopSetting;
    private AppSettingEntity readedAlertNoticeIdSetting;
    private AppSettingEntity userIdSetting;
    private AppSettingEntity userInfoSetting;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_TYPE = "USER_SETTING";
    private static final Lazy<UserSettings> current$delegate = LazyKt.lazy(new Function0<UserSettings>() { // from class: com.funny.audio.user.UserSettings$Companion$current$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserSettings invoke() {
            UserSettings userSettings = UserSettings._current;
            Intrinsics.checkNotNull(userSettings);
            return userSettings;
        }
    });

    public UserSettings() {
        AppSettings appSettings = AppSettings.INSTANCE;
        String str = KEY_TYPE;
        this.userIdSetting = appSettings.createSetting(str, UserSettingKey.INSTANCE.getUSERID(), "");
        this.userInfoSetting = AppSettings.INSTANCE.createSetting(str, UserSettingKey.INSTANCE.getUSERINFO(), "");
        this.readedAlertNoticeIdSetting = AppSettings.INSTANCE.createSetting(str, UserSettingKey.INSTANCE.getREADED_ALERT_NOTICE_ID(), "");
        this.audioTopSetting = AppSettings.INSTANCE.createSetting(str, UserSettingKey.INSTANCE.getAUDIO_TOP(), false);
    }

    public final String getUserId() {
        return this.userIdSetting.getValue();
    }

    public final void setUserId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.userIdSetting.setValue(value);
    }

    public final AppSettingEntity getUserIdSetting() {
        return this.userIdSetting;
    }

    public final void setUserIdSetting(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.userIdSetting = appSettingEntity;
    }

    public final String getUserInfo() {
        return this.userInfoSetting.getValue();
    }

    public final void setUserInfo(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.userInfoSetting.setValue(value);
    }

    public final AppSettingEntity getUserInfoSetting() {
        return this.userInfoSetting;
    }

    public final void setUserInfoSetting(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.userInfoSetting = appSettingEntity;
    }

    public final String getReadedAlertNoticeId() {
        return this.readedAlertNoticeIdSetting.getValue();
    }

    public final void setReadedAlertNoticeId(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.readedAlertNoticeIdSetting.setValue(value);
    }

    public final AppSettingEntity getReadedAlertNoticeIdSetting() {
        return this.readedAlertNoticeIdSetting;
    }

    public final void setReadedAlertNoticeIdSetting(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.readedAlertNoticeIdSetting = appSettingEntity;
    }

    public final boolean getAudioTop() {
        return this.audioTopSetting.getValueBoolean();
    }

    public final void setAudioTop(boolean z) {
        this.audioTopSetting.setValueBoolean(z);
    }

    public final AppSettingEntity getAudioTopSetting() {
        return this.audioTopSetting;
    }

    public final void setAudioTopSetting(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.audioTopSetting = appSettingEntity;
    }

    /* JADX INFO: compiled from: UserSettings.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/user/UserSettings$Companion;", "", "()V", "KEY_TYPE", "", "_current", "Lcom/funny/audio/user/UserSettings;", "current", "getCurrent", "()Lcom/funny/audio/user/UserSettings;", "current$delegate", "Lkotlin/Lazy;", "load", d.R, "Landroid/content/Context;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserSettings getCurrent() {
            return (UserSettings) UserSettings.current$delegate.getValue();
        }

        public final UserSettings load(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            UserSettings userSettings = new UserSettings();
            for (AppSettingEntity appSettingEntity : AppSettings.INSTANCE.getList(UserSettings.KEY_TYPE)) {
                String settingKey = appSettingEntity.getSettingKey();
                if (Intrinsics.areEqual(settingKey, UserSettingKey.INSTANCE.getUSERID())) {
                    userSettings.setUserIdSetting(appSettingEntity);
                } else if (Intrinsics.areEqual(settingKey, UserSettingKey.INSTANCE.getUSERINFO())) {
                    userSettings.setUserInfoSetting(appSettingEntity);
                } else if (Intrinsics.areEqual(settingKey, UserSettingKey.INSTANCE.getREADED_ALERT_NOTICE_ID())) {
                    userSettings.setReadedAlertNoticeIdSetting(appSettingEntity);
                } else if (Intrinsics.areEqual(settingKey, UserSettingKey.INSTANCE.getAUDIO_TOP())) {
                    userSettings.setAudioTopSetting(appSettingEntity);
                }
            }
            UserSettings._current = userSettings;
            return userSettings;
        }
    }
}
