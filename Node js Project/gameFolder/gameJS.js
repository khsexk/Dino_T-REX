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