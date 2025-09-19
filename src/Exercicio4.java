import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio4 {
    public static void main(String[] args) {
        try {
            // Parâmetros fictícios
            String categoria = "teste";
            int limite = 5;

            // Monta a URL com os parâmetros
            String url = "https://apichallenges.eviltester.com/sim/entities?categoria=" 
                        + categoria + "&limite=" + limite;

            System.out.println("URL final: " + url);

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("Código HTTP: " + responseCode);

            // Ler e imprimir resposta (opcional)
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Resposta da API:");
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
