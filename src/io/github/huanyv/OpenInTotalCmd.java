package io.github.huanyv;

import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import io.github.huanyv.util.Constant;
import io.github.huanyv.util.SimpleConfigUtil;
import io.github.huanyv.util.SystemUtil;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.StringJoiner;

/**
 * @author huanyv
 * @date 2025/7/26 16:45
 */
public class OpenInTotalCmd extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        VirtualFile virtualFile = event.getData(PlatformDataKeys.VIRTUAL_FILE);
        assert virtualFile != null;
        String filePath = virtualFile.getPath();
        File file = new File(filePath);
        filePath = file.getAbsolutePath();
        if (file.isDirectory()) {
            filePath = file.getParentFile().getAbsolutePath();
        }

        String totalCmdPath = SimpleConfigUtil.getString(Constant.TOTAL_CMD_PATH_SETTING);
        if (totalCmdPath == null || totalCmdPath.trim().length() == 0) {
            Messages.showMessageDialog(event.getProject(), "请正确设置Total Commander的可执行文件地址", "OpenInTotalCmd", Messages.getInformationIcon());
            return;
        }

        StringJoiner cmd = new StringJoiner(" ");
        cmd.add(totalCmdPath);
        cmd.add("/O");
        cmd.add("/T");

        String panelLocation = SimpleConfigUtil.getString(Constant.PANEL_LOCATION);
        System.out.println("panelLocation = " + panelLocation);
        if (Constant.PANEL_LOCATION_LEFT.equals(panelLocation)) {
            cmd.add("/L=\"" + filePath + "\"");
        } else {
            cmd.add("/R=\"" + filePath + "\"");
        }
        SystemUtil.exec(cmd.toString());
    }

}
