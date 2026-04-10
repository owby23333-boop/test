package me.jessyan.art.d;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import java.util.List;
import me.jessyan.art.a.b.o;

/* JADX INFO: compiled from: ConfigModule.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {
    void a(@NonNull Context context, @NonNull List<FragmentManager.FragmentLifecycleCallbacks> list);

    void a(@NonNull Context context, @NonNull o.b bVar);

    void b(@NonNull Context context, @NonNull List<me.jessyan.art.base.f.e> list);

    void c(@NonNull Context context, @NonNull List<Application.ActivityLifecycleCallbacks> list);
}
