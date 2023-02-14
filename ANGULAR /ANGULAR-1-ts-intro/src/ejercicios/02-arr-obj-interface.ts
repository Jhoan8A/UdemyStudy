let habilidadesPersonaje: string []= ['fuerte', 'rapido', 'divertido'];

interface Personaje {
    nombre: string,
    id: number,
    habilidades:string [],
    puebloNatal?:string
}

const personaje1: Personaje ={
    nombre: 'PEPE',
    id: 1,
    habilidades: ['Velocidad', 'musculatura', 'inteligente']
} 

console.log("PERSONAJE 1, con pueblo:", personaje1);

console.log("PERSONAJE 1: ", personaje1);