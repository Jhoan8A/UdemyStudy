interface SuperHeroe {
    name: string,
    edad: number,
    direction: Direction,
    mostrarDirection: ()=> string

}

interface Direction{
    calle: string,
    pais: string,
    ciudad: string
}
const superHeroe: SuperHeroe = {
    name: 'spiderman',
    edad: 30,
    direction: {
        calle: 'Main ST',
        pais: 'USA',
        ciudad: 'NY'
    },
    mostrarDirection (){
        return this.name + ', '+ this.direction.ciudad + ', '+ this.direction.pais;
    }
}

const dirSuperHeroe = superHeroe.mostrarDirection();

console.log(dirSuperHeroe);





