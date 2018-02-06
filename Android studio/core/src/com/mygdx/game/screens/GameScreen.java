package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.managers.GameScreenManager;
import com.mygdx.game.utils.B2DBodyBuilder;
import com.mygdx.game.utils.B2DJointBuilder;

import static com.mygdx.game.utils.B2DConstants.PPM;

/**
 * Created by lykkebergsli on 06/02/2018.
 */

public class GameScreen extends AbstractScreen{

    OrthographicCamera camera;

    // Box2D
    World world;
    Box2DDebugRenderer b2dr;

    // Game Bodies
    Body ball;
    Body paddleLeft, goalLeft;
    Body paddleRight, goalRight;

    public GameScreen(final MyGdxGame app){
        super(app);

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, MyGdxGame.V_WIDTH, MyGdxGame.V_HEIGHT);
        this.b2dr = new Box2DDebugRenderer();
    }

    @Override
    public void show() {
        world = new World(new Vector2(0,0), false);

        initArena();

        app.batch.setProjectionMatrix(camera.combined);
        app.shapeBatch.setProjectionMatrix(camera.combined);
    }

    public void update(float delta) {
        world.step(1f / MyGdxGame.APP_FPS, 6,2);

        // Get Mouse Position - Move Paddle
        // TODO: Revise
        float mousePosToWorld = -(Gdx.input.getY() - camera.viewportHeight) / PPM;
        float mouseLerp = paddleLeft.getPosition().y + (mousePosToWorld - paddleLeft.getPosition().y) * .2f;
        if (mouseLerp * PPM > camera.viewportHeight - 20f) {
            mouseLerp = (camera.viewportHeight - 20f) / PPM;
        } else if (mouseLerp * PPM < 20f){
            mouseLerp = 20f /PPM;
        }
        paddleLeft.setTransform(paddleLeft.getPosition().x, mouseLerp, paddleLeft.getAngle());

        // Move ball
        ball.applyLinearImpulse(new Vector2(-.2f,.1f), ball.getWorldCenter(), true);
        Vector2 vel = ball.getLinearVelocity();
        float velX = vel.x;
        float velY = vel.y;
        float ballLerpY = ball.getPosition().y;
        float ballLerpX = ball.getPosition().x;
        if(ballLerpX * PPM > paddleLeft.getPosition().x + 5f) {
            ball.applyLinearImpulse(new Vector2(- velX, velY), ball.getWorldCenter(), true);
        }
        if (ballLerpX * PPM < paddleRight.getPosition().x - 5f) {
            ball.applyLinearImpulse(new Vector2(- velX, velY), ball.getWorldCenter(), true);
        }

        if(ballLerpY * PPM > camera.viewportHeight - 10f) {
            ball.applyLinearImpulse(new Vector2(velX, - velY), ball.getWorldCenter(), true);
        }
        if (ballLerpY * PPM < 10f) {
            ball.applyLinearImpulse(new Vector2(velX, - velY), ball.getWorldCenter(), true);
        }



        stage.act(delta);
        camera.update();
        app.batch.setProjectionMatrix(camera.combined);
        app.shapeBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void render(float delta){
        super.render(delta);

        b2dr.render(world, camera.combined.cpy().scl(PPM));
        stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose(){
        super.dispose();
        world.dispose();
    }

    private void initArena(){
        createWalls();
        ball = B2DBodyBuilder.createBall(world, camera.viewportWidth / 2,camera.viewportHeight / 2, 6f);

        //Setup paddles
        paddleLeft = B2DBodyBuilder.createBox(world, 40, camera.viewportHeight / 2, 10,40, false, false);
        paddleRight = B2DBodyBuilder.createBox(world, camera.viewportWidth - 40, camera.viewportHeight / 2, 10,40, false, false);

        //Setup Goal Sensors
        goalLeft = B2DBodyBuilder.createBox(world, 5, camera.viewportHeight / 2, 10, camera.viewportHeight, true, true);
        goalRight = B2DBodyBuilder.createBox(world, camera.viewportWidth - 5, camera.viewportHeight / 2, 10, camera.viewportHeight, true, true);

        //Create Goal To Paddle Joints
        B2DJointBuilder.createPrismaticJoint(world, goalLeft, paddleLeft, camera.viewportHeight / 2, - camera.viewportHeight / 2, new Vector2(35 / PPM, 0), new Vector2(0,0));

        B2DJointBuilder.createPrismaticJoint(world, goalRight, paddleRight, camera.viewportHeight / 2, - camera.viewportHeight / 2, new Vector2(- 35 / PPM, 0), new Vector2(0,0));
    }

    private void createWalls(){
        Vector2[] verts = new Vector2[5];
        verts[0] = new Vector2(1f / PPM, 0);
        verts[1] = new Vector2(camera.viewportWidth / PPM, 0);
        verts[2] = new Vector2(camera.viewportWidth / PPM, (camera.viewportHeight - 1f)/ PPM);
        verts[3] = new Vector2(0 / PPM, (camera.viewportHeight - 1f) / PPM);
        verts[4] = new Vector2(1f / PPM, 0);
        B2DBodyBuilder.createChainShape(world, verts);
    }
}
