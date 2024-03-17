package com.cherhy.plugin.note.action

import com.cherhy.plugin.note.define.open
import com.cherhy.plugin.note.ui.Notepad
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import javax.swing.JTextArea

class OpenNotepadAction: AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val textArea = JTextArea()
        val notepad = Notepad(textArea, e.project!!)
        notepad.open()
    }
}