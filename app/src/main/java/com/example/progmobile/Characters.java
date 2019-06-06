package com.example.progmobile;

public class Characters {
    String Name;
    String ThumbnailUrl;

    public String getImgUrl() {
        switch(this.getName()){ //Pour lucas et bayonetta, les images du site ne correspondent pas, donc plutôt que d'attendre une mise à jour, je mets un autre lien
            case "Lucas":
                return "https://www.smashbros.com/wiiu-3ds/fr/images/dlc-fighter/image/character-dlc-fighter02.png"; //Le site officiel de Nintendo est plus fiable, mais il faut se servir de l'API pour l'exercice
            case "Bayonetta":
                return "https://www.smashbros.com/wiiu-3ds/fr/images/dlc-fighter/image/character-dlc-fighter06.png";
            default:
                return "http://kuroganehammer.com/images/" + ThumbnailUrl.substring(25);} //Donc ici je me sers de l'API
    }

    public String getName() {return Name;}
}
