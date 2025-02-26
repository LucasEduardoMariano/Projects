function changecolor(cor){
    document.body.style.backgroundImage = 'none'
    document.body.style.backgroundColor = cor
}

function randomColor(){
    document.body.style.backgroundImage = 'none'
    const red = Math.floor(Math.random() * 255)
    const green = Math.floor(Math.random() * 255)
    const blue = Math.floor(Math.random() * 255)

    document.body.style.backgroundColor = `rgb(${red}, ${green}, ${blue})`

}

function PersonalColor(){

    const corIpunt = document.querySelector('.color-input').value
    
    changecolor(corIpunt)
}

function chooseImagem(imagem){
    const reader = new FileReader()

    reader.onload = function(evento){
        const urlImagem = evento.target.result
        document.body.style.backgroundImage = `url(${urlImagem}`

    }

    reader.readAsDataURL(imagem)
}