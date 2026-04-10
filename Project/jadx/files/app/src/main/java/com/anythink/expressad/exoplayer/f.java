package com.anythink.expressad.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ab {
    public static final long a = 5000;
    public static final int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9024c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9025d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final int f9026e = 50;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9027f = "DefaultRenderersFactory";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f9028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private final com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> f9029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f9030i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f9031j;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public f(Context context) {
        this(context, 0);
    }

    private static void a() {
    }

    private static com.anythink.expressad.exoplayer.b.f[] b() {
        return new com.anythink.expressad.exoplayer.b.f[0];
    }

    @Override // com.anythink.expressad.exoplayer.ab
    public final y[] a(Handler handler, com.anythink.expressad.exoplayer.l.h hVar, com.anythink.expressad.exoplayer.b.g gVar, com.anythink.expressad.exoplayer.g.f fVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar2) {
        int i2;
        int i3;
        com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar3 = gVar2 == null ? this.f9029h : gVar2;
        ArrayList arrayList = new ArrayList();
        Context context = this.f9028g;
        long j2 = this.f9031j;
        int i4 = this.f9030i;
        arrayList.add(new com.anythink.expressad.exoplayer.l.e(context, com.anythink.expressad.exoplayer.f.c.a, j2, gVar3, handler, hVar, 50));
        if (i4 != 0) {
            int size = arrayList.size();
            if (i4 == 2) {
                size--;
            }
            try {
                arrayList.add(size, (y) Class.forName("com.anythink.expressad.exoplayer.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.anythink.expressad.exoplayer.l.h.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j2), handler, hVar, 50));
            } catch (ClassNotFoundException unused) {
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating VP9 extension", e2);
            }
        }
        Context context2 = this.f9028g;
        com.anythink.expressad.exoplayer.b.f[] fVarArr = new com.anythink.expressad.exoplayer.b.f[0];
        int i5 = this.f9030i;
        arrayList.add(new com.anythink.expressad.exoplayer.b.o(context2, com.anythink.expressad.exoplayer.f.c.a, gVar3, handler, gVar, com.anythink.expressad.exoplayer.b.c.a(context2), fVarArr));
        if (i5 != 0) {
            int size2 = arrayList.size();
            if (i5 == 2) {
                size2--;
            }
            try {
                try {
                    i2 = size2 + 1;
                    try {
                        arrayList.add(size2, (y) Class.forName("com.anythink.expressad.exoplayer.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                    } catch (ClassNotFoundException unused2) {
                    }
                } catch (ClassNotFoundException unused3) {
                    i2 = size2;
                }
                try {
                    try {
                        i3 = i2 + 1;
                        try {
                            arrayList.add(i2, (y) Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                        } catch (ClassNotFoundException unused4) {
                        }
                    } catch (Exception e3) {
                        throw new RuntimeException("Error instantiating FLAC extension", e3);
                    }
                } catch (ClassNotFoundException unused5) {
                    i3 = i2;
                }
                try {
                    arrayList.add(i3, (y) Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                } catch (ClassNotFoundException unused6) {
                } catch (Exception e4) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e4);
                }
            } catch (Exception e5) {
                throw new RuntimeException("Error instantiating Opus extension", e5);
            }
        }
        arrayList.add(new com.anythink.expressad.exoplayer.g.g(fVar, handler.getLooper()));
        return (y[]) arrayList.toArray(new y[arrayList.size()]);
    }

    @Deprecated
    private f(Context context, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        this(context, gVar, (byte) 0);
    }

    public f(Context context, int i2) {
        this(context, null, i2, 5000L);
    }

    @Deprecated
    private f(Context context, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, byte b2) {
        this(context, gVar, 0, 5000L);
    }

    public f(Context context, int i2, long j2) {
        this(context, null, i2, j2);
    }

    @Deprecated
    private f(Context context, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, int i2, long j2) {
        this.f9028g = context;
        this.f9030i = i2;
        this.f9031j = j2;
        this.f9029h = gVar;
    }

    private static void a(Context context, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, long j2, Handler handler, com.anythink.expressad.exoplayer.l.h hVar, int i2, ArrayList<y> arrayList) {
        arrayList.add(new com.anythink.expressad.exoplayer.l.e(context, com.anythink.expressad.exoplayer.f.c.a, j2, gVar, handler, hVar, 50));
        if (i2 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i2 == 2) {
            size--;
        }
        try {
            arrayList.add(size, (y) Class.forName("com.anythink.expressad.exoplayer.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.anythink.expressad.exoplayer.l.h.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j2), handler, hVar, 50));
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating VP9 extension", e2);
        }
    }

    private static void a(Context context, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.b.f[] fVarArr, Handler handler, com.anythink.expressad.exoplayer.b.g gVar2, int i2, ArrayList<y> arrayList) {
        int i3;
        int i4;
        arrayList.add(new com.anythink.expressad.exoplayer.b.o(context, com.anythink.expressad.exoplayer.f.c.a, gVar, handler, gVar2, com.anythink.expressad.exoplayer.b.c.a(context), fVarArr));
        if (i2 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i2 == 2) {
            size--;
        }
        try {
            try {
                i3 = size + 1;
                try {
                    arrayList.add(size, (y) Class.forName("com.anythink.expressad.exoplayer.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                } catch (ClassNotFoundException unused) {
                }
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating Opus extension", e2);
            }
        } catch (ClassNotFoundException unused2) {
            i3 = size;
        }
        try {
            try {
                i4 = i3 + 1;
                try {
                    arrayList.add(i3, (y) Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                } catch (ClassNotFoundException unused3) {
                }
            } catch (ClassNotFoundException unused4) {
                i4 = i3;
            }
            try {
                arrayList.add(i4, (y) Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
            } catch (ClassNotFoundException unused5) {
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e3);
            }
        } catch (Exception e4) {
            throw new RuntimeException("Error instantiating FLAC extension", e4);
        }
    }

    private static void a(com.anythink.expressad.exoplayer.g.f fVar, Looper looper, ArrayList<y> arrayList) {
        arrayList.add(new com.anythink.expressad.exoplayer.g.g(fVar, looper));
    }
}
