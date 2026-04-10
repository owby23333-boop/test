package com.bytedance.sdk.component.d.bf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f2090a;
    public static final v ah;
    public static final v aq;
    public static final v as;
    public static final v ay;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f2091b;
    public static final v bc;
    public static final v bf;
    public static final v bh;
    public static final v bm;
    public static final v bp;
    public static final v br;
    public static final v bx;
    public static final v c;
    public static final v cv;
    public static final v d;
    public static final v dt;
    static final Comparator<String> e;
    public static final v eb;
    public static final v em;
    public static final v en;
    public static final v ev;
    public static final v ey;
    public static final v f;
    public static final v fa;
    public static final v fg;
    public static final v fl;
    public static final v ft;
    public static final v fy;
    public static final v g;
    public static final v ga;
    public static final v gm;
    private static final Map<String, v> gz;
    public static final v h;
    public static final v hb;
    public static final v i;
    public static final v in;
    public static final v j;
    public static final v jk;
    public static final v ju;
    public static final v k;
    public static final v kt;
    public static final v kx;
    public static final v l;
    public static final v lc;
    public static final v lg;
    public static final v lw;
    public static final v m;
    public static final v n;
    public static final v ne;
    public static final v nt;
    public static final v o;
    public static final v ot;
    public static final v ou;
    public static final v ov;
    public static final v p;
    public static final v pc;
    public static final v pe;
    public static final v pl;
    public static final v q;
    public static final v qb;
    public static final v r;
    public static final v rb;
    public static final v rd;
    public static final v rk;
    public static final v rm;
    public static final v rt;
    public static final v rw;
    public static final v s;
    public static final v sq;
    public static final v t;
    public static final v tg;
    public static final v tk;
    public static final v tu;
    public static final v tv;
    public static final v tx;
    public static final v ue;
    public static final v ui;
    public static final v uk;
    public static final v uo;
    public static final v uq;
    public static final v v;
    public static final v vd;
    public static final v vg;
    public static final v vl;
    public static final v vm;
    public static final v vn;
    public static final v vr;
    public static final v vs;
    public static final v vu;
    public static final v w;
    public static final v wl;
    public static final v wu;
    public static final v x;
    public static final v xn;
    public static final v xo;
    public static final v xu;
    public static final v xy;
    public static final v y;
    public static final v ya;
    public static final v yf;
    public static final v yk;
    public static final v yl;
    public static final v yq;
    public static final v ys;
    public static final v yx;
    public static final v z;
    public static final v za;
    public static final v zb;
    public static final v zk;
    public static final v zm;
    public static final v zo;
    public static final v zr;
    public static final v zw;
    final String u;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.component.d.bf.v.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                int iMin = Math.min(str.length(), str2.length());
                for (int i2 = 4; i2 < iMin; i2++) {
                    char cCharAt = str.charAt(i2);
                    char cCharAt2 = str2.charAt(i2);
                    if (cCharAt != cCharAt2) {
                        return cCharAt < cCharAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        e = comparator;
        gz = new TreeMap(comparator);
        bf = e("SSL_RSA_WITH_NULL_MD5", 1);
        d = e("SSL_RSA_WITH_NULL_SHA", 2);
        tg = e("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        ga = e("SSL_RSA_WITH_RC4_128_MD5", 4);
        vn = e("SSL_RSA_WITH_RC4_128_SHA", 5);
        p = e("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        v = e("SSL_RSA_WITH_DES_CBC_SHA", 9);
        zk = e("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        m = e("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        wu = e("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        xu = e("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        bh = e("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        t = e("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        s = e("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        w = e("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        l = e("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        f = e("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        k = e("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        dt = e("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        pe = e("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        y = e("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        cv = e("TLS_KRB5_WITH_RC4_128_SHA", 32);
        wl = e("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        za = e("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        lc = e("TLS_KRB5_WITH_RC4_128_MD5", 36);
        f2090a = e("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        uk = e("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        fy = e("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        h = e("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        x = e("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        hb = e("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        bx = e("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        bm = e("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f2091b = e("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        r = e("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        rm = e("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        q = e("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        rt = e("TLS_RSA_WITH_NULL_SHA256", 59);
        j = e("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        i = e("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        yl = e("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        rb = e("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        ot = e("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        n = e("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        nt = e("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        ya = e("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        fl = e("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        uq = e("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        yf = e("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        ue = e("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA);
        ft = e("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        ov = e("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        vu = e("TLS_PSK_WITH_RC4_128_SHA", 138);
        z = e("TLS_PSK_WITH_3DES_EDE_CBC_SHA", MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_DEVICE);
        ev = e("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        vs = e("TLS_PSK_WITH_AES_256_CBC_SHA", MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID);
        em = e("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        g = e("TLS_RSA_WITH_AES_128_GCM_SHA256", MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME);
        tx = e("TLS_RSA_WITH_AES_256_GCM_SHA384", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME);
        pl = e("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        zb = e("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        xn = e("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        lw = e("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        xy = e("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        sq = e("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        vg = e("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        tu = e("TLS_FALLBACK_SCSV", 22016);
        zo = e("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        lg = e("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        zr = e("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        tv = e("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        rk = e("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        c = e("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        in = e("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        as = e("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        jk = e("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        rw = e("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        ys = e("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        br = e("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        aq = e("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        ey = e("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        vm = e("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        yq = e("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        en = e("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        bc = e("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        fa = e("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        vd = e("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        kt = e("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        uo = e("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        ou = e("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        tk = e("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        kx = e("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        vl = e("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        qb = e("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        zm = e("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        yk = e("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        fg = e("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        ah = e("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        vr = e("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        ay = e("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        xo = e("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        eb = e("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        gm = e("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        pc = e("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        o = e("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        ju = e("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        zw = e("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        yx = e("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        rd = e("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        ui = e("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        bp = e("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        ne = e("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    private v(String str) {
        str.getClass();
        this.u = str;
    }

    public static synchronized v e(String str) {
        v vVar;
        Map<String, v> map = gz;
        vVar = map.get(str);
        if (vVar == null) {
            vVar = new v(str);
            map.put(str, vVar);
        }
        return vVar;
    }

    public String toString() {
        return this.u;
    }

    public static List<v> e(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(e(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static v e(String str, int i2) {
        return e(str);
    }

    public String e() {
        return this.u;
    }
}
