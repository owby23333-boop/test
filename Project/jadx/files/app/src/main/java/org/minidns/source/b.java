package org.minidns.source;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.minidns.MiniDnsException;
import org.minidns.dnsmessage.DnsMessage;
import org.minidns.dnsqueryresult.DnsQueryResult;
import org.minidns.dnsqueryresult.c;
import org.minidns.source.AbstractDnsDataSource;
import org.minidns.util.MultipleIoException;

/* JADX INFO: compiled from: NetworkDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends AbstractDnsDataSource {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Logger f21660d = Logger.getLogger(b.class.getName());

    /* JADX INFO: compiled from: NetworkDataSource.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[AbstractDnsDataSource.QueryMode.values().length];

        static {
            try {
                a[AbstractDnsDataSource.QueryMode.dontCare.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbstractDnsDataSource.QueryMode.udpTcp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbstractDnsDataSource.QueryMode.tcp.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected DnsMessage a(DnsMessage dnsMessage, InetAddress inetAddress, int i2) throws Throwable {
        Socket socketD;
        try {
            socketD = d();
        } catch (Throwable th) {
            th = th;
            socketD = null;
        }
        try {
            socketD.connect(new InetSocketAddress(inetAddress, i2), this.b);
            socketD.setSoTimeout(this.b);
            DataOutputStream dataOutputStream = new DataOutputStream(socketD.getOutputStream());
            dnsMessage.a(dataOutputStream);
            dataOutputStream.flush();
            DataInputStream dataInputStream = new DataInputStream(socketD.getInputStream());
            int unsignedShort = dataInputStream.readUnsignedShort();
            byte[] bArr = new byte[unsignedShort];
            for (int i3 = 0; i3 < unsignedShort; i3 += dataInputStream.read(bArr, i3, unsignedShort - i3)) {
            }
            DnsMessage dnsMessage2 = new DnsMessage(bArr);
            if (dnsMessage2.a != dnsMessage.a) {
                throw new MiniDnsException.IdMismatch(dnsMessage, dnsMessage2);
            }
            if (socketD != null) {
                socketD.close();
            }
            return dnsMessage2;
        } catch (Throwable th2) {
            th = th2;
            if (socketD != null) {
                socketD.close();
            }
            throw th;
        }
    }

    protected DnsMessage b(DnsMessage dnsMessage, InetAddress inetAddress, int i2) throws Throwable {
        DatagramSocket datagramSocketC;
        DatagramPacket datagramPacketA = dnsMessage.a(inetAddress, i2);
        byte[] bArr = new byte[this.a];
        try {
            datagramSocketC = c();
        } catch (Throwable th) {
            th = th;
            datagramSocketC = null;
        }
        try {
            datagramSocketC.setSoTimeout(this.b);
            datagramSocketC.send(datagramPacketA);
            DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length);
            datagramSocketC.receive(datagramPacket);
            DnsMessage dnsMessage2 = new DnsMessage(datagramPacket.getData());
            if (dnsMessage2.a != dnsMessage.a) {
                throw new MiniDnsException.IdMismatch(dnsMessage, dnsMessage2);
            }
            if (datagramSocketC != null) {
                datagramSocketC.close();
            }
            return dnsMessage2;
        } catch (Throwable th2) {
            th = th2;
            if (datagramSocketC != null) {
                datagramSocketC.close();
            }
            throw th;
        }
    }

    protected DatagramSocket c() throws SocketException {
        return new DatagramSocket();
    }

    protected Socket d() {
        return new Socket();
    }

    @Override // org.minidns.source.AbstractDnsDataSource, org.minidns.source.a
    public c query(DnsMessage dnsMessage, InetAddress inetAddress, int i2) throws Throwable {
        boolean z2;
        AbstractDnsDataSource.QueryMode queryModeB = b();
        int i3 = a.a[queryModeB.ordinal()];
        if (i3 == 1 || i3 == 2) {
            z2 = true;
        } else {
            if (i3 != 3) {
                throw new IllegalStateException("Unsupported query mode: " + queryModeB);
            }
            z2 = false;
        }
        ArrayList arrayList = new ArrayList(2);
        DnsMessage dnsMessageB = null;
        if (z2) {
            try {
                dnsMessageB = b(dnsMessage, inetAddress, i2);
            } catch (IOException e2) {
                arrayList.add(e2);
            }
            DnsMessage dnsMessage2 = dnsMessageB;
            if (dnsMessage2 != null && !dnsMessage2.f21419f) {
                return new c(inetAddress, i2, DnsQueryResult.QueryMethod.udp, dnsMessage, dnsMessage2);
            }
            Logger logger = f21660d;
            Level level = Level.FINE;
            Object[] objArr = new Object[1];
            objArr[0] = dnsMessage2 != null ? "response is truncated" : arrayList.get(0);
            logger.log(level, "Fallback to TCP because {0}", objArr);
            dnsMessageB = dnsMessage2;
        }
        try {
            dnsMessageB = a(dnsMessage, inetAddress, i2);
        } catch (IOException e3) {
            arrayList.add(e3);
            MultipleIoException.a((List<? extends IOException>) arrayList);
        }
        return new c(inetAddress, i2, DnsQueryResult.QueryMethod.tcp, dnsMessage, dnsMessageB);
    }
}
