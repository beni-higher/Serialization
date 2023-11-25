import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {

        String jsonString = "{ \"nom\":\"Dikitele\", \"prenom\":\"beni\", \"age\":4}";
        Integer n = 8;

        Personne p = new Personne("Dikitele","beni",23);


        System.out.println(p.toString());


    }

    // Methode generique pour serialiser n'importe quel objet
    public static <T> String serializeObjet(T objet){

        // Si l'objet a serialiser est null la methode return null simplement
        if (objet == null){
            return null;
        }

        //On recupere la classe de l'objet a serialiser
        Class<?> objetClass = objet.getClass();

        if (objetClass == String.class || objetClass == Integer.class || objetClass == int.class ||
                objetClass == Double.class || objetClass == double.class ||
                objetClass == Boolean.class || objetClass == boolean.class) {

            return objet.toString();
        }else{
            // Utilisation de StringBuilder pour la creation de l'element json
            StringBuilder jsonElement = new StringBuilder("{");

            //Recuperation des champs et serialisation recursive
            for (Field champ:objetClass.getDeclaredFields()){
                //set accessible
                champ.setAccessible(true);

                try{
                    jsonElement.append("\"").append(champ.getName()).append("\"").append(serializeObjet(champ.get(objet))).append(",");
                }catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (jsonElement.charAt(jsonElement.length()-1)==','){
                jsonElement.setCharAt(jsonElement.length()-1,'}');
            }

        }


        return objet.toString();
    }


}