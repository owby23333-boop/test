package com.funny.audio.settings;

import androidx.exifinterface.media.ExifInterface;
import com.funny.audio.database.DbContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppSettingEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u0002H\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"save", "", "Lcom/funny/audio/settings/AppSettingEntity;", ExifInterface.GPS_DIRECTION_TRUE, "value", "(Lcom/funny/audio/settings/AppSettingEntity;Ljava/lang/Object;)V", "app_normalRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AppSettingEntityKt {
    public static final void save(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<this>");
        DbContext.INSTANCE.getCurrent().appSetting().add(appSettingEntity);
    }

    public static final <T> void save(AppSettingEntity appSettingEntity, T t) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<this>");
        AppSettings.INSTANCE.saveValue(appSettingEntity, t);
        DbContext.INSTANCE.getCurrent().appSetting().add(appSettingEntity);
    }
}
