package com.bytedance.sdk.component.dl.g.z.e;

import com.bytedance.sdk.component.dl.g.io;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
class dl extends gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f656a;
    private final Method dl;
    private final Method g;
    private final Class<?> gc;
    private final Method z;

    dl(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.z = method;
        this.g = method2;
        this.dl = method3;
        this.f656a = cls;
        this.gc = cls2;
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public void z(SSLSocket sSLSocket, String str, List<io> list) {
        try {
            this.z.invoke(null, sSLSocket, Proxy.newProxyInstance(gc.class.getClassLoader(), new Class[]{this.f656a, this.gc}, new z(z(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to set alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public void g(SSLSocket sSLSocket) {
        try {
            this.dl.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to remove alpn", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public String z(SSLSocket sSLSocket) {
        try {
            z zVar = (z) Proxy.getInvocationHandler(this.g.invoke(null, sSLSocket));
            if (!zVar.z && zVar.g == null) {
                g().z(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (zVar.z) {
                return null;
            }
            return zVar.g;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to get selected protocol", (Exception) e);
        }
    }

    public static gc z() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new dl(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    private static class z implements InvocationHandler {
        private final List<String> dl;
        String g;
        boolean z;

        z(List<String> list) {
            this.dl = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.bytedance.sdk.component.dl.g.z.dl.g;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.z = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.dl;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.dl.contains(list.get(i))) {
                            String str = (String) list.get(i);
                            this.g = str;
                            return str;
                        }
                    }
                    String str2 = this.dl.get(0);
                    this.g = str2;
                    return str2;
                }
            }
            if ((name.equals("protocolSelected") || name.equals("selected")) && objArr.length == 1) {
                this.g = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
