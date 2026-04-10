package com.funny.audio.settings;

import androidx.exifinterface.media.ExifInterface;
import com.funny.audio.core.utils.TextUtils;
import com.funny.audio.database.DbContext;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\"\u0010\f\u001a\u0004\u0018\u0001H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J \u0010\u0010\u001a\u0004\u0018\u0001H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0011\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/funny/audio/settings/AppSettings;", "", "()V", "createSetting", "Lcom/funny/audio/settings/AppSettingEntity;", ExifInterface.GPS_DIRECTION_TRUE, "type", "", "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/funny/audio/settings/AppSettingEntity;", "getKey", "getKeyValue", "(Ljava/lang/String;)Ljava/lang/Object;", "getList", "", "getValue", "info", "(Lcom/funny/audio/settings/AppSettingEntity;)Ljava/lang/Object;", "saveValue", "", "value", "(Lcom/funny/audio/settings/AppSettingEntity;Ljava/lang/Object;)V", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppSettings {
    public static final AppSettings INSTANCE = new AppSettings();

    private AppSettings() {
    }

    public final AppSettingEntity getKey(String key) {
        String str = key;
        if (str == null || str.length() == 0) {
            return null;
        }
        return DbContext.INSTANCE.getCurrent().appSetting().key(key);
    }

    public final List<AppSettingEntity> getList(String type) {
        String str = type;
        return str == null || str.length() == 0 ? CollectionsKt.emptyList() : DbContext.INSTANCE.getCurrent().appSetting().list(type);
    }

    public final /* synthetic */ <T> T getKeyValue(String key) {
        String str = key;
        if (str == null || str.length() == 0) {
            return null;
        }
        AppSettingEntity appSettingEntityKey = DbContext.INSTANCE.getCurrent().appSetting().key(key);
        Intrinsics.reifiedOperationMarker(4, "T?");
        if (Intrinsics.areEqual(Object.class, String.class)) {
            CharSequence value = appSettingEntityKey.getValue();
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) value;
        }
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            Object objValueOf = Integer.valueOf(appSettingEntityKey.getValueInt());
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) objValueOf;
        }
        if (Intrinsics.areEqual(Object.class, Long.TYPE)) {
            Object objValueOf2 = Long.valueOf(appSettingEntityKey.getValueLong());
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) objValueOf2;
        }
        if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            Object objValueOf3 = Float.valueOf(appSettingEntityKey.getValueFloat());
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) objValueOf3;
        }
        if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            Object objValueOf4 = Double.valueOf(appSettingEntityKey.getValueDouble());
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) objValueOf4;
        }
        if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            Object objValueOf5 = Double.valueOf(appSettingEntityKey.getValueDouble());
            Intrinsics.reifiedOperationMarker(1, "T?");
            return (T) objValueOf5;
        }
        TextUtils textUtils = TextUtils.INSTANCE;
        String value2 = appSettingEntityKey.getValue();
        Gson gson = textUtils.getGson();
        Intrinsics.reifiedOperationMarker(4, "T?");
        return (T) gson.fromJson(value2, (Class) Object.class);
    }

    public final /* synthetic */ <T> T getValue(AppSettingEntity info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        if (Intrinsics.areEqual(Object.class, String.class)) {
            CharSequence value = info.getValue();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) value;
        }
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            Object objValueOf = Integer.valueOf(info.getValueInt());
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf;
        }
        if (Intrinsics.areEqual(Object.class, Long.TYPE)) {
            Object objValueOf2 = Long.valueOf(info.getValueLong());
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf2;
        }
        if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            Object objValueOf3 = Float.valueOf(info.getValueFloat());
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf3;
        }
        if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            Object objValueOf4 = Double.valueOf(info.getValueDouble());
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf4;
        }
        if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            Object objValueOf5 = Double.valueOf(info.getValueDouble());
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return (T) objValueOf5;
        }
        TextUtils textUtils = TextUtils.INSTANCE;
        String value2 = info.getValue();
        Gson gson = textUtils.getGson();
        Intrinsics.reifiedOperationMarker(4, "T?");
        return (T) gson.fromJson(value2, (Class) Object.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void saveValue(AppSettingEntity info, T value) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (value == 0) {
            return;
        }
        if (value instanceof String) {
            info.setValue((String) value);
            return;
        }
        if (value instanceof Integer) {
            info.setValueInt(((Number) value).intValue());
            return;
        }
        if (value instanceof Long) {
            info.setValueLong(((Number) value).longValue());
            return;
        }
        if (value instanceof Float) {
            info.setValueFloat(((Number) value).floatValue());
            return;
        }
        if (value instanceof Double) {
            info.setValueDouble(((Number) value).doubleValue());
        } else if (value instanceof Boolean) {
            info.setValueBoolean(((Boolean) value).booleanValue());
        } else {
            info.setValue(TextUtils.INSTANCE.serializeJson(value));
        }
    }

    public final <T> AppSettingEntity createSetting(String type, String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(key, "key");
        AppSettingEntity appSettingEntity = new AppSettingEntity();
        appSettingEntity.setSettingKey(key);
        appSettingEntity.setType(type);
        saveValue(appSettingEntity, defaultValue);
        return appSettingEntity;
    }
}
