package com.baiguiren.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

/**
 * 在打开 IDE 之后会运行下面的 runActivity 方法，可以看作是一个 hook 之类的东西
 */
public class MyStartupActivity implements StartupActivity {
    @Override
    public void runActivity(@NotNull Project project) {
        Notification notification = new Notification("my first plugin", "StartupActivity", "Hello from MyStartupActivity!", NotificationType.INFORMATION);
        notification.notify(project);
    }
}
