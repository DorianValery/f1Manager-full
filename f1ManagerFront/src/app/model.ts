import { CourseService } from "./course/course.service";

export class Compte {

    id: number;
    version: number;
    login: string;
    password: string;
    type: string;
    joueur: Joueur;

    constructor(id?: number, version?: number, login?: string, type?: string) {
        this.id = id;
        this.version = version;
        this.login = login;
        this.type = type;
    }

}
export class Joueur {
    id: number;
    version: number;
    pseudo: string;
    age: number;
    mail: string;
    telephone: string;
    civilite: string;
    ecurie: Ecurie;

    constructor(id?: number, version?: number, pseudo?: string, age?: number, mail?: string, telephone?: string, civilite?: string, ecurie?: Ecurie) {
        this.id = id;
        this.version = version;
        this.pseudo = pseudo;
        this.age = age;
        this.mail = mail;
        this.telephone = telephone;
        this.civilite = civilite;
        this.ecurie = ecurie;
    }
}

export class Ecurie {
    id: number;
    version: number;
    nom: string;
    argent: number;
    experience: number;
    courseEnCours: number;
    pilotes: Pilote[];
    infrastructures: Infrastructure[];
    voitures: Voiture[];
    positionFinale : Position[];


    constructor(id?: number, version?: number, nom?: string, argent?: number, experience?: number, courseEnCours?: number, pilotes?: Pilote[], infrastructures?: Infrastructure[], voitures?: Voiture[], positionFinale?: Position[]) {
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.argent = argent;
        this.experience = experience;
        this.courseEnCours = courseEnCours;
        this.pilotes = pilotes;
        this.infrastructures = infrastructures;
        this.voitures = voitures;
        this.positionFinale= positionFinale;
     }
}
export class Pilote {
    id: number;
    version: number;
    nom: string;
    prenom: string;
    age: number;
    nationalite: string;
    civ: string;
    experience: number;
    etat: boolean;
    prix: number;
    imagePilote: string;
    position: Position[];

    constructor(id?: number, version?: number, nom?: string, prenom?: string, age?: number, nationalite?: string, civ?: string, experience?: number, etat?: boolean, prix?: number, imagePilote?: string, position?: Position[]) {
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.nationalite = nationalite;
        this.civ = civ;
        this.experience = experience;
        this.etat = etat;
        this.prix = prix;
        this.imagePilote = imagePilote;
        this.position = position;
    }
}
export class Voiture {

    id: number;
    version: number;
    marque: string;
    maniabilite: number;
    vitesse: number;
    poids: number;
    etat: boolean;
    prix: number;
    image: string;

    constructor(id?: number, version?: number, marque?: string, maniabilite?: number, vitesse?: number, poids?: number, etat?: boolean, prix?: number, image?: string) {
        this.id = id;
        this.version = version;
        this.marque = marque;
        this.maniabilite = maniabilite;
        this.vitesse = vitesse;
        this.poids = poids;
        this.etat = etat;
        this.prix = prix;
        this.image = image;
    }
}

export class Array<Voiture> extends Voiture {

    voiture: Voiture;

    constructor(voiture: Voiture) {
        super()
    }
}

export class Infrastructure {
    id: number;
    version: number;
    nom: string;
    type: string;
    nbIngenieurs: number;
    pitStop: number;
    experience: number;
    etat: boolean;
    prix: number;

    constructor(id?: number, version?: number, nom?: string, type?: string, nbIngenieurs?: number, pitStop?: number, experience?: number, etat?: boolean, prix?: number) {
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.type = type;
        this.nbIngenieurs = nbIngenieurs;
        this.pitStop = pitStop;
        this.experience = experience;
        this.etat = etat;
        this.prix = prix;
    }
}

export class Course {
    id: number;
    version: number;
    nom: string;
    nombreTour: number;
    tempsRef: string;
    cashPrize: number;
    popularite: number;
    image: String;
    position: Position[];

    constructor(id?: number, version?: number, nom?: string, nombreTour?: number, tempsRef?: string, cashPrize?: number, popularite?: number, image?: string, position?: Position[]) {
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.nombreTour = nombreTour;
        this.tempsRef = tempsRef;
        this.cashPrize = cashPrize;
        this.popularite = popularite;
        this.image = image;
        this.position = position;
    }
}

export class Position {

    id: number;
    version: number;
    course : Course;
    position : number;
    ecurie : Ecurie;

    

    constructor(id?: number, version?: number,course ?: Course, position? : number,ecurie? : Ecurie ) {
        this.id = id;
        this.version = version;
        this.ecurie=ecurie;
        this.course=course;
        this.position=position;
        
    }
}
export class Inventaire {

    id: number;
    version: number;
    joueur: Joueur;
    pilote: Pilote;
    voiture: Voiture;
    infrastructure: Infrastructure;
    

    constructor(id?: number, version?: number, joueur?: Joueur,pilote?: Pilote, voiture?: Voiture, infrastructure?: Infrastructure ) {
        this.id = id;
        this.version = version;
        this.joueur = joueur;
        this.pilote = pilote;
        this.voiture = voiture;
        this.infrastructure = infrastructure;
    }
}



export class SeConnecterForm {
    login: string;
    password: string;

    constructor(login?: string, password?: string) {
        this.login = login;
        this.password = password;
    }
}


export class Tour {

    position: number;

    constructor() {

    }
}

export class Order {
    voiture: Voiture;
    pilote: Pilote;
    infra: Infrastructure;
    score: number;

    constructor(voiture?: Voiture, pilote?: Pilote, infra?: Infrastructure, score?: number) {
        this.voiture = voiture;
        this.pilote = pilote;
        this.infra = infra;
        this.score = score;

    }
}
export class InscriptionDTO {
    login: string;
    password: string;
    mail: string;
    age: number;
    civilite: string;
    id: number;

    constructor(login?: string, password?: string, mail?: string, age?: number, civilite?: string, id?: number) {
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.age = age;
        this.id = id;
        this.civilite = civilite;
    }


}

// export class Order extends Ecurie {

//     score: number;

//     constructor(id?: number, version?: number, nom?: string, argent?: number, experience?: number, courseEncours?: number,score?: number) {
//         super(id, version, nom, argent, experience, courseEncours);

//         this.score = score;

//     }
// }