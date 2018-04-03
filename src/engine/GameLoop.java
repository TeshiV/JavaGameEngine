package engine;

import render.DisplayManager;
import render.Loader;
import render.RawModel;
import render.Renderer;

public class GameLoop {

    public static void main(String[] args) {

        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        float[] vertices = {
                //left bottom triangle
                -0.5f, 0.5f, 0f,
                -0.5f, -0.5f, 0f,
                0.5f, -0.5f, 0f,
                //right top triangle
                0.5f, -0.5f, 0f,
                0.5f, 0.5f, 0f,
                -0.5f, 0.5f, 0f,
        };

        RawModel model = loader.loadToVAO(vertices);

        while(!DisplayManager.isCloseRequested()){
            renderer.prepare();
            renderer.render(model);
            //game logic
            //render
            DisplayManager.updateDisplay();
        }

        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
