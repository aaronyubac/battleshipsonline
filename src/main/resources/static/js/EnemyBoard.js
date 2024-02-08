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



// take shot
    // send selectedSquare via ajax
function takeShot() {
    $.ajax({
        url: url + "/battleships/shoot",
        type: 'POST',
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            "shot": {"x": selectedSquare.x, "y": selectedSquare.y},
            "gameId": gameId
        }),
        success: function (data) {
            alert("You took a shot");
            refreshGameBoard(data);
        },
        error: function(error) {
            console.log(error);
        }
    });
}

// gray for miss
// red for hit
// if is destroyed -> announce