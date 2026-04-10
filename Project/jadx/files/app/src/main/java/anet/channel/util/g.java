package anet.channel.util;

import android.util.Base64;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static g a;
    private final Proxy b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f498d;

    public g(String str, int i2, String str2, String str3) {
        this.b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        this.f497c = str2;
        this.f498d = str3;
    }

    public static g a() {
        return a;
    }

    public Proxy b() {
        return this.b;
    }

    public String c() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f497c);
        sb.append(":");
        sb.append(this.f498d);
        String strEncodeToString = Base64.encodeToString(sb.toString().getBytes(), 0);
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("Basic ");
        sb2.append(strEncodeToString);
        return sb2.toString();
    }
}
