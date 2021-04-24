package scenes;

import javafx.scene.Parent;

public interface Scene {
    public void bindManager(Manager sceneManager);
    public Parent getRoot();
}
