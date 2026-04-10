package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ey;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
public class ge {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    int f431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ey.a f432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private short f434a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final long f435b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f436b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7996b = hr.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f7995a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final byte[] f430a = new byte[0];

    public ge() {
        this.f434a = (short) 2;
        this.f436b = f430a;
        this.f433a = null;
        this.f435b = System.currentTimeMillis();
        this.f432a = new ey.a();
        this.f431a = 1;
    }

    public static synchronized String d() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(f7996b);
        long j = f7995a;
        f7995a = 1 + j;
        sb.append(Long.toString(j));
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m454a() {
        return this.f435b;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m462b() {
        return this.f432a.m349d();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m465c() {
        return this.f432a.m353f();
    }

    public String e() {
        String strM351e = this.f432a.m351e();
        if ("ID_NOT_AVAILABLE".equals(strM351e)) {
            return null;
        }
        if (this.f432a.g()) {
            return strM351e;
        }
        String strD = d();
        this.f432a.e(strD);
        return strD;
    }

    public String f() {
        return this.f433a;
    }

    public String g() {
        if (!this.f432a.m345b()) {
            return null;
        }
        return Long.toString(this.f432a.m339a()) + "@" + this.f432a.m341a() + "/" + this.f432a.m344b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + com.xiaomi.push.service.bd.a(e()) + "; cmd=" + m455a() + "; type=" + ((int) m457a()) + "; from=" + g() + " ]";
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f432a.c(str);
        this.f432a.m340a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f432a.d(str2);
    }

    public int b() {
        return this.f432a.f();
    }

    public void c(long j) {
        this.f432a.c(j);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m463b() {
        return this.f432a.l();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m464c() {
        return this.f432a.m339a();
    }

    public void b(long j) {
        this.f432a.b(j);
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iIndexOf = str.indexOf("@");
        try {
            long j = Long.parseLong(str.substring(0, iIndexOf));
            int iIndexOf2 = str.indexOf("/", iIndexOf);
            String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            String strSubstring2 = str.substring(iIndexOf2 + 1);
            this.f432a.a(j);
            this.f432a.a(strSubstring);
            this.f432a.b(strSubstring2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("Blob parse user err " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m461b() {
        return this.f432a.m343b();
    }

    public void b(String str) {
        this.f433a = str;
    }

    public ge(ey.a aVar, short s, byte[] bArr) {
        this.f434a = (short) 2;
        this.f436b = f430a;
        this.f433a = null;
        this.f435b = System.currentTimeMillis();
        this.f432a = aVar;
        this.f434a = s;
        this.f436b = bArr;
        this.f431a = 2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m455a() {
        return this.f432a.m347c();
    }

    public void a(int i) {
        this.f432a.a(i);
    }

    public int a() {
        return this.f432a.c();
    }

    public void a(String str) {
        this.f432a.e(str);
    }

    public void a(long j) {
        this.f432a.a(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m458a() {
        return this.f432a.j();
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f432a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f432a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f432a.b(str2);
    }

    public int c() {
        return this.f432a.b() + 8 + this.f436b.length;
    }

    public void a(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f432a.c(1);
            this.f436b = com.xiaomi.push.service.bo.a(com.xiaomi.push.service.bo.a(str, e()), bArr);
        } else {
            this.f432a.c(0);
            this.f436b = bArr;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m459a() {
        return gf.a(this, this.f436b);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m460a(String str) {
        if (this.f432a.e() == 1) {
            return gf.a(this, com.xiaomi.push.service.bo.a(com.xiaomi.push.service.bo.a(str, e()), this.f436b));
        }
        if (this.f432a.e() == 0) {
            return gf.a(this, this.f436b);
        }
        com.xiaomi.channel.commonutils.logger.b.m106a("unknow cipher = " + this.f432a.e());
        return gf.a(this, this.f436b);
    }

    @Deprecated
    public static ge a(hg hgVar, String str) {
        int i;
        ge geVar = new ge();
        try {
            i = Integer.parseInt(hgVar.k());
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        geVar.a(i);
        geVar.a(hgVar.j());
        geVar.c(hgVar.m());
        geVar.b(hgVar.n());
        geVar.a("XMLMSG", (String) null);
        try {
            geVar.a(hgVar.mo496a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                geVar.a((short) 3);
            } else {
                geVar.a((short) 2);
                geVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            com.xiaomi.channel.commonutils.logger.b.m106a("Blob setPayload err： " + e2.getMessage());
        }
        return geVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo456a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f434a);
        byteBuffer.putShort((short) this.f432a.a());
        byteBuffer.putInt(this.f436b.length);
        int iPosition = byteBuffer.position();
        this.f432a.m317a(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, this.f432a.a());
        byteBuffer.position(iPosition + this.f432a.a());
        byteBuffer.put(this.f436b);
        return byteBuffer;
    }

    public static ge a(ByteBuffer byteBuffer) throws IOException {
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            short s = byteBufferSlice.getShort(0);
            short s2 = byteBufferSlice.getShort(2);
            int i = byteBufferSlice.getInt(4);
            ey.a aVar = new ey.a();
            aVar.a(byteBufferSlice.array(), byteBufferSlice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i];
            byteBufferSlice.position(s2 + 8);
            byteBufferSlice.get(bArr, 0, i);
            return new ge(aVar, s, bArr);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short m457a() {
        return this.f434a;
    }

    public void a(short s) {
        this.f434a = s;
    }
}
