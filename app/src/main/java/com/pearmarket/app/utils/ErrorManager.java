package com.pearmarket.app.utils;

/**
 * Exception qui permet de gérer des erreurs personnalisées
 */
public class ErrorManager extends Exception{
    public enum ErrorTypes {
        INVALID_PARAMETER,
        NULL_OBJECT,
        UNKNOWN_ERROR,
        ERROR_404
    }

    private final ErrorTypes type;
    private String title;
    private String description;

    /**
     * Initialise la classe et renseigne les champs en fonction de l'erreur
     * @param type type de l'erreur
     */
    public ErrorManager(ErrorTypes type) {
        this.type = type;

        switch (type) {
            case INVALID_PARAMETER:
                title = "Le lien saisi n'existe pas";
                description = "Les paramètres de l'URL sont erronés.";
                break;

            case NULL_OBJECT:
                title = "L'élement recherché est introuvable";
                description = "Aucun élément ne correspond à votre recherche, il a soit été supprimé ou n'existe pas.";
                break;

            case ERROR_404:
                title = "La page que vous recherchez n'existe pas";
                description = "Aucune page correspondante n'a été trouvée, réessayez votre requête ou vérifiez l'URL.";
                break;

            default:
            case UNKNOWN_ERROR:
                title = "Une erreur inconnue s'est produite";
                description = "Veuillez réessayer dans quelques minutes.";
                break;
        }
        description += "\nSi le problème persiste veuillez contacter un administrateur!";
    }



    /** Getters & Setters **/

    public ErrorTypes getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
