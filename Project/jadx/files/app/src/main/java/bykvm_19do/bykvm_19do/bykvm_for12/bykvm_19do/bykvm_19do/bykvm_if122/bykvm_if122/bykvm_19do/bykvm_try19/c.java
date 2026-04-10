package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f1136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f1137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Method f1138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f1139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Class<?> f1140g;

    private static class a implements InvocationHandler {
        private final List<String> a;
        boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f1141c;

        a(List<String> list) {
            this.a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.a;
            }
            if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f1141c = (String) objArr[0];
                return null;
            }
            List list = (List) objArr[0];
            int size = list.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    obj2 = this.a.get(0);
                    break;
                }
                if (this.a.contains(list.get(i2))) {
                    obj2 = list.get(i2);
                    break;
                }
                i2++;
            }
            String str = (String) obj2;
            this.f1141c = str;
            return str;
        }
    }

    c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f1136c = method;
        this.f1137d = method2;
        this.f1138e = method3;
        this.f1139f = cls;
        this.f1140g = cls2;
    }

    public static e a() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new c(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(SSLSocket sSLSocket) {
        try {
            this.f1138e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to remove alpn", (Exception) e2);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        List<String> listA = e.a(list);
        try {
            this.f1136c.invoke(null, sSLSocket, Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f1139f, this.f1140g}, new a(listA)));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to set alpn", (Exception) e2);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e
    public String b(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f1137d.invoke(null, sSLSocket));
            if (!aVar.b && aVar.f1141c == null) {
                e.b().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (aVar.b) {
                return null;
            }
            return aVar.f1141c;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("unable to get selected protocol", (Exception) e2);
        }
    }
}
