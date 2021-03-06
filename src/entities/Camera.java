package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

    public static final float SPEED = 0.2f;
    private Vector3f position = new Vector3f(0, 4, 5);
    private float pitch;
    private float yaw;
    private float roll;

    public Camera(){

    }

    public void move(){
        if(Keyboard.isKeyDown(Keyboard.KEY_W)){
            position.z -=SPEED;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_S)){
            position.z +=SPEED;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_D)){
            position.x +=SPEED;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_A)){
            position.x -=SPEED;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            position.y +=SPEED;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_F)){
            position.y -=SPEED;
        }
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
}
