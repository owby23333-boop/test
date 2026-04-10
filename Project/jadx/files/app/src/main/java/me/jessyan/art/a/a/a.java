package me.jessyan.art.a.a;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import java.io.File;
import javax.inject.Singleton;
import me.jessyan.art.a.b.g;
import me.jessyan.art.a.b.o;
import me.jessyan.art.base.f.c;
import me.jessyan.art.d.j.a;
import me.jessyan.art.mvp.d;

/* JADX INFO: compiled from: AppComponent.java */
/* JADX INFO: loaded from: classes.dex */
@Component(modules = {me.jessyan.art.a.b.b.class, g.class, o.class})
@Singleton
public interface a {

    /* JADX INFO: renamed from: me.jessyan.art.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppComponent.java */
    @Component.Builder
    public interface InterfaceC0577a {
        @BindsInstance
        InterfaceC0577a a(Application application);

        InterfaceC0577a a(o oVar);

        a build();
    }

    a.InterfaceC0579a a();

    void a(c cVar);

    me.jessyan.art.e.c b();

    File c();

    d d();

    me.jessyan.art.d.j.a<String, Object> e();

    me.jessyan.art.c.e.c imageLoader();
}
