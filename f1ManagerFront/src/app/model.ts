export class Compte {

    id : number;
    version : number;
	login : string;
    password : string;
    type : string;

    constructor(id? : number,version ? : number,login? : string , type ?: string){

    }
	
}
export class Joueur {
    id :number;
    version : number;
	pseudo : string;
	age : number;
	mail : string;
	telephone : string;
    civilite : string;

    constructor(id? : number,version ? : number,pseudo ?: string,  age ?: number, mail ?: string ,telephone? : string ,civilite? : string){

    }
}

export class Ecurie{
    id : number;
    version : number;
	nom : string;
	argent : number;
	experience : number;

    constructor(id? : number,version ? :number,nom ?: string, argent? : number, experience ?: number )
   {} 
}
export class Pilote {
    id : number;
    version : number;
	nom : string;
	prenom : string;
	age : number;
	nationalite : string;
    civitlite : string;
	experience : number;
	etat : boolean;
	prix : number;

    constructor(id? : number,version ? :number,nom ?: string, prenom? : string, age? : number, nationalite? : string, civitlite ? : string ,experience ? : number, etat ? : boolean, prix ? : number){

    }
}
 export class Voiture {

    id : number;
    version : number;
	marque : string;
	maniabilite: number;
	vitesse : number;
	poids : number;
	etat : boolean;
	prix : number;

    constructor(id? : number,version ? :number,marque ?: string , maniabilite ?: number,vitesse ? : number, poids ?: number, etat ? : boolean, prix ? : number){
    }
 }

 export class Infrastructure{
    id : number;
    version : number;
	nom :string;
	type : string;
	nbIngenieurs : number;
	pitStop : number;
	experience : number;
	etat : boolean;
	prix : number;

    constructor(id? : number,version ? :number,nom ?: string , type ?: string,nbIngenieurs ? : number, pitStop ?: number, experience ? : number, etat ?: boolean, prix ? : number){
    }
 }

 export class Course {
    id : number;
    version : number;
	nom : string;
	nombreTour : number;
    tempsRef : string;
	cashPrize : number;
    popularite : number;

    constructor(id? : number,version ? :number,nom ?: string , nombreTour ? : number, tempsRef ? : string, cashPrize ?: number,popularite ?: number){
    }
 }

 export class Position {

    id : number;
    version : number;
    position : number;

    constructor(id? : number,version ? :number,position ?: number ){

    }
 }
 export class Inventaire {

    id : number;
    version : number;
    argentDisponible : number;

    constructor(id? : number,version ? :number,argentDisponible ?: number ){

    }
 }