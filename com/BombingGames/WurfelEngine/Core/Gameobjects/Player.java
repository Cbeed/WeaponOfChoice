package com.BombingGames.WurfelEngine.Core.Gameobjects;

import com.BombingGames.WurfelEngine.Core.Map.Point;
import com.BombingGames.WurfelEngine.WEMain;
import com.badlogic.gdx.Gdx;


/**
 *The Player is a character who can walk.
 * @author Benedikt
 */
public class Player extends AbstractCharacter{   
    /**
     * Creates a player. The parameters are for the lower half of the player. The constructor automatically creates a block on top of it.
     * @param id 
     * @param point 
     * @see com.BombingGames.Game.Gameobjects.Block#getInstance(int) 
     */
    public Player(int id, Point point) {
        super(id, 1, point);
        Gdx.app.debug("Player", "Creating player");
        setFallingSound(
            (com.badlogic.gdx.backends.openal.Ogg.Sound)
            WEMain.getInstance().manager.get("com/BombingGames/WurfelEngine/Game/Sounds/wind.ogg")
        );
        setRunningSound(
            (com.badlogic.gdx.backends.openal.Ogg.Sound)
            WEMain.getInstance().manager.get("com/BombingGames/WurfelEngine/Game/Sounds/victorcenusa_running.ogg")
        );
        setJumpingSound((com.badlogic.gdx.backends.openal.Wav.Sound)
            WEMain.getInstance().manager.get("com/BombingGames/WurfelEngine/Game/Sounds/jump_man.wav")
        );
        setLandingSound((com.badlogic.gdx.backends.openal.Wav.Sound)
            WEMain.getInstance().manager.get("com/BombingGames/WurfelEngine/Game/Sounds/landing.wav")
        );
        
        setTransparent(true);
        setObstacle(true);
        setDimensionZ(2);
    }   

    /**
     * Jumps the player
     */
    @Override
    public void jump() {
        super.jump(5);
    }
    
    @Override
    public float[] getAiming(){
        float deltaX =Gdx.input.getX()-Gdx.graphics.getWidth()/2;
        float deltaY =Gdx.input.getY()-Gdx.graphics.getHeight()/2; 
       float length = (float) Math.sqrt( Math.pow(deltaX,2)+ Math.pow(deltaY,2));
        return new float[]{
            deltaX/length,
            deltaY*2/length
        };
    }
}