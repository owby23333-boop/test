package com.funny.audio.api;

import android.content.Context;
import com.funny.audio.settings.AppSettingEntity;
import com.funny.audio.settings.AppSettings;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.z;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddressSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/funny/audio/api/AddressSetting;", "", "()V", "business", "Lcom/funny/audio/settings/AppSettingEntity;", "getBusiness", "()Lcom/funny/audio/settings/AppSettingEntity;", "setBusiness", "(Lcom/funny/audio/settings/AppSettingEntity;)V", "businessStatic", "getBusinessStatic", "setBusinessStatic", "cloud", "getCloud", "setCloud", "notice", "getNotice", "setNotice", "search", "getSearch", "setSearch", "staticResource", "getStaticResource", "setStaticResource", "trackResource", "getTrackResource", "setTrackResource", z.m, "getUser", "setUser", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AddressSetting {
    private static AddressSetting _current;
    private AppSettingEntity business;
    private AppSettingEntity businessStatic;
    private AppSettingEntity cloud;
    private AppSettingEntity notice;
    private AppSettingEntity search;
    private AppSettingEntity staticResource;
    private AppSettingEntity trackResource;
    private AppSettingEntity user;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_TYPE = "ADDRESS_SETTING";
    private static final Lazy<AddressSetting> current$delegate = LazyKt.lazy(new Function0<AddressSetting>() { // from class: com.funny.audio.api.AddressSetting$Companion$current$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AddressSetting invoke() {
            AddressSetting addressSetting = AddressSetting._current;
            Intrinsics.checkNotNull(addressSetting);
            return addressSetting;
        }
    });

    public /* synthetic */ AddressSetting(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AddressSetting() {
        AppSettings appSettings = AppSettings.INSTANCE;
        String str = KEY_TYPE;
        this.business = appSettings.createSetting(str, AddressSettingKeys.INSTANCE.getBUSINESS(), AddressSettingDefault.INSTANCE.getBUSINESS());
        this.businessStatic = AppSettings.INSTANCE.createSetting(str, AddressSettingKeys.INSTANCE.getBUSINESS_STATIC(), AddressSettingDefault.INSTANCE.getBUSINESS_STATIC());
        this.user = AppSettings.INSTANCE.createSetting(str, AddressSettingKeys.INSTANCE.getUSER(), AddressSettingDefault.INSTANCE.getUSER());
        this.cloud = AppSettings.INSTANCE.createSetting(str, AddressSettingKeys.INSTANCE.getCLOUD(), AddressSettingDefault.INSTANCE.getCLOUD());
        this.search = AppSettings.INSTANCE.createSetting(str, AddressSettingKeys.INSTANCE.getSEARCH(), AddressSettingDefault.INSTANCE.getSEARCH());
        this.trackResource = AppSettings.INSTANCE.createSetting(str, AddressSettingKeys.INSTANCE.getTRACK_RESOURCE(), AddressSettingDefault.INSTANCE.getTRACK_RESOURCE());
        this.staticResource = AppSettings.INSTANCE.createSetting(str, AddressSettingKeys.INSTANCE.getSTATIC_RESOURCE(), AddressSettingDefault.INSTANCE.getSTATIC_RESOURCE());
        this.notice = AppSettings.INSTANCE.createSetting(str, AddressSettingKeys.INSTANCE.getNOTICE(), AddressSettingDefault.INSTANCE.getNOTICE());
    }

    public final AppSettingEntity getBusiness() {
        return this.business;
    }

    public final void setBusiness(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.business = appSettingEntity;
    }

    public final AppSettingEntity getBusinessStatic() {
        return this.businessStatic;
    }

    public final void setBusinessStatic(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.businessStatic = appSettingEntity;
    }

    public final AppSettingEntity getUser() {
        return this.user;
    }

    public final void setUser(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.user = appSettingEntity;
    }

    public final AppSettingEntity getCloud() {
        return this.cloud;
    }

    public final void setCloud(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.cloud = appSettingEntity;
    }

    public final AppSettingEntity getSearch() {
        return this.search;
    }

    public final void setSearch(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.search = appSettingEntity;
    }

    public final AppSettingEntity getTrackResource() {
        return this.trackResource;
    }

    public final void setTrackResource(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.trackResource = appSettingEntity;
    }

    public final AppSettingEntity getStaticResource() {
        return this.staticResource;
    }

    public final void setStaticResource(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.staticResource = appSettingEntity;
    }

    public final AppSettingEntity getNotice() {
        return this.notice;
    }

    public final void setNotice(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.notice = appSettingEntity;
    }

    /* JADX INFO: compiled from: AddressSetting.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/api/AddressSetting$Companion;", "", "()V", "KEY_TYPE", "", "_current", "Lcom/funny/audio/api/AddressSetting;", "current", "getCurrent", "()Lcom/funny/audio/api/AddressSetting;", "current$delegate", "Lkotlin/Lazy;", "load", d.R, "Landroid/content/Context;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddressSetting getCurrent() {
            return (AddressSetting) AddressSetting.current$delegate.getValue();
        }

        public final AddressSetting load(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AddressSetting addressSetting = new AddressSetting(null);
            List<AppSettingEntity> list = AppSettings.INSTANCE.getList(AddressSetting.KEY_TYPE);
            if (!list.isEmpty()) {
                for (AppSettingEntity appSettingEntity : list) {
                    String settingKey = appSettingEntity.getSettingKey();
                    if (Intrinsics.areEqual(settingKey, AddressSettingKeys.INSTANCE.getBUSINESS())) {
                        addressSetting.setBusiness(appSettingEntity);
                    } else if (Intrinsics.areEqual(settingKey, AddressSettingKeys.INSTANCE.getBUSINESS_STATIC())) {
                        addressSetting.setBusinessStatic(appSettingEntity);
                    } else if (Intrinsics.areEqual(settingKey, AddressSettingKeys.INSTANCE.getUSER())) {
                        addressSetting.setUser(appSettingEntity);
                    } else if (Intrinsics.areEqual(settingKey, AddressSettingKeys.INSTANCE.getSEARCH())) {
                        addressSetting.setSearch(appSettingEntity);
                    } else if (Intrinsics.areEqual(settingKey, AddressSettingKeys.INSTANCE.getTRACK_RESOURCE())) {
                        addressSetting.setTrackResource(appSettingEntity);
                    } else if (Intrinsics.areEqual(settingKey, AddressSettingKeys.INSTANCE.getCLOUD())) {
                        addressSetting.setCloud(appSettingEntity);
                    } else if (Intrinsics.areEqual(settingKey, AddressSettingKeys.INSTANCE.getNOTICE())) {
                        addressSetting.setNotice(appSettingEntity);
                    }
                }
            }
            AddressSetting._current = addressSetting;
            return addressSetting;
        }
    }
}
