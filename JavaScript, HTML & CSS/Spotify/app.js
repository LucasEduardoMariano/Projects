document.addEventListener('DOMContentLoaded', () => {
    const artistsData = [
        { name: 'Billie Eilish', image: './images/artist-billie.jpeg' },
        { name: 'Lady Gaga', image: './images/artist-lady.jpeg' },
        { name: 'Nicki Minaj', image: './images/artist-nicki.jpeg' },        
        { name: 'Bad Bunny', image: './images/artist-bad.jpeg' },
        { name: 'Tate Mcrae', image: './images/artist-tate.jpeg' }
    ];

    const albumsData = [
        { name: 'Brat', artist: 'Charli xcx', image: './images/album-brat.jpeg' },
        { name: 'Cupido', artist: 'Tini', image: './images/album-cupido.jpeg'},
        { name: 'The Secret of us', artist: 'Gracie Abrams', image: './images/album-true.jpeg' },
        { name: 'Guts', artist: 'Olivia Rodrigo', image: './images/album-olivia.jpeg' },
        { name: 'Sagrado Profano', artist: 'Luisa Sonza', image: './images/album-luisa.jpeg' },
    ];

    const artistGrid = document.querySelector('.artist-grid')
    const albumGrid = document.querySelector('.album-grid')

    artistsData.forEach(artist => {
        const artistCard = document.createElement('div')
        artistCard.classList.add('artist-card')

        artistCard.innerHTML = `        
            <img src="${artist.image}" alt= " imagem do ${artist.name}">
            <h3>${artist.name}</h3>
            <p>Artist<p>        
        `
        artistGrid.appendChild(artistCard)

    })

    albumsData.forEach(album => {
        const albumCard = document.createElement('div')
        albumCard.classList.add('album-card')

        albumCard.innerHTML = `        
            <img src="${album.image}" alt= " imagem do ${album.name}">
            <h3>${album.name}</h3>
            <p>${album.artist}<p>
     
        `
        albumGrid.appendChild(albumCard)

    })


})