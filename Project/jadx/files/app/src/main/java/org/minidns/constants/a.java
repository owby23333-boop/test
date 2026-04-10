package org.minidns.constants;

import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.o;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: DnsRootServer.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final Map<Character, Inet4Address> a = new HashMap();
    private static final Map<Character, Inet6Address> b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final Inet4Address[] f21408c = {a('a', 198, 41, 0, 4), a('b', 192, TbsListener.ErrorCode.INCR_ERROR_DETAIL, 79, 201), a('c', 192, 33, 4, 12), a('d', 199, 7, 91, 13), a('e', 192, 203, TbsListener.ErrorCode.RENAME_SUCCESS, 10), a('f', 192, 5, 5, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID), a('g', 192, 112, 36, 4), a('h', 198, 97, 190, 53), a('i', 192, 36, 148, 17), a('j', 192, 58, 128, 30), a('k', 193, 0, 14, 129), a('l', 199, 7, 83, 42), a('m', 202, 12, 27, 33)};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final Inet6Address[] f21409d = {a('a', o.a.f19780q, 1283, 47678, 0, 0, 0, 2, 48), a('b', o.a.f19780q, 1280, TbsListener.ErrorCode.DOWNLOAD_CDN_URL_IS_NULL, 0, 0, 0, 0, 11), a('c', o.a.f19780q, 1280, 2, 0, 0, 0, 0, 12), a('d', o.a.f19780q, 1280, 45, 0, 0, 0, 0, 13), a('f', o.a.f19780q, 1280, 47, 0, 0, 0, 0, 15), a('h', o.a.f19780q, 1280, 1, 0, 0, 0, 0, 83), a('i', o.a.f19780q, 2046, 0, 0, 0, 0, 0, 83), a('j', o.a.f19780q, 1283, 3111, 0, 0, 0, 2, 48), a('l', o.a.f19780q, 1280, 3, 0, 0, 0, 0, 66), a('m', o.a.f19780q, 3523, 0, 0, 0, 0, 0, 53)};

    private static Inet4Address a(char c2, int i2, int i3, int i4, int i5) {
        try {
            Inet4Address inet4Address = (Inet4Address) InetAddress.getByAddress(c2 + ".root-servers.net", new byte[]{(byte) i2, (byte) i3, (byte) i4, (byte) i5});
            a.put(Character.valueOf(c2), inet4Address);
            return inet4Address;
        } catch (UnknownHostException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Inet6Address b(Random random) {
        Inet6Address[] inet6AddressArr = f21409d;
        return inet6AddressArr[random.nextInt(inet6AddressArr.length)];
    }

    private static Inet6Address a(char c2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        try {
            Inet6Address inet6Address = (Inet6Address) InetAddress.getByAddress(c2 + ".root-servers.net", new byte[]{(byte) (i2 >> 8), (byte) i2, (byte) (i3 >> 8), (byte) i3, (byte) (i4 >> 8), (byte) i4, (byte) (i5 >> 8), (byte) i5, (byte) (i6 >> 8), (byte) i6, (byte) (i7 >> 8), (byte) i7, (byte) (i8 >> 8), (byte) i8, (byte) (i9 >> 8), (byte) i9});
            b.put(Character.valueOf(c2), inet6Address);
            return inet6Address;
        } catch (UnknownHostException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Inet4Address a(Random random) {
        Inet4Address[] inet4AddressArr = f21408c;
        return inet4AddressArr[random.nextInt(inet4AddressArr.length)];
    }
}
