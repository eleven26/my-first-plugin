package com.baiguiren.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

public class MyBackgroundPostStartupActivity implements StartupActivity {
    @Override
    public void runActivity(@NotNull Project project) {
        Notification notification = new Notification("my first plugin", "MyBackgroundPostStartupActivity", "Hello from MyBackgroundPostStartupActivity!", NotificationType.INFORMATION);
        notification.notify(project);
    }
}
