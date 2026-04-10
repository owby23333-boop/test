package org.minidns.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import org.minidns.util.f;

/* JADX INFO: compiled from: AndroidUsingExec.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final d f21382v = new b();

    private b() {
        super(b.class.getSimpleName(), 999);
    }

    protected static Set<String> a(BufferedReader bufferedReader, boolean z2) throws IOException {
        String hostAddress;
        HashSet hashSet = new HashSet(6);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return hashSet;
            }
            int iIndexOf = line.indexOf("]: [");
            if (iIndexOf != -1) {
                String strSubstring = line.substring(1, iIndexOf);
                int i2 = iIndexOf + 4;
                int length = line.length() - 1;
                if (length >= i2) {
                    String strSubstring2 = line.substring(i2, length);
                    if (!strSubstring2.isEmpty() && (strSubstring.endsWith(".dns") || strSubstring.endsWith(".dns1") || strSubstring.endsWith(".dns2") || strSubstring.endsWith(".dns3") || strSubstring.endsWith(".dns4"))) {
                        InetAddress byName = InetAddress.getByName(strSubstring2);
                        if (byName != null && (hostAddress = byName.getHostAddress()) != null && hostAddress.length() != 0) {
                            hashSet.add(hostAddress);
                        }
                    }
                } else if (z2) {
                    a.f21379u.warning("Malformed property detected: \"" + line + '\"');
                }
            }
        }
    }

    @Override // org.minidns.c.d
    public List<String> a0() {
        try {
            Set<String> setA = a(new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream(), StandardCharsets.UTF_8)), true);
            if (setA.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(setA.size());
            arrayList.addAll(setA);
            return arrayList;
        } catch (IOException e2) {
            a.f21379u.log(Level.WARNING, "Exception in findDNSByExec", (Throwable) e2);
            return null;
        }
    }

    @Override // org.minidns.c.d
    public boolean isAvailable() {
        return f.a();
    }
}
