package cn.bmob.v3;

import cn.bmob.v3.datatype.BmobRelation;

/* JADX INFO: loaded from: classes.dex */
public class BmobRole extends BmobObject {
    private static final long serialVersionUID = -4139218579795079311L;
    public static String tableName = "_Role";
    protected String name;
    private BmobRelation roles = new BmobRelation();
    private BmobRelation users = new BmobRelation();

    public BmobRole(String str) {
        setName(str);
    }

    public String getName() {
        return this.name;
    }

    public BmobRelation getRoles() {
        return this.roles;
    }

    @Override // cn.bmob.v3.BmobObject
    public String getTableName() {
        return "_Role";
    }

    public BmobRelation getUsers() {
        return this.users;
    }

    public void setName(String str) {
        this.name = str;
    }
}
