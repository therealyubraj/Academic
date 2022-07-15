class Point {
    static windowSize = 300;
    static spawnWindow = 20;
    constructor() {
        this.initSpawn();
        this.alreadyReset = true;
    }

    initSpawn() {
        this.x = getRandom(0, width);
        this.y = getRandom(0, height);
        this.giveDirection();
    }

    reset() {
        do {
            this.x = getRandom(-Point.spawnWindow, width + Point.spawnWindow);
        } while (this.x > 0 && this.x < width);
        do {
            this.y = getRandom(-Point.spawnWindow, height + Point.spawnWindow);
        }
        while (this.y > 0 && this.y < height);
        this.giveDirection();
    }

    giveDirection() {
        let destX = getRandom(width / 2 - Point.windowSize, width / 2 + Point.windowSize);
        let destY = getRandom(height / 2 - Point.windowSize, height / 2 + Point.windowSize);

        let diffX = destX - this.x;
        let diffY = destY - this.y;

        let mag = dist(this.x, this.y, destX, destY);

        this.xSpeed = diffX / mag;
        this.ySpeed = diffY / mag;
    }

    update() {
        this.x += this.xSpeed;
        this.y += this.ySpeed;

        if (this.alreadyReset && this.x >= 0 && this.x < width && this.y >= 0 && this.y < height) {
            this.alreadyReset = false;
        }
        if (this.x >= width || this.x < 0 || this.y >= height || this.y < 0) {
            if (!this.alreadyReset) {
                this.reset();
            }
        }
    }

    drawPoint() {
        fill(255, 255, 255, 40);
        circle(this.x, this.y, 1, 1);
    }
}