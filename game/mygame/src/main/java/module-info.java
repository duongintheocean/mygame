module com.mygame {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.lwjgl;
    requires org.lwjgl.glfw;
    requires org.lwjgl.opengl;


    opens com.mygame to javafx.fxml;
    exports com.mygame;
}