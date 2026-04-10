package com.anythink.expressad.foundation.g.c;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends f {
    private static final String b = "anythink_template/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10471c = "anythink_template/res/Movies";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10472d = "anythink_template/res";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10473e = "anythink_template/res/.Anythink_VC";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10474f = "anythink_template/res/.anythink700";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f10475g = "anythink_template/res/img";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f10476h = "anythink_template/crashinfo";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10477i = "anythink_template/other";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f10478j = "anythink_template/res/xml";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f10479k = "anythink_template/anythink/config";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f10480l = "anythink_template/res/res";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f10481m = "anythink_template/res/html";

    public b(String str) {
        super(str);
    }

    @Override // com.anythink.expressad.foundation.g.c.f
    protected final List<e> a() {
        ArrayList arrayList = new ArrayList();
        f.a(arrayList, a.ANYTHINK_RES_MANAGER_DIR, f10472d);
        f.a(arrayList, a.AD_MOVIES, f10471c).a(a.ANYTHINK_VC, f10473e);
        e eVarA = f.a(arrayList, a.AD_ANYTHINK_700, f10474f);
        eVarA.a(a.ANYTHINK_700_IMG, f10475g);
        eVarA.a(a.ANYTHINK_700_XML, f10478j);
        eVarA.a(a.MBRIDGE_700_CONFIG, f10479k);
        eVarA.a(a.ANYTHINK_700_RES, f10480l);
        eVarA.a(a.ANYTHINK_700_HTML, f10481m);
        f.a(arrayList, a.ANYTHINK_OTHER, f10477i);
        f.a(arrayList, a.ANYTHINK_CRASH_INFO, f10476h);
        f.a(arrayList, a.ANYTHINK_OTHER, f10477i);
        return arrayList;
    }
}
