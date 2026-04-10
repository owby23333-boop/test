package org.minidns.hla;

import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;

/* JADX INFO: loaded from: classes3.dex */
public class ResolutionUnsuccessfulException extends MiniDnsException {
    public ResolutionUnsuccessfulException(org.minidns.dnsmessage.a aVar, DnsMessage.RESPONSE_CODE response_code) {
        super("Asking for " + aVar + " yielded an error response " + response_code);
    }
}
