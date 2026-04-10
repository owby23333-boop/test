package com.funny.audio.view;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.funny.audio.R;
import com.umeng.analytics.pro.d;
import es.dmoral.toasty.Toasty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/funny/audio/view/DialogUtils;", "", "()V", "appIcon", "Landroid/graphics/drawable/Drawable;", "getAppIcon", "()Landroid/graphics/drawable/Drawable;", "setAppIcon", "(Landroid/graphics/drawable/Drawable;)V", d.R, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "init", "", "tip", "tipText", "", "OnButtonClickListener", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialogUtils {
    public static final DialogUtils INSTANCE = new DialogUtils();
    private static Drawable appIcon;
    private static Application context;

    /* JADX INFO: compiled from: DialogUtils.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/funny/audio/view/DialogUtils$OnButtonClickListener;", "", "onClick", "", "v", "Landroid/view/View;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnButtonClickListener {
        boolean onClick(View v);
    }

    private DialogUtils() {
    }

    public final Application getContext() {
        return context;
    }

    public final void setContext(Application application) {
        context = application;
    }

    public final Drawable getAppIcon() {
        return appIcon;
    }

    public final void setAppIcon(Drawable drawable) {
        appIcon = drawable;
    }

    public final void init(Application context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        appIcon = ContextCompat.getDrawable(context2, R.mipmap.ic_logo);
        Toasty.Config.getInstance().allowQueue(false).tintIcon(false).apply();
    }

    public final void tip(String tipText) {
        Intrinsics.checkNotNullParameter(tipText, "tipText");
        Application application = context;
        if (application != null) {
            Application application2 = application;
            Toasty.custom((Context) application2, (CharSequence) tipText, appIcon, ContextCompat.getColor(application2, R.color.toast_dialog_background), ContextCompat.getColor(application2, R.color.primary_text_color), 2000, true, true).show();
        }
    }
}
