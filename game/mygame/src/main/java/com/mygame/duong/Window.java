package com.mygame.duong;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private int width,height;
    private String title;
    private static Window window=null;
    private long glfwWindow;
    private Window(){
        this.width=1920;
        this.height=1080;
        this.title="DvsD";
    }
    public static Window get(){
        if(Window.window==null){
            Window.window=new Window();
        }
        return Window.window;
    }
    public void run(){
        System.out.println("Hello LWJGL "+ Version.getVersion()+ "!");
        init();
        loop();
    }
    public void init(){
        //set up error callback
        GLFWErrorCallback.createPrint(System.err).set();
        // Initialize GLFW
        if (!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");

        }
        // config glfw
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE,GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE,GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED,GLFW_TRUE);
        // create window
        this.glfwWindow=glfwCreateWindow(this.height,this.width,this.title,NULL,NULL);
        if (this.glfwWindow==NULL){
            throw new IllegalStateException("Failed to create the window");

        }
        // make opengl context current
        glfwMakeContextCurrent(glfwWindow);
        // enable v-sync
        glfwSwapInterval(1);
        // make window visible
        glfwShowWindow(glfwWindow);
        GL.createCapabilities();
    }
    public void loop(){
        while(!glfwWindowShouldClose(this.glfwWindow)){
            //poll events
            glfwPollEvents();
            GL11.glClearColor(1.0f,0.0f,0.0f,1.0f);
            glClear(GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(glfwWindow);
        }
    }
}

