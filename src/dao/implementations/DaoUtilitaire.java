package dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtilitaire {
	
	/* Fermeture silencieuse du resultset */
	public static void fermetureSilencieuse( ResultSet resultSet ) {
	    if ( resultSet != null ) {
	        try {
	            resultSet.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
	        }
	    }
	}
	
	/* Fermeture silencieuse du Statement */
	public static void fermetureSilencieuse(Statement statement ) {
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
	        }
	    }
	}
	
	/* Fermeture silencieuse du PreparedStatement */
	public static void fermetureSilencieuse(PreparedStatement preStatement ) {
	    if ( preStatement != null ) {
	        try {
	            preStatement.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
	        }
	    }
	}
	
	/* Fermeture silencieuse de la connexion */
	public static void fermetureSilencieuse( Connection connexion ) {
	    if ( connexion != null ) {
	        try {
	            connexion.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
	        }
	    }
	}
	
	/* Fermetures silencieuses du resultset, du statement et de la connexion */
	public static void fermeturesSilencieuses( ResultSet resultSet, PreparedStatement preStatement, Connection connexion ) {
	    fermetureSilencieuse( resultSet );
	    fermetureSilencieuse( preStatement );
	    fermetureSilencieuse( connexion );
	}
	
	public static void fermeturesSilencieuses(ResultSet resultSet, Statement Statement, Connection connexion ) {
	    fermetureSilencieuse( resultSet );
	    fermetureSilencieuse( Statement );
	    fermetureSilencieuse( connexion );
	}

}
