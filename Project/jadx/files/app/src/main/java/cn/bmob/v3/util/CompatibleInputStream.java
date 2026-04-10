package cn.bmob.v3.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: loaded from: classes.dex */
public class CompatibleInputStream extends ObjectInputStream {
    public CompatibleInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    @Override // java.io.ObjectInputStream
    protected ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
        ObjectStreamClass classDescriptor = super.readClassDescriptor();
        try {
            ObjectStreamClass objectStreamClassLookup = ObjectStreamClass.lookup(Class.forName(classDescriptor.getName()));
            if (objectStreamClassLookup == null) {
                return classDescriptor;
            }
            long serialVersionUID = objectStreamClassLookup.getSerialVersionUID();
            long serialVersionUID2 = classDescriptor.getSerialVersionUID();
            if (serialVersionUID2 == serialVersionUID) {
                return classDescriptor;
            }
            StringBuffer stringBuffer = new StringBuffer("Overriding serialized class version mismatch: ");
            stringBuffer.append("local serialVersionUID = ");
            stringBuffer.append(serialVersionUID);
            stringBuffer.append(" stream serialVersionUID = ");
            stringBuffer.append(serialVersionUID2);
            return objectStreamClassLookup;
        } catch (ClassNotFoundException unused) {
            return classDescriptor;
        }
    }
}
