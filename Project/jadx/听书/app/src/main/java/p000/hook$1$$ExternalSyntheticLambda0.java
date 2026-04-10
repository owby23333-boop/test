package p000;

import android.app.Activity;
import android.os.MessageQueue;
import bhjuguyt.Loader;
import bhjuguyt.hidden.Hidden0;

/* JADX INFO: loaded from: classes5.dex */
public final class hook$1$$ExternalSyntheticLambda0 implements MessageQueue.IdleHandler {
    public final Activity f$0;
    public final String f$1;

    static {
        Loader.registerNativesForClass(1, hook$1$$ExternalSyntheticLambda0.class);
        Hidden0.special_clinit_1_20(hook$1$$ExternalSyntheticLambda0.class);
    }

    public /* synthetic */ hook$1$$ExternalSyntheticLambda0(Activity activity, String str) {
        this.f$0 = activity;
        this.f$1 = str;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final native boolean queueIdle();
}
