package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import miuix.pickerwidget.date.DateUtils;

/* JADX INFO: loaded from: classes.dex */
class bh {
    e bf = new e();
    final bf e;

    public interface bf {
        int bf();

        int bf(View view);

        int e();

        int e(View view);

        View e(int i);
    }

    public static class e {
        int bf;
        int d;
        int e = 0;
        int ga;
        int tg;

        public boolean bf() {
            int i = this.e;
            if ((i & 7) != 0 && (i & (e(this.tg, this.bf) << 0)) == 0) {
                return false;
            }
            int i2 = this.e;
            if ((i2 & 112) != 0 && (i2 & (e(this.tg, this.d) << 4)) == 0) {
                return false;
            }
            int i3 = this.e;
            if ((i3 & 1792) != 0 && (i3 & (e(this.ga, this.bf) << 8)) == 0) {
                return false;
            }
            int i4 = this.e;
            return (i4 & DateUtils.FORMAT_ABBREV_ALL) == 0 || (i4 & (e(this.ga, this.d) << 12)) != 0;
        }

        public int e(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        public void e(int i, int i2, int i3, int i4) {
            this.bf = i;
            this.d = i2;
            this.tg = i3;
            this.ga = i4;
        }

        public void e(int i) {
            this.e = i | this.e;
        }

        public void e() {
            this.e = 0;
        }
    }

    public bh(bf bfVar) {
        this.e = bfVar;
    }

    public View e(int i, int i2, int i3, int i4) {
        int iE = this.e.e();
        int iBf = this.e.bf();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewE = this.e.e(i);
            this.bf.e(iE, iBf, this.e.e(viewE), this.e.bf(viewE));
            if (i3 != 0) {
                this.bf.e();
                this.bf.e(i3);
                if (this.bf.bf()) {
                    return viewE;
                }
            }
            if (i4 != 0) {
                this.bf.e();
                this.bf.e(i4);
                if (this.bf.bf()) {
                    view = viewE;
                }
            }
            i += i5;
        }
        return view;
    }
}
