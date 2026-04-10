package com.amgcyo.cuttadon.h.d;

import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Map;

/* JADX INFO: compiled from: BaseGMUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    protected String a;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseGMUtil.java */
    public static class C0096a {
        public ImageView a;
        public ImageView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Button f3879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextView f3880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public TextView f3881e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TextView f3882f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public LinearLayout f3883g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TextView f3884h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public TextView f3885i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public TextView f3886j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public TextView f3887k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public TextView f3888l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public TextView f3889m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public TextView f3890n;
    }

    /* JADX INFO: compiled from: BaseGMUtil.java */
    public static class b {
        public FrameLayout a;
    }

    /* JADX INFO: compiled from: BaseGMUtil.java */
    public static class c extends C0096a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ImageView f3891o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ImageView f3892p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public ImageView f3893q;
    }

    /* JADX INFO: compiled from: BaseGMUtil.java */
    public static class d extends C0096a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ImageView f3894o;
    }

    /* JADX INFO: compiled from: BaseGMUtil.java */
    public static class e extends C0096a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ImageView f3895o;
    }

    /* JADX INFO: compiled from: BaseGMUtil.java */
    public static class f extends C0096a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ImageView f3896o;
    }

    /* JADX INFO: compiled from: BaseGMUtil.java */
    public static class g extends C0096a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public FrameLayout f3897o;
    }

    protected void a(FrameLayout frameLayout) {
        if (frameLayout != null) {
            com.amgcyo.cuttadon.h.a.c.a(this.a, 0L);
            frameLayout.removeAllViews();
        }
    }

    protected String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(" : ");
            sb.append(map.get(str));
            sb.append(" \n");
        }
        return sb.toString();
    }
}
