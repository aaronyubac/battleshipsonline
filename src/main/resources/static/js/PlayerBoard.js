width = 10;
playerSquares = new Array();

const shipsArray = [
    {
        name: 'destroyer',
        directions: {
            horizontal: [0, 1],
            vertical: [0, width]
            }
        },
    {
        name: 'submarine',
        directions: {
            horizontal: [0, 1, 2],
            vertical: [0, width, width*2]
            }
        },
    {
        name: 'cruiser',
        directions: {
            horizontal: [0, 1, 2],
            vertical: [0, width, width*2]
            }
        },
    {
        name: 'battleship',
        directions: {
            horizontal: [0, 1, 2, 3],
            vertical: [0, width, width*2, width*3]
            }
        },
    {
        name: 'carrier',
        directions: {
            horizontal: [0, 1, 2, 3, 4],
            vertical: [0, width, width*2, width*3, width*4]
            }
        }
]

document.addEventListener("DOMContentLoaded", () => {
    const ships = document.querySelectorAll('.ship');
    const shipsContainer = document.querySelector(".ships-container");
    playerBoard = document.getElementById('playerBoard');
    renderBoard(playerBoard, playerSquares);

shipsContainer.addEventListener('click', e => {
    if(e.target.parentElement.matches('div.ship')) {rotate(e.target.parentElement);}});

    shipsContainer.addEventListener('mousedown', e => grabShip(e, target));

    ships.forEach(ship => ship.addEventListener('dragstart', e => {dragStart(e, target)}));
        playerBoard.addEventListener('dragover', dragOver);
        playerBoard.addEventListener('dragenter', dragEnter);
        playerBoard.addEventListener('dragleave', dragLeave);
        playerBoard.addEventListener('drop', e => {placeShip(e, target, shipsContainer)});
    document.getElementById("confirmBattleshipsBtn").addEventListener("click", confirmShips);
    document.getElementById("resetBtn").addEventListener("click", e => reset(e, shipsContainer));
});

const target = {
    shipNameWithId:'',
    ship:'',
    shipLength: 0
    };

function rotate(ship){
    ship.classList.toggle(`${ship.classList[1]}-vertical`)
}

function grabShip(e, target) {
    target['shipNameWithId'] = e.target.id;
}

function dragStart(e, target){
    target['ship'] = e.target;
    target['shipLength'] = e.target.childElementCount;
}

function placeShip(e, target, container) {

    let isVertical = [...target.ship.classList].some(className => className.includes('vertical'));

    let shipLength = target.shipLength;
    let draggedShipWithLastId = target.ship.lastElementChild.id;
    let draggedShipClass = draggedShipWithLastId.slice(0, -2);
    let draggedShipLastIndex = parseInt(draggedShipWithLastId.slice(-1));
    let draggedShipIndex = parseInt(target.shipNameWithId.slice(-1));
    let receivingSquare = parseInt(e.target.dataset.id);
    let droppedShipFirstId = (!isVertical) ?
                receivingSquare - draggedShipIndex :
                receivingSquare - (draggedShipIndex * 10);
    let droppedShipLastId = (!isVertical) ?
                receivingSquare + draggedShipLastIndex - draggedShipIndex :
                receivingSquare + ((draggedShipLastIndex - draggedShipIndex) * 10);



    if (!isVertical) {
        let current = shipsArray.find(ship => ship.name === draggedShipClass).directions.horizontal;
        try {
            let isTaken = current.some(index => playerSquares[droppedShipFirstId + index].classList.contains('taken'));

        if (Math.floor(droppedShipLastId/10) === Math.floor(receivingSquare/10) && !isTaken) {
            for(let i = 0; i < shipLength; i++){
                playerSquares[receivingSquare - draggedShipIndex + i].classList.add(
                    'taken', draggedShipClass, 'ship');
                }
                container.removeChild(target.ship);
            } else if (((receivingSquare % 10)  + shipLength> 9) || ((receivingSquare % 10) - shipLength) < 0) {
                alert("Can't place ship here");
            } else {
                alert("Is taken");
            }
        } catch {
            console.log("Out of bounds placement");
        }


    } else {
        let current = shipsArray.find(ship => ship.name === draggedShipClass).directions.vertical;
        try {
        let isTaken = current.some(index => playerSquares[droppedShipFirstId + index].classList.contains('taken'));


        if(receivingSquare + (shipLength - 1) * 10 < 100 && !isTaken){
            for(let i = 0; i < shipLength; i++){
                playerSquares[receivingSquare + (10 * (i-draggedShipIndex))].classList.add(
                    'taken', draggedShipClass, 'ship');
                }
                container.removeChild(target.ship);
            } else {
                alert("Is taken");
                }
           } catch {
                alert("Can't place ship here");
                console.log("Out of bounds placement");

            }
        }

    $("." + draggedShipClass).first().data("head", droppedShipFirstId);
    $("." + draggedShipClass).first().data("tail", droppedShipLastId);
    $("." + draggedShipClass).first().data("isVertical", isVertical);

    if(!container.querySelector('.ship')) {
        $('#confirmBattleshipsBtn').css("visibility", "visible");
    }
    }
function dragOver(e){
    e.preventDefault();
}
function dragEnter(e){
    e.preventDefault();
}
function dragLeave(){

}

function confirmShips() {

    if (gameId == null || gameId === '') {
        alert("Please enter game id");
    } else {

    let heads = new Array();
    let tails = new Array();
    let isVerticals = new Array();

    shipsArray.forEach(ship => {
        let current = $("." + ship.name);
        let headIndex = $(current).first().data("head");
        let tailIndex = $(current).first().data("tail");
        let isVertical = $(current).first().data("isVertical");

        console.log("headIndex: " + headIndex);
        console.log("tailIndex: " + tailIndex);

        let headX = headIndex % 10; // 1
        let headY = Math.floor(headIndex / 10); //0
        let tailX = tailIndex % 10; // 1
        let tailY = Math.floor(tailIndex / 10); // 1
        let head = {"x": headX,"y": headY};
        let tail = {"x": tailX,"y": tailY};

        console.log("head: " + head);
        console.log("tail: " + tail);

        heads.push(head);
        tails.push(tail);
        isVerticals.push(isVertical);

    });

        $.ajax({
            url: url + "/battleships/place",
            type: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify({
                    "heads": heads,
                    "tails": tails,
                    "isVerticals": isVerticals,
                    "playerType": playerType,
                    "gameId": gameId
            }),
            success: function(data) {
                console.log(data);
                $('#confirmBattleshipsBtn').css("visibility", "hidden");
                $('#resetBtn').css("visibility", "hidden");
                refreshGameBoard(data);
            },
            error: function(error) {
                console.log(error);
            }
        });

}
}


function reset (e,shipsContainer) {

    playerSquares.forEach(square => {
        if(square.classList.contains('taken')){
            square.className = 'square';
        }
    })

        shipsContainer.innerHTML = `
       <div class="ship destroyer-container" draggable="true">
          <div id="destroyer-0"></div>
          <div id="destroyer-1"></div>
        </div>

        <div class="ship submarine-container" draggable="true">
          <div id="submarine-0"></div>
          <div id="submarine-1"></div>
          <div id="submarine-2"></div>
        </div>

        <div class="ship cruiser-container" draggable="true">
          <div id="cruiser-0"></div>
          <div id="cruiser-1"></div>
          <div id="cruiser-2"></div>
        </div>

        <div class="ship battleship-container" draggable="true">
          <div id="battleship-0"></div>
          <div id="battleship-1"></div>
          <div id="battleship-2"></div>
          <div id="battleship-3"></div>
        </div>

        <div class="ship carrier-container" draggable="true">
          <div id="carrier-0"></div>
          <div id="carrier-1"></div>
          <div id="carrier-2"></div>
          <div id="carrier-3"></div>
          <div id="carrier-4"></div>
        </div>`;

        ships = document.querySelectorAll('.ship')
        ships.forEach(ship => ship.addEventListener('dragstart', e => {dragStart(e, target)}));


}




