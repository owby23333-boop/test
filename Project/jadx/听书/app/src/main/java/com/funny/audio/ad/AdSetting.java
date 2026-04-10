package com.funny.audio.ad;

import android.content.Context;
import com.funny.audio.AppManager;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.AdSettingEntity;
import com.funny.audio.models.AdInfo;
import com.funny.audio.settings.AppSettingEntity;
import com.funny.audio.settings.AppSettingEntityKt;
import com.funny.audio.settings.AppSettings;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b¨\u0006."}, d2 = {"Lcom/funny/audio/ad/AdSetting;", "", "()V", "bookshelfInterstitialAd", "Lcom/funny/audio/database/entities/AdSettingEntity;", "getBookshelfInterstitialAd", "()Lcom/funny/audio/database/entities/AdSettingEntity;", "setBookshelfInterstitialAd", "(Lcom/funny/audio/database/entities/AdSettingEntity;)V", "freeTime", "Lcom/funny/audio/settings/AppSettingEntity;", "getFreeTime", "()Lcom/funny/audio/settings/AppSettingEntity;", "setFreeTime", "(Lcom/funny/audio/settings/AppSettingEntity;)V", "globalAd", "getGlobalAd", "setGlobalAd", "mediaPlayerFeedAd", "getMediaPlayerFeedAd", "setMediaPlayerFeedAd", "mediaPlayerRewardAd", "getMediaPlayerRewardAd", "setMediaPlayerRewardAd", "pureModeRewardAd", "getPureModeRewardAd", "setPureModeRewardAd", "pureTime", "getPureTime", "setPureTime", "resumeBookshelfTime", "", "getResumeBookshelfTime", "()J", "setResumeBookshelfTime", "(J)V", "resumeSplashAd", "getResumeSplashAd", "setResumeSplashAd", "rewardTime", "getRewardTime", "setRewardTime", "splashAd", "getSplashAd", "setSplashAd", "Companion", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdSetting {
    private static AdSetting _current;
    private AppSettingEntity freeTime;
    private AppSettingEntity pureTime;
    private long resumeBookshelfTime;
    private AppSettingEntity rewardTime;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_TYPE = "KEY_AD_SETTING";
    private static final Lazy<AdSetting> current$delegate = LazyKt.lazy(new Function0<AdSetting>() { // from class: com.funny.audio.ad.AdSetting$Companion$current$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AdSetting invoke() {
            AdSetting adSetting = AdSetting._current;
            Intrinsics.checkNotNull(adSetting);
            return adSetting;
        }
    });
    private AdSettingEntity globalAd = new AdSettingEntity();
    private AdSettingEntity splashAd = new AdSettingEntity();
    private AdSettingEntity resumeSplashAd = new AdSettingEntity();
    private AdSettingEntity bookshelfInterstitialAd = new AdSettingEntity();
    private AdSettingEntity mediaPlayerFeedAd = new AdSettingEntity();
    private AdSettingEntity mediaPlayerRewardAd = new AdSettingEntity();
    private AdSettingEntity pureModeRewardAd = new AdSettingEntity();

    public AdSetting() {
        AppSettings appSettings = AppSettings.INSTANCE;
        String str = KEY_TYPE;
        this.freeTime = appSettings.createSetting(str, AdSettingKey.INSTANCE.getFREE_TIME(), -1L);
        this.rewardTime = AppSettings.INSTANCE.createSetting(str, AdSettingKey.INSTANCE.getREWARD_TIME(), 0L);
        this.pureTime = AppSettings.INSTANCE.createSetting(str, AdSettingKey.INSTANCE.getPURE_TIME(), 0L);
    }

    public final AdSettingEntity getGlobalAd() {
        return this.globalAd;
    }

    public final void setGlobalAd(AdSettingEntity adSettingEntity) {
        Intrinsics.checkNotNullParameter(adSettingEntity, "<set-?>");
        this.globalAd = adSettingEntity;
    }

    public final AdSettingEntity getSplashAd() {
        return this.splashAd;
    }

    public final void setSplashAd(AdSettingEntity adSettingEntity) {
        Intrinsics.checkNotNullParameter(adSettingEntity, "<set-?>");
        this.splashAd = adSettingEntity;
    }

    public final AdSettingEntity getResumeSplashAd() {
        return this.resumeSplashAd;
    }

    public final void setResumeSplashAd(AdSettingEntity adSettingEntity) {
        Intrinsics.checkNotNullParameter(adSettingEntity, "<set-?>");
        this.resumeSplashAd = adSettingEntity;
    }

    public final AdSettingEntity getBookshelfInterstitialAd() {
        return this.bookshelfInterstitialAd;
    }

    public final void setBookshelfInterstitialAd(AdSettingEntity adSettingEntity) {
        Intrinsics.checkNotNullParameter(adSettingEntity, "<set-?>");
        this.bookshelfInterstitialAd = adSettingEntity;
    }

    public final AdSettingEntity getMediaPlayerFeedAd() {
        return this.mediaPlayerFeedAd;
    }

    public final void setMediaPlayerFeedAd(AdSettingEntity adSettingEntity) {
        Intrinsics.checkNotNullParameter(adSettingEntity, "<set-?>");
        this.mediaPlayerFeedAd = adSettingEntity;
    }

    public final AdSettingEntity getMediaPlayerRewardAd() {
        return this.mediaPlayerRewardAd;
    }

    public final void setMediaPlayerRewardAd(AdSettingEntity adSettingEntity) {
        Intrinsics.checkNotNullParameter(adSettingEntity, "<set-?>");
        this.mediaPlayerRewardAd = adSettingEntity;
    }

    public final AdSettingEntity getPureModeRewardAd() {
        return this.pureModeRewardAd;
    }

    public final void setPureModeRewardAd(AdSettingEntity adSettingEntity) {
        Intrinsics.checkNotNullParameter(adSettingEntity, "<set-?>");
        this.pureModeRewardAd = adSettingEntity;
    }

    public final AppSettingEntity getFreeTime() {
        return this.freeTime;
    }

    public final void setFreeTime(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.freeTime = appSettingEntity;
    }

    public final AppSettingEntity getRewardTime() {
        return this.rewardTime;
    }

    public final void setRewardTime(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.rewardTime = appSettingEntity;
    }

    public final AppSettingEntity getPureTime() {
        return this.pureTime;
    }

    public final void setPureTime(AppSettingEntity appSettingEntity) {
        Intrinsics.checkNotNullParameter(appSettingEntity, "<set-?>");
        this.pureTime = appSettingEntity;
    }

    public final long getResumeBookshelfTime() {
        return this.resumeBookshelfTime;
    }

    public final void setResumeBookshelfTime(long j) {
        this.resumeBookshelfTime = j;
    }

    /* JADX INFO: compiled from: AdSetting.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/funny/audio/ad/AdSetting$Companion;", "", "()V", "KEY_TYPE", "", "_current", "Lcom/funny/audio/ad/AdSetting;", "current", "getCurrent", "()Lcom/funny/audio/ad/AdSetting;", "current$delegate", "Lkotlin/Lazy;", "load", d.R, "Landroid/content/Context;", "setUp", "", "adInfos", "", "Lcom/funny/audio/models/AdInfo;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AdSetting getCurrent() {
            return (AdSetting) AdSetting.current$delegate.getValue();
        }

        public final AdSetting load(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AdSetting adSetting = new AdSetting();
            List<AppSettingEntity> list = AppSettings.INSTANCE.getList(AdSetting.KEY_TYPE);
            if (!list.isEmpty()) {
                for (AppSettingEntity appSettingEntity : list) {
                    String settingKey = appSettingEntity.getSettingKey();
                    if (Intrinsics.areEqual(settingKey, AdSettingKey.INSTANCE.getFREE_TIME())) {
                        adSetting.setFreeTime(appSettingEntity);
                    } else if (Intrinsics.areEqual(settingKey, AdSettingKey.INSTANCE.getREWARD_TIME())) {
                        adSetting.setRewardTime(appSettingEntity);
                    } else if (Intrinsics.areEqual(settingKey, AdSettingKey.INSTANCE.getPURE_TIME())) {
                        adSetting.setPureTime(appSettingEntity);
                    }
                }
            }
            for (AdSettingEntity adSettingEntity : DbContext.INSTANCE.getCurrent().adSetting().all()) {
                String key = adSettingEntity.getKey();
                if (Intrinsics.areEqual(key, AdSettingKey.INSTANCE.getGLOBAL())) {
                    adSetting.setGlobalAd(adSettingEntity);
                    if (adSetting.getFreeTime().getValueLong() == -1 && adSettingEntity.getFreeTime() > 0) {
                        AppSettingEntityKt.save(adSetting.getFreeTime(), Long.valueOf(System.currentTimeMillis() + adSettingEntity.getFreeTime()));
                    }
                    String psign = AppManager.INSTANCE.getPsign();
                    if (!(psign == null || psign.length() == 0)) {
                        if ((adSettingEntity.getPsign().length() > 0) && !Intrinsics.areEqual(AppManager.INSTANCE.getPsign(), adSettingEntity.getPsign())) {
                            System.exit(0);
                        }
                    }
                } else if (Intrinsics.areEqual(key, AdSettingKey.INSTANCE.getSPLASH())) {
                    adSetting.setSplashAd(adSettingEntity);
                } else if (Intrinsics.areEqual(key, AdSettingKey.INSTANCE.getRESUME_SPLASH())) {
                    adSetting.setResumeSplashAd(adSettingEntity);
                } else if (Intrinsics.areEqual(key, AdSettingKey.INSTANCE.getBOOKSHELF_INTERSTITIAL())) {
                    adSetting.setBookshelfInterstitialAd(adSettingEntity);
                } else if (Intrinsics.areEqual(key, AdSettingKey.INSTANCE.getMEDIA_PLAYER_FEED())) {
                    adSetting.setMediaPlayerFeedAd(adSettingEntity);
                } else if (Intrinsics.areEqual(key, AdSettingKey.INSTANCE.getMEDIA_PLAYER_REWARD())) {
                    adSetting.setMediaPlayerRewardAd(adSettingEntity);
                } else if (Intrinsics.areEqual(key, AdSettingKey.INSTANCE.getPURE_MODE_REWARD())) {
                    adSetting.setPureModeRewardAd(adSettingEntity);
                }
            }
            AdSetting._current = adSetting;
            return adSetting;
        }

        public final void setUp(List<AdInfo> adInfos) {
            Intrinsics.checkNotNullParameter(adInfos, "adInfos");
            ArrayList arrayList = new ArrayList();
            for (AdInfo adInfo : adInfos) {
                AdSettingEntity adSettingEntity = new AdSettingEntity();
                adSettingEntity.setId(adInfo.getId());
                adSettingEntity.setKey(adInfo.getKey());
                adSettingEntity.setName(adInfo.getName());
                adSettingEntity.setPsign(adInfo.getPsign());
                adSettingEntity.setShow(adInfo.getShow());
                adSettingEntity.setFreeTime(adInfo.getFreeTime());
                adSettingEntity.setRewardDuration(adInfo.getRewardDuration());
                adSettingEntity.setAdType(adInfo.getAdType());
                adSettingEntity.setMaxShowCount(adInfo.getMaxShowCount());
                adSettingEntity.setPreloadInterval(adInfo.getPreloadInterval());
                adSettingEntity.setShowInterval(adInfo.getShowInterval());
                adSettingEntity.setCodeId(adInfo.getCodeId());
                adSettingEntity.setDescription(adInfo.getDescription());
                adSettingEntity.setCreateTime(System.currentTimeMillis());
                adSettingEntity.setUpdateTime(System.currentTimeMillis());
                arrayList.add(adSettingEntity);
            }
            if (CollectionsKt.any(arrayList)) {
                DbContext.INSTANCE.getCurrent().adSetting().addList(arrayList);
            }
        }
    }
}
