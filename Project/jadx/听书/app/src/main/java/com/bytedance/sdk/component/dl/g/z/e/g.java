package com.bytedance.sdk.component.dl.g.z.e;

import com.bytedance.sdk.component.dl.g.io;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes2.dex */
final class g extends gc {
    final Method g;
    final Method z;

    g(Method method, Method method2) {
        this.z = method;
        this.g = method2;
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public void z(SSLSocket sSLSocket, String str, List<io> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listZ = z(list);
            this.z.invoke(sSLParameters, listZ.toArray(new String[listZ.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.bytedance.sdk.component.dl.g.z.e.gc
    public String z(SSLSocket sSLSocket) {
        try {
            String str = (String) this.g.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.bytedance.sdk.component.dl.g.z.dl.z("unable to get selected protocols", (Exception) e);
        }
    }

    public static g z() {
        try {
            return new g(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
