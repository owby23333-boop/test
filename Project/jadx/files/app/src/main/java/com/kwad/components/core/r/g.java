package com.kwad.components.core.r;

import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bo;
import com.taobao.accs.common.Constants;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static final AtomicBoolean PV = new AtomicBoolean(false);
    private static volatile g PW;
    private Context PX;
    private a PY;

    private g(Context context) {
        this.PX = bo.dt(context);
    }

    public static g at(@NonNull Context context) {
        if (PW == null) {
            synchronized (g.class) {
                if (PW == null) {
                    PW = new g(context);
                }
            }
        }
        return PW;
    }

    private void qg() {
        Context context;
        if (!PV.get() || (context = this.PX) == null) {
            return;
        }
        context.unregisterReceiver(this.PY);
        PV.set(false);
    }

    public final void qf() {
        if (this.PX == null || PV.get()) {
            return;
        }
        if (this.PY == null) {
            this.PY = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme(Constants.KEY_PACKAGE);
        this.PX.registerReceiver(this.PY, intentFilter);
        PV.set(true);
    }

    public final void qh() {
        qg();
    }
}
