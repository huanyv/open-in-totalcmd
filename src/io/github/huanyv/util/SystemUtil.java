package io.github.huanyv.util;

import java.io.IOException;

/**
 * @author huanyv
 * @date 2025/7/26 16:46
 */
public class SystemUtil {

    public static void exec(String cmd) {
        if (cmd == null || cmd.length() == 0) {
            return;
        }
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
