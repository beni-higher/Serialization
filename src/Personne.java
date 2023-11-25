public class Personne {
    private String nom;
    private int age;
    private String prenome;

    public Personne(){
        this.nom = null;
        this.prenome = null;
        this.age = 0;

    }

    public Personne(String nom, String prenom, int age){
        this.nom = nom;
        this.prenome = prenom;
        this.age = age;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrenome() {
        return prenome;
    }

    public void setPrenome(String prenome) {
        this.prenome = prenome;
    }

    @Override
    public String toString() {
        return "Personne {" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", prenome='" + prenome + '\'' +
                '}';
    }
}
