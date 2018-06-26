package client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class ServiceClient {
	// Створюємо клієнта
	private static HttpClient httpClient = HttpClientBuilder.create().build();
	// Метод для веріфікації та виконання запиту з виводом результату на консоль
	public static void executeRequest(HttpRequestBase request) throws Exception {
		HttpResponse response = httpClient.execute(request);
		int code = response.getStatusLine().getStatusCode();
		if (code != 200)
			throw new Exception(response.getStatusLine().toString());
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	}
	// ***************************************************************
 //Тестування різнх видів запитів
	public static void sendToServer() {
		try {
			//Добавляємо студента з id=33
			String uri = "http://localhost:8080/MyProjectREST2/rest/restExample/students/33/stud33/3.33";
			executeRequest(new HttpPut(uri));
			//Показуємо студента з id=33
			uri = "http://localhost:8080/MyProjectREST2/rest/restExample/students/33";
			executeRequest(new HttpGet(uri));
			//Виравляємо оцінку студента з id=33
			uri = "http://localhost:8080/MyProjectREST2/rest/restExample/students/33/stud33/5.0";
			executeRequest(new HttpPost(uri));
			//Показуємо студента з id=33
			uri = "http://localhost:8080/MyProjectREST2/rest/restExample/students/33";
			executeRequest(new HttpGet(uri));
			//Видаляємо студента з id=33
			uri = "http://localhost:8080/MyProjectREST2/rest/restExample/students/33";
			executeRequest(new HttpDelete(uri));
			//Показуємо усіх студентів
			uri = "http://localhost:8080/MyProjectREST2/rest/restExample/students";
			executeRequest(new HttpGet(uri));	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
