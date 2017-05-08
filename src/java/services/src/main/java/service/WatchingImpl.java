package service;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WatchingImpl implements WatchingService {

	ReadCsvService read;
	
	public ReadCsvService getRead() {
		return read;
	}
	@Autowired
	public void setRead(ReadCsvService read) {
		this.read = read;
	}

	@Override
	public void watching() {
		try {
			System.out.println("Vui long nhap toi thu muc can theo doi: ");
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
					if (kind == ENTRY_CREATE ) {
						read.readCsv(dir +"/"+fileName);
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
