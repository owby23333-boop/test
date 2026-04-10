package org.minidns;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import org.minidns.AbstractDnsClient;
import org.minidns.MiniDnsException;
import org.minidns.c.c;
import org.minidns.c.d;
import org.minidns.c.e;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.edns.Edns;
import org.minidns.util.MultipleIoException;

/* JADX INFO: compiled from: DnsClient.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends AbstractDnsClient {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final List<d> f21371n = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final Set<Inet4Address> f21372o = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final Set<Inet6Address> f21373p = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Set<String> f21374q;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set<InetAddress> f21375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f21376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f21377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f21378m;

    /* JADX INFO: compiled from: DnsClient.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[DnsMessage.RESPONSE_CODE.values().length];

        static {
            try {
                b[DnsMessage.RESPONSE_CODE.NO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[DnsMessage.RESPONSE_CODE.NX_DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = new int[AbstractDnsClient.IpVersionSetting.values().length];
            try {
                a[AbstractDnsClient.IpVersionSetting.v4v6.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AbstractDnsClient.IpVersionSetting.v6v4.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AbstractDnsClient.IpVersionSetting.v4only.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AbstractDnsClient.IpVersionSetting.v6only.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        a(org.minidns.c.b.f21382v);
        a(c.f21383v);
        a(e.f21384v);
        try {
            f21372o.add(org.minidns.util.e.a("8.8.8.8"));
        } catch (IllegalArgumentException e2) {
            AbstractDnsClient.f21358h.log(Level.WARNING, "Could not add static IPv4 DNS Server", (Throwable) e2);
        }
        try {
            f21373p.add(org.minidns.util.e.b("[2001:4860:4860::8888]"));
        } catch (IllegalArgumentException e3) {
            AbstractDnsClient.f21358h.log(Level.WARNING, "Could not add static IPv6 DNS Server", (Throwable) e3);
        }
        f21374q = Collections.newSetFromMap(new ConcurrentHashMap(4));
    }

    public b() {
        this.f21375j = Collections.newSetFromMap(new ConcurrentHashMap(4));
        this.f21376k = false;
        this.f21377l = false;
        this.f21378m = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        r4 = r2.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r4.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        r5 = r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
    
        if (org.minidns.util.e.c(r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        org.minidns.AbstractDnsClient.f21358h.warning("The DNS server lookup mechanism '" + r3.getName() + "' returned an invalid non-IP address result: '" + r5 + "'");
        r4.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (org.minidns.b.f21374q.contains(r5) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        org.minidns.AbstractDnsClient.f21358h.fine("The DNS server lookup mechanism '" + r3.getName() + "' returned a blacklisted result: '" + r5 + "'");
        r4.remove();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009a, code lost:
    
        if (r2.isEmpty() != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> c() {
        /*
            java.util.List<org.minidns.c.d> r0 = org.minidns.b.f21371n
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L7:
            r2 = r1
        L8:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto Lbc
            java.lang.Object r3 = r0.next()
            org.minidns.c.d r3 = (org.minidns.c.d) r3
            java.util.List r2 = r3.a0()     // Catch: java.lang.SecurityException -> L19
            goto L23
        L19:
            r4 = move-exception
            java.util.logging.Logger r5 = org.minidns.AbstractDnsClient.f21358h
            java.util.logging.Level r6 = java.util.logging.Level.WARNING
            java.lang.String r7 = "Could not lookup DNS server"
            r5.log(r6, r7, r4)
        L23:
            if (r2 != 0) goto L26
            goto L8
        L26:
            java.util.Iterator r4 = r2.iterator()
        L2a:
            boolean r5 = r4.hasNext()
            java.lang.String r6 = "The DNS server lookup mechanism '"
            if (r5 == 0) goto L96
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r7 = org.minidns.util.e.c(r5)
            java.lang.String r8 = "'"
            if (r7 != 0) goto L67
            java.util.logging.Logger r7 = org.minidns.AbstractDnsClient.f21358h
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            java.lang.String r6 = r3.getName()
            r9.append(r6)
            java.lang.String r6 = "' returned an invalid non-IP address result: '"
            r9.append(r6)
            r9.append(r5)
            r9.append(r8)
            java.lang.String r5 = r9.toString()
            r7.warning(r5)
            r4.remove()
            goto L2a
        L67:
            java.util.Set<java.lang.String> r7 = org.minidns.b.f21374q
            boolean r7 = r7.contains(r5)
            if (r7 == 0) goto L2a
            java.util.logging.Logger r7 = org.minidns.AbstractDnsClient.f21358h
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            java.lang.String r6 = r3.getName()
            r9.append(r6)
            java.lang.String r6 = "' returned a blacklisted result: '"
            r9.append(r6)
            r9.append(r5)
            r9.append(r8)
            java.lang.String r5 = r9.toString()
            r7.fine(r5)
            r4.remove()
            goto L2a
        L96:
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L9d
            goto Lbc
        L9d:
            java.util.logging.Logger r2 = org.minidns.AbstractDnsClient.f21358h
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.String r3 = r3.getName()
            r4.append(r3)
            java.lang.String r3 = "' returned not a single valid IP address after sanitazion"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.warning(r3)
            goto L7
        Lbc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.b.c():java.util.List");
    }

    public static List<InetAddress> d() {
        List<String> listC = c();
        if (listC == null) {
            return new ArrayList();
        }
        AbstractDnsClient.IpVersionSetting ipVersionSetting = AbstractDnsClient.f21359i;
        ArrayList arrayList = ipVersionSetting.f21369s ? new ArrayList(listC.size()) : null;
        ArrayList arrayList2 = ipVersionSetting.f21370t ? new ArrayList(listC.size()) : null;
        int i2 = 0;
        for (String str : listC) {
            try {
                InetAddress byName = InetAddress.getByName(str);
                if (!(byName instanceof Inet4Address)) {
                    if (!(byName instanceof Inet6Address)) {
                        throw new AssertionError("The address '" + byName + "' is neither of type Inet(4|6)Address");
                    }
                    if (ipVersionSetting.f21370t) {
                        arrayList2.add((Inet6Address) byName);
                        i2++;
                    }
                } else if (ipVersionSetting.f21369s) {
                    arrayList.add((Inet4Address) byName);
                    i2++;
                }
            } catch (UnknownHostException e2) {
                AbstractDnsClient.f21358h.log(Level.SEVERE, "Could not transform '" + str + "' to InetAddress", (Throwable) e2);
            }
        }
        ArrayList arrayList3 = new ArrayList(i2);
        int i3 = a.a[ipVersionSetting.ordinal()];
        if (i3 == 1) {
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
        } else if (i3 == 2) {
            arrayList3.addAll(arrayList2);
            arrayList3.addAll(arrayList);
        } else if (i3 == 3) {
            arrayList3.addAll(arrayList);
        } else if (i3 == 4) {
            arrayList3.addAll(arrayList2);
        }
        return arrayList3;
    }

    private List<InetAddress> e() {
        InetAddress inetAddressB;
        List<InetAddress> listD = d();
        if (this.f21378m) {
            InetAddress inetAddressA = null;
            int i2 = a.a[this.f21363f.ordinal()];
            if (i2 == 1) {
                inetAddressB = b();
                inetAddressA = a();
            } else if (i2 == 2) {
                inetAddressB = a();
                inetAddressA = b();
            } else if (i2 == 3) {
                inetAddressB = b();
            } else {
                if (i2 != 4) {
                    throw new AssertionError("Unknown ipVersionSetting: " + this.f21363f);
                }
                inetAddressB = a();
            }
            listD.add(inetAddressB);
            if (inetAddressA != null) {
                listD.add(inetAddressA);
            }
        }
        return listD;
    }

    @Override // org.minidns.AbstractDnsClient
    protected DnsMessage.b a(DnsMessage.b bVar) {
        bVar.a(true);
        Edns.b bVarB = bVar.b();
        bVarB.a(this.f21362e.a());
        bVarB.a(this.f21376k);
        return bVar;
    }

    public InetAddress b() {
        return (InetAddress) org.minidns.util.c.a(f21372o, this.f21360c);
    }

    @Override // org.minidns.AbstractDnsClient
    public DnsQueryResult query(DnsMessage.b bVar) throws IOException {
        int i2;
        DnsMessage dnsMessageA = a(bVar).a();
        org.minidns.a aVar = this.f21361d;
        org.minidns.dnsqueryresult.a aVarA = aVar == null ? null : aVar.a(dnsMessageA);
        if (aVarA != null) {
            return aVarA;
        }
        List<InetAddress> listE = e();
        ArrayList arrayList = new ArrayList(listE.size());
        for (InetAddress inetAddress : listE) {
            if (this.f21375j.contains(inetAddress)) {
                AbstractDnsClient.f21358h.finer("Skipping " + inetAddress + " because it was marked as \"recursion not available\"");
            } else {
                try {
                    DnsQueryResult dnsQueryResultQuery = query(dnsMessageA, inetAddress);
                    DnsMessage dnsMessage = dnsQueryResultQuery.a;
                    if (dnsMessage.f21421h) {
                        if (this.f21377l || (i2 = a.b[dnsMessage.f21416c.ordinal()]) == 1 || i2 == 2) {
                            return dnsQueryResultQuery;
                        }
                        String str = "Response from " + inetAddress + " asked for " + dnsMessageA.f() + " with error code: " + dnsMessage.f21416c + '.';
                        if (!AbstractDnsClient.f21358h.isLoggable(Level.FINE)) {
                            str = str + "\n" + dnsMessage;
                        }
                        AbstractDnsClient.f21358h.warning(str);
                        arrayList.add(new MiniDnsException.ErrorResponseException(dnsMessageA, dnsQueryResultQuery));
                    } else if (this.f21375j.add(inetAddress)) {
                        AbstractDnsClient.f21358h.warning("The DNS server " + inetAddress + " returned a response without the \"recursion available\" (RA) flag set. This likely indicates a misconfiguration because the server is not suitable for DNS resolution");
                    }
                } catch (IOException e2) {
                    arrayList.add(e2);
                }
            }
        }
        MultipleIoException.a((List<? extends IOException>) arrayList);
        throw new MiniDnsException.NoQueryPossibleException(dnsMessageA);
    }

    public static void a(d dVar) {
        if (!dVar.isAvailable()) {
            AbstractDnsClient.f21358h.fine("Not adding " + dVar.getName() + " as it is not available.");
            return;
        }
        synchronized (f21371n) {
            ArrayList arrayList = new ArrayList(f21371n.size() + 1);
            arrayList.addAll(f21371n);
            arrayList.add(dVar);
            Collections.sort(arrayList);
            f21371n.clear();
            f21371n.addAll(arrayList);
        }
    }

    public b(org.minidns.a aVar) {
        super(aVar);
        this.f21375j = Collections.newSetFromMap(new ConcurrentHashMap(4));
        this.f21376k = false;
        this.f21377l = false;
        this.f21378m = true;
    }

    public InetAddress a() {
        return (InetAddress) org.minidns.util.c.a(f21373p, this.f21360c);
    }
}
