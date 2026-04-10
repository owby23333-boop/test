package me.jessyan.art.a.b;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import me.jessyan.art.d.j.a;

/* JADX INFO: compiled from: AppModule.java */
/* JADX INFO: loaded from: classes3.dex */
@Module
public abstract class b {

    /* JADX INFO: compiled from: AppModule.java */
    public interface a {
        void a(@NonNull Context context, @NonNull GsonBuilder gsonBuilder);
    }

    @Provides
    @Singleton
    static Gson a(Application application, @Nullable a aVar) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (aVar != null) {
            aVar.a(application, gsonBuilder);
        }
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    static me.jessyan.art.d.d a(Application application) {
        return me.jessyan.art.d.d.e().a(application);
    }

    @Provides
    @Singleton
    static me.jessyan.art.d.j.a<String, Object> a(a.InterfaceC0579a interfaceC0579a) {
        return interfaceC0579a.a(me.jessyan.art.d.j.b.f21177c);
    }

    @Provides
    @Singleton
    static List<FragmentManager.FragmentLifecycleCallbacks> a() {
        return new ArrayList();
    }
}
