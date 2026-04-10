package cn.bmob.v3;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BmobACL implements Serializable {
    private static final String READ = "read";
    private static final String WRITE = "write";
    private static final long serialVersionUID = 3706778250022037535L;
    private Map<String, Object> acl = new HashMap();

    private void setAccess(String str, String str2, boolean z2) {
        if (this.acl.containsKey(str2)) {
            Map map = (Map) this.acl.get(str2);
            map.put(str, Boolean.valueOf(z2));
            this.acl.put(str2, map);
        } else {
            HashMap map2 = new HashMap();
            map2.put(str, Boolean.valueOf(z2));
            this.acl.put(str2, map2);
        }
    }

    public Map<String, Object> getAcl() {
        return this.acl;
    }

    public void setAcl(Map<String, Object> map) {
        this.acl = map;
    }

    public void setPublicReadAccess(boolean z2) {
        if (z2) {
            setReadAccess("*", z2);
        }
    }

    public void setPublicWriteAccess(boolean z2) {
        if (z2) {
            setWriteAccess("*", z2);
        }
    }

    public void setReadAccess(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("cannot setReadAccess for null userId");
        }
        if (z2) {
            setAccess(READ, str, z2);
        }
    }

    public void setRoleReadAccess(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("cannot setReadAccess for null roleName");
        }
        if (z2) {
            setAccess(READ, "role:" + str, z2);
        }
    }

    public void setRoleWriteAccess(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("cannot setReadAccess for null roleName");
        }
        if (z2) {
            setAccess(WRITE, "role:" + str, z2);
        }
    }

    public void setWriteAccess(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("cannot setReadAccess for null userId");
        }
        if (z2) {
            setAccess(WRITE, str, z2);
        }
    }

    public void setReadAccess(BmobUser bmobUser, boolean z2) {
        if (bmobUser != null) {
            if (TextUtils.isEmpty(bmobUser.getObjectId())) {
                throw new IllegalArgumentException("cannot setReadAccess for null userId");
            }
            if (z2) {
                setAccess(READ, bmobUser.getObjectId(), z2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("cannot setReadAccess for null user");
    }

    public void setRoleReadAccess(BmobRole bmobRole, boolean z2) {
        if (bmobRole != null) {
            if (TextUtils.isEmpty(bmobRole.getName())) {
                throw new IllegalArgumentException("cannot setReadAccess for null roleName");
            }
            if (z2) {
                setAccess(READ, "role:" + bmobRole.getName(), z2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("cannot setReadAccess for null role");
    }

    public void setRoleWriteAccess(BmobRole bmobRole, boolean z2) {
        if (bmobRole != null) {
            if (TextUtils.isEmpty(bmobRole.getName())) {
                throw new IllegalArgumentException("cannot setReadAccess for null roleName");
            }
            if (z2) {
                setAccess(WRITE, "role:" + bmobRole.getName(), z2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("cannot setReadAccess for null role");
    }

    public void setWriteAccess(BmobUser bmobUser, boolean z2) {
        if (bmobUser != null) {
            if (TextUtils.isEmpty(bmobUser.getObjectId())) {
                throw new IllegalArgumentException("cannot setReadAccess for null userId");
            }
            if (z2) {
                setAccess(WRITE, bmobUser.getObjectId(), z2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("cannot setReadAccess for null user");
    }
}
