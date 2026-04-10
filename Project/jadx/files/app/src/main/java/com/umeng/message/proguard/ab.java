package com.umeng.message.proguard;

import android.net.Uri;
import android.provider.BaseColumns;

/* JADX INFO: compiled from: MessageProviderConst.java */
/* JADX INFO: loaded from: classes3.dex */
public class ab {
    public static final String a = r.b().getPackageName() + ".umeng.message";
    public static final Uri b = a(a.a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f20365c = a(a.b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f20366d = a(a.f20375c);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Uri f20367e = a("MsgAlias");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Uri f20368f = a(a.f20377e);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Uri f20369g = a(a.f20378f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Uri f20370h = a(a.f20379g);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Uri f20371i = a(a.f20380h);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Uri f20372j = a(a.f20381i);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Uri f20373k = a(a.f20382j);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Uri f20374l = a(a.f20383k);

    /* JADX INFO: compiled from: MessageProviderConst.java */
    public static class a implements BaseColumns {
        public static final String a = "MessageStores";
        public static final String b = "MsgSp";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f20375c = "UnionUa";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f20376d = "MsgAlias";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f20377e = "MsgAliasDeleteAll";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f20378f = "MsgLogStores";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f20379g = "MsgLogIdTypeStores";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f20380h = "MsgLogStoreForAgoos";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f20381i = "MsgLogIdTypeStoreForAgoos";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f20382j = "MsgConfigInfos";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f20383k = "InAppLogStores";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f20384l = "vnd.android.cursor.dir/vnd.umeng.message";

        private a() {
        }
    }

    private static Uri a(String str) {
        return Uri.parse("content://" + a + "/" + str);
    }
}
