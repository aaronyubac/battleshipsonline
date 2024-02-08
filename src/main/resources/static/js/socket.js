const url = 'http://localhost:8080';
let stompClient;
let gameId;
let playerType;

function connectToSocket(gameId) {

    console.log("connecting to the game");
    let socket = new SockJS(url + "/battleships/lobby");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
    console.log("connected to the frame: " + frame);
    stompClient.subscribe("/topic/game-progress/" + gameId, function (response) {
        let data = JSON.parse(response.body);
        refreshGameBoard(data);
        })
    })
}

document.getElementById("createNewGameBtn").addEventListener("click", createGame);

function createGame() {
    let name = document.getElementById("name").value;
    if (name == null || name === '') {
        alert("Please enter name");
    } else {

        $.ajax({
            url: url + "/battleships/create",
            type: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                    "name": name
            }),
            success: function (data) {
                gameId = data.gameId;
                playerType = 'FIRST_PLAYER';
                connectToSocket(gameId);
                alert("You created a game. Game id is: " + data.gameId);
                console.log(data);
                refreshGameBoard(data);
            },
            error: function (error) {
                console.log(error);
            }
        })
    }
}

document.getElementById("joinGameBtn").addEventListener("click", connectToGame);

function connectToGame() {
    let name = document.getElementById("name").value;
    if (name == null || name === '') {
        alert("Please enter name");
    } else {
        let gameIdInput = document.getElementById("gameId").value;
        if (gameIdInput == null || gameIdInput === '') {
            alert("Please enter game id");
        }

      $.ajax({
        url: url + "/battleships/connect",
        type: 'POST',
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            "player": {
                "name": name,
            },
            "gameId": gameIdInput
        }),
        success: function(data) {
            gameId = data.gameId;
            playerType = 'SECOND_PLAYER';
            connectToSocket(gameId);
            alert("You are now playing with: " + data.players[0].name);
            refreshGameBoard(data);
        },
      error: function (error) {
        console.log(error);
        }
      })
    }
}








