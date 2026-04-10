package com.amgcyo.cuttadon.activity.user;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import butterknife.BindView;
import butterknife.OnClick;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.other.MkUser;
import com.amgcyo.cuttadon.api.presenter.UserPresenter;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.event.MkCommentEvent;
import com.amgcyo.cuttadon.utils.otherutils.i0;
import com.amgcyo.cuttadon.utils.otherutils.r0;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.widget.lovelydialog.b;
import com.amgcyo.cuttadon.widget.lovelydialog.d;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.fatcatfat.io.R;
import com.umeng.message.common.inter.ITagManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;
import me.jessyan.art.mvp.Message;

/* JADX INFO: loaded from: classes.dex */
public class MkUserModifyActivity extends BaseTitleBarActivity<UserPresenter> {

    @BindView(R.id.iv_userImg)
    ImageView ivUserImg;

    @BindView(R.id.iv_red_circle)
    ImageView iv_red_circle;

    @BindView(R.id.ll_bind_phone)
    LinearLayout llBindPhone;

    @BindView(R.id.ll_nick)
    LinearLayout llNick;

    @BindView(R.id.ll_cancel_account)
    LinearLayout ll_cancel_account;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    MkUser f2954n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private int f2955o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private File f2956p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private Uri f2957q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private Uri f2958r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    int f2959s0 = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    Dialog f2960t0;

    @BindView(R.id.tv_nick)
    TextView tvNick;

    @BindView(R.id.tv_user_name)
    TextView tvUserName;

    @BindView(R.id.tv_phone)
    TextView tv_phone;

    @BindView(R.id.view_line)
    View view_line;

    class a implements com.bumptech.glide.request.g<Bitmap> {
        a(MkUserModifyActivity mkUserModifyActivity) {
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Bitmap bitmap, Object obj, com.bumptech.glide.request.k.j<Bitmap> jVar, DataSource dataSource, boolean z2) {
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, com.bumptech.glide.request.k.j<Bitmap> jVar, boolean z2) {
            return false;
        }
    }

    class b implements com.hjq.permissions.a {
        b() {
        }

        @Override // com.hjq.permissions.a
        public void a(List<String> list, boolean z2) {
            MkUserModifyActivity mkUserModifyActivity = MkUserModifyActivity.this;
            mkUserModifyActivity.f2959s0 = 0;
            mkUserModifyActivity.a(list);
        }

        @Override // com.hjq.permissions.a
        public void b(List<String> list, boolean z2) {
            if (z2) {
                MkUserModifyActivity.this.t();
            }
        }
    }

    private void b(String... strArr) {
        com.hjq.permissions.f fVarA = com.hjq.permissions.f.a((FragmentActivity) this);
        fVarA.a(strArr);
        fVarA.a(new b());
    }

    private void o() {
        this.f2954n0 = AppDatabase.i().d().a();
        if (this.f2954n0 != null) {
            this.view_line.setVisibility(0);
            this.ll_cancel_account.setVisibility(0);
            this.tvNick.setText(this.f2954n0.getNick());
            this.f2955o0 = this.f2954n0.getUser_id();
            this.tvUserName.setText(this.f2954n0.getUser());
            this.tv_phone.setVisibility(8);
            this.iv_red_circle.setVisibility(8);
            q();
            com.bumptech.glide.c.a((FragmentActivity) this).asBitmap().mo49load(com.amgcyo.cuttadon.utils.otherutils.g.b(this.f2954n0.getAvatar())).listener(new a(this)).apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.bitmapTransform(new com.bumptech.glide.load.resource.bitmap.k()).placeholder(R.drawable.icon_unlogin_men).error(R.drawable.icon_unlogin_men).fallback(R.drawable.icon_unlogin_men)).into(this.ivUserImg);
            zhugeIodEvent("[MY]进入个人信息修改页面");
        }
    }

    private void p() {
        com.amgcyo.cuttadon.f.o.a(a(), "提示", "退出登录将无法同步您的书架数据以及阅读记录.\n您是否确认要退出登录?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.user.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3004s.e(view);
            }
        }, (View.OnClickListener) null);
    }

    private void q() {
        this.llBindPhone.post(new Runnable() { // from class: com.amgcyo.cuttadon.activity.user.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f3007s.n();
            }
        });
    }

    private void r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("相\u3000机");
        arrayList.add("从相册选择");
        com.amgcyo.cuttadon.f.o.a(this, "提示", "您可以从“相机”或者“相册”中选择自己喜欢的照片进行上传哦(注意：上传的图片大小不能大于2MB)", new com.amgcyo.cuttadon.adapter.other.g(this, arrayList), new b.c() { // from class: com.amgcyo.cuttadon.activity.user.o
            @Override // com.amgcyo.cuttadon.widget.lovelydialog.b.c
            public final void a(int i2, Object obj) {
                this.a.a(i2, obj);
            }
        });
    }

    private void s() {
        this.f2960t0 = com.amgcyo.cuttadon.f.o.a(a(), R.string.text_input_error_message, (String) null, "请输入昵称", "一个有个性的昵称，别人一秒就能记住你呢~", new d.c() { // from class: com.amgcyo.cuttadon.activity.user.n
            @Override // com.amgcyo.cuttadon.widget.lovelydialog.d.c
            public final void a(String str) {
                this.a.e(str);
            }
        }, (View.OnClickListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.f2959s0 == 0) {
            camera();
        } else {
            gallery();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected BaseTitleBarActivity a() {
        return this;
    }

    public void camera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (i0.a()) {
            this.f2958r0 = com.amgcyo.cuttadon.utils.otherutils.s.a(this);
        } else {
            this.f2958r0 = Uri.fromFile(new File(z.k(), "avatar.jpg"));
        }
        intent.putExtra("output", this.f2958r0);
        startActivityForResult(intent, 831);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected String d() {
        return "个人中心";
    }

    public /* synthetic */ void e(String str) {
        ((UserPresenter) this.f2276v).N(Message.a(this, new Object[]{str, this.f2954n0}));
    }

    public void gallery() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 829);
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, me.jessyan.art.mvp.e
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        int i2 = message.f21197s;
        if (i2 == 823) {
            o();
            return;
        }
        if (i2 == 824 || i2 != 834) {
            return;
        }
        if (this.ivUserImg != null && this.f2954n0 != null) {
            String str = (String) message.f21202x;
            if (!TextUtils.isEmpty(str)) {
                this.f2954n0.setAvatar(str);
                this.G.a(this.f2277w, ImageConfigImpl.builder().url(com.amgcyo.cuttadon.utils.otherutils.g.b(str)).isCircle(true).imageView(this.ivUserImg).build());
                me.jessyan.art.d.f.a().a(new MkCommentEvent(), "login_out");
            }
        }
        File file = this.f2956p0;
        if (file != null) {
            String str2 = "mCropImageFile是否删除成功：" + file.delete();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1:");
        sb.append(this.f2957q0 == null);
        sb.append(" 2: ");
        sb.append(this.f2958r0 == null);
        sb.toString();
        if (this.f2957q0 != null) {
            String str3 = "cropUriDelete是否删除成功：" + (Build.VERSION.SDK_INT >= 30 ? getContentResolver().delete(this.f2957q0, null) : 0);
        }
        if (this.f2958r0 != null) {
            String str4 = "cameraUriDelete是否删除成功：" + (Build.VERSION.SDK_INT >= 30 ? getContentResolver().delete(this.f2958r0, null) : 0);
        }
    }

    @Override // me.jessyan.art.base.f.h
    public void initData(@Nullable Bundle bundle) {
        o();
    }

    @Override // me.jessyan.art.base.f.h
    public int initView(@Nullable Bundle bundle) {
        return R.layout.mk_ac_user_modify;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean l() {
        return false;
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity
    protected boolean m() {
        return true;
    }

    public /* synthetic */ void n() {
        if (this.llBindPhone != null) {
            com.amgcyo.cuttadon.view.showcaseview.f fVar = new com.amgcyo.cuttadon.view.showcaseview.f(a(), "change_phone");
            BaseTitleBarActivity baseTitleBarActivityA = a();
            LinearLayout linearLayout = this.llBindPhone;
            fVar.a(com.amgcyo.cuttadon.f.o.a(baseTitleBarActivityA, linearLayout, "点击这里可以更换手机号哦~", new com.amgcyo.cuttadon.view.showcaseview.i.d(linearLayout.getWidth(), this.llBindPhone.getHeight()), 30, 1, 30, new v(this)));
            fVar.b();
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 829:
                if (i3 == -1 && intent != null) {
                    Uri data = intent.getData();
                    if (data != null) {
                        a(data);
                    }
                } else {
                    showMessage("请选择照片！");
                }
                break;
            case 830:
                if (intent != null) {
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.f2957q0));
                        if (bitmapDecodeStream != null) {
                            this.f2956p0 = com.amgcyo.cuttadon.utils.otherutils.g.a(bitmapDecodeStream);
                            if (this.f2956p0 == null) {
                                showMessage("图片裁剪失败!");
                            } else if (z.a(this.f2956p0.getAbsolutePath(), 3) < 2.0d) {
                                ((UserPresenter) this.f2276v).P(Message.a(this, new Object[]{this.f2956p0, this.f2954n0}));
                            } else {
                                showMessage("所上传的图片大于2M了!");
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                break;
            case 831:
                Uri uri = this.f2958r0;
                if (uri == null) {
                    showMessage("请选择照片！");
                } else {
                    a(uri);
                }
                break;
        }
    }

    @OnClick({R.id.ll_avatar, R.id.ll_nick, R.id.ll_bind_phone, R.id.ll_username, R.id.ll_update_pwd, R.id.tv_login_out, R.id.ll_cancel_account})
    public void onClick(View view) {
        if (BaseTitleBarActivity.v()) {
            com.amgcyo.cuttadon.f.o.d(R.string.operating_busy);
        }
        switch (view.getId()) {
            case R.id.ll_avatar /* 2131297900 */:
                r();
                zhugeIodEvent("[MY]我的头像");
                break;
            case R.id.ll_bind_phone /* 2131297904 */:
                r0.startActivity(this.f2277w, ShowCurrentPhoneActivity.class);
                break;
            case R.id.ll_cancel_account /* 2131297916 */:
                r0.startActivity(this.f2277w, MkCancelAccountActivity.class);
                break;
            case R.id.ll_nick /* 2131297950 */:
                s();
                zhugeIodEvent("[MY]修改昵称");
                break;
            case R.id.ll_update_pwd /* 2131297994 */:
                r0.startActivity(a(), MkUpdatePwdActivity.class);
                zhugeIodEvent("[MY]修改密码");
                break;
            case R.id.ll_username /* 2131297995 */:
                showMessage("用户名暂时无法修改!");
                break;
            case R.id.tv_login_out /* 2131298740 */:
                p();
                zhugeIodEvent("[MY]退出登录");
                break;
        }
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        zhugeIodEvent("[MY]关闭个人信息修改页面");
    }

    @Override // com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Dialog dialog = this.f2960t0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f2960t0.dismiss();
        this.f2960t0 = null;
    }

    public /* synthetic */ void e(View view) {
        if (com.amgcyo.cuttadon.utils.otherutils.g.t(this.f2955o0) <= 0) {
            showMessage("出现异常!");
        } else {
            showMessage("成功退出账号");
            r0.a((Activity) this);
        }
    }

    @Override // me.jessyan.art.base.f.h
    @Nullable
    public UserPresenter obtainPresenter() {
        return new UserPresenter(me.jessyan.art.f.e.a(this));
    }

    private void a(final String... strArr) {
        if (com.hjq.permissions.f.a(this, strArr)) {
            t();
        } else {
            com.amgcyo.cuttadon.f.o.a(a(), "提示", "上传头像功能需要访问您的照相机和内存卡访问权限。是否开启?", new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.user.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f3002s.a(strArr, view);
                }
            }, (View.OnClickListener) null);
        }
    }

    public /* synthetic */ void a(String[] strArr, View view) {
        b(strArr);
    }

    public /* synthetic */ void a(int i2, Object obj) {
        this.f2959s0 = i2;
        if (Build.VERSION.SDK_INT >= 23) {
            a("android.permission.CAMERA", com.kuaishou.weapon.p0.g.f16729i, "android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            t();
        }
    }

    private void a(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", ITagManager.STATUS_TRUE);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        intent.putExtra("outputY", ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);
        if (i0.a()) {
            this.f2957q0 = com.amgcyo.cuttadon.utils.otherutils.s.a(this);
        } else {
            this.f2957q0 = Uri.parse("file:///" + z.k() + "/avatar.jpg");
        }
        intent.putExtra("output", this.f2957q0);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        startActivityForResult(intent, 830);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final List<String> list) {
        com.amgcyo.cuttadon.f.o.a(a(), getResources().getString(R.string.tip), getString(R.string.message_permission_always_failed, new Object[]{TextUtils.join("\n", getResources().getStringArray(R.array.permission_title_camer))}), new View.OnClickListener() { // from class: com.amgcyo.cuttadon.activity.user.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f3005s.a(list, view);
            }
        }, (View.OnClickListener) null);
    }

    public /* synthetic */ void a(List list, View view) {
        com.hjq.permissions.f.a((Activity) this, (List<String>) list);
    }
}
