package com.anythink.expressad.video.dynview.ordercamp.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.dynview.h.b;
import com.anythink.expressad.video.dynview.widget.ATRotationView;
import com.anythink.expressad.video.dynview.widget.AnyThinkImageView;
import com.anythink.expressad.video.dynview.widget.AnyThinkLevelLayoutView;
import com.anythink.expressad.video.dynview.widget.AnyThinkTextView;
import com.anythink.expressad.videocommon.view.RoundImageView;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends BaseAdapter {
    private static final String a = "OrderCampAdapter";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f11689e = "anythink_lv_item_rl";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f11690f = "anythink_lv_iv";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f11691g = "anythink_lv_icon_iv";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f11692h = "anythink_lv_title_tv";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f11693i = "anythink_lv_tv_install";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f11694j = "anythink_lv_sv_starlevel";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f11695k = "anythink_lv_sv_heat_level";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f11696l = "anythink_lv_ration";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f11697m = "anythink_lv_desc_tv";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f11698n = "anythink_iv_flag";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f11699o = "anythink_order_viewed_tv";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f11700p = "anythink_order_layout_item";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f11701q = "anythink_lv_iv_burl";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f11702r = "501";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f11703s = "\\.xml";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f11704t = "\\/xml";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f11705u = "_item.xml";
    private boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0224a f11706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<c> f11707d;

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.ordercamp.a.a$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                int iB = t.b(this.a, 12.0f);
                a.this.f11706c.f11716j.getLayoutParams().height = iB;
                a.this.f11706c.f11716j.getLayoutParams().width = (int) (iB * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                a.this.f11706c.f11716j.setImageBitmap(bitmap);
                a.this.f11706c.f11716j.setBackgroundColor(1426063360);
            } catch (Throwable unused) {
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.video.dynview.ordercamp.a.a$a, reason: collision with other inner class name */
    static class C0224a {
        RelativeLayout a;
        ATRotationView b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AnyThinkImageView f11709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        RoundImageView f11710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        TextView f11711e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        TextView f11712f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        TextView f11713g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        TextView f11714h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        AnyThinkLevelLayoutView f11715i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        ImageView f11716j;

        C0224a() {
        }
    }

    public a(List<c> list) {
        this.f11707d = list;
    }

    private View b() {
        View viewInflate = LayoutInflater.from(n.a().g()).inflate(i.a(n.a().g().getApplicationContext(), f11700p, "layout"), (ViewGroup) null);
        this.f11706c = new C0224a();
        this.f11706c.f11709c = (AnyThinkImageView) viewInflate.findViewById(b(f11690f));
        this.f11706c.f11710d = (RoundImageView) viewInflate.findViewById(b(f11691g));
        this.f11706c.f11715i = (AnyThinkLevelLayoutView) viewInflate.findViewById(b(f11694j));
        this.f11706c.b = (ATRotationView) viewInflate.findViewById(b(f11696l));
        viewInflate.setTag(this.f11706c);
        return viewInflate;
    }

    private static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private int d(String str) {
        return this.b ? c(str) : b(str);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<c> list = this.f11707d;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f11707d.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        List<c> list = this.f11707d;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            if (view == null) {
                View viewInflate = LayoutInflater.from(n.a().g()).inflate(i.a(n.a().g().getApplicationContext(), f11700p, "layout"), (ViewGroup) null);
                this.f11706c = new C0224a();
                this.f11706c.f11709c = (AnyThinkImageView) viewInflate.findViewById(b(f11690f));
                this.f11706c.f11710d = (RoundImageView) viewInflate.findViewById(b(f11691g));
                this.f11706c.f11715i = (AnyThinkLevelLayoutView) viewInflate.findViewById(b(f11694j));
                this.f11706c.b = (ATRotationView) viewInflate.findViewById(b(f11696l));
                viewInflate.setTag(this.f11706c);
                view = viewInflate;
            } else {
                this.f11706c = (C0224a) view.getTag();
            }
            this.f11706c.a = (RelativeLayout) view.findViewById(d(f11689e));
            this.f11706c.f11711e = (TextView) view.findViewById(d(f11692h));
            this.f11706c.f11713g = (TextView) view.findViewById(d(f11693i));
            this.f11706c.f11712f = (TextView) view.findViewById(d(f11697m));
            this.f11706c.f11716j = (ImageView) view.findViewById(d(f11698n));
            this.f11706c.f11714h = (TextView) view.findViewById(d(f11699o));
            if (this.f11707d != null && this.f11706c != null && this.f11707d.size() != 0) {
                if (this.f11706c.f11709c != null) {
                    a(this.f11706c.f11709c, this.f11707d.get(i2).be(), false);
                }
                if (this.f11706c.f11710d != null) {
                    this.f11706c.f11710d.setBorderRadius(25);
                    a(this.f11706c.f11710d, this.f11707d.get(i2).bd(), true);
                }
                double dAX = this.f11707d.get(i2).aX();
                if (dAX <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                    dAX = 5.0d;
                }
                if (this.f11706c.f11715i != null) {
                    this.f11706c.f11715i.setRatingAndUser(dAX, this.f11707d.get(i2).aY());
                    this.f11706c.f11715i.setOrientation(0);
                }
                if (this.f11706c.b != null) {
                    this.f11706c.b.setWidthRatio(1.0f);
                    this.f11706c.b.setHeightRatio(1.0f);
                    this.f11706c.b.setAutoscroll(false);
                }
                if (this.f11706c.f11709c != null) {
                    this.f11706c.f11709c.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                }
            }
            if (this.f11706c != null) {
                c cVar = this.f11707d.get(i2);
                if (this.f11706c.f11711e != null) {
                    this.f11706c.f11711e.setText(cVar.bb());
                }
                if (this.f11706c.f11712f != null) {
                    this.f11706c.f11712f.setText(cVar.bc());
                }
                if (this.f11706c.f11713g != null) {
                    String str = cVar.cU;
                    if (this.f11706c.f11713g instanceof AnyThinkTextView) {
                        new b();
                        ((AnyThinkTextView) this.f11706c.f11713g).setObjectAnimator(b.c(this.f11706c.f11713g));
                    }
                    this.f11706c.f11713g.setText(str);
                }
                if (this.f11706c.f11716j != null) {
                    try {
                        Locale.getDefault().getLanguage();
                        Context contextG = n.a().g();
                        com.anythink.expressad.foundation.g.d.b.a(contextG).a(cVar.aE(), new AnonymousClass2(contextG));
                    } catch (Exception e2) {
                        o.d(a, e2.getMessage());
                    }
                }
                if (this.f11706c.f11714h != null) {
                    try {
                        this.f11706c.f11714h.setText(n.a().g().getResources().getString(n.a().g().getResources().getIdentifier("anythink_reward_viewed_text_str", i.f10649g, n.a().g().getPackageName())));
                        this.f11706c.f11714h.setVisibility(0);
                    } catch (Exception e3) {
                        o.d(a, e3.getMessage());
                    }
                }
            }
        } catch (Exception e4) {
            o.d(a, e4.getMessage());
        }
        return view;
    }

    private void a(int i2) {
        List<c> list = this.f11707d;
        if (list == null || this.f11706c == null || list.size() == 0) {
            return;
        }
        AnyThinkImageView anyThinkImageView = this.f11706c.f11709c;
        if (anyThinkImageView != null) {
            a(anyThinkImageView, this.f11707d.get(i2).be(), false);
        }
        RoundImageView roundImageView = this.f11706c.f11710d;
        if (roundImageView != null) {
            roundImageView.setBorderRadius(25);
            a(this.f11706c.f11710d, this.f11707d.get(i2).bd(), true);
        }
        double dAX = this.f11707d.get(i2).aX();
        if (dAX <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            dAX = 5.0d;
        }
        AnyThinkLevelLayoutView anyThinkLevelLayoutView = this.f11706c.f11715i;
        if (anyThinkLevelLayoutView != null) {
            anyThinkLevelLayoutView.setRatingAndUser(dAX, this.f11707d.get(i2).aY());
            this.f11706c.f11715i.setOrientation(0);
        }
        ATRotationView aTRotationView = this.f11706c.b;
        if (aTRotationView != null) {
            aTRotationView.setWidthRatio(1.0f);
            this.f11706c.b.setHeightRatio(1.0f);
            this.f11706c.b.setAutoscroll(false);
        }
        AnyThinkImageView anyThinkImageView2 = this.f11706c.f11709c;
        if (anyThinkImageView2 != null) {
            anyThinkImageView2.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
        }
    }

    private static int b(String str) {
        return i.a(n.a().g().getApplicationContext(), str, "id");
    }

    private void b(int i2) {
        if (this.f11706c != null) {
            c cVar = this.f11707d.get(i2);
            if (this.f11706c.f11711e != null) {
                this.f11706c.f11711e.setText(cVar.bb());
            }
            if (this.f11706c.f11712f != null) {
                this.f11706c.f11712f.setText(cVar.bc());
            }
            TextView textView = this.f11706c.f11713g;
            if (textView != null) {
                String str = cVar.cU;
                if (textView instanceof AnyThinkTextView) {
                    new b();
                    ((AnyThinkTextView) this.f11706c.f11713g).setObjectAnimator(b.c(this.f11706c.f11713g));
                }
                this.f11706c.f11713g.setText(str);
            }
            if (this.f11706c.f11716j != null) {
                try {
                    Locale.getDefault().getLanguage();
                    Context contextG = n.a().g();
                    com.anythink.expressad.foundation.g.d.b.a(contextG).a(cVar.aE(), new AnonymousClass2(contextG));
                } catch (Exception e2) {
                    o.d(a, e2.getMessage());
                }
            }
            if (this.f11706c.f11714h != null) {
                try {
                    this.f11706c.f11714h.setText(n.a().g().getResources().getString(n.a().g().getResources().getIdentifier("anythink_reward_viewed_text_str", i.f10649g, n.a().g().getPackageName())));
                    this.f11706c.f11714h.setVisibility(0);
                } catch (Exception e3) {
                    o.d(a, e3.getMessage());
                }
            }
        }
    }

    private void a(View view) {
        this.f11706c.a = (RelativeLayout) view.findViewById(d(f11689e));
        this.f11706c.f11711e = (TextView) view.findViewById(d(f11692h));
        this.f11706c.f11713g = (TextView) view.findViewById(d(f11693i));
        this.f11706c.f11712f = (TextView) view.findViewById(d(f11697m));
        this.f11706c.f11716j = (ImageView) view.findViewById(d(f11698n));
        this.f11706c.f11714h = (TextView) view.findViewById(d(f11699o));
    }

    private void a(final ImageView imageView, String str, final boolean z2) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            com.anythink.expressad.foundation.g.d.b.a(imageView.getContext()).a(str, new com.anythink.expressad.foundation.g.d.c() { // from class: com.anythink.expressad.video.dynview.ordercamp.a.a.1
                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(Bitmap bitmap, String str2) {
                    try {
                        if (bitmap.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    } catch (Throwable th) {
                        o.d(a.a, th.getMessage());
                    }
                }

                @Override // com.anythink.expressad.foundation.g.d.c
                public final void a(String str2, String str3) {
                    if (z2) {
                        imageView.setVisibility(8);
                    }
                }
            });
        } else if (z2) {
            imageView.setVisibility(8);
        }
    }

    private static int a(String str) {
        return i.a(n.a().g().getApplicationContext(), str, "layout");
    }

    private View a() {
        View viewInflate = LayoutInflater.from(n.a().g()).inflate(i.a(n.a().g().getApplicationContext(), f11700p, "layout"), (ViewGroup) null);
        this.f11706c = new C0224a();
        this.f11706c.f11709c = (AnyThinkImageView) viewInflate.findViewById(b(f11690f));
        this.f11706c.f11710d = (RoundImageView) viewInflate.findViewById(b(f11691g));
        this.f11706c.f11715i = (AnyThinkLevelLayoutView) viewInflate.findViewById(b(f11694j));
        this.f11706c.b = (ATRotationView) viewInflate.findViewById(b(f11696l));
        viewInflate.setTag(this.f11706c);
        return viewInflate;
    }
}
