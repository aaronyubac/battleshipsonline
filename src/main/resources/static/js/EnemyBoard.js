var enemySquares = new Array();

document.addEventListener("DOMContentLoaded", () => {
    enemyBoard = document.getElementById('enemyBoard');
    renderBoard(enemyBoard, enemySquares);

    enemyBoard.addEventListener('click', e => select(e));
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

// gray for miss
// red for hit
// if is destroyed -> announce