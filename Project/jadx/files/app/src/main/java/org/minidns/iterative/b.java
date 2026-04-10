package org.minidns.iterative;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.iterative.IterativeClientException;

/* JADX INFO: compiled from: ResolutionState.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private final a a;
    private final HashMap<InetAddress, Set<org.minidns.dnsmessage.a>> b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21524c;

    b(a aVar) {
        this.a = aVar;
    }

    void a(InetAddress inetAddress, DnsMessage dnsMessage) throws IterativeClientException.MaxIterativeStepsReached, IterativeClientException.LoopDetected {
        org.minidns.dnsmessage.a aVarF = dnsMessage.f();
        if (!this.b.containsKey(inetAddress)) {
            this.b.put(inetAddress, new HashSet());
        } else if (this.b.get(inetAddress).contains(aVarF)) {
            throw new IterativeClientException.LoopDetected(inetAddress, aVarF);
        }
        int i2 = this.f21524c + 1;
        this.f21524c = i2;
        if (i2 > this.a.f21522j) {
            throw new IterativeClientException.MaxIterativeStepsReached();
        }
        this.b.get(inetAddress).add(aVarF);
    }

    void a() {
        this.f21524c--;
    }
}
