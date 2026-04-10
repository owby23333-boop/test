package org.minidns.edns;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;
import org.minidns.record.h;
import org.minidns.record.p;

/* JADX INFO: loaded from: classes3.dex */
public class Edns {
    public final int a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<org.minidns.edns.a> f21493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f21494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Record<p> f21495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f21496h;

    public enum OptionCode {
        UNKNOWN(-1, c.class),
        NSID(3, org.minidns.edns.b.class);


        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static Map<Integer, OptionCode> f21499v = new HashMap(values().length);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f21501s;

        static {
            for (OptionCode optionCode : values()) {
                f21499v.put(Integer.valueOf(optionCode.f21501s), optionCode);
            }
        }

        OptionCode(int i2, Class cls) {
            this.f21501s = i2;
        }

        public static OptionCode b(int i2) {
            OptionCode optionCode = f21499v.get(Integer.valueOf(i2));
            return optionCode == null ? UNKNOWN : optionCode;
        }
    }

    public static final class b {
        private int a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f21502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f21503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<org.minidns.edns.a> f21504e;

        private b() {
        }

        public b a(int i2) {
            if (i2 <= 65535) {
                this.a = i2;
                return this;
            }
            throw new IllegalArgumentException("UDP payload size must not be greater than 65536, was " + i2);
        }

        public b a(boolean z2) {
            this.f21503d = z2;
            return this;
        }

        public Edns a() {
            return new Edns(this);
        }
    }

    public Edns(Record<p> record) {
        this.a = record.f21536d;
        long j2 = record.f21537e;
        this.b = (int) ((j2 >> 8) & 255);
        this.f21491c = (int) ((j2 >> 16) & 255);
        this.f21492d = ((int) j2) & 65535;
        this.f21494f = (j2 & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) > 0;
        this.f21493e = ((p) record.f21538f).f21632u;
        this.f21495g = record;
    }

    public static b c() {
        return new b();
    }

    public Record<p> a() {
        if (this.f21495g == null) {
            this.f21495g = new Record<>(DnsName.f21472z, Record.TYPE.OPT, this.a, ((long) this.f21492d) | ((long) (this.b << 8)) | ((long) (this.f21491c << 16)), new p(this.f21493e));
        }
        return this.f21495g;
    }

    public String b() {
        if (this.f21496h == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EDNS: version: ");
            sb.append(this.f21491c);
            sb.append(", flags:");
            if (this.f21494f) {
                sb.append(" do");
            }
            sb.append("; udp: ");
            sb.append(this.a);
            if (!this.f21493e.isEmpty()) {
                sb.append('\n');
                Iterator<org.minidns.edns.a> it = this.f21493e.iterator();
                while (it.hasNext()) {
                    org.minidns.edns.a next = it.next();
                    sb.append(next.c());
                    sb.append(": ");
                    sb.append(next.a());
                    if (it.hasNext()) {
                        sb.append('\n');
                    }
                }
            }
            this.f21496h = sb.toString();
        }
        return this.f21496h;
    }

    public String toString() {
        return b();
    }

    public static Edns a(Record<? extends h> record) {
        if (record.b != Record.TYPE.OPT) {
            return null;
        }
        return new Edns((Record<p>) record);
    }

    public Edns(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.f21491c = bVar.f21502c;
        int i2 = bVar.f21503d ? 32768 : 0;
        this.f21494f = bVar.f21503d;
        this.f21492d = i2;
        if (bVar.f21504e != null) {
            this.f21493e = bVar.f21504e;
        } else {
            this.f21493e = Collections.emptyList();
        }
    }
}
