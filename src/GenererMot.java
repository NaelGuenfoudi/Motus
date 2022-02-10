import java.util.Objects;
import java.util.Random;

/**
 * Classe qui choisit au hasard un mots d'après un fichier
 */
public class GenererMot {


    static LectureFichier fich = new LectureFichier("dico/ListeMotFacile.txt");
    /**
     * liste des mots d'un fichier Dico
     */
    public static String[] listeMots = fich.lireFichier();
    /**
     * mot généré au hasard
     */
    private String motGenere;

    public static void main(String[] args) {
        GenererMot gM = new GenererMot();
        String[] tab = gM.choisirMots(5);
        gM.choisirMot(tab);
        System.out.println(gM.getMotGenere());
    }

    /**
     * cree un tableau de mots de longueur choisi
     *
     * @param niv niveau du mots(longueur)
     * @return tableau de mots
     */
    private String[] choisirMots(int niv) {
        String[] tabNivMot = new String[0];
        for (String mot :
                listeMots) {
            if (mot.length() == niv) {
                String[] tabNouv2 = new String[tabNivMot.length + 1];//1

                for (int i = 0; i < tabNivMot.length; i++) {
                    tabNouv2[i] = tabNivMot[i];
                }
                tabNouv2[tabNivMot.length] = mot;
                tabNivMot = tabNouv2;
            }

        }
        return tabNivMot;
    }

    /**
     * definit motGenere par un mot au hasard d'un tableau de mots et enleve ce même mots de la liste des mots du dico
     *
     * @param tabMot
     */
    public void choisirMot(String[] tabMot) {
        Random r = new Random();
        int rand = r.nextInt(tabMot.length);
        motGenere = tabMot[rand];
        enleverMot();
    }

    /**
     * enleve un mot d'un tableau
     */
    private void enleverMot() {
        String[] listeMot2 = new String[listeMots.length - 1];
        boolean trouve = false;
        for (int i = 0; i < listeMot2.length; i++) {
            if (Objects.equals(listeMots[i], motGenere)) {
                i++;
                trouve = true;
            }
            if (!trouve) {
                listeMot2[i] = listeMots[i];
            } else
                listeMot2[i - 1] = listeMots[i];
        }
        listeMots = listeMot2;
    }

    public String getMotGenere() {
        return motGenere;
    }

    public void setMotGenere(String motGenere) {
        this.motGenere = motGenere;
    }

}

