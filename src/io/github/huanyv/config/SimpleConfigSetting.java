package io.github.huanyv.config;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.util.NlsContexts;
import io.github.huanyv.ui.TotalCmdSettingUI;
import io.github.huanyv.util.Constant;
import io.github.huanyv.util.SimpleConfigUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class SimpleConfigSetting implements SearchableConfigurable {

    private final TotalCmdSettingUI form = new TotalCmdSettingUI();

    @Override
    public @NotNull
    @NonNls
    String getId() {
        return "io.github.huanyv.config.SimpleConfigSetting";
    }

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Open In TotalCmd";
    }

    @Override
    public @Nullable
    JComponent createComponent() {
        return form.getPanel();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {
        JTextField simpleConfigInput = form.getTotalCmdPath();
        String inputValue = simpleConfigInput.getText();
        SimpleConfigUtil.save(Constant.TOTAL_CMD_PATH_SETTING, inputValue);

        Object selectedItem = form.getOpenPanel().getSelectedItem();
        SimpleConfigUtil.save(Constant.PANEL_LOCATION, selectedItem);
    }
}
