import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio9 {
    public static void main(String[] args) {
        try {
            int id = 9;
            String url = "https://apichallenges.eviltester.com/sim/entities/" + id;

            // 1️DELETE da entidade
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("DELETE");

            int deleteResponseCode = con.getResponseCode();
            System.out.println("DELETE Código HTTP: " + deleteResponseCode);

            // Ler resposta (opcional)
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder deleteResponse = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                deleteResponse.append(inputLine);
            }
            in.close();

            System.out.println("Resposta do DELETE:");
            System.out.println(deleteResponse.toString());

            // 2️GET para verificar se a entidade foi deletada
            System.out.println("\nVerificando com GET...");
            URL getUrl = new URL(url);
            HttpURLConnection getCon = (HttpURLConnection) getUrl.openConnection();
            getCon.setRequestMethod("GET");

            int getResponseCode = getCon.getResponseCode();
            System.out.println("GET Código HTTP: " + getResponseCode);

            if (getResponseCode == 404) {
                System.out.println("Entidade com ID " + id + " não encontrada (deletada com sucesso).");
            } else {
                BufferedReader getIn = new BufferedReader(new InputStreamReader(getCon.getInputStream()));
                StringBuilder getResponse = new StringBuilder();
                while ((inputLine = getIn.readLine()) != null) {
                    getResponse.append(inputLine);
                }
                getIn.close();
                System.out.println("Resposta do GET:");
                System.out.println(getResponse.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
