package org.minidns.iterative;

import java.net.InetAddress;
import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsqueryresult.DnsQueryResult;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IterativeClientException extends MiniDnsException {

    public static class LoopDetected extends IterativeClientException {
        public LoopDetected(InetAddress inetAddress, org.minidns.dnsmessage.a aVar) {
            super("Resolution loop detected: We already asked " + inetAddress + " about " + aVar);
        }
    }

    public static class MaxIterativeStepsReached extends IterativeClientException {
        public MaxIterativeStepsReached() {
            super("Maxmimum steps reached");
        }
    }

    public static class NotAuthoritativeNorGlueRrFound extends IterativeClientException {
        public NotAuthoritativeNorGlueRrFound(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult, DnsName dnsName) {
            super("Did not receive an authoritative answer, nor did the result contain any glue records");
        }
    }

    protected IterativeClientException(String str) {
        super(str);
    }
}
