let container = document.querySelector("#container");
let dino = document.querySelector("#dino");
let block = document.querySelector("#block");
let road = document.querySelector("#road");
let cloud = document.querySelector("#cloud");
let score = document.querySelector("#score");
let gameOver = document.querySelector("#gameOver");


let interval = null;
let playerScore = 0;

// 게임 시작 함수
var gameStart = function(){
    gameOver.style.display = "none";
    block.classList.add("blockActive");
    road.firstElementChild.style.animation = "roadAnimate 1.5s linear infinite";
    cloud.firstElementChild.style.animation = "cloudAnimate 50s linear infinite";

    // score
    playerScore = 0;
    interval = setInterval(scoreCounter, 60);
}

// 점프 함수
var jump = function(){
    dino.classList.add("dinoActive");
            
    setTimeout(()=>{
        dino.classList.remove("dinoActive");
    }, 500);
}

// score 구현
let scoreCounter = ()=>{
    playerScore++;
    score.innerHTML = `Score <b>${playerScore}</b>`;
}

// 게임 시작
window.addEventListener("keydown", (start)=>{
    console.log(start);
    if(start.code == "Space"){
        gameStart();
    }
})

// 점프
window.addEventListener("keydown", (e)=>{
    console.log(e);

    if(e.key=="ArrowUp"){
        if(dino.classList != "dinoActive"){
            jump();
        }
    }
})

// 충돌 → 게임오버
let result = setInterval(()=>{
    let dinoBottom = parseInt(getComputedStyle(dino).getPropertyValue("bottom"));
    console.log("DinoBottom" + dinoBottom);

    let blockLeft = parseInt(getComputedStyle(block).getPropertyValue("left"));
    console.log("BlockLeft" + blockLeft);

    if(dinoBottom <= 90 && blockLeft >= 20 && blockLeft <= 145){
        console.log("Game Over");

        gameOver.style.display = "block";
        block.classList.remove("blockActive");
        road.firstElementChild.style.animation = "none";
        cloud.firstElementChild.style.animation = "none";

        clearInterval(interval);
    }
}, 10);