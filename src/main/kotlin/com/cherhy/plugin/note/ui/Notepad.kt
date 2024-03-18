package com.cherhy.plugin.note.ui

import com.cherhy.plugin.note.constant.NoteConstant.CLOSE
import com.cherhy.plugin.note.constant.NoteConstant.SAVE
import com.intellij.openapi.project.Project
import java.awt.BorderLayout.*
import javax.swing.*
import com.cherhy.plugin.note.define.saveTextToFile
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent

class Notepad(
    val textArea: JTextArea,
    val project: Project,
): JFrame() {
    init {
        title = "Notepad"
        defaultCloseOperation = DISPOSE_ON_CLOSE
        size = Dimension(800, 600)
        setLocationRelativeTo(null)

        isVisible = false

        val scrollPane = JScrollPane(textArea)
        add(scrollPane, CENTER)

        val saveButton = JButton(SAVE)
        add(saveButton, SOUTH)
        saveButton.addActionListener { saveTextToFile() }

        saveEvent()
        closeEvent()
    }

    private fun saveEvent() {
        val saveKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().menuShortcutKeyMask, false)
        val saveAction = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                saveTextToFile()
            }
        }

        rootPane.inputMap.put(saveKeyStroke, SAVE)
        rootPane.actionMap.put(SAVE, saveAction)
    }

    private fun closeEvent() {
        val escKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false)
        val escAction = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                dispose()
            }
        }

        rootPane.inputMap.put(escKeyStroke, CLOSE)
        rootPane.actionMap.put(CLOSE, escAction)
    }

    // TODO: ctrl + s to save
    // TODO: 다른 화면을 누르면 닫히는 현상 수정
}