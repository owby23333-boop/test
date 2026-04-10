package anet.channel.util;

import java.net.Inet6Address;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public int a;
    public Inet6Address b;

    public f(Inet6Address inet6Address, int i2) {
        this.a = i2;
        this.b = inet6Address;
    }

    public String toString() {
        return this.b.getHostAddress() + "/" + this.a;
    }
}
