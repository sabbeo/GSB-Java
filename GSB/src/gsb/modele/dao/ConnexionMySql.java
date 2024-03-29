package gsb.modele.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnexionMySql { // DAO = Data Access Object
	
	static Connection cnx;
	
	public ConnexionMySql(){
		cnx = null;
	}
	
	/**
	 * methode qui permet la connexion � la base de donn�es
	 * le fait que la m�thode soit static permet d'�viter d'instancier dans une classe un objet ConnexioMySql
	 * pour utiliser cette m�thode �crire : ConnexionMySql.connecterBd()
	 */
	public static void connecterBd(){
		//connexion � la base de donn�e � partir de jdbc
		String url = "jdbc:mysql://localhost:3308/gsbjava?zeroDateTimeBehavior=CONVERTTONULL&serverTimezone=UTC"; // url : chaine de connexion
		// try permet d'essayer de lancer la connexion
		try {Class.forName("com.mysql.jdbc.Driver"); 
		cnx = DriverManager.getConnection(url,"root","password"); 
		System.out.println( "la connexion � la base secolog s'est bien d�roul�e !");
	} 
	// si la connexion echoue un message d'erreur est affich�
    catch(Exception e) {  System.out.println("erreur lors de la connexion � la BDD");  } 

}

	
	/**
	 * @param laRequete requ�te SQL de type SELECT
	 * @return un curseur qui contient les lignes obtenues lors de l'ex�cution de la requ�te, null sinon
	 * pour utiliser cette m�thode �crire : ConnexionMySql.execReqSelection(uneRequete) o� uneRequ�te est de type String
	 */
	public static ResultSet execReqSelection(String laRequete){ 
		connecterBd();
		ResultSet resultatReq = null;
		try {
				Statement requete = cnx.createStatement(); 
				resultatReq =requete.executeQuery(laRequete); 
		} 
		catch(Exception e) {  System.out.println("Erreur requete : "+laRequete);  }
		return resultatReq;	
	}
	
	/**
	 * @param laRequete requ�te SQL de type INSERT, UPDATE ou DELETE
	 * @return 1 si la MAJ s'est bien d�roul�e, 0 sinon
	 * pour utiliser cette m�thode �crire : ConnexionMySql.execReqMaj(uneRequete) o� uneRequ�te est de type String
	 */
	public static int execReqMaj(String laRequete){
		connecterBd();
		int nbMaj =0;
		try {
		Statement s = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        nbMaj = s.executeUpdate(laRequete);
        s.close();}
		catch (Exception er) {
			er.printStackTrace(); 
			System.out.println("echec requ�te : "+laRequete); }
		return nbMaj;       
	}
	
	/**
	 * attention : tant que la connexion n'est pas ferm�e, 
	 * les MAJ ne sont pas effectives, on reste en mode d�connect�
	 * pour utiliser cette m�thode �crire : ConnexionMySql.fermerConnexionBd()
	 */
	public static void fermerConnexionBd(){
		try{cnx.close();}
		catch(Exception e) {  System.out.println("Erreur sur fermeture connexion");  } 
	}

}

