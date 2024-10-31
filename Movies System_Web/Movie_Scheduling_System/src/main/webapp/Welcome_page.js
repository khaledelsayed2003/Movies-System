let text = document.querySelector('.text');
let spans = text.innerText.split('').map((letter, i) => {
    let randomHue = Math.floor(Math.random() * 360); // Generate a random hue value between 0 and 360
    return `<span style="transition-delay:${i * 40}ms; filter:hue-rotate(${randomHue}deg)">${letter}</span>`;
}).join('');
text.innerHTML = spans;
console.log(spans);
