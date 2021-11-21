function sendScore() {
	const score = document.getElementById('score');
	const point = document.getElementById('point');
	point.innerHTML= `<input type="text" name="point" '+'${score}`;
}