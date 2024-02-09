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
    $('#gameIdDisplay').html(data.gameId);
    $('#playerOne').html(data.players[0].name);
    if(data.players[1]!=null){ $('#playerTwo').html(data.players[1].name); }


    if (data.players[0].ready && data.players[1].ready) {
        turn = data.turn;
        name = data.players[turn].name;

        $('#turnDisplay').html(name);
        $('#turnDisplayContainer').css("visibility", "visible");

        if (turn == 0 && playerType === "FIRST_PLAYER") {
            $('#takeShotBtn').css("visibility", "visible");
        } else if (turn == 1 && playerType === "SECOND_PLAYER"){
            $('#takeShotBtn').css("visibility", "visible");
        }
    }

    shooter = data.players[(turn+1)%2].name;

    switch (data.event)  {
        case "MISS":
            $("#eventContainer").html(shooter + " missed");
            break;
        case "BATTLESHIP_DESTROYED":
            $("#eventContainer").html(shooter + " destroyed a battleship");
            break;
        case "BATTLESHIP_HIT":
            $("#eventContainer").html(shooter + " hit a battleship");
            break;
        case "GAME_OVER":
            $("#eventContainer").html(winner + " won the game");
            break;
        default:
            $("#eventContainer").html("");
    }

}
