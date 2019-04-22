package eoms.cn.commons.tools;

import java.util.UUID;

public class UUIDUtil {

    private UUIDUtil() {}

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }
}
