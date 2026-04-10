package miuix.responsive.interfaces;

import android.content.res.Configuration;
import miuix.responsive.map.ResponsiveState;
import miuix.responsive.map.ScreenSpec;

/* JADX INFO: loaded from: classes8.dex */
public interface IResponsive<T> {
    default void dispatchResponsiveLayout(Configuration configuration, ScreenSpec screenSpec, boolean z) {
        onResponsiveLayout(configuration, screenSpec, z);
    }

    ResponsiveState getResponsiveState();

    T getResponsiveSubject();

    void onResponsiveLayout(Configuration configuration, ScreenSpec screenSpec, boolean z);
}
