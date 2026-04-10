package me.jessyan.art.a.b;

import androidx.fragment.app.FragmentManager;
import java.util.List;

/* JADX INFO: compiled from: AppModule_ProvideFragmentLifecyclesFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements dagger.internal.b<List<FragmentManager.FragmentLifecycleCallbacks>> {
    private static final e a = new e();

    public static e a() {
        return a;
    }

    public static List<FragmentManager.FragmentLifecycleCallbacks> b() {
        return c();
    }

    public static List<FragmentManager.FragmentLifecycleCallbacks> c() {
        List<FragmentManager.FragmentLifecycleCallbacks> listA = b.a();
        dagger.internal.d.a(listA, "Cannot return null from a non-@Nullable @Provides method");
        return listA;
    }

    @Override // javax.inject.a, dagger.a
    public List<FragmentManager.FragmentLifecycleCallbacks> get() {
        return b();
    }
}
