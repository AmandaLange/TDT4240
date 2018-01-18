//
//  GameScene.m
//  TechIntro
//
//  Created by Rakel Sjaastad Andreassen on 18.01.2018.
//  Copyright © 2018 Rakel Sjaastad Andreassen. All rights reserved.
//

#import "GameScene.h"

// 1
@interface GameScene ()
@property (nonatomic) SKSpriteNode * player;
@property (nonatomic) NSTimeInterval lastSpawnTimeInterval;
@property (nonatomic) NSTimeInterval lastUpdateTimeInterval;
@end


@implementation GameScene

-(id)initWithSize:(CGSize)size {
    if (self = [super initWithSize:size]) {
        
        // 2
        NSLog(@"Size: %@", NSStringFromCGSize(size));
        
        // 3
        self.backgroundColor = [SKColor colorWithRed:1.0 green:1.0 blue:1.0 alpha:1.0];
        self.physicsBody = [SKPhysicsBody bodyWithEdgeLoopFromRect:self.frame];
        self.physicsBody.categoryBitMask = wallCategory;
        
        // 4
        
        self.player = [SKSpriteNode spriteNodeWithImageNamed:@"attackhelicopter"];
        self.player.position = CGPointMake(300, 100);
        self.player.xScale = 0.5;
        self.player.yScale = 0.5;
        
        
        self.player.physicsBody = [SKPhysicsBody bodyWithRectangleOfSize:self.player.size];
        self.player.physicsBody.dynamic = YES;
        self.player.physicsBody.affectedByGravity = NO;
        
        self.player.physicsBody.categoryBitMask = playerCategory;
        self.player.physicsBody.collisionBitMask = wallCategory;
        
        self.player.physicsBody.restitution = 1.0;
        self.player.physicsBody.friction = 0.0;
        self.player.physicsBody.allowsRotation = YES;
        self.player.physicsBody.linearDamping = 0.0;
        self.player.physicsBody.angularDamping = 0.0;
        self.player.physicsBody.usesPreciseCollisionDetection = true;
        
        [self addChild:self.player];
        
        CGVector impulse = CGVectorMake(100.0,100.0);
        [self.player.physicsBody applyImpulse:impulse];
        
        

        
        
    }
    return self;
}
/*
- (void)addPlayer {
    
    self.player = [SKSpriteNode spriteNodeWithImageNamed:@"attackhelicopter"];
    self.player.position = CGPointMake(self.player.size.width/2, self.frame.size.height/2);
    [self addChild:self.player];*/
    

    
    // Determine where to spawn the monster along the Y axis
/*    int minY = self.player.size.height / 2;
    int maxY = self.player.frame.size.height - self.player.size.height / 2 + 1;
    int rangeY = maxY - minY;
    int actualY = (arc4random() % rangeY) + minY;

        // Determine speed of the monster
    int minDuration = 2.0;
    int maxDuration = 4.0;
    int rangeDuration = maxDuration - minDuration;
    int actualDuration = (arc4random() % rangeDuration) + minDuration;
    
    // Create the actions
    SKAction * actionMove = [SKAction moveTo:CGPointMake(-self.player.size.width/2, actualY) duration:actualDuration];
    SKAction * actionMoveDone = [SKAction removeFromParent];
    [self.player runAction:[SKAction sequence:@[actionMove, actionMoveDone]]];
    
}

- (void)updateWithTimeSinceLastUpdate:(CFTimeInterval)timeSinceLast {
    
    self.lastSpawnTimeInterval += timeSinceLast;
    if (self.lastSpawnTimeInterval > 1) {
        self.lastSpawnTimeInterval = 0;
        [self addPlayer];
    }
}


- (void)update:(NSTimeInterval)currentTime {
    // Handle time delta.
    // If we drop below 60fps, we still want everything to move the same distance.
    CFTimeInterval timeSinceLast = currentTime - self.lastUpdateTimeInterval;
    self.lastUpdateTimeInterval = currentTime;
    if (timeSinceLast > 1) { // more than a second since last update
        timeSinceLast = 1.0 / 60.0;
        self.lastUpdateTimeInterval = currentTime;
    }
    
    [self updateWithTimeSinceLastUpdate:timeSinceLast];
    
}

*/


@end
