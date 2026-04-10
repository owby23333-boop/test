package com.duokan.reader.common;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityResultObserver implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActivityResultRegistry f3975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActivityResultLauncher<String[]> f3976b;
    public WeakReference<ActivityResultCallback<List<Uri>>> c;

    public ActivityResultObserver(@NonNull ActivityResultRegistry activityResultRegistry) {
        this.f3975a = activityResultRegistry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(List list) {
        if (this.c.get() != null) {
            this.c.get().onActivityResult(list);
            this.c.clear();
        }
    }

    public void b(ActivityResultCallback<List<Uri>> activityResultCallback, String[] strArr) {
        this.c = new WeakReference<>(activityResultCallback);
        this.f3976b.launch(strArr);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(@NonNull LifecycleOwner lifecycleOwner) {
        this.f3976b = this.f3975a.register("ImportLocalBookLauncherObserver:" + lifecycleOwner.hashCode(), lifecycleOwner, new ActivityResultContracts.OpenMultipleDocuments(), new ActivityResultCallback() { // from class: com.yuewen.d5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                this.f10089a.c((List) obj);
            }
        });
    }
}
