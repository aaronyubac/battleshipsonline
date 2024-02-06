function renderBoard(board, squares) {
    for (let i = 0; i < 100; i++) {
        const square = document.createElement('div');
        square.classList.add('square');
        square.dataset.id = i;
        board.appendChild(square);
        squares.push(square);
    }
}



function refreshGameBoard(data) {
// gameboards
    // loop through board[][] and refresh based on value (0-water, 1-ship, 2-shot-hit, 3-shot-miss)
    // really need shot hit or shot miss
    $('#gameIdFinal').replaceWith(data.gameId);
    $('#playerOne').replaceWith(data.players[0].name);

    try {
        if(data.players[1]!=null){ $('#playerTwo').replaceWith(data.players[1].name); }
    // turn (might have to change to .html)
        $('#turnDisplay').replaceWith(data.turn == 0 ? data.players[0].name : data.players[2].name);
    } catch (err) {
        console.log(err);
    }

// winner
// game state
    // if game state is done show winner
}

function takeShot() {

}