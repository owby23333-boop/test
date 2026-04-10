package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private IProgressRemoteView afc;

    private c(IProgressRemoteView iProgressRemoteView) {
        this.afc = iProgressRemoteView;
    }

    @Nullable
    public static c a(Context context, int i2, boolean z2) {
        c cVar;
        try {
            cVar = ((e) ServiceProvider.get(e.class)).getApiVersionCode() >= 3031000 ? new c(RemoteViewBuilder.createProgressView(context, i2, z2)) : new c(RemoteViewBuilder.createProgressView(context));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            cVar = null;
        }
        if (cVar == null) {
            try {
                return new c(RemoteViewBuilder.createProgressView(context));
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
            }
        }
        return cVar;
    }

    final RemoteViews build() {
        IProgressRemoteView iProgressRemoteView = this.afc;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }

    public final void setControlBtnPaused(boolean z2) {
        try {
            if (this.afc != null) {
                this.afc.setControlBtnPaused(z2);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public final void setIcon(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.afc;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public final void setName(String str) {
        IProgressRemoteView iProgressRemoteView = this.afc;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public final void setPercentNum(String str) {
        IProgressRemoteView iProgressRemoteView = this.afc;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }

    public final void setProgress(int i2, int i3, boolean z2) {
        IProgressRemoteView iProgressRemoteView = this.afc;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(100, i3, false);
        }
    }

    public final void setSize(String str) {
        IProgressRemoteView iProgressRemoteView = this.afc;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public final void setStatus(String str) {
        IProgressRemoteView iProgressRemoteView = this.afc;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }
}
