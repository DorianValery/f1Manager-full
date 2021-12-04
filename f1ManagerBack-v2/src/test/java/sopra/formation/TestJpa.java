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
import sopra.formation.model.Position;
import sopra.formation.model.Type;
import sopra.formation.model.Voiture;
import sopra.formation.model.typeInfra;
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
		pilote1false.setPosition(1);
		
		
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
		pilote3false.setEtat(true);
		pilote3false.setPrix(65000);
		
		pilote3false = piloteRepo.save(pilote3false);
		
		Pilote pilote4false =new Pilote();
		pilote4false.setNom("LEO");
		pilote4false.setPrenom("Messi");
		pilote4false.setAge(22);
		pilote4false.setNationalite("Mexicaine");
		pilote4false.setCiv(Civilite.M);
		pilote4false.setExperience(70);
		pilote4false.setEtat(true);
		pilote4false.setPrix(80000);
		
		pilote4false = piloteRepo.save(pilote4false);
		
		//Pilotes 1 et 2 etat possédés

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
		listPilote.add(piloteX);
		
		//PILOTES DES ECURIES
		Inventaire inventaire1 = new Inventaire(50);
		
		Pilote pilote1 =new Pilote();
		pilote1.setNom("SUSHI");
		pilote1.setPrenom("Manga");
		pilote1.setAge(21);
		pilote1.setNationalite("Japonaise");
		pilote1.setCiv(Civilite.M);
		pilote1.setExperience(60);
		pilote1.setEtat(false);
		pilote1.setPrix(100000);
		pilote1.setImagePilote("./../assets/pilote 1.png");
		
		Pilote pilote2 =new Pilote();
		pilote2.setNom("KONI");
		pilote2.setPrenom("Chiwa");
		pilote2.setAge(21);
		pilote2.setNationalite("Chinoise");
		pilote2.setCiv(Civilite.M);
		pilote2.setExperience(65);
		pilote2.setEtat(false);
		pilote2.setPrix(100000);
		pilote2.setImagePilote("./../assets/pilote 2.png");
		
		Pilote pilote3 =new Pilote();
		pilote3.setNom("O'NEILL");
		pilote3.setPrenom("Bryan");
		pilote3.setAge(43);
		pilote3.setNationalite("Néerlandaise");
		pilote3.setCiv(Civilite.M);
		pilote3.setExperience(95);
		pilote3.setEtat(false);
		pilote3.setPrix(150000);
		pilote3.setImagePilote("./../assets/pilote 3.png");
		
		Pilote pilote4 =new Pilote();
		pilote4.setNom("DONUT");
		pilote4.setPrenom("Lindsey");
		pilote4.setAge(40);
		pilote4.setNationalite("Américiaine");
		pilote4.setCiv(Civilite.MME);
		pilote4.setExperience(90);
		pilote4.setEtat(false);
		pilote4.setPrix(150000);
		pilote4.setImagePilote("./../assets/pilote 4.png");
		
		Pilote pilote5 =new Pilote();
		pilote5.setNom("DUPONT");
		pilote5.setPrenom("François");
		pilote5.setAge(35);
		pilote5.setNationalite("Française");
		pilote5.setCiv(Civilite.M);
		pilote5.setExperience(150);
		pilote5.setEtat(false);
		pilote5.setPrix(200000);
		pilote5.setImagePilote("./../assets/pilote 4.png");
		
		Pilote pilote6 =new Pilote();
		pilote6.setNom("ELIZABETH");
		pilote6.setPrenom("Marie");
		pilote6.setAge(25);
		pilote6.setNationalite("Anglaise");
		pilote6.setCiv(Civilite.MME);
		pilote6.setExperience(95);
		pilote6.setEtat(false);
		pilote6.setPrix(170000);
		pilote6.setImagePilote("./../assets/pilote 5.png");
		
		Pilote pilote7 =new Pilote();
		pilote7.setNom("CHAN");
		pilote7.setPrenom("Jackie");
		pilote7.setAge(22);
		pilote7.setNationalite("Coréenne");
		pilote7.setCiv(Civilite.M);
		pilote7.setExperience(80);
		pilote7.setEtat(false);
		pilote7.setPrix(120000);
		pilote7.setImagePilote("./../assets/pilote 6.png");
		
		Pilote pilote8 =new Pilote();
		pilote8.setNom("LEE");
		pilote8.setPrenom("Bruce");
		pilote8.setAge(21);
		pilote8.setNationalite("Coréenne");
		pilote8.setCiv(Civilite.M);
		pilote8.setExperience(85);
		pilote8.setEtat(false);
		pilote8.setPrix(140000);
		pilote8.setImagePilote("./../assets/pilote 7.png");
		
		Pilote pilote9 =new Pilote();
		pilote9.setNom("PEREZ");
		pilote9.setPrenom("Antonio");
		pilote9.setAge(21);
		pilote9.setNationalite("Mexicaine");
		pilote9.setCiv(Civilite.M);
		pilote9.setExperience(60);
		pilote9.setEtat(false);
		pilote9.setPrix(95000);
		pilote9.setImagePilote("./../assets/pilote 8.png");
		
		Pilote pilote10 =new Pilote();
		pilote10.setNom("PEDRO");
		pilote10.setPrenom("Juliano");
		pilote10.setAge(21);
		pilote10.setNationalite("Mexicaine");
		pilote10.setCiv(Civilite.M);
		pilote10.setExperience(65);
		pilote10.setEtat(false);
		pilote10.setPrix(100000);
		pilote10.setImagePilote("./../assets/pilote 9.png");
		
		Pilote pilote11 =new Pilote();
		pilote11.setNom("GIANLUIGI");
		pilote11.setPrenom("Mario");
		pilote11.setAge(35);
		pilote11.setNationalite("Italienne");
		pilote11.setCiv(Civilite.M);
		pilote11.setExperience(200);
		pilote11.setEtat(false);
		pilote11.setPrix(300000);
		pilote11.setImagePilote("./../assets/pilote 10.png");
		
		Pilote pilote12 =new Pilote();
		pilote12.setNom("MERKEL");
		pilote12.setPrenom("Angela");
		pilote12.setAge(39);
		pilote12.setNationalite("Allemande");
		pilote12.setCiv(Civilite.MME);
		pilote12.setExperience(205);
		pilote12.setEtat(false);
		pilote12.setPrix(310000);
		pilote12.setImagePilote("");
		
		Pilote pilote13 =new Pilote();
		pilote13.setNom("BERN");
		pilote13.setPrenom("Jules");
		pilote13.setAge(34);
		pilote13.setNationalite("Suisse");
		pilote13.setCiv(Civilite.M);
		pilote13.setExperience(220);
		pilote13.setEtat(false);
		pilote13.setPrix(400000);
		pilote13.setImagePilote("");
		
		Pilote pilote14 =new Pilote();
		pilote14.setNom("SCHUMACHER");
		pilote14.setPrenom("Gunter");
		pilote14.setAge(36);
		pilote14.setNationalite("Allemande");
		pilote14.setCiv(Civilite.M);
		pilote14.setExperience(240);
		pilote14.setEtat(false);
		pilote14.setPrix(430000);
		pilote14.setImagePilote("");
		
		Pilote pilote15 =new Pilote();
		pilote15.setNom("FERRARI");
		pilote15.setPrenom("Tony");
		pilote15.setAge(26);
		pilote15.setNationalite("Italienne");
		pilote15.setCiv(Civilite.M);
		pilote15.setExperience(120);
		pilote15.setEtat(false);
		pilote15.setPrix(140000);
		pilote15.setImagePilote("");
		
		Pilote pilote16 =new Pilote();
		pilote16.setNom("DINO");
		pilote16.setPrenom("Maria");
		pilote16.setAge(30);
		pilote16.setNationalite("Italienne");
		pilote16.setCiv(Civilite.MME);
		pilote16.setExperience(120);
		pilote16.setEtat(false);
		pilote16.setPrix(130000);
		pilote16.setImagePilote("");
		
		Pilote pilote17 =new Pilote();
		pilote17.setNom("JOHNSON");
		pilote17.setPrenom("Clark");
		pilote17.setAge(27);
		pilote17.setNationalite("Anglaise");
		pilote17.setCiv(Civilite.M);
		pilote17.setExperience(150);
		pilote17.setEtat(false);
		pilote17.setPrix(180000);
		pilote17.setImagePilote("");
		
		Pilote pilote18 =new Pilote();
		pilote18.setNom("HUNTER");
		pilote18.setPrenom("James");
		pilote18.setAge(23);
		pilote18.setNationalite("Anglaise");
		pilote18.setCiv(Civilite.M);
		pilote18.setExperience(124);
		pilote18.setEtat(false);
		pilote18.setPrix(170000);
		pilote18.setImagePilote("");

		Pilote pilote19 =new Pilote();
		pilote19.setNom("CARLOS");
		pilote19.setPrenom("Maya");
		pilote19.setAge(24);
		pilote19.setNationalite("Mexicaine");
		pilote19.setCiv(Civilite.MME);
		pilote19.setExperience(117);
		pilote19.setEtat(false);
		pilote19.setPrix(170000);
		pilote19.setImagePilote("");
		
		
		Pilote pilote20 =new Pilote();
		pilote20.setNom("SPEED");
		pilote20.setPrenom("Johny");
		pilote20.setAge(25);
		pilote20.setNationalite("Anglaise");
		pilote20.setCiv(Civilite.M);
		pilote20.setExperience(128);
		pilote20.setEtat(false);
		pilote20.setPrix(180000);
		pilote20.setImagePilote("");
		
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
		
		List <Pilote> listPilote1 = new ArrayList();
		listPilote1.add(pilote1);
		listPilote1.add(pilote2);
		
		List <Pilote> listPilote2 = new ArrayList();
		listPilote1.add(pilote3);
		listPilote1.add(pilote4);
		
		List <Pilote> listPilote3 = new ArrayList();
		listPilote1.add(pilote5);
		listPilote1.add(pilote6);
		
		List <Pilote> listPilote4 = new ArrayList();
		listPilote1.add(pilote7);
		listPilote1.add(pilote8);
		
		List <Pilote> listPilote5 = new ArrayList();
		listPilote1.add(pilote9);
		listPilote1.add(pilote10);
		
		List <Pilote> listPilote6 = new ArrayList();
		listPilote1.add(pilote11);
		listPilote1.add(pilote12);
		
		List <Pilote> listPilote7 = new ArrayList();
		listPilote1.add(pilote13);
		listPilote1.add(pilote14);
		
		List <Pilote> listPilote8 = new ArrayList();
		listPilote1.add(pilote15);
		listPilote1.add(pilote16);
		
		List <Pilote> listPilote9= new ArrayList();
		listPilote1.add(pilote17);
		listPilote1.add(pilote18);
		
		List <Pilote> listPilote10 = new ArrayList();
		listPilote1.add(pilote19);
		listPilote1.add(pilote20);
		
		//VOITURES DES ECURIES
		
		Voiture voiture1 = new Voiture();
		voiture1.setMarque("ALPINE");
		voiture1.setManiabilite(6);
		voiture1.setPoids(800);
		voiture1.setVitesse(300);
		voiture1.setPrix(300000);
		voiture1.setImage("../../assets/voiture_bleue.gif");
		voiture1.setEtat(true);

		Voiture voiture2 = new Voiture();
		voiture2.setMarque("LOTUS");
		voiture2.setManiabilite(8);
		voiture2.setPoids(780);
		voiture2.setVitesse(305);
		voiture2.setPrix(400000);
		voiture2.setEtat(false);
		voiture2.setImage("../../assets/voiture_jaune.gif");
		
		Voiture voiture3 = new Voiture();
		voiture3.setMarque("FERRARI");
		voiture3.setManiabilite(8);
		voiture3.setPoids(774);
		voiture3.setVitesse(315);
		voiture3.setPrix(420000);
		voiture3.setEtat(false);
		voiture3.setImage("../../assets/voiture_rouge.gif");
		
		Voiture voiture4= new Voiture();
		voiture4.setMarque("MCLAREN");
		voiture4.setManiabilite(8);
		voiture4.setPoids(780);
		voiture4.setVitesse(320);
		voiture4.setPrix(380000);
		voiture4.setEtat(false);
		voiture4.setImage("../../assets/voiture_orange.gif");
		
		Voiture voiture5= new Voiture();
		voiture5.setMarque("ASTON MARTIN");
		voiture5.setManiabilite(9);
		voiture5.setPoids(810);
		voiture5.setVitesse(297);
		voiture5.setPrix(400000);
		voiture5.setEtat(false);
		voiture5.setImage("../../assets/voiture_verte.gif");
	
		Voiture voiture6= new Voiture();
		voiture6.setMarque("FERRARI");
		voiture6.setManiabilite(12);
		voiture6.setPoids(770);
		voiture6.setVitesse(330);
		voiture6.setPrix(500000);
		voiture6.setEtat(false);
		voiture6.setImage("../../assets/voiture_rouge.gif");
		
		Voiture voiture7= new Voiture();
		voiture7.setMarque("MERCEDES");
		voiture7.setManiabilite(12);
		voiture7.setPoids(765);
		voiture7.setVitesse(335);
		voiture7.setPrix(500000);
		voiture7.setEtat(false);
		voiture7.setImage("../../assets/voiture_rose.gif");
		
		Voiture voiture8= new Voiture();
		voiture8.setMarque("HONDA");
		voiture8.setManiabilite(14);
		voiture8.setPoids(755);
		voiture8.setVitesse(350);
		voiture8.setPrix(620000);
		voiture8.setEtat(false);
		voiture8.setImage("../../assets/voiture_bleue.gif");
			
		voiture1 = voitureRepo.save(voiture1);
		voiture2 = voitureRepo.save(voiture2);
		voiture3 = voitureRepo.save(voiture3);
		voiture4 = voitureRepo.save(voiture4);
		voiture5 = voitureRepo.save(voiture5);
		voiture6 = voitureRepo.save(voiture6);
		voiture7 = voitureRepo.save(voiture7);
		voiture8 = voitureRepo.save(voiture8);
		
		List<Voiture> listVoiture1 = new ArrayList();
		listVoiture1.add(voiture1);
		listVoiture1.add(voiture2);
		
		List<Voiture> listVoiture2 = new ArrayList();
		listVoiture2.add(voiture3);
		listVoiture2.add(voiture4);
		
		List<Voiture> listVoiture3 = new ArrayList();
		listVoiture3.add(voiture5);
		listVoiture3.add(voiture6);
		
		List<Voiture> listVoiture4 = new ArrayList();
		listVoiture4.add(voiture7);
		listVoiture4.add(voiture8);
		
		List<Voiture> listVoiture5 = new ArrayList();
		listVoiture5.add(voiture6);
		listVoiture5.add(voiture7);
		
		List<Voiture> listVoiture6 = new ArrayList();
		listVoiture6.add(voiture4);
		listVoiture6.add(voiture5);
		
		List<Voiture> listVoiture7 = new ArrayList();
		listVoiture7.add(voiture5);
		listVoiture7.add(voiture6);
		
		List<Voiture> listVoiture8 = new ArrayList();
		listVoiture8.add(voiture2);
		listVoiture8.add(voiture3);
		
		List<Voiture> listVoiture9 = new ArrayList();
		listVoiture9.add(voiture6);
		listVoiture9.add(voiture8);
		
		List<Voiture> listVoiture10 = new ArrayList();
		listVoiture10.add(voiture1);
		listVoiture10.add(voiture3);
		
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
		infraVoiture1.setPitStop(7);
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
		
		List<Infrastructure> listInfrastructure1 = new ArrayList();
		listInfrastructure1.add(infraPilote1);
		listInfrastructure1.add(infraVoiture1);
		listInfrastructure1.add(infraMarketing1);
		
		////////////////////
		
		Infrastructure infraPilote2 = new Infrastructure();
		infraPilote2.setExperience(18);
		infraPilote2.setNom("infraPilote2");
		infraPilote2.setNbIngenieurs(5);
		infraPilote2.setPrix(0);
		infraPilote2.setEtat(false);
		infraPilote2.setType(typeInfra.P);
		
		Infrastructure infraVoiture2 = new Infrastructure();
		infraVoiture2.setExperience(14);
		infraVoiture2.setNom("infraVoiture2");
		infraVoiture2.setNbIngenieurs(6);
		infraVoiture2.setPitStop(4);
		infraVoiture2.setPrix(0);
		infraVoiture2.setEtat(false);
		infraVoiture2.setType(typeInfra.V);
		
		Infrastructure infraMarketing2 = new Infrastructure();
		infraMarketing2.setExperience(15);
		infraMarketing2.setNom("infraMarketing2");
		infraMarketing2.setNbIngenieurs(2);
		infraMarketing2.setPrix(0);
		infraMarketing2.setEtat(false);
		infraMarketing2.setType(typeInfra.M);
		
		infraPilote2 = infrastructureRepo.save(infraPilote2);
		infraVoiture2 = infrastructureRepo.save(infraVoiture2);
		infraMarketing2 = infrastructureRepo.save(infraMarketing2);
		
		List<Infrastructure> listInfrastructure2 = new ArrayList();
		listInfrastructure2.add(infraPilote2);
		listInfrastructure2.add(infraVoiture2);
		listInfrastructure2.add(infraMarketing2);
		
		/////////////////////
		
		Infrastructure infraPilote3 = new Infrastructure();
		infraPilote3.setExperience(16);
		infraPilote3.setNom("infraPilote3");
		infraPilote3.setNbIngenieurs(6);
		infraPilote3.setPrix(0);
		infraPilote3.setEtat(false);
		infraPilote3.setType(typeInfra.P);
		
		Infrastructure infraVoiture3 = new Infrastructure();
		infraVoiture3.setExperience(15);
		infraVoiture3.setNom("infraVoiture3");
		infraVoiture3.setNbIngenieurs(5);
		infraVoiture3.setPitStop(5);
		infraVoiture3.setPrix(0);
		infraVoiture3.setEtat(false);
		infraVoiture3.setType(typeInfra.V);
		
		Infrastructure infraMarketing3 = new Infrastructure();
		infraMarketing3.setExperience(17);
		infraMarketing3.setNom("infraMarketing3");
		infraMarketing3.setNbIngenieurs(3);
		infraMarketing3.setPrix(0);
		infraMarketing3.setEtat(false);
		infraMarketing3.setType(typeInfra.M);
		
		infraPilote3 = infrastructureRepo.save(infraPilote3);
		infraVoiture3 = infrastructureRepo.save(infraVoiture3);
		infraMarketing3 = infrastructureRepo.save(infraMarketing3);
		
		List<Infrastructure> listInfrastructure3 = new ArrayList();
		listInfrastructure3.add(infraPilote3);
		listInfrastructure3.add(infraVoiture3);
		listInfrastructure3.add(infraMarketing3);
		
		/////////////////////
				
		Infrastructure infraPilote4 = new Infrastructure();
		infraPilote4.setExperience(18);
		infraPilote4.setNom("infraPilote4");
		infraPilote4.setNbIngenieurs(7);
		infraPilote4.setPrix(0);
		infraPilote4.setEtat(false);
		infraPilote4.setType(typeInfra.P);
		
		Infrastructure infraVoiture4 = new Infrastructure();
		infraVoiture4.setExperience(16);
		infraVoiture4.setNom("infraVoiture4");
		infraVoiture4.setNbIngenieurs(6);
		infraVoiture4.setPitStop(4);
		infraVoiture4.setPrix(0);
		infraVoiture4.setEtat(false);
		infraVoiture4.setType(typeInfra.V);
		
		Infrastructure infraMarketing4 = new Infrastructure();
		infraMarketing4.setExperience(17);
		infraMarketing4.setNom("infraMarketing4");
		infraMarketing4.setNbIngenieurs(3);
		infraMarketing4.setPrix(0);
		infraMarketing4.setEtat(false);
		infraMarketing4.setType(typeInfra.M);
		
		infraPilote4 = infrastructureRepo.save(infraPilote4);
		infraVoiture4 = infrastructureRepo.save(infraVoiture4);
		infraMarketing4 = infrastructureRepo.save(infraMarketing4);
		
		List<Infrastructure> listInfrastructure4 = new ArrayList();
		listInfrastructure4.add(infraPilote4);
		listInfrastructure4.add(infraVoiture4);
		listInfrastructure4.add(infraMarketing4);
		
		/////////////////////
				
		Infrastructure infraPilote5 = new Infrastructure();
		infraPilote5.setExperience(14);
		infraPilote5.setNom("infraPilote5");
		infraPilote5.setNbIngenieurs(5);
		infraPilote5.setPrix(0);
		infraPilote5.setEtat(false);
		infraPilote5.setType(typeInfra.P);
		
		Infrastructure infraVoiture5 = new Infrastructure();
		infraVoiture5.setExperience(14);
		infraVoiture5.setNom("infraVoiture5");
		infraVoiture5.setNbIngenieurs(5);
		infraVoiture5.setPitStop(7);
		infraVoiture5.setPrix(0);
		infraVoiture5.setEtat(false);
		infraVoiture5.setType(typeInfra.V);
		
		Infrastructure infraMarketing5 = new Infrastructure();
		infraMarketing5.setExperience(15);
		infraMarketing5.setNom("infraMarketing5");
		infraMarketing5.setNbIngenieurs(2);
		infraMarketing5.setPrix(0);
		infraMarketing5.setEtat(false);
		infraMarketing5.setType(typeInfra.M);
		
		infraPilote5 = infrastructureRepo.save(infraPilote5);
		infraVoiture5 = infrastructureRepo.save(infraVoiture5);
		infraMarketing5 = infrastructureRepo.save(infraMarketing5);
		
		List<Infrastructure> listInfrastructure5 = new ArrayList();
		listInfrastructure5.add(infraPilote5);
		listInfrastructure5.add(infraVoiture5);
		listInfrastructure5.add(infraMarketing5);
		
		/////////////////////
				
		Infrastructure infraPilote6 = new Infrastructure();
		infraPilote6.setExperience(14);
		infraPilote6.setNom("infraPilote6");
		infraPilote6.setNbIngenieurs(4);
		infraPilote6.setPrix(0);
		infraPilote6.setEtat(false);
		infraPilote6.setType(typeInfra.P);
		
		Infrastructure infraVoiture6 = new Infrastructure();
		infraVoiture6.setExperience(14);
		infraVoiture6.setNom("infraVoiture6");
		infraVoiture6.setNbIngenieurs(6);
		infraVoiture6.setPitStop(6);
		infraVoiture6.setPrix(0);
		infraVoiture6.setEtat(false);
		infraVoiture6.setType(typeInfra.V);
		
		Infrastructure infraMarketing6 = new Infrastructure();
		infraMarketing6.setExperience(16);
		infraMarketing6.setNom("infraMarketing6");
		infraMarketing6.setNbIngenieurs(2);
		infraMarketing6.setPrix(0);
		infraMarketing6.setEtat(false);
		infraMarketing6.setType(typeInfra.M);
		
		infraPilote6 = infrastructureRepo.save(infraPilote6);
		infraVoiture6 = infrastructureRepo.save(infraVoiture6);
		infraMarketing6 = infrastructureRepo.save(infraMarketing6);
		
		List<Infrastructure> listInfrastructure6 = new ArrayList();
		listInfrastructure6.add(infraPilote6);
		listInfrastructure6.add(infraVoiture6);
		listInfrastructure6.add(infraMarketing6);
		
		/////////////////////
				
		Infrastructure infraPilote7 = new Infrastructure();
		infraPilote7.setExperience(19);
		infraPilote7.setNom("infraPilote7");
		infraPilote7.setNbIngenieurs(7);
		infraPilote7.setPrix(0);
		infraPilote7.setEtat(false);
		infraPilote7.setType(typeInfra.P);
		
		Infrastructure infraVoiture7 = new Infrastructure();
		infraVoiture7.setExperience(17);
		infraVoiture7.setNom("infraVoiture7");
		infraVoiture7.setNbIngenieurs(7);
		infraVoiture7.setPitStop(3);
		infraVoiture7.setPrix(0);
		infraVoiture7.setEtat(false);
		infraVoiture7.setType(typeInfra.V);
		
		Infrastructure infraMarketing7 = new Infrastructure();
		infraMarketing7.setExperience(16);
		infraMarketing7.setNom("infraMarketing7");
		infraMarketing7.setNbIngenieurs(3);
		infraMarketing7.setPrix(0);
		infraMarketing7.setEtat(false);
		infraMarketing7.setType(typeInfra.M);
		
		infraPilote7 = infrastructureRepo.save(infraPilote7);
		infraVoiture7 = infrastructureRepo.save(infraVoiture7);
		infraMarketing7 = infrastructureRepo.save(infraMarketing7);
		
		List<Infrastructure> listInfrastructure7 = new ArrayList();
		listInfrastructure7.add(infraPilote7);
		listInfrastructure7.add(infraVoiture7);
		listInfrastructure7.add(infraMarketing7);
		
		/////////////////////
				
		Infrastructure infraPilote8 = new Infrastructure();
		infraPilote8.setExperience(14);
		infraPilote8.setNom("infraPilote8");
		infraPilote8.setNbIngenieurs(5);
		infraPilote8.setPrix(0);
		infraPilote8.setEtat(false);
		infraPilote8.setType(typeInfra.P);
		
		Infrastructure infraVoiture8 = new Infrastructure();
		infraVoiture8.setExperience(14);
		infraVoiture8.setNom("infraVoiture8");
		infraVoiture8.setNbIngenieurs(6);
		infraVoiture8.setPitStop(7);
		infraVoiture8.setPrix(0);
		infraVoiture8.setEtat(false);
		infraVoiture8.setType(typeInfra.V);
		
		Infrastructure infraMarketing8 = new Infrastructure();
		infraMarketing8.setExperience(18);
		infraMarketing8.setNom("infraMarketing8");
		infraMarketing8.setNbIngenieurs(4);
		infraMarketing8.setPrix(0);
		infraMarketing8.setEtat(false);
		infraMarketing8.setType(typeInfra.M);
		
		infraPilote8 = infrastructureRepo.save(infraPilote8);
		infraVoiture8 = infrastructureRepo.save(infraVoiture8);
		infraMarketing8 = infrastructureRepo.save(infraMarketing8);
		
		List<Infrastructure> listInfrastructure8 = new ArrayList();
		listInfrastructure8.add(infraPilote8);
		listInfrastructure8.add(infraVoiture8);
		listInfrastructure8.add(infraMarketing8);
		
		/////////////////////
				
		Infrastructure infraPilote9 = new Infrastructure();
		infraPilote9.setExperience(17);
		infraPilote9.setNom("infraPilote9");
		infraPilote9.setNbIngenieurs(5);
		infraPilote9.setPrix(0);
		infraPilote9.setEtat(false);
		infraPilote9.setType(typeInfra.P);
		
		Infrastructure infraVoiture9 = new Infrastructure();
		infraVoiture9.setExperience(16);
		infraVoiture9.setNom("infraVoiture9");
		infraVoiture9.setNbIngenieurs(6);
		infraVoiture9.setPitStop(5);
		infraVoiture9.setPrix(0);
		infraVoiture9.setEtat(false);
		infraVoiture9.setType(typeInfra.V);
		
		Infrastructure infraMarketing9 = new Infrastructure();
		infraMarketing9.setExperience(16);
		infraMarketing9.setNom("infraMarketing9");
		infraMarketing9.setNbIngenieurs(3);
		infraMarketing9.setPrix(0);
		infraMarketing9.setEtat(false);
		infraMarketing9.setType(typeInfra.M);
		
		infraPilote9 = infrastructureRepo.save(infraPilote9);
		infraVoiture9 = infrastructureRepo.save(infraVoiture9);
		infraMarketing9 = infrastructureRepo.save(infraMarketing9);
		
		List<Infrastructure> listInfrastructure9 = new ArrayList();
		listInfrastructure9.add(infraPilote9);
		listInfrastructure9.add(infraVoiture9);
		listInfrastructure9.add(infraMarketing9);
		
		/////////////////////
				
		Infrastructure infraPilote10 = new Infrastructure();
		infraPilote10.setExperience(17);
		infraPilote10.setNom("infraPilote10");
		infraPilote10.setNbIngenieurs(6);
		infraPilote10.setPrix(0);
		infraPilote10.setEtat(false);
		infraPilote10.setType(typeInfra.P);
		
		Infrastructure infraVoiture10 = new Infrastructure();
		infraVoiture10.setExperience(16);
		infraVoiture10.setNom("infraVoiture10");
		infraVoiture10.setNbIngenieurs(6);
		infraVoiture10.setPitStop(5);
		infraVoiture10.setPrix(0);
		infraVoiture10.setEtat(false);
		infraVoiture10.setType(typeInfra.V);
		
		Infrastructure infraMarketing10 = new Infrastructure();
		infraMarketing10.setExperience(16);
		infraMarketing10.setNom("infraMarketing10");
		infraMarketing10.setNbIngenieurs(3);
		infraMarketing10.setPrix(0);
		infraMarketing10.setEtat(false);
		infraMarketing10.setType(typeInfra.M);
		
		infraPilote10 = infrastructureRepo.save(infraPilote10);
		infraVoiture10 = infrastructureRepo.save(infraVoiture10);
		infraMarketing10 = infrastructureRepo.save(infraMarketing10);
		
		List<Infrastructure> listInfrastructure10 = new ArrayList();
		listInfrastructure10.add(infraPilote10);
		listInfrastructure10.add(infraVoiture10);
		listInfrastructure10.add(infraMarketing10);
		
		/////////////////
		
		listInfrastructure1 = infrastructureRepo.saveAll(listInfrastructure1);
		listInfrastructure2 = infrastructureRepo.saveAll(listInfrastructure2);
		listInfrastructure3 = infrastructureRepo.saveAll(listInfrastructure3);
		listInfrastructure4 = infrastructureRepo.saveAll(listInfrastructure4);
		listInfrastructure5 = infrastructureRepo.saveAll(listInfrastructure5);
		listInfrastructure6 = infrastructureRepo.saveAll(listInfrastructure6);
		listInfrastructure7 = infrastructureRepo.saveAll(listInfrastructure7);
		listInfrastructure8 = infrastructureRepo.saveAll(listInfrastructure8);
		listInfrastructure9 = infrastructureRepo.saveAll(listInfrastructure9);
		listInfrastructure10 = infrastructureRepo.saveAll(listInfrastructure10);
		
		//Ecuries du joueur
		
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
		
		//ECURIES IA
		
		Ecurie ecurie1 = new Ecurie();
		ecurie1.setNom("RACE SPIRIT");
		ecurie1.setArgent(1000000);
		ecurie1.setExperience(300);
		ecurie1.setInfrastructure(listInfrastructure1);
		ecurie1.setVoitures(listVoiture1);
		ecurie1.setPilotes(listPilote1);
		
		Ecurie ecurie2 = new Ecurie();
		ecurie2.setNom("LEGENDARY");
		ecurie2.setArgent(1200000);
		ecurie2.setExperience(320);
		ecurie2.setInfrastructure(listInfrastructure2);
		ecurie2.setVoitures(listVoiture2);
		ecurie2.setPilotes(listPilote2);
		
		Ecurie ecurie3 = new Ecurie();
		ecurie3.setNom("SPEED BULLET");
		ecurie3.setArgent(1200000);
		ecurie3.setExperience(322);
		ecurie3.setInfrastructure(listInfrastructure3);
		ecurie3.setVoitures(listVoiture3);
		ecurie3.setPilotes(listPilote3);
		
		Ecurie ecurie4 = new Ecurie();
		ecurie4.setNom("SPEED HUNTERS");
		ecurie4.setArgent(1300000);
		ecurie4.setExperience(325);
		ecurie4.setInfrastructure(listInfrastructure4);
		ecurie4.setVoitures(listVoiture4);
		ecurie4.setPilotes(listPilote4);
		
		Ecurie ecurie5 = new Ecurie();
		ecurie5.setNom("FORMULA SCUDERIA");
		ecurie5.setArgent(1000000);
		ecurie5.setExperience(300);
		ecurie5.setInfrastructure(listInfrastructure5);
		ecurie5.setVoitures(listVoiture5);
		ecurie5.setPilotes(listPilote5);

		Ecurie ecurie6 = new Ecurie();
		ecurie6.setNom("GP ONE");
		ecurie6.setArgent(1100000);
		ecurie6.setExperience(290);
		ecurie6.setInfrastructure(listInfrastructure6);
		ecurie6.setVoitures(listVoiture6);
		ecurie6.setPilotes(listPilote6);
		
		Ecurie ecurie7 = new Ecurie();
		ecurie7.setNom("HISTORIC CHAMPIONS");
		ecurie7.setArgent(1140000);
		ecurie7.setExperience(350);
		ecurie7.setInfrastructure(listInfrastructure7);
		ecurie7.setVoitures(listVoiture7);
		ecurie7.setPilotes(listPilote7);
		
		Ecurie ecurie8 = new Ecurie();
		ecurie8.setNom("WHEEL MASTERS");
		ecurie8.setArgent(1400000);
		ecurie8.setExperience(340);
		ecurie8.setInfrastructure(listInfrastructure8);
		ecurie8.setVoitures(listVoiture8);
		ecurie8.setPilotes(listPilote8);
		
		Ecurie ecurie9 = new Ecurie();
		ecurie9.setNom("F1 TEAM PRO");
		ecurie9.setArgent(1200000);
		ecurie9.setExperience(290);
		
		ecurie9.setVoitures(listVoiture9);
		ecurie9.setPilotes(listPilote8);
		ecurie9.setInfrastructure(listInfrastructure9);
		
		
		ecurie1= ecurieRepo.save(ecurie1);
		ecurie2= ecurieRepo.save(ecurie2);
		ecurie3= ecurieRepo.save(ecurie3);
		ecurie4= ecurieRepo.save(ecurie4);
		ecurie5= ecurieRepo.save(ecurie5);
		ecurie6= ecurieRepo.save(ecurie6);
		ecurie7= ecurieRepo.save(ecurie7);
		ecurie8= ecurieRepo.save(ecurie8);
		ecurie9= ecurieRepo.save(ecurie9);
		
		
		//Inventaires
		
		
		Inventaire inventaire2 = new Inventaire(0);
		Inventaire inventaire3 = new Inventaire(0);
		Inventaire inventaire4 = new Inventaire(0);
		
		inventaire1.setPilotes(listPilote);
		inventaire1.setInfrastructure(listInfrastructure3);
		inventaire1.setVoitures(listVoiture10);
		
		inventaire1 = inventaireRepo.save(inventaire1);
		inventaire2 = inventaireRepo.save(inventaire2);
		inventaire3 = inventaireRepo.save(inventaire3);
		inventaire4 = inventaireRepo.save(inventaire4);
	
		//Course
		
		Course course1 = new Course();
		course1.setNom("Bahrein International Circuit");
		course1.setNombreTour(56);
		course1.setPopularite(70);
		course1.setTempsRef(null);
		course1.setCashPrize(200000);
		course1.setImage("../../assets/Circuit-Bahrein-Plan.jpg");
		
		Course course2 = new Course();
		course2.setNom("Imola");
		course2.setNombreTour(63);
		course2.setPopularite(60);
		course2.setTempsRef(null);
		course2.setCashPrize(150000);

		Course course3 = new Course();
		course3.setNom("Portimao");
		course3.setNombreTour(66);
		course3.setPopularite(50);
		course3.setTempsRef(null);
		course3.setCashPrize(140000);
		
		Course course4 = new Course();
		course4.setNom("Catalunya");
		course4.setNombreTour(66);
		course4.setPopularite(65);
		course4.setTempsRef(null);
		course4.setCashPrize(180000);
		
		Course course5 = new Course();
		course5.setNom("Monaco");
		course5.setNombreTour(78);
		course5.setPopularite(90);
		course5.setTempsRef(null);
		course5.setCashPrize(250000);
		
		Course course6 = new Course();
		course6.setNom("Baku City Circuit");
		course6.setNombreTour(51);
		course6.setPopularite(55);
		course6.setTempsRef(null);
		course6.setCashPrize(150000);
		
		Course course7 = new Course();
		course7.setNom("Paul Ricard");
		course7.setNombreTour(53);
		course7.setPopularite(60);
		course7.setTempsRef(null);
		course7.setCashPrize(170000);
		
		Course course8 = new Course();
		course8.setNom("Red Bull Ring");
		course8.setNombreTour(71);
		course8.setPopularite(55);
		course8.setTempsRef(null);
		course8.setCashPrize(145000);
		
		Course course9 = new Course();
		course9.setNom("Silverstone");
		course9.setNombreTour(52);
		course9.setPopularite(65);
		course9.setTempsRef(null);
		course9.setCashPrize(175000);
		
		Course course10 = new Course();
		course10.setNom("Hungagoring");
		course10.setNombreTour(70);
		course10.setPopularite(60);
		course10.setTempsRef(null);
		course10.setCashPrize(170000);
		
		Course course11 = new Course();
		course11.setNom("Spa-Francorchamps");
		course11.setNombreTour(44);
		course11.setPopularite(80);
		course11.setTempsRef(null);
		course11.setCashPrize(220000);
		
		Course course12 = new Course();
		course12.setNom("Zandvoort");
		course12.setNombreTour(72);
		course12.setPopularite(60);
		course12.setTempsRef(null);
		course12.setCashPrize(180000);
		
		Course course13 = new Course();
		course13.setNom("Monza");
		course13.setNombreTour(53);
		course13.setPopularite(75);
		course13.setTempsRef(null);
		course13.setCashPrize(200000);
		
		Course course14 = new Course();
		course14.setNom("Sochi");
		course14.setNombreTour(53);
		course14.setPopularite(60);
		course14.setTempsRef(null);
		course14.setCashPrize(170000);
		
		Course course15 = new Course();
		course15.setNom("Istanbul");
		course15.setNombreTour(58);
		course15.setPopularite(50);
		course15.setTempsRef(null);
		course15.setCashPrize(150000);
		
		Course course16 = new Course();
		course16.setNom("Circuit of the Americas");
		course16.setNombreTour(56);
		course16.setPopularite(70);
		course16.setTempsRef(null);
		course16.setCashPrize(185000);
		
		Course course17 = new Course();
		course17.setNom("Mexico");
		course17.setNombreTour(71);
		course17.setPopularite(70);
		course17.setTempsRef(null);
		course17.setCashPrize(180000);
		
		Course course18 = new Course();
		course18.setNom("Interlagos");
		course18.setNombreTour(71);
		course18.setPopularite(70);
		course18.setTempsRef(null);
		course18.setCashPrize(180000);
		
		Course course19 = new Course();
		course19.setNom("Qatar");
		course19.setNombreTour(57);
		course19.setPopularite(65);
		course19.setTempsRef(null);
		course19.setCashPrize(175000);
		
		Course course20 = new Course();
		course20.setNom("Yas Marina Circuit");
		course20.setNombreTour(55);
		course20.setPopularite(80);
		course20.setTempsRef(null);
		course20.setCashPrize(200000);
		
		course1 = courseRepo.save(course1);
		course2 = courseRepo.save(course2);
		course3 = courseRepo.save(course3);
		course4 = courseRepo.save(course4);
		course5 = courseRepo.save(course5);
		course6 = courseRepo.save(course6);
		course7 = courseRepo.save(course7);
		course8 = courseRepo.save(course8);
		course9 = courseRepo.save(course9);
		course10 = courseRepo.save(course10);
		course11 = courseRepo.save(course11);
		course12 = courseRepo.save(course12);
		course13 = courseRepo.save(course13);
		course14 = courseRepo.save(course14);
		course15 = courseRepo.save(course15);
		course16 = courseRepo.save(course16);
		course17 = courseRepo.save(course17);
		course18 = courseRepo.save(course18);
		course19 = courseRepo.save(course19);
		course20 = courseRepo.save(course20);
		
		
		
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
		
		pilote1false.setEcurie(ecurieJoueur1);
		pilote2false.setEcurie(ecurieJoueur2);
		
		pilote1false.setInventaire(inventaire1);
		pilote2false.setInventaire(inventaire1);
		
		pilote1false = piloteRepo.save(pilote1false);
		pilote2false = piloteRepo.save(pilote2false);
		
		voiture1.setEcurie(ecurieJoueur1);
		voiture1 = voitureRepo.save(voiture1);
		
		voiture2.setEcurie(ecurieJoueur1);
		voiture2 = voitureRepo.save(voiture2);
		
		infraMarketing1.setEcurie(ecurieJoueur1);
		infraMarketing1 = infrastructureRepo.save(infraMarketing1);
		
		infraPilote1.setEcurie(ecurieJoueur1);
		infraPilote1 = infrastructureRepo.save(infraPilote1);
		
		infraVoiture1.setEcurie(ecurieJoueur1);
		infraVoiture1 = infrastructureRepo.save(infraVoiture1);
		
		inventaire1 = inventaireRepo.save(inventaire1);
	
		Position positionPilote1 = new Position();
		positionPilote1.setPosition(4);
		positionPilote1.setPilote(pilote1false);
		positionPilote1.setCourse(course1);
		
		positionPilote1 = positionRepo.save(positionPilote1);

		spring.close();
	}
	
	

}
