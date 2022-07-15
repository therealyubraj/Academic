let canvas, ctx;
let width, height;
let fps = 24;
/**
 * @type Point[]
 */
let points = [];
let numOfPoints = 150;

window.onscroll = resizeCanvas;
window.onload = function() {
    canvas = document.getElementById("background-anim");
    canvas.width = window.innerWidth + 20;
    canvas.height = window.innerHeight;
    width = canvas.width;
    height = canvas.height;

    ctx = canvas.getContext("2d");

    Point.windowSize = width / 2;

    clearCanvas();

    for (let i = 0; i < numOfPoints; i++) {
        points.push(new Point());
    }

    setInterval(draw, 1000 / fps);
}


function clearCanvas() {
    fill(24, 24, 24, 255);
    ctx.fillRect(0, 0, width, height);
}

function draw() {
    clearCanvas();
    points.forEach(p => {
        p.update();
        p.drawPoint();
    });

    for (let i = 0; i < points.length; i++) {
        let p1 = points[i];
        if (p1.x > 0 && p1.x <= width && p1.y > 0 && p1.y <= height) {
            for (let j = i + 1; j < points.length; j++) {
                let p2 = points[j];
                if (p2.x > 0 && p2.x <= width && p2.y > 0 && p2.y <= height) {
                    let d = dist(p1.x, p1.y, p2.x, p2.y);
                    if (d <= (width / 10)) {
                        let opacity = Math.floor(mapValue(d, 0, 100, 100, 0));
                        stroke(255, 255, 255, opacity);
                        line(p1.x, p1.y, p2.x, p2.y);
                    }
                }
            }
        }
    }
}

function getRandom(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

function dist(x1, y1, x2, y2) {
    return Math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2);
}


function circle(x, y, r) {
    ctx.beginPath();
    ctx.ellipse(x, y, r, r, 0, 0, Math.PI * 2);
    ctx.fill();
}

function mapValue(val, valMin, valMax, newMin, newMax) {
    let oldPercentage = (val - valMin) / (valMax - valMin);
    return oldPercentage * (newMax - newMin) + newMin;
}

function line(x1, y1, x2, y2) {
    ctx.beginPath();
    ctx.moveTo(x1, y1);
    ctx.lineTo(x2, y2);
    ctx.stroke();
}

function fill(r, g, b, a) {
    ctx.fillStyle = rgbaToHex(r, g, b, a);
}

function stroke(r, g, b, a) {
    ctx.strokeStyle = rgbaToHex(r, g, b, a);
}

function rgbaToHex(r, g, b, a = 255) {
    r = r.toString(16).padStart(2, '0');
    g = g.toString(16).padStart(2, '0');
    b = b.toString(16).padStart(2, '0');
    a = a.toString(16).padStart(2, '0');
    return "#" + r + g + b + a;
}

function resizeCanvas() {
    if (canvas)
        canvas.style.top = window.scrollY + "px";
}