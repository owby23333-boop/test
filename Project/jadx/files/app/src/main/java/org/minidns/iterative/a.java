package org.minidns.iterative;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import org.minidns.AbstractDnsClient;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.iterative.IterativeClientException;
import org.minidns.record.Record;
import org.minidns.record.h;
import org.minidns.record.l;
import org.minidns.record.s;
import org.minidns.util.MultipleIoException;

/* JADX INFO: compiled from: IterativeDnsClient.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends AbstractDnsClient {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f21522j;

    /* JADX INFO: renamed from: org.minidns.iterative.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IterativeDnsClient.java */
    static /* synthetic */ class C0590a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b = new int[Record.TYPE.values().length];

        static {
            try {
                b[Record.TYPE.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Record.TYPE.AAAA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = new int[AbstractDnsClient.IpVersionSetting.values().length];
            try {
                a[AbstractDnsClient.IpVersionSetting.v4only.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AbstractDnsClient.IpVersionSetting.v6only.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AbstractDnsClient.IpVersionSetting.v4v6.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AbstractDnsClient.IpVersionSetting.v6v4.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: IterativeDnsClient.java */
    private static final class b {
        final List<InetAddress> a;

        /* JADX INFO: renamed from: org.minidns.iterative.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IterativeDnsClient.java */
        private static final class C0591a {
            private final Random a;
            private final List<InetAddress> b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final List<InetAddress> f21523c;

            /* synthetic */ C0591a(Random random, C0590a c0590a) {
                this(random);
            }

            private C0591a(Random random) {
                this.b = new ArrayList(8);
                this.f21523c = new ArrayList(8);
                this.a = random;
            }

            public b a() {
                return new b(this.b, this.f21523c, this.a, null);
            }
        }

        /* synthetic */ b(List list, List list2, Random random, C0590a c0590a) {
            this(list, list2, random);
        }

        private b(List<InetAddress> list, List<InetAddress> list2, Random random) {
            int i2 = C0590a.a[AbstractDnsClient.f21359i.ordinal()];
            int size = i2 != 1 ? i2 != 2 ? list.size() + list2.size() : list2.size() : list.size();
            if (size == 0) {
                this.a = Collections.emptyList();
                return;
            }
            if (AbstractDnsClient.f21359i.f21369s) {
                Collections.shuffle(list, random);
            }
            if (AbstractDnsClient.f21359i.f21370t) {
                Collections.shuffle(list2, random);
            }
            ArrayList arrayList = new ArrayList(size);
            int i3 = C0590a.a[AbstractDnsClient.f21359i.ordinal()];
            if (i3 == 1) {
                arrayList.addAll(list);
            } else if (i3 == 2) {
                arrayList.addAll(list2);
            } else if (i3 == 3) {
                arrayList.addAll(list);
                arrayList.addAll(list2);
            } else if (i3 == 4) {
                arrayList.addAll(list2);
                arrayList.addAll(list);
            }
            this.a = Collections.unmodifiableList(arrayList);
        }
    }

    public a() {
        this.f21522j = 128;
    }

    private b.C0591a e() {
        return new b.C0591a(this.f21360c, null);
    }

    @Override // org.minidns.AbstractDnsClient
    protected DnsQueryResult query(DnsMessage.b bVar) throws IOException {
        return a(new org.minidns.iterative.b(this), bVar.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055 A[EDGE_INSN: B:28:0x0055->B:22:0x0055 BREAK  A[LOOP:1: B:14:0x0034->B:18:0x0044], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress[] a(java.util.Collection<? extends org.minidns.record.j<? extends java.net.InetAddress>> r5, java.util.Collection<? extends org.minidns.record.j<? extends java.net.InetAddress>> r6) {
        /*
            r0 = 2
            java.net.InetAddress[] r0 = new java.net.InetAddress[r0]
            java.util.Iterator r5 = r5.iterator()
        L7:
            boolean r1 = r5.hasNext()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L30
            java.lang.Object r1 = r5.next()
            org.minidns.record.j r1 = (org.minidns.record.j) r1
            r4 = r0[r3]
            if (r4 != 0) goto L26
            java.net.InetAddress r4 = r1.b()
            r0[r3] = r4
            boolean r4 = r6.isEmpty()
            if (r4 == 0) goto L26
            goto L7
        L26:
            r5 = r0[r2]
            if (r5 != 0) goto L30
            java.net.InetAddress r5 = r1.b()
            r0[r2] = r5
        L30:
            java.util.Iterator r5 = r6.iterator()
        L34:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L55
            java.lang.Object r6 = r5.next()
            org.minidns.record.j r6 = (org.minidns.record.j) r6
            r1 = r0[r3]
            if (r1 != 0) goto L4b
            java.net.InetAddress r6 = r6.b()
            r0[r3] = r6
            goto L34
        L4b:
            r5 = r0[r2]
            if (r5 != 0) goto L55
            java.net.InetAddress r5 = r6.b()
            r0[r2] = r5
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.minidns.iterative.a.a(java.util.Collection, java.util.Collection):java.net.InetAddress[]");
    }

    public a(org.minidns.a aVar) {
        super(aVar);
        this.f21522j = 128;
    }

    private DnsQueryResult a(org.minidns.iterative.b bVar, DnsMessage dnsMessage) throws IOException {
        InetAddress inetAddressB;
        InetAddress inetAddressB2;
        DnsName dnsNameG = dnsMessage.f().a.g();
        int i2 = C0590a.a[this.f21363f.ordinal()];
        if (i2 == 1) {
            inetAddressB = null;
            for (org.minidns.record.a aVar : b(dnsNameG)) {
                if (inetAddressB == null) {
                    inetAddressB = aVar.b();
                } else {
                    inetAddressB2 = aVar.b();
                    break;
                }
            }
            inetAddressB2 = null;
        } else if (i2 == 2) {
            inetAddressB = null;
            for (org.minidns.record.b bVar2 : d(dnsNameG)) {
                if (inetAddressB == null) {
                    inetAddressB = bVar2.b();
                } else {
                    inetAddressB2 = bVar2.b();
                    break;
                }
            }
            inetAddressB2 = null;
        } else if (i2 == 3) {
            InetAddress[] inetAddressArrA = a(b(dnsNameG), d(dnsNameG));
            inetAddressB = inetAddressArrA[0];
            inetAddressB2 = inetAddressArrA[1];
        } else if (i2 == 4) {
            InetAddress[] inetAddressArrA2 = a(d(dnsNameG), b(dnsNameG));
            inetAddressB = inetAddressArrA2[0];
            inetAddressB2 = inetAddressArrA2[1];
        } else {
            throw new AssertionError();
        }
        if (inetAddressB == null) {
            dnsNameG = DnsName.f21472z;
            int i3 = C0590a.a[this.f21363f.ordinal()];
            if (i3 == 1) {
                inetAddressB = org.minidns.constants.a.a(this.f21360c);
            } else if (i3 == 2) {
                inetAddressB = org.minidns.constants.a.b(this.f21360c);
            } else if (i3 == 3) {
                inetAddressB = org.minidns.constants.a.a(this.f21360c);
                inetAddressB2 = org.minidns.constants.a.b(this.f21360c);
            } else if (i3 == 4) {
                inetAddressB = org.minidns.constants.a.b(this.f21360c);
                inetAddressB2 = org.minidns.constants.a.a(this.f21360c);
            }
        }
        LinkedList linkedList = new LinkedList();
        try {
            return a(bVar, dnsMessage, inetAddressB, dnsNameG);
        } catch (IOException e2) {
            a(e2);
            linkedList.add(e2);
            if (inetAddressB2 != null) {
                try {
                    return a(bVar, dnsMessage, inetAddressB2, dnsNameG);
                } catch (IOException e3) {
                    linkedList.add(e3);
                    MultipleIoException.a((List<? extends IOException>) linkedList);
                    return null;
                }
            }
            MultipleIoException.a((List<? extends IOException>) linkedList);
            return null;
        }
    }

    private DnsQueryResult a(org.minidns.iterative.b bVar, DnsMessage dnsMessage, InetAddress inetAddress, DnsName dnsName) throws IOException {
        Record.TYPE type;
        bVar.a(inetAddress, dnsMessage);
        DnsQueryResult dnsQueryResultQuery = query(dnsMessage, inetAddress);
        DnsMessage dnsMessage2 = dnsQueryResultQuery.a;
        if (dnsMessage2.f21418e) {
            return dnsQueryResultQuery;
        }
        org.minidns.a aVar = this.f21361d;
        if (aVar != null) {
            aVar.a(dnsMessage, dnsQueryResultQuery, dnsName);
        }
        List<Record<? extends h>> listD = dnsMessage2.d();
        LinkedList linkedList = new LinkedList();
        Iterator<Record<? extends h>> it = listD.iterator();
        while (it.hasNext()) {
            Record<E> recordA = it.next().a(l.class);
            if (recordA == 0) {
                it.remove();
            } else {
                Iterator<InetAddress> it2 = a(dnsMessage2, ((l) recordA.f21538f).f21639u).a.iterator();
                while (it2.hasNext()) {
                    try {
                        return a(bVar, dnsMessage, it2.next(), recordA.a);
                    } catch (IOException e2) {
                        a(e2);
                        AbstractDnsClient.f21358h.log(Level.FINER, "Exception while recursing", (Throwable) e2);
                        bVar.a();
                        linkedList.add(e2);
                        if (!it2.hasNext()) {
                            it.remove();
                        }
                    }
                }
            }
        }
        for (Record<? extends h> record : listD) {
            org.minidns.dnsmessage.a aVarF = dnsMessage.f();
            DnsName dnsName2 = ((l) record.f21538f).f21639u;
            if (!aVarF.a.equals(dnsName2) || ((type = aVarF.b) != Record.TYPE.A && type != Record.TYPE.AAAA)) {
                b bVarA = null;
                try {
                    bVarA = a(bVar, dnsName2);
                } catch (IOException e3) {
                    bVar.a();
                    linkedList.add(e3);
                }
                if (bVarA == null) {
                    continue;
                } else {
                    Iterator<InetAddress> it3 = bVarA.a.iterator();
                    while (it3.hasNext()) {
                        try {
                            return a(bVar, dnsMessage, it3.next(), record.a);
                        } catch (IOException e4) {
                            bVar.a();
                            linkedList.add(e4);
                        }
                    }
                }
            }
        }
        MultipleIoException.a((List<? extends IOException>) linkedList);
        throw new IterativeClientException.NotAuthoritativeNorGlueRrFound(dnsMessage, dnsQueryResultQuery, dnsName);
    }

    private b a(org.minidns.iterative.b bVar, DnsName dnsName) throws IOException {
        b.C0591a c0591aE = e();
        if (this.f21363f.f21369s) {
            org.minidns.dnsmessage.a aVar = new org.minidns.dnsmessage.a(dnsName, Record.TYPE.A);
            DnsQueryResult dnsQueryResultA = a(bVar, b(aVar));
            DnsMessage dnsMessage = dnsQueryResultA != null ? dnsQueryResultA.a : null;
            if (dnsMessage != null) {
                for (Record<? extends h> record : dnsMessage.f21425l) {
                    if (record.a(aVar)) {
                        c0591aE.b.add(a(dnsName.f21473s, (org.minidns.record.a) record.f21538f));
                    } else if (record.b == Record.TYPE.CNAME && record.a.equals(dnsName)) {
                        return a(bVar, ((s) record.f21538f).f21639u);
                    }
                }
            }
        }
        if (this.f21363f.f21370t) {
            org.minidns.dnsmessage.a aVar2 = new org.minidns.dnsmessage.a(dnsName, Record.TYPE.AAAA);
            DnsQueryResult dnsQueryResultA2 = a(bVar, b(aVar2));
            DnsMessage dnsMessage2 = dnsQueryResultA2 != null ? dnsQueryResultA2.a : null;
            if (dnsMessage2 != null) {
                for (Record<? extends h> record2 : dnsMessage2.f21425l) {
                    if (record2.a(aVar2)) {
                        c0591aE.f21523c.add(a(dnsName.f21473s, (org.minidns.record.b) record2.f21538f));
                    } else if (record2.b == Record.TYPE.CNAME && record2.a.equals(dnsName)) {
                        return a(bVar, ((s) record2.f21538f).f21639u);
                    }
                }
            }
        }
        return c0591aE.a();
    }

    private b a(DnsMessage dnsMessage, DnsName dnsName) {
        b.C0591a c0591aE = e();
        for (Record<? extends h> record : dnsMessage.f21427n) {
            if (record.a.equals(dnsName)) {
                int i2 = C0590a.b[record.b.ordinal()];
                if (i2 == 1) {
                    c0591aE.b.add(a(dnsName.f21473s, (org.minidns.record.a) record.f21538f));
                } else if (i2 == 2) {
                    c0591aE.f21523c.add(a(dnsName.f21473s, (org.minidns.record.b) record.f21538f));
                }
            }
        }
        return c0591aE.a();
    }

    private static InetAddress a(String str, org.minidns.record.a aVar) {
        try {
            return InetAddress.getByAddress(str, aVar.c());
        } catch (UnknownHostException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static InetAddress a(String str, org.minidns.record.b bVar) {
        try {
            return InetAddress.getByAddress(str, bVar.c());
        } catch (UnknownHostException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.minidns.AbstractDnsClient
    protected boolean a(org.minidns.dnsmessage.a aVar, DnsQueryResult dnsQueryResult) {
        return dnsQueryResult.a.f21418e;
    }

    @Override // org.minidns.AbstractDnsClient
    protected DnsMessage.b a(DnsMessage.b bVar) {
        bVar.a(false);
        bVar.b().a(this.f21362e.a());
        return bVar;
    }

    protected static void a(IOException iOException) throws IOException {
        if (iOException instanceof IterativeClientException.LoopDetected) {
            throw iOException;
        }
    }
}
