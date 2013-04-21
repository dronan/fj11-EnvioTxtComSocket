import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		ServerSocket servidor = new ServerSocket(12345);
		
		System.out.println("porta 12345 aberta");
		
		Socket cliente = servidor.accept();
		
		System.out.println("nova conexao com o cliente " +cliente.getInetAddress().getHostAddress());
		
		Scanner entrada = new Scanner(cliente.getInputStream());
				
		while (entrada.hasNextLine()){
			System.out.println(entrada.nextLine());
		}
		
		entrada.close();
		cliente.close();
		servidor.close();
	}

}
