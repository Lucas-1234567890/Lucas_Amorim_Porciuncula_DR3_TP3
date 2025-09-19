import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio11 {
    public static void main(String[] args) {
        try {
            String url = "https://apichallenges.eviltester.com/sim/entities";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("OPTIONS");

            // Enviar a requisição e capturar o código
            int responseCode = con.getResponseCode();
            System.out.println("Código HTTP: " + responseCode);

           
            String allowHeader = con.getHeaderField("Allow");
            System.out.println("Métodos permitidos (Allow): " + allowHeader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
