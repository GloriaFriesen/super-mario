package com.megandwarnock.supermario.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.megandwarnock.supermario.Scenes.Hud;
import com.megandwarnock.supermario.SuperMario;


public class Brick extends InteractiveTileObject {
    public Brick(World world, TiledMap map, Rectangle bounds){
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(SuperMario.BRICK_BIT);
    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Brick", "Collision");
        setCategoryFilter(SuperMario.DESTROYED_BIT);
        getCell().setTile(null);
        Hud.addScore(200);
        SuperMario.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
    }
}