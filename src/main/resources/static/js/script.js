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
    if(data.players[1]!=null){ $('#playerTwo').replaceWith(data.players[1].name); }


    $('#turnDisplay').html(data.turn == 0 ? data.players[0].name : data.players[1].name);
    if (data.turn == 0 && playerType === "FIRST_PLAYER") {
        $('#takeShotBtn').css("visibility", "visible");
    } else if (data.turn == 1 && playerType === "SECOND_PLAYER"){
        $('#takeShotBtn').css("visibility", "visible");
    }

// winner
// game state
    // if game state is done show winner
}

function takeShot() {

}