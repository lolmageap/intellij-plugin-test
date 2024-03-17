package com.cherhy.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class Menu: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val menu = Messages.showInputDialog("What is your name?", "Input your name", Messages.getQuestionIcon())
        Messages.showMessageDialog(menu, "input", null)
    }
}
