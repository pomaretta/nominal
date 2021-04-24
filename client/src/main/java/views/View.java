package views;

import javafx.scene.Parent;

public interface View {
    public void bindManager(Manager viewManager);
    public Parent getRoot();
}
