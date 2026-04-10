package me.jessyan.art.mvp;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.internal.RxCache;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.jessyan.art.d.j.a;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: RepositoryManager.java */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
public class f implements d {

    @Inject
    dagger.a<Retrofit> a;

    @Inject
    dagger.a<RxCache> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    Application f21209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Inject
    a.InterfaceC0579a f21210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private me.jessyan.art.d.j.a<String, b> f21211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private me.jessyan.art.d.j.a<String, Object> f21212f;

    /* JADX INFO: compiled from: RepositoryManager.java */
    class a implements InvocationHandler {
        final /* synthetic */ Class a;

        a(Class cls) {
            this.a = cls;
        }

        public /* synthetic */ ObservableSource a(Class cls, Method method, Object[] objArr) throws Exception {
            Object objE = f.this.e(cls);
            return ((Observable) f.this.a(objE, method).invoke(objE, objArr)).subscribeOn(Schedulers.io());
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, final Method method, @Nullable final Object[] objArr) throws Throwable {
            if (method.getReturnType() == Observable.class) {
                final Class cls = this.a;
                return Observable.defer(new Callable() { // from class: me.jessyan.art.mvp.a
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f21205s.a(cls, method, objArr);
                    }
                }).subscribeOn(Schedulers.single());
            }
            Object objE = f.this.e(this.a);
            return f.this.a(objE, method).invoke(objE, objArr);
        }
    }

    @Inject
    public f() {
    }

    private <T> T c(Class<T> cls) {
        me.jessyan.art.f.g.a(cls, "serviceClass == null");
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    private static Constructor<? extends b> d(Class<?> cls) {
        String name = cls.getName();
        try {
            return cls.getConstructor(d.class);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Unable to find constructor for " + name, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T> T e(Class<T> cls) {
        if (this.f21212f == null) {
            this.f21212f = this.f21210d.a(me.jessyan.art.d.j.b.b);
        }
        me.jessyan.art.f.g.a(this.f21212f, "Cannot return null from a Cache.Factory#build(int) method");
        T t2 = (T) this.f21212f.get(cls.getCanonicalName());
        if (t2 != null) {
            return t2;
        }
        T t3 = (T) this.a.get().create(cls);
        this.f21212f.put(cls.getCanonicalName(), t3);
        return t3;
    }

    @Override // me.jessyan.art.mvp.d
    @NonNull
    public synchronized <T extends b> T b(@NonNull Class<T> cls) {
        T t2;
        me.jessyan.art.f.g.a(cls, "repository == null");
        if (this.f21211e == null) {
            this.f21211e = this.f21210d.a(me.jessyan.art.d.j.b.a);
        }
        me.jessyan.art.f.g.a(this.f21211e, "Cannot return null from a Cache.Factory#build(int) method");
        t2 = (T) this.f21211e.get(cls.getCanonicalName());
        if (t2 == null) {
            Constructor<? extends b> constructorD = d(cls);
            try {
                b bVarNewInstance = constructorD.newInstance(this);
                this.f21211e.put(cls.getCanonicalName(), bVarNewInstance);
                t2 = (T) bVarNewInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Unable to invoke " + constructorD, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Unable to invoke " + constructorD, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Create repository error", e4);
            }
        }
        return t2;
    }

    @Override // me.jessyan.art.mvp.d
    @NonNull
    public Context getContext() {
        return this.f21209c;
    }

    @Override // me.jessyan.art.mvp.d
    @NonNull
    public synchronized <T> T a(@NonNull Class<T> cls) {
        return (T) c(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> Method a(T t2, Method method) throws NoSuchMethodException {
        return t2.getClass().getMethod(method.getName(), method.getParameterTypes());
    }
}
