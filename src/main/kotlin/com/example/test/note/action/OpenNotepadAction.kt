package com.example.test.note.action

import com.example.test.note.define.open
import com.example.test.note.ui.Notepad
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