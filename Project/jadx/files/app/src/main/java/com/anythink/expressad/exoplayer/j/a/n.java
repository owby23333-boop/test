package com.anythink.expressad.exoplayer.j.a;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class n extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f9648g = ".v3.exo";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f9649h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f9650i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f9651j = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private n(String str, long j2, long j3, long j4, @Nullable File file) {
        super(str, j2, j3, j4, file);
    }

    public static File a(File file, int i2, long j2, long j3) {
        return new File(file, i2 + "." + j2 + "." + j3 + f9648g);
    }

    public static n b(String str, long j2) {
        return new n(str, j2, -1L, com.anythink.expressad.exoplayer.b.b, null);
    }

    public static n a(String str, long j2) {
        return new n(str, j2, -1L, com.anythink.expressad.exoplayer.b.b, null);
    }

    @Nullable
    private static File b(File file, h hVar) {
        String strGroup;
        String name = file.getName();
        Matcher matcher = f9650i.matcher(name);
        if (matcher.matches()) {
            strGroup = af.h(matcher.group(1));
            if (strGroup == null) {
                return null;
            }
        } else {
            matcher = f9649h.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            strGroup = matcher.group(1);
        }
        File fileA = a(file.getParentFile(), hVar.c(strGroup), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (file.renameTo(fileA)) {
            return fileA;
        }
        return null;
    }

    public static n a(String str, long j2, long j3) {
        return new n(str, j2, j3, com.anythink.expressad.exoplayer.b.b, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.anythink.expressad.exoplayer.j.a.n a(java.io.File r16, com.anythink.expressad.exoplayer.j.a.h r17) {
        /*
            r0 = r17
            java.lang.String r1 = r16.getName()
            java.lang.String r2 = ".v3.exo"
            boolean r2 = r1.endsWith(r2)
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 != 0) goto L6e
            java.lang.String r1 = r16.getName()
            java.util.regex.Pattern r2 = com.anythink.expressad.exoplayer.j.a.n.f9650i
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r7 = r2.matches()
            if (r7 == 0) goto L2d
            java.lang.String r1 = r2.group(r5)
            java.lang.String r1 = com.anythink.expressad.exoplayer.k.af.h(r1)
            if (r1 != 0) goto L3f
            goto L39
        L2d:
            java.util.regex.Pattern r2 = com.anythink.expressad.exoplayer.j.a.n.f9649h
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r1 = r2.matches()
            if (r1 != 0) goto L3b
        L39:
            r1 = r6
            goto L64
        L3b:
            java.lang.String r1 = r2.group(r5)
        L3f:
            java.io.File r7 = r16.getParentFile()
            int r8 = r0.c(r1)
            java.lang.String r1 = r2.group(r4)
            long r9 = java.lang.Long.parseLong(r1)
            java.lang.String r1 = r2.group(r3)
            long r11 = java.lang.Long.parseLong(r1)
            java.io.File r1 = a(r7, r8, r9, r11)
            r2 = r16
            boolean r2 = r2.renameTo(r1)
            if (r2 != 0) goto L64
            goto L39
        L64:
            if (r1 != 0) goto L67
            return r6
        L67:
            java.lang.String r2 = r1.getName()
            r15 = r1
            r1 = r2
            goto L71
        L6e:
            r2 = r16
            r15 = r2
        L71:
            java.util.regex.Pattern r2 = com.anythink.expressad.exoplayer.j.a.n.f9651j
            java.util.regex.Matcher r1 = r2.matcher(r1)
            boolean r2 = r1.matches()
            if (r2 != 0) goto L7e
            return r6
        L7e:
            long r11 = r15.length()
            java.lang.String r2 = r1.group(r5)
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.String r8 = r0.a(r2)
            if (r8 != 0) goto L91
            return r6
        L91:
            com.anythink.expressad.exoplayer.j.a.n r0 = new com.anythink.expressad.exoplayer.j.a.n
            java.lang.String r2 = r1.group(r4)
            long r9 = java.lang.Long.parseLong(r2)
            java.lang.String r1 = r1.group(r3)
            long r13 = java.lang.Long.parseLong(r1)
            r7 = r0
            r7.<init>(r8, r9, r11, r13, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.j.a.n.a(java.io.File, com.anythink.expressad.exoplayer.j.a.h):com.anythink.expressad.exoplayer.j.a.n");
    }

    public final n a(int i2) {
        com.anythink.expressad.exoplayer.k.a.b(this.f9619d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new n(this.a, this.b, this.f9618c, jCurrentTimeMillis, a(this.f9620e.getParentFile(), i2, this.b, jCurrentTimeMillis));
    }
}
