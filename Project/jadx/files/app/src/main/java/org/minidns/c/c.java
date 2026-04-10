package org.minidns.c;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.minidns.util.f;

/* JADX INFO: compiled from: AndroidUsingReflection.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f21383v = new c();

    protected c() {
        super(c.class.getSimpleName(), 1000);
    }

    @Override // org.minidns.c.d
    public List<String> a0() {
        ArrayList arrayList;
        InetAddress byName;
        String hostAddress;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
            arrayList = new ArrayList(5);
            for (String str : new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"}) {
                String str2 = (String) method.invoke(null, str);
                if (str2 != null && str2.length() != 0 && !arrayList.contains(str2) && (byName = InetAddress.getByName(str2)) != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0 && !arrayList.contains(hostAddress)) {
                    arrayList.add(hostAddress);
                }
            }
        } catch (Exception e2) {
            a.f21379u.log(Level.WARNING, "Exception in findDNSByReflection", (Throwable) e2);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    @Override // org.minidns.c.d
    public boolean isAvailable() {
        return f.a();
    }
}
