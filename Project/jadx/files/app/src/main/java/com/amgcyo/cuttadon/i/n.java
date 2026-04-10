package com.amgcyo.cuttadon.i;

import android.content.Context;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.app.MkApplication;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushAliasCallback;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.tag.TagManager;
import java.util.List;

/* JADX INFO: compiled from: UPushAlias.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    private static void a(Context context, String str, String str2) {
        PushAgent.getInstance(context).addAlias(str, str2, new UPushAliasCallback() { // from class: com.amgcyo.cuttadon.i.d
            @Override // com.umeng.message.api.UPushTagCallback
            public final void onMessage(boolean z2, String str3) {
                n.a(z2, str3);
            }
        });
    }

    private static void b(Context context, String str, String str2) {
        PushAgent.getInstance(context).deleteAlias(str, str2, new UPushAliasCallback() { // from class: com.amgcyo.cuttadon.i.a
            @Override // com.umeng.message.api.UPushTagCallback
            public final void onMessage(boolean z2, String str3) {
                n.b(z2, str3);
            }
        });
    }

    static /* synthetic */ void a(boolean z2, String str) {
        String str2 = "add success:" + z2 + " msg:" + str;
    }

    static /* synthetic */ void b(boolean z2, String str) {
        String str2 = "delete success:" + z2 + " msg:" + str;
    }

    public static void a(MkUser mkUser) {
        if (mkUser != null) {
            a(MkApplication.getAppContext(), "user_" + mkUser.getUser_id(), "at");
        }
    }

    static /* synthetic */ void b(boolean z2, ITagManager.Result result) {
        String str = "deleteTags " + z2 + " " + result;
    }

    static /* synthetic */ void b(o oVar, String str, boolean z2, ITagManager.Result result) {
        if (oVar != null) {
            oVar.a(str);
        }
        String str2 = "deleteTags " + z2 + " " + result;
    }

    public static void a(int i2) {
        if (i2 > 0) {
            b(MkApplication.getAppContext(), "user_" + i2, "at");
        }
    }

    static /* synthetic */ void b(TagManager tagManager, final boolean z2, final List list) {
        String str = "getTags " + z2 + " " + list;
        tagManager.deleteTags(new UPushTagCallback() { // from class: com.amgcyo.cuttadon.i.h
            @Override // com.umeng.message.api.UPushTagCallback
            public final void onMessage(boolean z3, Object obj) {
                n.b(z2, list, z3, (ITagManager.Result) obj);
            }
        }, b(list));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r7, java.lang.String... r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r1 = " 的类型"
            r0.append(r1)
            r0.toString()
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L13:
            if (r2 >= r0) goto L2a
            r3 = r8[r2]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "TAG:"
            r4.append(r5)
            r4.append(r3)
            r4.toString()
            int r2 = r2 + 1
            goto L13
        L2a:
            com.amgcyo.cuttadon.app.MkApplication r0 = com.amgcyo.cuttadon.app.MkApplication.getAppContext()
            com.umeng.message.PushAgent r0 = com.umeng.message.PushAgent.getInstance(r0)
            com.umeng.message.tag.TagManager r0 = r0.getTagManager()
            r2 = -1
            int r3 = r7.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -1335458389: goto L5f;
                case 96417: goto L56;
                case 102230: goto L4c;
                case 1528964772: goto L42;
                default: goto L41;
            }
        L41:
            goto L69
        L42:
            java.lang.String r1 = "get_then_delete"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L69
            r1 = 3
            goto L6a
        L4c:
            java.lang.String r1 = "get"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L69
            r1 = 2
            goto L6a
        L56:
            java.lang.String r3 = "add"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L69
            goto L6a
        L5f:
            java.lang.String r1 = "delete"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L69
            r1 = 1
            goto L6a
        L69:
            r1 = -1
        L6a:
            if (r1 == 0) goto L88
            if (r1 == r6) goto L82
            if (r1 == r5) goto L7c
            if (r1 == r4) goto L73
            goto L8d
        L73:
            com.amgcyo.cuttadon.i.b r7 = new com.amgcyo.cuttadon.i.b
            r7.<init>()
            r0.getTags(r7)
            goto L8d
        L7c:
            com.amgcyo.cuttadon.i.c r7 = new com.umeng.message.api.UPushTagCallback() { // from class: com.amgcyo.cuttadon.i.c
                static {
                    /*
                        com.amgcyo.cuttadon.i.c r0 = new com.amgcyo.cuttadon.i.c
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.amgcyo.cuttadon.i.c) com.amgcyo.cuttadon.i.c.a com.amgcyo.cuttadon.i.c
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.c.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.c.<init>():void");
                }

                @Override // com.umeng.message.api.UPushTagCallback
                public final void onMessage(boolean r1, java.lang.Object r2) {
                    /*
                        r0 = this;
                        java.util.List r2 = (java.util.List) r2
                        com.amgcyo.cuttadon.i.n.a(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.c.onMessage(boolean, java.lang.Object):void");
                }
            }
            r0.getTags(r7)
            goto L8d
        L82:
            com.amgcyo.cuttadon.i.g r7 = new com.umeng.message.api.UPushTagCallback() { // from class: com.amgcyo.cuttadon.i.g
                static {
                    /*
                        com.amgcyo.cuttadon.i.g r0 = new com.amgcyo.cuttadon.i.g
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.amgcyo.cuttadon.i.g) com.amgcyo.cuttadon.i.g.a com.amgcyo.cuttadon.i.g
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.g.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.g.<init>():void");
                }

                @Override // com.umeng.message.api.UPushTagCallback
                public final void onMessage(boolean r1, java.lang.Object r2) {
                    /*
                        r0 = this;
                        com.umeng.message.common.inter.ITagManager$Result r2 = (com.umeng.message.common.inter.ITagManager.Result) r2
                        com.amgcyo.cuttadon.i.n.b(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.g.onMessage(boolean, java.lang.Object):void");
                }
            }
            r0.deleteTags(r7, r8)
            goto L8d
        L88:
            com.amgcyo.cuttadon.i.f r7 = new com.umeng.message.api.UPushTagCallback() { // from class: com.amgcyo.cuttadon.i.f
                static {
                    /*
                        com.amgcyo.cuttadon.i.f r0 = new com.amgcyo.cuttadon.i.f
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.amgcyo.cuttadon.i.f) com.amgcyo.cuttadon.i.f.a com.amgcyo.cuttadon.i.f
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.f.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.f.<init>():void");
                }

                @Override // com.umeng.message.api.UPushTagCallback
                public final void onMessage(boolean r1, java.lang.Object r2) {
                    /*
                        r0 = this;
                        com.umeng.message.common.inter.ITagManager$Result r2 = (com.umeng.message.common.inter.ITagManager.Result) r2
                        com.amgcyo.cuttadon.i.n.a(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.f.onMessage(boolean, java.lang.Object):void");
                }
            }
            r0.addTags(r7, r8)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.n.a(java.lang.String, java.lang.String[]):void");
    }

    static /* synthetic */ void b(boolean z2, List list, boolean z3, ITagManager.Result result) {
        String str = "deleteTags " + z2 + " " + list;
    }

    private static String[] b(List<String> list) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = list.get(i2);
        }
        return strArr;
    }

    static /* synthetic */ void a(boolean z2, ITagManager.Result result) {
        String str = "addTags " + z2 + " " + result;
    }

    static /* synthetic */ void a(boolean z2, List list) {
        String str = "getTags " + z2 + " " + list;
    }

    static /* synthetic */ void a(TagManager tagManager, final boolean z2, final List list) {
        String str = "getTags " + z2 + " " + list;
        tagManager.deleteTags(new UPushTagCallback() { // from class: com.amgcyo.cuttadon.i.l
            @Override // com.umeng.message.api.UPushTagCallback
            public final void onMessage(boolean z3, Object obj) {
                n.a(z2, list, z3, (ITagManager.Result) obj);
            }
        }, b(list));
    }

    static /* synthetic */ void a(boolean z2, List list, boolean z3, ITagManager.Result result) {
        String str = "deleteTags " + z2 + " " + list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(final java.lang.String r5, final com.amgcyo.cuttadon.i.o r6, java.lang.String... r7) {
        /*
            com.amgcyo.cuttadon.app.MkApplication r0 = com.amgcyo.cuttadon.app.MkApplication.getAppContext()
            com.umeng.message.PushAgent r0 = com.umeng.message.PushAgent.getInstance(r0)
            com.umeng.message.tag.TagManager r0 = r0.getTagManager()
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1335458389: goto L35;
                case 96417: goto L2b;
                case 102230: goto L21;
                case 1528964772: goto L17;
                default: goto L16;
            }
        L16:
            goto L3f
        L17:
            java.lang.String r1 = "get_then_delete"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L3f
            r1 = 3
            goto L40
        L21:
            java.lang.String r1 = "get"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L3f
            r1 = 2
            goto L40
        L2b:
            java.lang.String r1 = "add"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L3f
            r1 = 0
            goto L40
        L35:
            java.lang.String r1 = "delete"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L3f
            r1 = 1
            goto L40
        L3f:
            r1 = -1
        L40:
            if (r1 == 0) goto L64
            if (r1 == r4) goto L5b
            if (r1 == r3) goto L52
            if (r1 == r2) goto L49
            goto L6c
        L49:
            com.amgcyo.cuttadon.i.i r5 = new com.amgcyo.cuttadon.i.i
            r5.<init>()
            r0.getTags(r5)
            goto L6c
        L52:
            com.amgcyo.cuttadon.i.j r7 = new com.amgcyo.cuttadon.i.j
            r7.<init>()
            r0.getTags(r7)
            goto L6c
        L5b:
            com.amgcyo.cuttadon.i.e r1 = new com.amgcyo.cuttadon.i.e
            r1.<init>()
            r0.deleteTags(r1, r7)
            goto L6c
        L64:
            com.amgcyo.cuttadon.i.k r1 = new com.amgcyo.cuttadon.i.k
            r1.<init>()
            r0.addTags(r1, r7)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.i.n.a(java.lang.String, com.amgcyo.cuttadon.i.o, java.lang.String[]):void");
    }

    static /* synthetic */ void a(o oVar, String str, boolean z2, ITagManager.Result result) {
        if (oVar != null) {
            oVar.a(str);
        }
        String str2 = "addTags " + z2 + " " + result;
    }

    static /* synthetic */ void a(o oVar, String str, boolean z2, List list) {
        if (oVar != null) {
            oVar.a(str);
        }
        String str2 = "getTags " + z2 + " " + list;
    }

    public static String[] a(List<MkBook> list) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.a(list)) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = String.valueOf(list.get(i2).getBook_id());
        }
        return strArr;
    }
}
