package com.funny.audio.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdSetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006$"}, d2 = {"Lcom/funny/audio/ad/AdSettingKey;", "", "()V", "BOOKSHELF_INTERSTITIAL", "", "getBOOKSHELF_INTERSTITIAL", "()Ljava/lang/String;", "setBOOKSHELF_INTERSTITIAL", "(Ljava/lang/String;)V", "FREE_TIME", "getFREE_TIME", "setFREE_TIME", "GLOBAL", "getGLOBAL", "setGLOBAL", "MEDIA_PLAYER_FEED", "getMEDIA_PLAYER_FEED", "setMEDIA_PLAYER_FEED", "MEDIA_PLAYER_REWARD", "getMEDIA_PLAYER_REWARD", "setMEDIA_PLAYER_REWARD", "PURE_MODE_REWARD", "getPURE_MODE_REWARD", "setPURE_MODE_REWARD", "PURE_TIME", "getPURE_TIME", "setPURE_TIME", "RESUME_SPLASH", "getRESUME_SPLASH", "setRESUME_SPLASH", "REWARD_TIME", "getREWARD_TIME", "setREWARD_TIME", "SPLASH", "getSPLASH", "setSPLASH", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdSettingKey {
    public static final AdSettingKey INSTANCE = new AdSettingKey();
    private static String GLOBAL = "KEY_AD_SETTING_GLOBAL";
    private static String SPLASH = "KEY_AD_SETTING_SPLASH";
    private static String RESUME_SPLASH = "KEY_AD_SETTING_RESUME_SPLASH";
    private static String BOOKSHELF_INTERSTITIAL = "KEY_AD_SETTING_BOOKSHELF_INTERSTITIAL";
    private static String MEDIA_PLAYER_FEED = "KEY_AD_SETTING_MEDIA_PLAYER_FEED";
    private static String MEDIA_PLAYER_REWARD = "KEY_AD_SETTING_MEDIA_PLAYER_REWARD";
    private static String PURE_MODE_REWARD = "KEY_AD_SETTING_PURE_MODE_REWARD";
    private static String FREE_TIME = "KEY_AD_SETTING_FREE_TIME";
    private static String REWARD_TIME = "KEY_AD_SETTING_REWARD_TIME";
    private static String PURE_TIME = "KEY_AD_SETTING_PURE_TIME";

    private AdSettingKey() {
    }

    public final String getGLOBAL() {
        return GLOBAL;
    }

    public final void setGLOBAL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        GLOBAL = str;
    }

    public final String getSPLASH() {
        return SPLASH;
    }

    public final void setSPLASH(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        SPLASH = str;
    }

    public final String getRESUME_SPLASH() {
        return RESUME_SPLASH;
    }

    public final void setRESUME_SPLASH(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        RESUME_SPLASH = str;
    }

    public final String getBOOKSHELF_INTERSTITIAL() {
        return BOOKSHELF_INTERSTITIAL;
    }

    public final void setBOOKSHELF_INTERSTITIAL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        BOOKSHELF_INTERSTITIAL = str;
    }

    public final String getMEDIA_PLAYER_FEED() {
        return MEDIA_PLAYER_FEED;
    }

    public final void setMEDIA_PLAYER_FEED(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        MEDIA_PLAYER_FEED = str;
    }

    public final String getMEDIA_PLAYER_REWARD() {
        return MEDIA_PLAYER_REWARD;
    }

    public final void setMEDIA_PLAYER_REWARD(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        MEDIA_PLAYER_REWARD = str;
    }

    public final String getPURE_MODE_REWARD() {
        return PURE_MODE_REWARD;
    }

    public final void setPURE_MODE_REWARD(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        PURE_MODE_REWARD = str;
    }

    public final String getFREE_TIME() {
        return FREE_TIME;
    }

    public final void setFREE_TIME(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        FREE_TIME = str;
    }

    public final String getREWARD_TIME() {
        return REWARD_TIME;
    }

    public final void setREWARD_TIME(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        REWARD_TIME = str;
    }

    public final String getPURE_TIME() {
        return PURE_TIME;
    }

    public final void setPURE_TIME(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        PURE_TIME = str;
    }
}
