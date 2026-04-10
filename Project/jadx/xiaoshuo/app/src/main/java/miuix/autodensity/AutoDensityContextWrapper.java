package miuix.autodensity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes7.dex */
public class AutoDensityContextWrapper extends ContextThemeWrapper {
    private Configuration mOriginConfiguration;

    public AutoDensityContextWrapper(Context context, int i) {
        super(context, i);
    }

    public Configuration getNoOverrideConfiguration() {
        ContextThemeWrapper contextThemeWrapper = this;
        while (contextThemeWrapper.getBaseContext() instanceof ContextThemeWrapper) {
            contextThemeWrapper = (ContextThemeWrapper) contextThemeWrapper.getBaseContext();
        }
        return contextThemeWrapper.getResources().getConfiguration();
    }

    public Configuration getOriginConfiguration() {
        return this.mOriginConfiguration;
    }

    public void restoreOriginConfig() {
        getResources().getConfiguration().setTo(this.mOriginConfiguration);
        getResources().getDisplayMetrics().density = this.mOriginConfiguration.densityDpi / 160.0f;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Configuration configuration = this.mOriginConfiguration;
        displayMetrics.densityDpi = configuration.densityDpi;
        float f = configuration.fontScale;
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        float f2 = getResources().getDisplayMetrics().density;
        if (f == 0.0f) {
            f = 1.0f;
        }
        displayMetrics2.scaledDensity = f2 * f;
    }

    public void setOriginConfiguration(Configuration configuration) {
        this.mOriginConfiguration = configuration;
    }

    @RequiresApi(api = 23)
    public AutoDensityContextWrapper(Context context, Resources.Theme theme) {
        super(context, theme);
    }
}
