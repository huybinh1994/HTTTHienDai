package baitap;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Scanner;

/**
 * This program demonstrates how to use the Watch Service API to monitor change
 * events for a specific directory.
 * @author www.codejava.net
 *
 */
public class App {

	private static void cmd (String cmd) throws InterruptedException, IOException	{
		
		    final Process p = Runtime.getRuntime().exec(cmd);

		    new Thread(new Runnable() {
		        public void run() {
		            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		            String line = null; 

		            try {
		                while ((line = input.readLine()) != null) {
		                    System.out.println(line);
		                }
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }).start();

		    p.waitFor();
		     }
	
	public static void main(String[] args) throws InterruptedException, URISyntaxException {
		try {
			System.out.println("Vui long nhap duong dan thu muc goc(1542268) de xem su thay doi cua nhanvien.txt: ");
			Scanner sc = new Scanner(System.in);
			

	
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Path dir = Paths.get( sc.nextLine());
			dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
			
			System.out.println("Watch Service registered for dir: " + dir.getFileName());
			
			while (true) {
				WatchKey key;
				try {
					key = watcher.take();
				} catch (InterruptedException ex) {
					return;
				}
				
				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					
					@SuppressWarnings("unchecked")
					WatchEvent<Path> ev = (WatchEvent<Path>) event;
					Path fileName = ev.context();
					
					System.out.println(kind.name() + ": " + fileName);
					if (kind == ENTRY_MODIFY ) {
						System.out.println("Vui long nhap duong dan den file import.dtsx trong thu muc DBImport ");

						cmd("dtexec -f "+sc.nextLine());
					}
				}
				
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
			
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}