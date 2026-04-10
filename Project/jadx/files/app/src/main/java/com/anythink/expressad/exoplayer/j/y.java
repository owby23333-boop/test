package com.anythink.expressad.exoplayer.j;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements h {
    public static final String a = "rawresource";
    private final Resources b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final aa<? super y> f9771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f9772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AssetFileDescriptor f9773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InputStream f9774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f9775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9776h;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public a(IOException iOException) {
            super(iOException);
        }
    }

    private y(Context context) {
        this(context, null);
    }

    private static Uri a(int i2) {
        return Uri.parse("rawresource:///".concat(String.valueOf(i2)));
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f9772d = null;
        try {
            try {
                if (this.f9774f != null) {
                    this.f9774f.close();
                }
                this.f9774f = null;
                try {
                    try {
                        if (this.f9773e != null) {
                            this.f9773e.close();
                        }
                    } finally {
                        this.f9773e = null;
                        if (this.f9776h) {
                            this.f9776h = false;
                            aa<? super y> aaVar = this.f9771c;
                            if (aaVar != null) {
                                aaVar.c();
                            }
                        }
                    }
                } catch (IOException e2) {
                    throw new a(e2);
                }
            } catch (IOException e3) {
                throw new a(e3);
            }
        } catch (Throwable th) {
            this.f9774f = null;
            try {
                try {
                    if (this.f9773e != null) {
                        this.f9773e.close();
                    }
                    this.f9773e = null;
                    if (this.f9776h) {
                        this.f9776h = false;
                        aa<? super y> aaVar2 = this.f9771c;
                        if (aaVar2 != null) {
                            aaVar2.c();
                        }
                    }
                    throw th;
                } catch (IOException e4) {
                    throw new a(e4);
                }
            } finally {
                this.f9773e = null;
                if (this.f9776h) {
                    this.f9776h = false;
                    aa<? super y> aaVar3 = this.f9771c;
                    if (aaVar3 != null) {
                        aaVar3.c();
                    }
                }
            }
        }
    }

    public y(Context context, aa<? super y> aaVar) {
        this.b = context.getResources();
        this.f9771c = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) throws a {
        try {
            this.f9772d = kVar.f9667c;
            if (!TextUtils.equals(a, this.f9772d.getScheme())) {
                throw new a("URI must use scheme rawresource");
            }
            try {
                this.f9773e = this.b.openRawResourceFd(Integer.parseInt(this.f9772d.getLastPathSegment()));
                this.f9774f = new FileInputStream(this.f9773e.getFileDescriptor());
                this.f9774f.skip(this.f9773e.getStartOffset());
                if (this.f9774f.skip(kVar.f9670f) < kVar.f9670f) {
                    throw new EOFException();
                }
                long j2 = -1;
                if (kVar.f9671g != -1) {
                    this.f9775g = kVar.f9671g;
                } else {
                    long length = this.f9773e.getLength();
                    if (length != -1) {
                        j2 = length - kVar.f9670f;
                    }
                    this.f9775g = j2;
                }
                this.f9776h = true;
                aa<? super y> aaVar = this.f9771c;
                if (aaVar != null) {
                    aaVar.b();
                }
                return this.f9775g;
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.");
            }
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) throws a {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f9775g;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, i3);
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
        int i4 = this.f9774f.read(bArr, i2, i3);
        if (i4 == -1) {
            if (this.f9775g == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j3 = this.f9775g;
        if (j3 != -1) {
            this.f9775g = j3 - ((long) i4);
        }
        aa<? super y> aaVar = this.f9771c;
        if (aaVar != null) {
            aaVar.a(i4);
        }
        return i4;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f9772d;
    }
}
