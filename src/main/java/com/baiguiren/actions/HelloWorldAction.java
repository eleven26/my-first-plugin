package com.baiguiren.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class HelloWorldAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Notification notification = new Notification("my first plugin", "Message", "Hello World!", NotificationType.INFORMATION);
        notification.notify(e.getProject());
    }
}
