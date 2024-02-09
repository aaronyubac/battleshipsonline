var enemySquares = new Array();

document.addEventListener("DOMContentLoaded", () => {
    enemyBoard = document.getElementById('enemyBoard');
    renderBoard(enemyBoard, enemySquares);

    enemyBoard.addEventListener('click', e => select(e));
    document.getElementById("takeShotBtn").addEventListener("click", () => {
        takeShot();
        $('#takeShotBtn').css("visibility", "hidden");
    });
});

var selectedSquare;
function select(e) {
    index = e.target.dataset.id;

    selectedSquare = {
        x: index % 10,
        y: Math.floor(index / 10)
    };

    $('#selected').html('(' + selectedSquare.x + ',' + selectedSquare.y + ')');
}

function takeShot() {
    $.ajax({
        url: url + "/battleships/shoot",
        type: 'POST',
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            "shot": {"location":{"x": selectedSquare.x, "y": selectedSquare.y}, "isHit": false},
            "gameId": gameId
        }),
        success: function (data) {
            refreshGameBoard(data);

        },
        error: function(error) {
            console.log(error);
        }
    });
}

// have selected square remain bright
// if shot already taken there can't shoot there again
// gray for miss
// red for hit