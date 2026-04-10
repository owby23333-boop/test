package com.anythink.core.common.e;

import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends i<u> {
    public static final int a = 1;
    public static final int b = 2;
    public int R;
    public long S;
    String T = "";
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private long ae;
    private int af;
    private String ag;
    private String ah;
    private String ai;
    private String aj;
    private String ak;

    private String Z() {
        return this.ak;
    }

    private int aa() {
        return this.R;
    }

    private long ab() {
        return this.S;
    }

    private long ac() {
        return this.ae;
    }

    private void g(int i2) {
        this.R = i2;
    }

    public final void E(String str) {
        this.ah = str;
    }

    public final void F(String str) {
        this.ai = str;
    }

    public final void G(String str) {
        this.aj = str;
    }

    public final void H(String str) {
        this.U = str;
    }

    public final void I(String str) {
        this.V = str;
    }

    public final void J(String str) {
        this.W = str;
    }

    public final void K(String str) {
        this.X = str;
    }

    public final void L(String str) {
        this.Y = str;
    }

    public final void M(String str) {
        this.Z = str;
    }

    public final String N() {
        return this.aj;
    }

    public final int O() {
        return this.af;
    }

    public final String P() {
        return this.U;
    }

    public final String Q() {
        return this.V;
    }

    public final String R() {
        return this.W;
    }

    public final String S() {
        return this.X;
    }

    public final String T() {
        return this.Y;
    }

    public final String U() {
        return this.Z;
    }

    public final String V() {
        return this.aa;
    }

    public final String W() {
        return this.ab;
    }

    public final String X() {
        return this.ac;
    }

    public final String Y() {
        return this.ad;
    }

    public final void a(String str) {
        this.ak = str;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f0  */
    @Override // com.anythink.core.common.e.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.util.List b(com.anythink.core.common.e.k r11) {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.s.b(com.anythink.core.common.e.k):java.util.List");
    }

    public final String c() {
        return this.ai;
    }

    @Override // com.anythink.core.common.e.i
    public final int d() {
        return 1;
    }

    @Override // com.anythink.core.common.e.i
    public final String m() {
        return this.T;
    }

    public final void N(String str) {
        this.aa = str;
    }

    public final void O(String str) {
        this.ab = str;
    }

    public final void P(String str) {
        this.ac = str;
    }

    public final void Q(String str) {
        this.ad = str;
    }

    public final String R(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.ak);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                str = str.replaceAll("\\{" + next + "\\}", jSONObject.optString(next));
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public final String a() {
        return this.ag;
    }

    public final void a(int i2) {
        this.af = i2;
    }

    public final void a(long j2) {
        this.ae = j2;
    }

    public final boolean a(u uVar) {
        return uVar == null || System.currentTimeMillis() - this.ae > uVar.A();
    }

    public final void b(String str) {
        this.ag = str;
    }

    public final String b() {
        return this.ah;
    }

    private void b(long j2) {
        this.S = j2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> b(com.anythink.core.common.e.u r11) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.e.s.b(com.anythink.core.common.e.u):java.util.List");
    }
}
