public class TestSimpleAPI {
    public static void main(String[] args) {
        // 1️ GET todos os itens
        String allItems = HttpUtils.get("https://apichallenges.eviltester.com/simpleapi/items");
        System.out.println("Itens atuais: " + allItems);

        // 2️ Gerar ISBN aleatório
        String isbn = HttpUtils.get("https://apichallenges.eviltester.com/simpleapi/randomisbn");
        System.out.println("ISBN gerado: " + isbn);

        // 3️ POST novo item
        String jsonPost = String.format("{\"type\":\"book\",\"isbn13\":\"%s\",\"price\":5.99,\"numberinstock\":5}", isbn);
        String postResponse = HttpUtils.post("https://apichallenges.eviltester.com/simpleapi/items", jsonPost);
        System.out.println("POST response: " + postResponse);

        // 4️ PUT atualizar item
        String jsonPut = String.format("{\"type\":\"book\",\"isbn13\":\"%s\",\"price\":7.99,\"numberinstock\":10}", isbn);
        String putResponse = HttpUtils.put("https://apichallenges.eviltester.com/simpleapi/items", jsonPut);
        System.out.println("PUT response: " + putResponse);

        // 5️ DELETE item
        String deleteResponse = HttpUtils.delete("https://apichallenges.eviltester.com/simpleapi/items/" + isbn);
        System.out.println("DELETE response: " + deleteResponse);

        // 6️ OPTIONS
        String allow = HttpUtils.options("https://apichallenges.eviltester.com/simpleapi/items");
        System.out.println("Métodos permitidos: " + allow);
    }
}
