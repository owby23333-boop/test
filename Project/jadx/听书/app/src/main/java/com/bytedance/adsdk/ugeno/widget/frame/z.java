package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.adsdk.ugeno.g.z<UGFrameLayout> {
    private UGFrameLayout wo;

    public z(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: jq, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout z() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.g);
        this.wo = uGFrameLayout;
        uGFrameLayout.z(this);
        return this.wo;
    }

    @Override // com.bytedance.adsdk.ugeno.g.z, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        this.wo.setEventMap(this.s);
        super.g();
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public z.C0045z gz() {
        return new C0048z(this);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.widget.frame.z$z, reason: collision with other inner class name */
    public static class C0048z extends z.C0045z {
        protected int sy;

        public C0048z(com.bytedance.adsdk.ugeno.g.z zVar) {
            super(zVar);
            this.sy = -1;
        }

        @Override // com.bytedance.adsdk.ugeno.g.z.C0045z
        public void z(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.z(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.sy = z(str2);
            }
        }

        private int z(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iG = 0;
            for (String str2 : strArrSplit) {
                iG |= g(str2);
            }
            return iG;
        }

        private int g(String str) {
            str.hashCode();
            switch (str) {
                case "bottom":
                    return 80;
                case "center":
                    return 17;
                case "center_vertical":
                    return 16;
                case "top":
                    return 48;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center_horizontal":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.g.z.C0045z
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams z() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.z, (int) this.g);
            layoutParams.leftMargin = (int) this.m;
            layoutParams.rightMargin = (int) this.e;
            layoutParams.topMargin = (int) this.gz;
            layoutParams.bottomMargin = (int) this.fo;
            layoutParams.gravity = this.sy;
            return layoutParams;
        }
    }
}
