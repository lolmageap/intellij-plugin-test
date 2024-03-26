package com.cherhy.plugin.note.ui

import com.cherhy.plugin.function.rootPackage
import com.cherhy.plugin.note.constant.NoteConstant.CLOSE
import com.cherhy.plugin.note.define.saveTextToFile
import com.intellij.openapi.project.Project
import java.awt.BorderLayout.CENTER
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import java.io.File
import java.util.UUID
import javax.swing.*
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

class Notepad(
    val textArea: JTextArea,
    val project: Project,
): JFrame() {

    val currentFileName = UUID.randomUUID().toString() + ".txt"

    init {
        title = "Notepad"
        defaultCloseOperation = DISPOSE_ON_CLOSE
        size = Dimension(800, 600)
        setLocationRelativeTo(null)

        isVisible = false

        val scrollPane = JScrollPane(textArea)
        add(scrollPane, CENTER)

        textArea.document.addDocumentListener(object : DocumentListener {
            override fun insertUpdate(e: DocumentEvent?) {
                saveTextToFile()
            }

            override fun removeUpdate(e: DocumentEvent?) {
                saveTextToFile()
            }

            override fun changedUpdate(e: DocumentEvent?) {
                saveTextToFile()
            }
        })

        closeEvent()
    }

    private fun closeEvent() {
        val escKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false)
        val escAction = object : AbstractAction() {
            override fun actionPerformed(e: ActionEvent?) {
                if (confirmAndSaveFile()) {
                    dispose()
                }
            }
        }

        rootPane.inputMap.put(escKeyStroke, CLOSE)
        rootPane.actionMap.put(CLOSE, escAction)
    }

    private fun confirmAndSaveFile(): Boolean {
        val defaultDirectory = rootPackage(project)
        val fileChooser = JFileChooser(defaultDirectory)
        fileChooser.dialogTitle = "Save"
        fileChooser.fileSelectionMode = JFileChooser.FILES_ONLY

        val userSelection = fileChooser.showSaveDialog(this)

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            val newFileName = JOptionPane.showInputDialog(
                this,
                "Enter new file name:",
                "File Name",
                JOptionPane.PLAIN_MESSAGE
            )

            if (newFileName.isNullOrEmpty()) {
                return false
            }

            val newFilePath = File(defaultDirectory, "$newFileName.txt")

            newFilePath.writeText(textArea.text)
            return true
        }
        return false
    }

    // TODO: 항상 자동 저장이 되게 수정
    // TODO: 다른 화면을 누르면 닫히는 현상 수정
}