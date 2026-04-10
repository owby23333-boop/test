package cn.bmob.v3;

import cn.bmob.v3.listener.SaveListener;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes.dex */
public class BmobArticle extends BmobObject {
    private String content;
    private String cover;
    private String desc;
    private String m_id;
    private String title;
    private String type;
    private String url;

    public String getContent() {
        return this.content;
    }

    public String getCover() {
        return this.cover;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getM_id() {
        return this.m_id;
    }

    @Override // cn.bmob.v3.BmobObject
    public String getTableName() {
        return "_Article";
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // cn.bmob.v3.BmobObject
    @Deprecated
    public Disposable save(SaveListener saveListener) {
        throw new IllegalArgumentException(" _Article does not support save operation,please use console.");
    }

    public BmobArticle setContent(String str) {
        this.content = str;
        return this;
    }

    public BmobArticle setCover(String str) {
        this.cover = str;
        return this;
    }

    public BmobArticle setDesc(String str) {
        this.desc = str;
        return this;
    }

    public BmobArticle setM_id(String str) {
        this.m_id = str;
        return this;
    }

    public BmobArticle setTitle(String str) {
        this.title = str;
        return this;
    }

    public BmobArticle setType(String str) {
        this.type = str;
        return this;
    }

    public BmobArticle setUrl(String str) {
        this.url = str;
        return this;
    }
}
