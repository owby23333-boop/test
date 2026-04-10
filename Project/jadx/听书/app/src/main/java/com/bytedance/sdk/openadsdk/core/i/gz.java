package com.bytedance.sdk.openadsdk.core.i;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.core.uy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    public interface z {
        void z();

        void z(String str);

        void z(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.bytedance.sdk.openadsdk.core.un.z zVarA = uy.ls().a();
        if (zVarA == null) {
            return;
        }
        zVarA.z((Application.ActivityLifecycleCallbacks) null);
    }

    public void z(final z zVar) {
        com.bytedance.sdk.openadsdk.core.un.z zVarA;
        if (zVar == null || (zVarA = uy.ls().a()) == null) {
            return;
        }
        zVarA.z(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sdk.openadsdk.core.i.gz.1
            private WeakReference<Object> dl;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                gz.this.z();
                zVar.z("create");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                gz.this.z();
                zVar.z(TtmlNode.START);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                gz.this.z();
                zVar.z();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                this.dl = new WeakReference<>(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                gz.this.z();
                zVar.z(z(activity));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                gz.this.z();
                zVar.z("destroy");
            }

            private boolean z(Activity activity) {
                WeakReference<Object> weakReference;
                return (activity == null || (weakReference = this.dl) == null || activity != weakReference.get()) ? false : true;
            }
        });
    }
}
