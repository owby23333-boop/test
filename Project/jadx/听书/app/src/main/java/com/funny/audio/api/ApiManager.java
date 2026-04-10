package com.funny.audio.api;

import android.app.Application;
import android.util.Log;
import com.funny.audio.AppManager;
import com.funny.audio.core.net.ApiServiceFactory;
import com.funny.audio.core.net.AppBody;
import com.funny.audio.core.net.NetModelsKt;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.CloudServiceInfo;
import com.funny.audio.settings.AppSettingEntityKt;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\b\u001a\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/funny/audio/api/ApiManager;", "", "()V", "business", "Lcom/funny/audio/api/IBusinessApi;", "getBusiness", "()Lcom/funny/audio/api/IBusinessApi;", "business$delegate", "Lkotlin/Lazy;", "cloud", "Lcom/funny/audio/api/ICloudApi;", "getCloud", "()Lcom/funny/audio/api/ICloudApi;", "cloud$delegate", d.R, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "notice", "Lcom/funny/audio/api/INoticeApi;", "getNotice", "()Lcom/funny/audio/api/INoticeApi;", "notice$delegate", "search", "Lcom/funny/audio/api/ISearchApi;", "getSearch", "()Lcom/funny/audio/api/ISearchApi;", "search$delegate", "setting", "Lcom/funny/audio/api/AddressSetting;", "getSetting", "()Lcom/funny/audio/api/AddressSetting;", "setSetting", "(Lcom/funny/audio/api/AddressSetting;)V", "tagName", "", z.m, "Lcom/funny/audio/api/IUserApi;", "getUser", "()Lcom/funny/audio/api/IUserApi;", "user$delegate", "cloudUpdate", "", "init", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ApiManager {
    private static Application context;
    private static AddressSetting setting;
    public static final ApiManager INSTANCE = new ApiManager();
    private static final String tagName = "API";

    /* JADX INFO: renamed from: business$delegate, reason: from kotlin metadata */
    private static final Lazy business = LazyKt.lazy(new Function0<IBusinessApi>() { // from class: com.funny.audio.api.ApiManager$business$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IBusinessApi invoke() {
            ApiServiceFactory apiServiceFactory = ApiServiceFactory.INSTANCE;
            Application context2 = ApiManager.INSTANCE.getContext();
            Intrinsics.checkNotNull(context2);
            AddressSetting setting2 = ApiManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting2);
            String value = setting2.getBusiness().getValue();
            AddressSetting setting3 = ApiManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting3);
            return (IBusinessApi) apiServiceFactory.createService(context2, IBusinessApi.class, value, setting3.getBusinessStatic().getValue());
        }
    });

    /* JADX INFO: renamed from: user$delegate, reason: from kotlin metadata */
    private static final Lazy user = LazyKt.lazy(new Function0<IUserApi>() { // from class: com.funny.audio.api.ApiManager$user$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IUserApi invoke() {
            ApiServiceFactory apiServiceFactory = ApiServiceFactory.INSTANCE;
            Application context2 = ApiManager.INSTANCE.getContext();
            Intrinsics.checkNotNull(context2);
            AddressSetting setting2 = ApiManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting2);
            return (IUserApi) ApiServiceFactory.createService$default(apiServiceFactory, context2, IUserApi.class, setting2.getUser().getValue(), null, 8, null);
        }
    });

    /* JADX INFO: renamed from: search$delegate, reason: from kotlin metadata */
    private static final Lazy search = LazyKt.lazy(new Function0<ISearchApi>() { // from class: com.funny.audio.api.ApiManager$search$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ISearchApi invoke() {
            ApiServiceFactory apiServiceFactory = ApiServiceFactory.INSTANCE;
            Application context2 = ApiManager.INSTANCE.getContext();
            Intrinsics.checkNotNull(context2);
            AddressSetting setting2 = ApiManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting2);
            return (ISearchApi) ApiServiceFactory.createService$default(apiServiceFactory, context2, ISearchApi.class, setting2.getSearch().getValue(), null, 8, null);
        }
    });

    /* JADX INFO: renamed from: cloud$delegate, reason: from kotlin metadata */
    private static final Lazy cloud = LazyKt.lazy(new Function0<ICloudApi>() { // from class: com.funny.audio.api.ApiManager$cloud$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ICloudApi invoke() {
            ApiServiceFactory apiServiceFactory = ApiServiceFactory.INSTANCE;
            Application context2 = ApiManager.INSTANCE.getContext();
            Intrinsics.checkNotNull(context2);
            AddressSetting setting2 = ApiManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting2);
            return (ICloudApi) ApiServiceFactory.createService$default(apiServiceFactory, context2, ICloudApi.class, setting2.getCloud().getValue(), null, 8, null);
        }
    });

    /* JADX INFO: renamed from: notice$delegate, reason: from kotlin metadata */
    private static final Lazy notice = LazyKt.lazy(new Function0<INoticeApi>() { // from class: com.funny.audio.api.ApiManager$notice$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final INoticeApi invoke() {
            ApiServiceFactory apiServiceFactory = ApiServiceFactory.INSTANCE;
            Application context2 = ApiManager.INSTANCE.getContext();
            Intrinsics.checkNotNull(context2);
            AddressSetting setting2 = ApiManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting2);
            return (INoticeApi) ApiServiceFactory.createService$default(apiServiceFactory, context2, INoticeApi.class, setting2.getNotice().getValue(), null, 8, null);
        }
    });

    private ApiManager() {
    }

    public final Application getContext() {
        return context;
    }

    public final void setContext(Application application) {
        context = application;
    }

    public final AddressSetting getSetting() {
        return setting;
    }

    public final void setSetting(AddressSetting addressSetting) {
        setting = addressSetting;
    }

    public final IBusinessApi getBusiness() {
        return (IBusinessApi) business.getValue();
    }

    public final IUserApi getUser() {
        return (IUserApi) user.getValue();
    }

    public final ISearchApi getSearch() {
        return (ISearchApi) search.getValue();
    }

    public final ICloudApi getCloud() {
        return (ICloudApi) cloud.getValue();
    }

    public final INoticeApi getNotice() {
        return (INoticeApi) notice.getValue();
    }

    public final void init(Application context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        setting = AddressSetting.INSTANCE.load(context2);
    }

    public final void cloudUpdate() {
        try {
            String str = tagName;
            Log.i(str, "获取包名对应云控服务地址配置...");
            Response<CloudServiceInfo> serviceInfo = getCloud().getServiceInfo(AppManager.INSTANCE.getAppKey());
            if (serviceInfo == null || !NetModelsKt.successWithData(serviceInfo)) {
                Log.i(str, "获取总云控服务地址配置...");
                serviceInfo = getCloud().getServiceInfo();
            }
            if (serviceInfo != null && NetModelsKt.successWithData(serviceInfo)) {
                Log.i(str, "获取云控服务地址配置成功！");
                AddressSetting addressSetting = setting;
                Intrinsics.checkNotNull(addressSetting);
                AppBody<CloudServiceInfo> body = serviceInfo.getBody();
                Intrinsics.checkNotNull(body);
                CloudServiceInfo data = body.getData();
                Intrinsics.checkNotNull(data);
                CloudServiceInfo cloudServiceInfo = data;
                if (!Intrinsics.areEqual(addressSetting.getCloud().getValue(), cloudServiceInfo.getCloudAddress())) {
                    Log.i(str, "云控服务地址更新：（旧：" + addressSetting.getCloud().getValue() + "）-> （新：" + cloudServiceInfo.getCloudAddress() + "）");
                    AppSettingEntityKt.save(addressSetting.getCloud(), cloudServiceInfo.getCloudAddress());
                }
                if (!Intrinsics.areEqual(addressSetting.getBusiness().getValue(), cloudServiceInfo.getBusinessDynamicAddress())) {
                    Log.i(str, "业务服务动态地址更新：（旧：" + addressSetting.getBusiness().getValue() + "）-> （新：" + cloudServiceInfo.getBusinessDynamicAddress() + "）");
                    AppSettingEntityKt.save(addressSetting.getBusiness(), cloudServiceInfo.getBusinessDynamicAddress());
                }
                if (!Intrinsics.areEqual(addressSetting.getBusinessStatic().getValue(), cloudServiceInfo.getBusinessStaticAddress())) {
                    Log.i(str, "业务服务缓存地址更新：（旧：" + addressSetting.getBusinessStatic().getValue() + "）-> （新：" + cloudServiceInfo.getBusinessStaticAddress() + "）");
                    AppSettingEntityKt.save(addressSetting.getBusinessStatic(), cloudServiceInfo.getBusinessStaticAddress());
                }
                if (!Intrinsics.areEqual(addressSetting.getUser().getValue(), cloudServiceInfo.getUserAddress())) {
                    Log.i(str, "用户服务地址更新：（旧：" + addressSetting.getUser().getValue() + "）-> （新：" + cloudServiceInfo.getUserAddress() + "）");
                    AppSettingEntityKt.save(addressSetting.getUser(), cloudServiceInfo.getUserAddress());
                }
                if (!Intrinsics.areEqual(addressSetting.getSearch().getValue(), cloudServiceInfo.getSearchAddress())) {
                    Log.i(str, "用户服务地址更新：（旧：" + addressSetting.getSearch().getValue() + "）-> （新：" + cloudServiceInfo.getSearchAddress() + "）");
                    AppSettingEntityKt.save(addressSetting.getSearch(), cloudServiceInfo.getSearchAddress());
                }
                if (!Intrinsics.areEqual(addressSetting.getNotice().getValue(), cloudServiceInfo.getNoticeAddress())) {
                    Log.i(str, "用户服务地址更新：（旧：" + addressSetting.getNotice().getValue() + "）-> （新：" + cloudServiceInfo.getNoticeAddress() + "）");
                    AppSettingEntityKt.save(addressSetting.getNotice(), cloudServiceInfo.getNoticeAddress());
                }
                if (!Intrinsics.areEqual(addressSetting.getStaticResource().getValue(), cloudServiceInfo.getStaticResource())) {
                    Log.i(str, "静态资源服务地址更新：（旧：" + addressSetting.getStaticResource().getValue() + "）-> （新：" + cloudServiceInfo.getStaticResource() + "）");
                    AppSettingEntityKt.save(addressSetting.getStaticResource(), cloudServiceInfo.getStaticResource());
                }
                if (Intrinsics.areEqual(addressSetting.getTrackResource().getValue(), cloudServiceInfo.getTrackResource())) {
                    return;
                }
                Log.i(str, "音频资源服务地址更新：（旧：" + addressSetting.getTrackResource().getValue() + "）-> （新：" + cloudServiceInfo.getTrackResource() + "）");
                AppSettingEntityKt.save(addressSetting.getTrackResource(), cloudServiceInfo.getTrackResource());
                return;
            }
            Log.i(str, "获取云控服务地址配置失败！");
        } catch (Exception e) {
            Log.i(tagName, "更新云控服务地址配置失败：" + e.getMessage());
        }
    }
}
