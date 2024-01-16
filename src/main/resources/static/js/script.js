
document.getElementById("placeBattleshipsBtn").addEventListener("click", placeBattleships);

function placeBattleships() {

alert("Battleships placed");

let x = document.getElementById("x").value;
let y = document.getElementById("y").value;
let direction = document.getElementById("dir").value;

    $.ajax({
        url: url + "/battleships/place",
        type: 'POST',
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
                    "head": {"x": x,"y": y},
                    "direction": direction,
                    "length": 2,
                    "playerType": playerType,
                    "gameId": gameId
        }),
        success: function(data) {
            alert(data.gameId)
        },
        error: function(error) {
            console.log(error);
    }
  })
}