package com.yuewen;

import android.view.View;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class tw3 extends jt {
    public b f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iIndexOf = tw3.this.f13145b.indexOf(view);
            if (iIndexOf < 0 || tw3.this.f == null) {
                return;
            }
            tw3.this.f.a(view, iIndexOf);
        }
    }

    public interface b {
        void a(View view, int i);
    }

    public tw3(View view, int... iArr) {
        super(view, iArr);
        a aVar = new a();
        Iterator<View> it = this.f13145b.iterator();
        while (it.hasNext()) {
            it.next().setOnClickListener(aVar);
        }
    }

    public b j() {
        return this.f;
    }

    public void k(b bVar) {
        this.f = bVar;
    }
}
