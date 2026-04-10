package com.open.hule.library.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.FragmentActivity;
import com.liulishuo.filedownloader.q;
import com.open.hule.library.CustomException;
import com.open.hule.library.R$id;
import com.open.hule.library.R$string;
import com.open.hule.library.entity.AppUpdate;
import com.open.hule.library.entity.SafBean;
import com.open.hule.library.entity.TipsBean;
import java.io.File;
import java.util.Locale;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: compiled from: UpdateRemindDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends k {
    private int A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.open.hule.library.b.b f17682t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private View f17683u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Button f17684v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f17685w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f17686x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f17687y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f17688z;

    private void i() {
        if (getActivity() == null) {
            return;
        }
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            j();
            return;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Toast.makeText(getActivity(), getResources().getString(R$string.update_permission), 1).show();
        }
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
    }

    private void j() {
        if (!this.f17686x) {
            this.f17682t.a(true);
            return;
        }
        SafBean safBean = new SafBean();
        safBean.setFile(null);
        safBean.setType(3);
        safBean.setMigration_package("");
        this.f17682t.a(safBean);
    }

    @Override // com.open.hule.library.view.k
    int a() {
        return 0;
    }

    public void g() {
        View view = this.f17683u;
        if (view == null || this.f17684v == null) {
            return;
        }
        view.setEnabled(false);
        a(false, 0.4f);
        this.f17684v.setText("正在下载更新");
        this.f17684v.setTextColor(-1);
        this.f17685w.setText("无法更新？");
    }

    public void h() {
        if (this.f17684v != null) {
            a(false, 0.4f);
            this.f17684v.setText("正在准备下载...");
        }
    }

    @Override // com.open.hule.library.view.k, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        AppUpdate appUpdate;
        return (getArguments() == null || (appUpdate = (AppUpdate) getArguments().getParcelable("appUpdate")) == null || appUpdate.getUpdateResourceId() == 0) ? layoutInflater.inflate(a(), viewGroup, false) : layoutInflater.inflate(appUpdate.getUpdateResourceId(), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1) {
            if (iArr.length > 0 && iArr[0] == 0) {
                j();
            } else {
                Toast.makeText(getActivity(), getResources().getString(R$string.update_permission), 1).show();
                dismiss();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getActivity() == null) {
            return;
        }
        if (view == null) {
            dismiss();
            return;
        }
        if (getArguments() == null) {
            dismiss();
            return;
        }
        AppUpdate appUpdate = (AppUpdate) getArguments().getParcelable("appUpdate");
        if (appUpdate == null) {
            dismiss();
            return;
        }
        TipsBean tipsBean = appUpdate.getTipsBean();
        if (tipsBean == null) {
            dismiss();
            return;
        }
        this.f17686x = false;
        try {
            ((ImageView) view.findViewById(R$id.iv_top)).setImageResource(appUpdate.getTop_imgResourceId());
            TextView textView = (TextView) view.findViewById(R$id.tvTitle);
            TextView textView2 = (TextView) view.findViewById(R$id.tvForceUpdate);
            TextView textView3 = (TextView) view.findViewById(R$id.tvContent);
            ((MaxHeightScrollView) view.findViewById(R$id.scrollview)).setMaxHeight(tipsBean.getMaxHeight());
            String newVersionCode = appUpdate.getNewVersionCode();
            if (TextUtils.isEmpty(newVersionCode)) {
                textView.setText("发现新版本");
            } else {
                textView.setText(String.format("发现新版本%s", newVersionCode));
            }
            String tips_content = tipsBean.getTips_content();
            if (tips_content.contains("https://") || tips_content.contains("http://") || tips_content.contains("&nbsp;")) {
                textView3.setText(Html.fromHtml(tips_content.replaceAll("；", "；<br/>").replaceAll("。", "；<br/>").replaceAll("：", "：<br/>").replaceAll("&nbsp;", "")));
            } else {
                if (TextUtils.isEmpty(tips_content)) {
                    tips_content = getResources().getString(R$string.default_update_content);
                }
                textView3.setText(tips_content);
                textView3.setMovementMethod(new ScrollingMovementMethod());
            }
            this.f17683u = view.findViewById(R$id.iv_close);
            this.f17685w = (TextView) view.findViewById(R$id.tv_help);
            ((TextView) view.findViewById(R$id.tv_feedback)).setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f17678s.a(view2);
                }
            });
            this.f17684v = (Button) view.findViewById(R$id.btnUpdateNow);
            this.f17684v.setBackgroundResource(appUpdate.getBtnBgResourceId());
            this.f17684v.setText(appUpdate.getUpdateText());
            this.f17684v.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f17679s.b(view2);
                }
            });
            String savePath = appUpdate.getSavePath();
            final String newVersionUrl = appUpdate.getNewVersionUrl();
            this.f17688z = tipsBean.getMd5_key();
            String tips_app = tipsBean.getTips_app();
            final FragmentActivity activity = getActivity();
            if (activity != null) {
                if (!TextUtils.isEmpty(tips_app)) {
                    this.f17684v.setText(String.format("立即下载【%s】", tips_app));
                }
                this.f17685w.setText("无法更新？");
                File externalFilesDir = activity.getExternalFilesDir(savePath);
                String strB = com.open.hule.library.c.b.b(newVersionUrl);
                if (!TextUtils.isEmpty(strB)) {
                    final File file = new File(externalFilesDir, strB);
                    if (file.exists()) {
                        if (TextUtils.isEmpty(this.f17688z) || !com.open.hule.library.c.b.a(this.f17688z, file)) {
                            this.f17684v.setText("立即安装");
                        } else {
                            this.f17684v.setText("安全安装");
                        }
                        this.f17685w.setText("无法安装？");
                        this.f17684v.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.g
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                this.f17674s.a(file, view2);
                            }
                        });
                    }
                }
                String tips_appremark = tipsBean.getTips_appremark();
                String tips_logo = tipsBean.getTips_logo();
                final String matchFormat = tipsBean.getMatchFormat();
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.rl_app_info);
                if (TextUtils.isEmpty(tips_app) || TextUtils.isEmpty(tips_appremark) || TextUtils.isEmpty(tips_logo) || TextUtils.isEmpty(matchFormat)) {
                    relativeLayout.setVisibility(8);
                } else {
                    relativeLayout.setVisibility(0);
                    ImageView imageView = (ImageView) view.findViewById(R$id.tips_logo);
                    TextView textView4 = (TextView) view.findViewById(R$id.tips_app);
                    TextView textView5 = (TextView) view.findViewById(R$id.tips_appremark);
                    textView4.setText(tips_app);
                    textView5.setText(tips_appremark);
                    me.jessyan.art.f.e.a(activity).imageLoader().a(activity, ImageConfigImpl.builder().imageRadius(20).url(tips_logo).imageView(imageView).build());
                    if (com.open.hule.library.c.b.b(activity, matchFormat)) {
                        this.f17684v.setText("立即启动新应用");
                        this.f17684v.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.h
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                this.f17676s.a(matchFormat, view2);
                            }
                        });
                        this.f17685w.setText("无法启动？");
                    }
                    textView.setText("停止维护通知");
                    textView.setTextColor(SupportMenu.CATEGORY_MASK);
                }
                this.f17686x = relativeLayout.getVisibility() == 0;
            }
            this.A = appUpdate.getForceUpdate();
            if (this.A == 0) {
                this.f17683u.setVisibility(0);
            } else {
                this.f17683u.setVisibility(4);
            }
            if (this.f17686x || this.A == 0) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
            this.f17683u.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f17670s.c(view2);
                }
            });
            this.f17685w.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f17671s.a(newVersionUrl, activity, view2);
                }
            });
        } catch (Exception unused) {
            if (getActivity() == null) {
                return;
            }
            dismiss();
        }
    }

    /* JADX INFO: compiled from: UpdateRemindDialog.java */
    class a extends com.liulishuo.filedownloader.i {
        final /* synthetic */ FragmentActivity a;
        final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17689c;

        a(FragmentActivity fragmentActivity, String str, String str2) {
            this.a = fragmentActivity;
            this.b = str;
            this.f17689c = str2;
        }

        @Override // com.liulishuo.filedownloader.i
        protected void a(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
        }

        @Override // com.liulishuo.filedownloader.i
        protected void a(com.liulishuo.filedownloader.a aVar, String str, boolean z2, int i2, int i3) {
            m.this.f17687y = com.open.hule.library.c.b.a(i3);
            String str2 = "connected:" + m.this.f17687y;
        }

        @Override // com.liulishuo.filedownloader.i
        protected void a(com.liulishuo.filedownloader.a aVar, Throwable th, int i2, int i3) {
        }

        @Override // com.liulishuo.filedownloader.i
        protected void b(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
            if (m.this.f17684v == null) {
                a(aVar, new CustomException("系统异常，请退出重试！"));
            } else {
                m.this.a(false, 0.4f);
                m.this.f17684v.setText("正在准备下载...");
            }
        }

        @Override // com.liulishuo.filedownloader.i
        protected void c(com.liulishuo.filedownloader.a aVar, int i2, int i3) {
            String strA = com.open.hule.library.c.b.a(i2);
            if (TextUtils.isEmpty(m.this.f17687y)) {
                m.this.f17687y = com.open.hule.library.c.b.a(i3);
            }
            if (m.this.f17683u != null && m.this.f17683u.getVisibility() == 0) {
                m.this.f17683u.setVisibility(4);
            }
            if (m.this.f17684v != null) {
                m.this.f17684v.setText(String.format("已下载：%s/%s", strA, m.this.f17687y));
            }
        }

        @Override // com.liulishuo.filedownloader.i
        protected void d(com.liulishuo.filedownloader.a aVar) {
        }

        @Override // com.liulishuo.filedownloader.i
        protected void a(com.liulishuo.filedownloader.a aVar) {
            String str = "blockComplete，下发的md5：" + m.this.f17688z;
        }

        @Override // com.liulishuo.filedownloader.i
        @SuppressLint({"SetTextI18n"})
        protected void a(com.liulishuo.filedownloader.a aVar, Throwable th) {
            boolean zA = me.jessyan.art.f.e.a();
            String str = "error," + zA;
            if (zA) {
                if (m.this.f17684v != null) {
                    m.this.a(true, 1.0f);
                    if (th instanceof CustomException) {
                        Toast.makeText(this.a, th.getMessage(), 1).show();
                    } else {
                        Toast.makeText(this.a, "下载失败，请点击重试！", 1).show();
                    }
                    m.this.f17684v.setText("下载失败，请点击重试！");
                    if (m.this.A == 0) {
                        m.this.f17683u.setVisibility(0);
                    } else {
                        m.this.f17683u.setVisibility(4);
                    }
                    m.this.f17685w.setText("无法更新？");
                    Button button = m.this.f17684v;
                    final String str2 = this.b;
                    final String str3 = this.f17689c;
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.open.hule.library.view.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f17667s.a(str2, str3, view);
                        }
                    });
                    return;
                }
                Toast.makeText(m.this.getActivity(), "下载失败，正在使用手机默认浏览器下载", 0).show();
                com.open.hule.library.c.b.a(this.b, m.this.getActivity());
            }
        }

        @Override // com.liulishuo.filedownloader.i
        protected void b(com.liulishuo.filedownloader.a aVar) {
            String path = aVar.getPath();
            if (!TextUtils.isEmpty(path)) {
                if (m.this.f17684v == null) {
                    a(aVar, new CustomException("系统异常，请退出重试！"));
                    return;
                }
                String str = "completed：" + path;
                if (!TextUtils.isEmpty(m.this.f17688z)) {
                    File file = new File(path);
                    if (file.exists()) {
                        if (com.open.hule.library.c.b.a(m.this.f17688z, file)) {
                            m.this.a(file);
                            return;
                        } else {
                            a(aVar, new CustomException("文件校验失败！"));
                            return;
                        }
                    }
                    a(aVar, new CustomException("下载文件不存在！"));
                    return;
                }
                File file2 = new File(path);
                if (file2.exists()) {
                    m.this.a(file2);
                    return;
                }
                return;
            }
            a(aVar, new CustomException("下载文件不存在，请退出重试！"));
        }

        public /* synthetic */ void a(String str, String str2, View view) {
            m.this.a(str, str2, false);
        }
    }

    public /* synthetic */ void b(View view) {
        if (this.f17682t != null) {
            i();
        }
    }

    public void c(int i2) {
        Button button = this.f17684v;
        if (button == null || i2 <= 0) {
            return;
        }
        if (i2 < 100) {
            a(false, 0.4f);
            this.f17684v.setText(String.format(Locale.getDefault(), "%s%d%%", "正在下载更新", Integer.valueOf(i2)));
        } else {
            button.setText("下载完成,立即安装");
            a(true, 1.0f);
            this.f17685w.setText("无法安装？");
        }
    }

    public void f() {
        if (this.f17684v != null) {
            a(true, 1.0f);
            this.f17684v.setText("请使用系统浏览器打开网页更新");
            this.f17684v.setTextColor(-1);
            this.f17685w.setText("无法更新？");
        }
    }

    public static m a(Bundle bundle) {
        m mVar = new m();
        if (bundle != null) {
            mVar.setArguments(bundle);
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, float f2) {
        this.f17684v.setEnabled(z2);
        this.f17684v.setAlpha(f2);
    }

    public /* synthetic */ void c(View view) {
        com.open.hule.library.b.b bVar = this.f17682t;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void a(String str) {
        if (this.f17684v != null) {
            a(true, 1.0f);
            this.f17684v.setText(str);
            this.f17684v.setTextColor(-1);
            this.f17685w.setText("无法更新？");
        }
    }

    public m a(com.open.hule.library.b.b bVar) {
        this.f17682t = bVar;
        return this;
    }

    public /* synthetic */ void a(View view) {
        com.open.hule.library.b.b bVar = this.f17682t;
        if (bVar != null) {
            bVar.gotoFeedback();
        }
    }

    public /* synthetic */ void a(File file, View view) {
        a(file, true);
    }

    public /* synthetic */ void a(String str, View view) {
        SafBean safBean = new SafBean();
        safBean.setFile(null);
        safBean.setType(2);
        safBean.setMigration_package(str);
        this.f17682t.a(safBean);
    }

    public /* synthetic */ void a(String str, FragmentActivity fragmentActivity, View view) {
        CharSequence text;
        TextView textView = this.f17685w;
        if (textView == null || (text = textView.getText()) == null) {
            return;
        }
        String string = text.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        byte b = -1;
        int iHashCode = string.hashCode();
        if (iHashCode != -832937263) {
            if (iHashCode != -830699218) {
                if (iHashCode == -828168626 && string.equals("无法更新？")) {
                    b = 0;
                }
            } else if (string.equals("无法安装？")) {
                b = 1;
            }
        } else if (string.equals("无法启动？")) {
            b = 2;
        }
        if (b == 0) {
            Toast.makeText(getActivity(), "正在使用手机默认浏览器下载", 0).show();
            com.open.hule.library.c.b.a(str, getActivity());
        } else if (b == 1) {
            Toast.makeText(getActivity(), "正在使用手机默认浏览器重新下载", 0).show();
            com.open.hule.library.c.b.a(str, getActivity());
        } else {
            if (b != 2) {
                return;
            }
            Toast.makeText(fragmentActivity, "请检查是否安装新应用", 0).show();
        }
    }

    public void a(String str, String str2, boolean z2) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (z2) {
            q.a(activity);
        }
        String str3 = activity.getExternalFilesDir(str2) + "/" + com.open.hule.library.c.b.b(str);
        String str4 = "path:" + str3;
        com.liulishuo.filedownloader.a aVarA = q.d().a(str);
        aVarA.a(true);
        aVarA.b(str3);
        aVarA.a(new a(activity, str, str2));
        aVarA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        a(true, 1.0f);
        this.f17684v.setText("立即安装");
        this.f17685w.setText("无法安装？");
        a(file, false);
    }

    private void a(File file, boolean z2) {
        com.open.hule.library.b.b bVar = this.f17682t;
        if (bVar != null) {
            if (!this.f17686x) {
                bVar.a(file);
                return;
            }
            if (z2) {
                SafBean safBean = new SafBean();
                safBean.setFile(file);
                safBean.setType(1);
                safBean.setMigration_package("");
                this.f17682t.a(safBean);
                return;
            }
            bVar.a(file);
        }
    }
}
