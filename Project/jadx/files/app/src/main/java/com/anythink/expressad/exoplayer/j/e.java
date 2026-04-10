package com.anythink.expressad.exoplayer.j;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements h {
    private final ContentResolver a;
    private final aa<? super e> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f9656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AssetFileDescriptor f9657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FileInputStream f9658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f9659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9660g;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    private e(Context context) {
        this(context, null);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) throws a {
        try {
            this.f9656c = kVar.f9667c;
            this.f9657d = this.a.openAssetFileDescriptor(this.f9656c, "r");
            if (this.f9657d == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.f9656c);
            }
            this.f9658e = new FileInputStream(this.f9657d.getFileDescriptor());
            long startOffset = this.f9657d.getStartOffset();
            long jSkip = this.f9658e.skip(kVar.f9670f + startOffset) - startOffset;
            if (jSkip != kVar.f9670f) {
                throw new EOFException();
            }
            long jPosition = -1;
            if (kVar.f9671g != -1) {
                this.f9659f = kVar.f9671g;
            } else {
                long length = this.f9657d.getLength();
                if (length == -1) {
                    FileChannel channel = this.f9658e.getChannel();
                    long size = channel.size();
                    if (size != 0) {
                        jPosition = size - channel.position();
                    }
                    this.f9659f = jPosition;
                } else {
                    this.f9659f = length - jSkip;
                }
            }
            this.f9660g = true;
            aa<? super e> aaVar = this.b;
            if (aaVar != null) {
                aaVar.b();
            }
            return this.f9659f;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f9656c = null;
        try {
            try {
                if (this.f9658e != null) {
                    this.f9658e.close();
                }
                this.f9658e = null;
                try {
                    try {
                        if (this.f9657d != null) {
                            this.f9657d.close();
                        }
                    } finally {
                        this.f9657d = null;
                        if (this.f9660g) {
                            this.f9660g = false;
                            aa<? super e> aaVar = this.b;
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
            this.f9658e = null;
            try {
                try {
                    if (this.f9657d != null) {
                        this.f9657d.close();
                    }
                    this.f9657d = null;
                    if (this.f9660g) {
                        this.f9660g = false;
                        aa<? super e> aaVar2 = this.b;
                        if (aaVar2 != null) {
                            aaVar2.c();
                        }
                    }
                    throw th;
                } catch (IOException e4) {
                    throw new a(e4);
                }
            } finally {
                this.f9657d = null;
                if (this.f9660g) {
                    this.f9660g = false;
                    aa<? super e> aaVar3 = this.b;
                    if (aaVar3 != null) {
                        aaVar3.c();
                    }
                }
            }
        }
    }

    public e(Context context, aa<? super e> aaVar) {
        this.a = context.getContentResolver();
        this.b = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) throws a {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f9659f;
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
        int i4 = this.f9658e.read(bArr, i2, i3);
        if (i4 == -1) {
            if (this.f9659f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j3 = this.f9659f;
        if (j3 != -1) {
            this.f9659f = j3 - ((long) i4);
        }
        aa<? super e> aaVar = this.b;
        if (aaVar != null) {
            aaVar.a(i4);
        }
        return i4;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f9656c;
    }
}
