package com.anythink.expressad.exoplayer.e;

import anet.channel.entity.EventType;
import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.g.b.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9017d = "com.apple.iTunes";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9018e = "iTunSMPB";
    public int b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9020c = -1;
    public static final g.a a = new g.a() { // from class: com.anythink.expressad.exoplayer.e.i.1
        @Override // com.anythink.expressad.exoplayer.g.b.g.a
        public final boolean a(int i2, int i3, int i4, int i5, int i6) {
            if (i3 == 67 && i4 == 79 && i5 == 77) {
                return i6 == 77 || i2 == 2;
            }
            return false;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f9019f = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    private boolean a(int i2) {
        int i3 = i2 >> 12;
        int i4 = i2 & EventType.ALL;
        if (i3 <= 0 && i4 <= 0) {
            return false;
        }
        this.b = i3;
        this.f9020c = i4;
        return true;
    }

    public final boolean a(com.anythink.expressad.exoplayer.g.a aVar) {
        for (int i2 = 0; i2 < aVar.a(); i2++) {
            a.InterfaceC0191a interfaceC0191aA = aVar.a(i2);
            if (interfaceC0191aA instanceof com.anythink.expressad.exoplayer.g.b.e) {
                com.anythink.expressad.exoplayer.g.b.e eVar = (com.anythink.expressad.exoplayer.g.b.e) interfaceC0191aA;
                if (f9018e.equals(eVar.f9089c) && a(eVar.f9090d)) {
                    return true;
                }
            } else if (interfaceC0191aA instanceof com.anythink.expressad.exoplayer.g.b.i) {
                com.anythink.expressad.exoplayer.g.b.i iVar = (com.anythink.expressad.exoplayer.g.b.i) interfaceC0191aA;
                if (f9017d.equals(iVar.b) && f9018e.equals(iVar.f9111c) && a(iVar.f9112d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private boolean a(String str) {
        Matcher matcher = f9019f.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i2 = Integer.parseInt(matcher.group(1), 16);
            int i3 = Integer.parseInt(matcher.group(2), 16);
            if (i2 <= 0 && i3 <= 0) {
                return false;
            }
            this.b = i2;
            this.f9020c = i3;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean a() {
        return (this.b == -1 || this.f9020c == -1) ? false : true;
    }
}
