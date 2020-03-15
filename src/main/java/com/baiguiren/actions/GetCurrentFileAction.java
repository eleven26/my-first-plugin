package com.baiguiren.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class GetCurrentFileAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // virtualFile 是当前指向的文件的抽象
        VirtualFile virtualFile = e.getData(CommonDataKeys.VIRTUAL_FILE);
        if (virtualFile == null) {
            notify("Can not get virtual file.", e);
            return;
        }

        // 1. 获取所指向的文件名、文件路径
        notify("file name: " + virtualFile.getName(), e);
        notify("file path: " + virtualFile.getPath(), e);

        // 2. 获取光标所在行的内容
        // Caret 是编辑器汇中的光标
        Caret caret = e.getData(CommonDataKeys.CARET);
        if (caret != null) {
            // 获取当前 Editor 对象
            Editor editor = e.getData(CommonDataKeys.EDITOR);
            if (editor == null) return;
            // 也是当前操作的文件，不过这是是文件内容的抽象
            Document document = editor.getDocument();

            // 获取当前行开始位置和结束位置
            // CaretModel 是操作光标的对象
            CaretModel caretModel = caret.getCaretModel();
            int caretOffset = caretModel.getOffset();
            // 光标所在行的行号
            int lineNum = document.getLineNumber(caretOffset);
            // 光标所在行起始位置
            int lineStartOffset = document.getLineStartOffset(lineNum);
            // 光标所在行结束位置
            int lineEndOffset = document.getLineEndOffset(lineNum);

            // 获取光标所在行的内容
            String lineContent = document.getText(new TextRange(lineStartOffset, lineEndOffset));
            notify("line content: " + lineContent, e);
        }
    }

    private static void notify(String msg, AnActionEvent e) {
        Notification notification = new Notification(
                "my first plugin",
                "Message",
                msg,
                NotificationType.INFORMATION
        );
        notification.notify(e.getProject());
    }
}
