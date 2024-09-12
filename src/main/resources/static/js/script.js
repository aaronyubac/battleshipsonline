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
    $('#gameIdDisplay').html(data.gameId);
    $('#playerOne').html(data.players[0].name);
    if(data.players[1]!=null){ $('#playerTwo').html(data.players[1].name);


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
        shooterIndex = (turn+1) % 2;
        shooter = data.players[shooterIndex];
        latestShotLocation = data.latestShot.location;
        shotIndex = (latestShotLocation.y * 10) + latestShotLocation.x;
    }


    switch (data.event)  {
        case "MISS":
            $("#eventContainer").html(shooter.name + " missed");
            if ((playerType === "FIRST_PLAYER" && shooterIndex == 0) || (playerType === "SECOND_PLAYER" && shooterIndex == 1)) {
                enemySquares[shotIndex].classList.add('miss');
            } else if ((playerType === "FIRST_PLAYER" && shooterIndex == 1) || (playerType === "SECOND_PLAYER" && shooterIndex == 0)) {
                playerSquares[shotIndex].classList.add('miss');
            }

            break;
        case "BATTLESHIP_DESTROYED":
            $("#eventContainer").html(shooter.name + " destroyed a battleship");
            if ((playerType === "FIRST_PLAYER" && shooterIndex == 0) || (playerType === "SECOND_PLAYER" && shooterIndex == 1)) {
                shipDestroyed(data, enemySquares);
            } else if ((playerType === "FIRST_PLAYER" && shooterIndex == 1) || (playerType === "SECOND_PLAYER" && shooterIndex == 0)) {
                shipDestroyed(data, playerSquares);
            }
            break;
        case "BATTLESHIP_HIT":
            $("#eventContainer").html(shooter.name + " hit a battleship");
            if ((playerType === "FIRST_PLAYER" && shooterIndex == 0) || (playerType === "SECOND_PLAYER" && shooterIndex == 1)) {
                enemySquares[shotIndex].classList.add('hit');
            } else if ((playerType === "FIRST_PLAYER" && shooterIndex == 1) || (playerType === "SECOND_PLAYER" && shooterIndex == 0)) {
                playerSquares[shotIndex].classList.add('hit');
            }
            break;
        case "GAME_OVER":
            $("#eventContainer").html(data.winner.name + " won the game");
            $('#takeShotBtn').css("visibility", "hidden");

            if ((playerType === "FIRST_PLAYER" && shooterIndex == 0) || (playerType === "SECOND_PLAYER" && shooterIndex == 1)) {
                shipDestroyed(data, enemySquares);
            } else if ((playerType === "FIRST_PLAYER" && shooterIndex == 1) || (playerType === "SECOND_PLAYER" && shooterIndex == 0)) {
                shipDestroyed(data, playerSquares);
            }


            // screen darked out
            break;
        default:
            $("#eventContainer").html("");
    }
}

}

function shipDestroyed(data, squares) {
    data.gameBoards[data.turn].battleships.forEach(ship => {
        if (ship.destroyed == true) {
            ship.body.forEach(index => {
                squares[(index.y*10) + index.x].classList.add('destroyed')
            });
        }
    });
}
