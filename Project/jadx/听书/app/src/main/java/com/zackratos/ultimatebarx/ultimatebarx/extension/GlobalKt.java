package com.zackratos.ultimatebarx.ultimatebarx.extension;

import android.text.TextUtils;
import com.zackratos.ultimatebarx.ultimatebarx.rom.EmuiRom;
import com.zackratos.ultimatebarx.ultimatebarx.rom.FuntouchRom;
import com.zackratos.ultimatebarx.ultimatebarx.rom.MiuiRom;
import com.zackratos.ultimatebarx.ultimatebarx.rom.OtherRom;
import com.zackratos.ultimatebarx.ultimatebarx.rom.Rom;
import kotlin.Metadata;

/* JADX INFO: compiled from: Global.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getProp", "", "name", "getRom", "Lcom/zackratos/ultimatebarx/ultimatebarx/rom/Rom;", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class GlobalKt {
    public static final Rom getRom() {
        if (!TextUtils.isEmpty(getProp("ro.miui.ui.version.name"))) {
            return new MiuiRom();
        }
        if (!TextUtils.isEmpty(getProp("ro.build.version.emui"))) {
            return new EmuiRom();
        }
        if (!TextUtils.isEmpty(getProp("ro.vivo.os.version"))) {
            return new FuntouchRom();
        }
        return new OtherRom();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String getProp(java.lang.String r4) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "getprop "
            r1 = 0
            r2 = r1
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.StringBuilder r4 = r3.append(r4)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.Process r4 = r2.exec(r4)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r3 = "p"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r3)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.InputStream r4 = r4.getInputStream()     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.io.Reader r2 = (java.io.Reader) r2     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            r4 = 1024(0x400, float:1.435E-42)
            r0.<init>(r2, r4)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L46
            java.lang.String r4 = r0.readLine()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L56
            r0.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L56
            r0.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r0 = move-exception
            r0.printStackTrace()
        L41:
            return r4
        L42:
            r4 = move-exception
            goto L48
        L44:
            r4 = move-exception
            goto L58
        L46:
            r4 = move-exception
            r0 = r1
        L48:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto L55
            r0.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r4 = move-exception
            r4.printStackTrace()
        L55:
            return r1
        L56:
            r4 = move-exception
            r1 = r0
        L58:
            if (r1 == 0) goto L62
            r1.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r0 = move-exception
            r0.printStackTrace()
        L62:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zackratos.ultimatebarx.ultimatebarx.extension.GlobalKt.getProp(java.lang.String):java.lang.String");
    }
}
