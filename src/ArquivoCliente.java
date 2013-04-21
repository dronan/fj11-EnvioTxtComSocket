import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ArquivoCliente {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket cliente = new Socket("127.0.0.1",12321);
		System.out.println("cliente conectado ao servidor");
		
		// inicia o processo de criar o arquivo.txt
		
		OutputStream os = new FileOutputStream("arquivo.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		
		bw.write("primeira linha");
		bw.newLine();
		bw.write("segunda linha");
		bw.newLine();
		bw.write("terceira linha");
		bw.close();
		
		System.out.println("Arquivo gerado pelo cliente");
		
		// le o arquivo criado
		
		FileInputStream stream = new FileInputStream("arquivo.txt");
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);
		String arquivo = reader.readLine();
		String retorno = "";
		
		while(arquivo != null){
			retorno += arquivo+"\n";
			arquivo = reader.readLine();
		}
		
		// envia o conteudo da variavel para o servidor
		
		PrintStream envio = new PrintStream(cliente.getOutputStream());
		envio.println(retorno);
		
		System.out.println("arquivo enviado para o servidor");
		
		stream.close();
		streamReader.close();
		reader.close();
		
		cliente.close();
		
		
	}

}
