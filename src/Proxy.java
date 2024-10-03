import java.util.Random;

public class Proxy implements Standard{
    private StandardImpl1 standardImpl1;
    @Override
    public void process() {
        boolean b = new Random().nextBoolean();
        if (b){
            System.out.println("avant traitement"); // peut etre gerer des aspects techniques comme : cache , transaction , securité
            standardImpl1 = new StandardImpl1(); // pour eviter la lourdissement d'objet
            standardImpl1.process();
            System.out.println("apres traitement"); // enregistrer le cache
        }else {
            throw new RuntimeException("forbidden 403");
        }
    }
}
