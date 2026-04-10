package org.minidns;

import java.io.IOException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MiniDnsException extends IOException {

    public static class ErrorResponseException extends MiniDnsException {
        public ErrorResponseException(DnsMessage dnsMessage, DnsQueryResult dnsQueryResult) {
            super("Received " + dnsQueryResult.a.f21416c + " error response\n" + dnsQueryResult);
        }
    }

    public static class IdMismatch extends MiniDnsException {
        public IdMismatch(DnsMessage dnsMessage, DnsMessage dnsMessage2) {
            super(a(dnsMessage, dnsMessage2));
        }

        private static String a(DnsMessage dnsMessage, DnsMessage dnsMessage2) {
            return "The response's ID doesn't matches the request ID. Request: " + dnsMessage.a + ". Response: " + dnsMessage2.a;
        }
    }

    public static class NoQueryPossibleException extends MiniDnsException {
        public NoQueryPossibleException(DnsMessage dnsMessage) {
            super("No DNS server could be queried");
        }
    }

    public static class NullResultException extends MiniDnsException {
        public NullResultException(DnsMessage dnsMessage) {
            super("The request yielded a 'null' result while resolving.");
        }
    }

    protected MiniDnsException(String str) {
        super(str);
    }
}
