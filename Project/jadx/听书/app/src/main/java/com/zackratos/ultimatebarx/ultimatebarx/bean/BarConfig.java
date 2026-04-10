package com.zackratos.ultimatebarx.ultimatebarx.bean;

import com.kwad.sdk.api.model.AdnName;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BarConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010-\u001a\u00020\nH\u0016J\u0006\u0010.\u001a\u00020\u0000J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0000R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR$\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR$\u0010%\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000f¨\u00063"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig;", "", "()V", "value", "Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarBackground;", QMUISkinValueBuilder.BACKGROUND, "getBackground", "()Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarBackground;", "setBackground", "(Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarBackground;)V", "", "color", "getColor", "()I", "setColor", "(I)V", "colorRes", "getColorRes", "setColorRes", "drawableRes", "getDrawableRes", "setDrawableRes", "fitWindow", "", "getFitWindow", "()Z", "setFitWindow", "(Z)V", "light", "getLight", "setLight", "lvlBackground", "getLvlBackground", "setLvlBackground", "lvlColor", "getLvlColor", "setLvlColor", "lvlColorRes", "getLvlColorRes", "setLvlColorRes", "lvlDrawableRes", "getLvlDrawableRes", "setLvlDrawableRes", "equals", AdnName.OTHER, "hashCode", "transparent", "update", "", "config", "Companion", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public final class BarConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private BarBackground background;
    private boolean fitWindow;
    private boolean light;
    private BarBackground lvlBackground;

    public BarConfig() {
        BarBackground barBackgroundNewInstance = BarBackground.newInstance();
        Intrinsics.checkExpressionValueIsNotNull(barBackgroundNewInstance, "BarBackground.newInstance()");
        this.background = barBackgroundNewInstance;
        BarBackground barBackgroundNewInstance2 = BarBackground.newInstance();
        Intrinsics.checkExpressionValueIsNotNull(barBackgroundNewInstance2, "BarBackground.newInstance()");
        this.lvlBackground = barBackgroundNewInstance2;
    }

    /* JADX INFO: compiled from: BarConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig$Companion;", "", "()V", "newInstance", "Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig;", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BarConfig newInstance() {
            BarConfig barConfig = new BarConfig();
            barConfig.getBackground().defaultBg();
            barConfig.getLvlBackground().defaultBg();
            barConfig.setFitWindow(true);
            barConfig.setLight(false);
            return barConfig;
        }
    }

    public final boolean getFitWindow() {
        return this.fitWindow;
    }

    public final void setFitWindow(boolean z) {
        this.fitWindow = z;
    }

    public final BarBackground getBackground() {
        return this.background;
    }

    public final void setBackground(BarBackground value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.background.update(value);
    }

    public final boolean getLight() {
        return this.light;
    }

    public final void setLight(boolean z) {
        this.light = z;
    }

    public final BarBackground getLvlBackground() {
        return this.lvlBackground;
    }

    public final void setLvlBackground(BarBackground value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        this.lvlBackground.update(value);
    }

    public final int getColor() {
        return this.background.getColor();
    }

    public final void setColor(int i) {
        this.background.setColor(i);
    }

    public final int getColorRes() {
        return this.background.getColorRes();
    }

    public final void setColorRes(int i) {
        this.background.setColorRes(i);
    }

    public final int getDrawableRes() {
        return this.background.getDrawableRes();
    }

    public final void setDrawableRes(int i) {
        this.background.setDrawableRes(i);
    }

    public final int getLvlColor() {
        return this.lvlBackground.getColor();
    }

    public final void setLvlColor(int i) {
        this.lvlBackground.setColor(i);
    }

    public final int getLvlColorRes() {
        return this.lvlBackground.getColorRes();
    }

    public final void setLvlColorRes(int i) {
        this.lvlBackground.setColorRes(i);
    }

    public final int getLvlDrawableRes() {
        return this.lvlBackground.getDrawableRes();
    }

    public final void setLvlDrawableRes(int i) {
        this.lvlBackground.setDrawableRes(i);
    }

    public final BarConfig transparent() {
        this.fitWindow = false;
        this.background.transparent();
        return this;
    }

    public final void update(BarConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (Intrinsics.areEqual(config, this)) {
            return;
        }
        this.fitWindow = config.fitWindow;
        this.background.update(config.background);
        this.lvlBackground.update(config.lvlBackground);
        this.light = config.light;
    }

    public boolean equals(Object other) {
        if (!(other instanceof BarConfig)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        BarConfig barConfig = (BarConfig) other;
        return this.light == barConfig.light && Intrinsics.areEqual(this.background, barConfig.background) && Intrinsics.areEqual(this.lvlBackground, barConfig.lvlBackground) && this.fitWindow == barConfig.fitWindow;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.light), Boolean.valueOf(this.fitWindow), this.background, this.lvlBackground);
    }
}
