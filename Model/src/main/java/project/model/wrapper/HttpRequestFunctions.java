package project.model.wrapper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abs
 */
public class HttpRequestFunctions {

    public static void httpRequest1(String link, String query, String outFile) throws IOException {
        URL url;
        try {
            if (!query.isEmpty()) {
                url = new URL(link + URLEncoder.encode(query, "UTF-8").replace("+", "_")); //alterar replace se necessário
            } else {
                url = new URL(link);
            }

            URLConnection connection = url.openConnection();

            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.79 Safari/537.36");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String linha;

            while ((linha = in.readLine()) != null) {
                sb.append(linha)
                  .append(System.getProperty("line.separator"));
            }
            //Escrever num ficheiro
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
            out.write(sb.toString());

            out.close();
            in.close();

        } catch (MalformedURLException ex) {
            System.out.println("Erro no URL / ligação");
            Logger.getLogger(HttpRequestFunctions.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            System.out.println("Erro na escrita do ficheiro");
            Logger.getLogger(HttpRequestFunctions.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static void httpRequest2(String link, String query, String outFile) throws IOException {
        URL url;
        try {
            if (!query.isEmpty()) {
                url = new URL(link + URLEncoder.encode(query, "iso-8859-1").replace("+", "_")); //alterar replace se necessário
            } else {
                url = new URL(link);
            }

            URLConnection connection = url.openConnection();

            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.79 Safari/537.36");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "iso-8859-1"));
            StringBuilder sb = new StringBuilder();
            String linha;

            while ((linha = in.readLine()) != null) {
                sb.append(linha)
                        .append(System.getProperty("line.separator"));
            }
            //Escrever num ficheiro
            // BufferedWriter out = new BufferedWriter(new FileWriter(outFile));
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(outFile), "iso-8859-1");
            out.write(sb.toString());

            out.close();
            in.close();

        } catch (MalformedURLException ex) {
            System.out.println("Erro no URL / ligação");
            Logger.getLogger(HttpRequestFunctions.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            System.out.println("Erro na escrita do ficheiro");
            Logger.getLogger(HttpRequestFunctions.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}
