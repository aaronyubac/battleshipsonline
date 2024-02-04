function refreshGameBoard(data) {
// gameboards
    // loop through board[][] and refresh based on value (0-water, 1-ship, 2-shot-hit, 3-shot-miss)
    // really need shot hit or shot miss
// game id
    $('#gameIdFinal').replaceWith(data.gameId);
// player 1
    $('#playerOne').replaceWith(data.player1.name);
// player 2
    $('#playerTwo').replaceWith(data.player2.name);
// turn
    $('#turnDisplay').replaceWith(data.turn == 0 ? data.player1.name : data.player2.name);
// winner
// game state
    // if game state is done show winner
}

function takeShot() {

}