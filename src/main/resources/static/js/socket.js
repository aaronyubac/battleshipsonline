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
        console.log(data);
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
                $('#gameId').replaceWith(data.gameId);
            },
            error: function (error) {
                console.log(error);
            }
        })
    }
}








