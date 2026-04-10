package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadAlertDialogInfo {
    public String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f17944h;
    public String hj;
    public Drawable ko;
    public View lz;
    public Context mb;
    public String ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f17945u;
    public ox ww;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f17946x;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Scene {
        public static final int BACK_INSTALL = 1;
        public static final int CANCEL = 3;
        public static final int OPEN_APP = 2;
        public static final int WEBVIEW_START = 0;
    }

    public static final class mb {
        private Context b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f17947h;
        private String hj;
        private String ko;
        private Drawable lz;
        public View mb;
        public int ox;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private String f17948u;
        private boolean ww;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private ox f17949x;

        public mb(Context context) {
            this.b = context;
        }

        public mb b(String str) {
            this.f17948u = str;
            return this;
        }

        public mb hj(String str) {
            this.ko = str;
            return this;
        }

        public mb mb(String str) {
            this.hj = str;
            return this;
        }

        public mb ox(String str) {
            this.f17947h = str;
            return this;
        }

        public mb mb(boolean z2) {
            this.ww = z2;
            return this;
        }

        public mb mb(Drawable drawable) {
            this.lz = drawable;
            return this;
        }

        public mb mb(ox oxVar) {
            this.f17949x = oxVar;
            return this;
        }

        public mb mb(int i2) {
            this.ox = i2;
            return this;
        }

        public DownloadAlertDialogInfo mb() {
            return new DownloadAlertDialogInfo(this);
        }
    }

    public interface ox {
        void b(DialogInterface dialogInterface);

        void mb(DialogInterface dialogInterface);

        void ox(DialogInterface dialogInterface);
    }

    private DownloadAlertDialogInfo(mb mbVar) {
        this.f17945u = true;
        this.mb = mbVar.b;
        this.ox = mbVar.hj;
        this.b = mbVar.f17947h;
        this.hj = mbVar.f17948u;
        this.f17944h = mbVar.ko;
        this.f17945u = mbVar.ww;
        this.ko = mbVar.lz;
        this.ww = mbVar.f17949x;
        this.lz = mbVar.mb;
        this.f17946x = mbVar.ox;
    }
}
