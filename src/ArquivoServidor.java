import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ArquivoServidor {
	public static void main(String[] args) throws IOException {
		ServerSocket servidor = new ServerSocket(12321);
		System.out.println("porta aberta");
		Socket cliente = servidor.accept();
		System.out.println("conexao estabelecida com o cliente "
				+ cliente.getInetAddress().getHostAddress());

		// recebe o conteudo enviado pelo cliente
		Scanner entrada = new Scanner(cliente.getInputStream());

		// inicia a criação do txt para guardar o arquivo

		OutputStream osR = new FileOutputStream("retorno.txt");
		OutputStreamWriter oswR = new OutputStreamWriter(osR);
		BufferedWriter bwR = new BufferedWriter(oswR);
		String resposta = "";

		while (entrada.hasNextLine()) {
			resposta += entrada.nextLine()+"\n";
		}
		
		// String teste = "eee";
		bwR.write(resposta);

		bwR.close();
		oswR.close();
		osR.close();
		
		System.out.println("Arquivo gerado pelo servidor");
		
		entrada.close();
		cliente.close();
		servidor.close();

	}
}
