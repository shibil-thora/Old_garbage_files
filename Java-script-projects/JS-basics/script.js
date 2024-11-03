"use strict";
 
const display = document.getElementById("display") ;

display.addEventListener("mousedown" , () => {display.innerHTML = "mousedown"})
display.addEventListener("mouseup" , () => {display.innerHTML = "mouseup"})

window.addEventListener("resize", () => {display.innerHTML = ""})
