package sopra.formation.model;

import com.fasterxml.jackson.annotation.JsonView;

public class Views {

	public static class ViewCommon {
	}
	
	public static class ViewCompte extends ViewCommon{
	}
	
	public static class ViewCourse extends ViewCommon{
	}
	
	public static class ViewEcurie extends ViewCommon{
	}
	
	public static class ViewEcurieDetail extends ViewEcurie{
	}
	
	public static class ViewEcurieVoiture extends ViewEcurie{
	}
	
	public static class ViewEcuriePilote extends ViewEcurie{
	}
	
	public static class ViewEcurieInfra extends ViewEcurie{
	}
	
	public static class ViewEcurieCourses extends ViewEcurie{
	}
	
	public static class ViewInfrastructure extends ViewCommon{
	}
	
	public static class ViewInfrastructureDetail extends ViewInfrastructure{
	}
	
	public static class ViewInventaire extends ViewCommon{
	}
	
	public static class ViewInventaireDetail extends ViewInventaire{
	}
	
	public static class ViewJoueur extends ViewCommon{
	}
	
	public static class ViewJoueurDetail extends ViewJoueur{
	}
	
	public static class ViewPilote extends ViewCommon{
	}
	
	public static class ViewPiloteDetail extends ViewPilote{
	}
	
	public static class ViewPosition extends ViewCommon{
	}
	
	public static class ViewVoiture extends ViewCommon{
	}
	public static class ViewVoitureDetail extends ViewVoiture{
	}
	
	public static class ViewCompteWithRoles extends ViewCompte{
		
	}


}
