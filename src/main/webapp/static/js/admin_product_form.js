console.log("Abc")
var imgaAdd= document.querySelector('#img_add');
imgaAdd.addEventListener('click',function(){
    var divrow=document.querySelector("#ram")
    var new_row=document.createElement("div")
    new_row.className='input-box'
    input = document.createElement('input')
    input.setAttribute('placeholder','Ram')
    input.setAttribute('name','rams')
    new_row.appendChild(input)
    divrow.appendChild(new_row);

    var divrow1=document.querySelector("#price")
    var new_row1=document.createElement("div")
    new_row1.className='input-box'
    input1 = document.createElement('input')
    input1.setAttribute('placeholder','Price')
    input1.setAttribute('name','prices')
    new_row1.appendChild(input1)
    divrow1.appendChild(new_row1);
});