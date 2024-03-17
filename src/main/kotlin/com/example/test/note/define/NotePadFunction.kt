package com.example.test.note.define

import com.example.test.function.rootPackage
import com.example.test.note.ui.Notepad
import javax.swing.JFileChooser

fun Notepad.open() {
    val defaultDirectory = rootPackage(project)

    JFileChooser().apply {
        currentDirectory = defaultDirectory

        val dialog = showOpenDialog(contentPane)
        if (dialog == JFileChooser.APPROVE_OPTION) {
            textArea.text = selectedFile.readText()
        }
    }

    isVisible = true
}

fun Notepad.saveTextToFile() {
    val defaultDirectory = rootPackage(project)

    JFileChooser().apply {
        currentDirectory = defaultDirectory
        isVisible = true
        selectedFile.writeText(textArea.text)
    }

    dispose()
}