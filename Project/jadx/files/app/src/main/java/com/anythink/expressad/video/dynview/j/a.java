package com.anythink.expressad.video.dynview.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.d;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.video.dynview.f.e;
import com.anythink.expressad.video.dynview.g.a;
import com.anythink.expressad.video.dynview.widget.AnyThinkLevelLayoutView;
import com.anythink.expressad.videocommon.view.RoundImageView;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final String a = "DataEnergizeWrapper";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f11645k = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.video.dynview.i.c.b f11646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Bitmap> f11647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f11648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11649f = "#FFFFFFFF";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11650g = "#60000000";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11651h = "#FF5F5F5F";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f11652i = "#90ECECEC";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f11653j = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.anythink.expressad.video.dynview.i.c.a f11654l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f11655m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f11656n = 0;
    public com.anythink.expressad.video.dynview.e.a b = new com.anythink.expressad.video.dynview.e.a() { // from class: com.anythink.expressad.video.dynview.j.a.1
        @Override // com.anythink.expressad.video.dynview.e.a
        public final void a() {
            if (!a.this.f11655m || a.this.f11646c == null) {
                return;
            }
            a.this.f11646c.a(a.this.f11656n * 1000, a.this.f11654l);
            a.this.f11655m = false;
        }

        @Override // com.anythink.expressad.video.dynview.e.a
        public final void b() {
        }

        @Override // com.anythink.expressad.video.dynview.e.a
        public final void c() {
            if (a.this.f11646c != null) {
                a.this.f11646c.c();
                a.this.f11655m = true;
            }
        }
    };

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.j.a$5, reason: invalid class name */
    final class AnonymousClass5 extends com.anythink.expressad.widget.a {
        final /* synthetic */ Map a;

        AnonymousClass5(Map map) {
            this.a = map;
        }

        @Override // com.anythink.expressad.widget.a
        protected final void a(View view) {
            if (a.this.f11648e) {
                return;
            }
            a.f(a.this);
            a.a(a.this, this.a);
        }
    }

    static /* synthetic */ boolean f(a aVar) {
        aVar.f11648e = true;
        return true;
    }

    public final void b(com.anythink.expressad.video.dynview.c cVar, View view, Map map, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            f11645k = ((Boolean) map.get("is_dy_success")).booleanValue();
        }
        f11645k = false;
        ImageView imageView = (ImageView) view.findViewById(a("anythink_reward_icon_riv"));
        TextView textView = (TextView) view.findViewById(a("anythink_reward_title_tv"));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(a("anythink_reward_stars_mllv"));
        TextView textView2 = (TextView) view.findViewById(a("anythink_reward_click_tv"));
        ImageView imageView2 = (ImageView) view.findViewById(a("anythink_videoview_bg"));
        TextView textView3 = (TextView) view.findViewById(a("anythink_reward_desc_tv"));
        List<View> arrayList = new ArrayList<>();
        List<com.anythink.expressad.foundation.d.c> listG = cVar.g();
        if (listG == null || listG.size() <= 0) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
            return;
        }
        com.anythink.expressad.foundation.d.c cVar2 = listG.get(0);
        if (cVar2 == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (imageView != null) {
            ((RoundImageView) imageView).setBorderRadius(10);
            a(cVar2.bd(), imageView);
        }
        if (textView != null) {
            textView.setText(cVar2.bb());
        }
        if (textView3 != null) {
            textView3.setText(cVar2.bc());
        }
        if (linearLayout != null) {
            double dAX = cVar2.aX();
            if (dAX <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                dAX = 5.0d;
            }
            ((AnyThinkLevelLayoutView) linearLayout).setRatingAndUser(dAX, cVar2.aY());
        }
        if (textView2 != null) {
            textView2.setText(cVar2.cU);
        }
        int iH = cVar.h();
        if (iH == 102 || iH == 202 || iH == 302) {
            if (textView2 != null) {
                arrayList.add(textView2);
            }
        } else if (iH == 802) {
            if (imageView != null) {
                arrayList.add(imageView);
            }
            if (textView2 != null) {
                arrayList.add(textView2);
            }
            a(imageView2, cVar2.be(), iH);
        } else if (iH == 904 && cVar.k()) {
            arrayList.add(view);
        }
        eVar.a(view, arrayList);
    }

    public final void c(com.anythink.expressad.video.dynview.c cVar, View view, final Map map, e eVar) {
        try {
            if (this.f11647d == null) {
                this.f11647d = new HashMap();
            }
            final List<com.anythink.expressad.foundation.d.c> listG = cVar.g();
            if (view.getContext() == null) {
                eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                f11645k = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            f11645k = false;
            ListView listView = (ListView) view.findViewById(a("anythink_order_view_lv"));
            GridView gridView = (GridView) view.findViewById(a("anythink_order_view_h_lv"));
            ImageView imageView = (ImageView) view.findViewById(a("anythink_order_view_iv_close"));
            com.anythink.expressad.video.dynview.ordercamp.a.a aVar = new com.anythink.expressad.video.dynview.ordercamp.a.a(listG);
            if (cVar.e() == 1) {
                if (listView != null) {
                    listView.setAdapter((ListAdapter) aVar);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.anythink.expressad.video.dynview.j.a.7
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                            a.a(a.this, map, listG, i2);
                        }
                    });
                }
            } else if (gridView != null) {
                int iD = (int) cVar.d();
                int size = iD / listG.size();
                int i2 = size / 9;
                int i3 = i2 / 2;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams.width = iD - (i2 * 2);
                gridView.setLayoutParams(layoutParams);
                gridView.setColumnWidth((size - i2) - (i3 / 2));
                gridView.setHorizontalSpacing(i3);
                gridView.setStretchMode(0);
                gridView.setNumColumns(listG.size());
                gridView.setAdapter((ListAdapter) aVar);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.anythink.expressad.video.dynview.j.a.8
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view2, int i4, long j2) {
                        a.a(a.this, map, listG, i4);
                    }
                });
            }
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.video.dynview.j.a.9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        a.b(a.this, map);
                    }
                });
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        } catch (Exception unused) {
            if (eVar != null) {
                eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.expressad.video.dynview.c r33, android.view.View r34, final java.util.Map r35, com.anythink.expressad.video.dynview.f.e r36) {
        /*
            Method dump skipped, instruction units count: 831
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.video.dynview.j.a.a(com.anythink.expressad.video.dynview.c, android.view.View, java.util.Map, com.anythink.expressad.video.dynview.f.e):void");
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.j.a$6, reason: invalid class name */
    final class AnonymousClass6 implements com.anythink.expressad.video.dynview.i.c.a {
        final /* synthetic */ TextView a;
        final /* synthetic */ Map b;

        AnonymousClass6(TextView textView, Map map) {
            this.a = textView;
            this.b = map;
        }

        @Override // com.anythink.expressad.video.dynview.i.c.a
        public final void a(long j2) {
            String str;
            a.this.f11656n = (int) (j2 / 1000);
            long j3 = a.this.f11656n;
            String strF = d.f(this.a.getContext());
            if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.V)) {
                if (strF.contains(com.anythink.expressad.video.dynview.a.a.ad) || strF.contains(com.anythink.expressad.video.dynview.a.a.ae)) {
                    str = j3 + com.anythink.expressad.video.dynview.a.a.G;
                } else {
                    str = j3 + com.anythink.expressad.video.dynview.a.a.F;
                }
            } else if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.W)) {
                str = j3 + com.anythink.expressad.video.dynview.a.a.I;
            } else if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.X)) {
                str = com.anythink.expressad.video.dynview.a.a.J + j3 + " Sekunden";
            } else if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.Y)) {
                str = j3 + com.anythink.expressad.video.dynview.a.a.K;
            } else if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.Z)) {
                str = com.anythink.expressad.video.dynview.a.a.L + j3 + " secondes";
            } else if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.aa)) {
                str = " ثوان" + j3 + com.anythink.expressad.video.dynview.a.a.M;
            } else if (strF.startsWith(com.anythink.expressad.video.dynview.a.a.ab)) {
                str = com.anythink.expressad.video.dynview.a.a.N + j3 + " секунд";
            } else {
                str = com.anythink.expressad.video.dynview.a.a.H + j3 + " s";
            }
            this.a.setText(str);
            a.this.f11653j++;
        }

        @Override // com.anythink.expressad.video.dynview.i.c.a
        public final void a() {
            a.a(a.this, this.b);
        }
    }

    private void b(Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
                    ((com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E)).a();
                    b();
                }
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
        }
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private static void b(com.anythink.expressad.video.dynview.c cVar, View view) {
        a.C0223a c0223aA = com.anythink.expressad.video.dynview.g.a.a();
        c0223aA.a(cVar.e()).a();
        if (cVar.e() != 2 || cVar.d() > cVar.c()) {
            c0223aA.a(cVar.d()).b(cVar.c());
        } else {
            c0223aA.a(cVar.c()).b(cVar.d());
        }
        if (view.getBackground() == null) {
            view.setBackgroundDrawable(c0223aA.b());
        }
    }

    private void b() {
        com.anythink.expressad.video.dynview.i.a.a.a().b();
        com.anythink.expressad.video.dynview.i.c.b bVar = this.f11646c;
        if (bVar != null) {
            bVar.c();
            this.f11646c = null;
        }
        com.anythink.expressad.video.dynview.b.a.a().a = null;
        if (this.b != null) {
            this.b = null;
        }
        Map<String, Bitmap> map = this.f11647d;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    Iterator<Map.Entry<String, Bitmap>> it = this.f11647d.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<String, Bitmap> next = it.next();
                        if (next != null && next.getValue() != null && !next.getValue().isRecycled()) {
                            next.getValue().recycle();
                        }
                        it.remove();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f11647d.clear();
        }
    }

    static /* synthetic */ void b(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
                    ((com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E)).a();
                    aVar.b();
                }
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
        }
    }

    public final void a(com.anythink.expressad.video.dynview.c cVar, View view, e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            return;
        }
        try {
            ImageView imageView = (ImageView) view.findViewById(a("anythink_iv_adbanner_bg"));
            if (imageView != null) {
                imageView.setBackgroundColor(Color.parseColor(this.f11652i));
            }
            ImageView imageView2 = (ImageView) view.findViewById(a("anythink_iv_adbanner"));
            if (imageView2 != null) {
                imageView2.setBackgroundColor(Color.parseColor(this.f11652i));
            }
            eVar.a(view, new ArrayList());
        } catch (Exception e2) {
            o.a(a, e2.getMessage());
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
        }
    }

    private void a(String str, Context context, View view, int i2, Map map) {
        FrameLayout.LayoutParams layoutParams;
        String strA = x.a(str, "cltp");
        long j2 = !TextUtils.isEmpty(strA) ? Long.parseLong(strA) : 0L;
        if (j2 != 0) {
            if (map != null && map.containsKey("is_dy_success")) {
                f11645k = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            f11645k = false;
            TextView textView = (TextView) view.findViewById(a("anythink_choice_one_countdown_tv"));
            textView.setTextSize(11.0f);
            textView.setTextColor(Color.parseColor(this.f11649f));
            String str2 = this.f11650g;
            if (textView != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor(str2));
                gradientDrawable.setCornerRadius(t.b(textView.getContext(), 12.0f));
                gradientDrawable.setStroke(t.b(textView.getContext(), 1.0f), Color.parseColor(str2));
                textView.setBackgroundDrawable(gradientDrawable);
            }
            if (i2 == 2 && (layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams()) != null) {
                int iD = t.d(context);
                int iB = t.b(context, 10.0f);
                layoutParams.setMargins(iB, iB, iD, iB);
            }
            if (textView != null) {
                textView.setVisibility(0);
                textView.setOnClickListener(new AnonymousClass5(map));
                this.f11654l = new AnonymousClass6(textView, map);
                this.f11646c = new com.anythink.expressad.video.dynview.i.c.b().a(j2 * 1000).a().a(this.f11654l);
                this.f11646c.b();
            }
        }
    }

    private void a(String str, ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView, str, -1);
    }

    private void a(final ImageView imageView, String str, final int i2) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(imageView.getContext()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.dynview.j.a.10
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                if (bitmap == null || bitmap.isRecycled()) {
                    int iA = i.a(imageView.getContext(), "anythink_icon_play_bg", i.f10645c);
                    imageView.setBackgroundColor(Color.parseColor(a.this.f11651h));
                    imageView.setImageResource(iA);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    return;
                }
                int i3 = i2;
                if (i3 != 501 && i3 != 802) {
                    imageView.setImageBitmap(bitmap);
                    return;
                }
                ImageView imageView2 = imageView;
                com.anythink.expressad.video.dynview.i.b.a();
                imageView2.setImageBitmap(com.anythink.expressad.video.dynview.i.b.a(bitmap, 0));
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
                try {
                    int iA = i.a(imageView.getContext(), "anythink_icon_play_bg", i.f10645c);
                    imageView.setBackgroundColor(Color.parseColor(a.this.f11651h));
                    imageView.setImageResource(iA);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                } catch (Exception e2) {
                    o.a(a.a, e2.getMessage());
                }
            }
        });
    }

    private void a(final String str, final ImageView imageView, final com.anythink.expressad.video.dynview.c cVar, final View view) {
        com.anythink.expressad.foundation.g.d.b.a(imageView.getContext()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.dynview.j.a.2
            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(Bitmap bitmap, String str2) {
                ImageView imageView2;
                if (bitmap == null || bitmap.isRecycled() || (imageView2 = imageView) == null) {
                    return;
                }
                imageView2.setImageBitmap(bitmap);
                if (a.this.f11647d != null) {
                    a.this.f11647d.put(p.a(str), bitmap);
                    a.a(a.this, cVar, view);
                }
            }

            @Override // com.anythink.expressad.foundation.g.d.c
            public final void a(String str2, String str3) {
            }
        });
        if (a() != null) {
            b(cVar, view);
        }
    }

    private void a(Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
                    ((com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D)).a();
                    b();
                }
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
        }
    }

    private void a(Map map, List<com.anythink.expressad.foundation.d.c> list, int i2) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
            com.anythink.expressad.video.dynview.f.d dVar = (com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D);
            if (dVar != null) {
                dVar.a(list.get(i2));
            }
            b();
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
            com.anythink.expressad.video.dynview.f.c cVar = (com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E);
            if (cVar != null) {
                cVar.a(list.get(i2), i2);
            }
            b();
        }
    }

    private void a(com.anythink.expressad.video.dynview.c cVar, View view) {
        Map<String, Bitmap> map = this.f11647d;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.anythink.expressad.video.dynview.h.b();
        Map<String, Bitmap> map2 = this.f11647d;
        if (view != null) {
            com.anythink.expressad.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }

    private static int a(String str) {
        return i.a(n.a().g(), str, "id");
    }

    private Bitmap a() {
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
            bitmapCreateBitmap.eraseColor(Color.parseColor(this.f11652i));
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            if (!com.anythink.expressad.a.a) {
                return bitmapCreateBitmap;
            }
            e2.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    static /* synthetic */ void a(a aVar, Map map, List list, int i2) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
            com.anythink.expressad.video.dynview.f.d dVar = (com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D);
            if (dVar != null) {
                dVar.a((com.anythink.expressad.foundation.d.c) list.get(i2));
            }
            aVar.b();
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
            com.anythink.expressad.video.dynview.f.c cVar = (com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E);
            if (cVar != null) {
                cVar.a((com.anythink.expressad.foundation.d.c) list.get(i2), i2);
            }
            aVar.b();
        }
    }

    static /* synthetic */ void a(a aVar, Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
                    ((com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D)).a();
                    aVar.b();
                }
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(a aVar, com.anythink.expressad.video.dynview.c cVar, View view) {
        Map<String, Bitmap> map = aVar.f11647d;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.anythink.expressad.video.dynview.h.b();
        Map<String, Bitmap> map2 = aVar.f11647d;
        if (view != null) {
            com.anythink.expressad.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }
}
