package engine;

import entities.Camera;
import entities.Entity;
import entities.Light;
import models.TexturedModel;
import org.lwjgl.util.vector.Vector3f;
import render.*;
import models.RawModel;
import shaders.StaticShader;
import terrains.Terrain;
import textures.ModelTexture;

public class GameLoop {

    public static void main(String[] args) {

        DisplayManager.createDisplay();
        Loader loader = new Loader();
        MasterRenderer renderer = new MasterRenderer();

        Terrain terrain = new Terrain(0, -1, loader, new ModelTexture(loader.loadTexture("FlatStoneWalkway_1024")));
        Terrain terrain2 = new Terrain(-1, -1, loader, new ModelTexture(loader.loadTexture("Grass_1024")));

        RawModel model = OBJLoader.loadObjModel("dragon", loader);
        ModelTexture texture = new ModelTexture(loader.loadTexture("white"));
        texture.setShineDamper(10);
        texture.setReflectivity(1);
        TexturedModel texturedModel = new TexturedModel(model, texture);

        Entity entity = new Entity(texturedModel, new Vector3f(50, 4, -25), 0,0,0, 1);
        Light light = new Light(new Vector3f(0, 500, -20), new Vector3f(1, 1, 1));
        Camera camera = new Camera();

        while(!DisplayManager.isCloseRequested()){
            entity.increaseRotation(0, 0, 1);
            camera.move();
            renderer.processEntity(entity);
            renderer.processTerrain(terrain);
            renderer.processTerrain(terrain2);
            renderer.render(light, camera);
            DisplayManager.updateDisplay();
        }

        renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
