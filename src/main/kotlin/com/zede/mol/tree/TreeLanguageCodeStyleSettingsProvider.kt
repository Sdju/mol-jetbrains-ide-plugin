package com.zede.mol.tree

import com.intellij.psi.codeStyle.*


class TreeLanguageCodeStyleSettingsProvider : LanguageCodeStyleSettingsProvider() {
    override fun customizeSettings(
        consumer: CodeStyleSettingsCustomizable,
        settingsType: SettingsType
    ) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS")
            consumer.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Separator")
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
            consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE")
        }
    }

    override fun getLanguage(): TreeLanguage {
        return TreeLanguage.INSTANCE
    }

    override fun getCodeSample(settingsType: SettingsType): String {
        return """
@ xml:lang \ru
head
	title \Рога & Копыта
body
	h1 \Привет!
	p  \Хочешь, я расскажу тебе сказку?
"""
    }
}
