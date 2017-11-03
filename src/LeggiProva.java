import java.io.*;
import java.util.ArrayList;

public class LeggiProva {

    private ArrayList<Quesito> prova1, prova2, prova3;
    private transient BufferedReader b;

    public LeggiProva() {
        prova1 = new ArrayList<Quesito>();
        prova2 = new ArrayList<Quesito>();
        prova3 = new ArrayList<Quesito>();

    }

    public void leggiProva1() {
        String domanda;
        String risposta;
        try {
            b = new BufferedReader(new FileReader(new File("./src/Prove/prova1")));
            while ((domanda = b.readLine())!=null && domanda.length()!=0) {
                String[] opzioni = new String[3];   //???????????????
                opzioni[0] = b.readLine();
                opzioni[1] = b.readLine();
                opzioni[2] = b.readLine();
                //System.out.println(opzioni[0] + opzioni[1] + opzioni[2]);
                risposta = b.readLine();
                prova1.add(new Quesito(domanda, opzioni, risposta));
            }
            b.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aCaso() {
        for (Quesito q : prova1) {
            System.out.println(q.toStringProva1());
        }
    }

    public void leggiProva2() {
        String parola;
        try {
            b = new BufferedReader(new FileReader(new File("./src/Prove/prova2")));
            while ((parola = b.readLine())!=null && parola.length()!=0) {
                Quesito q = new Quesito(parola);
                prova2.add(q);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leggiProva3() {
        String domanda;
        String risposta;
        try {
            b = new BufferedReader(new FileReader(new File("./src/Prove/prova3")));
            while ((domanda = b.readLine())!=null && domanda.length()!=0) {
                risposta = b.readLine();
                Quesito q = new Quesito(domanda, risposta);
                prova3.add(q);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean checkRispostaProva1(int index, String risposta) {
        if (prova1.get(index).getRisposta().equalsIgnoreCase(risposta)) return true;
        return false;
    }

    public boolean checkRispostaProva3(int index, String risposta) {
        if (risposta.toLowerCase().contains(prova3.get(index).getRisposta().toLowerCase())) return true;
        return false;
    }


    public ArrayList<Quesito> getProva1() {
        return prova1;
    }

    public ArrayList<Quesito> getProva2() {
        return prova2;
    }

    public ArrayList<Quesito> getProva3() {
        return prova3;
    }
}
