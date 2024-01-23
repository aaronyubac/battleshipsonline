(function() {

    var buffer, context, drawMap, map, size;

    buffer = document.createElement("canvas").getContext("2d");
    context = document.getElementById("enemyBoard").getContext("2d");

    map = [
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0,0],
    ];

    size = 32;

    buffer.canvas.width = 10 * size;
    buffer.canvas.height = 10 * size;

    drawMap = function() {

        for (let i = 0; i < map.length; i++) {
            for (let j = 0; j < map[i].length; j++) {
                console.log(i + ", " + j);
                buffer.fillStyle = (map[j][i] == 1) ? "#000000" : "#0096C7";
                buffer.fillRect(j * size, i * size, size, size);
            }
        }

        context.drawImage(buffer.canvas, 0, 0, buffer.canvas.width, buffer.canvas.height,
                                        0, 0, context.canvas.width, context.canvas.height);

    };

    resize = function(event) {

    context.canvas.width = Math.floor(document.documentElement.clientWidth - 32);

    if (context.canvas.width > document.documentElement.clientHeight) {

      context.canvas.width = Math.floor(document.documentElement.clientHeight);

    }

    context.canvas.height = Math.floor(context.canvas.width * 0.5625);

    drawMap();

  };

  window.addEventListener("resize", resize, {passive:true});

  resize();

})();