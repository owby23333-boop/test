package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bp;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TDeserializer.java */
/* JADX INFO: loaded from: classes4.dex */
public class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bv f2183a;
    private final ci b;

    public az() {
        this(new bp.a());
    }

    public az(bx bxVar) {
        ci ciVar = new ci();
        this.b = ciVar;
        this.f2183a = bxVar.a(ciVar);
    }

    public void a(aw awVar, byte[] bArr) throws bc {
        try {
            this.b.a(bArr);
            awVar.read(this.f2183a);
        } finally {
            this.b.e();
            this.f2183a.B();
        }
    }

    public void a(aw awVar, String str, String str2) throws bc {
        try {
            try {
                a(awVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bc("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f2183a.B();
        }
    }

    public void a(aw awVar, byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        try {
            try {
                if (j(bArr, bdVar, bdVarArr) != null) {
                    awVar.read(this.f2183a);
                }
            } catch (Exception e) {
                throw new bc(e);
            }
        } finally {
            this.b.e();
            this.f2183a.B();
        }
    }

    public Boolean a(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Boolean) a((byte) 2, bArr, bdVar, bdVarArr);
    }

    public Byte b(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Byte) a((byte) 3, bArr, bdVar, bdVarArr);
    }

    public Double c(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Double) a((byte) 4, bArr, bdVar, bdVarArr);
    }

    public Short d(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Short) a((byte) 6, bArr, bdVar, bdVarArr);
    }

    public Integer e(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Integer) a((byte) 8, bArr, bdVar, bdVarArr);
    }

    public Long f(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Long) a((byte) 10, bArr, bdVar, bdVarArr);
    }

    public String g(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (String) a((byte) 11, bArr, bdVar, bdVarArr);
    }

    public ByteBuffer h(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (ByteBuffer) a((byte) 100, bArr, bdVar, bdVarArr);
    }

    public Short i(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        try {
            try {
                if (j(bArr, bdVar, bdVarArr) != null) {
                    this.f2183a.j();
                    return Short.valueOf(this.f2183a.l().c);
                }
                this.b.e();
                this.f2183a.B();
                return null;
            } catch (Exception e) {
                throw new bc(e);
            }
        } finally {
            this.b.e();
            this.f2183a.B();
        }
        this.b.e();
        this.f2183a.B();
    }

    private Object a(byte b, byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        try {
            try {
                bq bqVarJ = j(bArr, bdVar, bdVarArr);
                if (bqVarJ != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && bqVarJ.b == 11) {
                                                    return this.f2183a.z();
                                                }
                                            } else if (bqVarJ.b == 10) {
                                                return Long.valueOf(this.f2183a.x());
                                            }
                                        } else if (bqVarJ.b == 11) {
                                            return this.f2183a.A();
                                        }
                                    } else if (bqVarJ.b == 8) {
                                        return Integer.valueOf(this.f2183a.w());
                                    }
                                } else if (bqVarJ.b == 6) {
                                    return Short.valueOf(this.f2183a.v());
                                }
                            } else if (bqVarJ.b == 4) {
                                return Double.valueOf(this.f2183a.y());
                            }
                        } else if (bqVarJ.b == 3) {
                            return Byte.valueOf(this.f2183a.u());
                        }
                    } else if (bqVarJ.b == 2) {
                        return Boolean.valueOf(this.f2183a.t());
                    }
                }
                this.b.e();
                this.f2183a.B();
                return null;
            } catch (Exception e) {
                throw new bc(e);
            }
        } finally {
            this.b.e();
            this.f2183a.B();
        }
    }

    private bq j(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        this.b.a(bArr);
        int length = bdVarArr.length + 1;
        bd[] bdVarArr2 = new bd[length];
        int i = 0;
        bdVarArr2[0] = bdVar;
        int i2 = 0;
        while (i2 < bdVarArr.length) {
            int i3 = i2 + 1;
            bdVarArr2[i3] = bdVarArr[i2];
            i2 = i3;
        }
        this.f2183a.j();
        bq bqVarL = null;
        while (i < length) {
            bqVarL = this.f2183a.l();
            if (bqVarL.b == 0 || bqVarL.c > bdVarArr2[i].a()) {
                return null;
            }
            if (bqVarL.c != bdVarArr2[i].a()) {
                by.a(this.f2183a, bqVarL.b);
                this.f2183a.m();
            } else {
                i++;
                if (i < length) {
                    this.f2183a.j();
                }
            }
        }
        return bqVarL;
    }

    public void a(aw awVar, String str) throws bc {
        a(awVar, str.getBytes());
    }
}
