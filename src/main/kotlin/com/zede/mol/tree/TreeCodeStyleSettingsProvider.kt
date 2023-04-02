package com.zede.mol.tree

import com.intellij.application.options.CodeStyleAbstractConfigurable
import com.intellij.application.options.CodeStyleAbstractPanel
import com.intellij.application.options.TabbedLanguageCodeStylePanel
import com.intellij.psi.codeStyle.*


class TreeCodeStyleSettingsProvider : CodeStyleSettingsProvider () {
    override fun createCustomSettings(settings: CodeStyleSettings): CustomCodeStyleSettings {
        return TreeCodeStyleSettings(settings)
    }

    override fun getConfigurableDisplayName(): String {
        return "Tree (\$mol)"
    }

    override fun createConfigurable(
        settings: CodeStyleSettings,
        modelSettings: CodeStyleSettings
    ): CodeStyleConfigurable {
        return object : CodeStyleAbstractConfigurable(settings, modelSettings, this.configurableDisplayName) {
            override fun createPanel(settings: CodeStyleSettings): CodeStyleAbstractPanel {
                return SimpleCodeStyleMainPanel(currentSettings, settings)
            }
        }
    }


    private class SimpleCodeStyleMainPanel(currentSettings: CodeStyleSettings?, settings: CodeStyleSettings?) :
        TabbedLanguageCodeStylePanel(TreeLanguage.INSTANCE, currentSettings, settings!!)

}
