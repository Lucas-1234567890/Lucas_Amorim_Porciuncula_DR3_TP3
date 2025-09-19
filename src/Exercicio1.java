import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio1 {
    public static void main(String[] args) {
        try {
            // URL do endpoint
            String url = "https://apichallenges.eviltester.com/sim/entities";
            URL obj = new URL(url);

            // Abre a conexão HTTP
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Método GET
            con.setRequestMethod("GET");

            // Código de status
            int responseCode = con.getResponseCode();
            System.out.println("Código HTTP: " + responseCode);

            // Ler a resposta (body)
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprime o JSON de resposta
            System.out.println("Resposta da API:");
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
