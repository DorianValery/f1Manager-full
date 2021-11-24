package sopra.formation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.formation.config.ApplicationConfig;
import sopra.formation.model.Civilite;
import sopra.formation.model.Compte;
import sopra.formation.model.Course;
import sopra.formation.model.Ecurie;
import sopra.formation.model.Infrastructure;
import sopra.formation.model.Inventaire;
import sopra.formation.model.Joueur;
import sopra.formation.model.Pilote;
import sopra.formation.model.Voiture;
import sopra.formation.model.typeInfra;
import sopra.formation.model.Type;
import sopra.formation.repository.ICompteRepository;
import sopra.formation.repository.ICourseRepository;
import sopra.formation.repository.IEcurieRepository;
import sopra.formation.repository.IInfrastructureRepository;
import sopra.formation.repository.IInventaireRepository;
import sopra.formation.repository.IJoueurRepository;
import sopra.formation.repository.IPiloteRepository;
import sopra.formation.repository.IPositionRepository;
import sopra.formation.repository.IVoitureRepository;

public class TestJpa {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		ICompteRepository compteRepo = spring.getBean(ICompteRepository.class);
		ICourseRepository courseRepo = spring.getBean(ICourseRepository.class);
		IEcurieRepository ecurieRepo = spring.getBean(IEcurieRepository.class);
		IInfrastructureRepository infrastructureRepo = spring.getBean(IInfrastructureRepository.class);
		IInventaireRepository inventaireRepo = spring.getBean(IInventaireRepository.class);
		IJoueurRepository joueurRepo = spring.getBean(IJoueurRepository.class);
		IPiloteRepository piloteRepo = spring.getBean(IPiloteRepository.class);
		IPositionRepository positionRepo = spring.getBean(IPositionRepository.class);
		IVoitureRepository voitureRepo = spring.getBean(IVoitureRepository.class);
		
		//Compte Admin
		Compte compteAdmin = new Compte();
		compteAdmin.setLogin("Admin");
		compteAdmin.setPassword("Admin");
		compteAdmin.setType(Type.ADMIN);
	
		compteAdmin = compteRepo.save(compteAdmin);
		
		//Comptes des joueurs
		Compte compteJoueur1= new Compte();
		compteJoueur1.setLogin("Joueur1");
		compteJoueur1.setPassword("Joueur1");
		compteJoueur1.setType(Type.JOUEUR);
		
		compteJoueur1 = compteRepo.save(compteJoueur1);
		
		Compte compteJoueur2= new Compte();
		compteJoueur2.setLogin("Joueur2");
		compteJoueur2.setPassword("Joueur2");
		compteJoueur2.setType(Type.JOUEUR);
		
		compteJoueur2 = compteRepo.save(compteJoueur2);
		
		Compte compteJoueur3= new Compte();
		compteJoueur3.setLogin("Joueur3");
		compteJoueur3.setPassword("Joueur3");
		compteJoueur3.setType(Type.JOUEUR);
		
		compteJoueur3 = compteRepo.save(compteJoueur3);
		
		Compte compteJoueur4= new Compte();
		compteJoueur4.setLogin("Joueur4");
		compteJoueur4.setPassword("Joueur4");
		compteJoueur4.setType(Type.JOUEUR);
		
		compteAdmin = compteRepo.save(compteAdmin);
		
		
		
		//Pilotes 1 et 2 etat non possédés
		
		Pilote pilote1false =new Pilote();
		pilote1false.setNom("BOTTAS");
		pilote1false.setPrenom("Slow");
		pilote1false.setAge(21);
		pilote1false.setNationalite("Finlandaise");
		pilote1false.setCiv(Civilite.M);
		pilote1false.setExperience(60);
		pilote1false.setEtat(false);
		pilote1false.setPrix(60000);
		
		pilote1false = piloteRepo.save(pilote1false);
		
		Pilote pilote2false =new Pilote();
		pilote2false.setNom("LITTLE");
		pilote2false.setPrenom("Jane");
		pilote2false.setAge(20);
		pilote2false.setNationalite("Anglaise");
		pilote2false.setCiv(Civilite.MME);
		pilote2false.setExperience(63);
		pilote2false.setEtat(false);
		pilote2false.setPrix(65000);
		
		pilote2false = piloteRepo.save(pilote2false);
		
		Pilote pilote3false =new Pilote();
		pilote3false.setNom("LINCOLN");
		pilote3false.setPrenom("Jenny");
		pilote3false.setAge(20);
		pilote3false.setNationalite("Américaine");
		pilote3false.setCiv(Civilite.MME);
		pilote3false.setExperience(60);
		pilote3false.setEtat(false);
		pilote3false.setPrix(65000);
		
		pilote3false = piloteRepo.save(pilote3false);
		
		Pilote pilote4false =new Pilote();
		pilote4false.setNom("LEO");
		pilote4false.setPrenom("Messi");
		pilote4false.setAge(22);
		pilote4false.setNationalite("Mexicaine");
		pilote4false.setCiv(Civilite.M);
		pilote4false.setExperience(70);
		pilote4false.setEtat(false);
		pilote4false.setPrix(80000);
		
		pilote4false = piloteRepo.save(pilote4false);
		
		//Pilotes 1 et 2 etat possédés
		
		Pilote pilote3true =new Pilote();
		pilote3true.setNom("Pilote3");
		pilote3true.setPrenom("Pilote3");
		pilote3true.setAge(25);
		pilote3true.setNationalite("Espagnole");
		pilote3true.setCiv(Civilite.M);
		pilote3true.setExperience(100);
		pilote3true.setEtat(true);
		pilote3true.setPrix(3000);
		
		pilote3true = piloteRepo.save(pilote3true);
		
		Pilote pilote4true =new Pilote();
		pilote4true.setNom("Pilote4");
		pilote4true.setPrenom("Pilote4");
		pilote4true.setAge(25);
		pilote4true.setNationalite("Suedoise");
		pilote4true.setCiv(Civilite.MME);
		pilote4true.setExperience(200);
		pilote4true.setEtat(true);
		pilote4true.setPrix(4000);
		
		pilote4true = piloteRepo.save(pilote4true);
		

		Pilote piloteX =new Pilote();
		piloteX.setNom("X");
		piloteX.setPrenom("X");
		piloteX.setAge(0);
		piloteX.setNationalite("X");
		piloteX.setCiv(Civilite.M);
		piloteX.setExperience(500);
		piloteX.setEtat(false);
		piloteX.setPrix(2000000);
		
		piloteX = piloteRepo.save(piloteX);
		
		List <Pilote> listPilote = new ArrayList();
		listPilote.add(pilote1false);
		listPilote.add(pilote2false);
		listPilote.add(pilote3false);
		listPilote.add(pilote4false);
		listPilote.add(pilote3true);
		listPilote.add(pilote4true);
		listPilote.add(piloteX);
		
		//PILOTES DES ECURIES
		
		Pilote pilote1 =new Pilote();
		pilote1.setNom("SUSHI");
		pilote1.setPrenom("Manga");
		pilote1.setAge(21);
		pilote1.setNationalite("Japonaise");
		pilote1.setCiv(Civilite.M);
		pilote1.setExperience(60);
		pilote1.setEtat(false);
		pilote1.setPrix(100000);
		
		Pilote pilote2 =new Pilote();
		pilote2.setNom("KONI");
		pilote2.setPrenom("Chiwa");
		pilote2.setAge(21);
		pilote2.setNationalite("Chinoise");
		pilote2.setCiv(Civilite.M);
		pilote2.setExperience(65);
		pilote2.setEtat(false);
		pilote2.setPrix(100000);
		
		Pilote pilote3 =new Pilote();
		pilote3.setNom("O'NEILL");
		pilote3.setPrenom("Bryan");
		pilote3.setAge(43);
		pilote3.setNationalite("Néerlandaise");
		pilote3.setCiv(Civilite.M);
		pilote3.setExperience(95);
		pilote3.setEtat(false);
		pilote3.setPrix(150000);
		
		Pilote pilote4 =new Pilote();
		pilote4.setNom("DONUT");
		pilote4.setPrenom("Lindsey");
		pilote4.setAge(40);
		pilote4.setNationalite("Américiaine");
		pilote4.setCiv(Civilite.MME);
		pilote4.setExperience(90);
		pilote4.setEtat(false);
		pilote4.setPrix(150000);
		
		Pilote pilote5 =new Pilote();
		pilote5.setNom("DUPONT");
		pilote5.setPrenom("François");
		pilote5.setAge(35);
		pilote5.setNationalite("Française");
		pilote5.setCiv(Civilite.M);
		pilote5.setExperience(150);
		pilote5.setEtat(false);
		pilote5.setPrix(200000);
		
		Pilote pilote6 =new Pilote();
		pilote6.setNom("ELIZABETH");
		pilote6.setPrenom("Marie");
		pilote6.setAge(25);
		pilote6.setNationalite("Anglaise");
		pilote6.setCiv(Civilite.MME);
		pilote6.setExperience(95);
		pilote6.setEtat(false);
		pilote6.setPrix(170000);
		
		Pilote pilote7 =new Pilote();
		pilote7.setNom("CHAN");
		pilote7.setPrenom("Jackie");
		pilote7.setAge(22);
		pilote7.setNationalite("Coréenne");
		pilote7.setCiv(Civilite.M);
		pilote7.setExperience(80);
		pilote7.setEtat(false);
		pilote7.setPrix(120000);
		
		Pilote pilote8 =new Pilote();
		pilote8.setNom("LEE");
		pilote8.setPrenom("Bruce");
		pilote8.setAge(21);
		pilote8.setNationalite("Coréenne");
		pilote8.setCiv(Civilite.M);
		pilote8.setExperience(85);
		pilote8.setEtat(false);
		pilote8.setPrix(140000);
		
		Pilote pilote9 =new Pilote();
		pilote9.setNom("PEREZ");
		pilote9.setPrenom("Antonio");
		pilote9.setAge(21);
		pilote9.setNationalite("Mexicaine");
		pilote9.setCiv(Civilite.M);
		pilote9.setExperience(60);
		pilote9.setEtat(false);
		pilote9.setPrix(95000);
		
		Pilote pilote10 =new Pilote();
		pilote10.setNom("PEDRO");
		pilote10.setPrenom("Juliano");
		pilote10.setAge(21);
		pilote10.setNationalite("Mexicaine");
		pilote10.setCiv(Civilite.M);
		pilote10.setExperience(65);
		pilote10.setEtat(false);
		pilote10.setPrix(100000);
		
		Pilote pilote11 =new Pilote();
		pilote11.setNom("GIANLUIGI");
		pilote11.setPrenom("Mario");
		pilote11.setAge(35);
		pilote11.setNationalite("Italienne");
		pilote11.setCiv(Civilite.M);
		pilote11.setExperience(200);
		pilote11.setEtat(false);
		pilote11.setPrix(300000);
		
		Pilote pilote12 =new Pilote();
		pilote12.setNom("MERKEL");
		pilote12.setPrenom("Angela");
		pilote12.setAge(39);
		pilote12.setNationalite("Allemande");
		pilote12.setCiv(Civilite.MME);
		pilote12.setExperience(205);
		pilote12.setEtat(false);
		pilote12.setPrix(310000);
		
		Pilote pilote13 =new Pilote();
		pilote13.setNom("BERN");
		pilote13.setPrenom("Jules");
		pilote13.setAge(34);
		pilote13.setNationalite("Suisse");
		pilote13.setCiv(Civilite.M);
		pilote13.setExperience(220);
		pilote13.setEtat(false);
		pilote13.setPrix(400000);
		
		Pilote pilote14 =new Pilote();
		pilote14.setNom("SCHUMACHER");
		pilote14.setPrenom("Gunter");
		pilote14.setAge(36);
		pilote14.setNationalite("Allemande");
		pilote14.setCiv(Civilite.M);
		pilote14.setExperience(240);
		pilote14.setEtat(false);
		pilote14.setPrix(430000);
		
		Pilote pilote15 =new Pilote();
		pilote15.setNom("FERRARI");
		pilote15.setPrenom("Tony");
		pilote15.setAge(26);
		pilote15.setNationalite("Italienne");
		pilote15.setCiv(Civilite.M);
		pilote15.setExperience(120);
		pilote15.setEtat(false);
		pilote15.setPrix(140000);
		
		Pilote pilote16 =new Pilote();
		pilote16.setNom("DINO");
		pilote16.setPrenom("Maria");
		pilote16.setAge(30);
		pilote16.setNationalite("Italienne");
		pilote16.setCiv(Civilite.MME);
		pilote16.setExperience(120);
		pilote16.setEtat(false);
		pilote16.setPrix(130000);
		
		Pilote pilote17 =new Pilote();
		pilote17.setNom("JOHNSON");
		pilote17.setPrenom("Clark");
		pilote17.setAge(27);
		pilote17.setNationalite("Anglaise");
		pilote17.setCiv(Civilite.M);
		pilote17.setExperience(150);
		pilote17.setEtat(false);
		pilote17.setPrix(180000);
		
		Pilote pilote18 =new Pilote();
		pilote18.setNom("HUNTER");
		pilote18.setPrenom("James");
		pilote18.setAge(23);
		pilote18.setNationalite("Anglaise");
		pilote18.setCiv(Civilite.M);
		pilote18.setExperience(124);
		pilote18.setEtat(false);
		pilote18.setPrix(170000);

		Pilote pilote19 =new Pilote();
		pilote19.setNom("CARLOS");
		pilote19.setPrenom("Maya");
		pilote19.setAge(24);
		pilote19.setNationalite("Mexicaine");
		pilote19.setCiv(Civilite.MME);
		pilote19.setExperience(117);
		pilote19.setEtat(false);
		pilote19.setPrix(170000);
		
		Pilote pilote20 =new Pilote();
		pilote20.setNom("SPEED");
		pilote20.setPrenom("Johny");
		pilote20.setAge(25);
		pilote20.setNationalite("Anglaise");
		pilote20.setCiv(Civilite.M);
		pilote20.setExperience(128);
		pilote20.setEtat(false);
		pilote20.setPrix(180000);
		
		pilote1 = piloteRepo.save(pilote1);
		pilote2 = piloteRepo.save(pilote2);
		pilote3 = piloteRepo.save(pilote3);
		pilote4 = piloteRepo.save(pilote4);
		pilote5 = piloteRepo.save(pilote5);
		pilote6 = piloteRepo.save(pilote6);
		pilote7 = piloteRepo.save(pilote7);
		pilote8 = piloteRepo.save(pilote8);
		pilote9 = piloteRepo.save(pilote9);
		pilote10 = piloteRepo.save(pilote10);
		pilote11 = piloteRepo.save(pilote11);
		pilote12 = piloteRepo.save(pilote12);
		pilote13 = piloteRepo.save(pilote13);
		pilote14 = piloteRepo.save(pilote14);
		pilote15 = piloteRepo.save(pilote15);
		pilote16 = piloteRepo.save(pilote16);
		pilote17 = piloteRepo.save(pilote17);
		pilote18 = piloteRepo.save(pilote18);
		pilote19 = piloteRepo.save(pilote19);
		pilote20 = piloteRepo.save(pilote20);
		
		//VOITURES DES ECURIES
		
		Voiture voiture1 = new Voiture();
		voiture1.setMarque("BMW");
		voiture1.setManiabilite(6);
		voiture1.setPoids(1700);
		voiture1.setVitesse(50);
		voiture1.setPrix(300000);
		voiture1.setEtat(false);

		Voiture voiture2 = new Voiture();
		voiture2.setMarque("MERCEDES");
		voiture2.setManiabilite(8);
		voiture2.setPoids(1500);
		voiture2.setVitesse(55);
		voiture2.setPrix(400000);
		voiture2.setEtat(false);
		
		Voiture voiture3 = new Voiture();
		voiture3.setMarque("FERRARI");
		voiture3.setManiabilite(8);
		voiture3.setPoids(1500);
		voiture3.setVitesse(55);
		voiture3.setPrix(420000);
		voiture3.setEtat(false);
		
		Voiture voiture4= new Voiture();
		voiture4.setMarque("RENAULT");
		voiture4.setManiabilite(8);
		voiture4.setPoids(1520);
		voiture4.setVitesse(47);
		voiture4.setPrix(380000);
		voiture4.setEtat(false);
		
		Voiture voiture5= new Voiture();
		voiture4.setMarque("RENAULT");
		voiture5.setManiabilite(9);
		voiture5.setPoids(1520);
		voiture5.setVitesse(53);
		voiture5.setPrix(400000);
		voiture5.setEtat(false);
	
		Voiture voiture6= new Voiture();
		voiture6.setMarque("FERRARI");
		voiture6.setManiabilite(12);
		voiture6.setPoids(1300);
		voiture6.setVitesse(60);
		voiture6.setPrix(500000);
		voiture6.setEtat(false);
		
		Voiture voiture7= new Voiture();
		voiture7.setMarque("MERCEDES");
		voiture7.setManiabilite(12);
		voiture7.setPoids(1350);
		voiture7.setVitesse(60);
		voiture7.setPrix(500000);
		voiture7.setEtat(false);
		
		Voiture voiture8= new Voiture();
		voiture8.setMarque("HONDA");
		voiture8.setManiabilite(14);
		voiture8.setPoids(1350);
		voiture8.setVitesse(64);
		voiture8.setPrix(620000);
		voiture8.setEtat(false);
			
		voiture1 = voitureRepo.save(voiture1);
		voiture2 = voitureRepo.save(voiture2);
		voiture3 = voitureRepo.save(voiture3);
		voiture4 = voitureRepo.save(voiture4);
		voiture5 = voitureRepo.save(voiture5);
		voiture6 = voitureRepo.save(voiture6);
		voiture7 = voitureRepo.save(voiture7);
		voiture8 = voitureRepo.save(voiture8);
		
		//Infrastructures
		
		Infrastructure infraPilote1 = new Infrastructure();
		infraPilote1.setExperience(15);
		infraPilote1.setNom("infraPilote1");
		infraPilote1.setNbIngenieurs(5);
		infraPilote1.setPrix(100000);
		infraPilote1.setEtat(false);
		infraPilote1.setType(typeInfra.P);
		
		Infrastructure infraVoiture1 = new Infrastructure();
		infraVoiture1.setExperience(15);
		infraVoiture1.setNom("infraVoiture1");
		infraVoiture1.setNbIngenieurs(5);
		infraVoiture1.setPitStop(15);
		infraVoiture1.setPrix(120000);
		infraVoiture1.setEtat(false);
		infraVoiture1.setType(typeInfra.V);
		
		Infrastructure infraMarketing1 = new Infrastructure();
		infraMarketing1.setExperience(15);
		infraMarketing1.setNom("infraMarketing1");
		infraMarketing1.setNbIngenieurs(2);
		infraMarketing1.setPrix(100000);
		infraMarketing1.setEtat(false);
		infraMarketing1.setType(typeInfra.M);
		
		infraPilote1 = infrastructureRepo.save(infraPilote1);
		infraVoiture1 = infrastructureRepo.save(infraVoiture1);
		infraMarketing1 = infrastructureRepo.save(infraMarketing1);
		
		//ECURIES
		
		Ecurie ecurieJoueur1 = new Ecurie();
		ecurieJoueur1.setNom("EcurieJoueur1");
		ecurieJoueur1.setArgent(50000);
		ecurieJoueur1.setExperience(500);
		
		ecurieJoueur1 = ecurieRepo.save(ecurieJoueur1);
		
		Ecurie ecurieJoueur2 = new Ecurie();
		ecurieJoueur2.setNom("Ecurie2");
		ecurieJoueur2.setArgent(40000);
		ecurieJoueur2.setExperience(400);
		
		ecurieJoueur2 = ecurieRepo.save(ecurieJoueur2);
		
		Ecurie ecurieJoueur3 = new Ecurie();
		ecurieJoueur3.setNom("Ecurie3");
		ecurieJoueur3.setArgent(30000);
		ecurieJoueur3.setExperience(300);
		
		ecurieJoueur3 = ecurieRepo.save(ecurieJoueur3);
		
		Ecurie ecurieJoueur4 = new Ecurie();
		ecurieJoueur4.setNom("Ecurie4");
		ecurieJoueur4.setArgent(20000);
		ecurieJoueur4.setExperience(200);
		
		ecurieJoueur4 = ecurieRepo.save(ecurieJoueur4);
		
		//Inventaires
		
		Inventaire inventaire1 = new Inventaire(0);
		Inventaire inventaire2 = new Inventaire(0);
		Inventaire inventaire3 = new Inventaire(0);
		Inventaire inventaire4 = new Inventaire(0);
		
		inventaire1.setPilotes(listPilote);
		
		
		
		inventaire1 = inventaireRepo.save(inventaire1);
		inventaire2 = inventaireRepo.save(inventaire2);
		inventaire3 = inventaireRepo.save(inventaire3);
		inventaire4 = inventaireRepo.save(inventaire4);
	
		//Course
		
		Course course1 = new Course();
		course1.setNom("course1");
		course1.setNombreTour(35);
		course1.setPopularite(45);
		course1.setTempsRef(null);
		course1.setCashPrize(150000);	
		
		course1 = courseRepo.save(course1);

		Course course2 = new Course();
		course2.setNom("course2");
		course2.setNombreTour(45);
		course2.setPopularite(45);
		course2.setTempsRef(null);
		course2.setCashPrize(180000);
		
		course2 = courseRepo.save(course2);
		
		Course course3 = new Course();
		course3.setNom("course3");
		course3.setNombreTour(50);
		course3.setPopularite(45);
		course3.setTempsRef(null);
		course3.setCashPrize(100000);
		
		course3 = courseRepo.save(course3);

		Course course4 = new Course();
		course4.setNom("course4");
		course4.setNombreTour(65);
		course4.setPopularite(25);
		course4.setTempsRef(null);
		course4.setCashPrize(250000);
		
		course4 = courseRepo.save(course4);
		
		//Joueurs
		Joueur joueur1=new Joueur();
		joueur1.setPseudo("Joueur1");
		joueur1.setAge(30);
		joueur1.setMail("joueur1@gmail.com");
		joueur1.setTelephone("0606060606");
		joueur1.setCiv(Civilite.M);
		joueur1.setEcurie(ecurieJoueur1);
		joueur1.setInventaire(inventaire1);
		
		joueur1 = joueurRepo.save(joueur1);
		compteJoueur1.setJoueur(joueur1);
		compteJoueur1 = compteRepo.save(compteJoueur1);

		Joueur joueur2=new Joueur();
		joueur2.setPseudo("Joueur2");
		joueur2.setAge(27);
		joueur2.setMail("joueur2@gmail.com");
		joueur2.setTelephone("0606060606");
		joueur2.setCiv(Civilite.MME);
		joueur2.setEcurie(ecurieJoueur2);
		joueur2.setInventaire(inventaire2);
		
		joueur2 = joueurRepo.save(joueur2);
		compteJoueur2.setJoueur(joueur2);
		compteJoueur2 = compteRepo.save(compteJoueur2);
		
		Joueur joueur3=new Joueur();
		joueur3.setPseudo("Joueur3");
		joueur3.setAge(25);
		joueur3.setMail("joueur3@gmail.com");
		joueur3.setTelephone("0606060606");
		joueur3.setCiv(Civilite.M);
		joueur3.setEcurie(ecurieJoueur3);
		joueur3.setInventaire(inventaire3);
		
		joueur3 = joueurRepo.save(joueur3);
		compteJoueur3.setJoueur(joueur3);
		compteJoueur3 = compteRepo.save(compteJoueur3);

		Joueur joueur4=new Joueur();
		joueur4.setPseudo("Joueur4");
		joueur4.setAge(28);
		joueur4.setMail("joueur4@gmail.com");
		joueur4.setTelephone("0606060606");
		joueur4.setCiv(Civilite.MME);
		joueur4.setEcurie(ecurieJoueur4);
		joueur4.setInventaire(inventaire4);
		
		joueur4 = joueurRepo.save(joueur4);
		compteJoueur4.setJoueur(joueur4);
		compteJoueur4 = compteRepo.save(compteJoueur4);
		
		pilote1false.setEcurie(ecurieJoueur1);
		pilote2false.setEcurie(ecurieJoueur2);
		pilote3true.setEcurie(ecurieJoueur3);
		pilote4true.setEcurie(ecurieJoueur4);
		
		pilote1false.setInventaire(inventaire1);
		pilote2false.setInventaire(inventaire1);
		pilote3true.setInventaire(inventaire1);
		pilote4true.setInventaire(inventaire1);
		
		pilote1false = piloteRepo.save(pilote1false);
		pilote2false = piloteRepo.save(pilote2false);
		pilote3true = piloteRepo.save(pilote3true);
		pilote4true = piloteRepo.save(pilote4true);
		

		spring.close();
	}
	
	

}
